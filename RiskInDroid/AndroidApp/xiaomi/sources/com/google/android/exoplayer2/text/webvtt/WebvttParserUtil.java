package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttParserUtil {
    private static final Pattern COMMENT = Pattern.compile("^NOTE([ \t].*)?$");

    private WebvttParserUtil() {
    }

    public static void validateWebvttHeaderLine(ParsableByteArray parsableByteArray) throws ParserException {
        int position = parsableByteArray.getPosition();
        if (!isWebvttHeaderLine(parsableByteArray)) {
            parsableByteArray.setPosition(position);
            throw new ParserException("Expected WEBVTT. Got " + parsableByteArray.readLine());
        }
    }

    public static boolean isWebvttHeaderLine(ParsableByteArray parsableByteArray) {
        String readLine = parsableByteArray.readLine();
        return readLine != null && readLine.startsWith("WEBVTT");
    }

    public static long parseTimestampUs(String str) throws NumberFormatException {
        String[] splitAtFirst = Util.splitAtFirst(str, "\\.");
        long j = 0;
        for (String parseLong : Util.split(splitAtFirst[0], ":")) {
            j = (j * 60) + Long.parseLong(parseLong);
        }
        long j2 = j * 1000;
        if (splitAtFirst.length == 2) {
            j2 += Long.parseLong(splitAtFirst[1]);
        }
        return j2 * 1000;
    }

    public static float parsePercentage(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static Matcher findNextCueHeader(ParsableByteArray parsableByteArray) {
        String readLine;
        while (true) {
            String readLine2 = parsableByteArray.readLine();
            if (readLine2 == null) {
                return null;
            }
            if (COMMENT.matcher(readLine2).matches()) {
                do {
                    readLine = parsableByteArray.readLine();
                    if (readLine == null) {
                        break;
                    }
                } while (!readLine.isEmpty());
            } else {
                Matcher matcher = WebvttCueParser.CUE_HEADER_PATTERN.matcher(readLine2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }
}
