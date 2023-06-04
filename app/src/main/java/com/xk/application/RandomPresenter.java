package com.xk.application;

import java.util.ArrayList;

public interface RandomPresenter {

    ArrayList<RandomItem> getData();

    void generateRandom(String seed, String range);

}
