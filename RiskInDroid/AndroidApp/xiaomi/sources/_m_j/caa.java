package _m_j;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.imageselector.MultiImageSelectorActivity;
import com.mi.global.shop.imageselector.bean.Image;
import com.mi.global.shop.imageselector.view.SquaredSimpleDraweeView;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class caa extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13509O000000o = "caa";
    public Context O00000Oo;
    public boolean O00000o = true;
    public boolean O00000o0 = true;
    public int O00000oO;
    public ArrayList<Image> O00000oo = new ArrayList<>();
    public ArrayList<String> O0000O0o = new ArrayList<>();
    final int O0000OOo;
    private LayoutInflater O0000Oo0;

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public caa(Context context, boolean z) {
        int i;
        this.O00000Oo = context;
        this.O0000Oo0 = (LayoutInflater) context.getSystemService("layout_inflater");
        this.O00000o0 = z;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            i = point.x;
        } else {
            i = windowManager.getDefaultDisplay().getWidth();
        }
        this.O0000OOo = i / 3;
    }

    public final void O000000o(boolean z) {
        if (this.O00000o0 != z) {
            this.O00000o0 = z;
            notifyDataSetChanged();
        }
    }

    public int getItemViewType(int i) {
        return (!this.O00000o0 || i != 0) ? 1 : 0;
    }

    public int getCount() {
        return this.O00000o0 ? this.O00000oo.size() + 1 : this.O00000oo.size();
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public Image getItem(int i) {
        if (!this.O00000o0) {
            return this.O00000oo.get(i);
        }
        if (i == 0) {
            return null;
        }
        return this.O00000oo.get(i - 1);
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        SimpleDraweeView f13510O000000o;
        ImageView O00000Oo;
        View O00000o0;

        O000000o(View view) {
            this.f13510O000000o = (SquaredSimpleDraweeView) view.findViewById(R.id.image);
            this.O00000Oo = (ImageView) view.findViewById(R.id.checkmark);
            this.O00000o0 = view.findViewById(R.id.mask);
            view.setTag(this);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View getView(int i, View view, ViewGroup viewGroup) {
        O000000o o000000o;
        Image O000000o2;
        if (this.O00000o0 && i == 0) {
            return this.O0000Oo0.inflate((int) R.layout.shop_mis_list_item_camera, viewGroup, false);
        }
        if (view == null) {
            view = this.O0000Oo0.inflate((int) R.layout.shop_mis_list_item_image, viewGroup, false);
            o000000o = new O000000o(view);
        } else {
            o000000o = (O000000o) view.getTag();
        }
        if (!(o000000o == null || (O000000o2 = getItem(i)) == null)) {
            if (caa.this.O00000o) {
                o000000o.O00000Oo.setVisibility(0);
                o000000o.O00000Oo.setSelected(false);
                o000000o.O00000o0.setVisibility(8);
                if (caa.this.O0000O0o != null && !TextUtils.isEmpty(O000000o2.f4887O000000o)) {
                    Iterator<String> it = caa.this.O0000O0o.iterator();
                    while (it.hasNext()) {
                        if (O000000o2.f4887O000000o.equals(it.next())) {
                            o000000o.O00000Oo.setSelected(true);
                            o000000o.O00000o0.setVisibility(0);
                        }
                    }
                }
            } else {
                o000000o.O00000Oo.setVisibility(8);
            }
            if (new File(O000000o2.f4887O000000o).exists()) {
                cbq.O000000o(O000000o2.f4887O000000o, o000000o.f13510O000000o, caa.this.O0000OOo, caa.this.O0000OOo);
            } else {
                o000000o.f13510O000000o.setImageResource(R.drawable.shop_default_pic_small_inverse);
            }
            o000000o.O00000Oo.setOnClickListener(new View.OnClickListener(O000000o2) {
                /* class _m_j.caa.O000000o.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Image f13511O000000o;

                {
                    this.f13511O000000o = r2;
                }

                public final void onClick(View view) {
                    if (caa.this.O0000O0o == null || caa.this.O0000O0o.size() != caa.this.O00000oO) {
                        if (O000000o.this.O00000Oo.isSelected()) {
                            O000000o.this.O00000Oo.setSelected(false);
                            O000000o.this.O00000o0.setVisibility(8);
                            if (caa.this.O0000O0o != null) {
                                caa.this.O0000O0o.remove(this.f13511O000000o.f4887O000000o);
                            }
                        } else {
                            O000000o.this.O00000Oo.setSelected(true);
                            O000000o.this.O00000o0.setVisibility(0);
                            if (caa.this.O0000O0o != null) {
                                caa.this.O0000O0o.add(this.f13511O000000o.f4887O000000o);
                            }
                        }
                        if (caa.this.O00000Oo instanceof MultiImageSelectorActivity) {
                            ((MultiImageSelectorActivity) caa.this.O00000Oo).updateDoneText();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(caa.this.O00000Oo, (int) R.string.mis_msg_amount_limit, 0).show();
                }
            });
        }
        return view;
    }
}
