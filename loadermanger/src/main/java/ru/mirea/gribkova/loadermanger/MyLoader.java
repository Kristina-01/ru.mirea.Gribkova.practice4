package ru.mirea.gribkova.loadermanger;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import java.util.concurrent.ThreadLocalRandom;

public class MyLoader  extends AsyncTaskLoader<String> {
    private String strgiven;
    public static final String ARG_WORD="word";


    public StringBuffer string;
    public String res;
    public int count;
    public int max;


    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null)
            strgiven = args.getString(ARG_WORD);
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @Override
    public String loadInBackground() {

        res="";
        string=new StringBuffer(strgiven);
        max=string.length();

        for (int i=0;i<max;i++){
            count = ThreadLocalRandom.current().nextInt(string.length());
            res=res+string.charAt(count);
            string.deleteCharAt(count);
        }

        return res;
    }


}
