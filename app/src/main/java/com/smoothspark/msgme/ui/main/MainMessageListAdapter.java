package com.smoothspark.msgme.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smoothspark.msgme.R;
import com.smoothspark.msgme.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SmoothSpark on 2018. 04. 29.
 */
public class MainMessageListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<String> messages = new ArrayList<>();

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MessageViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_message, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (messages != null && messages.size() > 0) {
            return messages.size();
        } else {
            return 1;
        }
    }

    public void addItem(String message) {
        if (messages == null) {
            messages = new ArrayList<>();
        }
        messages.add(message);

        notifyDataSetChanged();
    }


    class MessageViewHolder extends BaseViewHolder {

        @BindView(R.id.messageTextView)
        TextView messageTextView;

        @BindView(R.id.messengerTextView)
        TextView messengerNameTExtView;

        @BindView(R.id.messengerImageView)
        ImageView messengerImageView;

        MessageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {
            messageTextView.setText("");
            messengerNameTExtView.setText("");
            messengerImageView.setImageDrawable(null);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            if (!messages.isEmpty()) {
                String message = messages.get(position);
                if (message != null) {
                    messageTextView.setText(message);
                }
            }
        }
    }
}
