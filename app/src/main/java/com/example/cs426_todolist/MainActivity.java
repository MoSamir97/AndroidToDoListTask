package com.example.cs426_todolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Todo> todoList;
    private TodoListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView myListView = findViewById(R.id.listView);

        todoList = new ArrayList<>();
        for (int i = 0; i < 30; i++)
            todoList.add(new Todo("Job ("+ i + ")", "This is description of Job (" + i + ")", R.drawable.checkbox_off_background));

        adapter = new TodoListAdapter(this, R.layout.row, todoList);
        myListView.setAdapter(adapter);


        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView iconImage = (ImageView)findViewById(R.id.image);

                // The logic isn't correct
                if (view.getId() == iconImage.getId())  {
                    iconImage.setImageResource(R.drawable.checkbox_on_background);
                    //The code is not compelete ...
                }

                Intent intent = new Intent(getApplicationContext(), Info.class); //Make the intent

                /*Pass the information here*/
                intent.putExtra("name", todoList.get(position).getName());
                intent.putExtra("description", todoList.get(position).getDescription());
                intent.putExtra("icon", todoList.get(position).getIconIndex());

                //Lunch SecondActivity
                startActivity(intent);
            }
        });

        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                createDialog(view, position);
                return true;

            }
        });

    }

    public void createDialog(View view, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Item");
        builder.setMessage("Are you sure you want to delete this item?");
        builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                removeAnItem(position); //Execute the deletion
            }
        });

        AlertDialog alertDialog = builder.create();
        builder.show();
    }

    private void removeAnItem(int position) {
        Todo removedItem = todoList.get(position);
        todoList.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(getApplicationContext(), removedItem.getName() + " has been deleted.", Toast.LENGTH_SHORT).show();
    }


}