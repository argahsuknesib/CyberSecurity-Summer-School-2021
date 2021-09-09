package com.xiaomi.smarthome.flexible_layout;

import _m_j.ixe;
import android.content.Context;
import com.xiaomi.smarthome.R;
import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/xiaomi/smarthome/flexible_layout/FlexSize;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "Normal", "W530dp", "W780dp", "W960dp", "W1280dp", "Companion", "flexible-layout_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FlexSize extends Enum<FlexSize> {
    private static final /* synthetic */ FlexSize[] $VALUES = $values();
    public static final O000000o Companion = new O000000o((byte) 0);
    public static final FlexSize Normal = new FlexSize("Normal", 0, R.bool.flexible_detect_id_normal);
    public static final FlexSize W1280dp = new FlexSize("W1280dp", 4, R.bool.flexible_detect_id_w1280);
    public static final FlexSize W530dp = new FlexSize("W530dp", 1, R.bool.flexible_detect_id_w530);
    public static final FlexSize W780dp = new FlexSize("W780dp", 2, R.bool.flexible_detect_id_w780);
    public static final FlexSize W960dp = new FlexSize("W960dp", 3, R.bool.flexible_detect_id_w960);
    private final int id;

    private static final /* synthetic */ FlexSize[] $values() {
        return new FlexSize[]{Normal, W530dp, W780dp, W960dp, W1280dp};
    }

    private FlexSize(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/xiaomi/smarthome/flexible_layout/FlexSize$Companion;", "", "()V", "TAG", "", "getSize", "", "context", "Landroid/content/Context;", "size", "Lcom/xiaomi/smarthome/flexible_layout/FlexSize;", "isNormal", "isW1280dp", "isW530dp", "isW780dp", "isW960dp", "query", "test", "", "flexible-layout_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        public static FlexSize O000000o(Context context) {
            ixe.O00000o(context, "context");
            for (FlexSize flexSize : FlexSize.values()) {
                O000000o o000000o = FlexSize.Companion;
                if (O000000o(context, flexSize)) {
                    return flexSize;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        public static boolean O00000Oo(Context context) {
            ixe.O00000o(context, "context");
            return O000000o(context, FlexSize.Normal);
        }

        private static boolean O000000o(Context context, FlexSize flexSize) {
            return context.getResources().getBoolean(flexSize.getId());
        }
    }

    public static FlexSize valueOf(String str) {
        ixe.O00000o(str, "value");
        return (FlexSize) Enum.valueOf(FlexSize.class, str);
    }

    public static FlexSize[] values() {
        FlexSize[] flexSizeArr = $VALUES;
        return (FlexSize[]) Arrays.copyOf(flexSizeArr, flexSizeArr.length);
    }
}
