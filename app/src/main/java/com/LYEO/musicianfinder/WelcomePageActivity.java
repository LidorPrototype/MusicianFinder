package com.LYEO.musicianfinder;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

    }
    public  void mainClick (View v){
        if (v.getId()==R.id.btLogin){
//            Intent intent= new Intent(getApplicationContext(),Login.class);
//            startActivity(intent);
        }
        else if (v.getId()==R.id.btRegister){
//            Intent intent= new Intent(getApplicationContext(),Register.class);
//            startActivity(intent);

        }

    }
}