package com.renzam.googleyoutube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends YouTubeBaseActivity {

    RecyclerView recyclerView;

    RecycleAdapter recycleAdapter;

    List<Modelvideo> myViedioList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        myViedioList = new ArrayList<>();


        myViedioList.add(new Modelvideo("kVYB4PJlwZ8"));
        myViedioList.add(new Modelvideo("74yb9E3WY1I"));
        myViedioList.add(new Modelvideo("XM2Q2rpmxmY"));
        myViedioList.add(new Modelvideo("Ginx7WKq5GE"));
        myViedioList.add(new Modelvideo("QRUNUtZUtEo"));
        myViedioList.add(new Modelvideo("GP4okspbfMM"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recycleAdapter = new RecycleAdapter(myViedioList,this);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recycleAdapter);


    }
}
