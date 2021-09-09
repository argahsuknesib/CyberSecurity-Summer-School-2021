package _m_j;

import com.xiaomi.smarthome.device.api.SceneInfo;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hpl {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final hpl f469O000000o = new hpl();
    private String[] O00000Oo = {"^event\\.(\\S*)sensor_smoke(\\S*)\\.alarm$", "^event\\.(\\S*)sensor_natgas(\\S*)\\.alarm$", "^event\\.(\\S*)lock(\\S*)\\.fing_verified$", "^event\\.(\\S*)lock(\\S*)\\.psw_verified$", "^event\\.(\\S*)lock(\\S*)\\.card_verified$"};

    public static hpl O000000o() {
        return f469O000000o;
    }

    private hpl() {
    }

    public final void O000000o(SceneInfo.SceneLaunch sceneLaunch, String str, String str2) {
        gsy.O00000Oo("lumiscene", "summer launch extra>>" + str + ",event>>" + str2);
        if (Arrays.asList(this.O00000Oo).contains(str2)) {
            str = str.replace("\"x\"", sceneLaunch.mEventValue.toString());
        } else if (str2.equalsIgnoreCase("^event\\.(\\S+)\\.no_motion$")) {
            str = str.replace("\"x\"", sceneLaunch.mEventValue.toString()).replace("\"y\"", String.valueOf(sceneLaunch.mLaunchType));
        } else if (str2.equalsIgnoreCase("^event\\.(\\S*)sensor_magnet(\\S*)\\.no_close$")) {
            str = str.replace("\"y\"", String.valueOf(sceneLaunch.mLaunchType));
        } else if (str2.equalsIgnoreCase("^prop\\.(\\S+)\\.temperature$")) {
            if (sceneLaunch.mEventValue != null) {
                try {
                    JSONObject jSONObject = new JSONObject(sceneLaunch.mEventValue.toString());
                    int optInt = jSONObject.optInt("min", -2100);
                    int optInt2 = jSONObject.optInt("max", 6100);
                    if (optInt2 == 6000) {
                        str = str.replace("\"x\"", new JSONArray().put(2).put(optInt).toString());
                    } else {
                        str = str.replace("\"x\"", new JSONArray().put(3).put(optInt2).toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else if (str2.equalsIgnoreCase("^prop\\.(\\S+)\\.humidity$")) {
            if (sceneLaunch.mEventValue != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(sceneLaunch.mEventValue.toString());
                    int optInt3 = jSONObject2.optInt("min", -100);
                    int optInt4 = jSONObject2.optInt("max", 11000);
                    if (optInt4 == 10000) {
                        str = str.replace("\"x\"", new JSONArray().put(2).put(optInt3).toString());
                    } else {
                        str = str.replace("\"x\"", new JSONArray().put(3).put(optInt4).toString());
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else if (str2.equalsIgnoreCase("^event\\.(\\S*)vibration(\\S*)\\.open$") || str2.equalsIgnoreCase("^event\\.(\\S*)vibration(\\S*)\\.close$")) {
            if (sceneLaunch.mLaunchType != 0) {
                str = str.replace("\"y\"", String.valueOf(sceneLaunch.mLaunchType));
            }
        } else if (str2.equalsIgnoreCase("^event\\.(\\S*)vibration(\\S*)\\.no_close$")) {
            if (sceneLaunch.mLaunchType != 0) {
                str = str.replace("\"y\"", String.valueOf(sceneLaunch.mLaunchType)).replace("\"x\"", sceneLaunch.mEventValue.toString());
            }
        } else if (str2.equalsIgnoreCase("^prop\\.(\\S*)lock(\\S*)\\.reminder_type$")) {
            if (sceneLaunch.mLaunchType != 0) {
                str = str.replace("\"x\"", String.valueOf(Integer.parseInt(sceneLaunch.mEventValue.toString(), 16)));
            }
        } else if (str2.equalsIgnoreCase("^event\\.(\\S*)sensor_occupy(\\S*)\\.out$")) {
            if (sceneLaunch.mLaunchType != 0) {
                str = str.replace("\"x\"", String.valueOf(((Integer) sceneLaunch.mEventValue).intValue() / 60));
            }
        } else if (!str2.equalsIgnoreCase("^prop\\.(\\S*)sensor_motion(\\S*)\\.illumination$")) {
            if (str2.equalsIgnoreCase("^event\\.(\\S*)lock(\\S*)\\.open_verified$")) {
                if (sceneLaunch.mEventValue.toString().length() > 1) {
                    str = str.replace("\"y\"", "2").replace("\"x\"", "0");
                } else {
                    str = str.replace("\"y\"", "0");
                }
            }
            str = str.replace("\"x\"", sceneLaunch.mEventValue.toString());
        } else if (sceneLaunch.mLaunchType != 0) {
            try {
                JSONObject jSONObject3 = new JSONObject(sceneLaunch.mEventValue.toString());
                int optInt5 = jSONObject3.optInt("min", -1);
                int optInt6 = jSONObject3.optInt("max", -1);
                if (optInt5 != -1) {
                    str = str.replace("\"x\"", new JSONArray().put(2).put(optInt5).toString());
                } else if (optInt6 != -1) {
                    str = str.replace("\"x\"", new JSONArray().put(3).put(optInt6).toString());
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        sceneLaunch.mExtra = str;
    }
}
