package com.LYEO.musicianfinder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.LYEO.musicianfinder.Posts.Post;

public class PublishYourselfActivity extends AppCompatActivity{
    private Button ToBand;
    private Button ToMusician;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_yourself);
        ToBand=(Button) findViewById(R.id.band);
        ToMusician=(Button) findViewById(R.id.single);

        //send post to firebase
//        Post p1;
        try {
        Post p1 = new Post();
        FireBase fb1 = new FireBase();
        fb1.sendPostToFb(p1);

        }catch (Exception e){
            Log.d("yisrael", "yaa " + e);

        }
//        Post p1 = new Post(Login.userName," content", "location", "instrument");


        ToBand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBand();
            }
        });
        ToMusician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMusician();
            }
        });
}

    public void openBand(){
        intent=new Intent(this,Publish_Band.class);
        startActivity(intent);
        finish();
    }
    public void openMusician(){
        intent=new Intent(this,Publish_Musician.class);
        startActivity(intent);
        finish();
    }

}