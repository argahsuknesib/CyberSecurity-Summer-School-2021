package _m_j;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.zip.Deflater;

public class gaq implements UIBlock {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f17468O000000o = "gaq";
    private static byte[] O00000Oo = new byte[65536];
    private static final Object O0000o0O = new Object();
    private static final Set<Bitmap> O0000o0o = Collections.newSetFromMap(new WeakHashMap());
    private final String O00000o;
    private final int O00000o0;
    @O000000o
    private final int O00000oO;
    private final double O00000oo;
    private final Integer O0000O0o;
    private final Integer O0000OOo;
    private final String O0000Oo;
    private final File O0000Oo0;
    private final Promise O0000OoO;
    private final Boolean O0000Ooo;
    private final Activity O0000o0;
    private final ReactApplicationContext O0000o00;

    public @interface O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final Bitmap.CompressFormat[] f17469O000000o = {Bitmap.CompressFormat.JPEG, Bitmap.CompressFormat.PNG, Bitmap.CompressFormat.WEBP};
    }

    public gaq(int i, String str, @O000000o int i2, double d, Integer num, Integer num2, File file, String str2, Boolean bool, ReactApplicationContext reactApplicationContext, Activity activity, Promise promise) {
        this.O00000o0 = i;
        this.O00000o = str;
        this.O00000oO = i2;
        this.O00000oo = d;
        this.O0000O0o = num;
        this.O0000OOo = num2;
        this.O0000Oo0 = file;
        this.O0000Oo = str2;
        this.O0000Ooo = bool;
        this.O0000o00 = reactApplicationContext;
        this.O0000o0 = activity;
        this.O0000OoO = promise;
    }

    public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
        View view;
        int i = this.O00000o0;
        if (i == -1) {
            view = this.O0000o0.getWindow().getDecorView().findViewById(16908290);
        } else {
            view = nativeViewHierarchyManager.resolveView(i);
        }
        if (view == null) {
            String str = f17468O000000o;
            Log.e(str, "No view found with reactTag: " + this.O00000o0, new AssertionError());
            Promise promise = this.O0000OoO;
            promise.reject("E_UNABLE_TO_SNAPSHOT", "No view found with reactTag: " + this.O00000o0);
            return;
        }
        try {
            O00000Oo o00000Oo = new O00000Oo(O00000Oo);
            o00000Oo.O00000Oo(Math.min(view.getWidth() * view.getHeight() * 4, 32));
            O00000Oo = o00000Oo.O000000o();
            if ("tmpfile".equals(this.O0000Oo) && -1 == this.O00000oO) {
                String uri = Uri.fromFile(this.O0000Oo0).toString();
                FileOutputStream fileOutputStream = new FileOutputStream(this.O0000Oo0);
                O00000Oo o00000Oo2 = new O00000Oo(O00000Oo);
                Point O000000o2 = O000000o(view, o00000Oo2);
                O00000Oo = o00000Oo2.O000000o();
                int size = o00000Oo2.size();
                fileOutputStream.write(String.format(Locale.US, "%d:%d|", Integer.valueOf(O000000o2.x), Integer.valueOf(O000000o2.y)).getBytes(Charset.forName("US-ASCII")));
                fileOutputStream.write(O00000Oo, 0, size);
                fileOutputStream.close();
                this.O0000OoO.resolve(uri);
            } else if (!"tmpfile".equals(this.O0000Oo) || -1 == this.O00000oO) {
                if (!"base64".equals(this.O0000Oo)) {
                    if (!"zip-base64".equals(this.O0000Oo)) {
                        if ("data-uri".equals(this.O0000Oo)) {
                            O00000Oo o00000Oo3 = new O00000Oo(O00000Oo);
                            O000000o(view, o00000Oo3);
                            O00000Oo = o00000Oo3.O000000o();
                            String encodeToString = Base64.encodeToString(O00000Oo, 0, o00000Oo3.size(), 2);
                            String str2 = "jpg".equals(this.O00000o) ? "jpeg" : this.O00000o;
                            Promise promise2 = this.O0000OoO;
                            promise2.resolve("data:image/" + str2 + ";base64," + encodeToString);
                            return;
                        }
                        return;
                    }
                }
                O000000o(view);
            } else {
                O000000o(view, new FileOutputStream(this.O0000Oo0));
                this.O0000OoO.resolve(Uri.fromFile(this.O0000Oo0).toString());
            }
        } catch (Throwable th) {
            Log.e(f17468O000000o, "Failed to capture view snapshot", th);
            this.O0000OoO.reject("E_UNABLE_TO_SNAPSHOT", "Failed to capture view snapshot");
        }
    }

    private void O000000o(View view) throws IOException {
        String str;
        boolean z = -1 == this.O00000oO;
        boolean equals = "zip-base64".equals(this.O0000Oo);
        O00000Oo o00000Oo = new O00000Oo(O00000Oo);
        Point O000000o2 = O000000o(view, o00000Oo);
        O00000Oo = o00000Oo.O000000o();
        int size = o00000Oo.size();
        String format = String.format(Locale.US, "%d:%d|", Integer.valueOf(O000000o2.x), Integer.valueOf(O000000o2.y));
        if (!z) {
            format = "";
        }
        if (equals) {
            Deflater deflater = new Deflater();
            deflater.setInput(O00000Oo, 0, size);
            deflater.finish();
            O00000Oo o00000Oo2 = new O00000Oo(new byte[32]);
            byte[] bArr = new byte[1024];
            while (!deflater.finished()) {
                o00000Oo2.write(bArr, 0, deflater.deflate(bArr));
            }
            str = format + Base64.encodeToString(o00000Oo2.O000000o(), 0, o00000Oo2.size(), 2);
        } else {
            str = format + Base64.encodeToString(O00000Oo, 0, size, 2);
        }
        this.O0000OoO.resolve(str);
    }

    private List<View> O00000Oo(View view) {
        if (!(view instanceof ViewGroup)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(view);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            arrayList2.addAll(O00000Oo(viewGroup.getChildAt(i)));
        }
        return arrayList2;
    }

    private Point O000000o(View view, OutputStream outputStream) throws IOException {
        Bitmap bitmap;
        View view2 = view;
        OutputStream outputStream2 = outputStream;
        try {
            gap.O000000o(f17468O000000o, gap.O000000o(this.O0000o0));
            int width = view.getWidth();
            int height = view.getHeight();
            if (this.O0000Ooo.booleanValue()) {
                if (width <= 0) {
                    throw new RuntimeException("Impossible to snapshot the view: view is invalid");
                }
            } else if (width <= 0 || height <= 0) {
                throw new RuntimeException("Impossible to snapshot the view: view is invalid");
            }
            boolean z = false;
            if (this.O0000Ooo.booleanValue()) {
                ScrollView scrollView = (ScrollView) view2;
                int i = 0;
                for (int i2 = 0; i2 < scrollView.getChildCount(); i2++) {
                    i += scrollView.getChildAt(i2).getHeight();
                }
                height = i;
            }
            Point point = new Point(width, height);
            Bitmap O000000o2 = O000000o(width, height);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            paint.setDither(true);
            Canvas canvas = new Canvas(O000000o2);
            if (this.O0000Ooo.booleanValue()) {
                if (this.O00000oO == 1) {
                    canvas.drawColor(0);
                } else {
                    canvas.drawColor(-1);
                }
                ((ScrollView) view2).getChildAt(0).draw(canvas);
            } else {
                view2.draw(canvas);
            }
            for (View next : O00000Oo(view)) {
                if ((next instanceof TextureView) && next.getVisibility() == 0) {
                    TextureView textureView = (TextureView) next;
                    textureView.setOpaque(z);
                    Bitmap bitmap2 = textureView.getBitmap(O00000Oo(next.getWidth(), next.getHeight()));
                    int save = canvas.save();
                    O000000o(canvas, view2, next);
                    canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
                    canvas.restoreToCount(save);
                    O000000o(bitmap2);
                    z = false;
                }
            }
            if (this.O0000O0o == null || this.O0000OOo == null || (this.O0000O0o.intValue() == width && this.O0000OOo.intValue() == height)) {
                bitmap = O000000o2;
            } else {
                bitmap = Bitmap.createScaledBitmap(O000000o2, this.O0000O0o.intValue(), this.O0000OOo.intValue(), true);
                O000000o(O000000o2);
            }
            if (-1 != this.O00000oO || !(outputStream2 instanceof O00000Oo)) {
                bitmap.compress(O000000o.f17469O000000o[this.O00000oO], (int) (this.O00000oo * 100.0d), outputStream2);
            } else {
                int i3 = width * height * 4;
                O00000Oo o00000Oo = (O00000Oo) outputStream2;
                bitmap.copyPixelsToBuffer(o00000Oo.O000000o(i3));
                o00000Oo.O00000Oo(i3);
            }
            O000000o(bitmap);
            return point;
        } finally {
            outputStream.close();
        }
    }

    private static Matrix O000000o(Canvas canvas, View view, View view2) {
        Matrix matrix = new Matrix();
        LinkedList linkedList = new LinkedList();
        View view3 = view2;
        do {
            linkedList.add(view3);
            view3 = (View) view3.getParent();
        } while (view3 != view);
        Collections.reverse(linkedList);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            View view4 = (View) it.next();
            canvas.save();
            int i = 0;
            float left = ((float) (view4.getLeft() + (view4 != view2 ? view4.getPaddingLeft() : 0))) + view4.getTranslationX();
            int top = view4.getTop();
            if (view4 != view2) {
                i = view4.getPaddingTop();
            }
            float translationY = ((float) (top + i)) + view4.getTranslationY();
            canvas.translate(left, translationY);
            canvas.rotate(view4.getRotation(), view4.getPivotX(), view4.getPivotY());
            canvas.scale(view4.getScaleX(), view4.getScaleY());
            matrix.postTranslate(left, translationY);
            matrix.postRotate(view4.getRotation(), view4.getPivotX(), view4.getPivotY());
            matrix.postScale(view4.getScaleX(), view4.getScaleY());
        }
        return matrix;
    }

    private static void O000000o(Bitmap bitmap) {
        synchronized (O0000o0O) {
            O0000o0o.add(bitmap);
        }
    }

    private static Bitmap O000000o(int i, int i2) {
        synchronized (O0000o0O) {
            for (Bitmap next : O0000o0o) {
                if (next.getWidth() == i && next.getHeight() == i2) {
                    O0000o0o.remove(next);
                    next.eraseColor(0);
                    return next;
                }
            }
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }

    private static Bitmap O00000Oo(int i, int i2) {
        synchronized (O0000o0O) {
            for (Bitmap next : O0000o0o) {
                if (next.getWidth() == i && next.getHeight() == i2) {
                    O0000o0o.remove(next);
                    next.eraseColor(0);
                    return next;
                }
            }
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }

    public static class O00000Oo extends ByteArrayOutputStream {
        public O00000Oo(byte[] bArr) {
            super(0);
            this.buf = bArr;
        }

        public final byte[] O000000o() {
            return this.buf;
        }

        public final ByteBuffer O000000o(int i) {
            if (this.buf.length < i) {
                int length = this.buf.length << 1;
                if (length - i < 0) {
                    length = i;
                }
                if (length - 2147483639 > 0) {
                    if (i >= 0) {
                        length = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
                    } else {
                        throw new OutOfMemoryError();
                    }
                }
                this.buf = Arrays.copyOf(this.buf, length);
            }
            return ByteBuffer.wrap(this.buf);
        }

        public final void O00000Oo(int i) {
            this.count = i;
        }
    }
}
