package com.mibi.sdk.component.recharge;

import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.BundleUtils;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class EntryData implements Serializable {
    public Map<String, Object> mExtraData;
    public String mId;
    public String mIntentUri;
    private transient Map<String, Object> mMetaData;
    public String mPackageName;
    public Type mType;
    public String mUrl;

    public <T> T getMetaData(String str, T t) {
        Map<String, Object> map = this.mMetaData;
        if (map != null && map.containsKey(str)) {
            try {
                return t.getClass().cast(this.mMetaData.get(str));
            } catch (Exception unused) {
            }
        }
        return t;
    }

    public enum Type {
        LOCAL,
        WEB,
        APP;

        public static Type getType(String str) {
            try {
                return valueOf(str);
            } catch (IllegalArgumentException e) {
                Log.e("EntryData", "EntryData Type IllegalArgumentException ", e);
                return null;
            }
        }

        public static String getTypes() {
            Type[] values = values();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(values[i].name());
            }
            return sb.toString();
        }
    }

    public void parseEntryData(JSONObject jSONObject) throws PaymentException {
        if (jSONObject != null) {
            try {
                this.mId = jSONObject.getString("id");
                this.mExtraData = BundleUtils.convertJson2Map(jSONObject.optJSONObject("extra"));
                this.mMetaData = BundleUtils.convertJson2Map(jSONObject.optJSONObject("meta"));
                String string = jSONObject.getString("type");
                this.mType = Type.getType(string);
                if (this.mType != null) {
                    int i = AnonymousClass1.$SwitchMap$com$mibi$sdk$component$recharge$EntryData$Type[this.mType.ordinal()];
                    if (i == 1) {
                        this.mUrl = jSONObject.optString("url");
                    } else if (i == 2) {
                        this.mUrl = jSONObject.getString("url");
                        if (TextUtils.isEmpty(this.mUrl)) {
                            throw new ResultException("mUrl should not all be null in WEB, type is ".concat(String.valueOf(string)));
                        }
                    } else if (i == 3) {
                        this.mUrl = jSONObject.optString("url");
                        this.mIntentUri = jSONObject.getString("intentUri");
                        this.mPackageName = jSONObject.getString("packageName");
                        if (!TextUtils.isEmpty(this.mIntentUri)) {
                            return;
                        }
                        if (TextUtils.isEmpty(this.mPackageName)) {
                            throw new ResultException("mIntentUri and mPackageName should not all be null in APP, type is ".concat(String.valueOf(string)));
                        }
                    }
                } else {
                    throw new ResultException("entryData type is null, type is ".concat(String.valueOf(string)));
                }
            } catch (JSONException e) {
                throw new ResultException(e);
            }
        }
    }

    /* renamed from: com.mibi.sdk.component.recharge.EntryData$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mibi$sdk$component$recharge$EntryData$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$mibi$sdk$component$recharge$EntryData$Type[Type.LOCAL.ordinal()] = 1;
            $SwitchMap$com$mibi$sdk$component$recharge$EntryData$Type[Type.WEB.ordinal()] = 2;
            try {
                $SwitchMap$com$mibi$sdk$component$recharge$EntryData$Type[Type.APP.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
