package com.desanhs.filemanager.storage;

import android.net.Uri;

public class Document {
    private final String name;
    private final String  path;
    private final boolean isFile;

    public Document(String name, String path, boolean isFile){
        this.name = name;
        this.path = path;
        this.isFile = isFile;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public boolean isFile() {
        return isFile;
    }
}
