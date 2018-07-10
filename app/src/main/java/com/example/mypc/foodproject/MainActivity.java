package com.example.mypc.foodproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    VideoView v1;
    Button btn,btn2,btn3;
    EditText e1,e2;
    AlertDialog.Builder ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v1 = (VideoView) findViewById(R.id.videoView);
        btn = (Button) findViewById(R.id.button3);
        btn2 = (Button) findViewById(R.id.button4);
        btn3 = (Button) findViewById(R.id.button5);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.food_video);

        v1.setVideoURI(uri);
        v1.start();

        v1.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
            @Override
            public void onPrepared(MediaPlayer mp)
            {
                mp.start();
                mp.setLooping(true);
            }
        });

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this,homeActivity.class);
                startActivity(i);
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this,DonarRegistration.class);
                startActivity(i);
                finish();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this,ReceiverRegistration.class);
                startActivity(i);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed()
    {
        ab = new AlertDialog.Builder(MainActivity.this);
        ab.setTitle("Exit");
        ab.setMessage("Do you want to close this app?");
        ab.setIcon(R.drawable.alert);
        ab.setCancelable(false);

        ab.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finishAffinity();
            }
        });

        ab.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });

        ab.show();
    }

}