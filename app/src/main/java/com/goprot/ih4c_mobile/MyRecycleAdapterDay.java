package com.goprot.ih4c_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecycleAdapterDay extends RecyclerView.Adapter<MyRecycleAdapterDay.MyViewHolder> {

    List<RecycleDataDay> dataday;
    Context context;

    public MyRecycleAdapterDay(List<RecycleDataDay> dataday, Context context) {
        this.dataday = dataday;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_recycle_line_day,parent,false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.day.setText(dataday.get(position).getday());
        holder.total.setText(dataday.get(position).gettotal());

    }

    @Override
    public int getItemCount() {
        return dataday.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        TextView day;
        TextView total;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.recycleDay);
            total=itemView.findViewById(R.id.recycleTotal);
        }
    }
}
