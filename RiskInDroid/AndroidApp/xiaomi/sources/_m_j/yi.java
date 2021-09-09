package _m_j;

import com.adobe.xmp.XMPException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class yi {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f2604O000000o;

    private static int O000000o(byte b) {
        if (b >= 48 && b <= 57) {
            return b - 48;
        }
        byte b2 = 65;
        if (b < 65 || b > 70) {
            b2 = 97;
            if (b < 97 || b > 102) {
                return -1;
            }
        }
        return (b - b2) + 10;
    }

    public void O000000o(yh yhVar, xu xuVar, xm xmVar) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.setLength(0);
            while (true) {
                char O00000Oo = (char) xmVar.O00000Oo();
                if (O00000Oo != 13 && O00000Oo != 10) {
                    sb.append(O00000Oo);
                }
            }
            if (sb.length() == 0 || sb.charAt(0) == '%') {
                int indexOf = sb.indexOf(":");
                if (indexOf != -1) {
                    str = sb.substring(0, indexOf).trim();
                    String trim = sb.substring(indexOf + 1).trim();
                    Integer num = yh.O0000OOo.get(str);
                    if (num != null) {
                        int intValue = num.intValue();
                        if (intValue == 8) {
                            yhVar.O000000o(8, trim.trim());
                            String[] split = trim.split(" ");
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            int i = 3;
                            int parseInt3 = Integer.parseInt(split[3]);
                            if (!yhVar.O000000o(28)) {
                                yhVar.O000000o(28, parseInt);
                            }
                            if (!yhVar.O000000o(29)) {
                                yhVar.O000000o(29, parseInt2);
                            }
                            if (!yhVar.O000000o(30)) {
                                yhVar.O000000o(30, parseInt3);
                            }
                            if (!yhVar.O000000o(31)) {
                                if (parseInt3 == 1) {
                                    i = 1;
                                } else if (!(parseInt3 == 2 || parseInt3 == 3 || parseInt3 == 4)) {
                                    i = 0;
                                }
                                if (i != 0) {
                                    yhVar.O000000o(31, i * parseInt * parseInt2);
                                }
                            }
                        } else if (intValue == 36) {
                            int i2 = this.f2604O000000o;
                            yhVar.O000000o(i2, yhVar.O0000o0(this.f2604O000000o) + " " + trim);
                        } else if (!yh.O0000O0o.containsKey(num) || yhVar.O000000o(num.intValue())) {
                            this.f2604O000000o = 0;
                        } else {
                            yhVar.O000000o(num.intValue(), trim);
                            this.f2604O000000o = num.intValue();
                        }
                        this.f2604O000000o = num.intValue();
                    }
                } else {
                    str = sb.toString().trim();
                }
                if (str.equals("%BeginPhotoshop")) {
                    byte[] O000000o2 = O000000o(xmVar);
                    if (O000000o2 != null) {
                        new agn();
                        agn.O000000o(new xl(O000000o2), O000000o2.length, xuVar);
                    }
                } else if (str.equals("%%BeginICCProfile")) {
                    byte[] O000000o3 = O000000o(xmVar);
                    if (O000000o3 != null) {
                        new acd().O000000o(new xc(O000000o3), xuVar);
                    }
                } else if (str.equals("%begin_xml_packet")) {
                    String str2 = new String(O000000o(xmVar, "<?xpacket end=\"w\"?>".getBytes()), xf.f2590O000000o);
                    new ahf();
                    ahe ahe = new ahe();
                    try {
                        ahe.O000000o(mp.O000000o(str2));
                    } catch (XMPException e) {
                        ahe.O000000o("Error processing XMP data: " + e.getMessage());
                    }
                    if (!ahe.O00000o0()) {
                        xuVar.O000000o(ahe);
                    }
                }
            } else {
                return;
            }
        }
    }

    private static byte[] O000000o(xm xmVar, byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        int i = 0;
        while (i != length) {
            byte O00000Oo = xmVar.O00000Oo();
            i = O00000Oo == bArr[i] ? i + 1 : 0;
            byteArrayOutputStream.write(O00000Oo);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] O000000o(xm xmVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = false;
        char c = 0;
        byte b = 0;
        int i = 0;
        while (!z) {
            b = xmVar.O00000Oo();
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        int O000000o2 = O000000o(b);
                        if (O000000o2 != -1) {
                            i = O000000o2 * 16;
                            c = 3;
                        } else if (b != 13 && b != 10) {
                            return null;
                        } else {
                            c = 0;
                        }
                    } else if (c == 3) {
                        int O000000o3 = O000000o(b);
                        if (O000000o3 == -1) {
                            return null;
                        }
                        byteArrayOutputStream.write(O000000o3 + i);
                    } else {
                        continue;
                    }
                } else if (b != 32) {
                    z = true;
                }
                c = 2;
            } else if (!(b == 10 || b == 13 || b == 32)) {
                if (b != 37) {
                    return null;
                }
                c = 1;
            }
        }
        while (b != 10) {
            b = xmVar.O00000Oo();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
