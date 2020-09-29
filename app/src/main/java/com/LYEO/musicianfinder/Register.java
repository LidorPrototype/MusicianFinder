package com.LYEO.musicianfinder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Yisrael Bar & Lidor Eliyahu on 24/09/2020
 */

public class Register extends AppCompatActivity implements MultiChoiceDialog.MultiChoiceDialogListener {

    private String UserName = "",UserPass = "", Name = "",UserArea = "", UserBio = "", UserLink = "";
    private List<String> instrumentsNames = new ArrayList<>();
    private List<String> genreList = new ArrayList<>();
    private AutoCompleteTextView actvArea;
    private int UserAge = 0;
    private EditText edUserName, edUserPass, edName, edAge, edBio, edLink;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private ProgressDialog progressDialog;
    private Button btReg;
    private FireBase fb1;
    private User u1;
    private TextView textView_Instruments;
    private ArrayList<String> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUserName = findViewById(R.id.edUserName);
        edUserPass = findViewById(R.id.edUserPass);
        edName = findViewById(R.id.edName);
        edAge = findViewById(R.id.edAge);
        actvArea = findViewById(R.id.actvArea);
        edBio = findViewById(R.id.edBio);
        edLink = findViewById(R.id.edLink);
        textView_Instruments = findViewById(R.id.textView_listOfInstruments);

        Configuration configurationObj = new Configuration();

        textView_Instruments.setMovementMethod(new ScrollingMovementMethod());

        progressDialog = new ProgressDialog(this);
        btReg = findViewById(R.id.btnRegister);
        fb1 = new FireBase();

        // Activity Area
        cities = configurationObj.getCities();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.cities_items, R.id.text_city_name, cities);
        actvArea.setAdapter(adapter);


    }

    public  void mainClick (View v){
        if (v.getId()==R.id.btnRegister){
            try {
                if (edUserName.getText().toString().equals("") || edUserPass.getText().toString().equals("")){
                    Toast.makeText(this, "Please Fill The Mandatory Parts!", Toast.LENGTH_SHORT).show();
                }else{
                    UserName = edUserName.getText().toString();
                    UserPass = edUserPass.getText().toString();
                    Name = edName.getText().toString();
                    UserAge = Integer.parseInt(edAge.getText().toString());
                    UserArea = actvArea.getText().toString();
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

                    // TODO Fix Register for Mandatory + Optional Data: (9 in general)
                    // TODO - Add instrumentsNames to the user credentials
                    u1= new User(UserName,UserPass,Name,UserBio,UserLink,UserAge);
                    registerUser(UserName,UserPass);
                    Login.u1 =this.u1;
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
                            if (fb1.sendUserInfoFb(u1)){
                                btReg.setText("User added");
                                Intent intent= new Intent(getApplicationContext(),MenuActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }else{
                            //display some message here
                            Toast.makeText(Register.this,"Registration Error",Toast.LENGTH_LONG).show();

                        }
                        progressDialog.dismiss();
                    }
                });

    }

    public void OpenMultiChoiceDialog(View view) {
        openDialog();
    }

    public void openDialog(){
        MultiChoiceDialog multiChoiceDialog = new MultiChoiceDialog();
        multiChoiceDialog.show(getSupportFragmentManager(), "multi_choice dialog");
    }

    @Override
    public void applyData(ArrayList<Instruments> _listOfItems, int flag) {// 0 - Empty, 1 - Full
        if(flag == 0){
            textView_Instruments.setText("No Instruments Selected!");
        }else if(flag == 1){
            StringBuilder tmp = new StringBuilder();
            for (int h = 0; h < _listOfItems.size(); h++){
                tmp.append(_listOfItems.get(h).getInstrument());
                instrumentsNames.add(_listOfItems.get(h).getInstrument());
                if(h < _listOfItems.size() - 1){
                    tmp.append(", ");
                }
            }
            textView_Instruments.setText(tmp);
        }
    }
}



























