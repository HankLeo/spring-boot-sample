package com.hank.sample.spring.model;

/**
 * Created by Hank on 12/4/2017.
 */
public class Hello {

    private final long id;
    private final String content;

    public Hello(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
