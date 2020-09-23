package com.LYEO.musicianfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText edUser,edpass;
    private SharedPreferences myShare;

    private static  final  String USER_NAME="USER_NAME";
    private static  final  String USER_PASSWORD="USER_PASSWORD";
    public static String userName="";
    private  String userPass="";
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUser = findViewById(R.id.edUserName);
        edpass = findViewById((R.id.edPassword));

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        try {
//            Log.d("yisrael", " 0");


            myShare = getSharedPreferences("first", Context.MODE_PRIVATE);
            userName = myShare.getString(USER_NAME, null);
            userPass = myShare.getString(USER_PASSWORD, null);
            edUser.setText(userName);
            edpass.setText(userPass);

        } catch (Exception e) {
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
                    login(userName, userPass);
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
                }else{
                    //display some message here
                    Toast.makeText(Login.this,"sign Error",Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }

            }
        });
    }

}