package com.facebook.react.uimanager;

import _m_j.bh;
import _m_j.cb;
import _m_j.cl;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class ReactAccessibilityDelegate extends bh {
    public static final HashMap<String, Integer> sActionIdMap;
    private static int sCounter = 1056964608;
    private final HashMap<Integer, String> mAccessibilityActionsMap = new HashMap<>();

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        sActionIdMap = hashMap;
        hashMap.put("activate", Integer.valueOf(cl.O000000o.O00000oO.O000000o()));
        sActionIdMap.put("longpress", Integer.valueOf(cl.O000000o.O00000oo.O000000o()));
        sActionIdMap.put("increment", Integer.valueOf(cl.O000000o.O0000o00.O000000o()));
        sActionIdMap.put("decrement", Integer.valueOf(cl.O000000o.O0000o0.O000000o()));
    }

    /* renamed from: com.facebook.react.uimanager.ReactAccessibilityDelegate$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole = new int[AccessibilityRole.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|(3:53|54|56)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|56) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00da */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fe */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x010a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0116 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0122 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x013a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.BUTTON.ordinal()] = 1;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.SEARCH.ordinal()] = 2;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.IMAGE.ordinal()] = 3;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.IMAGEBUTTON.ordinal()] = 4;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.KEYBOARDKEY.ordinal()] = 5;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.TEXT.ordinal()] = 6;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.ADJUSTABLE.ordinal()] = 7;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.CHECKBOX.ordinal()] = 8;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.RADIO.ordinal()] = 9;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.SPINBUTTON.ordinal()] = 10;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.SWITCH.ordinal()] = 11;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.NONE.ordinal()] = 12;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.LINK.ordinal()] = 13;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.SUMMARY.ordinal()] = 14;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.HEADER.ordinal()] = 15;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.ALERT.ordinal()] = 16;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.COMBOBOX.ordinal()] = 17;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.MENU.ordinal()] = 18;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.MENUBAR.ordinal()] = 19;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.MENUITEM.ordinal()] = 20;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.PROGRESSBAR.ordinal()] = 21;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.RADIOGROUP.ordinal()] = 22;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.SCROLLBAR.ordinal()] = 23;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.TAB.ordinal()] = 24;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.TABLIST.ordinal()] = 25;
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.TIMER.ordinal()] = 26;
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.TOOLBAR.ordinal()] = 27;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public enum AccessibilityRole {
        NONE,
        BUTTON,
        LINK,
        SEARCH,
        IMAGE,
        IMAGEBUTTON,
        KEYBOARDKEY,
        TEXT,
        ADJUSTABLE,
        SUMMARY,
        HEADER,
        ALERT,
        CHECKBOX,
        COMBOBOX,
        MENU,
        MENUBAR,
        MENUITEM,
        PROGRESSBAR,
        RADIO,
        RADIOGROUP,
        SCROLLBAR,
        SPINBUTTON,
        SWITCH,
        TAB,
        TABLIST,
        TIMER,
        TOOLBAR;

        public static String getValue(AccessibilityRole accessibilityRole) {
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[accessibilityRole.ordinal()]) {
                case 1:
                    return "android.widget.Button";
                case 2:
                    return "android.widget.EditText";
                case 3:
                    return "android.widget.ImageView";
                case 4:
                    return "android.widget.ImageButon";
                case 5:
                    return "android.inputmethodservice.Keyboard$Key";
                case 6:
                    return "android.widget.TextView";
                case 7:
                    return "android.widget.SeekBar";
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    return "android.widget.CheckBox";
                case 9:
                    return "android.widget.RadioButton";
                case 10:
                    return "android.widget.SpinButton";
                case 11:
                    return "android.widget.Switch";
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                case 13:
                case 14:
                case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    return "android.view.View";
                default:
                    throw new IllegalArgumentException("Invalid accessibility role value: ".concat(String.valueOf(accessibilityRole)));
            }
        }

        public static AccessibilityRole fromValue(String str) {
            for (AccessibilityRole accessibilityRole : values()) {
                if (accessibilityRole.name().equalsIgnoreCase(str)) {
                    return accessibilityRole;
                }
            }
            throw new IllegalArgumentException("Invalid accessibility role value: ".concat(String.valueOf(str)));
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
        super.onInitializeAccessibilityNodeInfo(view, clVar);
        AccessibilityRole accessibilityRole = (AccessibilityRole) view.getTag(R.id.accessibility_role);
        if (accessibilityRole != null) {
            setRole(clVar, accessibilityRole, view.getContext());
        }
        ReadableArray readableArray = (ReadableArray) view.getTag(R.id.accessibility_states);
        ReadableMap readableMap = (ReadableMap) view.getTag(R.id.accessibility_state);
        if (readableArray != null) {
            setStates(clVar, readableArray, view.getContext());
        }
        if (readableMap != null) {
            setState(clVar, readableMap, view.getContext());
        }
        ReadableArray readableArray2 = (ReadableArray) view.getTag(R.id.accessibility_actions);
        if (readableArray2 != null) {
            int i = 0;
            while (i < readableArray2.size()) {
                ReadableMap map = readableArray2.getMap(i);
                if (map.hasKey("name")) {
                    int i2 = sCounter;
                    String string = map.hasKey("label") ? map.getString("label") : null;
                    if (sActionIdMap.containsKey(map.getString("name"))) {
                        i2 = sActionIdMap.get(map.getString("name")).intValue();
                    } else {
                        sCounter++;
                    }
                    this.mAccessibilityActionsMap.put(Integer.valueOf(i2), map.getString("name"));
                    clVar.O000000o(new cl.O000000o(i2, string));
                    i++;
                } else {
                    throw new IllegalArgumentException("Unknown accessibility action.");
                }
            }
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (!this.mAccessibilityActionsMap.containsKey(Integer.valueOf(i))) {
            return super.performAccessibilityAction(view, i, bundle);
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putString("actionName", this.mAccessibilityActionsMap.get(Integer.valueOf(i)));
        ((RCTEventEmitter) ((ReactContext) view.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(view.getId(), "topAccessibilityAction", createMap);
        return true;
    }

    private static void setStates(cl clVar, ReadableArray readableArray, Context context) {
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            char c = 65535;
            switch (string.hashCode()) {
                case -1840852242:
                    if (string.equals("unchecked")) {
                        c = 3;
                        break;
                    }
                    break;
                case 270940796:
                    if (string.equals("disabled")) {
                        c = 1;
                        break;
                    }
                    break;
                case 742313895:
                    if (string.equals("checked")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1191572123:
                    if (string.equals("selected")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                clVar.O0000O0o(true);
            } else if (c == 1) {
                clVar.O0000Oo(false);
            } else if (c == 2) {
                clVar.O000000o(true);
                clVar.O00000Oo(true);
                if (clVar.f13980O000000o.getClassName().equals(AccessibilityRole.getValue(AccessibilityRole.SWITCH))) {
                    clVar.O00000o0(context.getString(R.string.state_on_description));
                }
            } else if (c == 3) {
                clVar.O000000o(true);
                clVar.O00000Oo(false);
                if (clVar.f13980O000000o.getClassName().equals(AccessibilityRole.getValue(AccessibilityRole.SWITCH))) {
                    clVar.O00000o0(context.getString(R.string.state_off_description));
                }
            }
        }
    }

    private static void setState(cl clVar, ReadableMap readableMap, Context context) {
        Log.d("ReactAccessibilityDelegate", "setState ".concat(String.valueOf(readableMap)));
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            Dynamic dynamic = readableMap.getDynamic(nextKey);
            if (nextKey.equals("selected") && dynamic.getType() == ReadableType.Boolean) {
                clVar.O0000O0o(dynamic.asBoolean());
            } else if (nextKey.equals("disabled") && dynamic.getType() == ReadableType.Boolean) {
                clVar.O0000Oo(!dynamic.asBoolean());
            } else if (nextKey.equals("checked") && dynamic.getType() == ReadableType.Boolean) {
                boolean asBoolean = dynamic.asBoolean();
                clVar.O000000o(true);
                clVar.O00000Oo(asBoolean);
                if (clVar.f13980O000000o.getClassName().equals(AccessibilityRole.getValue(AccessibilityRole.SWITCH))) {
                    clVar.O00000o0(context.getString(asBoolean ? R.string.state_on_description : R.string.state_off_description));
                }
            }
        }
    }

    public static void setRole(cl clVar, AccessibilityRole accessibilityRole, Context context) {
        cl.O00000o0 o00000o0;
        if (accessibilityRole == null) {
            accessibilityRole = AccessibilityRole.NONE;
        }
        clVar.O00000Oo((CharSequence) AccessibilityRole.getValue(accessibilityRole));
        if (accessibilityRole.equals(AccessibilityRole.LINK)) {
            clVar.O0000O0o(context.getString(R.string.link_description));
            if (clVar.f13980O000000o.getContentDescription() != null) {
                SpannableString spannableString = new SpannableString(clVar.f13980O000000o.getContentDescription());
                spannableString.setSpan(new URLSpan(""), 0, spannableString.length(), 0);
                clVar.O00000oO(spannableString);
            }
            if (clVar.O00000o() != null) {
                SpannableString spannableString2 = new SpannableString(clVar.O00000o());
                spannableString2.setSpan(new URLSpan(""), 0, spannableString2.length(), 0);
                clVar.O00000o0(spannableString2);
            }
        } else if (accessibilityRole.equals(AccessibilityRole.SEARCH)) {
            clVar.O0000O0o(context.getString(R.string.search_description));
        } else if (accessibilityRole.equals(AccessibilityRole.IMAGE)) {
            clVar.O0000O0o(context.getString(R.string.image_description));
        } else if (accessibilityRole.equals(AccessibilityRole.IMAGEBUTTON)) {
            clVar.O0000O0o(context.getString(R.string.imagebutton_description));
            clVar.O0000OOo(true);
        } else if (accessibilityRole.equals(AccessibilityRole.SUMMARY)) {
            clVar.O0000O0o(context.getString(R.string.summary_description));
        } else if (accessibilityRole.equals(AccessibilityRole.HEADER)) {
            clVar.O0000O0o(context.getString(R.string.header_description));
            if (Build.VERSION.SDK_INT >= 19) {
                o00000o0 = new cl.O00000o0(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, 0, 1, true));
            } else {
                o00000o0 = new cl.O00000o0(null);
            }
            clVar.O00000Oo(o00000o0);
        } else if (accessibilityRole.equals(AccessibilityRole.ALERT)) {
            clVar.O0000O0o(context.getString(R.string.alert_description));
        } else if (accessibilityRole.equals(AccessibilityRole.COMBOBOX)) {
            clVar.O0000O0o(context.getString(R.string.combobox_description));
        } else if (accessibilityRole.equals(AccessibilityRole.MENU)) {
            clVar.O0000O0o(context.getString(R.string.menu_description));
        } else if (accessibilityRole.equals(AccessibilityRole.MENUBAR)) {
            clVar.O0000O0o(context.getString(R.string.menubar_description));
        } else if (accessibilityRole.equals(AccessibilityRole.MENUITEM)) {
            clVar.O0000O0o(context.getString(R.string.menuitem_description));
        } else if (accessibilityRole.equals(AccessibilityRole.PROGRESSBAR)) {
            clVar.O0000O0o(context.getString(R.string.progressbar_description));
        } else if (accessibilityRole.equals(AccessibilityRole.RADIOGROUP)) {
            clVar.O0000O0o(context.getString(R.string.radiogroup_description));
        } else if (accessibilityRole.equals(AccessibilityRole.SCROLLBAR)) {
            clVar.O0000O0o(context.getString(R.string.scrollbar_description));
        } else if (accessibilityRole.equals(AccessibilityRole.SPINBUTTON)) {
            clVar.O0000O0o(context.getString(R.string.spinbutton_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TAB)) {
            clVar.O0000O0o(context.getString(R.string.rn_tab_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TABLIST)) {
            clVar.O0000O0o(context.getString(R.string.tablist_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TIMER)) {
            clVar.O0000O0o(context.getString(R.string.timer_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TOOLBAR)) {
            clVar.O0000O0o(context.getString(R.string.toolbar_description));
        }
    }

    public static void setDelegate(View view) {
        if (cb.O00000o0(view)) {
            return;
        }
        if (view.getTag(R.id.accessibility_role) != null || view.getTag(R.id.accessibility_states) != null || view.getTag(R.id.accessibility_state) != null || view.getTag(R.id.accessibility_actions) != null) {
            cb.O000000o(view, new ReactAccessibilityDelegate());
        }
    }
}
