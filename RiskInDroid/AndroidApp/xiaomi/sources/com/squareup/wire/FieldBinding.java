package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> {
    private ProtoAdapter<Object> adapter;
    public final String adapterString;
    private final Field builderField;
    private final Method builderMethod;
    public final WireField.Label label;
    private final Field messageField;
    public final String name;
    public final boolean redacted;
    private ProtoAdapter<?> singleAdapter;
    public final int tag;

    private static Field getBuilderField(Class<?> cls, String str) {
        try {
            return cls.getField(str);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + cls.getName() + "." + str);
        }
    }

    private static Method getBuilderMethod(Class<?> cls, String str, Class<?> cls2) {
        try {
            return cls.getMethod(str, cls2);
        } catch (NoSuchMethodException unused) {
            throw new AssertionError("No builder method " + cls.getName() + "." + str + "(" + cls2.getName() + ")");
        }
    }

    FieldBinding(WireField wireField, Field field, Class<B> cls) {
        this.label = wireField.label();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.adapterString = wireField.adapter();
        this.redacted = wireField.redacted();
        this.messageField = field;
        this.builderField = getBuilderField(cls, this.name);
        this.builderMethod = getBuilderMethod(cls, this.name, field.getType());
    }

    /* access modifiers changed from: package-private */
    public final ProtoAdapter<?> singleAdapter() {
        ProtoAdapter<?> protoAdapter = this.singleAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.adapterString);
        this.singleAdapter = protoAdapter2;
        return protoAdapter2;
    }

    /* access modifiers changed from: package-private */
    public final ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> withLabel = singleAdapter().withLabel(this.label);
        this.adapter = withLabel;
        return withLabel;
    }

    /* access modifiers changed from: package-private */
    public final void value(B b, Object obj) {
        if (this.label.isRepeated()) {
            try {
                ((List) this.builderField.get(b)).add(obj);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        } else {
            set(b, obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void set(B b, Object obj) {
        try {
            if (this.label.isOneOf()) {
                this.builderMethod.invoke(b, obj);
                return;
            }
            this.builderField.set(b, obj);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final Object get(M m) {
        try {
            return this.messageField.get(m);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final Object getFromBuilder(B b) {
        try {
            return this.builderField.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
