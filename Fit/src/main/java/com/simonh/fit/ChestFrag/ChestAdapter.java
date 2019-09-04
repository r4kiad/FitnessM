package com.simonh.fit.ChestFrag;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.simonh.fit.DatabaseHelper;
import com.simonh.fit.R;


import java.util.ArrayList;
//adapater for the chest fragment helps control the actions within that fragment
public class ChestAdapter extends RecyclerView.Adapter<ChestAdapter.ChestViewHolder>
{   //arraylist of the object class Chest Item
    DatabaseHelper myDB;
    private static ArrayList<ChestItem> chworkoutlist;

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
        public Button setbtn;


        public ChestViewHolder(final View itemView) {
            super(itemView);
            nName = itemView.findViewById(R.id.workout);
            weight = itemView.findViewById(R.id.weightdisplay);
            lb = itemView.findViewById(R.id.lb);
            setbtn = itemView.findViewById(R.id.setBtn);

        }

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
        chestViewHolder.setbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //function to add to a database
                openDialog(v);



            }
        });


    }


    @Override
    public int getItemCount() {
        return chworkoutlist.size();
    }
    public void openDialog(View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
        View mView = LayoutInflater.from(view.getContext()).inflate(R.layout.layout_dialog,null);
        final EditText text_weight = (EditText)mView.findViewById(R.id.edit_weight);
        Button btn_add = (Button)mView.findViewById(R.id.add);

        alert.setView(mView);
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCancelable(true);

        btn_add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isWeightSet = myDB.insertWeight(text_weight.getText().toString());
                if(isWeightSet = true )
                    Toast.makeText(v.getContext(),"Weight has been set",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(v.getContext(),"Weight not set Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.show();
    }


}

