package com.LYEO.musicianfinder.Posts;/*
 * created by yisrael bar
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.LYEO.musicianfinder.Chat.Rooms;
import com.LYEO.musicianfinder.Chat.sql;
import com.LYEO.musicianfinder.R;
import com.LYEO.musicianfinder.WelcomePageActivity;

import java.util.List;

public class AdapterPosts extends ArrayAdapter<Post> {
    private TextView tv0,tv1,tv2,tv3,tv4;
    private Button btnAdapterPost;
    private LinearLayout linearLayoutGenre;
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
        tv4=(TextView)myView.findViewById(R.id.tv4);
        linearLayoutGenre = myView.findViewById(R.id.linearLayout_Genre);
        btnAdapterPost = (Button)myView.findViewById(R.id.btAdapterPosts);

        Post pd1=getItem(position);
        tv0.setText(pd1.getUserName());
        btnAdapterPost.setText(pd1.getUserName());
        tv1.setText(pd1.getLocation());
        tv2.setText(pd1.getInstrument());
        tv3.setText(pd1.getContent());
        tv4.setText(pd1.getGenre());
        if (pd1.getGenre().equals(""))
            linearLayoutGenre.setVisibility(View.GONE);

        myView.findViewById(R.id.btAdapterPosts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //need to change to text view
                Button btn1 = (Button) v;     // Irrelevant b/c of new UI
                String user_name = btn1.getText().toString();
                try{
//                    Log.d("yisrael", "yaa "+user_name);
                    if(DisplayPosts.cn1 != null){
                        sql s = new sql(DisplayPosts.cn1,"yisrael",null,1);
                        if (!s.searchUserIfExist(user_name))
                            s.AddChatName(user_name);

                        Intent intent = new Intent(DisplayPosts.cn1, Rooms.class);
                        DisplayPosts.cn1.startActivity(intent);
                        DisplayPosts.act.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);;
                        DisplayPosts.act.finish();
                    }else{
                        sql s = new sql(WelcomePageActivity.cn1,"yisrael",null,1);
                        if (!s.searchUserIfExist(user_name))
                            s.AddChatName(user_name);

                        Intent intent = new Intent(WelcomePageActivity.cn1, Rooms.class);
                        WelcomePageActivity.cn1.startActivity(intent);
                        WelcomePageActivity.actW.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);;
                    }

                }catch (Exception e){
//                    Log.d("yisrael", "yaa "+e);
                    e.printStackTrace();
                }

            }
        });
        return myView;
    }
}
