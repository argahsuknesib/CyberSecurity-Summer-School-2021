package _m_j;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hln {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f19041O000000o;
    public TitleBarMenu O00000Oo;
    public View.OnClickListener O00000o;
    public O00000o0 O00000o0;
    private final O00000Oo O00000oO = new O00000Oo("inner:share_menu_id", "") {
        /* class _m_j.hln.AnonymousClass1 */

        public final void O000000o(View view, TitleBarMenu.O000000o o000000o) {
            if (hln.this.O00000o != null) {
                hln.this.O00000o.onClick(view);
            }
        }
    };

    public interface O00000o0 {
        void O000000o(View view, TitleBarMenu.O000000o o000000o, String str);
    }

    static class O00000Oo extends TitleBarMenu.O000000o {
        public O00000Oo(String str, String str2) {
            super(str, str2);
            this.O00000oO = R.drawable.std_tittlebar_main_device_share;
        }
    }

    public hln(Context context, TitleBarMenu titleBarMenu) {
        this.f19041O000000o = context;
        this.O00000Oo = titleBarMenu;
        this.O00000oO.O00000o0 = this.f19041O000000o.getString(R.string.share_title);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0035  */
    public final void O000000o() {
        for (TitleBarMenu.O000000o o000000o : new ArrayList(this.O00000Oo.getDropDownMenus())) {
            if (o000000o instanceof O00000Oo) {
                return;
            }
        }
        ArrayList<TitleBarMenu.O000000o> arrayList = new ArrayList<>(this.O00000Oo.getOptionMenus());
        for (TitleBarMenu.O000000o o000000o2 : arrayList) {
            if (TextUtils.equals(o000000o2.O00000Oo, "inner:share_menu_id") || (o000000o2 instanceof O00000Oo)) {
                return;
            }
            while (r1.hasNext()) {
            }
        }
        boolean z = true;
        if (arrayList.size() == 1 && TextUtils.equals(((TitleBarMenu.O000000o) arrayList.get(0)).O00000Oo, this.O00000Oo.f10526O000000o.O00000Oo)) {
            TitleBarMenu titleBarMenu = this.O00000Oo;
            O00000Oo o00000Oo = this.O00000oO;
            if (o00000Oo.O00000o == null && o00000Oo.O00000oO == -1) {
                gsy.O000000o(3, "TitleBarMenu", "insertOptionMenu: menu.iconBitmap is null. " + o00000Oo.toString());
            } else if (!TitleBarMenu.O000000o(titleBarMenu.O00000Oo, o00000Oo)) {
                titleBarMenu.O00000Oo.add(0, o00000Oo);
                if (!titleBarMenu.O00000o) {
                    titleBarMenu.addView(titleBarMenu.O00000o0(o00000Oo), 0);
                }
            }
        } else {
            if (arrayList.size() <= 0) {
                z = false;
            }
            if (!z) {
                this.O00000Oo.O000000o(this.O00000oO);
                gsy.O00000Oo("TitleBarMenuAdapter", "addShareOptionMenu: ");
            }
        }
    }

    public final void O00000Oo() {
        this.O00000Oo.O00000Oo(this.O00000oO);
    }

    public final void O000000o(View view, TitleBarMenu.O000000o o000000o, String str) {
        O00000o0 o00000o0 = this.O00000o0;
        if (o00000o0 != null) {
            o00000o0.O000000o(view, o000000o, str);
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f19047O000000o;
        public boolean O00000Oo;
        public List<C0116O000000o> O00000o0;

        private O000000o() {
        }

        /* renamed from: _m_j.hln$O000000o$O000000o  reason: collision with other inner class name */
        public static class C0116O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public int f19048O000000o;
            public String O00000Oo;
            public int O00000o;
            public String O00000o0;

            C0116O000000o(int i) {
                this.f19048O000000o = i;
            }
        }

        public static O000000o O000000o(String str) {
            try {
                O000000o o000000o = new O000000o();
                JSONObject jSONObject = new JSONObject(str);
                o000000o.f19047O000000o = "optionButtonClick";
                int i = 0;
                o000000o.O00000Oo = jSONObject.optBoolean("reset", false);
                ArrayList arrayList = new ArrayList();
                o000000o.O00000o0 = arrayList;
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                while (optJSONArray != null && i < optJSONArray.length()) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    C0116O000000o o000000o2 = new C0116O000000o(i);
                    o000000o2.O00000Oo = jSONObject2.optString("icon");
                    o000000o2.O00000o0 = jSONObject2.optString("type");
                    o000000o2.O00000o = jSONObject2.optInt("badge", -1);
                    arrayList.add(o000000o2);
                    i++;
                }
                return o000000o;
            } catch (Exception e) {
                gsy.O000000o(6, "TitleBarMenuAdapter", "parse: " + e.getLocalizedMessage());
                return null;
            }
        }
    }

    public static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f19049O000000o;
        String O00000Oo;
        public List<O000000o> O00000o0;

        private O00000o() {
        }

        public static class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public int f19050O000000o;
            public String O00000Oo;
            public String O00000o;
            public String O00000o0;
            public int O00000oO;

            O000000o(int i) {
                this.f19050O000000o = i;
            }
        }

        public static O00000o O000000o(String str) {
            try {
                O00000o o00000o = new O00000o();
                JSONObject jSONObject = new JSONObject(str);
                o00000o.f19049O000000o = jSONObject.optBoolean("enabled", true);
                o00000o.O00000Oo = "popMenuClick";
                ArrayList arrayList = new ArrayList();
                o00000o.O00000o0 = arrayList;
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                int i = 0;
                while (optJSONArray != null && i < optJSONArray.length()) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    O000000o o000000o = new O000000o(i);
                    o000000o.O00000Oo = jSONObject2.optString("title");
                    o000000o.O00000o0 = jSONObject2.optString("type");
                    o000000o.O00000o = jSONObject2.optString("icon");
                    o000000o.O00000oO = jSONObject2.optInt("badge", -1);
                    arrayList.add(o000000o);
                    i++;
                }
                return o00000o;
            } catch (Exception e) {
                gsy.O000000o(6, "TitleBarMenuAdapter", "parse: " + e.getLocalizedMessage());
                return null;
            }
        }
    }
}
