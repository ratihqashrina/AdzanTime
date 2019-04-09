package com.example.adzantime;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import static com.example.adzantime.model.AdzanResponse.*;

public class AdzanAdapter extends RecyclerView.Adapter<AdzanAdapter.AdzanViewHolder> {

//    private Context mContext;
    private List<DataBean> mData;

    public AdzanAdapter(List<DataBean> mData) {
//        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public AdzanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layout;
        layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card,viewGroup,false);
        return new AdzanViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull AdzanViewHolder adzanViewHolder, int position) {

        adzanViewHolder.text_date.setText(mData.get(position).getDate().getReadable());
        adzanViewHolder.text_subuh.setText(mData.get(position).getTimings().getFajr());
        adzanViewHolder.text_dzuhur.setText(mData.get(position).getTimings().getDhuhr());
        adzanViewHolder.text_ashar.setText(mData.get(position).getTimings().getAsr());
        adzanViewHolder.text_maghrib.setText(mData.get(position).getTimings().getMaghrib());
        adzanViewHolder.text_isya.setText(mData.get(position).getTimings().getIsha());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class AdzanViewHolder extends RecyclerView.ViewHolder {

        TextView text_date, text_subuh, text_dzuhur, text_ashar, text_maghrib, text_isya;
        

        public AdzanViewHolder(@NonNull View itemView) {
            super(itemView);

            text_date = itemView.findViewById(R.id.text_date);
            text_subuh = itemView.findViewById(R.id.text_subuh);
            text_dzuhur = itemView.findViewById(R.id.text_dzuhur);
            text_ashar = itemView.findViewById(R.id.text_ashar);
            text_maghrib = itemView.findViewById(R.id.text_maghrib);
            text_isya = itemView.findViewById(R.id.text_isya);

        }
    }
}
