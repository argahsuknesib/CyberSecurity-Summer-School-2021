package com.hannto.print.widget;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import com.otaliastudios.cameraview.CameraView;

public class ScanCameraView extends CameraView {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f4366O000000o;
    public DrawView O00000Oo;

    public ScanCameraView(Context context) {
        this(context, null);
    }

    public ScanCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4366O000000o = context;
        this.O00000Oo = new DrawView(this.f4366O000000o, null);
        addView(this.O00000Oo);
    }

    public void setPath(Path path) {
        this.O00000Oo.setPath(path);
    }
}
