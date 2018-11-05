package com.quicktutorialz.observable;

import com.quicktutorialz.observable.observable.Observable;

public class MainApplication {

    public static void main(String[] args){
        String text = "This is a nice text to be processed reactively";
        //new Observable().just(() -> processText(text)).subscribe(obj -> System.out.println(obj));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        new Observable().just(() -> processText(text))
                        .map(t -> processText((String) t))
                        .map(t -> processText((String) t))
                        .map(t -> processTextObs((String) t))
                        .map(t -> processText((String) t))
                        .subscribe(result -> System.out.println(result));

    }

    private static String processText(String text){
        return text + " and you must believe it! ";
    }

    private static Observable processTextObs(String text){
        return new Observable().just(() -> text + "YOU MUST BELIEVE IT! ");
    }
}
