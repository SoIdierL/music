package com.music.vuemusic.entity;

public class ResponseA<T> {

    boolean success = true;
    T data;
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseA<T> fail(String message) {
        success = false;
        this.message=message;
        return this;
    }
    public ResponseA<T> success(T data) {
        this.data=data;
        return this;
    }

    public ResponseA<T> fail() {
        return fail(null);
    }
}

