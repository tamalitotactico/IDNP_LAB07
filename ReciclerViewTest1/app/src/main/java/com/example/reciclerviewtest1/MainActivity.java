package com.example.reciclerviewtest1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BuildingAdapter adapter;
    private List<Building> buildingList;
    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeData();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new BuildingAdapter(buildingList);
        recyclerView.setAdapter(adapter);

        searchBar = findViewById(R.id.search_bar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void initializeData() {
        buildingList = new ArrayList<>();
        buildingList.add(new Building("Baños Termales", "Estos son los baños termales", R.drawable.edificio1));
        buildingList.add(new Building("Cañon de Colca", "Cañon del colca ubicado en arequipa", R.drawable.edificio2));
        buildingList.add(new Building("Yanahuara", "textotextotextotexto", R.drawable.edificio3));
    }
}
