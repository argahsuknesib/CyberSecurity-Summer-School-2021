package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.IGmsCallbacks;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface IGmsServiceBroker extends IInterface {

    public static abstract class Stub extends Binder implements IGmsServiceBroker {

        static class zza implements IGmsServiceBroker {
            private final IBinder zza;

            zza(IBinder iBinder) {
                this.zza = iBinder;
            }

            public final IBinder asBinder() {
                return this.zza;
            }

            public final void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
                    if (getServiceRequest != null) {
                        obtain.writeInt(1);
                        getServiceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zza.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        public static IGmsServiceBroker asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) ? new zza(iBinder) : (IGmsServiceBroker) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* access modifiers changed from: protected */
        public void getLegacyService(int i, IGmsCallbacks iGmsCallbacks, int i2, String str, String str2, String[] strArr, Bundle bundle, IBinder iBinder, String str3, String str4) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r7v1, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v4, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r0v6, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r0v8, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r0v11, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r0v14, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r4v3, types: [com.google.android.gms.common.internal.ValidateAccountRequest] */
        /* JADX WARN: Type inference failed for: r4v6, types: [com.google.android.gms.common.internal.GetServiceRequest] */
        /* JADX WARN: Type inference failed for: r9v15 */
        /* JADX WARN: Type inference failed for: r9v16 */
        /* JADX WARN: Type inference failed for: r4v9 */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 2 */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str;
            String[] strArr;
            IBinder iBinder;
            String[] strArr2;
            String[] strArr3;
            String str2;
            ? r0;
            String str3;
            String[] strArr4;
            String[] strArr5;
            String[] strArr6;
            String str4;
            String[] strArr7;
            int i3 = i;
            Parcel parcel3 = parcel;
            if (i3 > 16777215) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel3.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            IGmsCallbacks asInterface = IGmsCallbacks.Stub.asInterface(parcel.readStrongBinder());
            ? r4 = 0;
            if (i3 == 46) {
                if (parcel.readInt() != 0) {
                    r4 = GetServiceRequest.CREATOR.createFromParcel(parcel3);
                }
                getService(asInterface, r4);
            } else if (i3 == 47) {
                if (parcel.readInt() != 0) {
                    r4 = ValidateAccountRequest.CREATOR.createFromParcel(parcel3);
                }
                validateAccount(asInterface, r4);
            } else {
                int readInt = parcel.readInt();
                String readString = i3 != 4 ? parcel.readString() : null;
                if (i3 != 1) {
                    if (!(i3 == 2 || i3 == 23 || i3 == 25 || i3 == 27)) {
                        if (i3 != 30) {
                            if (i3 == 34) {
                                str2 = parcel.readString();
                                strArr6 = null;
                                strArr5 = strArr6;
                                strArr4 = strArr5;
                                strArr = strArr4;
                                str = strArr;
                                iBinder = strArr4;
                                getLegacyService(i, asInterface, readInt, readString, str2, strArr3, strArr2, iBinder, strArr, str);
                            } else if (!(i3 == 41 || i3 == 43 || i3 == 37 || i3 == 38)) {
                                switch (i3) {
                                    case 5:
                                    case 6:
                                    case 7:
                                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                    case 11:
                                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                    case 13:
                                    case 14:
                                    case GmsLogger.MAX_PII_TAG_LENGTH:
                                    case 16:
                                    case 17:
                                    case 18:
                                        break;
                                    case 9:
                                        str2 = parcel.readString();
                                        strArr3 = parcel.createStringArray();
                                        String readString2 = parcel.readString();
                                        iBinder = parcel.readStrongBinder();
                                        String readString3 = parcel.readString();
                                        if (parcel.readInt() == 0) {
                                            str = readString3;
                                            strArr = readString2;
                                            strArr2 = null;
                                            break;
                                        } else {
                                            r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel3);
                                            str = readString3;
                                            str3 = readString2;
                                            break;
                                        }
                                    case 10:
                                        str2 = parcel.readString();
                                        strArr6 = parcel.createStringArray();
                                        strArr5 = null;
                                        strArr4 = strArr5;
                                        strArr = strArr4;
                                        str = strArr;
                                        iBinder = strArr4;
                                        break;
                                    case 19:
                                        IBinder readStrongBinder = parcel.readStrongBinder();
                                        if (parcel.readInt() != 0) {
                                            strArr2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel3);
                                            strArr3 = null;
                                            strArr = null;
                                        } else {
                                            strArr3 = null;
                                            strArr2 = null;
                                            strArr = null;
                                        }
                                        str = strArr;
                                        iBinder = readStrongBinder;
                                        str2 = str;
                                        break;
                                    case 20:
                                        break;
                                    default:
                                        str2 = null;
                                        strArr6 = null;
                                        strArr5 = strArr6;
                                        strArr4 = strArr5;
                                        strArr = strArr4;
                                        str = strArr;
                                        iBinder = strArr4;
                                        break;
                                }
                                getLegacyService(i, asInterface, readInt, readString, str2, strArr3, strArr2, iBinder, strArr, str);
                            }
                        }
                        String[] createStringArray = parcel.createStringArray();
                        String readString4 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            strArr7 = (Bundle) Bundle.CREATOR.createFromParcel(parcel3);
                            str4 = null;
                        } else {
                            strArr7 = null;
                            str4 = null;
                        }
                        strArr = str4;
                        str = strArr;
                        String str5 = readString4;
                        strArr3 = createStringArray;
                        str2 = str5;
                        iBinder = str4;
                        getLegacyService(i, asInterface, readInt, readString, str2, strArr3, strArr2, iBinder, strArr, str);
                    }
                    if (parcel.readInt() != 0) {
                        strArr5 = (Bundle) Bundle.CREATOR.createFromParcel(parcel3);
                        str2 = null;
                        strArr6 = null;
                        strArr4 = null;
                        strArr = strArr4;
                        str = strArr;
                        iBinder = strArr4;
                        getLegacyService(i, asInterface, readInt, readString, str2, strArr3, strArr2, iBinder, strArr, str);
                    }
                    str2 = null;
                    strArr6 = null;
                    strArr5 = strArr6;
                    strArr4 = strArr5;
                    strArr = strArr4;
                    str = strArr;
                    iBinder = strArr4;
                    getLegacyService(i, asInterface, readInt, readString, str2, strArr3, strArr2, iBinder, strArr, str);
                } else {
                    String readString5 = parcel.readString();
                    strArr3 = parcel.createStringArray();
                    String readString6 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel3);
                        iBinder = null;
                        str = null;
                        str3 = readString5;
                        str2 = readString6;
                    } else {
                        iBinder = null;
                        str = null;
                        strArr = readString5;
                        str2 = readString6;
                        strArr2 = null;
                        getLegacyService(i, asInterface, readInt, readString, str2, strArr3, strArr2, iBinder, strArr, str);
                    }
                }
                strArr2 = r0;
                getLegacyService(i, asInterface, readInt, readString, str2, strArr3, strArr2, iBinder, strArr, str);
            }
            parcel2.writeNoException();
            return true;
        }

        /* access modifiers changed from: protected */
        public void validateAccount(IGmsCallbacks iGmsCallbacks, ValidateAccountRequest validateAccountRequest) throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException;
}
