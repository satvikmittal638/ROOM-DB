package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class AddNotes extends AppCompatActivity {
EditText etNewNotes;
static String INTENT_NAME="REPLY FROM AddNotes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        etNewNotes=findViewById(R.id.etNewNotes);

    }

    //runs when a user clicks the back button
 @Override
    public void onBackPressed(){
     Intent replyIntent=new Intent();
     String notes=etNewNotes.getText().toString();

     if(!notes.isEmpty()) {
         replyIntent.putExtra(INTENT_NAME, notes);
         setResult(RESULT_OK, replyIntent);
     }
     else
         setResult(RESULT_CANCELED,replyIntent);

     finish(); //current activity gets killed and returns to the MainActivity
    }
}