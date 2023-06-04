package com.xk.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @Author xk
 * @Date 2023/04/19 00:07
 */
//自定义适配器，继承自ArrayAdapter
public class BrowserAdapter extends ArrayAdapter<Browser> {
    //resourceID指定ListView的布局方式
    private int resourceID;

    //重写BrowserAdapter的构造器
    public BrowserAdapter(Context context, int textViewResourceID, List<Browser> objects) {
        super(context, textViewResourceID, objects);
        resourceID = textViewResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Browser browser = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceID, null);
            viewHolder = new ViewHolder();
            viewHolder.browserIcon = (ImageView) view.findViewById(R.id.browser_icon);
            viewHolder.browserName = (TextView) view.findViewById(R.id.browser_name);
            viewHolder.browserIcon1 = (ImageView) view.findViewById(R.id.browser_icon1);
            viewHolder.browserName1 = (TextView) view.findViewById(R.id.browser_date);
            viewHolder.browserIcon2 = (ImageView) view.findViewById(R.id.browser_kj);
            //将ViewHolder存储在View中
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.browserIcon.setImageResource(browser.getIcon());
        viewHolder.browserIcon1.setImageResource(browser.getIcon1());
        viewHolder.browserIcon2.setImageResource(browser.getIcon2());
        viewHolder.browserName.setText(browser.getMdate());
        viewHolder.browserName1.setText(browser.getName());
        return view;
    }

    class ViewHolder {
        ImageView browserIcon, browserIcon1, browserIcon2;
        TextView browserName, browserName1;
    }
}
