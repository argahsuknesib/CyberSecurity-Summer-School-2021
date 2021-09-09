package com.xiaomi.mico.music.patchwall.micoselect.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder.ViewHolder;
import com.xiaomi.smarthome.R;

public abstract class BaseItemBinder<VH extends ViewHolder> extends ItemViewBinder<ViewSection, VH> {
    public Context mContext;

    public BaseItemBinder(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: VH
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
    public void onBindViewHolder(VH r1, com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection r2, int r3) {
        /*
            r0 = this;
            r1.baseUpdateData(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder.onBindViewHolder(com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder$ViewHolder, com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection, int):void");
    }

    /* access modifiers changed from: protected */
    public void onViewAttachedToWindow(VH vh) {
        super.onViewAttachedToWindow((RecyclerView.O000OOo0) vh);
        vh.onViewAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onViewDetachedFromWindow(VH vh) {
        super.onViewDetachedFromWindow((RecyclerView.O000OOo0) vh);
        vh.onViewDetachedFromWindow();
    }

    public Context getContext() {
        return this.mContext;
    }

    static class ViewContainer extends FrameLayout {
        public ViewContainer(View view) {
            super(view.getContext());
            addView(view, new FrameLayout.LayoutParams(-1, -2));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public static FrameLayout createContainer(View view) {
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public abstract class ViewHolder extends RecyclerView.O000OOo0 {
        protected View mContentView;

        /* access modifiers changed from: protected */
        public void onViewAttachedToWindow() {
        }

        /* access modifiers changed from: protected */
        public void onViewDetachedFromWindow() {
        }

        public abstract void updateData(ViewSection viewSection, int i);

        public ViewHolder(View view) {
            super(BaseItemBinder.createContainer(view));
            this.mContentView = view;
        }

        public void baseUpdateData(ViewSection viewSection, int i) {
            updateData(viewSection, i);
        }

        private void setBackgroundColor(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.itemView.setBackgroundColor(Color.parseColor(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                this.itemView.setBackgroundResource(R.color.mj_color_white);
            }
        }

        public void setTextColor(TextView textView, String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    textView.setTextColor(Color.parseColor(str));
                    return;
                } catch (Exception unused) {
                }
            }
            textView.setTextColor(BaseItemBinder.this.getContext().getResources().getColor(i));
        }

        public void setTextSize(TextView textView, String str, int i) {
            int i2;
            if (TextUtils.isEmpty(str) || (i2 = Integer.parseInt(str)) <= 0) {
                i2 = i;
            }
            textView.setTextSize(1, (float) i2);
        }

        public void setTextAlign(TextView textView, String str, int i) {
            if (TextUtils.isEmpty(str)) {
                textView.setGravity(i);
            } else if (str.equals("left")) {
                textView.setGravity(3);
            } else if (str.equals("right")) {
                textView.setGravity(5);
            } else if (str.equals("center")) {
                textView.setGravity(17);
            } else {
                textView.setGravity(3);
            }
        }
    }
}
