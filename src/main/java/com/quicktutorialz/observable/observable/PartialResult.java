package com.quicktutorialz.observable.observable;

class PartialResult {
    Object result;

    protected Object get() {
        return result;
    }

    protected void setResult(Object result) {
        this.result = result;
    }
}
