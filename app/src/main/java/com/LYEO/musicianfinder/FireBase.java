package com.LYEO.musicianfinder;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;
public class FireBase {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    static List <User> UserList=new ArrayList<User>();
    private  User u1 =new User();


    public Boolean sendUserInfoFb(User u1){
        boolean flag=false;
        DatabaseReference UserInfo = database.getReference("Users").child("User");
        UserInfo.child(u1.getUserName()).setValue(u1);
        flag=true;
        return flag;
    }

    public  List<User> getEmployeeList(){

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



}
