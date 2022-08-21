package com.example.meeting_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.meeting_5.Entities.NameEntity;
import com.example.meeting_5.Entities.NamesList;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView grid;
    private ArrayAdapter<NameEntity> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.my_fade_in, R.anim.my_fade_out);

        grid = findViewById(R.id.mainGrid);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NameEntity selectedName = adapter.getItem(i);
                if(selectedName != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(R.anim.horizontal_in, R.anim.horizontal_in, R.anim.horizontal_out, R.anim.horizontal_out);
                    NameFragment newFragment = NameFragment.newInstance(selectedName.getName());
                    ft.add(R.id.mainContainer, newFragment, "Name fragment").addToBackStack("Name fragment");
                    ft.commit();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<NameEntity> names = new NamesList().getAll();
        adapter = new ArrayAdapter<NameEntity>(this, android.R.layout.simple_list_item_1, names);
        grid.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}