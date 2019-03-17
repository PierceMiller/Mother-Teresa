package mother_teresa.softwaredev;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class Login extends AppCompatActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener {

    private LinearLayout Prof_Section;
    private Button SignOut;
    private SignInButton SignIn;
    private TextView Name,Email;
    private GoogleApiClient googleApiClient;
    private GoogleSignInClient mGoogleSignInClient;
    private static final int REQ_CODE = 9001;

    CallbackManager callbackManager;
    LoginButton loginButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Facebook SDK setup
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        getSupportActionBar().setTitle("Welcome!");

        setContentView(R.layout.activity_login);
        Prof_Section = (LinearLayout)findViewById(R.id.prof_section);

        //Google & Facebook user detial , sign-in /sign-out button setup
        SignOut = (Button)findViewById(R.id.bn_logout);
        SignIn = (SignInButton)findViewById(R.id.bn_login);
        Name = (TextView)findViewById(R.id.name);
        Email = (TextView)findViewById(R.id.email);
        SignIn.setOnClickListener(this);
        SignOut.setOnClickListener(this);

        //user detial box dispear
        Prof_Section.setVerticalGravity(View.GONE);

        //Google Api set up
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, signInOptions);

        //Facebook login button setup & update
        loginButton = (LoginButton)findViewById(R.id.login_button);
        //textView = (TextView)findViewById(R.id.textView);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            //Facebook sign-in result,
            @Override
            public void onSuccess(LoginResult loginResult) {
                //textView.setText("Login Success \n" +
                        //loginResult.getAccessToken().getUserId()+"\n" +
                        //loginResult.getAccessToken().getToken());
                redirect();

            }

            @Override
            public void onCancel() {
                textView.setText("Login cancel");
            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        //this for clean up the google login UI, problem not work yet
        //set all things disappear
        Prof_Section.setVisibility(View.GONE);
        SignIn.setVisibility(View.GONE);
    }

    //jump to home, when login access
    public void redirect(){

        Intent intent = new Intent(this, Topics_Home.class);
        startActivity(intent);
    }

    //login & logout button ClickListener
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bn_login:
                signIn();
                break;
            case R.id.bn_logout:
                signOut();
                break;
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    //sign-in button ClickListener
    private void signIn(){

        Intent intent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(intent,REQ_CODE);
    }

    //sign-out button ClickListener
    private void signOut(){

        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUI(false);
                googleApiClient.clearDefaultAccountAndReconnect();
            }
        });
    }

    //handle @result from google and update , @result: user detial
    private void handleResult(GoogleSignInResult result){

        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            String name = account.getDisplayName();
            String email = account.getEmail();
            Name.setText(name);
            Email.setText(email);
            updateUI(true);

        }else{
            updateUI(false);
        }
    }

    //update the view
    //login access, login button disappear user detail box display
    //login not access, login button display user detail box disappear
    private void updateUI(boolean isLogin){

        if(isLogin){
            Prof_Section.setVisibility(View.GONE);//View.VISIBLE
            SignIn.setVisibility(View.GONE);
        }else{
            Prof_Section.setVisibility(View.GONE);
            SignIn.setVisibility(View.GONE);//View.VISIBLE
        }
    }

    //check the result is handel and changed then update the UI
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);//problem here the result not change , google sign-in window not shows up*/

        }
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

            AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
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
