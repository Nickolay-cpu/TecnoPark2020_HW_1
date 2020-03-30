package com.example.homework_1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersHolder> {

    private int kolNum;
    private Context context;

    NumbersAdapter(int numberOfItem){
        kolNum = numberOfItem;
    }

    @NonNull
    @Override
    public NumbersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        int layoutIdForListItem = R.layout.item_number;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        return new NumbersHolder(view);

    }

    @Override
    public void onBindViewHolder(NumbersHolder holder, final int position) {
        holder.bind(position+1);
        holder.num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FragmentWithNumber.class);
                intent.putExtra("curNum", String.valueOf(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kolNum;
    }

    // Update 1
    void addItem(int position) {
        kolNum = position;
    }
}
