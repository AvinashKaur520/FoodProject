package com.example.mypc.foodproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

public class ReceiverRegistration extends AppCompatActivity {


    EditText e1,e2,e3,e4,e5,e6;
    VideoView v1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_registration);

        v1 = (VideoView) findViewById(R.id.videoView);
        e1 = (EditText) findViewById(R.id.edit1);
        e2 = (EditText) findViewById(R.id.edit2);
        e3 = (EditText) findViewById(R.id.edit3);
        e4 = (EditText) findViewById(R.id.edit4);
        e5 = (EditText) findViewById(R.id.edit5);
        e6 = (EditText) findViewById(R.id.edit6);
        btn = (Button) findViewById(R.id.button3);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.food_video);

        v1.setVideoURI(uri);
        v1.start();

        v1.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
            @Override
            public void onPrepared(MediaPlayer mp)
            {
                mp.setLooping(true);
            }
        });

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String id = e1.getText().toString();
                String num = e2.getText().toString();
                String name = e3.getText().toString();
                String lname = e4.getText().toString();
                String pass = e5.getText().toString();
                String add = e6.getText().toString();

                Intent i = new Intent(ReceiverRegistration.this,homeActivity.class);
                startActivity(i);
                finish();

            }
        });
    }

    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(ReceiverRegistration.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
