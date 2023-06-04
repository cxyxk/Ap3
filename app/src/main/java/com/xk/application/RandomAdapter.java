package com.xk.application;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Locale;

public class RandomAdapter extends RecyclerView.Adapter<RandomAdapter.ViewHolder> {

    private ArrayList<RandomItem> dataList;

    public RandomAdapter(ArrayList<RandomItem> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_random, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RandomItem item = dataList.get(position);
        holder.seedTextView.setText(String.format(Locale.getDefault(), "Seed: %d", item.getSeed()));
        holder.rangeTextView.setText(String.format(Locale.getDefault(), "Range: %d", item.getRange()));
        holder.randomTextView.setText(String.format(Locale.getDefault(), "Random: %d", item.getRandom()));
        holder.timeTextView.setText(getDateString(item.getTimestamp()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String getDateString(long timestamp) {
        SimpleDateFormat format = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        }
            return format.format(new Date(timestamp));


    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView seedTextView;
        TextView rangeTextView;
        TextView randomTextView;
        TextView timeTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            seedTextView = itemView.findViewById(R.id.seed_text_view);
            rangeTextView = itemView.findViewById(R.id.range_text_view);
            randomTextView = itemView.findViewById(R.id.random_text_view);
            timeTextView = itemView.findViewById(R.id.time_text_view);
        }
    }

}
