package com.xiaomi.smarthome.camera.activity.alarm2.util;

import _m_j.gkv;
import android.text.TextUtils;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.mijia.model.alarmcloud.FaceInfoMeta;
import com.xiaomi.smarthome.R;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Alarm2Utils {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r3.equals("AI") != false) goto L_0x0057;
     */
    public static int getIntByType(String str) {
        char c = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        switch (str.hashCode()) {
            case -1293551627:
                if (str.equals("ObjectMotion")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -740191200:
                if (str.equals("KnownFace")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2088:
                break;
            case 80127:
                if (str.equals("Pet")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 2181757:
                if (str.equals("Face")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 722651973:
                if (str.equals("PeopleMotion")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1316906260:
                if (str.equals("BabyCry")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 10;
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 40;
            case 4:
                return 50;
            case 5:
                return 60;
            case 6:
                return 70;
            default:
                return 80;
        }
    }

    private static void sort(String[] strArr) {
        if (strArr != null && strArr.length > 1) {
            Arrays.sort(strArr, new Comparator<String>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.util.Alarm2Utils.AnonymousClass1 */

                public final int compare(String str, String str2) {
                    return Alarm2Utils.getIntByType(str) - Alarm2Utils.getIntByType(str2);
                }
            });
        }
    }

    private static String arrayToString(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String append : strArr) {
            sb.append(append);
            sb.append(":");
        }
        return sb.toString();
    }

    public static String[] sortEventTypes(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(":")) == null) {
            return null;
        }
        sort(split);
        while (split.length >= 2) {
            int length = split.length;
            String arrayToString = arrayToString(split);
            if (arrayToString.contains("AI")) {
                arrayToString = arrayToString.replace("BabyCry", "").replace("KnownFace", "").replace("Face", "").replace("Pet", "").replace("PeopleMotion", "").replace("ObjectMotion", "");
            } else if ((arrayToString.contains("KnownFace") || arrayToString.contains("Face")) && (arrayToString.contains("PeopleMotion") || arrayToString.contains("ObjectMotion"))) {
                arrayToString = arrayToString.replace("PeopleMotion", "").replace("ObjectMotion", "");
            } else if (arrayToString.contains("Pet")) {
                arrayToString = arrayToString.replace("ObjectMotion", "");
            } else if (arrayToString.contains("PeopleMotion")) {
                arrayToString = arrayToString.replace("ObjectMotion", "");
            }
            split = arrayToString.split(":");
            int length2 = split.length;
            if (length2 != length || length2 <= 2) {
                if (length2 == 2 && length2 == length) {
                    break;
                }
            } else {
                split = (String[]) Arrays.copyOfRange(split, 0, split.length - 1);
            }
        }
        return split;
    }

    public static String getEventName(AlarmVideo alarmVideo, String[] strArr) {
        String str;
        if (alarmVideo == null || strArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            if (str2.equals("AI")) {
                sb.append(gkv.f17949O000000o.getResources().getString(R.string.ai_scene_desc));
            } else if (str2.equals("BabyCry")) {
                sb.append(gkv.f17949O000000o.getResources().getString(R.string.baby_cry_desc));
            } else if (str2.equals("KnownFace") || str2.equals("Face")) {
                if (alarmVideo.fileIdMetaResult != null && alarmVideo.fileIdMetaResult.faceInfoMetas != null) {
                    Iterator<FaceInfoMeta> it = alarmVideo.fileIdMetaResult.faceInfoMetas.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FaceInfoMeta next = it.next();
                        if (next != null && next.matched) {
                            str = next.figureName;
                            break;
                        }
                    }
                }
                str = "";
                if (!TextUtils.isEmpty(str)) {
                    sb.append(String.format(gkv.f17949O000000o.getResources().getString(R.string.known_people_desc), str.trim()));
                } else {
                    sb.append(gkv.f17949O000000o.getResources().getString(R.string.unknown_people_desc));
                }
            } else if (str2.equals("Pet")) {
                sb.append(gkv.f17949O000000o.getResources().getString(R.string.event_type_pet));
            } else if (str2.equals("PeopleMotion")) {
                sb.append(gkv.f17949O000000o.getResources().getString(R.string.event_type_people_motion));
            } else if (str2.equals("ObjectMotion")) {
                sb.append(gkv.f17949O000000o.getResources().getString(R.string.event_type_obj_motion));
            }
            sb.append(gkv.f17949O000000o.getResources().getString(R.string.and));
        }
        sb.replace(sb.length() - gkv.f17949O000000o.getResources().getString(R.string.and).length(), sb.length(), "!");
        return sb.toString();
    }
}
