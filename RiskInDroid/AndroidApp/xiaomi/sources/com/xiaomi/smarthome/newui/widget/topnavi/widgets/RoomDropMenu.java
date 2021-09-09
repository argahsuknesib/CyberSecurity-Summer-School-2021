package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import _m_j.fcn;
import _m_j.ft;
import _m_j.gfz;
import _m_j.gpc;
import _m_j.hgv;
import _m_j.hhn;
import _m_j.hxi;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.newui.page.IPage;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import java.util.Iterator;
import java.util.List;

public class RoomDropMenu extends IPage {
    static hgv.O00000Oo<View> O0000OoO = new hgv.O00000Oo<View>("height") {
        /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.RoomDropMenu.AnonymousClass6 */

        public final /* synthetic */ void O000000o(Object obj, int i) {
            View view = (View) obj;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }

        public final /* synthetic */ Object get(Object obj) {
            return Integer.valueOf(((View) obj).getLayoutParams().height);
        }
    };
    private static final Property<View, Float> O0000o0o = new hgv.O000000o<View>("alpha") {
        /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.RoomDropMenu.AnonymousClass5 */

        public final /* synthetic */ void O000000o(Object obj, float f) {
            View view = (View) obj;
            if (view != null) {
                view.setAlpha(f);
            }
        }

        public final /* synthetic */ Object get(Object obj) {
            View view = (View) obj;
            if (view == null) {
                return Float.valueOf(0.0f);
            }
            return Float.valueOf(view.getAlpha());
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f10377O000000o;
    public List<PageBean.O00000Oo> O00000Oo;
    public PageBean O00000o0;
    public CardConstraintLayout O0000OOo;
    public int[] O0000Oo = new int[2];
    public CardConstraintLayout O0000Oo0;
    private View O0000Ooo;
    private View O0000o0;
    private BroadcastReceiver O0000o00 = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.RoomDropMenu.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "action_room_selected")) {
                String stringExtra = intent.getStringExtra("extra_room_selected_id");
                if (!TextUtils.isEmpty(stringExtra)) {
                    for (PageBean.O00000Oo o00000Oo : RoomDropMenu.this.O00000Oo) {
                        Iterator<PageBean> it = o00000Oo.O00000Oo.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            PageBean next = it.next();
                            if (stringExtra.equals(next.O00000Oo)) {
                                RoomDropMenu.this.O00000o0 = next;
                                break;
                            }
                        }
                    }
                }
            }
            try {
                RoomDropMenu.this.O00000Oo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private TextView O0000o0O;

    public RoomDropMenu(FragmentActivity fragmentActivity, View view, List<PageBean.O00000Oo> list, PageBean pageBean) {
        super(fragmentActivity);
        this.O00000Oo = list;
        this.O00000o0 = pageBean;
        this.f10377O000000o = view.getMeasuredHeight();
        view.getLocationInWindow(this.O0000Oo);
        hxi.O00000o.O00000Oo(1);
        hxi.O00000o.f952O000000o.O000000o("all.device.filter", "time", Long.valueOf(System.currentTimeMillis()), "uid", fcn.O000000o().O00000Oo(), "type", "1");
        try {
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (PageBean.O00000Oo next : this.O00000Oo) {
                if ("all_type".equals(next.f10341O000000o)) {
                    for (PageBean next2 : next.O00000Oo) {
                        i2 = "mijia.roomid.share".equals(next2.O00000Oo) ? 1 : i2;
                        if ("mijia.roomid.nearby".equals(next2.O00000Oo)) {
                            z = true;
                        }
                    }
                } else if ("category_type".equals(next.f10341O000000o)) {
                    i = next.O00000Oo.size();
                }
            }
            hxi.O00000o0.f957O000000o.O000000o("home_navigation_show_dropdown", "category_number", Integer.valueOf(i), "share", Integer.valueOf(i2), "nearby", Integer.valueOf(z ? 1 : 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View O000000o(ViewGroup viewGroup) {
        return LayoutInflater.from(CommonApplication.getAppContext()).inflate((int) R.layout.activity_room_menu, viewGroup, false);
    }

    public final void e_() {
        super.e_();
        this.O0000Oo0 = (CardConstraintLayout) this.O00000oO.findViewById(R.id.menu);
        this.O0000Ooo = this.O00000oO.findViewById(R.id.bg_mask);
        this.O0000OOo = (CardConstraintLayout) this.O00000oO.findViewById(R.id.erase_menu);
        this.O0000o0O = (TextView) this.O00000oO.findViewById(R.id.room_name);
        int size = gfz.f17670O000000o.O000000o(this.O00000o0).size();
        this.O0000o0O.setText(String.format("%s (%s)", this.O00000o0.f10340O000000o, Integer.valueOf(size)));
        this.O0000o0 = this.O00000oO.findViewById(R.id.arrow_down_img);
        RecyclerView recyclerView = (RecyclerView) this.O00000oO.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.O00000oO.getContext()));
        recyclerView.setAdapter(new hhn(this.O00000oO.getContext(), this.O00000Oo, this.O00000o0));
        recyclerView.addOnScrollListener(new RecyclerView.O00oOooO() {
            /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.RoomDropMenu.AnonymousClass2 */

            public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1) {
                    hxi.O0000OoO.f961O000000o.O000000o("all.device.panel", "time", Long.valueOf(System.currentTimeMillis()), "uid", fcn.O000000o().O00000Oo());
                }
            }
        });
        this.O00000oO.findViewById(R.id.container).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.$$Lambda$RoomDropMenu$p6asO0OMgIyqKh3OmjGBbuyQgo */

            public final void onClick(View view) {
                RoomDropMenu.this.O000000o(view);
            }
        });
        O00000oO();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O0000Ooo, O0000o0o, 0.0f, 0.4f);
        ofFloat.setDuration(200L);
        ofFloat.start();
        this.O0000o0.animate().rotation(180.0f).setDuration(125).setInterpolator(new AccelerateDecelerateInterpolator());
        this.O00000oO.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.RoomDropMenu.AnonymousClass4 */

            public final boolean onPreDraw() {
                RoomDropMenu.this.O00000oO.getViewTreeObserver().removeOnPreDrawListener(this);
                int O00000o0 = gpc.O00000o0(RoomDropMenu.this.O00000oO.getContext(), 59.0f);
                int O00000o02 = RoomDropMenu.this.O0000Oo[1] + O00000o0 + gpc.O00000o0(RoomDropMenu.this.O00000oO.getContext(), 3.0f);
                RoomDropMenu.this.O0000OOo.setY((float) (O00000o02 - O00000o0));
                RoomDropMenu.this.O0000Oo0.setY((float) O00000o02);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RoomDropMenu.this.O0000Oo0, View.ALPHA, 0.2f, 1.0f);
                ObjectAnimator ofInt = ObjectAnimator.ofInt(RoomDropMenu.this.O0000Oo0, RoomDropMenu.O0000OoO, RoomDropMenu.this.f10377O000000o, RoomDropMenu.this.O0000Oo0.getMeasuredHeight());
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(250L);
                animatorSet.setDuration(250L);
                animatorSet.setInterpolator(new DecelerateInterpolator());
                animatorSet.playTogether(ofFloat, ofInt);
                animatorSet.start();
                return true;
            }
        });
        ft.O000000o(CommonApplication.getAppContext()).O000000o(this.O0000o00, new IntentFilter("action_room_selected"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        O00000Oo();
    }

    public final void O00000Oo() {
        ft.O000000o(CommonApplication.getAppContext()).O000000o(this.O0000o00);
        int size = gfz.f17670O000000o.O000000o(this.O00000o0).size();
        this.O0000o0O.setText(String.format("%s (%s)", this.O00000o0.f10340O000000o, Integer.valueOf(size)));
        ViewPropertyAnimator startDelay = this.O0000o0.animate().rotation(0.0f).setDuration(125).setStartDelay(125);
        startDelay.setInterpolator(new AccelerateDecelerateInterpolator());
        startDelay.start();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O0000Oo0, View.ALPHA, 1.0f, 0.0f);
        CardConstraintLayout cardConstraintLayout = this.O0000Oo0;
        ObjectAnimator ofInt = ObjectAnimator.ofInt(cardConstraintLayout, O0000OoO, cardConstraintLayout.getMeasuredHeight(), this.f10377O000000o);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.O0000Ooo, View.ALPHA, 0.4f, 0.0f);
        ofFloat2.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() {
            /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.RoomDropMenu.AnonymousClass3 */

            public final void onAnimationEnd(Animator animator) {
                RoomDropMenu.super.O00000Oo();
            }
        });
        animatorSet.playTogether(ofFloat, ofInt, ofFloat2);
        animatorSet.start();
        hxi.O00000o.O00000Oo(0);
    }

    public final void O000000o(Configuration configuration) {
        O00000oO();
    }

    private void O00000oO() {
        CardConstraintLayout cardConstraintLayout = this.O0000Oo0;
        if (cardConstraintLayout != null && this.O0000OOo != null) {
            int dimension = (int) cardConstraintLayout.getContext().getResources().getDimension(R.dimen.main_page_flex_padding);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.O0000Oo0.getLayoutParams();
            int O000000o2 = gpc.O000000o(10.0f) + dimension;
            marginLayoutParams.rightMargin = O000000o2;
            marginLayoutParams.leftMargin = O000000o2;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.O0000OOo.getLayoutParams();
            int O000000o3 = gpc.O000000o(10.0f) + dimension;
            marginLayoutParams2.rightMargin = O000000o3;
            marginLayoutParams2.leftMargin = O000000o3;
        }
    }
}
