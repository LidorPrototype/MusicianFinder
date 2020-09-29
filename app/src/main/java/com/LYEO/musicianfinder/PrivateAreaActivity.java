package com.LYEO.musicianfinder;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PrivateAreaActivity extends AppCompatActivity implements MultiChoiceDialog.MultiChoiceDialogListener{
/* Created by Yisrael Bar on 26/09/2020*/
    private String UserName = "",UserPass = "", Name = "", UserLocation = "", UserBio = "", UserLink = "";
    private List<String> instrumentsNames = new ArrayList<>();
    private int UserAge = 0;
    private EditText edName, edAge, edLocation, edBio, edLink;
    private Button btReg;
    private TextView textView_Instruments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_area);

        edName = findViewById(R.id.edName);
        edLocation = findViewById(R.id.edLocation);
        edAge = findViewById(R.id.edAge);
        edBio = findViewById(R.id.edBio);
        edLink = findViewById(R.id.edLink);
        btReg = findViewById(R.id.btnSaveChange);

        textView_Instruments = findViewById(R.id.textView_listOfInstruments);
        textView_Instruments.setMovementMethod(new ScrollingMovementMethod());

        try {
            edName.setText(Login.u1.getName());
            edAge.setText(Login.u1.getUserAge()+"");
            edBio.setText(Login.u1.getUserBio());
            edLocation.setText(Login.u1.getUserLocation());
            instrumentsNames = Login.u1.getUserInstruments();
            StringBuilder namesIntoText = new StringBuilder();
            for (int f = 0; f < instrumentsNames.size(); f++){
                namesIntoText.append(instrumentsNames.get(f));
                if (f < instrumentsNames.size() - 1){
                    namesIntoText.append(", ");
                }
            }
            textView_Instruments.setText(namesIntoText);
            edLink.setText(Login.u1.getUserLink());
            UserName = Login.u1.getUserName();
            UserPass = Login.u1.getUserPass();
        }catch (Exception e){
            Toast.makeText(PrivateAreaActivity.this,"load Error" +e,Toast.LENGTH_LONG).show();
        }


    }
    public  void mainClick (View v){
        if (v.getId()==R.id.btnSaveChange){
            try {
                Name = edName.getText().toString();
                UserLocation = edLocation.getText().toString();
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
                 User  u2 = new User(UserName, UserPass, Name, UserLocation, UserBio, instrumentsNames, UserLink, UserAge);
                FireBase fb1 = new FireBase();
                Login.u1 = u2;
                if (fb1.sendUserInfoFb(u2)){
                    btReg.setText("data been update");
                }else Toast.makeText(PrivateAreaActivity.this,"Update Error",Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Toast.makeText(PrivateAreaActivity.this,"Update Error" +e,Toast.LENGTH_LONG).show();
            }
        }
        if (v.getId()==R.id.btnReturn){
            Intent intent=new Intent(this,MenuActivity.class);
            startActivity(intent);
            finish();
        }
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
            instrumentsNames.clear();
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

    public void OpenGenresList(View view) {
    }
}