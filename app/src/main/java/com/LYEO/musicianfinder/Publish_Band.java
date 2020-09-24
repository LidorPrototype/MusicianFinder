package com.LYEO.musicianfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Publish_Band extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_yourself);

        Spinner spinner =findViewById(R.id.BandOrSingle);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.ChooseBandOrSingle,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
        if(text.equals("Musician")){
            startActivity(new Intent(view.getContext(),Publish_Band.class));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}