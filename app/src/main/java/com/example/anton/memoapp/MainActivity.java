package com.example.anton.memoapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button addButton;
    DatabaseHelper myDb;
    ArrayList<TextView> memoViewList = new ArrayList<>(); // empty list of TextViews

    public void addMemo(){

        addButton = findViewById(R.id.button); //Find new memo button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {

                Intent add_memo = new Intent(MainActivity.this,MemoActivity.class); // Declare intent to launch new activity
                startActivity(add_memo); // Launch activity
            }
        });


    }

    public void getMemos(){
        ConstraintLayout constraintLayout = (ConstraintLayout)findViewById(R.id.main);
        //constraintLayout.removeAllViews();
        Cursor memos = myDb.getAllData();
        if(memos.getCount() == 0) {
            return;
        }
        // Db query for all memos
        while(memos.moveToNext()){
            final TextView memoView = new TextView(this); //create new textview
            memoView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,75)); //setting layout params
            memoViewList.add(memoView);
            constraintLayout.addView(memoView);
            //Find a way to replace this with something that works
        }
        // Show all data goes here
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        addMemo();
        getMemos();
    }


}
