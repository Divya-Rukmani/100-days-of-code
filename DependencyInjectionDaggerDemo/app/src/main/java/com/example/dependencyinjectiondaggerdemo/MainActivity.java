package com.example.dependencyinjectiondaggerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editText;
    TextView textView;
    Button saveBtn, getBtn;
    private SharedPreferenceComponent sharedPreferenceComponent;
    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.inputField);
        textView = (TextView) findViewById(R.id.outputField);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        getBtn = (Button) findViewById(R.id.getBtn);
        saveBtn.setOnClickListener(this);
        getBtn.setOnClickListener(this);
        //Dagger keyword will be prefix to the component name for binding

        sharedPreferenceComponent = DaggerSharedPreferenceComponent.builder().sharedPreferenceModule(
                new SharedPreferenceModule(this)).build();
        sharedPreferenceComponent.inject(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveBtn:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("feededData", editText.getText().toString().trim());
                editor.apply();
                break;
            case R.id.getBtn:
                textView.setText(sharedPreferences.getString("feededData", ""));
                break;
        }

    }
}
