package com.LYEO.musicianfinder.Posts;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.LYEO.musicianfinder.Configuration;
import com.LYEO.musicianfinder.FireBase;
import com.LYEO.musicianfinder.Login;
import com.LYEO.musicianfinder.MenuActivity;
import com.LYEO.musicianfinder.R;

public class PublishYourselfActivity extends AppCompatActivity{

    private RadioGroup radioGroup;
    private RadioButton rbBand, rbSingle;
    private EditText edPlayLocation, edInstrument, edContent;
    private TextView textView_PublishYourselfHeadline;

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
        textView_PublishYourselfHeadline = findViewById(R.id.publish_post_headline);

        Login.cn1 = getApplicationContext();
        Configuration configurationObj = new Configuration();

        int h = configurationObj.getHeight();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(10, h, 10, h);
        findViewById(R.id.LinearLayout_PublishPost).setLayoutParams(layoutParams);

        Typeface typefaceHeadlinePrivateArea = Typeface.createFromAsset(getAssets(), "fonts/epilogue.regular.ttf");
        textView_PublishYourselfHeadline.setTypeface(typefaceHeadlinePrivateArea);

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