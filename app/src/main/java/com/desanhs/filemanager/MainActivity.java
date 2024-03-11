package com.desanhs.filemanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.desanhs.filemanager.storage.Storage;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Storage storage = new Storage();

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView chartCenter = (TextView) findViewById(R.id.storage);
        TextView freeIdentifier = (TextView) findViewById(R.id.free);
        TextView totalIdentifier = (TextView) findViewById(R.id.totalIdentifier);
        ProgressBar freeSpace = (ProgressBar) findViewById(R.id.stats_progressbar);
        LinearLayout imagesButton = (LinearLayout) findViewById(R.id.images_button);
        LinearLayout audiosButton = (LinearLayout) findViewById(R.id.audios_button);
        LinearLayout videosButton = (LinearLayout) findViewById(R.id.videos_button);
        LinearLayout docsButton = (LinearLayout) findViewById(R.id.docs_button);
        LinearLayout appsButton = (LinearLayout) findViewById(R.id.apps_button);
        LinearLayout foldersButton = (LinearLayout) findViewById(R.id.folders_button);

        chartCenter.setText(storage.getFree() + " GB Free");
        freeIdentifier.setText(storage.getFree() + " GB Free");
        totalIdentifier.setText(storage.getTotal() + " GB Total");
        freeSpace.setProgress(100 * Integer.parseInt(storage.getFree()) / Integer.parseInt(storage.getTotal()));

        imagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ImageActivity.class);
                startActivity(i);
            }
        });

        audiosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AudiosActivity.class);
                startActivity(intent);
            }
        });

        videosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideosActivity.class);
                startActivity(intent);
            }
        });

        docsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DocumentsActivity.class);
                startActivity(intent);
            }
        });

        appsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AppsActivity.class);
                startActivity(intent);
            }
        });

        foldersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoldersActivity.class);
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}