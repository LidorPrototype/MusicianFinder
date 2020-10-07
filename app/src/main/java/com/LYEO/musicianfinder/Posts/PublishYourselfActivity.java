package com.LYEO.musicianfinder.Posts;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.LYEO.musicianfinder.FireBase;
import com.LYEO.musicianfinder.Login;
import com.LYEO.musicianfinder.MenuActivity;
import com.LYEO.musicianfinder.Posts.Post;
import com.LYEO.musicianfinder.R;

public class PublishYourselfActivity extends AppCompatActivity{
    RadioGroup radioGroup;
    RadioButton rbBand, rbSingle;
    EditText edPlayLocation, edInstrument, edContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_yourself);

        radioGroup =(RadioGroup)findViewById(R.id.radioGroup);
        rbBand = (RadioButton) findViewById(R.id.band);
        rbSingle = (RadioButton) findViewById(R.id.single);
        edPlayLocation = (EditText)findViewById(R.id.edPlayLocation);
        edInstrument = (EditText)findViewById(R.id.edInstrument);
        edContent = (EditText)findViewById(R.id.edContent);

    }



    public  void mainClick (View v){
        if (v.getId()== R.id.btnPublish){
            try {
                boolean itIsABand = rbBand.isChecked();
                String playLocation = "", content = "", instrument = "";
                playLocation = edPlayLocation.getText().toString();
                content =  edContent.getText().toString();
                instrument = edInstrument.getText().toString();
                Post p1 = new Post(Login.userName, content, playLocation, instrument, itIsABand);
                FireBase fb1 = new FireBase();
                fb1.sendPostToFb(p1);
                Toast.makeText(this,"post been published",Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Log.d("yisrael", "PublishYourselfActivity " + e);
            }
        }else if (v.getId()== R.id.btnReturn){
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            finish();
        }
    }


}