package com.LYEO.musicianfinder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.LYEO.musicianfinder.Chat.Rooms;
import com.LYEO.musicianfinder.Posts.DisplayPosts;
import com.LYEO.musicianfinder.Posts.PublishYourselfActivity;
import com.LYEO.musicianfinder.Posts.SearchScreenActivity;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout ToPrivateArea, ToFindABand, ToFindAMusician, ToPublishYouself, ToChats, ToPosts, ToSearch;
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
        ToPosts = findViewById(R.id.linearLayout_Posts);
        ToSearch = findViewById(R.id.linearLayout_Search);

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
                openPublishYourself();
            }
        });
        ToChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChats();
            }
        });
        ToPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPosts();
            }
        });
        ToSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSearch();
            }
        });
        try {
        //get all new chat
        FireBase fb1= new FireBase();
        fb1.getAllNewChats();
        }catch (Exception e){
//            Toast.makeText(MenuActivity.this,"load Error" +e,Toast.LENGTH_LONG).show();

        }

    }



    private void openPrivateArea(){
        Log.d("yisrael", "yaa "+Login.u1);
        try {
        intent = new Intent(this,PrivateAreaActivity.class);
        startActivity(intent);
        }catch (Exception e){
            Toast.makeText(MenuActivity.this,"load Error" +e,Toast.LENGTH_LONG).show();
        }
    }

    private void openFindABand(){
        intent = new Intent(this,BandSearchScreenActivity.class);
        startActivity(intent);
        finish();
    }

    private void openFindAMusician(){
    intent = new Intent(this, SearchScreenActivity.class);
    startActivity(intent);
        finish();
    }

    private void openPublishYourself(){
    intent = new Intent(this, PublishYourselfActivity.class);
    startActivity(intent);
        finish();
    }

    private void openChats() {
        intent = new Intent(this, Rooms.class);
        startActivity(intent);
        finish();
    }
    private void openPosts() {
        intent = new Intent(this, DisplayPosts.class);
        startActivity(intent);
        finish();
    }
    private void openSearch() {
        intent = new Intent(this, SearchScreenActivity.class);
        startActivity(intent);
        finish();
    }
}