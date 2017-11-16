package com.vintagecarhire;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class CreateAccount extends AppCompatActivity {

    private static final String TAG = "CreateAccountActivity";


    ImageView profile;
    EditText input_name;
    EditText input_email;
    EditText input_password;
    Button btn_Sign_up;
    TextView link_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        //** User enter her or his details that includes drivers license and other details after filling in the required info user
        //user clicks on signup button which takes him to the confirmpayment method

        profile = (ImageView) findViewById(R.id.profile);
        input_name = (EditText) findViewById(R.id.input_name);
        input_email = (EditText) findViewById(R.id.input_email);
        input_password = (EditText) findViewById(R.id.input_password);
        btn_Sign_up = (Button) findViewById(R.id.btn_Sign_up);
        link_login = (TextView) findViewById(R.id.link_login);
    }
    btn_Sign_up.setOnClickListener(new View.OnClickListener())

    {
        public void onClick (View v){
        Signup();

    }
    }

    private void Signup() {
    }

        link_login.setOnClickListener(new View.OnClickListener(){

                                         //**the following lines of code takes the user to the next class after details have been enter and validation has
                                         //has been done . Restructuring of code is needed so that it first goes through validation process then login is enabled
                                         @Override
                                         public void onClick(View view){
                                             Intent intent = new Intent (CreateAccount.this,LoginActivity.class);
                                             startActivity(intent);

        }
    }
    btn_Sign_up.setEnabled(false);
    final ProgressDialog progressDialog = new ProgressDialog(CreateAccount.this,
                                           R.style.Theme_AppCompat_NoActionBar);
    progressDialog.setMessage("creating Account.......");
    progressDialog.show();

}

//**validation is done on both login and account creation this is done to check if user has entered the correct information
public boolean validate() {
    boolean valid = true;

    String name = input_name.getText().toString();
    String email = input_email.getText().toString();
    String password = input_password.getText().toString();

    if (name.isEmpty() || name.length() < 3) {
        input_name.setError("at least 3 characters");
        valid = false;
    } else {
        input_name.setError(null);
    }

    if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        input_email.setError("Invalid email address");
    } else {
        input_email.setError(null);
    }
    if (password.isEmpty() || password.length() < 6 || password.length() > 10) {
        input_password.setError("Password should be between 6-10 alphanumeric characters");
        valid = false;
    } else {
        input_password.setError(null);
    }
    return valid;

}
//After user clicks on the sign up button it takes him to the confirm payment in short he does need to go back to the
    //home activity the application takes him to the page after the selected vintage has been picked.
    public void onClickButtonListener() {
        btn_Sign_up = (Button) findViewById(R.id.btn_Sign_up);
        btn_Sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (CreateAccount.this,ConfirmPayment.class);
                startActivity(intent);

            }
        });


    }
