package com.quicktutorialz.observable;

import com.quicktutorialz.observable.observable.Observable;

public class MainApplication {

    public static void main(String[] args){
        String text = "This is a nice text to be processed reactively";
        new Observable().just(() -> processText(text)).subscribe(obj -> System.out.println(obj));
    }

    private static String processText(String text){
        return text + " and you must believe it! ";
    }
}
