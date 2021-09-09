package _m_j;

import _m_j.ggb;
import _m_j.hod;
import _m_j.hof;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.IXmPluginHostActivity;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueDefinition;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueList;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecEvent;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.operation.js_sdk.OperationCommonWebViewActivity;
import com.xiaomi.smarthome.scene.NFCLiteAutomationChooseScene;
import com.xiaomi.smarthome.scene.SceneTabSwitcher;
import com.xiaomi.smarthome.scene.activity.CommonSceneOnline;
import com.xiaomi.smarthome.scene.activity.DeviceSceneActivityNew;
import com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActivity;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerActivity;
import com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity;
import com.xiaomi.smarthome.scene.pluginrecommend.LightActionStartActivity;
import com.xiaomi.smarthome.scene.timer.CommonTimerListActivity;
import com.xiaomi.smarthome.scene.timer.CountDownTimerActivity;
import com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage;
import com.xiaomi.smarthome.scene.ui.rec.initdevice.InitDeviceRecSpecSceneActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RouterService
public class hon implements hol {
    public boolean isSupportGeo() {
        return false;
    }

    public void updateScene15(String str) {
        hod.O0000OoO().O00000o();
    }

    public boolean isLiteSceneInited() {
        return hpr.O00000o0().O00000oO;
    }

    public void updateLiteScene() {
        hpr.O00000o0().O00000Oo();
    }

    public void updateLiteScene(final hny hny) {
        hpr.O00000o0().O000000o(new hny() {
            /* class _m_j.hon.AnonymousClass1 */

            public final void onRefreshScenceSuccess(int i) {
                hny hny = hny;
                if (hny != null) {
                    hny.onRefreshScenceSuccess(i);
                }
            }

            public final void onRefreshScenceFailed(int i) {
                hny hny = hny;
                if (hny != null) {
                    hny.onRefreshScenceFailed(i);
                }
            }
        });
    }

    public void setCurrentStepInCreateSceneManager(int i) {
        hpq.O000000o().O0000Oo0 = i;
    }

    public void clearCreateSceneManager() {
        hpq.O000000o().O00000o0();
    }

    public void setSceneInCreateSceneManager(Object obj) {
        hpq.O000000o().O000000o((SceneApi.O000OOOo) obj);
    }

    public void clearSceneManager() {
        hod.O0000OoO();
        hod.O0000Ooo();
    }

    public void clearLiteSceneManager() {
        hpr.O00000o0();
        hpr.O00000o();
    }

    public void clearRecommendSceneManager() {
        hpu O000000o2 = hpu.O000000o();
        if (hpu.O00000o0 != null) {
            hpu.O00000o0.O00000Oo = null;
            O000000o2.O0000O0o = false;
        }
    }

    public void clearInitDeviceRecommendSceneHelper() {
        hrj.O000000o().f562O000000o.clear();
    }

    public void updateTemplate() {
        hod.O0000OoO().O00000o0();
    }

    public Intent getIntentFrom(Context context, String str, String str2) {
        hps.O000000o();
        return hps.O000000o(context, str, str2);
    }

    public void getPluginRecommendSceneInitDevice(String str, String str2, fsm<ArrayList<hog>, fso> fsm) {
        hrj.O000000o().O000000o(str, str2, fsm);
    }

    public void updateCustomScene(String str, final hny hny) {
        if (hny != null) {
            hod.O0000OoO().O000000o(new hny() {
                /* class _m_j.hon.AnonymousClass2 */

                public final void onRefreshScenceSuccess(int i) {
                    hny.onRefreshScenceSuccess(i);
                }

                public final void onRefreshScenceFailed(int i) {
                    hny.onRefreshScenceFailed(i);
                }
            });
        } else {
            hod.O0000OoO().O00000o();
        }
    }

    public void clearScenedata() {
        hod.O0000OoO().O0000o00();
    }

    public boolean isShowRecSceneInitDeviceStep(Device device) {
        return hrj.O000000o().O00000Oo();
    }

    public void startInitDeviceRecSpecSceneActivity(Context context, Intent intent) {
        Intent intent2 = new Intent(context, InitDeviceRecSpecSceneActivity.class);
        intent2.putExtras(intent);
        context.startActivity(intent2);
    }

    public void startDeviceSceneNewActivity(Context context, Intent intent) {
        Intent intent2 = new Intent(context, DeviceSceneActivityNew.class);
        intent2.putExtras(intent);
        context.startActivity(intent2);
    }

    public Class<?> getDeviceSceneActivity() {
        return DeviceSceneActivityNew.class;
    }

    public int getLiteSceneSize() {
        return hpr.O00000o0().O0000O0o.size();
    }

    public void replaceLiteScene(CommonUsedScene commonUsedScene) {
        hpr O00000o0 = hpr.O00000o0();
        if (commonUsedScene != null) {
            int i = 0;
            while (i < O00000o0.O0000O0o.size()) {
                try {
                    if (commonUsedScene.f11134O000000o == Long.parseLong(O00000o0.O0000O0o.get(i).f11131O000000o)) {
                        O00000o0.O0000O0o.get(i).O00000Oo = commonUsedScene.O00000Oo;
                        return;
                    }
                    i++;
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    public boolean toSceneListTabInSceneTab() {
        return SceneTabSwitcher.INSTANCE.toSceneListTab();
    }

    public void showNotifyOpenGuideDialogForSmartInSceneTab() {
        SceneTabSwitcher.INSTANCE.showNotifyOpenGuideDialogForSmart();
    }

    public int getCustomSceneSizeByDid(String str) {
        if (!hod.O0000OoO().O00000oo) {
            return 0;
        }
        return hod.O0000OoO().O000000o(str).size();
    }

    public int getLiteSceneSizeByDid(String str) {
        if (!hpr.O00000o0().O00000oO) {
            return 0;
        }
        hpr O00000o0 = hpr.O00000o0();
        ArrayList arrayList = new ArrayList();
        if (O00000o0.O00000oO && O00000o0.O0000O0o != null) {
            for (int i = 0; i < O00000o0.O0000O0o.size(); i++) {
                if (O00000o0.O0000O0o.get(i).O0000O0o != null) {
                    int i2 = 0;
                    while (true) {
                        if (i2 < (O00000o0.O0000O0o.get(i).O00000oo == null ? 0 : O00000o0.O0000O0o.get(i).O00000oo.size())) {
                            if (O00000o0.O0000O0o.get(i).O00000oo.get(i2).f11120O000000o == SceneApi.Action.ACTION_TYPE.TYPE_DEVICE.value && O00000o0.O0000O0o.get(i).O00000oo.get(i2).O0000O0o != null && TextUtils.equals(str, O00000o0.O0000O0o.get(i).O00000oo.get(i2).O0000O0o.O00000o)) {
                                arrayList.add(O00000o0.O0000O0o.get(i));
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return arrayList.size();
    }

    public void unregisterLiteSceneCallback(hny hny) {
        hpr.O00000o0().O00000o0(hny);
    }

    public void unregisterCustomSceneCallback(hny hny) {
        hod.O0000OoO().O00000o0(hny);
    }

    public boolean isSceneManagerInited() {
        return hod.O0000OoO().O00000oo;
    }

    public boolean isLiteSceneManagerInited() {
        return hpr.O00000o0().O00000oO;
    }

    public int getCachedCustomSceneSize() {
        return hod.O0000OoO().O0000o00.size();
    }

    public List<SceneInfo> getSceneInfosByDid(String str) {
        List<SceneApi.O000OOOo> list = hod.O0000OoO().f416O000000o;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (SceneApi.O000OOOo next : list) {
                boolean z = false;
                if (next.O00000o < 1000 || next.O00000o > 1003) {
                    Iterator<SceneApi.O000000o> it = next.O0000O0o.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        SceneApi.O000000o next2 = it.next();
                        if (next2.f11121O000000o == LAUNCH_TYPE.DEVICE && next2.O00000o0 != null && TextUtils.equals(next2.O00000o0.f11122O000000o, str)) {
                            arrayList.add(hod.O00000o(next));
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        Iterator<SceneApi.Action> it2 = next.O00000oo.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            SceneApi.Action next3 = it2.next();
                            if (!TextUtils.isEmpty(next3.O0000O0o.O00000o) && next3.O0000O0o.O00000o.equalsIgnoreCase(str)) {
                                arrayList.add(hod.O00000o(next));
                                break;
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public SceneInfo getSceneInfo(JSONObject jSONObject, boolean z) {
        SceneApi.O000OOOo o000OOOo;
        try {
            o000OOOo = SceneApi.O000OOOo.O000000o(jSONObject, z);
        } catch (JSONException e) {
            e.printStackTrace();
            o000OOOo = null;
        }
        if (o000OOOo == null) {
            return null;
        }
        return hod.O00000o(o000OOOo);
    }

    public void destroySceneManager() {
        hod O0000OoO = hod.O0000OoO();
        O0000OoO.O0000o00();
        hpf O000000o2 = hpf.O000000o();
        hpf.f464O000000o = null;
        O000000o2.O00000Oo.clear();
        hod.O00oOooO = null;
        try {
            if (O0000OoO.O0000o0o != null) {
                O0000OoO.O0000o0o.removeCallbacksAndMessages(null);
            }
            O0000OoO.O0000Ooo.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroyLiteSceneManager() {
        hpr O00000o0 = hpr.O00000o0();
        gsy.O00000Oo(hpr.f481O000000o, "destroy");
        hpr.O0000o0 = null;
        try {
            if (O00000o0.O0000Oo != null) {
                O00000o0.O0000Oo.removeCallbacksAndMessages(null);
            }
            O00000o0.O00000oo.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroyRecSceneManager() {
        hpu.O000000o();
        hpu.O00000Oo();
    }

    public void setNeedGotoMySceneFirst(boolean z) {
        hpu.O000000o().O0000Ooo = z;
    }

    public void startPluginRecScene(Context context, Intent intent) {
        Intent intent2 = new Intent(context, PluginRecommendSceneActivity.class);
        intent2.putExtras(intent);
        context.startActivity(intent2);
    }

    public void startCreateAutoScene(Context context, Intent intent) {
        Intent intent2 = new Intent(context, SmarthomeCreateAutoSceneActivity.class);
        intent2.putExtras(intent);
        context.startActivity(intent2);
    }

    public void startEditScene(Context context, Intent intent) {
        Intent intent2 = new Intent(context, SmartHomeSceneCreateEditActivity.class);
        intent2.putExtras(intent);
        context.startActivity(intent2);
    }

    public void startCommonTimer(Context context, Intent intent) {
        Intent intent2 = new Intent(context, CommonTimerListActivity.class);
        intent2.putExtras(intent);
        context.startActivity(intent2);
    }

    public void startCountDownTimer(Context context, Intent intent) {
        Intent intent2 = new Intent(context, CountDownTimerActivity.class);
        intent2.putExtras(intent);
        context.startActivity(intent2);
    }

    public void updatePluginRecommendScenes(String str, IXmPluginHostActivity.AsyncCallback<String> asyncCallback) {
        hob.O000000o().O000000o(ServiceApplication.getAppContext(), 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: INVOKE  
              (wrap: _m_j.hob : 0x0004: INVOKE  (r0v0 _m_j.hob) =  type: STATIC call: _m_j.hob.O000000o():_m_j.hob)
              (wrap: android.content.Context : 0x0008: INVOKE  (r1v0 android.content.Context) =  type: STATIC call: com.xiaomi.smarthome.application.ServiceApplication.getAppContext():android.content.Context)
              (wrap: _m_j.hpu$4 : 0x000e: CONSTRUCTOR  (r2v0 _m_j.hpu$4) = 
              (wrap: _m_j.hpu : 0x0000: INVOKE  (r4v1 _m_j.hpu) =  type: STATIC call: _m_j.hpu.O000000o():_m_j.hpu)
              (r5v0 'asyncCallback' com.xiaomi.smarthome.device.api.IXmPluginHostActivity$AsyncCallback<java.lang.String>)
             call: _m_j.hpu.4.<init>(_m_j.hpu, com.xiaomi.smarthome.device.api.IXmPluginHostActivity$AsyncCallback):void type: CONSTRUCTOR)
             type: VIRTUAL call: _m_j.hob.O000000o(android.content.Context, _m_j.fsm):_m_j.fsn in method: _m_j.hon.updatePluginRecommendScenes(java.lang.String, com.xiaomi.smarthome.device.api.IXmPluginHostActivity$AsyncCallback<java.lang.String>):void, dex: classes.dex
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
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: CONSTRUCTOR  (r2v0 _m_j.hpu$4) = 
              (wrap: _m_j.hpu : 0x0000: INVOKE  (r4v1 _m_j.hpu) =  type: STATIC call: _m_j.hpu.O000000o():_m_j.hpu)
              (r5v0 'asyncCallback' com.xiaomi.smarthome.device.api.IXmPluginHostActivity$AsyncCallback<java.lang.String>)
             call: _m_j.hpu.4.<init>(_m_j.hpu, com.xiaomi.smarthome.device.api.IXmPluginHostActivity$AsyncCallback):void type: CONSTRUCTOR in method: _m_j.hon.updatePluginRecommendScenes(java.lang.String, com.xiaomi.smarthome.device.api.IXmPluginHostActivity$AsyncCallback<java.lang.String>):void, dex: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 31 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.hpu, state: NOT_LOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 37 more
            */
        /*
            this = this;
            _m_j.hpu r4 = _m_j.hpu.O000000o()
            _m_j.hob r0 = _m_j.hob.O000000o()
            android.content.Context r1 = com.xiaomi.smarthome.application.ServiceApplication.getAppContext()
            _m_j.hpu$4 r2 = new _m_j.hpu$4
            r2.<init>(r5)
            r0.O000000o(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.hon.updatePluginRecommendScenes(java.lang.String, com.xiaomi.smarthome.device.api.IXmPluginHostActivity$AsyncCallback):void");
    }

    public void createAndSaveSceneFrom(PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem, String str, hqy hqy) {
        hpt.O000000o(recommendSceneItem, str, hqy);
    }

    public void startRecommendSceneDetailActivityBy(Activity activity, String str, int i) {
        if (TextUtils.isEmpty(str) || i < 1000 || activity == null) {
            return;
        }
        if (i / 1000 == 2) {
            Intent intent = new Intent(activity, CreateSceneFromRecommendActivity.class);
            intent.putExtra("sr_id", i);
            intent.putExtra("did", str);
            activity.startActivity(intent);
            return;
        }
        switch (i) {
            case 1000:
                Intent intent2 = new Intent(activity, PluginRecommendSceneActivity.class);
                intent2.putExtra("sr_id", i);
                intent2.putExtra("did", str);
                activity.startActivity(intent2);
                return;
            case 1001:
            case 1002:
            case 1003:
                Intent intent3 = new Intent(activity, LightActionStartActivity.class);
                intent3.putExtra("sr_id", i);
                intent3.putExtra("did", str);
                activity.startActivity(intent3);
                return;
            default:
                return;
        }
    }

    public boolean isLvMiModel(String str) {
        return hnw.O00000o(str);
    }

    public String getDegreeConfig(String str) {
        hod O0000OoO = hod.O0000OoO();
        if (!O0000OoO.O0000o0O.containsKey(str)) {
            return null;
        }
        hod.O000000o o000000o = O0000OoO.O0000o0O.get(str);
        if (ftl.O00000Oo()) {
            return o000000o.f429O000000o;
        }
        return o000000o.O00000Oo;
    }

    public String getSpecValue(Device device, SpecProperty specProperty, String str, Object obj) {
        return faw.O000000o().getValueName(device, specProperty, null, null);
    }

    public Class<?> getPluginRecommendSceneActivityClass() {
        return PluginRecommendSceneActivity.class;
    }

    public Class<?> getOperationCommonWebViewActivityClass() {
        return OperationCommonWebViewActivity.class;
    }

    public void miioSceneUpdate(Context context, String str, String str2, boolean z, fsm fsm) {
        SceneApi.O000OOOo O00000Oo = hod.O0000OoO().O00000Oo(str);
        O00000Oo.O00000Oo = str2;
        O00000Oo.O0000Oo0 = z;
        hob.O000000o().O000000o(O00000Oo, fsm);
    }

    public boolean getSceneOnline(String str, String str2) {
        CommonSceneOnline O00000Oo = hod.O0000OoO().O00000Oo(str, str2);
        return (O00000Oo == null || O00000Oo.O00000o == null || O00000Oo.O00000o.size() <= 0) ? false : true;
    }

    public void startNFCActionChoose(Context context, Intent intent) {
        Intent intent2 = new Intent(context, NFCLiteAutomationChooseScene.class);
        intent2.putExtras(intent);
        context.startActivity(intent2);
    }

    public List<Device> getDevicesByHomeId(String str) {
        Home O0000Oo0 = TextUtils.isEmpty(str) ? ggb.O00000Oo().O0000Oo0() : ggb.O00000Oo().O00000o(str);
        if (O0000Oo0 == null) {
            return null;
        }
        return ggb.O00000Oo().O0000Oo(O0000Oo0.getId());
    }

    public void saveHome(String str, String str2, String str3, String str4, String str5, final Callback callback) {
        Home O0000Oo0 = TextUtils.isEmpty(str) ? ggb.O00000Oo().O0000Oo0() : ggb.O00000Oo().O00000o(str);
        if (O0000Oo0 != null) {
            O0000Oo0.setLatitude(str5);
            O0000Oo0.setLongitude(str4);
            O0000Oo0.setAddr(str3);
            if (!TextUtils.isEmpty(str2)) {
                O0000Oo0.setLocationId(str2);
            }
            ggb.O00000Oo().O000000o(O0000Oo0, new ggb.O00000o() {
                /* class _m_j.hon.AnonymousClass3 */

                public final void O000000o() {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(null);
                    }
                }

                public final void O000000o(int i, fso fso) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                    }
                }
            });
            ggb.O00000Oo().O0000o();
        } else if (callback != null) {
            callback.onFailure(-1, "home is null");
        }
    }

    public JSONObject getHome(String str) {
        Home O0000Oo0 = TextUtils.isEmpty(str) ? ggb.O00000Oo().O0000Oo0() : ggb.O00000Oo().O00000o(str);
        if (O0000Oo0 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("home_id", O0000Oo0.getId());
            jSONObject.put("home_name", O0000Oo0.getRawName());
            jSONObject.put("home_addr", O0000Oo0.getAddr());
            jSONObject.put("home_lat", O0000Oo0.getLatitude());
            jSONObject.put("home_lat", O0000Oo0.getLongitude());
            jSONObject.put("homd_city_id", O0000Oo0.getLocationId());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public boolean lockCanVisible(Device device) {
        if (device == null) {
            return false;
        }
        return hri.O000000o(device, "2.1.7");
    }

    public SpecDevice getSpecDeviceBy(Device device) {
        if (device == null) {
            return null;
        }
        return faw.O000000o().getSpecInstance(device);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00da A[EDGE_INSN: B:38:0x00da->B:32:0x00da ?: BREAK  , SYNTHETIC] */
    public List<String> filterDidsIncludeSpecSource(List<String> list, String str) {
        SpecDevice specInstance;
        int indexOf;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str2 = list.get(i);
            Device O000000o2 = fno.O000000o().O000000o(str2);
            if (O000000o2 != null && (specInstance = faw.O000000o().getSpecInstance(O000000o2)) != null) {
                boolean z = false;
                for (Map.Entry next : specInstance.getServices().entrySet()) {
                    if (str.startsWith("event")) {
                        int indexOf2 = str.indexOf(":");
                        if (indexOf2 < str.length()) {
                            String substring = str.substring(indexOf2 + 1);
                            Iterator<Map.Entry<Integer, SpecEvent>> it = ((SpecService) next.getValue()).getEvents().entrySet().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (TextUtils.equals(((SpecEvent) it.next().getValue()).getTypeName(), substring)) {
                                        arrayList.add(str2);
                                        break;
                                    }
                                } else {
                                    continue;
                                    break;
                                }
                            }
                        } else {
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    } else {
                        if (str.startsWith("prop") && (indexOf = str.indexOf(":")) < str.length()) {
                            String substring2 = str.substring(indexOf + 1);
                            Iterator<Map.Entry<Integer, SpecProperty>> it2 = ((SpecService) next.getValue()).getProperties().entrySet().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (TextUtils.equals(((SpecProperty) it2.next().getValue()).getTypeName(), substring2)) {
                                        arrayList.add(str2);
                                        break;
                                    }
                                } else {
                                    continue;
                                    break;
                                }
                            }
                        }
                        if (z) {
                        }
                    }
                    z = true;
                    continue;
                    if (z) {
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00dc A[EDGE_INSN: B:37:0x00dc->B:31:0x00dc ?: BREAK  , SYNTHETIC] */
    public List<String> filterDidsExcludeSpecSource(List<String> list, String str) {
        SpecDevice specInstance;
        int indexOf;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        for (int size = list.size() - 1; size >= 0; size--) {
            boolean z = false;
            Device O000000o2 = fno.O000000o().O000000o(list.get(size));
            if (O000000o2 != null && (specInstance = faw.O000000o().getSpecInstance(O000000o2)) != null) {
                for (Map.Entry next : specInstance.getServices().entrySet()) {
                    if (str.startsWith("event")) {
                        int indexOf2 = str.indexOf(":");
                        if (indexOf2 < str.length()) {
                            String substring = str.substring(indexOf2 + 1);
                            Iterator<Map.Entry<Integer, SpecEvent>> it = ((SpecService) next.getValue()).getEvents().entrySet().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (TextUtils.equals(((SpecEvent) it.next().getValue()).getTypeName(), substring)) {
                                        arrayList.remove(size);
                                        break;
                                    }
                                } else {
                                    continue;
                                    break;
                                }
                            }
                        } else {
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    } else {
                        if (str.startsWith("prop") && (indexOf = str.indexOf(":")) < str.length()) {
                            String substring2 = str.substring(indexOf + 1);
                            Iterator<Map.Entry<Integer, SpecProperty>> it2 = ((SpecService) next.getValue()).getProperties().entrySet().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (TextUtils.equals(((SpecProperty) it2.next().getValue()).getTypeName(), substring2)) {
                                        arrayList.remove(size);
                                        break;
                                    }
                                } else {
                                    continue;
                                    break;
                                }
                            }
                        }
                        if (z) {
                        }
                    }
                    z = true;
                    continue;
                    if (z) {
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061 A[LOOP:0: B:1:0x0007->B:17:0x0061, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064 A[EDGE_INSN: B:20:0x0064->B:18:0x0064 ?: BREAK  , SYNTHETIC] */
    public List<String> filterDidsIncludeSpecDeviceService(List<String> list, String str, String str2) {
        boolean z;
        SpecDevice specInstance;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            String str3 = list.get(i);
            Device O000000o2 = fno.O000000o().O000000o(str3);
            if (O000000o2 != null && (specInstance = faw.O000000o().getSpecInstance(O000000o2)) != null && TextUtils.equals(str, specInstance.getTypeName())) {
                Iterator<Map.Entry<Integer, SpecService>> it = specInstance.getServices().entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (TextUtils.equals(str2, ((SpecService) it.next().getValue()).getTypeName())) {
                            arrayList.add(str3);
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    break;
                }
                i++;
            }
            z = false;
            if (!z) {
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064 A[LOOP:0: B:1:0x000a->B:17:0x0064, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067 A[EDGE_INSN: B:19:0x0067->B:18:0x0067 ?: BREAK  , SYNTHETIC] */
    public List<String> filterDidsExcludeSpecDeviceService(List<String> list, String str, String str2) {
        boolean z;
        SpecDevice specInstance;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        int i = 0;
        while (i < list.size()) {
            String str3 = list.get(i);
            Device O000000o2 = fno.O000000o().O000000o(str3);
            if (O000000o2 != null && (specInstance = faw.O000000o().getSpecInstance(O000000o2)) != null && TextUtils.equals(str, specInstance.getTypeName())) {
                Iterator<Map.Entry<Integer, SpecService>> it = specInstance.getServices().entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (TextUtils.equals(str2, ((SpecService) it.next().getValue()).getTypeName())) {
                            arrayList.add(str3);
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    break;
                }
                i++;
            }
            z = false;
            if (!z) {
            }
        }
        return arrayList;
    }

    public Pair<SpecDevice, Integer> matchSpecInstanceBy(String str, String str2, String str3) {
        SpecDevice specInstance;
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (!(O000000o2 == null || (specInstance = faw.O000000o().getSpecInstance(O000000o2)) == null || !TextUtils.equals(str3, specInstance.getTypeName()))) {
            for (Map.Entry next : specInstance.getServices().entrySet()) {
                if (TextUtils.equals(str2, next.getValue() == null ? null : ((SpecService) next.getValue()).getTypeName())) {
                    return new Pair<>(specInstance, Integer.valueOf(((SpecService) next.getValue()).getIid()));
                }
            }
        }
        return null;
    }

    public hrb filterSpecInstanceBy(SpecDevice specDevice, int i, String str, int i2, Object obj, int i3, JSONArray jSONArray) {
        Map<Integer, SpecService> services;
        hrb hrb;
        hrb hrb2;
        if (specDevice == null || (services = specDevice.getServices()) == null) {
            return null;
        }
        SpecService specService = services.get(Integer.valueOf(i));
        int indexOf = str.indexOf(":");
        if (indexOf >= str.length()) {
            return null;
        }
        String substring = str.substring(indexOf + 1);
        if (str.startsWith("event")) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                hrb2 = hri.O000000o(substring, specService, i2, obj, 0, (ArrayList<hof.O0000OOo>) null);
            } else {
                hrb2 = hri.O000000o(substring, specService, i2, obj, i3, hof.O0000OOo.O000000o(jSONArray));
            }
            return hrb2;
        } else if (!str.startsWith("prop")) {
            return null;
        } else {
            if (specService != null) {
                Iterator<Map.Entry<Integer, SpecProperty>> it = specService.getProperties().entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SpecProperty specProperty = (SpecProperty) it.next().getValue();
                    if (TextUtils.equals(specProperty.getTypeName(), substring)) {
                        hrb = new hrb();
                        hrb.f542O000000o = "prop";
                        hrb.O00000o0 = specService.getDescription().toLowerCase().replaceAll("\\s", "").toLowerCase();
                        hrb.O00000Oo = specService.getIid();
                        hrb.O00000o = specProperty.getIid();
                        hrb.O0000OOo = i2;
                        if (i2 == 6 && (obj instanceof JSONObject)) {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (jSONObject.has("description")) {
                                String optString = jSONObject.optString("description");
                                ConstraintValue constraintValue = specProperty.getConstraintValue();
                                if (constraintValue != null && (constraintValue instanceof ValueList)) {
                                    ValueList valueList = (ValueList) constraintValue;
                                    List<ValueDefinition> values = valueList.values();
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 >= (valueList != null ? valueList.size() : 0)) {
                                            break;
                                        } else if (TextUtils.equals(optString, values.get(i4).description())) {
                                            hrb.O0000Oo0 = values.get(i4).valueObject();
                                            hrb.O0000OOo = hri.O000000o(hrb.O0000Oo0);
                                            break;
                                        } else {
                                            i4++;
                                        }
                                    }
                                }
                                if (hrb.O0000Oo0 == null) {
                                    return null;
                                }
                            }
                        }
                        hrb.O0000Oo0 = obj;
                    }
                }
                return hrb;
            }
            hrb = null;
            return hrb;
        }
    }

    public String filterSpecInstanceBy(String str, String str2, String str3) {
        SpecDevice specInstance;
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (!(O000000o2 == null || (specInstance = faw.O000000o().getSpecInstance(O000000o2)) == null)) {
            if (TextUtils.equals(str3, specInstance.getTypeName())) {
                return null;
            }
            for (Map.Entry next : specInstance.getServices().entrySet()) {
                if (TextUtils.equals(str2, next.getValue() == null ? null : ((SpecService) next.getValue()).getTypeName())) {
                    return null;
                }
            }
        }
        String specInstanceStr = faw.O000000o().getSpecInstanceStr(str);
        if (!TextUtils.isEmpty(specInstanceStr)) {
            return specInstanceStr;
        }
        return null;
    }

    public void getRecTplBy(String str, String str2, final Callback callback) {
        if (TextUtils.isEmpty(str)) {
            str = ggb.O00000Oo().O0000OOo();
        }
        if (TextUtils.isEmpty(str)) {
            if (callback != null) {
                callback.onFailure(-1, "home id is null");
            }
        } else if (!TextUtils.isEmpty(str2)) {
            JSONObject jSONObject = null;
            for (int i = 1; i < 9999; i++) {
                String O00000o0 = gpy.O00000o0(ServiceApplication.getAppContext(), "tpl_scene_list", String.valueOf(i), "");
                if (TextUtils.isEmpty(O00000o0)) {
                    break;
                }
                try {
                    JSONArray jSONArray = new JSONArray(O00000o0);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (TextUtils.equals(optJSONObject.optString("template_id"), str2)) {
                            jSONObject = optJSONObject;
                            break;
                        }
                        i2++;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (jSONObject != null) {
                    break;
                }
            }
            if (!(jSONObject == null || callback == null)) {
                callback.onSuccess(jSONObject);
            }
            hnz.O00000Oo(ServiceApplication.getAppContext(), str2, 0, new fsm<JSONObject, fso>() {
                /* class _m_j.hon.AnonymousClass4 */

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(fso fso) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                    }
                }
            });
        } else if (callback != null) {
            callback.onFailure(-1, "template id is null");
        }
    }

    public Pair<String, String> getHomeByDevice(String str) {
        Home O0000o0;
        if (!TextUtils.isEmpty(str) && (O0000o0 = ggb.O00000Oo().O0000o0(str)) != null) {
            return new Pair<>(O0000o0.getId(), O0000o0.getRawName());
        }
        return null;
    }

    public Pair<String, String> getRoomByDevice(String str) {
        Room O0000o00;
        if (!TextUtils.isEmpty(str) && (O0000o00 = ggb.O00000Oo().O0000o00(str)) != null) {
            return new Pair<>(O0000o00.getId(), O0000o00.getName());
        }
        return null;
    }

    public Object getEventValues(String str, int i, Map<Integer, SpecProperty> map) {
        return hri.O000000o(str, i, map);
    }

    public void getRecSceneDetailBy(final String str, final String str2, final Callback callback) {
        if ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && callback != null) {
            callback.onFailure(-1, "param is null");
            return;
        }
        long j = -1;
        if (hrh.O000000o().f558O000000o != null) {
            j = hrh.O000000o().f558O000000o.O00000Oo;
        }
        if (j <= 0) {
            hnz.O000000o(ServiceApplication.getAppContext(), str, 0, (fsm<JSONObject, fso>) new fsm<JSONObject, fso>() {
                /* class _m_j.hon.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    Callback callback;
                    JSONObject jSONObject = (JSONObject) obj;
                    hoh hoh = null;
                    if (jSONObject != null) {
                        try {
                            hoh = hoh.O000000o(jSONObject.optJSONArray("scene_list"), str).get(Long.valueOf(Long.parseLong(str2)));
                        } catch (Exception unused) {
                        }
                        if (hoh != null) {
                            hnz.O000000o(ServiceApplication.getAppContext(), hoh.O00000Oo, 0, new fsm<JSONObject, fso>() {
                                /* class _m_j.hon.AnonymousClass5.AnonymousClass1 */

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    JSONObject jSONObject = (JSONObject) obj;
                                    if (callback != null) {
                                        callback.onSuccess(jSONObject.toString());
                                    }
                                }

                                public final void onFailure(fso fso) {
                                    if (callback != null) {
                                        callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                                    }
                                }
                            });
                            return;
                        }
                    }
                    if (hoh == null && (callback = callback) != null) {
                        callback.onSuccess("");
                    }
                }

                public final void onFailure(fso fso) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                    }
                }
            });
        } else {
            hnz.O000000o(ServiceApplication.getAppContext(), j, 0, new fsm<JSONObject, fso>() {
                /* class _m_j.hon.AnonymousClass6 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(jSONObject.toString());
                    }
                }

                public final void onFailure(fso fso) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                    }
                }
            });
        }
    }

    public void delScenes(final List<String> list, final Callback callback) {
        final int[] iArr = {0};
        for (int i = 0; i < list.size(); i++) {
            hnz.O000000o(ServiceApplication.getAppContext(), list.get(i), new fsy<JSONObject, fso>() {
                /* class _m_j.hon.AnonymousClass7 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    int[] iArr = iArr;
                    iArr[0] = iArr[0] + 1;
                    if (iArr[0] == list.size()) {
                        callback.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(fso fso) {
                    callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                }
            });
        }
    }

    public void editScenes(final List<String> list, final Callback callback) {
        final int[] iArr = {0};
        for (int i = 0; i < list.size(); i++) {
            hnz.O000000o(ServiceApplication.getAppContext(), 1, list.get(i), 0, new fsy<JSONObject, fso>() {
                /* class _m_j.hon.AnonymousClass8 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    int[] iArr = iArr;
                    iArr[0] = iArr[0] + 1;
                    if (iArr[0] == list.size()) {
                        callback.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(fso fso) {
                    callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                }
            });
        }
    }

    public void openMapDialog(Activity activity, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = ggb.O00000Oo().O0000OOo();
        }
        if (!TextUtils.isEmpty(str) && fux.O000000o(activity)) {
            ExternalLoadManager.instance.loadExternal("amap2d", new fkv(activity, str2, str) {
                /* class _m_j.$$Lambda$hon$iBQCCjRSJPs8ApWY0TbqU7kgQfA */
                private final /* synthetic */ Activity f$0;
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final Object call(Object obj) {
                    return hon.lambda$openMapDialog$0(this.f$0, this.f$1, this.f$2, (ExternalLoadManager.O000000o) obj);
                }
            });
        }
    }

    public String validMsgForScene(Context context, long j, String str) {
        ArrayList<SceneApi.O000OOOo> arrayList = new ArrayList<>();
        arrayList.addAll(hod.O0000OoO().O00000o0);
        arrayList.addAll(hpr.O00000o0().O0000O0o);
        for (SceneApi.O000OOOo o000OOOo : arrayList) {
            if (!String.valueOf(j).equalsIgnoreCase(o000OOOo.f11131O000000o) && o000OOOo.O00000Oo == str) {
                return context.getString(R.string.scene_modify_name_error);
            }
        }
        return "";
    }

    public fsn miioGetRecommendScene(Context context, String str, fsm<JSONObject, fso> fsm) {
        return hoa.O00000oO(context, str, fsm);
    }

    public fsn miioSceneStart(Context context, String str, fsm<Void, fso> fsm) {
        return hoa.O00000Oo(context, str, fsm);
    }

    public fsn runSpecScene(Context context, long j, fsm<JSONObject, fso> fsm) {
        return hoa.O000000o(context, j, fsm);
    }

    public fsn getCommonUsedSceneList(Context context, String str, fsm<List<CommonUsedScene>, fso> fsm) {
        return hoa.O00000o0(context, str, fsm);
    }

    public fsn getUncommonUsedSceneList(Context context, String str, fsm<List<CommonUsedScene>, fso> fsm) {
        return hoa.O00000o(context, str, fsm);
    }

    public fsn changeCommonUsedSceneOrder(Context context, String str, List<Long> list, fsm<JSONObject, fso> fsm) {
        return hoa.O00000o0(context, str, list, fsm);
    }

    public fsn updateCommonUseName(Context context, CommonUsedScene commonUsedScene, fsm<JSONObject, fso> fsm) {
        return hoa.O000000o(context, commonUsedScene, fsm);
    }

    public fsn setUncommonUse(Context context, String str, List<CommonUsedScene> list, fsm<JSONObject, fso> fsm) {
        return hoa.O00000Oo(context, str, list, fsm);
    }

    public fsn setCommonUse(Context context, String str, List<CommonUsedScene> list, fsm<JSONObject, fso> fsm) {
        return hoa.O000000o(context, str, list, fsm);
    }

    public fsn delScene(Context context, String str, fsm<JSONObject, fso> fsm) {
        return hoa.O000000o(context, str, fsm);
    }

    public void builderLocalScene(DeviceStat deviceStat, String str, MessageCallback messageCallback) {
        hpn.O000000o().O000000o(deviceStat, str, messageCallback);
    }

    public void setGatewayScene(String str, DeviceStat deviceStat, int i, String str2, MessageCallback messageCallback) {
        hpn O000000o2 = hpn.O000000o();
        int i2 = i <= 0 ? 700 : i;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        O000000o2.O000000o(str, i2, arrayList);
        int size = arrayList.size();
        int nextInt = new Random().nextInt(65535);
        for (int i3 = 0; i3 < size; i3++) {
            O000000o2.O000000o(deviceStat, str2, nextInt, i3, size, (String) arrayList.get(i3), arrayList2, messageCallback);
        }
    }

    public void buildExtra(SceneInfo sceneInfo, Callback<SceneInfo> callback) {
        hpp.O000000o().O000000o(sceneInfo, callback);
    }

    public Class<?> getCreateSceneFromRecommendActivityClass() {
        return CreateSceneFromRecommendActivity.class;
    }

    public Class<?> getTimerSettingActivityClass() {
        return SmartHomeSceneTimerActivity.class;
    }

    public String getSceneTabName() {
        return hnj.class.getSimpleName();
    }

    public hoo createSceneTabFragment() {
        return new hnj();
    }

    public boolean openRecommendSceneDetail(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("rectemplateid");
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        try {
            openRecommendSceneDetail(context, Long.parseLong(optString), jSONObject.optString("iconurl"), jSONObject.optString("did"));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void openRecommendSceneDetail(Context context, long j, String str, String str2) {
        if (j > 0) {
            if (PluginDeviceManager.instance.getPluginInfo("miot.clock.mijia") != null) {
                DeviceStat deviceStat = new DeviceStat();
                deviceStat.did = "main.".concat(String.valueOf(j));
                deviceStat.model = "miot.clock.mijia";
                deviceStat.isOnline = true;
                deviceStat.deviceIconReal = str;
                if (str2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("real_did", str2);
                        deviceStat.extrainfo = jSONObject.toString();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                PluginApi.getInstance().sendMessage(context, deviceStat.model, 1, null, deviceStat, null, false, null);
            } else if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(new Intent(context, RecommendSceneDetailPage.class), 1008);
            } else {
                context.startActivity(new Intent(context, RecommendSceneDetailPage.class));
            }
        }
    }

    public String getDeviceDisplayName(String str, int i, int i2) {
        SpecDevice specDevice;
        SpecService specService;
        Device O000000o2 = fno.O000000o().O000000o(str);
        String str2 = null;
        if (O000000o2 == null) {
            specDevice = null;
        } else {
            specDevice = faw.O000000o().getSpecInstance(O000000o2);
        }
        if (!(specDevice == null || specDevice.getServices() == null || (specService = specDevice.getServices().get(Integer.valueOf(i))) == null)) {
            String description = specService.getDescription();
            SpecProperty specProperty = specService.getProperties().get(Integer.valueOf(i2));
            if (specProperty != null) {
                str2 = faw.O000000o().getValueName(O000000o2, specProperty, null, null);
            }
            if (!TextUtils.isEmpty(str2)) {
                gsy.O00000Oo("RecScene", O000000o2.name + "---+" + description + "found in cardtype " + str2);
            } else {
                gsy.O00000o0(LogType.SCENE, "multiname", O000000o2.name + "+++" + description + "can not show config");
            }
        }
        return str2;
    }

    static /* synthetic */ Integer lambda$openMapDialog$0(Activity activity, String str, String str2, ExternalLoadManager.O000000o o000000o) throws RuntimeException {
        if (o000000o.f4013O000000o == 3) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(activity, "com.xiaomi.smarthome.scene.newui.amappoi.AmapRecSceneSetHomePage"));
            intent.putExtra("extra_data_min_radius", 200);
            intent.putExtra("extra_data_max_radius", 2000);
            intent.putExtra("is_pin_mode", TextUtils.equals(str.toUpperCase(), "PIN_MODE"));
            intent.putExtra("home_id", str2);
            activity.startActivityForResult(intent, 1002);
        } else {
            gqg.O00000Oo((int) R.string.mapload_fail);
        }
        return Integer.valueOf(o000000o.f4013O000000o);
    }
}
