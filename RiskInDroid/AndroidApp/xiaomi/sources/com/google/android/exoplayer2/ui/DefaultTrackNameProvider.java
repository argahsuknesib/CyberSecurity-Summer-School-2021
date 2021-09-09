package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.xiaomi.smarthome.R;
import java.util.Locale;

public class DefaultTrackNameProvider implements TrackNameProvider {
    private final Resources resources;

    public DefaultTrackNameProvider(Resources resources2) {
        this.resources = (Resources) Assertions.checkNotNull(resources2);
    }

    public String getTrackName(Format format) {
        String str;
        int inferPrimaryTrackType = inferPrimaryTrackType(format);
        if (inferPrimaryTrackType == 2) {
            str = joinWithSeparator(buildRoleString(format), buildResolutionString(format), buildBitrateString(format));
        } else if (inferPrimaryTrackType == 1) {
            str = joinWithSeparator(buildLanguageOrLabelString(format), buildAudioChannelString(format), buildBitrateString(format));
        } else {
            str = buildLanguageOrLabelString(format);
        }
        return str.length() == 0 ? this.resources.getString(R.string.exo_track_unknown) : str;
    }

    private String buildResolutionString(Format format) {
        int i = format.width;
        int i2 = format.height;
        if (i == -1 || i2 == -1) {
            return "";
        }
        return this.resources.getString(R.string.exo_track_resolution, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private String buildBitrateString(Format format) {
        int i = format.bitrate;
        if (i == -1) {
            return "";
        }
        return this.resources.getString(R.string.exo_track_bitrate, Float.valueOf(((float) i) / 1000000.0f));
    }

    private String buildAudioChannelString(Format format) {
        int i = format.channelCount;
        if (i == -1 || i <= 0) {
            return "";
        }
        if (i == 1) {
            return this.resources.getString(R.string.exo_track_mono);
        }
        if (i == 2) {
            return this.resources.getString(R.string.exo_track_stereo);
        }
        if (i == 6 || i == 7) {
            return this.resources.getString(R.string.exo_track_surround_5_point_1);
        }
        if (i != 8) {
            return this.resources.getString(R.string.exo_track_surround);
        }
        return this.resources.getString(R.string.exo_track_surround_7_point_1);
    }

    private String buildLanguageOrLabelString(Format format) {
        String joinWithSeparator = joinWithSeparator(buildLanguageString(format), buildRoleString(format));
        return TextUtils.isEmpty(joinWithSeparator) ? buildLabelString(format) : joinWithSeparator;
    }

    private String buildLabelString(Format format) {
        return TextUtils.isEmpty(format.label) ? "" : format.label;
    }

    private String buildLanguageString(Format format) {
        String str = format.language;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        return (Util.SDK_INT >= 21 ? Locale.forLanguageTag(str) : new Locale(str)).getDisplayName();
    }

    private String buildRoleString(Format format) {
        String string = (format.roleFlags & 2) != 0 ? this.resources.getString(R.string.exo_track_role_alternate) : "";
        if ((format.roleFlags & 4) != 0) {
            string = joinWithSeparator(string, this.resources.getString(R.string.exo_track_role_supplementary));
        }
        if ((format.roleFlags & 8) != 0) {
            string = joinWithSeparator(string, this.resources.getString(R.string.exo_track_role_commentary));
        }
        if ((format.roleFlags & 1088) == 0) {
            return string;
        }
        return joinWithSeparator(string, this.resources.getString(R.string.exo_track_role_closed_captions));
    }

    private String joinWithSeparator(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                if (TextUtils.isEmpty(str)) {
                    str = str2;
                } else {
                    str = this.resources.getString(R.string.exo_item_list, str, str2);
                }
            }
        }
        return str;
    }

    private static int inferPrimaryTrackType(Format format) {
        int trackType = MimeTypes.getTrackType(format.sampleMimeType);
        if (trackType != -1) {
            return trackType;
        }
        if (MimeTypes.getVideoMediaMimeType(format.codecs) != null) {
            return 2;
        }
        if (MimeTypes.getAudioMediaMimeType(format.codecs) != null) {
            return 1;
        }
        if (format.width != -1 || format.height != -1) {
            return 2;
        }
        if (format.channelCount == -1 && format.sampleRate == -1) {
            return -1;
        }
        return 1;
    }
}
