package com.LYEO.musicianfinder.Chat;
/*
 * created by yisrael bar
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.LYEO.musicianfinder.Configuration;
import com.LYEO.musicianfinder.MenuActivity;
import com.LYEO.musicianfinder.R;

import java.util.ArrayList;
import java.util.List;

public class Rooms extends AppCompatActivity {

    private TextView textViewChatHeadline;
    private LinearLayout linearLayoutListAndButton;
    public static List<String> chatsList = new ArrayList<>();
    private ListView l1;
    public static Context cn1;
    private Button btnReturn;
    public static Activity act;
    private static sql s;
    private static adaptersForNewChat adapter;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        linearLayoutListAndButton = findViewById(R.id.linearLayout_list_n_btn);
        l1 = findViewById(R.id.l1);
        btnReturn = findViewById(R.id.btnReturn);
        textViewChatHeadline = findViewById(R.id.textView_ChatHeadline);

        l1.setDividerHeight(0);

        Configuration configurationObj = new Configuration();
        int h = configurationObj.getHeight();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(30, 20, 30, h);
        linearLayoutListAndButton.setLayoutParams(layoutParams);

        // go back button
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMenu();
            }
        });

        Typeface typefaceHeadlineChatsRoom = Typeface.createFromAsset(getAssets(), "fonts/epilogue.regular.ttf");
        textViewChatHeadline.setTypeface(typefaceHeadlineChatsRoom);

        try {
            cn1 = this;
            act = this;
            chatsList.clear();
            s = new sql(getApplicationContext(),"yisrael",null,1);

            //put in chat list all the chats from sql
            s.showChatNames();

            //send the chat list to the adapter to display
            adapter = new adaptersForNewChat(getApplicationContext(), chatsList, this);
            l1.setAdapter(adapter);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void adapterNotify(){
        chatsList.clear();
        s.showChatNames();

        adapter.notifyDataSetChanged();
    }

    private void goToMenu(){
        onBackPressed();
    }

}