package com.smoothspark.msgme.data.db;

import com.smoothspark.msgme.data.db.model.Message;

import java.util.List;

/**
 * Created by SmoothSpark on 2018. 05. 03.
 */
public interface DbHelper {

    List<Message> retrievePreviousMessagesFromDb();

    boolean saveMessagesToDb(List<Message> messages);
}
