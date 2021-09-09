package com.xiaomi.smarthome.newui;

import _m_j.awq;
import _m_j.axx;
import _m_j.fh;
import _m_j.fo;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fvm;
import _m_j.ggb;
import _m_j.gwg;
import _m_j.gzy;
import _m_j.gzz;
import _m_j.hgr;
import _m_j.hgs;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class HomeEnvInfoSettingFragment extends fvm {

    /* renamed from: O000000o  reason: collision with root package name */
    public XQProgressDialog f10099O000000o;
    protected RecyclerViewExpandableItemManager O00000Oo;
    protected RecyclerView.O000000o O00000o;
    protected axx O00000o0;
    protected LinearLayoutManager O00000oO;
    private View O00000oo;
    private gzy O0000O0o;
    private String O0000OOo;
    private Unbinder O0000Oo;
    private gzz O0000Oo0;
    @BindView(5368)
    TextView mEmpty;
    @BindView(5900)
    DevicePtrFrameLayout mPullRefresh;
    @BindView(5924)
    RecyclerView mRecyclerView;
    @BindView(5706)
    ImageView mReturnImageView;
    @BindView(5710)
    TextView mTextTitle;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.O00000oo == null) {
            this.O00000oo = layoutInflater.inflate((int) R.layout.fragment_home_env_info, (ViewGroup) null);
            this.O0000Oo = ButterKnife.bind(this, this.O00000oo);
            this.mPullRefresh.setPtrHandler(new PtrDefaultHandler() {
                /* class com.xiaomi.smarthome.newui.HomeEnvInfoSettingFragment.AnonymousClass2 */

                public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                    HomeEnvInfoSettingFragment.this.mPullRefresh.refreshComplete();
                }

                public final boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
                    if (HomeEnvInfoSettingFragment.this.mRecyclerView.canScrollVertically(-1)) {
                        return false;
                    }
                    return super.checkCanDoRefresh(ptrFrameLayout, view, view2);
                }
            });
            this.mReturnImageView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.$$Lambda$HomeEnvInfoSettingFragment$dPDKTafLA1FV4qKjPmZoT4Bk */

                public final void onClick(View view) {
                    HomeEnvInfoSettingFragment.this.O000000o(view);
                }
            });
            this.mRecyclerView.setOnScrollListener(new RecyclerView.O00oOooO() {
                /* class com.xiaomi.smarthome.newui.HomeEnvInfoSettingFragment.AnonymousClass1 */

                public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    View currentFocus;
                    super.onScrollStateChanged(recyclerView, i);
                    if (i != 0 && HomeEnvInfoSettingFragment.this.isValid() && (currentFocus = HomeEnvInfoSettingFragment.this.getActivity().getCurrentFocus()) != null) {
                        currentFocus.clearFocus();
                    }
                }
            });
            this.O00000Oo = new RecyclerViewExpandableItemManager();
            this.O0000O0o = new gzy(getActivity(), true);
            this.O00000o = this.O00000Oo.O000000o(this.O0000O0o);
            this.O00000oO = new LinearLayoutManager(getActivity());
            this.O00000oO.setAutoMeasureEnabled(true);
            this.O00000oO.setSmoothScrollbarEnabled(true);
            awq awq = new awq();
            awq.O0000o00 = false;
            this.mRecyclerView.setLayoutManager(this.O00000oO);
            this.mRecyclerView.setAdapter(this.O00000o);
            this.mRecyclerView.setItemAnimator(awq);
            this.mRecyclerView.setHasFixedSize(true);
            this.O00000o0 = new axx();
            axx axx = this.O00000o0;
            axx.O0000OOo = true;
            axx.O00000Oo();
            this.O00000o0.O000000o(this.mRecyclerView);
            this.O00000Oo.O000000o(this.mRecyclerView);
            this.O00000Oo.O000000o();
            this.mTextTitle.setText((int) R.string.home_env_info_setting);
            gwg.O00000Oo(getActivity().getWindow());
            this.O0000OOo = ggb.O00000Oo().O0000OOo();
            if (getActivity() != null) {
                this.O0000Oo0 = (gzz) fo.O000000o(getActivity()).O000000o(gzz.class);
                this.O0000Oo0.O000000o().observe(this, new fh() {
                    /* class com.xiaomi.smarthome.newui.$$Lambda$HomeEnvInfoSettingFragment$DHrZFtLyu9czMwRGZyLVDSb_Z8 */

                    public final void onChanged(Object obj) {
                        HomeEnvInfoSettingFragment.this.O00000Oo((Map) obj);
                    }
                });
                this.O0000Oo0.O00000o0().observe(this, new fh() {
                    /* class com.xiaomi.smarthome.newui.$$Lambda$HomeEnvInfoSettingFragment$fkBw9uSlDdD43FghHVJH6l8wM3A */

                    public final void onChanged(Object obj) {
                        HomeEnvInfoSettingFragment.this.O000000o((Map) obj);
                    }
                });
            }
            O000000o();
            O000000o(this.O0000Oo0.O00000o0().getValue());
        }
        return this.O00000oo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(Map map) {
        O000000o();
    }

    /* access modifiers changed from: private */
    public void O000000o(Map<String, List<hgr>> map) {
        if (map != null && !map.isEmpty() && map.get(this.O0000OOo) != null) {
            HashMap hashMap = new HashMap();
            for (hgr hgr : map.get(this.O0000OOo)) {
                hashMap.put(hgr.f18915O000000o, hgr.O00000Oo);
            }
            gzy gzy = this.O0000O0o;
            if (!hashMap.isEmpty()) {
                gzy.O00000o0 = hashMap;
            }
        }
    }

    private void O000000o() {
        List<gzz.O000000o> O00000o2 = this.O0000Oo0.O00000o(this.O0000OOo);
        if (O00000o2 == null || O00000o2.isEmpty()) {
            this.mEmpty.setVisibility(0);
            this.mRecyclerView.setVisibility(8);
            return;
        }
        this.mRecyclerView.setVisibility(0);
        this.mEmpty.setVisibility(8);
        gzy gzy = this.O0000O0o;
        gzy.O00000oO = O00000o2;
        gzy.notifyDataSetChanged();
        this.O00000Oo.O000000o();
    }

    public boolean onBackPressed() {
        if (this.O0000O0o.f18675O000000o) {
            this.f10099O000000o = new XQProgressDialog(getContext());
            this.f10099O000000o.setMessage(getResources().getString(R.string.mj_loading));
            this.f10099O000000o.setCancelable(false);
            this.f10099O000000o.show();
            ArrayList arrayList = new ArrayList();
            Map<String, String> map = this.O0000O0o.O00000o0;
            if (map == null) {
                return true;
            }
            for (String next : gzz.O0000O0o) {
                arrayList.add(new hgr(next, map.get(next)));
            }
            gzz gzz = this.O0000Oo0;
            String str = this.O0000OOo;
            AnonymousClass3 r3 = new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.newui.HomeEnvInfoSettingFragment.AnonymousClass3 */

                public final void onFailure(fso fso) {
                    if (HomeEnvInfoSettingFragment.this.isValid()) {
                        HomeEnvInfoSettingFragment.this.getActivity().getSupportFragmentManager().O00000o();
                    }
                    if (HomeEnvInfoSettingFragment.this.f10099O000000o != null && HomeEnvInfoSettingFragment.this.f10099O000000o.isShowing()) {
                        HomeEnvInfoSettingFragment.this.f10099O000000o.dismiss();
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (HomeEnvInfoSettingFragment.this.isValid()) {
                        HomeEnvInfoSettingFragment.this.getActivity().getSupportFragmentManager().O00000o();
                    }
                    if (HomeEnvInfoSettingFragment.this.f10099O000000o != null && HomeEnvInfoSettingFragment.this.f10099O000000o.isShowing()) {
                        HomeEnvInfoSettingFragment.this.f10099O000000o.dismiss();
                    }
                }
            };
            if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                return true;
            }
            hgs.O000000o().O000000o(str, arrayList, new fsm<JSONObject, fso>(str, arrayList, r3) {
                /* class _m_j.gzz.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ String f18677O000000o;
                final /* synthetic */ List O00000Oo;
                final /* synthetic */ fsm O00000o0;

                {
                    this.f18677O000000o = r2;
                    this.O00000Oo = r3;
                    this.O00000o0 = r4;
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null && jSONObject.optInt("code", -1) == 0) {
                        Map value = gzz.this.O0000Ooo.getValue();
                        if (value == null) {
                            value = new HashMap();
                        }
                        value.put(this.f18677O000000o, this.O00000Oo);
                        gzz.this.O0000Ooo.postValue(value);
                    }
                    fsm fsm = this.O00000o0;
                    if (fsm != null) {
                        fsm.onSuccess(jSONObject);
                    }
                    String str = gzz.f18676O000000o;
                    gsy.O00000Oo(str, "setDefaultEnvDevicesToServer onSuccess: " + jSONObject.toString());
                }

                public final void onFailure(fso fso) {
                    fsm fsm = this.O00000o0;
                    if (fsm != null) {
                        fsm.onFailure(fso);
                    }
                    String str = gzz.f18676O000000o;
                    gsy.O00000Oo(str, "setDefaultEnvDevicesToServer onFailure: " + fso.O00000Oo);
                }
            });
            return true;
        }
        getActivity().getSupportFragmentManager().O00000o();
        return true;
    }

    public void onDestroyView() {
        XQProgressDialog xQProgressDialog = this.f10099O000000o;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.f10099O000000o.dismiss();
        }
        super.onDestroyView();
    }

    public void onDestroy() {
        Unbinder unbinder = this.O0000Oo;
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }
}
