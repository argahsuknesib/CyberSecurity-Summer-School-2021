package com.xiaomi.smarthome.framework.update.ui;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gfb;
import _m_j.gfj;
import _m_j.ggb;
import _m_j.gqb;
import _m_j.gsy;
import _m_j.hzj;
import _m_j.izb;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RouterService
public class UpdateRecordActivity extends BaseActivity {
    RecyclerView.O000000o mAdapter = new RecyclerView.O000000o() {
        /* class com.xiaomi.smarthome.framework.update.ui.UpdateRecordActivity.AnonymousClass4 */

        public final int getItemCount() {
            return UpdateRecordActivity.this.mDatas.size();
        }

        /* renamed from: com.xiaomi.smarthome.framework.update.ui.UpdateRecordActivity$4$O000000o */
        class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            public SimpleDraweeView f8754O000000o;
            public Button O00000Oo;
            public TextView O00000o;
            public TextView O00000o0;
            public TextView O00000oO;
            public TextView O00000oo;
            public TextView O0000O0o;
            public TextView O0000OOo;
            public ImageView O0000Oo0;

            public O000000o(View view) {
                super(view);
                this.f8754O000000o = (SimpleDraweeView) view.findViewById(R.id.icon);
                this.O00000Oo = (Button) view.findViewById(R.id.btn_open);
                this.O00000o0 = (TextView) view.findViewById(R.id.tv_device_name);
                this.O00000o = (TextView) view.findViewById(R.id.tv_date);
                this.O00000oO = (TextView) view.findViewById(R.id.tv_auto_flag);
                this.O00000oo = (TextView) view.findViewById(R.id.tv_family);
                this.O0000O0o = (TextView) view.findViewById(R.id.tv_version);
                this.O0000OOo = (TextView) view.findViewById(R.id.tv_release_note);
                this.O0000Oo0 = (ImageView) view.findViewById(R.id.iv_expand);
            }
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            final Device device;
            final gfj gfj = UpdateRecordActivity.this.mDatas.get(i);
            try {
                device = fno.O000000o().O000000o(gfj.f17656O000000o);
                if (device == null) {
                    device = fno.O000000o().O00000oo(gfj.f17656O000000o);
                }
            } catch (Exception unused) {
                device = null;
            }
            if (device != null) {
                hzj.O000000o();
                final O000000o o000000o = (O000000o) o000OOo0;
                DeviceFactory.O00000Oo(device.model, o000000o.f8754O000000o);
                o000000o.O00000o0.setText(device.name);
                o000000o.O00000o.setText(new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(gfj.O00000o0 * 1000)));
                if (gfj.O00000Oo == 0) {
                    o000000o.O00000oO.setText((int) R.string.update_manual);
                    o000000o.O00000oO.setTextColor(UpdateRecordActivity.this.getResources().getColor(R.color.mj_color_manual_update_flag_text_color));
                } else {
                    o000000o.O00000oO.setText((int) R.string.update_auto);
                    o000000o.O00000oO.setTextColor(UpdateRecordActivity.this.getResources().getColor(R.color.mj_color_auto_update_flag_text_color));
                }
                String O0000o0O = ggb.O00000Oo().O0000o0O(device.did);
                Home O0000o0 = ggb.O00000Oo().O0000o0(device.did);
                String rawName = O0000o0 != null ? O0000o0.getRawName() : "";
                TextView textView = o000000o.O00000oo;
                textView.setText(gqb.O000000o(rawName, 14, "…") + "-" + gqb.O000000o(O0000o0O, 10, "…"));
                o000000o.O0000O0o.setText(gfj.O00000o);
                o000000o.O0000OOo.setText(gfj.O00000oo);
                o000000o.O00000Oo.setVisibility(0);
                o000000o.O00000Oo.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.update.ui.UpdateRecordActivity.AnonymousClass4.AnonymousClass1 */

                    public final void onClick(View view) {
                        UpdateRecordActivity.this.gotoDevicePage(gfj.f17656O000000o);
                    }
                });
                o000000o.O0000OOo.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    /* class com.xiaomi.smarthome.framework.update.ui.UpdateRecordActivity.AnonymousClass4.AnonymousClass2 */

                    public final boolean onPreDraw() {
                        if (o000000o.O0000OOo.getLineCount() <= 2) {
                            o000000o.O0000Oo0.setVisibility(8);
                        } else {
                            o000000o.O0000Oo0.setVisibility(0);
                            o000000o.O0000Oo0.performClick();
                        }
                        o000000o.O0000OOo.getViewTreeObserver().removeOnPreDrawListener(this);
                        return false;
                    }
                });
                o000000o.O0000Oo0.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.update.ui.UpdateRecordActivity.AnonymousClass4.AnonymousClass3 */

                    public final void onClick(View view) {
                        if (o000000o.O0000OOo.getMaxLines() == 2) {
                            o000000o.O0000OOo.setMaxLines(Integer.MAX_VALUE);
                            o000000o.O0000Oo0.setImageResource(R.drawable.icon_update_pack);
                            return;
                        }
                        o000000o.O0000OOo.setMaxLines(2);
                        o000000o.O0000Oo0.setImageResource(R.drawable.icon_update_expand);
                    }
                });
                o000000o.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.update.ui.UpdateRecordActivity.AnonymousClass4.AnonymousClass4 */

                    public final void onClick(View view) {
                        Intent intent = new Intent(UpdateRecordActivity.this.getContext(), FireWareHistoryActivity.class);
                        intent.putExtra("did", device.did);
                        UpdateRecordActivity.this.startActivity(intent);
                    }
                });
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O000000o(LayoutInflater.from(UpdateRecordActivity.this).inflate((int) R.layout.update_record_recycler_item, viewGroup, false));
        }
    };
    public List<gfj> mDatas = new ArrayList();
    private RecyclerView mRecyclerView;
    public RelativeLayout mRlNoData;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_udpate_record);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.UpdateRecordActivity.AnonymousClass1 */

            public final void onClick(View view) {
                UpdateRecordActivity.this.finish();
            }
        });
        this.mRlNoData = (RelativeLayout) findViewById(R.id.rl_no_data);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.setAdapter(this.mAdapter);
        requestData();
    }

    /* access modifiers changed from: package-private */
    public void writeLog(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        gsy.O00000o0(LogType.OTA, "Wifi-OTA", str);
    }

    private void requestData() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
            Device device = (Device) value.getValue();
            if (device != null) {
                arrayList.add(device.did);
            }
        }
        writeLog("更新记录:start requestData ,dids=".concat(String.valueOf(TextUtils.join(",", arrayList))), new Object[0]);
        gfb.O000000o();
        gfb.O00000Oo(this, arrayList, new fsm<List<gfj>, fso>() {
            /* class com.xiaomi.smarthome.framework.update.ui.UpdateRecordActivity.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    gfj gfj = (gfj) it.next();
                    Device O000000o2 = fno.O000000o().O000000o(gfj.f17656O000000o);
                    if (O000000o2 == null) {
                        O000000o2 = fno.O000000o().O0000OOo(gfj.f17656O000000o);
                    }
                    if (O000000o2 == null) {
                        UpdateRecordActivity.this.writeLog("更新记录: requestData onSuccess, did=%s,changLog=%s, 但在本地无法根据did匹配设备，remove it!!!", gfj.f17656O000000o, gfj.O00000oo);
                        it.remove();
                    } else {
                        UpdateRecordActivity.this.writeLog("更新记录: requestData onSuccess, name =%s,did=%s,changLog=%s", O000000o2.name, gfj.f17656O000000o, gfj.O00000oo);
                    }
                }
                if (list.size() == 0) {
                    UpdateRecordActivity.this.mRlNoData.setVisibility(0);
                    return;
                }
                UpdateRecordActivity.this.mRlNoData.setVisibility(8);
                UpdateRecordActivity.this.mDatas.clear();
                UpdateRecordActivity.this.mDatas.addAll(list);
                UpdateRecordActivity.this.mAdapter.notifyDataSetChanged();
            }

            public final void onFailure(fso fso) {
                if (fso != null) {
                    UpdateRecordActivity updateRecordActivity = UpdateRecordActivity.this;
                    updateRecordActivity.writeLog("更新记录: requestData onFailure:" + fso.toString(), new Object[0]);
                    return;
                }
                UpdateRecordActivity.this.writeLog("更新记录: requestData onFailure: error is null", new Object[0]);
            }
        });
    }

    public void gotoDevicePage(String str) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 == null) {
            O000000o2 = fno.O000000o().O00000Oo(str);
        }
        if (O000000o2 == null) {
            izb.O000000o(this, (int) R.string.update_success_open_failure, 0).show();
            return;
        }
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(O000000o2.model);
        Intent intent = new Intent();
        final XQProgressHorizontalDialog O000000o3 = XQProgressHorizontalDialog.O000000o(this, getString(R.string.plugin_downloading) + O00000oO.O0000Oo0() + getString(R.string.plugin));
        PluginApi.getInstance().sendMessage(this, O000000o2.model, 1, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O000000o2), null, false, new SendMessageCallback() {
            /* class com.xiaomi.smarthome.framework.update.ui.UpdateRecordActivity.AnonymousClass3 */

            public final void onDownloadStart(final String str, final PluginDownloadTask pluginDownloadTask) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (UpdateRecordActivity.this.isValid() && (xQProgressHorizontalDialog = O000000o3) != null) {
                    xQProgressHorizontalDialog.O000000o(true);
                    XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o3;
                    xQProgressHorizontalDialog2.f9117O000000o = false;
                    xQProgressHorizontalDialog2.setCancelable(true);
                    O000000o3.show();
                    O000000o3.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        /* class com.xiaomi.smarthome.framework.update.ui.UpdateRecordActivity.AnonymousClass3.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            CoreApi.O000000o().O000000o(str, pluginDownloadTask);
                        }
                    });
                }
            }

            public final void onDownloadProgress(String str, float f) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o3;
                if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                    O000000o3.O000000o(100, (int) (f * 100.0f));
                }
            }

            public final void onDownloadSuccess(String str) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o3;
                if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                    O000000o3.dismiss();
                }
            }

            public final void onDownloadFailure(PluginError pluginError) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o3;
                if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                    O000000o3.dismiss();
                }
            }

            public final void onDownloadCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o3;
                if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                    O000000o3.dismiss();
                }
            }
        });
    }
}
