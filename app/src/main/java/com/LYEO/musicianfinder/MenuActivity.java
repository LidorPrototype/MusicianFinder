package com.LYEO.musicianfinder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.LYEO.musicianfinder.Chat.Rooms;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout ToPrivateArea, ToFindABand, ToFindAMusician, ToPublishYouself, ToChats;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ToPrivateArea = findViewById(R.id.linearLayout_Profile);
        ToFindABand = findViewById(R.id.linearLayout_Band);
        ToFindAMusician = findViewById(R.id.linearLayout_Musician);
        ToPublishYouself = findViewById(R.id.linearLayout_Publish);
        ToChats = findViewById(R.id.linearLayout_Chat);

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
        ToChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChats();
            }
        });

    }

    public void openPrivateArea(){
        Log.d("yisrael", "yaa "+Login.u1);
        try {
        intent = new Intent(this,PrivateAreaActivity.class);
        startActivity(intent);
        }catch (Exception e){
            Toast.makeText(MenuActivity.this,"load Error" +e,Toast.LENGTH_LONG).show();
        }
    }

    public void openFindABand(){
        intent = new Intent(this,BandSearchScreenActivity.class);
        startActivity(intent);
    }

    public void openFindAMusician(){
    intent = new Intent(this,MusicianSearchScreenActivity.class);
    startActivity(intent);
    }

    public void openPublishYouself(){
    intent = new Intent(this,PublishYourselfActivity.class);
    startActivity(intent);
    }

    public void openChats() {
        intent = new Intent(this, Rooms.class);
        startActivity(intent);
    }

}