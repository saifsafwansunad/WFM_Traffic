package com.example.wfm_traffic.adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wfm_traffic.R;
import com.example.wfm_traffic.activities.AssignedTaskActivity;
import com.example.wfm_traffic.activities.DetailsActivity;
import com.example.wfm_traffic.fragments.DetailsFragment;
import com.example.wfm_traffic.model.TaskModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class AssignedTaskAdapter extends RecyclerView.Adapter<AssignedTaskAdapter.ViewHolder> {
    private ArrayList<TaskModel> tsk;
    private Context context;

    public AssignedTaskAdapter(ArrayList<TaskModel> tsk, Context context) {
        this.tsk = tsk;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.id.setText(String.valueOf(tsk.get(position).getTaskId()));
        holder.task.setText(tsk.get(position).getTaskTitle());
        holder.cate.setText(tsk.get(position).getTaskCategory());
        holder.assigned.setText(tsk.get(position).getTaskAssignedTo());
        holder.date.setText(tsk.get(position).getTaskDate());
        holder.from.setText(tsk.get(position).getTaskFrom());
        holder.to.setText(tsk.get(position).getTaskTo());

        holder.buttonViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myactivity = new Intent(context.getApplicationContext(), DetailsActivity.class);
                myactivity.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(myactivity);
//                ((Activity) context).overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);



//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//
//                MyFragment next = getMyFragment();
//
//                ft.add(R.id.MyLayout,next);
//                ft.setCustomAnimations(R.anim.slide_in_right,0);
//                ft.show(next);
//                ft.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (tsk != null) ? tsk.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id,task,cate,assigned,date,from,to;
        LinearLayout linearLayoutDetails;
        Button buttonViewDetails;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView2);
            task = itemView.findViewById(R.id.textView4);
            cate = itemView.findViewById(R.id.textView6);
            assigned = itemView.findViewById(R.id.textView8);
            date = itemView.findViewById(R.id.textView10);
            from = itemView.findViewById(R.id.textView12);
            to = itemView.findViewById(R.id.textView14);
//            linearLayoutDetails=itemView.findViewById(R.id.details_layout);
            buttonViewDetails=itemView.findViewById(R.id.viewDetails);
        }
    }
}
