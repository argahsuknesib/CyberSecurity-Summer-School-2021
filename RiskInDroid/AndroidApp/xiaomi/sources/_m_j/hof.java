package _m_j;

import java.util.ArrayList;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bO\b\b\u0018\u0000 m2\u00020\u0001:\u0006mnopqrB\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010!\u001a\u00020\"\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010%J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010M\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\u0010\u0010X\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010[\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u00100J\t\u0010\\\u001a\u00020\u001eHÆ\u0003J\t\u0010]\u001a\u00020 HÆ\u0003J\t\u0010^\u001a\u00020\"HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010$HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0007HÆ\u0003JÌ\u0002\u0010g\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$HÆ\u0001¢\u0006\u0002\u0010hJ\u0013\u0010i\u001a\u00020\u00192\b\u0010j\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010k\u001a\u00020\u0005HÖ\u0001J\t\u0010l\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u00101\u001a\u0004\b2\u00100R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u00101\u001a\u0004\b9\u00100R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010'R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u0010'R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u0010'R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b=\u0010'R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u0010'R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u0010'R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u0010'R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010'R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bB\u0010'R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bC\u0010'R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00105\u001a\u0004\bD\u00104R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010K\u001a\u0004\bI\u0010J¨\u0006s"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl;", "", "tempId", "", "version", "", "desc", "", "shortDesc", "name", "logoUrl", "pictureUrl", "taUrl", "taText", "taIcon", "tcUrl", "tcText", "tcIcon", "acUrl", "acText", "acIcon", "tcaUrl", "tcaText", "tcaIcon", "required", "", "extra", "enable", "enablePush", "trigger", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendTrigger;", "condition", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendCondition;", "action", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction;", "timespan", "Lcom/xiaomi/smarthome/scene/bean/TimeSpan;", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendTrigger;Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendCondition;Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction;Lcom/xiaomi/smarthome/scene/bean/TimeSpan;)V", "getAcIcon", "()Ljava/lang/String;", "getAcText", "getAcUrl", "getAction", "()Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction;", "getCondition", "()Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendCondition;", "getDesc", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnablePush", "getExtra", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLogoUrl", "getName", "getPictureUrl", "getRequired", "getShortDesc", "getTaIcon", "getTaText", "getTaUrl", "getTcIcon", "getTcText", "getTcUrl", "getTcaIcon", "getTcaText", "getTcaUrl", "getTempId", "getTimespan", "()Lcom/xiaomi/smarthome/scene/bean/TimeSpan;", "getTrigger", "()Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendTrigger;", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendTrigger;Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendCondition;Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction;Lcom/xiaomi/smarthome/scene/bean/TimeSpan;)Lcom/xiaomi/smarthome/scene/bean/RecommendTpl;", "equals", "other", "hashCode", "toString", "Companion", "DeviceType", "RecommendAction", "RecommendCondition", "RecommendTrigger", "TriggerConSubProp", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hof {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f432O000000o = new O000000o((byte) 0);
    public final Long O00000Oo;
    public final String O00000o;
    public final String O00000o0;
    public final String O00000oO;
    public final String O00000oo;
    public final String O0000O0o;
    public final String O0000OOo;
    public final String O0000Oo;
    public final String O0000Oo0;
    public final String O0000OoO;
    public final String O0000Ooo;
    public final String O0000o;
    public final String O0000o0;
    public final String O0000o00;
    public final String O0000o0O;
    public final String O0000o0o;
    public final Boolean O0000oO;
    public final String O0000oO0;
    public final Boolean O0000oOO;
    public final O0000O0o O0000oOo;
    public final O00000o0 O0000oo;
    public final O00000o O0000oo0;
    public final hoi O0000ooO;
    private final Integer O0000ooo;
    private final Long O000O00o;
    private final String O00oOooO;
    private final Boolean O00oOooo;

    public static final hof O000000o(JSONObject jSONObject) {
        return O000000o.O000000o(jSONObject);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hof)) {
            return false;
        }
        hof hof = (hof) obj;
        return ixe.O000000o(this.O00000Oo, hof.O00000Oo) && ixe.O000000o(this.O0000ooo, hof.O0000ooo) && ixe.O000000o(this.O00000o0, hof.O00000o0) && ixe.O000000o(this.O00000o, hof.O00000o) && ixe.O000000o(this.O00000oO, hof.O00000oO) && ixe.O000000o(this.O00000oo, hof.O00000oo) && ixe.O000000o(this.O00oOooO, hof.O00oOooO) && ixe.O000000o(this.O0000O0o, hof.O0000O0o) && ixe.O000000o(this.O0000OOo, hof.O0000OOo) && ixe.O000000o(this.O0000Oo0, hof.O0000Oo0) && ixe.O000000o(this.O0000Oo, hof.O0000Oo) && ixe.O000000o(this.O0000OoO, hof.O0000OoO) && ixe.O000000o(this.O0000Ooo, hof.O0000Ooo) && ixe.O000000o(this.O0000o00, hof.O0000o00) && ixe.O000000o(this.O0000o0, hof.O0000o0) && ixe.O000000o(this.O0000o0O, hof.O0000o0O) && ixe.O000000o(this.O0000o0o, hof.O0000o0o) && ixe.O000000o(this.O0000o, hof.O0000o) && ixe.O000000o(this.O0000oO0, hof.O0000oO0) && ixe.O000000o(this.O00oOooo, hof.O00oOooo) && ixe.O000000o(this.O000O00o, hof.O000O00o) && ixe.O000000o(this.O0000oO, hof.O0000oO) && ixe.O000000o(this.O0000oOO, hof.O0000oOO) && ixe.O000000o(this.O0000oOo, hof.O0000oOo) && ixe.O000000o(this.O0000oo0, hof.O0000oo0) && ixe.O000000o(this.O0000oo, hof.O0000oo) && ixe.O000000o(this.O0000ooO, hof.O0000ooO);
    }

    public final int hashCode() {
        Long l = this.O00000Oo;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Integer num = this.O0000ooo;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.O00000o0;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.O00000o;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.O00000oO;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.O00000oo;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.O00oOooO;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.O0000O0o;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.O0000OOo;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.O0000Oo0;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.O0000Oo;
        int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.O0000OoO;
        int hashCode12 = (hashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.O0000Ooo;
        int hashCode13 = (hashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.O0000o00;
        int hashCode14 = (hashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.O0000o0;
        int hashCode15 = (hashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.O0000o0O;
        int hashCode16 = (hashCode15 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.O0000o0o;
        int hashCode17 = (hashCode16 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.O0000o;
        int hashCode18 = (hashCode17 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.O0000oO0;
        int hashCode19 = (hashCode18 + (str17 == null ? 0 : str17.hashCode())) * 31;
        Boolean bool = this.O00oOooo;
        int hashCode20 = (hashCode19 + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l2 = this.O000O00o;
        int hashCode21 = (hashCode20 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Boolean bool2 = this.O0000oO;
        int hashCode22 = (hashCode21 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.O0000oOO;
        int hashCode23 = (((((((hashCode22 + (bool3 == null ? 0 : bool3.hashCode())) * 31) + this.O0000oOo.hashCode()) * 31) + this.O0000oo0.hashCode()) * 31) + this.O0000oo.hashCode()) * 31;
        hoi hoi = this.O0000ooO;
        if (hoi != null) {
            i = hoi.hashCode();
        }
        return hashCode23 + i;
    }

    public final String toString() {
        return "RecommendTpl(tempId=" + this.O00000Oo + ", version=" + this.O0000ooo + ", desc=" + ((Object) this.O00000o0) + ", shortDesc=" + ((Object) this.O00000o) + ", name=" + ((Object) this.O00000oO) + ", logoUrl=" + ((Object) this.O00000oo) + ", pictureUrl=" + ((Object) this.O00oOooO) + ", taUrl=" + ((Object) this.O0000O0o) + ", taText=" + ((Object) this.O0000OOo) + ", taIcon=" + ((Object) this.O0000Oo0) + ", tcUrl=" + ((Object) this.O0000Oo) + ", tcText=" + ((Object) this.O0000OoO) + ", tcIcon=" + ((Object) this.O0000Ooo) + ", acUrl=" + ((Object) this.O0000o00) + ", acText=" + ((Object) this.O0000o0) + ", acIcon=" + ((Object) this.O0000o0O) + ", tcaUrl=" + ((Object) this.O0000o0o) + ", tcaText=" + ((Object) this.O0000o) + ", tcaIcon=" + ((Object) this.O0000oO0) + ", required=" + this.O00oOooo + ", extra=" + this.O000O00o + ", enable=" + this.O0000oO + ", enablePush=" + this.O0000oOO + ", trigger=" + this.O0000oOo + ", condition=" + this.O0000oo0 + ", action=" + this.O0000oo + ", timespan=" + this.O0000ooO + ')';
    }

    public hof(Long l, Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Boolean bool, Long l2, Boolean bool2, Boolean bool3, O0000O0o o0000O0o, O00000o o00000o, O00000o0 o00000o0, hoi hoi) {
        O0000O0o o0000O0o2 = o0000O0o;
        O00000o o00000o2 = o00000o;
        O00000o0 o00000o02 = o00000o0;
        ixe.O00000o(o0000O0o2, "trigger");
        ixe.O00000o(o00000o2, "condition");
        ixe.O00000o(o00000o02, "action");
        this.O00000Oo = l;
        this.O0000ooo = num;
        this.O00000o0 = str;
        this.O00000o = str2;
        this.O00000oO = str3;
        this.O00000oo = str4;
        this.O00oOooO = str5;
        this.O0000O0o = str6;
        this.O0000OOo = str7;
        this.O0000Oo0 = str8;
        this.O0000Oo = str9;
        this.O0000OoO = str10;
        this.O0000Ooo = str11;
        this.O0000o00 = str12;
        this.O0000o0 = str13;
        this.O0000o0O = str14;
        this.O0000o0o = str15;
        this.O0000o = str16;
        this.O0000oO0 = str17;
        this.O00oOooo = bool;
        this.O000O00o = l2;
        this.O0000oO = bool2;
        this.O0000oOO = bool3;
        this.O0000oOo = o0000O0o2;
        this.O0000oo0 = o00000o2;
        this.O0000oo = o00000o02;
        this.O0000ooO = hoi;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u0000 )2\u00020\u0001:\u0002)*BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003Jh\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\nHÖ\u0001R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006+"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendTrigger;", "", "optiontype", "", "options", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendTrigger$TriggerOption;", "Lkotlin/collections/ArrayList;", "express", "diversionUrl", "", "diversionText", "diversionIcon", "desc", "(Ljava/lang/Integer;Ljava/util/ArrayList;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getDiversionIcon", "getDiversionText", "getDiversionUrl", "getExpress", "()I", "getOptions", "()Ljava/util/ArrayList;", "getOptiontype", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/util/ArrayList;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendTrigger;", "equals", "", "other", "hashCode", "toString", "Companion", "TriggerOption", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f441O000000o = new O000000o((byte) 0);
        public final Integer O00000Oo;
        public final int O00000o;
        public final ArrayList<O00000Oo> O00000o0;
        public final String O00000oO;
        public final String O00000oo;
        public final String O0000O0o;
        public final String O0000OOo;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O0000O0o)) {
                return false;
            }
            O0000O0o o0000O0o = (O0000O0o) obj;
            return ixe.O000000o(this.O00000Oo, o0000O0o.O00000Oo) && ixe.O000000o(this.O00000o0, o0000O0o.O00000o0) && this.O00000o == o0000O0o.O00000o && ixe.O000000o(this.O00000oO, o0000O0o.O00000oO) && ixe.O000000o(this.O00000oo, o0000O0o.O00000oo) && ixe.O000000o(this.O0000O0o, o0000O0o.O0000O0o) && ixe.O000000o(this.O0000OOo, o0000O0o.O0000OOo);
        }

        public final int hashCode() {
            Integer num = this.O00000Oo;
            int i = 0;
            int hashCode = (((((((((num == null ? 0 : num.hashCode()) * 31) + this.O00000o0.hashCode()) * 31) + Integer.valueOf(this.O00000o).hashCode()) * 31) + this.O00000oO.hashCode()) * 31) + this.O00000oo.hashCode()) * 31;
            String str = this.O0000O0o;
            if (str != null) {
                i = str.hashCode();
            }
            return ((hashCode + i) * 31) + this.O0000OOo.hashCode();
        }

        public final String toString() {
            return "RecommendTrigger(optiontype=" + this.O00000Oo + ", options=" + this.O00000o0 + ", express=" + this.O00000o + ", diversionUrl=" + this.O00000oO + ", diversionText=" + this.O00000oo + ", diversionIcon=" + ((Object) this.O0000O0o) + ", desc=" + this.O0000OOo + ')';
        }

        public O0000O0o(Integer num, ArrayList<O00000Oo> arrayList, int i, String str, String str2, String str3, String str4) {
            ixe.O00000o(arrayList, "options");
            ixe.O00000o(str, "diversionUrl");
            ixe.O00000o(str2, "diversionText");
            ixe.O00000o(str4, "desc");
            this.O00000Oo = num;
            this.O00000o0 = arrayList;
            this.O00000o = i;
            this.O00000oO = str;
            this.O00000oo = str2;
            this.O0000O0o = str3;
            this.O0000OOo = str4;
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 ?2\u00020\u0001:\u0001?BÙ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r\u0012\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r\u0012\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001d\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\rHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u001d\u00105\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rHÆ\u0003J\u001d\u00106\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rHÆ\u0003J\u001d\u00107\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\rHÆ\u0003Jþ\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r2\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\t\u0010>\u001a\u00020\u0007HÖ\u0001R%\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R%\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR%\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R%\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\"\u0010\u001fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b#\u0010\u001fR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b$\u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b)\u0010\u001f¨\u0006@"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendTrigger$TriggerOption;", "", "id", "", "styleId", "displayType", "desc", "", "triggeSource", "triggeType", "deviceTypeEnabled", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$DeviceType;", "Lkotlin/collections/ArrayList;", "deviceTypeDisabled", "blackList", "valueJson", "conSubProps", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$TriggerConSubProp;", "subPropExpress", "valueType", "priority", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBlackList", "()Ljava/util/ArrayList;", "getConSubProps", "getDesc", "()Ljava/lang/String;", "getDeviceTypeDisabled", "getDeviceTypeEnabled", "getDisplayType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getPriority", "getStyleId", "getSubPropExpress", "getTriggeSource", "getTriggeType", "getValueJson", "()Ljava/lang/Object;", "getValueType", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendTrigger$TriggerOption;", "equals", "", "other", "hashCode", "toString", "Companion", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O000000o f442O000000o = new O000000o((byte) 0);
            public final Integer O00000Oo;
            public final Integer O00000o;
            public final Integer O00000o0;
            public final String O00000oO;
            public final String O00000oo;
            public final ArrayList<O00000Oo> O0000O0o;
            public final ArrayList<O00000Oo> O0000OOo;
            public final Object O0000Oo;
            public final ArrayList<String> O0000Oo0;
            public final ArrayList<O0000OOo> O0000OoO;
            public final Integer O0000Ooo;
            public final Integer O0000o0;
            public final Integer O0000o00;
            private final String O0000o0O;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof O00000Oo)) {
                    return false;
                }
                O00000Oo o00000Oo = (O00000Oo) obj;
                return ixe.O000000o(this.O00000Oo, o00000Oo.O00000Oo) && ixe.O000000o(this.O00000o0, o00000Oo.O00000o0) && ixe.O000000o(this.O00000o, o00000Oo.O00000o) && ixe.O000000o(this.O0000o0O, o00000Oo.O0000o0O) && ixe.O000000o(this.O00000oO, o00000Oo.O00000oO) && ixe.O000000o(this.O00000oo, o00000Oo.O00000oo) && ixe.O000000o(this.O0000O0o, o00000Oo.O0000O0o) && ixe.O000000o(this.O0000OOo, o00000Oo.O0000OOo) && ixe.O000000o(this.O0000Oo0, o00000Oo.O0000Oo0) && ixe.O000000o(this.O0000Oo, o00000Oo.O0000Oo) && ixe.O000000o(this.O0000OoO, o00000Oo.O0000OoO) && ixe.O000000o(this.O0000Ooo, o00000Oo.O0000Ooo) && ixe.O000000o(this.O0000o00, o00000Oo.O0000o00) && ixe.O000000o(this.O0000o0, o00000Oo.O0000o0);
            }

            public final int hashCode() {
                Integer num = this.O00000Oo;
                int i = 0;
                int hashCode = (num == null ? 0 : num.hashCode()) * 31;
                Integer num2 = this.O00000o0;
                int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
                Integer num3 = this.O00000o;
                int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
                String str = this.O0000o0O;
                int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.O00000oO;
                int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.O00000oo;
                int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
                ArrayList<O00000Oo> arrayList = this.O0000O0o;
                int hashCode7 = (hashCode6 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
                ArrayList<O00000Oo> arrayList2 = this.O0000OOo;
                int hashCode8 = (hashCode7 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
                ArrayList<String> arrayList3 = this.O0000Oo0;
                int hashCode9 = (hashCode8 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31;
                Object obj = this.O0000Oo;
                int hashCode10 = (hashCode9 + (obj == null ? 0 : obj.hashCode())) * 31;
                ArrayList<O0000OOo> arrayList4 = this.O0000OoO;
                int hashCode11 = (hashCode10 + (arrayList4 == null ? 0 : arrayList4.hashCode())) * 31;
                Integer num4 = this.O0000Ooo;
                int hashCode12 = (hashCode11 + (num4 == null ? 0 : num4.hashCode())) * 31;
                Integer num5 = this.O0000o00;
                int hashCode13 = (hashCode12 + (num5 == null ? 0 : num5.hashCode())) * 31;
                Integer num6 = this.O0000o0;
                if (num6 != null) {
                    i = num6.hashCode();
                }
                return hashCode13 + i;
            }

            public final String toString() {
                return "TriggerOption(id=" + this.O00000Oo + ", styleId=" + this.O00000o0 + ", displayType=" + this.O00000o + ", desc=" + ((Object) this.O0000o0O) + ", triggeSource=" + ((Object) this.O00000oO) + ", triggeType=" + ((Object) this.O00000oo) + ", deviceTypeEnabled=" + this.O0000O0o + ", deviceTypeDisabled=" + this.O0000OOo + ", blackList=" + this.O0000Oo0 + ", valueJson=" + this.O0000Oo + ", conSubProps=" + this.O0000OoO + ", subPropExpress=" + this.O0000Ooo + ", valueType=" + this.O0000o00 + ", priority=" + this.O0000o0 + ')';
            }

            public O00000Oo(Integer num, Integer num2, Integer num3, String str, String str2, String str3, ArrayList<O00000Oo> arrayList, ArrayList<O00000Oo> arrayList2, ArrayList<String> arrayList3, Object obj, ArrayList<O0000OOo> arrayList4, Integer num4, Integer num5, Integer num6) {
                this.O00000Oo = num;
                this.O00000o0 = num2;
                this.O00000o = num3;
                this.O0000o0O = str;
                this.O00000oO = str2;
                this.O00000oo = str3;
                this.O0000O0o = arrayList;
                this.O0000OOo = arrayList2;
                this.O0000Oo0 = arrayList3;
                this.O0000Oo = obj;
                this.O0000OoO = arrayList4;
                this.O0000Ooo = num4;
                this.O0000o00 = num5;
                this.O0000o0 = num6;
            }

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendTrigger$TriggerOption$Companion;", "", "()V", "parseItem", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendTrigger$TriggerOption;", "jsonObject", "Lorg/json/JSONObject;", "parseList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "Lorg/json/JSONArray;", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class O000000o {
                public /* synthetic */ O000000o(byte b) {
                    this();
                }

                private O000000o() {
                }

                public static ArrayList<O00000Oo> O000000o(JSONArray jSONArray) {
                    int i;
                    JSONObject jSONObject;
                    ArrayList<O00000Oo> arrayList = new ArrayList<>();
                    int i2 = 0;
                    if (jSONArray == null) {
                        i = 0;
                    } else {
                        i = jSONArray.length();
                    }
                    if (i > 0) {
                        while (true) {
                            int i3 = i2 + 1;
                            if (jSONArray == null) {
                                jSONObject = null;
                            } else {
                                jSONObject = jSONArray.optJSONObject(i2);
                            }
                            arrayList.add(O000000o(jSONObject));
                            if (i3 >= i) {
                                break;
                            }
                            i2 = i3;
                        }
                    }
                    return arrayList;
                }

                private static O00000Oo O000000o(JSONObject jSONObject) {
                    Integer num;
                    Integer num2;
                    Integer num3;
                    String str;
                    String str2;
                    String str3;
                    Object obj;
                    Integer num4;
                    JSONObject jSONObject2 = jSONObject;
                    Integer num5 = null;
                    Object opt = jSONObject2 == null ? null : jSONObject2.opt("value_json");
                    ArrayList<O0000OOo> arrayList = new ArrayList<>();
                    int i = 0;
                    if (opt != null && (opt instanceof JSONObject)) {
                        try {
                            JSONObject optJSONObject = ((JSONObject) opt).optJSONObject("sub_props");
                            if (optJSONObject != null) {
                                i = optJSONObject.optInt("express");
                            }
                            JSONObject optJSONObject2 = ((JSONObject) opt).optJSONObject("sub_props");
                            JSONArray optJSONArray = optJSONObject2 == null ? null : optJSONObject2.optJSONArray("attr");
                            O0000OOo.O000000o o000000o = O0000OOo.f443O000000o;
                            arrayList = O0000OOo.O000000o.O000000o(optJSONArray);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    ArrayList<O0000OOo> arrayList2 = arrayList;
                    if (jSONObject2 == null) {
                        num = null;
                    } else {
                        num = Integer.valueOf(jSONObject2.optInt("id"));
                    }
                    if (jSONObject2 == null) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(jSONObject2.optInt("style_id"));
                    }
                    if (jSONObject2 == null) {
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(jSONObject2.optInt("display_type"));
                    }
                    if (jSONObject2 == null) {
                        str = null;
                    } else {
                        str = jSONObject2.optString("desc");
                    }
                    if (jSONObject2 == null) {
                        str2 = null;
                    } else {
                        str2 = jSONObject2.optString("trigger_source");
                    }
                    if (jSONObject2 == null) {
                        str3 = null;
                    } else {
                        str3 = jSONObject2.optString("trigger_type");
                    }
                    O00000Oo.O000000o o000000o2 = O00000Oo.f433O000000o;
                    ArrayList<O00000Oo> O000000o2 = O00000Oo.O000000o.O000000o(jSONObject2 == null ? null : jSONObject2.optJSONArray("device_type_enabled"));
                    O00000Oo.O000000o o000000o3 = O00000Oo.f433O000000o;
                    ArrayList<O00000Oo> O000000o3 = O00000Oo.O000000o.O000000o(jSONObject2 == null ? null : jSONObject2.optJSONArray("device_type_disabled"));
                    O000000o o000000o4 = hof.f432O000000o;
                    ArrayList<String> O000000o4 = O000000o.O000000o(jSONObject2 == null ? null : jSONObject2.optJSONArray("blacklist_model"));
                    if (jSONObject2 == null) {
                        obj = null;
                    } else {
                        obj = jSONObject2.opt("value_json");
                    }
                    Integer valueOf = Integer.valueOf(i);
                    if (jSONObject2 == null) {
                        num4 = null;
                    } else {
                        num4 = Integer.valueOf(jSONObject2.optInt("value_type"));
                    }
                    if (jSONObject2 != null) {
                        num5 = Integer.valueOf(jSONObject2.optInt("priority"));
                    }
                    return new O00000Oo(num, num2, num3, str, str2, str3, O000000o2, O000000o3, O000000o4, obj, arrayList2, valueOf, num4, num5);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendTrigger$Companion;", "", "()V", "parse", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendTrigger;", "jsonObject", "Lorg/json/JSONObject;", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000000o {
            public /* synthetic */ O000000o(byte b) {
                this();
            }

            private O000000o() {
            }

            public static O0000O0o O000000o(JSONObject jSONObject) {
                ixe.O00000o(jSONObject, "jsonObject");
                Integer valueOf = Integer.valueOf(jSONObject.optInt("option_type"));
                O00000Oo.O000000o o000000o = O00000Oo.f442O000000o;
                JSONArray optJSONArray = jSONObject.optJSONArray("options");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                ArrayList<O00000Oo> O000000o2 = O00000Oo.O000000o.O000000o(optJSONArray);
                int optInt = jSONObject.optInt("express");
                String optString = jSONObject.optString("diversion_url");
                ixe.O00000Oo(optString, "jsonObject.optString(\"diversion_url\")");
                String optString2 = jSONObject.optString("diversion_text");
                ixe.O00000Oo(optString2, "jsonObject.optString(\"diversion_text\")");
                String optString3 = jSONObject.optString("diversion_icon");
                String optString4 = jSONObject.optString("desc");
                ixe.O00000Oo(optString4, "jsonObject.optString(\"desc\")");
                return new O0000O0o(valueOf, O000000o2, optInt, optString, optString2, optString3, optString4);
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u0000 &2\u00020\u0001:\u0002&'BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J_\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\nHÖ\u0001R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006("}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendCondition;", "", "optiontype", "", "options", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendCondition$ConditionOption;", "Lkotlin/collections/ArrayList;", "express", "diversionUrl", "", "diversionText", "diversionIcon", "desc", "(ILjava/util/ArrayList;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getDiversionIcon", "getDiversionText", "getDiversionUrl", "getExpress", "()I", "getOptions", "()Ljava/util/ArrayList;", "getOptiontype", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "ConditionOption", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f434O000000o = new O000000o((byte) 0);
        public final int O00000Oo;
        public final int O00000o;
        public final ArrayList<O00000Oo> O00000o0;
        public final String O00000oO;
        public final String O00000oo;
        public final String O0000O0o;
        public final String O0000OOo;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O00000o)) {
                return false;
            }
            O00000o o00000o = (O00000o) obj;
            return this.O00000Oo == o00000o.O00000Oo && ixe.O000000o(this.O00000o0, o00000o.O00000o0) && this.O00000o == o00000o.O00000o && ixe.O000000o(this.O00000oO, o00000o.O00000oO) && ixe.O000000o(this.O00000oo, o00000o.O00000oo) && ixe.O000000o(this.O0000O0o, o00000o.O0000O0o) && ixe.O000000o(this.O0000OOo, o00000o.O0000OOo);
        }

        public final int hashCode() {
            return (((((((((((Integer.valueOf(this.O00000Oo).hashCode() * 31) + this.O00000o0.hashCode()) * 31) + Integer.valueOf(this.O00000o).hashCode()) * 31) + this.O00000oO.hashCode()) * 31) + this.O00000oo.hashCode()) * 31) + this.O0000O0o.hashCode()) * 31) + this.O0000OOo.hashCode();
        }

        public final String toString() {
            return "RecommendCondition(optiontype=" + this.O00000Oo + ", options=" + this.O00000o0 + ", express=" + this.O00000o + ", diversionUrl=" + this.O00000oO + ", diversionText=" + this.O00000oo + ", diversionIcon=" + this.O0000O0o + ", desc=" + this.O0000OOo + ')';
        }

        public O00000o(int i, ArrayList<O00000Oo> arrayList, int i2, String str, String str2, String str3, String str4) {
            ixe.O00000o(arrayList, "options");
            ixe.O00000o(str, "diversionUrl");
            ixe.O00000o(str2, "diversionText");
            ixe.O00000o(str3, "diversionIcon");
            ixe.O00000o(str4, "desc");
            this.O00000Oo = i;
            this.O00000o0 = arrayList;
            this.O00000o = i2;
            this.O00000oO = str;
            this.O00000oo = str2;
            this.O0000O0o = str3;
            this.O0000OOo = str4;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendCondition$Companion;", "", "()V", "parse", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendCondition;", "jsonObject", "Lorg/json/JSONObject;", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000000o {
            public /* synthetic */ O000000o(byte b) {
                this();
            }

            private O000000o() {
            }

            public static O00000o O000000o(JSONObject jSONObject) {
                ixe.O00000o(jSONObject, "jsonObject");
                JSONArray optJSONArray = jSONObject.optJSONArray("options");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                int optInt = jSONObject.optInt("option_type");
                O00000Oo.O000000o o000000o = O00000Oo.f435O000000o;
                ArrayList<O00000Oo> O000000o2 = O00000Oo.O000000o.O000000o(optJSONArray);
                int optInt2 = jSONObject.optInt("express");
                String optString = jSONObject.optString("diversion_url");
                ixe.O00000Oo(optString, "jsonObject.optString(\"diversion_url\")");
                String optString2 = jSONObject.optString("diversion_text");
                ixe.O00000Oo(optString2, "jsonObject.optString(\"diversion_text\")");
                String optString3 = jSONObject.optString("diversion_icon");
                ixe.O00000Oo(optString3, "jsonObject.optString(\"diversion_icon\")");
                String optString4 = jSONObject.optString("desc");
                ixe.O00000Oo(optString4, "jsonObject.optString(\"desc\")");
                return new O00000o(optInt, O000000o2, optInt2, optString, optString2, optString3, optString4);
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 ?2\u00020\u0001:\u0001?BÑ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010+\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001d\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\rHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0019\u00105\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rHÆ\u0003J\u0019\u00106\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rHÆ\u0003J\u001d\u00107\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\rHÆ\u0003Jö\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\t\u0010>\u001a\u00020\u0007HÖ\u0001R%\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R%\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b#\u0010!R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b$\u0010!R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b%\u0010!R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b&\u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b)\u0010!¨\u0006@"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendCondition$ConditionOption;", "", "id", "", "styleId", "displayType", "desc", "", "conditionSource", "conditionType", "deviceTypeEnabled", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$DeviceType;", "Lkotlin/collections/ArrayList;", "deviceTypeDisabled", "blackList", "valueJson", "conSubProps", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$TriggerConSubProp;", "subPropExpress", "valueType", "priority", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBlackList", "()Ljava/util/ArrayList;", "getConSubProps", "getConditionSource", "()Ljava/lang/String;", "getConditionType", "getDesc", "getDeviceTypeDisabled", "getDeviceTypeEnabled", "getDisplayType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getPriority", "getStyleId", "getSubPropExpress", "getValueJson", "()Ljava/lang/Object;", "getValueType", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendCondition$ConditionOption;", "equals", "", "other", "hashCode", "toString", "Companion", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O000000o f435O000000o = new O000000o((byte) 0);
            public final Integer O00000Oo;
            public final Integer O00000o;
            public final Integer O00000o0;
            public final String O00000oO;
            public final String O00000oo;
            public final ArrayList<O00000Oo> O0000O0o;
            public final ArrayList<O00000Oo> O0000OOo;
            public final Object O0000Oo;
            public final ArrayList<String> O0000Oo0;
            public final ArrayList<O0000OOo> O0000OoO;
            public final Integer O0000Ooo;
            public final Integer O0000o0;
            public final Integer O0000o00;
            private final String O0000o0O;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof O00000Oo)) {
                    return false;
                }
                O00000Oo o00000Oo = (O00000Oo) obj;
                return ixe.O000000o(this.O00000Oo, o00000Oo.O00000Oo) && ixe.O000000o(this.O00000o0, o00000Oo.O00000o0) && ixe.O000000o(this.O00000o, o00000Oo.O00000o) && ixe.O000000o(this.O0000o0O, o00000Oo.O0000o0O) && ixe.O000000o(this.O00000oO, o00000Oo.O00000oO) && ixe.O000000o(this.O00000oo, o00000Oo.O00000oo) && ixe.O000000o(this.O0000O0o, o00000Oo.O0000O0o) && ixe.O000000o(this.O0000OOo, o00000Oo.O0000OOo) && ixe.O000000o(this.O0000Oo0, o00000Oo.O0000Oo0) && ixe.O000000o(this.O0000Oo, o00000Oo.O0000Oo) && ixe.O000000o(this.O0000OoO, o00000Oo.O0000OoO) && ixe.O000000o(this.O0000Ooo, o00000Oo.O0000Ooo) && ixe.O000000o(this.O0000o00, o00000Oo.O0000o00) && ixe.O000000o(this.O0000o0, o00000Oo.O0000o0);
            }

            public final int hashCode() {
                Integer num = this.O00000Oo;
                int i = 0;
                int hashCode = (num == null ? 0 : num.hashCode()) * 31;
                Integer num2 = this.O00000o0;
                int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
                Integer num3 = this.O00000o;
                int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
                String str = this.O0000o0O;
                int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.O00000oO;
                int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.O00000oo;
                int hashCode6 = (((((hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.O0000O0o.hashCode()) * 31) + this.O0000OOo.hashCode()) * 31;
                ArrayList<String> arrayList = this.O0000Oo0;
                int hashCode7 = (hashCode6 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
                Object obj = this.O0000Oo;
                int hashCode8 = (hashCode7 + (obj == null ? 0 : obj.hashCode())) * 31;
                ArrayList<O0000OOo> arrayList2 = this.O0000OoO;
                int hashCode9 = (hashCode8 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
                Integer num4 = this.O0000Ooo;
                int hashCode10 = (hashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
                Integer num5 = this.O0000o00;
                int hashCode11 = (hashCode10 + (num5 == null ? 0 : num5.hashCode())) * 31;
                Integer num6 = this.O0000o0;
                if (num6 != null) {
                    i = num6.hashCode();
                }
                return hashCode11 + i;
            }

            public final String toString() {
                return "ConditionOption(id=" + this.O00000Oo + ", styleId=" + this.O00000o0 + ", displayType=" + this.O00000o + ", desc=" + ((Object) this.O0000o0O) + ", conditionSource=" + ((Object) this.O00000oO) + ", conditionType=" + ((Object) this.O00000oo) + ", deviceTypeEnabled=" + this.O0000O0o + ", deviceTypeDisabled=" + this.O0000OOo + ", blackList=" + this.O0000Oo0 + ", valueJson=" + this.O0000Oo + ", conSubProps=" + this.O0000OoO + ", subPropExpress=" + this.O0000Ooo + ", valueType=" + this.O0000o00 + ", priority=" + this.O0000o0 + ')';
            }

            public O00000Oo(Integer num, Integer num2, Integer num3, String str, String str2, String str3, ArrayList<O00000Oo> arrayList, ArrayList<O00000Oo> arrayList2, ArrayList<String> arrayList3, Object obj, ArrayList<O0000OOo> arrayList4, Integer num4, Integer num5, Integer num6) {
                ixe.O00000o(arrayList, "deviceTypeEnabled");
                ixe.O00000o(arrayList2, "deviceTypeDisabled");
                this.O00000Oo = num;
                this.O00000o0 = num2;
                this.O00000o = num3;
                this.O0000o0O = str;
                this.O00000oO = str2;
                this.O00000oo = str3;
                this.O0000O0o = arrayList;
                this.O0000OOo = arrayList2;
                this.O0000Oo0 = arrayList3;
                this.O0000Oo = obj;
                this.O0000OoO = arrayList4;
                this.O0000Ooo = num4;
                this.O0000o00 = num5;
                this.O0000o0 = num6;
            }

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendCondition$ConditionOption$Companion;", "", "()V", "parseItem", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendCondition$ConditionOption;", "jsonObject", "Lorg/json/JSONObject;", "parseList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "Lorg/json/JSONArray;", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class O000000o {
                public /* synthetic */ O000000o(byte b) {
                    this();
                }

                private O000000o() {
                }

                public static ArrayList<O00000Oo> O000000o(JSONArray jSONArray) {
                    int i;
                    JSONObject jSONObject;
                    ArrayList<O00000Oo> arrayList = new ArrayList<>();
                    int i2 = 0;
                    if (jSONArray == null) {
                        i = 0;
                    } else {
                        i = jSONArray.length();
                    }
                    if (i > 0) {
                        while (true) {
                            int i3 = i2 + 1;
                            if (jSONArray == null) {
                                jSONObject = null;
                            } else {
                                jSONObject = jSONArray.optJSONObject(i2);
                            }
                            arrayList.add(O000000o(jSONObject));
                            if (i3 >= i) {
                                break;
                            }
                            i2 = i3;
                        }
                    }
                    return arrayList;
                }

                /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
                /* JADX WARNING: Removed duplicated region for block: B:26:0x0050  */
                /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
                /* JADX WARNING: Removed duplicated region for block: B:29:0x005f  */
                /* JADX WARNING: Removed duplicated region for block: B:31:0x006c  */
                /* JADX WARNING: Removed duplicated region for block: B:32:0x006e  */
                /* JADX WARNING: Removed duplicated region for block: B:34:0x007b  */
                /* JADX WARNING: Removed duplicated region for block: B:35:0x007d  */
                /* JADX WARNING: Removed duplicated region for block: B:37:0x0086  */
                /* JADX WARNING: Removed duplicated region for block: B:38:0x0088  */
                /* JADX WARNING: Removed duplicated region for block: B:40:0x0091  */
                /* JADX WARNING: Removed duplicated region for block: B:41:0x0093  */
                /* JADX WARNING: Removed duplicated region for block: B:44:0x009e  */
                /* JADX WARNING: Removed duplicated region for block: B:45:0x00a0  */
                /* JADX WARNING: Removed duplicated region for block: B:48:0x00ae  */
                /* JADX WARNING: Removed duplicated region for block: B:49:0x00b0  */
                /* JADX WARNING: Removed duplicated region for block: B:52:0x00be  */
                /* JADX WARNING: Removed duplicated region for block: B:53:0x00c0  */
                /* JADX WARNING: Removed duplicated region for block: B:56:0x00d0  */
                /* JADX WARNING: Removed duplicated region for block: B:57:0x00d3  */
                /* JADX WARNING: Removed duplicated region for block: B:59:0x00e2  */
                private static O00000Oo O000000o(JSONObject jSONObject) {
                    ArrayList<O0000OOo> arrayList;
                    Integer num;
                    Integer num2;
                    String str;
                    String str2;
                    String str3;
                    Integer num3;
                    JSONObject jSONObject2 = jSONObject;
                    Integer num4 = null;
                    Object opt = jSONObject2 == null ? null : jSONObject2.opt("value_json");
                    ArrayList<O0000OOo> arrayList2 = new ArrayList<>();
                    int i = 0;
                    if (opt != null && (opt instanceof JSONObject)) {
                        try {
                            JSONObject optJSONObject = ((JSONObject) opt).optJSONObject("sub_props");
                            if (optJSONObject != null) {
                                i = optJSONObject.optInt("express");
                            }
                            JSONObject optJSONObject2 = ((JSONObject) opt).optJSONObject("sub_props");
                            JSONArray optJSONArray = optJSONObject2 == null ? null : optJSONObject2.optJSONArray("attr");
                            O0000OOo.O000000o o000000o = O0000OOo.f443O000000o;
                            arrayList = O0000OOo.O000000o.O000000o(optJSONArray);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Integer valueOf = jSONObject2 != null ? null : Integer.valueOf(jSONObject2.optInt("id"));
                        if (jSONObject2 != null) {
                            num = null;
                        } else {
                            num = Integer.valueOf(jSONObject2.optInt("style_id"));
                        }
                        if (jSONObject2 != null) {
                            num2 = null;
                        } else {
                            num2 = Integer.valueOf(jSONObject2.optInt("display_type"));
                        }
                        if (jSONObject2 != null) {
                            str = null;
                        } else {
                            str = jSONObject2.optString("desc");
                        }
                        if (jSONObject2 != null) {
                            str2 = null;
                        } else {
                            str2 = jSONObject2.optString("condition_source");
                        }
                        if (jSONObject2 != null) {
                            str3 = null;
                        } else {
                            str3 = jSONObject2.optString("condition_type");
                        }
                        O00000Oo.O000000o o000000o2 = O00000Oo.f433O000000o;
                        ArrayList<O00000Oo> O000000o2 = O00000Oo.O000000o.O000000o(jSONObject2 != null ? null : jSONObject2.optJSONArray("device_type_enabled"));
                        O00000Oo.O000000o o000000o3 = O00000Oo.f433O000000o;
                        ArrayList<O00000Oo> O000000o3 = O00000Oo.O000000o.O000000o(jSONObject2 != null ? null : jSONObject2.optJSONArray("device_type_disabled"));
                        O000000o o000000o4 = hof.f432O000000o;
                        ArrayList<String> O000000o4 = O000000o.O000000o(jSONObject2 != null ? null : jSONObject2.optJSONArray("blacklist_model"));
                        Integer valueOf2 = Integer.valueOf(i);
                        if (jSONObject2 != null) {
                            num3 = null;
                        } else {
                            num3 = Integer.valueOf(jSONObject2.optInt("value_type"));
                        }
                        if (jSONObject2 != null) {
                            num4 = Integer.valueOf(jSONObject2.optInt("priority"));
                        }
                        return new O00000Oo(valueOf, num, num2, str, str2, str3, O000000o2, O000000o3, O000000o4, opt, arrayList, valueOf2, num3, num4);
                    }
                    arrayList = arrayList2;
                    if (jSONObject2 != null) {
                    }
                    if (jSONObject2 != null) {
                    }
                    if (jSONObject2 != null) {
                    }
                    if (jSONObject2 != null) {
                    }
                    if (jSONObject2 != null) {
                    }
                    if (jSONObject2 != null) {
                    }
                    O00000Oo.O000000o o000000o22 = O00000Oo.f433O000000o;
                    ArrayList<O00000Oo> O000000o22 = O00000Oo.O000000o.O000000o(jSONObject2 != null ? null : jSONObject2.optJSONArray("device_type_enabled"));
                    O00000Oo.O000000o o000000o32 = O00000Oo.f433O000000o;
                    ArrayList<O00000Oo> O000000o32 = O00000Oo.O000000o.O000000o(jSONObject2 != null ? null : jSONObject2.optJSONArray("device_type_disabled"));
                    O000000o o000000o42 = hof.f432O000000o;
                    ArrayList<String> O000000o42 = O000000o.O000000o(jSONObject2 != null ? null : jSONObject2.optJSONArray("blacklist_model"));
                    Integer valueOf22 = Integer.valueOf(i);
                    if (jSONObject2 != null) {
                    }
                    if (jSONObject2 != null) {
                    }
                    return new O00000Oo(valueOf, num, num2, str, str2, str3, O000000o22, O000000o32, O000000o42, opt, arrayList, valueOf22, num3, num4);
                }
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 %2\u00020\u0001:\u0005\"#$%&BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003JX\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction;", "", "optiontype", "", "diversionUrl", "", "diversionText", "diversionIcon", "groupList", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$GroupActionOption;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getDiversionIcon", "()Ljava/lang/String;", "getDiversionText", "getDiversionUrl", "getGroupList", "()Ljava/util/ArrayList;", "getOptiontype", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction;", "equals", "", "other", "hashCode", "toString", "Action", "ActionOption", "ActionSubProp", "Companion", "GroupActionOption", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O00000o f436O000000o = new O00000o((byte) 0);
        public final String O00000Oo;
        public final String O00000o;
        public final String O00000o0;
        public final ArrayList<O0000O0o> O00000oO;
        private final Integer O00000oo;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O00000o0)) {
                return false;
            }
            O00000o0 o00000o0 = (O00000o0) obj;
            return ixe.O000000o(this.O00000oo, o00000o0.O00000oo) && ixe.O000000o(this.O00000Oo, o00000o0.O00000Oo) && ixe.O000000o(this.O00000o0, o00000o0.O00000o0) && ixe.O000000o(this.O00000o, o00000o0.O00000o) && ixe.O000000o(this.O00000oO, o00000o0.O00000oO);
        }

        public final int hashCode() {
            Integer num = this.O00000oo;
            int i = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.O00000Oo;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.O00000o0;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.O00000o;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return ((hashCode3 + i) * 31) + this.O00000oO.hashCode();
        }

        public final String toString() {
            return "RecommendAction(optiontype=" + this.O00000oo + ", diversionUrl=" + ((Object) this.O00000Oo) + ", diversionText=" + ((Object) this.O00000o0) + ", diversionIcon=" + ((Object) this.O00000o) + ", groupList=" + this.O00000oO + ')';
        }

        public O00000o0(Integer num, String str, String str2, String str3, ArrayList<O0000O0o> arrayList) {
            ixe.O00000o(arrayList, "groupList");
            this.O00000oo = num;
            this.O00000Oo = str;
            this.O00000o0 = str2;
            this.O00000o = str3;
            this.O00000oO = arrayList;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$Companion;", "", "()V", "parse", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction;", "jsonObject", "Lorg/json/JSONObject;", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O00000o {
            public /* synthetic */ O00000o(byte b) {
                this();
            }

            private O00000o() {
            }

            public static O00000o0 O000000o(JSONObject jSONObject) {
                String str;
                String str2;
                String str3 = null;
                JSONArray optJSONArray = jSONObject == null ? null : jSONObject.optJSONArray("group_list");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                Integer valueOf = jSONObject == null ? null : Integer.valueOf(jSONObject.optInt("option_type"));
                if (jSONObject == null) {
                    str = null;
                } else {
                    str = jSONObject.optString("diversion_url");
                }
                if (jSONObject == null) {
                    str2 = null;
                } else {
                    str2 = jSONObject.optString("diversion_text");
                }
                if (jSONObject != null) {
                    str3 = jSONObject.optString("diversion_icon");
                }
                O0000O0o.O000000o o000000o = O0000O0o.f440O000000o;
                return new O00000o0(valueOf, str, str2, str3, O0000O0o.O000000o.O000000o(optJSONArray));
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0003JP\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011¨\u0006 "}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$GroupActionOption;", "", "id", "", "styleId", "desc", "", "ActionList", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$ActionOption;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;)V", "getActionList", "()Ljava/util/ArrayList;", "getDesc", "()Ljava/lang/String;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStyleId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;)Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$GroupActionOption;", "equals", "", "other", "hashCode", "toString", "Companion", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O0000O0o {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O000000o f440O000000o = new O000000o((byte) 0);
            public final Integer O00000Oo;
            public final String O00000o;
            public final Integer O00000o0;
            public final ArrayList<O00000Oo> O00000oO;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof O0000O0o)) {
                    return false;
                }
                O0000O0o o0000O0o = (O0000O0o) obj;
                return ixe.O000000o(this.O00000Oo, o0000O0o.O00000Oo) && ixe.O000000o(this.O00000o0, o0000O0o.O00000o0) && ixe.O000000o(this.O00000o, o0000O0o.O00000o) && ixe.O000000o(this.O00000oO, o0000O0o.O00000oO);
            }

            public final int hashCode() {
                Integer num = this.O00000Oo;
                int i = 0;
                int hashCode = (num == null ? 0 : num.hashCode()) * 31;
                Integer num2 = this.O00000o0;
                int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
                String str = this.O00000o;
                int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
                ArrayList<O00000Oo> arrayList = this.O00000oO;
                if (arrayList != null) {
                    i = arrayList.hashCode();
                }
                return hashCode3 + i;
            }

            public final String toString() {
                return "GroupActionOption(id=" + this.O00000Oo + ", styleId=" + this.O00000o0 + ", desc=" + ((Object) this.O00000o) + ", ActionList=" + this.O00000oO + ')';
            }

            public O0000O0o(Integer num, Integer num2, String str, ArrayList<O00000Oo> arrayList) {
                this.O00000Oo = num;
                this.O00000o0 = num2;
                this.O00000o = str;
                this.O00000oO = arrayList;
            }

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$GroupActionOption$Companion;", "", "()V", "parseItem", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$GroupActionOption;", "jsonObject", "Lorg/json/JSONObject;", "parseList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "Lorg/json/JSONArray;", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class O000000o {
                public /* synthetic */ O000000o(byte b) {
                    this();
                }

                private O000000o() {
                }

                public static ArrayList<O0000O0o> O000000o(JSONArray jSONArray) {
                    int i;
                    JSONObject jSONObject;
                    Integer num;
                    String str;
                    ArrayList<O0000O0o> arrayList = new ArrayList<>();
                    int i2 = 0;
                    if (jSONArray == null) {
                        i = 0;
                    } else {
                        i = jSONArray.length();
                    }
                    if (i > 0) {
                        while (true) {
                            int i3 = i2 + 1;
                            Integer num2 = null;
                            if (jSONArray == null) {
                                jSONObject = null;
                            } else {
                                jSONObject = jSONArray.optJSONObject(i2);
                            }
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            JSONArray optJSONArray = jSONObject == null ? null : jSONObject.optJSONArray("action_list");
                            if (optJSONArray == null) {
                                optJSONArray = new JSONArray();
                            }
                            Integer valueOf = jSONObject == null ? null : Integer.valueOf(jSONObject.optInt("id"));
                            if (jSONObject == null) {
                                num = null;
                            } else {
                                num = Integer.valueOf(jSONObject.optInt("style_id"));
                            }
                            if (jSONObject == null) {
                                str = null;
                            } else {
                                str = jSONObject.optString("desc");
                            }
                            O00000Oo.O000000o o000000o = O00000Oo.f438O000000o;
                            if (jSONObject != null) {
                                num2 = Integer.valueOf(jSONObject.optInt("style_id"));
                            }
                            arrayList.add(new O0000O0o(valueOf, num, str, O00000Oo.O000000o.O000000o(optJSONArray, num2)));
                            if (i3 >= i) {
                                break;
                            }
                            i2 = i3;
                        }
                    }
                    return arrayList;
                }
            }
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 32\u00020\u0001:\u00013B¯\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\n\u0012\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\n\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\bj\b\u0012\u0004\u0012\u00020\u0011`\n\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0019\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u0019\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u001d\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\nHÆ\u0003J\u001d\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\nHÆ\u0003J\u0019\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00110\bj\b\u0012\u0004\u0012\u00020\u0011`\nHÆ\u0003JÌ\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\n2\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\n2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\bj\b\u0012\u0004\u0012\u00020\u0011`\n2\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\bj\b\u0012\u0004\u0012\u00020\u0011`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R%\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR%\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017¨\u00064"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$ActionOption;", "", "id", "", "displayType", "styleId", "actionType", "deviceTypeEnabled", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$DeviceType;", "Lkotlin/collections/ArrayList;", "deviceTypeDisabled", "blackList", "", "subProperties", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$ActionSubProp;", "actions", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$Action;", "priority", "(IILjava/lang/Integer;ILjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;I)V", "getActionType", "()I", "getActions", "()Ljava/util/ArrayList;", "getBlackList", "getDeviceTypeDisabled", "getDeviceTypeEnabled", "getDisplayType", "getId", "getPriority", "getStyleId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSubProperties", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILjava/lang/Integer;ILjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;I)Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$ActionOption;", "equals", "", "other", "hashCode", "toString", "Companion", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O000000o f438O000000o = new O000000o((byte) 0);
            public final int O00000Oo;
            public final Integer O00000o;
            public final int O00000o0;
            public final int O00000oO;
            public final ArrayList<O00000Oo> O00000oo;
            public final ArrayList<O00000Oo> O0000O0o;
            public final ArrayList<String> O0000OOo;
            public final ArrayList<O000000o> O0000Oo;
            public final ArrayList<C0001O00000o0> O0000Oo0;
            public final int O0000OoO;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof O00000Oo)) {
                    return false;
                }
                O00000Oo o00000Oo = (O00000Oo) obj;
                return this.O00000Oo == o00000Oo.O00000Oo && this.O00000o0 == o00000Oo.O00000o0 && ixe.O000000o(this.O00000o, o00000Oo.O00000o) && this.O00000oO == o00000Oo.O00000oO && ixe.O000000o(this.O00000oo, o00000Oo.O00000oo) && ixe.O000000o(this.O0000O0o, o00000Oo.O0000O0o) && ixe.O000000o(this.O0000OOo, o00000Oo.O0000OOo) && ixe.O000000o(this.O0000Oo0, o00000Oo.O0000Oo0) && ixe.O000000o(this.O0000Oo, o00000Oo.O0000Oo) && this.O0000OoO == o00000Oo.O0000OoO;
            }

            public final int hashCode() {
                int hashCode = ((Integer.valueOf(this.O00000Oo).hashCode() * 31) + Integer.valueOf(this.O00000o0).hashCode()) * 31;
                Integer num = this.O00000o;
                int i = 0;
                int hashCode2 = (((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.valueOf(this.O00000oO).hashCode()) * 31) + this.O00000oo.hashCode()) * 31) + this.O0000O0o.hashCode()) * 31;
                ArrayList<String> arrayList = this.O0000OOo;
                int hashCode3 = (hashCode2 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
                ArrayList<C0001O00000o0> arrayList2 = this.O0000Oo0;
                if (arrayList2 != null) {
                    i = arrayList2.hashCode();
                }
                return ((((hashCode3 + i) * 31) + this.O0000Oo.hashCode()) * 31) + Integer.valueOf(this.O0000OoO).hashCode();
            }

            public final String toString() {
                return "ActionOption(id=" + this.O00000Oo + ", displayType=" + this.O00000o0 + ", styleId=" + this.O00000o + ", actionType=" + this.O00000oO + ", deviceTypeEnabled=" + this.O00000oo + ", deviceTypeDisabled=" + this.O0000O0o + ", blackList=" + this.O0000OOo + ", subProperties=" + this.O0000Oo0 + ", actions=" + this.O0000Oo + ", priority=" + this.O0000OoO + ')';
            }

            public O00000Oo(int i, int i2, Integer num, int i3, ArrayList<O00000Oo> arrayList, ArrayList<O00000Oo> arrayList2, ArrayList<String> arrayList3, ArrayList<C0001O00000o0> arrayList4, ArrayList<O000000o> arrayList5, int i4) {
                ixe.O00000o(arrayList, "deviceTypeEnabled");
                ixe.O00000o(arrayList2, "deviceTypeDisabled");
                ixe.O00000o(arrayList5, "actions");
                this.O00000Oo = i;
                this.O00000o0 = i2;
                this.O00000o = num;
                this.O00000oO = i3;
                this.O00000oo = arrayList;
                this.O0000O0o = arrayList2;
                this.O0000OOo = arrayList3;
                this.O0000Oo0 = arrayList4;
                this.O0000Oo = arrayList5;
                this.O0000OoO = i4;
            }

            @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\tJ/\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000bj\b\u0012\u0004\u0012\u00020\u0004`\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$ActionOption$Companion;", "", "()V", "parseItem", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$ActionOption;", "jsonObject", "Lorg/json/JSONObject;", "styleId", "", "(Lorg/json/JSONObject;Ljava/lang/Integer;)Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$ActionOption;", "parseList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;Ljava/lang/Integer;)Ljava/util/ArrayList;", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class O000000o {
                public /* synthetic */ O000000o(byte b) {
                    this();
                }

                private O000000o() {
                }

                public static ArrayList<O00000Oo> O000000o(JSONArray jSONArray, Integer num) {
                    JSONArray jSONArray2 = jSONArray;
                    ixe.O00000o(jSONArray2, "jsonArray");
                    ArrayList<O00000Oo> arrayList = new ArrayList<>();
                    int length = jSONArray.length();
                    if (length > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                            ixe.O00000Oo(optJSONObject, "jsonArray.optJSONObject(i)");
                            int optInt = optJSONObject.optInt("id");
                            int optInt2 = optJSONObject.optInt("display_type");
                            int optInt3 = optJSONObject.optInt("action_type");
                            O00000Oo.O000000o o000000o = O00000Oo.f433O000000o;
                            JSONArray jSONArray3 = null;
                            ArrayList<O00000Oo> O000000o2 = O00000Oo.O000000o.O000000o(optJSONObject == null ? null : optJSONObject.optJSONArray("device_type_enabled"));
                            O00000Oo.O000000o o000000o2 = O00000Oo.f433O000000o;
                            ArrayList<O00000Oo> O000000o3 = O00000Oo.O000000o.O000000o(optJSONObject == null ? null : optJSONObject.optJSONArray("device_type_disabled"));
                            O000000o o000000o3 = hof.f432O000000o;
                            ArrayList<String> O000000o4 = O000000o.O000000o(optJSONObject == null ? null : optJSONObject.optJSONArray("blacklist_model"));
                            C0001O00000o0.O000000o o000000o4 = C0001O00000o0.f439O000000o;
                            ArrayList<C0001O00000o0> O000000o5 = C0001O00000o0.O000000o.O000000o(optJSONObject == null ? null : optJSONObject.optJSONArray("set_properties"));
                            O000000o.C0000O000000o o000000o5 = O000000o.f437O000000o;
                            if (optJSONObject != null) {
                                jSONArray3 = optJSONObject.optJSONArray("actions");
                            }
                            arrayList.add(new O00000Oo(optInt, optInt2, num, optInt3, O000000o2, O000000o3, O000000o4, O000000o5, O000000o.C0000O000000o.O000000o(jSONArray3), optJSONObject.optInt("priority")));
                            if (i2 >= length) {
                                break;
                            }
                            i = i2;
                        }
                    }
                    return arrayList;
                }
            }
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$ActionSubProp;", "", "property", "", "value", "valueType", "", "description", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getProperty", "getValue", "()Ljava/lang/Object;", "getValueType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;)Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$ActionSubProp;", "equals", "", "other", "hashCode", "toString", "Companion", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* renamed from: _m_j.hof$O00000o0$O00000o0  reason: collision with other inner class name */
        public static final class C0001O00000o0 {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O000000o f439O000000o = new O000000o((byte) 0);
            public final String O00000Oo;
            public final Integer O00000o;
            public final Object O00000o0;
            public final String O00000oO;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0001O00000o0)) {
                    return false;
                }
                C0001O00000o0 o00000o0 = (C0001O00000o0) obj;
                return ixe.O000000o(this.O00000Oo, o00000o0.O00000Oo) && ixe.O000000o(this.O00000o0, o00000o0.O00000o0) && ixe.O000000o(this.O00000o, o00000o0.O00000o) && ixe.O000000o(this.O00000oO, o00000o0.O00000oO);
            }

            public final int hashCode() {
                String str = this.O00000Oo;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                Object obj = this.O00000o0;
                int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
                Integer num = this.O00000o;
                int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
                String str2 = this.O00000oO;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode3 + i;
            }

            public final String toString() {
                return "ActionSubProp(property=" + ((Object) this.O00000Oo) + ", value=" + this.O00000o0 + ", valueType=" + this.O00000o + ", description=" + ((Object) this.O00000oO) + ')';
            }

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$ActionSubProp$Companion;", "", "()V", "parseItem", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$ActionSubProp;", "jsonObject", "Lorg/json/JSONObject;", "parseList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "Lorg/json/JSONArray;", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* renamed from: _m_j.hof$O00000o0$O00000o0$O000000o */
            public static final class O000000o {
                public /* synthetic */ O000000o(byte b) {
                    this();
                }

                private O000000o() {
                }

                public static ArrayList<C0001O00000o0> O000000o(JSONArray jSONArray) {
                    int i;
                    JSONObject jSONObject;
                    ArrayList<C0001O00000o0> arrayList = new ArrayList<>();
                    int i2 = 0;
                    if (jSONArray == null) {
                        i = 0;
                    } else {
                        i = jSONArray.length();
                    }
                    if (i > 0) {
                        while (true) {
                            int i3 = i2 + 1;
                            String str = null;
                            if (jSONArray == null) {
                                jSONObject = null;
                            } else {
                                jSONObject = jSONArray.optJSONObject(i2);
                            }
                            String optString = jSONObject == null ? null : jSONObject.optString("property");
                            Object opt = jSONObject == null ? null : jSONObject.opt("value_json");
                            Integer valueOf = jSONObject == null ? null : Integer.valueOf(jSONObject.optInt("value_type"));
                            if (jSONObject != null) {
                                str = jSONObject.optString("description");
                            }
                            arrayList.add(new C0001O00000o0(optString, opt, valueOf, str));
                            if (i3 >= i) {
                                break;
                            }
                            i2 = i3;
                        }
                    }
                    return arrayList;
                }
            }

            public C0001O00000o0(String str, Object obj, Integer num, String str2) {
                this.O00000Oo = str;
                this.O00000o0 = obj;
                this.O00000o = num;
                this.O00000oO = str2;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000  2\u00020\u0001:\u0001 B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u000fJN\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$Action;", "", "action", "", "subActionSubProps", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$ActionSubProp;", "Lkotlin/collections/ArrayList;", "value", "format", "", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/lang/Integer;)V", "getAction", "()Ljava/lang/String;", "getFormat", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSubActionSubProps", "()Ljava/util/ArrayList;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/lang/Integer;)Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$Action;", "equals", "", "other", "hashCode", "toString", "Companion", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final C0000O000000o f437O000000o = new C0000O000000o((byte) 0);
            public final String O00000Oo;
            private final Object O00000o;
            public final ArrayList<C0001O00000o0> O00000o0;
            private final Integer O00000oO;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof O000000o)) {
                    return false;
                }
                O000000o o000000o = (O000000o) obj;
                return ixe.O000000o(this.O00000Oo, o000000o.O00000Oo) && ixe.O000000o(this.O00000o0, o000000o.O00000o0) && ixe.O000000o(this.O00000o, o000000o.O00000o) && ixe.O000000o(this.O00000oO, o000000o.O00000oO);
            }

            public final int hashCode() {
                int hashCode = this.O00000Oo.hashCode() * 31;
                ArrayList<C0001O00000o0> arrayList = this.O00000o0;
                int i = 0;
                int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
                Object obj = this.O00000o;
                int hashCode3 = (hashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
                Integer num = this.O00000oO;
                if (num != null) {
                    i = num.hashCode();
                }
                return hashCode3 + i;
            }

            public final String toString() {
                return "Action(action=" + this.O00000Oo + ", subActionSubProps=" + this.O00000o0 + ", value=" + this.O00000o + ", format=" + this.O00000oO + ')';
            }

            public O000000o(String str, ArrayList<C0001O00000o0> arrayList, Object obj, Integer num) {
                ixe.O00000o(str, "action");
                this.O00000Oo = str;
                this.O00000o0 = arrayList;
                this.O00000o = obj;
                this.O00000oO = num;
            }

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$Action$Companion;", "", "()V", "parseItem", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$RecommendAction$Action;", "jsonObject", "Lorg/json/JSONObject;", "parseList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "Lorg/json/JSONArray;", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* renamed from: _m_j.hof$O00000o0$O000000o$O000000o  reason: collision with other inner class name */
            public static final class C0000O000000o {
                public /* synthetic */ C0000O000000o(byte b) {
                    this();
                }

                private C0000O000000o() {
                }

                public static ArrayList<O000000o> O000000o(JSONArray jSONArray) {
                    ArrayList<O000000o> arrayList = new ArrayList<>();
                    if (jSONArray != null) {
                        int i = 0;
                        int length = jSONArray.length();
                        if (length > 0) {
                            while (true) {
                                int i2 = i + 1;
                                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                                ixe.O00000Oo(optJSONObject, "jsonArray.optJSONObject(i)");
                                String optString = optJSONObject.optString("action");
                                ixe.O00000Oo(optString, "jsonObject.optString(\"action\")");
                                C0001O00000o0.O000000o o000000o = C0001O00000o0.f439O000000o;
                                arrayList.add(new O000000o(optString, C0001O00000o0.O000000o.O000000o(optJSONObject.optJSONArray("in")), optJSONObject.opt("value"), Integer.valueOf(optJSONObject.optInt("value_type"))));
                                if (i2 >= length) {
                                    break;
                                }
                                i = i2;
                            }
                        }
                    }
                    return arrayList;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$TriggerConSubProp;", "", "key", "", "valueJson", "itemName", "valueType", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Integer;)V", "getItemName", "()Ljava/lang/String;", "getKey", "getValueJson", "()Ljava/lang/Object;", "getValueType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Integer;)Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$TriggerConSubProp;", "equals", "", "other", "hashCode", "toString", "Companion", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f443O000000o = new O000000o((byte) 0);
        public final String O00000Oo;
        public final String O00000o;
        public final Object O00000o0;
        public final Integer O00000oO;

        public static final ArrayList<O0000OOo> O000000o(JSONArray jSONArray) {
            return O000000o.O000000o(jSONArray);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O0000OOo)) {
                return false;
            }
            O0000OOo o0000OOo = (O0000OOo) obj;
            return ixe.O000000o(this.O00000Oo, o0000OOo.O00000Oo) && ixe.O000000o(this.O00000o0, o0000OOo.O00000o0) && ixe.O000000o(this.O00000o, o0000OOo.O00000o) && ixe.O000000o(this.O00000oO, o0000OOo.O00000oO);
        }

        public final int hashCode() {
            String str = this.O00000Oo;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Object obj = this.O00000o0;
            int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            String str2 = this.O00000o;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.O00000oO;
            if (num != null) {
                i = num.hashCode();
            }
            return hashCode3 + i;
        }

        public final String toString() {
            return "TriggerConSubProp(key=" + ((Object) this.O00000Oo) + ", valueJson=" + this.O00000o0 + ", itemName=" + ((Object) this.O00000o) + ", valueType=" + this.O00000oO + ')';
        }

        public O0000OOo(String str, Object obj, String str2, Integer num) {
            this.O00000Oo = str;
            this.O00000o0 = obj;
            this.O00000o = str2;
            this.O00000oO = num;
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$TriggerConSubProp$Companion;", "", "()V", "parseItem", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$TriggerConSubProp;", "jsonObject", "Lorg/json/JSONObject;", "parseList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "Lorg/json/JSONArray;", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000000o {
            public /* synthetic */ O000000o(byte b) {
                this();
            }

            private O000000o() {
            }

            public static ArrayList<O0000OOo> O000000o(JSONArray jSONArray) {
                int i;
                JSONObject jSONObject;
                ArrayList<O0000OOo> arrayList = new ArrayList<>();
                int i2 = 0;
                if (jSONArray == null) {
                    i = 0;
                } else {
                    i = jSONArray.length();
                }
                if (i > 0) {
                    while (true) {
                        int i3 = i2 + 1;
                        if (jSONArray == null) {
                            jSONObject = null;
                        } else {
                            jSONObject = jSONArray.optJSONObject(i2);
                        }
                        arrayList.add(O000000o(jSONObject));
                        if (i3 >= i) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                return arrayList;
            }

            private static O0000OOo O000000o(JSONObject jSONObject) {
                Object obj;
                String str;
                Integer num = null;
                String optString = jSONObject == null ? null : jSONObject.optString("key");
                if (jSONObject == null) {
                    obj = null;
                } else {
                    obj = jSONObject.opt("value_json");
                }
                if (jSONObject == null) {
                    str = null;
                } else {
                    str = jSONObject.optString("description");
                }
                if (jSONObject != null) {
                    num = Integer.valueOf(jSONObject.optInt("value_type"));
                }
                return new O0000OOo(optString, obj, str, num);
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$DeviceType;", "", "device", "", "service", "(Ljava/lang/String;Ljava/lang/String;)V", "getDevice", "()Ljava/lang/String;", "getService", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f433O000000o = new O000000o((byte) 0);
        public final String O00000Oo;
        public final String O00000o0;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O00000Oo)) {
                return false;
            }
            O00000Oo o00000Oo = (O00000Oo) obj;
            return ixe.O000000o(this.O00000Oo, o00000Oo.O00000Oo) && ixe.O000000o(this.O00000o0, o00000Oo.O00000o0);
        }

        public final int hashCode() {
            String str = this.O00000Oo;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.O00000o0;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            return "DeviceType(device=" + ((Object) this.O00000Oo) + ", service=" + ((Object) this.O00000o0) + ')';
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$DeviceType$Companion;", "", "()V", "parseItem", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$DeviceType;", "jsonObject", "Lorg/json/JSONObject;", "parseList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "Lorg/json/JSONArray;", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000000o {
            public /* synthetic */ O000000o(byte b) {
                this();
            }

            private O000000o() {
            }

            public static ArrayList<O00000Oo> O000000o(JSONArray jSONArray) {
                int i;
                JSONObject jSONObject;
                ArrayList<O00000Oo> arrayList = new ArrayList<>();
                int i2 = 0;
                if (jSONArray == null) {
                    i = 0;
                } else {
                    i = jSONArray.length();
                }
                if (i > 0) {
                    while (true) {
                        int i3 = i2 + 1;
                        String str = null;
                        if (jSONArray == null) {
                            jSONObject = null;
                        } else {
                            jSONObject = jSONArray.optJSONObject(i2);
                        }
                        String optString = jSONObject == null ? null : jSONObject.optString("device");
                        if (jSONObject != null) {
                            str = jSONObject.optString("service");
                        }
                        arrayList.add(new O00000Oo(optString, str));
                        if (i3 >= i) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                return arrayList;
            }
        }

        public O00000Oo(String str, String str2) {
            this.O00000Oo = str;
            this.O00000o0 = str2;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\"\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0004j\b\u0012\u0004\u0012\u00020\n`\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\u000e"}, d2 = {"Lcom/xiaomi/smarthome/scene/bean/RecommendTpl$Companion;", "", "()V", "parseBlackList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "jsonArray", "Lorg/json/JSONArray;", "parseItem", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl;", "jsonObject", "Lorg/json/JSONObject;", "parseList", "smarthome-scene-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        public static hof O000000o(JSONObject jSONObject) {
            JSONObject jSONObject2;
            JSONObject jSONObject3;
            JSONObject jSONObject4;
            Long l;
            Integer num;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            Boolean bool;
            Long l2;
            Boolean bool2;
            String optString;
            JSONObject jSONObject5 = jSONObject;
            Boolean bool3 = null;
            JSONObject optJSONObject = jSONObject5 == null ? null : jSONObject5.optJSONObject("trigger");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            if (jSONObject5 == null) {
                jSONObject2 = null;
            } else {
                jSONObject2 = jSONObject5.optJSONObject("condition");
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            if (jSONObject5 == null) {
                jSONObject3 = null;
            } else {
                jSONObject3 = jSONObject5.optJSONObject("action");
            }
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            if (jSONObject5 == null) {
                jSONObject4 = null;
            } else {
                jSONObject4 = jSONObject5.optJSONObject("timespan");
            }
            if (jSONObject4 == null) {
                jSONObject4 = new JSONObject();
            }
            if (jSONObject5 == null || (optString = jSONObject5.optString("template_id")) == null) {
                l = null;
            } else {
                l = Long.valueOf(Long.parseLong(optString));
            }
            if (jSONObject5 == null) {
                num = null;
            } else {
                num = Integer.valueOf(jSONObject5.optInt("version"));
            }
            if (jSONObject5 == null) {
                str = null;
            } else {
                str = jSONObject5.optString("desc");
            }
            if (jSONObject5 == null) {
                str2 = null;
            } else {
                str2 = jSONObject5.optString("short_desc");
            }
            if (jSONObject5 == null) {
                str3 = null;
            } else {
                str3 = jSONObject5.optString("name");
            }
            if (jSONObject5 == null) {
                str4 = null;
            } else {
                str4 = jSONObject5.optString("logo_url");
            }
            if (jSONObject5 == null) {
                str5 = null;
            } else {
                str5 = jSONObject5.optString("picture_url");
            }
            if (jSONObject5 == null) {
                str6 = null;
            } else {
                str6 = jSONObject5.optString("ta_url");
            }
            if (jSONObject5 == null) {
                str7 = null;
            } else {
                str7 = jSONObject5.optString("ta_text");
            }
            if (jSONObject5 == null) {
                str8 = null;
            } else {
                str8 = jSONObject5.optString("ta_icon");
            }
            if (jSONObject5 == null) {
                str9 = null;
            } else {
                str9 = jSONObject5.optString("tc_url");
            }
            if (jSONObject5 == null) {
                str10 = null;
            } else {
                str10 = jSONObject5.optString("tc_text");
            }
            if (jSONObject5 == null) {
                str11 = null;
            } else {
                str11 = jSONObject5.optString("tc_icon");
            }
            if (jSONObject5 == null) {
                str12 = null;
            } else {
                str12 = jSONObject5.optString("ac_url");
            }
            if (jSONObject5 == null) {
                str13 = null;
            } else {
                str13 = jSONObject5.optString("ac_text");
            }
            if (jSONObject5 == null) {
                str14 = null;
            } else {
                str14 = jSONObject5.optString("ac_icon");
            }
            if (jSONObject5 == null) {
                str15 = null;
            } else {
                str15 = jSONObject5.optString("tca_url");
            }
            if (jSONObject5 == null) {
                str16 = null;
            } else {
                str16 = jSONObject5.optString("tca_text");
            }
            if (jSONObject5 == null) {
                str17 = null;
            } else {
                str17 = jSONObject5.optString("tca_icon");
            }
            if (jSONObject5 == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(jSONObject5.optBoolean("required"));
            }
            if (jSONObject5 == null) {
                l2 = null;
            } else {
                l2 = Long.valueOf(jSONObject5.optLong("extra"));
            }
            if (jSONObject5 == null) {
                bool2 = null;
            } else {
                bool2 = Boolean.valueOf(jSONObject5.optBoolean("enable"));
            }
            if (jSONObject5 != null) {
                bool3 = Boolean.valueOf(jSONObject5.optBoolean("enable_push"));
            }
            O0000O0o.O000000o o000000o = O0000O0o.f441O000000o;
            O0000O0o O000000o2 = O0000O0o.O000000o.O000000o(optJSONObject);
            O00000o.O000000o o000000o2 = O00000o.f434O000000o;
            O00000o O000000o3 = O00000o.O000000o.O000000o(jSONObject2);
            O00000o0.O00000o o00000o = O00000o0.f436O000000o;
            return new hof(l, num, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, bool, l2, bool2, bool3, O000000o2, O000000o3, O00000o0.O00000o.O000000o(jSONObject3), hoi.O000000o(jSONObject4));
        }

        public static ArrayList<String> O000000o(JSONArray jSONArray) {
            int i;
            String str;
            ArrayList<String> arrayList = new ArrayList<>();
            int i2 = 0;
            if (jSONArray == null) {
                i = 0;
            } else {
                i = jSONArray.length();
            }
            if (i > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    if (jSONArray == null) {
                        str = null;
                    } else {
                        str = jSONArray.optString(i2);
                    }
                    if (str != null) {
                        arrayList.add(str);
                    }
                    if (i3 >= i) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return arrayList;
        }
    }

    public static final ArrayList<hof> O000000o(JSONArray jSONArray) {
        int i;
        JSONObject jSONObject;
        ArrayList<hof> arrayList = new ArrayList<>();
        int i2 = 0;
        if (jSONArray == null) {
            i = 0;
        } else {
            i = jSONArray.length();
        }
        if (i > 0) {
            while (true) {
                int i3 = i2 + 1;
                if (jSONArray == null) {
                    jSONObject = null;
                } else {
                    jSONObject = jSONArray.optJSONObject(i2);
                }
                arrayList.add(O000000o.O000000o(jSONObject));
                if (i3 >= i) {
                    break;
                }
                i2 = i3;
            }
        }
        return arrayList;
    }
}
