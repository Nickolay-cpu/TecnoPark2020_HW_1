package com.example.homework_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private RecyclerView numberGrid;
    private NumbersAdapter numbersAdapter;
    private int colon;
    Button plusItem;
    public static final String NUMBER = "Number";
    int i = 100; // number of elements
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  determine the orientation
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            colon = 3;
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            colon = 4;

        numberGrid = findViewById(R.id.rv);
        numberGrid.setLayoutManager(new GridLayoutManager(this, colon));
        numberGrid.setHasFixedSize(true);

        restoreState(savedInstanceState);

        numbersAdapter = new NumbersAdapter(i);
        numberGrid.setAdapter(numbersAdapter);

        //create Button
        plusItem = findViewById(R.id.plusItem);
        plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                numbersAdapter = new NumbersAdapter(i);
                numberGrid.setAdapter(numbersAdapter);
                numberGrid.scrollToPosition(Objects.requireNonNull(numberGrid.getAdapter()).getItemCount() - 1);
            }
        });

    }

    private void restoreState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            i = savedInstanceState.getInt(NUMBER);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NUMBER, i);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
