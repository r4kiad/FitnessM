package com.simonh.fit.ChestFrag;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.simonh.fit.R;


import java.util.ArrayList;
//adapater for the chest fragment helps control the actions within that fragment
public class ChestAdapter extends RecyclerView.Adapter<ChestAdapter.ChestViewHolder>
{   //arraylist of the object class Chest Item
    private static ArrayList<ChestItem> chworkoutlist;
    //suppose to be integer variable for the plus and minus button
    private int bpnumber,IBPnumber,cfdnumber,dpnumber,clcrnumber,cfnumber = 0;


    //private OnObjectClickListener mListener;
    //private static String Weight;


//    public void setOnObjectClickListener(OnObjectClickListener listener){
//        mListener = listener;
//    }
//
//    public interface OnObjectClickListener{
//        void onObjectClick(int position);
//    }




    //viewholder to connect the variables to the chest item layout
    public static class ChestViewHolder extends RecyclerView.ViewHolder{
        public TextView nName, weight, lb;
        public Button mbtn, pbtn;


        public ChestViewHolder(final View itemView) {
            super(itemView);
            nName = itemView.findViewById(R.id.workout);
            weight = itemView.findViewById(R.id.weightdisplay);
            lb = itemView.findViewById(R.id.lb);
            mbtn = itemView.findViewById(R.id.mbtn);
            pbtn = itemView.findViewById(R.id.pbtn);
        }
//        public Button getPlusBtn(){
//            return pbtn;
//        }
//        public Button getMinusBtn(){
//            return mbtn;
//        }
//        public String getWeightTxt(int position){
//            Weight = ChestAdapter.chworkoutlist.get(position);
//            return Weight;
//        }
    }
    public ChestAdapter(ArrayList<ChestItem> list ){ chworkoutlist = list;}


    @NonNull
    @Override//same thing inflate the fragment with chest item layout
    public ChestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chest_item,viewGroup,false);
        ChestViewHolder cvh = new ChestViewHolder(v);
        return cvh;
    }
    //pass value into our view
    @Override//int i is for position
    public void onBindViewHolder(@NonNull final ChestViewHolder chestViewHolder,final  int i) {
        final String currentPosition = chworkoutlist.get(i).getWorkouName();

        chestViewHolder.nName.setText(currentPosition);
        chestViewHolder.weight.setText(Integer.toString(chworkoutlist.get(i).getWeightNumber()));
        //click listener for the minus m and plus p buttton
        chestViewHolder.mbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //I was playing around with this-> //if(chestViewHolder.mbtn.getVerticalScrollbarPosition())
                bpnumber = bpnumber - 10;
                chestViewHolder.weight.setText(Integer.toString(bpnumber));


            }
        });
        chestViewHolder.pbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                bpnumber = bpnumber + 10;
                chestViewHolder.weight.setText(Integer.toString(bpnumber));

            }
        });
//        switch(currentPosition){
//            case "Bench Press":
//                chestViewHolder.mbtn.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        bpnumber = bpnumber - 10;
//                        chestViewHolder.weight.setText(Integer.toString(bpnumber));
//                        bpnumber = 0;
//
//                    }
//                });
//                chestViewHolder.pbtn.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        bpnumber = bpnumber + 10;
//                        chestViewHolder.weight.setText(Integer.toString(bpnumber));
//                        bpnumber = 0;
//                    }
//                });
//            case "Incline Bench Press":
//                chestViewHolder.mbtn.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        IBPnumber = IBPnumber - 10;
//                        chestViewHolder.weight.setText(Integer.toString(IBPnumber));
//                        IBPnumber = 0;
//
//                    }
//                });
//                chestViewHolder.pbtn.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        IBPnumber = IBPnumber + 10;
//                        chestViewHolder.weight.setText(Integer.toString(IBPnumber));
//                        IBPnumber = 0;
//                    }
//                });
//            case "Chest Fly (Dumbbell)":
//                chestViewHolder.mbtn.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        chworkoutlist.get(i).setWeightNumber(cfdnumber = cfdnumber - 10);
//                        chestViewHolder.weight.setText(Integer.toString(chworkoutlist.get(i).getWeightNumber()));
//
//                    }
//                });
//                chestViewHolder.pbtn.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        chworkoutlist.get(i).setWeightNumber(cfdnumber = cfdnumber + 10);
//                        chestViewHolder.weight.setText(Integer.toString(chworkoutlist.get(i).getWeightNumber()));
//                    }
//                });
//            case "Dumbbell Press":
//                chestViewHolder.mbtn.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        chworkoutlist.get(i).setWeightNumber(dpnumber = dpnumber - 10);
//                        chestViewHolder.weight.setText(Integer.toString(chworkoutlist.get(i).getWeightNumber()));
//
//                    }
//                });
//                chestViewHolder.pbtn.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        chworkoutlist.get(i).setWeightNumber(dpnumber = dpnumber + 10);
//                        chestViewHolder.weight.setText(Integer.toString(chworkoutlist.get(i).getWeightNumber()));
//                    }
//                });
//            case "Cable Lower Chest Raise":
//                chestViewHolder.mbtn.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        chworkoutlist.get(i).setWeightNumber(clcrnumber = clcrnumber - 10);
//                        chestViewHolder.weight.setText(Integer.toString(chworkoutlist.get(i).getWeightNumber()));
//
//                    }
//                });
//                chestViewHolder.pbtn.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        chworkoutlist.get(i).setWeightNumber(clcrnumber = clcrnumber + 10);
//                        chestViewHolder.weight.setText(Integer.toString(chworkoutlist.get(i).getWeightNumber()));
//                    }
//                });
//            case "Cable Fly":
//                chestViewHolder.mbtn.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        chworkoutlist.get(i).setWeightNumber(cfnumber = cfnumber - 10);
//                        chestViewHolder.weight.setText(Integer.toString(chworkoutlist.get(i).getWeightNumber()));
//
//                    }
//                });
//                chestViewHolder.pbtn.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        chworkoutlist.get(i).setWeightNumber(cfnumber = cfnumber + 10);
//                        chestViewHolder.weight.setText(Integer.toString(chworkoutlist.get(i).getWeightNumber()));
//                    }
//                });
//
//        }





    }


    @Override
    public int getItemCount() {
        return chworkoutlist.size();
    }


}

