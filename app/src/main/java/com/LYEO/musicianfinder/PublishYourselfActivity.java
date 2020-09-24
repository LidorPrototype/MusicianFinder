package com.LYEO.musicianfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PublishYourselfActivity extends AppCompatActivity{
    private Button ToBand;
    private Button ToMusician;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_yourself);
        ToBand=(Button) findViewById(R.id.band);
        ToMusician=(Button) findViewById(R.id.single);

        ToBand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBand();
            }
        });
        ToMusician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMusician();
            }
        });
}

    public void openBand(){
        intent=new Intent(this,Publish_Band.class);
        startActivity(intent);
    }
    public void openMusician(){
        intent=new Intent(this,Publish_Musician.class);
        startActivity(intent);
    }

}