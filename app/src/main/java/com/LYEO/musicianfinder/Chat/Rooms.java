package com.LYEO.musicianfinder.Chat;
/*
 * created by yisrael bar
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.LYEO.musicianfinder.BandSearchScreenActivity;
import com.LYEO.musicianfinder.MenuActivity;
import com.LYEO.musicianfinder.R;

import java.util.ArrayList;
import java.util.List;

public class Rooms extends AppCompatActivity {
    static List<String> chatsList=new ArrayList<>();
    ListView l1;
    public static Context cn1;
    Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        l1=(ListView)findViewById(R.id.l1);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        // go back button
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMenu();
            }
        });


        try {
            cn1=this;
            chatsList.clear();
            sql s=new sql(getApplicationContext(),"yisrael",null,1);

            //put in chat list all the chats from sql
            s.showChatNames();
//            if (chatsList.size()<1){
//                s.AddChatName("test");
//                s.showChatNames();
//            }
            //send the chat list to the adapter to display
            adaptersForNewChat adapter=new adaptersForNewChat(getApplicationContext(),chatsList);
            l1.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void goToMenu(){
        Intent intent=new Intent(this,MenuActivity.class);
        startActivity(intent);
        finish();
    }
}