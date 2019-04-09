package com.example.adzantime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;

import com.example.adzantime.model.AdzanResponse;
import com.example.adzantime.remote.AdzanService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView AdzanRecyclerview;
    AdzanAdapter adzanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdzanRecyclerview = findViewById(R.id.adzan_rv);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(getApplicationContext());
        AdzanRecyclerview.setLayoutManager(mLayout);



        AdzanService.getAPI().getPrayerTimeByCity("Makassar", "ID").enqueue(new Callback<AdzanResponse>() {
            @Override
            public void onResponse(Call<AdzanResponse> call, Response<AdzanResponse> response) {

                if (response.isSuccessful()) {
                    List<AdzanResponse.DataBean> dataBeans = response.body().getData();
                    adzanAdapter = new AdzanAdapter(dataBeans);
                    AdzanRecyclerview.setAdapter(adzanAdapter);

                }
            }

            @Override
            public void onFailure(Call<AdzanResponse> call, Throwable t) {

            }


        });

    }
}
