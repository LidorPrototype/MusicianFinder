package com.LYEO.musicianfinder.Chat;
/*
 * created by yisrael bar
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.LYEO.musicianfinder.Login;
import com.LYEO.musicianfinder.R;

import java.util.List;

public class Adapter extends ArrayAdapter<Message> {

    // All the variables:
    private TextView tv1,tv2,tv3;
    private LinearLayout linearLayoutChat;

    public Adapter(@NonNull Context context, @NonNull List<Message> objects) {
        super(context, 0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View myView = LayoutInflater.from(getContext()).inflate(R.layout.activity_adapter,parent,false);

        tv2 = myView.findViewById(R.id.tv2);
        tv3 = myView.findViewById(R.id.tv3);
        linearLayoutChat = myView.findViewById(R.id.linearLayout_ChatSelf);

        Message pd1 = getItem(position);

        if(pd1.getSelf_name().equals(Login.u1.getUserName())){
            tv2.setBackgroundResource(R.drawable.chat_me_background);
            linearLayoutChat.setTextDirection(View.TEXT_DIRECTION_RTL);
            linearLayoutChat.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
//                tv3.setText(pd1.getDate());
        }else {
            tv2.setBackgroundResource(R.drawable.chat_resipient_background);
            linearLayoutChat.setTextDirection(View.TEXT_DIRECTION_LTR);
            linearLayoutChat.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
//                tv3.setText(pd1.getDate());
        }

        tv2.setText(pd1.getMesseage());

        return myView;
    }
}
