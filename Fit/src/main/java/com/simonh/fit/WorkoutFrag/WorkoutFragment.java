package com.simonh.fit.WorkoutFrag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simonh.fit.ChestFrag.ChestFragment;
import com.simonh.fit.R;

import java.util.ArrayList;
import java.util.Collections;

public class WorkoutFragment extends Fragment {

    //inflate fragment into the main activity
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstancesState){
        View rootView = inflater.inflate(R.layout.fragment_workout,container,false);
        //creates the recyclerview list
        final RecyclerView mRecyclerView = rootView.findViewById(R.id.recyclerViewWork);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        final ArrayList<ExampleItem> exampleList = new ArrayList<>();
//        //exampleList.add(newExampleItem(R.drawable.ic_android)) this needs to be included to add image
//        exampleList.add(new ExampleItem("Line 1","Line 2",R.drawable.ic_drag));
//        exampleList.add(new ExampleItem("Line 3","Line 4",R.drawable.ic_drag));
//        exampleList.add(new ExampleItem("Line 5","Line 6",R.drawable.ic_drag));
        final ArrayList<String> list = new ArrayList<>();
        list.add("Chest");
        list.add("Back");
        list.add("Arms");
        list.add("Shoulder");
        list.add("Legs");

        //final ExampleAdapter mAdapter = new ExampleAdapter(exampleList);
        final ExampleAdapter mAdapter = new ExampleAdapter(list);


        //item touch helper library used to implement drag and drop feature
        final ItemTouchHelper ith = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,0) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder dragged, RecyclerView.ViewHolder target) {
                int position_dragged = dragged.getAdapterPosition();
                int position_target = target.getAdapterPosition();
                //swaps position with item on the list
                Collections.swap(list,position_dragged,position_target);
                mAdapter.notifyItemMoved(position_dragged,position_target);


                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });
        //set the item touch helper to the recycler view
        ith.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //calls the onItemClickListener method fromt he adapter class to help drag the objects
        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onDragClick(ExampleAdapter.ExampleViewHolder v) {
                {
                    ith.startDrag(v);

                }
            }
            @Override//when you click on the item name it will open a new fragment which replaces this one
            public void onItemClick(int position) {
                switch(mAdapter.getName(position)){
                    case "Chest":
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, new ChestFragment()).commit();
                        break;
                    case "Back":

                        break;
                    case "Arms":

                        break;
                    case "Shoulder":

                        break;
                    case "Legs":

                        break;
                }
            }


        });

        return rootView;
    }



}
