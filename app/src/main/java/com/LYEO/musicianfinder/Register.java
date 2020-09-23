package com.LYEO.musicianfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private String UserName="",UserPass="";
    private  EditText edUserName,edUserPass;
    private FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    private ProgressDialog progressDialog;
    private Button btReg;
    private FireBase fb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUserName=findViewById(R.id.edUserName);
        edUserPass=findViewById(R.id.edUserPass);
        progressDialog = new ProgressDialog(this);
        btReg=findViewById(R.id.btRegister);
        fb1=new FireBase();

    }





    public  void mainClick (View v){

        if (v.getId()==R.id.btRegister){
//            Intent intent= new Intent(getApplicationContext(),Register.class);
//            startActivity(intent);
//
//            FirebaseDatabase database = FirebaseDatabase.getInstance();
//            DatabaseReference myRef = database.getReference("message");
//
//            myRef.setValue("Hello, World!");
            try {
                if ( edUserName.getText().toString().equals("") || edUserPass.getText().toString().equals("") ){
                    btReg.setText("Fill the blank");
                }else{
                    UserName = edUserName.getText().toString();
                    UserPass = edUserPass.getText().toString();
                    registerUser(UserName,UserPass);

//                     User u1 = new User(UserName,UserPass);
                    Toast.makeText(Register.this,"in register",Toast.LENGTH_LONG).show();
                }

            } catch (Exception e) {
                btReg.setText("Fill the blank"+ e);
            }
        }

    }

    private void registerUser(String userName,String userPass){

        userName+="@gmail.com";

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();
        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(userName, userPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(Register.this,"Successfully registered",Toast.LENGTH_LONG).show();
                            if (fb1.sendUserInfoFb(UserName, UserPass)){
                                //edit
//                                fb1.sendUserInfoFb(UserName, UserPass)
                                btReg.setText("User added");
                            }
                        }else{
                            //display some message here
                            Toast.makeText(Register.this,"Registration Error",Toast.LENGTH_LONG).show();

                        }
                        progressDialog.dismiss();
                    }
                });

    }
}


