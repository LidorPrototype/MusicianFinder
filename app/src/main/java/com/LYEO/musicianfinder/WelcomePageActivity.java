package com.LYEO.musicianfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Lidor on 9/25/2020.
 * Developer name: L-ES
 *  _        _   _____     ____    ______
 * | |      |_| |  __ \   / __ \  |  O   |
 * | |      | | | |  | | | |  | | |   ___/
 * | |____  | | | |__| | | |__| | | | \
 * |______| |_| |_____/   \____/  |_|__\
 *  ____         ____
 * |  __|       |  __|
 * |  __|   _   |__  |
 * |____|  |_|  |____|
 */

public class WelcomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

    }
    public  void mainClick (View v){
        if (v.getId()==R.id.btnLogin){
            Intent intent= new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.btnRegister){
            Intent intent= new Intent(getApplicationContext(),Register.class);
            startActivity(intent);
        }

    }
}