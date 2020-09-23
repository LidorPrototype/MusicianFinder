package com.LYEO.musicianfinder;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBase {
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    public boolean sendUserInfoFb (String userName, String userPass){
        boolean flag=false;
        DatabaseReference UserInfo = database.getReference("Users").child("User");
        UserInfo.child(userName).setValue(userPass);
        flag=true;
        return flag;
    }
}
