package com.example.homework_1;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FragmentWithNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        TextView fragItem = findViewById(R.id.fragItem);
        // Get Number from activity_main
        String curNum = getIntent().getStringExtra("curNum");
        assert curNum != null;
        int cur = Integer.parseInt(curNum) + 1;

        fragItem.setText(String.valueOf(cur));

        if (cur % 2 == 0) {
            fragItem.setTextColor(Color.parseColor("#f44336"));
        } else {
            fragItem.setTextColor(Color.parseColor("#01579b"));
        }
    }

}