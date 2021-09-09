package in.cashify.otex;

import _m_j.O00o;
import _m_j.O0OO0Oo;
import _m_j.O0OOOOO;
import _m_j.O0OOOo0;
import _m_j.ee;
import _m_j.ei;
import _m_j.ird;
import _m_j.ooooooo;
import a.a.a.a;
import a.a.a.b;
import a.a.a.e.c.g;
import a.a.a.f.d.a;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeError;
import in.cashify.otex.widget.CircleRoadProgress;
import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class ExchangeManager extends Fragment implements ooooooo.O000000o, ViewPager.O0000O0o {

    /* renamed from: O000000o  reason: collision with root package name */
    public ExchangeSetup f12257O000000o;
    public O000000o O00000Oo;
    public final ArrayList<g> O00000o = new ArrayList<>();
    public a O00000o0;
    public final HashMap<String, b> O00000oO = new HashMap<>();
    public FrameLayout O00000oo;
    public O0OOOOO O0000O0o;
    public int O0000OOo;
    public boolean O0000Oo = false;
    public ViewPager O0000Oo0;
    public ProgressBar O0000OoO;
    public TextView O0000Ooo;

    public interface O000000o {
        void O000000o(int i, String str, String str2);

        void O000000o(ird ird);

        void O000000o(String str);

        void O000000o(String str, String str2);

        void O00000Oo(String str, String str2);
    }

    public class O00000o0 implements Runnable {
        public O00000o0() {
        }

        public final void run() {
            try {
                ExchangeManager.this.O0000Oo0.setOffscreenPageLimit(ExchangeManager.this.O00000o.size());
                ExchangeManager.this.O000000o(ExchangeManager.this.O0000O0o, ExchangeManager.this.O00000o);
                ExchangeManager.this.O00000Oo(ExchangeManager.this.O0000OOo = 0);
            } catch (Throwable unused) {
                if (ExchangeManager.this.O00000Oo != null) {
                    ExchangeManager.this.O00000Oo.O000000o(new ird(ExchangeError.Kind.UNKNOWN_ERROR));
                }
            }
        }
    }

    public class O0000OOo implements DialogInterface.OnClickListener {
        public O0000OOo() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ExchangeManager.this.O00000oO();
        }
    }

    public class O0000Oo implements Runnable {
        public O0000Oo() {
        }

        public final void run() {
            if (ExchangeManager.this.O0000O0o != null) {
                ExchangeManager.this.O0000O0o.notifyDataSetChanged();
            }
        }
    }

    public class O0000Oo0 implements DialogInterface.OnClickListener {
        public O0000Oo0() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ExchangeManager.this.O00000o0();
        }
    }

    public enum h {
        WELCOME_PAGE("welcome_page"),
        QUOTE_PAGE("quote_page"),
        MOBILE_AGE("mobile_age"),
        WIFI("wifi"),
        BLUETOOTH("bluetooth"),
        MICROPHONE("mic"),
        FRONT_CAMERA("front_camera"),
        BACK_CAMERA("back_camera"),
        BATTERY("battery"),
        SPEAKER("speaker"),
        VOLUME("volume_button"),
        CHARGING("charging"),
        AUDIO_JACK("audio_jack"),
        MANUAL_WEB_PAGE("manual_web_page"),
        PROXIMITY_SENSOR("proximity_sensor"),
        TELEPHONY_TEST("telephony_test"),
        VIBRATION("vibration"),
        MANUAL_SINGLE_CHOICE("manual_single_choice"),
        MANUAL_MULTI_CHOICE("manual_multi_choice"),
        MANUAL_DROPDOWN("manual_dropdown"),
        GPS("gps"),
        PROMPT_PAGE("prompt_page"),
        ZERO_QUOTE_PAGE("zero_quote_page"),
        TOUCH_CALIBRATION("touch_calibration"),
        HOME_BUTTON("home_button"),
        RECENT_TASK_BUTTON("recent_task_button"),
        BACK_BUTTON("back_button"),
        DEAD_PIXEL("manual_dead_pixel"),
        SENSOR_ACCELEROMETER("sensor_accelerometer"),
        SENSOR_COMPASS("sensor_compass"),
        SENSOR_GYROSCOPE("sensor_gyroscope"),
        BUTTON_BACK("button_back"),
        BUTTON_HOME("home_button"),
        BUTTON_RECENT_APPS("button_recent_apps"),
        SIM_CARD("sim_card"),
        SPEAKER_RECEIVER("speaker_receiver"),
        POWER_BUTTON("power_button"),
        REMARK("remark"),
        FINGERPRINT("fingerprint"),
        NONE("none");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f12264a;

        /* access modifiers changed from: public */
        h(String str) {
            this.f12264a = str;
        }

        public static h a(String str) {
            for (h hVar : values()) {
                if (hVar.a().equalsIgnoreCase(str)) {
                    return hVar;
                }
            }
            return NONE;
        }

        public final String a() {
            return this.f12264a;
        }
    }

    public static ExchangeManager O000000o(ExchangeSetup exchangeSetup) {
        ExchangeManager exchangeManager = new ExchangeManager();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_exchange_info", exchangeSetup);
        exchangeManager.setArguments(bundle);
        return exchangeManager;
    }

    private static String O000000o(int i, long j) {
        return "cashify:diagnose:" + i + ":" + j;
    }

    private void O000000o(int i, int i2) {
        this.O0000Ooo.setText(MessageFormat.format("{0}/{1}", Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public static void O000000o(List<g> list) {
        Collections.sort(list, new O00000o());
    }

    private void O00000Oo(ExchangeSetup exchangeSetup) {
        new Thread(new O00000Oo(exchangeSetup)).start();
    }

    /* access modifiers changed from: private */
    public void O00000o0() {
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, 28);
        }
    }

    /* access modifiers changed from: private */
    public void O00000oO() {
        O000000o o000000o = this.O00000Oo;
        if (o000000o != null) {
            o000000o.O000000o(new ird(ExchangeError.Kind.PERMISSION_NOT_GRANTED));
        }
    }

    public final void O00000Oo() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            O0OOOOO o0ooooo = this.O0000O0o;
            if (o0ooooo != null) {
                o0ooooo.notifyDataSetChanged();
                return;
            }
            return;
        }
        new Handler().post(new O0000Oo());
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof O000000o) {
            this.O00000Oo = (O000000o) getParentFragment();
            return;
        }
        throw new RuntimeException(context.toString() + " must implement ExchangeManager.OnExchangeCallback");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity(), 2132738353)).inflate((int) R.layout.fragment_exchange_manager, viewGroup, false);
    }

    public final void onDetach() {
        super.onDetach();
        this.O00000Oo = null;
    }

    public final void onPageScrollStateChanged(int i) {
        this.O0000Oo = i != 0;
    }

    public final void onPageScrolled(int i, float f, int i2) {
        if (this.O0000Oo) {
            this.O0000Oo0.invalidate();
        }
    }

    public final void onPageSelected(int i) {
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.O00000oO.values());
        bundle.putParcelableArrayList("bundle_result_map", arrayList);
        bundle.putParcelableArrayList("bundle_device_registration", this.O00000o);
        bundle.putInt("bundle_current_test_index", this.O0000OOo);
        bundle.putParcelable("bundle_device_info", this.O00000o0);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        this.O00000oo = (FrameLayout) view.findViewById(R.id.diagnose_container);
        View findViewById = view.findViewById(R.id.pager_container);
        if (Build.VERSION.SDK_INT < 17) {
            findViewById.setLayerType(1, null);
        }
        this.O0000OoO = (ProgressBar) view.findViewById(R.id.progress_bar_test_status);
        if (getContext() != null) {
            this.O0000OoO.getProgressDrawable().setColorFilter(ContextCompat.O00000o0(getContext(), R.color.otexColorPrimary), PorterDuff.Mode.SRC_IN);
        }
        this.O0000Ooo = (TextView) view.findViewById(R.id.tv_progress_counter);
        this.O0000Oo0 = (ViewPager) view.findViewById(R.id.pager_header);
        this.O0000O0o = new O0OOOOO();
        this.O0000Oo0.setAdapter(this.O0000O0o);
        this.O0000Oo0.setPageTransformer(true, new O0OOOo0());
        this.O0000Oo0.addOnPageChangeListener(this);
        if (this.O00000o.size() > 0) {
            this.O0000Oo0.setOffscreenPageLimit(this.O00000o.size());
            O000000o(this.O0000O0o, this.O00000o);
            O00000Oo(this.O0000OOo);
        }
    }

    public class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ ExchangeSetup f12258O000000o;

        public O00000Oo(ExchangeSetup exchangeSetup) {
            this.f12258O000000o = exchangeSetup;
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x00ea A[Catch:{ all -> 0x0242 }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00ec A[Catch:{ all -> 0x0242 }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00f3 A[Catch:{ all -> 0x0242 }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00f4 A[Catch:{ all -> 0x0242 }] */
        public final void run() {
            ird ird;
            O000000o o000000o;
            String str;
            String str2;
            String str3;
            boolean z;
            try {
                if (ExchangeManager.this.O00000o0 == null) {
                    ExchangeManager exchangeManager = ExchangeManager.this;
                    new a.O00000Oo();
                    FragmentActivity activity = ExchangeManager.this.getActivity();
                    boolean z2 = false;
                    a aVar = new a((byte) 0);
                    String unused = aVar.f2609O000000o = Build.MANUFACTURER;
                    String unused2 = aVar.O00000Oo = Build.ID;
                    String unused3 = aVar.O00000o0 = Build.BRAND;
                    String unused4 = aVar.O00000o = Build.MODEL;
                    String unused5 = aVar.O00000oO = Build.VERSION.RELEASE;
                    String unused6 = aVar.O00000oo = O00o.O00000Oo("hardware");
                    String unused7 = aVar.O0000O0o = System.getProperty("os.arch");
                    String unused8 = aVar.O0000OOo = String.valueOf(O00o.O00000o0());
                    String unused9 = aVar.O0000Oo0 = String.valueOf(O00o.O00000o());
                    String unused10 = aVar.O0000Oo = String.valueOf(O00o.O00000oO());
                    double unused11 = aVar.O0000OoO = O00o.O00000Oo();
                    double unused12 = aVar.O0000Ooo = (double) (O00o.O000000o("/storage") + 0 + O00o.O000000o("/cache") + O00o.O000000o("/system") + Environment.getDataDirectory().getTotalSpace());
                    String O000000o2 = O00o.O000000o();
                    if (TextUtils.isEmpty(O000000o2)) {
                        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
                        int i = 0;
                        while (true) {
                            if (i >= 9) {
                                str3 = "";
                                break;
                            }
                            String str4 = strArr[i];
                            if (new File(str4).exists()) {
                                str3 = str4;
                                break;
                            }
                            i++;
                        }
                        if (TextUtils.isEmpty(O000000o2)) {
                            String str5 = Build.TAGS;
                            if (str5 != null) {
                                if (str5.contains("test-keys")) {
                                    z = true;
                                    if (!z) {
                                        O000000o2 = "test-keys";
                                    } else {
                                        O000000o2 = "";
                                    }
                                    if (!TextUtils.isEmpty(O000000o2)) {
                                        O000000o2 = "NA";
                                    }
                                }
                            }
                            z = false;
                            if (!z) {
                            }
                            if (!TextUtils.isEmpty(O000000o2)) {
                            }
                        }
                    }
                    String unused13 = aVar.O0000o0 = O000000o2;
                    int unused14 = aVar.O0000o00 = aVar.O0000o0.equals("NA") ^ true ? 1 : 0;
                    File file = new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder");
                    if (file.exists()) {
                        str = file.getAbsolutePath();
                    } else {
                        str = "";
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = TextUtils.isEmpty(Settings.Secure.getString(activity.getContentResolver(), "android_id")) ? "Device Id empty" : Build.PRODUCT.equals("google_sdk") ? "google_sdk" : Build.PRODUCT.equals("sdk") ? "sdk" : "";
                        if (TextUtils.isEmpty(str)) {
                            if (((SensorManager) activity.getSystemService("sensor")).getSensorList(-1).isEmpty()) {
                                str2 = "Sensor Manager not found";
                            } else {
                                str2 = "NA";
                            }
                            if (TextUtils.isEmpty(str)) {
                                String property = System.getProperty("os.version");
                                String str6 = "x86";
                                if (property != null) {
                                    if (property.contains(str6)) {
                                        z2 = true;
                                    }
                                }
                                if (!z2) {
                                    str6 = "";
                                }
                                if (!TextUtils.isEmpty(str6)) {
                                    str = str6;
                                } else {
                                    str = "NA";
                                }
                            }
                        }
                    }
                    String unused15 = aVar.O0000o0o = str;
                    int unused16 = aVar.O0000o0O = aVar.O0000o0o.equals("NA") ^ true ? 1 : 0;
                    List unused17 = aVar.O0000o = new ArrayList();
                    List O00000o0 = aVar.O0000o;
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(O00o.O000000o(activity));
                    O00000o0.addAll(hashSet);
                    a unused18 = exchangeManager.O00000o0 = aVar;
                }
                a.a.a.f.d.a O000000o3 = new a.b(ExchangeManager.this.getActivity()).O000000o(this.f12258O000000o, ExchangeManager.this.O00000o0);
                if (ExchangeManager.this.O00000Oo != null) {
                    if (String.valueOf(this.f12258O000000o.O00000Oo).length() != 6) {
                        o000000o = ExchangeManager.this.O00000Oo;
                        ird = new ird(ExchangeError.Kind.INVALID_PIN_CODE);
                    } else if (O000000o3 == null) {
                        o000000o = ExchangeManager.this.O00000Oo;
                        ird = new ird(ExchangeError.Kind.UNKNOWN_ERROR);
                    } else {
                        ExchangeManager.this.O00000Oo.O000000o(O000000o3.f6678O000000o.f6670O000000o, O000000o3.f6678O000000o.O00000Oo);
                        return;
                    }
                    o000000o.O000000o(ird);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class O0000O0o implements Runnable {
        public O0000O0o() {
        }

        public final void run() {
            try {
                if (ExchangeManager.this.O00000Oo != null) {
                    new O0OO0Oo.O000000o();
                    O0OO0Oo O000000o2 = O0OO0Oo.O000000o.O000000o(ExchangeManager.this.getActivity(), ExchangeManager.this.f12257O000000o, ExchangeManager.this.O00000o0, ExchangeManager.this.O00000oO);
                    if (O000000o2 != null) {
                        ExchangeManager.this.O00000Oo.O00000Oo(O000000o2.f6678O000000o.f6670O000000o, O000000o2.f6678O000000o.O00000Oo);
                    } else {
                        ExchangeManager.this.O00000Oo.O000000o(new ird(ExchangeError.Kind.UNKNOWN_ERROR));
                    }
                }
            } catch (Throwable unused) {
                if (ExchangeManager.this.O00000Oo != null) {
                    ExchangeManager.this.O00000Oo.O000000o(new ird(ExchangeError.Kind.UNKNOWN_ERROR));
                }
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f12257O000000o = (ExchangeSetup) getArguments().getParcelable("arg_exchange_info");
        }
        if (bundle != null) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("bundle_result_map");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("bundle_device_registration");
            this.O00000o0 = (a.a.a.a) bundle.getParcelable("bundle_device_info");
            if (parcelableArrayList2 != null && !parcelableArrayList2.isEmpty()) {
                this.O00000o.clear();
                this.O00000o.addAll(parcelableArrayList2);
                this.O0000OOo = bundle.getInt("bundle_current_test_index");
                if (this.O0000OOo >= parcelableArrayList2.size()) {
                    this.O0000OOo = 0;
                }
            }
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                this.O00000oO.clear();
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    this.O00000oO.put(bVar.f2610O000000o, bVar);
                }
            }
        } else if (getActivity() == null || ContextCompat.O000000o(getActivity(), "android.permission.READ_PHONE_STATE") != 0) {
            O00000o0();
        } else {
            O00000Oo(this.f12257O000000o);
        }
    }

    public class O00000o implements Comparator<g> {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((g) obj).O00000o0 - ((g) obj2).O00000o0;
        }
    }

    public final void O000000o(String str, ArrayList<b> arrayList) {
        boolean z;
        String str2;
        O0OOOOO.O000000o O000000o2;
        if (this.O0000OOo < this.O00000o.size()) {
            boolean z2 = false;
            if (arrayList != null) {
                Iterator<b> it = arrayList.iterator();
                z = false;
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null) {
                        this.O00000oO.put(next.f2610O000000o, next);
                        z2 = next.O00000o0;
                        z = next.O00000o;
                    }
                }
            } else {
                z = false;
            }
            g gVar = this.O00000o.get(this.O0000OOo);
            if (gVar != null && (str2 = gVar.O0000Oo0) != null && str2.equals(str)) {
                O0OOOOO o0ooooo = this.O0000O0o;
                if (!(o0ooooo == null || (O000000o2 = o0ooooo.O000000o(this.O0000OOo)) == null)) {
                    int i = z2 ? 1 : 2;
                    O000000o2.f6676O000000o = i;
                    gVar.O0000OOo = i;
                    if (this.O00000Oo != null) {
                        this.O00000Oo.O000000o(this.O0000OOo, gVar.O0000Oo0, z ? "skip" : z2 ? "pass" : "fail");
                    }
                }
                O00000o();
            }
        }
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 28) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                if ("android.permission.READ_PHONE_STATE".equals(str)) {
                    if (iArr[i2] == -1) {
                        if (!(Build.VERSION.SDK_INT >= 23 ? shouldShowRequestPermissionRationale(str) : false)) {
                            O00000oO();
                        } else {
                            new AlertDialog.Builder(getActivity()).setMessage((int) R.string.otex_permission_message).setPositiveButton(getString(17039370), new O0000Oo0()).setNegativeButton(getString(17039360), new O0000OOo()).show();
                        }
                    } else {
                        O00000Oo(this.f12257O000000o);
                    }
                }
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public final void O000000o(long j, CircleRoadProgress.O00000Oo o00000Oo, int i) {
        O0OOOOO.O000000o O000000o2 = this.O0000O0o.O000000o(this.O0000OOo);
        if (O000000o2 != null) {
            O000000o2.O00000oO = i;
            O000000o2.f6676O000000o = 3;
            O000000o2.O00000Oo = 1;
            O000000o2.O00000o0 = j;
            O000000o2.O00000o = o00000Oo;
            O00000Oo();
        }
    }

    public final void O000000o(long j, CircleRoadProgress.O00000Oo o00000Oo) {
        O0OOOOO.O000000o O000000o2 = this.O0000O0o.O000000o(this.O0000OOo);
        if (O000000o2 != null) {
            O000000o2.f6676O000000o = 3;
            O000000o2.O00000Oo = 1;
            O000000o2.O00000o0 = j;
            O000000o2.O00000o = o00000Oo;
            O00000Oo();
        }
    }

    public final void O000000o(long j, Boolean bool) {
        O0OOOOO.O000000o O000000o2 = this.O0000O0o.O000000o(this.O0000OOo);
        if (O000000o2 != null) {
            O000000o2.O00000o0 = j;
            if (bool.booleanValue()) {
                O000000o2.O00000oO = R.drawable.ic_cross;
                if (getContext() != null) {
                    O000000o2.O0000O0o = ContextCompat.O00000o0(getContext(), R.color.arc_fail_color);
                }
            } else {
                O000000o2.O00000oO = R.drawable.ic_tick;
                if (getContext() != null) {
                    O000000o2.O0000O0o = ContextCompat.O00000o0(getContext(), R.color.arc_pass_color);
                }
            }
            O000000o2.O00000Oo = 2;
            O00000Oo();
        }
    }

    public final void O000000o() {
        O0OOOOO.O000000o O000000o2 = this.O0000O0o.O000000o(this.O0000OOo);
        if (O000000o2 != null) {
            O000000o2.O00000Oo = 4;
            O00000Oo();
        }
    }

    public final void O000000o(int i) {
        O0OOOOO.O000000o O000000o2 = this.O0000O0o.O000000o(this.O0000OOo);
        if (O000000o2 != null) {
            O000000o2.O00000oO = i;
            O00000Oo();
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(O0OOOOO o0ooooo, List<g> list) {
        if (list == null || list.isEmpty()) {
            Log.d("", "Diagnose list may not be null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            g gVar = list.get(i);
            int i2 = gVar.O0000OOo;
            if (i == this.O0000OOo) {
                i2 = 3;
            }
            O0OOOOO.O000000o o000000o = new O0OOOOO.O000000o(i2, gVar.O0000o, gVar.O0000oO0, gVar.O0000Oo);
            o000000o.O0000Oo0 = gVar.O0000Oo0;
            arrayList.add(o000000o);
        }
        o0ooooo.O000000o(arrayList);
        this.O0000OoO.setMax(this.O00000o.size());
        O000000o(0, this.O00000o.size());
    }

    /* access modifiers changed from: private */
    public void O00000Oo(int i) {
        if (i >= 0 && i < this.O00000o.size() && isAdded()) {
            this.O0000OoO.incrementProgressBy(1);
            O000000o(i + 1, this.O00000o.size());
            g gVar = this.O00000o.get(i);
            O000000o o000000o = this.O00000Oo;
            if (o000000o != null) {
                o000000o.O000000o(gVar.O0000Oo);
            }
            ee childFragmentManager = getChildFragmentManager();
            String O000000o2 = O000000o(this.O00000oo.getId(), (long) i);
            Fragment O000000o3 = childFragmentManager.O000000o(O000000o2);
            if (O000000o3 == null) {
                O000000o3 = gVar.O000000o();
            }
            ei O000000o4 = childFragmentManager.O000000o();
            O000000o4.O000000o((int) R.anim.slide_in_right, (int) R.anim.slide_out_left);
            O000000o4.O00000Oo(this.O00000oo.getId(), O000000o3, O000000o2);
            O000000o4.O000000o((String) null);
            O000000o4.O00000o0();
        }
    }

    private synchronized void O00000o() {
        int i = this.O0000OOo + 1;
        this.O0000OOo = i;
        if (i < this.O00000o.size()) {
            O0OOOOO o0ooooo = this.O0000O0o;
            if (o0ooooo != null) {
                O0OOOOO.O000000o O000000o2 = o0ooooo.O000000o(i);
                if (O000000o2 != null) {
                    O000000o2.f6676O000000o = 3;
                }
                this.O0000Oo0.setCurrentItem(i, true);
                O00000Oo();
            }
            O00000Oo(i);
            return;
        }
        new Thread(new O0000O0o()).start();
    }
}
