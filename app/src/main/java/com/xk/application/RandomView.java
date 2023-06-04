package com.xk.application;

import java.util.ArrayList;

public interface RandomView {

    void onGenerateRandom(int seed, int range);

    void onSaveRandom(ArrayList<RandomItem> randomList);

        void onQueryRandom(ArrayList<RandomItem> dataList);
        void onShowQueryDialog();
        void onDismissQueryDialog();


}
