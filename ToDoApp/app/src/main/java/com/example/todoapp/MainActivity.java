package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton buttonAddTask;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            recyclerView = findViewById(R.id.recylerview_notes);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            buttonAddTask = findViewById(R.id.fab);
            buttonAddTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, AddNewNote.class);
                    startActivity(intent);
                }
            });


            getNotes();

        }

        private void getNotes() {
            class GetTasks extends AsyncTask<Void, Void, List<Note>> {

                @Override
                protected List<Note> doInBackground(Void... voids) {
                    List<Note> taskList = DatabaseClient
                            .getInstance(getApplicationContext())
                            .getAppDatabase()
                            .noteDao()
                            .getAll();
                    return taskList;
                }

                @Override
                protected void onPostExecute(List<Note> tasks) {
                    super.onPostExecute(tasks);
                    NotesAdapter adapter = new NotesAdapter(MainActivity.this, tasks);
                    recyclerView.setAdapter(adapter);
                }
            }

            GetTasks gt = new GetTasks();
            gt.execute();
        }


    }

