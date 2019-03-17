package mother_teresa.softwaredev;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import static com.facebook.share.Sharer.Result;

public class Quiz_Share extends AppCompatActivity {
    private CallbackManager callbackManager;
    private ShareDialog shareDialog;
    public static final String EXTRA_SCORE = "extraScore";
    private Intent dataIntent;
    private int score;
    private TextView scoreText, shareText;
    private Button shareBtn, finishBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        scoreText = findViewById(R.id.score_text);
        init();

        if(score == 10){
            getSupportActionBar().setTitle("PERFECT SCORE!");
        }else if(score >= 8){
            getSupportActionBar().setTitle("SO CLOSE!");
        }else if(score >= 5){
            getSupportActionBar().setTitle("NOT TO BAD");
        }else if(score < 5){
            getSupportActionBar().setTitle("TRY AGAIN...");
        }else{
            getSupportActionBar().setTitle("Error");
        }

        //Defines the BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);

        /*Once an item on the bottomNavigationView is clicked depending
         * on the item clicked directs the user to the corresponding activity*/
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.menu_Topic:
                        Intent quiz = new Intent(Quiz_Share.this, Topics_Home.class);
                        startActivity(quiz);
                        break;

                    case R.id.menu_Quiz:
                        Toast.makeText(Quiz_Share.this, "Tap on 'Try Again'", Toast.LENGTH_SHORT).show();

                        break;
                }
                return false;
            }
        });
    }

    private void init() {

        shareBtn = findViewById(R.id.button_share);
        finishBtn = findViewById(R.id.button_finish);
        shareText = findViewById(R.id.share_text);
        dataIntent = getIntent();
        score = dataIntent.getIntExtra(EXTRA_SCORE, 0);
        scoreText.setText(score + "");
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);

        shareDialog.registerCallback(callbackManager, new FacebookCallback<Result>() {

            @Override
            public void onSuccess(Result result) {
                Toast.makeText(Quiz_Share.this, "Share success!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(Quiz_Share.this, "Share Canceled", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException error) {
                error.printStackTrace();
                ;
                Toast.makeText(Quiz_Share.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void share(View view) {

        if (ShareDialog.canShow(ShareLinkContent.class)) {
            shareBtn.setVisibility(View.GONE);
            finishBtn.setVisibility(View.GONE);
            shareText.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Sharing...please wait", Toast.LENGTH_LONG).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    SharePhoto photo = new SharePhoto.Builder()
                            .setBitmap(captureScreen()).build();
                    SharePhotoContent content = new SharePhotoContent.Builder()
                            .addPhoto(photo).build();

                    shareDialog.show(content);
                    shareBtn.setVisibility(View.VISIBLE);
                    finishBtn.setVisibility(View.VISIBLE);
                    shareText.setVisibility(View.GONE);
                }
            }, 4000);
        }
    }

    public Bitmap captureScreen() {
        getWindow().getDecorView().setDrawingCacheEnabled(true);
        return getWindow().getDecorView().getDrawingCache();
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void finishQuiz(View view) {

        /*Calling finish() in anyway, is bad practice,
        setting a class that invokes finish is preferred*/

        if (mother_teresa.softwaredev.QuizStart.getInstance() != null)
            mother_teresa.softwaredev.QuizStart.getInstance().updateHighScore(score);
        finish();
    }

    //Creates option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_About) {

            AlertDialog alertDialog = new AlertDialog.Builder(Quiz_Share.this).create();
            alertDialog.setTitle("Developers");
            alertDialog.setMessage("Pierce Miller\nBenjamin Gu\nKaihan Wang\nNick Winter\n");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();

        }
        return super.onOptionsItemSelected(item);
    }
}