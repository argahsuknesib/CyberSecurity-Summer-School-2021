package _m_j;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.MiioDeviceV2;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.activity.SmartHomeLauncherActivity;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import com.xiaomi.smarthome.scene.geofence.manager.model.GeoFenceItem;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hnw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int[] f390O000000o = {R.drawable.intelligence_icon_if_nor, R.drawable.intelligence_icon_ifonly_nor};
    private static String[] O00000Oo = {"lumi.gateway.v1", "lumi.gateway.v2", "lumi.gateway.v3", "lumi.acpartner.v1", "lumi.acpartner.v2", "lumi.camera.v1", "lumi.camera.aq1", "lumi.acpartner.v3", "lumi.gateway.mitw01", "lumi.gateway.mieu01", "lumi.gateway.mihk01", "lumi.gateway.aqcn01", "lumi.gateway.lmuk01", "lumi.gateway.iragl01", "lumi.gateway.aqhm01", "lumi.camera.gwagl01", "lumi.gateway.aqhm02", "lumi.plug.mitw01", "lumi.sensor_cube.aqgl01", "lumi.relay.c2acn01", "lumi.lock.acn03", "lumi.airrtc.tcpecn02", "lumi.dimmer.cwegl01"};

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f397O000000o = R.drawable.device_list_phone_no;
        public boolean O00000Oo;
    }

    public static int O000000o(int i) {
        switch (i) {
            case 167:
            case 173:
                return R.drawable.intelligence_icon_home_nor;
            case 168:
            case 174:
                return R.drawable.intelligence_icon_away_nor;
            case 169:
                return R.drawable.intelligence_icon_wakeup_nor;
            case 170:
                return R.drawable.intelligence_icon_sleep_nor;
            case 171:
            case 172:
            default:
                return R.drawable.intelligence_icon_default_nor;
        }
    }

    public static int O00000Oo(int i) {
        switch (i) {
            case 167:
            case 173:
                return R.drawable.widget_icon_home_nor;
            case 168:
            case 174:
                return R.drawable.widget_icon_away_nor;
            case 169:
                return R.drawable.widget_icon_wakeup_nor;
            case 170:
                return R.drawable.widget_icon_sleep_nor;
            case 171:
            case 172:
            default:
                return R.drawable.widget_icon_default_nor;
        }
    }

    public static String O000000o(SceneApi.O000OOOo o000OOOo) {
        String str;
        String str2;
        Device O0000o0O;
        String str3;
        StringBuilder sb = new StringBuilder();
        if (o000OOOo.O0000O0o != null && o000OOOo.O0000O0o.size() > 0) {
            SceneApi.O000000o o000000o = o000OOOo.O0000O0o.get(0);
            if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
                Room O0000o00 = ggb.O00000Oo().O0000o00(o000000o.O00000o0.f11122O000000o);
                str3 = (O0000o00 == null ? gwc.O000000o((int) R.string.room_default) : O0000o00.getName()) + " " + o000000o.O00000o0.O00000Oo;
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.TIMER) {
                str3 = gwc.O000000o((int) R.string.smarthome_scene_start_timer);
            } else {
                str3 = O00000o0(ServiceApplication.getAppContext(), o000000o);
                if (str3.equalsIgnoreCase(ServiceApplication.getAppContext().getResources().getString(R.string.smarthome_scene_start_click))) {
                    str3 = "";
                }
            }
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            sb.append("-");
        }
        if (o000OOOo.O00000oo != null && o000OOOo.O00000oo.size() > 0) {
            SceneApi.Action action = o000OOOo.O00000oo.get(0);
            if ((action.O0000O0o instanceof SceneApi.O000O0o0) && o000OOOo.O00000oo.size() > 1) {
                action = o000OOOo.O00000oo.get(1);
            }
            if (action.O0000O0o instanceof SceneApi.O000OO0o) {
                Device O000000o2 = fno.O000000o().O000000o(action.O0000O0o.O00000o);
                if (O000000o2 == null) {
                    O000000o2 = fno.O000000o().O00000Oo(action.O0000O0o.O00000o);
                }
                if (O000000o2 != null) {
                    str2 = O000000o2.name;
                } else {
                    str2 = "";
                }
                if (str2.isEmpty() && (O0000o0O = DeviceFactory.O0000o0O(action.O00000oO)) != null) {
                    str2 = O0000o0O.name;
                }
                str = str2 + " " + action.O00000o0;
            } else if ((action.O0000O0o instanceof SceneApi.O000O0o0) && o000OOOo.O00000oo.size() > 1) {
                str = o000OOOo.O00000oo.get(1).O00000Oo;
            } else if (action != null) {
                str = action.O00000Oo;
            } else {
                str = "";
            }
            if (str == null) {
                str = "";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static void O000000o(SimpleDraweeView simpleDraweeView, SceneApi.O000000o o000000o) {
        if (o000000o == null) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.scene_click_lite_scene_icon));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.TIMER) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.condition_timer_icon));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
            if (o000000o.O00000o0 != null) {
                Device O0000o0O = DeviceFactory.O0000o0O(o000000o.O00000o0.O00000o);
                if (O0000o0O != null) {
                    DeviceFactory.O00000Oo(O0000o0O.model, simpleDraweeView);
                } else {
                    DeviceFactory.O00000Oo((String) null, simpleDraweeView);
                }
            } else {
                DeviceFactory.O00000Oo((String) null, simpleDraweeView);
            }
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_HOME) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.intelligence_icon_away_nor));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.COME_HOME) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.intelligence_icon_home_nor));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.PHONE_SMS) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_sms));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.PHONE_CALL) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_phonecall));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.MIKEY) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_icon_mikey_virtual));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.MIBAND) {
            Device O0000o0O2 = DeviceFactory.O0000o0O(o000000o.O00000oo.O00000o);
            if (O0000o0O2 != null) {
                DeviceFactory.O00000Oo(O0000o0O2.model, simpleDraweeView);
            } else {
                DeviceFactory.O00000Oo((String) null, simpleDraweeView);
            }
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.COME_LOC || o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_LOC) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_wifi_poi));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.ENTER_FENCE || o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_fence));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.HUMIDITY) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.scene_humidity_icon));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.SUN_RISE || o000000o.f11121O000000o == LAUNCH_TYPE.SUN_SET) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.scene_sun_icon));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.TEMPERATURE) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.scene_temperature_icon));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.AQI) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.scene_pm25_icon));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.CLICK) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.scene_click_lite_scene_icon));
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.NFC) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_nfc));
        } else {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.intelligence_icon_default_nor));
        }
    }

    public static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[\\u4e00-\\u9fa5]+$").matcher(str).matches();
    }

    public static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[\\u4e00-\\u9fa5_a-zA-Z\\-]+$").matcher(str).matches();
    }

    public static boolean O00000o0(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 20) {
            return false;
        }
        return true;
    }

    public static O000000o O000000o(SceneApi.Action action) {
        if (action == null) {
            return null;
        }
        O000000o o000000o = new O000000o();
        if (action.O0000O0o instanceof SceneApi.O000OO) {
            o000000o.O00000Oo = true;
            o000000o.f397O000000o = R.drawable.device_list_phone;
        }
        Iterator<Map.Entry<String, Device>> it = fno.O000000o().O0000O0o().entrySet().iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Device device = (Device) it.next().getValue();
            if ((!device.isOwner() && !device.isFamily() && !device.isSubDevice()) || !device.isOnline) {
                z = true;
            }
            if (!z) {
                if ((action.O0000O0o instanceof SceneApi.O000OO0o) && ((SceneApi.O000OO0o) action.O0000O0o).O00000o.equalsIgnoreCase(device.did)) {
                    o000000o.O00000Oo = true;
                    o000000o.f397O000000o = fqs.O000000o(device.model);
                }
                if (action.O0000O0o instanceof SceneApi.O000OO) {
                    o000000o.O00000Oo = true;
                    o000000o.f397O000000o = R.drawable.device_list_phone;
                }
            }
        }
        for (Map.Entry<String, Device> value : fno.O000000o().O00000Oo().entrySet()) {
            Device device2 = (Device) value.getValue();
            if (!((!device2.isOwner() && !device2.isFamily()) || !device2.isOnline) && (action.O0000O0o instanceof SceneApi.O000OO0o) && ((SceneApi.O000OO0o) action.O0000O0o).O00000o.equalsIgnoreCase(device2.did)) {
                o000000o.O00000Oo = true;
                o000000o.f397O000000o = fqs.O000000o(device2.model);
            }
        }
        return o000000o;
    }

    public static void O000000o(SimpleDraweeView simpleDraweeView, TextView textView, SceneApi.Action action) {
        if (action != null && action.O0000O0o != null) {
            if (action.O0000O0o instanceof SceneApi.O000OO) {
                if (!TextUtils.isDigitsOnly(action.O00000Oo)) {
                    textView.setText(action.O00000Oo);
                } else {
                    textView.setText((int) R.string.smarthome_scene_push_action);
                }
                simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_push));
            } else if (action.O0000O0o instanceof SceneApi.O000O00o) {
                textView.setText(action.O00000Oo);
                simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.scene_click_lite_scene_icon));
            } else if (action.O0000O0o instanceof SceneApi.O000O0OO) {
                textView.setText(action.O00000Oo);
                simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.scene_auto_icon));
            } else {
                for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
                    Device device = (Device) value.getValue();
                    if ((device.isOwner() || device.isFamily()) && TextUtils.equals(device.did, action.O0000O0o.O00000o)) {
                        DeviceFactory.O00000Oo(device.model, simpleDraweeView);
                        textView.setText(device.name);
                        return;
                    }
                }
                for (Map.Entry<String, Device> value2 : fno.O000000o().O00000Oo().entrySet()) {
                    Device device2 = (Device) value2.getValue();
                    if (!((!device2.isOwner() && !device2.isFamily()) || !device2.isOnline) && device2.did.equals(action.O0000O0o.O00000o)) {
                        DeviceFactory.O00000Oo(device2.model, simpleDraweeView);
                        textView.setText(device2.name);
                        return;
                    }
                }
                if (action.O00000Oo != null && !TextUtils.isEmpty(action.O00000oO)) {
                    textView.setText(action.O00000Oo);
                    DeviceFactory.O00000Oo(action.O00000oO, simpleDraweeView);
                }
            }
        }
    }

    public static String O000000o(Context context, SceneApi.O000000o o000000o) {
        if (o000000o.f11121O000000o == LAUNCH_TYPE.TIMER) {
            return context.getString(R.string.smarthome_scene_timer_title);
        }
        if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
            String str = o000000o.O00000o0.O00000o0;
            if (str == null || !TextUtils.isEmpty(str)) {
                return str;
            }
            Device O000000o2 = fno.O000000o().O000000o(o000000o.O00000o0.f11122O000000o);
            if (O000000o2 == null) {
                O000000o2 = fno.O000000o().O00000Oo(o000000o.O00000o0.f11122O000000o);
            }
            if (O000000o2 != null) {
                str = O000000o2.name;
            }
            if (str.isEmpty()) {
                return DeviceFactory.O0000o0O(o000000o.O00000o0.O00000o).name;
            }
            return str;
        } else if (o000000o.O00000Oo()) {
            return o000000o.O0000OoO.O00000Oo;
        } else {
            if (o000000o.f11121O000000o == LAUNCH_TYPE.COME_LOC) {
                return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_enter_wifi);
            }
            if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_LOC) {
                return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_exit_wifi);
            }
            if (o000000o.f11121O000000o == LAUNCH_TYPE.ENTER_FENCE) {
                return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_enter_fence);
            }
            return o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE ? gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_exit_fence) : "";
        }
    }

    public static String O00000Oo(Context context, SceneApi.O000000o o000000o) {
        Device O0000o0O;
        if (o000000o == null || o000000o.f11121O000000o == LAUNCH_TYPE.CLICK) {
            return context.getString(R.string.smarthome_scene_start_click);
        }
        if (o000000o.f11121O000000o == LAUNCH_TYPE.TIMER) {
            return context.getString(R.string.smarthome_scene_timer_title);
        }
        if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
            String str = o000000o.O00000o0.O00000o0;
            if (str == null || !TextUtils.isEmpty(str)) {
                return str;
            }
            Device O000000o2 = fno.O000000o().O000000o(o000000o.O00000o0.f11122O000000o);
            if (O000000o2 == null) {
                O000000o2 = fno.O000000o().O00000Oo(o000000o.O00000o0.f11122O000000o);
            }
            if (O000000o2 != null) {
                str = O000000o2.name;
            }
            if (!str.isEmpty() || (O0000o0O = DeviceFactory.O0000o0O(o000000o.O00000o0.O00000o)) == null) {
                return str;
            }
            return O0000o0O.name;
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.COME_HOME) {
            return context.getString(R.string.condition_come_home);
        } else {
            if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_HOME) {
                return context.getString(R.string.condition_leave_home);
            }
            if (o000000o.f11121O000000o == LAUNCH_TYPE.PHONE_CALL) {
                return context.getString(R.string.scene_condition_phone_call);
            }
            if (o000000o.f11121O000000o == LAUNCH_TYPE.PHONE_SMS) {
                return context.getString(R.string.scene_condition_sms);
            }
            if (o000000o.f11121O000000o == LAUNCH_TYPE.MIKEY) {
                if ("mikey_click".equalsIgnoreCase(o000000o.O00000oO.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_default_mikey_click);
                }
                if ("mikey_dbclick".equalsIgnoreCase(o000000o.O00000oO.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_default_mikey_dbclick);
                }
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.MIBAND) {
                if ("miband_sleep".equalsIgnoreCase(o000000o.O00000oo.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_condition_miband_sleep);
                }
                if ("miband_awake".equalsIgnoreCase(o000000o.O00000oo.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_condition_miband_awake);
                }
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.COME_LOC) {
                return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_enter_wifi);
            } else {
                if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_LOC) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_exit_wifi);
                }
                if (o000000o.f11121O000000o == LAUNCH_TYPE.ENTER_FENCE) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_enter_fence);
                }
                if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_exit_fence);
                }
                if (o000000o.O00000Oo()) {
                    return o000000o.O0000OoO.O0000O0o;
                }
            }
            return "";
        }
    }

    public static String O00000o0(Context context, SceneApi.O000000o o000000o) {
        if (o000000o == null || o000000o.f11121O000000o == LAUNCH_TYPE.CLICK) {
            return context.getString(R.string.smarthome_scene_start_click);
        }
        if (o000000o.f11121O000000o == LAUNCH_TYPE.TIMER) {
            return SmartHomeSceneTimerActivity.getTimerHint(context, o000000o.O00000Oo != null ? o000000o.O00000Oo : null);
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
            String str = o000000o.O00000o0.O00000Oo;
            if (str == null || !TextUtils.isEmpty(str)) {
                return str;
            }
            Device O000000o2 = fno.O000000o().O000000o(o000000o.O00000o0.f11122O000000o);
            if (O000000o2 == null) {
                O000000o2 = fno.O000000o().O00000Oo(o000000o.O00000o0.f11122O000000o);
            }
            if (O000000o2 != null) {
                str = O000000o2.name;
            }
            if (str.isEmpty()) {
                return DeviceFactory.O0000o0O(o000000o.O00000o0.O00000o).name;
            }
            return str;
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.COME_HOME) {
            return context.getString(R.string.condition_come_home);
        } else {
            if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_HOME) {
                return context.getString(R.string.condition_leave_home);
            }
            if (o000000o.f11121O000000o == LAUNCH_TYPE.PHONE_CALL) {
                return context.getString(R.string.scene_condition_phone_call);
            }
            if (o000000o.f11121O000000o == LAUNCH_TYPE.PHONE_SMS) {
                return context.getString(R.string.scene_condition_sms);
            }
            if (o000000o.f11121O000000o == LAUNCH_TYPE.MIKEY) {
                if ("mikey_click".equalsIgnoreCase(o000000o.O00000oO.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_default_mikey_click);
                }
                if ("mikey_dbclick".equalsIgnoreCase(o000000o.O00000oO.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_default_mikey_dbclick);
                }
                return "";
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.MIBAND) {
                if ("miband_sleep".equalsIgnoreCase(o000000o.O00000oo.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_condition_miband_sleep);
                }
                if ("miband_awake".equalsIgnoreCase(o000000o.O00000oo.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_condition_miband_awake);
                }
                return "";
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.COME_LOC) {
                if (o000000o.O0000Oo0 == null || TextUtils.isEmpty(o000000o.O0000Oo0.O00000Oo)) {
                    return "";
                }
                return o000000o.O0000Oo0.O00000Oo;
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_LOC) {
                if (o000000o.O0000Oo0 == null || TextUtils.isEmpty(o000000o.O0000Oo0.O00000Oo)) {
                    return "";
                }
                return o000000o.O0000Oo0.O00000Oo;
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.ENTER_FENCE) {
                if (o000000o.O0000Oo == null || TextUtils.isEmpty(o000000o.O0000Oo.O00000Oo)) {
                    return "";
                }
                return o000000o.O0000Oo.O00000Oo;
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE) {
                if (o000000o.O0000Oo == null || TextUtils.isEmpty(o000000o.O0000Oo.O00000Oo)) {
                    return "";
                }
                return o000000o.O0000Oo.O00000Oo;
            } else if (!o000000o.O00000Oo() || o000000o.O0000OoO == null) {
                return "";
            } else {
                return o000000o.O0000OoO.O0000O0o;
            }
        }
    }

    public static String O00000o(Context context, SceneApi.O000000o o000000o) {
        if (o000000o == null || o000000o.f11121O000000o == LAUNCH_TYPE.CLICK) {
            return context.getString(R.string.smarthome_scene_start_click);
        }
        if (o000000o.f11121O000000o == LAUNCH_TYPE.TIMER) {
            return SmartHomeSceneTimerActivity.getTimerHint(context, o000000o.O00000Oo != null ? o000000o.O00000Oo : null);
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
            String str = o000000o.O00000o0.O00000Oo;
            if (str == null || !TextUtils.isEmpty(str)) {
                return str;
            }
            Device O000000o2 = fno.O000000o().O000000o(o000000o.O00000o0.f11122O000000o);
            if (O000000o2 == null) {
                O000000o2 = fno.O000000o().O00000Oo(o000000o.O00000o0.f11122O000000o);
            }
            if (O000000o2 != null) {
                str = O000000o2.name;
            }
            if (str.isEmpty()) {
                return DeviceFactory.O0000o0O(o000000o.O00000o0.O00000o).name;
            }
            return str;
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.COME_HOME) {
            return context.getString(R.string.condition_come_home);
        } else {
            if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_HOME) {
                return context.getString(R.string.condition_leave_home);
            }
            if (o000000o.f11121O000000o == LAUNCH_TYPE.PHONE_CALL) {
                return context.getString(R.string.scene_condition_phone_call);
            }
            if (o000000o.f11121O000000o == LAUNCH_TYPE.PHONE_SMS) {
                return context.getString(R.string.scene_condition_sms);
            }
            if (o000000o.f11121O000000o == LAUNCH_TYPE.MIKEY) {
                if ("mikey_click".equalsIgnoreCase(o000000o.O00000oO.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_default_mikey_click);
                }
                if ("mikey_dbclick".equalsIgnoreCase(o000000o.O00000oO.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_default_mikey_dbclick);
                }
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.MIBAND) {
                if ("miband_sleep".equalsIgnoreCase(o000000o.O00000oo.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_condition_miband_sleep);
                }
                if ("miband_awake".equalsIgnoreCase(o000000o.O00000oo.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_condition_miband_awake);
                }
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.COME_LOC) {
                return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_enter_wifi);
            } else {
                if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_LOC) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_exit_wifi);
                }
                if (o000000o.f11121O000000o == LAUNCH_TYPE.ENTER_FENCE) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_enter_fence);
                }
                if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_exit_fence);
                }
                if (o000000o.O00000Oo() && o000000o.O0000OoO != null) {
                    if (!TextUtils.isEmpty(o000000o.O0000OoO.O0000O0o)) {
                        return o000000o.O0000OoO.O0000O0o;
                    }
                    return o000000o.O0000OoO.O00000Oo;
                }
            }
            return "";
        }
    }

    public static String O00000oO(Context context, SceneApi.O000000o o000000o) {
        if (o000000o == null || o000000o.f11121O000000o == LAUNCH_TYPE.CLICK) {
            return context.getString(R.string.smarthome_scene_start_click);
        }
        if (o000000o.f11121O000000o == LAUNCH_TYPE.TIMER) {
            return SmartHomeSceneTimerActivity.getTimerHint(context, o000000o.O00000Oo != null ? o000000o.O00000Oo : null);
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
            return o000000o.O00000o0.O00000o0 + o000000o.O00000o0.O00000Oo;
        } else if (o000000o.f11121O000000o == LAUNCH_TYPE.COME_HOME) {
            return context.getString(R.string.condition_come_home);
        } else {
            if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_HOME) {
                return context.getString(R.string.condition_leave_home);
            }
            if (o000000o.f11121O000000o == LAUNCH_TYPE.MIKEY) {
                if ("mikey_click".equalsIgnoreCase(o000000o.O00000oO.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_default_mikey_click);
                }
                if ("mikey_dbclick".equalsIgnoreCase(o000000o.O00000oO.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_default_mikey_dbclick);
                }
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.MIBAND) {
                if ("miband_sleep".equalsIgnoreCase(o000000o.O00000oo.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_condition_miband_sleep);
                }
                if ("miband_awake".equalsIgnoreCase(o000000o.O00000oo.O0000Oo)) {
                    return gqb.O000000o(ServiceApplication.getAppContext(), (int) R.string.scene_condition_miband_awake);
                }
            } else if (o000000o.O00000Oo()) {
                return o000000o.O0000OoO.O0000O0o;
            }
            return "";
        }
    }

    public static boolean O000000o(Object obj, Object obj2) {
        if ((obj instanceof Integer) && (obj2 instanceof Integer)) {
            return obj.equals(obj2);
        }
        if ((obj instanceof Float) && (obj2 instanceof Float)) {
            return obj.equals(obj2);
        }
        if ((obj instanceof Double) && (obj2 instanceof Double)) {
            return obj.equals(obj2);
        }
        if ((obj instanceof String) && (obj2 instanceof String)) {
            return obj.equals(obj2);
        }
        String str = null;
        String obj3 = obj instanceof JSONObject ? obj.toString() : null;
        if (obj instanceof JSONArray) {
            obj3 = obj.toString();
        }
        if (obj2 instanceof JSONObject) {
            str = obj2.toString();
        }
        if (obj2 instanceof JSONArray) {
            str = obj2.toString();
        }
        if (obj3 != null && str != null) {
            return obj3.equals(str);
        }
        if (obj3 != null) {
            return obj3.equals(obj2);
        }
        if (str != null) {
            return str.equals(obj);
        }
        return obj.equals(obj2);
    }

    public static boolean O00000Oo(SceneApi.O000OOOo o000OOOo) {
        for (SceneApi.O000000o o000000o : o000OOOo.O0000O0o) {
            if (o000000o.f11121O000000o == LAUNCH_TYPE.CLICK) {
                return true;
            }
        }
        return false;
    }

    public static int O000000o(SceneApi.O000OOOo o000OOOo, LinearLayout linearLayout) {
        if (o000OOOo == null || o000OOOo.O00000oo == null || linearLayout == null) {
            return 0;
        }
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            linearLayout.getChildAt(i).setVisibility(8);
        }
        int i2 = 0;
        while (true) {
            int i3 = 3;
            if (o000OOOo.O00000oo.size() <= 3) {
                i3 = o000OOOo.O00000oo.size();
            }
            if (i2 >= i3) {
                break;
            }
            if (o000OOOo.O00000oo.get(i2).O0000O0o instanceof SceneApi.O000O0o0) {
                O000000o(linearLayout, i2, Integer.valueOf((int) R.drawable.std_scene_icon_delayed));
            } else if (o000OOOo.O00000oo.get(i2).O0000O0o instanceof SceneApi.O000OO) {
                O000000o(linearLayout, i2, Integer.valueOf((int) R.drawable.std_scene_icon_push));
            } else if (o000OOOo.O00000oo.get(i2).O0000O0o instanceof SceneApi.O000O00o) {
                O000000o(linearLayout, i2, Integer.valueOf(O000000o(o000OOOo.O00000o)));
            } else if (o000OOOo.O00000oo.get(i2).O0000O0o instanceof SceneApi.O000O0OO) {
                O000000o(linearLayout, i2, Integer.valueOf((int) R.drawable.scene_auto_icon));
            } else if (o000OOOo.O00000oo.get(i2).O0000O0o instanceof SceneApi.O000OO0o) {
                PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(o000OOOo.O00000oo.get(i2).O00000oO);
                if (O00000oO != null) {
                    O000000o(linearLayout, i2, O00000oO.O0000o0());
                } else {
                    JSONObject thirdAccountDeviceById = o000OOOo.O00000oo.get(i2).O0000O0o == null ? null : gty.O000000o().getThirdAccountDeviceById(o000OOOo.O00000oo.get(i2).O0000O0o.O00000o);
                    if (thirdAccountDeviceById != null) {
                        String optString = thirdAccountDeviceById.optString("third_cloud_device_icon");
                        if (!TextUtils.isEmpty(optString)) {
                            O000000o(linearLayout, i2, optString);
                        } else {
                            O000000o(linearLayout, i2, Integer.valueOf((int) R.drawable.device_list_phone_no));
                        }
                    } else {
                        O000000o(linearLayout, i2, Integer.valueOf(DeviceFactory.O0000oOo(o000OOOo.O00000oo.get(i2).O00000oO)));
                    }
                }
            } else {
                O000000o(linearLayout, i2, Integer.valueOf((int) R.drawable.device_list_phone_no));
            }
            i2++;
        }
        return 0;
    }

    public static boolean O000000o(SceneApi.Action action, SceneApi.O000OOOo o000OOOo, SimpleDraweeView simpleDraweeView) {
        if (action == null) {
            return false;
        }
        simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setPlaceholderImage(simpleDraweeView.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
        if (action.O0000O0o instanceof SceneApi.O000O0o0) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_delayed));
            return true;
        } else if (action.O0000O0o instanceof SceneApi.O000OO) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_push));
            return true;
        } else if (action.O0000O0o instanceof SceneApi.O000O00o) {
            simpleDraweeView.setImageURI(gqd.O000000o(O000000o(o000OOOo.O00000o)));
            return true;
        } else if (action.O0000O0o instanceof SceneApi.O000O0OO) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.scene_auto_icon));
            return true;
        } else if (action.O0000O0o instanceof SceneApi.O000OO0o) {
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(action.O00000oO);
            if (O00000oO != null) {
                simpleDraweeView.setImageURI(Uri.parse(O00000oO.O0000o0()));
                return true;
            }
            simpleDraweeView.setImageURI(gqd.O000000o(DeviceFactory.O0000oOo(action.O00000oO)));
            return true;
        } else {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.device_list_phone_no));
            return true;
        }
    }

    public static boolean O000000o(Device device) {
        if (device == null || TextUtils.isEmpty(device.model)) {
            return false;
        }
        return O00000o(device.model);
    }

    public static boolean O00000o(String str) {
        List<fce> list = fbv.O000000o().O00000Oo;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (list != null && list.size() > 0) {
            gsy.O00000Oo("SmartHomeSceneUtility", "通过网络判断绿米设备");
            for (int i = 0; i < list.size(); i++) {
                if (str.equalsIgnoreCase(list.get(i).f16078O000000o)) {
                    return true;
                }
            }
        }
        for (String equalsIgnoreCase : O00000Oo) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static int O00000o0(int i) {
        if (i == 0) {
            return f390O000000o[0];
        }
        if (i == 1) {
            return f390O000000o[1];
        }
        return f390O000000o[0];
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void O000000o(Activity activity, SceneApi.O000OOOo o000OOOo, int i) {
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", o000OOOo.O00000Oo);
        Intent intent2 = new Intent("com.xiaomi.smarthome.scene.smarthomelauncher");
        intent2.setComponent(new ComponentName(ServiceApplication.getAppContext().getPackageName(), SmartHomeLauncherActivity.class.getName()));
        intent.putExtra("duplicate", false);
        intent2.putExtra("extra_str_scene_id", o000OOOo.f11131O000000o);
        intent2.putExtra("extra_scene_id", o000OOOo.f11131O000000o);
        intent2.putExtra("extra_scene_account", CoreApi.O000000o().O0000o0());
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        if (gnn.O00000o0) {
            ShortcutManager shortcutManager = (ShortcutManager) ServiceApplication.getAppContext().getSystemService(ShortcutManager.class);
            if (shortcutManager.isRequestPinShortcutSupported()) {
                shortcutManager.requestPinShortcut(new ShortcutInfo.Builder(activity, o000OOOo.O00000Oo).setIcon(Icon.createWithResource(activity, i)).setShortLabel(o000OOOo.O00000Oo).setIntent(intent2).build(), null);
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(activity, i));
                activity.sendBroadcast(intent);
            }
        } else {
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(activity, i));
            activity.sendBroadcast(intent);
        }
        gqg.O00000Oo((int) R.string.smarthome_add_short_cut_success);
    }

    private static void O000000o(ViewGroup viewGroup, int i, String str) {
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            childAt.setVisibility(0);
            ((SimpleDraweeView) childAt.findViewById(R.id.icon_sdv)).setImageURI(Uri.parse(str));
        }
    }

    private static void O000000o(ViewGroup viewGroup, int i, Integer num) {
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            childAt.setVisibility(0);
            ((SimpleDraweeView) childAt.findViewById(R.id.icon_sdv)).setImageURI(gqd.O000000o(num.intValue()));
        }
    }

    private static String O000000o(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (i >= 0 && i <= 9) {
            sb.append("0");
        }
        sb.append(i);
        sb.append(":");
        if (i2 >= 0 && i2 <= 9) {
            sb.append("0");
        }
        sb.append(i2);
        return sb.toString();
    }

    public static void O000000o(SceneApi.O0000o0 o0000o0, TextView textView, String str) {
        if (o0000o0 == null) {
            textView.setText((int) R.string.scene_exetime_all_day);
        } else if (o0000o0.f11125O000000o == o0000o0.O00000Oo && o0000o0.O00000o0 == o0000o0.O00000o) {
            textView.setText((int) R.string.scene_exetime_all_day);
        } else {
            int rawOffset = new GregorianCalendar().getTimeZone().getRawOffset();
            int convert = (int) TimeUnit.HOURS.convert((long) rawOffset, TimeUnit.MILLISECONDS);
            LogType logType = LogType.SCENE;
            gsy.O000000o(logType, "scene", "offsetHOser----" + convert + "--mGTMoffeset---" + rawOffset);
            int i = (((o0000o0.f11125O000000o + convert) + -8) + 24) % 24;
            int i2 = o0000o0.O00000o0;
            int i3 = (((o0000o0.O00000Oo + convert) + -8) + 24) % 24;
            int i4 = o0000o0.O00000o;
            if (i3 < i || (i3 == i && i4 < i2)) {
                textView.setText(O000000o(i, i2) + "-" + O000000o(i3, i4) + "(" + str + ")");
                return;
            }
            textView.setText(O000000o(i, i2) + "-" + O000000o(i3, i4));
        }
    }

    public static void O000000o(final SceneApi.O000OOOo o000OOOo, final hoc hoc) {
        if (eys.f15955O000000o) {
            hob.O000000o().O000000o(ServiceApplication.getAppContext(), o000OOOo, new fsm<JSONObject, fso>() {
                /* class _m_j.hnw.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    String optString = jSONObject.optString("us_id");
                    boolean optBoolean = jSONObject.optBoolean("local");
                    String optString2 = jSONObject.optString("local_dev");
                    o000OOOo.f11131O000000o = optString;
                    if (TextUtils.isEmpty(optString2) || !optBoolean) {
                        hoc hoc = hoc;
                        if (hoc != null) {
                            hoc.O000000o(true);
                            return;
                        }
                        return;
                    }
                    hnw.O000000o(optString2, jSONObject.optJSONObject("data").toString(), o000OOOo, hoc);
                }

                public final void onFailure(fso fso) {
                    hoc hoc = hoc;
                    if (hoc != null) {
                        hoc.O000000o(fso.f17063O000000o, fso.O00000Oo);
                    }
                }
            });
        } else {
            hoc.O000000o(-9990, "is not smarttttttt home");
        }
    }

    public static void O000000o(String str, String str2, final SceneApi.O000OOOo o000OOOo, final hoc hoc) {
        Device O00000o0 = fno.O000000o().O00000o0(str);
        if (O00000o0 != null) {
            hpn.O000000o().O000000o(XmPluginHostApi.instance().getDeviceByDid(O00000o0.did), str2, new MessageCallback() {
                /* class _m_j.hnw.AnonymousClass2 */

                public final void onSuccess(Intent intent) {
                    hob.O000000o();
                    hob.O00000Oo(ServiceApplication.getAppContext(), o000OOOo, new fsm<Void, fso>() {
                        /* class _m_j.hnw.AnonymousClass2.AnonymousClass1 */

                        public final void onFailure(fso fso) {
                            if (hoc != null) {
                                hoc.O000000o(false);
                            }
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            if (hoc != null) {
                                hoc.O000000o(true);
                            }
                        }
                    });
                }

                public final void onFailure(int i, String str) {
                    hoc hoc = hoc;
                    if (hoc != null) {
                        hoc.O000000o(i, str);
                    }
                }
            });
            new CountDownTimer() {
                /* class _m_j.hnw.AnonymousClass3 */

                public final void onTick(long j) {
                }

                public final void onFinish() {
                    hoc hoc = hoc;
                    if (hoc != null) {
                        hoc.O000000o(-9000, "save local 10s time out");
                    }
                }
            }.start();
        }
    }

    public static GeoFenceItem O000000o(SceneApi.O0000O0o o0000O0o, String str) {
        if (o0000O0o == null || TextUtils.isEmpty(o0000O0o.O0000o0O)) {
            return null;
        }
        hpv O00000o0 = hjk.O00000o0(o0000O0o.O0000o0o, o0000O0o.O0000o);
        if (Double.valueOf(O00000o0.O00000Oo).equals(Double.valueOf(Double.NaN)) || Double.valueOf(O00000o0.f511O000000o).equals(Double.valueOf(Double.NaN))) {
            LogType logType = LogType.GENERAL;
            gsy.O00000Oo(logType, "GCJ2WGS", str + "   latlng NaN");
            return null;
        }
        LogType logType2 = LogType.GENERAL;
        gsy.O00000Oo(logType2, "GCJ2WGS", "lat:" + O00000o0.O00000Oo + "  ,lon: " + O00000o0.f511O000000o);
        if (TextUtils.equals("enter_fence", o0000O0o.O0000o0O)) {
            return new GeoFenceItem(O00000o0.O00000Oo, O00000o0.f511O000000o, (double) o0000O0o.O0000oO0, 1);
        }
        if (TextUtils.equals("leave_fence", o0000O0o.O0000o0O)) {
            return new GeoFenceItem(O00000o0.O00000Oo, O00000o0.f511O000000o, (double) o0000O0o.O0000oO0, 2);
        }
        return null;
    }

    public static GeoFenceItem O000000o(String str, double d, String str2, long j) {
        Home O00000o;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (O00000o = ggb.O00000Oo().O00000o(str)) != null && !TextUtils.isEmpty(O00000o.getAddr())) {
            try {
                hpv hpv = new hpv(Double.parseDouble(O00000o.getLatitude()), Double.parseDouble(O00000o.getLongitude()));
                if (!Double.valueOf(hpv.O00000Oo).equals(Double.valueOf(Double.NaN))) {
                    if (!Double.valueOf(hpv.f511O000000o).equals(Double.valueOf(Double.NaN))) {
                        LogType logType = LogType.GENERAL;
                        gsy.O00000Oo(logType, "GPS ", "lat:" + hpv.O00000Oo + "  ,lon: " + hpv.f511O000000o);
                        if (TextUtils.equals("location.enter_fence", str2)) {
                            return new GeoFenceItem(hpv.O00000Oo, hpv.f511O000000o, d, 1);
                        }
                        if (TextUtils.equals("location.leave_fence", str2)) {
                            return new GeoFenceItem(hpv.O00000Oo, hpv.f511O000000o, d, 2);
                        }
                        return null;
                    }
                }
                LogType logType2 = LogType.GENERAL;
                gsy.O00000Oo(logType2, "get home location ", j + "   latlng NaN");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean O000000o() {
        return "GooglePlay".toLowerCase().equals(gfr.O00000o.toLowerCase());
    }

    public static boolean O00000Oo(Device device) {
        boolean z = true;
        if (device instanceof MiioDeviceV2) {
            String str = ((MiioDeviceV2) device).mFwVersion;
            List<fcg> list = fbv.O000000o().O00000o0;
            if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
                for (fcg next : list) {
                    if (TextUtils.equals(next.f16080O000000o, device.model) && fpo.O000000o(str, next.O00000Oo) < 0) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    public static Dialog O000000o(final Activity activity) {
        return new MLAlertDialog.Builder(activity).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class _m_j.hnw.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                gty.O000000o().startLogin(activity, 1, null);
                dialogInterface.dismiss();
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener(false, activity) {
            /* class _m_j.hnw.AnonymousClass4 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ boolean f395O000000o = false;
            final /* synthetic */ Activity O00000Oo;

            {
                this.O00000Oo = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (this.f395O000000o) {
                    this.O00000Oo.finish();
                }
            }
        }).O000000o(true).O00000Oo((int) R.string.loing_helper_title).O00000oo();
    }
}
