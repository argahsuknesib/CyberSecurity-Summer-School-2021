package _m_j;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import com.lwansbrough.RCTCamera.RCTCameraViewManager;
import java.util.Arrays;
import java.util.List;
import org.reactnative.camera.CameraModule;
import org.reactnative.camera.CameraViewManager;
import org.reactnative.facedetector.FaceDetectorModule;

public final class jls implements ReactPackage {
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new RCTCameraModule(reactApplicationContext), new CameraModule(reactApplicationContext), new FaceDetectorModule(reactApplicationContext));
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new RCTCameraViewManager(), new CameraViewManager());
    }
}
