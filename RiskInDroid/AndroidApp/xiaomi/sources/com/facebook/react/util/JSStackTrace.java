package com.facebook.react.util;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSStackTrace {
    private static final Pattern FILE_ID_PATTERN = Pattern.compile("\\b((?:seg-\\d+(?:_\\d+)?|\\d+)\\.js)");

    public static String format(String str, ReadableArray readableArray) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(", stack:\n");
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            sb.append(map.getString("methodName"));
            sb.append("@");
            sb.append(parseFileId(map));
            if (!map.hasKey("lineNumber") || map.isNull("lineNumber") || map.getType("lineNumber") != ReadableType.Number) {
                sb.append(-1);
            } else {
                sb.append(map.getInt("lineNumber"));
            }
            if (map.hasKey("column") && !map.isNull("column") && map.getType("column") == ReadableType.Number) {
                sb.append(":");
                sb.append(map.getInt("column"));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String parseFileId(ReadableMap readableMap) {
        String string;
        if (!readableMap.hasKey("file") || readableMap.isNull("file") || readableMap.getType("file") != ReadableType.String || (string = readableMap.getString("file")) == null) {
            return "";
        }
        Matcher matcher = FILE_ID_PATTERN.matcher(string);
        if (!matcher.find()) {
            return "";
        }
        return matcher.group(1) + ":";
    }
}
