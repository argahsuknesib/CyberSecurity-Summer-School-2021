package com.xiaomi.smarthome.camera.activity.setting;

import _m_j.chr;
import _m_j.chw;
import _m_j.cia;
import _m_j.civ;
import _m_j.cll;
import _m_j.gqg;
import _m_j.gwg;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.IStreamCmdMessageListener;
import com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity;
import com.xiaomi.smarthome.camera.activity.CommandTreatment;
import com.xiaomi.smarthome.camera.activity.SPUtil;
import com.xiaomi.smarthome.camera.activity.setting.bean.Desc;
import com.xiaomi.smarthome.camera.activity.setting.bean.LeaveMsg;
import com.xiaomi.smarthome.camera.activity.setting.record.LeaveMsgManager;
import com.xiaomi.smarthome.camera.activity.setting.record.LeaveMsgUtil;
import com.xiaomi.smarthome.camera.activity.voice.VoiceManager;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceBroadCastActivity extends CameraPlayerBaseActivity implements cia, View.OnClickListener, IStreamCmdMessageListener {
    public static final String TAG = "VoiceBroadCastActivity";
    public ArrayList<LeaveMsg> allMsgs = new ArrayList<>();
    public long deviceVoiceId;
    TextView duration_tv;
    private boolean isOpenBroadCast = false;
    public LinearLayout ll_record_empty;
    private VoiceManager mVoiceManager;
    public ArrayList<LeaveMsg> msgs = new ArrayList<>();
    public RelativeLayout rl_play;
    private TextView tv_automatic_broadcast;
    TextView tv_msg_content;
    private TextView tv_record_voice;

    public void detectSDCard() {
    }

    public void doResume() {
    }

    public boolean isHistory() {
        return false;
    }

    public void onDisconnectedWithCode(int i) {
    }

    public void refreshUI() {
    }

    public void resumeCamera() {
    }

    public void startPlay() {
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        gwg.O00000Oo(getWindow());
        setContentView((int) R.layout.camera_setting_voice_broadcast_activity);
        initView();
        this.mVoiceManager = new VoiceManager(this.mCameraDevice, this);
    }

    private void initView() {
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.VoiceBroadCastActivity.AnonymousClass1 */

            public void onClick(View view) {
                VoiceBroadCastActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.setting_voice_broadcast);
        this.tv_record_voice = (TextView) findViewById(R.id.tv_record_voice);
        this.tv_record_voice.setOnClickListener(this);
        this.ll_record_empty = (LinearLayout) findViewById(R.id.ll_record_empty);
        this.tv_msg_content = (TextView) findViewById(R.id.tv_msg_content);
        this.duration_tv = (TextView) findViewById(R.id.duration_tv);
        this.rl_play = (RelativeLayout) findViewById(R.id.rl_play);
        this.rl_play.setOnClickListener(this);
        this.tv_automatic_broadcast = (TextView) findViewById(R.id.tv_automatic_broadcast);
        this.tv_automatic_broadcast.setOnClickListener(this);
        this.ll_record_empty.setVisibility(0);
        this.rl_play.setVisibility(8);
    }

    public void initData() {
        LeaveMsgManager.getInstance(activity()).getData(this.mCameraDevice, 0, 10, new Callback<Object>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.VoiceBroadCastActivity.AnonymousClass2 */

            public void onSuccess(Object obj) {
                long j;
                VoiceBroadCastActivity.this.allMsgs.clear();
                VoiceBroadCastActivity.this.msgs.clear();
                VoiceBroadCastActivity.this.msgs.addAll(LeaveMsgManager.getInstance(VoiceBroadCastActivity.this.activity()).getAllMsgs());
                String str = VoiceBroadCastActivity.TAG;
                civ.O00000o(str, "获取录音数据成功msgs.size()=" + VoiceBroadCastActivity.this.msgs.size());
                if (VoiceBroadCastActivity.this.msgs.size() > 0) {
                    VoiceBroadCastActivity.this.rl_play.setVisibility(0);
                    VoiceBroadCastActivity.this.ll_record_empty.setVisibility(8);
                } else {
                    VoiceBroadCastActivity.this.rl_play.setVisibility(8);
                    VoiceBroadCastActivity.this.ll_record_empty.setVisibility(0);
                }
                Iterator<LeaveMsg> it = VoiceBroadCastActivity.this.msgs.iterator();
                while (it.hasNext()) {
                    LeaveMsg next = it.next();
                    if (!VoiceBroadCastActivity.this.containsByItemId(next.itemId)) {
                        civ.O00000o(VoiceBroadCastActivity.TAG, "云上的个性语音Id和固件上的语音ID不一致，删除");
                        VoiceBroadCastActivity.this.clearRecord(next);
                    } else {
                        VoiceBroadCastActivity.this.allMsgs.add(next);
                    }
                }
                String str2 = VoiceBroadCastActivity.TAG;
                civ.O00000o(str2, "获取录音数据成功allMsgs.size()=" + VoiceBroadCastActivity.this.allMsgs.size());
                if (VoiceBroadCastActivity.this.allMsgs == null || VoiceBroadCastActivity.this.allMsgs.size() <= 0) {
                    VoiceBroadCastActivity.this.ll_record_empty.setVisibility(0);
                    VoiceBroadCastActivity.this.rl_play.setVisibility(8);
                    return;
                }
                LeaveMsg leaveMsg = VoiceBroadCastActivity.this.allMsgs.get(0);
                Desc desc = leaveMsg.descObj;
                VoiceBroadCastActivity.this.tv_msg_content.setText(desc == null ? leaveMsg.desc : desc.name);
                if (desc == null) {
                    j = 0;
                } else {
                    j = desc.duration / 1000;
                }
                if (j < 10) {
                    VoiceBroadCastActivity.this.duration_tv.setText(String.format(Locale.getDefault(), "00:0%d", Long.valueOf(j)));
                } else {
                    VoiceBroadCastActivity.this.duration_tv.setText(String.format(Locale.getDefault(), "00:%d", Long.valueOf(j)));
                }
                VoiceBroadCastActivity.this.ll_record_empty.setVisibility(8);
                VoiceBroadCastActivity.this.rl_play.setVisibility(0);
            }

            public void onFailure(int i, String str) {
                VoiceBroadCastActivity.this.ll_record_empty.setVisibility(0);
                VoiceBroadCastActivity.this.rl_play.setVisibility(8);
            }
        });
        this.mVoiceManager.getVoiceState(this);
    }

    public boolean containsByItemId(long j) {
        String str = TAG;
        civ.O00000o(str, j + "=" + this.deviceVoiceId);
        return this.deviceVoiceId == j;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_record_voice) {
            Intent intent = new Intent(this, RecordingVoiceActivity.class);
            intent.putExtra("SETTING_KEY_MAIN", "MANUAL_PLAY_RECORD");
            startActivity(intent);
        } else if (id == R.id.rl_play) {
            Intent intent2 = new Intent(this, RecordingVoiceActivity.class);
            intent2.putExtra("SETTING_KEY_MAIN", "AUTO_PLAY_RECORD");
            startActivity(intent2);
        } else if (id == R.id.tv_automatic_broadcast) {
            ArrayList<LeaveMsg> arrayList = this.allMsgs;
            if (arrayList == null || arrayList.size() <= 0) {
                activity();
                gqg.O000000o(getString(R.string.no_broacast_content));
                return;
            }
            int i = 1;
            this.isOpenBroadCast = !this.isOpenBroadCast;
            if (this.isOpenBroadCast) {
                activity();
                gqg.O000000o(getString(R.string.automatic_announcement_turned_on));
                this.tv_automatic_broadcast.setBackgroundResource(R.drawable.voice_broadcast_bg);
                this.tv_automatic_broadcast.setText(getString(R.string.close_automatic_announcement));
                if (Build.VERSION.SDK_INT >= 23) {
                    this.tv_automatic_broadcast.setTextColor(getColor(R.color.mj_color_white));
                }
                civ.O00000o(TAG, "开启语音播报");
                this.mVoiceManager.setVoiceState(1, 1, this);
            } else {
                activity();
                gqg.O000000o(getString(R.string.automatic_announcement_turned_off));
                this.tv_automatic_broadcast.setBackgroundResource(R.drawable.voice_broadcast_bg);
                this.tv_automatic_broadcast.setText(getString(R.string.open_automatic_announcement));
                if (Build.VERSION.SDK_INT >= 23) {
                    this.tv_automatic_broadcast.setTextColor(getColor(R.color.mj_color_white));
                }
                civ.O00000o(TAG, "关闭语音播报");
                this.mVoiceManager.setVoiceState(2, 1, this);
            }
            String str = chr.O00Oo0oO;
            if (!this.isOpenBroadCast) {
                i = 2;
            }
            chr.O000000o(str, "type", String.valueOf(i));
        }
    }

    public void onResume() {
        super.onResume();
        civ.O00000o(TAG, "onResume....");
        getCustomVoiceInfo();
        this.mCameraPlayerEx = new chw(this.mCameraDevice, this);
    }

    public void onPause() {
        super.onPause();
        this.mCameraPlayerEx.O0000O0o();
        this.mCameraPlayerEx = null;
    }

    public void onServerCmd(int i, byte[] bArr) {
        civ.O00000o(TAG, "延时摄影详情页 CommandTreatment onServerCmd type=".concat(String.valueOf(i)));
        new CommandTreatment(this.mHandler, this.mCameraDevice).processData(bArr);
    }

    public void onConnected() {
        super.onConnected();
        civ.O00000o(TAG, "摄像头连接成功，授权+校准时间");
        if (this.mCameraPlayerEx != null && this.mCameraDevice != null && this.mCameraDevice.O0000oOO()) {
            this.mCameraPlayerEx.O0000Oo();
            this.mCameraPlayerEx.O0000Oo0();
        }
    }

    public void handleMessage(Message message) {
        byte[] bArr;
        super.handleMessage(message);
        int i = message.what;
        if (i == 21009) {
            byte[] bArr2 = (byte[]) message.obj;
            if (bArr2 != null && bArr2.length >= 3) {
                byte b = bArr2[0];
                byte b2 = bArr2[1];
                byte b3 = bArr2[2];
                if (b2 == 1) {
                    this.isOpenBroadCast = true;
                    refreshVoiceUI(true);
                } else {
                    this.isOpenBroadCast = false;
                    refreshVoiceUI(false);
                }
                String str = TAG;
                civ.O00000o(str, "获取个性语音播报的状态 fileExist=" + ((int) b) + ",isOpen=" + ((int) b2) + ",playScence=" + ((int) b3));
            }
        } else if (i == 210010 && (bArr = (byte[]) message.obj) != null && bArr.length > 0) {
            civ.O00000o(TAG, "设置个性语音播报的状态 result=".concat(String.valueOf((int) bArr[0])));
        }
    }

    private void refreshVoiceUI(boolean z) {
        if (z) {
            this.tv_automatic_broadcast.setBackgroundResource(R.drawable.voice_broadcast_bg);
            this.tv_automatic_broadcast.setText(getString(R.string.close_automatic_announcement));
            if (Build.VERSION.SDK_INT >= 23) {
                this.tv_automatic_broadcast.setTextColor(getColor(R.color.mj_color_white));
                return;
            }
            return;
        }
        this.tv_automatic_broadcast.setBackgroundResource(R.drawable.voice_broadcast_bg);
        this.tv_automatic_broadcast.setText(getString(R.string.open_automatic_announcement));
        if (Build.VERSION.SDK_INT >= 23) {
            this.tv_automatic_broadcast.setTextColor(getColor(R.color.mj_color_white));
        }
    }

    private void getCustomVoiceInfo() {
        if (this.mCameraDevice != null && this.mCameraDevice.O000000o() != null) {
            cll O000000o2 = this.mCameraDevice.O000000o();
            AnonymousClass3 r1 = new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.activity.setting.VoiceBroadCastActivity.AnonymousClass3 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(JSONObject jSONObject) {
                    try {
                        String str = VoiceBroadCastActivity.TAG;
                        civ.O00000o(str, "jsonObject==" + jSONObject.toString());
                        String optString = jSONObject.optString("fileId");
                        civ.O00000o(VoiceBroadCastActivity.TAG, "fileId==".concat(String.valueOf(optString)));
                        if (!TextUtils.isEmpty(optString)) {
                            VoiceBroadCastActivity.this.deviceVoiceId = Long.parseLong(optString);
                        }
                        civ.O00000o(VoiceBroadCastActivity.TAG, "long fileId==".concat(String.valueOf(optString)));
                        VoiceBroadCastActivity.this.initData();
                    } catch (Exception unused) {
                    }
                }
            };
            O000000o2.O00000o0.callMethod("getCustomVoiceInfo", new JSONArray(), new Callback<JSONObject>(r1) {
                /* class _m_j.cll.AnonymousClass8 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Callback f14081O000000o;

                {
                    this.f14081O000000o = r2;
                }

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Callback callback = this.f14081O000000o;
                    if (callback != null) {
                        callback.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(int i, String str) {
                    Callback callback = this.f14081O000000o;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            }, new Parser<JSONObject>() {
                /* class _m_j.cll.AnonymousClass9 */

                public final /* synthetic */ Object parse(String str) throws JSONException {
                    civ.O000000o("CameraProperties", "getCustomVoiceInfo result=".concat(String.valueOf(str)));
                    return new JSONObject(str);
                }
            });
        }
    }

    public void clearRecord(final LeaveMsg leaveMsg) {
        LeaveMsgManager.getInstance(activity()).removeItem(this.mCameraDevice, leaveMsg.itemId, new Callback<Object>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.VoiceBroadCastActivity.AnonymousClass4 */

            public void onSuccess(Object obj) {
                VoiceBroadCastActivity.this.msgs.remove(leaveMsg);
                VoiceBroadCastActivity.this.removeByItemId(leaveMsg.itemId);
                String audioFilePath = LeaveMsgUtil.getAudioFilePath(VoiceBroadCastActivity.this.mCameraDevice.getDid(), leaveMsg.itemId);
                civ.O00000o(VoiceBroadCastActivity.TAG, "clearRecord fileName =".concat(String.valueOf(audioFilePath)));
                File file = new File(audioFilePath);
                if (file.exists()) {
                    civ.O00000o(VoiceBroadCastActivity.TAG, "删除了 录音文件");
                    file.delete();
                    SPUtil.getInstance(VoiceBroadCastActivity.this.activity(), VoiceBroadCastActivity.this.mCameraDevice.getDid()).remove("KEY_LEAVE_MSGS");
                    VoiceBroadCastActivity.this.msgs.clear();
                }
            }

            public void onFailure(int i, String str) {
                String str2 = VoiceBroadCastActivity.TAG;
                civ.O00000o(str2, "删除 onFailure i=" + i + ",s=" + str);
            }
        });
    }

    public void removeByItemId(long j) {
        for (int size = this.allMsgs.size() - 1; size >= 0; size--) {
            LeaveMsg leaveMsg = this.allMsgs.get(size);
            if (leaveMsg.itemId == j) {
                this.allMsgs.remove(leaveMsg);
                return;
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onSendCmdError() {
        civ.O00000o(TAG, "onSendCmdError");
    }
}
