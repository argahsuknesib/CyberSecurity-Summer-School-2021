package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzcg<MessageType extends zzcg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzas<MessageType, BuilderType> {
    private static Map<Object, zzcg<?, ?>> zzjr = new ConcurrentHashMap();
    protected zzey zzjp = zzey.zzea();
    private int zzjq = -1;

    public static abstract class zza<MessageType extends zzcg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzat<MessageType, BuilderType> {
        private final MessageType zzjs;
        protected MessageType zzjt;
        protected boolean zzju = false;

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: MessageType
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        protected zza(MessageType r3) {
            /*
                r2 = this;
                r2.<init>()
                r2.zzjs = r3
                int r0 = com.google.android.gms.internal.clearcut.zzcg.zzg.zzkg
                r1 = 0
                java.lang.Object r3 = r3.zza(r0, r1, r1)
                com.google.android.gms.internal.clearcut.zzcg r3 = (com.google.android.gms.internal.clearcut.zzcg) r3
                r2.zzjt = r3
                r3 = 0
                r2.zzju = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzcg.zza.<init>(com.google.android.gms.internal.clearcut.zzcg):void");
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzea.zzcm().zzp(messagetype).zzc(messagetype, messagetype2);
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) ((zzcg) this.zzjs).zza(zzg.zzkh, (Object) null, (Object) null);
            zza.zza((zzcg) zzbi());
            return zza;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.internal.clearcut.zzcg.zza(com.google.android.gms.internal.clearcut.zzcg, boolean):boolean
         arg types: [MessageType, int]
         candidates:
          com.google.android.gms.internal.clearcut.zzcg.zza(com.google.android.gms.internal.clearcut.zzcg, byte[]):T
          com.google.android.gms.internal.clearcut.zzcg.zza(java.lang.Class, com.google.android.gms.internal.clearcut.zzcg):void
          com.google.android.gms.internal.clearcut.zzcg.zza(com.google.android.gms.internal.clearcut.zzcg, boolean):boolean */
        public final boolean isInitialized() {
            return zzcg.zza((zzcg) this.zzjt, false);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzbf();
            zza(this.zzjt, messagetype);
            return this;
        }

        public final /* synthetic */ zzdo zzbe() {
            return this.zzjs;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: MessageType
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        protected void zzbf() {
            /*
                r3 = this;
                boolean r0 = r3.zzju
                if (r0 == 0) goto L_0x0019
                MessageType r0 = r3.zzjt
                int r1 = com.google.android.gms.internal.clearcut.zzcg.zzg.zzkg
                r2 = 0
                java.lang.Object r0 = r0.zza(r1, r2, r2)
                com.google.android.gms.internal.clearcut.zzcg r0 = (com.google.android.gms.internal.clearcut.zzcg) r0
                MessageType r1 = r3.zzjt
                zza(r0, r1)
                r3.zzjt = r0
                r0 = 0
                r3.zzju = r0
            L_0x0019:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzcg.zza.zzbf():void");
        }

        /* renamed from: zzbg */
        public MessageType zzbi() {
            if (this.zzju) {
                return this.zzjt;
            }
            MessageType messagetype = this.zzjt;
            zzea.zzcm().zzp(messagetype).zzc(messagetype);
            this.zzju = true;
            return this.zzjt;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: MessageType
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public final MessageType zzbh() {
            /*
                r5 = this;
                com.google.android.gms.internal.clearcut.zzdo r0 = r5.zzbi()
                com.google.android.gms.internal.clearcut.zzcg r0 = (com.google.android.gms.internal.clearcut.zzcg) r0
                int r1 = com.google.android.gms.internal.clearcut.zzcg.zzg.zzkd
                r2 = 0
                java.lang.Object r1 = r0.zza(r1, r2, r2)
                java.lang.Byte r1 = (java.lang.Byte) r1
                byte r1 = r1.byteValue()
                r3 = 1
                if (r1 != r3) goto L_0x0017
                goto L_0x0031
            L_0x0017:
                if (r1 != 0) goto L_0x001b
                r3 = 0
                goto L_0x0031
            L_0x001b:
                com.google.android.gms.internal.clearcut.zzea r1 = com.google.android.gms.internal.clearcut.zzea.zzcm()
                com.google.android.gms.internal.clearcut.zzef r1 = r1.zzp(r0)
                boolean r3 = r1.zzo(r0)
                int r1 = com.google.android.gms.internal.clearcut.zzcg.zzg.zzke
                if (r3 == 0) goto L_0x002d
                r4 = r0
                goto L_0x002e
            L_0x002d:
                r4 = r2
            L_0x002e:
                r0.zza(r1, r4, r2)
            L_0x0031:
                if (r3 == 0) goto L_0x0034
                return r0
            L_0x0034:
                com.google.android.gms.internal.clearcut.zzew r1 = new com.google.android.gms.internal.clearcut.zzew
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzcg.zza.zzbh():com.google.android.gms.internal.clearcut.zzcg");
        }

        public final /* synthetic */ zzdo zzbj() {
            zzcg zzcg = (zzcg) zzbi();
            byte byteValue = ((Byte) zzcg.zza(zzg.zzkd, (Object) null, (Object) null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = zzea.zzcm().zzp(zzcg).zzo(zzcg);
                    zzcg.zza(zzg.zzke, z ? zzcg : null, (Object) null);
                }
            }
            if (z) {
                return zzcg;
            }
            throw new zzew(zzcg);
        }

        public final /* synthetic */ zzat zzt() {
            return (zza) clone();
        }
    }

    public static class zzb<T extends zzcg<T, ?>> extends zzau<T> {
        private T zzjs;

        public zzb(T t) {
            this.zzjs = t;
        }
    }

    public static abstract class zzc<MessageType extends zzd<MessageType, BuilderType>, BuilderType extends zzc<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzdq {
        protected zzc(MessageType messagetype) {
            super(messagetype);
        }

        /* access modifiers changed from: protected */
        public final void zzbf() {
            if (this.zzju) {
                super.zzbf();
                ((zzd) this.zzjt).zzjv = (zzby) ((zzd) this.zzjt).zzjv.clone();
            }
        }

        public final /* synthetic */ zzcg zzbg() {
            return (zzd) zzbi();
        }

        public final /* synthetic */ zzdo zzbi() {
            zzcg zzbg;
            if (this.zzju) {
                zzbg = this.zzjt;
            } else {
                ((zzd) this.zzjt).zzjv.zzv();
                zzbg = super.zzbi();
            }
            return (zzd) zzbg;
        }
    }

    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType extends zzc<MessageType, BuilderType>> extends zzcg<MessageType, BuilderType> implements zzdq {
        protected zzby<zze> zzjv = zzby.zzar();
    }

    static final class zze implements zzca<zze> {
        final int number = 66321687;
        private final zzck<?> zzjw = null;
        final zzfl zzjx;
        final boolean zzjy;
        final boolean zzjz;

        zze(zzck<?> zzck, int i, zzfl zzfl, boolean z, boolean z2) {
            this.zzjx = zzfl;
            this.zzjy = false;
            this.zzjz = false;
        }

        public final /* synthetic */ int compareTo(Object obj) {
            return this.number - ((zze) obj).number;
        }

        public final zzdp zza(zzdp zzdp, zzdo zzdo) {
            return ((zza) zzdp).zza((zzcg) zzdo);
        }

        public final zzdv zza(zzdv zzdv, zzdv zzdv2) {
            throw new UnsupportedOperationException();
        }

        public final zzfl zzau() {
            return this.zzjx;
        }

        public final zzfq zzav() {
            return this.zzjx.zzek();
        }

        public final boolean zzaw() {
            return false;
        }

        public final boolean zzax() {
            return false;
        }

        public final int zzc() {
            return this.number;
        }
    }

    public static class zzf<ContainingType extends zzdo, Type> extends zzbr<ContainingType, Type> {
        private final Type zzdu;
        private final ContainingType zzka;
        private final zzdo zzkb;
        private final zze zzkc;

        zzf(ContainingType containingtype, Type type, zzdo zzdo, zze zze, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (zze.zzjx == zzfl.MESSAGE && zzdo == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.zzka = containingtype;
                this.zzdu = type;
                this.zzkb = zzdo;
                this.zzkc = zze;
            }
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class zzg {
        public static final int zzkd = 1;
        public static final int zzke = 2;
        public static final int zzkf = 3;
        public static final int zzkg = 4;
        public static final int zzkh = 5;
        public static final int zzki = 6;
        public static final int zzkj = 7;
        private static final /* synthetic */ int[] zzkk = {zzkd, zzke, zzkf, zzkg, zzkh, zzki, zzkj};
        public static final int zzkl = 1;
        public static final int zzkm = 2;
        private static final /* synthetic */ int[] zzkn = {zzkl, zzkm};
        public static final int zzko = 1;
        public static final int zzkp = 2;
        private static final /* synthetic */ int[] zzkq = {zzko, zzkp};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzkk.clone();
        }
    }

    public static <ContainingType extends zzdo, Type> zzf<ContainingType, Type> zza(ContainingType containingtype, Type type, zzdo zzdo, zzck<?> zzck, int i, zzfl zzfl, Class cls) {
        return new zzf(containingtype, type, zzdo, new zze(null, 66321687, zzfl, false, false), cls);
    }

    private static <T extends zzcg<T, ?>> T zza(zzcg zzcg, byte[] bArr) throws zzco {
        T t = (zzcg) zzcg.zza(zzg.zzkg, (Object) null, (Object) null);
        try {
            zzea.zzcm().zzp(t).zza(t, bArr, 0, bArr.length, new zzay());
            zzea.zzcm().zzp(t).zzc(t);
            if (t.zzex == 0) {
                return t;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzco) {
                throw ((zzco) e.getCause());
            }
            throw new zzco(e.getMessage()).zzg(t);
        } catch (IndexOutOfBoundsException unused) {
            throw zzco.zzbl().zzg(t);
        }
    }

    protected static Object zza(zzdo zzdo, String str, Object[] objArr) {
        return new zzec(zzdo, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static <T extends zzcg<?, ?>> void zza(Class cls, zzcg zzcg) {
        zzjr.put(cls, zzcg);
    }

    protected static final <T extends zzcg<T, ?>> boolean zza(zzcg zzcg, boolean z) {
        byte byteValue = ((Byte) zzcg.zza(zzg.zzkd, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return zzea.zzcm().zzp(zzcg).zzo(zzcg);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.clearcut.zzch, com.google.android.gms.internal.clearcut.zzcl] */
    protected static zzcl zzaz() {
        return zzch.zzbk();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    protected static <T extends com.google.android.gms.internal.clearcut.zzcg<T, ?>> T zzb(T r3, byte[] r4) throws com.google.android.gms.internal.clearcut.zzco {
        /*
            com.google.android.gms.internal.clearcut.zzcg r3 = zza(r3, r4)
            if (r3 == 0) goto L_0x0047
            int r4 = com.google.android.gms.internal.clearcut.zzcg.zzg.zzkd
            r0 = 0
            java.lang.Object r4 = r3.zza(r4, r0, r0)
            java.lang.Byte r4 = (java.lang.Byte) r4
            byte r4 = r4.byteValue()
            r1 = 1
            if (r4 != r1) goto L_0x0017
            goto L_0x0031
        L_0x0017:
            if (r4 != 0) goto L_0x001b
            r1 = 0
            goto L_0x0031
        L_0x001b:
            com.google.android.gms.internal.clearcut.zzea r4 = com.google.android.gms.internal.clearcut.zzea.zzcm()
            com.google.android.gms.internal.clearcut.zzef r4 = r4.zzp(r3)
            boolean r1 = r4.zzo(r3)
            int r4 = com.google.android.gms.internal.clearcut.zzcg.zzg.zzke
            if (r1 == 0) goto L_0x002d
            r2 = r3
            goto L_0x002e
        L_0x002d:
            r2 = r0
        L_0x002e:
            r3.zza(r4, r2, r0)
        L_0x0031:
            if (r1 == 0) goto L_0x0034
            goto L_0x0047
        L_0x0034:
            com.google.android.gms.internal.clearcut.zzew r4 = new com.google.android.gms.internal.clearcut.zzew
            r4.<init>(r3)
            com.google.android.gms.internal.clearcut.zzco r0 = new com.google.android.gms.internal.clearcut.zzco
            java.lang.String r4 = r4.getMessage()
            r0.<init>(r4)
            com.google.android.gms.internal.clearcut.zzco r3 = r0.zzg(r3)
            throw r3
        L_0x0047:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzcg.zzb(com.google.android.gms.internal.clearcut.zzcg, byte[]):com.google.android.gms.internal.clearcut.zzcg");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.clearcut.zzcm, com.google.android.gms.internal.clearcut.zzdc] */
    protected static zzcm zzba() {
        return zzdc.zzbx();
    }

    protected static <E> zzcn<E> zzbb() {
        return zzeb.zzcn();
    }

    static <T extends zzcg<?, ?>> T zzc(Class<T> cls) {
        T t = (zzcg) zzjr.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzcg) zzjr.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        String valueOf = String.valueOf(cls.getName());
        throw new IllegalStateException(valueOf.length() != 0 ? "Unable to get default instance for: ".concat(valueOf) : new String("Unable to get default instance for: "));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzcg) zza(zzg.zzki, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzea.zzcm().zzp(this).equals(this, (zzcg) obj);
    }

    public int hashCode() {
        if (this.zzex != 0) {
            return this.zzex;
        }
        this.zzex = zzea.zzcm().zzp(this).hashCode(this);
        return this.zzex;
    }

    public final boolean isInitialized() {
        byte byteValue = ((Byte) zza(zzg.zzkd, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzo = zzea.zzcm().zzp(this).zzo(this);
        zza(zzg.zzke, zzo ? this : null, (Object) null);
        return zzo;
    }

    public String toString() {
        return zzdr.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public final int zzas() {
        if (this.zzjq == -1) {
            this.zzjq = zzea.zzcm().zzp(this).zzm(this);
        }
        return this.zzjq;
    }

    public final void zzb(zzbn zzbn) throws IOException {
        zzea.zzcm().zze(getClass()).zza(this, zzbp.zza(zzbn));
    }

    public final /* synthetic */ zzdp zzbc() {
        zza zza2 = (zza) zza(zzg.zzkh, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzdp zzbd() {
        return (zza) zza(zzg.zzkh, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzdo zzbe() {
        return (zzcg) zza(zzg.zzki, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(int i) {
        this.zzjq = i;
    }

    /* access modifiers changed from: package-private */
    public final int zzs() {
        return this.zzjq;
    }
}
