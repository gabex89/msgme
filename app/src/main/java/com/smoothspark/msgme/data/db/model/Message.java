package com.smoothspark.msgme.data.db.model;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;

import java.util.Objects;

/**
 * Created by SmoothSpark on 2018. 05. 03.
 */
@Entity(nameInDb = "messages")
public class Message implements Comparable<Message> {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "message")
    private String message;

    @Property(nameInDb = "timestamp")
    private Long timestamp;

    @Keep
    public Message(Long id, String message, Long timestamp) {
        this.id = id;
        this.message = message;
        this.timestamp = timestamp;
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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return Objects.equals(id, message1.id) &&
                Objects.equals(message, message1.message) &&
                Objects.equals(timestamp, message1.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, timestamp);
    }

    @Override
    public int compareTo(@NonNull Message otherMessage) {
        long otherTimestamp = otherMessage.getTimestamp();
        if (otherTimestamp > this.timestamp) {
            return 1;
        } else if (this.timestamp > otherTimestamp) {
            return -1;
        }
        return 0;

    }
}
