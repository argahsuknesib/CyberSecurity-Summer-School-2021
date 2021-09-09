package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;

public class GlideContext extends ContextWrapper {
    public GlideContext(Context context) {
        super(context);
    }
}
