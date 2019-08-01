package com.simonh.fit.WorkoutFrag;


import android.annotation.SuppressLint;

import android.support.annotation.NonNull;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.simonh.fit.R;

import java.util.ArrayList;


//Adapter to the workout fragment recycler view, like a controller
public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>
{
    //private ArrayList<ExampleItem> mExampleList;
    private ArrayList<String> mlist;
    private OnItemClickListener mListener;
    private String name;
    //personal on click listener for use within workoutfragment, is parent to onItemClickListener
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    //method within setOnItemClickListener needed for the drag and drop feature
    public interface OnItemClickListener{
        void onItemClick(int position);
        void onDragClick(ExampleViewHolder v);

    }

    // This link up the variables with the layout in the Example_Item layout
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;
        public ImageView mDragImage;


        //        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) {
//            @Override
//            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder dragged, RecyclerView.ViewHolder target) {
//
//                int position_dragged = dragged.getAdapterPosition();
//                int position_target = target.getAdapterPosition();
//
//                Collections.swap(exampleList,position_dragged,position_target);
//                mAdapter.notifyItemMoved(position_dragged,position_target);
//
//                return false;
//            }
//
//            @Override
//            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//
//            }
//        });
        //helper.attachToRecyclerView(mRecyclerView);
        //constructor to assign variables to the layout workout fragment and displays the textview.
        public ExampleViewHolder(final View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
//            mTextView2 = itemView.findViewById(R.id.textView2);
            mDragImage = itemView.findViewById(R.id.drag);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);

                        }
                    }
                }
            });
        }
    }
    //example adapter constructor to take in the arraylist of strings used in workout fragment
    public ExampleAdapter(ArrayList<String> List){
        mlist = List;
    }

    @NonNull
    @Override//This creates a view holder which is like a container that set what you want to view
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //we are passing example item layout into this view, this also calls to take in a click listener
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false );
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override//pass value to our view
    public void onBindViewHolder(@NonNull final ExampleViewHolder holder, int position) {
        //values are put into the view, takes in position as well
        final String currentItem = mlist.get(position);
        //get data and insert it into the recyclerview card
        //holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem);
//        holder.mTextView2.setText(currentItem.getText2());
//        holder.mTextView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (currentItem.toString()){
//                    case "Chest":
//
//                        break;
//                }
//
//            }
//        });

        holder.mDragImage.setImageResource(R.drawable.ic_drag);
        holder.mDragImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN)
                {
                    mListener.onDragClick(holder);


                }
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
    public String getName(int position){
        name = mlist.get(position);
        return name;
    }
}

