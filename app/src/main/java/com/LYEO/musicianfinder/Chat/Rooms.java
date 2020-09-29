package com.LYEO.musicianfinder.Chat;
/*
 * created by yisrael bar
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.LYEO.musicianfinder.R;

import java.util.ArrayList;
import java.util.List;

public class Rooms extends AppCompatActivity {
    static List<String> chatsList=new ArrayList<>();
    ListView l1;
    static Context cn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        l1=(ListView)findViewById(R.id.l1);
        try {
            cn1=this;

            chatsList.clear();
            sql s=new sql(getApplicationContext(),"yisrael",null,1);
            s.AddChatName("tal");
//            s.AddChatName("lidor");
//            s.AddChatName("or");
//            s.AddChatName("eli");
            s.showChatNames();

            adaptersForNewChat adapter=new adaptersForNewChat(getApplicationContext(),chatsList);
            l1.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}