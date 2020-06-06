package com.example.styledotmetask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ImgListAdapter extends RecyclerView.Adapter<ImgListAdapter.ViewHolder>{
    private MyListData[] listdata;

    public ImgListAdapter(MyListData[] listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.profile_photo_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyListData myListData = listdata[position];

        holder.profileImgView.setImageResource(listdata[position].getProfileImg());

        holder.photoLayout.setOnClickListener(new View.OnClickListener() {
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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView profileImgView;

        public ConstraintLayout photoLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.profileImgView = (CircleImageView) itemView.findViewById(R.id.profileImg);
            photoLayout = (ConstraintLayout) itemView.findViewById(R.id.photo_layout);
        }
    }
}
