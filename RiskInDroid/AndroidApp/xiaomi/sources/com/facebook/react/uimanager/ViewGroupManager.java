package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.WeakHashMap;

public abstract class ViewGroupManager<T extends ViewGroup> extends BaseViewManager<T, LayoutShadowNode> implements IViewManagerWithChildren {
    private static WeakHashMap<View, Integer> mZIndexHash = new WeakHashMap<>();

    public boolean needsCustomLayoutForChildren() {
        return false;
    }

    public boolean shouldPromoteGrandchildren() {
        return false;
    }

    public void updateExtraData(T t, Object obj) {
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new LayoutShadowNode();
    }

    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return LayoutShadowNode.class;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public void addView(T r1, android.view.View r2, int r3) {
        /*
            r0 = this;
            r1.addView(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ViewGroupManager.addView(android.view.ViewGroup, android.view.View, int):void");
    }

    public void addViews(T t, List<View> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            addView(t, list.get(i), i);
        }
    }

    public static void setViewZIndex(View view, int i) {
        mZIndexHash.put(view, Integer.valueOf(i));
    }

    public static Integer getViewZIndex(View view) {
        return mZIndexHash.get(view);
    }

    public int getChildCount(T t) {
        return t.getChildCount();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public android.view.View getChildAt(T r1, int r2) {
        /*
            r0 = this;
            android.view.View r1 = r1.getChildAt(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ViewGroupManager.getChildAt(android.view.ViewGroup, int):android.view.View");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public void removeViewAt(T r1, int r2) {
        /*
            r0 = this;
            r1.removeViewAt(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ViewGroupManager.removeViewAt(android.view.ViewGroup, int):void");
    }

    public void removeView(T t, View view) {
        for (int i = 0; i < getChildCount(t); i++) {
            if (getChildAt(t, i) == view) {
                removeViewAt(t, i);
                return;
            }
        }
    }

    public void removeAllViews(T t) {
        for (int childCount = getChildCount(t) - 1; childCount >= 0; childCount--) {
            removeViewAt(t, childCount);
        }
    }
}
