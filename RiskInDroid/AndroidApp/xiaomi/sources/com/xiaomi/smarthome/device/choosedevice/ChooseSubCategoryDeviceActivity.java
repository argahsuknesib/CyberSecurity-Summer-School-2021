package com.xiaomi.smarthome.device.choosedevice;

import _m_j.fmg;
import _m_j.fpq;
import _m_j.fqy;
import _m_j.hvg;
import _m_j.hxc;
import _m_j.hxi;
import _m_j.hzf;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.ChooseCategoryDeviceAdapter;
import com.xiaomi.smarthome.device.ChooseDeviceNestedParent;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.common.widget.FixHeightGridView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ChooseSubCategoryDeviceActivity extends BaseActivity implements fmg.O00000o, View.OnClickListener {
    private static int O0000OOo = 8;

    /* renamed from: O000000o  reason: collision with root package name */
    protected XQProgressHorizontalDialog f7241O000000o;
    private fpq O00000Oo = new fpq();
    private String O00000o;
    private boolean O00000o0;
    private int O00000oO;
    private int O00000oo;
    private float O0000O0o;
    @BindView(5136)
    View arrowSelected;
    @BindView(5135)
    View arrowUnSelected;
    public boolean isSorted = false;
    @BindView(4988)
    TextView mAddDeviceHeadTitle;
    public ChooseCategoryDeviceAdapter mCategoryDeviceAdapter;
    public boolean mHasLoaded;
    @BindView(5639)
    ImageView mMoreBackImg;
    public ArrayList<PluginDeviceInfo> mPDInfoSortedByNew = new ArrayList<>();
    public ArrayList<PluginDeviceInfo> mPluginDeviceInfos = new ArrayList<>();
    @BindView(5101)
    View mSubCategoryDeviceLayout;
    @BindView(6031)
    ChooseDeviceNestedParent mSubCategoryScrollView;
    @BindView(6030)
    TextView mSubCategoryTv;
    @BindView(6032)
    FixHeightGridView mSubCatoryListView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_choose_sub_category_device);
        ButterKnife.bind(this);
        this.O00000Oo.O00000Oo = this;
        Intent intent = getIntent();
        if (intent != null) {
            this.O00000o0 = intent.getBooleanExtra("from_miui", false);
            this.O00000o = intent.getStringExtra("sub_category_name");
            int intExtra = intent.getIntExtra("category_id", 0);
            int intExtra2 = intent.getIntExtra("sub_category_id", 0);
            hxi.O00000o0.f957O000000o.O000000o("add_device_all_show", "categoryId", Integer.valueOf(intExtra), "subCategoryId", Integer.valueOf(intExtra2));
        }
        this.mMoreBackImg.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.$$Lambda$ChooseSubCategoryDeviceActivity$igqFNuBe75EzXGWJF23Y4CmtAU4 */

            public final void onClick(View view) {
                ChooseSubCategoryDeviceActivity.this.O00000Oo(view);
            }
        });
        this.mAddDeviceHeadTitle.setVisibility(0);
        this.mCategoryDeviceAdapter = new ChooseCategoryDeviceAdapter(getContext());
        ChooseCategoryDeviceAdapter chooseCategoryDeviceAdapter = this.mCategoryDeviceAdapter;
        chooseCategoryDeviceAdapter.O00000Oo = this;
        this.mSubCatoryListView.setAdapter((ListAdapter) chooseCategoryDeviceAdapter);
        this.mSubCategoryScrollView.setNestView(this.mSubCategoryTv);
        this.mSubCategoryScrollView.setYScrollDelta(0);
        this.mSubCategoryTv.setText(this.O00000o);
        this.mMoreBackImg.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.$$Lambda$ChooseSubCategoryDeviceActivity$GlYJG9vbfltPNAMEx4c7UwcCr8o */

            public final void onClick(View view) {
                ChooseSubCategoryDeviceActivity.this.O000000o(view);
            }
        });
        this.mSubCategoryScrollView.setOnScanViewChangeListener(new ChooseDeviceNestedParent.O000000o() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseSubCategoryDeviceActivity.AnonymousClass3 */

            public final void O000000o() {
                ChooseSubCategoryDeviceActivity.this.mAddDeviceHeadTitle.setText(ChooseSubCategoryDeviceActivity.this.mSubCategoryTv.getText());
                hzf.O0000Oo0(ChooseSubCategoryDeviceActivity.this.mAddDeviceHeadTitle);
            }

            public final void O00000Oo() {
                hzf.O0000Oo(ChooseSubCategoryDeviceActivity.this.mAddDeviceHeadTitle);
            }
        });
    }

    public void onResume() {
        XQProgressHorizontalDialog xQProgressHorizontalDialog;
        super.onResume();
        this.O00000oo = getResources().getDimensionPixelOffset(R.dimen.choose_device_common_item_width);
        this.O0000O0o = getResources().getDisplayMetrics().density;
        this.O00000oO = hzf.O000000o(getContext(), (int) (((float) this.O00000oo) / this.O0000O0o), O0000OOo);
        ChooseCategoryDeviceAdapter chooseCategoryDeviceAdapter = this.mCategoryDeviceAdapter;
        int i = this.O00000oO;
        chooseCategoryDeviceAdapter.O00000o = i;
        this.mSubCatoryListView.setNumColumns(i);
        if (!this.mHasLoaded && ((xQProgressHorizontalDialog = this.f7241O000000o) == null || !xQProgressHorizontalDialog.isShowing())) {
            this.f7241O000000o = new XQProgressHorizontalDialog(this);
            this.f7241O000000o.setCancelable(false);
            this.f7241O000000o.setMessage(getResources().getString(R.string.loading_data));
            this.f7241O000000o.show();
        }
        CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseSubCategoryDeviceActivity.AnonymousClass1 */

            public final void run() {
                ChooseSubCategoryDeviceActivity.this.mPluginDeviceInfos.clear();
                ChooseSubCategoryDeviceActivity.this.mPluginDeviceInfos.addAll(ChooseDeviceActivity.selectSubCategoryPluginDeviceInfo);
                Collections.sort(ChooseSubCategoryDeviceActivity.this.mPluginDeviceInfos, new Comparator<PluginDeviceInfo>() {
                    /* class com.xiaomi.smarthome.device.choosedevice.ChooseSubCategoryDeviceActivity.AnonymousClass1.AnonymousClass1 */

                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        PluginDeviceInfo pluginDeviceInfo = (PluginDeviceInfo) obj;
                        PluginDeviceInfo pluginDeviceInfo2 = (PluginDeviceInfo) obj2;
                        if (pluginDeviceInfo.O00oOoOo == 0) {
                            return pluginDeviceInfo2.O00oOoOo == 0 ? 0 : 1;
                        }
                        if (pluginDeviceInfo2.O00oOoOo == 0) {
                            return -1;
                        }
                        if (pluginDeviceInfo.O00oOoOo == pluginDeviceInfo2.O00oOoOo) {
                            return pluginDeviceInfo.O0000Oo0().compareTo(pluginDeviceInfo2.O0000Oo0());
                        }
                        return pluginDeviceInfo.O00oOoOo - pluginDeviceInfo2.O00oOoOo;
                    }
                });
                ChooseSubCategoryDeviceActivity.this.mCategoryDeviceAdapter.O00000o0 = new ChooseCategoryDeviceAdapter.O000000o() {
                    /* class com.xiaomi.smarthome.device.choosedevice.ChooseSubCategoryDeviceActivity.AnonymousClass1.AnonymousClass2 */

                    public final void O000000o() {
                        ChooseSubCategoryDeviceActivity.this.hideProgress();
                        ChooseSubCategoryDeviceActivity.this.mHasLoaded = true;
                    }
                };
                ChooseSubCategoryDeviceActivity.this.mCategoryDeviceAdapter.O000000o(ChooseSubCategoryDeviceActivity.this.mPluginDeviceInfos);
            }
        }, 50);
        CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseSubCategoryDeviceActivity.AnonymousClass2 */

            public final void run() {
                ChooseSubCategoryDeviceActivity chooseSubCategoryDeviceActivity = ChooseSubCategoryDeviceActivity.this;
                chooseSubCategoryDeviceActivity.mPDInfoSortedByNew = (ArrayList) chooseSubCategoryDeviceActivity.mPluginDeviceInfos.clone();
                Collections.sort(ChooseSubCategoryDeviceActivity.this.mPDInfoSortedByNew, new Comparator<PluginDeviceInfo>() {
                    /* class com.xiaomi.smarthome.device.choosedevice.ChooseSubCategoryDeviceActivity.AnonymousClass2.AnonymousClass1 */

                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        PluginDeviceInfo pluginDeviceInfo = (PluginDeviceInfo) obj;
                        PluginDeviceInfo pluginDeviceInfo2 = (PluginDeviceInfo) obj2;
                        if (pluginDeviceInfo == null) {
                            return pluginDeviceInfo2 == null ? 0 : 1;
                        }
                        if (pluginDeviceInfo2 == null) {
                            return -1;
                        }
                        return (int) (pluginDeviceInfo2.O0000oo - Long.valueOf(pluginDeviceInfo.O0000oo).longValue());
                    }
                });
                if (ChooseSubCategoryDeviceActivity.this.isSorted) {
                    ChooseSubCategoryDeviceActivity.this.mCategoryDeviceAdapter.O000000o(ChooseSubCategoryDeviceActivity.this.mPDInfoSortedByNew);
                    ChooseSubCategoryDeviceActivity.this.arrowSelected.setVisibility(0);
                    ChooseSubCategoryDeviceActivity.this.arrowUnSelected.setVisibility(8);
                }
                ChooseSubCategoryDeviceActivity.this.arrowUnSelected.setOnClickListener(ChooseSubCategoryDeviceActivity.this);
                ChooseSubCategoryDeviceActivity.this.arrowSelected.setOnClickListener(ChooseSubCategoryDeviceActivity.this);
            }
        }, 50);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int O000000o2 = hzf.O000000o(getContext(), (int) (((float) this.O00000oo) / this.O0000O0o), O0000OOo);
        if (this.O00000oO != O000000o2) {
            this.O00000oO = O000000o2;
            ChooseCategoryDeviceAdapter chooseCategoryDeviceAdapter = this.mCategoryDeviceAdapter;
            int i = this.O00000oO;
            chooseCategoryDeviceAdapter.O00000o = i;
            this.mSubCatoryListView.setNumColumns(i);
            this.mCategoryDeviceAdapter.O000000o(this.mPluginDeviceInfos);
        }
    }

    public void hideProgress() {
        XQProgressHorizontalDialog xQProgressHorizontalDialog = this.f7241O000000o;
        if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
            this.f7241O000000o.dismiss();
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
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null ? intent.getBooleanExtra("finish", true) : false) {
            Intent intent2 = new Intent();
            intent2.putExtra("finish", true);
            if (intent != null) {
                intent2.putExtras(intent);
            }
            setResult(-1, intent2);
            finish();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.choose_sub_new_down) {
            this.isSorted = true;
            this.mCategoryDeviceAdapter.O000000o(this.mPDInfoSortedByNew);
            this.arrowSelected.setVisibility(0);
            this.arrowUnSelected.setVisibility(8);
            hxi.O00000o.f952O000000o.O000000o("add_device_all_new_ck", new Object[0]);
        }
        if (view.getId() == R.id.choose_sub_new_up) {
            this.isSorted = true;
            this.mCategoryDeviceAdapter.O000000o(this.mPluginDeviceInfos);
            this.arrowSelected.setVisibility(8);
            this.arrowUnSelected.setVisibility(0);
        }
    }

    public void chooseConnectDevice(PluginDeviceInfo pluginDeviceInfo) {
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(pluginDeviceInfo.O00000Oo());
        if (O00000oO2 != null) {
            if (this.O00000Oo.O000000o(O00000oO2, fqy.O000000o((Intent) null, 2), this.O00000o0)) {
                hxc.O000000o().O000000o(O00000oO2.O00000Oo(), 2);
            }
            hvg.O000000o(CommonApplication.getAppContext()).O000000o(O00000oO2.O00000Oo());
            hvg.O000000o(CommonApplication.getAppContext()).O000000o("from", "2");
        }
    }
}
