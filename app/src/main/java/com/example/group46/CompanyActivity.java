package com.example.group46;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;



import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CompanyActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        recyclerView = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        CompanyAdapter menuAdapter = new CompanyAdapter();

        menuAdapter.setData(CompanyDB.getAllCompanies());
        recyclerView.setAdapter(menuAdapter);


    }
}