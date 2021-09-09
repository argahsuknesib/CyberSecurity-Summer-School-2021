package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.ffmpegcmd.FFmpegCmd;

public final class cik {
    public static int O000000o(String str) {
        ckk ckk = new ckk();
        ckk.O000000o("FFmpeg", "ffmpeg execute", "cmd:".concat(String.valueOf(str)));
        cki.O00000Oo("FFmpeg", "execute: %s", str);
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int execSync = FFmpegCmd.execSync(str);
        ckk.O00000Oo("FFmpeg", "ffmpeg execute", "result:".concat(String.valueOf(execSync)));
        return execSync;
    }

    public static int O000000o(String str, String str2) {
        if (ckn.O00000Oo(str)) {
            return O000000o("ffmpeg" + " -y -threads 4" + " -i " + str + " -filter:v scale=640:360" + " -pix_fmt yuv420p -c:v mpeg4 -c:a copy " + str2);
        }
        cki.O00000Oo("FFmpeg", "src not exist %s", str);
        return -1;
    }
}
