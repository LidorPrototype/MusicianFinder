package com.LYEO.musicianfinder.Chat;
/*
 * created by yisrael bar
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.LYEO.musicianfinder.Login;
import com.LYEO.musicianfinder.R;

import java.util.List;

public class Adapter extends ArrayAdapter<Message> {
    TextView tv1,tv2,tv3;


    public Adapter(@NonNull Context context, @NonNull List<Message> objects) {
        super(context, 0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View myView= LayoutInflater.from(getContext()).inflate(R.layout.activity_adapter,parent,false);
        tv1=(TextView)myView.findViewById(R.id.tv1);
        tv2=(TextView)myView.findViewById(R.id.tv2);
        tv3=(TextView)myView.findViewById(R.id.tv3);
        Message pd1=getItem(position);

        if (pd1.getSelf_name().equals(Login.u1.getUserName())){
            tv1.setBackgroundColor(Color.GRAY);
            tv1.setTextColor(Color.BLACK);
            tv2.setBackgroundColor(Color.GRAY);
            tv2.setTextColor(Color.BLACK);
            tv3.setBackgroundColor(Color.GRAY);
            tv3.setTextColor(Color.BLACK);
            tv3.setTextSize(10);
            tv1.setText("name: "+pd1.getSelf_name());
            tv2.setText("message: "+pd1.getMesseage());
            tv3.setText(pd1.getDate());
        }else {
            tv1.setBackgroundColor(Color.CYAN);
            tv1.setTextColor(Color.BLACK);
            tv2.setBackgroundColor(Color.CYAN);
            tv2.setTextColor(Color.BLACK);
            tv3.setBackgroundColor(Color.CYAN);
            tv3.setTextColor(Color.BLACK);
            tv3.setTextSize(12);
            tv1.setText("name: "+pd1.getSelf_name());
            tv2.setText("message: "+pd1.getMesseage());
            tv3.setText(pd1.getDate());
        }
        return myView;
    }
}
