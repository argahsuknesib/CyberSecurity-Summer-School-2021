package com.xiaomi.smarthome.scene.view;

import _m_j.fnn;
import _m_j.gpc;
import _m_j.hrl;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SceneFilterView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f11315O000000o;
    public Context O00000Oo;
    public DeviceTagInterface O00000o;
    public LayoutInflater O00000o0;
    public Map<String, Set<String>> O00000oO;
    public List<hrl.O00000Oo> O00000oo;
    public PopupWindow O0000O0o;
    public O00000Oo O0000OOo;
    public int O0000Oo;
    public O00000o0 O0000Oo0;
    private TextView O0000OoO;
    private TextView O0000Ooo;
    private ListView O0000o0;
    private TextView O0000o00;
    private O000000o O0000o0O;

    public interface O00000Oo {
        void O000000o();
    }

    public interface O00000o0 {
        void O000000o();
    }

    public O00000Oo getOnItemSelectListener() {
        return this.O0000OOo;
    }

    public void setOnItemSelectListener(O00000Oo o00000Oo) {
        this.O0000OOo = o00000Oo;
    }

    public SceneFilterView(Context context) {
        this(context, null);
    }

    public SceneFilterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SceneFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11315O000000o = 0;
        this.O0000o0O = new O000000o(this, (byte) 0);
        this.O00000oo = new ArrayList();
        this.O0000Oo = 2;
        this.O00000Oo = context;
        this.O00000o0 = LayoutInflater.from(this.O00000Oo);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.O0000OoO = (TextView) findViewById(R.id.filter_tv_left);
        this.O0000Ooo = (TextView) findViewById(R.id.filter_tv_mid);
        this.O0000o00 = (TextView) findViewById(R.id.filter_tv_right);
        this.O0000o0 = (ListView) findViewById(R.id.scene_filter_lv);
        this.O0000o0.setAdapter((ListAdapter) this.O0000o0O);
        this.O0000OoO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.view.SceneFilterView.AnonymousClass2 */

            public final void onClick(View view) {
                SceneFilterView.this.O000000o(2, 0, ServiceApplication.getAppContext().getResources().getString(R.string.smarthome_scene_all));
            }
        });
        this.O0000Ooo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.view.SceneFilterView.AnonymousClass3 */

            public final void onClick(View view) {
                SceneFilterView.this.O000000o(4, 0, ServiceApplication.getAppContext().getResources().getString(R.string.smarthome_scene_all));
            }
        });
        this.O0000o00.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.view.SceneFilterView.AnonymousClass4 */

            public final void onClick(View view) {
                SceneFilterView.this.O000000o(0, 0, ServiceApplication.getAppContext().getResources().getString(R.string.smarthome_scene_all));
            }
        });
    }

    public final void O000000o(int i, int i2, String str) {
        if (i == 0) {
            this.O0000OoO.setSelected(false);
            this.O0000Ooo.setSelected(false);
            this.O0000o00.setSelected(true);
        } else if (i == 2) {
            this.O0000OoO.setSelected(true);
            this.O0000Ooo.setSelected(false);
            this.O0000o00.setSelected(false);
        } else if (i == 4) {
            this.O0000OoO.setSelected(false);
            this.O0000Ooo.setSelected(true);
            this.O0000o00.setSelected(false);
        }
        O00000Oo(i, i2, str);
        this.O0000o0O.notifyDataSetChanged();
    }

    private void O00000Oo(int i, int i2, String str) {
        this.O00000o = fnn.O000000o().O00000Oo();
        this.O00000oO = this.O00000o.O000000o(i);
        this.O00000oo = hrl.O000000o().O000000o(this.O00000oO, this.f11315O000000o);
        O000000o o000000o = this.O0000o0O;
        o000000o.f11320O000000o = i2;
        o000000o.O00000Oo = str;
        this.O0000Oo = i;
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f11320O000000o;
        String O00000Oo;

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        private O000000o() {
            this.f11320O000000o = 0;
            this.O00000Oo = ServiceApplication.getAppContext().getResources().getString(R.string.smarthome_scene_all);
        }

        /* synthetic */ O000000o(SceneFilterView sceneFilterView, byte b) {
            this();
        }

        public final int getCount() {
            return SceneFilterView.this.O00000oo.size();
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            O00000o o00000o;
            final hrl.O00000Oo o00000Oo = SceneFilterView.this.O00000oo.get(i);
            if (view == null) {
                view = SceneFilterView.this.O00000o0.inflate((int) R.layout.scene_fliter_item_view, (ViewGroup) null);
                o00000o = new O00000o(view);
                view.setTag(o00000o);
            } else {
                o00000o = (O00000o) view.getTag();
            }
            if (SceneFilterView.this.O0000Oo == 2) {
                TextView textView = o00000o.f11322O000000o;
                textView.setText(SceneFilterView.this.O00000o.O0000OoO(o00000Oo.f566O000000o) + " (" + o00000Oo.O00000Oo + ")");
            } else {
                TextView textView2 = o00000o.f11322O000000o;
                textView2.setText(o00000Oo.f566O000000o + " (" + o00000Oo.O00000Oo + ")");
            }
            if (this.O00000Oo.equalsIgnoreCase(o00000Oo.f566O000000o)) {
                o00000o.f11322O000000o.setSelected(true);
            } else {
                o00000o.f11322O000000o.setSelected(false);
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.view.SceneFilterView.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    O000000o o000000o = O000000o.this;
                    o000000o.f11320O000000o = i;
                    if (SceneFilterView.this.O0000Oo != 2 || i == 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(o00000Oo.f566O000000o);
                        sb.append(" (");
                        sb.append(o00000Oo.O00000Oo);
                        sb.append(")");
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(SceneFilterView.this.O00000o.O0000OoO(o00000Oo.f566O000000o));
                        sb2.append(" (");
                        sb2.append(o00000Oo.O00000Oo);
                        sb2.append(")");
                    }
                    if (O000000o.this.f11320O000000o == 0) {
                        if (SceneFilterView.this.f11315O000000o == 1 || SceneFilterView.this.f11315O000000o == 2) {
                            hrl.O000000o().O000000o(SceneFilterView.this.O0000Oo, O000000o.this.f11320O000000o, o00000Oo.f566O000000o, o00000Oo.O00000Oo);
                            hrl.O000000o().O00000o0.clear();
                        } else if (SceneFilterView.this.f11315O000000o == 3) {
                            hrl.O000000o().O00000Oo(SceneFilterView.this.O0000Oo, O000000o.this.f11320O000000o, o00000Oo.f566O000000o, o00000Oo.O00000Oo);
                            hrl.O000000o().O00000o.clear();
                        }
                    } else if (SceneFilterView.this.f11315O000000o == 1 || SceneFilterView.this.f11315O000000o == 2) {
                        hrl.O000000o().O000000o(SceneFilterView.this.O0000Oo, O000000o.this.f11320O000000o, o00000Oo.f566O000000o, o00000Oo.O00000Oo);
                        hrl O000000o2 = hrl.O000000o();
                        O000000o2.O00000o0.clear();
                        O000000o2.O00000o0.addAll(SceneFilterView.this.O00000oO.get(o00000Oo.f566O000000o));
                    } else if (SceneFilterView.this.f11315O000000o == 3) {
                        hrl.O000000o().O00000Oo(SceneFilterView.this.O0000Oo, O000000o.this.f11320O000000o, o00000Oo.f566O000000o, o00000Oo.O00000Oo);
                        hrl O000000o3 = hrl.O000000o();
                        O000000o3.O00000o.clear();
                        O000000o3.O00000o.addAll(SceneFilterView.this.O00000oO.get(o00000Oo.f566O000000o));
                    }
                    if (SceneFilterView.this.O0000OOo != null) {
                        if (O000000o.this.f11320O000000o == 0) {
                            SceneFilterView.this.O0000OOo.O000000o();
                        } else {
                            O00000Oo o00000Oo = SceneFilterView.this.O0000OOo;
                            SceneFilterView.this.O00000oO.get(o00000Oo.f566O000000o);
                            o00000Oo.O000000o();
                        }
                    }
                    O000000o.this.notifyDataSetChanged();
                }
            });
            return view;
        }
    }

    class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f11322O000000o;

        public O00000o(View view) {
            this.f11322O000000o = (TextView) view.findViewById(R.id.scene_item_tv);
        }
    }

    public O00000o0 getmDismissListener() {
        return this.O0000Oo0;
    }

    public void setmDismissListener(O00000o0 o00000o0) {
        this.O0000Oo0 = o00000o0;
    }

    public static Animation O000000o(Context context) {
        AnimationSet animationSet = new AnimationSet(context, null);
        animationSet.setFillAfter(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (-gpc.O000000o(320.0f)), 0.0f);
        translateAnimation.setDuration(500);
        animationSet.addAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    public static Animation O00000Oo(Context context) {
        AnimationSet animationSet = new AnimationSet(context, null);
        animationSet.setFillAfter(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-gpc.O000000o(320.0f)));
        translateAnimation.setDuration(500);
        animationSet.addAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }
}
