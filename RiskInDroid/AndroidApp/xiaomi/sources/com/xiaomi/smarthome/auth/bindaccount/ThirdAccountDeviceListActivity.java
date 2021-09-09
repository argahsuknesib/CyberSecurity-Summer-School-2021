package com.xiaomi.smarthome.auth.bindaccount;

import _m_j.fal;
import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gqq;
import _m_j.gsy;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxt;
import _m_j.hyg;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.auth.bindaccount.model.ThirdAccount;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import com.xiaomi.smarthome.library.common.widget.SmartHomePtrHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ThirdAccountDeviceListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f4296O000000o;
    private TextView O00000Oo;
    private SmartHomePtrHeader O00000o;
    private RecyclerView O00000o0;
    private PtrIndicator O00000oO;
    private ImageView O00000oo;
    private View O0000O0o;
    private boolean O0000OOo = false;
    private BroadcastReceiver O0000Oo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDeviceListActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "filter_sync_dev")) {
                if (ThirdAccountDeviceListActivity.this.mSyncRotateAnimate != null) {
                    ThirdAccountDeviceListActivity.this.mSyncRotateAnimate.cancel();
                }
                if (intent.getIntExtra("sync_dev_code", 0) == 0) {
                    ThirdAccountDeviceListActivity.this.startRefresh(true);
                    gqg.O00000Oo((int) R.string.third_account_sync_device_success);
                    return;
                }
                gqg.O00000Oo((int) R.string.third_account_sync_device_failed);
            }
        }
    };
    private TextView O0000Oo0;
    public O000000o mAdapter;
    public XQProgressDialog mProcessDialog;
    public DevicePtrFrameLayout mPullRefresh;
    public Animation mSyncRotateAnimate;
    public View mSyncTv;
    public ThirdAccount mThirdAccount;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.mThirdAccount = fal.getInstance().O000000o(intent.getStringExtra("account_id"));
        if (this.mThirdAccount == null) {
            finish();
            return;
        }
        setContentView((int) R.layout.activity_third_account_device_list_layout);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDeviceListActivity.AnonymousClass9 */

            public final void onClick(View view) {
                ThirdAccountDeviceListActivity.this.finish();
            }
        });
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        String str = this.mThirdAccount.f4322O000000o;
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.third_account_list_title);
        }
        textView.setText(str);
        findViewById(R.id.module_a_3_return_more_more_btn).setVisibility(8);
        this.f4296O000000o = findViewById(R.id.common_white_empty_view);
        this.O00000Oo = (TextView) this.f4296O000000o.findViewById(R.id.common_white_empty_text);
        this.O0000Oo0 = (TextView) findViewById(R.id.expire_view);
        String string = getString(R.string.third_account_bind_expire);
        String string2 = getString(R.string.third_account_rebind);
        try {
            int indexOf = string.indexOf("%s");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(string, string2));
            spannableStringBuilder.setSpan(new ClickableSpan() {
                /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDeviceListActivity.AnonymousClass8 */

                public final void onClick(View view) {
                    if (ThirdAccountDeviceListActivity.this.mThirdAccount.O00000oo != 0) {
                        ThirdAccountDeviceListActivity.this.finish();
                        Intent intent = new Intent(ThirdAccountDeviceListActivity.this, ThirdAccountDetailActivity.class);
                        intent.putExtra("account_id", ThirdAccountDeviceListActivity.this.mThirdAccount.O00000Oo);
                        ThirdAccountDeviceListActivity.this.startActivity(intent);
                        hxi.O00000o.O000000o(ThirdAccountDeviceListActivity.this.mThirdAccount.f4322O000000o);
                    }
                }

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ThirdAccountDeviceListActivity.this.getResources().getColor(R.color.mj_color_orange_normal));
                    textPaint.setUnderlineText(false);
                }
            }, indexOf, string2.length() + indexOf, 33);
            this.O0000Oo0.setText(spannableStringBuilder);
            this.O0000Oo0.setMovementMethod(LinkMovementMethod.getInstance());
            this.O0000Oo0.setHighlightColor(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mPullRefresh = (DevicePtrFrameLayout) findViewById(R.id.pull_down_refresh);
        this.O00000o = (SmartHomePtrHeader) findViewById(R.id.pull_header_new);
        this.O00000oO = new PtrIndicator();
        this.mPullRefresh.disableWhenHorizontalMove(true);
        this.mPullRefresh.setPullToRefresh(false);
        this.mPullRefresh.setPtrIndicator(this.O00000oO);
        this.mPullRefresh.addPtrUIHandler(new gqq());
        this.mPullRefresh.setPtrHandler(new PtrDefaultHandler() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDeviceListActivity.AnonymousClass5 */

            public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                ThirdAccountDeviceListActivity.this.startRefresh(false);
            }
        });
        this.O00000o0 = (RecyclerView) findViewById(R.id.recycler_view);
        this.O00000o0.setLayoutManager(new LinearLayoutManager(this));
        this.mAdapter = new O000000o(this, (byte) 0);
        this.O00000o0.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.tag_group_item_common_3, (ViewGroup) this.O00000o0, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        layoutParams.height = gpc.O000000o(20.0f);
        inflate.setLayoutParams(layoutParams);
        O000000o o000000o = this.mAdapter;
        o000000o.O00000Oo = inflate;
        o000000o.notifyItemInserted(0);
        this.mSyncTv = findViewById(R.id.sync_device);
        this.mSyncTv.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDeviceListActivity.AnonymousClass2 */

            public final void onClick(View view) {
                ThirdAccountDeviceListActivity.this.startSync();
                hxk hxk = hxi.O00000o;
                String str = ThirdAccountDeviceListActivity.this.mThirdAccount.f4322O000000o;
                hyg hyg = hxk.f952O000000o;
                Object[] objArr = new Object[2];
                objArr[0] = "name";
                if (str == null) {
                    str = "null";
                }
                objArr[1] = str;
                hyg.O000000o("ctoc_synchronization", objArr);
            }
        });
        this.O00000oo = (ImageView) findViewById(R.id.sync_icon);
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDeviceListActivity.AnonymousClass3 */

            public final void onClick(View view) {
                ThirdAccountDeviceListActivity.this.mSyncTv.performClick();
            }
        });
        this.O0000O0o = findViewById(R.id.unbind_device);
        this.O0000O0o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDeviceListActivity.AnonymousClass4 */

            public final void onClick(View view) {
                ThirdAccountDeviceListActivity.this.startUnbind();
                hxk hxk = hxi.O00000o;
                String str = ThirdAccountDeviceListActivity.this.mThirdAccount.f4322O000000o;
                hyg hyg = hxk.f952O000000o;
                Object[] objArr = new Object[2];
                objArr[0] = "name";
                if (str == null) {
                    str = "null";
                }
                objArr[1] = str;
                hyg.O000000o("ctoc_relieve", objArr);
            }
        });
        if (this.mThirdAccount.O00000oo == 1) {
            showExpireView();
        } else {
            ThirdAccount thirdAccount = this.mThirdAccount;
            if (thirdAccount == null || thirdAccount.O00000oO == null || this.mThirdAccount.O00000oO.isEmpty()) {
                showEmptyView();
            } else {
                showContentView();
            }
        }
        fal.getInstance();
        ThirdAccount thirdAccount2 = this.mThirdAccount;
        if (fal.O00000o(thirdAccount2 == null ? "" : thirdAccount2.O00000Oo)) {
            O000000o();
        }
        this.mPullRefresh.autoRefresh();
        startRefresh(false);
        ft.O000000o(this).O000000o(this.O0000Oo, new IntentFilter("filter_sync_dev"));
        this.O0000OOo = intent.getBooleanExtra("sync_on_start", false);
        if (this.O0000OOo) {
            startSync();
        }
    }

    public void startRefresh(final boolean z) {
        if (this.mThirdAccount != null) {
            fal.getInstance().O000000o(new fsm<Void, fso>() {
                /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDeviceListActivity.AnonymousClass6 */

                public final void onFailure(fso fso) {
                    if (ThirdAccountDeviceListActivity.this.isValid()) {
                        gsy.O00000Oo(20000, "20000.3.1", "");
                        ThirdAccountDeviceListActivity.this.mPullRefresh.refreshComplete();
                        gqg.O00000Oo((int) R.string.loading_failed);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (ThirdAccountDeviceListActivity.this.isValid()) {
                        ThirdAccountDeviceListActivity.this.mPullRefresh.refreshComplete();
                        ThirdAccountDeviceListActivity.this.mThirdAccount = fal.getInstance().O000000o(ThirdAccountDeviceListActivity.this.mThirdAccount.O00000Oo);
                        if (ThirdAccountDeviceListActivity.this.mThirdAccount == null) {
                            ThirdAccountDeviceListActivity.this.finish();
                            return;
                        }
                        try {
                            if (ThirdAccountDeviceListActivity.this.mThirdAccount.O00000oo == 1) {
                                ThirdAccountDeviceListActivity.this.showExpireView();
                            } else if (ThirdAccountDeviceListActivity.this.mThirdAccount.O00000oo == -1) {
                                ThirdAccountDeviceListActivity.this.showNotBindView();
                            } else {
                                if (ThirdAccountDeviceListActivity.this.mThirdAccount.O00000oO != null) {
                                    if (!ThirdAccountDeviceListActivity.this.mThirdAccount.O00000oO.isEmpty()) {
                                        List<Device> list = ThirdAccountDeviceListActivity.this.mThirdAccount.O00000oO;
                                        if (list == null) {
                                            list = new ArrayList<>();
                                        }
                                        if (z) {
                                            StringBuilder sb = new StringBuilder();
                                            for (int i = 0; i < list.size(); i++) {
                                                sb.append(list.get(i).did);
                                                sb.append(";");
                                            }
                                            hxt hxt = hxi.O0000Oo;
                                            int size = list.size();
                                            String sb2 = sb.toString();
                                            hxt.f960O000000o.O000000o("ctoc_synchronization_success", "num", Integer.valueOf(size), "did", sb2);
                                        }
                                        if (list.isEmpty()) {
                                            ThirdAccountDeviceListActivity.this.showEmptyView();
                                            return;
                                        }
                                        ThirdAccountDeviceListActivity.this.showContentView();
                                        O000000o o000000o = ThirdAccountDeviceListActivity.this.mAdapter;
                                        if (list == null) {
                                            o000000o.f4308O000000o = new ArrayList();
                                        } else {
                                            o000000o.f4308O000000o = list;
                                        }
                                        ThirdAccountDeviceListActivity.this.mAdapter.notifyDataSetChanged();
                                        return;
                                    }
                                }
                                ThirdAccountDeviceListActivity.this.showEmptyView();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void showNotBindView() {
        this.mSyncTv.setVisibility(8);
        this.O00000oo.setVisibility(8);
        this.O0000O0o.setVisibility(8);
        this.f4296O000000o.setVisibility(0);
        this.O00000o0.setVisibility(8);
        this.O0000Oo0.setVisibility(8);
        this.O00000Oo.setText((int) R.string.third_account_bind_lose_efficacy);
    }

    public void showEmptyView() {
        this.mSyncTv.setVisibility(0);
        this.O00000oo.setVisibility(0);
        this.O0000O0o.setVisibility(0);
        this.f4296O000000o.setVisibility(0);
        this.O00000o0.setVisibility(8);
        this.O0000Oo0.setVisibility(8);
        TextView textView = this.O00000Oo;
        ThirdAccount thirdAccount = this.mThirdAccount;
        textView.setText(thirdAccount == null ? "" : thirdAccount.f4322O000000o);
    }

    public void showContentView() {
        this.mSyncTv.setVisibility(0);
        this.O00000oo.setVisibility(0);
        this.O0000O0o.setVisibility(0);
        this.f4296O000000o.setVisibility(8);
        this.O0000Oo0.setVisibility(8);
        this.O00000o0.setVisibility(0);
        this.mSyncTv.setEnabled(true);
        this.O00000oo.setEnabled(true);
    }

    public void showExpireView() {
        this.mSyncTv.setVisibility(0);
        this.O00000oo.setVisibility(0);
        this.O0000O0o.setVisibility(0);
        this.f4296O000000o.setVisibility(8);
        this.O00000o0.setVisibility(8);
        this.O0000Oo0.setVisibility(0);
        this.mSyncTv.setEnabled(false);
        this.O00000oo.setEnabled(false);
    }

    public void startSync() {
        fal.getInstance();
        ThirdAccount thirdAccount = this.mThirdAccount;
        String str = "";
        if (!fal.O00000o(thirdAccount == null ? str : thirdAccount.O00000Oo)) {
            O000000o();
            fal.getInstance();
            ThirdAccount thirdAccount2 = this.mThirdAccount;
            if (thirdAccount2 != null) {
                str = thirdAccount2.O00000Oo;
            }
            fal.O00000o0(str);
        }
    }

    private void O000000o() {
        if (this.mSyncRotateAnimate == null) {
            this.mSyncRotateAnimate = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.mSyncRotateAnimate.setInterpolator(new LinearInterpolator());
        }
        this.mSyncRotateAnimate.setDuration(1000);
        this.mSyncRotateAnimate.setRepeatCount(-1);
        this.mSyncRotateAnimate.setRepeatMode(-1);
        this.mSyncRotateAnimate.setFillAfter(true);
        this.O00000oo.startAnimation(this.mSyncRotateAnimate);
    }

    public void onDestroy() {
        super.onDestroy();
        Animation animation = this.mSyncRotateAnimate;
        if (animation != null) {
            animation.cancel();
        }
        try {
            ft.O000000o(this).O000000o(this.O0000Oo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startUnbind() {
        new MLAlertDialog.Builder(this).O00000Oo(getResources().getString(R.string.third_account_unbind_msg)).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.third_account_unbind_ok, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDeviceListActivity.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ThirdAccountDeviceListActivity thirdAccountDeviceListActivity = ThirdAccountDeviceListActivity.this;
                thirdAccountDeviceListActivity.mProcessDialog = new XQProgressDialog(thirdAccountDeviceListActivity);
                ThirdAccountDeviceListActivity.this.mProcessDialog.setCancelable(true);
                ThirdAccountDeviceListActivity.this.mProcessDialog.setMessage(ThirdAccountDeviceListActivity.this.getResources().getString(R.string.loading_share_info));
                ThirdAccountDeviceListActivity.this.mProcessDialog.show();
                ThirdAccountDeviceListActivity.this.mProcessDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDeviceListActivity.AnonymousClass7.AnonymousClass1 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                    }
                });
                fal instance = fal.getInstance();
                fru.O000000o().O00000oO(ThirdAccountDeviceListActivity.this.mThirdAccount == null ? "" : ThirdAccountDeviceListActivity.this.mThirdAccount.O00000Oo, new fsm<JSONObject, fso>(new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDeviceListActivity.AnonymousClass7.AnonymousClass2 */

                    public final void onFailure(fso fso) {
                        if (ThirdAccountDeviceListActivity.this.isValid()) {
                            if (ThirdAccountDeviceListActivity.this.mProcessDialog != null) {
                                ThirdAccountDeviceListActivity.this.mProcessDialog.dismiss();
                            }
                            gqg.O00000Oo((int) R.string.third_account_unbind_failed);
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (ThirdAccountDeviceListActivity.this.isValid()) {
                            if (ThirdAccountDeviceListActivity.this.mProcessDialog != null) {
                                ThirdAccountDeviceListActivity.this.mProcessDialog.dismiss();
                            }
                            gqg.O00000Oo((int) R.string.third_account_unbind_success);
                            int size = (ThirdAccountDeviceListActivity.this.mThirdAccount == null || ThirdAccountDeviceListActivity.this.mThirdAccount.O00000oO == null) ? 0 : ThirdAccountDeviceListActivity.this.mThirdAccount.O00000oO.size();
                            StringBuilder sb = new StringBuilder();
                            for (int i = 0; i < size; i++) {
                                sb.append(ThirdAccountDeviceListActivity.this.mThirdAccount.O00000oO.get(i).did);
                                sb.append(";");
                            }
                            hxi.O0000Oo.f960O000000o.O000000o("ctoc_relieve_success", "num", Integer.valueOf(size), "did", sb.toString());
                            ThirdAccountDeviceListActivity.this.finish();
                        }
                    }
                }) {
                    /* class _m_j.fal.AnonymousClass4 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ fsm f16020O000000o;

                    {
                        this.f16020O000000o = r2;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (fal.f16012O000000o == null) {
                            return;
                        }
                        if (jSONObject == null) {
                            fsm fsm = this.f16020O000000o;
                            if (fsm != null) {
                                fsm.onFailure(new fso(Integer.MIN_VALUE, "result is null"));
                                return;
                            }
                            return;
                        }
                        int optInt = jSONObject.optInt("code");
                        if (optInt != 0) {
                            fsm fsm2 = this.f16020O000000o;
                            if (fsm2 != null) {
                                fsm2.onFailure(new fso(optInt, jSONObject.optString("message", "")));
                                return;
                            }
                            return;
                        }
                        fsm fsm3 = this.f16020O000000o;
                        if (fsm3 != null) {
                            fsm3.onSuccess(null);
                        }
                    }

                    public final void onFailure(fso fso) {
                        fsm fsm;
                        if (fal.f16012O000000o != null && (fsm = this.f16020O000000o) != null) {
                            fsm.onFailure(fso);
                        }
                    }
                });
            }
        }).O00000o().show();
    }

    class O000000o extends RecyclerView.O000000o<C0033O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        List<Device> f4308O000000o;
        public View O00000Oo;

        private O000000o() {
            this.f4308O000000o = new ArrayList();
        }

        /* synthetic */ O000000o(ThirdAccountDeviceListActivity thirdAccountDeviceListActivity, byte b) {
            this();
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            C0033O000000o o000000o = (C0033O000000o) o000OOo0;
            if (getItemViewType(i) != 0) {
                int layoutPosition = o000000o.getLayoutPosition();
                if (this.O00000Oo != null) {
                    layoutPosition--;
                }
                Device device = this.f4308O000000o.get(layoutPosition);
                o000000o.O00000Oo.setText(device.name);
                String str = "";
                if (device.propInfo != null) {
                    str = device.propInfo.optString("third_cloud_device_icon", str);
                }
                fal.O000000o(o000000o.f4309O000000o, str);
            }
        }

        public final int getItemViewType(int i) {
            return (i != 0 || this.O00000Oo == null) ? 1 : 0;
        }

        public final int getItemCount() {
            return this.O00000Oo == null ? this.f4308O000000o.size() : this.f4308O000000o.size() + 1;
        }

        /* renamed from: com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDeviceListActivity$O000000o$O000000o  reason: collision with other inner class name */
        public class C0033O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            public SimpleDraweeView f4309O000000o;
            public TextView O00000Oo;

            public C0033O000000o(View view) {
                super(view);
                if (view != O000000o.this.O00000Oo) {
                    this.f4309O000000o = (SimpleDraweeView) view.findViewById(R.id.icon);
                    this.O00000Oo = (TextView) view.findViewById(R.id.title);
                    view.findViewById(R.id.next_btn).setVisibility(8);
                }
            }
        }

        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = this.O00000Oo;
            if (view == null || i != 0) {
                return new C0033O000000o(LayoutInflater.from(ThirdAccountDeviceListActivity.this).inflate((int) R.layout.third_account_item_layout, (ViewGroup) null));
            }
            return new C0033O000000o(view);
        }
    }
}
