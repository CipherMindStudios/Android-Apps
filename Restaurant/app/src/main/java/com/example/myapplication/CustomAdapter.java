package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList res_name, res_location, res_phone, res_description, res_rating;

    CustomAdapter(Activity activity, Context context, ArrayList res_name, ArrayList res_location, ArrayList res_phone, ArrayList res_description, ArrayList res_rating){
        this.activity = activity;
        this.context = context;

        this.res_name = res_name;
        this.res_location = res_location;
        this.res_phone = res_phone;
        this.res_description = res_description;
        this.res_rating = res_rating;



    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.res_name_txt.setText(String.valueOf(res_name.get(position)));
        holder.res_location_txt.setText(String.valueOf(res_location.get(position)));
        holder.res_phone_txt.setText(String.valueOf(res_phone.get(position)));
        holder.description_txt.setText(String.valueOf(res_description.get(position)));
        holder.rating_txt.setText(String.valueOf(res_rating.get(position)));

    }

    @Override
    public int getItemCount() {
        return res_name.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView  res_name_txt, res_location_txt, res_phone_txt, description_txt, rating_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            res_name_txt = itemView.findViewById(R.id.name_txt);
            res_location_txt = itemView.findViewById(R.id.location_txt);
            res_phone_txt = itemView.findViewById(R.id.phone_txt);
            description_txt = itemView.findViewById(R.id.description_txt);
            rating_txt = itemView.findViewById(R.id.rating_txt);

            mainLayout = itemView.findViewById(R.id.mainLayout);

        }

    }

}