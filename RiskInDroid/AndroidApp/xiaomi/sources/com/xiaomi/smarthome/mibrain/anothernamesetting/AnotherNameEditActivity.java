package com.xiaomi.smarthome.mibrain.anothernamesetting;

import _m_j.fh;
import _m_j.fno;
import _m_j.fo;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gpc;
import _m_j.gvh;
import _m_j.gvi;
import _m_j.gzo;
import _m_j.hag;
import _m_j.hah;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.multikey.PowerMultikeyBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

public class AnotherNameEditActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    hah.O000000o f9470O000000o = new hah.O000000o() {
        /* class com.xiaomi.smarthome.mibrain.anothernamesetting.AnotherNameEditActivity.AnonymousClass1 */

        public final String O00000Oo(String str) {
            return null;
        }

        public final void O000000o(String str) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(AnotherNameEditActivity.this.mValueKey)) {
                AnotherNameEditActivity.this.showProgressDialog();
                gvh gvh = AnotherNameEditActivity.this.mViewModel;
                String str2 = AnotherNameEditActivity.this.mDevice.did;
                String str3 = AnotherNameEditActivity.this.mValueKey;
                ArrayList<PowerMultikeyBean> arrayList = AnotherNameEditActivity.this.mMultikeyBeanList;
                ArrayList arrayList2 = new ArrayList();
                if (gvh.f18385O000000o.getValue() != null) {
                    arrayList2.addAll((Collection) gvh.f18385O000000o.getValue());
                }
                arrayList2.add(str);
                gvi.O000000o().O000000o(str2, arrayList2, new fsm<JSONObject, fso>(arrayList2) {
                    /* class _m_j.gvh.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ List f18371O000000o;

                    {
                        this.f18371O000000o = r2;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject == null || jSONObject.optInt("code") != 0) {
                            gvh.this.f18385O000000o.postValue(gvh.this.f18385O000000o.getValue());
                        } else {
                            gvh.this.f18385O000000o.postValue(this.f18371O000000o);
                        }
                    }

                    public final void onFailure(fso fso) {
                        gvh.this.f18385O000000o.postValue(gvh.this.f18385O000000o.getValue());
                    }
                }, str3, arrayList);
            }
        }
    };
    private Boolean O00000Oo;
    private AliasAdapter O00000o;
    private XQProgressDialog O00000o0;
    private PowerMultikeyBean O00000oO;
    private String O00000oo;
    private Unbinder O0000O0o;
    private View O0000OOo;
    public List<String> list = new ArrayList();
    @BindView(5053)
    TextView mDelete;
    @BindView(5055)
    ViewGroup mDeleteGroup;
    public Device mDevice;
    @BindView(5073)
    SimpleDraweeView mDeviceIcon;
    @BindView(5082)
    TextView mDeviceName;
    public boolean mEditMode = false;
    @BindView(5198)
    LinearLayout mGuide;
    @BindView(5199)
    ImageView mGuideCancel;
    @BindView(5316)
    ListView mListView;
    @BindView(5900)
    TextView mMultiBtnName;
    @BindView(5349)
    View mMultiGroup;
    public ArrayList<PowerMultikeyBean> mMultikeyBeanList;
    @BindView(5407)
    ImageView mReturn;
    public List<String> mSelectedList = new ArrayList();
    @BindView(5411)
    TextView mTitle;
    @BindView(5416)
    ImageView mTitleRightIcon;
    @BindView(5899)
    TextView mTvMultiBtnKey;
    public String mValueKey = "common";
    public gvh mViewModel;

    class AliasAdapter extends BaseAdapter {
        private Context O00000Oo;

        public final long getItemId(int i) {
            return (long) i;
        }

        public class ViewHolder_ViewBinding implements Unbinder {

            /* renamed from: O000000o  reason: collision with root package name */
            private ViewHolder f9476O000000o;

            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.f9476O000000o = viewHolder;
                viewHolder.mNameTV = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alias, "field 'mNameTV'", TextView.class);
                viewHolder.mCheckBox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ckb_edit_selected, "field 'mCheckBox'", CheckBox.class);
            }

            public void unbind() {
                ViewHolder viewHolder = this.f9476O000000o;
                if (viewHolder != null) {
                    this.f9476O000000o = null;
                    viewHolder.mNameTV = null;
                    viewHolder.mCheckBox = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        public AliasAdapter(Context context) {
            this.O00000Oo = context;
        }

        public final int getCount() {
            return AnotherNameEditActivity.this.list.size();
        }

        public final Object getItem(int i) {
            return AnotherNameEditActivity.this.list.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.widget.ListView, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            int i2 = 0;
            if (view == null) {
                view = LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.voice_another_name_list_item, (ViewGroup) AnotherNameEditActivity.this.mListView, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            CheckBox checkBox = viewHolder.mCheckBox;
            if (!AnotherNameEditActivity.this.mEditMode) {
                i2 = 8;
            }
            checkBox.setVisibility(i2);
            viewHolder.mNameTV.setText(AnotherNameEditActivity.this.list.get(i));
            CheckBox checkBox2 = viewHolder.mCheckBox;
            List<String> list = AnotherNameEditActivity.this.mSelectedList;
            checkBox2.setChecked(list.contains(i + "_" + AnotherNameEditActivity.this.list.get(i)));
            return view;
        }

        class ViewHolder {
            @BindView(4999)
            CheckBox mCheckBox;
            @BindView(5870)
            TextView mNameTV;

            public ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_another_name_edit);
        this.O0000O0o = ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("key_alias_did");
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        this.mDevice = fno.O000000o().O000000o(stringExtra);
        if (this.mDevice == null) {
            finish();
            return;
        }
        this.O00000Oo = Boolean.valueOf(intent.getBooleanExtra("key_multi_btn", false));
        if (this.O00000Oo.booleanValue()) {
            int intExtra = intent.getIntExtra("key_multi_btn_name_position", -1);
            this.mMultikeyBeanList = intent.getParcelableArrayListExtra("key_multi_btn_name_bean_list");
            ArrayList<PowerMultikeyBean> arrayList = this.mMultikeyBeanList;
            if (arrayList == null || intExtra == -1) {
                finish();
                return;
            }
            this.O00000oo = gzo.O000000o(arrayList, intExtra);
            if (intExtra < this.mMultikeyBeanList.size()) {
                this.O00000oO = this.mMultikeyBeanList.get(intExtra);
            }
            if (this.O00000oO == null || TextUtils.isEmpty(this.O00000oo)) {
                finish();
                return;
            }
            this.mValueKey = this.O00000oO.O00000oo;
        }
        if (TextUtils.isEmpty(this.mValueKey)) {
            finish();
            return;
        }
        this.mGuideCancel.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameEditActivity$z54Vkf4mBIzAkOJ9l2jiw2H1riU */

            public final void onClick(View view) {
                AnotherNameEditActivity.this.O00000oo(view);
            }
        });
        this.mDeviceName.setText(this.mDevice.getName());
        DeviceFactory.O00000Oo(this.mDevice.model, this.mDeviceIcon);
        if (this.O00000Oo.booleanValue()) {
            this.mMultiGroup.setVisibility(0);
            this.mTvMultiBtnKey.setText(this.O00000oo);
            if (TextUtils.isEmpty(this.O00000oO.O00000o)) {
                this.mMultiBtnName.setText((int) R.string.unset);
            } else {
                this.mMultiBtnName.setText(this.O00000oO.O00000o);
            }
        }
        this.mDeleteGroup.setVisibility(8);
        this.mDelete.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameEditActivity$Fx738SVgqZNFqNSBfuqq8KNfx78 */

            public final void onClick(View view) {
                AnotherNameEditActivity.this.O00000oO(view);
            }
        });
        this.mTitle.setText((int) R.string.voice_another_name_setting);
        this.mReturn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameEditActivity$vfl4lKMPRBCNyY60zcfVGiupDKU */

            public final void onClick(View view) {
                AnotherNameEditActivity.this.O00000Oo(view);
            }
        });
        this.mTitleRightIcon.setImageResource(R.drawable.mihome_help_icon);
        this.mTitleRightIcon.setVisibility(0);
        this.mTitleRightIcon.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameEditActivity$pqwSAYKBYrk4PguGRf670gXpgKg */

            public final void onClick(View view) {
                AnotherNameEditActivity.this.O000000o(view);
            }
        });
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.voice_another_name_list_header, (ViewGroup) this.mListView, false);
        this.O0000OOo = inflate.findViewById(R.id.edit);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameEditActivity$410geJawuMpzoQ2Ol5M5IkV0hA */

            public final void onClick(View view) {
                AnotherNameEditActivity.this.O00000o(view);
            }
        });
        this.mListView.addHeaderView(inflate);
        View inflate2 = LayoutInflater.from(getApplicationContext()).inflate((int) R.layout.voice_another_name_list_footer, (ViewGroup) this.mListView, false);
        inflate2.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameEditActivity$ZMVa_wJ53REOV3fQ3AjQiQB0jCE */

            public final void onClick(View view) {
                AnotherNameEditActivity.this.O00000o0(view);
            }
        });
        this.mListView.addFooterView(inflate2);
        this.O00000o = new AliasAdapter(this);
        this.mListView.setAdapter((ListAdapter) this.O00000o);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameEditActivity$blHtClD00QfjfPvU6ZFXUyMcJ0 */

            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                AnotherNameEditActivity.this.O000000o(adapterView, view, i, j);
            }
        });
        this.mViewModel = (gvh) fo.O000000o(this).O000000o(gvh.class);
        this.mViewModel.f18385O000000o.observe(this, new fh() {
            /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameEditActivity$86cDAdDczogO1wpu_delsMYL0YQ */

            public final void onChanged(Object obj) {
                AnotherNameEditActivity.this.O000000o((List) obj);
            }
        });
        showProgressDialog();
        gvh gvh = this.mViewModel;
        String str = this.mDevice.did;
        String str2 = this.mValueKey;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            gvh.f18385O000000o.postValue(new ArrayList());
        } else {
            gvi.O000000o().O000000o(str, new fsm<List<String>, fso>() {
                /* class _m_j.gvh.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    gvh.this.f18385O000000o.postValue((List) obj);
                }

                public final void onFailure(fso fso) {
                    gvh.this.f18385O000000o.postValue(new ArrayList());
                }
            }, true, str2);
        }
    }

    public void onBackPressed() {
        if (this.mGuide.getVisibility() == 0) {
            this.mGuide.setVisibility(8);
        } else if (this.mEditMode) {
            O000000o();
        } else {
            super.onBackPressed();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        dismissProgressDialog();
        Unbinder unbinder = this.O0000O0o;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oo(View view) {
        this.mGuide.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oO(View view) {
        if (this.mSelectedList.size() > 0 && !TextUtils.isEmpty(this.mValueKey)) {
            TextView textView = this.mDelete;
            final $$Lambda$AnotherNameEditActivity$o9C2DgLM8aD8KTB6kdy3KIUfI r0 = new Runnable() {
                /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameEditActivity$o9C2DgLM8aD8KTB6kdy3KIUfI */

                public final void run() {
                    AnotherNameEditActivity.this.O00000Oo();
                }
            };
            hag hag = new hag(1.1f);
            hag.setDuration(100);
            hag.setInterpolator(new LinearInterpolator());
            hag.setAnimationListener(new Animation.AnimationListener() {
                /* class com.xiaomi.smarthome.mibrain.anothernamesetting.AnotherNameEditActivity.AnonymousClass3 */

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    r0.run();
                }
            });
            textView.startAnimation(hag);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(AdapterView adapterView, View view, int i, long j) {
        String str = (String) adapterView.getAdapter().getItem(i);
        if (!TextUtils.isEmpty(str) && this.mEditMode) {
            AliasAdapter.ViewHolder viewHolder = (AliasAdapter.ViewHolder) view.getTag();
            viewHolder.mCheckBox.toggle();
            if (viewHolder.mCheckBox.isChecked()) {
                List<String> list2 = this.mSelectedList;
                list2.add((i - this.mListView.getHeaderViewsCount()) + "_" + str);
                return;
            }
            List<String> list3 = this.mSelectedList;
            list3.remove((i - this.mListView.getHeaderViewsCount()) + "_" + str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(List list2) {
        this.list.clear();
        this.list.addAll(list2);
        if (this.list.size() > 0) {
            this.O0000OOo.setEnabled(true);
        } else {
            this.O0000OOo.setEnabled(false);
        }
        this.O00000o.notifyDataSetChanged();
        dismissProgressDialog();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpc.O000000o(android.app.Activity, float):int
     arg types: [com.xiaomi.smarthome.mibrain.anothernamesetting.AnotherNameEditActivity, int]
     candidates:
      _m_j.gpc.O000000o(android.content.Context, float):int
      _m_j.gpc.O000000o(android.view.View, int):void
      _m_j.gpc.O000000o(android.app.Activity, float):int */
    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        if (this.mEditMode) {
            O000000o();
            return;
        }
        this.mEditMode = true;
        this.mDeleteGroup.setVisibility(0);
        ObjectAnimator.ofFloat(this.mDeleteGroup, "translationY", (float) gpc.O000000o((Activity) this, 67.0f), 0.0f).start();
        this.O00000o.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        if (this.list.size() >= 3) {
            new MLAlertDialog.Builder(this).O00000Oo(getResources().getQuantityString(R.plurals.voice_another_name_max, 3, 3)).O00000Oo((int) R.string.mj_i_know, (DialogInterface.OnClickListener) null).O00000Oo(true).O000000o(getResources().getColor(R.color.mj_color_black_70_transparent), -2).O00000oo();
            return;
        }
        hah.O000000o(this, "", getString(R.string.voice_another_name_add), getString(R.string.voice_another_name_add_hint), this.f9470O000000o);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        finish();
    }

    public void showProgressDialog() {
        dismissProgressDialog();
        this.O00000o0 = XQProgressDialog.O000000o(this, null, getString(R.string.mj_loading));
    }

    public void dismissProgressDialog() {
        XQProgressDialog xQProgressDialog = this.O00000o0;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O00000o0.dismiss();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpc.O000000o(android.app.Activity, float):int
     arg types: [com.xiaomi.smarthome.mibrain.anothernamesetting.AnotherNameEditActivity, int]
     candidates:
      _m_j.gpc.O000000o(android.content.Context, float):int
      _m_j.gpc.O000000o(android.view.View, int):void
      _m_j.gpc.O000000o(android.app.Activity, float):int */
    private void O000000o() {
        this.mEditMode = false;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mDeleteGroup, "translationY", 0.0f, (float) gpc.O000000o((Activity) this, 67.0f));
        ofFloat.addListener(new AnimatorListenerAdapter() {
            /* class com.xiaomi.smarthome.mibrain.anothernamesetting.AnotherNameEditActivity.AnonymousClass2 */

            public final void onAnimationEnd(Animator animator) {
                AnotherNameEditActivity.this.mDeleteGroup.setVisibility(8);
            }
        });
        ofFloat.start();
        this.O00000o.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public void O00000Oo() {
        showProgressDialog();
        gvh gvh = this.mViewModel;
        String str = this.mDevice.did;
        List<String> list2 = this.mSelectedList;
        String str2 = this.mValueKey;
        ArrayList<PowerMultikeyBean> arrayList = this.mMultikeyBeanList;
        ArrayList arrayList2 = new ArrayList();
        if (gvh.f18385O000000o.getValue() != null) {
            arrayList2.addAll((Collection) gvh.f18385O000000o.getValue());
        }
        for (int size = list2.size() - 1; size >= 0; size--) {
            int parseInt = Integer.parseInt(list2.get(size).substring(0, list2.get(size).indexOf("_")));
            if (parseInt >= 0 && parseInt < arrayList2.size()) {
                arrayList2.remove(parseInt);
            }
        }
        gvi.O000000o().O000000o(str, arrayList2, new fsm<JSONObject, fso>(list2, arrayList2) {
            /* class _m_j.gvh.AnonymousClass3 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ List f18372O000000o;
            final /* synthetic */ List O00000Oo;

            {
                this.f18372O000000o = r2;
                this.O00000Oo = r3;
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject == null || jSONObject.optInt("code") != 0) {
                    gvh.this.f18385O000000o.postValue(gvh.this.f18385O000000o.getValue());
                    return;
                }
                this.f18372O000000o.clear();
                gvh.this.f18385O000000o.postValue(this.O00000Oo);
            }

            public final void onFailure(fso fso) {
                gvh.this.f18385O000000o.postValue(gvh.this.f18385O000000o.getValue());
            }
        }, str2, arrayList);
        O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        if (isValid()) {
            this.mGuide.setVisibility(0);
        }
    }
}
