package _m_j;

import _m_j.hcc;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.library.common.widget.AutoSizeTextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class hgw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Drawable f18925O000000o = new ColorDrawable() {
        /* class _m_j.hgw.AnonymousClass1 */

        public final boolean isStateful() {
            return true;
        }
    };

    public static void O000000o(int i, hcc hcc, TextView textView, ImageView imageView) {
        List O00000Oo = hcc.O00000Oo();
        int i2 = hcc.O00000Oo;
        int size = O00000Oo.size();
        if (size == 1) {
            imageView.getLayoutParams().width = gpc.O00000o0(imageView.getContext(), 73.33f);
            imageView.getLayoutParams().height = gpc.O00000o0(imageView.getContext(), 73.33f);
            textView.setVisibility(8);
        } else if (i2 == 1 && size == 2 && i == 0) {
            imageView.getLayoutParams().width = gpc.O00000o0(imageView.getContext(), 43.33f);
            imageView.getLayoutParams().height = gpc.O00000o0(imageView.getContext(), 43.33f);
            textView.setVisibility(8);
        } else if (i2 == 6) {
            imageView.getLayoutParams().width = gpc.O00000o0(imageView.getContext(), 43.33f);
            imageView.getLayoutParams().height = gpc.O00000o0(imageView.getContext(), 43.33f);
            textView.setVisibility(8);
        } else if (i2 == 3 && size == 3) {
            hcc.O000000o o000000o = (hcc.O000000o) O00000Oo.get(2);
            if (i == 1 && o000000o.O00000o() && o000000o.O00000Oo != 4) {
                imageView.getLayoutParams().width = gpc.O00000o0(imageView.getContext(), 43.33f);
                imageView.getLayoutParams().height = gpc.O00000o0(imageView.getContext(), 43.33f);
                textView.setVisibility(8);
            }
        } else if (hcc instanceof hep) {
            int[] O000000o2 = O000000o((hep) hcc, i);
            if (O000000o2[0] == 2 && O000000o2[2] == 0 && ((hcc.O000000o) O00000Oo.get(i + 1)).O00000o()) {
                imageView.getLayoutParams().width = gpc.O00000o0(imageView.getContext(), 43.33f);
                imageView.getLayoutParams().height = gpc.O00000o0(imageView.getContext(), 43.33f);
                textView.setVisibility(8);
            }
        }
    }

    public static <T> void O000000o(hcc<? extends hcc.O000000o<T>, T> hcc, int i, TextView textView, int i2, AutoSizeTextView autoSizeTextView, TextView textView2) {
        int i3 = 2;
        if (hcc.O00000Oo == 4) {
            i3 = 3;
        } else if (hcc.O00000Oo != 2) {
            i3 = hcc instanceof hep ? O000000o((hep) hcc, i)[0] : 1;
        }
        float f = 54.0f;
        if (((hcc.O000000o) hcc.O00000Oo().get(i)).O00000oO()) {
            f = (float) (70.19999694824219d / Math.sqrt((double) Math.max(1, i2)));
        }
        float max = ((f - 15.0f) / ((float) Math.max(i3, 1))) + 15.0f;
        if (autoSizeTextView != null) {
            autoSizeTextView.setTextSize(15.0f, max, 1, 1);
        }
        if (textView != null) {
            textView.setTextSize(1, 15.0f);
        }
        if (textView2 != null) {
            textView2.setTextSize(1, 15.0f);
        }
    }

    public static void O000000o(SimpleDraweeView simpleDraweeView, Uri uri) {
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) simpleDraweeView.getHierarchy();
        genericDraweeHierarchy.setBackgroundImage(f18925O000000o);
        simpleDraweeView.setHierarchy(genericDraweeHierarchy);
        simpleDraweeView.setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setOldController(simpleDraweeView.getController())).setUri(uri).setCustomDrawableFactories(hce.f18771O000000o).setCustomDrawableFactory(hce.f18771O000000o).build());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    public static boolean O000000o(Object obj, Object obj2) {
        if (!Objects.equals(obj, obj2) && !String.valueOf(obj).equals(String.valueOf(obj2)) && hhc.O000000o(obj, -1.0d) != hhc.O000000o(obj2, -2.0d)) {
            return false;
        }
        return true;
    }

    private static int[] O000000o(hep hep, int i) {
        ArrayList<ArrayList<Integer>> arrayList = hep.O00000o;
        int[] iArr = {1, 0, 0};
        if (arrayList != null) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= arrayList.size()) {
                    break;
                }
                ArrayList arrayList2 = arrayList.get(i2);
                int size = arrayList2.size() + i3;
                if (i >= i3 && i < size) {
                    iArr[0] = arrayList2.size();
                    iArr[1] = i2;
                    iArr[2] = i - i3;
                    break;
                }
                i2++;
                i3 = size;
            }
        }
        return iArr;
    }
}
