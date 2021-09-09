package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.util.List;

@akg
public final class aqj extends aqz<List<?>> {
    public final /* synthetic */ boolean O000000o(Object obj) {
        List list = (List) obj;
        return list == null || list.isEmpty();
    }

    public final /* synthetic */ void O00000Oo(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        ajz<Object> ajz;
        ajz<Object> ajz2;
        List list = (List) obj;
        int i = 0;
        if (this.O00000o != null) {
            ajz ajz3 = this.O00000o;
            int size = list.size();
            if (size != 0) {
                aoi aoi = this.O00000o0;
                while (i < size) {
                    Object obj2 = list.get(i);
                    if (obj2 == null) {
                        try {
                            akf.O000000o(jsonGenerator);
                        } catch (Exception e) {
                            O000000o(akf, e, list, i);
                        }
                    } else if (aoi == null) {
                        ajz3.O000000o(obj2, jsonGenerator, akf);
                    } else {
                        ajz3.O000000o(obj2, jsonGenerator, akf, aoi);
                    }
                    i++;
                }
            }
        } else if (this.O00000o0 != null) {
            int size2 = list.size();
            if (size2 != 0) {
                try {
                    aoi aoi2 = this.O00000o0;
                    aqp aqp = this.O00000oo;
                    while (i < size2) {
                        Object obj3 = list.get(i);
                        if (obj3 == null) {
                            akf.O000000o(jsonGenerator);
                        } else {
                            Class<?> cls = obj3.getClass();
                            ajz<Object> O000000o2 = aqp.O000000o(cls);
                            if (O000000o2 == null) {
                                if (this.O00000Oo.O0000o0()) {
                                    ajz2 = O000000o(aqp, akf.O000000o(this.O00000Oo, cls), akf);
                                } else {
                                    ajz2 = O000000o(aqp, cls, akf);
                                }
                                O000000o2 = ajz2;
                                aqp = this.O00000oo;
                            }
                            O000000o2.O000000o(obj3, jsonGenerator, akf, aoi2);
                        }
                        i++;
                    }
                } catch (Exception e2) {
                    O000000o(akf, e2, list, 0);
                }
            }
        } else {
            int size3 = list.size();
            if (size3 != 0) {
                try {
                    aqp aqp2 = this.O00000oo;
                    while (i < size3) {
                        Object obj4 = list.get(i);
                        if (obj4 == null) {
                            akf.O000000o(jsonGenerator);
                        } else {
                            Class<?> cls2 = obj4.getClass();
                            ajz<Object> O000000o3 = aqp2.O000000o(cls2);
                            if (O000000o3 == null) {
                                if (this.O00000Oo.O0000o0()) {
                                    ajz = O000000o(aqp2, akf.O000000o(this.O00000Oo, cls2), akf);
                                } else {
                                    ajz = O000000o(aqp2, cls2, akf);
                                }
                                O000000o3 = ajz;
                                aqp2 = this.O00000oo;
                            }
                            O000000o3.O000000o(obj4, jsonGenerator, akf);
                        }
                        i++;
                    }
                } catch (Exception e3) {
                    O000000o(akf, e3, list, 0);
                }
            }
        }
    }

    public final /* synthetic */ boolean O00000Oo(Object obj) {
        return ((List) obj).size() == 1;
    }

    public aqj(ajv ajv, boolean z, aoi aoi, ajr ajr, ajz<Object> ajz) {
        super(List.class, ajv, z, aoi, ajr, ajz);
    }

    private aqj(aqj aqj, aoi aoi, ajz<?> ajz) {
        super(aqj, aoi, ajz);
    }

    public final apy<?> O00000Oo(aoi aoi) {
        return new aqj(this.O00000Oo, this.f12540O000000o, aoi, this.O00000oO, this.O00000o);
    }

    public final /* synthetic */ aqz O000000o(ajr ajr, aoi aoi, ajz ajz) {
        return new aqj(this, aoi, ajz);
    }
}
