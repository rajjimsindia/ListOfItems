package com.demo.raj.listofitems.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.demo.raj.listofitems.Item;
import com.demo.raj.listofitems.R;

import java.util.List;

/**
 * Created by raj on 2/4/2016.
 */
public class ItemsAdapter extends BaseAdapter {

    // TAG for debugging
    private static final String LOG_TAG = ItemsAdapter.class.getSimpleName();

    // Context
    private Context context;

    // adapter data
    private List<Item> mData;

    // default constructor
    public ItemsAdapter(){}

    // get data and context
    public ItemsAdapter(Context ctx, List<Item> data){

        this.context = ctx;
        this.mData = data;
    }

    // remember inflated child views
    private static class ViewHolder{
        TextView title;
        TextView desc;
    }

    @Override
    public boolean isEmpty() {

        boolean isEmpty = false;

        if(mData != null)
            isEmpty = mData.isEmpty();

        return isEmpty;
    }

    @Override
    public int getCount() {

        int size = 0;

        if(mData != null)
            size = mData.size();

        return  size;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.list_item_text, parent, false);

            holder = new ViewHolder();
            holder.title = (TextView)convertView.findViewById(R.id.item_title);
            holder.desc = (TextView)convertView.findViewById(R.id.item_desc);
            convertView.setTag(holder);
        }
        holder = (ViewHolder)convertView.getTag();
        holder.title.setText(mData.get(position).getTitle());
        holder.desc.setText(mData.get(position).getDesc());

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}