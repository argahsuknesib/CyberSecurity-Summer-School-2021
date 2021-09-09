package _m_j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class cdy {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f13672O000000o = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /* JADX WARN: Failed to insert an additional move for type inference into block B:20:0x0028 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:19:0x0028 */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: int} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v1, types: [int, byte] */
    /* JADX WARNING: Multi-variable type inference failed */
    public static final String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i : digest) {
                if (i < 0) {
                    i += 256;
                }
                stringBuffer.append(f13672O000000o[i / 16] + f13672O000000o[i % 16]);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int O000000o(Activity activity, float f) {
        if (activity == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (int) ((f * displayMetrics.density) + 0.5f);
    }

    public static int O000000o(Context context, float f) {
        if (context == null) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int O000000o(float f) {
        return O000000o(bxp.f13383O000000o, f);
    }
}
