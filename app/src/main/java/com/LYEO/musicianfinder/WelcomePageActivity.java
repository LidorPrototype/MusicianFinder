package com.LYEO.musicianfinder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    private Button btnLogin, btnSignIn;
    private TextView textView_Headline;
    private String headlineStartColor = "#00FF00", headlineMiddleColor = "#FF0000", headlineEndColor = "#000000";
    private int durationTextColorChange = 6500;
    protected AnimationDrawable animDrawableLogin, animDrawableSignIn;
    protected ValueAnimator anim1, anim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignIn = findViewById(R.id.btnRegister);
        textView_Headline = findViewById(R.id.textView_WelcomeHeadLine);

        Typeface rockIt =Typeface.createFromAsset(getAssets(), "fonts/rock_it.regular.ttf");
        textView_Headline.setTypeface(rockIt);

        // Buttons Animation - START
        animDrawableLogin = (AnimationDrawable) btnLogin.getBackground();
        animDrawableSignIn = (AnimationDrawable) btnSignIn.getBackground();

        animDrawableLogin.setEnterFadeDuration(2500);
        animDrawableSignIn.setEnterFadeDuration(2500);
        animDrawableLogin.setExitFadeDuration(2500);
        animDrawableSignIn.setExitFadeDuration(2500);
        // Buttons Animation - END

        // Headline Animation - START
        final float[] from = new float[3], to =   new float[3];

        Color.colorToHSV(Color.parseColor(headlineStartColor), from);    // from
        Color.colorToHSV(Color.parseColor(headlineMiddleColor), to);     // to

        anim1 = ValueAnimator.ofFloat(0, 1);                             // animate from 0 to 1
        anim1.setDuration(durationTextColorChange);                      // for 8000 ms

        final float[] hsv  = new float[3];                              // transition color
        anim1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            @Override public void onAnimationUpdate(ValueAnimator animation) {
                // Transition along each axis of HSV (hue, saturation, value)
                hsv[0] = from[0] + (to[0] - from[0])*animation.getAnimatedFraction();
                hsv[1] = from[1] + (to[1] - from[1])*animation.getAnimatedFraction();
                hsv[2] = from[2] + (to[2] - from[2])*animation.getAnimatedFraction();

                textView_Headline.setTextColor(Color.HSVToColor(hsv));
            }
        });
        anim1.start();
        anim1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                final float[] from2 = new float[3], to2 =   new float[3];

                Color.colorToHSV(Color.parseColor(headlineMiddleColor), from2);     // from
                Color.colorToHSV(Color.parseColor(headlineEndColor), to2);          // to

                anim2 = ValueAnimator.ofFloat(0, 1);                                 // animate from 0 to 1
                anim2.setDuration(durationTextColorChange - 1500);                          // for 8000 ms

                final float[] hsv2 = new float[3];                                  // transition color
                anim2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
                    @Override public void onAnimationUpdate(ValueAnimator animation) {
                        // Transition along each axis of HSV (hue, saturation, value)
                        hsv2[0] = from2[0] + (to2[0] - from2[0])*animation.getAnimatedFraction();
                        hsv2[1] = from2[1] + (to2[1] - from2[1])*animation.getAnimatedFraction();
                        hsv2[2] = from2[2] + (to2[2] - from2[2])*animation.getAnimatedFraction();

                        textView_Headline.setTextColor(Color.HSVToColor(hsv2));
                    }
                });
                anim2.start();
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }
        });
        // Headline Animation - END




    }

    public  void mainClick (View v){
        if (v.getId()==R.id.btnLogin){
            Intent intent= new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
        }else if (v.getId()==R.id.btnRegister){
            Intent intent= new Intent(getApplicationContext(),Register.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animDrawableLogin != null && !animDrawableLogin.isRunning()){
            animDrawableLogin.start();
        }
        if (animDrawableSignIn != null && !animDrawableSignIn.isRunning()){
            animDrawableSignIn.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animDrawableLogin != null && animDrawableLogin.isRunning()){
            animDrawableLogin.stop();
        }
        if (animDrawableSignIn != null && animDrawableSignIn.isRunning()){
            animDrawableSignIn.stop();
        }
    }

}