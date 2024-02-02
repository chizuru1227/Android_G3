package com.goprot.ih4c_mobile;

import static com.goprot.ih4c_mobile.R.drawable.ranking_1;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecycleAdapterRanking extends RecyclerView.Adapter<MyRecycleAdapterRanking.MyViewHolder> {

    List<RecycleHistory> rank;
    Context context;
    private int position;



    public MyRecycleAdapterRanking(List<RecycleHistory> rank, Context context) {
        this.rank = rank;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_history_line,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.seikai.setText(rank.get(position).getSeikai());
        holder.hazure.setText(rank.get(position).getHazure());
        holder.rankingImg.setImageResource(rank.get(position).getRankImgDrawable());

    }

    @Override
    public int getItemCount() {
        return rank.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView seikai;
        TextView hazure;
        ImageView rankingImg;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            seikai= itemView.findViewById(R.id.seikaiId);
            hazure= itemView.findViewById(R.id.hazureId);
            rankingImg=itemView.findViewById(R.id.rankingImg);
        }
    }
}
