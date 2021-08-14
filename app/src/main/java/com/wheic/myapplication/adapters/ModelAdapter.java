package com.wheic.myapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wheic.myapplication.HealthcareActivity;
import com.wheic.myapplication.R;

import java.util.ArrayList;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder>{

    ArrayList<model>educationData ;
    ArrayList<model>heathCareData ;
    Activity act ;
    HealthcareActivity h;

    public interface onClickListener
    {

        void onItemClicked(int i);

    }

    onClickListener onc;
    ModelAdapter m;
    @NonNull
    @Override
    public ModelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_models,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelAdapter.ViewHolder holder, int position) {

        if(act.equals(h))
        {
            holder.itemView.setTag(heathCareData.get(position));

            holder.t1.setText(heathCareData.get(position).getName());
            holder.t2.setText(heathCareData.get(position).getDetails());

            if(heathCareData.get(position).getName()=="Ear")
                holder.i1.setImageResource(R.drawable.ear);
            else if(heathCareData.get(position).getName()=="Eye")
                holder.i1.setImageResource(R.drawable.eye);
            else if(heathCareData.get(position).getName()=="Skull")
                holder.i1.setImageResource(R.drawable.skull);

        }
        else
        {
            holder.itemView.setTag(educationData.get(position));

            holder.t1.setText(educationData.get(position).getName());
            holder.t2.setText(educationData.get(position).getDetails());

            if(educationData.get(position).getName()=="Satellite")
                holder.i1.setImageResource(R.drawable.satellite);
            else if(educationData.get(position).getName()=="Saturn")
                holder.i1.setImageResource(R.drawable.saturn);
            else if(educationData.get(position).getName()=="Black hole")
                holder.i1.setImageResource(R.drawable.bh);

        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public ModelAdapter(Context con, ArrayList<model> data,ArrayList<model> data2)
    {
        this.educationData=data;
        this.heathCareData=data2;
        Log.d("Size","Size"+data.size());
        onc=(onClickListener)con;
        act = ((Activity) con).getParent();

    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView i1,i2;
        TextView t1,t2;

        public ViewHolder(@NonNull final View itemView)
        {
            super(itemView);
            i1=itemView.findViewById(R.id.iView1);
            i2=itemView.findViewById(R.id.iView2);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);

            if(act==h) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onc.onItemClicked(heathCareData.indexOf(itemView.getTag()));
                        int index = heathCareData.indexOf(itemView.getTag());
//                    Toast.makeText(this,"Item clicked:"+index ,Toast.LENGTH_SHORT).show();
                        Log.d("Clicked", "Item Clicked:" + index);
                    }
                });

//                i2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//              if (heathCareData.get(heathCareData.indexOf(itemView.getTag())).getName()=="Eye"){
//                   Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.Eye ");
//                if (launchIntent != null)
//                {
//                    startActivity(launchIntent);
//                }
//                else {
//                    Toast.makeText(HealthcareActivity.this, "No such package", Toast.LENGTH_LONG).show();
//                }
//                    }
//                });
//            }
            }
            else
            {

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onc.onItemClicked(educationData.indexOf(itemView.getTag()));
                        int index = educationData.indexOf(itemView.getTag());
//                    Toast.makeText(this,"Item clicked:"+index ,Toast.LENGTH_SHORT).show();
                        Log.d("Clicked", "Item Clicked:" + index);
                    }
                });
            }


        }
    }

}
