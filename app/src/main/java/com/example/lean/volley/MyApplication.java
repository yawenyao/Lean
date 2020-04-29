package com.example.lean.volley;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyApplication extends Application {


    public MyApplication() {
    }

    public static RequestQueue queues;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        queues = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getHttpQueues() {
        return queues;
    }


}
