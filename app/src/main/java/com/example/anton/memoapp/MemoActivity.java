package com.example.anton.memoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MemoActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    Button saveButton;
    EditText memoText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        myDb = new DatabaseHelper(this); // declare database helper class
        memoText = findViewById(R.id.memo); // find EditText
        saveButton = findViewById(R.id.save); //find save button
        AddMemo();
    }
    public void AddMemo(){
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDb.insertMemo(memoText.getText().toString()); //write EditText contents to database
              /*
               boolean isInserted = <-- move this in front of myDb
               if(isInserted = true){
                   Toast.makeText(MemoActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
               } else{
                   Toast.makeText(MemoActivity.this, "Data not inserted!",Toast.LENGTH_SHORT).show();
               }

               Toast is for debugging purposes to see if data was inserted

               */
             MemoActivity.super.finish(); //close activity on save
            }
        });
    }
}
