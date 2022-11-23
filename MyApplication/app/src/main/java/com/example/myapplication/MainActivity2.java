package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ArrayList<RandomItem> randomItems;
    private RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    Button goToMain;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        System.err.println("[Debug Start]");
        switch (item.getItemId()){
            case R.id.addItem:
                addItem();
                break;
            case R.id.removeItem:
                removeItem();
                break;
            default:
                //kasih tau kalau data diubah
                return super.onOptionsItemSelected(item);
        }
        adapter.notifyDataSetChanged();
        System.err.println("[Debug End]");
        return super.onOptionsItemSelected(item);
    }

    public void addItem(){
        randomItems.add(new RandomItem());
    }

    public void removeItem(){
        if(randomItems.size() > 0)
            randomItems.remove(randomItems.size() - 1);
    }

    public void setAdapter(){
        adapter = new Adapter(randomItems);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        goToMain = (Button) findViewById(R.id.goToMain);
        recyclerView = findViewById(R.id.recyclerViewList);
        randomItems = new ArrayList<RandomItem>();
        randomItems.add(new RandomItem());
        randomItems.add(new RandomItem());
        randomItems.add(new RandomItem());

        setAdapter();

        goToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);
            }
        });
    }
}