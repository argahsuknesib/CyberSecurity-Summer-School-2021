package _m_j;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.printer.PrintJobProxy;
import java.util.concurrent.ScheduledExecutorService;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.json.JSONObject;

public final class azd implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f12722O000000o = false;
    public PrintJobProxy O00000Oo;
    public Context O00000o;
    Handler O00000o0;
    public int O00000oO = 0;
    private int O00000oo;
    private String O0000O0o;
    private boolean O0000OOo = false;
    private ScheduledExecutorService O0000Oo;
    private String O0000Oo0 = "";
    private String O0000OoO;
    private int O0000Ooo = 1;
    private int O0000o00 = 0;

    public azd(Context context, int i, String str, ScheduledExecutorService scheduledExecutorService, PrintJobProxy printJobProxy, Handler handler, String str2) {
        this.O00000o = context;
        this.O00000oo = i;
        this.O0000O0o = str;
        this.O0000Oo = scheduledExecutorService;
        this.O00000Oo = printJobProxy;
        this.O00000o0 = handler;
        this.O0000OoO = str2;
    }

    public final void run() {
        Log.v("HanntoPrinterService", " QueryJobStatusRunnable 开始一次查询");
        this.O0000o00++;
        if (this.O0000o00 > 60) {
            O000000o(false, this.O00000o.getString(R.string.service_overtime));
            this.O0000Oo.shutdown();
            Log.d("HanntoPrinterService", " QueryJobStatusRunnable 停止打印任务状态查询");
        } else if (this.f12722O000000o) {
            this.O0000Oo.shutdown();
            Log.d("HanntoPrinterService", " QueryJobStatusRunnable 停止打印任务状态查询");
        } else {
            JSONObject jSONObject = new JSONObject();
            int i = this.O00000oo;
            if (i != -1) {
                try {
                    jSONObject.put("print_job_id", i);
                    if (this.O0000OoO.equals("hannto.printer.honey")) {
                        int i2 = this.O0000Ooo;
                        this.O0000Ooo = i2 + 1;
                        jSONObject.put("query_id", i2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            XmPluginHostApi.instance().callMethod(this.O0000O0o, "job_status", jSONObject, new Callback<JSONObject>() {
                /* class _m_j.azd.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    String O000000o2 = azd.this.O000000o(jSONObject);
                    Log.i("HanntoPrinterService", " QueryJobStatusRunnable result = " + jSONObject.toString() + " jobStatus = " + O000000o2);
                    if ("parse_error".equals(O000000o2)) {
                        Log.e("HanntoPrinterService", " QueryJobStatusRunnable 获取状态异常");
                        azd.this.O00000oO++;
                        if (azd.this.O00000oO > 3) {
                            azd.this.f12722O000000o = true;
                            Log.d("HanntoPrinterService", " QueryJobStatusRunnable 无法获取到状态，不再获取");
                            azd azd = azd.this;
                            azd.O000000o(false, azd.O00000o.getString(R.string.service_get_job_failed));
                        }
                    } else if (("finished".equals(O000000o2) || "canceled".equals(O000000o2)) && !azd.this.f12722O000000o) {
                        azd.this.f12722O000000o = true;
                        Log.d("HanntoPrinterService", " QueryJobStatusRunnable 打印完成");
                        azd.this.O000000o(true, null);
                    } else if (azd.O00000Oo(O000000o2)) {
                        azd.this.f12722O000000o = true;
                        Log.d("HanntoPrinterService", " QueryJobStatusRunnable 打印机任务异常结束");
                        azd azd2 = azd.this;
                        azd2.O000000o(false, azd2.O00000o.getString(R.string.service_job_error));
                    } else if (azd.O000000o(O000000o2)) {
                        Log.w("HanntoPrinterService", "QueryJobStatusRunnable 打印机任务状态异常");
                        azd azd3 = azd.this;
                        azd3.O00000o0.post(new Runnable(O000000o2) {
                            /* class _m_j.azd.AnonymousClass2 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ String f12724O000000o;

                            {
                                this.f12724O000000o = r2;
                            }

                            public final void run() {
                                String str;
                                if (azd.this.O00000Oo.isStarted()) {
                                    String str2 = this.f12724O000000o;
                                    char c = 65535;
                                    switch (str2.hashCode()) {
                                        case -2049695130:
                                            if (str2.equals("anise_out_of_paper")) {
                                                c = 12;
                                                break;
                                            }
                                            break;
                                        case -2011551112:
                                            if (str2.equals("anise_paper_short")) {
                                                c = 16;
                                                break;
                                            }
                                            break;
                                        case -1664977087:
                                            if (str2.equals("PaperEmpty")) {
                                                c = 1;
                                                break;
                                            }
                                            break;
                                        case -1664826372:
                                            if (str2.equals("PaperError")) {
                                                c = 7;
                                                break;
                                            }
                                            break;
                                        case -1522912842:
                                            if (str2.equals("PaperLengthError")) {
                                                c = 10;
                                                break;
                                            }
                                            break;
                                        case -1345110503:
                                            if (str2.equals("HwError")) {
                                                c = 8;
                                                break;
                                            }
                                            break;
                                        case -791648701:
                                            if (str2.equals("PaperEjectError")) {
                                                c = 9;
                                                break;
                                            }
                                            break;
                                        case -759368191:
                                            if (str2.equals("NoPaperTray")) {
                                                c = 2;
                                                break;
                                            }
                                            break;
                                        case -650140598:
                                            if (str2.equals("anise_paper_out")) {
                                                c = 14;
                                                break;
                                            }
                                            break;
                                        case -584581227:
                                            if (str2.equals("NoInkRibbonMarker")) {
                                                c = 5;
                                                break;
                                            }
                                            break;
                                        case -504805509:
                                            if (str2.equals("NoInkRibbon")) {
                                                c = 3;
                                                break;
                                            }
                                            break;
                                        case 102479310:
                                            if (str2.equals("anise_no_pick")) {
                                                c = 13;
                                                break;
                                            }
                                            break;
                                        case 451649279:
                                            if (str2.equals("anise_paper_sensor_center_error")) {
                                                c = 18;
                                                break;
                                            }
                                            break;
                                        case 474693192:
                                            if (str2.equals("anise_paper_size_mismatch")) {
                                                c = 15;
                                                break;
                                            }
                                            break;
                                        case 891052844:
                                            if (str2.equals("InkRibbonError")) {
                                                c = 6;
                                                break;
                                            }
                                            break;
                                        case 1182628106:
                                            if (str2.equals("PaperJam")) {
                                                c = 0;
                                                break;
                                            }
                                            break;
                                        case 1301484287:
                                            if (str2.equals("InkRibbonEnd")) {
                                                c = 4;
                                                break;
                                            }
                                            break;
                                        case 1956590186:
                                            if (str2.equals("anise_door_open")) {
                                                c = 11;
                                                break;
                                            }
                                            break;
                                        case 2063625534:
                                            if (str2.equals("anise_paper_sensor")) {
                                                c = 17;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (c) {
                                        case 0:
                                            str = azd.this.O00000o.getString(R.string.paper_jam_title);
                                            break;
                                        case 1:
                                            str = azd.this.O00000o.getString(R.string.OOP_title);
                                            break;
                                        case 2:
                                            str = azd.this.O00000o.getString(R.string.tray_missing_title);
                                            break;
                                        case 3:
                                            str = azd.this.O00000o.getString(R.string.ribbon_missing_title);
                                            break;
                                        case 4:
                                            str = azd.this.O00000o.getString(R.string.ribbon_end_title);
                                            break;
                                        case 5:
                                        case 6:
                                            str = azd.this.O00000o.getString(R.string.ribbon_error_title);
                                            break;
                                        case 7:
                                            str = azd.this.O00000o.getString(R.string.photo_paper_error_title);
                                            break;
                                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                            str = azd.this.O00000o.getString(R.string.hardware_error_title);
                                            break;
                                        case 9:
                                            str = azd.this.O00000o.getString(R.string.paper_eject_title);
                                            break;
                                        case 10:
                                            str = azd.this.O00000o.getString(R.string.paper_length_title);
                                            break;
                                        case 11:
                                            str = azd.this.O00000o.getString(R.string.door_close_sub);
                                            break;
                                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                        case 13:
                                        case 14:
                                            str = azd.this.O00000o.getString(R.string.OOP_sub);
                                            break;
                                        case GmsLogger.MAX_PII_TAG_LENGTH:
                                            str = azd.this.O00000o.getString(R.string.paper_size_sub);
                                            break;
                                        case 16:
                                            str = azd.this.O00000o.getString(R.string.paper_short_sub);
                                            break;
                                        case 17:
                                        case 18:
                                            str = azd.this.O00000o.getString(R.string.paper_align_sub);
                                            break;
                                        default:
                                            str = azd.this.O00000o.getString(R.string.service_job_error);
                                            break;
                                    }
                                    azd.this.O00000Oo.block(str);
                                }
                            }
                        });
                    } else {
                        Log.d("HanntoPrinterService", "QueryJobStatusRunnable 打印机任务状态正常");
                        azd azd4 = azd.this;
                        azd4.O00000o0.post(new Runnable() {
                            /* class _m_j.azd.AnonymousClass3 */

                            public final void run() {
                                if (azd.this.O00000Oo.isBlocked()) {
                                    azd.this.O00000Oo.start();
                                }
                            }
                        });
                    }
                }

                public final void onFailure(int i, String str) {
                    Log.d("HanntoPrinterService", "onFailure: ".concat(String.valueOf(str)));
                    azd.this.O00000oO++;
                    if (azd.this.O00000oO > 3) {
                        azd.this.f12722O000000o = true;
                        Log.d("HanntoPrinterService", "无法获取到状态，不再获取");
                        azd azd = azd.this;
                        azd.O000000o(false, azd.O00000o.getString(R.string.service_get_job_failed));
                    }
                }
            }, Parser.DEFAULT_PARSER);
        }
    }

    public final String O000000o(JSONObject jSONObject) {
        try {
            if (this.O0000OoO.equals("hannto.printer.anise")) {
                int i = jSONObject.getJSONArray("result").getJSONObject(0).getInt("jm_state");
                int i2 = jSONObject.getJSONArray("result").getJSONObject(0).getInt("jm_state_reason");
                Log.d("HanntoPrinterService", "jm_state = " + i + " jm_state_reason = " + i2);
                if (i != 4) {
                    if (i != 5) {
                        if (i == 2) {
                            if (i2 == 46) {
                                return "anise_paper_sensor";
                            }
                            if (i2 == 48) {
                                return "anise_paper_sensor_center_error";
                            }
                            if (i2 == 66) {
                                return "anise_paper_size_mismatch";
                            }
                            if (i2 == 67) {
                                return "anise_paper_short";
                            }
                            switch (i2) {
                                case 60:
                                    return "anise_door_open";
                                case 61:
                                    return "anise_out_of_paper";
                                case 62:
                                    return "anise_no_pick";
                                case 63:
                                    return "anise_paper_out";
                                default:
                                    return "printer_error";
                            }
                        } else if (i == 3) {
                            return "aborted";
                        } else {
                            return "";
                        }
                    }
                }
                return "finished";
            } else if (this.O0000OoO.equals("hannto.printer.honey")) {
                return jSONObject.getJSONArray("result").getJSONObject(0).getString("job_state");
            } else {
                Log.e("HanntoPrinterService", "错误的model = " + this.O0000OoO);
                return "parse_error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "parse_error";
        }
    }

    public static boolean O000000o(String str) {
        return "PaperJam".equals(str) || "PaperEmpty".equals(str) || "NoPaperTray".equals(str) || "NoInkRibbon".equals(str) || "InkRibbonEnd".equals(str) || "NoInkRibbonMarker".equals(str) || "PaperError".equals(str) || "InkRibbonError".equals(str) || "HwError".equals(str) || "PaperEjectError".equals(str) || "PaperLengthError".equals(str) || "anise_door_open".equals(str) || "anise_out_of_paper".equals(str) || "anise_no_pick".equals(str) || "anise_paper_out".equals(str) || "anise_paper_size_mismatch".equals(str) || "anise_paper_short".equals(str) || "anise_paper_sensor".equals(str) || "anise_paper_sensor_center_error".equals(str) || "printer_error".equals(str);
    }

    public static boolean O00000Oo(String str) {
        return "aborted".equals(str);
    }

    public final void O000000o(final boolean z, final String str) {
        this.O00000o0.post(new Runnable() {
            /* class _m_j.azd.AnonymousClass4 */

            public final void run() {
                if (!azd.this.O00000Oo.isFailed() && !azd.this.O00000Oo.isCompleted() && !azd.this.O00000Oo.isCancelled()) {
                    if (z) {
                        azd.this.O00000Oo.complete();
                    } else {
                        azd.this.O00000Oo.fail(str);
                    }
                }
            }
        });
    }
}
