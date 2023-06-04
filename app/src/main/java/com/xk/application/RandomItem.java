package com.xk.application;

public class RandomItem {

    private int seed;
    private int range;
    private int random;
    private long timestamp;

    public RandomItem(int seed, int range, int random, long timestamp) {
        this.seed = seed;
        this.range = range;
        this.random = random;
        this.timestamp = timestamp;
    }

    public int getSeed() {
        return seed;
    }

    public int getRange() {
        return range;
    }

    public int getRandom() {
        return random;
    }

    public long getTimestamp() {
        return timestamp;
    }

}
