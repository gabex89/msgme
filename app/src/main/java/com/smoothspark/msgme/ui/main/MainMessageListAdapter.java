package com.smoothspark.msgme.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smoothspark.msgme.R;
import com.smoothspark.msgme.data.db.model.Message;
import com.smoothspark.msgme.di.module.GlideApp;
import com.smoothspark.msgme.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.smoothspark.msgme.utils.ConstantUtil.IMAGE_URL_REGEXP;

/**
 * Created by SmoothSpark on 2018. 04. 29.
 */
public class MainMessageListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Message> messages = new ArrayList<>();

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MessageViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_message, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        //TODO need to find another solution ASAP!!!
        holder.setIsRecyclable(false);
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (messages != null && messages.size() > 0) {
            return messages.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    public void addItem(String message) {
        if (messages == null) {
            messages = new ArrayList<>();
        }
        messages.add(0, new Message(null, message, System.currentTimeMillis()));

        notifyDataSetChanged();
    }

    public List<Message> getAllMessages() {
        return messages;
    }

    public void addChatItems(List<Message> messages) {
        this.messages = messages;
        Collections.sort(messages);
    }

    public void clear() {
        messages = new ArrayList<>();
        notifyDataSetChanged();
    }

    class MessageViewHolder extends BaseViewHolder {

        @BindView(R.id.messageTextView)
        TextView messageTextView;

        @BindView(R.id.messengerImageView)
        ImageView messengerImageView;

        @BindView(R.id.imageThumbnailImageView)
        ImageView imageThumbnailImageView;

        MessageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {
            messageTextView.setText("");
            messengerImageView.setImageDrawable(null);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            if (!messages.isEmpty()) {
                Message message = messages.get(position);
                if (message != null) {
                    String imageUrl = getImageUrlIfExist(message.getMessage());
                    if (!imageUrl.isEmpty()) {
                        GlideApp.with(imageThumbnailImageView)
                                .load(imageUrl)
                                .placeholder(android.R.drawable.ic_delete)
                                .into(imageThumbnailImageView);
                    }
                    messageTextView.setText(message.getMessage());
                }
            }
        }

        private String getImageUrlIfExist(String message) {
            Pattern pat = Pattern.compile(IMAGE_URL_REGEXP);
            Matcher matcher = pat.matcher(message);
            if (matcher.find()) {
                return matcher.group();
            }
            return "";
        }
    }
}
