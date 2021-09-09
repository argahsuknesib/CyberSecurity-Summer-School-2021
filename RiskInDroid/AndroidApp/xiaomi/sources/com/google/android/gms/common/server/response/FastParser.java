package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FastParser<T extends FastJsonResponse> {
    private static final char[] zzwv = {'u', 'l', 'l'};
    private static final char[] zzww = {'r', 'u', 'e'};
    private static final char[] zzwx = {'r', 'u', 'e', '\"'};
    private static final char[] zzwy = {'a', 'l', 's', 'e'};
    private static final char[] zzwz = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zzxa = {10};
    private static final zza<Integer> zzxc = new zza();
    private static final zza<Long> zzxd = new zzb();
    private static final zza<Float> zzxe = new zzc();
    private static final zza<Double> zzxf = new zzd();
    private static final zza<Boolean> zzxg = new zze();
    private static final zza<String> zzxh = new zzf();
    private static final zza<BigInteger> zzxi = new zzg();
    private static final zza<BigDecimal> zzxj = new zzh();
    private final char[] zzwq = new char[1];
    private final char[] zzwr = new char[32];
    private final char[] zzws = new char[1024];
    private final StringBuilder zzwt = new StringBuilder(32);
    private final StringBuilder zzwu = new StringBuilder(1024);
    private final Stack<Integer> zzxb = new Stack<>();

    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super(str, th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    interface zza<O> {
        O zzh(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException;
    }

    private final int zza(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i;
        char zzj = zzj(bufferedReader);
        if (zzj == 0) {
            throw new ParseException("Unexpected EOF");
        } else if (zzj == ',') {
            throw new ParseException("Missing value");
        } else if (zzj == 'n') {
            zzb(bufferedReader, zzwv);
            return 0;
        } else {
            bufferedReader.mark(1024);
            if (zzj == '\"') {
                i = 0;
                boolean z = false;
                while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                    char c = cArr[i];
                    if (Character.isISOControl(c)) {
                        throw new ParseException("Unexpected control character while reading string");
                    } else if (c != '\"' || z) {
                        z = c == '\\' ? !z : false;
                        i++;
                    } else {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i + 1));
                        return i;
                    }
                }
            } else {
                cArr[0] = zzj;
                int i2 = 1;
                while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                    if (cArr[i] == '}' || cArr[i] == ',' || Character.isWhitespace(cArr[i]) || cArr[i] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i - 1));
                        cArr[i] = 0;
                        return i;
                    }
                    i2 = i + 1;
                }
            }
            if (i == cArr.length) {
                throw new ParseException("Absurdly long value");
            }
            throw new ParseException("Unexpected EOF");
        }
    }

    private final String zza(BufferedReader bufferedReader) throws ParseException, IOException {
        this.zzxb.push(2);
        char zzj = zzj(bufferedReader);
        if (zzj == '\"') {
            this.zzxb.push(3);
            String zzb = zzb(bufferedReader, this.zzwr, this.zzwt, null);
            zzk(3);
            if (zzj(bufferedReader) == ':') {
                return zzb;
            }
            throw new ParseException("Expected key/value separator");
        } else if (zzj == ']') {
            zzk(2);
            zzk(1);
            zzk(5);
            return null;
        } else if (zzj == '}') {
            zzk(2);
            return null;
        } else {
            StringBuilder sb = new StringBuilder(19);
            sb.append("Unexpected token: ");
            sb.append(zzj);
            throw new ParseException(sb.toString());
        }
    }

    private final String zza(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        char zzj = zzj(bufferedReader);
        if (zzj == '\"') {
            return zzb(bufferedReader, cArr, sb, cArr2);
        }
        if (zzj == 'n') {
            zzb(bufferedReader, zzwv);
            return null;
        }
        throw new ParseException("Expected string");
    }

    private final <T extends FastJsonResponse> ArrayList<T> zza(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) throws ParseException, IOException {
        ArrayList<T> arrayList = new ArrayList<>();
        char zzj = zzj(bufferedReader);
        if (zzj == ']') {
            zzk(5);
            return arrayList;
        } else if (zzj == 'n') {
            zzb(bufferedReader, zzwv);
            zzk(5);
            return null;
        } else if (zzj == '{') {
            Stack<Integer> stack = this.zzxb;
            while (true) {
                stack.push(1);
                try {
                    FastJsonResponse newConcreteTypeInstance = field.newConcreteTypeInstance();
                    if (!zza(bufferedReader, newConcreteTypeInstance)) {
                        return arrayList;
                    }
                    arrayList.add(newConcreteTypeInstance);
                    char zzj2 = zzj(bufferedReader);
                    if (zzj2 != ',') {
                        if (zzj2 == ']') {
                            zzk(5);
                            return arrayList;
                        }
                        StringBuilder sb = new StringBuilder(19);
                        sb.append("Unexpected token: ");
                        sb.append(zzj2);
                        throw new ParseException(sb.toString());
                    } else if (zzj(bufferedReader) == '{') {
                        stack = this.zzxb;
                    } else {
                        throw new ParseException("Expected start of next object in array");
                    }
                } catch (InstantiationException e) {
                    throw new ParseException("Error instantiating inner object", e);
                } catch (IllegalAccessException e2) {
                    throw new ParseException("Error instantiating inner object", e2);
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append("Unexpected token: ");
            sb2.append(zzj);
            throw new ParseException(sb2.toString());
        }
    }

    private final <O> ArrayList<O> zza(BufferedReader bufferedReader, zza<O> zza2) throws ParseException, IOException {
        char zzj = zzj(bufferedReader);
        if (zzj == 'n') {
            zzb(bufferedReader, zzwv);
            return null;
        } else if (zzj == '[') {
            this.zzxb.push(5);
            ArrayList<O> arrayList = new ArrayList<>();
            while (true) {
                bufferedReader.mark(1024);
                char zzj2 = zzj(bufferedReader);
                if (zzj2 == 0) {
                    throw new ParseException("Unexpected EOF");
                } else if (zzj2 != ',') {
                    if (zzj2 != ']') {
                        bufferedReader.reset();
                        arrayList.add(zza2.zzh(this, bufferedReader));
                    } else {
                        zzk(5);
                        return arrayList;
                    }
                }
            }
        } else {
            throw new ParseException("Expected start of array");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.common.server.response.FastParser.zza(java.io.BufferedReader, boolean):boolean
     arg types: [java.io.BufferedReader, int]
     candidates:
      com.google.android.gms.common.server.response.FastParser.zza(com.google.android.gms.common.server.response.FastParser, java.io.BufferedReader):int
      com.google.android.gms.common.server.response.FastParser.zza(java.io.BufferedReader, char[]):int
      com.google.android.gms.common.server.response.FastParser.zza(java.io.BufferedReader, com.google.android.gms.common.server.response.FastJsonResponse$Field<?, ?>):java.util.ArrayList<T>
      com.google.android.gms.common.server.response.FastParser.zza(java.io.BufferedReader, com.google.android.gms.common.server.response.FastParser$zza):java.util.ArrayList<O>
      com.google.android.gms.common.server.response.FastParser.zza(java.io.BufferedReader, com.google.android.gms.common.server.response.FastJsonResponse):boolean
      com.google.android.gms.common.server.response.FastParser.zza(java.io.BufferedReader, boolean):boolean */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02b7  */
    private final boolean zza(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        int i;
        char zzj;
        HashMap hashMap;
        BufferedReader bufferedReader2 = bufferedReader;
        FastJsonResponse fastJsonResponse2 = fastJsonResponse;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String zza2 = zza(bufferedReader);
        if (zza2 == null) {
            zzk(1);
            return false;
        }
        while (zza2 != null) {
            FastJsonResponse.Field field = fieldMappings.get(zza2);
            if (field == null) {
                zza2 = zzb(bufferedReader);
            } else {
                this.zzxb.push(4);
                switch (field.getTypeIn()) {
                    case 0:
                        if (field.isTypeInArray()) {
                            fastJsonResponse2.setIntegers(field, zza(bufferedReader2, zzxc));
                        } else {
                            fastJsonResponse2.setInteger(field, zzd(bufferedReader));
                        }
                        i = 4;
                        zzk(i);
                        zzk(2);
                        zzj = zzj(bufferedReader);
                        if (zzj == ',') {
                            zza2 = zza(bufferedReader);
                            break;
                        } else if (zzj == '}') {
                            zza2 = null;
                            break;
                        } else {
                            StringBuilder sb = new StringBuilder(55);
                            sb.append("Expected end of object or field separator, but found: ");
                            sb.append(zzj);
                            throw new ParseException(sb.toString());
                        }
                    case 1:
                        if (field.isTypeInArray()) {
                            fastJsonResponse2.setBigIntegers(field, zza(bufferedReader2, zzxi));
                        } else {
                            fastJsonResponse2.setBigInteger(field, zzf(bufferedReader));
                        }
                        i = 4;
                        zzk(i);
                        zzk(2);
                        zzj = zzj(bufferedReader);
                        if (zzj == ',') {
                        }
                        break;
                    case 2:
                        if (field.isTypeInArray()) {
                            fastJsonResponse2.setLongs(field, zza(bufferedReader2, zzxd));
                        } else {
                            fastJsonResponse2.setLong(field, zze(bufferedReader));
                        }
                        i = 4;
                        zzk(i);
                        zzk(2);
                        zzj = zzj(bufferedReader);
                        if (zzj == ',') {
                        }
                        break;
                    case 3:
                        if (field.isTypeInArray()) {
                            fastJsonResponse2.setFloats(field, zza(bufferedReader2, zzxe));
                        } else {
                            fastJsonResponse2.setFloat(field, zzg(bufferedReader));
                        }
                        i = 4;
                        zzk(i);
                        zzk(2);
                        zzj = zzj(bufferedReader);
                        if (zzj == ',') {
                        }
                        break;
                    case 4:
                        if (field.isTypeInArray()) {
                            fastJsonResponse2.setDoubles(field, zza(bufferedReader2, zzxf));
                        } else {
                            fastJsonResponse2.setDouble(field, zzh(bufferedReader));
                        }
                        i = 4;
                        zzk(i);
                        zzk(2);
                        zzj = zzj(bufferedReader);
                        if (zzj == ',') {
                        }
                        break;
                    case 5:
                        if (field.isTypeInArray()) {
                            fastJsonResponse2.setBigDecimals(field, zza(bufferedReader2, zzxj));
                        } else {
                            fastJsonResponse2.setBigDecimal(field, zzi(bufferedReader));
                        }
                        i = 4;
                        zzk(i);
                        zzk(2);
                        zzj = zzj(bufferedReader);
                        if (zzj == ',') {
                        }
                        break;
                    case 6:
                        if (field.isTypeInArray()) {
                            fastJsonResponse2.setBooleans(field, zza(bufferedReader2, zzxg));
                            i = 4;
                            zzk(i);
                            zzk(2);
                            zzj = zzj(bufferedReader);
                            if (zzj == ',') {
                            }
                        } else {
                            fastJsonResponse2.setBoolean(field, zza(bufferedReader2, false));
                            i = 4;
                            zzk(i);
                            zzk(2);
                            zzj = zzj(bufferedReader);
                            if (zzj == ',') {
                            }
                        }
                        break;
                    case 7:
                        if (field.isTypeInArray()) {
                            fastJsonResponse2.setStrings(field, zza(bufferedReader2, zzxh));
                        } else {
                            fastJsonResponse2.setString(field, zzc(bufferedReader));
                        }
                        i = 4;
                        zzk(i);
                        zzk(2);
                        zzj = zzj(bufferedReader);
                        if (zzj == ',') {
                        }
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        fastJsonResponse2.setDecodedBytes(field, Base64Utils.decode(zza(bufferedReader2, this.zzws, this.zzwu, zzxa)));
                        i = 4;
                        zzk(i);
                        zzk(2);
                        zzj = zzj(bufferedReader);
                        if (zzj == ',') {
                        }
                        break;
                    case 9:
                        fastJsonResponse2.setDecodedBytes(field, Base64Utils.decodeUrlSafe(zza(bufferedReader2, this.zzws, this.zzwu, zzxa)));
                        i = 4;
                        zzk(i);
                        zzk(2);
                        zzj = zzj(bufferedReader);
                        if (zzj == ',') {
                        }
                        break;
                    case 10:
                        char zzj2 = zzj(bufferedReader);
                        if (zzj2 == 'n') {
                            zzb(bufferedReader2, zzwv);
                            hashMap = null;
                        } else if (zzj2 == '{') {
                            this.zzxb.push(1);
                            hashMap = new HashMap();
                            while (true) {
                                char zzj3 = zzj(bufferedReader);
                                if (zzj3 == 0) {
                                    throw new ParseException("Unexpected EOF");
                                } else if (zzj3 == '\"') {
                                    String zzb = zzb(bufferedReader2, this.zzwr, this.zzwt, null);
                                    if (zzj(bufferedReader) != ':') {
                                        String valueOf = String.valueOf(zzb);
                                        throw new ParseException(valueOf.length() != 0 ? "No map value found for key ".concat(valueOf) : new String("No map value found for key "));
                                    } else if (zzj(bufferedReader) != '\"') {
                                        String valueOf2 = String.valueOf(zzb);
                                        throw new ParseException(valueOf2.length() != 0 ? "Expected String value for key ".concat(valueOf2) : new String("Expected String value for key "));
                                    } else {
                                        hashMap.put(zzb, zzb(bufferedReader2, this.zzwr, this.zzwt, null));
                                        char zzj4 = zzj(bufferedReader);
                                        if (zzj4 != ',') {
                                            if (zzj4 != '}') {
                                                StringBuilder sb2 = new StringBuilder(48);
                                                sb2.append("Unexpected character while parsing string map: ");
                                                sb2.append(zzj4);
                                                throw new ParseException(sb2.toString());
                                            }
                                        }
                                    }
                                } else if (zzj3 != '}') {
                                }
                            }
                            zzk(1);
                        } else {
                            throw new ParseException("Expected start of a map object");
                        }
                        fastJsonResponse2.setStringMap(field, hashMap);
                        i = 4;
                        zzk(i);
                        zzk(2);
                        zzj = zzj(bufferedReader);
                        if (zzj == ',') {
                        }
                        break;
                    case 11:
                        if (field.isTypeInArray()) {
                            char zzj5 = zzj(bufferedReader);
                            if (zzj5 == 'n') {
                                zzb(bufferedReader2, zzwv);
                                fastJsonResponse2.addConcreteTypeArrayInternal(field, field.getOutputFieldName(), null);
                            } else {
                                this.zzxb.push(5);
                                if (zzj5 == '[') {
                                    fastJsonResponse2.addConcreteTypeArrayInternal(field, field.getOutputFieldName(), zza(bufferedReader2, field));
                                } else {
                                    throw new ParseException("Expected array start");
                                }
                            }
                        } else {
                            char zzj6 = zzj(bufferedReader);
                            if (zzj6 == 'n') {
                                zzb(bufferedReader2, zzwv);
                                fastJsonResponse2.addConcreteTypeInternal(field, field.getOutputFieldName(), null);
                            } else {
                                this.zzxb.push(1);
                                if (zzj6 == '{') {
                                    try {
                                        FastJsonResponse newConcreteTypeInstance = field.newConcreteTypeInstance();
                                        zza(bufferedReader2, newConcreteTypeInstance);
                                        fastJsonResponse2.addConcreteTypeInternal(field, field.getOutputFieldName(), newConcreteTypeInstance);
                                    } catch (InstantiationException e) {
                                        throw new ParseException("Error instantiating inner object", e);
                                    } catch (IllegalAccessException e2) {
                                        throw new ParseException("Error instantiating inner object", e2);
                                    }
                                } else {
                                    throw new ParseException("Expected start of object");
                                }
                            }
                        }
                        i = 4;
                        zzk(i);
                        zzk(2);
                        zzj = zzj(bufferedReader);
                        if (zzj == ',') {
                        }
                        break;
                    default:
                        int typeIn = field.getTypeIn();
                        StringBuilder sb3 = new StringBuilder(30);
                        sb3.append("Invalid field type ");
                        sb3.append(typeIn);
                        throw new ParseException(sb3.toString());
                }
            }
        }
        PostProcessor<? extends FastJsonResponse> postProcessor = fastJsonResponse.getPostProcessor();
        if (postProcessor != null) {
            postProcessor.postProcess(fastJsonResponse2);
        }
        zzk(1);
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean zza(BufferedReader bufferedReader, boolean z) throws ParseException, IOException {
        while (true) {
            char zzj = zzj(bufferedReader);
            if (zzj != '\"') {
                if (zzj == 'f') {
                    zzb(bufferedReader, z ? zzwz : zzwy);
                    return false;
                } else if (zzj == 'n') {
                    zzb(bufferedReader, zzwv);
                    return false;
                } else if (zzj == 't') {
                    zzb(bufferedReader, z ? zzwx : zzww);
                    return true;
                } else {
                    StringBuilder sb = new StringBuilder(19);
                    sb.append("Unexpected token: ");
                    sb.append(zzj);
                    throw new ParseException(sb.toString());
                }
            } else if (!z) {
                z = true;
            } else {
                throw new ParseException("No boolean value found in string");
            }
        }
    }

    private final String zzb(BufferedReader bufferedReader) throws ParseException, IOException {
        BufferedReader bufferedReader2 = bufferedReader;
        bufferedReader2.mark(1024);
        char zzj = zzj(bufferedReader);
        if (zzj != '\"') {
            if (zzj != ',') {
                int i = 1;
                if (zzj == '[') {
                    this.zzxb.push(5);
                    bufferedReader2.mark(32);
                    if (zzj(bufferedReader) != ']') {
                        bufferedReader.reset();
                        boolean z = false;
                        boolean z2 = false;
                        while (i > 0) {
                            char zzj2 = zzj(bufferedReader);
                            if (zzj2 == 0) {
                                throw new ParseException("Unexpected EOF while parsing array");
                            } else if (!Character.isISOControl(zzj2)) {
                                if (zzj2 == '\"' && !z) {
                                    z2 = !z2;
                                }
                                if (zzj2 == '[' && !z2) {
                                    i++;
                                }
                                if (zzj2 == ']' && !z2) {
                                    i--;
                                }
                                z = (zzj2 != '\\' || !z2) ? false : !z;
                            } else {
                                throw new ParseException("Unexpected control character while reading array");
                            }
                        }
                    }
                    zzk(5);
                } else if (zzj != '{') {
                    bufferedReader.reset();
                    zza(bufferedReader2, this.zzws);
                } else {
                    this.zzxb.push(1);
                    bufferedReader2.mark(32);
                    char zzj3 = zzj(bufferedReader);
                    if (zzj3 != '}') {
                        if (zzj3 == '\"') {
                            bufferedReader.reset();
                            zza(bufferedReader);
                            do {
                            } while (zzb(bufferedReader) != null);
                        } else {
                            StringBuilder sb = new StringBuilder(18);
                            sb.append("Unexpected token ");
                            sb.append(zzj3);
                            throw new ParseException(sb.toString());
                        }
                    }
                    zzk(1);
                }
            } else {
                throw new ParseException("Missing value");
            }
        } else if (bufferedReader2.read(this.zzwq) != -1) {
            char c = this.zzwq[0];
            boolean z3 = false;
            do {
                if (c != '\"' || z3) {
                    z3 = c == '\\' ? !z3 : false;
                    if (bufferedReader2.read(this.zzwq) != -1) {
                        c = this.zzwq[0];
                    } else {
                        throw new ParseException("Unexpected EOF while parsing string");
                    }
                }
            } while (!Character.isISOControl(c));
            throw new ParseException("Unexpected control character while reading string");
        } else {
            throw new ParseException("Unexpected EOF while parsing string");
        }
        char zzj4 = zzj(bufferedReader);
        if (zzj4 == ',') {
            zzk(2);
            return zza(bufferedReader);
        } else if (zzj4 == '}') {
            zzk(2);
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder(18);
            sb2.append("Unexpected token ");
            sb2.append(zzj4);
            throw new ParseException(sb2.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0032 A[SYNTHETIC] */
    private static String zzb(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        boolean z;
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                boolean z4 = z3;
                boolean z5 = z2;
                int i = 0;
                while (i < read) {
                    char c = cArr[i];
                    if (Character.isISOControl(c)) {
                        if (cArr2 != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= cArr2.length) {
                                    break;
                                } else if (cArr2[i2] == c) {
                                    z = true;
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            if (!z) {
                                throw new ParseException("Unexpected control character while reading string");
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                    if (c != '\"' || z5) {
                        if (c == '\\') {
                            z5 = !z5;
                            z4 = true;
                        } else {
                            z5 = false;
                        }
                        i++;
                    } else {
                        sb.append(cArr, 0, i);
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i + 1));
                        return z4 ? JsonUtils.unescapeString(sb.toString()) : sb.toString();
                    }
                }
                sb.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
                z2 = z5;
                z3 = z4;
            } else {
                throw new ParseException("Unexpected EOF while parsing string");
            }
        }
    }

    private final void zzb(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i = 0;
        while (i < cArr.length) {
            int read = bufferedReader.read(this.zzwr, 0, cArr.length - i);
            if (read != -1) {
                int i2 = 0;
                while (i2 < read) {
                    if (cArr[i2 + i] == this.zzwr[i2]) {
                        i2++;
                    } else {
                        throw new ParseException("Unexpected character");
                    }
                }
                i += read;
            } else {
                throw new ParseException("Unexpected EOF");
            }
        }
    }

    /* access modifiers changed from: private */
    public final String zzc(BufferedReader bufferedReader) throws ParseException, IOException {
        return zza(bufferedReader, this.zzwr, this.zzwt, null);
    }

    /* access modifiers changed from: private */
    public final int zzd(BufferedReader bufferedReader) throws ParseException, IOException {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            return 0;
        }
        char[] cArr = this.zzws;
        if (zza2 > 0) {
            if (cArr[0] == '-') {
                i2 = 1;
                i = Integer.MIN_VALUE;
                z = true;
            } else {
                i2 = 0;
                i = -2147483647;
                z = false;
            }
            if (i2 < zza2) {
                i4 = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit >= 0) {
                    i3 = -digit;
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                i4 = i2;
                i3 = 0;
            }
            while (i4 < zza2) {
                int i5 = i4 + 1;
                int digit2 = Character.digit(cArr[i4], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (i3 >= -214748364) {
                    int i6 = i3 * 10;
                    if (i6 >= i + digit2) {
                        i3 = i6 - digit2;
                        i4 = i5;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (!z) {
                return -i3;
            }
            if (i4 > 1) {
                return i3;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    /* access modifiers changed from: private */
    public final long zze(BufferedReader bufferedReader) throws ParseException, IOException {
        long j;
        boolean z;
        long j2;
        int i;
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            return 0;
        }
        char[] cArr = this.zzws;
        if (zza2 > 0) {
            int i2 = 0;
            if (cArr[0] == '-') {
                j = Long.MIN_VALUE;
                i2 = 1;
                z = true;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            if (i2 < zza2) {
                i = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit >= 0) {
                    j2 = (long) (-digit);
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                j2 = 0;
                i = i2;
            }
            while (i < zza2) {
                int i3 = i + 1;
                int digit2 = Character.digit(cArr[i], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (j2 >= -922337203685477580L) {
                    long j3 = j2 * 10;
                    long j4 = (long) digit2;
                    if (j3 >= j + j4) {
                        j2 = j3 - j4;
                        i = i3;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (!z) {
                return -j2;
            }
            if (i > 1) {
                return j2;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    /* access modifiers changed from: private */
    public final BigInteger zzf(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zzws, 0, zza2));
    }

    /* access modifiers changed from: private */
    public final float zzg(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zzws, 0, zza2));
    }

    /* access modifiers changed from: private */
    public final double zzh(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zzws, 0, zza2));
    }

    /* access modifiers changed from: private */
    public final BigDecimal zzi(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zzws, 0, zza2));
    }

    private final char zzj(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.zzwq) == -1) {
            return 0;
        }
        while (Character.isWhitespace(this.zzwq[0])) {
            if (bufferedReader.read(this.zzwq) == -1) {
                return 0;
            }
        }
        return this.zzwq[0];
    }

    private final void zzk(int i) throws ParseException {
        if (!this.zzxb.isEmpty()) {
            int intValue = this.zzxb.pop().intValue();
            if (intValue != i) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Expected state ");
                sb.append(i);
                sb.append(" but had ");
                sb.append(intValue);
                throw new ParseException(sb.toString());
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Expected state ");
        sb2.append(i);
        sb2.append(" but had empty stack");
        throw new ParseException(sb2.toString());
    }

    public void parse(InputStream inputStream, FastJsonResponse fastJsonResponse) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            this.zzxb.push(0);
            char zzj = zzj(bufferedReader);
            if (zzj != 0) {
                if (zzj == '[') {
                    this.zzxb.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
                    if (fieldMappings.size() == 1) {
                        FastJsonResponse.Field field = (FastJsonResponse.Field) fieldMappings.entrySet().iterator().next().getValue();
                        fastJsonResponse.addConcreteTypeArrayInternal(field, field.getOutputFieldName(), zza(bufferedReader, field));
                    } else {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                } else if (zzj == '{') {
                    this.zzxb.push(1);
                    zza(bufferedReader, fastJsonResponse);
                } else {
                    StringBuilder sb = new StringBuilder(19);
                    sb.append("Unexpected token: ");
                    sb.append(zzj);
                    throw new ParseException(sb.toString());
                }
                zzk(0);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                    Log.w("FastParser", "Failed to close reader while parsing.");
                }
            } else {
                throw new ParseException("No data to parse");
            }
        } catch (IOException e) {
            throw new ParseException(e);
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }

    public void parse(String str, FastJsonResponse fastJsonResponse) throws ParseException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        try {
            parse(byteArrayInputStream, fastJsonResponse);
            try {
                byteArrayInputStream.close();
            } catch (IOException unused) {
                Log.w("FastParser", "Failed to close the input stream while parsing.");
            }
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close the input stream while parsing.");
            }
            throw th;
        }
    }
}
