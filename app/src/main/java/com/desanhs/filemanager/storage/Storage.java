package com.desanhs.filemanager.storage;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

public class Storage {

    private final String path;
    private final StatFs statFs;
    private final String free;
    private final String total;

    public Storage(){
        this.path = Environment.getDataDirectory().getPath();
        statFs = new StatFs(this.path);
        this.free = getFreeStorage();
        this.total = getUsingStorage();
    }

    private String getFreeStorage(){
        long bytesAvailable;
        bytesAvailable = statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();

        return Long.toString(bytesAvailable / (1024 * 1024 * 1024));
    }

    private String getUsingStorage(){
        long bytesUsing;
        bytesUsing = statFs.getBlockSizeLong() * statFs.getBlockCountLong();

        return Long.toString(bytesUsing / (1000 * 1000 * 1000));
    }

    public String getFree(){
        return this.free;
    }

    public String getTotal(){
        return this.total;
    }
}
