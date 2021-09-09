package com.xiaomi.smarthome.camera.v4.utils;

import _m_j.cki;
import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.Spanned;
import com.xiaomi.smarthome.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util {
    public static String getSdCardStatus(Resources resources, int i) {
        String string = resources.getString(R.string.sd_card_status0);
        if (i == 1) {
            return resources.getString(R.string.sd_card_status1);
        }
        if (i == 2) {
            return resources.getString(R.string.sd_card_status2);
        }
        if (i == 3) {
            return resources.getString(R.string.sd_card_status3);
        }
        if (i == 4) {
            return resources.getString(R.string.sd_card_status4);
        }
        if (i != 5) {
            return string;
        }
        return resources.getString(R.string.sd_card_status5);
    }

    public static String getNasCycle(Resources resources, int i) {
        switch (i) {
            case 86400:
                return resources.getString(R.string.nas_recycle_day);
            case 604800:
                return resources.getString(R.string.nas_recycle_week);
            case 2592000:
                return resources.getString(R.string.nas_recycle_month);
            case 7776000:
                return resources.getString(R.string.nas_recycle_3_months);
            default:
                return "";
        }
    }

    public static String getNasSyncInterval(Resources resources, int i) {
        if (i == 300) {
            return resources.getString(R.string.nas_sync_interval_real_time);
        }
        if (i == 3600) {
            return resources.getString(R.string.nas_sync_interval_1_hour);
        }
        if (i != 86400) {
            return null;
        }
        return resources.getString(R.string.nas_sync_interval_1_day);
    }

    public static String getProgress(Resources resources, int i) {
        if (i < 20) {
            return resources.getString(R.string.connect_step1);
        }
        if (i < 40) {
            return resources.getString(R.string.connect_step2);
        }
        if (i < 70) {
            return resources.getString(R.string.connect_step3);
        }
        if (i < 80) {
            return resources.getString(R.string.connect_step4);
        }
        return resources.getString(R.string.connect_step5);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0046=Splitter:B:27:0x0046, B:14:0x002d=Splitter:B:14:0x002d} */
    public static Spanned getRawTxt(Resources resources, int i) {
        if (i < 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        InputStream openRawResource = resources.openRawResource(i);
        if (openRawResource != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (IOException e) {
                    e.printStackTrace();
                    if (openRawResource != null) {
                        try {
                            openRawResource.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    bufferedReader.close();
                } catch (Throwable th) {
                    if (openRawResource != null) {
                        try {
                            openRawResource.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            }
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            try {
                bufferedReader.close();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return Html.fromHtml(sb.toString());
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String getRawTxt2(Resources resources, int i) {
        if (i < 0) {
            return null;
        }
        InputStream openRawResource = resources.openRawResource(i);
        InputStreamReader inputStreamReader = new InputStreamReader(openRawResource);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(10);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                break;
            } catch (Exception unused) {
            }
        }
        bufferedReader.close();
        inputStreamReader.close();
        openRawResource.close();
        return sb.toString();
    }

    public static int getFD() {
        try {
            File file = new File("/proc/self/fd/");
            if (!file.exists() || file.listFiles() == null) {
                return 0;
            }
            return file.listFiles().length;
        } catch (Exception e) {
            cki.O00000o0("getFD", e.getLocalizedMessage());
            return 0;
        }
    }
}
