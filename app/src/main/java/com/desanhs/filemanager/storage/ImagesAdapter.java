package com.desanhs.filemanager.storage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.desanhs.filemanager.R;

import java.util.ArrayList;

public class ImagesAdapter extends ArrayAdapter<Image> {
    public ImagesAdapter(@NonNull Context context, ArrayList<Image> images) {
        super(context, 0, images);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.single_image, parent, false);
        }
        Image image = getItem(position);
        ImageView imageView = listItemView.findViewById(R.id.singleImage);

        imageView.setImageURI(Uri.withAppendedPath(image.getUri(), Integer.toString(image.getImgId())));
        return listItemView;
    }
}
