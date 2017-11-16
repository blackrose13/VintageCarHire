package com.vintagecarhire;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    private static final String TAG  = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    EditText input_email;
    EditText input_password;
    Button btn_login;
    ImageView profile;
    TextView link_signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        input_email = (EditText) findViewById(R.id.input_email);
        input_password = (EditText) findViewById(R.id.input_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        profile = (ImageView) findViewById(R.id.profile);
        link_signup = (TextView) findViewById(R.id.link_signup);

        btn_login.setOnClickListener(new View.OnClickListener(){

            //**the following lines of code takes the user to the next class after details have been enter and validation has
            //has been done . Restructuring of code is needed so that it first goes through validation process then login is enabled
            @Override
            public void onClick(View view){
                Intent intent = new Intent (LoginActivity.this,ConfirmPayment.class);
                startActivity(intent);

            }

        });

        //in most cases the greater number of users of this application are new so some of them click on the sign up link
        //after selecting the vintage they want to use
        link_signup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent intent = new Intent (LoginActivity.this,CreateAccount.class);
                startActivity(intent);
            }
        });
    }
     public void login() {
         Log.d(TAG, "Login");

         if (!validate()) {
             onLoginFailed();
             return;
         }

         btn_login.setEnabled(false);

         //the dialog that shows up the authentication process user has to wait for it to finish processing so it takes them
         //to the next page which is the Confirm payment activity
         final ProgressDialog progressDialog = new ProgressDialog((LoginActivity.this),
                 R.style.Theme_AppCompat_NoActionBar);
         progressDialog.setIndeterminate(true);
         progressDialog.setMessage("Authenticating");
         progressDialog.show();
     }

    private void onLoginFailed() {

    }

    public boolean validate(){
         boolean valid = true;
// validation has to be done for security reasons . This part of the code  focuses on whether a user has entered the correct
        //email address by checking the pattern first using the android.util.patterns function.
        //password characters are given a minimum and a maximum length
        String email = input_email.getText().toString();
        String password =input_password.getText().toString();

        if (email.isEmpty()||!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            input_email.setError("Enter a valid email address");
            valid = false;

        }else {
            input_email.setError(null);
        }
        if (password.isEmpty()||password.length()<6 || password.length()>10) {
            input_password.setError("Password should be between 6-10 alphanumeric characters");
            valid = false;
        }else {
            input_password.setError(null);
        }
        return valid;


        }

    }

///the code still needs a number of fields like the forgot password feature and the linking of users accounts with google




