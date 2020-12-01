package com.example.cs426_todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TodoListAdapter extends ArrayAdapter<Todo> {
    private Context mContext;
    int mRsource;

    public TodoListAdapter(@NonNull Context context, int resource, @NonNull List<Todo> objects) {
        super(context, resource, objects);
        mContext = context;
        mRsource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String description = getItem(position).getDescription();
        int iconIndex = getItem(position).getIconIndex();

        Todo todo = new Todo(name, description, iconIndex);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mRsource, parent, false);


        TextView nameText = (TextView) convertView.findViewById(R.id.nameTextView);
        TextView descriptionText = (TextView) convertView.findViewById(R.id.descriptionTextView);
        ImageView iconImage = (ImageView) convertView.findViewById(R.id.image);

        nameText.setText(name);
        descriptionText.setText(description);
        iconImage.setImageResource(iconIndex);

        return convertView;
    }
}
