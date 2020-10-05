package com.example.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE="MESSAGE";
    private EditText mMessageEditText;
    private TextView mreplyTextView;
    public static final int TEXT_REQUEST=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText=findViewById(R.id.editText_main);
        mreplyTextView=findViewById(R.id.text_reply);
    }

    public void launchSecondActivity(View view) {
        String message=mMessageEditText.getText().toString();

        Intent intent=new Intent (this, secondActivity2.class);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==TEXT_REQUEST){
            if (resultCode==RESULT_OK){
                String reply=data.getStringExtra(secondActivity2.EXTRA_REPLY);
                mreplyTextView.setText(reply);
            }
        }
    }
}