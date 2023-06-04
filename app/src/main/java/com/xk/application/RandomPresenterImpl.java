package com.xk.application;

import android.app.Activity;
import android.content.Context;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RandomPresenterImpl implements RandomPresenter {

    private RandomView view;

    private ArrayList<RandomItem> dataList;
    private Timer timer;
    private Context context;

    public RandomPresenterImpl(Context context, RandomView view) {
        this.view = view;
        dataList = new ArrayList<>();
    }

    @Override
    public ArrayList<RandomItem> getData() {
        return dataList;
    }

    @Override
    public void generateRandom(String seed, String range) {

        int seedNum = seed.isEmpty() ? (int) (Math.random() * 10000) : Integer.parseInt(seed);
        int rangeNum = range.isEmpty() ? 10 : Integer.parseInt(range);
        Random rand = new Random(seedNum);
        int randomNum = rand.nextInt(rangeNum) + 1;

        long timestamp = System.currentTimeMillis();final SecureRandom secureRandom = new SecureRandom();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long seed = System.currentTimeMillis();
                final int random1 = secureRandom.nextInt(2) + 1;
                final int random2 = secureRandom.nextInt(2) + 3;
                ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String text = "时间戳：" + seed + "\n1或2的随机数：" + random1 + "\n3或4的随机数：" + random2;
                        //textView.setText(text);
                        // saveRecord(seed, random1, random2);
                    }
                });
            }
        }, 0, 60000);
        RandomItem item = new RandomItem(seedNum, rangeNum, randomNum, timestamp);
        dataList.add(item);

        view.onGenerateRandom(seedNum, rangeNum);
        view.onSaveRandom(dataList);
    }

}
