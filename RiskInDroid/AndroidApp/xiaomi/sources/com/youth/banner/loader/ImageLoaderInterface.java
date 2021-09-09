package com.youth.banner.loader;

import android.content.Context;
import android.view.View;
import java.io.Serializable;

public interface ImageLoaderInterface<T extends View> extends Serializable {
    T createImageView(Context context);

    void displayImage(Context context, Object obj, View view);
}
