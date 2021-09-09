package _m_j;

import android.os.Bundle;
import com.xiaomi.smarthome.frame.core.CoreApi;

public final class fai {
    public static Bundle O000000o(int i) {
        Bundle bundle = new Bundle();
        if (i != 100) {
            switch (i) {
                case -116:
                    bundle.putString("extra_result_msg", "网络不稳定或者没有联网，请检查网络后重试");
                    break;
                case -115:
                    bundle.putString("extra_result_msg", "暂时不支持海外版");
                    break;
                case -114:
                    bundle.putString("extra_result_msg", "版本号不匹配，请升级sdk版本或者米家app版本");
                    break;
                default:
                    switch (i) {
                        case -111:
                            bundle.putString("extra_result_msg", "该账号不支持该类型授权，请到开放平台申请");
                            break;
                        case -110:
                            bundle.putString("extra_result_msg", "该设备不支持语音授权，或者该设备不属于你的名下");
                            break;
                        case -109:
                            bundle.putString("extra_result_msg", "缺少device_id");
                            break;
                        case -108:
                            bundle.putString("extra_result_msg", "请求的code错误");
                            break;
                        case -107:
                            bundle.putString("extra_result_msg", "请求授权失败");
                            break;
                        case -106:
                            bundle.putString("extra_result_msg", "取消授权");
                            break;
                        case -105:
                            bundle.putString("extra_result_msg", "签名错误");
                            break;
                        case -104:
                            bundle.putString("extra_result_msg", "App_Id错误");
                            break;
                        case -103:
                            bundle.putString("extra_result_msg", "授权失败");
                            break;
                        case -102:
                            bundle.putString("extra_result_msg", "获取token失败");
                            break;
                        case -101:
                            bundle.putString("extra_result_msg", "缺少参数");
                            break;
                        case -100:
                            bundle.putString("extra_result_msg", "包名错误");
                            break;
                        default:
                            bundle.putString("extra_result_msg", "请求授权失败");
                            break;
                    }
            }
        } else {
            bundle.putString("extra_result_msg", "授权成功");
        }
        bundle.putInt("extra_result_code", i);
        if (CoreApi.O000000o().O0000Ooo()) {
            bundle.putString("extra_user_id", CoreApi.O000000o().O0000o0());
        }
        fak.O000000o();
        bundle.putString("extra_version_info", fak.O00000oO().toString());
        return bundle;
    }
}
