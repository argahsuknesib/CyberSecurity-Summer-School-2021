package _m_j;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.imageselector.view.SquaredSimpleDraweeView;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class bzz extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f13505O000000o = 5;
    public List<String> O00000Oo = new ArrayList();
    private Activity O00000o;
    final int O00000o0;
    private LayoutInflater O00000oO;

    public final long getItemId(int i) {
        return (long) i;
    }

    public bzz(Activity activity) {
        int i;
        this.O00000o = activity;
        this.O00000oO = (LayoutInflater) activity.getSystemService("layout_inflater");
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            i = point.x;
        } else {
            i = windowManager.getDefaultDisplay().getWidth();
        }
        this.O00000o0 = i / 4;
    }

    public final void O000000o(List<String> list) {
        this.O00000Oo.clear();
        if (list == null || list.size() <= 0) {
            this.O00000Oo.clear();
        } else {
            this.O00000Oo = list;
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.O00000Oo.size() < f13505O000000o ? this.O00000Oo.size() + 1 : this.O00000Oo.size();
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public String getItem(int i) {
        return this.O00000Oo.get(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View getView(final int i, View view, ViewGroup viewGroup) {
        O000000o o000000o;
        if (view == null) {
            view = this.O00000oO.inflate((int) R.layout.shop_grid_item, viewGroup, false);
            o000000o = new O000000o(view);
        } else {
            o000000o = (O000000o) view.getTag();
        }
        o000000o.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.bzz.AnonymousClass1 */

            public final void onClick(View view) {
                bzz.this.O00000Oo.remove(i);
                bzz.this.notifyDataSetChanged();
            }
        });
        if (i == this.O00000Oo.size()) {
            SimpleDraweeView simpleDraweeView = o000000o.f13507O000000o;
            int i2 = this.O00000o0;
            cbq.O000000o(simpleDraweeView, i2, i2);
        } else {
            String O000000o2 = getItem(i);
            if (!TextUtils.isEmpty(O000000o2) && new File(O000000o2).exists()) {
                SimpleDraweeView simpleDraweeView2 = o000000o.f13507O000000o;
                int i3 = this.O00000o0;
                cbq.O000000o(O000000o2, simpleDraweeView2, i3, i3);
            }
        }
        return view;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public SimpleDraweeView f13507O000000o;
        public ImageView O00000Oo;

        O000000o(View view) {
            this.f13507O000000o = (SquaredSimpleDraweeView) view.findViewById(R.id.image);
            this.O00000Oo = (ImageView) view.findViewById(R.id.checkmark);
            view.setTag(this);
        }
    }
}
