package com.xiaomi.smarthome.miio.page.msgcentersetting;

import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.gge;
import _m_j.gqg;
import _m_j.gxz;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hzf;
import _m_j.izb;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.ListItemView;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.miio.page.msgcentersetting.model.From;
import com.xiaomi.smarthome.miio.page.msgcentersetting.model.MsgCenterSettingData;
import com.xiaomi.smarthome.miio.page.msgcentersetting.model.NoInterruptTime;
import com.xiaomi.smarthome.miio.page.msgcentersetting.model.Param;
import com.xiaomi.smarthome.miio.page.msgcentersetting.model.To;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class MessageCenterSettingActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    XQProgressDialog f9928O000000o;
    @BindView(5089)
    ListItemView deviceShareItem;
    @BindView(5090)
    SwitchButton deviceShareItemBtn;
    @BindView(5091)
    TextView deviceShareItemTitle;
    @BindView(5161)
    SwitchButton familyInvitationBtn;
    @BindView(5162)
    ListItemView familyInvitationItem;
    @BindView(5163)
    TextView familyInvitationItemTitle;
    public MsgCenterSettingData mData;
    public Disposable mSubscription;
    public MsgCenterSettingData mTempData;
    @BindView(5422)
    ImageView moduleA3ReturnBtn;
    @BindView(5423)
    ImageView moduleA3ReturnMoreMoreBtn;
    @BindView(5426)
    TextView moduleA3ReturnTitle;
    @BindView(5598)
    SwitchButton pushDeviceItemBtn;
    @BindView(5600)
    ListItemView pushHomeDeviceItem;
    @BindView(5602)
    ListItemView pushShareDeviceItem;
    @BindView(5604)
    ListItemView pushSilentItem;
    @BindView(5605)
    SwitchButton pushSilentItemBtn;
    @BindView(5606)
    TextView pushSilentItemTitle;
    @BindView(5607)
    ListItemView pushSilentTimeItem;
    @BindView(5608)
    TextView pushSilentTimeItemTitle;
    @BindView(5609)
    TextView pushSilentTimeTv;
    @BindView(5734)
    ListItemView shopItem;
    @BindView(5735)
    SwitchButton shopItemBtn;
    @BindView(5736)
    TextView shopItemTitle;
    @BindView(5854)
    FrameLayout titleBar;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_message_center_setting);
        ButterKnife.bind(this);
        O000000o();
        this.mSubscription = (Disposable) Observable.create(new ObservableOnSubscribe<JSONObject>() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity.AnonymousClass5 */

            public final void subscribe(final ObservableEmitter<JSONObject> observableEmitter) throws Exception {
                fru.O000000o().O000000o(MessageCenterSettingActivity.this, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity.AnonymousClass5.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (!observableEmitter.isDisposed()) {
                            observableEmitter.onNext(jSONObject);
                            observableEmitter.onComplete();
                        }
                    }

                    public final void onFailure(fso fso) {
                        if (!observableEmitter.isDisposed()) {
                            observableEmitter.onError(new Exception(fso == null ? "" : fso.O00000Oo));
                        }
                    }
                });
            }
        }).map(new Function<JSONObject, MsgCenterSettingData>() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity.AnonymousClass4 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject == null) {
                    jSONObject = gxz.O000000o();
                }
                if (jSONObject == null) {
                    return null;
                }
                return MsgCenterSettingData.O000000o(jSONObject);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MsgCenterSettingData>() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity.AnonymousClass3 */

            public final void onComplete() {
            }

            public final /* synthetic */ void onNext(Object obj) {
                MsgCenterSettingData msgCenterSettingData = (MsgCenterSettingData) obj;
                if (MessageCenterSettingActivity.this.mSubscription.isDisposed()) {
                    return;
                }
                if ((Build.VERSION.SDK_INT < 17 || !MessageCenterSettingActivity.this.isDestroyed()) && !MessageCenterSettingActivity.this.isFinishing()) {
                    MessageCenterSettingActivity.this.dismissProcessDialog();
                    MessageCenterSettingActivity messageCenterSettingActivity = MessageCenterSettingActivity.this;
                    messageCenterSettingActivity.mData = msgCenterSettingData;
                    messageCenterSettingActivity.updateView(false);
                }
            }

            public final void onError(Throwable th) {
                if (!MessageCenterSettingActivity.this.mSubscription.isDisposed()) {
                    if ((Build.VERSION.SDK_INT < 17 || !MessageCenterSettingActivity.this.isDestroyed()) && !MessageCenterSettingActivity.this.isFinishing()) {
                        MessageCenterSettingActivity.this.dismissProcessDialog();
                        gqg.O000000o(MessageCenterSettingActivity.this.getString(R.string.message_center_setting_load_err));
                    }
                }
            }
        });
        this.moduleA3ReturnMoreMoreBtn.setVisibility(8);
        this.moduleA3ReturnTitle.setText((int) R.string.message_center_setting_title);
        this.deviceShareItemBtn.setOnTouchEnable(false);
        this.familyInvitationBtn.setOnTouchEnable(false);
        this.shopItemBtn.setOnTouchEnable(false);
        this.pushSilentItemBtn.setOnTouchEnable(false);
        this.pushDeviceItemBtn.setOnTouchEnable(false);
        findViewById(R.id.family_invitation_item).setVisibility(0);
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            findViewById(R.id.shop_item).setVisibility(8);
        } else {
            findViewById(R.id.shop_item).setVisibility(0);
        }
    }

    @OnClick({5422, 5597, 5090, 5089, 5161, 5162, 5735, 5734, 5605, 5604, 5607, 5600, 5602, 5598})
    public void onClick(View view) {
        try {
            this.mTempData = (MsgCenterSettingData) deepClone(this.mData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.mTempData != null || view.getId() == R.id.module_a_3_return_btn) {
            int id = view.getId();
            if (id == R.id.module_a_3_return_btn) {
                finish();
            } else if (id == R.id.push_device_item) {
                SwitchButton switchButton = this.pushDeviceItemBtn;
                switchButton.setChecked(!switchButton.isChecked());
                hzf.O000000o((CompoundButton) this.pushDeviceItemBtn);
                this.mTempData.param.O000000o(Integer.valueOf(this.pushDeviceItemBtn.isChecked() ? 1 : 0));
                updateMipushSwitch();
                hxi.O00000o.f952O000000o.O000000o("message_setting_device", "toggle", Integer.valueOf(this.pushDeviceItemBtn.isChecked() ^ true ? 1 : 0));
            } else if (id == R.id.device_share_item_btn) {
                this.mTempData.O000000o(this.deviceShareItemBtn.isChecked() ? 1 : 0);
                updateMipushSwitch();
            } else if (id == R.id.device_share_item) {
                SwitchButton switchButton2 = this.deviceShareItemBtn;
                switchButton2.setChecked(!switchButton2.isChecked());
                hzf.O000000o((CompoundButton) this.deviceShareItemBtn);
                this.mTempData.O000000o(this.deviceShareItemBtn.isChecked() ? 1 : 0);
                updateMipushSwitch();
                hxi.O00000o.f952O000000o.O000000o("message_setting_dshare", "toggle", Integer.valueOf(this.deviceShareItemBtn.isChecked() ^ true ? 1 : 0));
            } else if (id == R.id.family_invitation_btn) {
                this.mTempData.O00000Oo(this.familyInvitationBtn.isChecked() ? 1 : 0);
                updateMipushSwitch();
            } else if (id == R.id.family_invitation_item) {
                SwitchButton switchButton3 = this.familyInvitationBtn;
                switchButton3.setChecked(!switchButton3.isChecked());
                hzf.O000000o((CompoundButton) this.familyInvitationBtn);
                this.mTempData.O00000Oo(this.familyInvitationBtn.isChecked() ? 1 : 0);
                updateMipushSwitch();
                hxi.O00000o.f952O000000o.O000000o("message_setting_hshare", "toggle", Integer.valueOf(this.familyInvitationBtn.isChecked() ^ true ? 1 : 0));
            } else if (id == R.id.shop_item_btn) {
                this.mTempData.O00000o0(this.shopItemBtn.isChecked() ? 1 : 0);
                updateMipushSwitch();
            } else if (id == R.id.shop_item) {
                SwitchButton switchButton4 = this.shopItemBtn;
                switchButton4.setChecked(!switchButton4.isChecked());
                hzf.O000000o((CompoundButton) this.shopItemBtn);
                this.mTempData.O00000o0(this.shopItemBtn.isChecked() ? 1 : 0);
                updateMipushSwitch();
                hxi.O00000o.f952O000000o.O000000o("message_setting_store", "toggle", Integer.valueOf(this.shopItemBtn.isChecked() ^ true ? 1 : 0));
            } else if (id == R.id.push_silent_item_btn) {
                this.mTempData.O00000o(this.pushSilentItemBtn.isChecked() ? 1 : 0);
                updateMipushSwitch();
            } else if (id == R.id.push_silent_item) {
                SwitchButton switchButton5 = this.pushSilentItemBtn;
                switchButton5.setChecked(!switchButton5.isChecked());
                hzf.O000000o((CompoundButton) this.pushSilentItemBtn);
                this.mTempData.O00000o(this.pushSilentItemBtn.isChecked() ? 1 : 0);
                updateMipushSwitch();
                hxi.O00000o.f952O000000o.O000000o("message_setting_ndisturb", "toggle", Integer.valueOf(this.pushSilentItemBtn.isChecked() ^ true ? 1 : 0));
            } else if (id == R.id.push_silent_time_item) {
                NoInterruptTime noInterruptTime = this.mData.param.noInterruptTime;
                CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
                corntabParam.O00000o0 = noInterruptTime.from.hour;
                corntabParam.O00000Oo = noInterruptTime.from.min;
                CorntabUtils.CorntabParam O00000Oo = CorntabUtils.O00000Oo(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), corntabParam);
                CorntabUtils.CorntabParam corntabParam2 = new CorntabUtils.CorntabParam();
                corntabParam2.O00000o0 = noInterruptTime.to.hour;
                corntabParam2.O00000Oo = noInterruptTime.to.min;
                CorntabUtils.CorntabParam O00000Oo2 = CorntabUtils.O00000Oo(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), corntabParam2);
                Intent intent = new Intent(this, InterruptPushTimerSettingActiviy.class);
                intent.putExtra("from_hour", O00000Oo.O00000o0);
                intent.putExtra("from_min", O00000Oo.O00000Oo);
                intent.putExtra("to_hour", O00000Oo2.O00000o0);
                intent.putExtra("to_min", O00000Oo2.O00000Oo);
                startActivityForResult(intent, 200);
                hxi.O00000o.f952O000000o.O000000o("message_setting_time", new Object[0]);
            } else if (id == R.id.push_home_device_item) {
                Intent intent2 = new Intent(this, DevicePushSettingActivity.class);
                intent2.putExtra("device_push", "home_device");
                startActivity(intent2);
                hxi.O00000o.f952O000000o.O000000o("message_setting_hdevice", new Object[0]);
            } else if (id == R.id.push_share_device_item) {
                Intent intent3 = new Intent(this, DevicePushSettingActivity.class);
                intent3.putExtra("device_push", "share_device");
                startActivity(intent3);
                hxi.O00000o.f952O000000o.O000000o("message_setting_sdevice", new Object[0]);
            }
        }
    }

    public static Object deepClone(Object obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            return new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3;
        int i4;
        int i5;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 200 && intent != null) {
            MsgCenterSettingData msgCenterSettingData = this.mTempData;
            int i6 = 0;
            if (msgCenterSettingData == null) {
                i3 = 0;
            } else {
                i3 = msgCenterSettingData.param.noInterruptTime.from.hour;
            }
            int intExtra = intent.getIntExtra("from_hour", i3);
            MsgCenterSettingData msgCenterSettingData2 = this.mTempData;
            if (msgCenterSettingData2 == null) {
                i4 = 0;
            } else {
                i4 = msgCenterSettingData2.param.noInterruptTime.from.min;
            }
            int intExtra2 = intent.getIntExtra("from_min", i4);
            MsgCenterSettingData msgCenterSettingData3 = this.mTempData;
            if (msgCenterSettingData3 == null) {
                i5 = 0;
            } else {
                i5 = msgCenterSettingData3.param.noInterruptTime.to.hour;
            }
            int intExtra3 = intent.getIntExtra("to_hour", i5);
            MsgCenterSettingData msgCenterSettingData4 = this.mTempData;
            if (msgCenterSettingData4 != null) {
                i6 = msgCenterSettingData4.param.noInterruptTime.to.min;
            }
            int intExtra4 = intent.getIntExtra("to_min", i6);
            if (this.mTempData != null) {
                CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
                corntabParam.O00000o0 = intExtra;
                corntabParam.O00000Oo = intExtra2;
                CorntabUtils.CorntabParam O000000o2 = CorntabUtils.O000000o(TimeZone.getTimeZone("Asia/Shanghai"), corntabParam);
                this.mTempData.param.noInterruptTime.from.O000000o(Integer.valueOf(O000000o2.O00000o0));
                this.mTempData.param.noInterruptTime.from.O00000Oo(Integer.valueOf(O000000o2.O00000Oo));
                CorntabUtils.CorntabParam corntabParam2 = new CorntabUtils.CorntabParam();
                corntabParam2.O00000o0 = intExtra3;
                corntabParam2.O00000Oo = intExtra4;
                CorntabUtils.CorntabParam O000000o3 = CorntabUtils.O000000o(TimeZone.getTimeZone("Asia/Shanghai"), corntabParam2);
                this.mTempData.param.noInterruptTime.to.O000000o(Integer.valueOf(O000000o3.O00000o0));
                this.mTempData.param.noInterruptTime.to.O00000Oo(Integer.valueOf(O000000o3.O00000Oo));
            }
            updateMipushSwitch();
        } else if (i == 300 && intent.getExtras() != null) {
            try {
                MsgCenterSettingData msgCenterSettingData5 = (MsgCenterSettingData) intent.getExtras().get("device_push");
                if (msgCenterSettingData5 != null) {
                    this.mData = msgCenterSettingData5;
                    updateView(true);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.mSubscription;
        if (disposable != null && !disposable.isDisposed()) {
            this.mSubscription.dispose();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void updateMipushSwitch() {
        O000000o();
        this.mSubscription = (Disposable) Observable.create(new ObservableOnSubscribe<Object>() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity.AnonymousClass2 */

            public final void subscribe(final ObservableEmitter<Object> observableEmitter) throws Exception {
                fru.O000000o();
                MessageCenterSettingActivity messageCenterSettingActivity = MessageCenterSettingActivity.this;
                fru.O000000o(messageCenterSettingActivity, messageCenterSettingActivity.mTempData.param.O000000o(), new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity.AnonymousClass2.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        if (!observableEmitter.isDisposed()) {
                            observableEmitter.onError(new Throwable(fso.O00000Oo));
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (!observableEmitter.isDisposed()) {
                            ServiceApplication.getApplication().getSharedPreferences("msg_center_setting", 0).edit().putString("msg_center_content", MessageCenterSettingActivity.this.mTempData.param.O000000o().toString()).commit();
                            observableEmitter.onNext(new Object());
                            observableEmitter.onComplete();
                        }
                    }
                });
            }
        }).subscribeOn(Schedulers.io()).delay(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Object>() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity.AnonymousClass1 */

            public final void onNext(Object obj) {
            }

            public final void onError(Throwable th) {
                if ((Build.VERSION.SDK_INT < 17 || !MessageCenterSettingActivity.this.isDestroyed()) && !MessageCenterSettingActivity.this.isFinishing()) {
                    MessageCenterSettingActivity.this.updateView(true);
                    MessageCenterSettingActivity.this.dismissProcessDialog();
                    izb.O000000o(MessageCenterSettingActivity.this, (int) R.string.home_set_failed, 0).show();
                }
            }

            public final void onComplete() {
                if ((Build.VERSION.SDK_INT < 17 || !MessageCenterSettingActivity.this.isDestroyed()) && !MessageCenterSettingActivity.this.isFinishing()) {
                    MessageCenterSettingActivity messageCenterSettingActivity = MessageCenterSettingActivity.this;
                    messageCenterSettingActivity.mData = messageCenterSettingActivity.mTempData;
                    MessageCenterSettingActivity.this.updateView(true);
                    MessageCenterSettingActivity.this.dismissProcessDialog();
                }
            }
        });
    }

    public void updateView(boolean z) {
        Param param;
        MsgCenterSettingData msgCenterSettingData = this.mData;
        if (msgCenterSettingData != null && (param = msgCenterSettingData.param) != null) {
            this.pushDeviceItemBtn.setChecked(param.scene == 1);
            this.deviceShareItemBtn.setChecked(param.deviceShare == 1);
            this.familyInvitationBtn.setChecked(param.familyShare == 1);
            this.shopItemBtn.setChecked(param.shop == 1);
            this.pushSilentItemBtn.setChecked(param.noInterrupt == 1);
            if (this.pushSilentItemBtn.isChecked()) {
                this.pushSilentTimeItemTitle.setTextColor(getResources().getColor(R.color.mj_color_black_100_transparent));
                this.pushSilentTimeItemTitle.setEnabled(true);
                this.pushSilentTimeItem.setEnabled(true);
            } else {
                this.pushSilentTimeItemTitle.setTextColor(getResources().getColor(R.color.mj_color_gray_normal));
                this.pushSilentTimeItemTitle.setEnabled(false);
                this.pushSilentTimeItem.setEnabled(false);
            }
            NoInterruptTime noInterruptTime = param.noInterruptTime;
            if (noInterruptTime != null) {
                From from = noInterruptTime.from;
                To to = noInterruptTime.to;
                if (!(from == null || to == null)) {
                    CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
                    corntabParam.O00000o0 = from.hour;
                    corntabParam.O00000Oo = from.min;
                    CorntabUtils.CorntabParam O00000Oo = CorntabUtils.O00000Oo(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), corntabParam);
                    CorntabUtils.CorntabParam corntabParam2 = new CorntabUtils.CorntabParam();
                    corntabParam2.O00000o0 = to.hour;
                    corntabParam2.O00000Oo = to.min;
                    CorntabUtils.CorntabParam O00000Oo2 = CorntabUtils.O00000Oo(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), corntabParam2);
                    String formatTime = InterruptPushTimerSettingActiviy.formatTime(O00000Oo.O00000o0, O00000Oo.O00000Oo);
                    String formatTime2 = InterruptPushTimerSettingActiviy.formatTime(O00000Oo2.O00000o0, O00000Oo2.O00000Oo);
                    if (z) {
                        hxk hxk = hxi.O00000o;
                        StringBuilder sb = new StringBuilder();
                        sb.append(formatTime);
                        sb.append("~");
                        sb.append(formatTime2);
                        hxk.f952O000000o.O000000o("notification_settinglist_freetime_click", "start_time", formatTime, "end_time", formatTime2, "switch", Integer.valueOf(sb.toString().equals(this.pushSilentTimeTv.getText().toString()) ^ true ? 1 : 0));
                    }
                    this.pushSilentTimeTv.setText(formatTime + "~" + formatTime2);
                }
            }
            int i = 8;
            this.pushHomeDeviceItem.setVisibility(param.scene == 1 ? 0 : 8);
            gge.O000000o();
            boolean z2 = !gge.O00000oO().isEmpty();
            ListItemView listItemView = this.pushShareDeviceItem;
            if (z2) {
                i = 0;
            }
            listItemView.setVisibility(i);
        }
    }

    private void O000000o() {
        this.f9928O000000o = new XQProgressDialog(this);
        this.f9928O000000o.setMessage(getResources().getString(R.string.loading_share_info));
        this.f9928O000000o.setCancelable(true);
        this.f9928O000000o.show();
        this.f9928O000000o.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity.AnonymousClass6 */

            public final void onDismiss(DialogInterface dialogInterface) {
            }
        });
    }

    public void dismissProcessDialog() {
        XQProgressDialog xQProgressDialog = this.f9928O000000o;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }
}
