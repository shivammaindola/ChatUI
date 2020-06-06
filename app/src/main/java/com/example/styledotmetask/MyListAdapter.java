package com.example.styledotmetask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private MyListData[] listdata;

    MyListAdapter(MyListData[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.chat_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyListData myListData = listdata[position];

        holder.profileImgView.setImageResource(listdata[position].getProfileImg());
        holder.userNameView.setText(listdata[position].getUserName());
        holder.userMsgView.setText(listdata[position].getUserMsg());
        holder.time.setText(listdata[position].getTime());
        holder.number.setText(listdata[position].getNumber());

        holder.chatLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Item Clicked ",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView profileImgView;
        TextView userNameView;
        TextView userMsgView;
        TextView time;
        TextView number;

        ConstraintLayout chatLayout;

        ViewHolder(View itemView) {
            super(itemView);
            this.profileImgView = (CircleImageView) itemView.findViewById(R.id.userImg);
            this.userNameView=(TextView) itemView.findViewById(R.id.userName);
            this.userMsgView = (TextView) itemView.findViewById(R.id.userMsg);
            this.time=(TextView) itemView.findViewById(R.id.time);
            this.number=(TextView) itemView.findViewById(R.id.number);
            chatLayout = (ConstraintLayout) itemView.findViewById(R.id.chat_layout);
        }
    }
}
