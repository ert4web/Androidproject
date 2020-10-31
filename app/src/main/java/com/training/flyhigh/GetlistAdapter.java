package com.training.flyhigh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.training.comebackapp.R;

import java.util.ArrayList;

public class GetlistAdapter extends RecyclerView.Adapter<GetlistAdapter.MyViewHolder> {

    Context context;
    ArrayList <ListModel> arrayList;

    public GetlistAdapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ListModel model = arrayList.get(position);
        holder.tvSubject.setText(model.getSubject());
        holder.tvFrom.setText(model.getFrom());
        if(model.getImage() !=null){
            Picasso.get().load(model.getImage()).into(holder.ivImage);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context instanceof GetList) {
                    ((GetList) context).getFromAdapter(model.getId(),model.getIsImp(),model.getImage(),model.getFrom(), model.getSubject(),model.getMessage(),model.getTimeStamp(),model.getIsRead());
                }
            }
        });

    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvFrom, tvSubject;
        ImageView ivImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFrom = itemView.findViewById(R.id.from);
            tvSubject = itemView.findViewById(R.id.subject);
            ivImage = itemView.findViewById(R.id.image);
        }
    }
}
