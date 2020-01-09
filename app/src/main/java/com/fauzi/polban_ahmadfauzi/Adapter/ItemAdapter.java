package com.fauzi.polban_ahmadfauzi.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fauzi.polban_ahmadfauzi.Model.Item;
import com.fauzi.polban_ahmadfauzi.R;


import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater layoutInflater;
    public ArrayList<Item> listItem;

    public ItemAdapter(Activity activity, ArrayList<Item>listItem){
    this.activity = activity;
    this.listItem =listItem;
    }
    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (layoutInflater == null)
            layoutInflater =(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = layoutInflater.inflate(R.layout.list_row, null);
        final TextView tvIdItem = (TextView) view.findViewById(R.id.idItem);
        final TextView tvNamaItem = (TextView) view.findViewById(R.id.namaItem);
        final TextView tvDescItem = (TextView) view.findViewById(R.id.descItem);

        Item data = listItem.get(i);
        tvIdItem.setText(String.valueOf(data.getId()));
        tvNamaItem.setText(data.getNama_item());
        tvDescItem.setText(data.getDesc_item());

        return view;

    }
}
