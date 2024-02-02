package com.goprot.ih4c_mobile;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {

    List<RecycleData> data;
    Context context;
    private MyViewHolder holder;
    private int position;
    Dialog popUp;



    public MyRecycleAdapter(List<RecycleData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_recycle_line,parent,false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Gakka.setText(data.get(position).getGakka());
        holder.Bunya.setText(data.get(position).getBunya());

//      ポップアップ画面
        popUp = new Dialog(context);
        popUp.setContentView(R.layout.rirekianpopup);

//        RecycleViewクリックしたらポップアップ画面を展開
        holder.Gakka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView popkamoku =  popUp.findViewById(R.id.popup_kamoku);
                TextView popbunya =  popUp.findViewById(R.id.popup_bunya);
                popkamoku.setText(data.get(position).getGakka());
                popbunya.setText(data.get(position).getBunya());
                popUp.show();
                ImageButton close_popup = popUp.findViewById(R.id.closepopup);
                close_popup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popUp.cancel();
                    }
                });
            }
        });
        holder.Bunya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView popkamoku =  popUp.findViewById(R.id.popup_kamoku);
                TextView popbunya =  popUp.findViewById(R.id.popup_bunya);
                popkamoku.setText(data.get(position).getGakka());
                popbunya.setText(data.get(position).getBunya());
                popUp.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        TextView Gakka;
        TextView Bunya;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Gakka = itemView.findViewById(R.id.recycleGakka);
            Bunya=itemView.findViewById(R.id.recycleBunya);
        }
    }

}
