package _m_j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.List;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:608)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:241)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:122)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:43)
    */
public class hns extends hnm implements hoz {
    private List<SceneApi.O000OOOo> O00000oO;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: Method info already added: _m_j.hnm.<init>():void in method: _m_j.hns.<init>(java.util.List<com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo>):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:154)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:306)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method info already added: _m_j.hnm.<init>():void
        	at jadx.core.dex.info.InfoStorage.putMethod(InfoStorage.java:42)
        	at jadx.core.dex.info.MethodInfo.fromDex(MethodInfo.java:50)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:678)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:534)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:139)
        	... 5 more
        */
    public hns(java.util.List<com.xiaomi.smarthome.scene.api.SceneApi.O000OOOo> r1) {
        /*
            r1 = this;
            r1.<init>()
            r1.O00000oO = r2
            java.util.List<com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo> r2 = r1.O00000oO
            int r2 = r2.size()
            int[] r2 = new int[r2]
            r1.O00000Oo = r2
            r2 = 0
        L_0x0010:
            java.util.List<com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo> r0 = r1.O00000oO
            int r0 = r0.size()
            if (r2 >= r0) goto L_0x001f
            int[] r0 = r1.O00000Oo
            r0[r2] = r2
            int r2 = r2 + 1
            goto L_0x0010
        L_0x001f:
            java.util.List<com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo> r2 = r1.O00000oO
            int r2 = r2.size()
            java.lang.String[] r2 = new java.lang.String[r2]
            r1.f19096O000000o = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.hns.<init>(java.util.List):void");
    }

    public final int O000000o() {
        return R.string.exectute_one_scene;
    }

    public final int O000000o(int i) {
        return -1;
    }

    public final int O000000o(SmartHomeSceneActionChooseActivity.O0000OOo o0000OOo, Context context, int i, Object obj, Object obj2) {
        return -2;
    }

    public final int O000000o(String str, Object obj) {
        return -1;
    }

    public final SceneApi.Action O000000o(String str, int i, Object obj, Intent intent) {
        SceneApi.O000OOOo o000OOOo = this.O00000oO.get(i);
        SceneApi.Action action = new SceneApi.Action();
        action.f11120O000000o = 2;
        action.O00000Oo = o000OOOo.O00000Oo;
        action.O00000o0 = o000OOOo.O00000Oo;
        SceneApi.O000O00o o000O00o = new SceneApi.O000O00o();
        o000O00o.f11127O000000o = o000OOOo.f11131O000000o;
        action.O0000O0o = o000O00o;
        return action;
    }

    public final String O000000o(Object obj) {
        return ServiceApplication.getAppContext().getString(R.string.exectute_one_scene);
    }

    public final int O000000o(SceneApi.Action action, Object obj) {
        if (!(action.O0000O0o instanceof SceneApi.O000O00o)) {
            return -1;
        }
        for (int i = 0; i < this.O00000oO.size(); i++) {
            if (TextUtils.equals(this.O00000oO.get(i).f11131O000000o, ((SceneApi.O000O00o) action.O0000O0o).f11127O000000o)) {
                return i;
            }
        }
        return -1;
    }
}
