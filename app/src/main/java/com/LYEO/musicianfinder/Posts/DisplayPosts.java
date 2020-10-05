package com.LYEO.musicianfinder.Posts;
/*
 * created by yisrael bar
 */
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

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

    ListView l1;
    List<Post> postList = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static Context cn1;
//    Post p1 = new Post();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_posts);
        l1=(ListView)findViewById(R.id.l1);
        try {
            cn1=this;
            getAllNewPost();

        }catch (Exception e){
            Log.d("yisrael", "yaa "+e);

        }
        // go back button
        findViewById(R.id.btnReturn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void getAllNewPost(){
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