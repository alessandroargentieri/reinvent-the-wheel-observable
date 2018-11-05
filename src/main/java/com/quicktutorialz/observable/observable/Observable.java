package com.quicktutorialz.observable.observable;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Observable {

    private Supplier supplier;

    public Observable just(Supplier supplier){
        this.supplier = supplier;
        return this;
    }

    public void subscribe(Consumer onFinish){
        onFinish.accept(supplier.get());
    }

    public void subscribe(Consumer onFinish, Consumer onError){
        try{
            onFinish.accept(supplier.get());
        }catch(Exception e){
            onError.accept(e);
        }
    }

}
