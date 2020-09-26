package com.LYEO.musicianfinder;


import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;
/*
 * Created by Yisrael Bar on 24/09/2020
 * */

public class FireBase {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    static List <User> UserList=new ArrayList<User>();
    private  User u1 =new User();


    public Boolean sendUserInfoFb(User u2){
        boolean flag=false;
        DatabaseReference UserInfo = database.getReference("Users").child("User");
        UserInfo.child(u2.getUserName()).setValue(u2);
        flag=true;
        return flag;
    }

    public  List<User> getUesrsList(){

        DatabaseReference getUserInfo=database.getReference("Users");
        getUserInfo.addChildEventListener(new ChildEventListener() {
            @Override
            public  void onChildAdded (@NonNull DataSnapshot dataSnapshot, @Nullable String s)  {
                UserList.clear();
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    u1=ds.getValue(User.class);
                    UserList.add(u1);
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                UserList.clear();
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    u1=ds.getValue(User.class);
                    UserList.add(u1);
                }
//                Log.d("yisrael", "yaa "+u1);
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

//        Log.d("yisrael", "its "+UserList.isEmpty());
        return UserList;
    }
    public  void getAUesr(final String UserName){

        DatabaseReference getUserInfo=database.getReference("Users");
        getUserInfo.addChildEventListener(new ChildEventListener() {
            @Override
            public  void onChildAdded (@NonNull DataSnapshot dataSnapshot, @Nullable String s)  {

                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    u1=ds.getValue(User.class);
//                        Log.d("yisrael", "ya2a "+u1.getUserName() + " ? " + UserName);
                    if (u1.getUserName().equals(UserName)){
//                        Log.d("yisrael", "ya1a "+u1);
                        Login.u1 =u1;
                        break;
                    }
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    u1=ds.getValue(User.class);
                    if (u1.getUserName().equals(UserName)){

                        Login.u1 =u1;
                        break;
                    }
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

//        Log.d("yisrael", "its "+Login.u1);
//        return u1;
    }



}
