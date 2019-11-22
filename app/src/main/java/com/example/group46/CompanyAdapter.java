package com.example.group46;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.annotation.NonNull;

import java.util.ArrayList;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> {
    private ArrayList<Company> companyToAdapt;

    public void setData(ArrayList<Company>companyToAdapt){

        this.companyToAdapt = companyToAdapt;
    }

    @NonNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.company, parent, false);
        CompanyViewHolder companyViewHolder = new CompanyViewHolder(view);
        return companyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, int position) {
        final Company companyAtPosition = companyToAdapt.get(position);

        holder.name.setText(companyAtPosition.getCompanyName());
        holder.image.setImageResource(companyAtPosition.getImageDrawableID());

    }

    @Override
    public int getItemCount() {
        return companyToAdapt.size();
    }

    public static class CompanyViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView name;
        public ImageView image;

        public CompanyViewHolder(View v){
            super(v);
            view = v;
            name = v.findViewById(R.id.oName);
            image = v.findViewById(R.id.oImage);
        }
    }
}