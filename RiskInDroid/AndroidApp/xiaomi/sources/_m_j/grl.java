package _m_j;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.library.common.widget.sectionedrecyclerviewadapter.Section;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public final class grl extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

    /* renamed from: O000000o  reason: collision with root package name */
    public LinkedHashMap<String, Section> f18182O000000o = new LinkedHashMap<>();
    private HashMap<String, Integer> O00000Oo = new HashMap<>();
    private int O00000o0 = 0;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        O000000o o000000o;
        RecyclerView.O000OOo0 o000OOo0 = null;
        for (Map.Entry next : this.O00000Oo.entrySet()) {
            if (i >= ((Integer) next.getValue()).intValue() && i < ((Integer) next.getValue()).intValue() + 6) {
                Section section = this.f18182O000000o.get(next.getKey());
                int intValue = i - ((Integer) next.getValue()).intValue();
                if (intValue != 0) {
                    if (intValue == 1) {
                        Integer num = section.O0000Oo0;
                        if (num != null) {
                            o000000o = new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(num.intValue(), viewGroup, false));
                        } else {
                            throw new NullPointerException("Missing 'footer' resource id");
                        }
                    } else if (intValue == 2) {
                        o000OOo0 = section.O00000Oo(LayoutInflater.from(viewGroup.getContext()).inflate(section.O0000Oo, viewGroup, false));
                    } else if (intValue == 3) {
                        Integer num2 = section.O0000OoO;
                        if (num2 != null) {
                            o000000o = new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(num2.intValue(), viewGroup, false));
                        } else {
                            throw new NullPointerException("Missing 'loading state' resource id");
                        }
                    } else if (intValue == 4) {
                        Integer num3 = section.O0000Ooo;
                        if (num3 != null) {
                            o000000o = new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(num3.intValue(), viewGroup, false));
                        } else {
                            throw new NullPointerException("Missing 'failed state' resource id");
                        }
                    } else if (intValue == 5) {
                        Integer num4 = section.O0000o00;
                        if (num4 != null) {
                            o000000o = new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(num4.intValue(), viewGroup, false));
                        } else {
                            throw new NullPointerException("Missing 'empty state' resource id");
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid viewType");
                    }
                    o000OOo0 = o000000o;
                } else {
                    Integer num5 = section.O0000OOo;
                    if (num5 != null) {
                        o000OOo0 = section.O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(num5.intValue(), viewGroup, false));
                    } else {
                        throw new NullPointerException("Missing 'header' resource id");
                    }
                }
            }
        }
        return o000OOo0;
    }

    private void O000000o(String str, Section section) {
        this.f18182O000000o.put(str, section);
        this.O00000Oo.put(str, Integer.valueOf(this.O00000o0));
        this.O00000o0 += 6;
    }

    public final String O000000o(Section section) {
        String uuid = UUID.randomUUID().toString();
        O000000o(uuid, section);
        return uuid;
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        int i2;
        int i3 = 0;
        int i4 = 0;
        for (Map.Entry<String, Section> value : this.f18182O000000o.entrySet()) {
            Section section = (Section) value.getValue();
            if (section.O00000oO) {
                int O00000Oo2 = section.O00000Oo();
                if (i < i4 || i > (i2 = (i4 + O00000Oo2) - 1)) {
                    i4 += O00000Oo2;
                } else if (section.O00000oo && i == i4) {
                    O000000o(i).O000000o(o000OOo0);
                    return;
                } else if (!section.O0000O0o || i != i2) {
                    Section O000000o2 = O000000o(i);
                    for (Map.Entry<String, Section> value2 : this.f18182O000000o.entrySet()) {
                        Section section2 = (Section) value2.getValue();
                        if (section2.O00000oO) {
                            int O00000Oo3 = section2.O00000Oo();
                            if (i < i3 || i > (i3 + O00000Oo3) - 1) {
                                i3 += O00000Oo3;
                            } else {
                                int i5 = (i - i3) - (section2.O00000oo ? 1 : 0);
                                int i6 = Section.AnonymousClass1.f9327O000000o[O000000o2.O00000o.ordinal()];
                                if (i6 != 1 && i6 != 2 && i6 != 3) {
                                    if (i6 == 4) {
                                        O000000o2.O000000o(o000OOo0, i5);
                                        return;
                                    }
                                    throw new IllegalStateException("Invalid state");
                                }
                                return;
                            }
                        }
                    }
                    throw new IndexOutOfBoundsException("Invalid position");
                } else {
                    O000000o(i);
                    return;
                }
            }
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    public final int getItemCount() {
        int i = 0;
        for (Map.Entry<String, Section> value : this.f18182O000000o.entrySet()) {
            Section section = (Section) value.getValue();
            if (section.O00000oO) {
                i += section.O00000Oo();
            }
        }
        return i;
    }

    public final int getItemViewType(int i) {
        int i2;
        int i3 = 0;
        for (Map.Entry next : this.f18182O000000o.entrySet()) {
            Section section = (Section) next.getValue();
            if (section.O00000oO) {
                int O00000Oo2 = section.O00000Oo();
                if (i < i3 || i > (i2 = (i3 + O00000Oo2) - 1)) {
                    i3 += O00000Oo2;
                } else {
                    int intValue = this.O00000Oo.get(next.getKey()).intValue();
                    if (section.O00000oo && i == i3) {
                        return intValue;
                    }
                    if (section.O0000O0o && i == i2) {
                        return intValue + 1;
                    }
                    int i4 = AnonymousClass1.f18183O000000o[section.O00000o.ordinal()];
                    if (i4 == 1) {
                        return intValue + 2;
                    }
                    if (i4 == 2) {
                        return intValue + 3;
                    }
                    if (i4 == 3) {
                        return intValue + 4;
                    }
                    if (i4 == 4) {
                        return intValue + 5;
                    }
                    throw new IllegalStateException("Invalid state");
                }
            }
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    /* renamed from: _m_j.grl$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f18183O000000o = new int[Section.State.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f18183O000000o[Section.State.LOADED.ordinal()] = 1;
            f18183O000000o[Section.State.LOADING.ordinal()] = 2;
            f18183O000000o[Section.State.FAILED.ordinal()] = 3;
            try {
                f18183O000000o[Section.State.EMPTY.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private Section O000000o(int i) {
        int i2 = 0;
        for (Map.Entry<String, Section> value : this.f18182O000000o.entrySet()) {
            Section section = (Section) value.getValue();
            if (section.O00000oO) {
                int O00000Oo2 = section.O00000Oo();
                if (i >= i2 && i <= (i2 + O00000Oo2) - 1) {
                    return section;
                }
                i2 += O00000Oo2;
            }
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    public static class O000000o extends RecyclerView.O000OOo0 {
        public O000000o(View view) {
            super(view);
        }
    }
}
