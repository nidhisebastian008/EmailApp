package com.example.nidhi.emailapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etTo,etSubject,etMessage;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTo=(EditText) findViewById(R.id.editTextTo);
        etSubject=(EditText) findViewById(R.id.editTextSubject);
        etMessage=(EditText) findViewById(R.id.editTextMessage);
        btnSend=(Button) findViewById(R.id.buttonSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });


    }
    public void send(){
        String[] to = {etTo.getText().toString()} ;
        String subject = etSubject.getText().toString() ;
        String message = etMessage.getText().toString() ;

        Intent emailIntent = new Intent(Intent.ACTION_SEND) ;
        emailIntent.setData(Uri.parse("mailto:")) ;
        emailIntent.setType("text/plain") ;
        emailIntent.putExtra(Intent.EXTRA_EMAIL , to) ;
        emailIntent.putExtra(Intent.EXTRA_SUBJECT , subject) ;
        emailIntent.putExtra(Intent.EXTRA_TEXT , message) ;
        startActivity(emailIntent);

    }
}
