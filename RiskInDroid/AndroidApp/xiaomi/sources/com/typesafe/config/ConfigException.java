package com.typesafe.config;

import _m_j.dsi;
import _m_j.dtj;
import com.typesafe.config.impl.SerializedConfigValue;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;

public abstract class ConfigException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient dsi origin;

    protected ConfigException(dsi dsi, String str, Throwable th) {
        super(dsi.O000000o() + ": " + str, th);
        this.origin = dsi;
    }

    protected ConfigException(dsi dsi, String str) {
        this(dsi.O000000o() + ": " + str, (Throwable) null);
    }

    protected ConfigException(String str, Throwable th) {
        super(str, th);
        this.origin = null;
    }

    protected ConfigException(String str) {
        this(str, (Throwable) null);
    }

    public dsi origin() {
        return this.origin;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        SerializedConfigValue.O000000o(new DataOutputStream(objectOutputStream), (dtj) this.origin, (dtj) null);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        dtj O000000o2 = SerializedConfigValue.O000000o(objectInputStream, (dtj) null);
        try {
            Field declaredField = ConfigException.class.getDeclaredField("origin");
            declaredField.setAccessible(true);
            try {
                declaredField.set(this, O000000o2);
            } catch (IllegalArgumentException e) {
                throw new IOException("unable to set origin field", e);
            } catch (IllegalAccessException e2) {
                throw new IOException("unable to set origin field", e2);
            }
        } catch (NoSuchFieldException e3) {
            throw new IOException("ConfigException has no origin field?", e3);
        } catch (SecurityException e4) {
            throw new IOException("unable to fill out origin field in ConfigException", e4);
        }
    }

    public static class WrongType extends ConfigException {
        private static final long serialVersionUID = 1;

        public WrongType(dsi dsi, String str, String str2, String str3, Throwable th) {
            super(dsi, str + " has type " + str3 + " rather than " + str2, th);
        }

        public WrongType(dsi dsi, String str, String str2, String str3) {
            this(dsi, str, str2, str3, null);
        }

        public WrongType(dsi dsi, String str, Throwable th) {
            super(dsi, str, th);
        }

        public WrongType(dsi dsi, String str) {
            super(dsi, str, null);
        }
    }

    public static class Missing extends ConfigException {
        private static final long serialVersionUID = 1;

        public Missing(String str, Throwable th) {
            super("No configuration setting found for key '" + str + "'", th);
        }

        public Missing(String str) {
            this(str, (Throwable) null);
        }

        protected Missing(dsi dsi, String str, Throwable th) {
            super(dsi, str, th);
        }

        protected Missing(dsi dsi, String str) {
            this(dsi, str, null);
        }
    }

    public static class Null extends Missing {
        private static final long serialVersionUID = 1;

        private static String makeMessage(String str, String str2) {
            if (str2 != null) {
                return "Configuration key '" + str + "' is set to null but expected " + str2;
            }
            return "Configuration key '" + str + "' is null";
        }

        public Null(dsi dsi, String str, String str2, Throwable th) {
            super(dsi, makeMessage(str, str2), th);
        }

        public Null(dsi dsi, String str, String str2) {
            this(dsi, str, str2, null);
        }
    }

    public static class BadValue extends ConfigException {
        private static final long serialVersionUID = 1;

        public BadValue(dsi dsi, String str, String str2, Throwable th) {
            super(dsi, "Invalid value at '" + str + "': " + str2, th);
        }

        public BadValue(dsi dsi, String str, String str2) {
            this(dsi, str, str2, null);
        }

        public BadValue(String str, String str2, Throwable th) {
            super("Invalid value at '" + str + "': " + str2, th);
        }

        public BadValue(String str, String str2) {
            this(str, str2, (Throwable) null);
        }
    }

    public static class BadPath extends ConfigException {
        private static final long serialVersionUID = 1;

        /* JADX WARNING: Illegal instructions before constructor call */
        public BadPath(dsi dsi, String str, String str2, Throwable th) {
            super(dsi, str2, th);
            if (str != null) {
                str2 = "Invalid path '" + str + "': " + str2;
            }
        }

        public BadPath(dsi dsi, String str, String str2) {
            this(dsi, str, str2, null);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        public BadPath(String str, String str2, Throwable th) {
            super(str2, th);
            if (str != null) {
                str2 = "Invalid path '" + str + "': " + str2;
            }
        }

        public BadPath(String str, String str2) {
            this(str, str2, (Throwable) null);
        }

        public BadPath(dsi dsi, String str) {
            this(dsi, (String) null, str);
        }
    }

    public static class BugOrBroken extends ConfigException {
        private static final long serialVersionUID = 1;

        public BugOrBroken(String str, Throwable th) {
            super(str, th);
        }

        public BugOrBroken(String str) {
            this(str, null);
        }
    }

    public static class IO extends ConfigException {
        private static final long serialVersionUID = 1;

        public IO(dsi dsi, String str, Throwable th) {
            super(dsi, str, th);
        }

        public IO(dsi dsi, String str) {
            this(dsi, str, null);
        }
    }

    public static class Parse extends ConfigException {
        private static final long serialVersionUID = 1;

        public Parse(dsi dsi, String str, Throwable th) {
            super(dsi, str, th);
        }

        public Parse(dsi dsi, String str) {
            this(dsi, str, null);
        }
    }

    public static class UnresolvedSubstitution extends Parse {
        private static final long serialVersionUID = 1;

        public UnresolvedSubstitution(dsi dsi, String str, Throwable th) {
            super(dsi, "Could not resolve substitution to a value: ".concat(String.valueOf(str)), th);
        }

        public UnresolvedSubstitution(dsi dsi, String str) {
            this(dsi, str, null);
        }
    }

    public static class NotResolved extends BugOrBroken {
        private static final long serialVersionUID = 1;

        public NotResolved(String str, Throwable th) {
            super(str, th);
        }

        public NotResolved(String str) {
            this(str, null);
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f5919O000000o;
        final dsi O00000Oo;
        final String O00000o0;

        public final String toString() {
            return "ValidationProblem(" + this.f5919O000000o + "," + this.O00000Oo + "," + this.O00000o0 + ")";
        }
    }

    public static class ValidationFailed extends ConfigException {
        private static final long serialVersionUID = 1;
        private final Iterable<O000000o> problems;

        public ValidationFailed(Iterable<O000000o> iterable) {
            super(makeMessage(iterable), (Throwable) null);
            this.problems = iterable;
        }

        public Iterable<O000000o> problems() {
            return this.problems;
        }

        private static String makeMessage(Iterable<O000000o> iterable) {
            StringBuilder sb = new StringBuilder();
            for (O000000o next : iterable) {
                sb.append(next.O00000Oo.O000000o());
                sb.append(": ");
                sb.append(next.f5919O000000o);
                sb.append(": ");
                sb.append(next.O00000o0);
                sb.append(", ");
            }
            if (sb.length() != 0) {
                sb.setLength(sb.length() - 2);
                return sb.toString();
            }
            throw new BugOrBroken("ValidationFailed must have a non-empty list of problems");
        }
    }

    public static class Generic extends ConfigException {
        private static final long serialVersionUID = 1;

        public Generic(String str, Throwable th) {
            super(str, th);
        }

        public Generic(String str) {
            this(str, null);
        }
    }
}
