package com.quicktutorialz.observable;

import com.quicktutorialz.observable.observable.Flowable;
import com.quicktutorialz.observable.observable.Observable;
import java.util.Arrays;
import java.util.List;

public class MainApplication {

    public static void main(String[] args){
        String text = "This is a nice text to be processed reactively";

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        new Observable().just(() -> processText(text))
                        .map(t -> processText((String) t))
                        .map(t -> processText((String) t))
                        .map(t -> processTextObs((String) t))
                        .map(t -> processText((String) t))
                        .subscribeAsync(result -> System.out.println(result));


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        new Flowable().just(() -> processText(text))
                .map(t -> processText((String) t))
                .map(t -> processText((String) t))
                .map(t -> processTextObs((String) t))
                .map(t -> processText((String) t))
                .subscribeAsync(result -> System.out.println(result));


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        new Flowable().just(() -> getWords())
                .map(w -> capitalize((String) w))
                .map(w -> addNumbers((String) w))
                .map(w -> addStella((String) w))
                .subscribeAsync(result -> System.out.println(result),
                           error  -> System.out.println(error),
                           () -> System.out.println("Completed")
                );

    }

    private static String processText(String text){
        for(int i=1; i<=10; i++){
            text = text + " " + i + " ";
        }
        return text + " and you must believe it! ";
    }

    private static Observable processTextObs(String text){
        return new Observable().just(() -> text + "YOU MUST BELIEVE IT! ");
    }

    /* ---------------- */

    private static List getWords(){
        return Arrays.asList(
                "Andrea",
                "Francesca",
                "Lucio",
                "Mariella",
                "Maribella"
        );
    }

    private static String capitalize(String word){
        return word.toUpperCase();
    }

    private static Observable addNumbers(String word){
        return new Observable().just(() -> word + " 1 2 3").map(w -> w+" Urca");
    }

    private static String addStella(String word){
        return word + " Stella! ";
    }



}
