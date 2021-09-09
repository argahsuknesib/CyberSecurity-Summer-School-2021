package _m_j;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.config.PropertySetterException;

public final class jem {
    static Class O00000o;
    static Class O00000o0;
    static Class O00000oO;
    static Class O00000oo;

    /* renamed from: O000000o  reason: collision with root package name */
    protected Object f1793O000000o;
    protected PropertyDescriptor[] O00000Oo;

    public jem(Object obj) {
        this.f1793O000000o = obj;
    }

    private void O000000o() {
        try {
            this.O00000Oo = Introspector.getBeanInfo(this.f1793O000000o.getClass()).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            StringBuffer stringBuffer = new StringBuffer("Failed to introspect ");
            stringBuffer.append(this.f1793O000000o);
            stringBuffer.append(": ");
            stringBuffer.append(e.getMessage());
            jep.O00000Oo(stringBuffer.toString());
            this.O00000Oo = new PropertyDescriptor[0];
        }
    }

    public static void O000000o(Object obj, Properties properties, String str) {
        new jem(obj).O000000o(properties, str);
    }

    public final void O000000o(Properties properties, String str) {
        int length = str.length();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str2 = (String) propertyNames.nextElement();
            if (str2.startsWith(str) && str2.indexOf(46, length + 1) <= 0) {
                String O000000o2 = jer.O000000o(str2, properties);
                String substring = str2.substring(length);
                if ((!"layout".equals(substring) && !"errorhandler".equals(substring)) || !(this.f1793O000000o instanceof jdx)) {
                    PropertyDescriptor O000000o3 = O000000o(Introspector.decapitalize(substring));
                    if (O000000o3 != null) {
                        Class cls = O00000o0;
                        if (cls == null) {
                            cls = O00000Oo("_m_j.jfe");
                            O00000o0 = cls;
                        }
                        if (cls.isAssignableFrom(O000000o3.getPropertyType()) && O000000o3.getWriteMethod() != null) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(str);
                            stringBuffer.append(substring);
                            jfe jfe = (jfe) jer.O000000o(properties, stringBuffer.toString(), O000000o3.getPropertyType());
                            jem jem = new jem(jfe);
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(str);
                            stringBuffer2.append(substring);
                            stringBuffer2.append(".");
                            jem.O000000o(properties, stringBuffer2.toString());
                            try {
                                O000000o3.getWriteMethod().invoke(this.f1793O000000o, jfe);
                            } catch (IllegalAccessException e) {
                                StringBuffer stringBuffer3 = new StringBuffer("Failed to set property [");
                                stringBuffer3.append(substring);
                                stringBuffer3.append("] to value \"");
                                stringBuffer3.append(O000000o2);
                                stringBuffer3.append("\". ");
                                jep.O00000o0(stringBuffer3.toString(), e);
                            } catch (InvocationTargetException e2) {
                                if ((e2.getTargetException() instanceof InterruptedException) || (e2.getTargetException() instanceof InterruptedIOException)) {
                                    Thread.currentThread().interrupt();
                                }
                                StringBuffer stringBuffer4 = new StringBuffer("Failed to set property [");
                                stringBuffer4.append(substring);
                                stringBuffer4.append("] to value \"");
                                stringBuffer4.append(O000000o2);
                                stringBuffer4.append("\". ");
                                jep.O00000o0(stringBuffer4.toString(), e2);
                            } catch (RuntimeException e3) {
                                StringBuffer stringBuffer5 = new StringBuffer("Failed to set property [");
                                stringBuffer5.append(substring);
                                stringBuffer5.append("] to value \"");
                                stringBuffer5.append(O000000o2);
                                stringBuffer5.append("\". ");
                                jep.O00000o0(stringBuffer5.toString(), e3);
                            }
                        }
                    }
                    O000000o(substring, O000000o2);
                }
            }
        }
    }

    private static Class O00000Oo(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public final void O000000o(String str, String str2) {
        if (str2 != null) {
            String decapitalize = Introspector.decapitalize(str);
            PropertyDescriptor O000000o2 = O000000o(decapitalize);
            if (O000000o2 == null) {
                StringBuffer stringBuffer = new StringBuffer("No such property [");
                stringBuffer.append(decapitalize);
                stringBuffer.append("] in ");
                stringBuffer.append(this.f1793O000000o.getClass().getName());
                stringBuffer.append(".");
                jep.O00000o0(stringBuffer.toString());
                return;
            }
            try {
                O000000o(O000000o2, decapitalize, str2);
            } catch (PropertySetterException e) {
                StringBuffer stringBuffer2 = new StringBuffer("Failed to set property [");
                stringBuffer2.append(decapitalize);
                stringBuffer2.append("] to value \"");
                stringBuffer2.append(str2);
                stringBuffer2.append("\". ");
                jep.O00000o0(stringBuffer2.toString(), e.rootCause);
            }
        }
    }

    private void O000000o(PropertyDescriptor propertyDescriptor, String str, String str2) throws PropertySetterException {
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod != null) {
            Class<?>[] parameterTypes = writeMethod.getParameterTypes();
            if (parameterTypes.length == 1) {
                try {
                    Object O000000o2 = O000000o(str2, parameterTypes[0]);
                    if (O000000o2 != null) {
                        StringBuffer stringBuffer = new StringBuffer("Setting property [");
                        stringBuffer.append(str);
                        stringBuffer.append("] to [");
                        stringBuffer.append(O000000o2);
                        stringBuffer.append("].");
                        jep.O000000o(stringBuffer.toString());
                        try {
                            writeMethod.invoke(this.f1793O000000o, O000000o2);
                        } catch (IllegalAccessException e) {
                            throw new PropertySetterException(e);
                        } catch (InvocationTargetException e2) {
                            if ((e2.getTargetException() instanceof InterruptedException) || (e2.getTargetException() instanceof InterruptedIOException)) {
                                Thread.currentThread().interrupt();
                            }
                            throw new PropertySetterException(e2);
                        } catch (RuntimeException e3) {
                            throw new PropertySetterException(e3);
                        }
                    } else {
                        StringBuffer stringBuffer2 = new StringBuffer("Conversion to type [");
                        stringBuffer2.append(parameterTypes[0]);
                        stringBuffer2.append("] failed.");
                        throw new PropertySetterException(stringBuffer2.toString());
                    }
                } catch (Throwable th) {
                    StringBuffer stringBuffer3 = new StringBuffer("Conversion to type [");
                    stringBuffer3.append(parameterTypes[0]);
                    stringBuffer3.append("] failed. Reason: ");
                    stringBuffer3.append(th);
                    throw new PropertySetterException(stringBuffer3.toString());
                }
            } else {
                throw new PropertySetterException("#params for setter != 1");
            }
        } else {
            StringBuffer stringBuffer4 = new StringBuffer("No setter for property [");
            stringBuffer4.append(str);
            stringBuffer4.append("].");
            throw new PropertySetterException(stringBuffer4.toString());
        }
    }

    private static Object O000000o(String str, Class cls) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        Class cls2 = O00000o;
        if (cls2 == null) {
            cls2 = O00000Oo("java.lang.String");
            O00000o = cls2;
        }
        if (cls2.isAssignableFrom(cls)) {
            return str;
        }
        if (Integer.TYPE.isAssignableFrom(cls)) {
            return new Integer(trim);
        }
        if (Long.TYPE.isAssignableFrom(cls)) {
            return new Long(trim);
        }
        if (!Boolean.TYPE.isAssignableFrom(cls)) {
            Class cls3 = O00000oO;
            if (cls3 == null) {
                cls3 = O00000Oo("_m_j.jej");
                O00000oO = cls3;
            }
            if (cls3.isAssignableFrom(cls)) {
                return jer.O000000o(trim, Level.O00000oo);
            }
            Class cls4 = O00000oo;
            if (cls4 == null) {
                cls4 = O00000Oo("_m_j.jey");
                O00000oo = cls4;
            }
            if (cls4.isAssignableFrom(cls)) {
                Class cls5 = O00000oo;
                if (cls5 == null) {
                    cls5 = O00000Oo("_m_j.jey");
                    O00000oo = cls5;
                }
                return jer.O000000o(trim, cls5, (Object) null);
            }
        } else if ("true".equalsIgnoreCase(trim)) {
            return Boolean.TRUE;
        } else {
            if ("false".equalsIgnoreCase(trim)) {
                return Boolean.FALSE;
            }
        }
        return null;
    }

    private PropertyDescriptor O000000o(String str) {
        if (this.O00000Oo == null) {
            O000000o();
        }
        int i = 0;
        while (true) {
            PropertyDescriptor[] propertyDescriptorArr = this.O00000Oo;
            if (i >= propertyDescriptorArr.length) {
                return null;
            }
            if (str.equals(propertyDescriptorArr[i].getName())) {
                return this.O00000Oo[i];
            }
            i++;
        }
    }
}
