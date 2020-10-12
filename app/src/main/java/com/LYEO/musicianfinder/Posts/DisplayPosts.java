package com.LYEO.musicianfinder.Posts;
/*
 * created by yisrael bar
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.LYEO.musicianfinder.Configuration;
import com.LYEO.musicianfinder.MenuActivity;
import com.LYEO.musicianfinder.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DisplayPosts extends AppCompatActivity {

    private TextView textViewPostHeadline;
    private ListView l1;
    private List<Post> postList = new ArrayList<>();
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static Context cn1;
    public static Activity act;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_posts);

        textViewPostHeadline = findViewById(R.id.textView_PostsHeadline);

        Configuration configurationObj = new Configuration();
        int h = configurationObj.getHeight();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(30, 20, 30, h);
        findViewById(R.id.linearLayout_Posts).setLayoutParams(layoutParams);

        Typeface typefaceHeadlinePost = Typeface.createFromAsset(getAssets(), "fonts/epilogue.regular.ttf");
        textViewPostHeadline.setTypeface(typefaceHeadlinePost);

        l1 = findViewById(R.id.l1);

        l1.setDividerHeight(0);

        try {
            cn1 = this;
            act = this;
            getAllNewPost();

        }catch (Exception e){
            Log.d("yisrael", "yaa "+e);

        }
        // go back button
        findViewById(R.id.btnReturn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
    private void getAllNewPost(){
        DatabaseReference  myRef1= database.getReference("posts");
        myRef1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                try {

                    postList.clear();
                    for (DataSnapshot ds:dataSnapshot.getChildren()){
                        Post p1=ds.getValue(Post.class);
                        postList.add(p1);
                        AdapterPosts adapterPosts = new AdapterPosts(getApplicationContext(), postList);
                        l1.setAdapter(adapterPosts);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                try {
                    postList.clear();
                    for (DataSnapshot ds:dataSnapshot.getChildren()){
                        Post p1=ds.getValue(Post.class);
                        postList.add(p1);
                        AdapterPosts adapterPosts = new AdapterPosts(getApplicationContext(), postList);
                        l1.setAdapter(adapterPosts);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}