package com.example.homework_1;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class NumbersHolder extends RecyclerView.ViewHolder {

    TextView num;

    NumbersHolder(View itemView) {
        super(itemView);
        num = itemView.findViewById(R.id.num);
    }

    void bind(int listIndex) {
        num.setText(String.valueOf(listIndex));
        if (listIndex % 2 == 0) {
            num.setTextColor(Color.parseColor("#f44336"));
        } else {
            num.setTextColor(Color.parseColor("#01579b"));
        }
    }

}
