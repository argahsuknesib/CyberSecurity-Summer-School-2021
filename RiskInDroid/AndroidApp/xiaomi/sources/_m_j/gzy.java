package _m_j;

import _m_j.gzy;
import _m_j.gzz;
import _m_j.hgt;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.CardConstraintLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class gzy extends aya<ghc, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f18675O000000o = false;
    protected Context O00000Oo;
    public View O00000o;
    public Map<String, String> O00000o0 = new HashMap();
    public List<gzz.O000000o> O00000oO = new ArrayList();
    boolean O00000oo = false;
    private final int O0000O0o = 1;

    public final int getChildItemViewType(int i, int i2) {
        return 0;
    }

    public final /* bridge */ /* synthetic */ boolean onCheckCanExpandOrCollapseGroup(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, boolean z) {
        return false;
    }

    public final /* synthetic */ void onBindChildViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3) {
        O000000o o000000o = (O000000o) o000OOo0;
        o000000o.O000000o(this.O00000oO.get(i).O00000o0.get(i2));
        boolean z = true;
        o000000o.O00000Oo.setVisibility(i2 == this.O00000oO.get(i).O00000o0.size() - 1 ? 8 : 0);
        if (i2 != this.O00000oO.get(i).O00000o0.size() - 1) {
            z = false;
        }
        o000000o.O000000o(z);
    }

    public final /* synthetic */ void onBindGroupViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2) {
        ghc ghc = (ghc) o000OOo0;
        if (i2 != 1) {
            ghc.O000000o(this.O00000oO.get(i).f18681O000000o);
        }
    }

    public gzy(Activity activity, boolean z) {
        this.O00000Oo = activity;
        this.O00000oo = z;
        setHasStableIds(true);
    }

    public final int getGroupCount() {
        return this.O00000oO.size();
    }

    public final int getChildCount(int i) {
        return this.O00000oO.get(i).O00000o0.size();
    }

    public final long getGroupId(int i) {
        return (long) (this.O00000oO.get(i).f18681O000000o.hashCode() + this.O00000oO.get(i).O00000o);
    }

    public final long getChildId(int i, int i2) {
        gzz.O000000o o000000o = this.O00000oO.get(i);
        if (TextUtils.isEmpty(o000000o.f18681O000000o)) {
            return 0;
        }
        return (long) (o000000o.f18681O000000o.hashCode() + (TextUtils.isEmpty(o000000o.O00000o0.get(i2).O00000Oo) ? 0 : o000000o.O00000o0.get(i2).O00000Oo.hashCode()));
    }

    public final int getGroupItemViewType(int i) {
        return this.O00000oO.get(i).O00000o;
    }

    public final void O000000o(String str, String str2, boolean z) {
        if (z) {
            this.O00000o0.put(str, str2);
        } else {
            this.O00000o0.remove(str);
        }
        notifyDataSetChanged();
    }

    class O000000o extends ghd {
        View O00000Oo;
        private CardConstraintLayout O00000o;
        private TextView O00000oO;
        private TextView O00000oo;
        private TextView O0000O0o;
        private SimpleDraweeView O0000OOo;
        private TextView O0000Oo;
        private CheckBox O0000Oo0;

        public O000000o(View view) {
            super(view);
            this.O00000o = (CardConstraintLayout) view.findViewById(R.id.root);
            this.O00000oO = (TextView) view.findViewById(R.id.title);
            this.O00000oo = (TextView) view.findViewById(R.id.desc);
            this.O0000OOo = (SimpleDraweeView) view.findViewById(R.id.icon);
            this.O00000Oo = view.findViewById(R.id.divider_item);
            this.O0000Oo0 = (CheckBox) view.findViewById(R.id.checkbox);
            this.O0000O0o = (TextView) view.findViewById(R.id.right_text);
            this.O0000Oo = (TextView) view.findViewById(R.id.sign);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.hhc.O000000o(java.lang.Object, double):double
         arg types: [java.lang.String, int]
         candidates:
          _m_j.hhc.O000000o(java.lang.Object, int):int
          _m_j.hhc.O000000o(java.lang.Object, double):double */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.hhc.O000000o(java.lang.Object, double):double
         arg types: [java.lang.Object, int]
         candidates:
          _m_j.hhc.O000000o(java.lang.Object, int):int
          _m_j.hhc.O000000o(java.lang.Object, double):double */
        public final void O000000o(hgt.O000000o o000000o) {
            String str;
            Device O000000o2 = fno.O000000o().O000000o(o000000o.O00000Oo);
            if (O000000o2 != null) {
                this.O00000oo.setText(O000000o2.name);
                float f = 1.0f;
                this.O00000oo.setAlpha(O000000o2.isOnline ? 1.0f : 0.5f);
                this.O00000oO.setAlpha(O000000o2.isOnline ? 1.0f : 0.5f);
                this.O0000OOo.setAlpha(O000000o2.isOnline ? 1.0f : 0.5f);
                this.O0000O0o.setAlpha(O000000o2.isOnline ? 1.0f : 0.5f);
                TextView textView = this.O0000Oo;
                if (!O000000o2.isOnline) {
                    f = 0.5f;
                }
                textView.setAlpha(f);
                DeviceFactory.O00000Oo(O000000o2.model, this.O0000OOo);
                if (!gzy.this.O00000oo) {
                    int abs = Math.abs(gzz.O0000O0o.indexOf(o000000o.O0000O0o)) % gzz.O0000O0o.size();
                    String[] stringArray = gzy.this.O00000Oo.getResources().getStringArray(R.array.home_env_info_item_title);
                    if (abs < stringArray.length && stringArray.length > 0) {
                        this.O00000oO.setText(stringArray[abs]);
                    }
                    if (!TextUtils.isEmpty(o000000o.O00000oo)) {
                        this.O0000O0o.setTextColor(Color.parseColor("#808C8E"));
                        Pair<String, fkv<Object, Object>> pair = null;
                        String str2 = o000000o.O0000O0o;
                        char c = 65535;
                        int hashCode = str2.hashCode();
                        if (hashCode != 103680) {
                            if (hashCode != 3442944) {
                                if (hashCode == 3556308 && str2.equals("temp")) {
                                    c = 0;
                                }
                            } else if (str2.equals("pm25")) {
                                c = 2;
                            }
                        } else if (str2.equals("hum")) {
                            c = 1;
                        }
                        if (c == 0) {
                            pair = fju.O000000o().O00000Oo("℃");
                            this.O0000Oo.setVisibility(0);
                            this.O0000Oo.setText((CharSequence) pair.first);
                        } else if (c == 1) {
                            pair = fju.O000000o().O00000Oo("%");
                            this.O0000Oo.setVisibility(0);
                            this.O0000Oo.setText((CharSequence) pair.first);
                        } else if (c == 2) {
                            this.O0000Oo.setVisibility(8);
                            try {
                                if (hhc.O000000o((Object) o000000o.O00000oo, 0.0d) > 50.0d) {
                                    this.O0000O0o.setTextColor(Color.parseColor("#DFAD16"));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            TextView textView2 = this.O0000O0o;
                            if (pair == null) {
                                str = String.valueOf((int) (hhc.O000000o((Object) o000000o.O00000oo, 0.0d) + 0.5d));
                            } else {
                                str = String.valueOf((int) (hhc.O000000o(((fkv) pair.second).call(o000000o.O00000oo), 0.0d) + 0.5d));
                            }
                            textView2.setText(str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (!O000000o2.isOnline) {
                            this.O0000Oo.setVisibility(8);
                            this.O0000O0o.setVisibility(8);
                            return;
                        }
                        this.O0000O0o.setVisibility(0);
                        TextView textView3 = this.O0000Oo;
                        textView3.setVisibility(textView3.getVisibility());
                        return;
                    }
                    return;
                }
                this.O0000O0o.setVisibility(4);
                this.O0000Oo.setVisibility(8);
                this.O0000Oo0.setVisibility(0);
                CheckBox checkBox = this.O0000Oo0;
                checkBox.setTag(o000000o.O0000O0o + "_" + o000000o.O00000Oo);
                if (gzy.this.O00000o0 != null) {
                    this.O0000Oo0.setChecked(TextUtils.equals(gzy.this.O00000o0.get(o000000o.O0000O0o), o000000o.O00000Oo));
                }
                this.O0000Oo0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(o000000o) {
                    /* class _m_j.$$Lambda$gzy$O000000o$qeuRWCk1MSqJINwOfJYwFomZXs */
                    private final /* synthetic */ hgt.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        gzy.O000000o.this.O000000o(this.f$1, compoundButton, z);
                    }
                });
                this.O00000o.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.$$Lambda$gzy$O000000o$CeE3k3ZDufm7eGyj3R0fMVfxsY4 */

                    public final void onClick(View view) {
                        gzy.O000000o.this.O000000o(view);
                    }
                });
                Room O00000o02 = ggb.O00000Oo().O00000o0(o000000o.O0000OOo);
                if (O00000o02 != null) {
                    this.O00000oO.setText(O00000o02.getName());
                } else if (TextUtils.equals(o000000o.O0000OOo, "mijia.roomid.default")) {
                    this.O00000oO.setText(gzy.this.O00000Oo.getString(R.string.default_room));
                }
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0055  */
        public /* synthetic */ void O000000o(hgt.O000000o o000000o, CompoundButton compoundButton, boolean z) {
            String str;
            String str2 = (String) this.O0000Oo0.getTag();
            String str3 = "";
            if (!TextUtils.isEmpty(str2)) {
                try {
                    str = str2.substring(0, str2.indexOf("_"));
                    try {
                        str3 = str2.substring(str2.indexOf("_") + 1);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (z) {
                        }
                        gzy.this.f18675O000000o = true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str = str3;
                    e.printStackTrace();
                    if (z) {
                    }
                    gzy.this.f18675O000000o = true;
                }
            } else {
                str = str3;
            }
            if (z) {
                if (!gzy.this.O00000o0.containsKey(str) || !TextUtils.equals(gzy.this.O00000o0.get(str), str3)) {
                    gzy.this.O000000o(o000000o.O0000O0o, o000000o.O00000Oo, true);
                }
            } else if (gzy.this.O00000o0.containsKey(str) && TextUtils.equals(gzy.this.O00000o0.get(str), str3)) {
                gzy.this.O000000o(o000000o.O0000O0o, o000000o.O00000Oo, false);
            }
            gzy.this.f18675O000000o = true;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(View view) {
            this.O0000Oo0.setChecked(!this.O0000Oo0.isChecked());
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(boolean z) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.O00000o.getLayoutParams();
            if (z) {
                this.O00000o.O000000o(true, true);
                layoutParams.bottomMargin = gpc.O00000o0(gzy.this.O00000Oo, 12.0f);
            } else {
                this.O00000o.O000000o(false, false);
                layoutParams.bottomMargin = gpc.O00000o0(gzy.this.O00000Oo, 0.0f);
            }
            this.O00000o.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateChildViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.tag_child_home_env, viewGroup, false));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateGroupViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.O00000Oo);
        if (i == 1) {
            return new ghc(this.O00000o);
        }
        return new ghe(from.inflate((int) R.layout.tag_group_item_common_5, viewGroup, false));
    }
}
