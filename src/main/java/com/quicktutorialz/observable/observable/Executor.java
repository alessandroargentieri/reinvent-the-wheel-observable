package com.quicktutorialz.observable.observable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

    private static ExecutorService exec;
    public static ExecutorService getExecutor(){
        return (exec!=null) ? exec : Executors.newFixedThreadPool(10);
    }
}
