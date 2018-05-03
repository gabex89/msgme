package com.smoothspark.msgme.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by SmoothSpark on 2018. 05. 03.
 */
@Entity(nameInDb = "messages")
public class Message {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "message")
    private String message;

    @Keep
    public Message(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    @Keep
    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
