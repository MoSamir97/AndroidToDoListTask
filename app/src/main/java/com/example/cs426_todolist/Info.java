package com.example.cs426_todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("description");
        //int icon = Integer.valueOf(intent.getIntExtra("icon"));

        TextView nameText = (TextView) findViewById(R.id.nameTextView);
        TextView descText = (TextView) findViewById(R.id.descriptionTextView);
//        ImageView iconImage = (ImageView) findViewById(R.id.image);

        nameText.setText(name);
        descText.setText(desc);
//        iconImage.setImageResource(icon);
    }

    public void close(View view) {
        finish();
    }
}