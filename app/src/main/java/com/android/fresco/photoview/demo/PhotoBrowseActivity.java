package com.android.fresco.photoview.demo;

import android.view.View;

import com.anbetter.log.MLog;
import com.facebook.fresco.helper.photoview.PictureBrowseActivity;

/**
 * Created by android_ls on 2017/1/20.
 */

public class PhotoBrowseActivity extends PictureBrowseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_photo_browse;
    }

    @Override
    protected void setupViews() {
        super.setupViews();
        findViewById(R.id.rl_top_deleted).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MLog.i("用户点击了删除按钮");

            }
        });
    }


}
