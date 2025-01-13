package com.kj.排序;

public class SleepSort {
    public static void main(String[] args) {
        int[] ints = {1, 4, 7, 3, 8, 9, 2, 6, 5};
        sleep(ints);
    }

    private static void sleep(int[] ints) {
        SortThread[] sortThreads = new SortThread[ints.length];
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i] = new SortThread(ints[i]);
        }
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i].start();
        }
    }
}

class SortThread extends Thread {
    int ms;

    public SortThread(int ms) {
        this.ms = ms;
    }

    public void run() {
        try {
            sleep(ms * 10L + 1000);
        } catch (InterruptedException ignore) {
        }
        System.out.println(ms);
    }
}