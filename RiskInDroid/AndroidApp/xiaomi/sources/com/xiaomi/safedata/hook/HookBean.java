package com.xiaomi.safedata.hook;

import android.util.Log;
import com.xiaomi.safedata.base.BaseBean;
import org.json.JSONObject;

public class HookBean extends BaseBean {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f6616O000000o = "HookBean";
    public boolean isHaveFrida;
    public boolean isHaveSubstrate;
    public boolean isHaveXposed;

    public static class FridaBean extends BaseBean {
        public boolean checkFridaJars;
        public boolean checkRunningProcesses;
    }

    public static class SubstrateBean extends BaseBean {
        public boolean checkSubstrateHookMethod;
        public boolean checkSubstrateJars;
        public boolean checkSubstratePackage;
    }

    public static class XposedBean extends BaseBean {
        public boolean checkCheckman;
        public boolean checkClassLoader;
        public boolean checkExecLib;
        public boolean checkNativeMethod;
        public boolean checkSystem;
        public boolean checkXposedBridge;
        public boolean checkXposedHookMethod;
        public boolean checkXposedJars;
        public boolean checkXposedPackage;
    }

    public final JSONObject O000000o() {
        try {
            this.jsonObject.put("xposed", this.isHaveXposed);
            this.jsonObject.put("substrate", this.isHaveSubstrate);
            this.jsonObject.put("frida", this.isHaveFrida);
        } catch (Exception e) {
            Log.e(f6616O000000o, e.toString());
        }
        return super.O000000o();
    }
}
