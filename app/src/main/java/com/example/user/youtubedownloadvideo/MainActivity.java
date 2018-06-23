package com.example.user.youtubedownloadvideo;
import android.app.AlertDialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubePlayerView;

import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import android.app.Activity;
import  android.view.View;
import android.view.Menu;

import java.util.ArrayList;

import static android.app.AlertDialog.*;

public class MainActivity extends AppCompatActivity {

    public  static  String Video_Id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleSendText(intent); // Handle text being sent
            }
        } else {
            // Handle other intents, such as being started from the home screen
        }



        final EditText text = (EditText) findViewById(R.id.editText);

        final Button btn = (Button) findViewById(R.id.button);

        final TextView txtv = (TextView) findViewById( R.id.Alert );

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String VLink = (String) text.getText().toString();
                if(VLink != null && (VLink.contains("youtu") || VLink.contains( "youtube" )) ){

                    Video_Id= VLink.split("/")[3];
                    //text.setText( "", TextView.BufferType.EDITABLE );
                    startActivity(new Intent(MainActivity.this, Main2Activity.class));
                }
                else {
                    Builder alertDialog = new Builder( MainActivity.this );
                    alertDialog.setCancelable( true );
                    alertDialog.setTitle( "Xeberdarliq" );
                    if(VLink.isEmpty()){
                        alertDialog.setMessage( "Bos Buraxmayin" );
                    }else {
                        alertDialog.setMessage( "Daxil etdiyiniz yalniz Youtube linki olmalidir" );
                    }
                    alertDialog.setPositiveButton( "Tamam", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            txtv.setVisibility( View.VISIBLE );
                        }


                    }

                    );
                    alertDialog.show();
                }

            }
        });






    }

    void handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        EditText text = (EditText) findViewById(R.id.editText);
        if (sharedText != null) {
           text.setText( sharedText );
        }
    }


    }



