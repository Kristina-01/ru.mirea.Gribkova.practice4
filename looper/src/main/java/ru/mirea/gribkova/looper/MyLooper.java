package ru.mirea.gribkova.looper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.concurrent.ThreadLocalRandom;

public class MyLooper extends Thread{
    private int number = 0;
    Handler handler;
    int ts = ThreadLocalRandom.current().nextInt(1,100);

    public void run(){
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler(){
            public void handleMessage(Message msg) {
                ts =ThreadLocalRandom.current().nextInt(1,100);
                int myage = msg.getData().getInt("AGE");
                String mywork = msg.getData().getString("OCC");
                try{
                    Thread.sleep(myage);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                Log.d("MyLooper", "age" + ": "+myage);
                Log.d("MyLooper", "Work" + ": " +mywork);
                number++;
            }
        };
        Looper.loop();
    }

}

