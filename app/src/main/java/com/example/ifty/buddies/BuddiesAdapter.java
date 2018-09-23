package com.example.ifty.buddies;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BuddiesAdapter extends ArrayAdapter {

    Context context;
    ArrayList<Buddy>buddies;
    public BuddiesAdapter(@NonNull Context context, @NonNull ArrayList buddies) {
        super(context, R.layout.buddy_layout, buddies);
        this.context=context;
        this.buddies=buddies;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.buddy_layout,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.buddyImage=convertView.findViewById(R.id.buddyImage);
            viewHolder.buddyName=convertView.findViewById(R.id.buddyName);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Buddy buddy=buddies.get(position);
        viewHolder.buddyImage.setImageResource(buddy.getImage());
        viewHolder.buddyName.setText(buddy.getName());
        viewHolder.buddyName.setOnClickListener(new View.OnClickListener() {
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
        return convertView;
    }
    static class ViewHolder{
        ImageView buddyImage;
        TextView buddyName;
    }
}
