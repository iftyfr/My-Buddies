package com.example.ifty.buddies;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BuddiesRvAdapter extends RecyclerView.Adapter<BuddiesRvAdapter.BuddiesViewHolder>{
    Context context;
    ArrayList<Buddy>buddies;

    public BuddiesRvAdapter(Context context, ArrayList<Buddy> buddies) {
        this.context = context;
        this.buddies = buddies;
    }

    @NonNull
    @Override
    public BuddiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.buddy_rv_layout,parent,false);
        return new BuddiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuddiesViewHolder holder, final int position) {
        Buddy buddy =buddies.get(position);
        holder.buddyImageRv.setImageResource(buddy.getImage());
        holder.buddyNameRv.setText(buddy.getName());
        holder.cardRv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BuddysDetailsActivity.class);
                intent.putExtra("image",buddies.get(position).getImage());
                intent.putExtra("name",buddies.get(position).getName());
                intent.putExtra("mobileNo",buddies.get(position).getMobileNo());
                intent.putExtra("email",buddies.get(position).getEmail());
                intent.putExtra("bloodGroup",buddies.get(position).getBloodGroup());
                intent.putExtra("address",buddies.get(position).getAddress());
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return buddies.size();
    }

    public class BuddiesViewHolder extends RecyclerView.ViewHolder {
        ImageView buddyImageRv;
        TextView buddyNameRv;
        CardView cardRv;
        public BuddiesViewHolder(View view) {
            super(view);
            buddyImageRv=view.findViewById(R.id.buddyImageRv);
            buddyNameRv=view.findViewById(R.id.buddyNameRv);
            cardRv=view.findViewById(R.id.cardRv);
        }
    }
}
