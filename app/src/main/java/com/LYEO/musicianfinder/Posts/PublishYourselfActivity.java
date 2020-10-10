package com.LYEO.musicianfinder.Posts;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
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

import java.util.ArrayList;

public class PublishYourselfActivity extends AppCompatActivity{

    private RadioGroup radioGroup;
    private RadioButton rbBand, rbMusician;
    private EditText edContent;
    private AutoCompleteTextView actvPlayLocation, actvInstrument, actvGenre;
    private TextView textView_PublishYourselfHeadline;
    private ArrayList<String> cities, instruments, genres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_yourself);

        radioGroup =(RadioGroup)findViewById(R.id.radioGroup);
        rbMusician = (RadioButton) findViewById(R.id.rb_musician);
        rbBand = (RadioButton) findViewById(R.id.rb_band);
        actvPlayLocation = findViewById(R.id.actvPlayLocation);
        actvInstrument = findViewById(R.id.actvInstruments);
        actvGenre = findViewById(R.id.actvGenres);
        edContent = (EditText)findViewById(R.id.edContent);
        textView_PublishYourselfHeadline = findViewById(R.id.publish_post_headline);
        //
        Login.cn1 = getApplicationContext();

        Configuration configurationObj = new Configuration();

        int h = configurationObj.getHeight();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(10, h, 10, h);
        findViewById(R.id.LinearLayout_PublishPost).setLayoutParams(layoutParams);

        Typeface typefaceHeadlinePrivateArea = Typeface.createFromAsset(getAssets(), "fonts/epilogue.regular.ttf");
        textView_PublishYourselfHeadline.setTypeface(typefaceHeadlinePrivateArea);

        rbMusician.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                actvGenre.setVisibility(View.VISIBLE);
            }
        });

        rbBand.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                actvGenre.setVisibility(View.GONE);
            }
        });

        // Activity Area
        cities = configurationObj.getCities();
        final ArrayAdapter<String> adapterCities = new ArrayAdapter<String>(this,
                R.layout.cities_items, R.id.text_city_name, cities);
        actvPlayLocation.setAdapter(adapterCities);
        // Instruments
        instruments = configurationObj.getInstrumentsArray();
        final ArrayAdapter<String> adapterInstruments = new ArrayAdapter<String>(this,
                R.layout.cities_items, R.id.text_city_name, instruments);
        actvInstrument.setAdapter(adapterInstruments);
        // Genres
        genres = configurationObj.getGenresArrayList();
        final ArrayAdapter<String> adapterGenres = new ArrayAdapter<String>(this,
                R.layout.cities_items, R.id.text_city_name, genres);
        actvGenre.setAdapter(adapterGenres);

    }

    public  void mainClick (View v){
        if (v.getId()== R.id.btnPublish){
            try {
                boolean itIsABand = rbBand.isChecked();
                String playLocation = "", content = "", instrument = "", genre = "";
                playLocation = actvPlayLocation.getText().toString();
                content =  edContent.getText().toString();
                instrument = actvInstrument.getText().toString();
                genre = actvGenre.getText().toString();
                Post p1 = new Post(Login.userName, content, playLocation, instrument, itIsABand,genre);
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