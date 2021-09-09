package com.squareup.picasso;

import _m_j.dvt;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.RemoteViews;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import java.io.File;

public class Picasso {
    private static volatile Picasso picasso;
    private final Context context;

    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    /* access modifiers changed from: package-private */
    public void cancelExistingRequest(Object obj) {
    }

    public void cancelTag(Object obj) {
    }

    public void shutdown() {
    }

    private Picasso(Context context2) {
        this.context = context2;
        dvt.O000000o();
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(context2, ImagePipelineConfig.newBuilder(context2).setDownsampleEnabled(true).setResizeAndRotateEnabledForNetwork(true).setBitmapsConfig(Bitmap.Config.RGB_565).build());
        }
    }

    public static Picasso get() {
        if (picasso == null) {
            synchronized (Picasso.class) {
                if (picasso == null) {
                    picasso = new Picasso(PicassoProvider.context);
                }
            }
        }
        return picasso;
    }

    public RequestCreator load(Uri uri) {
        return new RequestCreator(uri.getPath(), this.context);
    }

    public RequestCreator load(String str) {
        return new RequestCreator(str, this.context);
    }

    public RequestCreator load(File file) {
        return new RequestCreator(file.getAbsolutePath(), this.context);
    }

    public RequestCreator load(int i) {
        if (i != 0) {
            return new RequestCreator("res:///".concat(String.valueOf(i)), this.context);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    public void cancelRequest(ImageView imageView) {
        if (imageView != null) {
            cancelExistingRequest(imageView);
            return;
        }
        throw new IllegalArgumentException("view cannot be null.");
    }

    public void cancelRequest(Target target) {
        if (target != null) {
            cancelExistingRequest(target);
            return;
        }
        throw new IllegalArgumentException("target cannot be null.");
    }

    public void cancelRequest(RemoteViews remoteViews, int i) {
        if (remoteViews == null) {
            throw new IllegalArgumentException("remoteViews cannot be null.");
        }
    }

    public void pauseTag(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("tag == null");
        }
    }

    public void resumeTag(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("tag == null");
        }
    }

    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        
        final int debugColor;

        private LoadedFrom(int i) {
            this.debugColor = i;
        }
    }
}
