package a.a.a.f.d;

import _m_j.O0OO0O;
import a.a.a.e.c.a;
import a.a.a.e.c.c;
import a.a.a.e.c.d;
import a.a.a.e.c.e;
import a.a.a.e.c.f;
import a.a.a.e.c.g;
import a.a.a.e.c.h;
import a.a.a.e.c.j;
import a.a.a.e.c.k;
import a.a.a.e.c.l;
import a.a.a.e.c.m;
import a.a.a.e.c.n;
import a.a.a.e.c.o;
import a.a.a.e.c.p;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import in.cashify.otex.ExchangeManager;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends O0OO0O implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public List<g> f2623O000000o;

    public static /* synthetic */ class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final /* synthetic */ int[] f2624O000000o = new int[ExchangeManager.h.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(74:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|(3:73|74|76)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(76:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|76) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00da */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fe */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x010a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0116 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0122 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x013a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0146 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0152 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x015e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x016a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0176 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0182 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x018e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x019a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x01a6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x01b2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f2624O000000o[ExchangeManager.h.WELCOME_PAGE.ordinal()] = 1;
            f2624O000000o[ExchangeManager.h.QUOTE_PAGE.ordinal()] = 2;
            f2624O000000o[ExchangeManager.h.MOBILE_AGE.ordinal()] = 3;
            f2624O000000o[ExchangeManager.h.WIFI.ordinal()] = 4;
            f2624O000000o[ExchangeManager.h.BLUETOOTH.ordinal()] = 5;
            f2624O000000o[ExchangeManager.h.MICROPHONE.ordinal()] = 6;
            f2624O000000o[ExchangeManager.h.FRONT_CAMERA.ordinal()] = 7;
            f2624O000000o[ExchangeManager.h.BACK_CAMERA.ordinal()] = 8;
            f2624O000000o[ExchangeManager.h.BATTERY.ordinal()] = 9;
            f2624O000000o[ExchangeManager.h.SPEAKER.ordinal()] = 10;
            f2624O000000o[ExchangeManager.h.VOLUME.ordinal()] = 11;
            f2624O000000o[ExchangeManager.h.CHARGING.ordinal()] = 12;
            f2624O000000o[ExchangeManager.h.AUDIO_JACK.ordinal()] = 13;
            f2624O000000o[ExchangeManager.h.MANUAL_WEB_PAGE.ordinal()] = 14;
            f2624O000000o[ExchangeManager.h.PROXIMITY_SENSOR.ordinal()] = 15;
            f2624O000000o[ExchangeManager.h.TELEPHONY_TEST.ordinal()] = 16;
            f2624O000000o[ExchangeManager.h.VIBRATION.ordinal()] = 17;
            f2624O000000o[ExchangeManager.h.MANUAL_SINGLE_CHOICE.ordinal()] = 18;
            f2624O000000o[ExchangeManager.h.MANUAL_MULTI_CHOICE.ordinal()] = 19;
            f2624O000000o[ExchangeManager.h.MANUAL_DROPDOWN.ordinal()] = 20;
            f2624O000000o[ExchangeManager.h.GPS.ordinal()] = 21;
            f2624O000000o[ExchangeManager.h.PROMPT_PAGE.ordinal()] = 22;
            f2624O000000o[ExchangeManager.h.ZERO_QUOTE_PAGE.ordinal()] = 23;
            f2624O000000o[ExchangeManager.h.TOUCH_CALIBRATION.ordinal()] = 24;
            f2624O000000o[ExchangeManager.h.DEAD_PIXEL.ordinal()] = 25;
            f2624O000000o[ExchangeManager.h.SENSOR_ACCELEROMETER.ordinal()] = 26;
            f2624O000000o[ExchangeManager.h.SENSOR_COMPASS.ordinal()] = 27;
            f2624O000000o[ExchangeManager.h.SENSOR_GYROSCOPE.ordinal()] = 28;
            f2624O000000o[ExchangeManager.h.BUTTON_BACK.ordinal()] = 29;
            f2624O000000o[ExchangeManager.h.BUTTON_HOME.ordinal()] = 30;
            f2624O000000o[ExchangeManager.h.BUTTON_RECENT_APPS.ordinal()] = 31;
            f2624O000000o[ExchangeManager.h.SIM_CARD.ordinal()] = 32;
            f2624O000000o[ExchangeManager.h.SPEAKER_RECEIVER.ordinal()] = 33;
            f2624O000000o[ExchangeManager.h.POWER_BUTTON.ordinal()] = 34;
            f2624O000000o[ExchangeManager.h.REMARK.ordinal()] = 35;
            f2624O000000o[ExchangeManager.h.FINGERPRINT.ordinal()] = 36;
            try {
                f2624O000000o[ExchangeManager.h.NONE.ordinal()] = 37;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public b(Parcel parcel) {
        this.f2623O000000o = parcel.createTypedArrayList(g.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f2623O000000o);
    }

    public class O000000o implements Parcelable.Creator<b> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new b[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new b(parcel);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public b(String str) {
        g gVar;
        JSONArray jSONArray = new JSONObject(str).getJSONArray("tl");
        if (jSONArray == null || jSONArray.length() <= 0) {
            throw new InvalidObjectException("Invalid response");
        }
        try {
            this.f2623O000000o = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                switch (O00000Oo.f2624O000000o[ExchangeManager.h.a(jSONObject.optString("tid")).ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 14:
                    case 16:
                    case 18:
                    case 19:
                    case 20:
                    case 22:
                    case 23:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                        gVar = null;
                        break;
                    case 4:
                        gVar = new p(jSONObject);
                        break;
                    case 5:
                        gVar = new c(jSONObject);
                        break;
                    case 6:
                        gVar = new j(jSONObject);
                        break;
                    case 7:
                        gVar = new d(jSONObject);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        gVar = new d(jSONObject);
                        break;
                    case 9:
                        gVar = new a.a.a.e.c.b(jSONObject);
                        break;
                    case 10:
                        gVar = new l(jSONObject);
                        break;
                    case 11:
                        gVar = new o(jSONObject);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        gVar = new e(jSONObject);
                        break;
                    case 13:
                        gVar = new a(jSONObject);
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                        gVar = new k(jSONObject);
                        break;
                    case 17:
                        gVar = new n(jSONObject);
                        break;
                    case 21:
                        gVar = new h(jSONObject);
                        break;
                    case 24:
                        gVar = new m(jSONObject);
                        break;
                    case 25:
                        gVar = new f(jSONObject);
                        break;
                    default:
                        gVar = null;
                        break;
                }
                if (gVar != null && (!TextUtils.isEmpty(gVar.O0000Oo0))) {
                    this.f2623O000000o.add(gVar);
                }
            }
        } catch (JSONException e) {
            this.f2623O000000o = null;
            throw e;
        }
    }
}
