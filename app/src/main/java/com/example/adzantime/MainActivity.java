package com.example.adzantime;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import com.example.adzantime.model.AdzanResponse;
import com.example.adzantime.remote.AdzanService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdzanService.getAPI().getPrayerTimeByCity("Makassar", "ID").enqueue(new Callback<AdzanResponse>() {
            @Override
            public void onResponse(Call<AdzanResponse> call, Response<AdzanResponse> response) {
                if (response.isSuccessful()) {
                    List<AdzanResponse.DataBean> dataBeans = response.body().getData();

                    for (AdzanResponse.DataBean dataBean: dataBeans) {
                        AdzanResponse.DataBean.TimingsBean timingsBean = dataBean.getTimings();
                        AdzanResponse.DataBean.DateBean dateBean = dataBean.getDate();

                        Log.d("Jadwal Sholat Maghrib", timingsBean.getMaghrib() + "in " + dataBean.getDate());
                    }
                }
            }

            @Override
            public void onFailure(Call<AdzanResponse> call, Throwable t) {

            }
        });
    }
}
