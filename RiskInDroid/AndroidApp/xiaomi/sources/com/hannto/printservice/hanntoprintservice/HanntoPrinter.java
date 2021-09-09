package com.hannto.printservice.hanntoprintservice;

import _m_j.azd;
import _m_j.azf;
import _m_j.azg;
import _m_j.azh;
import _m_j.azi;
import _m_j.hma;
import _m_j.hmb;
import _m_j.hmd;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.print.PrintAttributes;
import android.print.PrinterCapabilitiesInfo;
import android.print.PrinterId;
import android.print.PrinterInfo;
import android.printservice.PrintService;
import android.util.Base64;
import android.util.Log;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.printer.PrintJobProxy;
import java.io.File;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class HanntoPrinter implements hmb {

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<PrinterId, DeviceStat> f4367O000000o = new HashMap();
    private ArrayList<PrinterInfo> O00000Oo = new ArrayList<>();

    public final List<PrinterInfo> O000000o() {
        Log.i("HanntoPrinterService", "HanntoPrinter getPrinters()");
        return this.O00000Oo;
    }

    public final void O00000Oo() {
        Log.i("HanntoPrinterService", "HanntoPrinter onConnected()");
    }

    public final void O00000o0() {
        Log.i("HanntoPrinterService", "HanntoPrinter onDisconnected()");
        this.O00000Oo.clear();
        try {
            if (azf.f12727O000000o != null && azf.f12727O000000o.getLooper() != null) {
                azf.f12727O000000o.getLooper().quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void O00000o() {
        Log.i("HanntoPrinterService", "HanntoPrinter onCreatePrinterDiscoverySession()");
    }

    @TargetApi(19)
    public final void O000000o(PrintService printService, hmd hmd, hma hma) {
        Log.i("HanntoPrinterService", "HanntoPrinter onStartPrinterDiscovery()");
        ArrayList arrayList = new ArrayList();
        arrayList.add("hannto.printer.anise");
        if (Build.VERSION.SDK_INT >= 21) {
            arrayList.add("hannto.printer.honey");
        }
        ArrayList<DeviceStat> device = hma.getDevice(arrayList);
        List<PrinterInfo> printers = hmd.f19058O000000o.getPrinters();
        if (device != null) {
            Log.i("HanntoPrinterService", "devices.size() = " + device.size());
            Iterator<DeviceStat> it = device.iterator();
            while (it.hasNext()) {
                DeviceStat next = it.next();
                Log.i("HanntoPrinterService", "deviceStat.did = " + next.did + " deviceStat.model = " + next.model + " deviceStat.name = " + next.name);
                PrinterId generatePrinterId = printService.generatePrinterId(next.did);
                this.f4367O000000o.put(generatePrinterId, next);
                PrinterInfo build = new PrinterInfo.Builder(generatePrinterId, next.name, 1).setDescription(next.mac).build();
                printers.add(build);
                this.O00000Oo.add(build);
            }
            hmd.O000000o(printers);
        }
    }

    public final void O00000oO() {
        Log.i("HanntoPrinterService", "HanntoPrinter onStopPrinterDiscovery()");
    }

    public final void O000000o(final hmd hmd, PrinterId printerId, final PrinterInfo printerInfo) {
        Log.i("HanntoPrinterService", "HanntoPrinter onStartPrinterStateTracking()");
        if (printerInfo == null) {
            Log.e("HanntoPrinterService", " checkPrinterStatus printer == null");
            O000000o(hmd, printerInfo, new PrinterCapabilitiesInfo.Builder(printerId).build(), 3);
        } else if ("hannto.printer.anise".equals(this.f4367O000000o.get(printerId).model)) {
            final PrinterCapabilitiesInfo build = new PrinterCapabilitiesInfo.Builder(printerId).addMediaSize(PrintAttributes.MediaSize.ISO_A4, true).addMediaSize(new PrintAttributes.MediaSize("4x6", "6寸照片", 4000, 6000), false).addResolution(new PrintAttributes.Resolution("R2", "300x300", 300, 300), true).setColorModes(3, 1).build();
            String str = this.f4367O000000o.get(printerId).did;
            String str2 = this.f4367O000000o.get(printerId).model;
            final PrinterId printerId2 = printerId;
            final hmd hmd2 = hmd;
            final PrinterInfo printerInfo2 = printerInfo;
            AnonymousClass1 r1 = new Callback<String>() {
                /* class com.hannto.printservice.hanntoprintservice.HanntoPrinter.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    String str = (String) obj;
                    try {
                        Log.i("HanntoPrinterService", " checkPrinterStatus 获取打印机状态返回 = ".concat(String.valueOf(str)));
                        String[] split = new JSONObject(str).getJSONObject(HanntoPrinter.this.f4367O000000o.get(printerId2).did).getString("prop.status").split(";");
                        for (String valueOf : split) {
                            Log.d("HanntoPrinterService", "onSuccess: s = ".concat(String.valueOf(valueOf)));
                        }
                        int intValue = Integer.valueOf(split[0]).intValue();
                        int i = 2;
                        if (!(1 == intValue || 2 == intValue || 3 == intValue || 5 == intValue)) {
                            if (6 != intValue) {
                                if (4 != intValue) {
                                    i = 3;
                                }
                                HanntoPrinter.O000000o(hmd2, printerInfo2, build, i);
                            }
                        }
                        i = 1;
                        HanntoPrinter.O000000o(hmd2, printerInfo2, build, i);
                    } catch (Exception e) {
                        Log.e("HanntoPrinterService", " checkPrinterStatus " + e.getMessage());
                        e.printStackTrace();
                        HanntoPrinter.O000000o(hmd2, printerInfo2, build, 3);
                    }
                }

                public final void onFailure(int i, String str) {
                    Log.e("HanntoPrinterService", " checkPrinterStatus  error = " + i + " errorInfo = " + str);
                    HanntoPrinter.O000000o(hmd2, printerInfo2, build, 3);
                }
            };
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("prop.status");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", str);
                jSONObject.put("props", jSONArray);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject);
            XmPluginHostApi.instance().batchGetDeviceProps(str2, jSONArray2, r1);
        } else if ("hannto.printer.honey".equals(this.f4367O000000o.get(printerId).model)) {
            final PrinterCapabilitiesInfo build2 = new PrinterCapabilitiesInfo.Builder(printerId).addMediaSize(new PrintAttributes.MediaSize("4x6", "6寸照片", 4000, 6000), true).addResolution(new PrintAttributes.Resolution("R2", "300x300", 300, 300), true).setColorModes(2, 2).build();
            String str3 = this.f4367O000000o.get(printerId).did;
            AnonymousClass2 r2 = new Callback<JSONObject>() {
                /* class com.hannto.printservice.hanntoprintservice.HanntoPrinter.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    int i;
                    try {
                        String string = ((JSONObject) obj).getString("category");
                        if (!"idle".equals(string) && !"sleep".equals(string)) {
                            if (!"off".equals(string)) {
                                i = "processing".equals(string) ? 2 : 3;
                                HanntoPrinter.O000000o(hmd, printerInfo, build2, i);
                            }
                        }
                        i = 1;
                        HanntoPrinter.O000000o(hmd, printerInfo, build2, i);
                    } catch (Exception e) {
                        Log.e("HanntoPrinterService", " checkPrinterStatus " + e.getMessage());
                        e.printStackTrace();
                        HanntoPrinter.O000000o(hmd, printerInfo, build2, 3);
                    }
                }

                public final void onFailure(int i, String str) {
                    Log.e("HanntoPrinterService", " checkPrinterStatus error = " + i + " errorInfo = " + str);
                    HanntoPrinter.O000000o(hmd, printerInfo, build2, 3);
                }
            };
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("method", "get_prop");
                jSONObject2.put("params", "status");
                Log.i("HanntoPrinterService", "getHoneyPrinterStatus");
                XmPluginHostApi.instance().callMethod(str3, jSONObject2.toString(), r2, Parser.DEFAULT_PARSER);
            } catch (Exception e2) {
                e2.printStackTrace();
                r2.onFailure(-1, e2.getMessage());
            }
        } else {
            Log.e("HanntoPrinterService", " checkPrinterStatus 未知model = " + this.f4367O000000o.get(printerId).model);
            O000000o(hmd, printerInfo, new PrinterCapabilitiesInfo.Builder(printerId).build(), 3);
        }
    }

    @TargetApi(19)
    public static void O000000o(hmd hmd, PrinterInfo printerInfo, PrinterCapabilitiesInfo printerCapabilitiesInfo, int i) {
        Log.i("HanntoPrinterService", "refreshPrinterStatus() printerStatus = ".concat(String.valueOf(i)));
        PrinterInfo build = new PrinterInfo.Builder(printerInfo).setCapabilities(printerCapabilitiesInfo).setStatus(i).build();
        ArrayList arrayList = new ArrayList();
        arrayList.add(build);
        hmd.O000000o(arrayList);
    }

    public final void O00000oo() {
        Log.i("HanntoPrinterService", "onStopPrinterStateTracking()");
    }

    public final void O0000O0o() {
        Log.i("HanntoPrinterService", "onDestroyPrinterDiscoverySession()");
    }

    public final void O0000OOo() {
        Log.i("HanntoPrinterService", "onValidatePrinters()");
    }

    @TargetApi(19)
    public final void O000000o(PrinterInfo printerInfo, final PrintJobProxy printJobProxy) {
        Log.i("HanntoPrinterService", "onRequestCancelPrintJob()");
        if (printJobProxy.isCancelled() || printJobProxy.isCompleted() || printJobProxy.isFailed()) {
            Log.i("HanntoPrinterService", "cancelJob()任务已结束");
            return;
        }
        int i = -1;
        try {
            i = Integer.valueOf(printJobProxy.getTag()).intValue();
            Log.i("HanntoPrinterService", "cancelJob()printJobId = ".concat(String.valueOf(i)));
        } catch (Exception e) {
            Log.i("HanntoPrinterService", "cancelJob()" + e.getMessage());
            e.printStackTrace();
        }
        if (i <= 0) {
            printJobProxy.cancel();
        } else if ("hannto.printer.anise".equals(this.f4367O000000o.get(printerInfo.getId()).model)) {
            azf.O000000o(this.f4367O000000o.get(printerInfo.getId()).did, i, new Callback<JSONObject>() {
                /* class com.hannto.printservice.hanntoprintservice.HanntoPrinter.AnonymousClass3 */

                public final void onFailure(int i, String str) {
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    String str;
                    JSONObject jSONObject = (JSONObject) obj;
                    Log.i("HanntoPrinterService", "cancelJob()" + jSONObject.toString());
                    try {
                        str = jSONObject.getString("result");
                    } catch (Exception e) {
                        e.printStackTrace();
                        str = "";
                    }
                    if (str.equals("OK")) {
                        printJobProxy.cancel();
                    }
                }
            });
        } else if ("hannto.printer.honey".equals(this.f4367O000000o.get(printerInfo.getId()).model)) {
            azf.O000000o(this.f4367O000000o.get(printerInfo.getId()).did, i, new Callback<JSONObject>() {
                /* class com.hannto.printservice.hanntoprintservice.HanntoPrinter.AnonymousClass4 */

                public final void onFailure(int i, String str) {
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Log.i("HanntoPrinterService", "cancelJob()" + jSONObject.toString());
                    try {
                        if ("OK".equals(jSONObject.getJSONArray("result").getString(0))) {
                            printJobProxy.cancel();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.i("HanntoPrinterService", "cancelJob()" + e.getMessage());
                    }
                }
            });
        }
    }

    @TargetApi(19)
    public final void O000000o(PrintService printService, PrinterInfo printerInfo, PrintJobProxy printJobProxy) {
        Log.i("HanntoPrinterService", "onPrintJobQueued");
        final Handler handler = new Handler(printService.getMainLooper());
        DeviceStat deviceStat = this.f4367O000000o.get(printerInfo.getId());
        azh azh = new azh();
        final PrintJobProxy printJobProxy2 = printJobProxy;
        final DeviceStat deviceStat2 = deviceStat;
        final PrintService printService2 = printService;
        AnonymousClass5 r2 = new azi() {
            /* class com.hannto.printservice.hanntoprintservice.HanntoPrinter.AnonymousClass5 */

            public final void O000000o() {
                Log.i("HanntoPrinterService", "onPrintJobQueued()onStart");
            }

            public final void O000000o(String str) {
                Log.i("HanntoPrinterService", "onPrintJobQueued()onGetUploadUrl uploadUrl = ".concat(String.valueOf(str)));
            }

            public final void O000000o(final String str, final String str2, final String str3) {
                Log.i("HanntoPrinterService", "onPrintJobQueued()onUploadSuccess downloadUrl = " + str + " sha1 = " + str2 + " fileName = " + str3);
                handler.post(new Runnable() {
                    /* class com.hannto.printservice.hanntoprintservice.HanntoPrinter.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        if (!printJobProxy2.isCancelled()) {
                            HanntoPrinter hanntoPrinter = HanntoPrinter.this;
                            PrintJobProxy printJobProxy = printJobProxy2;
                            DeviceStat deviceStat = deviceStat2;
                            String str = str;
                            String str2 = str2;
                            String str3 = str3;
                            PrintService printService = printService2;
                            Handler handler = handler;
                            if ("hannto.printer.anise".equals(deviceStat.model)) {
                                File file = new File(printService.getCacheDir(), str3);
                                String absolutePath = file.getAbsolutePath();
                                long j = 0;
                                if (file.exists()) {
                                    j = file.length() / 1024;
                                }
                                long j2 = j;
                                String accountId = XmPluginHostApi.instance().getAccountId();
                                String str4 = deviceStat.did;
                                AnonymousClass6 r2 = new azf.O000000o(handler, printJobProxy, printService, deviceStat) {
                                    /* class com.hannto.printservice.hanntoprintservice.HanntoPrinter.AnonymousClass6 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ Handler f4375O000000o;
                                    final /* synthetic */ PrintJobProxy O00000Oo;
                                    final /* synthetic */ DeviceStat O00000o;
                                    final /* synthetic */ PrintService O00000o0;

                                    {
                                        this.f4375O000000o = r2;
                                        this.O00000Oo = r3;
                                        this.O00000o0 = r4;
                                        this.O00000o = r5;
                                    }

                                    public final void O000000o() {
                                        Log.i("HanntoPrinterService", "submitPrintJob()onStart");
                                    }

                                    @TargetApi(19)
                                    public final void O000000o(boolean z, final int i, String str) {
                                        this.f4375O000000o.post(new Runnable() {
                                            /* class com.hannto.printservice.hanntoprintservice.HanntoPrinter.AnonymousClass6.AnonymousClass1 */

                                            public final void run() {
                                                Log.i("HanntoPrinterService", "submitPrintJob()printJobId = " + i);
                                                AnonymousClass6.this.O00000Oo.setTag(String.valueOf(i));
                                            }
                                        });
                                        HanntoPrinter.this.O000000o(z, i, str, this.O00000Oo, this.O00000o0, this.O00000o, this.f4375O000000o, "hannto.printer.anise");
                                    }
                                };
                                int copies = printJobProxy.getInfo().getCopies();
                                String str5 = printJobProxy.getInfo().getAttributes().getColorMode() == 2 ? "Color" : "Mono";
                                String str6 = printJobProxy.getDocumentInfo().getContentType() == 1 ? "Glossy" : "Plain";
                                int i = printJobProxy.getDocumentInfo().getContentType() == 1 ? 0 : 3;
                                String str7 = printJobProxy.getDocumentInfo().getContentType() == 1 ? "High" : "Normal";
                                String str8 = printJobProxy.getInfo().getAttributes().getMediaSize().getId().equals("4x6") ? "4x6" : "A4";
                                String substring = absolutePath.substring(absolutePath.lastIndexOf("/") + 1);
                                azg.O000000o();
                                azg.O000000o(new Runnable(r2, str4, str, substring, str2, copies, str5, str6, str8, accountId, 6672, i, j2, str7) {
                                    /* class _m_j.azf.AnonymousClass1 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ O000000o f12728O000000o;
                                    final /* synthetic */ String O00000Oo;
                                    final /* synthetic */ String O00000o;
                                    final /* synthetic */ String O00000o0;
                                    final /* synthetic */ String O00000oO;
                                    final /* synthetic */ int O00000oo;
                                    final /* synthetic */ String O0000O0o;
                                    final /* synthetic */ String O0000OOo;
                                    final /* synthetic */ String O0000Oo;
                                    final /* synthetic */ String O0000Oo0;
                                    final /* synthetic */ int O0000OoO = 6672;
                                    final /* synthetic */ int O0000Ooo;
                                    final /* synthetic */ String O0000o0;
                                    final /* synthetic */ long O0000o00;

                                    {
                                        this.f12728O000000o = r1;
                                        this.O00000Oo = r2;
                                        this.O00000o0 = r3;
                                        this.O00000o = r4;
                                        this.O00000oO = r5;
                                        this.O00000oo = r6;
                                        this.O0000O0o = r7;
                                        this.O0000OOo = r8;
                                        this.O0000Oo0 = r9;
                                        this.O0000Oo = r10;
                                        this.O0000Ooo = r12;
                                        this.O0000o00 = r13;
                                        this.O0000o0 = r15;
                                    }

                                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
                                     arg types: [java.lang.String, int]
                                     candidates:
                                      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
                                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                     method: org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
                                     arg types: [java.lang.String, int]
                                     candidates:
                                      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
                                      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject */
                                    public final void run() {
                                        this.f12728O000000o.O000000o();
                                        String str = this.O00000Oo;
                                        String str2 = this.O00000o0;
                                        String str3 = this.O00000o;
                                        String str4 = this.O00000oO;
                                        int i = this.O00000oo;
                                        String str5 = this.O0000O0o;
                                        String str6 = this.O0000OOo;
                                        String str7 = this.O0000Oo0;
                                        String str8 = this.O0000Oo;
                                        int i2 = this.O0000OoO;
                                        int i3 = this.O0000Ooo;
                                        long j = this.O0000o00;
                                        String str9 = this.O0000o0;
                                        AnonymousClass1 r16 = new Callback<JSONObject>() {
                                            /* class _m_j.azf.AnonymousClass1.AnonymousClass1 */

                                            public final /* synthetic */ void onSuccess(Object obj) {
                                                JSONObject jSONObject = (JSONObject) obj;
                                                Log.d("HanntoPrinterService", jSONObject.toString());
                                                try {
                                                    AnonymousClass1.this.f12728O000000o.O000000o(true, jSONObject.getInt("print_job_id"), null);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                    AnonymousClass1.this.f12728O000000o.O000000o(false, -1, e.getMessage());
                                                }
                                            }

                                            public final void onFailure(int i, String str) {
                                                AnonymousClass1.this.f12728O000000o.O000000o(false, -1, str);
                                            }
                                        };
                                        Log.i("HanntoPrinterService", "printAniseJob() url = " + str2 + " fileType = " + ((String) null) + " fileName = " + str3 + " sha1 = " + str4 + " copies = " + i + " color = " + str5 + " paper_type = " + str6 + " paper_size = " + str7);
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put("chn", i2);
                                            jSONObject.put("account", str8);
                                            jSONObject.put("url", str2);
                                            jSONObject.put("file_type", "pdf");
                                            jSONObject.put("file_name", str3);
                                            jSONObject.put("sha1", str4);
                                            jSONObject.put("file_size", j);
                                            jSONObject.put("copies", i);
                                            jSONObject.put("color", str5);
                                            jSONObject.put("paper_type", str6);
                                            jSONObject.put("paper_size", str7);
                                            jSONObject.put("print_quality", str9);
                                            jSONObject.put("send_time", System.currentTimeMillis() / 1000);
                                            jSONObject.put("job_type", i3);
                                            jSONObject.put("duplex", false);
                                            jSONObject.put("collate", false);
                                            jSONObject.put("output_order", "Reverse");
                                            jSONObject.put("ps", 0);
                                            jSONObject.put("rt", -1);
                                            jSONObject.put("pm", 4.2d);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        XmPluginHostApi.instance().callMethod(str, "print_job", jSONObject, r16, Parser.DEFAULT_PARSER);
                                    }
                                });
                            } else if ("hannto.printer.honey".equals(deviceStat.model)) {
                                String accountId2 = XmPluginHostApi.instance().getAccountId();
                                String str9 = deviceStat.did;
                                int copies2 = printJobProxy.getInfo().getCopies();
                                AnonymousClass7 r22 = new azf.O000000o(handler, printJobProxy, printService, deviceStat) {
                                    /* class com.hannto.printservice.hanntoprintservice.HanntoPrinter.AnonymousClass7 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ Handler f4377O000000o;
                                    final /* synthetic */ PrintJobProxy O00000Oo;
                                    final /* synthetic */ DeviceStat O00000o;
                                    final /* synthetic */ PrintService O00000o0;

                                    {
                                        this.f4377O000000o = r2;
                                        this.O00000Oo = r3;
                                        this.O00000o0 = r4;
                                        this.O00000o = r5;
                                    }

                                    public final void O000000o() {
                                        Log.i("HanntoPrinterService", "submitPrintJob()onStart");
                                    }

                                    public final void O000000o(boolean z, final int i, String str) {
                                        this.f4377O000000o.post(new Runnable() {
                                            /* class com.hannto.printservice.hanntoprintservice.HanntoPrinter.AnonymousClass7.AnonymousClass1 */

                                            public final void run() {
                                                Log.i("HanntoPrinterService", "submitPrintJob()printJobId = " + i);
                                                AnonymousClass7.this.O00000Oo.setTag(String.valueOf(i));
                                            }
                                        });
                                        HanntoPrinter.this.O000000o(z, i, str, this.O00000Oo, this.O00000o0, this.O00000o, this.f4377O000000o, "hannto.printer.honey");
                                    }
                                };
                                azg.O000000o();
                                azg.O000000o(new Runnable(r22, str9, str, str3, copies2, accountId2, "printer_service") {
                                    /* class _m_j.azf.AnonymousClass2 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ O000000o f12730O000000o;
                                    final /* synthetic */ String O00000Oo;
                                    final /* synthetic */ String O00000o;
                                    final /* synthetic */ String O00000o0;
                                    final /* synthetic */ int O00000oO;
                                    final /* synthetic */ String O00000oo;
                                    final /* synthetic */ String O0000O0o;

                                    {
                                        this.f12730O000000o = r1;
                                        this.O00000Oo = r2;
                                        this.O00000o0 = r3;
                                        this.O00000o = r4;
                                        this.O00000oO = r5;
                                        this.O00000oo = r6;
                                        this.O0000O0o = r7;
                                    }

                                    public final void run() {
                                        this.f12730O000000o.O000000o();
                                        String str = this.O00000Oo;
                                        String str2 = this.O00000o0;
                                        String str3 = this.O00000o;
                                        int i = this.O00000oO;
                                        String str4 = this.O00000oo;
                                        String str5 = this.O0000O0o;
                                        AnonymousClass1 r6 = new Callback<JSONObject>() {
                                            /* class _m_j.azf.AnonymousClass2.AnonymousClass1 */

                                            public final /* synthetic */ void onSuccess(Object obj) {
                                                JSONObject jSONObject = (JSONObject) obj;
                                                Log.d("HanntoPrinterService", "onSuccess " + jSONObject.toString());
                                                try {
                                                    AnonymousClass2.this.f12730O000000o.O000000o(true, jSONObject.getInt("print_job_id"), null);
                                                } catch (Exception e) {
                                                    AnonymousClass2.this.f12730O000000o.O000000o(false, -1, e.getMessage());
                                                    e.printStackTrace();
                                                }
                                            }

                                            public final void onFailure(int i, String str) {
                                                AnonymousClass2.this.f12730O000000o.O000000o(false, -1, str);
                                            }
                                        };
                                        Log.i("HanntoPrinterService", "printHoneyJob() url = " + str2 + " fileName = " + str3 + " copies = " + i);
                                        JSONObject jSONObject = new JSONObject();
                                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                                        try {
                                            jSONObject.put("channel", str5);
                                            jSONObject.put("account", str4);
                                            jSONObject.put("send_time", currentTimeMillis);
                                            jSONObject.put("url", str2);
                                            jSONObject.put("file_name", str3);
                                            jSONObject.put("copies", i);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        XmPluginHostApi.instance().callMethod(str, "print_job", jSONObject, r6, Parser.DEFAULT_PARSER);
                                    }
                                });
                            }
                        }
                    }
                });
            }

            public final void O000000o(int i, final String str) {
                Log.i("HanntoPrinterService", "onPrintJobQueued()onFailed failType = " + i + " reason = " + str);
                handler.post(new Runnable() {
                    /* class com.hannto.printservice.hanntoprintservice.HanntoPrinter.AnonymousClass5.AnonymousClass2 */

                    public final void run() {
                        printJobProxy2.fail(str);
                    }
                });
            }
        };
        r2.O000000o();
        if (deviceStat == null) {
            r2.O000000o(0, XmPluginHostApi.instance().application().getString(R.string.service_get_did_failed));
            return;
        }
        printJobProxy.start();
        try {
            if (!azh.O000000o(printService, printJobProxy, deviceStat, r2)) {
                Log.e(azh.f12733O000000o, "保存文件失败0");
                return;
            }
            azg.O000000o();
            azg.O000000o(new Runnable(deviceStat, printService, r2) {
                /* class _m_j.azh.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ DeviceStat f12734O000000o;
                final /* synthetic */ PrintService O00000Oo;
                final /* synthetic */ azi O00000o0;

                {
                    this.f12734O000000o = r2;
                    this.O00000Oo = r3;
                    this.O00000o0 = r4;
                }

                public final void run() {
                    String str;
                    try {
                        String str2 = "anise";
                        if (this.f12734O000000o.model.equals("hannto.printer.honey")) {
                            str2 = "honey";
                        } else if (!this.f12734O000000o.model.equals("hannto.printer.anise")) {
                            Log.e("HanntoPrinterService", "未知model deviceStat.model = " + this.f12734O000000o.model);
                        }
                        try {
                            str = this.O00000Oo.getPackageManager().getPackageInfo(this.O00000Oo.getPackageName(), 0).versionName;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String accountId = XmPluginHostApi.instance().getAccountId();
                        String absolutePath = new File(this.O00000Oo.getCacheDir(), azh.this.O00000oo).getAbsolutePath();
                        String name = new File(absolutePath).getName();
                        String O000000o2 = aze.O000000o(absolutePath);
                        azh azh = azh.this;
                        int nextInt = new Random().nextInt();
                        long currentTimeMillis = System.currentTimeMillis();
                        String str3 = str2;
                        String str4 = absolutePath;
                        byte[] bArr = new byte[12];
                        System.arraycopy(ByteBuffer.allocate(4).putInt(nextInt).array(), 0, bArr, 0, 4);
                        System.arraycopy(ByteBuffer.allocate(4).putInt((int) (currentTimeMillis / 1000)).array(), 0, bArr, 4, 4);
                        System.arraycopy(ByteBuffer.allocate(4).putInt((int) (currentTimeMillis % 1000)).array(), 0, bArr, 8, 4);
                        String trim = Base64.encodeToString(bArr, 0).trim();
                        byte[] bytes = "e9zH1USvw82YVpk7OdloAIibqKZRGrEj".getBytes("utf-8");
                        byte[] bArr2 = new byte[(bytes.length + 12)];
                        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
                        System.arraycopy(bArr, 0, bArr2, bytes.length, 12);
                        MessageDigest instance = MessageDigest.getInstance("SHA-256");
                        instance.update(bArr2);
                        String format = String.format("%s&%s&%s&%s", "GET", "/v1/c/res/gen/presigned_url/", "IxomR6MCjsO3Ared", Base64.encodeToString(instance.digest(), 0).trim());
                        Log.d(azh.f12733O000000o, String.format("sha1String: %s", format));
                        MessageDigest instance2 = MessageDigest.getInstance("SHA-1");
                        instance2.update(format.getBytes());
                        String trim2 = Base64.encodeToString(instance2.digest(), 0).trim();
                        Log.d(azh.f12733O000000o, String.format("PERMISSION-API-NONCE: %s\nPERMISSION-API-SIGNATURE: %s", trim, trim2));
                        azh.O00000Oo = trim;
                        azh.O00000o0 = trim2;
                        String str5 = "https://api.hannto.com/v1/c/res/gen/presigned_url/?file_name=" + name + "&sha1=" + O000000o2 + "&model=" + str3 + "&uid=" + accountId + "&useto=print_file";
                        Log.i(azh.this.f12733O000000o, "finalString = " + str5 + " mNonce = " + azh.this.O00000Oo + " mSign = " + azh.this.O00000o0);
                        Response execute = azh.this.O00000oO.newCall(new Request.Builder().header("API-SIGNATURE", "permission").header("PERMISSION-API-KEY", "IxomR6MCjsO3Ared").header("PERMISSION-CLIENT-VERSION", str).header("PERMISSION-API-NONCE", azh.this.O00000Oo).header("PERMISSION-API-SIGNATURE", azh.this.O00000o0).url(str5).build()).execute();
                        if (execute.isSuccessful()) {
                            String string = execute.body().string();
                            Log.d(azh.this.f12733O000000o, "bodyString = ".concat(String.valueOf(string)));
                            JSONObject jSONObject = new JSONObject(string);
                            String string2 = jSONObject.getString("code");
                            String string3 = jSONObject.getString("message");
                            Log.d(azh.this.f12733O000000o, "code = " + string2 + " message = " + string3);
                            if (string2.equals("0")) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                                String string4 = jSONObject2.getString("presigned_url");
                                long j = jSONObject2.getLong("expiration");
                                Log.d(azh.this.f12733O000000o, "presigned_url = " + string4 + " expiration = " + j);
                                this.O00000o0.O000000o(string4);
                                azh.this.O000000o(str4, string4, O000000o2, this.O00000o0);
                                return;
                            }
                            Log.e(azh.this.f12733O000000o, "error_data = ".concat(String.valueOf(jSONObject.getString("error_data"))));
                            this.O00000o0.O000000o(0, XmPluginHostApi.instance().application().getString(R.string.service_upload_file_failed));
                            return;
                        }
                        Log.e(azh.this.f12733O000000o, execute.toString());
                        this.O00000o0.O000000o(0, XmPluginHostApi.instance().application().getString(R.string.service_upload_file_failed));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        this.O00000o0.O000000o(0, XmPluginHostApi.instance().application().getString(R.string.service_upload_file_failed));
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(azh.f12733O000000o, "保存文件失败", e);
            r2.O000000o(0, XmPluginHostApi.instance().application().getString(R.string.service_save_file_failed));
        }
    }

    @TargetApi(19)
    public final void O000000o(boolean z, int i, String str, PrintJobProxy printJobProxy, PrintService printService, DeviceStat deviceStat, Handler handler, String str2) {
        final boolean z2 = z;
        final int i2 = i;
        final String str3 = str;
        final PrintService printService2 = printService;
        final DeviceStat deviceStat2 = deviceStat;
        final PrintJobProxy printJobProxy2 = printJobProxy;
        final Handler handler2 = handler;
        final String str4 = str2;
        handler.post(new Runnable() {
            /* class com.hannto.printservice.hanntoprintservice.HanntoPrinter.AnonymousClass8 */

            public final void run() {
                Log.i("HanntoPrinterService", "handleSubmitResult()isSuccess = " + z2 + " printJobId = " + i2 + " reason = " + str3);
                if (z2) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                    newScheduledThreadPool.scheduleWithFixedDelay(new azd(printService2, i2, deviceStat2.did, newScheduledThreadPool, printJobProxy2, handler2, str4), 20, 10000, TimeUnit.MILLISECONDS);
                    return;
                }
                printJobProxy2.fail(XmPluginHostApi.instance().application().getString(R.string.service_submit_file_failed));
            }
        });
    }
}
