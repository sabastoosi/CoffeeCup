package com.example.coffeecup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private final ArrayList<Brew> mDataset;
    private LayoutInflater mInflater;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MyViewHolder(TextView v) {
            super(v);
            textView = v.findViewById(R.id.brewName);
        }
    }

    public RecyclerAdapter(Context context, ArrayList<Brew> myDataset) {
        mDataset = myDataset;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView v = (TextView) mInflater.inflate(R.layout.recyclerview_row, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        Brew brew = mDataset.get(position);

        TextView tv1 = holder.textView;
        tv1.setText(brew.getmName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
