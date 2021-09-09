package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.LruCache;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fyf {
    private static int O000000o(char c) {
        int i = c - 'W';
        return i < 0 ? c - '0' : i;
    }

    public static final String O000000o(List<String> list, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (String append : list) {
                stringBuffer.append(str);
                stringBuffer.append(append);
            }
        }
        if (stringBuffer.length() == 0) {
            return "";
        }
        return stringBuffer.substring(str.length());
    }

    public static String O000000o(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        if (readableArray.size() == 1) {
            return readableArray.getMap(0).getString("uri");
        }
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getMap(i).getString("uri");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return null;
    }

    public static String O000000o(ReadableMap readableMap, String str, String str2) {
        if (readableMap == null) {
            return str2;
        }
        try {
            return (!readableMap.hasKey(str) || readableMap.isNull(str)) ? str2 : readableMap.getString(str);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static boolean O000000o(ReadableMap readableMap, String str) {
        if (readableMap == null) {
            return false;
        }
        try {
            return readableMap.hasKey(str) && !readableMap.isNull(str) && readableMap.getBoolean(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static double O000000o(ReadableMap readableMap, String str, double d) {
        if (readableMap == null) {
            return d;
        }
        try {
            return (!readableMap.hasKey(str) || readableMap.isNull(str)) ? d : readableMap.getDouble(str);
        } catch (Exception unused) {
            return d;
        }
    }

    public static int O000000o(ReadableMap readableMap, String str, int i) {
        if (readableMap == null) {
            return i;
        }
        try {
            return (!readableMap.hasKey(str) || readableMap.isNull(str)) ? i : readableMap.getInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static ReadableArray O00000Oo(ReadableMap readableMap, String str) {
        if (readableMap == null) {
            return null;
        }
        try {
            if (!readableMap.hasKey(str) || readableMap.isNull(str)) {
                return null;
            }
            return readableMap.getArray(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ReadableMap O00000o0(ReadableMap readableMap, String str) {
        if (readableMap == null) {
            return null;
        }
        try {
            if (!readableMap.hasKey(str) || readableMap.isNull(str)) {
                return null;
            }
            return readableMap.getMap(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ReadableMap O000000o(ReadableArray readableArray, int i) {
        if (readableArray == null) {
            return null;
        }
        try {
            if (readableArray.size() <= i || readableArray.isNull(i)) {
                return null;
            }
            return readableArray.getMap(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String O000000o(ReadableMap readableMap) {
        if (readableMap == null) {
            return new JSONObject().toString();
        }
        try {
            JSONObject jSONObject = new JSONObject(readableMap.toString());
            if (jSONObject.has("NativeMap")) {
                return jSONObject.getString("NativeMap");
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            gbu.O00000Oo(e.toString());
            return new JSONObject().toString();
        }
    }

    public static String O00000Oo(ReadableMap readableMap, String str, String str2) {
        if (readableMap == null || TextUtils.isEmpty(str) || !readableMap.hasKey(str)) {
            return str2;
        }
        switch (readableMap.getType(str)) {
            case Null:
            default:
                return str2;
            case Boolean:
                return String.valueOf(readableMap.getBoolean(str));
            case Number:
                try {
                    return String.valueOf(readableMap.getInt(str));
                } catch (Exception unused) {
                    return String.valueOf(readableMap.getDouble(str));
                }
            case String:
                return O000000o(readableMap, str, "");
            case Map:
                return O00000o0(readableMap, str).toString();
            case Array:
                return O00000Oo(readableMap, str).toString();
        }
    }

    public static Bitmap O000000o(RecyclerView recyclerView) {
        RecyclerView.O000000o adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return null;
        }
        int itemCount = adapter.getItemCount();
        Paint paint = new Paint();
        LruCache lruCache = new LruCache(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);
        int i = 0;
        for (int i2 = 0; i2 < itemCount; i2++) {
            RecyclerView.O000OOo0 createViewHolder = adapter.createViewHolder(recyclerView, adapter.getItemViewType(i2));
            adapter.onBindViewHolder(createViewHolder, i2);
            createViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            createViewHolder.itemView.layout(0, 0, createViewHolder.itemView.getMeasuredWidth(), createViewHolder.itemView.getMeasuredHeight());
            createViewHolder.itemView.setDrawingCacheEnabled(true);
            createViewHolder.itemView.buildDrawingCache();
            Bitmap drawingCache = createViewHolder.itemView.getDrawingCache();
            if (drawingCache != null) {
                lruCache.put(String.valueOf(i2), drawingCache);
            }
            i += createViewHolder.itemView.getMeasuredHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(recyclerView.getMeasuredWidth(), i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = recyclerView.getBackground();
        if (background instanceof ColorDrawable) {
            canvas.drawColor(((ColorDrawable) background).getColor());
        }
        int i3 = 0;
        for (int i4 = 0; i4 < itemCount; i4++) {
            Bitmap bitmap = (Bitmap) lruCache.get(String.valueOf(i4));
            canvas.drawBitmap(bitmap, 0.0f, (float) i3, paint);
            i3 += bitmap.getHeight();
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap O000000o(ScrollView scrollView) {
        int i = 0;
        for (int i2 = 0; i2 < scrollView.getChildCount(); i2++) {
            i += scrollView.getChildAt(i2).getHeight();
            scrollView.getChildAt(i2).setBackgroundColor(-1);
        }
        Bitmap createBitmap = Bitmap.createBitmap(scrollView.getWidth(), i, Bitmap.Config.RGB_565);
        scrollView.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap O000000o(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        int count = adapter.getCount();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < count; i2++) {
            View view = adapter.getView(i2, null, listView);
            view.measure(View.MeasureSpec.makeMeasureSpec(listView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            arrayList.add(view.getDrawingCache());
            i += view.getMeasuredHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(listView.getMeasuredWidth(), i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            Bitmap bitmap = (Bitmap) arrayList.get(i4);
            canvas.drawBitmap(bitmap, 0.0f, (float) i3, paint);
            i3 += bitmap.getHeight();
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static void O000000o(JSONObject jSONObject, WritableMap writableMap) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt instanceof JSONObject) {
                    WritableMap createMap = Arguments.createMap();
                    O000000o((JSONObject) opt, createMap);
                    writableMap.putMap(next, createMap);
                } else if (opt instanceof JSONArray) {
                    WritableArray createArray = Arguments.createArray();
                    O000000o((JSONArray) opt, createArray);
                    writableMap.putArray(next, createArray);
                } else if (opt instanceof Boolean) {
                    writableMap.putBoolean(next, ((Boolean) opt).booleanValue());
                } else if (opt instanceof Integer) {
                    writableMap.putInt(next, ((Integer) opt).intValue());
                } else if (opt instanceof String) {
                    writableMap.putString(next, (String) opt);
                } else if (opt instanceof Number) {
                    writableMap.putDouble(next, ((Number) opt).doubleValue());
                }
            }
        }
    }

    private static void O000000o(JSONArray jSONArray, WritableArray writableArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                Object opt = jSONArray.opt(i);
                if (opt instanceof JSONObject) {
                    WritableMap createMap = Arguments.createMap();
                    O000000o((JSONObject) opt, createMap);
                    writableArray.pushMap(createMap);
                } else if (opt instanceof JSONArray) {
                    WritableArray createArray = Arguments.createArray();
                    O000000o((JSONArray) opt, createArray);
                    writableArray.pushArray(createArray);
                } else if (opt instanceof Boolean) {
                    writableArray.pushBoolean(((Boolean) opt).booleanValue());
                } else if (opt instanceof Integer) {
                    writableArray.pushInt(((Integer) opt).intValue());
                } else if (opt instanceof String) {
                    writableArray.pushString((String) opt);
                } else if (opt instanceof Number) {
                    writableArray.pushDouble(((Number) opt).doubleValue());
                }
            }
        }
    }

    public static String O000000o(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return fku.O000000o(bArr);
    }

    public static byte[] O000000o(String str) {
        if (str == null) {
            return new byte[0];
        }
        int length = str.length() >> 1;
        byte[] bArr = new byte[length];
        char[] charArray = str.toLowerCase().toCharArray();
        for (int i = 0; i < length; i++) {
            int i2 = i << 1;
            bArr[i] = (byte) (O000000o(charArray[i2 + 1]) | (O000000o(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static int O000000o(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021 A[SYNTHETIC, Splitter:B:11:0x0021] */
    public static String O000000o(Bitmap bitmap) {
        String str;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bitmap != null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.flush();
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        } else {
            str = null;
        }
        if (byteArrayOutputStream2 != null) {
            try {
                byteArrayOutputStream2.flush();
                byteArrayOutputStream2.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    public static String O000000o(Context context) {
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x01da A[SYNTHETIC, Splitter:B:78:0x01da] */
    public static String O000000o(int i, int i2, String str) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2;
        JSONArray jSONArray;
        float f;
        int i3;
        String str2;
        String str3;
        String str4;
        int i4 = i2;
        String str5 = "fillColor";
        String str6 = "dash";
        String str7 = "type";
        String str8 = "width";
        String str9 = "color";
        Bitmap createBitmap = Bitmap.createBitmap(i, i4, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        char c = 0;
        canvas.drawColor(0);
        Paint paint = new Paint();
        int i5 = 1;
        paint.setAntiAlias(true);
        try {
            JSONArray jSONArray2 = new JSONArray(str);
            int i6 = 0;
            while (i6 < jSONArray2.length()) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i6);
                String str10 = "#FFFFFFFF";
                if (jSONObject.has(str9)) {
                    str10 = jSONObject.getString(str9);
                }
                if (jSONObject.has(str8)) {
                    jSONArray = jSONArray2;
                    f = (float) jSONObject.getDouble(str8);
                } else {
                    jSONArray = jSONArray2;
                    f = 2.0f;
                }
                paint.setStrokeWidth(f);
                if ((jSONObject.has(str7) ? jSONObject.getInt(str7) : 0) == i5) {
                    float[] fArr = new float[2];
                    fArr[c] = 10.0f;
                    fArr[i5] = 10.0f;
                    if (jSONObject.has(str6)) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray(str6);
                        if (jSONArray3.length() == 2) {
                            i3 = i6;
                            fArr[0] = (float) jSONArray3.getDouble(0);
                            fArr[1] = (float) jSONArray3.getDouble(1);
                            paint.setPathEffect(new DashPathEffect(fArr, 0.0f));
                            byteArrayOutputStream = null;
                        }
                    }
                    i3 = i6;
                    paint.setPathEffect(new DashPathEffect(fArr, 0.0f));
                    byteArrayOutputStream = null;
                } else {
                    i3 = i6;
                    byteArrayOutputStream = null;
                    paint.setPathEffect(null);
                }
                JSONArray jSONArray4 = jSONObject.getJSONArray("points");
                if (jSONArray4.length() % 2 != 0) {
                    try {
                        if (jSONArray4.length() >= 4) {
                            throw new Exception("points in json must has valid length");
                        }
                    } catch (Exception e) {
                        e = e;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                }
                int length = jSONArray4.length() / 2;
                int parseColor = jSONObject.has(str5) ? Color.parseColor(jSONObject.getString(str5)) : 0;
                if (parseColor != 0) {
                    Path path = new Path();
                    int i7 = parseColor;
                    float f2 = (float) i4;
                    str3 = str5;
                    str2 = str6;
                    path.moveTo((float) jSONArray4.getDouble(0), f2 - ((float) jSONArray4.getDouble(1)));
                    int i8 = 1;
                    while (i8 < length) {
                        int i9 = i8 * 2;
                        Path path2 = path;
                        path2.lineTo((float) jSONArray4.getDouble(i9), f2 - ((float) jSONArray4.getDouble(i9 + 1)));
                        i8++;
                        str7 = str7;
                        path = path2;
                    }
                    Path path3 = path;
                    str4 = str7;
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(i7);
                    canvas.drawPath(path3, paint);
                } else {
                    str3 = str5;
                    str2 = str6;
                    str4 = str7;
                }
                paint.setColor(Color.parseColor(str10));
                float[] fArr2 = new float[((length - 1) * 4)];
                int i10 = 1;
                while (i10 < length) {
                    int i11 = i10 * 4;
                    int i12 = (i10 - 1) * 2;
                    fArr2[i11 - 4] = (float) jSONArray4.getDouble(i12);
                    float f3 = (float) i4;
                    String str11 = str9;
                    fArr2[i11 - 3] = f3 - ((float) jSONArray4.getDouble(i12 + 1));
                    int i13 = i10 * 2;
                    fArr2[i11 - 2] = (float) jSONArray4.getDouble(i13);
                    fArr2[i11 - 1] = f3 - ((float) jSONArray4.getDouble(i13 + 1));
                    i10++;
                    length = length;
                    str8 = str8;
                    str4 = str4;
                    str9 = str11;
                }
                canvas.drawLines(fArr2, paint);
                i6 = i3 + 1;
                str8 = str8;
                str7 = str4;
                str5 = str3;
                jSONArray2 = jSONArray;
                str9 = str9;
                str6 = str2;
                c = 0;
                i5 = 1;
            }
            byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                String encodeToString = Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 0);
                try {
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                if (createBitmap != null && !createBitmap.isRecycled()) {
                    createBitmap.recycle();
                }
                return encodeToString;
            } catch (Exception e3) {
                e = e3;
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream2 = null;
            throw e;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }
}
