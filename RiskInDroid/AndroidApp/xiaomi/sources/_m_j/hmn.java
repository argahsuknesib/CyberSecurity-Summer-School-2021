package _m_j;

import android.content.Context;
import com.facebook.react.bridge.WritableArray;
import com.xiaomi.smarthome.device.api.Callback;

public interface hmn {
    void connectBand(String str, Callback<Integer> callback);

    void deInitBandManager();

    void deleteCard(String str, Callback<Boolean> callback);

    void getAllNfcCards(Callback<String> callback);

    void getDefaultCardAndActivateInfo(Callback<WritableArray> callback);

    void initBandManager(Context context, String str, String str2, Callback<Boolean> callback);

    void issueDoorCard(Callback<Boolean> callback);

    void setDefaultCard(String str, Callback<Boolean> callback);

    void updateCard(String str, Callback<Boolean> callback);
}
