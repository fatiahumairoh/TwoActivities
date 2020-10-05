package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity2 extends AppCompatActivity {

    public static final String EXTRA_REPLY="REPLY";
    private EditText mreply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        mreply=findViewById(R.id.editText_second);


        Intent intent=getIntent();
        if (intent.hasExtra(MainActivity.EXTRA_MESSAGE)){
            String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            TextView textView=findViewById(R.id.text_message);
            textView.setText(message);
        }
    }

    public void returnReply(View view) {
       String reply=mreply.getText().toString();
       Intent replyintent=new Intent();
       replyintent.putExtra(EXTRA_REPLY, reply);
       setResult(RESULT_OK,replyintent);
       finish();
    }
}