package com.example.signup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> userList;

    public Adapter (List<ModelClass>userList){ this .userList = userList;}

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemdesign,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int resource = userList.get(position).getImageview1();
        String name= userList.get(position).getTextview1();
        String msg = userList.get(position).getTextview3();
        String time = userList.get(position).getTextview2();
        String line = userList.get(position).getDash();

        holder.setdata(resource,name,msg,time,line);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        private TextView textView2;
        private TextView textview3;
        private TextView dash;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview1);
            textView = itemView.findViewById(R.id.textview);
            textView2 = itemView.findViewById(R.id.textview2);
            textview3 = itemView.findViewById(R.id.textview3);
            dash = itemView.findViewById(R.id.dash);

        }

        public void setdata(int resource, String name, String msg, String time, String line) {
            imageView.setImageResource(resource);
            textView.setText(name);
            textview3.setText(msg);
            textView2.setText(time);
            dash.setText(line);
        }
    }
}
