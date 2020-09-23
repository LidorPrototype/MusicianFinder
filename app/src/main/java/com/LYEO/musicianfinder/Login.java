package com.LYEO.musicianfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public  void mainClick (View v){
        if (v.getId()==R.id.btLogin){
//            Intent intent= new Intent(getApplicationContext(),Login.class);
//            startActivity(intent);
            Toast.makeText(Login.this,"in login",Toast.LENGTH_LONG).show();

        }




    }
}