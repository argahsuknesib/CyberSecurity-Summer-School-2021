package com.facebook.react.views.art;

import android.view.View;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;

public class ARTRenderableViewManager extends ViewManager<View, ReactShadowNode> {
    private final String mClassName;

    public static ARTRenderableViewManager createARTGroupViewManager() {
        return new ARTGroupViewManager();
    }

    public static ARTRenderableViewManager createARTShapeViewManager() {
        return new ARTShapeViewManager();
    }

    public static ARTRenderableViewManager createARTTextViewManager() {
        return new ARTTextViewManager();
    }

    ARTRenderableViewManager(String str) {
        this.mClassName = str;
    }

    public String getName() {
        return this.mClassName;
    }

    public ReactShadowNode createShadowNodeInstance() {
        if ("ARTGroup".equals(this.mClassName)) {
            return new ARTGroupShadowNode();
        }
        if ("ARTShape".equals(this.mClassName)) {
            return new ARTShapeShadowNode();
        }
        if ("ARTText".equals(this.mClassName)) {
            return new ARTTextShadowNode();
        }
        throw new IllegalStateException("Unexpected type " + this.mClassName);
    }

    public Class<? extends ReactShadowNode> getShadowNodeClass() {
        if ("ARTGroup".equals(this.mClassName)) {
            return ARTGroupShadowNode.class;
        }
        if ("ARTShape".equals(this.mClassName)) {
            return ARTShapeShadowNode.class;
        }
        if ("ARTText".equals(this.mClassName)) {
            return ARTTextShadowNode.class;
        }
        throw new IllegalStateException("Unexpected type " + this.mClassName);
    }

    public View createViewInstance(ThemedReactContext themedReactContext) {
        throw new IllegalStateException("ARTShape does not map into a native view");
    }

    public void updateExtraData(View view, Object obj) {
        throw new IllegalStateException("ARTShape does not map into a native view");
    }
}
