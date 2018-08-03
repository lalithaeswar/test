package sampleproject.com.retrofitexample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sampleproject.com.retrofitexample.R;
import sampleproject.com.retrofitexample.model.Entity;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private List<Entity> countries;


    public CountryAdapter(List<Entity> countries) {
        this.countries = countries;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_country_list, parent, false);
        //return new CountryViewHolder(view);

        return new CountryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.content_country_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull final CountryViewHolder viewHolder, final int position) {

         Entity item = countries.get(position);
        try {
            viewHolder.countryName.setText(item.getCountry());
            viewHolder.countryCode.setText((item.getCountryCode()));
        } catch (Exception e) {
            Log.d("lalitha", "onBindViewHolder: erxception");
        }


    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    //view holder
    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView countryName;
        TextView countryCode;

        public CountryViewHolder(View view) {
            super(view);
            countryName = view.findViewById(R.id.tv_countryanme);
            countryCode = view.findViewById(R.id.tv_countrycode);
        }
    }
}

