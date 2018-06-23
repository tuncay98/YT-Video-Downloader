package com.example.user.youtubedownloadvideo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main3Activity extends AppCompatActivity {

    String LinkDownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main3 );




        WebView Wv = (WebView) findViewById( R.id.View );
        Wv.getSettings().setJavaScriptEnabled( true );

        Wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                    // open in Webview
                                    if (url.contains("android_asset") ){
                                        // Can be clever about it like so where myshost is defined in your strings file
                                        // if (Uri.parse(url).getHost().equals(getString(R.string.myhost)))
                                        return false;
                                    }
                                    // open rest of URLS in default browser
                                    Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(url));
                                    startActivity(intent);
                                    return true;
                                }
            @Override
            public void onPageFinished(WebView view, String url)
            {
/*
                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByClassName('navbar')[0].style.display='none'; " +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                    "document.getElementsByClassName('download-type')[0].style.display='none'; " +
                    "})()");
                view.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('download-type')[1].style.display='none'; " +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByClassName('downloadInstruction')[0].style.display='none'; " +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByClassName('downloadInstruction')[1].style.display='none'; " +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByTagName('footer')[0].style.display='none'; " +
                        "})()");
*/


                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementById('audio-streams').children[0].style.display='none' " +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head= document.getElementsByTagName('h5')[8].style.display='none';" +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head= document.getElementsByTagName('h5')[6].innerHTML='Musiqi';" +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head= document.getElementsByTagName('h5')[7].innerHTML='Video';" +
                        "})()");




                view.loadUrl("javascript:(function() { " +
                        "var head= document.getElementsByClassName('modal-header')[4].style.display='none';" +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByTagName('nav')[0].style.display='none'; " +
                        "})()");

                view.loadUrl("javascript:(function() { " +
                        "var head= document.getElementsByClassName('container-fluid')[0]; head.parentNode.removeChild(head); " +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementById('warning').style.display='none'; " +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementById('hooking').style.display='none'; " +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementById('downloadModal').classList.remove('modal', 'fade'); " +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementById('downloadModal').classList.add('table'); " +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementById('faqModal').style.display='none'; " +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementById('changelogModal').style.display='none'; " +
                        "})()");
                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementById('contactModal').style.display='none'; " +
                        "})()");

                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementById('converters').style.display='none'; " +
                        "})()");

            }





        }
        );






        Wv.loadUrl("https://hooktube.com/watch?v=" + MainActivity.Video_Id );


    }


}






/*



*/



