package com.example.user.youtubedownloadvideo;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.apache.http.client.HttpClient;

import com.google.android.youtube.player.YouTubePlayerView;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import  com.google.android.youtube.player.YouTubePlayerSupportFragment;
import android.app.Activity;
import  android.view.View;

import java.net.URL;


public class Main2Activity extends YouTubeBaseActivity {
    public static final String API_Key = "AIzaSyBmUQ9j-7i5jz9gKwF_aLjIkuoGJeSUqiI";
    ProgressDialog pogressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final MainActivity Main = new MainActivity();
        YouTubePlayerView youTubePlayerView =
                (YouTubePlayerView) findViewById(R.id.youtube_player);


        youTubePlayerView.initialize(API_Key,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {


                        youTubePlayer.cueVideo(Main.Video_Id);
                        

                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }

                    public static YouTubePlayerSupportFragment newInstance();
                });

        Button geri = (Button) findViewById(R.id.geri);
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        Button btnYukle =(Button) findViewById( R.id.Yukle );
        btnYukle.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pogressDialog = new ProgressDialog(Main2Activity.this);
                pogressDialog.setMessage("Yuklenir..."); // Setting Message
                pogressDialog.setTitle("Gozleyin..."); // Setting Title
                pogressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                pogressDialog.show(); // Display Progress Dialog
                pogressDialog.setCancelable(false);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(10000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        pogressDialog.dismiss();
                    }
                }).start();
/*                startActivity(new Intent(Main2Activity.this, Main3Activity.class));*/

                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                        startActivity(intent);
                    }
                },3000);
            }
        } );




    }







};

