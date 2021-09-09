package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class bgm implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bgm f12953O000000o = new bgm();

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bhu.O000000o(long, char):void
     arg types: [long, int]
     candidates:
      _m_j.bhu.O000000o(int, char):void
      _m_j.bhu.O000000o(java.lang.String, boolean):void
      _m_j.bhu.O000000o(long, char):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bhu.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.bhu.O000000o(int, char):void
      _m_j.bhu.O000000o(long, char):void
      _m_j.bhu.O000000o(java.lang.String, boolean):void */
    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        char[] cArr;
        bhc bhc2 = bhc;
        bhu bhu = bhc2.f12968O000000o;
        if (obj == null) {
            bhu.write("null");
        } else if (!bhu.O000000o(SerializerFeature.WriteClassName) || obj.getClass() == type) {
            Date date = (Date) obj;
            if (bhu.O000000o(SerializerFeature.WriteDateUseDateFormat)) {
                DateFormat O000000o2 = bhc.O000000o();
                if (O000000o2 == null) {
                    O000000o2 = new SimpleDateFormat(bdf.O00000o0);
                }
                bhu.O000000o(O000000o2.format(date));
                return;
            }
            long time = date.getTime();
            if (bhc2.O000000o(SerializerFeature.UseISO8601DateFormat)) {
                if (bhc2.O000000o(SerializerFeature.UseSingleQuotes)) {
                    bhu.O00000Oo('\'');
                } else {
                    bhu.O00000Oo('\"');
                }
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(time);
                int i = instance.get(1);
                int i2 = instance.get(2) + 1;
                int i3 = instance.get(5);
                int i4 = instance.get(11);
                int i5 = instance.get(12);
                int i6 = instance.get(13);
                int i7 = instance.get(14);
                if (i7 != 0) {
                    cArr = "0000-00-00T00:00:00.000".toCharArray();
                    bie.O000000o(i7, 23, cArr);
                    bie.O000000o(i6, 19, cArr);
                    bie.O000000o(i5, 16, cArr);
                    bie.O000000o(i4, 13, cArr);
                    bie.O000000o(i3, 10, cArr);
                    bie.O000000o(i2, 7, cArr);
                    bie.O000000o(i, 4, cArr);
                } else if (i6 == 0 && i5 == 0 && i4 == 0) {
                    cArr = "0000-00-00".toCharArray();
                    bie.O000000o(i3, 10, cArr);
                    bie.O000000o(i2, 7, cArr);
                    bie.O000000o(i, 4, cArr);
                } else {
                    cArr = "0000-00-00T00:00:00".toCharArray();
                    bie.O000000o(i6, 19, cArr);
                    bie.O000000o(i5, 16, cArr);
                    bie.O000000o(i4, 13, cArr);
                    bie.O000000o(i3, 10, cArr);
                    bie.O000000o(i2, 7, cArr);
                    bie.O000000o(i, 4, cArr);
                }
                bhu.write(cArr);
                if (bhc2.O000000o(SerializerFeature.UseSingleQuotes)) {
                    bhu.O00000Oo('\'');
                } else {
                    bhu.O00000Oo('\"');
                }
            } else {
                bhu.O000000o(time);
            }
        } else if (obj.getClass() == Date.class) {
            bhu.write("new Date(");
            bhu.O000000o(((Date) obj).getTime(), ')');
        } else {
            bhu.O000000o('{');
            bhu.O000000o(bdf.f12884O000000o, false);
            bhc2.O000000o(obj.getClass().getName());
            bhu.O000000o(',');
            bhu.O000000o("val", false);
            bhu.O000000o(((Date) obj).getTime());
            bhu.O000000o('}');
        }
    }
}
