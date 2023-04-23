package com.example.cspace.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cspace.classes.GlossaryItem;
import com.example.cspace.R;

import java.util.List;

public class GlossaryAdapter extends BaseAdapter {
     Context context;
     List<GlossaryItem> data;

    public GlossaryAdapter(Context context, List<GlossaryItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.glossary_item, parent, false);
        }

        GlossaryItem item = data.get(position);

        TextView termTextView = convertView.findViewById(R.id.term);
        termTextView.setText(item.getTerm());

        return convertView;
    }
}
