package com.LYEO.musicianfinder.Chat;/*
 * created by yisrael bar
 */


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.LYEO.musicianfinder.FireBase;
import com.LYEO.musicianfinder.R;

import java.util.List;

public class adaptersForNewChat  extends ArrayAdapter<String> {

    private Button bt1;
    private String pd1;
    private Activity activity;

    public adaptersForNewChat(@NonNull Context _context, @NonNull List<String> objects, @NonNull Activity _activity) {
        super(_context, 0, objects);
        activity = _activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final View myView= LayoutInflater.from(getContext()).inflate(R.layout.activity_adapters_for_new_chat,parent,false);

        bt1 = (Button)myView.findViewById(R.id.btAdapter);
        pd1 = getItem(position);
        bt1.setText(pd1);

        //delete a chat
        myView.findViewById(R.id.btAdapter).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                try {
                    Button btn1 = (Button)view;
                    String other_name = btn1.getText().toString();
                    FireBase fb1 = new FireBase();
                    sql s=new sql(Rooms.cn1.getApplicationContext(),"yisrael",null,1);
                    fb1.deleteChatFromFb(other_name);
                    s.DELETEChat(other_name);
                    Toast.makeText(Rooms.cn1,other_name + " chat is deleted",Toast.LENGTH_LONG).show();
                    Rooms.adapterNotify();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        //go to another chat
        myView.findViewById(R.id.btAdapter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn1 = (Button)v;
                String other_name = btn1.getText().toString();
                Intent intent = new Intent(Rooms.cn1, Chat.class);
                intent.putExtra("other_name", other_name);
                Rooms.cn1.startActivity(intent);
                Rooms.act.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                Rooms.act.finish();
            }
        });
        return myView;
    }

}
