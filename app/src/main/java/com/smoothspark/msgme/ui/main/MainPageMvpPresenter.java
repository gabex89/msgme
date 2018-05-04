package com.smoothspark.msgme.ui.main;

import com.smoothspark.msgme.data.db.model.Message;
import com.smoothspark.msgme.ui.base.MvpPresenter;

import java.util.List;

/**
 * Created by SmoothSpark on 2018. 04. 28.
 */
public interface MainPageMvpPresenter<V extends MainPageMvpView>
        extends MvpPresenter<V> {

    void openWebSocket();

    boolean sendMessage(String message);

    boolean saveAllChatEntries(List<Message> chatEntries);

    List<Message> loadAllChatEntries();
}
