package com.inuker.bluetooth.library;

import _m_j.bio;
import _m_j.bjr;
import _m_j.bko;
import _m_j.bkq;
import _m_j.bkw;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.inuker.bluetooth.library.IBluetoothService;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import com.inuker.bluetooth.library.search.SearchRequest;
import com.inuker.bluetooth.library.search.SearchResult;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class BluetoothServiceImpl extends IBluetoothService.Stub implements Handler.Callback {
    private static BluetoothServiceImpl sInstance;
    private Handler mHandler = new Handler(Looper.getMainLooper(), this);

    private BluetoothServiceImpl() {
    }

    public static BluetoothServiceImpl getInstance() {
        if (sInstance == null) {
            synchronized (BluetoothServiceImpl.class) {
                if (sInstance == null) {
                    sInstance = new BluetoothServiceImpl();
                }
            }
        }
        return sInstance;
    }

    public void callBluetoothApi(int i, Bundle bundle, final IResponse iResponse) throws RemoteException {
        Message obtainMessage = this.mHandler.obtainMessage(i, new bjr() {
            /* class com.inuker.bluetooth.library.BluetoothServiceImpl.AnonymousClass1 */

            public final /* synthetic */ void O000000o(int i, Object obj) {
                Bundle bundle = (Bundle) obj;
                if (iResponse != null) {
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    try {
                        iResponse.onResponse(i, bundle);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        bundle.setClassLoader(getClass().getClassLoader());
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public boolean handleMessage(Message message) {
        Bundle data = message.getData();
        String string = data.getString("extra.mac");
        UUID uuid = (UUID) data.getSerializable("extra.service.uuid");
        UUID uuid2 = (UUID) data.getSerializable("extra.character.uuid");
        UUID uuid3 = (UUID) data.getSerializable("extra.descriptor.uuid");
        byte[] byteArray = data.getByteArray("extra.byte.value");
        bjr bjr = (bjr) message.obj;
        switch (message.what) {
            case 1:
                bio.O000000o(string, (BleConnectOptions) data.getParcelable("extra.options"), bjr);
                return true;
            case 2:
                bio.O000000o(string);
                return true;
            case 3:
                bio.O000000o(string, uuid, uuid2, bjr);
                return true;
            case 4:
                bio.O000000o(string, uuid, uuid2, byteArray, bjr);
                return true;
            case 5:
                bio.O00000Oo(string, uuid, uuid2, byteArray, bjr);
                return true;
            case 6:
                bio.O00000Oo(string, uuid, uuid2, bjr);
                return true;
            case 7:
                bio.O00000o0(string, uuid, uuid2, bjr);
                return true;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                bio.O000000o(string, bjr);
                return true;
            case 9:
            case GmsLogger.MAX_PII_TAG_LENGTH:
            case 16:
            case 17:
            case 18:
            case 19:
            default:
                return true;
            case 10:
                bio.O00000o(string, uuid, uuid2, bjr);
                return true;
            case 11:
                bko.O000000o().O000000o(new bkq((SearchRequest) data.getParcelable("extra.request")), new bkw(bjr) {
                    /* class _m_j.bkp.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ bjr f13019O000000o;

                    {
                        this.f13019O000000o = r1;
                    }

                    public final void O000000o() {
                        this.f13019O000000o.O000000o(1, null);
                    }

                    public final void O000000o(SearchResult searchResult) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("extra.search.result", searchResult);
                        this.f13019O000000o.O000000o(4, bundle);
                    }

                    public final void O00000Oo() {
                        this.f13019O000000o.O000000o(2, null);
                    }

                    public final void O00000o0() {
                        this.f13019O000000o.O000000o(3, null);
                    }
                });
                return true;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                bko.O000000o().O00000Oo();
                return true;
            case 13:
                bio.O000000o(string, uuid, uuid2, uuid3, bjr);
                return true;
            case 14:
                bio.O000000o(string, uuid, uuid2, uuid3, byteArray, bjr);
                return true;
            case 20:
                bio.O000000o(string, data.getInt("extra.type", 0));
                return true;
            case 21:
                bio.O00000Oo(string);
                return true;
        }
    }
}
