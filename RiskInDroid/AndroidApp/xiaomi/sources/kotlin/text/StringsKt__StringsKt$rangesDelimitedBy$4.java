package kotlin.text;

import _m_j.iuf;
import _m_j.iwn;
import _m_j.ixe;
import _m_j.ixp;
import _m_j.ixr;
import _m_j.iyo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k = 3, mv = {1, 1, 13})
public final class StringsKt__StringsKt$rangesDelimitedBy$4 extends Lambda implements iwn<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ List $delimitersList;
    final /* synthetic */ boolean $ignoreCase = false;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$4(List list, boolean z) {
        super(2);
        this.$delimitersList = list;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.String, int, boolean, int):int
     arg types: [java.lang.CharSequence, java.lang.String, int, int, int]
     candidates:
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, int, int, boolean):boolean
      _m_j.iyw.O000000o(java.lang.String, java.lang.String, int, int, boolean):boolean
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.String, int, boolean, int):int */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0133 A[RETURN] */
    public final /* synthetic */ Object invoke(Object obj, Object obj2) {
        Pair pair;
        Object obj3;
        Object obj4;
        Object obj5;
        CharSequence charSequence = (CharSequence) obj;
        int intValue = ((Number) obj2).intValue();
        ixe.O00000o0(charSequence, "receiver$0");
        Collection collection = this.$delimitersList;
        boolean z = this.$ignoreCase;
        if (z || collection.size() != 1) {
            if (intValue < 0) {
                intValue = 0;
            }
            ixp ixr = new ixr(intValue, charSequence.length());
            if (charSequence instanceof String) {
                int i = ixr.f1645O000000o;
                int i2 = ixr.O00000Oo;
                int i3 = ixr.O00000o0;
                if (i3 <= 0 ? i >= i2 : i <= i2) {
                    while (true) {
                        Iterator it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj4 = null;
                                break;
                            }
                            obj4 = it.next();
                            String str = (String) obj4;
                            if (iyo.O000000o(str, (String) charSequence, i, str.length(), z)) {
                                break;
                            }
                        }
                        String str2 = (String) obj4;
                        if (str2 == null) {
                            if (i == i2) {
                                break;
                            }
                            i += i3;
                        } else {
                            pair = iuf.O000000o(Integer.valueOf(i), str2);
                            break;
                        }
                    }
                    if (pair == null) {
                        return iuf.O000000o(pair.first, Integer.valueOf(((String) pair.second).length()));
                    }
                    return null;
                }
            } else {
                int i4 = ixr.f1645O000000o;
                int i5 = ixr.O00000Oo;
                int i6 = ixr.O00000o0;
                if (i6 <= 0 ? i4 >= i5 : i4 <= i5) {
                    while (true) {
                        Iterator it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj3 = null;
                                break;
                            }
                            obj3 = it2.next();
                            String str3 = (String) obj3;
                            if (iyo.O000000o(str3, charSequence, i4, str3.length(), z)) {
                                break;
                            }
                        }
                        String str4 = (String) obj3;
                        if (str4 == null) {
                            if (i4 == i5) {
                                break;
                            }
                            i4 += i6;
                        } else {
                            pair = iuf.O000000o(Integer.valueOf(i4), str4);
                            break;
                        }
                    }
                    if (pair == null) {
                    }
                }
            }
        } else {
            Iterable iterable = collection;
            ixe.O00000o0(iterable, "receiver$0");
            if (iterable instanceof List) {
                List list = (List) iterable;
                ixe.O00000o0(list, "receiver$0");
                int size = list.size();
                if (size == 0) {
                    throw new NoSuchElementException("List is empty.");
                } else if (size == 1) {
                    obj5 = list.get(0);
                } else {
                    throw new IllegalArgumentException("List has more than one element.");
                }
            } else {
                Iterator it3 = iterable.iterator();
                if (it3.hasNext()) {
                    Object next = it3.next();
                    if (!it3.hasNext()) {
                        obj5 = next;
                    } else {
                        throw new IllegalArgumentException("Collection has more than one element.");
                    }
                } else {
                    throw new NoSuchElementException("Collection is empty.");
                }
            }
            String str5 = (String) obj5;
            int O000000o2 = iyo.O000000o(charSequence, str5, intValue, false, 4);
            if (O000000o2 >= 0) {
                pair = iuf.O000000o(Integer.valueOf(O000000o2), str5);
                if (pair == null) {
                }
            }
        }
        pair = null;
        if (pair == null) {
        }
    }
}
