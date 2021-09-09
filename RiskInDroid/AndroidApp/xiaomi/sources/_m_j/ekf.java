package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.CloudCoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class ekf {
    public static boolean O000000o(Context context, String str) {
        File O00000Oo;
        File[] listFiles;
        if (TextUtils.isEmpty(str) || (O00000Oo = O00000Oo(context, str)) == null) {
            return false;
        }
        File parentFile = O00000Oo.getParentFile();
        if (parentFile.isDirectory() && (listFiles = parentFile.listFiles()) != null && listFiles.length > 20) {
            ArrayList arrayList = new ArrayList();
            for (File file : listFiles) {
                arrayList.add(new Pair(file, Long.valueOf(file.lastModified())));
            }
            Collections.sort(arrayList, new Comparator<Pair<File, Long>>() {
                /* class _m_j.ekf.AnonymousClass1 */

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    Pair pair = (Pair) obj;
                    Pair pair2 = (Pair) obj2;
                    if (((Long) pair.second).longValue() < ((Long) pair2.second).longValue()) {
                        return -1;
                    }
                    return pair.second == pair2.second ? 0 : 1;
                }
            });
            for (int i = 0; i < arrayList.size() - 10; i++) {
                ((File) ((Pair) arrayList.get(i)).first).delete();
            }
        }
        if (!O00000Oo.isFile() || !O00000Oo.exists()) {
            try {
                SimpleRequest.StreamContent asStream = SimpleRequest.getAsStream(str, null, null);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(asStream.getStream());
                    if (decodeStream == null) {
                        return false;
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(decodeStream.getWidth(), decodeStream.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    Paint paint = new Paint();
                    Rect rect = new Rect(0, 0, decodeStream.getWidth(), decodeStream.getHeight());
                    paint.setAntiAlias(true);
                    canvas.drawARGB(0, 0, 0, 0);
                    paint.setColor(-16777216);
                    canvas.drawCircle((float) (decodeStream.getWidth() / 2), (float) (decodeStream.getHeight() / 2), (float) (decodeStream.getWidth() / 2), paint);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                    canvas.drawBitmap(decodeStream, rect, rect, paint);
                    FileOutputStream fileOutputStream = new FileOutputStream(O00000Oo);
                    createBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    decodeStream.recycle();
                    createBitmap.recycle();
                    fileOutputStream.close();
                    asStream.closeStream();
                    return true;
                } catch (IOException e) {
                    AccountLog.e("NetworkImageSaver", "failed to save avatar", e);
                    return false;
                } finally {
                    asStream.closeStream();
                }
            } catch (IOException e2) {
                AccountLog.e("NetworkImageSaver", "IO error when download avatar", e2);
                return false;
            } catch (AccessDeniedException e3) {
                AccountLog.e("NetworkImageSaver", "access denied when download avatar", e3);
                return false;
            } catch (AuthenticationFailureException e4) {
                AccountLog.e("NetworkImageSaver", "auth failed when download avatar", e4);
                return false;
            }
        } else {
            AccountLog.i("NetworkImageSaver", "file " + O00000Oo + " exists");
            return false;
        }
    }

    public static File O00000Oo(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(context.getExternalCacheDir(), "img");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, CloudCoder.getMd5DigestUpperCase(str));
    }
}
