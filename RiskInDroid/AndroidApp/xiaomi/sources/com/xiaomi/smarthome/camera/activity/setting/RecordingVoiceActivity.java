package com.xiaomi.smarthome.camera.activity.setting;

import _m_j.chw;
import _m_j.cia;
import _m_j.cin;
import _m_j.civ;
import _m_j.g;
import _m_j.gqg;
import _m_j.gwg;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.IStreamCmdMessageListener;
import com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity;
import com.xiaomi.smarthome.camera.activity.CommandTreatment;
import com.xiaomi.smarthome.camera.activity.SPUtil;
import com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity;
import com.xiaomi.smarthome.camera.activity.setting.bean.Desc;
import com.xiaomi.smarthome.camera.activity.setting.bean.GetLeavMsgData;
import com.xiaomi.smarthome.camera.activity.setting.bean.LeaveMsg;
import com.xiaomi.smarthome.camera.activity.setting.record.GlobalParam;
import com.xiaomi.smarthome.camera.activity.setting.record.LeaveMsgManager;
import com.xiaomi.smarthome.camera.activity.setting.record.LeaveMsgUtil;
import com.xiaomi.smarthome.camera.activity.setting.record.PlayLeaveMsg;
import com.xiaomi.smarthome.camera.activity.setting.record.RecorderLeaveMsg;
import com.xiaomi.smarthome.camera.activity.voice.VoiceManager;
import com.xiaomi.smarthome.camera.view.calendar.DateUtils;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class RecordingVoiceActivity extends CameraPlayerBaseActivity implements cia, View.OnClickListener, IStreamCmdMessageListener {
    public static final String TAG = "RecordingVoiceActivity";
    public ArrayList<LeaveMsg> allMsgs = new ArrayList<>();
    public AnimationDrawable animationDrawable;
    public LeaveMsg bindMsg;
    public int currentPosition;
    public boolean edited = false;
    private ImageView iv_loading;
    private ImageView iv_record_voice;
    public ImageView iv_speak_animation;
    public String key;
    public LeaveMsgAdapter leaveMsgAdapter;
    private RecyclerView leave_msg_recycler_view;
    public LinearLayout ll_record_empty;
    public LinearLayout ll_record_failed;
    public LinearLayout ll_record_loading;
    public LinearLayout ll_record_short;
    public LinearLayout ll_record_success;
    public LinearLayout ll_recording;
    private Animation loadAnimation;
    public VoiceManager mVoiceManager;
    public ArrayList<LeaveMsg> msgs = new ArrayList<>();
    public Handler myHandler = new Handler(Looper.getMainLooper()) {
        /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass7 */

        public void handleMessage(Message message) {
            if (message.what == 1000) {
                String str = (String) message.obj;
                long j = (long) message.arg1;
                civ.O00000o(RecordingVoiceActivity.TAG, "totalTime=".concat(String.valueOf(j)));
                if (j < 1) {
                    civ.O00000o(RecordingVoiceActivity.TAG, "录制时间太短小于1s");
                    return;
                }
                RecordingVoiceActivity.this.clearRecord();
                String O000000o2 = cin.O000000o(System.currentTimeMillis(), RecordingVoiceActivity.this.getResources());
                final long j2 = j;
                final String str2 = O000000o2;
                final String str3 = str;
                LeaveMsgManager.getInstance(RecordingVoiceActivity.this.activity()).putData(RecordingVoiceActivity.this.mCameraDevice, j2, str, O000000o2, new Callback<Object>() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass7.AnonymousClass1 */

                    public void onSuccess(Object obj) {
                        if (!RecordingVoiceActivity.this.isFinishing()) {
                            LeaveMsg leaveMsg = new LeaveMsg();
                            leaveMsg.itemId = ((Long) obj).longValue();
                            leaveMsg.descObj = new Desc();
                            leaveMsg.descObj.duration = j2 * 1000;
                            leaveMsg.descObj.name = str2;
                            RecordingVoiceActivity.this.msgs.add(leaveMsg);
                            RecordingVoiceActivity.this.allMsgs.add(leaveMsg);
                            RecordingVoiceActivity.this.edited = true;
                            RecordingVoiceActivity.this.refreshUINew();
                            LeaveMsgManager.getInstance(RecordingVoiceActivity.this.activity()).addDownLoadItem(leaveMsg.itemId, str3, RecordingVoiceActivity.this.mCameraDevice.getDid());
                            RecordingVoiceActivity.this.mVoiceManager.sendRecordVoiceSuccess(leaveMsg.itemId, RecordingVoiceActivity.this);
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!RecordingVoiceActivity.this.isFinishing()) {
                            RecordingVoiceActivity.this.rl_voice_tip.setVisibility(0);
                            RecordingVoiceActivity.this.ll_record_failed.setVisibility(0);
                            RecordingVoiceActivity.this.ll_record_success.setVisibility(8);
                            RecordingVoiceActivity.this.ll_record_short.setVisibility(8);
                            RecordingVoiceActivity.this.ll_recording.setVisibility(8);
                            RecordingVoiceActivity.this.ll_record_loading.setVisibility(8);
                            RecordingVoiceActivity.this.myHandler.postDelayed(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0051: INVOKE  
                                  (wrap: android.os.Handler : 0x0048: IGET  (r3v24 android.os.Handler) = 
                                  (wrap: com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity : 0x0046: IGET  (r3v23 com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity) = 
                                  (wrap: com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7 : 0x0044: IGET  (r3v22 com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7) = (r2v0 'this' com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7$1 A[THIS]) com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.7.1.this$1 com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7)
                                 com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.7.this$0 com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity)
                                 com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.myHandler android.os.Handler)
                                  (wrap: com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$7$1$mEqGXuKJst86NKsD-TGWm2qJr0I : 0x004c: CONSTRUCTOR  (r4v3 com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$7$1$mEqGXuKJst86NKsD-TGWm2qJr0I) = (r2v0 'this' com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7$1 A[THIS]) call: com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$7$1$mEqGXuKJst86NKsD-TGWm2qJr0I.<init>(com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7$1):void type: CONSTRUCTOR)
                                  (1000 long)
                                 type: VIRTUAL call: android.os.Handler.postDelayed(java.lang.Runnable, long):boolean in method: com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.7.1.onFailure(int, java.lang.String):void, dex: classes3.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:97)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:481)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	at jadx.core.codegen.ClassGen.addInsnBody(ClassGen.java:456)
                                	at jadx.core.codegen.ClassGen.addField(ClassGen.java:397)
                                	at jadx.core.codegen.ClassGen.addFields(ClassGen.java:367)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:245)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004c: CONSTRUCTOR  (r4v3 com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$7$1$mEqGXuKJst86NKsD-TGWm2qJr0I) = (r2v0 'this' com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7$1 A[THIS]) call: com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$7$1$mEqGXuKJst86NKsD-TGWm2qJr0I.<init>(com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7$1):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.7.1.onFailure(int, java.lang.String):void, dex: classes3.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 94 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$7$1$mEqGXuKJst86NKsD-TGWm2qJr0I, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 100 more
                                */
                            /*
                                this = this;
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7 r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass7.this
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.this
                                boolean r3 = r3.isFinishing()
                                if (r3 == 0) goto L_0x000b
                                return
                            L_0x000b:
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7 r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass7.this
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.this
                                android.widget.RelativeLayout r3 = r3.rl_voice_tip
                                r4 = 0
                                r3.setVisibility(r4)
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7 r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass7.this
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.this
                                android.widget.LinearLayout r3 = r3.ll_record_failed
                                r3.setVisibility(r4)
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7 r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass7.this
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.this
                                android.widget.LinearLayout r3 = r3.ll_record_success
                                r4 = 8
                                r3.setVisibility(r4)
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7 r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass7.this
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.this
                                android.widget.LinearLayout r3 = r3.ll_record_short
                                r3.setVisibility(r4)
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7 r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass7.this
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.this
                                android.widget.LinearLayout r3 = r3.ll_recording
                                r3.setVisibility(r4)
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7 r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass7.this
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.this
                                android.widget.LinearLayout r3 = r3.ll_record_loading
                                r3.setVisibility(r4)
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$7 r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass7.this
                                com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity r3 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.this
                                android.os.Handler r3 = r3.myHandler
                                com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$7$1$mEqGXuKJst86NKsD-TGWm2qJr0I r4 = new com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$7$1$mEqGXuKJst86NKsD-TGWm2qJr0I
                                r4.<init>(r2)
                                r0 = 1000(0x3e8, double:4.94E-321)
                                r3.postDelayed(r4, r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass7.AnonymousClass1.onFailure(int, java.lang.String):void");
                        }

                        public /* synthetic */ void lambda$onFailure$0$RecordingVoiceActivity$7$1() {
                            RecordingVoiceActivity.this.rl_voice_tip.setVisibility(8);
                        }
                    });
                }
            }
        };
        long onVoiceBtnClickDownTime = 0;
        private String[] permitArray = {"android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE"};
        public TextView record_time_tv;
        public RecorderLeaveMsg recorderLeaveMsg;
        public TextView recording_voice;
        public RelativeLayout rl_voice_tip;
        public long startTime;
        Runnable timerRunnable = new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass6 */

            public void run() {
                int currentTimeMillis = (int) ((System.currentTimeMillis() - RecordingVoiceActivity.this.startTime) / 1000);
                civ.O00000o(RecordingVoiceActivity.TAG, "duration===".concat(String.valueOf(currentTimeMillis)));
                if (currentTimeMillis >= 6) {
                    RecordingVoiceActivity.this.onClickRecord();
                    return;
                }
                String timeFromNum = DateUtils.getTimeFromNum(currentTimeMillis);
                civ.O00000o(RecordingVoiceActivity.TAG, "timerRunnable timeFromNum=".concat(String.valueOf(timeFromNum)));
                String removeRepeat = RecordingVoiceActivity.this.removeRepeat(timeFromNum);
                if (removeRepeat.contains("6")) {
                    civ.O00000o(RecordingVoiceActivity.TAG, "录音的时间大于6s,强制转为5s");
                    RecordingVoiceActivity.this.record_time_tv.setText("00:05");
                } else {
                    RecordingVoiceActivity.this.record_time_tv.setText(removeRepeat);
                }
                RecordingVoiceActivity.this.myHandler.postDelayed(RecordingVoiceActivity.this.timerRunnable, 133);
            }
        };

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
            setContentView((int) R.layout.setting_record_voice_activity);
            this.key = getIntent().getExtras().getString("SETTING_KEY_MAIN");
            this.recorderLeaveMsg = new RecorderLeaveMsg(activity(), this.myHandler, this.mCameraDevice);
            initView();
            intData();
            this.mVoiceManager = new VoiceManager(this.mCameraDevice, this);
        }

        public void onResume() {
            super.onResume();
            civ.O00000o(TAG, "onResume....");
            this.mCameraPlayerEx = new chw(this.mCameraDevice, this);
        }

        public void onPause() {
            super.onPause();
            this.mCameraPlayerEx.O0000O0o();
            this.mCameraPlayerEx = null;
            onStopRecord();
        }

        private void initView() {
            findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass1 */

                public void onClick(View view) {
                    RecordingVoiceActivity.this.onBackPressed();
                }
            });
            ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.recording_voice);
            findViewById(R.id.tv_record_voice).setVisibility(8);
            this.recording_voice = (TextView) findViewById(R.id.recording_voice);
            this.rl_voice_tip = (RelativeLayout) findViewById(R.id.rl_voice_tip);
            this.ll_record_short = (LinearLayout) findViewById(R.id.ll_record_short);
            this.ll_record_success = (LinearLayout) findViewById(R.id.ll_record_success);
            this.ll_recording = (LinearLayout) findViewById(R.id.ll_recording);
            this.record_time_tv = (TextView) findViewById(R.id.record_time_tv);
            this.leave_msg_recycler_view = (RecyclerView) findViewById(R.id.leave_msg_recycler_view);
            this.leave_msg_recycler_view.setLayoutManager(new LinearLayoutManager(this));
            this.leaveMsgAdapter = new LeaveMsgAdapter();
            this.leave_msg_recycler_view.setAdapter(this.leaveMsgAdapter);
            this.ll_record_empty = (LinearLayout) findViewById(R.id.ll_record_empty);
            this.iv_record_voice = (ImageView) findViewById(R.id.iv_record_voice);
            this.iv_record_voice.setOnTouchListener(new View.OnTouchListener() {
                /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass2 */

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        civ.O00000o(RecordingVoiceActivity.TAG, "MotionEvent.ACTION_DOWN");
                        RecordingVoiceActivity.this.onVoiceBtnClickDownTime = System.currentTimeMillis();
                        RecordingVoiceActivity.this.rl_voice_tip.setVisibility(0);
                        RecordingVoiceActivity.this.ll_record_short.setVisibility(8);
                        RecordingVoiceActivity.this.ll_record_success.setVisibility(8);
                        RecordingVoiceActivity.this.ll_recording.setVisibility(0);
                        RecordingVoiceActivity.this.ll_record_loading.setVisibility(8);
                        RecordingVoiceActivity.this.ll_record_failed.setVisibility(8);
                        RecordingVoiceActivity recordingVoiceActivity = RecordingVoiceActivity.this;
                        recordingVoiceActivity.animationDrawable = (AnimationDrawable) recordingVoiceActivity.iv_speak_animation.getDrawable();
                        RecordingVoiceActivity.this.animationDrawable.start();
                    } else if (motionEvent.getAction() == 1) {
                        civ.O00000o(RecordingVoiceActivity.TAG, "MotionEvent.ACTION_UP");
                        if (System.currentTimeMillis() - RecordingVoiceActivity.this.onVoiceBtnClickDownTime < 1000) {
                            civ.O00000o(RecordingVoiceActivity.TAG, "MotionEvent.ACTION_UP 小于1s");
                            RecordingVoiceActivity.this.onStopRecord();
                            RecordingVoiceActivity.this.rl_voice_tip.setVisibility(0);
                            RecordingVoiceActivity.this.ll_record_short.setVisibility(0);
                            RecordingVoiceActivity.this.ll_record_success.setVisibility(8);
                            RecordingVoiceActivity.this.ll_recording.setVisibility(8);
                            RecordingVoiceActivity.this.ll_record_loading.setVisibility(8);
                            RecordingVoiceActivity.this.ll_record_failed.setVisibility(8);
                            RecordingVoiceActivity recordingVoiceActivity2 = RecordingVoiceActivity.this;
                            recordingVoiceActivity2.animationDrawable = (AnimationDrawable) recordingVoiceActivity2.iv_speak_animation.getDrawable();
                            RecordingVoiceActivity.this.animationDrawable.stop();
                            RecordingVoiceActivity.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.activity.setting.$$Lambda$RecordingVoiceActivity$2$BAifSauioaaXRBLXqDDgcH08_0 */

                                public final void run() {
                                    RecordingVoiceActivity.AnonymousClass2.this.lambda$onTouch$0$RecordingVoiceActivity$2();
                                }
                            }, 1000);
                        } else {
                            civ.O00000o(RecordingVoiceActivity.TAG, "MotionEvent.ACTION_UP 大于1s");
                            RecordingVoiceActivity.this.onStopRecord();
                            RecordingVoiceActivity.this.rl_voice_tip.setVisibility(0);
                            RecordingVoiceActivity.this.ll_record_short.setVisibility(8);
                            RecordingVoiceActivity.this.ll_recording.setVisibility(8);
                            RecordingVoiceActivity.this.ll_record_success.setVisibility(8);
                            RecordingVoiceActivity.this.ll_record_loading.setVisibility(0);
                            RecordingVoiceActivity.this.ll_record_failed.setVisibility(8);
                            RecordingVoiceActivity recordingVoiceActivity3 = RecordingVoiceActivity.this;
                            recordingVoiceActivity3.animationDrawable = (AnimationDrawable) recordingVoiceActivity3.iv_speak_animation.getDrawable();
                            RecordingVoiceActivity.this.animationDrawable.stop();
                        }
                    } else if (motionEvent.getAction() == 3) {
                        civ.O00000o(RecordingVoiceActivity.TAG, "MotionEvent.ACTION_CANCEL");
                        if (System.currentTimeMillis() - RecordingVoiceActivity.this.onVoiceBtnClickDownTime < 1000) {
                            civ.O00000o(RecordingVoiceActivity.TAG, "MotionEvent.ACTION_UP 小于1s");
                            RecordingVoiceActivity.this.onStopRecord();
                            RecordingVoiceActivity.this.rl_voice_tip.setVisibility(0);
                            RecordingVoiceActivity.this.ll_record_short.setVisibility(0);
                            RecordingVoiceActivity.this.ll_record_success.setVisibility(8);
                            RecordingVoiceActivity.this.ll_recording.setVisibility(8);
                            RecordingVoiceActivity.this.ll_record_loading.setVisibility(8);
                            RecordingVoiceActivity.this.ll_record_failed.setVisibility(8);
                            RecordingVoiceActivity recordingVoiceActivity4 = RecordingVoiceActivity.this;
                            recordingVoiceActivity4.animationDrawable = (AnimationDrawable) recordingVoiceActivity4.iv_speak_animation.getDrawable();
                            RecordingVoiceActivity.this.animationDrawable.stop();
                            RecordingVoiceActivity.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.activity.setting.$$Lambda$RecordingVoiceActivity$2$MmLjBvZwmClhgRmq0JLuz1vokA */

                                public final void run() {
                                    RecordingVoiceActivity.AnonymousClass2.this.lambda$onTouch$1$RecordingVoiceActivity$2();
                                }
                            }, 1000);
                        } else {
                            civ.O00000o(RecordingVoiceActivity.TAG, "MotionEvent.ACTION_UP 大于1s");
                            RecordingVoiceActivity.this.onStopRecord();
                            RecordingVoiceActivity.this.rl_voice_tip.setVisibility(8);
                            RecordingVoiceActivity.this.ll_record_short.setVisibility(8);
                            RecordingVoiceActivity.this.ll_recording.setVisibility(8);
                            RecordingVoiceActivity.this.ll_record_success.setVisibility(8);
                            RecordingVoiceActivity.this.ll_record_loading.setVisibility(8);
                            RecordingVoiceActivity.this.ll_record_failed.setVisibility(8);
                            RecordingVoiceActivity recordingVoiceActivity5 = RecordingVoiceActivity.this;
                            recordingVoiceActivity5.animationDrawable = (AnimationDrawable) recordingVoiceActivity5.iv_speak_animation.getDrawable();
                            RecordingVoiceActivity.this.animationDrawable.stop();
                            RecordingVoiceActivity.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.activity.setting.$$Lambda$RecordingVoiceActivity$2$80kyOjCEBbOWAGWrvozUulMfLo */

                                public final void run() {
                                    RecordingVoiceActivity.AnonymousClass2.this.lambda$onTouch$2$RecordingVoiceActivity$2();
                                }
                            }, 1000);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        civ.O00000o(RecordingVoiceActivity.TAG, "MotionEvent.ACTION_MOVE");
                    }
                    return false;
                }

                public /* synthetic */ void lambda$onTouch$0$RecordingVoiceActivity$2() {
                    civ.O00000o(RecordingVoiceActivity.TAG, "1s之后消失");
                    RecordingVoiceActivity.this.rl_voice_tip.setVisibility(8);
                }

                public /* synthetic */ void lambda$onTouch$1$RecordingVoiceActivity$2() {
                    civ.O00000o(RecordingVoiceActivity.TAG, "1s之后消失");
                    RecordingVoiceActivity.this.rl_voice_tip.setVisibility(8);
                }

                public /* synthetic */ void lambda$onTouch$2$RecordingVoiceActivity$2() {
                    civ.O00000o(RecordingVoiceActivity.TAG, "1s之后消失");
                    RecordingVoiceActivity.this.rl_voice_tip.setVisibility(8);
                }
            });
            this.iv_record_voice.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass3 */

                public boolean onLongClick(View view) {
                    civ.O00000o(RecordingVoiceActivity.TAG, "setOnLongClickListener");
                    RecordingVoiceActivity.this.recording();
                    return false;
                }
            });
            this.iv_speak_animation = (ImageView) findViewById(R.id.iv_speak_animation);
            this.iv_loading = (ImageView) findViewById(R.id.iv_loading);
            this.loadAnimation = AnimationUtils.loadAnimation(activity(), R.anim.anim_rotate_loading);
            Animation animation = this.loadAnimation;
            if (animation != null) {
                this.iv_loading.startAnimation(animation);
            }
            this.ll_record_loading = (LinearLayout) findViewById(R.id.ll_record_loading);
            this.ll_record_failed = (LinearLayout) findViewById(R.id.ll_record_failed);
        }

        private void intData() {
            String str = (String) SPUtil.getInstance(activity(), this.mCameraDevice.getDid()).get("KEY_LEAVE_MSGS", "");
            if (!TextUtils.isEmpty(str)) {
                civ.O00000o(TAG, "msgsJson=".concat(String.valueOf(str)));
                this.allMsgs = ((GetLeavMsgData) GlobalParam.gGson.fromJson(str, GetLeavMsgData.class)).resultList;
            }
            LeaveMsgManager.getInstance(activity()).getAllMsgs().clear();
            LeaveMsgManager.getInstance(activity()).getData(this.mCameraDevice, 0, 10, new Callback<Object>() {
                /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass4 */

                public void onSuccess(Object obj) {
                    if (!RecordingVoiceActivity.this.isFinishing()) {
                        civ.O00000o(RecordingVoiceActivity.TAG, "获取录音数据成功");
                        RecordingVoiceActivity.this.ll_record_empty.setVisibility(8);
                        RecordingVoiceActivity.this.msgs.clear();
                        RecordingVoiceActivity.this.msgs.addAll(LeaveMsgManager.getInstance(RecordingVoiceActivity.this.activity()).getAllMsgs());
                        String str = RecordingVoiceActivity.TAG;
                        civ.O00000o(str, "msgs=" + RecordingVoiceActivity.this.msgs.size());
                        if (RecordingVoiceActivity.this.msgs == null || RecordingVoiceActivity.this.msgs.size() <= 0) {
                            RecordingVoiceActivity.this.ll_record_empty.setVisibility(0);
                            return;
                        }
                        RecordingVoiceActivity.this.leaveMsgAdapter.notifyDataSetChanged();
                        RecordingVoiceActivity.this.recording_voice.setText(RecordingVoiceActivity.this.getString(R.string.re_recording));
                        RecordingVoiceActivity.this.ll_record_empty.setVisibility(8);
                        if ("AUTO_PLAY_RECORD".equals(RecordingVoiceActivity.this.key)) {
                            RecordingVoiceActivity recordingVoiceActivity = RecordingVoiceActivity.this;
                            recordingVoiceActivity.bindMsg = recordingVoiceActivity.msgs.get(0);
                            RecordingVoiceActivity recordingVoiceActivity2 = RecordingVoiceActivity.this;
                            recordingVoiceActivity2.currentPosition = 0;
                            recordingVoiceActivity2.mVoiceManager.voiceAudition(RecordingVoiceActivity.this);
                        }
                        Iterator<LeaveMsg> it = RecordingVoiceActivity.this.msgs.iterator();
                        while (it.hasNext()) {
                            LeaveMsg next = it.next();
                            if (!RecordingVoiceActivity.this.containsByItemId(next.itemId)) {
                                RecordingVoiceActivity recordingVoiceActivity3 = RecordingVoiceActivity.this;
                                recordingVoiceActivity3.edited = true;
                                recordingVoiceActivity3.allMsgs.add(next);
                            }
                        }
                    }
                }

                public void onFailure(int i, String str) {
                    if (!RecordingVoiceActivity.this.isFinishing()) {
                        String str2 = RecordingVoiceActivity.TAG;
                        civ.O00000o(str2, "getData onFailure=" + i + str);
                        RecordingVoiceActivity.this.ll_record_empty.setVisibility(0);
                    }
                }
            });
        }

        public boolean containsByItemId(long j) {
            for (int size = this.allMsgs.size() - 1; size >= 0; size--) {
                LeaveMsg leaveMsg = this.allMsgs.get(size);
                civ.O00000o(TAG, j + "=" + leaveMsg.itemId);
                if (leaveMsg.itemId == j) {
                    return true;
                }
            }
            return false;
        }

        public void removeByItemId(long j) {
            this.edited = true;
            for (int size = this.allMsgs.size() - 1; size >= 0; size--) {
                LeaveMsg leaveMsg = this.allMsgs.get(size);
                if (leaveMsg.itemId == j) {
                    this.allMsgs.remove(leaveMsg);
                    return;
                }
            }
        }

        public void onClick(View view) {
            if (view.getId() != R.id.ll_record_voice) {
                return;
            }
            if (XmPluginHostApi.instance().getApiLevel() >= 75) {
                XmPluginHostApi.instance().checkAndRequestPermisson(activity(), true, new Callback<List<String>>() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass5 */

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((List<String>) ((List) obj));
                    }

                    public void onSuccess(List<String> list) {
                        if (!RecordingVoiceActivity.this.isFinishing()) {
                            civ.O00000Oo(RecordingVoiceActivity.TAG, "checkAndRequestPermisson onSuccess");
                            RecordingVoiceActivity.this.onClickRecord();
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!RecordingVoiceActivity.this.isFinishing()) {
                            RecordingVoiceActivity.this.activity();
                            gqg.O000000o((int) R.string.file_permission_denied);
                            RecordingVoiceActivity.this.rl_voice_tip.setVisibility(8);
                        }
                    }
                }, this.permitArray);
            } else if (g.O000000o(activity(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                activity();
                gqg.O000000o((int) R.string.file_permission_denied);
                this.rl_voice_tip.setVisibility(8);
            } else if (g.O000000o(activity(), "android.permission.RECORD_AUDIO") != 0) {
                activity();
                gqg.O000000o((int) R.string.audio_permission_denied);
                this.rl_voice_tip.setVisibility(8);
            } else {
                onClickRecord();
            }
        }

        public void onClickRecord() {
            if (!this.recorderLeaveMsg.isRecording()) {
                this.rl_voice_tip.setVisibility(0);
                this.ll_recording.setVisibility(0);
                this.ll_record_short.setVisibility(8);
                this.ll_record_failed.setVisibility(8);
                this.ll_record_success.setVisibility(8);
                this.ll_record_loading.setVisibility(8);
                this.recorderLeaveMsg.startRecord();
                this.startTime = System.currentTimeMillis();
                this.record_time_tv.setVisibility(0);
                this.record_time_tv.setText("00:00");
                this.myHandler.postDelayed(this.timerRunnable, 868);
                this.animationDrawable = (AnimationDrawable) this.iv_speak_animation.getDrawable();
                this.animationDrawable.start();
                return;
            }
            onStopRecord();
        }

        public void onStopRecord() {
            if (this.recorderLeaveMsg.isRecording()) {
                this.myHandler.removeCallbacks(this.timerRunnable);
                this.recorderLeaveMsg.stop();
                this.record_time_tv.setVisibility(8);
                this.rl_voice_tip.setVisibility(0);
                this.ll_record_success.setVisibility(8);
                this.ll_record_short.setVisibility(8);
                this.ll_recording.setVisibility(8);
                this.ll_record_failed.setVisibility(8);
                this.ll_record_loading.setVisibility(0);
                this.animationDrawable = (AnimationDrawable) this.iv_speak_animation.getDrawable();
                this.animationDrawable.stop();
            }
        }

        public void refreshUINew() {
            this.leaveMsgAdapter.notifyDataSetChanged();
        }

        public void onServerCmd(int i, byte[] bArr) {
            civ.O00000o(TAG, "录制声音页 CommandTreatment onServerCmd type=".concat(String.valueOf(i)));
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

        public void onSendCmdError() {
            civ.O00000o(TAG, "onSendCmdError");
            this.myHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass8 */

                public void run() {
                    RecordingVoiceActivity.this.rl_voice_tip.setVisibility(0);
                    RecordingVoiceActivity.this.ll_record_failed.setVisibility(0);
                    RecordingVoiceActivity.this.ll_record_success.setVisibility(8);
                    RecordingVoiceActivity.this.ll_record_short.setVisibility(8);
                    RecordingVoiceActivity.this.ll_recording.setVisibility(8);
                    RecordingVoiceActivity.this.ll_record_loading.setVisibility(8);
                }
            });
            this.myHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass9 */

                public void run() {
                    RecordingVoiceActivity.this.rl_voice_tip.setVisibility(8);
                }
            }, 1000);
        }

        class LeaveMsgAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
            public boolean globalIsPlaying = false;

            LeaveMsgAdapter() {
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
             arg types: [?, android.view.ViewGroup, int]
             candidates:
              ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
              ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
            public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new LeaveMsgViewHolder(LayoutInflater.from(RecordingVoiceActivity.this.activity()).inflate((int) R.layout.camera_item_leave_msg, viewGroup, false));
            }

            public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                long j;
                RecordingVoiceActivity recordingVoiceActivity = RecordingVoiceActivity.this;
                recordingVoiceActivity.currentPosition = i;
                LeaveMsgViewHolder leaveMsgViewHolder = (LeaveMsgViewHolder) o000OOo0;
                recordingVoiceActivity.bindMsg = recordingVoiceActivity.msgs.get(i);
                Desc desc = RecordingVoiceActivity.this.bindMsg.descObj;
                leaveMsgViewHolder.tv_msg_content.setText(desc == null ? RecordingVoiceActivity.this.bindMsg.desc : desc.name);
                if (desc == null) {
                    j = 0;
                } else {
                    j = desc.duration / 1000;
                }
                if (j < 10) {
                    leaveMsgViewHolder.duration_tv.setText(String.format(Locale.getDefault(), "00:0%d", Long.valueOf(j)));
                } else {
                    leaveMsgViewHolder.duration_tv.setText(String.format(Locale.getDefault(), "00:%d", Long.valueOf(j)));
                }
                if (RecordingVoiceActivity.this.bindMsg.isPlaying) {
                    leaveMsgViewHolder.duration_tv.setTextColor(RecordingVoiceActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                    leaveMsgViewHolder.tv_msg_content.setTextColor(RecordingVoiceActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                    leaveMsgViewHolder.icon_msg_play.setImageResource(R.drawable.icon_leave_msg_stop);
                } else {
                    leaveMsgViewHolder.duration_tv.setTextColor(RecordingVoiceActivity.this.getResources().getColor(R.color.mj_color_black_40_transparent));
                    leaveMsgViewHolder.tv_msg_content.setTextColor(RecordingVoiceActivity.this.getResources().getColor(R.color.mj_color_black));
                    leaveMsgViewHolder.icon_msg_play.setImageResource(R.drawable.icon_leave_msg_play);
                }
                leaveMsgViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.AnonymousClass1 */

                    public void onClick(View view) {
                        if (!LeaveMsgAdapter.this.globalIsPlaying && !RecordingVoiceActivity.this.recorderLeaveMsg.isRecording()) {
                            civ.O00000o(RecordingVoiceActivity.TAG, "发送了 个性语音试听功能");
                            RecordingVoiceActivity.this.mVoiceManager.voiceAudition(RecordingVoiceActivity.this);
                        }
                    }
                });
            }

            /* access modifiers changed from: package-private */
            public void palyRecord(final LeaveMsg leaveMsg, final int i) {
                String str = RecordingVoiceActivity.TAG;
                civ.O00000o(str, "播放的录音路径=" + LeaveMsgUtil.getAudioFilePath(RecordingVoiceActivity.this.mCameraDevice.getDid(), leaveMsg.itemId));
                new PlayLeaveMsg(RecordingVoiceActivity.this.activity(), LeaveMsgUtil.getAudioFilePath(RecordingVoiceActivity.this.mCameraDevice.getDid(), leaveMsg.itemId)).startPlay(new PlayLeaveMsg.PlayListener() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.AnonymousClass2 */

                    public void onPlaying() {
                        LeaveMsgAdapter leaveMsgAdapter = LeaveMsgAdapter.this;
                        leaveMsgAdapter.globalIsPlaying = true;
                        leaveMsg.isPlaying = true;
                        RecordingVoiceActivity.this.myHandler.post(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
                              (wrap: android.os.Handler : 0x000b: IGET  (r0v2 android.os.Handler) = 
                              (wrap: com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity : 0x0009: IGET  (r0v1 com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity) = (r0v0 'leaveMsgAdapter' com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter) com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.this$0 com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity)
                             com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.myHandler android.os.Handler)
                              (wrap: com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$mtTrWE3ihXgKV0_CRMR3IIW1PkI : 0x0011: CONSTRUCTOR  (r2v1 com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$mtTrWE3ihXgKV0_CRMR3IIW1PkI) = 
                              (r3v0 'this' com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter$2 A[THIS])
                              (wrap: int : 0x000d: IGET  (r1v1 int) = (r3v0 'this' com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter$2 A[THIS]) com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.2.val$position int)
                             call: com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$mtTrWE3ihXgKV0_CRMR3IIW1PkI.<init>(com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter$2, int):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.2.onPlaying():void, dex: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR  (r2v1 com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$mtTrWE3ihXgKV0_CRMR3IIW1PkI) = 
                              (r3v0 'this' com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter$2 A[THIS])
                              (wrap: int : 0x000d: IGET  (r1v1 int) = (r3v0 'this' com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter$2 A[THIS]) com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.2.val$position int)
                             call: com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$mtTrWE3ihXgKV0_CRMR3IIW1PkI.<init>(com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter$2, int):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.2.onPlaying():void, dex: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 79 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$mtTrWE3ihXgKV0_CRMR3IIW1PkI, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 85 more
                            */
                        /*
                            this = this;
                            com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter r0 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.this
                            r1 = 1
                            r0.globalIsPlaying = r1
                            com.xiaomi.smarthome.camera.activity.setting.bean.LeaveMsg r2 = r6
                            r2.isPlaying = r1
                            com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity r0 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.this
                            android.os.Handler r0 = r0.myHandler
                            int r1 = r7
                            com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$mtTrWE3ihXgKV0_CRMR3IIW1PkI r2 = new com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$mtTrWE3ihXgKV0_CRMR3IIW1PkI
                            r2.<init>(r3, r1)
                            r0.post(r2)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.AnonymousClass2.onPlaying():void");
                    }

                    public /* synthetic */ void lambda$onPlaying$0$RecordingVoiceActivity$LeaveMsgAdapter$2(int i) {
                        LeaveMsgAdapter.this.notifyItemChanged(i);
                    }

                    public void onStop() {
                        LeaveMsgAdapter leaveMsgAdapter = LeaveMsgAdapter.this;
                        leaveMsgAdapter.globalIsPlaying = false;
                        leaveMsg.isPlaying = false;
                        RecordingVoiceActivity.this.myHandler.post(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
                              (wrap: android.os.Handler : 0x000b: IGET  (r0v2 android.os.Handler) = 
                              (wrap: com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity : 0x0009: IGET  (r0v1 com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity) = (r0v0 'leaveMsgAdapter' com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter) com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.this$0 com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity)
                             com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.myHandler android.os.Handler)
                              (wrap: com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$YDcf6JPh6Z8mLwdIjd-To5SAsIo : 0x0011: CONSTRUCTOR  (r2v1 com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$YDcf6JPh6Z8mLwdIjd-To5SAsIo) = 
                              (r3v0 'this' com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter$2 A[THIS])
                              (wrap: int : 0x000d: IGET  (r1v1 int) = (r3v0 'this' com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter$2 A[THIS]) com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.2.val$position int)
                             call: com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$YDcf6JPh6Z8mLwdIjd-To5SAsIo.<init>(com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter$2, int):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.2.onStop():void, dex: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR  (r2v1 com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$YDcf6JPh6Z8mLwdIjd-To5SAsIo) = 
                              (r3v0 'this' com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter$2 A[THIS])
                              (wrap: int : 0x000d: IGET  (r1v1 int) = (r3v0 'this' com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter$2 A[THIS]) com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.2.val$position int)
                             call: com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$YDcf6JPh6Z8mLwdIjd-To5SAsIo.<init>(com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter$2, int):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.2.onStop():void, dex: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 79 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$YDcf6JPh6Z8mLwdIjd-To5SAsIo, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 85 more
                            */
                        /*
                            this = this;
                            com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity$LeaveMsgAdapter r0 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.this
                            r1 = 0
                            r0.globalIsPlaying = r1
                            com.xiaomi.smarthome.camera.activity.setting.bean.LeaveMsg r2 = r6
                            r2.isPlaying = r1
                            com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity r0 = com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.this
                            android.os.Handler r0 = r0.myHandler
                            int r1 = r7
                            com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$YDcf6JPh6Z8mLwdIjd-To5SAsIo r2 = new com.xiaomi.smarthome.camera.activity.setting.-$$Lambda$RecordingVoiceActivity$LeaveMsgAdapter$2$YDcf6JPh6Z8mLwdIjd-To5SAsIo
                            r2.<init>(r3, r1)
                            r0.post(r2)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.LeaveMsgAdapter.AnonymousClass2.onStop():void");
                    }

                    public /* synthetic */ void lambda$onStop$1$RecordingVoiceActivity$LeaveMsgAdapter$2(int i) {
                        LeaveMsgAdapter.this.notifyItemChanged(i);
                    }
                });
            }

            public int getItemCount() {
                return RecordingVoiceActivity.this.msgs.size();
            }

            class LeaveMsgViewHolder extends RecyclerView.O000OOo0 {
                TextView duration_tv;
                ImageView icon_msg_play;
                TextView tv_msg_content;

                public LeaveMsgViewHolder(View view) {
                    super(view);
                    this.tv_msg_content = (TextView) view.findViewById(R.id.tv_msg_content);
                    this.duration_tv = (TextView) view.findViewById(R.id.duration_tv);
                    this.icon_msg_play = (ImageView) view.findViewById(R.id.icon_msg_play);
                }
            }
        }

        public void onDestroy() {
            super.onDestroy();
            civ.O00000o(VoiceBroadCastActivity.TAG, "onDestroy.....");
            this.myHandler.removeCallbacksAndMessages(null);
            if (this.edited) {
                SPUtil.getInstance(activity(), this.mCameraDevice.getDid()).reSaveLeaveMsgs(this.allMsgs);
            }
        }

        public void onBackPressed() {
            super.onBackPressed();
            civ.O00000o(VoiceBroadCastActivity.TAG, "onBackPressed.....");
            this.myHandler.removeCallbacksAndMessages(null);
            SPUtil.getInstance(activity(), this.mCameraDevice.getDid()).reSaveLeaveMsgs(this.msgs);
        }

        public void clearRecord() {
            String str = TAG;
            civ.O00000o(str, "clearRecord msgs.size()=" + this.msgs.size());
            ArrayList<LeaveMsg> arrayList = this.msgs;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<LeaveMsg> it = this.msgs.iterator();
                while (it.hasNext()) {
                    final LeaveMsg next = it.next();
                    LeaveMsgManager.getInstance(activity()).removeItem(this.mCameraDevice, next.itemId, new Callback<Object>() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass10 */

                        public void onSuccess(Object obj) {
                            RecordingVoiceActivity.this.msgs.remove(next);
                            if (!RecordingVoiceActivity.this.isFinishing()) {
                                RecordingVoiceActivity.this.removeByItemId(next.itemId);
                                String audioFilePath = LeaveMsgUtil.getAudioFilePath(RecordingVoiceActivity.this.mCameraDevice.getDid(), next.itemId);
                                civ.O00000o(VoiceBroadCastActivity.TAG, "clearRecord fileName =".concat(String.valueOf(audioFilePath)));
                                File file = new File(audioFilePath);
                                if (file.exists()) {
                                    civ.O00000o(VoiceBroadCastActivity.TAG, "删除了 录音文件");
                                    file.delete();
                                    SPUtil.getInstance(RecordingVoiceActivity.this.activity(), RecordingVoiceActivity.this.mCameraDevice.getDid()).remove("KEY_LEAVE_MSGS");
                                }
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!RecordingVoiceActivity.this.isFinishing()) {
                                String str2 = RecordingVoiceActivity.TAG;
                                civ.O00000o(str2, "删除 onFailure i=" + i + ",s=" + str);
                            }
                        }
                    });
                }
            }
        }

        public void recording() {
            if (XmPluginHostApi.instance().getApiLevel() >= 75) {
                XmPluginHostApi.instance().checkAndRequestPermisson(activity(), true, new Callback<List<String>>() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity.AnonymousClass11 */

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((List<String>) ((List) obj));
                    }

                    public void onSuccess(List<String> list) {
                        if (!RecordingVoiceActivity.this.isFinishing()) {
                            civ.O00000Oo(RecordingVoiceActivity.TAG, "checkAndRequestPermisson onSuccess");
                            RecordingVoiceActivity.this.onClickRecord();
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!RecordingVoiceActivity.this.isFinishing()) {
                            RecordingVoiceActivity.this.activity();
                            gqg.O000000o((int) R.string.file_permission_denied);
                        }
                    }
                }, this.permitArray);
            } else if (g.O000000o(activity(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                activity();
                gqg.O000000o((int) R.string.file_permission_denied);
            } else if (g.O000000o(activity(), "android.permission.RECORD_AUDIO") != 0) {
                activity();
                gqg.O000000o((int) R.string.audio_permission_denied);
            } else {
                onClickRecord();
            }
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 21008) {
                int i2 = message.arg1;
                civ.O00000o(TAG, "result=".concat(String.valueOf(i2)));
                if (i2 == 1) {
                    this.rl_voice_tip.setVisibility(0);
                    this.ll_record_success.setVisibility(0);
                    this.ll_record_short.setVisibility(8);
                    this.ll_recording.setVisibility(8);
                    this.ll_record_failed.setVisibility(8);
                    this.ll_record_loading.setVisibility(8);
                    this.myHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.$$Lambda$RecordingVoiceActivity$WSy4xWJ1szV7sOwGTIqnlHX9so */

                        public final void run() {
                            RecordingVoiceActivity.this.lambda$handleMessage$0$RecordingVoiceActivity();
                        }
                    }, 1000);
                    this.recording_voice.setText(getString(R.string.re_recording));
                    this.ll_record_empty.setVisibility(8);
                } else if (i2 == 2) {
                    this.rl_voice_tip.setVisibility(0);
                    this.ll_record_failed.setVisibility(0);
                    this.ll_record_success.setVisibility(8);
                    this.ll_record_short.setVisibility(8);
                    this.ll_recording.setVisibility(8);
                    this.ll_record_loading.setVisibility(8);
                    clearRecord();
                    this.msgs.clear();
                    this.allMsgs.clear();
                    refreshUINew();
                    this.myHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.$$Lambda$RecordingVoiceActivity$fH6tITeT1mt7V5i9p_eJ55YAWJw */

                        public final void run() {
                            RecordingVoiceActivity.this.lambda$handleMessage$1$RecordingVoiceActivity();
                        }
                    }, 1000);
                }
            } else if (i == 210014) {
                civ.O00000o(TAG, "获取个性语音试听的状态");
                byte[] bArr = (byte[]) message.obj;
                if (bArr != null) {
                    byte b = bArr[0];
                    civ.O00000o(TAG, "获取个性语音试听的状态voiceState=".concat(String.valueOf((int) b)));
                    if (b == 1) {
                        this.leaveMsgAdapter.palyRecord(this.bindMsg, this.currentPosition);
                    } else if (b == 2) {
                        activity();
                        gqg.O000000o("未找到播放文件");
                    } else {
                        activity();
                        gqg.O000000o("正在播放");
                    }
                }
            }
        }

        public /* synthetic */ void lambda$handleMessage$0$RecordingVoiceActivity() {
            this.rl_voice_tip.setVisibility(8);
        }

        public /* synthetic */ void lambda$handleMessage$1$RecordingVoiceActivity() {
            this.rl_voice_tip.setVisibility(8);
        }

        public String removeRepeat(String str) {
            return str.length() > 5 ? str.substring(3) : str;
        }
    }
