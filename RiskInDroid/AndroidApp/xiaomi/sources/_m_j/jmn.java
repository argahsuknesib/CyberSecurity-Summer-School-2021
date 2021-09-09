package _m_j;

import android.os.AsyncTask;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.vision.text.Line;
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

public final class jmn extends AsyncTask<Void, Void, SparseArray<TextBlock>> {

    /* renamed from: O000000o  reason: collision with root package name */
    private jmo f1961O000000o;
    private ThemedReactContext O00000Oo;
    private byte[] O00000o;
    private TextRecognizer O00000o0;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private jmp O0000OOo;
    private double O0000Oo;
    private double O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        super.onPostExecute(sparseArray);
        TextRecognizer textRecognizer = this.O00000o0;
        if (textRecognizer != null) {
            textRecognizer.release();
        }
        if (sparseArray != null) {
            WritableArray createArray = Arguments.createArray();
            for (int i = 0; i < sparseArray.size(); i++) {
                WritableMap O000000o2 = O000000o((TextBlock) sparseArray.valueAt(i));
                if (this.O0000OOo.f1962O000000o == 1) {
                    O000000o2 = O000000o(O000000o2);
                }
                createArray.pushMap(O000000o2);
            }
            this.f1961O000000o.O00000o0(createArray);
        }
        this.f1961O000000o.O00000o();
    }

    public jmn(jmo jmo, ThemedReactContext themedReactContext, byte[] bArr, int i, int i2, int i3, float f, int i4, int i5, int i6, int i7, int i8) {
        this.f1961O000000o = jmo;
        this.O00000Oo = themedReactContext;
        this.O00000o = bArr;
        this.O00000oO = i;
        this.O00000oo = i2;
        this.O0000O0o = i3;
        this.O0000OOo = new jmp(i, i2, i3, i4);
        double d = (double) i5;
        double O000000o2 = (double) (((float) this.O0000OOo.O000000o()) * f);
        Double.isNaN(d);
        Double.isNaN(O000000o2);
        this.O0000Oo0 = d / O000000o2;
        double d2 = (double) i6;
        double O00000Oo2 = (double) (((float) this.O0000OOo.O00000Oo()) * f);
        Double.isNaN(d2);
        Double.isNaN(O00000Oo2);
        this.O0000Oo = d2 / O00000Oo2;
        this.O0000OoO = i7;
        this.O0000Ooo = i8;
    }

    private WritableMap O000000o(Text text) {
        String str;
        WritableMap createMap = Arguments.createMap();
        WritableArray createArray = Arguments.createArray();
        for (Text O000000o2 : text.getComponents()) {
            createArray.pushMap(O000000o(O000000o2));
        }
        createMap.putArray("components", createArray);
        createMap.putString("value", text.getValue());
        int i = text.getBoundingBox().left;
        int i2 = text.getBoundingBox().top;
        if (text.getBoundingBox().left < this.O00000oO / 2) {
            i += this.O0000OoO / 2;
        } else if (text.getBoundingBox().left > this.O00000oO / 2) {
            i -= this.O0000OoO / 2;
        }
        if (text.getBoundingBox().height() < this.O00000oo / 2) {
            i2 += this.O0000Ooo / 2;
        } else if (text.getBoundingBox().height() > this.O00000oo / 2) {
            i2 -= this.O0000Ooo / 2;
        }
        WritableMap createMap2 = Arguments.createMap();
        double d = (double) i;
        double d2 = this.O0000Oo0;
        Double.isNaN(d);
        createMap2.putDouble("x", d * d2);
        double d3 = (double) i2;
        double d4 = this.O0000Oo;
        Double.isNaN(d3);
        createMap2.putDouble("y", d3 * d4);
        WritableMap createMap3 = Arguments.createMap();
        double width = (double) text.getBoundingBox().width();
        double d5 = this.O0000Oo0;
        Double.isNaN(width);
        createMap3.putDouble("width", width * d5);
        double height = (double) text.getBoundingBox().height();
        double d6 = this.O0000Oo;
        Double.isNaN(height);
        createMap3.putDouble("height", height * d6);
        WritableMap createMap4 = Arguments.createMap();
        createMap4.putMap("origin", createMap2);
        createMap4.putMap("size", createMap3);
        createMap.putMap("bounds", createMap4);
        if (text instanceof TextBlock) {
            str = "block";
        } else {
            str = text instanceof Line ? "line" : "element";
        }
        createMap.putString("type", str);
        return createMap;
    }

    private WritableMap O000000o(WritableMap writableMap) {
        ReadableMap map = writableMap.getMap("bounds");
        WritableMap O000000o2 = jms.O000000o(jms.O000000o(map.getMap("origin"), this.O0000OOo.O000000o(), this.O0000Oo0), -map.getMap("size").getDouble("width"));
        WritableMap createMap = Arguments.createMap();
        createMap.merge(map);
        createMap.putMap("origin", O000000o2);
        writableMap.putMap("bounds", createMap);
        ReadableArray array = writableMap.getArray("components");
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < array.size(); i++) {
            WritableMap createMap2 = Arguments.createMap();
            createMap2.merge(array.getMap(i));
            O000000o(createMap2);
            createArray.pushMap(createMap2);
        }
        writableMap.putArray("components", createArray);
        return writableMap;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        if (isCancelled() || this.f1961O000000o == null) {
            return null;
        }
        this.O00000o0 = new TextRecognizer.Builder(this.O00000Oo).build();
        return this.O00000o0.detect(jmv.O000000o(this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o).f1965O000000o);
    }
}
