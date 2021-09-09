package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableMap;
import com.google.android.exoplayer2.C;
import java.util.Arrays;
import java.util.HashSet;

public class ViewProps {
    public static final int[] BORDER_SPACING_TYPES = {8, 4, 5, 1, 3, 0, 2};
    private static final HashSet<String> LAYOUT_ONLY_PROPS = new HashSet<>(Arrays.asList("alignSelf", "alignItems", "collapsable", "flex", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap", "justifyContent", "alignContent", "display", "position", "right", "top", "bottom", "left", "start", "end", "width", "height", "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "paddingStart", "paddingEnd"));
    public static final int[] PADDING_MARGIN_SPACING_TYPES = {8, 7, 6, 4, 5, 1, 3, 0, 2};
    public static final int[] POSITION_SPACING_TYPES = {4, 5, 1, 3};

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean isLayoutOnly(ReadableMap readableMap, String str) {
        char c;
        ReadableMap readableMap2 = readableMap;
        String str2 = str;
        if (LAYOUT_ONLY_PROPS.contains(str2)) {
            return true;
        }
        if ("pointerEvents".equals(str2)) {
            String string = readableMap.getString(str);
            if ("auto".equals(string) || "box-none".equals(string)) {
                return true;
            }
            return false;
        }
        switch (str.hashCode()) {
            case -1989576717:
                if (str2.equals("borderRightColor")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1971292586:
                if (str2.equals("borderRightWidth")) {
                    c = 9;
                    break;
                }
                c = 65535;
                break;
            case -1470826662:
                if (str2.equals("borderTopColor")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1452542531:
                if (str2.equals("borderTopWidth")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case -1308858324:
                if (str2.equals("borderBottomColor")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1290574193:
                if (str2.equals("borderBottomWidth")) {
                    c = 10;
                    break;
                }
                c = 65535;
                break;
            case -1267206133:
                if (str2.equals("opacity")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -242276144:
                if (str2.equals("borderLeftColor")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -223992013:
                if (str2.equals("borderLeftWidth")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 529642498:
                if (str2.equals("overflow")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 741115130:
                if (str2.equals("borderWidth")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1349188574:
                if (str2.equals("borderRadius")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                if (readableMap2.isNull("opacity") || readableMap2.getDouble("opacity") == 1.0d) {
                    return true;
                }
                return false;
            case 1:
                if (readableMap2.hasKey("backgroundColor") && readableMap2.getInt("backgroundColor") != 0) {
                    return false;
                }
                if (!readableMap2.hasKey("borderWidth") || readableMap2.isNull("borderWidth") || readableMap2.getDouble("borderWidth") == 0.0d) {
                    return true;
                }
                return false;
            case 2:
                if (readableMap2.isNull("borderLeftColor") || readableMap2.getInt("borderLeftColor") != 0) {
                    return false;
                }
                return true;
            case 3:
                if (readableMap2.isNull("borderRightColor") || readableMap2.getInt("borderRightColor") != 0) {
                    return false;
                }
                return true;
            case 4:
                if (readableMap2.isNull("borderTopColor") || readableMap2.getInt("borderTopColor") != 0) {
                    return false;
                }
                return true;
            case 5:
                if (readableMap2.isNull("borderBottomColor") || readableMap2.getInt("borderBottomColor") != 0) {
                    return false;
                }
                return true;
            case 6:
                if (readableMap2.isNull("borderWidth") || readableMap2.getDouble("borderWidth") == 0.0d) {
                    return true;
                }
                return false;
            case 7:
                if (readableMap2.isNull("borderLeftWidth") || readableMap2.getDouble("borderLeftWidth") == 0.0d) {
                    return true;
                }
                return false;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                if (readableMap2.isNull("borderTopWidth") || readableMap2.getDouble("borderTopWidth") == 0.0d) {
                    return true;
                }
                return false;
            case 9:
                if (readableMap2.isNull("borderRightWidth") || readableMap2.getDouble("borderRightWidth") == 0.0d) {
                    return true;
                }
                return false;
            case 10:
                if (readableMap2.isNull("borderBottomWidth") || readableMap2.getDouble("borderBottomWidth") == 0.0d) {
                    return true;
                }
                return false;
            case 11:
                if (readableMap2.isNull("overflow") || "visible".equals(readableMap2.getString("overflow"))) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }
}
