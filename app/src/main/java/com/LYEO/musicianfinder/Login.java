package com.LYEO.musicianfinder;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    /*
     * Created by yisrael bar on 24/09/2020
     * */
    private EditText edUser,edpass;
    private SharedPreferences myShare;
    public static User u1;
    private static  final  String USER_NAME="USER_NAME";
    private static  final  String USER_PASSWORD="USER_PASSWORD";
    public static String userName="";
    private  String userPass="";
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    public static Context cn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUser = findViewById(R.id.edUserName);
        edpass = findViewById((R.id.edPassword));
        //connect Context for - firebase - sql - getNewChats()
        cn1=this;
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        try {
            myShare = getSharedPreferences("first", Context.MODE_PRIVATE);
            userName = myShare.getString(USER_NAME, null);
            userPass = myShare.getString(USER_PASSWORD, null);
            edUser.setText(userName);
            edpass.setText(userPass);
        }catch (Exception e) {
            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor edit1 = myShare.edit();
        edit1.putString(USER_NAME,userName);
        edit1.putString(USER_PASSWORD,userPass);
        edit1.commit();
    }
    public  void mainClick (View v){
        if (v.getId()==R.id.btLogin){
            try {
                if (!edUser.getText().toString().equals("") && !edpass.getText().toString().equals("")) {
                    userName = edUser.getText().toString();
                    userPass = edpass.getText().toString();
                    FireBase fb1= new FireBase();
                    fb1.getAUesr(userName);
                    login(userName, userPass);
//                    Log.d("yisrael", "yaa "+u1);

                }
            }catch (Exception e) {
                Toast.makeText(Login.this,""+e,Toast.LENGTH_LONG).show();
            }
        }
    }

    private void login(String userName, String userPass) {
        userName+="@gmail.com";
        firebaseAuth.signInWithEmailAndPassword(userName,userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //checking if success
                if(task.isSuccessful()){
                    //display some message here
                    finish();
                    progressDialog.dismiss();
                    startActivity(new Intent(getApplicationContext(),MenuActivity.class));
                    finish();
                }else{
                    //display some message here
                    Toast.makeText(Login.this,"sign Error",Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }

            }
        });
    }

}