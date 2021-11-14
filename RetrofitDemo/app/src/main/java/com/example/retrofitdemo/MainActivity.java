package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);

        ((MyApp) getApplication()).getApiComponent().inject(this);
        getData();
    }

    private void getData(){

        Api api= retrofit.create(Api.class);
        Call<List<PageData>> call = api.getPage();
        call.enqueue(new Callback<List<PageData>>() {
            @Override
            public void onResponse(Call<List<PageData>> call, Response<List<PageData>> response) {
                List<PageData> PageList = response.body();
                String[] pageNumber = new String[PageList.size()];

                for (int i = 0; i < PageList.size(); i++) {
                    pageNumber[i] = String.valueOf(PageList.get(i).getPage());
                }

                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, pageNumber));
            }

            @Override
            public void onFailure(Call<List<PageData>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
