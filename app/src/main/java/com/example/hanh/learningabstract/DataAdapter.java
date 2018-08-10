package com.example.hanh.learningabstract;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DataAdapter extends BaseAdapter {
    private static final String TAG = "TestAdapter";
    private Activity activity;
    private String[] items;

    public  DataAdapter(Activity activity, String[] items)
    {
        this.activity = activity;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            Log.d(TAG, "getView: " + position);
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_name, null);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(items[position]);

//        if (convertView == null) {
//            LayoutInflater inflater = activity.getLayoutInflater();
//            convertView = inflater.inflate(R.layout.item_name, null);
//        }
//        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
//        tvName.setText(items[position]);
//        Log.v("DataAdapter","so lan"+position);
        return convertView;
    }

    class ViewHolder {
        TextView textView;
    }
}
