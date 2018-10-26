package com.learn.uzair.daypinpoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView result = findViewById(R.id.day);
        TextView date = findViewById(R.id.date);
        TextView dtIslamic = findViewById(R.id.hijrahstring);   //binds widgets with back-code.

        String res = getIntent().getStringExtra("Result");
        String dateString = getIntent().getStringExtra("Date");
        String dtIslamicString = getIntent().getStringExtra("Islamic Date"); //receives info from input.java

        result.setText(res);
        date.setText(dateString);
        dtIslamic.setText(dtIslamicString); //sets texts to corresponding TextView

        Button backbutton = findViewById(R.id.backbutton); //declaring and binds the button.
        backbutton.setOnClickListener(e -> startActivity(new Intent(getApplicationContext(),input.class))); //go back to input activity
    }
}
