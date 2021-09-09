package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.fastvideo.decoder.MediaCodecInfo;
import com.xiaomi.smarthome.fastvideo.decoder.MediaCodecSelector;
import com.xiaomi.smarthome.fastvideo.decoder.MediaCodecUtil;

public final class frx {

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f17038O000000o;
        final int O00000Oo = 0;
        final int O00000o0;

        O000000o(String str, int i) {
            this.f17038O000000o = str;
            this.O00000o0 = i;
        }

        public final String O000000o() {
            return this.O00000o0 == 1 ? "video/avc" : "video/hevc";
        }
    }

    public static O000000o O000000o(MediaCodecUtil.CodecKey codecKey) {
        try {
            MediaCodecInfo decoderInfo = MediaCodecSelector.DEFAULT.getDecoderInfo(codecKey);
            if (decoderInfo != null) {
                if (!TextUtils.isEmpty(decoderInfo.name)) {
                    return new O000000o(decoderInfo.name, codecKey.mimeType);
                }
            }
            return null;
        } catch (MediaCodecUtil.DecoderQueryException e) {
            cki.O00000o("AndroidH26xDecoderUtil", "getDecode:" + e.getLocalizedMessage());
            return null;
        }
    }
}
