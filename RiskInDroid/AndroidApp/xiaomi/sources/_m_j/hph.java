package _m_j;

import com.xiaomi.smarthome.device.api.SceneInfo;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

public final class hph {
    private static final hph O00000Oo = new hph();

    /* renamed from: O000000o  reason: collision with root package name */
    private String[] f466O000000o = {"^lumi\\.(\\S+)\\.set_curtain_level$", "^lumi\\.(\\S*)acpartner(\\S*)\\.set_on$", "^lumi\\.(\\S*)acpartner(\\S*)\\.set_off$", "^lumi\\.(\\S*)acpartner(\\S*)\\.set_ac$", "^lumi\\.(\\S*)acpartner(\\S*)\\.toggle_ac$", "^lumi\\.(\\S*)lock(\\S*)\\.set_spk_vol$", "^lumi\\.(\\S*)lock(\\S*)\\.set_door_vol$", "^lumi\\.(\\S*)light.(\\S*)\\.set_bright$", "^lumi\\.(\\S*)light.(\\S*)\\.set_ct$", "^lumi\\.(\\S*)airrtc.tcp(\\S*)\\.set_ac$", "^lumi\\.(\\S*)light.(\\S*)\\.set_rgb$", "^lumi\\.(\\S*)dimmer.rgbegl01(\\S*)\\.set_rgb$"};

    public static hph O000000o() {
        return O00000Oo;
    }

    private hph() {
    }

    public final void O000000o(SceneInfo.SceneAction sceneAction, SceneInfo sceneInfo, String str, String str2) {
        int i;
        if (sceneAction != null) {
            try {
                if (Arrays.asList(this.f466O000000o).contains(str2)) {
                    str = O000000o(str, sceneAction.mActionValue.toString());
                } else if (str2.equalsIgnoreCase("^lumi\\.(\\S+)\\.door_bell$")) {
                    if (sceneAction.mActionValue == null) {
                        str = O000000o(str, "10000");
                    } else {
                        str = O000000o(str, sceneAction.mActionValue.toString());
                    }
                } else if (str2.equalsIgnoreCase("^lumi\\.(\\S+)\\.play_specify_fm$")) {
                    if (sceneAction.mActionValue != null) {
                        try {
                            JSONArray jSONArray = new JSONArray(sceneAction.mActionValue.toString());
                            if (jSONArray.length() == 2) {
                                str = O000000o(str, jSONArray.getInt(0) + ",0," + jSONArray.getInt(1));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (!str2.equalsIgnoreCase("^lumi\\.(\\S+)\\.play_music_new$")) {
                    if (!str2.equalsIgnoreCase("^lumi\\.(\\S+)\\.adjust_fm_vol$") && !str2.equalsIgnoreCase("^lumi\\.(\\S*)gateway(\\S*)\\.adjust_bright$") && !str2.equalsIgnoreCase("^lumi\\.(\\S*)light.(\\S*)\\.adjust_bright$") && !str2.equalsIgnoreCase("^lumi\\.(\\S*)light.(\\S*)\\.adjust_ct$")) {
                        if (!str2.equalsIgnoreCase("^lumi\\.(\\S*)curtain(\\S*)\\.adjust_curtain_level$")) {
                            if (str2.equalsIgnoreCase("^lumi\\.(\\S*)airrtc.vrfegl01(\\S*)\\.set_power$")) {
                                JSONArray jSONArray2 = new JSONArray(sceneAction.mActionValue.toString());
                                if (jSONArray2.length() == 2) {
                                    String string = jSONArray2.getString(0);
                                    str = str.replace("\"channelIndex\"", String.valueOf(jSONArray2.getInt(1) + 1));
                                    if (string.equals("on")) {
                                        str = str.replace("\"ac_state\"", "536870656");
                                    } else if (string.equals("off")) {
                                        str = str.replace("\"ac_state\"", "268435200");
                                    }
                                }
                            } else if (str2.equalsIgnoreCase("^lumi\\.(\\S*)airrtc.vrfegl01(\\S*)\\.set_ac$")) {
                                JSONArray jSONArray3 = new JSONArray(sceneAction.mActionValue.toString());
                                if (jSONArray3.length() == 2) {
                                    str = str.replace("\"channelIndex\"", String.valueOf(jSONArray3.getInt(1) + 1)).replace("\"ac_state\"", String.valueOf(jSONArray3.getInt(0)));
                                }
                            } else if (str2.equalsIgnoreCase("^lumi\\.(\\S*)camera(\\S*)\\.set_video$")) {
                                if ("off".equals(sceneAction.mActionValue.toString())) {
                                    str = O000000o(str, "0");
                                } else if ("on".equals(sceneAction.mActionValue.toString())) {
                                    str = O000000o(str, "1");
                                } else {
                                    str = O000000o(str, "2");
                                }
                            } else if (str2.equalsIgnoreCase("^lumi\\.(\\S*)camera(\\S*)\\.record_video$")) {
                                str = O000000o(str, "12");
                            } else if (str2.equalsIgnoreCase("^lumi\\.(\\S*)acpartner(\\S*)\\.send_other_ele_cmd$")) {
                                str = O000000o(str, String.valueOf(Long.parseLong(sceneAction.mActionValue.toString(), 16)));
                            } else {
                                str = O000000o(str, sceneAction.mActionValue.toString());
                            }
                        }
                    }
                    String str3 = null;
                    if (sceneInfo.mLaunchList != null) {
                        Iterator<SceneInfo.SceneLaunch> it = sceneInfo.mLaunchList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            SceneInfo.SceneLaunch next = it.next();
                            if (next.mEventString.matches("^event\\.(\\S+)\\.rotate$")) {
                                str3 = next.mDid;
                                break;
                            }
                        }
                        if (str3 != null) {
                            int indexOf = str3.indexOf(".");
                            if (indexOf != -1) {
                                str = O000000o(str, new JSONArray().put(Long.valueOf(str3.substring(indexOf + 1), 16).longValue()).put(12).put(3).put(85).put(0).toString());
                            }
                        } else {
                            str = O000000o(str, "20");
                        }
                    } else {
                        return;
                    }
                } else if (sceneAction.mActionValue != null) {
                    try {
                        JSONArray jSONArray4 = new JSONArray(sceneAction.mActionValue.toString());
                        if (jSONArray4.length() == 2) {
                            str = O000000o(str, Integer.valueOf(jSONArray4.getString(0)).intValue() + ",0," + jSONArray4.getInt(1));
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (sceneAction.mDelayTime > 0) {
                    JSONArray jSONArray5 = new JSONArray(str);
                    int length = jSONArray5.length();
                    int i2 = length - 2;
                    if (i2 >= 0 && (i = length - 1) >= 0) {
                        jSONArray5.put(i2, 6);
                        jSONArray5.put(i, sceneAction.mDelayTime);
                    }
                    str = jSONArray5.toString();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            sceneAction.mExtra = str;
        }
    }

    private static String O000000o(String str, String str2) {
        return str.replace("\"x\"", str2);
    }
}
