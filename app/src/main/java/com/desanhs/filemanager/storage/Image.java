package com.desanhs.filemanager.storage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

public class Image {
    private final int imgId;
    private final Uri uri;

    public Image(Uri uri, int imgId){
        this.uri = uri;
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public Uri getUri() {
        return uri;
    }
}
