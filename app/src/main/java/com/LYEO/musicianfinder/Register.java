package com.LYEO.musicianfinder;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private String UserName = "",UserPass = "", Name = "", UserBio = "", UserLink = "";
    private int UserAge = 0;
    private EditText edUserName, edUserPass, edName, edAge, edBio, edLink;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private ProgressDialog progressDialog;
    private Button btReg;
    private FireBase fb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUserName = findViewById(R.id.edUserName);
        edUserPass = findViewById(R.id.edUserPass);
        edName = findViewById(R.id.edName);
        edAge = findViewById(R.id.edAge);
        edBio = findViewById(R.id.edBio);
        edLink = findViewById(R.id.edLink);

        progressDialog = new ProgressDialog(this);
        btReg = findViewById(R.id.btnRegister);
        fb1 = new FireBase();

    }

    public  void mainClick (View v){
        if (v.getId()==R.id.btnRegister){
//            Intent intent= new Intent(getApplicationContext(),Register.class);
//            startActivity(intent);
//
//            FirebaseDatabase database = FirebaseDatabase.getInstance();
//            DatabaseReference myRef = database.getReference("message");
//
//            myRef.setValue("Hello, World!");
            try {
                if (edUserName.getText().toString().equals("") || edUserPass.getText().toString().equals("")){
                    Toast.makeText(this, "Please Fill The Mandatory Parts!", Toast.LENGTH_SHORT).show();
                }else{
                    UserName = edUserName.getText().toString();
                    UserPass = edUserPass.getText().toString();
                    Name = edName.getText().toString();
                    UserAge = Integer.parseInt(edAge.getText().toString());
                    UserBio = edBio.getText().toString();
                    UserLink = edLink.getText().toString();

                    // Validate the link - START
                    UserLink = ((UserLink.equals("") || (UserLink.equals("www.example.com"))
                            ? ""
                            : UserLink));
                    boolean validUrl = Patterns.WEB_URL.matcher(UserLink).matches();
                    // Validate the link - END
                    if(validUrl || UserLink.equals("")){
                        // 1) Url is valid
                        // 2) User did not provide a url
                        // continue to register
                    }else{
                        //invalid Url
                        Toast.makeText(this, "Please provide a valid link!", Toast.LENGTH_SHORT).show();
                    }

                    // TODO Fix Register for Mandatory + Optional Data
                    registerUser(UserName,UserPass);

//                     User u1 = new User(UserName,UserPass);
                    Toast.makeText(Register.this,"in register",Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                Toast.makeText(this, "Try Again Please!", Toast.LENGTH_SHORT).show();
                Log.d("ERROR_REGISTER", "\nError msg: " + e + "\n");
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


