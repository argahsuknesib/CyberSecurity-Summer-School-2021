package _m_j;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.rt2zz.reactnativecontacts.ContactsManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class cua implements ReactPackage {
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ContactsManager(reactApplicationContext));
        return arrayList;
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ViewManager[0]);
    }
}
