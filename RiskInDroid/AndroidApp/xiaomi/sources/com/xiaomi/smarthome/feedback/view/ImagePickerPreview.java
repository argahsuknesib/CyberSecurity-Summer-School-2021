package com.xiaomi.smarthome.feedback.view;

import _m_j.fwq;
import _m_j.inc;
import _m_j.iuo;
import _m_j.ixc;
import _m_j.ixe;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0002()B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fJ\u0011\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00072\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0002J(\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\b\u0010 \u001a\u00020\u000fH\u0014J\b\u0010!\u001a\u00020\u000fH\u0014J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\fJ\u000e\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0007J\b\u0010'\u001a\u00020\u000fH\u0002R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\nX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/xiaomi/smarthome/feedback/view/ImagePickerPreview;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mData", "Lcom/xiaomi/smarthome/feedback/view/ImagePickerPreview$LimitQueue;", "Landroid/util/Pair;", "", "Landroid/graphics/Bitmap;", "add", "", "filePath", "getPickedItems", "", "()[Ljava/lang/String;", "makeAddBtn", "Landroid/view/View;", "makePreviewView", "index", "pair", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDetachedFromWindow", "onFinishInflate", "remove", "position", "file", "setLimit", "limit", "updatePreview", "Companion", "LimitQueue", "smarthome-mine_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ImagePickerPreview extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f7426O000000o = new O000000o((byte) 0);
    public LimitQueue<Pair<String, Bitmap>> O00000Oo;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImagePickerPreview(Context context) {
        this(context, null, 0, 6, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImagePickerPreview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        ixe.O00000o(context, "context");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/feedback/view/ImagePickerPreview$Companion;", "", "()V", "REQUEST_ALBUM_CODE", "", "smarthome-mine_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImagePickerPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ixe.O00000o(context, "context");
        this.O00000Oo = new LimitQueue<>(3);
        setOrientation(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImagePickerPreview(Context context, AttributeSet attributeSet, int i, int i2, ixc ixc) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        super.onFinishInflate();
        O000000o();
    }

    public final void setLimit(int i) {
        this.O00000Oo = new LimitQueue<>(i);
        O000000o();
    }

    public final String[] getPickedItems() {
        Iterable<Pair> iterable = this.O00000Oo;
        Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
        for (Pair pair : iterable) {
            arrayList.add((String) pair.first);
        }
        Object[] array = ((List) arrayList).toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void O000000o() {
        removeAllViews();
        int i = 0;
        for (Object next : this.O00000Oo) {
            int i2 = i + 1;
            if (i < 0) {
                iuo.O000000o();
            }
            addView(O000000o(i, (Pair) next));
            i = i2;
        }
        if (!this.O00000Oo.O000000o()) {
            addView(O00000Oo());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.feedback.view.ImagePickerPreview, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private final View O000000o(int i, Pair<String, Bitmap> pair) {
        View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.feedback_image_pick_item, (ViewGroup) this, false);
        ((ImageView) inflate.findViewById(R.id.image)).setImageBitmap((Bitmap) pair.second);
        inflate.findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener(i) {
            /* class com.xiaomi.smarthome.feedback.view.$$Lambda$ImagePickerPreview$YFfo424t7Tuo7s2XxgeD6tCOYl4 */
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ImagePickerPreview.O000000o(ImagePickerPreview.this, this.f$1, view);
            }
        });
        ixe.O00000Oo(inflate, "item");
        return inflate;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.feedback.view.ImagePickerPreview, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private final View O00000Oo() {
        View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.feedback_image_pick_item, (ViewGroup) this, false);
        inflate.setBackgroundColor(getResources().getColor(R.color.mj_color_black_00_transparent));
        ((ImageView) inflate.findViewById(R.id.image)).setImageResource(R.drawable.image_pick_add);
        inflate.findViewById(R.id.delete_button).setVisibility(8);
        inflate.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.feedback.view.$$Lambda$ImagePickerPreview$ljY0lj8sROgl2guFeOF5t5waBs */

            public final void onClick(View view) {
                ImagePickerPreview.O000000o(ImagePickerPreview.this, view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(ImagePickerPreview imagePickerPreview, View view) {
        ixe.O00000o(imagePickerPreview, "this$0");
        Context context = imagePickerPreview.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            fwq.O000000o(activity, new inc(activity) {
                /* class com.xiaomi.smarthome.feedback.view.$$Lambda$ImagePickerPreview$fdQUe1ZhJdQi0HNURhDGdNaZgfM */
                private final /* synthetic */ Activity f$0;

                {
                    this.f$0 = r1;
                }

                public final void onAction(List list) {
                    ImagePickerPreview.O000000o(this.f$0, list);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Activity activity, List list) {
        ixe.O00000o(activity, "$activity");
        Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        activity.startActivityForResult(intent, 703);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/feedback/view/ImagePickerPreview$LimitQueue;", "E", "Ljava/util/LinkedList;", "limit", "", "(I)V", "isFull", "", "()Z", "add", "e", "(Ljava/lang/Object;)Z", "smarthome-mine_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LimitQueue<E> extends LinkedList<E> {
        private final int limit;

        public LimitQueue(int i) {
            this.limit = i;
        }

        public final boolean O000000o() {
            return size() >= this.limit;
        }

        public final boolean add(E e) {
            if (O000000o()) {
                return false;
            }
            return super.add(e);
        }

        public final /* bridge */ E remove(int i) {
            return super.remove(i);
        }

        public final /* bridge */ int size() {
            return super.size();
        }
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        for (Pair pair : this.O00000Oo) {
            if (pair.second != null && !((Bitmap) pair.second).isRecycled()) {
                ((Bitmap) pair.second).recycle();
            }
        }
        this.O00000Oo.clear();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(ImagePickerPreview imagePickerPreview, int i, View view) {
        Bitmap bitmap;
        ixe.O00000o(imagePickerPreview, "this$0");
        boolean z = false;
        if (i >= 0 && i < imagePickerPreview.O00000Oo.size()) {
            z = true;
        }
        if (z) {
            Pair remove = imagePickerPreview.O00000Oo.remove(i);
            if (!(remove == null || (bitmap = (Bitmap) remove.second) == null)) {
                bitmap.recycle();
            }
            imagePickerPreview.O000000o();
        }
    }
}
