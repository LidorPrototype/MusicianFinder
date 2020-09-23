package com.LYEO.musicianfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


    }
    public  void mainClick (View v){

         if (v.getId()==R.id.btRegister){
//            Intent intent= new Intent(getApplicationContext(),Register.class);
//            startActivity(intent);
             Toast.makeText(Register.this,"in register",Toast.LENGTH_LONG).show();

        }

    }
}