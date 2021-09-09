package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class JsonMappingException extends JsonProcessingException {
    private static final long serialVersionUID = 1;
    protected LinkedList<Reference> _path;

    public static class Reference implements Serializable {
        private static final long serialVersionUID = 1;
        protected String _fieldName;
        protected Object _from;
        protected int _index = -1;

        protected Reference() {
        }

        public Reference(Object obj, String str) {
            this._from = obj;
            if (str != null) {
                this._fieldName = str;
                return;
            }
            throw new NullPointerException("Can not pass null fieldName");
        }

        public Reference(Object obj, int i) {
            this._from = obj;
            this._index = i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Object obj = this._from;
            Class<?> cls = obj instanceof Class ? (Class) obj : obj.getClass();
            Package packageR = cls.getPackage();
            if (packageR != null) {
                sb.append(packageR.getName());
                sb.append('.');
            }
            sb.append(cls.getSimpleName());
            sb.append('[');
            if (this._fieldName != null) {
                sb.append('\"');
                sb.append(this._fieldName);
                sb.append('\"');
            } else {
                int i = this._index;
                if (i >= 0) {
                    sb.append(i);
                } else {
                    sb.append('?');
                }
            }
            sb.append(']');
            return sb.toString();
        }
    }

    public JsonMappingException(String str) {
        super(str);
    }

    public JsonMappingException(String str, Throwable th) {
        super(str, th);
    }

    public JsonMappingException(String str, JsonLocation jsonLocation) {
        super(str, jsonLocation);
    }

    public JsonMappingException(String str, JsonLocation jsonLocation, Throwable th) {
        super(str, jsonLocation, th);
    }

    public static JsonMappingException from(JsonParser jsonParser, String str) {
        return new JsonMappingException(str, jsonParser.O0000O0o());
    }

    public static JsonMappingException from(JsonParser jsonParser, String str, Throwable th) {
        return new JsonMappingException(str, jsonParser.O0000O0o(), th);
    }

    public static JsonMappingException wrapWithPath(Throwable th, Object obj, String str) {
        return wrapWithPath(th, new Reference(obj, str));
    }

    public static JsonMappingException wrapWithPath(Throwable th, Object obj, int i) {
        return wrapWithPath(th, new Reference(obj, i));
    }

    public static JsonMappingException wrapWithPath(Throwable th, Reference reference) {
        JsonMappingException jsonMappingException;
        if (th instanceof JsonMappingException) {
            jsonMappingException = (JsonMappingException) th;
        } else {
            String message = th.getMessage();
            if (message == null || message.length() == 0) {
                message = "(was " + th.getClass().getName() + ")";
            }
            jsonMappingException = new JsonMappingException(message, null, th);
        }
        jsonMappingException.prependPath(reference);
        return jsonMappingException;
    }

    public List<Reference> getPath() {
        LinkedList<Reference> linkedList = this._path;
        if (linkedList == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(linkedList);
    }

    public String getPathReference() {
        return getPathReference(new StringBuilder()).toString();
    }

    public StringBuilder getPathReference(StringBuilder sb) {
        _appendPathDesc(sb);
        return sb;
    }

    public void prependPath(Object obj, String str) {
        prependPath(new Reference(obj, str));
    }

    public void prependPath(Object obj, int i) {
        prependPath(new Reference(obj, i));
    }

    public void prependPath(Reference reference) {
        if (this._path == null) {
            this._path = new LinkedList<>();
        }
        if (this._path.size() < 1000) {
            this._path.addFirst(reference);
        }
    }

    public String getLocalizedMessage() {
        return _buildMessage();
    }

    public String getMessage() {
        return _buildMessage();
    }

    /* access modifiers changed from: protected */
    public String _buildMessage() {
        String message = super.getMessage();
        if (this._path == null) {
            return message;
        }
        StringBuilder sb = message == null ? new StringBuilder() : new StringBuilder(message);
        sb.append(" (through reference chain: ");
        StringBuilder pathReference = getPathReference(sb);
        pathReference.append(')');
        return pathReference.toString();
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    /* access modifiers changed from: protected */
    public void _appendPathDesc(StringBuilder sb) {
        Iterator<Reference> it = this._path.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append("->");
            }
        }
    }
}
