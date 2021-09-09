package com.xiaomi.smarthome.mibrain.anothernamesetting;

import _m_j.fh;
import _m_j.fno;
import _m_j.fo;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.grk;
import _m_j.grl;
import _m_j.gvg;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.sectionedrecyclerviewadapter.Section;
import com.xiaomi.smarthome.mibrain.anothernamesetting.AnotherNameDevListActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnotherNameDevListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private grl f9465O000000o;
    private XQProgressDialog O00000Oo;
    private Unbinder O00000o0;
    @BindView(5117)
    TextView mEmpty;
    @BindView(5198)
    LinearLayout mGuide;
    @BindView(5199)
    ImageView mGuideCancel;
    @BindView(5240)
    TextView mIntroduction;
    @BindView(5593)
    RecyclerView mRecyclerView;
    @BindView(5407)
    ImageView mReturn;
    @BindView(5411)
    TextView mTitle;
    @BindView(5416)
    ImageView mTitleRightIcon;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_another_name_dev_list);
        this.O00000o0 = ButterKnife.bind(this);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f9465O000000o = new grl();
        this.mRecyclerView.setAdapter(this.f9465O000000o);
        this.mGuideCancel.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameDevListActivity$gRa0DVpx1Ymdty8SbZcGzK5Mmic */

            public final void onClick(View view) {
                AnotherNameDevListActivity.this.O00000o0(view);
            }
        });
        this.mTitle.setText((int) R.string.voice_another_name_setting);
        this.mReturn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameDevListActivity$uz_BMoeSdQNDeK_NKP45SkA5tvQ */

            public final void onClick(View view) {
                AnotherNameDevListActivity.this.O00000Oo(view);
            }
        });
        this.mTitleRightIcon.setImageResource(R.drawable.title_right_info_drawable);
        this.mTitleRightIcon.setVisibility(0);
        this.mTitleRightIcon.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameDevListActivity$MivK7jCRgA0aYfFZNGsihx8M1nE */

            public final void onClick(View view) {
                AnotherNameDevListActivity.this.O000000o(view);
            }
        });
        ((gvg) fo.O000000o(this).O000000o(gvg.class)).f18385O000000o.observe(this, new fh() {
            /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameDevListActivity$obcgCpVDQabPzHoZJsUVOCjY6o */

            public final void onChanged(Object obj) {
                AnotherNameDevListActivity.this.O000000o((List) obj);
            }
        });
        dismissProgressDialog();
        this.O00000Oo = XQProgressDialog.O000000o(this, null, getString(R.string.mj_loading));
        DeviceApi.getInstance().getSupportAliasModel(new fsm<JSONObject, fso>(new fsm<List<String>, fso>() {
            /* class _m_j.gvg.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ void onCache(Object obj) {
                super.onCache((List) obj);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                gvg gvg = gvg.this;
                List<Home> list2 = ggb.O00000Oo().O0000OoO.O00000Oo;
                ArrayList arrayList = new ArrayList();
                for (Home next : list2) {
                    if (next.isOwner()) {
                        List<String> O000000o2 = ggb.O00000Oo().O000000o(next.getId(), new boolean[0]);
                        if (!O000000o2.isEmpty()) {
                            ArrayList arrayList2 = new ArrayList();
                            for (String next2 : O000000o2) {
                                Device O000000o3 = fno.O000000o().O000000o(next2);
                                if (O000000o3 != null && list.contains(O000000o3.model)) {
                                    arrayList2.add(next2);
                                }
                            }
                            if (!arrayList2.isEmpty()) {
                                ggb.O00000Oo();
                                arrayList.add(new O000000o(ggb.O000000o(next), next.getId(), arrayList2));
                            }
                        }
                    }
                }
                gvg.this.f18385O000000o.postValue(arrayList);
            }

            public final void onFailure(fso fso) {
                gvg.this.f18385O000000o.postValue(new ArrayList());
            }
        }) {
            /* class _m_j.gvi.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ fsm f18375O000000o;

            {
                this.f18375O000000o = r2;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
                if (r6.get("result") == null) goto L_0x000d;
             */
            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    try {
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (this.f18375O000000o != null) {
                    this.f18375O000000o.onFailure(new fso(-1, "response is null or result is null"));
                    return;
                }
                return;
                JSONArray optJSONArray = jSONObject.optJSONArray("result");
                if (optJSONArray == null) {
                    fsm fsm = this.f18375O000000o;
                    if (fsm != null) {
                        fsm.onFailure(new fso(-1, "result cannot cast to JSONArray"));
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optJSONObject(i).optString("model");
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
                gvi.this.f18373O000000o.addAll(arrayList);
                fsm fsm2 = this.f18375O000000o;
                if (fsm2 != null) {
                    fsm2.onSuccess(arrayList);
                }
            }

            public final void onFailure(fso fso) {
                fsm fsm = this.f18375O000000o;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }
        });
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("show_guide", false)) {
            O000000o();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        dismissProgressDialog();
        Unbinder unbinder = this.O00000o0;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        this.mGuide.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        O000000o();
    }

    public void dismissProgressDialog() {
        XQProgressDialog xQProgressDialog = this.O00000Oo;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O00000Oo.dismiss();
        }
    }

    private void O000000o() {
        if (isValid()) {
            this.mGuide.setVisibility(0);
        }
    }

    public void onBackPressed() {
        if (this.mGuide.getVisibility() == 0) {
            this.mGuide.setVisibility(8);
        } else {
            super.onBackPressed();
        }
    }

    class O000000o extends Section {
        private Home O00000Oo;
        private List<String> O00000o0;

        public O000000o(Home home, List<String> list) {
            super(new grk.O000000o(R.layout.another_name_item_section).O000000o(R.layout.another_name_item_section_header).O000000o());
            this.O00000o0 = list;
            this.O00000Oo = home;
        }

        public final int O000000o() {
            return this.O00000o0.size();
        }

        public final RecyclerView.O000OOo0 O000000o(View view) {
            return new O00000Oo(view);
        }

        public final RecyclerView.O000OOo0 O00000Oo(View view) {
            return new C0080O000000o(view);
        }

        public final void O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
            if (i >= 0) {
                String str = this.O00000o0.get(i);
                C0080O000000o o000000o = (C0080O000000o) o000OOo0;
                o000000o.O00000Oo.setText(ggb.O00000Oo().O0000o0O(str));
                Device O000000o2 = fno.O000000o().O000000o(str);
                if (O000000o2 == null) {
                    o000000o.f9467O000000o.setText((int) R.string.tag_no_device);
                    return;
                }
                o000000o.f9467O000000o.setText(O000000o2.getName());
                DeviceFactory.O00000Oo(O000000o2.model, o000000o.O00000o0);
                o000000o.itemView.setOnClickListener(new View.OnClickListener(O000000o2, str) {
                    /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameDevListActivity$O000000o$U7fhX41EYoWzBA7CGkYSctDwq9g */
                    private final /* synthetic */ Device f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        AnotherNameDevListActivity.O000000o.this.O000000o(this.f$1, this.f$2, view);
                    }
                });
                if (i == this.O00000o0.size() - 1) {
                    o000000o.O00000o.setBackgroundResource(R.drawable.bottom_radius_rectangle_bg);
                    o000000o.O00000oO.setVisibility(8);
                    return;
                }
                o000000o.O00000o.setBackgroundResource(R.color.mj_color_dialog_bg_nor);
                o000000o.O00000oO.setVisibility(0);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(Device device, String str, View view) {
            if (CoreApi.O000000o().O00000oO(device.model).O0000oOo <= 1) {
                Intent intent = new Intent(AnotherNameDevListActivity.this, AnotherNameEditActivity.class);
                intent.putExtra("key_alias_did", str);
                AnotherNameDevListActivity.this.startActivity(intent);
                return;
            }
            AnotherNameMultiKeyActivity.startActivity(AnotherNameDevListActivity.this, device.did, device.mac);
        }

        public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
            TextView textView = ((O00000Oo) o000OOo0).f9468O000000o;
            ggb.O00000Oo();
            textView.setText(ggb.O000000o(this.O00000Oo));
        }

        class O00000Oo extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f9468O000000o;

            public O00000Oo(View view) {
                super(view);
                this.f9468O000000o = (TextView) view.findViewById(R.id.name_tv);
            }
        }

        /* renamed from: com.xiaomi.smarthome.mibrain.anothernamesetting.AnotherNameDevListActivity$O000000o$O000000o  reason: collision with other inner class name */
        class C0080O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f9467O000000o;
            TextView O00000Oo;
            View O00000o;
            SimpleDraweeView O00000o0;
            View O00000oO;

            public C0080O000000o(View view) {
                super(view);
                this.O00000o = view;
                this.f9467O000000o = (TextView) view.findViewById(R.id.device_name_tv);
                this.O00000Oo = (TextView) view.findViewById(R.id.room_name_tv);
                this.O00000o0 = (SimpleDraweeView) view.findViewById(R.id.icon);
                this.O00000oO = view.findViewById(R.id.divider);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(List list) {
        if (list != null) {
            this.f9465O000000o.f18182O000000o.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                gvg.O000000o o000000o = (gvg.O000000o) it.next();
                Home O00000o = ggb.O00000Oo().O00000o(o000000o.O00000Oo);
                if (O00000o != null) {
                    this.f9465O000000o.O000000o(new O000000o(O00000o, o000000o.O00000o0));
                }
            }
            if (this.f9465O000000o.getItemCount() == 0) {
                this.mEmpty.setVisibility(0);
                this.mRecyclerView.setVisibility(8);
            } else {
                this.mEmpty.setVisibility(8);
                this.mRecyclerView.setVisibility(0);
                this.f9465O000000o.notifyDataSetChanged();
            }
        }
        dismissProgressDialog();
    }
}
