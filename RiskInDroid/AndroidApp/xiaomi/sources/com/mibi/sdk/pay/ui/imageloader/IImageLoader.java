package com.mibi.sdk.pay.ui.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public interface IImageLoader {
    IImageLoader get(Context context);

    void into(ImageView imageView);

    IImageLoader load(String str);

    IImageLoader placeholder(int i);

    IImageLoader placeholder(Drawable drawable);
}
