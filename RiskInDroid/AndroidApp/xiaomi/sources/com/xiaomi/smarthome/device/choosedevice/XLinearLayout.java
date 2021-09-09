package com.xiaomi.smarthome.device.choosedevice;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;

public class XLinearLayout extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private SparseArray<LinkedList<RecyclerView.O000OOo0>> f7278O000000o = new SparseArray<>();
    private SparseArray<LinkedList<View>> O00000Oo = new SparseArray<>();

    public XLinearLayout(Context context) {
        super(context);
        setSoundEffectsEnabled(false);
    }

    public XLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setSoundEffectsEnabled(false);
    }

    public XLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setSoundEffectsEnabled(false);
    }

    public void setOnItemClickListener(final AdapterView.OnItemClickListener onItemClickListener) {
        int childCount = getChildCount();
        for (final int i = 0; i < childCount; i++) {
            getChildAt(i).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.choosedevice.XLinearLayout.AnonymousClass1 */

                public final void onClick(View view) {
                    onItemClickListener.onItemClick(null, view, i, (long) view.getId());
                }
            });
        }
    }

    public void playSoundEffect(final int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.playSoundEffect(i);
        } else {
            post(new Runnable() {
                /* class com.xiaomi.smarthome.device.choosedevice.XLinearLayout.AnonymousClass2 */

                public final void run() {
                    XLinearLayout.super.playSoundEffect(i);
                }
            });
        }
    }
}
