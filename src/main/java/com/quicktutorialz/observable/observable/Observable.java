package com.quicktutorialz.observable.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Observable {

    private Supplier supplier;
    private List<Function> mapList = new ArrayList<>();

    public Observable just(Supplier supplier){
        this.supplier = supplier;
        return this;
    }

    public void subscribe(Consumer onFinish){
        onFinish.accept(getResult());
    }

    public void subscribe(Consumer onFinish, Consumer onError){
        try{
            onFinish.accept(getResult());
        }catch(Exception e){
            onError.accept(e);
        }
    }

    public Observable map(Function function){
        mapList.add(function);
        return this;
    }


    private Object getResult(){
        Object result = supplier.get();
        for(Function f : mapList){
            result = f.apply(result);
            if(result instanceof Observable){
                PartialResult partial = new PartialResult();
                ((Observable) result).subscribe(res -> partial.setResult(res));
                result = partial.getResult();
            }
        }
        return result;
    }

    class PartialResult {
        Object result;

        public Object getResult() {
            return result;
        }

        public void setResult(Object result) {
            this.result = result;
        }
    }

}
