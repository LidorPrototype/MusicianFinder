package com.LYEO.musicianfinder;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    /*
     * Created by yisrael bar and Lidor Eliyahu on 24/09/2020
     * */
    private EditText edUser,edpass;
    private TextView textViewHeadline;
    private Button btnLogin;
    private SharedPreferences myShare;
    public static User u1;
    private static  final  String USER_NAME="USER_NAME";
    private static  final  String USER_PASSWORD="USER_PASSWORD";
    public static String userName="";
    public static Context cn1;
    private  String userPass="";
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    protected AnimationDrawable animationDrawableLogin;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, WelcomePageActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.bottom_to_up, R.anim.up_to_bottom);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUser = findViewById(R.id.edUserName);
        edpass = findViewById((R.id.edPassword));
        textViewHeadline = findViewById(R.id.textView_LoginHeadline);
        btnLogin = findViewById(R.id.btnLogin);

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

        Typeface typefaceHeadlineLogin = Typeface.createFromAsset(getAssets(), "fonts/epilogue.regular.ttf");
        textViewHeadline.setTypeface(typefaceHeadlineLogin);

        animationDrawableLogin = (AnimationDrawable) btnLogin.getBackground();
        animationDrawableLogin.setEnterFadeDuration(2500);
        animationDrawableLogin.setExitFadeDuration(2500);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor edit1 = myShare.edit();
        edit1.putString(USER_NAME,userName);
        edit1.putString(USER_PASSWORD,userPass);
        edit1.commit();
        if (animationDrawableLogin != null && animationDrawableLogin.isRunning()){
            animationDrawableLogin.stop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawableLogin != null && !animationDrawableLogin.isRunning()){
            animationDrawableLogin.start();
        }
    }

    public  void mainClick (View v){
        if (v.getId()==R.id.btnLogin){
            try {
                if (!edUser.getText().toString().equals("") && !edpass.getText().toString().equals("")) {
                    userName = edUser.getText().toString();
                    userPass = edpass.getText().toString();
                    FireBase fb1= new FireBase();
                    fb1.getAUesr(userName);
                    login(userName, userPass);

                    //close virtual keyboard
                    InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
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
                    ActivityOptions options = ActivityOptions
                            .makeSceneTransitionAnimation(Login.this);
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(intent, options.toBundle());
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