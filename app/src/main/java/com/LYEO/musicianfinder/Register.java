package com.LYEO.musicianfinder;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
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
import androidx.constraintlayout.widget.ConstraintLayout;

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

    private String UserName = "", UserPass = "", Name = "", UserLocation = "", UserBio = "", UserLink = "";
    private List<String> instrumentsNames = new ArrayList<>();
    private List<String> genresNames = new ArrayList<>();
    private String[] genreList = new String[61];
    private AutoCompleteTextView actvLocation;
    private int UserAge = 0;
    private EditText edUserName, edUserPass, edName, edAge, edBio, edLink;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private ProgressDialog progressDialog;
    private Button btReg;
    private FireBase fb1;
    private User u1;
    private TextView textView_Instruments, textView_Genres;
    private boolean[] genresCheckedItems;
    private ArrayList<Boolean> genresCheckedItemsList = new ArrayList<>();
    private ArrayList<Integer> userGenres = new ArrayList<>();
    private ArrayList<String> cities;
    protected AnimationDrawable animDrawableReg;
    protected Configuration configurationObj;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, WelcomePageActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.up_to_bottom_2, R.anim.bottom_to_up_2);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Login.cn1 = getApplicationContext();
        configurationObj = new Configuration();

        int h = configurationObj.getHeight();
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(10, h, 10, h);
        findViewById(R.id.linearLayout_Register).setLayoutParams(layoutParams);

        try {
            edUserName = findViewById(R.id.edUserName);
            edUserPass = findViewById(R.id.edUserPass);
            edName = findViewById(R.id.edName);
            edAge = findViewById(R.id.edAge);
            actvLocation = findViewById(R.id.actvLocation);
            edBio = findViewById(R.id.edBio);
            edLink = findViewById(R.id.edLink);
            textView_Instruments = findViewById(R.id.textView_listOfInstruments);
            textView_Genres = findViewById(R.id.textView_listOfGenres);
            btReg = findViewById(R.id.btnRegister);

            textView_Instruments.setMovementMethod(new ScrollingMovementMethod());

            progressDialog = new ProgressDialog(this);
            fb1 = new FireBase();

            // Activity Area
            cities = configurationObj.getCities();
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    R.layout.cities_items, R.id.text_city_name, cities);
            actvLocation.setAdapter(adapter);

            // Getting the Genres
            genreList = configurationObj.getGenres();
            genresCheckedItems = new boolean[genreList.length];

        } catch (Exception e) {
            Log.d("yisrael", "yaa " + e);
        }

        // Register Button Animation
        animDrawableReg = (AnimationDrawable) btReg.getBackground();
        animDrawableReg.setEnterFadeDuration(2000);
        animDrawableReg.setExitFadeDuration(2000);

    }

    public void mainClick(View v) {
        if (v.getId() == R.id.btnRegister) {
            try {
                if (edUserName.getText().toString().equals("") || edUserPass.getText().toString().equals("")) {
                    Toast.makeText(this, "Please Fill The Mandatory Parts!", Toast.LENGTH_SHORT).show();
                } else {
                    UserName = edUserName.getText().toString();
                    UserPass = edUserPass.getText().toString();
                    Name = edName.getText().toString();
                    UserAge = Integer.parseInt(edAge.getText().toString());
                    UserLocation = actvLocation.getText().toString();
                    UserBio = edBio.getText().toString();
                    UserLink = edLink.getText().toString();

                    // Validate the link - START
                    UserLink = ((UserLink.equals("") || (UserLink.equals("www.example.com"))
                            ? ""
                            : UserLink));
                    boolean validUrl = Patterns.WEB_URL.matcher(UserLink).matches();
                    // Validate the link - END
                    if (validUrl || UserLink.equals("")) {
                        // 1) Url is valid
                        // 2) User did not provide a url
                        // continue to register
                    } else {
                        //invalid Url
                        Toast.makeText(this, "Please provide a valid link!", Toast.LENGTH_SHORT).show();
                    }

                    // TODO Fix Register for Mandatory + Optional Data: (9 in general) - current 7 saved
                    u1 = new User(UserName, UserPass, Name, UserLocation, UserBio, genresNames, genresCheckedItemsList, instrumentsNames, UserLink, UserAge);
                    registerUser(UserName, UserPass);
                    Login.u1 = this.u1;
//                     User u1 = new User(UserName,UserPass);
                    Toast.makeText(Register.this, "in register", Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                Toast.makeText(this, "Try Again Please!", Toast.LENGTH_SHORT).show();
                Log.d("ERROR_REGISTER", "\nError msg: " + e + "\n");
            }
        }

    }

    private void registerUser(String userName, String userPass) {

        userName += "@gmail.com";

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();
        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(userName, userPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            //display some message here
                            Toast.makeText(Register.this, "Successfully registered", Toast.LENGTH_LONG).show();
                            if (fb1.sendUserInfoFb(u1)) {
                                btReg.setText("User added");
                                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        } else {
                            //display some message here
                            Toast.makeText(Register.this, "Registration Error", Toast.LENGTH_LONG).show();

                        }
                        progressDialog.dismiss();
                    }
                });

    }

    public void OpenMultiChoiceDialog(View view) {
        openDialog();
    }

    public void openDialog() {
        MultiChoiceDialog multiChoiceDialog = new MultiChoiceDialog();
        multiChoiceDialog.show(getSupportFragmentManager(), "multi_choice dialog");
    }

    @Override
    public void applyData(ArrayList<Instruments> _listOfItems, int flag) {// 0 - Empty, 1 - Full
        if (flag == 0) {
            textView_Instruments.setText("No Instruments Selected!");
        } else if (flag == 1) {
            instrumentsNames.clear();
            StringBuilder tmp = new StringBuilder();
            for (int h = 0; h < _listOfItems.size(); h++) {
                tmp.append(_listOfItems.get(h).getInstrument());
                instrumentsNames.add(_listOfItems.get(h).getInstrument());
                if (h < _listOfItems.size() - 1) {
                    tmp.append(", ");
                }
            }
            textView_Instruments.setText(tmp);
        }
    }

    public void OpenGenresList(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Register.this);
        mBuilder.setTitle(R.string.genres);
        mBuilder.setMultiChoiceItems(genreList, genresCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                if (isChecked) {
                    userGenres.add(position);
                } else {
                    userGenres.remove((Integer.valueOf(position)));
                }
            }
        });

        mBuilder.setCancelable(false);
        mBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                genresNames.clear();
                StringBuilder item = new StringBuilder();
                for (int i = 0; i < userGenres.size(); i++) {
                    item.append(genreList[userGenres.get(i)]);
                    genresNames.add(genreList[userGenres.get(i)]);
                    if (i != userGenres.size() - 1) {
                        item.append(", ");
                    }
                }
//                mItemSelected.setText(item);
                textView_Genres.setText(item.toString());
                genresCheckedItemsList.clear();
                for (boolean genresCheckedItem : genresCheckedItems) {
                    genresCheckedItemsList.add(genresCheckedItem);
                }
            }
        });

        mBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

//        mBuilder.setNeutralButton(R.string.clear_all_label, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int which) {
//                for (int i = 0; i < checkedItems.length; i++) {
//                    checkedItems[i] = false;
//                    mUserItems.clear();
//                    mItemSelected.setText("");
//                }
//            }
//        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animDrawableReg != null && !animDrawableReg.isRunning()) {
            animDrawableReg.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animDrawableReg != null && animDrawableReg.isRunning()) {
            animDrawableReg.stop();
        }
    }

    public void openInfo(View view) {
        openInfoDialog(0);
    }

    public void openInfoDialog(int type){
        /**
         * type = 0     -->     TermOfUse + PrivacyPolicy           (Default Value, Enter Negative)
         * type = 1     -->     Generated Password For User
         * */
        if(type < 0){type = 0;}
        TOU_PP_Dialog dialogInfo = new TOU_PP_Dialog().newInstance(type);
        dialogInfo.show(getSupportFragmentManager(), "info dialog");
    }
}



























