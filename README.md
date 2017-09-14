# FrescoPhoto
基于Fresco的大图浏览组件

Fresco在GitHub上的项目地址：https://github.com/facebook/fresco

目前是基于Fresco `1.5.0`这个版本。

在使用到fresco-helper库的Module中的build.gradle文件里，添加以下依赖：
```
 allprojects {
    repositories {
        jcenter()

        maven {
            url 'https://dl.bintray.com/hpdx/maven/'
        }
    }
 }

 compile 'com.facebook.fresco.helper:fresco-photoview:1.3.3'
```

## 目前支持
* 点击照片墙中的缩略图，打开和关闭效果类似微信朋友圈的图片查看效果
* 支持双击放大效果
* 支持单击关闭大图浏览
* 支持手势缩放功能
* 支持屏蔽长按事件
* 支持扩展，可以自定义浏览大图的UI风格

[下载示例Apk](https://github.com/hpdx/FrescoPhoto/blob/master/app-debug.apk)

## 示例效果如下：

从网络加载的图片墙

<img src="http://img.blog.csdn.net/20161114234539401" width="320px" />

点击图片墙中的照片后，打开的浏览大图界面

<img src="http://img.blog.csdn.net/20161114234557482" width="320px" />

## 使用：
详细细节请查看`PhotoWallActivity`中的示例

初始化
```
 Phoenix.init(this); // Context
```

加载缩略图
```
 Phoenix.with((SimpleDraweeView)itemView)
        .setWidth(itemDimensionSize)
        .setHeight(itemDimensionSize)
        .load(photoInfo.thumbnailUrl);
```
fresco-helper在GitHub上的项目地址：https://github.com/hpdx/fresco-helper

带动画的效果打开方式（多图）
```
ArrayList<PhotoInfo> photos = null;
PictureBrowse.newBuilder(PhotoWallActivity.this)
             .setLayoutManager(mLayoutManager)
             .setPhotoList(photos)
             .setCurrentPosition(position)
             .enabledAnimation(true)
             .start();
```

无动画效果的打开方式（多图）
```
 ArrayList<PhotoInfo> photos = null;
 PictureBrowse.newBuilder(PhotoWallActivity.this)
              .setPhotoList(photos)
              .setCurrentPosition(position)
              .start();
```

带动画效果的打开方式（只有一张图片）
```
String originalUrl = photos.get(position).originalUrl;
PictureBrowse.newBuilder(PhotoWallActivity.this)
             .setThumbnailView(view)
             .setOriginalUrl(originalUrl)
             .enabledAnimation(true)
             .start();
```

无动画效果的打开方式（只有一张图片）
```
String originalUrl = photos.get(position).originalUrl;
PictureBrowse.newBuilder(PhotoWallActivity.this)
             .setOriginalUrl(originalUrl)
             .start();
```

屏蔽长按事件
```
PictureBrowse.newBuilder(PhotoWallActivity.this, PhotoBrowseActivity.class)
             .setLayoutManager(mLayoutManager)
             .setPhotoList(photos)
             .setCurrentPosition(position)
             .enabledAnimation(true)
             .toggleLongClick(false) // 屏蔽长按事件
             .start();
```

支持扩展，可以自定义浏览大图的UI风格
```
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
                MLog.i("mPhotoIndex = " + mPhotoIndex);

                PhotoInfo photoInfo = mItems.get(mPhotoIndex);
                MLog.i("originalUrl = " + photoInfo.originalUrl);

            }
        });
    }

    @Override
    public boolean onLongClick(View view) {
        MLog.i("currentPosition = " + getCurrentPosition());

        PhotoInfo photoInfo = getCurrentPhotoInfo();
        MLog.i("current originalUrl = " + photoInfo.originalUrl);

        return super.onLongClick(view);
    }

}

```


欢迎提issuse ! 若你觉得还不错，请点Star, 谢谢！

