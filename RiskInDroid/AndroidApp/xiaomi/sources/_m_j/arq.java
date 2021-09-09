package _m_j;

import _m_j.aqp;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@akg
public final class arq extends aqy<Object[]> implements apz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final boolean f12555O000000o;
    protected final ajv O00000Oo;
    protected final aoi O00000o;
    protected ajz<Object> O00000oO;
    protected aqp O00000oo;

    public final /* bridge */ /* synthetic */ boolean O000000o(Object obj) {
        Object[] objArr = (Object[]) obj;
        return objArr == null || objArr.length == 0;
    }

    public final /* synthetic */ void O00000Oo(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        if (length != 0) {
            ajz<Object> ajz = this.O00000oO;
            Object obj2 = null;
            int i = 0;
            if (ajz != null) {
                int length2 = objArr.length;
                aoi aoi = this.O00000o;
                while (i < length2) {
                    try {
                        obj2 = objArr[i];
                        if (obj2 == null) {
                            akf.O000000o(jsonGenerator);
                        } else if (aoi == null) {
                            ajz.O000000o(obj2, jsonGenerator, akf);
                        } else {
                            ajz.O000000o(obj2, jsonGenerator, akf, aoi);
                        }
                        i++;
                    } catch (IOException e) {
                        throw e;
                    } catch (Exception e2) {
                        e = e2;
                        while ((e instanceof InvocationTargetException) && e.getCause() != null) {
                            e = e.getCause();
                        }
                        if (e instanceof Error) {
                            throw ((Error) e);
                        }
                        throw JsonMappingException.wrapWithPath(e, obj2, i);
                    }
                }
                return;
            }
            aoi aoi2 = this.O00000o;
            if (aoi2 != null) {
                int length3 = objArr.length;
                try {
                    aqp aqp = this.O00000oo;
                    while (i < length3) {
                        Object obj3 = objArr[i];
                        if (obj3 == null) {
                            akf.O000000o(jsonGenerator);
                        } else {
                            Class<?> cls = obj3.getClass();
                            ajz<Object> O000000o2 = aqp.O000000o(cls);
                            if (O000000o2 == null) {
                                O000000o2 = O000000o(aqp, cls, akf);
                            }
                            O000000o2.O000000o(obj3, jsonGenerator, akf, aoi2);
                        }
                        i++;
                    }
                } catch (IOException e3) {
                    throw e3;
                } catch (Exception e4) {
                    e = e4;
                    while ((e instanceof InvocationTargetException) && e.getCause() != null) {
                        e = e.getCause();
                    }
                    if (e instanceof Error) {
                        throw ((Error) e);
                    }
                    throw JsonMappingException.wrapWithPath(e, (Object) null, 0);
                }
            } else {
                try {
                    aqp aqp2 = this.O00000oo;
                    while (i < length) {
                        Object obj4 = objArr[i];
                        if (obj4 == null) {
                            akf.O000000o(jsonGenerator);
                        } else {
                            Class<?> cls2 = obj4.getClass();
                            ajz<Object> O000000o3 = aqp2.O000000o(cls2);
                            if (O000000o3 == null) {
                                if (this.O00000Oo.O0000o0()) {
                                    aqp.O00000o O000000o4 = aqp2.O000000o(akf.O000000o(this.O00000Oo, cls2), akf, this.O00000o0);
                                    if (aqp2 != O000000o4.O00000Oo) {
                                        this.O00000oo = O000000o4.O00000Oo;
                                    }
                                    O000000o3 = O000000o4.f12530O000000o;
                                } else {
                                    O000000o3 = O000000o(aqp2, cls2, akf);
                                }
                            }
                            O000000o3.O000000o(obj4, jsonGenerator, akf);
                        }
                        i++;
                    }
                } catch (IOException e5) {
                    throw e5;
                } catch (Exception e6) {
                    e = e6;
                    while ((e instanceof InvocationTargetException) && e.getCause() != null) {
                        e = e.getCause();
                    }
                    if (e instanceof Error) {
                        throw ((Error) e);
                    }
                    throw JsonMappingException.wrapWithPath(e, (Object) null, 0);
                }
            }
        }
    }

    public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
        return ((Object[]) obj).length == 1;
    }

    public arq(ajv ajv, boolean z, aoi aoi, ajz<Object> ajz) {
        super(Object[].class, (byte) 0);
        this.O00000Oo = ajv;
        this.f12555O000000o = z;
        this.O00000o = aoi;
        this.O00000oo = aqp.O000000o();
        this.O00000oO = ajz;
    }

    private arq(arq arq, ajr ajr, aoi aoi, ajz<?> ajz) {
        super(arq, ajr);
        this.O00000Oo = arq.O00000Oo;
        this.O00000o = aoi;
        this.f12555O000000o = arq.f12555O000000o;
        this.O00000oo = arq.O00000oo;
        this.O00000oO = ajz;
    }

    public final apy<?> O00000Oo(aoi aoi) {
        return new arq(this.O00000Oo, this.f12555O000000o, aoi, this.O00000oO);
    }

    public final ajz<?> O000000o(akf akf, ajr ajr) throws JsonMappingException {
        aoi aoi = this.O00000o;
        if (aoi != null) {
            aoi = aoi.O000000o(ajr);
        }
        ajz<?> ajz = this.O00000oO;
        if (ajz == null) {
            if (this.f12555O000000o) {
                ajz = akf.O000000o(this.O00000Oo, ajr);
            }
        } else if (ajz instanceof apz) {
            ajz = ((apz) ajz).O000000o(akf, ajr);
        }
        if (this.O00000o0 == ajr && ajz == this.O00000oO && this.O00000o == aoi) {
            return this;
        }
        return new arq(this, ajr, aoi, ajz);
    }

    private ajz<Object> O000000o(aqp aqp, Class<?> cls, akf akf) throws JsonMappingException {
        aqp.O00000o O000000o2 = aqp.O000000o(cls, akf, this.O00000o0);
        if (aqp != O000000o2.O00000Oo) {
            this.O00000oo = O000000o2.O00000Oo;
        }
        return O000000o2.f12530O000000o;
    }
}
