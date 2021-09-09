package com.xiaomi.smarthome.light.group;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gqg;
import _m_j.gtf;
import _m_j.gwg;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import _m_j.hzf;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfoV2;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.plugin.runtime.util.DeviceCategory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.AnimateLinearLayout;
import com.xiaomi.smarthome.light.group.LightGroupManageActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class LightGroupManageActivity extends BaseActivity {
    private static final String O00000o0 = "LightGroupManageActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    fno.O000000o f9352O000000o = new fno.O000000o() {
        /* class com.xiaomi.smarthome.light.group.LightGroupManageActivity.AnonymousClass1 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (i == 3 && fno.O000000o().O000000o(LightGroupManageActivity.this.mGroupDid) != null) {
                fno.O000000o().O00000Oo(LightGroupManageActivity.this.f9352O000000o);
                LightGroupManageActivity.this.mMemberDeviceList = fno.O000000o().O0000O0o(LightGroupManageActivity.this.mGroupDid);
                LightGroupManageActivity.this.lightGroupAdapter.f9358O000000o = LightGroupManageActivity.this.mMemberDeviceList;
                LightGroupManageActivity.this.exitEditMode();
            }
        }
    };
    protected TextView O00000Oo;
    private XQProgressDialog O00000o;
    private boolean O00000oO;
    public AtomicBoolean checkBleVersion = new AtomicBoolean(false);
    public O000000o lightGroupAdapter;
    public boolean mEditMode = false;
    public Device mGroup;
    public String mGroupDid;
    public List<Device> mMemberDeviceList = new ArrayList();
    public AnimateLinearLayout menuBar;
    public View titleBar;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_light_group_manage);
        this.mGroupDid = getIntent().getStringExtra("did");
        this.O00000oO = getIntent().getBooleanExtra("args_key_upgrade_only", false);
        if (TextUtils.isEmpty(this.mGroupDid)) {
            finish();
            return;
        }
        this.mGroup = fno.O000000o().O000000o(this.mGroupDid);
        if (this.mGroup == null) {
            finish();
            return;
        }
        this.mMemberDeviceList = fno.O000000o().O0000O0o(this.mGroupDid);
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        textView.setText((int) R.string.light_group_manager);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupManageActivity$97DYZ77hMui5JNFSOahAl8L4_EQ */

            public final void onClick(View view) {
                LightGroupManageActivity.this.O00000oo(view);
            }
        });
        findViewById(R.id.ota_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupManageActivity$a8Rp6zEiT9x8VetutIe6OhaKplk */

            public final void onClick(View view) {
                LightGroupManageActivity.this.O00000oO(view);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.module_a_3_right_btn);
        imageView.setImageResource(R.drawable.home_icon_add_gray);
        imageView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupManageActivity$6mvkU8SHovUziZ3Xbg495WfMNJQ */

            public final void onClick(View view) {
                LightGroupManageActivity.this.O00000o(view);
            }
        });
        if (this.O00000oO) {
            imageView.setVisibility(8);
            textView.setText((int) R.string.device_more_activity_firmware_update);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        this.lightGroupAdapter = new O000000o(this, this.mMemberDeviceList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.lightGroupAdapter);
        if (this.O00000oO) {
            hxp hxp = hxi.O00000o0;
            String str = this.mGroup.model;
            hxp.f957O000000o.O000000o("lightgroup_upgrade_show", "model", str);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (101 == i && i2 == -1 && intent != null) {
            List<Device> O0000O0o = fno.O000000o().O0000O0o(this.mGroupDid);
            if (O0000O0o != null) {
                O000000o o000000o = this.lightGroupAdapter;
                o000000o.f9358O000000o = O0000O0o;
                o000000o.notifyDataSetChanged();
            }
            this.mMemberDeviceList = O0000O0o;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        O000000o();
        fno.O000000o().O00000Oo(this.f9352O000000o);
        this.checkBleVersion.set(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oo(View view) {
        onBackPressed();
        hxk hxk = hxi.O00000o;
        String str = this.mGroup.model;
        hxk.f952O000000o.O000000o("lightgroup_upgrade_click", "model", str);
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
    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        Intent intent = new Intent(this, LightGroupSettingActivity.class);
        intent.putExtra("did", this.mGroupDid);
        intent.putExtra("create_mode", false);
        intent.putExtra("key_group_model", this.mGroup.model);
        startActivityForResult(intent, 101);
    }

    public void onBackPressed() {
        if (this.mEditMode) {
            exitEditMode();
        } else {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(List list, DialogInterface dialogInterface, int i) {
        DeviceApi.getInstance().modLightGroup(this, this.mGroupDid, new ArrayList(), list, new fsm<String, fso>() {
            /* class com.xiaomi.smarthome.light.group.LightGroupManageActivity.AnonymousClass2 */

            public final void onFailure(fso fso) {
                gqg.O00000Oo("Error: " + fso.O00000Oo);
                LightGroupManageActivity.this.O000000o();
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                fno.O000000o().O000000o(LightGroupManageActivity.this.f9352O000000o);
                fno.O000000o().O0000Oo0();
                LightGroupManageActivity.this.O000000o();
            }
        }, new boolean[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(DialogInterface dialogInterface, int i) {
        ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
        O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(DialogInterface dialogInterface, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mGroupDid);
        fno.O000000o().O000000o(arrayList, this, new fno.O00000Oo() {
            /* class com.xiaomi.smarthome.light.group.LightGroupManageActivity.AnonymousClass3 */

            public final void O000000o() {
                LightGroupManageActivity.this.finish();
                LightGroupManageActivity.this.overridePendingTransition(R.anim.activity_slide_in_left, R.anim.activity_slide_out_right);
                fbt fbt = new fbt(LightGroupManageActivity.this.getApplicationContext(), "SmartHomeMainActivity");
                fbt.O00000Oo(67108864);
                fbs.O000000o(fbt);
                LightGroupManageActivity.this.O000000o();
            }

            public final void O000000o(fso fso) {
                gqg.O00000Oo("Error: " + fso.O00000Oo);
                LightGroupManageActivity.this.O000000o();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
        ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
        O000000o();
    }

    public void enterEditMode() {
        if (!this.mEditMode && this.lightGroupAdapter.getItemCount() > 0) {
            try {
                if (this.titleBar == null) {
                    this.titleBar = ((ViewStub) findViewById(R.id.title_bar_choose_device_stub)).inflate();
                    this.titleBar.findViewById(16908313).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupManageActivity$fonthMZ03OcoreRQrAPwhYDd5UU */

                        public final void onClick(View view) {
                            LightGroupManageActivity.this.O00000o0(view);
                        }
                    });
                    this.titleBar.findViewById(16908314).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupManageActivity$SUoy_8gle7bpZBMGyX53RDtmdLo */

                        public final void onClick(View view) {
                            LightGroupManageActivity.this.O00000Oo(view);
                        }
                    });
                    this.O00000Oo = (TextView) this.titleBar.findViewById(R.id.module_a_4_return_more_title);
                    gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), findViewById(R.id.title_bar_choose_device));
                }
                if (this.menuBar == null) {
                    this.menuBar = (AnimateLinearLayout) ((ViewStub) findViewById(R.id.edit_action_bar_stub)).inflate();
                    this.menuBar.findViewById(R.id.btn_edit_sort).setVisibility(8);
                    ((Button) this.menuBar.findViewById(R.id.btn_edit_delete)).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupManageActivity$kjTUnxMzpNEmxCL2Wk1AIGWmpuc */

                        public final void onClick(View view) {
                            LightGroupManageActivity.this.O000000o(view);
                        }
                    });
                }
                this.titleBar.setVisibility(0);
                this.menuBar.setTranslationY(0.0f);
                this.menuBar.setVisibility(0);
                this.menuBar.O000000o(0, AnimateLinearLayout.O000000o(this.menuBar.getChildCount()));
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.titleBar, View.Y, -getResources().getDimension(R.dimen.titlebar_height), 0.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.play(ofFloat);
                animatorSet.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mEditMode = true;
            this.lightGroupAdapter.O00000Oo.clear();
            this.lightGroupAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        exitEditMode();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        O000000o o000000o = this.lightGroupAdapter;
        boolean z = o000000o.O00000Oo.size() < this.lightGroupAdapter.O000000o();
        for (int i = 0; i < o000000o.f9358O000000o.size(); i++) {
            if (o000000o.f9358O000000o.get(i).isOnline) {
                o000000o.O000000o(i, z);
            }
        }
        this.lightGroupAdapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        ArrayList arrayList = new ArrayList(this.lightGroupAdapter.O00000Oo);
        if (arrayList.size() > 0 && arrayList.size() == this.lightGroupAdapter.f9358O000000o.size()) {
            O00000Oo();
            new MLAlertDialog.Builder(this).O000000o((int) R.string.light_group_group_delete).O00000Oo((int) R.string.light_group_group_delete_desc).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupManageActivity$yvHA4_fnmAAXa5bSE7pe7lXGM */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    LightGroupManageActivity.this.O00000Oo(dialogInterface, i);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupManageActivity$anxI3VSloqpak1S57Zwh5PeELRk */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    LightGroupManageActivity.this.O000000o(dialogInterface, i);
                }
            }).O00000oo();
        } else if (arrayList.size() > 0 && arrayList.size() < this.lightGroupAdapter.f9358O000000o.size()) {
            O00000Oo();
            new MLAlertDialog.Builder(this).O000000o((int) R.string.light_group_child_delete).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(arrayList) {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupManageActivity$dgvoP95nGLz6FxpRqiTnVKZt_Bo */
                private final /* synthetic */ List f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    LightGroupManageActivity.this.O000000o(this.f$1, dialogInterface, i);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupManageActivity$zytXMBTlZ85MH0FYVGiu0pycHE */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    LightGroupManageActivity.this.O00000o0(dialogInterface, i);
                }
            }).O00000oo();
        }
    }

    public void exitEditMode() {
        if (this.mEditMode) {
            ViewGroup viewGroup = (ViewGroup) this.menuBar.getParent();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.titleBar, View.Y, 0.0f, (float) (-this.titleBar.getHeight()));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.menuBar, View.Y, (float) (viewGroup.getHeight() - this.menuBar.getHeight()), (float) viewGroup.getHeight());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new AnimatorListenerAdapter() {
                /* class com.xiaomi.smarthome.light.group.LightGroupManageActivity.AnonymousClass4 */

                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    LightGroupManageActivity.this.titleBar.clearAnimation();
                    LightGroupManageActivity.this.menuBar.clearAnimation();
                    LightGroupManageActivity.this.titleBar.setVisibility(8);
                    LightGroupManageActivity.this.menuBar.setVisibility(8);
                }
            });
            this.mEditMode = false;
            this.lightGroupAdapter.O00000Oo.clear();
            this.lightGroupAdapter.notifyDataSetChanged();
        }
    }

    public void updateActionItems(int i) {
        if (i > 0) {
            try {
                this.O00000Oo.setText(getResources().getQuantityString(R.plurals.edit_choosed_device, i, Integer.valueOf(i)));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            this.O00000Oo.setText((int) R.string.title_choose_device);
        }
        this.O00000Oo.setTypeface(null, 0);
        if (i >= this.lightGroupAdapter.O000000o()) {
            ((ImageView) this.titleBar.findViewById(16908314)).setImageResource(R.drawable.un_select_selector);
            this.titleBar.findViewById(16908314).setContentDescription(getString(R.string.unselect_all));
            return;
        }
        ((ImageView) this.titleBar.findViewById(16908314)).setImageResource(R.drawable.all_select_selector);
        this.titleBar.findViewById(16908314).setContentDescription(getString(R.string.select_all));
    }

    private void O00000Oo() {
        if (isValid()) {
            this.O00000o = new XQProgressDialog(this);
            this.O00000o.setMessage(getString(R.string.device_more_security_loading_operation));
            this.O00000o.show();
            this.O00000o.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupManageActivity$do77TQleOkMdDoUI9pVSTYqVoQE */

                public final void onCancel(DialogInterface dialogInterface) {
                    LightGroupManageActivity.this.O000000o(dialogInterface);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface) {
        this.checkBleVersion.set(false);
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        XQProgressDialog xQProgressDialog = this.O00000o;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    public class O000000o extends RecyclerView.O000000o<O00000Oo> {

        /* renamed from: O000000o  reason: collision with root package name */
        public List<Device> f9358O000000o;
        public Set<String> O00000Oo = new LinkedHashSet();
        private LayoutInflater O00000o;

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            Device device = this.f9358O000000o.get(i);
            if (device != null && o00000Oo != null) {
                o00000Oo.O00000oO.setVisibility(LightGroupManageActivity.this.mEditMode ? 0 : 8);
                o00000Oo.O00000oO.setEnabled(device.isOnline);
                o00000Oo.O00000Oo.setText(device.name);
                o00000Oo.O00000o0.setText(ggb.O00000Oo().O0000o0O(LightGroupManageActivity.this.mGroup.did) + "  " + ((Object) DeviceRouterFactory.getDeviceWrapper().getStatusDescription(device, LightGroupManageActivity.this)));
                DeviceFactory.O00000Oo(device.model, o00000Oo.O00000o);
                if (this.O00000Oo != null) {
                    o00000Oo.O00000oO.setChecked(this.O00000Oo.contains(device.did));
                }
                o00000Oo.O00000oO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(o00000Oo) {
                    /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupManageActivity$O000000o$w8a57h2bRFkSsLTcPE9NggI2z5k */
                    private final /* synthetic */ LightGroupManageActivity.O00000Oo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        LightGroupManageActivity.O000000o.this.O000000o(this.f$1, compoundButton, z);
                    }
                });
                if (o00000Oo.O00000oO.getVisibility() == 0) {
                    o00000Oo.f9359O000000o.setOnClickListener(o00000Oo.O00000oO.isEnabled() ? new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupManageActivity$O000000o$aNUEUo5Xue2gPOCjTnivREWa2A */

                        public final void onClick(View view) {
                            LightGroupManageActivity.O00000Oo.this.O00000oO.performClick();
                        }
                    } : null);
                    o00000Oo.f9359O000000o.setOnLongClickListener(null);
                }
            }
        }

        public O000000o(Context context, List<Device> list) {
            this.O00000o = LayoutInflater.from(context);
            this.f9358O000000o = list;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(O00000Oo o00000Oo, CompoundButton compoundButton, boolean z) {
            this.O00000Oo.contains(o00000Oo.O00000oO.getTag());
            O000000o(o00000Oo.getLayoutPosition(), z);
        }

        public final int getItemCount() {
            return this.f9358O000000o.size();
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(int i, boolean z) {
            try {
                Device device = this.f9358O000000o.get(i);
                if (device == null) {
                    return;
                }
                if (device.isOnline) {
                    if (z) {
                        this.O00000Oo.add(device.did);
                    } else {
                        this.O00000Oo.remove(device.did);
                    }
                    LightGroupManageActivity.this.updateActionItems(this.O00000Oo.size());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final int O000000o() {
            int i = 0;
            for (Device device : this.f9358O000000o) {
                if (device.isOnline) {
                    i++;
                }
            }
            return i;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O00000Oo(this.O00000o.inflate((int) R.layout.item_light_group, viewGroup, false));
        }
    }

    class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f9359O000000o;
        TextView O00000Oo;
        SimpleDraweeView O00000o;
        TextView O00000o0;
        CheckBox O00000oO;

        public O00000Oo(View view) {
            super(view);
            this.f9359O000000o = view;
            this.O00000Oo = (TextView) view.findViewById(R.id.title);
            this.O00000o0 = (TextView) view.findViewById(R.id.desc);
            this.O00000o = (SimpleDraweeView) view.findViewById(R.id.icon);
            this.O00000oO = (CheckBox) view.findViewById(R.id.checkbox);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oO(View view) {
        if (this.mMemberDeviceList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            for (Device next : this.mMemberDeviceList) {
                if (next != null) {
                    DeviceCategory fromPid = DeviceCategory.fromPid(next.pid);
                    if (fromPid == DeviceCategory.BleMesh || fromPid == DeviceCategory.Bluetooth) {
                        arrayList.add(next.did);
                    } else {
                        arrayList2.add(new KeyValuePair(next.did, next.model));
                    }
                }
            }
            O00000Oo();
            this.checkBleVersion.set(true);
            gtf.O000000o();
            gtf.O000000o(this.mGroup.model, arrayList, new Callback<List<BleMeshFirmwareUpdateInfoV2>>() {
                /* class com.xiaomi.smarthome.light.group.LightGroupManageActivity.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    if (!LightGroupManageActivity.this.checkBleVersion.get()) {
                        return;
                    }
                    if (list.size() > 0) {
                        fbt fbt = new fbt(LightGroupManageActivity.this, LightGroupMemberUpdateActivity.TAG);
                        fbt.O000000o("members", (Serializable) list);
                        fbt.O000000o("key_no_ble_mesh_devices", (ArrayList<? extends Parcelable>) arrayList2);
                        fbs.O000000o(fbt);
                        LightGroupManageActivity.this.O000000o();
                    } else if (arrayList2.size() > 0) {
                        LightGroupManageActivity.this.O000000o();
                        fbt fbt2 = new fbt(LightGroupManageActivity.this, "UpdateActivity");
                        fbt2.O000000o("arg_did_list", (ArrayList<? extends Parcelable>) arrayList2);
                        fbs.O000000o(fbt2);
                    } else {
                        gqg.O00000Oo((int) R.string.no_update);
                        LightGroupManageActivity.this.O000000o();
                    }
                }

                public final void onFailure(int i, String str) {
                    gqg.O00000Oo(str);
                    LightGroupManageActivity.this.O000000o();
                    if (arrayList2.size() > 0) {
                        fbt fbt = new fbt(LightGroupManageActivity.this, "UpdateActivity");
                        fbt.O000000o("arg_did_list", (ArrayList<? extends Parcelable>) arrayList2);
                        fbs.O000000o(fbt);
                    }
                }
            });
            return;
        }
        gqg.O00000Oo((int) R.string.no_update);
    }
}
