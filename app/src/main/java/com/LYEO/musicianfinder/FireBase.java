package com.LYEO.musicianfinder;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.LYEO.musicianfinder.Chat.Message;
import com.LYEO.musicianfinder.Chat.sql;
import com.LYEO.musicianfinder.Posts.Post;
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
    private  User u1 = new User();
    sql sql1;


    public void sendPostToFb(Post p){
        DatabaseReference myRef1= database.getReference("posts").child("post");
        //to update your post from before
        myRef1.child(Login.userName).setValue(p);
//        other way to send to firebase - for new post every time
//        myRef1.push().setValue(p);

    }
    public void deleteChatFromFb(String other_name){
        DatabaseReference myRef1 = database.getReference("rooms").child(Login.userName).child(other_name);
        myRef1.removeValue();
    }

    public void getAllNewChats (){
        try{
//            Log.d("yisrael", "im here0");
            sql1=new sql(WelcomePageActivity.cn1.getApplicationContext(),"yisrael",null,1);
        }catch (Exception e){
//            Log.d("yisrael", "im here1 "+e);
            e.printStackTrace();
        }

        DatabaseReference myRef1 = database.getReference("rooms").child(Login.userName);
        myRef1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                try {
                    String s1 = dataSnapshot.getKey();
                    if (!sql1.searchUserIfExist(s1)){
                        sql1.AddChatName(s1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                try {
                    String s1 = dataSnapshot.getKey();
                    if (!sql1.searchUserIfExist(s1)){
                        sql1.AddChatName(s1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void sendMessageToFb(Message m){
        DatabaseReference  myRef1= database.getReference("rooms").child(m.getSelf_name()).child(m.getOther_name()).child("message");
        myRef1.push().setValue(m);
        myRef1= database.getReference("rooms").child(m.getOther_name()).child(m.getSelf_name()).child("message");
        myRef1.push().setValue(m);
    }

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
