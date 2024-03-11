package com.desanhs.filemanager.storage;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

public class ImageData {
    public static ArrayList<Image> getImages(Context context){
        ArrayList<Image> images = new ArrayList<>();
        Uri uri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.MediaColumns._ID};

        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
        if(cursor != null){
            while (cursor.moveToNext()){
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.MediaColumns._ID));
                images.add(new Image(uri, id));
            }
            cursor.close();
        }
        return images;
    }
}
