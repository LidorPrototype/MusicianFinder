package com.LYEO.musicianfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public  void mainClick (View v){
        if (v.getId()==R.id.btLogin){
            Intent intent= new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.btRegister){
            Intent intent= new Intent(getApplicationContext(),Register.class);
            startActivity(intent);

        }

    }
}