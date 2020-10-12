package com.LYEO.musicianfinder;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.LYEO.musicianfinder.Chat.Rooms;
import com.LYEO.musicianfinder.Posts.DisplayPosts;
import com.LYEO.musicianfinder.Posts.PublishYourselfActivity;
import com.LYEO.musicianfinder.Posts.SearchScreenActivity;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout ToPrivateArea, ToPublishYouself, ToChats, ToPosts, ToSearch;
    private Intent intent;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(MenuActivity.this);
        intent = new Intent(this, WelcomePageActivity.class);
        startActivity(intent, options.toBundle());
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ToPrivateArea = findViewById(R.id.linearLayout_Profile);
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
        try {
            intent = new Intent(this, PrivateAreaActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.push_left_inside, R.anim.push_left_outside);
            finish();
        }catch (Exception e){
            Toast.makeText(MenuActivity.this,"load Error" +e,Toast.LENGTH_LONG).show();
        }
    }
    private void openSearch() {
        intent = new Intent(this, SearchScreenActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_inside, R.anim.push_left_outside);
        finish();
    }
    private void openPublishYourself(){
        intent = new Intent(this, PublishYourselfActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_inside, R.anim.push_left_outside);
        finish();
    }
    private void openChats() {
        intent = new Intent(this, Rooms.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_inside, R.anim.push_left_outside);
        finish();
    }
    private void openPosts() {
        intent = new Intent(this, DisplayPosts.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_inside, R.anim.push_left_outside);
        finish();
    }
}