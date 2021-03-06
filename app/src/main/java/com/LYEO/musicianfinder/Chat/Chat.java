package com.LYEO.musicianfinder.Chat;
/*
 * created by yisrael bar
 */
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.LYEO.musicianfinder.FireBase;
import com.LYEO.musicianfinder.Login;
import com.LYEO.musicianfinder.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {

    public static ListView l1;
    EditText eText;
    ImageButton btnReturn;
    Message m;
    List<Message> messageList=new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 ;
    String other_name = "";
    private TextView nameRecipient;
    private TextView textViewHeadline;
    private Adapter adapter;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, Rooms.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        l1 = (ListView)findViewById(R.id.l1);
        eText = (EditText)findViewById(R.id.edText);
        btnReturn = findViewById(R.id.image_btnReturn);
        nameRecipient = findViewById(R.id.textView_UserNameRecipient);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMenu();
            }
        });
        try {
            Bundle bndl = getIntent().getExtras();
            other_name = bndl.getString("other_name");
            nameRecipient.setText(other_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        myRef1 = database.getReference("rooms").child(Login.u1.getUserName()).child(other_name);

        l1.setDividerHeight(0);

        //listen to upcoming messages
        onChild();

        //write message to firebase
        findViewById(R.id.img_btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSend = eText.getText().toString();
                eText.setText("");
                m = new Message( Login.u1.getUserName(), other_name, toSend);
                FireBase fb1 = new FireBase();
                fb1.sendMessageToFb(m);

                //close virtual keyboard
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
        Typeface typefaceHeadlineChat = Typeface.createFromAsset(getAssets(), "fonts/epilogue.regular.ttf");
        nameRecipient.setTypeface(typefaceHeadlineChat);

    }

    private void onChild() {
        myRef1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                try {
                    aFor(dataSnapshot);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                try {
                    aFor(dataSnapshot);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void aFor(DataSnapshot dataSnapshot) {
        messageList.clear();
        for (DataSnapshot ds1:dataSnapshot.getChildren())    {
            Message m1 = ds1.getValue(Message.class);
            messageList.add(m1);
            adapter = new Adapter(getApplicationContext(),messageList);
            l1.setAdapter(adapter);

            l1.post(new Runnable() {
                @Override
                public void run() {
                    l1.setSelection(adapter.getCount() - 1);
                }
            });
        }
    }

    private void goToMenu(){
        onBackPressed();
    }
}