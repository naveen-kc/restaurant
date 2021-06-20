package com.naveenkc.restaurant;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder>{



    public List<RestaurantList> profileDataList;
    public Activity activity;


    public RestaurantAdapter(Activity activity, ArrayList<RestaurantList> profileDataList) {
        this.activity = activity;
        this.profileDataList = profileDataList;

    }


    public static class ViewHolder extends RecyclerView.ViewHolder{


        public TextView textView;


        public View maincardd;


        public ViewHolder(View v){

            super(v);
            //image=itemView.findViewById(R.id.mainimage);
            textView = (TextView)v.findViewById(R.id.subjectList);

            maincardd=v.findViewById(R.id.intetcardviewSub);
            // idd = (TextView)v.findViewById(R.id.id);



        }
    }

    @Override
    public RestaurantAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view1 = LayoutInflater.from(activity).inflate(R.layout.restaurant_view,parent,false);

        RestaurantAdapter.ViewHolder viewHolder1 = new RestaurantAdapter.ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantAdapter.ViewHolder holder, int position) {
        final RestaurantList profileData = profileDataList.get(position);

        // Product product = profileDataList.get(position);
       holder.textView.setText(profileDataList.get(position).getName() + "");


      /*  Glide.with(activity)
                .load(profileData.getImage())
                .into(holder.image);

       */


        // Log.e("multi",profileData.getMultiimages());

        holder.maincardd.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {


                                                    Toast.makeText(activity,"hello",Toast.LENGTH_SHORT).show();



                                                }

                                            }
        );


    }






    @Override
    public int getItemCount(){

        return profileDataList.size();
    }

}



