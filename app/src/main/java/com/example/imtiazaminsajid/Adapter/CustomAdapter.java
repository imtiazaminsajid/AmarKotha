package com.example.imtiazaminsajid.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.imtiazaminsajid.Models.ChatModels;
import com.example.imtiazaminsajid.R;
import com.github.library.bubbleview.BubbleTextView;

import java.text.CollationElementIterator;
import java.util.List;

/**
 * Created by Imtiaz Amin Sajid on 3/15/2018.
 */

public class CustomAdapter extends BaseAdapter{

    List<ChatModels> list_chat_models;
    Context context;
    LayoutInflater layoutInflater;

    public CustomAdapter(List<ChatModels> list_chat_models, Context context) {
        this.list_chat_models = list_chat_models;
        this.context = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return list_chat_models.size();
    }

    @Override
    public Object getItem(int i) {
        return list_chat_models.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;
        if (v==null){
            if (list_chat_models.get(i).isSend())
                v=layoutInflater.inflate(R.layout.list_item_message_send,null);

            else
                v = layoutInflater.inflate(R.layout.list_item_message_receiver,null);

            BubbleTextView  bubbleTextView = (BubbleTextView)v.findViewById(R.id.text_message);
            CollationElementIterator text_message = null;
            text_message.setText(list_chat_models.get(i).message);
        }
        return v;
    }


    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
