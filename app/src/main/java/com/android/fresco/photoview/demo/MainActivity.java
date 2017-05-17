package com.android.fresco.photoview.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.anbetter.log.MLog;
import com.facebook.fresco.helper.Phoenix;

public class MainActivity extends AppCompatActivity {

    private TextView tvCacheSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Phoenix.init(this); // Context

        tvCacheSize = (TextView) findViewById(R.id.tv_cache_size);
        findViewById(R.id.btn_get_cache_size).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long cacheSize = Phoenix.getMainDiskStorageCacheSize();
                MLog.i("cacheSize = " + cacheSize);
                tvCacheSize.setText("已使用的缓存：" + (cacheSize/1024) + "kb");
            }
        });

        findViewById(R.id.btn_clear_memory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phoenix.clearCaches();

                long cacheSize = Phoenix.getMainDiskStorageCacheSize();
                MLog.i("cacheSize = " + cacheSize);
                tvCacheSize.setText("已使用的缓存：" + (cacheSize/1024) + "kb");
            }
        });

        findViewById(R.id.btn_open_photo_wall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PhotoWallActivity.class));
            }
        });

        findViewById(R.id.btn_open_photo_album).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PhotoAlbumActivity.class));
            }
        });

    }

}
