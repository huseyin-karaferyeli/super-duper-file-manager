package com.desanhs.filemanager.storage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.desanhs.filemanager.R;

import java.util.ArrayList;

public class DocumentAdapter extends ArrayAdapter<Document> {
    public DocumentAdapter(@NonNull Context context, ArrayList<Document> documents) {
        super(context, 0, documents);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;

        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.single_document, parent, false);
        }

        Document document = getItem(position);
        TextView name = listView.findViewById(R.id.fileName);
        ImageView icon = listView.findViewById(R.id.fileIcon);

        name.setText(document.getName());
        if(document.isFile())
            icon.setImageResource(R.drawable.file);
        else
            icon.setImageResource(R.drawable.folder);

        return listView;
    }
}
