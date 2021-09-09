package org.reactnative.facedetector;

import _m_j.jmt;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FaceDetectorModule extends ReactContextBaseJavaModule {
    private static ReactApplicationContext mScopedContext;

    public String getName() {
        return "RNFaceDetector";
    }

    public FaceDetectorModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        mScopedContext = reactApplicationContext;
    }

    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new HashMap<String, Object>() {
            /* class org.reactnative.facedetector.FaceDetectorModule.AnonymousClass1 */

            {
                put("Mode", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class org.reactnative.facedetector.FaceDetectorModule.AnonymousClass1.AnonymousClass1 */

                    {
                        put("fast", Integer.valueOf(RNFaceDetector.O00000oo));
                        put("accurate", Integer.valueOf(RNFaceDetector.O00000oO));
                    }
                }));
                put("Landmarks", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class org.reactnative.facedetector.FaceDetectorModule.AnonymousClass1.AnonymousClass3 */

                    {
                        put("all", Integer.valueOf(RNFaceDetector.O00000o0));
                        put("none", Integer.valueOf(RNFaceDetector.O00000o));
                    }
                }));
                put("Classifications", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class org.reactnative.facedetector.FaceDetectorModule.AnonymousClass1.AnonymousClass2 */

                    {
                        put("all", Integer.valueOf(RNFaceDetector.f15479O000000o));
                        put("none", Integer.valueOf(RNFaceDetector.O00000Oo));
                    }
                }));
            }
        });
    }

    @ReactMethod
    public void detectFaces(ReadableMap readableMap, Promise promise) {
        new jmt(mScopedContext, readableMap, promise).execute(new Void[0]);
    }
}
