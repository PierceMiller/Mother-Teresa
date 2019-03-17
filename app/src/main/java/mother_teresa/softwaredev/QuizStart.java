package mother_teresa.softwaredev;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

import mother_teresa.softwaredev.QuizActivity;
import mother_teresa.softwaredev.Quiz_Share;
import mother_teresa.softwaredev.R;

public class QuizStart extends AppCompatActivity {

    public static final String SHARE_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighScore";
    private static QuizStart instance;

    private TextView textViewHighScore;
    private int highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_quiz_start);

        textViewHighScore = findViewById(R.id.text_view_highscore);
        loadHighScore();

        final Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz();
            }
        });

        //Defines the BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);

        /*Once an item on the bottomNavigationView is clicked depending
         * on the item clicked directs the user to the corresponding activity*/
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.menu_Topic:
                        Intent quiz = new Intent(QuizStart.this, Topics_Home.class);
                        startActivity(quiz);
                        break;

                    case R.id.menu_Quiz:
                        Toast.makeText(QuizStart.this, "You're on the Quiz!", Toast.LENGTH_SHORT).show();

                        break;
                }
                return false;
            }
        });
    }

    //Creates option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about, menu);
        return true;
    }


    public void startQuiz(){

        Intent intent = new Intent(QuizStart.this, QuizActivity.class);
        startActivity(intent);
    }

    private void loadHighScore() {
        SharedPreferences prefs = getSharedPreferences(SHARE_PREFS, MODE_PRIVATE);
        highScore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighScore.setText("Highscore: " + highScore);
    }

    public void updateHighScore(int highScoreNew) {
        highScore = highScoreNew;
        textViewHighScore.setText("Highscore: " + highScore);

        SharedPreferences prefs = getSharedPreferences(SHARE_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highScore);
        editor.apply();
    }

    public static QuizStart getInstance() {
        return instance;
    }


}
