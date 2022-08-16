package com.example.wfm_traffic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.model.TaskModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class LeaveDetailAdapter extends RecyclerView.Adapter<LeaveDetailAdapter.ViewHolder> {
    private ArrayList<TaskModel> tsk;
    private Context context;

    public LeaveDetailAdapter(ArrayList<TaskModel> tsk, Context context) {
        this.tsk = tsk;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public LeaveDetailAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.leave_detail_layout, parent, false);
        return new LeaveDetailAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull LeaveDetailAdapter.ViewHolder holder, int position) {
        holder.id.setText(String.valueOf(tsk.get(position).getTaskId()));
        holder.task.setText(tsk.get(position).getTaskTitle());
        holder.cate.setText(tsk.get(position).getTaskCategory());
        holder.assigned.setText(tsk.get(position).getTaskAssignedTo());
        holder.date.setText(tsk.get(position).getTaskDate());
        holder.from.setText(tsk.get(position).getTaskFrom());
//        holder.to.setText(tsk.get(position).getTaskTo());
    }

    @Override
    public int getItemCount() {
        return (tsk != null) ? tsk.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id,task,cate,assigned,date,from,to;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView2);
            task = itemView.findViewById(R.id.textView4);
            cate = itemView.findViewById(R.id.textView6);
            assigned = itemView.findViewById(R.id.textView8);
            date = itemView.findViewById(R.id.textView10);
            from = itemView.findViewById(R.id.textView12);
//        to = itemView.findViewById(R.id.textView14);

        }
    }
}
