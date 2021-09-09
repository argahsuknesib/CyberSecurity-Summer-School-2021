package com.xiaomi.smarthome.scene;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fvm;
import _m_j.ggb;
import _m_j.gno;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hnz;
import _m_j.hob;
import _m_j.hod;
import _m_j.hof;
import _m_j.hoh;
import _m_j.hor;
import _m_j.hpf;
import _m_j.hpq;
import _m_j.hqb;
import _m_j.hqs;
import _m_j.hrg;
import _m_j.hrh;
import _m_j.hxi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.viewflow.LoadingMoreView;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.SceneLogFragment;
import com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity;
import com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import com.xiaomi.smarthome.scene.timer.CommonTimer;
import com.xiaomi.smarthome.scene.timer.CountDownTimerStartActivity;
import com.xiaomi.smarthome.scene.timer.PlugTimer;
import com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SceneLogFragment extends fvm {

    /* renamed from: O000000o  reason: collision with root package name */
    View f10606O000000o;
    public ExpandableListView O00000Oo;
    public O00000o0 O00000o;
    public LoadingMoreView O00000o0;
    public ImageView O00000oO;
    public String O00000oo = "";
    public List<hqb.O00000Oo> O0000O0o = new ArrayList();
    public View O0000OOo;
    public boolean O0000Oo = false;
    public HashMap<Integer, Integer> O0000Oo0 = new HashMap<>();
    public boolean O0000OoO = true;
    public String O0000Ooo;
    public boolean O0000o = false;
    public Handler O0000o0 = new Handler();
    PtrFrameLayout O0000o00;
    public O000000o O0000o0O = new O000000o() {
        /* class com.xiaomi.smarthome.scene.SceneLogFragment.AnonymousClass1 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.widget.ExpandableListView, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final void O000000o(List<hqb.O00000Oo> list) {
            SceneLogFragment.this.O00000o.notifyDataSetChanged();
            SceneLogFragment.this.O00000Oo.setOnScrollListener(SceneLogFragment.this.O0000o0o);
            if (list.size() == 0) {
                SceneLogFragment.this.O0000OOo.setVisibility(0);
                SceneLogFragment.this.O00000Oo.setVisibility(8);
                SceneLogFragment.this.O00000oO.setVisibility(8);
                if (!SceneLogFragment.this.O0000Oo) {
                    try {
                        SceneLogFragment.this.O00000Oo.addHeaderView(LayoutInflater.from(ServiceApplication.getAppContext()).inflate((int) R.layout.common_list_space_empty, (ViewGroup) SceneLogFragment.this.O00000Oo, false));
                        SceneLogFragment.this.O0000Oo = true;
                    } catch (Exception unused) {
                    }
                }
            } else {
                SceneLogFragment.this.O0000OOo.setVisibility(8);
                SceneLogFragment.this.O00000Oo.setVisibility(0);
                SceneLogFragment.this.O00000oO.setVisibility(0);
                SceneLogFragment.this.O00000Oo.setOnScrollListener(SceneLogFragment.this.O0000o0o);
            }
            SceneLogFragment.this.O00000o0.setVisibility(8);
            SceneLogFragment.this.O0000o00.refreshComplete();
        }

        public final void O000000o() {
            if (SceneLogFragment.this.O0000o) {
                SceneLogFragment.this.O00000o0.setVisibility(8);
            } else {
                SceneLogFragment.this.O00000o.notifyDataSetChanged();
            }
        }

        public final void O00000Oo() {
            if (SceneLogFragment.this.O0000O0o == null || SceneLogFragment.this.O0000O0o.size() == 0) {
                SceneLogFragment.this.O0000o00.refreshComplete();
                SceneLogFragment.this.O00000Oo.setVisibility(8);
                SceneLogFragment.this.O00000oO.setVisibility(8);
                SceneLogFragment.this.O0000OOo.setVisibility(0);
            } else {
                SceneLogFragment.this.O00000Oo.setVisibility(0);
                SceneLogFragment.this.O0000OOo.setVisibility(8);
                SceneLogFragment.this.O00000oO.setVisibility(0);
                SceneLogFragment.this.O00000o.notifyDataSetChanged();
            }
            SceneLogFragment.this.O00000o0.O000000o(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.SceneLogFragment.AnonymousClass1.AnonymousClass1 */

                public final void onClick(View view) {
                    SceneLogFragment.this.O00000Oo();
                }
            });
        }

        public final void O00000o0() {
            SceneLogFragment.this.O00000o0.O000000o(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.SceneLogFragment.AnonymousClass1.AnonymousClass2 */

                public final void onClick(View view) {
                    SceneLogFragment.this.O00000Oo();
                }
            });
        }
    };
    public O00000Oo O0000o0o = new O00000Oo() {
        /* class com.xiaomi.smarthome.scene.SceneLogFragment.AnonymousClass2 */

        public final boolean O000000o() {
            return SceneLogFragment.this.O00000Oo();
        }
    };
    private long O0000oO = 0;
    private boolean O0000oO0 = false;

    public interface O000000o {
        void O000000o();

        void O000000o(List<hqb.O00000Oo> list);

        void O00000Oo();

        void O00000o0();
    }

    public abstract class O00000Oo implements AbsListView.OnScrollListener {

        /* renamed from: O000000o  reason: collision with root package name */
        private int f10620O000000o = 5;
        private int O00000o = 0;
        private int O00000o0 = 0;
        private boolean O00000oO = true;
        private int O00000oo = 0;

        public abstract boolean O000000o();

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public O00000Oo() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i3 < this.O00000o) {
                this.O00000o0 = this.O00000oo;
                this.O00000o = i3;
                if (i3 == 0) {
                    this.O00000oO = true;
                }
            }
            if (this.O00000oO && i3 > this.O00000o) {
                this.O00000oO = false;
                this.O00000o = i3;
                this.O00000o0++;
            }
            if (!this.O00000oO && i3 - i2 <= i + this.f10620O000000o) {
                this.O00000oO = O000000o();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null && getArguments().containsKey("device_id")) {
            this.O00000oo = getArguments().getString("device_id");
        }
        if (getArguments() != null && getArguments().containsKey("from")) {
            this.O0000Ooo = getArguments().getString("from");
        }
    }

    public void onPageSelected() {
        super.onPageSelected();
        if (this.O0000OoO) {
            ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.scene.SceneLogFragment.AnonymousClass3 */

                public final void run() {
                    if (SceneLogFragment.this.O0000o00 != null) {
                        gsy.O000000o(LogType.GENERAL, "SceneLogFragment", "SceneLogFragment 1000 after!");
                        SceneLogFragment.this.O0000o00.autoRefresh();
                        SceneLogFragment.this.O0000OoO = false;
                    }
                }
            }, 1000);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000oO0 = true;
        if (TextUtils.equals(this.O00000oo, "nfctag")) {
            hxi.O00000oO.f958O000000o.O000000o("NFC_scene_log", new Object[0]);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f10606O000000o == null) {
            this.f10606O000000o = layoutInflater.inflate((int) R.layout.fragment_scene_log_layout, (ViewGroup) null);
            this.O0000o00 = (PtrFrameLayout) this.f10606O000000o.findViewById(R.id.pull_to_refresh);
            this.O0000o00.setPtrHandler(new PtrDefaultHandler() {
                /* class com.xiaomi.smarthome.scene.SceneLogFragment.AnonymousClass4 */

                public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                    SceneLogFragment.this.O000000o();
                }
            });
            this.O0000Oo0.put(0, Integer.valueOf((int) R.string.scene_error_0));
            this.O0000Oo0.put(-2, Integer.valueOf((int) R.string.scene_error_2));
            this.O0000Oo0.put(-3, Integer.valueOf((int) R.string.scene_error_3));
            this.O0000Oo0.put(-33066, Integer.valueOf((int) R.string.scene_error_33066));
            this.O0000Oo0.put(-4003406, Integer.valueOf((int) R.string.smarthome_scene_client_deleted));
            this.O0000OOo = this.f10606O000000o.findViewById(R.id.common_white_empty_view);
            this.O00000oO = (ImageView) this.f10606O000000o.findViewById(R.id.del_iv);
            this.O0000OOo.setVisibility(8);
            ((TextView) this.f10606O000000o.findViewById(R.id.common_white_empty_text)).setText((int) R.string.smarthome_scene_no_log_data);
            this.O00000oO.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.SceneLogFragment.AnonymousClass6 */

                public final void onClick(View view) {
                    if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                        hrg.O000000o(SceneLogFragment.this.getContext(), SceneLogFragment.this.getResources().getString(R.string.log_clear_all_logs), SceneLogFragment.this.getString(R.string.sh_common_cancel), SceneLogFragment.this.getString(R.string.ok_button), new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.SceneLogFragment.AnonymousClass6.AnonymousClass1 */

                            public final void onClick(View view) {
                                hob.O000000o();
                                hob.O000000o(SceneLogFragment.this.O00000oo, SceneLogFragment.this.getActivity(), new fsm<Void, fso>() {
                                    /* class com.xiaomi.smarthome.scene.SceneLogFragment.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                                    public final void onFailure(fso fso) {
                                    }

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        SceneLogFragment.this.O0000O0o.clear();
                                        SceneLogFragment.this.O00000o.notifyDataSetChanged();
                                        SceneLogFragment.this.O0000OOo.setVisibility(0);
                                        SceneLogFragment.this.O00000oO.setVisibility(8);
                                    }
                                });
                            }
                        });
                    }
                }
            });
            this.O00000Oo = (ExpandableListView) this.f10606O000000o.findViewById(R.id.log_list);
            this.O00000Oo.setGroupIndicator(null);
            this.O00000Oo.setChildDivider(null);
            this.O00000Oo.setChildIndicator(null);
            this.O00000o = new O00000o0();
            this.O00000Oo.setAdapter(this.O00000o);
            this.O0000OOo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.SceneLogFragment.AnonymousClass7 */

                public final void onClick(View view) {
                    if (SceneLogFragment.this.O0000o00 != null) {
                        SceneLogFragment.this.O0000o00.autoRefresh();
                    }
                }
            });
            this.O00000o0 = new LoadingMoreView(getActivity());
            this.O00000Oo.addFooterView(this.O00000o0);
            this.O00000o0.setVisibility(0);
        }
        return this.f10606O000000o;
    }

    public void onResume() {
        super.onResume();
        if (this.O0000OoO) {
            ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.scene.SceneLogFragment.AnonymousClass5 */

                public final void run() {
                    if (SceneLogFragment.this.O0000o00 != null) {
                        gsy.O000000o(LogType.GENERAL, "SceneLogFragment", "SceneLogFragment 1000 after!");
                        SceneLogFragment.this.O0000o00.autoRefresh();
                        SceneLogFragment.this.O0000OoO = false;
                    }
                }
            }, 1000);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        long currentTimeMillis = System.currentTimeMillis();
        gsy.O000000o(LogType.GENERAL, "SceneLogFragment", "SceneLogFragment start initData!=====".concat(String.valueOf(currentTimeMillis)));
        if (!CoreApi.O000000o().O0000O0o()) {
            gsy.O000000o(LogType.GENERAL, "SceneLogFragment", "SceneLogFragment: core is not ready!=====".concat(String.valueOf(currentTimeMillis)));
        }
        if (CoreApi.O000000o().O0000O0o()) {
            O00000o0();
        } else {
            CoreApi.O000000o().O000000o(getContext(), new CoreApi.O0000o0(currentTimeMillis) {
                /* class com.xiaomi.smarthome.scene.$$Lambda$SceneLogFragment$3_pGsikujOZRLUbg9f3KwCAs08 */
                private final /* synthetic */ long f$1;

                {
                    this.f$1 = r2;
                }

                public final void onCoreReady() {
                    SceneLogFragment.this.O000000o(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(long j) {
        gsy.O000000o(LogType.GENERAL, "SceneLogFragment", "SceneLogFragment isCoreReady  onSuccess!====".concat(String.valueOf(j)));
        if (isValid()) {
            O00000o0();
        }
    }

    private void O00000o0() {
        if (this.O0000o00 != null) {
            this.O0000oO = -1;
            this.O0000o = false;
            hob.O000000o().O000000o(this.O00000oo, this.O0000oO, getActivity(), new fsm<hqb, fso>() {
                /* class com.xiaomi.smarthome.scene.SceneLogFragment.AnonymousClass8 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    hqb hqb = (hqb) obj;
                    SceneLogFragment.this.O0000o = !hqb.O00000Oo;
                    List<hqb.O00000Oo> list = hqb.f518O000000o;
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    SceneLogFragment sceneLogFragment = SceneLogFragment.this;
                    sceneLogFragment.O0000O0o = list;
                    sceneLogFragment.O0000o0.post(new Runnable(list) {
                        /* class com.xiaomi.smarthome.scene.$$Lambda$SceneLogFragment$8$0_pOYOT61a85YdqVzWOCXBAPhQc */
                        private final /* synthetic */ List f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            SceneLogFragment.AnonymousClass8.this.O000000o(this.f$1);
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(List list) {
                    if (SceneLogFragment.this.isValid()) {
                        SceneLogFragment.this.O0000o0O.O000000o(list);
                    }
                }

                public final void onFailure(fso fso) {
                    if (SceneLogFragment.this.isValid()) {
                        SceneLogFragment.this.O0000O0o.clear();
                        SceneLogFragment.this.O0000o0O.O00000Oo();
                    }
                }
            });
        }
    }

    public final boolean O00000Oo() {
        List<hqb.O00000Oo> list;
        if (!isValid() || (list = this.O0000O0o) == null || list.size() == 0 || this.O0000o) {
            return false;
        }
        this.O00000o0.setVisibility(0);
        this.O00000o0.O000000o();
        List<hqb.O00000Oo> list2 = this.O0000O0o;
        this.O0000oO = list2.get(list2.size() - 1).f520O000000o - 1;
        hob.O000000o().O000000o(this.O00000oo, this.O0000oO, getActivity(), new fsm<hqb, fso>() {
            /* class com.xiaomi.smarthome.scene.SceneLogFragment.AnonymousClass9 */

            public final /* synthetic */ void onSuccess(Object obj) {
                hqb hqb = (hqb) obj;
                gsy.O000000o(LogType.GENERAL, "SceneLogFragment", "SceneLogFragment getSceneLog  onSuccess!");
                if (SceneLogFragment.this.isValid()) {
                    List<hqb.O00000Oo> list = hqb.f518O000000o;
                    SceneLogFragment.this.O0000o = !hqb.O00000Oo;
                    if (SceneLogFragment.this.O0000O0o != null && SceneLogFragment.this.O0000O0o.size() > 0) {
                        hqb.O00000Oo o00000Oo = SceneLogFragment.this.O0000O0o.get(SceneLogFragment.this.O0000O0o.size() - 1);
                        hqb.O00000Oo o00000Oo2 = list.get(0);
                        if (o00000Oo != null && o00000Oo2 != null && TextUtils.equals(o00000Oo.O00000oo, o00000Oo2.O00000oo) && TextUtils.equals(o00000Oo.O00000o, o00000Oo2.O00000o) && TextUtils.equals(o00000Oo.O00000o0, o00000Oo2.O00000o0)) {
                            list.remove(0);
                        }
                    }
                    SceneLogFragment.this.O0000O0o.addAll(list);
                    SceneLogFragment.this.O0000o0.post(new Runnable(list) {
                        /* class com.xiaomi.smarthome.scene.$$Lambda$SceneLogFragment$9$ocRJAIAYlfNkxS72eosefp9uoMc */
                        private final /* synthetic */ List f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            SceneLogFragment.AnonymousClass9.this.O000000o(this.f$1);
                        }
                    });
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(List list) {
                if (SceneLogFragment.this.isValid()) {
                    SceneLogFragment.this.O0000o0O.O000000o();
                }
            }

            public final void onFailure(fso fso) {
                if (SceneLogFragment.this.isValid()) {
                    SceneLogFragment.this.O0000o0O.O00000o0();
                    LogType logType = LogType.GENERAL;
                    gsy.O000000o(logType, "SceneLogFragment", "SceneLogFragment getSceneLog  onFailure!" + fso.f17063O000000o);
                }
            }
        });
        return true;
    }

    class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        RelativeLayout f10621O000000o;
        RelativeLayout O00000Oo;
        TextView O00000o;
        TextView O00000o0;
        TextView O00000oO;
        ImageView O00000oo;
        ImageView O0000O0o;
        ImageView O0000OOo;
        TextView O0000Oo;
        ImageView O0000Oo0;
        TextView O0000OoO;
        View O0000Ooo;
        ImageView O0000o00;

        O00000o() {
        }
    }

    class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f10632O000000o;
        TextView O00000Oo;
        TextView O00000o0;

        O0000O0o() {
        }
    }

    class O00000o0 extends BaseExpandableListAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        final int[] f10622O000000o = {R.string.wifi_log_sunday, R.string.wifi_log_monday, R.string.wifi_log_tuesday, R.string.wifi_log_wednesday, R.string.wifi_log_thursday, R.string.wifi_log_friday, R.string.wifi_log_saturday};
        final int[] O00000Oo = {R.string.month_jan, R.string.month_feb, R.string.month_mar, R.string.month_apr, R.string.month_may, R.string.month_jun, R.string.month_jul, R.string.month_aug, R.string.month_sep, R.string.month_oct, R.string.month_nov, R.string.month_dec};
        private Typeface O00000o;

        public final boolean areAllItemsEnabled() {
            return false;
        }

        public final long getChildId(int i, int i2) {
            return 0;
        }

        public final long getCombinedChildId(long j, long j2) {
            return 0;
        }

        public final long getCombinedGroupId(long j) {
            return 0;
        }

        public final long getGroupId(int i) {
            return 0;
        }

        public final boolean hasStableIds() {
            return false;
        }

        public final boolean isChildSelectable(int i, int i2) {
            return false;
        }

        public final boolean isEmpty() {
            return false;
        }

        public final void onGroupCollapsed(int i) {
        }

        public final void onGroupExpanded(int i) {
        }

        public O00000o0() {
            this.O00000o = gno.O000000o(SceneLogFragment.this.getContext(), "fonts/DIN-Regular.ttf");
        }

        public final int getGroupCount() {
            if (SceneLogFragment.this.O0000O0o == null) {
                return 0;
            }
            return SceneLogFragment.this.O0000O0o.size();
        }

        public final int getChildrenCount(int i) {
            if (SceneLogFragment.this.O0000O0o.get(i).O00000Oo || SceneLogFragment.this.O0000O0o.get(i).O0000Oo == 0 || SceneLogFragment.this.O0000O0o.get(i) == null || SceneLogFragment.this.O0000O0o.get(i).O0000OoO == null) {
                return 0;
            }
            return SceneLogFragment.this.O0000O0o.get(i).O0000OoO.size();
        }

        public final Object getGroup(int i) {
            return SceneLogFragment.this.O0000O0o.get(i);
        }

        public final Object getChild(int i, int i2) {
            if (SceneLogFragment.this.O0000O0o.get(i).O0000OoO != null) {
                return SceneLogFragment.this.O0000O0o.get(i).O0000OoO.get(i2);
            }
            return null;
        }

        public final View getGroupView(final int i, boolean z, View view, ViewGroup viewGroup) {
            O00000o o00000o;
            if (view == null) {
                view = SceneLogFragment.this.getActivity().getLayoutInflater().inflate((int) R.layout.scene_group_log_item, (ViewGroup) null);
                o00000o = new O00000o();
                o00000o.f10621O000000o = (RelativeLayout) view.findViewById(R.id.log_time_container);
                o00000o.O00000Oo = (RelativeLayout) view.findViewById(R.id.log_content);
                o00000o.O00000o0 = (TextView) view.findViewById(R.id.month_text);
                o00000o.O00000o = (TextView) view.findViewById(R.id.day_text);
                o00000o.O00000oO = (TextView) view.findViewById(R.id.week_text);
                o00000o.O0000O0o = (ImageView) view.findViewById(R.id.feed_item_line_top);
                o00000o.O00000oo = (ImageView) view.findViewById(R.id.feed_item_line_circle_top);
                o00000o.O0000OOo = (ImageView) view.findViewById(R.id.feed_item_line_circle_bottom);
                o00000o.O0000Oo0 = (ImageView) view.findViewById(R.id.feed_item_icon);
                o00000o.O0000Oo = (TextView) view.findViewById(R.id.log_title_text);
                o00000o.O0000OoO = (TextView) view.findViewById(R.id.log_detail_text);
                o00000o.O0000Ooo = view.findViewById(R.id.top_line_margin);
                o00000o.O0000o00 = (ImageView) view.findViewById(R.id.right_arrow);
                view.setTag(o00000o);
            } else {
                o00000o = (O00000o) view.getTag();
            }
            view.setOnClickListener(null);
            String str = "";
            if (SceneLogFragment.this.O0000O0o.get(i).O00000Oo) {
                o00000o.f10621O000000o.setVisibility(0);
                o00000o.O00000Oo.setVisibility(8);
                o00000o.O0000OOo.setVisibility(0);
                o00000o.O00000o0.setTypeface(this.O00000o);
                o00000o.O00000o0.setText(SceneLogFragment.this.O0000O0o.get(i).O00000o0);
                try {
                    int intValue = Integer.valueOf(SceneLogFragment.this.O0000O0o.get(i).O00000o).intValue();
                    int intValue2 = Integer.valueOf(SceneLogFragment.this.O0000O0o.get(i).O00000oO).intValue();
                    if (intValue <= 0 || intValue > 12) {
                        o00000o.O00000o.setText(str);
                    } else {
                        o00000o.O00000o.setText(this.O00000Oo[intValue - 1]);
                    }
                    if (intValue2 < 0 || intValue2 > 6) {
                        o00000o.O00000oO.setText(str);
                    } else {
                        o00000o.O00000oO.setText(this.f10622O000000o[intValue2]);
                    }
                    if (TextUtils.equals("1", SceneLogFragment.this.O0000O0o.get(i).O00000o0) && TextUtils.equals("1", SceneLogFragment.this.O0000O0o.get(i).O00000o) && TextUtils.equals("1970", SceneLogFragment.this.O0000O0o.get(i).O00000oo)) {
                        gsy.O000000o(LogType.GENERAL, "SceneLogFragment", "SceneLogFragmentgetview：time is error");
                    }
                } catch (Exception e) {
                    o00000o.O00000o.setText(str);
                    o00000o.O00000oO.setText(str);
                    gsy.O000000o(LogType.GENERAL, "SceneLogFragment", "SceneLogFragment日期格式异常：" + e.getMessage());
                }
            } else {
                o00000o.f10621O000000o.setVisibility(8);
                o00000o.O00000Oo.setVisibility(0);
                o00000o.O0000OOo.setVisibility(8);
                o00000o.O0000O0o.setVisibility(0);
                o00000o.O00000oo.setVisibility(8);
                int i2 = i + 1;
                if (i2 >= SceneLogFragment.this.O0000O0o.size() || SceneLogFragment.this.O0000O0o.get(i2).O00000Oo) {
                    o00000o.O0000OOo.setVisibility(0);
                }
                int i3 = i - 1;
                if (i3 < 0 || !SceneLogFragment.this.O0000O0o.get(i3).O00000Oo) {
                    o00000o.O0000O0o.setVisibility(0);
                    o00000o.O00000oo.setVisibility(8);
                    o00000o.O0000Ooo.setVisibility(8);
                } else {
                    o00000o.O0000O0o.setVisibility(0);
                    o00000o.O00000oo.setVisibility(0);
                    o00000o.O0000Ooo.setVisibility(8);
                }
                o00000o.O0000Oo.setText(TextUtils.isEmpty(SceneLogFragment.this.O0000O0o.get(i).O0000O0o) ? str : SceneLogFragment.this.O0000O0o.get(i).O0000O0o);
                if (SceneLogFragment.this.O0000O0o.get(i).O0000Oo == 0) {
                    str = SceneLogFragment.this.getString(R.string.log_scene_sucess);
                } else if (SceneLogFragment.this.O0000O0o.get(i).O0000Oo == -1) {
                    str = SceneLogFragment.this.getString(R.string.log_scene_error);
                } else if (SceneLogFragment.this.O0000O0o.get(i).O0000Oo == 1) {
                    str = SceneLogFragment.this.getString(R.string.log_scene_success_part);
                }
                o00000o.O0000OoO.setText(SceneLogFragment.this.O0000O0o.get(i).O0000OOo + "  " + str);
                o00000o.O0000Oo0.setImageResource(SceneLogFragment.this.O0000O0o.get(i).O0000Oo0);
                if (i2 < SceneLogFragment.this.O0000O0o.size() && SceneLogFragment.this.O0000O0o.get(i2).O00000Oo) {
                    if (SceneLogFragment.this.O00000Oo.isGroupExpanded(i)) {
                        o00000o.O0000OOo.setVisibility(8);
                    } else {
                        o00000o.O0000OOo.setVisibility(0);
                    }
                }
                if (SceneLogFragment.this.O0000O0o.get(i).O0000Oo == 0 || SceneLogFragment.this.O0000O0o.get(i).O0000OoO.size() == 0) {
                    o00000o.O0000o00.setVisibility(8);
                    o00000o.O0000o00.setOnClickListener(null);
                } else {
                    o00000o.O0000o00.setVisibility(0);
                    o00000o.O0000o00.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.SceneLogFragment.O00000o0.AnonymousClass1 */

                        public final void onClick(View view) {
                            if (SceneLogFragment.this.O00000Oo.isGroupExpanded(i)) {
                                SceneLogFragment.this.O00000Oo.collapseGroup(i);
                            } else {
                                SceneLogFragment.this.O00000Oo.expandGroup(i);
                            }
                        }
                    });
                    if (SceneLogFragment.this.O00000Oo.isGroupExpanded(i)) {
                        o00000o.O0000o00.setImageResource(R.drawable.mj_arrow_up);
                        o00000o.O0000o00.setContentDescription(SceneLogFragment.this.getString(R.string.scen_log_close_detail));
                    } else {
                        o00000o.O0000o00.setImageResource(R.drawable.mj_drop_down_arrow);
                        o00000o.O0000o00.setContentDescription(SceneLogFragment.this.getString(R.string.scen_log_open_detail));
                    }
                }
                if (SceneLogFragment.this.O0000O0o.get(i).O0000Oo == 0) {
                    o00000o.O0000OoO.setTextColor(SceneLogFragment.this.getResources().getColor(R.color.mj_color_black_80_transparent));
                } else {
                    o00000o.O0000OoO.setTextColor(SceneLogFragment.this.getResources().getColor(R.color.mj_color_red_normal));
                }
                final hqb.O00000Oo o00000Oo = SceneLogFragment.this.O0000O0o.get(i);
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.SceneLogFragment.O00000o0.AnonymousClass2 */

                    public final void onClick(View view) {
                        hqb.O00000Oo o00000Oo;
                        if (TextUtils.equals(SceneLogFragment.this.O0000Ooo, "nfc_list") || (o00000Oo = o00000Oo) == null) {
                            return;
                        }
                        if (TextUtils.isEmpty(o00000Oo.O0000Ooo)) {
                            gqg.O00000Oo((int) R.string.scene_log_old_data_no_support);
                        } else {
                            O00000o0.this.O000000o(o00000Oo.O0000Ooo, o00000Oo.O0000o00);
                        }
                    }
                });
            }
            return view;
        }

        public final View getChildView(final int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            O0000O0o o0000O0o;
            if (view == null) {
                view = LayoutInflater.from(SceneLogFragment.this.getActivity()).inflate((int) R.layout.scene_log_item_detail, (ViewGroup) null);
                o0000O0o = new O0000O0o();
                o0000O0o.f10632O000000o = (TextView) view.findViewById(R.id.log_title_text);
                o0000O0o.O00000Oo = (TextView) view.findViewById(R.id.log_detail_text);
                o0000O0o.O00000o0 = (TextView) view.findViewById(R.id.log_detail_right_text);
                view.setTag(o0000O0o);
            } else {
                o0000O0o = (O0000O0o) view.getTag();
            }
            final hqb.O000000o o000000o = SceneLogFragment.this.O0000O0o.get(i).O0000OoO.get(i2);
            o0000O0o.f10632O000000o.setText(o000000o.O00000Oo);
            if (TextUtils.isEmpty(o000000o.O00000o0)) {
                o0000O0o.O00000Oo.setVisibility(8);
            } else {
                o0000O0o.O00000Oo.setVisibility(0);
                o0000O0o.O00000Oo.setText(o000000o.O00000o0);
            }
            o0000O0o.O00000o0.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.SceneLogFragment.O00000o0.AnonymousClass3 */

                public final void onClick(View view) {
                }
            });
            if (SceneLogFragment.this.O0000Oo0.containsKey(Integer.valueOf(o000000o.O00000oO))) {
                o0000O0o.O00000o0.setText(SceneLogFragment.this.O0000Oo0.get(Integer.valueOf(o000000o.O00000oO)).intValue());
            } else {
                o0000O0o.O00000o0.setText((int) R.string.scene_error_other);
                o0000O0o.O00000o0.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.SceneLogFragment.O00000o0.AnonymousClass4 */

                    public final void onClick(View view) {
                        O00000o0 o00000o0 = O00000o0.this;
                        new MLAlertDialog.Builder(SceneLogFragment.this.getActivity()).O00000o0().O00000Oo((int) R.string.scene_error_dialog_tips).O00000o0((int) R.string.scene_has_knowed, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.SceneLogFragment.O00000o0.AnonymousClass8 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).O00000o().show();
                    }
                });
            }
            int i3 = i + 1;
            if (i3 >= SceneLogFragment.this.O0000O0o.size() || !SceneLogFragment.this.O0000O0o.get(i3).O00000Oo) {
                view.findViewById(R.id.feed_item_line_circle_bottom).setVisibility(8);
            } else {
                view.findViewById(R.id.feed_item_line_circle_bottom).setVisibility(0);
            }
            if (o000000o.O00000oO == 0) {
                o0000O0o.O00000o0.setTextColor(SceneLogFragment.this.getResources().getColor(R.color.mj_color_black_80_transparent));
            } else {
                o0000O0o.O00000o0.setTextColor(SceneLogFragment.this.getResources().getColor(R.color.mj_color_red_normal));
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.SceneLogFragment.O00000o0.AnonymousClass5 */

                public final void onClick(View view) {
                    hqb.O000000o o000000o;
                    if (!TextUtils.equals(SceneLogFragment.this.O0000Ooo, "nfc_list") && (o000000o = o000000o) != null && !TextUtils.isEmpty(o000000o.O00000oo)) {
                        O00000o0.this.O000000o(o000000o.O00000oo, SceneLogFragment.this.O0000O0o.get(i).O0000o00);
                    }
                }
            });
            return view;
        }

        public final void O000000o(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                gqg.O00000Oo((int) R.string.scene_log_scene_no_exist);
                gsy.O00000Oo(LogType.SCENE, "SceneLog", "sceneid is null");
            } else if (i == 2) {
                hnz.O000000o(SceneLogFragment.this.getActivity(), Long.parseLong(str), 1, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.scene.SceneLogFragment.O00000o0.AnonymousClass6 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (SceneLogFragment.this.isValid()) {
                            if (jSONObject != null) {
                                final hqs O000000o2 = hqs.O000000o(jSONObject);
                                if (TextUtils.isEmpty(O000000o2.O00000o0) || ggb.O00000Oo().O00000o(O000000o2.O00000o0) != null) {
                                    FragmentActivity activity = SceneLogFragment.this.getActivity();
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(O000000o2.O00000Oo);
                                    hnz.O00000Oo(activity, sb.toString(), 1, new fsm<JSONObject, fso>() {
                                        /* class com.xiaomi.smarthome.scene.SceneLogFragment.O00000o0.AnonymousClass6.AnonymousClass1 */

                                        public final /* synthetic */ void onSuccess(Object obj) {
                                            JSONObject jSONObject = (JSONObject) obj;
                                            if (SceneLogFragment.this.isValid()) {
                                                hof O000000o2 = hof.O000000o(jSONObject);
                                                hrh O000000o3 = hrh.O000000o();
                                                hqs hqs = O000000o2;
                                                hoh hoh = new hoh();
                                                hoh.O00000Oo = hqs.f529O000000o;
                                                hoh.O00000o0 = hqs.O0000O0o;
                                                hoh.f444O000000o = hqs.O00000Oo;
                                                int i = 0;
                                                while (true) {
                                                    if (i >= (hqs.O0000o00 == null ? 0 : hqs.O0000o00.size())) {
                                                        break;
                                                    } else if (TextUtils.equals(hqs.O0000o00.get(i).O00000oo, "user.click")) {
                                                        hoh.O00000o = true;
                                                        break;
                                                    } else {
                                                        i++;
                                                    }
                                                }
                                                O000000o3.f558O000000o = hoh;
                                                hrh.O000000o().O000000o(O000000o2.O00000o0, O000000o2);
                                                hor.O000000o().openRecommendSceneDetail(SceneLogFragment.this.getActivity(), O000000o2.O00000Oo.longValue(), O000000o2.O00000oo, null);
                                            }
                                        }

                                        public final void onFailure(fso fso) {
                                            gqg.O00000Oo((int) R.string.scene_log_scene_no_exist);
                                        }
                                    });
                                    return;
                                }
                            }
                            gqg.O00000Oo((int) R.string.scene_log_scene_no_exist);
                        }
                    }

                    public final void onFailure(fso fso) {
                        gqg.O00000Oo((int) R.string.scene_log_scene_no_exist);
                    }
                });
            } else {
                hob.O000000o();
                hob.O00000o0(SceneLogFragment.this.getActivity(), str, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.scene.SceneLogFragment.O00000o0.AnonymousClass7 */

                    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0059, code lost:
                        if (_m_j.hod.O00000Oo(r5) != false) goto L_0x005b;
                     */
                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject == null) {
                            gqg.O00000Oo((int) R.string.scene_log_scene_no_exist);
                            return;
                        }
                        int optInt = jSONObject.optInt("st_id");
                        if (optInt == 8) {
                            SceneLogFragment.O000000o(SceneLogFragment.this.getContext(), jSONObject);
                        } else if (optInt == 15 || optInt == 30) {
                            try {
                                SceneApi.O000OOOo O000000o2 = SceneApi.O000OOOo.O000000o(jSONObject, optInt == 30);
                                if (O000000o2 != null && !SceneLogFragment.O000000o(O000000o2)) {
                                    if (!SceneLogFragment.O00000Oo(O000000o2) || hpf.O000000o().O00000o0()) {
                                        hod.O0000OoO();
                                        if (!hod.O000000o(O000000o2)) {
                                            hod.O0000OoO();
                                        }
                                        Intent intent = new Intent(SceneLogFragment.this.getActivity(), GoLeaveHomeSceneCreateEditActivity.class);
                                        intent.putExtra("scene_id", O000000o2.f11131O000000o);
                                        SceneLogFragment.this.startActivity(intent);
                                        if (SceneLogFragment.O00000o0(O000000o2)) {
                                            gqg.O00000Oo((int) R.string.scene_log_scene_no_exist);
                                            return;
                                        }
                                        Intent intent2 = new Intent(SceneLogFragment.this.getActivity(), SmarthomeCreateAutoSceneActivity.class);
                                        hpq.O000000o().O000000o(O000000o2);
                                        SceneLogFragment.this.getActivity().startActivityForResult(intent2, 999);
                                        return;
                                    }
                                    gqg.O00000Oo((int) R.string.cannot_edit_ios_scene);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            gqg.O00000Oo((int) R.string.scene_log_scene_no_exist);
                        }
                    }

                    public final void onFailure(fso fso) {
                        gqg.O00000Oo((int) R.string.scene_log_scene_no_exist);
                    }
                });
            }
        }
    }

    public static boolean O000000o(SceneApi.O000OOOo o000OOOo) {
        if (o000OOOo != null && !o000OOOo.O0000oO0 && o000OOOo.O0000O0o != null && o000OOOo.O0000O0o.size() == 1 && o000OOOo.O0000O0o.get(0).f11121O000000o == LAUNCH_TYPE.NFC) {
            return true;
        }
        return false;
    }

    public static boolean O00000Oo(SceneApi.O000OOOo o000OOOo) {
        if (!(o000OOOo == null || o000OOOo.O0000oO0 || o000OOOo.O0000O0o == null)) {
            for (int i = 0; i < o000OOOo.O0000O0o.size(); i++) {
                if (o000OOOo.O0000O0o.get(i).f11121O000000o == LAUNCH_TYPE.ENTER_FENCE || o000OOOo.O0000O0o.get(i).f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean O00000o0(SceneApi.O000OOOo o000OOOo) {
        if (!(o000OOOo == null || o000OOOo.O0000oO0 || o000OOOo.O0000O0o == null)) {
            for (int i = 0; i < o000OOOo.O0000O0o.size(); i++) {
                if (o000OOOo.O0000O0o.get(i).f11121O000000o == LAUNCH_TYPE.COME_HOME || o000OOOo.O0000O0o.get(i).f11121O000000o == LAUNCH_TYPE.LEAVE_HOME || o000OOOo.O0000O0o.get(i).f11121O000000o == LAUNCH_TYPE.MIBAND || o000OOOo.O0000O0o.get(i).f11121O000000o == LAUNCH_TYPE.MIKEY || o000OOOo.O0000O0o.get(i).f11121O000000o == LAUNCH_TYPE.PHONE_CALL || o000OOOo.O0000O0o.get(i).f11121O000000o == LAUNCH_TYPE.PHONE_SMS) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void O000000o(Context context, JSONObject jSONObject) {
        CommonTimer O000000o2 = CommonTimer.O000000o(jSONObject);
        if (TextUtils.isEmpty(O000000o2.O0000o0O) || TextUtils.equals(O000000o2.O0000o0O, "0")) {
            if (TextUtils.isEmpty(O000000o2.O00000Oo) || fno.O000000o().O000000o(O000000o2.O00000Oo) == null) {
                gqg.O00000Oo((int) R.string.smarthome_scene_client_deleted);
                return;
            }
            Intent intent = new Intent(context, SetTimerCommonActivity.class);
            if (O000000o2.O0000O0o && O000000o2.O0000OoO) {
                intent.putExtra("custom_title_text", context.getResources().getString(R.string.plug_timer_type_period));
                intent.putExtra("both_timer_must_be_set", true);
                intent.putExtra("timer_type", 0);
            } else if (O000000o2.O0000O0o) {
                intent.putExtra("custom_title_text", context.getResources().getString(R.string.plug_timer_type_on));
                intent.putExtra("both_timer_must_be_set", false);
                intent.putExtra("off_gone", true);
                intent.putExtra("timer_type", 1);
            } else if (O000000o2.O0000OoO) {
                intent.putExtra("custom_title_text", context.getResources().getString(R.string.plug_timer_type_off));
                intent.putExtra("both_timer_must_be_set", false);
                intent.putExtra("on_gone", true);
                intent.putExtra("timer_type", 2);
            }
            intent.putExtra("timer_identify_rn", O000000o2.O00000o);
            intent.putExtra("common.timer", O000000o2);
            context.startActivity(intent);
        } else if (TextUtils.equals(O000000o2.O0000o0O, "1")) {
            Intent intent2 = new Intent(context, CountDownTimerStartActivity.class);
            intent2.putExtra("is_from_log", true);
            intent2.putExtra("on_method", O000000o2.O0000OOo);
            intent2.putExtra("on_param", O000000o2.O0000Oo0);
            intent2.putExtra("off_method", O000000o2.O0000Ooo);
            intent2.putExtra("off_param", O000000o2.O0000o00);
            intent2.putExtra("device_power_on", O000000o2.O00000oo);
            intent2.putExtra("target_time", PlugTimer.O000000o(O000000o2));
            intent2.putExtra("timer_identify_rn", O000000o2.O00000o);
            intent2.putExtra("common_timer_display_name", O000000o2.O00000o0);
            context.startActivity(intent2);
        }
    }
}
