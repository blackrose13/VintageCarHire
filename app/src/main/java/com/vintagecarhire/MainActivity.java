package com.vintagecarhire;

//**this class is created on the basis that humans are visual creatures
//they judge the application basing on what they see on the first page of the application
//which is why a background image was used since the greatest numbers of booking reason are
//wedding hires and each moment will be remembered as a vintage moment.

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
//the imports used above are basically the fuel to the application without them certain variables cannot be used
//inorder to use them we have to fist import them as shown above

public class MainActivity extends AppCompatActivity {

    public static Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClickButtonListener();
    }

 //** the code below initialises the book now buttton such that when a user clicks on it,
    //it returns the second activity which will show the user the menu and the booking details required
    //for a user to enter
    public void onClickButtonListener() {
        Button button = (Button)findViewById(R.id.button);
          button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                   Intent intent = new Intent (MainActivity.this,HomeActivity.class);
                  startActivity(intent);

              }
          });


    }
}




