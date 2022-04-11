package ru.mirea.gribkova.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    MyLooper ml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ml= new MyLooper();
        ml.start();
    }

    public void OnClick(View view){
        Message msg = new Message();
        Bundle bundle= new Bundle();
        bundle.putString("KEY", "mirea");
        bundle.putString("OCC","student");

        bundle.putInt("AGE", ml.ts);

        try{
            Thread.sleep(ml.ts);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        msg.setData(bundle);
        if(ml != null){
            ml.handler.sendMessage(msg);
        }
    }
}