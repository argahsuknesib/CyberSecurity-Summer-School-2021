package com.xiaomi.smarthome.smartconfig.step;

import _m_j.gnn;
import _m_j.gri;
import _m_j.gue;
import _m_j.hsl;
import _m_j.htr;
import _m_j.huf;
import _m_j.hul;
import _m_j.hvb;
import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.FlowGroup;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SuccessStep extends SmartConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f11820O000000o = false;
    List<String> O00000Oo;
    private O000000o O00000o;
    HashSet<String> O00000o0 = new HashSet<>();
    private XQProgressDialog O00000oO;
    @BindView(6291)
    CheckBox mCheckBox;
    @BindView(6303)
    View mChooseContainer;
    @BindView(7374)
    FlowGroup mFlowGroup;
    @BindView(7370)
    ImageView mIcon;
    @BindView(6779)
    TextView mLeftBtn;
    @BindView(6989)
    View mLeftRightBtn;
    @BindView(6986)
    Button mNextButton;
    @BindView(7210)
    TextView mRightBtn;
    @BindView(7373)
    ScrollView mScrollView;

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_SUCCESS;
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(final boolean z) {
        this.O00000o0.clear();
        Device device = (Device) htr.O000000o().O000000o("connected_device");
        for (int i = 0; i < this.mFlowGroup.getChildCount() - 1; i++) {
            if (this.mFlowGroup.getChildAt(i).isSelected()) {
                this.O00000o0.add((String) this.mFlowGroup.getChildAt(i).getTag());
            }
        }
        Activity activity = null;
        if (this.O000O0oo != null) {
            this.O00000oO = XQProgressDialog.O000000o(this.O000O0oo, null, this.O000O0oo.getString(R.string.creating));
        }
        if (!this.mCheckBox.isChecked() || this.O000O0oo == null) {
            O00000o0(z);
        } else if (device == null) {
            O00000o0(z);
        } else {
            hvb smartConfigManager = SmartConfigRouterFactory.getSmartConfigManager();
            if (this.O000O0oo instanceof Activity) {
                activity = (Activity) this.O000O0oo;
            }
            smartConfigManager.addToLauncher(activity, false, device, null, "smart_config", new hul<Void>() {
                /* class com.xiaomi.smarthome.smartconfig.step.SuccessStep.AnonymousClass1 */

                public final void O000000o(int i) {
                    SuccessStep.this.O00000o0(z);
                }

                public final void O00000Oo(int i) {
                    SuccessStep.this.O00000o0(z);
                }

                public final /* synthetic */ void O000000o(Object obj) {
                    SuccessStep.this.O00000o0(z);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0(boolean z) {
        if (!z) {
            gue.O000000o().finishCurrentSmartConfig(this.O000O0oo, (Device) htr.O000000o().O000000o("connected_device"));
        }
        SmartConfigRouterFactory.getStatClickManager().adddevice_process_success_AP(this.O000OOOo, this.O00000o0.size() == 0 ? "null" : this.O00000o0.iterator().next(), this.mCheckBox.isChecked() ? 1 : 2);
        O00000o();
    }

    public final void O000000o(Context context) {
        O000000o(context, (int) R.layout.smart_config_success_ui);
        O000O0OO();
        this.mIcon.setImageResource(R.drawable.kuailian_success_icon);
        this.mCheckBox.setChecked(false);
        if (!gnn.O0000Oo0) {
            CheckBox checkBox = this.mCheckBox;
            checkBox.setPadding(checkBox.getPaddingLeft() + gri.O000000o(18.0f), this.mCheckBox.getPaddingTop(), this.mCheckBox.getPaddingRight(), this.mCheckBox.getPaddingBottom());
        }
        if (((Integer) htr.O000000o().O000000o("key_strategy_index")).intValue() == 10) {
            this.mNextButton.setVisibility(8);
            this.mLeftRightBtn.setVisibility(0);
            String authAppName = hsl.O000000o().getAuthAppName();
            TextView textView = this.mLeftBtn;
            textView.setText(this.O000O0oo.getString(R.string.action_back) + authAppName);
            this.mLeftBtn.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.SuccessStep.AnonymousClass2 */

                public final void onClick(View view) {
                    SuccessStep.this.O00000Oo(true);
                }
            });
            this.mRightBtn.setText((int) R.string.auth_finish_dialog_to_mijia_plugin);
            this.mRightBtn.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.SuccessStep.AnonymousClass3 */

                public final void onClick(View view) {
                    SuccessStep.this.O00000Oo(false);
                }
            });
        } else {
            this.mNextButton.setVisibility(0);
            this.mLeftRightBtn.setVisibility(8);
            this.mNextButton.setText((int) R.string.common_finish);
            this.mNextButton.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.SuccessStep.AnonymousClass4 */

                public final void onClick(View view) {
                    SuccessStep.this.O00000Oo(true);
                }
            });
        }
        Device device = (Device) htr.O000000o().O000000o("connected_device");
        if (device == null) {
            this.O00000Oo = SmartConfigRouterFactory.getSmartConfigManager().getDefaultRecommendTags();
        } else {
            this.O00000Oo = SmartConfigRouterFactory.getSmartConfigManager().getRecommendTags(device);
        }
        if (!SmartConfigRouterFactory.getCoreApiManager().isInternationalServer()) {
            O00000Oo();
        } else {
            this.mChooseContainer.setVisibility(8);
        }
        SmartConfigRouterFactory.getSmartConfigManager().resetCurrentTag();
    }

    private void O00000o() {
        Device device = (Device) htr.O000000o().O000000o("connected_device");
        if (device == null) {
            b_(true);
            return;
        }
        this.O00000o = new O000000o();
        HashSet<String> hashSet = this.O00000o0;
        if (hashSet == null || hashSet.size() <= 0) {
            SmartConfigRouterFactory.getSmartConfigManager().bindDeviceToHome(device, this.O00000o);
        } else {
            SmartConfigRouterFactory.getSmartConfigManager().addTags(this.O00000o0, device.did, true, this.O00000o);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        this.mFlowGroup.removeAllViews();
        LayoutInflater from = LayoutInflater.from(this.O000O0oo);
        int O000000o2 = gri.O000000o((Activity) this.O000O0oo).x - gri.O000000o(50.0f);
        for (int i = 0; i < this.O00000Oo.size(); i++) {
            TextView textView = (TextView) from.inflate((int) R.layout.smart_config_tag_btn, (ViewGroup) null);
            textView.setMaxWidth(O000000o2);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.SuccessStep.AnonymousClass5 */

                public final void onClick(View view) {
                    if (view.isSelected()) {
                        view.setSelected(false);
                        return;
                    }
                    for (int i = 0; i < SuccessStep.this.mFlowGroup.getChildCount(); i++) {
                        SuccessStep.this.mFlowGroup.getChildAt(i).setSelected(false);
                    }
                    view.setSelected(true);
                }
            });
            textView.setText(this.O00000Oo.get(i));
            textView.setTag(this.O00000Oo.get(i));
            this.mFlowGroup.addView(textView);
        }
        ImageView imageView = new ImageView(this.O000O0oo);
        imageView.setImageResource(R.drawable.choose_tag_more);
        this.mFlowGroup.addView(imageView);
        this.mFlowGroup.setMoreClickListener(new FlowGroup.O000000o() {
            /* class com.xiaomi.smarthome.smartconfig.step.SuccessStep.AnonymousClass6 */

            public final void O000000o(boolean z) {
                if (!z) {
                    SuccessStep.this.mFlowGroup.setExpand(!z);
                    SuccessStep.this.x_().postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.smartconfig.step.SuccessStep.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            SuccessStep.this.mScrollView.fullScroll(130);
                        }
                    }, 50);
                    return;
                }
                SmartConfigRouterFactory.getSmartConfigManager().showAddRoomDialog(SuccessStep.this.O000O0oo, new ArrayList(), new huf() {
                    /* class com.xiaomi.smarthome.smartconfig.step.SuccessStep.AnonymousClass6.AnonymousClass2 */

                    public final void accept(String str) {
                        SuccessStep.this.O00000Oo.add(0, str);
                        SuccessStep.this.O00000Oo();
                        for (int i = 0; i < SuccessStep.this.mFlowGroup.getChildCount(); i++) {
                            SuccessStep.this.mFlowGroup.getChildAt(i).setSelected(false);
                        }
                        SuccessStep.this.mFlowGroup.getChildAt(0).setSelected(true);
                    }
                });
            }
        });
    }

    public final void O0000O0o() {
        this.O00000o = null;
        XQProgressDialog xQProgressDialog = this.O00000oO;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    class O000000o implements huf {
        O000000o() {
        }

        public final void accept(String str) {
            SuccessStep.this.b_(true);
        }
    }
}
