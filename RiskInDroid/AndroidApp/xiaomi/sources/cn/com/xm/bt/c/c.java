package cn.com.xm.bt.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import cn.com.xm.bt.a.a;
import com.google.android.exoplayer2.C;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.UUID;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final UUID f3085a = a("2902");
    public static final UUID b = a("2901");
    public static UUID c = new UUID(303230942, 1523193452336828707L);
    public static UUID d = new UUID(-1152921504534413312L, -5764607523034234880L);
    private static final String e = String.format("0000%4s-0000-1000-8000-00805f9b34fb", "....");
    private static final UUID f = new UUID(13586, 2384656044284446464L);
    private static final int[] g = {0, 49345, 49537, 320, 49921, 960, 640, 49729, 50689, 1728, 1920, 51009, 1280, 50625, 50305, 1088, 52225, 3264, 3456, 52545, 3840, 53185, 52865, 3648, 2560, 51905, 52097, 2880, 51457, 2496, 2176, 51265, 55297, 6336, 6528, 55617, 6912, 56257, 55937, 6720, 7680, 57025, 57217, 8000, 56577, 7616, 7296, 56385, 5120, 54465, 54657, 5440, 55041, 6080, 5760, 54849, 53761, 4800, 4992, 54081, 4352, 53697, 53377, 4160, 61441, 12480, 12672, 61761, 13056, 62401, 62081, 12864, 13824, 63169, 63361, 14144, 62721, 13760, 13440, 62529, 15360, 64705, 64897, 15680, 65281, 16320, 16000, 65089, 64001, 15040, 15232, 64321, 14592, 63937, 63617, 14400, 10240, 59585, 59777, 10560, 60161, 11200, 10880, 59969, 60929, 11968, 12160, 61249, 11520, 60865, 60545, 11328, 58369, 9408, 9600, 58689, 9984, 59329, 59009, 9792, 8704, 58049, 58241, 9024, 57601, 8640, 8320, 57409, 40961, 24768, 24960, 41281, 25344, 41921, 41601, 25152, 26112, 42689, 42881, 26432, 42241, 26048, 25728, 42049, 27648, 44225, 44417, 27968, 44801, 28608, 28288, 44609, 43521, 27328, 27520, 43841, 26880, 43457, 43137, 26688, 30720, 47297, 47489, 31040, 47873, 31680, 31360, 47681, 48641, 32448, 32640, 48961, 32000, 48577, 48257, 31808, 46081, 29888, 30080, 46401, 30464, 47041, 46721, 30272, 29184, 45761, 45953, 29504, 45313, 29120, 28800, 45121, 20480, 37057, 37249, 20800, 37633, 21440, 21120, 37441, 38401, 22208, 22400, 38721, 21760, 38337, 38017, 21568, 39937, 23744, 23936, 40257, 24320, 40897, 40577, 24128, 23040, 39617, 39809, 23360, 39169, 22976, 22656, 38977, 34817, 18624, 18816, 35137, 19200, 35777, 35457, 19008, 19968, 36545, 36737, 20288, 36097, 19904, 19584, 35905, 17408, 33985, 34177, 17728, 34561, 18368, 18048, 34369, 33281, 17088, 17280, 33601, 16640, 33217, 32897, 16448};
    private static Field h = null;

    public static UUID a(String str) {
        return UUID.fromString(String.format("0000%4s-0000-1000-8000-00805f9b34fb", str));
    }

    public static UUID a(int i) {
        return a(f, (short) i);
    }

    public static UUID b(String str) {
        return UUID.fromString(str);
    }

    private static UUID a(UUID uuid, short s) {
        return new UUID((uuid.getMostSignificantBits() & -281470681743361L) | ((((long) s) & 65535) << 32), uuid.getLeastSignificantBits());
    }

    public static String a(byte[] bArr) {
        a.a(bArr);
        if (bArr == null || bArr.length == 0) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x ", Byte.valueOf(bArr[i])));
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        byte b2 = 0;
        while (i < length) {
            byte b3 = b2 ^ (bArr[i] & 255);
            for (int i2 = 0; i2 < 8; i2++) {
                b3 = (b3 & 1) != 0 ? ((b3 >> 1) & 255) ^ 140 : (b3 >> 1) & 255;
            }
            i++;
            b2 = b3;
        }
        return b2;
    }

    private static int a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 |= (bArr[i + i4] & 255) << (i4 * 8);
        }
        return i3;
    }

    public static int a(byte[] bArr, int i) {
        return a(bArr, i, 4);
    }

    private static String b(int i) {
        StringBuilder sb = new StringBuilder();
        if ((i & 1) > 0) {
            sb.append("BROADCAST ");
        }
        if ((i & NotificationCompat.FLAG_HIGH_PRIORITY) > 0) {
            sb.append("EXTENDED_PROPS ");
        }
        if ((i & 32) > 0) {
            sb.append("INDICATE ");
        }
        if ((i & 16) > 0) {
            sb.append("NOTIFY ");
        }
        if ((i & 2) > 0) {
            sb.append("READ ");
        }
        if ((i & 64) > 0) {
            sb.append("SIGNED_WRITE ");
        }
        if ((i & 8) > 0) {
            sb.append("WRITE ");
        }
        if ((i & 4) > 0) {
            sb.append("WRITE_NO_RESPONSE ");
        }
        return sb.toString();
    }

    public static String a(UUID uuid) {
        String uuid2 = uuid.toString();
        return uuid2.matches(e) ? uuid2.substring(4, 8) : uuid2;
    }

    public static cn.com.xm.bt.d.a c(byte[] bArr) {
        int i;
        int i2;
        int i3;
        byte[] bArr2 = bArr;
        a.b(bArr2.length == 62);
        cn.com.xm.bt.d.a aVar = new cn.com.xm.bt.d.a();
        int i4 = 0;
        while (i4 < 62) {
            int i5 = i4 + 1;
            byte b2 = bArr2[i4];
            if (b2 != 0 && b2 + i5 <= 62) {
                int i6 = i5 + 1;
                byte b3 = bArr2[i5];
                if (b3 == -1) {
                    int i7 = b2 - 1;
                    byte[] bArr3 = new byte[i7];
                    int i8 = i6;
                    int i9 = 0;
                    while (i9 < i7) {
                        bArr3[i9] = bArr2[i];
                        i9++;
                        i8 = i + 1;
                    }
                    String a2 = a(bArr3);
                    aVar.m = a2;
                    a.a("    manufact: ".concat(String.valueOf(a2)));
                } else if (b3 != 1) {
                    if (b3 != 2) {
                        char c2 = 3;
                        if (b3 != 3) {
                            char c3 = 11;
                            switch (b3) {
                                case 6:
                                    StringBuilder sb = new StringBuilder();
                                    int i10 = i6;
                                    int i11 = 0;
                                    while (i11 < b2 - 1) {
                                        byte[] bArr4 = new byte[16];
                                        int i12 = i10;
                                        int i13 = 0;
                                        while (i13 < 16) {
                                            bArr4[i13] = bArr2[i12];
                                            i13++;
                                            i12++;
                                        }
                                        ArrayList<String> arrayList = aVar.g;
                                        Object[] objArr = new Object[16];
                                        objArr[0] = Byte.valueOf(bArr4[15]);
                                        objArr[1] = Byte.valueOf(bArr4[14]);
                                        objArr[2] = Byte.valueOf(bArr4[13]);
                                        objArr[c2] = Byte.valueOf(bArr4[12]);
                                        objArr[4] = Byte.valueOf(bArr4[11]);
                                        objArr[5] = Byte.valueOf(bArr4[10]);
                                        objArr[6] = Byte.valueOf(bArr4[9]);
                                        objArr[7] = Byte.valueOf(bArr4[8]);
                                        objArr[8] = Byte.valueOf(bArr4[7]);
                                        objArr[9] = Byte.valueOf(bArr4[6]);
                                        objArr[10] = Byte.valueOf(bArr4[5]);
                                        objArr[11] = Byte.valueOf(bArr4[4]);
                                        objArr[12] = Byte.valueOf(bArr4[c2]);
                                        objArr[13] = Byte.valueOf(bArr4[2]);
                                        objArr[14] = Byte.valueOf(bArr4[1]);
                                        objArr[15] = Byte.valueOf(bArr4[0]);
                                        arrayList.add(String.format("%02x%02x%02x%02x-%02x%02x-%02x%02x-%02x%02x-%02x%02x%02x%02x%02x%02x", objArr));
                                        sb.append(a(bArr4));
                                        sb.append("; ");
                                        i11 += 16;
                                        i10 = i12;
                                        c2 = 3;
                                    }
                                    a.a("  (*)serv128: " + sb.toString());
                                    i4 = i10;
                                    break;
                                case 7:
                                    StringBuilder sb2 = new StringBuilder();
                                    int i14 = i6;
                                    int i15 = 0;
                                    while (i15 < b2 - 1) {
                                        byte[] bArr5 = new byte[16];
                                        int i16 = 0;
                                        while (i16 < 16) {
                                            bArr5[i16] = bArr2[i14];
                                            i16++;
                                            i14++;
                                        }
                                        ArrayList<String> arrayList2 = aVar.f;
                                        Object[] objArr2 = new Object[16];
                                        objArr2[0] = Byte.valueOf(bArr5[15]);
                                        objArr2[1] = Byte.valueOf(bArr5[14]);
                                        objArr2[2] = Byte.valueOf(bArr5[13]);
                                        objArr2[3] = Byte.valueOf(bArr5[12]);
                                        objArr2[4] = Byte.valueOf(bArr5[c3]);
                                        objArr2[5] = Byte.valueOf(bArr5[10]);
                                        objArr2[6] = Byte.valueOf(bArr5[9]);
                                        objArr2[7] = Byte.valueOf(bArr5[8]);
                                        objArr2[8] = Byte.valueOf(bArr5[7]);
                                        objArr2[9] = Byte.valueOf(bArr5[6]);
                                        objArr2[10] = Byte.valueOf(bArr5[5]);
                                        objArr2[c3] = Byte.valueOf(bArr5[4]);
                                        objArr2[12] = Byte.valueOf(bArr5[3]);
                                        objArr2[13] = Byte.valueOf(bArr5[2]);
                                        objArr2[14] = Byte.valueOf(bArr5[1]);
                                        objArr2[15] = Byte.valueOf(bArr5[0]);
                                        arrayList2.add(String.format("%02x%02x%02x%02x-%02x%02x-%02x%02x-%02x%02x-%02x%02x%02x%02x%02x%02x", objArr2));
                                        sb2.append(a(bArr5));
                                        sb2.append("; ");
                                        i15 += 16;
                                        c3 = 11;
                                    }
                                    a.a("     serv128: " + sb2.toString());
                                    i4 = i14;
                                    break;
                                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                                    int i17 = b2 - 1;
                                    byte[] bArr6 = new byte[i17];
                                    int i18 = i6;
                                    int i19 = 0;
                                    while (i19 < i17) {
                                        bArr6[i19] = bArr2[i];
                                        i19++;
                                        i18 = i + 1;
                                    }
                                    String str = new String(bArr6);
                                    aVar.k = str;
                                    a.a("     (*)name: ".concat(str));
                                    break;
                                case 9:
                                    int i20 = b2 - 1;
                                    byte[] bArr7 = new byte[i20];
                                    int i21 = i6;
                                    int i22 = 0;
                                    while (i22 < i20) {
                                        bArr7[i22] = bArr2[i];
                                        i22++;
                                        i21 = i + 1;
                                    }
                                    String str2 = new String(bArr7);
                                    aVar.j = str2;
                                    a.a("        name: ".concat(str2));
                                    break;
                                case 10:
                                    int i23 = b2 - 1;
                                    byte[] bArr8 = new byte[i23];
                                    int i24 = i6;
                                    int i25 = 0;
                                    while (i25 < i23) {
                                        bArr8[i25] = bArr2[i];
                                        i25++;
                                        i24 = i + 1;
                                    }
                                    String a3 = a(bArr8);
                                    aVar.l = a3;
                                    a.a("    tx level: ".concat(String.valueOf(a3)));
                                    break;
                                default:
                                    switch (b3) {
                                        case 20:
                                            StringBuilder sb3 = new StringBuilder();
                                            i2 = i6;
                                            int i26 = 0;
                                            while (i26 < b2 - 1) {
                                                byte[] bArr9 = new byte[2];
                                                int i27 = i2;
                                                int i28 = 0;
                                                while (i28 < 2) {
                                                    bArr9[i28] = bArr2[i27];
                                                    i28++;
                                                    i27++;
                                                }
                                                sb3.append(a(bArr9));
                                                sb3.append("; ");
                                                i26 += 2;
                                                i2 = i27;
                                            }
                                            aVar.h = sb3.toString();
                                            a.a("   solicit16: " + sb3.toString());
                                            break;
                                        case 21:
                                            StringBuilder sb4 = new StringBuilder();
                                            i = i6;
                                            int i29 = 0;
                                            while (i29 < b2 - 1) {
                                                byte[] bArr10 = new byte[16];
                                                int i30 = i;
                                                int i31 = 0;
                                                while (i31 < 16) {
                                                    bArr10[i31] = bArr2[i30];
                                                    i31++;
                                                    i30++;
                                                }
                                                sb4.append(a(bArr10));
                                                sb4.append("; ");
                                                i29 += 16;
                                                i = i30;
                                            }
                                            aVar.i = sb4.toString();
                                            a.a("  solicit128: " + sb4.toString());
                                            break;
                                        case 22:
                                            int i32 = b2 - 1;
                                            byte[] bArr11 = new byte[i32];
                                            int i33 = i6;
                                            int i34 = 0;
                                            while (i34 < i32) {
                                                bArr11[i34] = bArr2[i3];
                                                i34++;
                                                i33 = i3 + 1;
                                            }
                                            a(String.format("%02X%02X", Byte.valueOf(bArr11[1]), Byte.valueOf(bArr11[0])));
                                            i4 = i3;
                                            break;
                                        default:
                                            int i35 = b2 - 1;
                                            byte[] bArr12 = new byte[i35];
                                            i3 = i6;
                                            int i36 = 0;
                                            while (i36 < i35) {
                                                bArr12[i36] = bArr2[i3];
                                                i36++;
                                                i3++;
                                            }
                                            aVar.n = String.format("[0x%02x]", Byte.valueOf(b3)) + ": " + a(bArr12);
                                            a.a("      " + String.format("[0x%02x]", Byte.valueOf(b3)) + ": " + a(bArr12));
                                            i4 = i3;
                                            break;
                                    }
                            }
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            int i37 = i6;
                            int i38 = 0;
                            while (i38 < b2 - 1) {
                                byte[] bArr13 = new byte[2];
                                int i39 = i2;
                                int i40 = 0;
                                while (i40 < 2) {
                                    bArr13[i40] = bArr2[i39];
                                    i40++;
                                    i39++;
                                }
                                aVar.d.add(String.format("%02x%02x", Byte.valueOf(bArr13[1]), Byte.valueOf(bArr13[0])));
                                sb5.append(a(bArr13));
                                sb5.append("; ");
                                i38 += 2;
                                i37 = i39;
                            }
                            a.a("      serv16: " + sb5.toString());
                        }
                    } else {
                        StringBuilder sb6 = new StringBuilder();
                        int i41 = i6;
                        int i42 = 0;
                        while (i42 < b2 - 1) {
                            byte[] bArr14 = new byte[2];
                            int i43 = i2;
                            int i44 = 0;
                            while (i44 < 2) {
                                bArr14[i44] = bArr2[i43];
                                i44++;
                                i43++;
                            }
                            aVar.e.add(String.format("%02x%02x", Byte.valueOf(bArr14[1]), Byte.valueOf(bArr14[0])));
                            sb6.append(a(bArr14));
                            sb6.append("; ");
                            i42 += 2;
                            i41 = i43;
                        }
                        a.a("   (*)serv16: " + sb6.toString());
                    }
                    i4 = i2;
                } else {
                    a.b(b2 == 2);
                    i4 = i6 + 1;
                    byte b4 = bArr2[i6];
                    aVar.c = b4;
                    a.a("        flag: " + String.format("%02x", Byte.valueOf(b4)));
                }
                i4 = i;
            }
            return aVar;
        }
        return aVar;
    }

    public static int a(BluetoothGatt bluetoothGatt) {
        if (h == null) {
            try {
                Field declaredField = BluetoothGatt.class.getDeclaredField("mClientIf");
                h = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }
        try {
            return h.getInt(bluetoothGatt);
        } catch (IllegalAccessException | IllegalArgumentException e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    public static void a(BluetoothGattService bluetoothGattService) {
        StringBuilder sb = new StringBuilder();
        sb.append(bluetoothGattService.getType() == 0 ? "Primary" : "Secondary");
        sb.append(" service: ");
        sb.append(a(bluetoothGattService.getUuid()));
        a.a("GattUtils", sb.toString());
        for (BluetoothGattCharacteristic next : bluetoothGattService.getCharacteristics()) {
            a.a("GattUtils", "  Characteristic: " + a(next.getUuid()));
            a.a("GattUtils", "    - Properties: " + b(next.getProperties()));
            for (BluetoothGattDescriptor uuid : next.getDescriptors()) {
                a.a("GattUtils", "    Descriptor: " + a(uuid.getUuid()));
            }
        }
    }

    public static boolean a() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    public static byte[] c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    public static String d(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return sb.toString();
    }
}
