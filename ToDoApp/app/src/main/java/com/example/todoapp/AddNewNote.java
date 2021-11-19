package com.example.todoapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddNewNote extends AppCompatActivity  {


    EditText edt_notename,edt_notedesc,edt_noteDate;
    Button btn_save;



    private void SaveNotes() {
        final String sTask = edt_notename.getText().toString().trim();
        final String sDesc = edt_notedesc.getText().toString().trim();
        final String sDate = edt_noteDate.getText().toString().trim();

        class SaveNotes extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a task
                Note note = new Note();
                note.setNote(sTask);
                note.setDescription(sDesc);
                note.setDate(sDate);
                note.setFinished(false);


                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .noteDao()
                        .insert(note);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        SaveNotes st = new SaveNotes();
        st.execute();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_todo);
        edt_notename = findViewById(R.id.edt_addnotename);
        edt_notedesc = findViewById(R.id.edt_addnotedesc);
        edt_noteDate = findViewById(R.id.edt_noteDate);
        btn_save = findViewById(R.id.btn_savenote);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveNotes();
            }
        });


    }
}
