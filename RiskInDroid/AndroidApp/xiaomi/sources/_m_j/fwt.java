package _m_j;

import android.util.Log;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.ClassicBluetoothModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTAudioModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBluetoothModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTMapSearchModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPackageModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTRoomManageModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTSceneModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTSpecModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTSystemModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTXimalayaModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.kookong.MIOTKookongModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.HmPaceScalesModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.MHMiBandCardModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.MIOTWifiSpeakerModule;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.AMapViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.FakeMapViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.InputDialogManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.LoadingDialogManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MHNavigationBar;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MessageDialogManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MiotImageCapInsetManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MultiChoseDialogManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.NumberPickerManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.ProgressDialogManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.SingleChoseDialogManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.StringPickerManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.image.MHImageViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.pdf.RCTPdfManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.scrollview.MIOTScrollLayoutManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.scrollview.MIOTScrollViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.surfaceview.MHRSurfaceViewManager;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;

public final class fwt implements ReactPackage {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f17333O000000o;
    MIOTHostModule O00000Oo;
    private MIOTPackageModule O00000o;
    MIOTSystemModule O00000o0;
    private MIOTDeviceModule O00000oO;
    private MIOTPersistModule O00000oo;
    private MIOTServiceModule O0000O0o;
    private final long[] O0000OOo = {0};

    fwt(boolean z) {
        this.f17333O000000o = z;
        O000000o();
    }

    public final void O000000o() {
        this.O0000OOo[0] = System.currentTimeMillis();
    }

    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        this.O00000o = new MIOTPackageModule(reactApplicationContext, this.f17333O000000o);
        this.O00000oO = new MIOTDeviceModule(reactApplicationContext);
        this.O00000Oo = new MIOTHostModule(reactApplicationContext);
        arrayList.add(this.O00000o);
        arrayList.add(this.O00000oO);
        arrayList.add(new MIOTBluetoothModule(reactApplicationContext));
        this.O0000O0o = new MIOTServiceModule(reactApplicationContext);
        arrayList.add(this.O0000O0o);
        arrayList.add(this.O00000Oo);
        arrayList.add(new MIOTMapSearchModule(reactApplicationContext));
        this.O00000oo = new MIOTPersistModule(reactApplicationContext);
        arrayList.add(this.O00000oo);
        arrayList.add(new MIOTAudioModule(reactApplicationContext));
        arrayList.add(new MIOTSpecModule(reactApplicationContext));
        arrayList.add(new MIOTSceneModule(reactApplicationContext));
        arrayList.add(new MIOTXimalayaModule(reactApplicationContext));
        arrayList.add(new MIOTRoomManageModule(reactApplicationContext));
        arrayList.add(new MIOTWifiSpeakerModule(reactApplicationContext));
        this.O00000o0 = new MIOTSystemModule(reactApplicationContext);
        arrayList.add(this.O00000o0);
        arrayList.add(new HmPaceScalesModule(reactApplicationContext));
        arrayList.add(new CmTJInfraModule(reactApplicationContext));
        arrayList.add(new MHMiBandCardModule(reactApplicationContext));
        arrayList.add(new ClassicBluetoothModule(reactApplicationContext));
        arrayList.add(new MIOTKookongModule(reactApplicationContext));
        return arrayList;
    }

    public final ReadableMap O000000o(fwy fwy) {
        WritableMap createMap = Arguments.createMap();
        MIOTPackageModule mIOTPackageModule = this.O00000o;
        if (mIOTPackageModule != null) {
            createMap.putMap("package", Arguments.makeNativeMap(mIOTPackageModule.getConstantsFromInputRNRuntime(fwy)));
            createMap.putMap("device", Arguments.makeNativeMap(this.O00000oO.getConstants()));
            createMap.putMap("file", Arguments.makeNativeMap(this.O00000oo.getConstants()));
            createMap.putMap("host", Arguments.makeNativeMap(this.O00000Oo.getConstants()));
            createMap.putMap("service", Arguments.makeNativeMap(this.O0000O0o.getConstants()));
        }
        return createMap;
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MHNavigationBar());
        arrayList.add(new MessageDialogManager());
        arrayList.add(new InputDialogManager());
        arrayList.add(new SingleChoseDialogManager());
        arrayList.add(new MultiChoseDialogManager());
        arrayList.add(new LoadingDialogManager());
        arrayList.add(new ProgressDialogManager());
        arrayList.add(new MiotImageCapInsetManager());
        try {
            getClass().getClassLoader().loadClass("com.amap.api.maps2d.MapView");
            arrayList.add(new AMapViewManager());
        } catch (Throwable th) {
            arrayList.add(new FakeMapViewManager());
            gsy.O00000Oo(LogType.GENERAL, "MIOTReactNativeSDKPackage", Log.getStackTraceString(th));
        }
        arrayList.add(new NumberPickerManager());
        arrayList.add(new MIOTScrollViewManager());
        arrayList.add(new MIOTScrollLayoutManager());
        arrayList.add(new MHImageViewManager());
        arrayList.add(new StringPickerManager());
        arrayList.add(new MHRSurfaceViewManager());
        arrayList.add(new RCTPdfManager(reactApplicationContext));
        return arrayList;
    }
}
