package com.library.utils;

public class BrowserUtility {

    public static void wait(int senconds){
        try {
            Thread.sleep(senconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
