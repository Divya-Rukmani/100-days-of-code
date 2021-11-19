package com.example.todoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.TasksViewHolder> {

    private Context context;
    private List<Note> taskList;

    public NotesAdapter(Context context, List<Note> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_viewnote, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Note t = taskList.get(position);
        holder.textViewTask.setText(t.getNote());
        holder.textViewDesc.setText(t.getDescription());
        holder.textViewFinishBy.setText(t.getDate());

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder {

        TextView  textViewTask, textViewDesc, textViewFinishBy;

        public TasksViewHolder(View itemView) {
            super(itemView);

            //textViewStatus = itemView.findViewById(R.id.show_notename);
            textViewTask = itemView.findViewById(R.id.show_notename);
            textViewDesc = itemView.findViewById(R.id.show_notedesc);
            textViewFinishBy = itemView.findViewById(R.id.show_notedate);
        }
    }

}
