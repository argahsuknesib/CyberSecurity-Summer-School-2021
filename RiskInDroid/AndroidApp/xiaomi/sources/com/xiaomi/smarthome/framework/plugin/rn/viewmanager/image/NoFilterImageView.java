package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.image;

import _m_j.gbu;
import android.annotation.SuppressLint;
import android.content.Context;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.ExtendGenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.react.views.image.GlobalImageLoadListener;
import com.facebook.react.views.image.ReactImageView;

@SuppressLint({"ViewConstructor"})
public class NoFilterImageView extends ReactImageView {
    public NoFilterImageView(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj) {
        super(context, abstractDraweeControllerBuilder, globalImageLoadListener, obj);
        setHierarchy(new ExtendGenericDraweeHierarchy(new GenericDraweeHierarchyBuilder(context.getResources()).setRoundingParams(RoundingParams.fromCornersRadius(0.0f))));
        getTopLevelDrawable().setFilterBitmap(false);
        gbu.O000000o("MHImageView...");
    }
}
