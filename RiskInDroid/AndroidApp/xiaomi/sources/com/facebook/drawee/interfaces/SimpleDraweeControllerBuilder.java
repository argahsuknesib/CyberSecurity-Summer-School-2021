package com.facebook.drawee.interfaces;

import android.net.Uri;

public interface SimpleDraweeControllerBuilder {
    DraweeController build();

    SimpleDraweeControllerBuilder setCallerContext(Object obj);

    SimpleDraweeControllerBuilder setOldController(DraweeController draweeController);

    SimpleDraweeControllerBuilder setUri(Uri uri);

    SimpleDraweeControllerBuilder setUri(String str);
}
