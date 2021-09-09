package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.aa;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

final class cu {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3688a = new aa("ExtractorTaskFinder");
    private final cr b;
    private final bc c;
    private final bn d;

    cu(cr crVar, bc bcVar, bn bnVar) {
        this.b = crVar;
        this.c = bcVar;
        this.d = bnVar;
    }

    private final boolean a(co coVar, cp cpVar) {
        bc bcVar = this.c;
        cn cnVar = coVar.c;
        String str = cnVar.f3683a;
        return bcVar.e(str, coVar.b, cnVar.b, cpVar.f3685a).exists();
    }

    private static boolean a(cp cpVar) {
        int i = cpVar.f;
        return i == 1 || i == 2;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:23:0x00ad */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:37:0x0138 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:52:0x01d7 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:105:0x0412 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.google.android.play.core.assetpacks.ct] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0412, code lost:
        if (r0 == null) goto L_0x0414;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.google.android.play.core.assetpacks.cu.f3688a.a("Found final move task for session %s with pack %s.", java.lang.Integer.valueOf(r4.f3684a), r4.c.f3683a);
        r11 = r4.f3684a;
        r8 = r4.c;
        r10 = new com.google.android.play.core.assetpacks.dh(r11, r8.f3683a, r4.b, r8.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x02cd, code lost:
        com.google.android.play.core.assetpacks.cu.f3688a.a("Found extraction task for patch for session %s, pack %s, slice %s.", java.lang.Integer.valueOf(r6.f3684a), r6.c.f3683a, r10.f3685a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        r11 = r1.c;
        r3 = r6.c;
        r0 = new java.io.FileInputStream(r11.e(r3.f3683a, r6.b, r3.b, r10.f3685a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        r4 = r6.f3684a;
        r7 = r6.c;
        r19 = new com.google.android.play.core.assetpacks.bv(r4, r7.f3683a, r6.b, r7.b, r10.f3685a, 0, 0, 1, r7.d, r7.c, r0);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    public final ct a() {
        char c2;
        dn dnVar;
        char c3;
        de deVar;
        du duVar;
        bv bvVar;
        co coVar;
        cp next;
        int i;
        co coVar2;
        try {
            this.b.a();
            ArrayList arrayList = new ArrayList();
            for (co next2 : this.b.c().values()) {
                if (dd.c(next2.c.c)) {
                    arrayList.add(next2);
                }
            }
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    c2 = 0;
                    if (!it.hasNext()) {
                        dh dhVar = null;
                        break;
                    }
                    coVar2 = (co) it.next();
                    bc bcVar = this.c;
                    cn cnVar = coVar2.c;
                    if (bcVar.d(cnVar.f3683a, coVar2.b, cnVar.b) == coVar2.c.e.size()) {
                        break;
                    }
                }
                if (dnVar == null) {
                    Iterator it2 = arrayList.iterator();
                    loop2:
                    while (true) {
                        c3 = 3;
                        if (!it2.hasNext()) {
                            deVar = null;
                            break;
                        }
                        co coVar3 = (co) it2.next();
                        if (dd.c(coVar3.c.c)) {
                            for (cp next3 : coVar3.c.e) {
                                bc bcVar2 = this.c;
                                cn cnVar2 = coVar3.c;
                                if (bcVar2.b(cnVar2.f3683a, coVar3.b, cnVar2.b, next3.f3685a).exists()) {
                                    f3688a.a("Found merge task for session %s with pack %s and slice %s.", Integer.valueOf(coVar3.f3684a), coVar3.c.f3683a, next3.f3685a);
                                    int i2 = coVar3.f3684a;
                                    cn cnVar3 = coVar3.c;
                                    deVar = new de(i2, cnVar3.f3683a, coVar3.b, cnVar3.b, next3.f3685a);
                                    break loop2;
                                }
                            }
                            continue;
                        }
                    }
                    if (dnVar == null) {
                        Iterator it3 = arrayList.iterator();
                        loop4:
                        while (true) {
                            if (!it3.hasNext()) {
                                duVar = null;
                                break;
                            }
                            co coVar4 = (co) it3.next();
                            if (dd.c(coVar4.c.c)) {
                                for (cp next4 : coVar4.c.e) {
                                    bc bcVar3 = this.c;
                                    cn cnVar4 = coVar4.c;
                                    if (new dr(bcVar3, cnVar4.f3683a, coVar4.b, cnVar4.b, next4.f3685a).d()) {
                                        bc bcVar4 = this.c;
                                        cn cnVar5 = coVar4.c;
                                        if (bcVar4.a(cnVar5.f3683a, coVar4.b, cnVar5.b, next4.f3685a).exists()) {
                                            f3688a.a("Found verify task for session %s with pack %s and slice %s.", Integer.valueOf(coVar4.f3684a), coVar4.c.f3683a, next4.f3685a);
                                            int i3 = coVar4.f3684a;
                                            cn cnVar6 = coVar4.c;
                                            duVar = new du(i3, cnVar6.f3683a, coVar4.b, cnVar6.b, next4.f3685a, next4.b);
                                            break loop4;
                                        }
                                    }
                                }
                                continue;
                            }
                        }
                        if (dnVar == null) {
                            Iterator it4 = arrayList.iterator();
                            loop6:
                            while (true) {
                                if (!it4.hasNext()) {
                                    bvVar = null;
                                    break;
                                }
                                coVar = (co) it4.next();
                                if (dd.c(coVar.c.c)) {
                                    Iterator<cp> it5 = coVar.c.e.iterator();
                                    while (it5.hasNext()) {
                                        next = it5.next();
                                        if (!a(next)) {
                                            bc bcVar5 = this.c;
                                            cn cnVar7 = coVar.c;
                                            Iterator it6 = it4;
                                            try {
                                                i = new dr(bcVar5, cnVar7.f3683a, coVar.b, cnVar7.b, next.f3685a).c();
                                            } catch (IOException e) {
                                                IOException iOException = e;
                                                aa aaVar = f3688a;
                                                Object[] objArr = new Object[1];
                                                objArr[c2] = iOException;
                                                aaVar.b("Slice checkpoint corrupt, restarting extraction. %s", objArr);
                                                i = 0;
                                            }
                                            if (i != -1 && next.d.get(i).f3682a) {
                                                aa aaVar2 = f3688a;
                                                Object[] objArr2 = new Object[5];
                                                objArr2[c2] = Integer.valueOf(next.e);
                                                objArr2[1] = Integer.valueOf(coVar.f3684a);
                                                objArr2[2] = coVar.c.f3683a;
                                                objArr2[c3] = next.f3685a;
                                                objArr2[4] = Integer.valueOf(i);
                                                aaVar2.a("Found extraction task using compression format %s for session %s, pack %s, slice %s, chunk %s.", objArr2);
                                                InputStream a2 = this.d.a(coVar.f3684a, coVar.c.f3683a, next.f3685a, i);
                                                int i4 = coVar.f3684a;
                                                cn cnVar8 = coVar.c;
                                                String str = cnVar8.f3683a;
                                                int i5 = coVar.b;
                                                long j = cnVar8.b;
                                                String str2 = next.f3685a;
                                                int i6 = next.e;
                                                int size = next.d.size();
                                                cn cnVar9 = coVar.c;
                                                bvVar = new bv(i4, str, i5, j, str2, i6, i, size, cnVar9.d, cnVar9.c, a2);
                                                break loop6;
                                            }
                                            it4 = it6;
                                        } else {
                                            Iterator it7 = it4;
                                            if (a(coVar, next)) {
                                                break loop6;
                                            }
                                            it4 = it7;
                                            c2 = 0;
                                            c3 = 3;
                                        }
                                    }
                                    continue;
                                }
                            }
                            if (bvVar == null) {
                                Iterator it8 = arrayList.iterator();
                                loop8:
                                while (true) {
                                    if (!it8.hasNext()) {
                                        dnVar = null;
                                        break;
                                    }
                                    co coVar5 = (co) it8.next();
                                    if (dd.c(coVar5.c.c)) {
                                        for (cp next5 : coVar5.c.e) {
                                            if (a(next5) && next5.d.get(0).f3682a && !a(coVar5, next5)) {
                                                f3688a.a("Found patch slice task using patch format %s for session %s, pack %s, slice %s.", Integer.valueOf(next5.f), Integer.valueOf(coVar5.f3684a), coVar5.c.f3683a, next5.f3685a);
                                                InputStream a3 = this.d.a(coVar5.f3684a, coVar5.c.f3683a, next5.f3685a, 0);
                                                int i7 = coVar5.f3684a;
                                                String str3 = coVar5.c.f3683a;
                                                dnVar = new dn(i7, str3, this.c.e(str3), this.c.f(coVar5.c.f3683a), coVar5.b, coVar5.c.b, next5.f, next5.f3685a, next5.c, a3);
                                                break loop8;
                                            }
                                        }
                                        continue;
                                    }
                                }
                            } else {
                                this.b.b();
                                return bvVar;
                            }
                        }
                    }
                }
                this.b.b();
                return dnVar;
            }
            this.b.b();
            return null;
        } catch (FileNotFoundException e2) {
            throw new by(String.format("Error finding patch, session %s packName %s sliceId %s", Integer.valueOf(coVar.f3684a), coVar.c.f3683a, next.f3685a), e2, coVar.f3684a);
        } catch (IOException e3) {
            throw new by(String.format("Failed to check number of completed merges for session %s, pack %s", Integer.valueOf(coVar2.f3684a), coVar2.c.f3683a), e3, coVar2.f3684a);
        } catch (Throwable th) {
            this.b.b();
            throw th;
        }
    }
}
