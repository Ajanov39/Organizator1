package com.trifun.organizator;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder> {

    ArrayList<ToDo> todo;

    public ToDoAdapter(ArrayList<ToDo> cities) {
        this.todo = cities;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.item_to_do, null);
        ToDoViewHolder viewHolder = new ToDoViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        ToDo td = todo.get(position);
        holder.toDate.setText(td.getDate());
        holder.toTime.setText(td.getTime());
        holder.toActivity.setText(td.getActivity());
        holder.toActivity.setTextColor(Color.parseColor("#FFD700"));
    }

    @Override
    public int getItemCount() {
        return todo.size();
    }

    public static class ToDoViewHolder extends RecyclerView.ViewHolder {

        TextView toDate, toTime, toActivity;

        public ToDoViewHolder(@NonNull View itemView) {
            super(itemView);
            toDate = (TextView) itemView.findViewById(R.id.toDate);
            toTime = (TextView) itemView.findViewById(R.id.toTime);
            toActivity = (TextView) itemView.findViewById(R.id.toActivity);
        }
    }

}
