package com.bagalkotneha.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int oncreate;
    int onstart;
    int onresume;
    int onpause;
    int onstop;
    int onrestart;
    int ondestroy;
    TextView text;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Settings",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("keyName", "newValue");
        //oncreate
        oncreate = sharedPreferences.getInt("oncreate", 0);
        oncreate+=1;
        editor.putInt("oncreate", oncreate);
        editor.apply();
        text = findViewById(R.id.oncreate);
        text.setText("OnCreate: " + oncreate);
        //onstart
        onstart = sharedPreferences.getInt("onstart", 0);
        text1 = findViewById(R.id.onstart);
        text1.setText("OnStart: " + onstart);
        //onresume
        onresume = sharedPreferences.getInt("onresume", 0);
        text2 = findViewById(R.id.onresume);
        text2.setText("OnResume: " + onresume);
        //onpause
        onpause = sharedPreferences.getInt("onpause", 0);
        text3 = findViewById(R.id.onpause);
        text3.setText("OnPause: " + onpause);
        //onstop
        onstop = sharedPreferences.getInt("onstop", 0);
        text4 = findViewById(R.id.onstop);
        text4.setText("OnStop: " + onstop);
        //onrestart
        onrestart = sharedPreferences.getInt("onrestart", 0);
        text5 = findViewById(R.id.onrestart);
        text5.setText("OnRestart: " + onrestart);
        //ondestroy
        ondestroy = sharedPreferences.getInt("ondestroy", 0);
        text6 = findViewById(R.id.ondestroy);
        text6.setText("OnDestroy: " + ondestroy);
        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            private Activity activity;
            @Nullable
            private Bundle savedInstanceState;
            @Override public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }
            @Override public void onActivityStarted(Activity activity) {
                onstart = sharedPreferences.getInt("onstart", 0);
                onstart++;
                editor.putInt("onstart", onstart);
                editor.apply();
                text1.setText("OnStart: " + onstart);
            }
            @Override public void onActivityResumed(Activity activity) {
                onresume = sharedPreferences.getInt("onresume", 0);
                onresume+=1;
                editor.putInt("onresume", onresume);
                editor.apply();
                text2.setText("OnResume: " + onresume);
            }

            @Override public void onActivityPaused(Activity activity) {
                onpause = sharedPreferences.getInt("onpause", 0);
                onpause+=1;
                editor.putInt("onpause", onpause);
                editor.apply();
                text3.setText("OnPause: " + onpause);
            }

            @Override public void onActivityStopped(Activity activity) {
                onstop = sharedPreferences.getInt("onstop", 0);
                onstop+=1;
                editor.putInt("onstop", onstop);
                editor.apply();
                text4.setText("OnStop: " + onstop);
            }

            @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override public void onActivityDestroyed(Activity activity) {
                ondestroy = sharedPreferences.getInt("ondestroy", 0);
                ondestroy++;
                editor.putInt("ondestroy", ondestroy);
                editor.apply();
                text6.setText("OnDestroy: " + ondestroy);
            }
        });
    }

    @Override
    protected void onRestart() {
        onrestart = sharedPreferences.getInt("onrestart", 0);
        onrestart+=1;
        editor.putInt("onrestart", onrestart);
        editor.apply();
        TextView text = findViewById(R.id.onrestart);
        text.setText("OnRestart: " + onrestart);
        super.onRestart();
    }
}
