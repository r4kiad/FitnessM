package com.simonh.fit.ChestFrag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.simonh.fit.R;

import java.util.ArrayList;

public class ChestFragment extends Fragment {
    Button mbtn;
    Button pbtn;
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstancesState){

        v = inflater.inflate(R.layout.fragment_chest,container,false);
        //set recyclerview to the fragment
        final RecyclerView mRecyclerView = v.findViewById(R.id.recyclerViewChest);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //set title of the activity to Chest workouts
        getActivity().setTitle("Chest Workouts");
        //array list of object chest item
        ArrayList<ChestItem> chestworkoutlist = new ArrayList<>();

        chestworkoutlist.add(new ChestItem("Bench Press", mbtn, 0, "lb",pbtn));
        chestworkoutlist.add(new ChestItem("Incline Bench Press", mbtn, 20, "lb",pbtn));
        chestworkoutlist.add(new ChestItem("Chest Fly (Dumbbell)", mbtn, 100, "lb",pbtn));
        chestworkoutlist.add(new ChestItem("Dumbbell Press", mbtn, 0, "lb",pbtn));
        chestworkoutlist.add(new ChestItem("Cable Lower Chest Raise", mbtn, 0, "lb",pbtn));
        chestworkoutlist.add(new ChestItem("Cable Fly", mbtn, 0, "lb",pbtn));


        //initialize adapter and set it to this view so it display information
        final ChestAdapter cAdapter = new ChestAdapter(chestworkoutlist);
        mRecyclerView.setAdapter(cAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //final ChestAdapter.ChestViewHolder chestViewHolder = new ChestAdapter.ChestViewHolder(v);



        return v;
    }
}

