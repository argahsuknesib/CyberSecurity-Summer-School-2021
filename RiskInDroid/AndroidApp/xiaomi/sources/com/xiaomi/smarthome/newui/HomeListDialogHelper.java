package com.xiaomi.smarthome.newui;

import _m_j.ggb;
import _m_j.hxi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.homeroom.MultiHomeManagerActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.newui.HomeListDialogHelper;
import com.xiaomi.smarthome.newui.widget.IsCheckedableView;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class HomeListDialogHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    public static AtomicBoolean f10104O000000o = new AtomicBoolean(false);

    public interface O000000o {
        void O000000o();

        void O000000o(Home home);
    }

    public interface O00000Oo {
        void O000000o(Object obj);
    }

    public static void O000000o(Context context, View view, String str, boolean z, O000000o o000000o) {
        if (!f10104O000000o.getAndSet(true) && view != null && !TextUtils.isEmpty(str)) {
            View inflate = LayoutInflater.from(context).inflate((int) R.layout.popupwindowv2, (ViewGroup) null);
            ListView listView = (ListView) inflate.findViewById(R.id.lv_home);
            View findViewById = inflate.findViewById(R.id.footer_change_home);
            findViewById.setVisibility(8);
            InternalHomeListAdapterV2 internalHomeListAdapterV2 = new InternalHomeListAdapterV2(context);
            List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
            ArrayList arrayList = new ArrayList();
            Observable filter = Observable.fromIterable(list).filter(new Predicate(z) {
                /* class com.xiaomi.smarthome.newui.$$Lambda$HomeListDialogHelper$Ow7LTjxZ3YcYfvSuQnT3Da60tbc */
                private final /* synthetic */ boolean f$0;

                {
                    this.f$0 = r1;
                }

                public final boolean test(Object obj) {
                    return HomeListDialogHelper.O000000o(this.f$0, (Home) obj);
                }
            });
            arrayList.getClass();
            filter.subscribe(new Consumer(arrayList) {
                /* class com.xiaomi.smarthome.newui.$$Lambda$G9Oqky4S3k25NxxteOtCc3U0BMM */
                private final /* synthetic */ ArrayList f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj) {
                    this.f$0.add((Home) obj);
                }
            });
            internalHomeListAdapterV2.O000000o(arrayList);
            listView.setAdapter((ListAdapter) internalHomeListAdapterV2);
            if (internalHomeListAdapterV2.O000000o(str) != -1) {
                listView.setItemChecked(internalHomeListAdapterV2.O000000o(str), true);
            }
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
            popupWindow.setClippingEnabled(false);
            popupWindow.setAnimationStyle(R.style.anim_popupwindow_v2);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            popupWindow.setFocusable(true);
            popupWindow.setTouchable(true);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                /* class com.xiaomi.smarthome.newui.$$Lambda$HomeListDialogHelper$r3j_mWanar30DkOb8cqHKUngBw */

                public final void onDismiss() {
                    HomeListDialogHelper.O000000o(HomeListDialogHelper.O000000o.this);
                }
            });
            popupWindow.update();
            popupWindow.showAsDropDown(view, 0, 0);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(popupWindow, o000000o) {
                /* class com.xiaomi.smarthome.newui.$$Lambda$HomeListDialogHelper$8El1cPHt9hO69lbQa0MhsQcKMEU */
                private final /* synthetic */ PopupWindow f$0;
                private final /* synthetic */ HomeListDialogHelper.O000000o f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    HomeListDialogHelper.O000000o(this.f$0, this.f$1, adapterView, view, i, j);
                }
            });
            findViewById.setOnClickListener(new View.OnClickListener(popupWindow, context) {
                /* class com.xiaomi.smarthome.newui.$$Lambda$HomeListDialogHelper$G61HONrxLESL7nkdOE_MRKilZwY */
                private final /* synthetic */ PopupWindow f$0;
                private final /* synthetic */ Context f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    HomeListDialogHelper.O000000o(this.f$0, this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean O000000o(boolean z, Home home) throws Exception {
        return !z || home.isOwner();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(O000000o o000000o) {
        f10104O000000o.set(false);
        if (o000000o != null) {
            o000000o.O000000o();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(PopupWindow popupWindow, O000000o o000000o, AdapterView adapterView, View view, int i, long j) {
        popupWindow.dismiss();
        Home home = (Home) adapterView.getAdapter().getItem(i);
        if (o000000o != null) {
            o000000o.O000000o(home);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(PopupWindow popupWindow, Context context, View view) {
        popupWindow.dismiss();
        Intent intent = new Intent(context, MultiHomeManagerActivity.class);
        intent.putExtra("from", 7);
        context.startActivity(intent);
        hxi.O00000o.O0000O0o();
    }

    static class InternalHomeListAdapterV2 extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        protected List<Home> f10105O000000o;
        protected Context O00000Oo;

        public long getItemId(int i) {
            return (long) i;
        }

        public InternalHomeListAdapterV2(Context context) {
            this.O00000Oo = context;
        }

        public final void O000000o(List<Home> list) {
            this.f10105O000000o = list;
        }

        public final int O000000o(String str) {
            for (int i = 0; i < this.f10105O000000o.size(); i++) {
                if (TextUtils.equals(str, this.f10105O000000o.get(i).getId())) {
                    return i;
                }
            }
            return -1;
        }

        public int getCount() {
            List<Home> list = this.f10105O000000o;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: O000000o */
        public Home getItem(int i) {
            List<Home> list = this.f10105O000000o;
            if (list != null) {
                return list.get(i);
            }
            return null;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            O000000o o000000o;
            boolean z = false;
            if (view == null) {
                o000000o = new O000000o((byte) 0);
                view2 = LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.item_single_choice, viewGroup, false);
                o000000o.f10106O000000o = (IsCheckedableView) view2.findViewById(R.id.root);
                view2.setTag(o000000o);
            } else {
                view2 = view;
                o000000o = (O000000o) view.getTag();
            }
            Home O000000o2 = getItem(i);
            if (O000000o2 != null) {
                IsCheckedableView isCheckedableView = o000000o.f10106O000000o;
                ggb.O00000Oo();
                isCheckedableView.setText(ggb.O000000o(O000000o2));
            }
            IsCheckedableView isCheckedableView2 = o000000o.f10106O000000o;
            if (i != this.f10105O000000o.size() - 1) {
                z = true;
            }
            isCheckedableView2.setDividerVisivle(z);
            return view2;
        }

        static class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            IsCheckedableView f10106O000000o;

            private O000000o() {
            }

            /* synthetic */ O000000o(byte b) {
                this();
            }
        }
    }
}
