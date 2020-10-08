package com.LYEO.musicianfinder.Posts;/*
 * created by yisrael bar
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.LYEO.musicianfinder.Chat.Rooms;
import com.LYEO.musicianfinder.Chat.sql;
import com.LYEO.musicianfinder.Login;
import com.LYEO.musicianfinder.R;

import java.util.List;

public class AdapterPosts extends ArrayAdapter<Post> {
    TextView tv0,tv1,tv2,tv3;
    Button btnAdapterPost;
    public AdapterPosts(@NonNull Context context, @NonNull List<Post> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View myView= LayoutInflater.from(getContext()).inflate(R.layout.adapter_posts,parent,false);
        tv0=(TextView)myView.findViewById(R.id.tv0);
        tv1=(TextView)myView.findViewById(R.id.tv1);
        tv2=(TextView)myView.findViewById(R.id.tv2);
        tv3=(TextView)myView.findViewById(R.id.tv3);

        btnAdapterPost = (Button)myView.findViewById(R.id.btAdapterPosts);

        Post pd1=getItem(position);
        tv0.setText(""+ pd1.getUserName());
        tv1.setText("Location: "+ pd1.getLocation());
        tv2.setText("Instrument: "+ pd1.getInstrument());
        tv3.setText("Content: "+ pd1.getContent());
        btnAdapterPost.setText(""+pd1.getUserName());

        myView.findViewById(R.id.btAdapterPosts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //need to change to text view
                Button btn1 = (Button)v;
                String user_name = btn1.getText().toString();
                try{
//                    user_name = tv0.getText().toString();
//                    Log.d("yisrael", "yaa "+user_name);

                    sql s=new sql(DisplayPosts.cn1,"yisrael",null,1);
                    if (!s.searchUserIfExist(user_name))
                    s.AddChatName(user_name);
                }catch (Exception e){
                    Log.d("yisrael", "yaa "+e);
                }
                Intent intent = new Intent(DisplayPosts.cn1, Rooms.class);
//                intent.putExtra("user_name",user_name);
                DisplayPosts.cn1.startActivity(intent);
            }
        });
        return myView;
    }
}