package com.LYEO.musicianfinder.Posts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.LYEO.musicianfinder.MenuActivity;
import com.LYEO.musicianfinder.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SearchScreenActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton rbLocation, rbGenre, rbInstrument;
    private EditText edSearch;
    private Button btnSearch;
    private ListView l1;
    private List<Post> postList = new ArrayList<>();
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static Context cn1;
    private String searchBy = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);
        radioGroup = findViewById(R.id.radioGroup);
        rbLocation = findViewById(R.id.rbLocation);
        rbGenre = findViewById(R.id.rbGenre);
        rbInstrument = findViewById(R.id.rbInstrument);
        edSearch = findViewById(R.id.edSearch);
        btnSearch = findViewById(R.id.btnSearch);
        l1 = findViewById(R.id.l1);

        //update the edit text filed
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbLocation.isChecked()){
                    edSearch.setHint(R.string.search_by_location);
                }else if (rbGenre.isChecked()){
                    edSearch.setHint(R.string.search_by_genre);

                }else if (rbInstrument.isChecked()){
                    edSearch.setHint(R.string.search_by_instrument);
                }
            }
        });
        //apply the search button
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchBy = edSearch.getText().toString();
                getAllNewPost();
            }
        });
        findViewById(R.id.btnReturn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    //search posts in firebase by location or genre or instrument
    public void getAllNewPost(){
        DatabaseReference myRef1= database.getReference("posts");
        myRef1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                try {

                    postList.clear();
                    for (DataSnapshot ds:dataSnapshot.getChildren()){
                        Post p1=ds.getValue(Post.class);
                        if (rbLocation.isChecked()){
                            if (p1.getLocation().equals(searchBy))
                                postList.add(p1);
                        }else if (rbGenre.isChecked()){
                            if (p1.getGenre().equals(searchBy))
                                postList.add(p1);
                        }else if (rbInstrument.isChecked()){
                            if (p1.getInstrument().equals(searchBy))
                                postList.add(p1);
                        }
                        AdapterPosts adapterPosts = new AdapterPosts(getApplicationContext(), postList);
                        l1.setAdapter(adapterPosts);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("yisrael", "yaa "+e);

                }


            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                try {
                    postList.clear();
                    for (DataSnapshot ds:dataSnapshot.getChildren()){
                        Post p1=ds.getValue(Post.class);
                        if (rbLocation.isChecked()){
                            if (p1.getLocation().equals(searchBy))
                                postList.add(p1);
                        }else if (rbGenre.isChecked()){
                            if (p1.getGenre().equals(searchBy))
                                postList.add(p1);
                        }else if (rbInstrument.isChecked()){
                            if (p1.getInstrument().equals(searchBy))
                                postList.add(p1);
                        }
                        AdapterPosts adapterPosts = new AdapterPosts(getApplicationContext(), postList);
                        l1.setAdapter(adapterPosts);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("yisrael", "yaa "+e);

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