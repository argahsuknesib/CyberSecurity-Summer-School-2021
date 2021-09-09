package com.google.android.exoplayer2.text.ssa;

import android.graphics.PointF;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SsaStyle {
    public final int alignment;
    public final String name;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SsaAlignment {
    }

    private static boolean isValidAlignment(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private SsaStyle(String str, int i) {
        this.name = str;
        this.alignment = i;
    }

    public static SsaStyle fromStyleLine(String str, Format format) {
        Assertions.checkArgument(str.startsWith("Style:"));
        String[] split = TextUtils.split(str.substring(6), ",");
        if (split.length != format.length) {
            Log.w("SsaStyle", Util.formatInvariant("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(format.length), Integer.valueOf(split.length), str));
            return null;
        }
        try {
            return new SsaStyle(split[format.nameIndex].trim(), parseAlignment(split[format.alignmentIndex]));
        } catch (RuntimeException e) {
            Log.w("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e);
            return null;
        }
    }

    public static int parseAlignment(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (isValidAlignment(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        Log.w("SsaStyle", "Ignoring unknown alignment: ".concat(String.valueOf(str)));
        return -1;
    }

    static final class Format {
        public final int alignmentIndex;
        public final int length;
        public final int nameIndex;

        private Format(int i, int i2, int i3) {
            this.nameIndex = i;
            this.alignmentIndex = i2;
            this.length = i3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
        public static Format fromFormatLine(String str) {
            char c;
            String[] split = TextUtils.split(str.substring(7), ",");
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < split.length; i3++) {
                String lowerInvariant = Util.toLowerInvariant(split[i3].trim());
                int hashCode = lowerInvariant.hashCode();
                if (hashCode != 3373707) {
                    if (hashCode == 1767875043 && lowerInvariant.equals("alignment")) {
                        c = 1;
                        if (c == 0) {
                            i = i3;
                        } else if (c == 1) {
                            i2 = i3;
                        }
                    }
                } else if (lowerInvariant.equals("name")) {
                    c = 0;
                    if (c == 0) {
                    }
                }
                c = 65535;
                if (c == 0) {
                }
            }
            if (i != -1) {
                return new Format(i, i2, split.length);
            }
            return null;
        }
    }

    static final class Overrides {
        private static final Pattern ALIGNMENT_OVERRIDE_PATTERN = Pattern.compile("\\\\an(\\d+)");
        private static final Pattern BRACES_PATTERN = Pattern.compile("\\{([^}]*)\\}");
        private static final Pattern MOVE_PATTERN = Pattern.compile(Util.formatInvariant("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        private static final Pattern POSITION_PATTERN = Pattern.compile(Util.formatInvariant("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        public final int alignment;
        public final PointF position;

        private Overrides(int i, PointF pointF) {
            this.alignment = i;
            this.position = pointF;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|5|(1:7)|8|9|(2:11|18)(1:17)|15|1) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0022 */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0028  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x000a A[SYNTHETIC] */
        public static Overrides parseFromDialogue(String str) {
            Matcher matcher = BRACES_PATTERN.matcher(str);
            PointF pointF = null;
            int i = -1;
            while (matcher.find()) {
                String str2 = (String) Assertions.checkNotNull(matcher.group(1));
                PointF parsePosition = parsePosition(str2);
                if (parsePosition != null) {
                    pointF = parsePosition;
                }
                int parseAlignmentOverride = parseAlignmentOverride(str2);
                if (parseAlignmentOverride == -1) {
                    i = parseAlignmentOverride;
                }
            }
            return new Overrides(i, pointF);
        }

        public static String stripStyleOverrides(String str) {
            return BRACES_PATTERN.matcher(str).replaceAll("");
        }

        private static PointF parsePosition(String str) {
            String str2;
            String str3;
            Matcher matcher = POSITION_PATTERN.matcher(str);
            Matcher matcher2 = MOVE_PATTERN.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    Log.i("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                str2 = matcher.group(1);
                str3 = matcher.group(2);
            } else if (!find2) {
                return null;
            } else {
                str2 = matcher2.group(1);
                str3 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) Assertions.checkNotNull(str2)).trim()), Float.parseFloat(((String) Assertions.checkNotNull(str3)).trim()));
        }

        private static int parseAlignmentOverride(String str) {
            Matcher matcher = ALIGNMENT_OVERRIDE_PATTERN.matcher(str);
            if (matcher.find()) {
                return SsaStyle.parseAlignment((String) Assertions.checkNotNull(matcher.group(1)));
            }
            return -1;
        }
    }
}
