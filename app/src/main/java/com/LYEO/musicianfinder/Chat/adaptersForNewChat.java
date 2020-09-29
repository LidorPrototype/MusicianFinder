package com.LYEO.musicianfinder.Chat;/*
 * created by yisrael bar
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.LYEO.musicianfinder.R;

import java.util.List;

public class adaptersForNewChat  extends ArrayAdapter<String> {
    Button bt1;
    String pd1;
    public adaptersForNewChat(@NonNull Context context, @NonNull List<String> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View myView= LayoutInflater.from(getContext()).inflate(R.layout.activity_adapters_for_new_chat,parent,false);

        bt1=(Button)myView.findViewById(R.id.btAdapter);
        pd1=getItem(position);
        bt1.setText(pd1);
//        myView.findViewById(R.id.btAdapter).setText(getItem(position));
        myView.findViewById(R.id.btAdapter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn1 = (Button)v;
                String other_name=btn1.getText().toString();
                Intent intent = new Intent(Rooms.cn1,Chat.class);
                intent.putExtra("other_name",other_name);
                Rooms.cn1.startActivity(intent);
            }
        });
        return myView;
    }

}
