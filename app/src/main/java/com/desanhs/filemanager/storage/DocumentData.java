package com.desanhs.filemanager.storage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.util.ArrayList;

public class DocumentData {
    public static ArrayList<Document> getDocuments(Context context){
        ArrayList<Document> documents = new ArrayList<>();
        String uri = Environment.getExternalStorageDirectory().toString()+"/Download";
        File directory = new File(uri);
        File[] files = directory.listFiles();
        for(File file : files){
            documents.add(new Document(file.getName(), file.getPath(), file.isFile()));
        }
        String uri1 = Environment.getExternalStorageDirectory().toString()+"/Documents";
        File directory1 = new File(uri1);
        File[] files1 = directory1.listFiles();
        for(File file : files1){
            documents.add(new Document(file.getName(), file.getPath(), file.isFile()));
        }
        return documents;
    }
}
