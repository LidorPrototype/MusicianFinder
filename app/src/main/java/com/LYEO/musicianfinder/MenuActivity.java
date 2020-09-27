package com.LYEO.musicianfinder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    private Button ToPrivateArea;
    private Button ToFindABand;
    private Button ToFindAMusician;
    private Button ToPublishYouself;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ToPrivateArea=(Button) findViewById(R.id.privateArea);
        ToFindABand=(Button) findViewById(R.id.FindABand);
        ToFindAMusician=(Button) findViewById(R.id.FindAMusician);
        ToPublishYouself=(Button) findViewById(R.id.PublishYourself);

        ToPrivateArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPrivateArea();
            }
        });
        ToFindABand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFindABand();
            }
        });
        ToFindAMusician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFindAMusician();
            }
        });
        ToPublishYouself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPublishYouself();
            }
        });




        }
        public void openPrivateArea(){
            Log.d("yisrael", "yaa "+Login.u1);
            try {

            intent=new Intent(this,PrivateAreaActivity.class);
            startActivity(intent);
            finish();
            }catch (Exception e){
                Toast.makeText(MenuActivity.this,"load Error" +e,Toast.LENGTH_LONG).show();

            }
    }
        public void openFindABand(){
        intent=new Intent(this,BandSearchScreenActivity.class);
        startActivity(intent);
        finish();
    }
        public void openFindAMusician(){
        intent=new Intent(this,MusicianSearchScreenActivity.class);
        startActivity(intent);
        finish();
    }
        public void openPublishYouself(){
        intent=new Intent(this,PublishYourselfActivity.class);
        startActivity(intent);
        finish();
    }
    }