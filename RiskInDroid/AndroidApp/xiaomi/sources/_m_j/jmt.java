package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import java.io.File;
import java.io.IOException;
import org.reactnative.facedetector.RNFaceDetector;

public final class jmt extends AsyncTask<Void, Void, SparseArray<Face>> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f1964O000000o;
    private String O00000Oo;
    private int O00000o = 0;
    private Promise O00000o0;
    private int O00000oO = 0;
    private Context O00000oo;
    private ReadableMap O0000O0o;
    private int O0000OOo = 0;
    private RNFaceDetector O0000Oo0;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return O000000o();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        super.onPostExecute(sparseArray);
        WritableMap createMap = Arguments.createMap();
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            WritableMap O000000o2 = jms.O000000o((Face) sparseArray.valueAt(i));
            O000000o2.putDouble("yawAngle", ((-O000000o2.getDouble("yawAngle")) + 360.0d) % 360.0d);
            O000000o2.putDouble("rollAngle", ((-O000000o2.getDouble("rollAngle")) + 360.0d) % 360.0d);
            createArray.pushMap(O000000o2);
        }
        createMap.putArray("faces", createArray);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putInt("width", this.O00000o);
        createMap2.putInt("height", this.O00000oO);
        createMap2.putInt("orientation", this.O0000OOo);
        createMap2.putString("uri", this.f1964O000000o);
        createMap.putMap("image", createMap2);
        this.O0000Oo0.O00000Oo();
        this.O00000o0.resolve(createMap);
    }

    public jmt(Context context, ReadableMap readableMap, Promise promise) {
        this.f1964O000000o = readableMap.getString("uri");
        this.O00000o0 = promise;
        this.O0000O0o = readableMap;
        this.O00000oo = context;
    }

    /* access modifiers changed from: protected */
    public final void onPreExecute() {
        String str = this.f1964O000000o;
        if (str == null) {
            this.O00000o0.reject("E_FACE_DETECTION_FAILED", "You have to provide an URI of an image.");
            cancel(true);
            return;
        }
        this.O00000Oo = Uri.parse(str).getPath();
        String str2 = this.O00000Oo;
        if (str2 == null) {
            Promise promise = this.O00000o0;
            promise.reject("E_FACE_DETECTION_FAILED", "Invalid URI provided: `" + this.f1964O000000o + "`.");
            cancel(true);
            return;
        }
        if (!(str2.startsWith(this.O00000oo.getCacheDir().getPath()) || this.O00000Oo.startsWith(this.O00000oo.getFilesDir().getPath()))) {
            this.O00000o0.reject("E_FACE_DETECTION_FAILED", "The image has to be in the local app's directories.");
            cancel(true);
        } else if (!new File(this.O00000Oo).exists()) {
            Promise promise2 = this.O00000o0;
            promise2.reject("E_FACE_DETECTION_FAILED", "The file does not exist. Given path: `" + this.O00000Oo + "`.");
            cancel(true);
        }
    }

    private SparseArray<Face> O000000o() {
        if (isCancelled()) {
            return null;
        }
        ReadableMap readableMap = this.O0000O0o;
        RNFaceDetector rNFaceDetector = new RNFaceDetector(this.O00000oo);
        rNFaceDetector.O000000o(false);
        if (readableMap.hasKey("mode")) {
            rNFaceDetector.O00000o0(readableMap.getInt("mode"));
        }
        if (readableMap.hasKey("runClassifications")) {
            rNFaceDetector.O000000o(readableMap.getInt("runClassifications"));
        }
        if (readableMap.hasKey("detectLandmarks")) {
            rNFaceDetector.O00000Oo(readableMap.getInt("detectLandmarks"));
        }
        this.O0000Oo0 = rNFaceDetector;
        Bitmap decodeFile = BitmapFactory.decodeFile(this.O00000Oo);
        this.O00000o = decodeFile.getWidth();
        this.O00000oO = decodeFile.getHeight();
        try {
            this.O0000OOo = new dx(this.O00000Oo).O000000o("Orientation", 0);
        } catch (IOException e) {
            Log.e("E_FACE_DETECTION_FAILED", "Reading orientation from file `" + this.O00000Oo + "` failed.", e);
        }
        Frame.Builder builder = new Frame.Builder();
        builder.setBitmap(decodeFile);
        return this.O0000Oo0.O000000o(new jmu(builder.build(), new jmp(decodeFile.getWidth(), decodeFile.getHeight())));
    }
}
