package com.slidelayout;

import java.util.ArrayList;

import com.application.*;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class MenuAdapter extends BaseAdapter {
	@SuppressWarnings("unused")
	private Context context;
	private ArrayList<String> items;
	private LayoutInflater inflater;

	public MenuAdapter(Context context, ArrayList<String> items, Activity act) {
		this.context = context;
		this.items = items;
		this.inflater = LayoutInflater.from(context);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = inflater.inflate(R.layout.item_menu, null);
		TextView title = (TextView) convertView.findViewById(R.id.menu_title);
		title.setText(getItem(position));
		return convertView;
	}

	public int getCount() {
		return items.size();
	}

	public String getItem(int position) {
		return items.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

}
