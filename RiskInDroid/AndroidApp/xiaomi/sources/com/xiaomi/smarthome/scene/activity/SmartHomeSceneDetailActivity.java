package com.xiaomi.smarthome.scene.activity;

import _m_j.gqg;
import _m_j.gsy;
import _m_j.hnm;
import _m_j.hnq;
import _m_j.hos;
import _m_j.hox;
import _m_j.hpq;
import _m_j.izb;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SmartHomeSceneDetailActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f10964O000000o;
    private int O00000Oo;
    public hnm mAction;
    @BindView(5822)
    ImageView mBackBtn;
    public hos mCondition;
    @BindView(5291)
    ListView mContentList;
    public HashMap<Integer, String> mDisableMaps = new HashMap<>();
    public int mSGroupId = -1;
    public int mSId = -1;
    public String mSelectedDid;
    public boolean mShowGroupInfo = true;
    @BindView(5826)
    TextView mTitle;
    public List<Integer> mUnSelectIds = new ArrayList();
    public List<String> mUnSelectName = new ArrayList();

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.smarthome_scene_detail);
        ButterKnife.bind(this);
        this.mBackBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneDetailActivity.AnonymousClass1 */

            public final void onClick(View view) {
                SmartHomeSceneDetailActivity.this.finish();
            }
        });
        this.mCondition = hpq.O000000o().O00000o0;
        this.mAction = hpq.O000000o().O00000o;
        String stringExtra = getIntent().getStringExtra("extra_title");
        this.mSId = getIntent().getIntExtra("extra_selected_title", -1);
        if (this.mSId == -1) {
            this.mSelectedDid = getIntent().getStringExtra("extra_selected_did");
        }
        this.O00000Oo = getIntent().getIntExtra("extra_group_id", -1);
        this.mShowGroupInfo = getIntent().getBooleanExtra("show_group_info", true);
        this.mTitle.setText(stringExtra);
        this.f10964O000000o = new O000000o();
        int i = 0;
        this.mContentList.addHeaderView(LayoutInflater.from(this).inflate((int) R.layout.common_list_space_empty, (ViewGroup) this.mContentList, false));
        this.mContentList.setAdapter((ListAdapter) this.f10964O000000o);
        hos hos = this.mCondition;
        if (hos != null) {
            if (!(hos instanceof hox) || ((hox) hos).O0000O0o == null) {
                this.mShowGroupInfo = false;
            }
            if (this.mShowGroupInfo) {
                ArrayList arrayList = new ArrayList();
                for (int valueOf : ((hox) this.mCondition).O0000O0o) {
                    arrayList.add(Integer.valueOf(valueOf));
                }
                ArrayList arrayList2 = new ArrayList();
                if (this.mSId != -1) {
                    int[] O00000oO = this.mCondition.O00000oO();
                    int length = O00000oO.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        Integer valueOf2 = Integer.valueOf(O00000oO[i2]);
                        if (valueOf2.intValue() == this.mSId) {
                            this.mSGroupId = ((hox) this.mCondition).O0000OOo[valueOf2.intValue()];
                            break;
                        }
                        i2++;
                    }
                }
                generateDisplayIds(arrayList2, arrayList);
            } else {
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                if (this.O00000Oo == -1) {
                    int i3 = 0;
                    while (true) {
                        hos hos2 = this.mCondition;
                        if (i3 >= ((hos2 == null || hos2.O00000oO() == null) ? 0 : this.mCondition.O00000oO().length)) {
                            break;
                        }
                        arrayList3.add(Integer.valueOf(this.mCondition.O00000oO()[i3]));
                        i3++;
                    }
                } else {
                    for (int i4 = 0; i4 < ((hox) this.mCondition).O00000oO().length; i4++) {
                        if (this.O00000Oo == ((hox) this.mCondition).O0000OOo[i4]) {
                            arrayList3.add(Integer.valueOf(this.mCondition.O00000oO()[i4]));
                        }
                    }
                }
                for (int i5 = 0; i5 < arrayList3.size(); i5++) {
                    if (hpq.O000000o().O00000Oo != null && hpq.O000000o().O00000Oo.O0000Ooo == 0 && !hpq.O000000o().O000000o(Integer.valueOf(this.mCondition.O00000o0(((Integer) arrayList3.get(i5)).intValue())))) {
                        arrayList4.add(arrayList3.get(i5));
                    }
                }
                generateDisplayIds(arrayList4, arrayList3);
            }
        }
        hnm hnm = this.mAction;
        if (hnm != null) {
            if (!(hnm instanceof hnq) || ((hnq) hnm).O0000OOo == null) {
                this.mShowGroupInfo = false;
            }
            if (this.mShowGroupInfo) {
                ArrayList arrayList5 = new ArrayList();
                for (int valueOf3 : ((hnq) this.mAction).O0000OOo) {
                    arrayList5.add(Integer.valueOf(valueOf3));
                }
                ArrayList arrayList6 = new ArrayList();
                if (this.mSId != -1) {
                    int[] iArr = this.mAction.O00000Oo;
                    int length2 = iArr.length;
                    while (true) {
                        if (i >= length2) {
                            break;
                        }
                        Integer valueOf4 = Integer.valueOf(iArr[i]);
                        if (valueOf4.intValue() == this.mSId) {
                            this.mSGroupId = ((hnq) this.mAction).O0000Oo0[valueOf4.intValue()];
                            break;
                        }
                        i++;
                    }
                }
                generateDisplayIds(arrayList6, arrayList5);
                return;
            }
            ArrayList arrayList7 = new ArrayList();
            ArrayList arrayList8 = new ArrayList();
            arrayList8.addAll(this.mAction.O00000Oo());
            if (this.O00000Oo != -1) {
                for (int i6 = 0; i6 < ((hnq) this.mAction).O00000Oo.length; i6++) {
                    if (this.O00000Oo == ((hnq) this.mAction).O0000Oo0[i6]) {
                        arrayList7.add(Integer.valueOf(this.mAction.O00000Oo[i6]));
                    }
                }
            } else {
                for (int valueOf5 : this.mAction.O00000Oo) {
                    arrayList7.add(Integer.valueOf(valueOf5));
                }
            }
            while (i < arrayList7.size()) {
                if (!hpq.O000000o().O00000Oo(Integer.valueOf(this.mAction.O000000o(((Integer) arrayList7.get(i)).intValue())))) {
                    arrayList8.add(arrayList7.get(i));
                }
                i++;
            }
            generateDisplayIds(arrayList8, arrayList7);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int intExtra;
        if (this.mShowGroupInfo && i2 == -1 && (intExtra = intent.getIntExtra("extra_index", -1)) != -1) {
            Intent intent2 = new Intent();
            intent2.putExtra("extra_index", intExtra);
            setResult(-1, intent2);
            finish();
            hpq.O000000o().O00000o0();
        }
    }

    class O000000o extends BaseAdapter {
        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        O000000o() {
        }

        public final int getCount() {
            return SmartHomeSceneDetailActivity.this.mUnSelectIds.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x016f  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x017f  */
        public final View getView(final int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(SmartHomeSceneDetailActivity.this).inflate((int) R.layout.smarthome_action_item, viewGroup, false);
            }
            View findViewById = view.findViewById(R.id.is_selected);
            if ((!SmartHomeSceneDetailActivity.this.mShowGroupInfo || SmartHomeSceneDetailActivity.this.mUnSelectIds.get(i).intValue() != SmartHomeSceneDetailActivity.this.mSGroupId) && (SmartHomeSceneDetailActivity.this.mShowGroupInfo || SmartHomeSceneDetailActivity.this.mUnSelectIds.get(i).intValue() != SmartHomeSceneDetailActivity.this.mSId)) {
                view.findViewById(R.id.description_text).setSelected(false);
                if (SmartHomeSceneDetailActivity.this.mCondition instanceof hox) {
                    hox hox = (hox) SmartHomeSceneDetailActivity.this.mCondition;
                    if (hox.O00000o == null || hox.O00000o.O00000o.isEmpty() || i >= hox.O00000o.O00000o.size()) {
                        findViewById.setVisibility(8);
                    } else {
                        hpq O000000o2 = hpq.O000000o();
                        String str = SmartHomeSceneDetailActivity.this.mSelectedDid;
                        int i2 = hox.O00000o.O00000o.get(i).O00000Oo;
                        if ((i2 <= 0 || !O000000o2.O000000o(str) || O000000o2.O0000Ooo.get(str).isEmpty()) ? false : O000000o2.O0000Ooo.get(str).contains(Integer.valueOf(i2))) {
                            findViewById.setVisibility(0);
                        } else {
                            findViewById.setVisibility(8);
                        }
                    }
                } else if (SmartHomeSceneDetailActivity.this.mAction instanceof hnq) {
                    hnq hnq = (hnq) SmartHomeSceneDetailActivity.this.mAction;
                    if (hnq.O00000oO == null || hnq.O00000oO.O00000oO.isEmpty() || i >= hnq.O00000oO.O00000oO.size()) {
                        findViewById.setVisibility(8);
                    } else {
                        hpq O000000o3 = hpq.O000000o();
                        String str2 = SmartHomeSceneDetailActivity.this.mSelectedDid;
                        int i3 = hnq.O00000oO.O00000oO.get(i).O00000Oo;
                        if ((i3 <= 0 || !O000000o3.O00000Oo(str2) || O000000o3.O0000o00.get(str2).isEmpty()) ? false : O000000o3.O0000o00.get(str2).contains(Integer.valueOf(i3))) {
                            findViewById.setVisibility(0);
                        } else {
                            findViewById.setVisibility(8);
                        }
                    }
                }
                ((TextView) view.findViewById(R.id.description_text)).setText(SmartHomeSceneDetailActivity.this.mUnSelectName.get(i));
                if (!SmartHomeSceneDetailActivity.this.mDisableMaps.containsKey(SmartHomeSceneDetailActivity.this.mUnSelectIds.get(i))) {
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneDetailActivity.O000000o.AnonymousClass1 */

                        public final void onClick(View view) {
                            gqg.O00000Oo((int) R.string.scene_unclickable_toast_2);
                        }
                    });
                    view.findViewById(R.id.lock_item).setVisibility(0);
                } else {
                    view.findViewById(R.id.lock_item).setVisibility(8);
                    if (SmartHomeSceneDetailActivity.this.mShowGroupInfo) {
                        view.findViewById(R.id.expand_hint).setVisibility(0);
                    } else {
                        view.findViewById(R.id.expand_hint).setVisibility(8);
                    }
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneDetailActivity.O000000o.AnonymousClass2 */

                        public final void onClick(View view) {
                            Device device = SmartHomeSceneDetailActivity.this.getDevice();
                            if (device != null) {
                                PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(device.model);
                                if (CoreApi.O000000o().O00000oO(device.model) == null || DeviceConstant.isNewChuangmi(device.model)) {
                                    SmartHomeSceneDetailActivity.this.doOnNextStepScene(i);
                                } else if (O0000Oo == null) {
                                    SmartHomeSceneDetailActivity.this.downloadAndInstallPlugin(i, SmartHomeSceneDetailActivity.this, device.model);
                                } else {
                                    SmartHomeSceneDetailActivity.this.doOnNextStepScene(i);
                                }
                            } else {
                                gsy.O000000o(6, "Scene", "scene, this situation can not exec, if exec device may be null...");
                                SmartHomeSceneDetailActivity.this.doOnNextStepScene(i);
                            }
                        }
                    });
                }
                return view;
            }
            view.findViewById(R.id.description_text).setSelected(true);
            findViewById.setVisibility(8);
            ((TextView) view.findViewById(R.id.description_text)).setText(SmartHomeSceneDetailActivity.this.mUnSelectName.get(i));
            if (!SmartHomeSceneDetailActivity.this.mDisableMaps.containsKey(SmartHomeSceneDetailActivity.this.mUnSelectIds.get(i))) {
            }
            return view;
        }
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
    public void doOnNextStepScene(int i) {
        if (this.mShowGroupInfo) {
            Intent intent = new Intent();
            intent.setClass(this, SmartHomeSceneDetailActivity.class);
            int i2 = this.mSId;
            if (i2 != -1) {
                intent.putExtra("extra_selected_title", i2);
            }
            intent.putExtra("extra_title", this.mUnSelectName.get(i));
            intent.putExtra("extra_group_id", this.mUnSelectIds.get(i));
            intent.putExtra("show_group_info", false);
            startActivityForResult(intent, 101);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("extra_index", this.mUnSelectIds.get(i));
        setResult(-1, intent2);
        finish();
        hpq.O000000o().O00000o0();
    }

    public void downloadAndInstallPlugin(int i, Context context, String str) {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        StringBuilder sb = new StringBuilder();
        sb.append(context.getString(R.string.plugin_downloading));
        sb.append(O00000oO == null ? "" : O00000oO.O0000Oo0());
        sb.append(context.getString(R.string.plugin));
        final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(this, sb.toString());
        final PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
        final boolean z = (CoreApi.O000000o().O0000OoO(str) == null || CoreApi.O000000o().O0000Oo(str) == null) ? false : true;
        if (TextUtils.equals("mxiang.camera.mwc11", str)) {
            str = "mxiang.camera.mwc10";
        }
        final Context context2 = context;
        final int i2 = i;
        PluginApi.getInstance().installPlugin(ServiceApplication.getAppContext(), str, new SendMessageCallback() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneDetailActivity.AnonymousClass2 */

            public final void onDownloadStart(final String str, PluginDownloadTask pluginDownloadTask) {
                pluginDownloadTask.O000000o(pluginDownloadTask);
                if (O000000o2 != null) {
                    Context context = context2;
                    if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT < 17 || !((Activity) context2).isDestroyed()) {
                        O000000o2.O000000o(100, 0);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                        xQProgressHorizontalDialog.f9117O000000o = false;
                        xQProgressHorizontalDialog.setCancelable(true);
                        O000000o2.show();
                        O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneDetailActivity.AnonymousClass2.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                CoreApi.O000000o().O000000o(str, pluginDownloadTask);
                            }
                        });
                    }
                }
            }

            public final void onDownloadProgress(String str, float f) {
                if (z) {
                    int i = (int) (f * 100.0f);
                    if (i >= 99) {
                        i = 99;
                    }
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.O000000o(100, i);
                        return;
                    }
                    return;
                }
                XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
                if (xQProgressHorizontalDialog2 != null) {
                    xQProgressHorizontalDialog2.O000000o(100, (int) (f * 100.0f));
                }
            }

            public final void onDownloadSuccess(String str) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (!z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onDownloadFailure(PluginError pluginError) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (!z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
                izb.O000000o(ServiceApplication.getAppContext(), pluginError.O000000o(context2), 0).show();
            }

            public final void onDownloadCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (!z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onInstallSuccess(String str) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                    O000000o2.dismiss();
                }
                SmartHomeSceneDetailActivity.this.doOnNextStepScene(i2);
            }

            public final void onInstallFailure(PluginError pluginError) {
                gsy.O000000o(6, "SmartHomeSceneDetailActivity", pluginError.O00000Oo);
                XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                    O000000o2.dismiss();
                }
                izb.O000000o(ServiceApplication.getAppContext(), (int) R.string.device_enter_failed, 0).show();
            }
        });
    }

    public Device getDevice() {
        Device device;
        hos hos;
        hnm hnm = this.mAction;
        if (hnm != null && (hnm instanceof hnq)) {
            hnq hnq = (hnq) hnm;
            if (hnq.O00000oo != null) {
                device = hnq.O00000oo;
                return (device != null || (hos = this.mCondition) == null) ? device : hos.O00000o0();
            }
        }
        device = null;
        if (device != null) {
            return device;
        }
    }

    public void generateDisplayIds(List<Integer> list, List<Integer> list2) {
        Object obj;
        Object obj2;
        Object obj3;
        this.mUnSelectIds.clear();
        if (list2 != null) {
            this.mUnSelectIds.addAll(list2);
        }
        if (list != null) {
            for (Integer put : list) {
                this.mDisableMaps.put(put, "Disable");
            }
        }
        if (this.mCondition != null) {
            for (int i = 0; i < this.mUnSelectIds.size(); i++) {
                if (this.mShowGroupInfo) {
                    List<String> list3 = this.mUnSelectName;
                    hox hox = (hox) this.mCondition;
                    int intValue = this.mUnSelectIds.get(i).intValue();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= hox.O0000O0o.length) {
                            obj3 = null;
                            break;
                        } else if (hox.O0000O0o[i2] == intValue) {
                            obj3 = hox.O00000oo[i2];
                            break;
                        } else {
                            i2++;
                        }
                    }
                    list3.add(obj3);
                } else {
                    this.mUnSelectName.add(this.mCondition.O00000Oo(this.mUnSelectIds.get(i).intValue()));
                }
            }
        }
        if (this.mAction != null) {
            for (int i3 = 0; i3 < this.mUnSelectIds.size(); i3++) {
                if (this.mShowGroupInfo) {
                    List<String> list4 = this.mUnSelectName;
                    hnq hnq = (hnq) this.mAction;
                    int intValue2 = this.mUnSelectIds.get(i3).intValue();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= hnq.O0000OOo.length) {
                            obj2 = null;
                            break;
                        } else if (hnq.O0000OOo[i4] == intValue2) {
                            obj2 = hnq.O0000O0o[i4];
                            break;
                        } else {
                            i4++;
                        }
                    }
                    list4.add(obj2);
                } else {
                    List<String> list5 = this.mUnSelectName;
                    hnm hnm = this.mAction;
                    int intValue3 = this.mUnSelectIds.get(i3).intValue();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= hnm.O00000Oo.length) {
                            obj = null;
                            break;
                        } else if (hnm.O00000Oo[i5] == intValue3) {
                            obj = hnm.f19096O000000o[i5];
                            break;
                        } else {
                            i5++;
                        }
                    }
                    list5.add(obj);
                }
            }
        }
    }
}
