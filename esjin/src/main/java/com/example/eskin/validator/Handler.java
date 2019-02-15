package com.example.eskin.validator;

public abstract class Handler {

    protected Handler next;

    public abstract void handleRequest(String value);

    public Handler next() {
        return this.next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }
}
