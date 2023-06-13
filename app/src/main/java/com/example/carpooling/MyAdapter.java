package com.example.carpooling;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<DataClass> dataList;

    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recSrc.setText(dataList.get(position).getDataSrc());
        holder.recDest.setText(dataList.get(position).getDataDest());
        holder.recTime.setText(dataList.get(position).getDataTime());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Source", dataList.get(holder.getAdapterPosition()).getDataSrc());
                intent.putExtra("Destination", dataList.get(holder.getAdapterPosition()).getDataDest());
                intent.putExtra("Time", dataList.get(holder.getAdapterPosition()).getDataTime());

                intent.putExtra("Name", dataList.get(holder.getAdapterPosition()).getDataName());
                intent.putExtra("Gender", dataList.get(holder.getAdapterPosition()).getGender());
                intent.putExtra("NoPassenger", dataList.get(holder.getAdapterPosition()).getDataNoPass());
                intent.putExtra("FarePP", dataList.get(holder.getAdapterPosition()).getDataFarePerP());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recSrc, recDest, recTime;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recSrc = itemView.findViewById(R.id.recSrc);
        recDest = itemView.findViewById(R.id.recDest);
        recTime = itemView.findViewById(R.id.recTime);
    }
}
