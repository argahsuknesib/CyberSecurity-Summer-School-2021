package _m_j;

import com.amap.openapi.dt;

public final class sx implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private dt f2484O000000o;
    private ox O00000Oo;
    private sw O00000o0;

    public sx(dt dtVar, sw swVar, ox oxVar) {
        this.f2484O000000o = dtVar;
        this.O00000o0 = swVar;
        this.O00000Oo = oxVar;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void run() {
        /*
            r33 = this;
            r1 = r33
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r4 = 0
            com.amap.openapi.dt r0 = r1.f2484O000000o     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r0 = r0.O00000o0()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r5 = -1
            if (r0 != r5) goto L_0x002d
            int r0 = r2.size()
            if (r0 <= 0) goto L_0x002c
        L_0x0017:
            int r0 = r2.size()
            if (r4 >= r0) goto L_0x0029
            java.lang.Object r0 = r2.get(r4)
            android.database.Cursor r0 = (android.database.Cursor) r0
            _m_j.pd.O000000o(r0)
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0029:
            r2.clear()
        L_0x002c:
            return
        L_0x002d:
            com.amap.openapi.dt r5 = r1.f2484O000000o     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            com.amap.location.uptunnel.core.db.DBProvider r5 = r5.O00000Oo()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            android.database.sqlite.SQLiteDatabase r6 = r5.O00000o0()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.sw r7 = r1.O00000o0     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r7 = r7.O00000Oo     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            android.net.Uri r13 = com.amap.openapi.dt.O00000Oo(r7)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.sw r7 = r1.O00000o0     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r7 = r7.O00000Oo     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r7 = com.amap.openapi.dt.O00000o0(r7)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            long r8 = r5.O000000o(r13)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r14 = 2
            r15 = 0
            r16 = 0
            r12 = 1
            int r10 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r10 > 0) goto L_0x00dc
            _m_j.bwk r0 = new _m_j.bwk     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r0.<init>()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r5.<init>()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r8 = "time"
            java.lang.String r9 = _m_j.pa.O000000o(r6, r15)     // Catch:{ JSONException -> 0x0076 }
            r5.put(r8, r9)     // Catch:{ JSONException -> 0x0076 }
            java.lang.String r8 = "command"
            _m_j.sw r9 = r1.O00000o0     // Catch:{ JSONException -> 0x0076 }
            org.json.JSONObject r9 = r9.O000000o()     // Catch:{ JSONException -> 0x0076 }
            r5.put(r8, r9)     // Catch:{ JSONException -> 0x0076 }
        L_0x0076:
            com.amap.openapi.dt r8 = r1.f2484O000000o     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            android.content.Context r8 = r8.O000000o()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r8 = _m_j.qw.O000000o(r0, r8)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r9 = 100003(0x186a3, float:1.40134E-40)
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            byte[] r5 = r5.getBytes()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r5 = _m_j.tg.O000000o(r0, r5)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r5 = _m_j.tg.O000000o(r0, r9, r5, r6)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int[] r6 = new int[r12]     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r6[r4] = r5     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r5 = _m_j.th.O00000Oo(r0, r6)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.th.O000000o(r0)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.th.O000000o(r0, r12)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.th.O000000o(r0, r8)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.th.O00000o0(r0, r5)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r5 = _m_j.th.O00000Oo(r0)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.th.O00000o(r0, r5)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            byte[] r0 = r0.O00000o0()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.ox r5 = r1.O00000Oo     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            com.amap.openapi.dt r6 = r1.f2484O000000o     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r6 = r6.O000000o(r14)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r7 = 60000(0xea60, float:8.4078E-41)
            _m_j.tj.O000000o(r5, r6, r0, r7)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r0 = r2.size()
            if (r0 <= 0) goto L_0x00db
        L_0x00c6:
            int r0 = r2.size()
            if (r4 >= r0) goto L_0x00d8
            java.lang.Object r0 = r2.get(r4)
            android.database.Cursor r0 = (android.database.Cursor) r0
            _m_j.pd.O000000o(r0)
            int r4 = r4 + 1
            goto L_0x00c6
        L_0x00d8:
            r2.clear()
        L_0x00db:
            return
        L_0x00dc:
            java.lang.String r8 = "select max(ID) from "
            java.lang.String r9 = java.lang.String.valueOf(r7)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r8 = r8.concat(r9)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            android.database.Cursor r8 = r6.rawQuery(r8, r15)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r2.add(r8)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r8.moveToFirst()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            long r10 = r8.getLong(r4)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.pd.O000000o(r8)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r18 = 400000(0x61a80, double:1.976263E-318)
            r20 = 1
            r22 = -1
            if (r0 != r12) goto L_0x0128
            java.lang.String r0 = "ID"
            java.lang.String[] r8 = new java.lang.String[]{r0}     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r9 = 0
            r0 = 0
            r24 = 0
            java.lang.String r25 = "0,1"
            r6 = r5
            r7 = r13
            r14 = r10
            r10 = r0
            r11 = r24
            r0 = 1
            r12 = r25
            android.database.Cursor r6 = r6.O00000Oo(r7, r8, r9, r10, r11, r12)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r2.add(r6)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r6.moveToFirst()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            long r7 = r6.getLong(r4)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.pd.O000000o(r6)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            goto L_0x01b6
        L_0x0128:
            r14 = r10
            r8 = 1
            if (r0 != 0) goto L_0x01b4
            long r10 = r14 + r20
            r11 = r10
            r9 = r16
        L_0x0131:
            int r0 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r0 >= 0) goto L_0x01ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r3 = "select min(ID) from (select * from "
            r0.<init>(r3)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r0.append(r7)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r3 = " where id < "
            r0.append(r3)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r0.append(r11)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r3 = " order by ID desc limit 0, 50)"
            r0.append(r3)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r3 = 0
            android.database.Cursor r0 = r6.rawQuery(r0, r3)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r2.add(r0)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            if (r0 == 0) goto L_0x01a6
            boolean r3 = r0.moveToFirst()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            if (r3 == 0) goto L_0x01a6
            r27 = r9
            long r8 = r0.getLong(r4)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.pd.O000000o(r0)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r0 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x01ae
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r10 = "select sum(size) from "
            r0.<init>(r10)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r0.append(r7)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r10 = " where ID >= "
            r0.append(r10)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r0.append(r8)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r10 = " and ID < "
            r0.append(r10)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r0.append(r11)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r10 = 0
            android.database.Cursor r0 = r6.rawQuery(r0, r10)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r2.add(r0)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r0.moveToFirst()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            long r10 = r0.getLong(r4)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            long r10 = r27 + r10
            _m_j.pd.O000000o(r0)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r31 = r8
            r8 = 1
            r9 = r10
            r11 = r31
            goto L_0x0131
        L_0x01a6:
            r27 = r9
            _m_j.pd.O000000o(r0)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            goto L_0x01ae
        L_0x01ac:
            r27 = r9
        L_0x01ae:
            int r0 = (r27 > r16 ? 1 : (r27 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x01b4
            r7 = r11
            goto L_0x01b6
        L_0x01b4:
            r7 = r22
        L_0x01b6:
            int r0 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x02d6
            int r0 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x02d6
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r0.<init>()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.bwk r6 = new _m_j.bwk     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r6.<init>()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String[] r9 = _m_j.td.f2492O000000o     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r11 = " id >= "
            r10.<init>(r11)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r10.append(r7)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r11 = " and id <= "
            r10.append(r11)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r10.append(r14)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r10 = r10.toString()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r11 = 0
            android.database.Cursor r9 = r5.O000000o(r13, r9, r10, r11)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r2.add(r9)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            if (r9 == 0) goto L_0x02d6
            int r10 = r9.getCount()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            if (r10 == 0) goto L_0x02d6
            r27 = r7
            r25 = r16
            r7 = r22
            r29 = r7
        L_0x01f8:
            boolean r10 = r9.moveToNext()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            if (r10 == 0) goto L_0x023c
            long r27 = r9.getLong(r4)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            long r27 = r27 + r20
            r3 = 1
            int r10 = r9.getInt(r3)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r12 = 2
            byte[] r3 = r9.getBlob(r12)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r4 = 3
            long r11 = r9.getLong(r4)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r4 = (r7 > r22 ? 1 : (r7 == r22 ? 0 : -1))
            if (r4 != 0) goto L_0x0218
            r7 = r11
        L_0x0218:
            r4 = 4
            int r4 = r9.getInt(r4)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r3 = _m_j.tg.O000000o(r6, r3)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r3 = _m_j.tg.O000000o(r6, r10, r3, r11)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r0.add(r3)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            long r3 = (long) r4     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            long r25 = r25 + r3
            int r3 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r3 < 0) goto L_0x0237
            r3 = r7
            r7 = r27
            goto L_0x0241
        L_0x0237:
            r29 = r11
            r4 = 0
            r11 = 0
            goto L_0x01f8
        L_0x023c:
            r3 = r7
            r7 = r27
            r11 = r29
        L_0x0241:
            _m_j.pd.O000000o(r9)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r9 = r0.size()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int[] r9 = new int[r9]     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r25 = r5
            r10 = 0
        L_0x024d:
            int r5 = r0.size()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            if (r10 >= r5) goto L_0x0262
            java.lang.Object r5 = r0.get(r10)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r5 = r5.intValue()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r9[r10] = r5     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r10 = r10 + 1
            goto L_0x024d
        L_0x0262:
            com.amap.openapi.dt r5 = r1.f2484O000000o     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            android.content.Context r5 = r5.O000000o()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r5 = _m_j.qw.O000000o(r6, r5)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r9 = _m_j.th.O00000Oo(r6, r9)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.th.O000000o(r6)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r10 = 1
            _m_j.th.O000000o(r6, r10)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.th.O000000o(r6, r5)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.th.O00000o0(r6, r9)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r5 = _m_j.th.O00000Oo(r6)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.th.O00000o(r6, r5)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.ox r5 = r1.O00000Oo     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            com.amap.openapi.dt r9 = r1.f2484O000000o     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            _m_j.sw r10 = r1.O00000o0     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r10 = r10.O00000Oo     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r9 = r9.O000000o(r10)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            byte[] r6 = r6.O00000o0()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r10 = 120000(0x1d4c0, float:1.68156E-40)
            boolean r5 = _m_j.tj.O000000o(r5, r9, r6, r10)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            if (r5 != 0) goto L_0x02d1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r6 = "UpTunnel fail,条数是:"
            r5.<init>(r6)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            int r0 = r0.size()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r5.append(r0)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r0 = ", 最后一条 id  是:"
            r5.append(r0)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r5.append(r7)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r0 = ",第一条时间："
            r5.append(r0)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r5.append(r3)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r0 = ",最后一条时间："
            r5.append(r0)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r5.append(r11)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            java.lang.String r0 = r5.toString()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            byte[] r0 = r0.getBytes()     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
            r3 = 800001(0xc3501, float:1.12104E-39)
            _m_j.su.O000000o(r3, r0)     // Catch:{ Throwable -> 0x02f5, all -> 0x02f3 }
        L_0x02d1:
            r5 = r25
            r4 = 0
            goto L_0x01b6
        L_0x02d6:
            int r0 = r2.size()
            if (r0 <= 0) goto L_0x033e
            r0 = 0
        L_0x02dd:
            int r3 = r2.size()
            if (r0 >= r3) goto L_0x02ef
            java.lang.Object r3 = r2.get(r0)
            android.database.Cursor r3 = (android.database.Cursor) r3
            _m_j.pd.O000000o(r3)
            int r0 = r0 + 1
            goto L_0x02dd
        L_0x02ef:
            r2.clear()
            return
        L_0x02f3:
            r0 = move-exception
            goto L_0x0305
        L_0x02f5:
            r0 = move-exception
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch:{ Exception -> 0x0322, all -> 0x02f3 }
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x0322, all -> 0x02f3 }
            r3 = 800001(0xc3501, float:1.12104E-39)
            _m_j.su.O000000o(r3, r0)     // Catch:{ Exception -> 0x0322, all -> 0x02f3 }
            goto L_0x0322
        L_0x0305:
            int r3 = r2.size()
            if (r3 <= 0) goto L_0x0321
            r3 = 0
        L_0x030c:
            int r4 = r2.size()
            if (r3 >= r4) goto L_0x031e
            java.lang.Object r4 = r2.get(r3)
            android.database.Cursor r4 = (android.database.Cursor) r4
            _m_j.pd.O000000o(r4)
            int r3 = r3 + 1
            goto L_0x030c
        L_0x031e:
            r2.clear()
        L_0x0321:
            throw r0
        L_0x0322:
            int r0 = r2.size()
            if (r0 <= 0) goto L_0x033e
            r0 = 0
        L_0x0329:
            int r3 = r2.size()
            if (r0 >= r3) goto L_0x033b
            java.lang.Object r3 = r2.get(r0)
            android.database.Cursor r3 = (android.database.Cursor) r3
            _m_j.pd.O000000o(r3)
            int r0 = r0 + 1
            goto L_0x0329
        L_0x033b:
            r2.clear()
        L_0x033e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.sx.run():void");
    }
}
