package _m_j;

import android.net.Uri;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel;
import com.ximalaya.ting.android.player.XMediaplayerJNI;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.UUID;

public final class ily {

    /* renamed from: O000000o  reason: collision with root package name */
    long f1456O000000o;
    long O00000Oo;
    private ilu O00000o;
    private String O00000o0;

    public ily(String str, ilu ilu) {
        this.O00000o0 = str;
        this.O00000o = ilu;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:1252:0x0033 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:1258:0x0033 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:1115:0x1977 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:1042:0x184b */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:1006:0x17bf */
    /* JADX INFO: additional move instructions added (3) to help type inference */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:207:0x0497 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:305:0x0613 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:244:0x04e4 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r37v6 */
    /* JADX WARN: Type inference failed for: r38v8 */
    /* JADX WARN: Type inference failed for: r21v16 */
    /* JADX WARN: Type inference failed for: r38v13 */
    /* JADX WARN: Type inference failed for: r38v19 */
    /* JADX WARN: Type inference failed for: r38v20 */
    /* JADX WARN: Type inference failed for: r38v21 */
    /* JADX WARN: Type inference failed for: r37v31 */
    /* JADX WARN: Type inference failed for: r38v32 */
    /* JADX WARN: Type inference failed for: r37v36 */
    /* JADX WARN: Type inference failed for: r37v37 */
    /* JADX WARN: Type inference failed for: r37v39 */
    /* JADX WARN: Type inference failed for: r31v29 */
    /* JADX WARN: Type inference failed for: r9v36 */
    /* JADX WARN: Type inference failed for: r21v46 */
    /* JADX WARN: Type inference failed for: r9v38 */
    /* JADX WARN: Type inference failed for: r9v39 */
    /* JADX WARN: Type inference failed for: r3v84 */
    /* JADX WARN: Type inference failed for: r9v41 */
    /* JADX WARN: Type inference failed for: r3v86 */
    /* JADX WARN: Type inference failed for: r38v47 */
    /* JADX WARN: Type inference failed for: r9v43 */
    /* JADX WARN: Type inference failed for: r3v89 */
    /* JADX WARN: Type inference failed for: r38v48 */
    /* JADX WARN: Type inference failed for: r3v95 */
    /* JADX WARN: Type inference failed for: r38v50 */
    /* JADX WARN: Type inference failed for: r9v49 */
    /* JADX WARN: Type inference failed for: r3v101 */
    /* JADX WARN: Type inference failed for: r38v52 */
    /* JADX WARN: Type inference failed for: r21v53 */
    /* JADX WARN: Type inference failed for: r21v54 */
    /* JADX WARN: Type inference failed for: r38v55 */
    /* JADX WARN: Type inference failed for: r38v56 */
    /* JADX WARN: Type inference failed for: r38v59 */
    /* JADX WARN: Type inference failed for: r37v64 */
    /* JADX WARN: Type inference failed for: r38v60 */
    /* JADX WARN: Type inference failed for: r21v61 */
    /* JADX WARN: Type inference failed for: r38v62 */
    /* JADX WARN: Type inference failed for: r21v62 */
    /* JADX WARN: Type inference failed for: r37v66 */
    /* JADX WARN: Type inference failed for: r21v63 */
    /* JADX WARN: Type inference failed for: r21v64 */
    /* JADX WARN: Type inference failed for: r31v57 */
    /* JADX WARN: Type inference failed for: r37v67 */
    /* JADX WARN: Type inference failed for: r9v75 */
    /* JADX WARN: Type inference failed for: r21v71 */
    /* JADX WARN: Type inference failed for: r38v69 */
    /* JADX WARN: Type inference failed for: r38v71 */
    /* JADX WARN: Type inference failed for: r38v72 */
    /* JADX WARN: Type inference failed for: r21v75 */
    /* JADX WARN: Type inference failed for: r21v76 */
    /* JADX WARN: Type inference failed for: r37v75 */
    /* JADX WARN: Type inference failed for: r24v51 */
    /* JADX WARN: Type inference failed for: r37v76 */
    /* JADX WARN: Type inference failed for: r24v52 */
    /* JADX WARN: Type inference failed for: r37v77 */
    /* JADX WARN: Type inference failed for: r24v53 */
    /* JADX WARN: Type inference failed for: r24v55 */
    /* JADX WARN: Type inference failed for: r24v56 */
    /* JADX WARN: Type inference failed for: r24v57 */
    /* JADX WARN: Type inference failed for: r37v83 */
    /* JADX WARN: Type inference failed for: r31v82 */
    /* JADX WARN: Type inference failed for: r37v84 */
    /* JADX WARN: Type inference failed for: r31v83 */
    /* JADX WARN: Type inference failed for: r37v85 */
    /* JADX WARN: Type inference failed for: r31v84 */
    /* JADX WARN: Type inference failed for: r38v87 */
    /* JADX WARN: Type inference failed for: r37v87 */
    /* JADX WARN: Type inference failed for: r38v88 */
    /* JADX WARN: Type inference failed for: r37v88 */
    /* JADX WARN: Type inference failed for: r38v89 */
    /* JADX WARN: Type inference failed for: r38v90 */
    /* JADX WARN: Type inference failed for: r38v91 */
    /* JADX WARN: Type inference failed for: r24v67 */
    /* JADX WARN: Type inference failed for: r38v92 */
    /* JADX WARN: Type inference failed for: r24v68 */
    /* JADX WARN: Type inference failed for: r38v93 */
    /* JADX WARN: Type inference failed for: r37v93 */
    /* JADX WARN: Type inference failed for: r24v69 */
    /* JADX WARN: Type inference failed for: r38v94 */
    /* JADX WARN: Type inference failed for: r24v71 */
    /* JADX WARN: Type inference failed for: r24v72 */
    /* JADX WARN: Type inference failed for: r31v97 */
    /* JADX WARN: Type inference failed for: r9v115 */
    /* JADX WARN: Type inference failed for: r24v78, types: [boolean] */
    /* JADX WARN: Type inference failed for: r24v79 */
    /* JADX WARN: Type inference failed for: r24v80 */
    /* JADX WARN: Type inference failed for: r24v81 */
    /* JADX WARN: Type inference failed for: r24v82 */
    /* JADX WARN: Type inference failed for: r24v83 */
    /* JADX WARN: Type inference failed for: r24v84 */
    /* JADX WARN: Type inference failed for: r24v85 */
    /* JADX WARN: Type inference failed for: r24v86 */
    /* JADX WARN: Type inference failed for: r24v87 */
    /* JADX WARN: Type inference failed for: r24v88 */
    /* JADX WARN: Type inference failed for: r24v89 */
    /* JADX WARN: Type inference failed for: r24v90 */
    /* JADX WARN: Type inference failed for: r24v91 */
    /* JADX WARN: Type inference failed for: r24v92 */
    /* JADX WARN: Type inference failed for: r24v93, types: [float] */
    /* JADX WARN: Type inference failed for: r38v110 */
    /* JADX WARN: Type inference failed for: r38v111 */
    /* JADX WARN: Type inference failed for: r38v127 */
    /* JADX WARN: Type inference failed for: r38v128 */
    /* JADX WARN: Type inference failed for: r9v163 */
    /* JADX WARN: Type inference failed for: r38v133 */
    /* JADX WARN: Type inference failed for: r21v133 */
    /* JADX WARN: Type inference failed for: r38v134 */
    /* JADX WARN: Type inference failed for: r38v135 */
    /* JADX WARN: Type inference failed for: r38v136 */
    /* JADX WARN: Type inference failed for: r9v170 */
    /* JADX WARN: Type inference failed for: r24v96 */
    /* JADX WARN: Type inference failed for: r24v98 */
    /* JADX WARN: Type inference failed for: r4v165 */
    /* JADX WARN: Type inference failed for: r38v144 */
    /* JADX WARN: Type inference failed for: r24v100 */
    /* JADX WARN: Type inference failed for: r38v147 */
    /* JADX WARN: Type inference failed for: r38v148 */
    /* JADX WARN: Type inference failed for: r24v102 */
    /* JADX WARN: Type inference failed for: r4v171 */
    /* JADX WARN: Type inference failed for: r38v149 */
    /* JADX WARN: Type inference failed for: r41v93 */
    /* JADX WARN: Type inference failed for: r24v104 */
    /* JADX WARN: Type inference failed for: r38v153 */
    /* JADX WARN: Type inference failed for: r4v176 */
    /* JADX WARN: Type inference failed for: r38v154 */
    /* JADX WARN: Type inference failed for: r24v106 */
    /* JADX WARN: Type inference failed for: r4v177 */
    /* JADX WARN: Type inference failed for: r38v155 */
    /* JADX WARN: Type inference failed for: r15v66 */
    /* JADX WARN: Type inference failed for: r24v108 */
    /* JADX WARN: Type inference failed for: r15v67 */
    /* JADX WARN: Type inference failed for: r24v117 */
    /* JADX WARN: Type inference failed for: r41v108 */
    /* JADX WARN: Type inference failed for: r38v162 */
    /* JADX WARN: Type inference failed for: r24v118 */
    /* JADX WARN: Type inference failed for: r38v163 */
    /* JADX WARN: Type inference failed for: r24v119 */
    /* JADX WARN: Type inference failed for: r41v110 */
    /* JADX WARN: Type inference failed for: r24v120 */
    /* JADX WARN: Type inference failed for: r41v111 */
    /* JADX WARN: Type inference failed for: r38v165 */
    /* JADX WARN: Type inference failed for: r24v121 */
    /* JADX WARN: Type inference failed for: r24v122 */
    /* JADX WARN: Type inference failed for: r9v189 */
    /* JADX WARN: Type inference failed for: r12v173 */
    /* JADX WARN: Type inference failed for: r15v87 */
    /* JADX WARN: Type inference failed for: r12v176 */
    /* JADX WARN: Type inference failed for: r24v133 */
    /* JADX WARN: Type inference failed for: r24v150 */
    /* JADX WARN: Type inference failed for: r37v130 */
    /* JADX WARN: Type inference failed for: r37v132 */
    /* JADX WARN: Type inference failed for: r37v133 */
    /* JADX WARN: Type inference failed for: r37v135 */
    /* JADX WARN: Type inference failed for: r38v177 */
    /* JADX WARN: Type inference failed for: r37v138 */
    /* JADX WARN: Type inference failed for: r24v153 */
    /* JADX WARN: Type inference failed for: r37v142 */
    /* JADX WARN: Type inference failed for: r37v143 */
    /* JADX WARN: Type inference failed for: r24v158 */
    /* JADX WARN: Type inference failed for: r38v183 */
    /* JADX WARN: Type inference failed for: r37v148 */
    /* JADX WARN: Type inference failed for: r24v163 */
    /* JADX WARN: Type inference failed for: r38v186 */
    /* JADX WARN: Type inference failed for: r38v187 */
    /* JADX WARN: Type inference failed for: r37v152 */
    /* JADX WARN: Type inference failed for: r37v153 */
    /* JADX WARN: Type inference failed for: r24v168 */
    /* JADX WARN: Type inference failed for: r37v154 */
    /* JADX WARN: Type inference failed for: r37v155 */
    /* JADX WARN: Type inference failed for: r38v189 */
    /* JADX WARN: Type inference failed for: r38v190 */
    /* JADX WARN: Type inference failed for: r37v158 */
    /* JADX WARN: Type inference failed for: r24v173 */
    /* JADX WARN: Type inference failed for: r37v159 */
    /* JADX WARN: Type inference failed for: r37v160 */
    /* JADX WARN: Type inference failed for: r38v192 */
    /* JADX WARN: Type inference failed for: r31v146 */
    /* JADX WARN: Type inference failed for: r24v176 */
    /* JADX WARN: Type inference failed for: r37v162 */
    /* JADX WARN: Type inference failed for: r31v147 */
    /* JADX WARN: Type inference failed for: r24v177 */
    /* JADX WARN: Type inference failed for: r37v163 */
    /* JADX WARN: Type inference failed for: r31v148 */
    /* JADX WARN: Type inference failed for: r37v164 */
    /* JADX WARN: Type inference failed for: r24v181 */
    /* JADX WARN: Type inference failed for: r3v334 */
    /* JADX WARN: Type inference failed for: r31v152 */
    /* JADX WARN: Type inference failed for: r3v335 */
    /* JADX WARN: Type inference failed for: r31v163 */
    /* JADX WARN: Type inference failed for: r3v341 */
    /* JADX WARN: Type inference failed for: r37v195 */
    /* JADX WARN: Type inference failed for: r24v205 */
    /* JADX WARN: Type inference failed for: r24v206 */
    /* JADX WARN: Type inference failed for: r24v208 */
    /* JADX WARN: Type inference failed for: r24v209 */
    /* JADX WARN: Type inference failed for: r38v235 */
    /* JADX WARN: Type inference failed for: r24v211 */
    /* JADX WARN: Type inference failed for: r24v212 */
    /* JADX WARN: Type inference failed for: r38v236 */
    /* JADX WARN: Type inference failed for: r24v213 */
    /* JADX WARN: Type inference failed for: r24v214 */
    /* JADX WARN: Type inference failed for: r24v217 */
    /* JADX WARN: Type inference failed for: r24v219 */
    /* JADX WARN: Type inference failed for: r24v221 */
    /* JADX WARN: Type inference failed for: r24v223 */
    /* JADX WARN: Type inference failed for: r24v225 */
    /* JADX WARN: Type inference failed for: r24v227 */
    /* JADX WARN: Type inference failed for: r24v228 */
    /* JADX WARN: Type inference failed for: r38v244 */
    /* JADX WARN: Type inference failed for: r15v114 */
    /* JADX WARN: Type inference failed for: r41v127 */
    /* JADX WARN: Type inference failed for: r38v245 */
    /* JADX WARN: Type inference failed for: r41v129 */
    /* JADX WARN: Type inference failed for: r41v130 */
    /* JADX WARN: Type inference failed for: r24v249 */
    /* JADX WARN: Type inference failed for: r37v214 */
    /* JADX WARN: Type inference failed for: r37v215 */
    /* JADX WARN: Type inference failed for: r37v216 */
    /* JADX WARN: Type inference failed for: r37v217 */
    /* JADX WARN: Type inference failed for: r24v260 */
    /* JADX WARN: Type inference failed for: r37v219 */
    /* JADX WARN: Type inference failed for: r24v264 */
    /* JADX WARN: Type inference failed for: r24v268 */
    /* JADX WARN: Type inference failed for: r37v222 */
    /* JADX WARN: Type inference failed for: r37v223 */
    /* JADX WARN: Type inference failed for: r24v272 */
    /* JADX WARN: Type inference failed for: r38v247 */
    /* JADX WARN: Type inference failed for: r38v248 */
    /* JADX WARN: Type inference failed for: r37v224 */
    /* JADX WARN: Type inference failed for: r24v276 */
    /* JADX WARN: Type inference failed for: r37v225 */
    /* JADX WARN: Type inference failed for: r24v278 */
    /* JADX WARN: Type inference failed for: r37v226 */
    /* JADX WARN: Type inference failed for: r24v279 */
    /* JADX WARN: Type inference failed for: r24v280 */
    /* JADX WARN: Type inference failed for: r24v281 */
    /* JADX WARN: Type inference failed for: r37v228 */
    /* JADX WARN: Type inference failed for: r37v229 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imq.O000000o(float, boolean):float
     arg types: [float, int]
     candidates:
      _m_j.imq.O000000o(_m_j.imo, com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel):void
      _m_j.imq.O000000o(float, boolean):float */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imq.O000000o(float, boolean):float
     arg types: [boolean, int]
     candidates:
      _m_j.imq.O000000o(_m_j.imo, com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel):void
      _m_j.imq.O000000o(float, boolean):float */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imq.O000000o(float, boolean):float
     arg types: [?, int]
     candidates:
      _m_j.imq.O000000o(_m_j.imo, com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel):void
      _m_j.imq.O000000o(float, boolean):float */
    /* JADX WARNING: Code restructure failed: missing block: B:1004:0x179d, code lost:
        r7 = java.lang.System.currentTimeMillis() - r29;
        r14.O0000Oo = _m_j.imq.O000000o((float) r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1011:0x17e0, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000Oo0) != false) goto L_0x17e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1012:0x17e2, code lost:
        r14.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1014:0x17eb, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000OOo) != false) goto L_0x17ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1015:0x17ed, code lost:
        r14.O0000OOo = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1016:0x17ef, code lost:
        r39 = r7;
        r14.O0000OoO = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1020:0x1803, code lost:
        r14.O0000o = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1023:0x180a, code lost:
        r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1026:?, code lost:
        r35.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1030:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1036:0x182a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1037:0x182b, code lost:
        r37 = r2;
        r21 = r3;
        r38 = r4;
        r36 = r5;
        r6 = r7;
        r2 = r8;
        r4 = r9;
        r31 = r15;
        r39 = r22;
        r3 = r32;
        r22 = r11;
        r23 = r13;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1045:0x1851, code lost:
        r7 = java.lang.System.currentTimeMillis() - r29;
        r14.O0000Oo = _m_j.imq.O000000o((float) r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1050:0x187d, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000Oo0) != false) goto L_0x187f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1051:0x187f, code lost:
        r14.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1053:0x1888, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000OOo) != false) goto L_0x188a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1054:0x188a, code lost:
        r14.O0000OOo = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1055:0x188c, code lost:
        r32 = r7;
        r14.O0000OoO = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1059:0x18a0, code lost:
        r14.O0000o = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1062:0x18a7, code lost:
        r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1065:?, code lost:
        r35.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1069:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1072:0x18bf, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1073:0x18c0, code lost:
        r37 = r2;
        r21 = r3;
        r38 = r4;
        r36 = r5;
        r6 = r7;
        r2 = r8;
        r4 = r9;
        r31 = r15;
        r39 = r22;
        r3 = r32;
        r22 = r11;
        r23 = r13;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1081:0x18e6, code lost:
        r7 = java.lang.System.currentTimeMillis() - r29;
        r14.O0000Oo = _m_j.imq.O000000o((float) r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1086:0x1912, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000Oo0) != false) goto L_0x1914;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1087:0x1914, code lost:
        r14.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1089:0x191d, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000OOo) != false) goto L_0x191f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1090:0x191f, code lost:
        r14.O0000OOo = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1091:0x1921, code lost:
        r32 = r7;
        r14.O0000OoO = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1095:0x1935, code lost:
        r14.O0000o = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1098:0x193c, code lost:
        r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1101:?, code lost:
        r35.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1105:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1108:0x1954, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1109:0x1955, code lost:
        r37 = r2;
        r21 = r3;
        r38 = r4;
        r36 = r5;
        r6 = r7;
        r2 = r8;
        r4 = r9;
        r31 = r15;
        r39 = r22;
        r3 = r32;
        r22 = r11;
        r23 = r13;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02fc, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1118:0x197f, code lost:
        r7 = java.lang.System.currentTimeMillis() - r29;
        r14.O0000Oo = _m_j.imq.O000000o((float) r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fd, code lost:
        r15 = r10;
        r1 = r11;
        r37 = r12;
        r10 = r38;
        r7 = r39;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1121:0x1997, code lost:
        r14.O0000O0o = "cdn_socket_timeout";
        r14.O00000oo = java.lang.String.valueOf(r1) + _m_j.imq.O000000o(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1122:0x19b5, code lost:
        r14.O0000O0o = "cdn_connect_timeout";
        r14.O00000oo = _m_j.imq.O000000o(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1127:0x19d2, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000Oo0) != false) goto L_0x19d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1128:0x19d4, code lost:
        r14.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1130:0x19dd, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000OOo) != false) goto L_0x19df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1131:0x19df, code lost:
        r14.O0000OOo = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1132:0x19e1, code lost:
        r32 = r7;
        r14.O0000OoO = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1136:0x19f5, code lost:
        r14.O0000o = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1139:0x19fc, code lost:
        r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1142:?, code lost:
        r35.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1146:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1150:0x1a26, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1151:0x1a27, code lost:
        r37 = r2;
        r21 = r3;
        r38 = r4;
        r36 = r5;
        r6 = r7;
        r2 = r8;
        r4 = r9;
        r31 = r15;
        r39 = r22;
        r3 = r32;
        r22 = r11;
        r23 = r13;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1159:0x1a4d, code lost:
        r7 = java.lang.System.currentTimeMillis() - r29;
        r14.O0000Oo = _m_j.imq.O000000o((float) r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1161:0x1a70, code lost:
        r0 = th;
        r37 = r37;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1167:0x1a94, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000Oo0) != false) goto L_0x1a96;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1168:0x1a96, code lost:
        r14.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0317, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1170:0x1a9f, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000OOo) != false) goto L_0x1aa1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1171:0x1aa1, code lost:
        r14.O0000OOo = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1172:0x1aa3, code lost:
        r39 = r7;
        r14.O0000OoO = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1176:0x1ab7, code lost:
        r14.O0000o = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1179:0x1abe, code lost:
        r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0318, code lost:
        r9 = r3;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1182:?, code lost:
        r35.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1186:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1196:0x1af8, code lost:
        r1 = r22;
        _m_j.imq.O000000o(r14, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1206:0x1b2e, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000Oo0) != false) goto L_0x1b30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1207:0x1b30, code lost:
        r14.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1209:0x1b39, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000OOo) != false) goto L_0x1b3b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1210:0x1b3b, code lost:
        r14.O0000OOo = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1211:0x1b3d, code lost:
        r11 = r3;
        r14.O0000OoO = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1215:0x1b50, code lost:
        r14.O0000o = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1216:0x1b52, code lost:
        if (r5 != false) goto L_0x1c44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1219:0x1b59, code lost:
        if (r2 == 0) goto L_0x1b5b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1220:0x1b5b, code lost:
        r4.f1456O000000o = (long) r1.O00000Oo;
        r4.O00000Oo = (long) r1.O00000o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1221:0x1b6d, code lost:
        if (r7 > (r4.f1456O000000o * 1000)) goto L_0x1b6f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1222:0x1b6f, code lost:
        r14.O0000O0o = r36;
        r14.O00000oo = r38 + _m_j.imq.O000000o((float) r7, false) + r21 + r4.f1456O000000o + r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1224:0x1b9f, code lost:
        if (((float) r4.O00000Oo) > r15) goto L_0x1ba1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1225:0x1ba1, code lost:
        r14.O0000O0o = "cdn_download_too_slow";
        r14.O00000oo = "download_speed=" + _m_j.imq.O000000o(r15, true) + "KB/s, download_speed_threshold=" + r4.O00000Oo + "KB/s";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1226:0x1bcb, code lost:
        r17 = r11;
        r10 = r21;
        r3 = r36;
        r13 = r37;
        r5 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1227:0x1bd8, code lost:
        if (r2 == 1) goto L_0x1bda;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1228:0x1bda, code lost:
        r18 = r12;
        r4.f1456O000000o = (long) r1.f12180O000000o;
        r4.O00000Oo = (long) r1.O00000o0;
        r4.f1456O000000o = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1229:0x1bf0, code lost:
        if (r7 > (r4.f1456O000000o * 1000)) goto L_0x1bf2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x032e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1230:0x1bf2, code lost:
        r14.O0000O0o = r3;
        r14.O00000oo = r5 + _m_j.imq.O000000o((float) r7, false) + r10 + r4.f1456O000000o + r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1232:0x1c19, code lost:
        if (((float) r4.O00000Oo) > r15) goto L_0x1c1b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1233:0x1c1b, code lost:
        r14.O0000O0o = "cdn_download_too_slow";
        r14.O00000oo = "download_speed=" + _m_j.imq.O000000o(r15, true) + "KB/s, download_speed_threshold=" + r4.O00000Oo + "KB/s";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1235:0x1c46, code lost:
        r17 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1239:0x1c51, code lost:
        r18.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x032f, code lost:
        r1 = r0;
        r21 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1242:?, code lost:
        r35.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1246:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x034a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x034b, code lost:
        r1 = r0;
        r21 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0368, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0369, code lost:
        r1 = r0;
        r21 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0386, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0387, code lost:
        r1 = r0;
        r21 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x03a4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x03a5, code lost:
        r1 = r0;
        r21 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03c2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03c3, code lost:
        r1 = r0;
        r21 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x043d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x043e, code lost:
        r39 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0457, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0458, code lost:
        r1 = r0;
        r21 = r3;
        r31 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x045f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0460, code lost:
        r1 = r0;
        r21 = r3;
        r31 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0467, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0468, code lost:
        r1 = r0;
        r21 = r3;
        r31 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x046f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0470, code lost:
        r1 = r0;
        r21 = r3;
        r31 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0477, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0478, code lost:
        r1 = r0;
        r21 = r3;
        r31 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x047f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0480, code lost:
        r1 = r0;
        r21 = r3;
        r31 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x06bb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x06bc, code lost:
        r12 = r6;
        r1 = r11;
        r15 = r24;
        r6 = r36;
        r10 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x06c6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x06c7, code lost:
        r12 = r6;
        r39 = r7;
        r7 = r9;
        r13 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x06d9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x06da, code lost:
        r1 = r0;
        r21 = r3;
        r12 = r6;
        r13 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x06e6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x06e7, code lost:
        r1 = r0;
        r21 = r3;
        r12 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x06f3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x06f4, code lost:
        r1 = r0;
        r21 = r3;
        r12 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x0700, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x0701, code lost:
        r1 = r0;
        r21 = r3;
        r12 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x070d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x070e, code lost:
        r1 = r0;
        r21 = r3;
        r12 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x071a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x071b, code lost:
        r1 = r0;
        r21 = r3;
        r12 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:807:0x13f5, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:808:0x13f6, code lost:
        r15 = r2;
        r6 = r7;
        r39 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:809:0x13fc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:810:0x13fd, code lost:
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:811:0x13ff, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:812:0x1400, code lost:
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:813:0x1402, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:814:0x1403, code lost:
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:815:0x1406, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:816:0x1407, code lost:
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:817:0x140a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:818:0x140b, code lost:
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:819:0x140e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0298, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:820:0x140f, code lost:
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0299, code lost:
        r15 = r10;
        r1 = r11;
        r37 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:845:0x14c2, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:846:0x14c3, code lost:
        r6 = r7;
        r39 = r22;
        r23 = r13;
        r43 = r9;
        r9 = r3;
        r3 = r4;
        r4 = r43;
        r37 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:850:0x14e5, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:851:0x14e6, code lost:
        r6 = r7;
        r31 = r15;
        r39 = r22;
        r15 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:858:0x1507, code lost:
        if (android.text.TextUtils.isEmpty(r14.O00000oO) != false) goto L_0x1509;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:860:0x150d, code lost:
        r21 = r9;
        r8 = java.lang.System.currentTimeMillis() - r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:861:0x1515, code lost:
        if (r8 != 0) goto L_0x1517;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:862:0x1517, code lost:
        r37 = r15;
        r38 = r3;
        r15 = ((((float) r13) + 0.0f) / 1024.0f) / ((((float) r8) + 0.0f) / 1000.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:863:0x152b, code lost:
        r38 = r3;
        r37 = r15;
        r15 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:865:?, code lost:
        r3 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:866:0x1536, code lost:
        r36 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:868:?, code lost:
        r3.append(_m_j.imq.O000000o(r15, true));
        r14.O00000oO = r3.toString();
        r14.O0000o0O = java.lang.String.valueOf(r13);
        r14.O0000o0o = java.lang.String.valueOf(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:869:0x1552, code lost:
        r24 = r15;
        r38 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:870:0x1555, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:871:0x1557, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:872:0x1558, code lost:
        r36 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:873:0x155a, code lost:
        r3 = r0;
        r9 = r7;
        r1 = r11;
        r2 = r22;
        r38 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:874:0x1560, code lost:
        r38 = r3;
        r36 = r5;
        r21 = r9;
        r37 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:877:0x156c, code lost:
        if (r14.O0000Oo <= 0.0f) goto L_0x156e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:879:0x1572, code lost:
        r8 = java.lang.System.currentTimeMillis() - r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:881:?, code lost:
        r14.O0000Oo = _m_j.imq.O000000o((float) r8, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:882:0x157c, code lost:
        r39 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:883:0x157f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:884:0x1580, code lost:
        r3 = r0;
        r1 = r11;
        r2 = r22;
        r15 = r24;
        r5 = true;
        r9 = r7;
        r7 = r8;
        r38 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:886:?, code lost:
        r14.O0000o0O = r10;
        r14.O0000O0o = "cdn_unknown_exception";
        r14.O00000oo = _m_j.imq.O000000o(r2);
        r38 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:887:0x159b, code lost:
        r0 = th;
        r38 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:888:0x159d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:889:0x159e, code lost:
        r38 = r3;
        r36 = r5;
        r21 = r9;
        r37 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:890:0x15a6, code lost:
        r3 = r0;
        r9 = r7;
        r1 = r11;
        r2 = r22;
        r15 = r24;
        r38 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:891:0x15ad, code lost:
        r7 = r39;
        r38 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:896:0x15c3, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000Oo0) != false) goto L_0x15c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:897:0x15c5, code lost:
        r14.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:899:0x15ce, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000OOo) != false) goto L_0x15d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:900:0x15d0, code lost:
        r14.O0000OOo = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:901:0x15d2, code lost:
        r14.O0000OoO = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:902:0x15da, code lost:
        if (r14.O0000o != null) goto L_0x15dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:903:0x15dc, code lost:
        r2 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:904:0x15e4, code lost:
        if (r14.O0000o.contains(r2) == false) goto L_0x15e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:905:0x15e7, code lost:
        r2 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:906:0x15e9, code lost:
        r14.O0000o = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:909:0x15f0, code lost:
        r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:912:?, code lost:
        r35.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:916:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:919:0x161e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:920:0x161f, code lost:
        r37 = r2;
        r21 = r3;
        r38 = r4;
        r36 = r5;
        r6 = r7;
        r2 = r8;
        r4 = r9;
        r31 = r15;
        r39 = r22;
        r23 = r13;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:927:0x1643, code lost:
        if (android.text.TextUtils.isEmpty(r14.O00000oO) != false) goto L_0x1645;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:929:0x1649, code lost:
        r41 = r7;
        r7 = java.lang.System.currentTimeMillis() - r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:930:0x1651, code lost:
        if (r7 != 0) goto L_0x1653;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:931:0x1653, code lost:
        r3 = ((((float) r13) + 0.0f) / 1024.0f) / ((((float) r7) + 0.0f) / 1000.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:932:0x1661, code lost:
        r3 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:934:?, code lost:
        r5 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:935:0x1668, code lost:
        r22 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:937:?, code lost:
        r5.append(_m_j.imq.O000000o(r3, true));
        r14.O00000oO = r5.toString();
        r14.O0000o0O = java.lang.String.valueOf(r13);
        r14.O0000o0o = java.lang.String.valueOf(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:938:0x1684, code lost:
        r24 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:939:0x1687, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:940:0x1688, code lost:
        r15 = r3;
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:941:0x168c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:942:0x168d, code lost:
        r15 = r3;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:943:0x168f, code lost:
        r7 = r41;
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:945:0x1695, code lost:
        r41 = r7;
        r22 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:948:0x169d, code lost:
        if (r14.O0000Oo <= 0.0f) goto L_0x169f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:950:0x16a3, code lost:
        r7 = java.lang.System.currentTimeMillis() - r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:952:?, code lost:
        r14.O0000Oo = _m_j.imq.O000000o((float) r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:953:0x16ae, code lost:
        r7 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:955:0x16b4, code lost:
        if (r1.getMessage() == null) goto L_0x16d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:960:0x16ce, code lost:
        r3 = r32;
        r14.O0000o0O = r3;
        r14.O0000o0o = r3;
        r14.O0000O0o = "system_exception";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:961:0x16d9, code lost:
        r3 = r32;
        r14.O0000O0o = "cdn_io_exception";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:962:0x16df, code lost:
        r14.O00000oo = _m_j.imq.O000000o(r1);
        r14.O0000o = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:963:0x16e8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:964:0x16e9, code lost:
        r3 = r0;
        r1 = r22;
        r15 = r24;
        r7 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:965:0x16f2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:966:0x16f3, code lost:
        r3 = r0;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:973:0x1722, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000Oo0) != false) goto L_0x1724;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:974:0x1724, code lost:
        r14.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:976:0x172d, code lost:
        if (android.text.TextUtils.isEmpty(r14.O0000OOo) != false) goto L_0x172f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:977:0x172f, code lost:
        r14.O0000OOo = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:978:0x1731, code lost:
        r39 = r7;
        r14.O0000OoO = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:982:0x1745, code lost:
        r14.O0000o = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:985:0x174c, code lost:
        r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:988:?, code lost:
        r35.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:992:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:995:0x1776, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:996:0x1777, code lost:
        r37 = r2;
        r21 = r3;
        r38 = r4;
        r36 = r5;
        r6 = r7;
        r2 = r8;
        r4 = r9;
        r31 = r15;
        r39 = r22;
        r3 = r32;
        r22 = r11;
        r23 = r13;
        r1 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:1004:0x179d A[Catch:{ all -> 0x1a70 }] */
    /* JADX WARNING: Removed duplicated region for block: B:1009:0x17d8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:1023:0x180a  */
    /* JADX WARNING: Removed duplicated region for block: B:1025:0x180f A[SYNTHETIC, Splitter:B:1025:0x180f] */
    /* JADX WARNING: Removed duplicated region for block: B:1029:0x1816 A[SYNTHETIC, Splitter:B:1029:0x1816] */
    /* JADX WARNING: Removed duplicated region for block: B:1045:0x1851 A[Catch:{ all -> 0x1a70 }] */
    /* JADX WARNING: Removed duplicated region for block: B:1048:0x1875 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:1062:0x18a7  */
    /* JADX WARNING: Removed duplicated region for block: B:1064:0x18ac A[SYNTHETIC, Splitter:B:1064:0x18ac] */
    /* JADX WARNING: Removed duplicated region for block: B:1068:0x18b3 A[SYNTHETIC, Splitter:B:1068:0x18b3] */
    /* JADX WARNING: Removed duplicated region for block: B:1081:0x18e6 A[Catch:{ all -> 0x1a70 }] */
    /* JADX WARNING: Removed duplicated region for block: B:1084:0x190a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:1098:0x193c  */
    /* JADX WARNING: Removed duplicated region for block: B:1100:0x1941 A[SYNTHETIC, Splitter:B:1100:0x1941] */
    /* JADX WARNING: Removed duplicated region for block: B:1104:0x1948 A[SYNTHETIC, Splitter:B:1104:0x1948] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02fc A[ExcHandler: all (th java.lang.Throwable), PHI: r39 10  PHI: (r39v99 long) = (r39v89 long), (r39v89 long), (r39v70 long) binds: [B:170:0x03f4, B:171:?, B:73:0x0268] A[DONT_GENERATE, DONT_INLINE], Splitter:B:73:0x0268] */
    /* JADX WARNING: Removed duplicated region for block: B:1118:0x197f A[Catch:{ all -> 0x1a70 }] */
    /* JADX WARNING: Removed duplicated region for block: B:1121:0x1997 A[Catch:{ all -> 0x1a70 }] */
    /* JADX WARNING: Removed duplicated region for block: B:1122:0x19b5 A[Catch:{ all -> 0x1a70 }] */
    /* JADX WARNING: Removed duplicated region for block: B:1125:0x19ca A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:1139:0x19fc  */
    /* JADX WARNING: Removed duplicated region for block: B:1141:0x1a01 A[SYNTHETIC, Splitter:B:1141:0x1a01] */
    /* JADX WARNING: Removed duplicated region for block: B:1145:0x1a08 A[SYNTHETIC, Splitter:B:1145:0x1a08] */
    /* JADX WARNING: Removed duplicated region for block: B:1159:0x1a4d A[Catch:{ all -> 0x1a70 }] */
    /* JADX WARNING: Removed duplicated region for block: B:1165:0x1a8c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:1179:0x1abe  */
    /* JADX WARNING: Removed duplicated region for block: B:1181:0x1ac3 A[SYNTHETIC, Splitter:B:1181:0x1ac3] */
    /* JADX WARNING: Removed duplicated region for block: B:1185:0x1aca A[SYNTHETIC, Splitter:B:1185:0x1aca] */
    /* JADX WARNING: Removed duplicated region for block: B:1191:0x1ae6 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:1204:0x1b26 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:1239:0x1c51  */
    /* JADX WARNING: Removed duplicated region for block: B:1241:0x1c56 A[SYNTHETIC, Splitter:B:1241:0x1c56] */
    /* JADX WARNING: Removed duplicated region for block: B:1245:0x1c5d A[SYNTHETIC, Splitter:B:1245:0x1c5d] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x04c9 A[Catch:{ MalformedURLException -> 0x05f6, SocketTimeoutException -> 0x05e0, UnknownHostException -> 0x05ca, IllegalArgumentException -> 0x05b4, FileNotFoundException -> 0x059e, IOException -> 0x0588, Throwable -> 0x0573, all -> 0x055d }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x04cc A[Catch:{ MalformedURLException -> 0x05f6, SocketTimeoutException -> 0x05e0, UnknownHostException -> 0x05ca, IllegalArgumentException -> 0x05b4, FileNotFoundException -> 0x059e, IOException -> 0x0588, Throwable -> 0x0573, all -> 0x055d }] */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x06bb A[ExcHandler: all (th java.lang.Throwable), Splitter:B:343:0x06b6] */
    /* JADX WARNING: Removed duplicated region for block: B:481:0x09ac  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x09b1 A[SYNTHETIC, Splitter:B:483:0x09b1] */
    /* JADX WARNING: Removed duplicated region for block: B:487:0x09b8 A[SYNTHETIC, Splitter:B:487:0x09b8] */
    /* JADX WARNING: Removed duplicated region for block: B:544:0x0b48  */
    /* JADX WARNING: Removed duplicated region for block: B:546:0x0b4d A[SYNTHETIC, Splitter:B:546:0x0b4d] */
    /* JADX WARNING: Removed duplicated region for block: B:550:0x0b54 A[SYNTHETIC, Splitter:B:550:0x0b54] */
    /* JADX WARNING: Removed duplicated region for block: B:661:0x0f0c  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0298 A[ExcHandler: all (th java.lang.Throwable), PHI: r7 10  PHI: (r7v181 long) = (r7v106 long), (r7v183 long), (r7v183 long), (r7v183 long), (r7v183 long) binds: [B:167:0x03ea, B:76:0x0270, B:77:?, B:79:0x0294, B:80:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:76:0x0270] */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x14c2 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:850:0x14e5 A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:12:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:855:0x14ff A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x15bb A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:909:0x15f0  */
    /* JADX WARNING: Removed duplicated region for block: B:911:0x15f5 A[SYNTHETIC, Splitter:B:911:0x15f5] */
    /* JADX WARNING: Removed duplicated region for block: B:915:0x15fc A[SYNTHETIC, Splitter:B:915:0x15fc] */
    /* JADX WARNING: Removed duplicated region for block: B:924:0x163b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:971:0x171a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:985:0x174c  */
    /* JADX WARNING: Removed duplicated region for block: B:987:0x1751 A[SYNTHETIC, Splitter:B:987:0x1751] */
    /* JADX WARNING: Removed duplicated region for block: B:991:0x1758 A[SYNTHETIC, Splitter:B:991:0x1758] */
    /* JADX WARNING: Unknown variable types count: 5 */
    public final int O000000o() {
        int i;
        long currentTimeMillis;
        String str;
        Object obj;
        Object obj2;
        String str2;
        InputStream inputStream;
        boolean z;
        String str3;
        float f;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        long j;
        String str4;
        boolean z2;
        String str5;
        Throwable th;
        String str6;
        CdnConfigModel cdnConfigModel;
        HttpURLConnection httpURLConnection2;
        long j2;
        String str7;
        CdnConfigModel cdnConfigModel2;
        String str8;
        StringBuilder sb;
        String str9;
        MalformedURLException malformedURLException;
        CdnConfigModel cdnConfigModel3;
        Throwable th2;
        Object obj3;
        String str10;
        CdnConfigModel cdnConfigModel4;
        String str11;
        HttpURLConnection httpURLConnection3;
        String str12;
        String str13;
        long j3;
        String str14;
        CdnConfigModel cdnConfigModel5;
        String str15;
        String str16;
        String str17;
        MalformedURLException malformedURLException2;
        ByteArrayOutputStream byteArrayOutputStream2;
        HttpURLConnection httpURLConnection4;
        String str18;
        String str19;
        boolean z3;
        MalformedURLException malformedURLException3;
        StringBuilder sb2;
        String str20;
        String str21;
        SocketTimeoutException socketTimeoutException;
        Object obj4;
        String str22;
        String str23;
        CdnConfigModel cdnConfigModel6;
        Object obj5;
        HttpURLConnection httpURLConnection5;
        String str24;
        String str25;
        String str26;
        long j4;
        ? r38;
        String str27;
        CdnConfigModel cdnConfigModel7;
        String str28;
        String str29;
        String str30;
        SocketTimeoutException socketTimeoutException2;
        ByteArrayOutputStream byteArrayOutputStream3;
        HttpURLConnection httpURLConnection6;
        String str31;
        String str32;
        boolean z4;
        SocketTimeoutException socketTimeoutException3;
        UnknownHostException unknownHostException;
        String str33;
        String str34;
        CdnConfigModel cdnConfigModel8;
        String str35;
        HttpURLConnection httpURLConnection7;
        String str36;
        String str37;
        String str38;
        long j5;
        String str39;
        String str40;
        CdnConfigModel cdnConfigModel9;
        String str41;
        String str42;
        String str43;
        String str44;
        UnknownHostException unknownHostException2;
        ByteArrayOutputStream byteArrayOutputStream4;
        HttpURLConnection httpURLConnection8;
        String str45;
        String str46;
        boolean z5;
        UnknownHostException unknownHostException3;
        IllegalArgumentException illegalArgumentException;
        String str47;
        String str48;
        CdnConfigModel cdnConfigModel10;
        String str49;
        HttpURLConnection httpURLConnection9;
        String str50;
        String str51;
        long j6;
        ? r382;
        String str52;
        CdnConfigModel cdnConfigModel11;
        String str53;
        String str54;
        String str55;
        IllegalArgumentException illegalArgumentException2;
        ByteArrayOutputStream byteArrayOutputStream5;
        HttpURLConnection httpURLConnection10;
        String str56;
        String str57;
        boolean z6;
        IllegalArgumentException illegalArgumentException3;
        FileNotFoundException fileNotFoundException;
        String str58;
        String str59;
        String str60;
        HttpURLConnection httpURLConnection11;
        String str61;
        String str62;
        long j7;
        String str63;
        CdnConfigModel cdnConfigModel12;
        String str64;
        String str65;
        String str66;
        FileNotFoundException fileNotFoundException2;
        ByteArrayOutputStream byteArrayOutputStream6;
        HttpURLConnection httpURLConnection12;
        String str67;
        String str68;
        boolean z7;
        FileNotFoundException fileNotFoundException3;
        int i2;
        IOException iOException;
        Object obj6;
        String str69;
        String str70;
        String str71;
        String str72;
        String str73;
        long j8;
        String str74;
        String str75;
        IOException iOException2;
        int i3;
        ByteArrayOutputStream byteArrayOutputStream7;
        HttpURLConnection httpURLConnection13;
        String str76;
        String str77;
        IOException iOException3;
        boolean z8;
        String str78;
        String str79;
        int i4;
        String str80;
        ByteArrayOutputStream byteArrayOutputStream8;
        String str81;
        Throwable th3;
        HttpURLConnection httpURLConnection14;
        String str82;
        String str83;
        long j9;
        String str84;
        String str85;
        String str86;
        String str87;
        int i5;
        ByteArrayOutputStream byteArrayOutputStream9;
        HttpURLConnection httpURLConnection15;
        Object obj7;
        String str88;
        Object obj8;
        String str89;
        float f2;
        HttpURLConnection httpURLConnection16;
        String str90;
        boolean z9;
        String str91;
        CdnConfigModel cdnConfigModel13;
        InputStream inputStream2;
        Throwable th4;
        String str92;
        String str93;
        String str94;
        CdnConfigModel cdnConfigModel14;
        String str95;
        String str96;
        String str97;
        String str98;
        String str99;
        String str100;
        String str101;
        String str102;
        String str103;
        String str104;
        String str105;
        String str106;
        String str107;
        HttpURLConnection O000000o2;
        HttpURLConnection httpURLConnection17;
        Object obj9;
        ? r21;
        HttpURLConnection httpURLConnection18;
        Object obj10;
        HttpURLConnection httpURLConnection19;
        HttpURLConnection httpURLConnection20;
        String str108;
        HttpURLConnection httpURLConnection21;
        String str109;
        ? r212;
        HttpURLConnection httpURLConnection22;
        Object obj11;
        ? r213;
        HttpURLConnection httpURLConnection23;
        float f3;
        HttpURLConnection httpURLConnection24;
        String str110;
        String str111;
        String str112;
        String str113;
        String str114;
        String str115;
        HttpURLConnection httpURLConnection25;
        Object obj12;
        String str116;
        float f4;
        String str117;
        String str118;
        String str119;
        MalformedURLException malformedURLException4;
        String str120;
        SocketTimeoutException socketTimeoutException4;
        UnknownHostException unknownHostException4;
        String str121;
        IllegalArgumentException illegalArgumentException4;
        FileNotFoundException fileNotFoundException4;
        String str122;
        IOException iOException4;
        String str123;
        String str124;
        int i6;
        ByteArrayOutputStream byteArrayOutputStream10;
        String str125;
        String str126;
        int responseCode;
        Object obj13;
        Object obj14;
        Object obj15;
        Object obj16;
        String str127;
        MalformedURLException malformedURLException5;
        HttpURLConnection httpURLConnection26;
        ByteArrayOutputStream byteArrayOutputStream11;
        InputStream inputStream3;
        Object obj17;
        Object obj18;
        Object obj19;
        Object obj20;
        Object obj21;
        Object obj22;
        String str128;
        SocketTimeoutException socketTimeoutException5;
        HttpURLConnection httpURLConnection27;
        ByteArrayOutputStream byteArrayOutputStream12;
        InputStream inputStream4;
        Object obj23;
        String str129;
        String str130;
        UnknownHostException unknownHostException5;
        HttpURLConnection httpURLConnection28;
        ByteArrayOutputStream byteArrayOutputStream13;
        InputStream inputStream5;
        String str131;
        String str132;
        String str133;
        String str134;
        IllegalArgumentException illegalArgumentException5;
        HttpURLConnection httpURLConnection29;
        ByteArrayOutputStream byteArrayOutputStream14;
        InputStream inputStream6;
        String str135;
        String str136;
        Object obj24;
        Object obj25;
        String str137;
        FileNotFoundException fileNotFoundException5;
        HttpURLConnection httpURLConnection30;
        ByteArrayOutputStream byteArrayOutputStream15;
        InputStream inputStream7;
        Object obj26;
        String str138;
        String str139;
        HttpURLConnection httpURLConnection31;
        String str140;
        String str141;
        IOException iOException5;
        int i7;
        long j10;
        HttpURLConnection httpURLConnection32;
        Object obj27;
        String str142;
        String str143;
        MalformedURLException malformedURLException6;
        String str144;
        String str145;
        String str146;
        String str147;
        SocketTimeoutException socketTimeoutException6;
        String str148;
        String str149;
        String str150;
        String str151;
        UnknownHostException unknownHostException6;
        String str152;
        String str153;
        String str154;
        String str155;
        IllegalArgumentException illegalArgumentException6;
        String str156;
        String str157;
        String str158;
        String str159;
        HttpURLConnection httpURLConnection33;
        String str160;
        String str161;
        FileNotFoundException fileNotFoundException6;
        String str162;
        String str163;
        String str164;
        IOException iOException6;
        String str165;
        String str166;
        HttpURLConnection httpURLConnection34;
        String str167;
        String str168;
        HttpURLConnection httpURLConnection35;
        String str169;
        String str170;
        boolean z10;
        String str171;
        CdnConfigModel cdnConfigModel15;
        String str172;
        boolean z11;
        String str173;
        CdnConfigModel cdnConfigModel16;
        InputStream inputStream8;
        String str174;
        String str175;
        float f5;
        boolean z12;
        boolean z13;
        String str176;
        String str177;
        HttpURLConnection httpURLConnection36;
        MalformedURLException malformedURLException7;
        MalformedURLException malformedURLException8;
        boolean z14;
        String str178;
        HttpURLConnection httpURLConnection37;
        SocketTimeoutException socketTimeoutException7;
        SocketTimeoutException socketTimeoutException8;
        boolean z15;
        String str179;
        HttpURLConnection httpURLConnection38;
        UnknownHostException unknownHostException7;
        UnknownHostException unknownHostException8;
        HttpURLConnection httpURLConnection39;
        boolean z16;
        String str180;
        HttpURLConnection httpURLConnection40;
        IllegalArgumentException illegalArgumentException7;
        IllegalArgumentException illegalArgumentException8;
        HttpURLConnection httpURLConnection41;
        Object obj28;
        boolean z17;
        String str181;
        FileNotFoundException fileNotFoundException7;
        FileNotFoundException fileNotFoundException8;
        boolean z18;
        String str182;
        IOException iOException7;
        IOException iOException8;
        boolean z19;
        String str183;
        ByteArrayOutputStream byteArrayOutputStream16;
        String str184;
        long j11;
        ByteArrayOutputStream byteArrayOutputStream17;
        String str185;
        int read;
        boolean z20;
        int i8;
        String str186;
        int i9;
        ByteArrayOutputStream byteArrayOutputStream18;
        int i10;
        int i11;
        String str187;
        String str188;
        String str189;
        String str190;
        String str191;
        String str192;
        HttpURLConnection httpURLConnection42;
        String str193;
        String str194;
        ByteArrayOutputStream byteArrayOutputStream19;
        String str195;
        InputStream inputStream9;
        String str196;
        ByteArrayOutputStream byteArrayOutputStream20;
        String str197;
        InputStream inputStream10;
        String str198;
        ByteArrayOutputStream byteArrayOutputStream21;
        String str199;
        InputStream inputStream11;
        String str200;
        ByteArrayOutputStream byteArrayOutputStream22;
        String str201;
        InputStream inputStream12;
        String str202;
        ByteArrayOutputStream byteArrayOutputStream23;
        String str203;
        InputStream inputStream13;
        String str204;
        ByteArrayOutputStream byteArrayOutputStream24;
        String str205;
        InputStream inputStream14;
        String str206;
        ByteArrayOutputStream byteArrayOutputStream25;
        String str207;
        InputStream inputStream15;
        String str208;
        String str209;
        String str210;
        String str211;
        String str212;
        String str213;
        String str214;
        String str215;
        boolean z21;
        String str216;
        boolean z22;
        Object obj29;
        float f6;
        String str217;
        boolean z23;
        String str218;
        boolean z24;
        String str219;
        Object obj30;
        float f7;
        String str220;
        boolean z25;
        String str221;
        boolean z26;
        String str222;
        Object obj31;
        float f8;
        String str223;
        boolean z27;
        String str224;
        boolean z28;
        String str225;
        String str226;
        float f9;
        String str227;
        boolean z29;
        String str228;
        Object obj32;
        boolean z30;
        String str229;
        String str230;
        float f10;
        String str231;
        String str232;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        long j12;
        String str233;
        String str234;
        String str235;
        float f19;
        String str236;
        boolean z31;
        String str237;
        long j13;
        Object obj33;
        String str238;
        Object obj34;
        ily ily = this;
        String str239 = "s";
        String str240 = "s, connected_time_threshold=";
        String str241 = "connected_time=";
        String str242 = "cdn_connected_too_slow";
        String str243 = "0";
        String str244 = "DownloadThread hls readData end:";
        String str245 = "success";
        String str246 = "";
        String str247 = "failed";
        CdnConfigModel cdnConfigModel17 = imq.f1481O000000o;
        boolean z32 = cdnConfigModel17 == null;
        String uuid = UUID.randomUUID().toString();
        boolean z33 = z32;
        imo imo = null;
        int i12 = 3;
        boolean z34 = false;
        long j14 = 0;
        float f20 = 0.0f;
        long j15 = 0;
        int i13 = 0;
        while (true) {
            i = i12 - 1;
            if (i12 <= 0) {
                return -1;
            }
            currentTimeMillis = System.currentTimeMillis();
            imo imo2 = imo;
            str = str243;
            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "DownloadThread hls readData start:".concat(String.valueOf(currentTimeMillis)));
            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread hls readData mCurrentDownloadUrl:" + ily.O00000o0));
            imo = !z33 ? new imo() : imo2;
            try {
                str7 = uuid;
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread mPlayUrl:" + ily.O00000o0));
                String[] strArr = {ily.O00000o0};
                String host = TextUtils.isEmpty(ily.O00000o0) ? str246 : Uri.parse(ily.O00000o0).getHost();
                obj2 = str239;
                str107 = str244;
                try {
                    O000000o2 = imf.O000000o(strArr, null, 4, false, "GET");
                    try {
                        ily.O00000o0 = strArr[0];
                        if (O000000o2 == null) {
                            if (z33 || imo == null) {
                                str236 = str245;
                                str233 = str247;
                                j12 = j14;
                                f19 = f20;
                                str235 = obj2;
                                str234 = str246;
                                z31 = z33;
                            } else {
                                if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                    imo.O0000Oo0 = null;
                                }
                                if (TextUtils.isEmpty(imo.O0000OOo)) {
                                    imo.O0000OOo = str246;
                                }
                                boolean z35 = z33;
                                imo.O0000OoO = System.currentTimeMillis();
                                if (imo.O0000o == null || !imo.O0000o.contains(str245)) {
                                    imo.O0000o = str247;
                                }
                                if (!z34) {
                                    int i14 = cdnConfigModel17.O00000oO;
                                    if (i14 == -1) {
                                        str236 = str245;
                                        str233 = str247;
                                        j12 = j14;
                                        f19 = f20;
                                        str235 = obj2;
                                        z33 = true;
                                        str234 = str246;
                                        if (O000000o2 != null) {
                                            O000000o2.disconnect();
                                        }
                                        String str248 = XMediaplayerJNI.O0000o0;
                                        StringBuilder sb3 = new StringBuilder(str107);
                                        float f21 = f19;
                                        sb3.append(System.currentTimeMillis() - currentTimeMillis);
                                        imc.O000000o(str248, (Object) sb3.toString());
                                        str245 = str236;
                                        f20 = f21;
                                        str239 = str235;
                                        str246 = str234;
                                        i12 = i;
                                        uuid = str7;
                                        str243 = str;
                                        str244 = str107;
                                        str247 = str233;
                                        j14 = j12;
                                    } else {
                                        if (i14 == 0) {
                                            ily.f1456O000000o = (long) cdnConfigModel17.O00000Oo;
                                            ily.O00000Oo = (long) cdnConfigModel17.O00000o;
                                            String str249 = str246;
                                            str233 = str247;
                                            j13 = j14;
                                            if (j13 > ily.f1456O000000o * 1000) {
                                                imo.O0000O0o = str242;
                                                StringBuilder sb4 = new StringBuilder(str241);
                                                sb4.append(imq.O000000o((float) j13, false));
                                                sb4.append(str240);
                                                sb4.append(ily.f1456O000000o);
                                                str237 = obj2;
                                                sb4.append(str237);
                                                imo.O00000oo = sb4.toString();
                                                z31 = z35;
                                                str236 = str245;
                                                j12 = j13;
                                                str234 = str249;
                                            } else {
                                                String str250 = str245;
                                                str235 = obj2;
                                                f19 = f20;
                                                if (((float) ily.O00000Oo) > f19) {
                                                    imo.O0000O0o = "cdn_download_too_slow";
                                                    str234 = str249;
                                                    StringBuilder sb5 = new StringBuilder("download_speed=");
                                                    z31 = z35;
                                                    sb5.append(imq.O000000o(f19, true));
                                                    sb5.append("KB/s, download_speed_threshold=");
                                                    obj2 = str235;
                                                    str236 = str250;
                                                    sb5.append(ily.O00000Oo);
                                                    sb5.append("KB/s");
                                                    imo.O00000oo = sb5.toString();
                                                    j12 = j13;
                                                    str235 = obj2;
                                                } else {
                                                    z31 = z35;
                                                    str236 = str250;
                                                    str234 = str249;
                                                }
                                            }
                                        } else {
                                            str233 = str247;
                                            long j16 = j14;
                                            z31 = z35;
                                            str236 = str245;
                                            str234 = str246;
                                            j13 = j16;
                                            f19 = f20;
                                            if (i14 == 1) {
                                                ily.f1456O000000o = (long) cdnConfigModel17.f12180O000000o;
                                                ily.O00000Oo = (long) cdnConfigModel17.O00000o0;
                                                ily.f1456O000000o = 0;
                                                if (j13 > ily.f1456O000000o * 1000) {
                                                    imo.O0000O0o = str242;
                                                    StringBuilder sb6 = new StringBuilder(str241);
                                                    sb6.append(imq.O000000o((float) j13, false));
                                                    sb6.append(str240);
                                                    sb6.append(ily.f1456O000000o);
                                                    str235 = obj2;
                                                    sb6.append(str235);
                                                    imo.O00000oo = sb6.toString();
                                                } else {
                                                    j12 = j13;
                                                    str235 = obj2;
                                                    if (((float) ily.O00000Oo) > f19) {
                                                        imo.O0000O0o = "cdn_download_too_slow";
                                                        imo.O00000oo = "download_speed=" + imq.O000000o(f19, true) + "KB/s, download_speed_threshold=" + ily.O00000Oo + "KB/s";
                                                    }
                                                }
                                            }
                                            j12 = j13;
                                            str235 = obj2;
                                        }
                                        j12 = j13;
                                    }
                                } else {
                                    str233 = str247;
                                    j12 = j14;
                                    str237 = obj2;
                                    z31 = z35;
                                    str236 = str245;
                                    str234 = str246;
                                }
                                f19 = f20;
                            }
                            z33 = z31;
                            if (O000000o2 != null) {
                            }
                            String str2482 = XMediaplayerJNI.O0000o0;
                            StringBuilder sb32 = new StringBuilder(str107);
                            float f212 = f19;
                            sb32.append(System.currentTimeMillis() - currentTimeMillis);
                            imc.O000000o(str2482, (Object) sb32.toString());
                            str245 = str236;
                            f20 = f212;
                            str239 = str235;
                            str246 = str234;
                            i12 = i;
                            uuid = str7;
                            str243 = str;
                            str244 = str107;
                            str247 = str233;
                            j14 = j12;
                        } else {
                            str6 = str245;
                            str116 = str247;
                            long j17 = j14;
                            f4 = f20;
                            str117 = obj2;
                            str118 = str246;
                            z = z33;
                            if (imo != null) {
                                try {
                                    j = System.currentTimeMillis() - currentTimeMillis;
                                    try {
                                        imo.O0000Oo = imq.O000000o((float) j, false);
                                        imo.f1479O000000o = ily.O00000o0;
                                        imo.O00000o0 = imq.O000000o(ily.O00000o0);
                                        imo.O0000oO0 = host;
                                        imo.O0000Ooo = "play_hls";
                                        imo.O0000Oo0 = O000000o2.getHeaderField("via");
                                        str119 = str7;
                                        imo.O0000oO = str119;
                                    } catch (MalformedURLException e) {
                                        malformedURLException4 = e;
                                        str120 = str240;
                                    } catch (SocketTimeoutException e2) {
                                        socketTimeoutException4 = e2;
                                        String str251 = str240;
                                        f14 = f4;
                                        str210 = str251;
                                        obj30 = str117;
                                        str26 = str;
                                        str198 = str116;
                                        f7 = f14;
                                        str220 = str210;
                                        byteArrayOutputStream21 = null;
                                        inputStream10 = null;
                                        obj2 = obj30;
                                        z8 = f7;
                                        str197 = str220;
                                        obj4 = str241;
                                        httpURLConnection37 = O000000o2;
                                        str25 = str118;
                                        str24 = str107;
                                        obj2 = obj2;
                                        z24 = z8;
                                        str219 = str197;
                                        str23 = str242;
                                        z23 = z24;
                                        str218 = str219;
                                        cdnConfigModel6 = cdnConfigModel17;
                                        f20 = z23;
                                        obj5 = str218;
                                        imo.O00000oO = "0.0";
                                        if (imo.O0000Oo <= 0.0f) {
                                        }
                                        if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                        }
                                        imo.O0000o0O = str21;
                                        imo.O0000o0o = str21;
                                        imo.O0000o = str247;
                                        imo.O00000o = true;
                                        if (!z) {
                                        }
                                        long j18 = j;
                                        if (httpURLConnection != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        str20 = XMediaplayerJNI.O0000o0;
                                        sb2 = new StringBuilder(str4);
                                        str7 = str7;
                                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                        imc.O000000o(str20, (Object) sb2.toString());
                                        j2 = r32;
                                        f20 = f20;
                                        if (imo != null) {
                                        }
                                        CdnConfigModel cdnConfigModel18 = cdnConfigModel2;
                                        cdnConfigModel17 = cdnConfigModel18;
                                        str245 = str6;
                                        str246 = str5;
                                        str244 = str4;
                                        z33 = z;
                                        i12 = i;
                                        uuid = str7;
                                        str242 = str2;
                                        str239 = obj2;
                                        str241 = obj;
                                        j14 = j2;
                                        ily = this;
                                        str243 = str8;
                                        str240 = str3;
                                        z34 = true;
                                    } catch (UnknownHostException e3) {
                                        unknownHostException4 = e3;
                                        str121 = str240;
                                        f15 = f4;
                                        obj31 = str117;
                                        str38 = str;
                                        str200 = str116;
                                        f8 = f15;
                                        str223 = str121;
                                        byteArrayOutputStream22 = null;
                                        inputStream11 = null;
                                        obj2 = obj31;
                                        z8 = f8;
                                        str199 = str223;
                                        obj4 = str241;
                                        httpURLConnection38 = O000000o2;
                                        str37 = str118;
                                        str36 = str107;
                                        z26 = z8;
                                        str222 = str199;
                                        str34 = str242;
                                        z25 = z26;
                                        str221 = str222;
                                        cdnConfigModel8 = cdnConfigModel17;
                                        f20 = z25;
                                        str35 = str221;
                                        if (imo.O0000Oo <= 0.0f) {
                                        }
                                        imo.O0000O0o = "dns_fail";
                                        imo.O00000oo = imq.O000000o(unknownHostException);
                                        imo.O00000oO = "0.0";
                                        imo.O0000o0O = str21;
                                        imo.O0000o0o = str21;
                                        imo.O0000o = str247;
                                        if (!z) {
                                        }
                                        long j19 = j;
                                        if (httpURLConnection != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        str20 = XMediaplayerJNI.O0000o0;
                                        sb2 = new StringBuilder(str4);
                                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                        imc.O000000o(str20, (Object) sb2.toString());
                                        j2 = r32;
                                        f20 = f20;
                                        if (imo != null) {
                                        }
                                        CdnConfigModel cdnConfigModel182 = cdnConfigModel2;
                                        cdnConfigModel17 = cdnConfigModel182;
                                        str245 = str6;
                                        str246 = str5;
                                        str244 = str4;
                                        z33 = z;
                                        i12 = i;
                                        uuid = str7;
                                        str242 = str2;
                                        str239 = obj2;
                                        str241 = obj;
                                        j14 = j2;
                                        ily = this;
                                        str243 = str8;
                                        str240 = str3;
                                        z34 = true;
                                    } catch (IllegalArgumentException e4) {
                                        illegalArgumentException4 = e4;
                                        String str252 = str240;
                                        f16 = f4;
                                        str211 = str252;
                                        str226 = str117;
                                        str21 = str;
                                        str202 = str116;
                                        f9 = f16;
                                        str227 = str211;
                                        byteArrayOutputStream23 = null;
                                        inputStream12 = null;
                                        obj2 = str226;
                                        z8 = f9;
                                        str201 = str227;
                                        obj4 = str241;
                                        httpURLConnection40 = O000000o2;
                                        str51 = str118;
                                        str50 = str107;
                                        z28 = z8;
                                        str225 = str201;
                                        str48 = str242;
                                        obj2 = obj2;
                                        z27 = z28;
                                        str224 = str225;
                                        cdnConfigModel10 = cdnConfigModel17;
                                        f20 = z27;
                                        str238 = str224;
                                        if (imo.O0000Oo <= 0.0f) {
                                        }
                                        imo.O0000O0o = "dns_fail";
                                        imo.O00000oo = imq.O000000o(illegalArgumentException);
                                        imo.O00000oO = "0.0";
                                        imo.O0000o0O = str21;
                                        imo.O0000o0o = str21;
                                        imo.O0000o = str247;
                                        if (!z) {
                                        }
                                        long j20 = j;
                                        if (httpURLConnection != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        str20 = XMediaplayerJNI.O0000o0;
                                        sb2 = new StringBuilder(str4);
                                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                        imc.O000000o(str20, (Object) sb2.toString());
                                        j2 = j20;
                                        f20 = f20;
                                        if (imo != null) {
                                        }
                                        CdnConfigModel cdnConfigModel1822 = cdnConfigModel2;
                                        cdnConfigModel17 = cdnConfigModel1822;
                                        str245 = str6;
                                        str246 = str5;
                                        str244 = str4;
                                        z33 = z;
                                        i12 = i;
                                        uuid = str7;
                                        str242 = str2;
                                        str239 = obj2;
                                        str241 = obj;
                                        j14 = j2;
                                        ily = this;
                                        str243 = str8;
                                        str240 = str3;
                                        z34 = true;
                                    } catch (FileNotFoundException e5) {
                                        fileNotFoundException4 = e5;
                                        str122 = str240;
                                        f17 = f4;
                                        str230 = str117;
                                        str8 = str;
                                        str204 = str116;
                                        f10 = f17;
                                        str231 = str122;
                                        byteArrayOutputStream24 = null;
                                        inputStream13 = null;
                                        obj2 = str230;
                                        z8 = f10;
                                        str203 = str231;
                                        obj32 = str241;
                                        httpURLConnection11 = O000000o2;
                                        str62 = str118;
                                        str61 = str107;
                                        z30 = z8;
                                        str229 = str203;
                                        str59 = str242;
                                        str161 = obj32;
                                        z29 = z30;
                                        str228 = str229;
                                        cdnConfigModel2 = cdnConfigModel17;
                                        obj = str161;
                                        f20 = z29;
                                        obj34 = str228;
                                        if (imo.O0000Oo <= 0.0f) {
                                        }
                                        imo.O0000O0o = "system_exception";
                                        imo.O00000oo = imq.O000000o(fileNotFoundException);
                                        imo.O00000oO = "0.0";
                                        imo.O0000o0O = str8;
                                        imo.O0000o0o = str8;
                                        imo.O0000o = str247;
                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                        if (!z) {
                                        }
                                        long j21 = j;
                                        if (httpURLConnection != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        str9 = XMediaplayerJNI.O0000o0;
                                        sb = new StringBuilder(str4);
                                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                                        imc.O000000o(str9, (Object) sb.toString());
                                        f20 = f20;
                                        if (imo != null) {
                                        }
                                        CdnConfigModel cdnConfigModel18222 = cdnConfigModel2;
                                        cdnConfigModel17 = cdnConfigModel18222;
                                        str245 = str6;
                                        str246 = str5;
                                        str244 = str4;
                                        z33 = z;
                                        i12 = i;
                                        uuid = str7;
                                        str242 = str2;
                                        str239 = obj2;
                                        str241 = obj;
                                        j14 = j2;
                                        ily = this;
                                        str243 = str8;
                                        str240 = str3;
                                        z34 = true;
                                    } catch (IOException e6) {
                                        iOException4 = e6;
                                        String str253 = str240;
                                        f18 = f4;
                                        str212 = str253;
                                        str232 = str117;
                                        i2 = i13;
                                        str206 = str116;
                                        f11 = f18;
                                        byteArrayOutputStream25 = null;
                                        inputStream14 = null;
                                        obj2 = str232;
                                        z8 = f11;
                                        str205 = str212;
                                        obj4 = str241;
                                        httpURLConnection31 = O000000o2;
                                        str73 = str118;
                                        str72 = str107;
                                        obj2 = obj2;
                                        z8 = z8;
                                        str139 = str205;
                                        str70 = str242;
                                        f20 = z8;
                                        str3 = str139;
                                        if (!z) {
                                        }
                                        cdnConfigModel2 = cdnConfigModel17;
                                        String str254 = str;
                                        j = j;
                                        try {
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                            if (!z) {
                                            }
                                            long j22 = j;
                                            if (httpURLConnection != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                            i13 = i2;
                                            if (imo != null) {
                                            }
                                            CdnConfigModel cdnConfigModel182222 = cdnConfigModel2;
                                            cdnConfigModel17 = cdnConfigModel182222;
                                            str245 = str6;
                                            str246 = str5;
                                            str244 = str4;
                                            z33 = z;
                                            i12 = i;
                                            uuid = str7;
                                            str242 = str2;
                                            str239 = obj2;
                                            str241 = obj;
                                            j14 = j2;
                                            ily = this;
                                            str243 = str8;
                                            str240 = str3;
                                            z34 = true;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            obj = obj;
                                            String str255 = obj2;
                                            str3 = str3;
                                            th2 = th;
                                            cdnConfigModel3 = cdnConfigModel2;
                                            obj2 = str255;
                                            float f22 = f20;
                                            obj = obj;
                                            obj2 = obj2;
                                            z2 = true;
                                            obj = obj;
                                            obj2 = obj2;
                                            if (!z) {
                                            }
                                            Throwable th6 = th;
                                            httpURLConnection2 = httpURLConnection;
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                            throw th6;
                                        }
                                    } catch (Throwable th7) {
                                    }
                                } catch (MalformedURLException e7) {
                                    malformedURLException = e7;
                                    String str256 = str240;
                                    str7 = str119;
                                    f6 = f4;
                                    obj29 = str117;
                                    str13 = str;
                                    str196 = str116;
                                    j = j17;
                                    str217 = str256;
                                    byteArrayOutputStream20 = null;
                                    inputStream9 = null;
                                    obj2 = obj29;
                                    z8 = f6;
                                    str195 = str217;
                                    obj4 = str241;
                                    httpURLConnection36 = O000000o2;
                                    str5 = str118;
                                    str12 = str107;
                                    obj2 = obj2;
                                    z22 = z8;
                                    str176 = str195;
                                    str10 = str242;
                                    z21 = z22;
                                    str216 = str176;
                                    cdnConfigModel4 = cdnConfigModel17;
                                    f20 = z21;
                                    obj33 = str216;
                                    if (imo.O0000Oo <= 0.0f) {
                                    }
                                    imo.O0000O0o = "cdn_connect_fail ";
                                    imo.O00000oo = imq.O000000o(malformedURLException);
                                    imo.O00000oO = "0.0";
                                    imo.O0000o0O = str8;
                                    imo.O0000o0o = str8;
                                    imo.O0000o = str247;
                                    try {
                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                        if (!z) {
                                        }
                                        long j23 = j;
                                        if (httpURLConnection != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        str9 = XMediaplayerJNI.O0000o0;
                                        sb = new StringBuilder(str4);
                                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                                        imc.O000000o(str9, (Object) sb.toString());
                                        f20 = f20;
                                        if (imo != null) {
                                        }
                                        CdnConfigModel cdnConfigModel1822222 = cdnConfigModel2;
                                        cdnConfigModel17 = cdnConfigModel1822222;
                                        str245 = str6;
                                        str246 = str5;
                                        str244 = str4;
                                        z33 = z;
                                        i12 = i;
                                        uuid = str7;
                                        str242 = str2;
                                        str239 = obj2;
                                        str241 = obj;
                                        j14 = j2;
                                        ily = this;
                                        str243 = str8;
                                        str240 = str3;
                                        z34 = true;
                                    } catch (Throwable th8) {
                                        cdnConfigModel3 = cdnConfigModel2;
                                        th2 = th8;
                                        float f222 = f20;
                                        obj = obj;
                                        obj2 = obj2;
                                        z2 = true;
                                        obj = obj;
                                        obj2 = obj2;
                                        if (!z) {
                                        }
                                        Throwable th62 = th;
                                        httpURLConnection2 = httpURLConnection;
                                        if (httpURLConnection2 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                        throw th62;
                                    }
                                } catch (SocketTimeoutException e8) {
                                    socketTimeoutException = e8;
                                    String str257 = str240;
                                    str7 = str119;
                                    f7 = f4;
                                    obj30 = str117;
                                    str26 = str;
                                    str198 = str116;
                                    j = j17;
                                    str220 = str257;
                                    byteArrayOutputStream21 = null;
                                    inputStream10 = null;
                                    obj2 = obj30;
                                    z8 = f7;
                                    str197 = str220;
                                    obj4 = str241;
                                    httpURLConnection37 = O000000o2;
                                    str25 = str118;
                                    str24 = str107;
                                    obj2 = obj2;
                                    z24 = z8;
                                    str219 = str197;
                                    str23 = str242;
                                    z23 = z24;
                                    str218 = str219;
                                    cdnConfigModel6 = cdnConfigModel17;
                                    f20 = z23;
                                    obj5 = str218;
                                    imo.O00000oO = "0.0";
                                    if (imo.O0000Oo <= 0.0f) {
                                    }
                                    if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                    }
                                    imo.O0000o0O = str21;
                                    imo.O0000o0o = str21;
                                    imo.O0000o = str247;
                                    imo.O00000o = true;
                                    if (!z) {
                                    }
                                    long j182 = j;
                                    if (httpURLConnection != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    str20 = XMediaplayerJNI.O0000o0;
                                    sb2 = new StringBuilder(str4);
                                    str7 = str7;
                                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                    imc.O000000o(str20, (Object) sb2.toString());
                                    j2 = j20;
                                    f20 = f20;
                                    if (imo != null) {
                                    }
                                    CdnConfigModel cdnConfigModel18222222 = cdnConfigModel2;
                                    cdnConfigModel17 = cdnConfigModel18222222;
                                    str245 = str6;
                                    str246 = str5;
                                    str244 = str4;
                                    z33 = z;
                                    i12 = i;
                                    uuid = str7;
                                    str242 = str2;
                                    str239 = obj2;
                                    str241 = obj;
                                    j14 = j2;
                                    ily = this;
                                    str243 = str8;
                                    str240 = str3;
                                    z34 = true;
                                } catch (UnknownHostException e9) {
                                    unknownHostException = e9;
                                    String str258 = str240;
                                    str7 = str119;
                                    f8 = f4;
                                    obj31 = str117;
                                    str38 = str;
                                    str200 = str116;
                                    j = j17;
                                    str223 = str258;
                                    byteArrayOutputStream22 = null;
                                    inputStream11 = null;
                                    obj2 = obj31;
                                    z8 = f8;
                                    str199 = str223;
                                    obj4 = str241;
                                    httpURLConnection38 = O000000o2;
                                    str37 = str118;
                                    str36 = str107;
                                    z26 = z8;
                                    str222 = str199;
                                    str34 = str242;
                                    z25 = z26;
                                    str221 = str222;
                                    cdnConfigModel8 = cdnConfigModel17;
                                    f20 = z25;
                                    str35 = str221;
                                    if (imo.O0000Oo <= 0.0f) {
                                    }
                                    imo.O0000O0o = "dns_fail";
                                    imo.O00000oo = imq.O000000o(unknownHostException);
                                    imo.O00000oO = "0.0";
                                    imo.O0000o0O = str21;
                                    imo.O0000o0o = str21;
                                    imo.O0000o = str247;
                                    if (!z) {
                                    }
                                    long j192 = j;
                                    if (httpURLConnection != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    str20 = XMediaplayerJNI.O0000o0;
                                    sb2 = new StringBuilder(str4);
                                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                    imc.O000000o(str20, (Object) sb2.toString());
                                    j2 = j20;
                                    f20 = f20;
                                    if (imo != null) {
                                    }
                                    CdnConfigModel cdnConfigModel182222222 = cdnConfigModel2;
                                    cdnConfigModel17 = cdnConfigModel182222222;
                                    str245 = str6;
                                    str246 = str5;
                                    str244 = str4;
                                    z33 = z;
                                    i12 = i;
                                    uuid = str7;
                                    str242 = str2;
                                    str239 = obj2;
                                    str241 = obj;
                                    j14 = j2;
                                    ily = this;
                                    str243 = str8;
                                    str240 = str3;
                                    z34 = true;
                                } catch (IllegalArgumentException e10) {
                                    illegalArgumentException = e10;
                                    String str259 = str240;
                                    str7 = str119;
                                    f9 = f4;
                                    str226 = str117;
                                    str21 = str;
                                    str202 = str116;
                                    j = j17;
                                    str227 = str259;
                                    byteArrayOutputStream23 = null;
                                    inputStream12 = null;
                                    obj2 = str226;
                                    z8 = f9;
                                    str201 = str227;
                                    obj4 = str241;
                                    httpURLConnection40 = O000000o2;
                                    str51 = str118;
                                    str50 = str107;
                                    z28 = z8;
                                    str225 = str201;
                                    str48 = str242;
                                    obj2 = obj2;
                                    z27 = z28;
                                    str224 = str225;
                                    cdnConfigModel10 = cdnConfigModel17;
                                    f20 = z27;
                                    str238 = str224;
                                    if (imo.O0000Oo <= 0.0f) {
                                    }
                                    imo.O0000O0o = "dns_fail";
                                    imo.O00000oo = imq.O000000o(illegalArgumentException);
                                    imo.O00000oO = "0.0";
                                    imo.O0000o0O = str21;
                                    imo.O0000o0o = str21;
                                    imo.O0000o = str247;
                                    if (!z) {
                                    }
                                    long j202 = j;
                                    if (httpURLConnection != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    str20 = XMediaplayerJNI.O0000o0;
                                    sb2 = new StringBuilder(str4);
                                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                    imc.O000000o(str20, (Object) sb2.toString());
                                    j2 = j202;
                                    f20 = f20;
                                    if (imo != null) {
                                    }
                                    CdnConfigModel cdnConfigModel1822222222 = cdnConfigModel2;
                                    cdnConfigModel17 = cdnConfigModel1822222222;
                                    str245 = str6;
                                    str246 = str5;
                                    str244 = str4;
                                    z33 = z;
                                    i12 = i;
                                    uuid = str7;
                                    str242 = str2;
                                    str239 = obj2;
                                    str241 = obj;
                                    j14 = j2;
                                    ily = this;
                                    str243 = str8;
                                    str240 = str3;
                                    z34 = true;
                                } catch (FileNotFoundException e11) {
                                    fileNotFoundException = e11;
                                    String str260 = str240;
                                    str7 = str119;
                                    f10 = f4;
                                    str230 = str117;
                                    str8 = str;
                                    str204 = str116;
                                    j = j17;
                                    str231 = str260;
                                    byteArrayOutputStream24 = null;
                                    inputStream13 = null;
                                    obj2 = str230;
                                    z8 = f10;
                                    str203 = str231;
                                    obj32 = str241;
                                    httpURLConnection11 = O000000o2;
                                    str62 = str118;
                                    str61 = str107;
                                    z30 = z8;
                                    str229 = str203;
                                    str59 = str242;
                                    str161 = obj32;
                                    z29 = z30;
                                    str228 = str229;
                                    cdnConfigModel2 = cdnConfigModel17;
                                    obj = str161;
                                    f20 = z29;
                                    obj34 = str228;
                                    if (imo.O0000Oo <= 0.0f) {
                                    }
                                    imo.O0000O0o = "system_exception";
                                    imo.O00000oo = imq.O000000o(fileNotFoundException);
                                    imo.O00000oO = "0.0";
                                    imo.O0000o0O = str8;
                                    imo.O0000o0o = str8;
                                    imo.O0000o = str247;
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                    if (!z) {
                                    }
                                    long j212 = j;
                                    if (httpURLConnection != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    str9 = XMediaplayerJNI.O0000o0;
                                    sb = new StringBuilder(str4);
                                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                                    imc.O000000o(str9, (Object) sb.toString());
                                    f20 = f20;
                                    if (imo != null) {
                                    }
                                    CdnConfigModel cdnConfigModel18222222222 = cdnConfigModel2;
                                    cdnConfigModel17 = cdnConfigModel18222222222;
                                    str245 = str6;
                                    str246 = str5;
                                    str244 = str4;
                                    z33 = z;
                                    i12 = i;
                                    uuid = str7;
                                    str242 = str2;
                                    str239 = obj2;
                                    str241 = obj;
                                    j14 = j2;
                                    ily = this;
                                    str243 = str8;
                                    str240 = str3;
                                    z34 = true;
                                } catch (IOException e12) {
                                    iOException = e12;
                                    String str261 = str240;
                                    str7 = str119;
                                    f11 = f4;
                                    str232 = str117;
                                    i2 = i13;
                                    str206 = str116;
                                    j = j17;
                                    str212 = str261;
                                    byteArrayOutputStream25 = null;
                                    inputStream14 = null;
                                    obj2 = str232;
                                    z8 = f11;
                                    str205 = str212;
                                    obj4 = str241;
                                    httpURLConnection31 = O000000o2;
                                    str73 = str118;
                                    str72 = str107;
                                    obj2 = obj2;
                                    z8 = z8;
                                    str139 = str205;
                                    str70 = str242;
                                    f20 = z8;
                                    str3 = str139;
                                    if (!z) {
                                    }
                                    cdnConfigModel2 = cdnConfigModel17;
                                    String str2542 = str;
                                    j = j;
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                    if (!z) {
                                    }
                                    long j222 = j;
                                    if (httpURLConnection != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                    i13 = i2;
                                    if (imo != null) {
                                    }
                                    CdnConfigModel cdnConfigModel182222222222 = cdnConfigModel2;
                                    cdnConfigModel17 = cdnConfigModel182222222222;
                                    str245 = str6;
                                    str246 = str5;
                                    str244 = str4;
                                    z33 = z;
                                    i12 = i;
                                    uuid = str7;
                                    str242 = str2;
                                    str239 = obj2;
                                    str241 = obj;
                                    j14 = j2;
                                    ily = this;
                                    str243 = str8;
                                    str240 = str3;
                                    z34 = true;
                                } catch (Throwable th9) {
                                }
                            } else {
                                str119 = str7;
                                j = j17;
                            }
                            try {
                                responseCode = O000000o2.getResponseCode();
                                if (imo != null) {
                                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                    j17 = currentTimeMillis2;
                                    imo.O0000Oo = imq.O000000o((float) currentTimeMillis2, false);
                                    imo.O0000Oo0 = O000000o2.getHeaderField("via");
                                    imo.O0000OOo = String.valueOf(responseCode);
                                    j = j17;
                                }
                            } catch (MalformedURLException e13) {
                                httpURLConnection17 = O000000o2;
                                str7 = str119;
                                f20 = f4;
                                str15 = str107;
                                str247 = str116;
                                String str262 = str240;
                                String str263 = str241;
                                str16 = str118;
                                malformedURLException2 = e13;
                                obj9 = str263;
                                str14 = str242;
                                r21 = str262;
                                cdnConfigModel5 = cdnConfigModel17;
                                obj2 = str117;
                                str17 = str;
                                httpURLConnection4 = httpURLConnection17;
                                byteArrayOutputStream2 = null;
                                obj3 = obj9;
                                str11 = r21;
                                inputStream = null;
                                obj4 = obj3;
                                obj2 = obj2;
                                obj33 = str11;
                                if (imo.O0000Oo <= 0.0f) {
                                }
                                imo.O0000O0o = "cdn_connect_fail ";
                                imo.O00000oo = imq.O000000o(malformedURLException);
                                imo.O00000oO = "0.0";
                                imo.O0000o0O = str8;
                                imo.O0000o0o = str8;
                                imo.O0000o = str247;
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                if (!z) {
                                }
                                long j232 = j;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                str9 = XMediaplayerJNI.O0000o0;
                                sb = new StringBuilder(str4);
                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                imc.O000000o(str9, (Object) sb.toString());
                                f20 = f20;
                                if (imo != null) {
                                }
                                CdnConfigModel cdnConfigModel1822222222222 = cdnConfigModel2;
                                cdnConfigModel17 = cdnConfigModel1822222222222;
                                str245 = str6;
                                str246 = str5;
                                str244 = str4;
                                z33 = z;
                                i12 = i;
                                uuid = str7;
                                str242 = str2;
                                str239 = obj2;
                                str241 = obj;
                                j14 = j2;
                                ily = this;
                                str243 = str8;
                                str240 = str3;
                                z34 = true;
                            } catch (SocketTimeoutException e14) {
                                httpURLConnection18 = O000000o2;
                                str7 = str119;
                                f20 = f4;
                                str28 = str107;
                                str247 = str116;
                                String str264 = str240;
                                String str265 = str241;
                                str29 = str118;
                                socketTimeoutException2 = e14;
                                r38 = str265;
                                str27 = str242;
                                obj10 = str264;
                                cdnConfigModel7 = cdnConfigModel17;
                                obj2 = str117;
                                str30 = str;
                                httpURLConnection6 = httpURLConnection18;
                                byteArrayOutputStream3 = null;
                                str22 = obj2;
                                obj5 = obj10;
                                inputStream = null;
                                obj2 = str22;
                                str7 = str7;
                                f20 = f20;
                                imo.O00000oO = "0.0";
                                if (imo.O0000Oo <= 0.0f) {
                                }
                                if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                }
                                imo.O0000o0O = str21;
                                imo.O0000o0o = str21;
                                imo.O0000o = str247;
                                imo.O00000o = true;
                                if (!z) {
                                }
                                long j1822 = j;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                str20 = XMediaplayerJNI.O0000o0;
                                sb2 = new StringBuilder(str4);
                                str7 = str7;
                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                imc.O000000o(str20, (Object) sb2.toString());
                                j2 = j202;
                                f20 = f20;
                                if (imo != null) {
                                }
                                CdnConfigModel cdnConfigModel18222222222222 = cdnConfigModel2;
                                cdnConfigModel17 = cdnConfigModel18222222222222;
                                str245 = str6;
                                str246 = str5;
                                str244 = str4;
                                z33 = z;
                                i12 = i;
                                uuid = str7;
                                str242 = str2;
                                str239 = obj2;
                                str241 = obj;
                                j14 = j2;
                                ily = this;
                                str243 = str8;
                                str240 = str3;
                                z34 = true;
                            } catch (UnknownHostException e15) {
                                httpURLConnection19 = O000000o2;
                                str7 = str119;
                                f20 = f4;
                                str42 = str107;
                                str247 = str116;
                                String str266 = str240;
                                String str267 = str241;
                                str43 = str118;
                                unknownHostException2 = e15;
                                str39 = str267;
                                str40 = str242;
                                str41 = str266;
                                cdnConfigModel9 = cdnConfigModel17;
                                obj2 = str117;
                                str44 = str;
                                httpURLConnection8 = httpURLConnection19;
                                byteArrayOutputStream4 = null;
                                str33 = obj2;
                                inputStream = null;
                                obj2 = str33;
                                if (imo.O0000Oo <= 0.0f) {
                                }
                                imo.O0000O0o = "dns_fail";
                                imo.O00000oo = imq.O000000o(unknownHostException);
                                imo.O00000oO = "0.0";
                                imo.O0000o0O = str21;
                                imo.O0000o0o = str21;
                                imo.O0000o = str247;
                                if (!z) {
                                }
                                long j1922 = j;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                str20 = XMediaplayerJNI.O0000o0;
                                sb2 = new StringBuilder(str4);
                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                imc.O000000o(str20, (Object) sb2.toString());
                                j2 = j202;
                                f20 = f20;
                                if (imo != null) {
                                }
                                CdnConfigModel cdnConfigModel182222222222222 = cdnConfigModel2;
                                cdnConfigModel17 = cdnConfigModel182222222222222;
                                str245 = str6;
                                str246 = str5;
                                str244 = str4;
                                z33 = z;
                                i12 = i;
                                uuid = str7;
                                str242 = str2;
                                str239 = obj2;
                                str241 = obj;
                                j14 = j2;
                                ily = this;
                                str243 = str8;
                                str240 = str3;
                                z34 = true;
                            } catch (IllegalArgumentException e16) {
                                httpURLConnection20 = O000000o2;
                                str7 = str119;
                                f20 = f4;
                                str53 = str107;
                                str247 = str116;
                                String str268 = str240;
                                String str269 = str241;
                                str54 = str118;
                                illegalArgumentException2 = e16;
                                r382 = str269;
                                str52 = str242;
                                str108 = str268;
                                cdnConfigModel11 = cdnConfigModel17;
                                obj2 = str117;
                                str55 = str;
                                httpURLConnection10 = httpURLConnection20;
                                byteArrayOutputStream5 = null;
                                str47 = obj2;
                                str49 = str108;
                                inputStream = null;
                                obj2 = str47;
                                str238 = str49;
                                if (imo.O0000Oo <= 0.0f) {
                                }
                                imo.O0000O0o = "dns_fail";
                                imo.O00000oo = imq.O000000o(illegalArgumentException);
                                imo.O00000oO = "0.0";
                                imo.O0000o0O = str21;
                                imo.O0000o0o = str21;
                                imo.O0000o = str247;
                                if (!z) {
                                }
                                long j2022 = j;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                str20 = XMediaplayerJNI.O0000o0;
                                sb2 = new StringBuilder(str4);
                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                imc.O000000o(str20, (Object) sb2.toString());
                                j2 = j2022;
                                f20 = f20;
                                if (imo != null) {
                                }
                                CdnConfigModel cdnConfigModel1822222222222222 = cdnConfigModel2;
                                cdnConfigModel17 = cdnConfigModel1822222222222222;
                                str245 = str6;
                                str246 = str5;
                                str244 = str4;
                                z33 = z;
                                i12 = i;
                                uuid = str7;
                                str242 = str2;
                                str239 = obj2;
                                str241 = obj;
                                j14 = j2;
                                ily = this;
                                str243 = str8;
                                str240 = str3;
                                z34 = true;
                            } catch (FileNotFoundException e17) {
                                httpURLConnection21 = O000000o2;
                                str7 = str119;
                                f20 = f4;
                                str64 = str107;
                                str247 = str116;
                                String str270 = str240;
                                String str271 = str241;
                                str65 = str118;
                                fileNotFoundException2 = e17;
                                str109 = str271;
                                str63 = str242;
                                r212 = str270;
                                cdnConfigModel12 = cdnConfigModel17;
                                obj2 = str117;
                                str66 = str;
                                httpURLConnection12 = httpURLConnection21;
                                byteArrayOutputStream6 = null;
                                str58 = str109;
                                str60 = r212;
                                inputStream = null;
                                obj = str58;
                                obj2 = obj2;
                                obj34 = str60;
                                if (imo.O0000Oo <= 0.0f) {
                                }
                                imo.O0000O0o = "system_exception";
                                imo.O00000oo = imq.O000000o(fileNotFoundException);
                                imo.O00000oO = "0.0";
                                imo.O0000o0O = str8;
                                imo.O0000o0o = str8;
                                imo.O0000o = str247;
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                if (!z) {
                                }
                                long j2122 = j;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                str9 = XMediaplayerJNI.O0000o0;
                                sb = new StringBuilder(str4);
                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                imc.O000000o(str9, (Object) sb.toString());
                                f20 = f20;
                                if (imo != null) {
                                }
                                CdnConfigModel cdnConfigModel18222222222222222 = cdnConfigModel2;
                                cdnConfigModel17 = cdnConfigModel18222222222222222;
                                str245 = str6;
                                str246 = str5;
                                str244 = str4;
                                z33 = z;
                                i12 = i;
                                uuid = str7;
                                str242 = str2;
                                str239 = obj2;
                                str241 = obj;
                                j14 = j2;
                                ily = this;
                                str243 = str8;
                                str240 = str3;
                                z34 = true;
                            } catch (IOException e18) {
                                httpURLConnection22 = O000000o2;
                                str7 = str119;
                                f20 = f4;
                                str74 = str107;
                                str247 = str116;
                                String str272 = str240;
                                String str273 = str241;
                                str75 = str118;
                                iOException2 = e18;
                                obj11 = str273;
                                str70 = str242;
                                r213 = str272;
                                obj2 = str117;
                                i3 = i13;
                                httpURLConnection13 = httpURLConnection22;
                                byteArrayOutputStream7 = null;
                                obj6 = obj11;
                                str69 = obj2;
                                str71 = r213;
                                inputStream = null;
                                obj4 = obj6;
                                obj2 = str69;
                                str3 = str71;
                                if (!z) {
                                }
                                cdnConfigModel2 = cdnConfigModel17;
                                String str25422 = str;
                                j = j;
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                if (!z) {
                                }
                                long j2222 = j;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                i13 = i2;
                                if (imo != null) {
                                }
                                CdnConfigModel cdnConfigModel182222222222222222 = cdnConfigModel2;
                                cdnConfigModel17 = cdnConfigModel182222222222222222;
                                str245 = str6;
                                str246 = str5;
                                str244 = str4;
                                z33 = z;
                                i12 = i;
                                uuid = str7;
                                str242 = str2;
                                str239 = obj2;
                                str241 = obj;
                                j14 = j2;
                                ily = this;
                                str243 = str8;
                                str240 = str3;
                                z34 = true;
                            } catch (Throwable th10) {
                                th = th10;
                                str92 = str240;
                                String str274 = str241;
                                httpURLConnection25 = O000000o2;
                                float f23 = f4;
                                str94 = str118;
                                str93 = str107;
                                str247 = str116;
                                obj12 = str274;
                                str89 = str242;
                                cdnConfigModel14 = cdnConfigModel17;
                                obj2 = str117;
                                z9 = z34;
                                f2 = f23;
                                httpURLConnection16 = httpURLConnection25;
                                obj8 = obj12;
                                inputStream2 = null;
                                th4 = th;
                                obj7 = obj8;
                                str3 = str88;
                                byteArrayOutputStream = null;
                                obj = obj7;
                                if (!z) {
                                }
                                Throwable th622 = th;
                                httpURLConnection2 = httpURLConnection;
                                if (httpURLConnection2 != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                throw th622;
                            }
                            try {
                                String headerField = O000000o2.getHeaderField("Content-Range");
                                z8 = TextUtils.isEmpty(headerField);
                                if (z8 == 0) {
                                    str7 = str119;
                                    try {
                                        String[] split = headerField.split("/");
                                        z8 = f4;
                                        if (split.length >= 2) {
                                            try {
                                                if (!TextUtils.isEmpty(split[0])) {
                                                    String[] split2 = split[0].split(" ");
                                                    obj2 = str117;
                                                    if (split2.length >= 2) {
                                                        try {
                                                            str214 = split2[1];
                                                            if (TextUtils.isEmpty(split[1])) {
                                                                str215 = split[1];
                                                                obj2 = obj2;
                                                            } else {
                                                                str215 = str118;
                                                                obj2 = obj2;
                                                            }
                                                        } catch (MalformedURLException e19) {
                                                            malformedURLException6 = e19;
                                                            str143 = str240;
                                                            httpURLConnection3 = O000000o2;
                                                            str144 = str;
                                                            str145 = str107;
                                                            str146 = str116;
                                                            byteArrayOutputStream = null;
                                                            inputStream = null;
                                                            z8 = z8;
                                                            obj4 = str241;
                                                            str10 = str242;
                                                            str5 = str118;
                                                            z21 = z8;
                                                            str216 = str143;
                                                            cdnConfigModel4 = cdnConfigModel17;
                                                            f20 = z21;
                                                            obj33 = str216;
                                                            if (imo.O0000Oo <= 0.0f) {
                                                            }
                                                            imo.O0000O0o = "cdn_connect_fail ";
                                                            imo.O00000oo = imq.O000000o(malformedURLException);
                                                            imo.O00000oO = "0.0";
                                                            imo.O0000o0O = str8;
                                                            imo.O0000o0o = str8;
                                                            imo.O0000o = str247;
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                            if (!z) {
                                                            }
                                                            long j2322 = j;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            str9 = XMediaplayerJNI.O0000o0;
                                                            sb = new StringBuilder(str4);
                                                            sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                            imc.O000000o(str9, (Object) sb.toString());
                                                            f20 = f20;
                                                            if (imo != null) {
                                                            }
                                                            CdnConfigModel cdnConfigModel1822222222222222222 = cdnConfigModel2;
                                                            cdnConfigModel17 = cdnConfigModel1822222222222222222;
                                                            str245 = str6;
                                                            str246 = str5;
                                                            str244 = str4;
                                                            z33 = z;
                                                            i12 = i;
                                                            uuid = str7;
                                                            str242 = str2;
                                                            str239 = obj2;
                                                            str241 = obj;
                                                            j14 = j2;
                                                            ily = this;
                                                            str243 = str8;
                                                            str240 = str3;
                                                            z34 = true;
                                                        } catch (SocketTimeoutException e20) {
                                                            socketTimeoutException6 = e20;
                                                            str147 = str240;
                                                            httpURLConnection5 = O000000o2;
                                                            str148 = str;
                                                            str149 = str107;
                                                            str150 = str116;
                                                            byteArrayOutputStream = null;
                                                            inputStream = null;
                                                            z8 = z8;
                                                            obj4 = str241;
                                                            str23 = str242;
                                                            str25 = str118;
                                                            z23 = z8;
                                                            str218 = str147;
                                                            cdnConfigModel6 = cdnConfigModel17;
                                                            f20 = z23;
                                                            obj5 = str218;
                                                            imo.O00000oO = "0.0";
                                                            if (imo.O0000Oo <= 0.0f) {
                                                            }
                                                            if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                            }
                                                            imo.O0000o0O = str21;
                                                            imo.O0000o0o = str21;
                                                            imo.O0000o = str247;
                                                            imo.O00000o = true;
                                                            if (!z) {
                                                            }
                                                            long j18222 = j;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            str20 = XMediaplayerJNI.O0000o0;
                                                            sb2 = new StringBuilder(str4);
                                                            str7 = str7;
                                                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                            imc.O000000o(str20, (Object) sb2.toString());
                                                            j2 = j2022;
                                                            f20 = f20;
                                                            if (imo != null) {
                                                            }
                                                            CdnConfigModel cdnConfigModel18222222222222222222 = cdnConfigModel2;
                                                            cdnConfigModel17 = cdnConfigModel18222222222222222222;
                                                            str245 = str6;
                                                            str246 = str5;
                                                            str244 = str4;
                                                            z33 = z;
                                                            i12 = i;
                                                            uuid = str7;
                                                            str242 = str2;
                                                            str239 = obj2;
                                                            str241 = obj;
                                                            j14 = j2;
                                                            ily = this;
                                                            str243 = str8;
                                                            str240 = str3;
                                                            z34 = true;
                                                        } catch (UnknownHostException e21) {
                                                            unknownHostException6 = e21;
                                                            str151 = str240;
                                                            httpURLConnection7 = O000000o2;
                                                            str152 = str;
                                                            str153 = str107;
                                                            str154 = str116;
                                                            byteArrayOutputStream = null;
                                                            inputStream = null;
                                                            z8 = z8;
                                                            obj4 = str241;
                                                            str34 = str242;
                                                            str37 = str118;
                                                            z25 = z8;
                                                            str221 = str151;
                                                            cdnConfigModel8 = cdnConfigModel17;
                                                            f20 = z25;
                                                            str35 = str221;
                                                            if (imo.O0000Oo <= 0.0f) {
                                                            }
                                                            imo.O0000O0o = "dns_fail";
                                                            imo.O00000oo = imq.O000000o(unknownHostException);
                                                            imo.O00000oO = "0.0";
                                                            imo.O0000o0O = str21;
                                                            imo.O0000o0o = str21;
                                                            imo.O0000o = str247;
                                                            if (!z) {
                                                            }
                                                            long j19222 = j;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            str20 = XMediaplayerJNI.O0000o0;
                                                            sb2 = new StringBuilder(str4);
                                                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                            imc.O000000o(str20, (Object) sb2.toString());
                                                            j2 = j2022;
                                                            f20 = f20;
                                                            if (imo != null) {
                                                            }
                                                            CdnConfigModel cdnConfigModel182222222222222222222 = cdnConfigModel2;
                                                            cdnConfigModel17 = cdnConfigModel182222222222222222222;
                                                            str245 = str6;
                                                            str246 = str5;
                                                            str244 = str4;
                                                            z33 = z;
                                                            i12 = i;
                                                            uuid = str7;
                                                            str242 = str2;
                                                            str239 = obj2;
                                                            str241 = obj;
                                                            j14 = j2;
                                                            ily = this;
                                                            str243 = str8;
                                                            str240 = str3;
                                                            z34 = true;
                                                        } catch (IllegalArgumentException e22) {
                                                            illegalArgumentException6 = e22;
                                                            str155 = str240;
                                                            httpURLConnection9 = O000000o2;
                                                            str156 = str;
                                                            str157 = str107;
                                                            str158 = str116;
                                                            byteArrayOutputStream = null;
                                                            inputStream = null;
                                                            z8 = z8;
                                                            obj4 = str241;
                                                            str48 = str242;
                                                            str51 = str118;
                                                            z27 = z8;
                                                            str224 = str155;
                                                            cdnConfigModel10 = cdnConfigModel17;
                                                            f20 = z27;
                                                            str238 = str224;
                                                            if (imo.O0000Oo <= 0.0f) {
                                                            }
                                                            imo.O0000O0o = "dns_fail";
                                                            imo.O00000oo = imq.O000000o(illegalArgumentException);
                                                            imo.O00000oO = "0.0";
                                                            imo.O0000o0O = str21;
                                                            imo.O0000o0o = str21;
                                                            imo.O0000o = str247;
                                                            if (!z) {
                                                            }
                                                            long j20222 = j;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            str20 = XMediaplayerJNI.O0000o0;
                                                            sb2 = new StringBuilder(str4);
                                                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                            imc.O000000o(str20, (Object) sb2.toString());
                                                            j2 = j20222;
                                                            f20 = f20;
                                                            if (imo != null) {
                                                            }
                                                            CdnConfigModel cdnConfigModel1822222222222222222222 = cdnConfigModel2;
                                                            cdnConfigModel17 = cdnConfigModel1822222222222222222222;
                                                            str245 = str6;
                                                            str246 = str5;
                                                            str244 = str4;
                                                            z33 = z;
                                                            i12 = i;
                                                            uuid = str7;
                                                            str242 = str2;
                                                            str239 = obj2;
                                                            str241 = obj;
                                                            j14 = j2;
                                                            ily = this;
                                                            str243 = str8;
                                                            str240 = str3;
                                                            z34 = true;
                                                        } catch (FileNotFoundException e23) {
                                                            fileNotFoundException6 = e23;
                                                            str159 = str240;
                                                            httpURLConnection33 = O000000o2;
                                                            str162 = str;
                                                            str163 = str107;
                                                            str160 = str116;
                                                            byteArrayOutputStream = null;
                                                            inputStream = null;
                                                            z8 = z8;
                                                            str161 = str241;
                                                            str59 = str242;
                                                            str62 = str118;
                                                            z29 = z8;
                                                            str228 = str159;
                                                            httpURLConnection11 = httpURLConnection33;
                                                            str247 = str160;
                                                            cdnConfigModel2 = cdnConfigModel17;
                                                            obj = str161;
                                                            f20 = z29;
                                                            obj34 = str228;
                                                            if (imo.O0000Oo <= 0.0f) {
                                                            }
                                                            imo.O0000O0o = "system_exception";
                                                            imo.O00000oo = imq.O000000o(fileNotFoundException);
                                                            imo.O00000oO = "0.0";
                                                            imo.O0000o0O = str8;
                                                            imo.O0000o0o = str8;
                                                            imo.O0000o = str247;
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                                            if (!z) {
                                                            }
                                                            long j21222 = j;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            str9 = XMediaplayerJNI.O0000o0;
                                                            sb = new StringBuilder(str4);
                                                            sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                            imc.O000000o(str9, (Object) sb.toString());
                                                            f20 = f20;
                                                            if (imo != null) {
                                                            }
                                                            CdnConfigModel cdnConfigModel18222222222222222222222 = cdnConfigModel2;
                                                            cdnConfigModel17 = cdnConfigModel18222222222222222222222;
                                                            str245 = str6;
                                                            str246 = str5;
                                                            str244 = str4;
                                                            z33 = z;
                                                            i12 = i;
                                                            uuid = str7;
                                                            str242 = str2;
                                                            str239 = obj2;
                                                            str241 = obj;
                                                            j14 = j2;
                                                            ily = this;
                                                            str243 = str8;
                                                            str240 = str3;
                                                            z34 = true;
                                                        } catch (IOException e24) {
                                                            iOException6 = e24;
                                                            str164 = str240;
                                                            httpURLConnection = O000000o2;
                                                            i6 = i13;
                                                            str165 = str107;
                                                            str166 = str116;
                                                            byteArrayOutputStream = null;
                                                            inputStream = null;
                                                            z8 = z8;
                                                            obj4 = str241;
                                                            str70 = str242;
                                                            str73 = str118;
                                                            f20 = z8;
                                                            str3 = str164;
                                                            if (!z) {
                                                            }
                                                            cdnConfigModel2 = cdnConfigModel17;
                                                            String str254222 = str;
                                                            j = j;
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                                            if (!z) {
                                                            }
                                                            long j22222 = j;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                            i13 = i2;
                                                            if (imo != null) {
                                                            }
                                                            CdnConfigModel cdnConfigModel182222222222222222222222 = cdnConfigModel2;
                                                            cdnConfigModel17 = cdnConfigModel182222222222222222222222;
                                                            str245 = str6;
                                                            str246 = str5;
                                                            str244 = str4;
                                                            z33 = z;
                                                            i12 = i;
                                                            uuid = str7;
                                                            str242 = str2;
                                                            str239 = obj2;
                                                            str241 = obj;
                                                            j14 = j2;
                                                            ily = this;
                                                            str243 = str8;
                                                            str240 = str3;
                                                            z34 = true;
                                                        } catch (Throwable th11) {
                                                            th = th11;
                                                            HttpURLConnection httpURLConnection43 = O000000o2;
                                                            CdnConfigModel cdnConfigModel19 = cdnConfigModel17;
                                                            float f24 = z8;
                                                            String str275 = str107;
                                                            String str276 = str116;
                                                            byteArrayOutputStream = null;
                                                            inputStream = null;
                                                            str167 = str241;
                                                            str2 = str242;
                                                            z2 = z34;
                                                            str168 = str118;
                                                            str3 = str240;
                                                            obj = str167;
                                                            th = th;
                                                            if (!z) {
                                                            }
                                                            Throwable th6222 = th;
                                                            httpURLConnection2 = httpURLConnection;
                                                            if (httpURLConnection2 != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                            throw th6222;
                                                        }
                                                    }
                                                } else {
                                                    obj2 = str117;
                                                }
                                                str214 = str118;
                                                obj2 = obj2;
                                                if (TextUtils.isEmpty(split[1])) {
                                                }
                                            } catch (MalformedURLException e25) {
                                                e = e25;
                                                malformedURLException4 = e;
                                                str209 = str240;
                                                f13 = z8;
                                                obj29 = str117;
                                                str13 = str;
                                                str196 = str116;
                                                f6 = f13;
                                                str217 = str209;
                                                byteArrayOutputStream20 = null;
                                                inputStream9 = null;
                                                obj2 = obj29;
                                                z8 = f6;
                                                str195 = str217;
                                                obj4 = str241;
                                                httpURLConnection36 = O000000o2;
                                                str5 = str118;
                                                str12 = str107;
                                                obj2 = obj2;
                                                z22 = z8;
                                                str176 = str195;
                                                str10 = str242;
                                                z21 = z22;
                                                str216 = str176;
                                                cdnConfigModel4 = cdnConfigModel17;
                                                f20 = z21;
                                                obj33 = str216;
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                imo.O0000O0o = "cdn_connect_fail ";
                                                imo.O00000oo = imq.O000000o(malformedURLException);
                                                imo.O00000oO = "0.0";
                                                imo.O0000o0O = str8;
                                                imo.O0000o0o = str8;
                                                imo.O0000o = str247;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                if (!z) {
                                                }
                                                long j23222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str9 = XMediaplayerJNI.O0000o0;
                                                sb = new StringBuilder(str4);
                                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str9, (Object) sb.toString());
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel1822222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel1822222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (SocketTimeoutException e26) {
                                                e = e26;
                                                socketTimeoutException4 = e;
                                                str210 = str240;
                                                f14 = z8;
                                                obj30 = str117;
                                                str26 = str;
                                                str198 = str116;
                                                f7 = f14;
                                                str220 = str210;
                                                byteArrayOutputStream21 = null;
                                                inputStream10 = null;
                                                obj2 = obj30;
                                                z8 = f7;
                                                str197 = str220;
                                                obj4 = str241;
                                                httpURLConnection37 = O000000o2;
                                                str25 = str118;
                                                str24 = str107;
                                                obj2 = obj2;
                                                z24 = z8;
                                                str219 = str197;
                                                str23 = str242;
                                                z23 = z24;
                                                str218 = str219;
                                                cdnConfigModel6 = cdnConfigModel17;
                                                f20 = z23;
                                                obj5 = str218;
                                                imo.O00000oO = "0.0";
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                }
                                                imo.O0000o0O = str21;
                                                imo.O0000o0o = str21;
                                                imo.O0000o = str247;
                                                imo.O00000o = true;
                                                if (!z) {
                                                }
                                                long j182222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str20 = XMediaplayerJNI.O0000o0;
                                                sb2 = new StringBuilder(str4);
                                                str7 = str7;
                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str20, (Object) sb2.toString());
                                                j2 = j20222;
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel18222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel18222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (UnknownHostException e27) {
                                                e = e27;
                                                unknownHostException4 = e;
                                                str121 = str240;
                                                f15 = z8;
                                                obj31 = str117;
                                                str38 = str;
                                                str200 = str116;
                                                f8 = f15;
                                                str223 = str121;
                                                byteArrayOutputStream22 = null;
                                                inputStream11 = null;
                                                obj2 = obj31;
                                                z8 = f8;
                                                str199 = str223;
                                                obj4 = str241;
                                                httpURLConnection38 = O000000o2;
                                                str37 = str118;
                                                str36 = str107;
                                                z26 = z8;
                                                str222 = str199;
                                                str34 = str242;
                                                z25 = z26;
                                                str221 = str222;
                                                cdnConfigModel8 = cdnConfigModel17;
                                                f20 = z25;
                                                str35 = str221;
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                imo.O0000O0o = "dns_fail";
                                                imo.O00000oo = imq.O000000o(unknownHostException);
                                                imo.O00000oO = "0.0";
                                                imo.O0000o0O = str21;
                                                imo.O0000o0o = str21;
                                                imo.O0000o = str247;
                                                if (!z) {
                                                }
                                                long j192222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str20 = XMediaplayerJNI.O0000o0;
                                                sb2 = new StringBuilder(str4);
                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str20, (Object) sb2.toString());
                                                j2 = j20222;
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel182222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel182222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (IllegalArgumentException e28) {
                                                e = e28;
                                                illegalArgumentException4 = e;
                                                str211 = str240;
                                                f16 = z8;
                                                str226 = str117;
                                                str21 = str;
                                                str202 = str116;
                                                f9 = f16;
                                                str227 = str211;
                                                byteArrayOutputStream23 = null;
                                                inputStream12 = null;
                                                obj2 = str226;
                                                z8 = f9;
                                                str201 = str227;
                                                obj4 = str241;
                                                httpURLConnection40 = O000000o2;
                                                str51 = str118;
                                                str50 = str107;
                                                z28 = z8;
                                                str225 = str201;
                                                str48 = str242;
                                                obj2 = obj2;
                                                z27 = z28;
                                                str224 = str225;
                                                cdnConfigModel10 = cdnConfigModel17;
                                                f20 = z27;
                                                str238 = str224;
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                imo.O0000O0o = "dns_fail";
                                                imo.O00000oo = imq.O000000o(illegalArgumentException);
                                                imo.O00000oO = "0.0";
                                                imo.O0000o0O = str21;
                                                imo.O0000o0o = str21;
                                                imo.O0000o = str247;
                                                if (!z) {
                                                }
                                                long j202222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str20 = XMediaplayerJNI.O0000o0;
                                                sb2 = new StringBuilder(str4);
                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str20, (Object) sb2.toString());
                                                j2 = j202222;
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel1822222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel1822222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (FileNotFoundException e29) {
                                                e = e29;
                                                fileNotFoundException4 = e;
                                                str122 = str240;
                                                f17 = z8;
                                                str230 = str117;
                                                str8 = str;
                                                str204 = str116;
                                                f10 = f17;
                                                str231 = str122;
                                                byteArrayOutputStream24 = null;
                                                inputStream13 = null;
                                                obj2 = str230;
                                                z8 = f10;
                                                str203 = str231;
                                                obj32 = str241;
                                                httpURLConnection11 = O000000o2;
                                                str62 = str118;
                                                str61 = str107;
                                                z30 = z8;
                                                str229 = str203;
                                                str59 = str242;
                                                str161 = obj32;
                                                z29 = z30;
                                                str228 = str229;
                                                cdnConfigModel2 = cdnConfigModel17;
                                                obj = str161;
                                                f20 = z29;
                                                obj34 = str228;
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                imo.O0000O0o = "system_exception";
                                                imo.O00000oo = imq.O000000o(fileNotFoundException);
                                                imo.O00000oO = "0.0";
                                                imo.O0000o0O = str8;
                                                imo.O0000o0o = str8;
                                                imo.O0000o = str247;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                                if (!z) {
                                                }
                                                long j212222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str9 = XMediaplayerJNI.O0000o0;
                                                sb = new StringBuilder(str4);
                                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str9, (Object) sb.toString());
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel18222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel18222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (IOException e30) {
                                                e = e30;
                                                iOException4 = e;
                                                str212 = str240;
                                                f18 = z8;
                                                str232 = str117;
                                                i2 = i13;
                                                str206 = str116;
                                                f11 = f18;
                                                byteArrayOutputStream25 = null;
                                                inputStream14 = null;
                                                obj2 = str232;
                                                z8 = f11;
                                                str205 = str212;
                                                obj4 = str241;
                                                httpURLConnection31 = O000000o2;
                                                str73 = str118;
                                                str72 = str107;
                                                obj2 = obj2;
                                                z8 = z8;
                                                str139 = str205;
                                                str70 = str242;
                                                f20 = z8;
                                                str3 = str139;
                                                if (!z) {
                                                }
                                                cdnConfigModel2 = cdnConfigModel17;
                                                String str2542222 = str;
                                                j = j;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                                if (!z) {
                                                }
                                                long j222222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                i13 = i2;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel182222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel182222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (Throwable th12) {
                                                th = th12;
                                                cdnConfigModel = cdnConfigModel17;
                                                String str277 = str117;
                                                f = z8;
                                                str247 = str116;
                                                String str278 = str277;
                                                byteArrayOutputStream = null;
                                                inputStream = null;
                                                obj2 = str278;
                                                str193 = str241;
                                                httpURLConnection34 = O000000o2;
                                                str168 = str118;
                                                str4 = str107;
                                                obj2 = obj2;
                                                str2 = str242;
                                                z2 = z34;
                                                str167 = str193;
                                                obj2 = obj2;
                                                str3 = str240;
                                                obj = str167;
                                                th = th;
                                                if (!z) {
                                                }
                                                Throwable th62222 = th;
                                                httpURLConnection2 = httpURLConnection;
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                throw th62222;
                                            }
                                        } else {
                                            obj2 = str117;
                                            str215 = str118;
                                            str214 = str215;
                                        }
                                        if (imo != null) {
                                            imo.O0000o00 = str214;
                                            imo.O0000o0 = str215;
                                        }
                                    } catch (MalformedURLException e31) {
                                        e = e31;
                                        z8 = f4;
                                        malformedURLException4 = e;
                                        str209 = str240;
                                        f13 = z8;
                                        obj29 = str117;
                                        str13 = str;
                                        str196 = str116;
                                        f6 = f13;
                                        str217 = str209;
                                        byteArrayOutputStream20 = null;
                                        inputStream9 = null;
                                        obj2 = obj29;
                                        z8 = f6;
                                        str195 = str217;
                                        obj4 = str241;
                                        httpURLConnection36 = O000000o2;
                                        str5 = str118;
                                        str12 = str107;
                                        obj2 = obj2;
                                        z22 = z8;
                                        str176 = str195;
                                        str10 = str242;
                                        z21 = z22;
                                        str216 = str176;
                                        cdnConfigModel4 = cdnConfigModel17;
                                        f20 = z21;
                                        obj33 = str216;
                                        if (imo.O0000Oo <= 0.0f) {
                                        }
                                        imo.O0000O0o = "cdn_connect_fail ";
                                        imo.O00000oo = imq.O000000o(malformedURLException);
                                        imo.O00000oO = "0.0";
                                        imo.O0000o0O = str8;
                                        imo.O0000o0o = str8;
                                        imo.O0000o = str247;
                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                        if (!z) {
                                        }
                                        long j232222 = j;
                                        if (httpURLConnection != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        str9 = XMediaplayerJNI.O0000o0;
                                        sb = new StringBuilder(str4);
                                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                                        imc.O000000o(str9, (Object) sb.toString());
                                        f20 = f20;
                                        if (imo != null) {
                                        }
                                        CdnConfigModel cdnConfigModel1822222222222222222222222222222 = cdnConfigModel2;
                                        cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222;
                                        str245 = str6;
                                        str246 = str5;
                                        str244 = str4;
                                        z33 = z;
                                        i12 = i;
                                        uuid = str7;
                                        str242 = str2;
                                        str239 = obj2;
                                        str241 = obj;
                                        j14 = j2;
                                        ily = this;
                                        str243 = str8;
                                        str240 = str3;
                                        z34 = true;
                                    } catch (SocketTimeoutException e32) {
                                        e = e32;
                                        z8 = f4;
                                        socketTimeoutException4 = e;
                                        str210 = str240;
                                        f14 = z8;
                                        obj30 = str117;
                                        str26 = str;
                                        str198 = str116;
                                        f7 = f14;
                                        str220 = str210;
                                        byteArrayOutputStream21 = null;
                                        inputStream10 = null;
                                        obj2 = obj30;
                                        z8 = f7;
                                        str197 = str220;
                                        obj4 = str241;
                                        httpURLConnection37 = O000000o2;
                                        str25 = str118;
                                        str24 = str107;
                                        obj2 = obj2;
                                        z24 = z8;
                                        str219 = str197;
                                        str23 = str242;
                                        z23 = z24;
                                        str218 = str219;
                                        cdnConfigModel6 = cdnConfigModel17;
                                        f20 = z23;
                                        obj5 = str218;
                                        imo.O00000oO = "0.0";
                                        if (imo.O0000Oo <= 0.0f) {
                                        }
                                        if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                        }
                                        imo.O0000o0O = str21;
                                        imo.O0000o0o = str21;
                                        imo.O0000o = str247;
                                        imo.O00000o = true;
                                        if (!z) {
                                        }
                                        long j1822222 = j;
                                        if (httpURLConnection != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        str20 = XMediaplayerJNI.O0000o0;
                                        sb2 = new StringBuilder(str4);
                                        str7 = str7;
                                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                        imc.O000000o(str20, (Object) sb2.toString());
                                        j2 = j202222;
                                        f20 = f20;
                                        if (imo != null) {
                                        }
                                        CdnConfigModel cdnConfigModel18222222222222222222222222222222 = cdnConfigModel2;
                                        cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222;
                                        str245 = str6;
                                        str246 = str5;
                                        str244 = str4;
                                        z33 = z;
                                        i12 = i;
                                        uuid = str7;
                                        str242 = str2;
                                        str239 = obj2;
                                        str241 = obj;
                                        j14 = j2;
                                        ily = this;
                                        str243 = str8;
                                        str240 = str3;
                                        z34 = true;
                                    } catch (UnknownHostException e33) {
                                        e = e33;
                                        z8 = f4;
                                        unknownHostException4 = e;
                                        str121 = str240;
                                        f15 = z8;
                                        obj31 = str117;
                                        str38 = str;
                                        str200 = str116;
                                        f8 = f15;
                                        str223 = str121;
                                        byteArrayOutputStream22 = null;
                                        inputStream11 = null;
                                        obj2 = obj31;
                                        z8 = f8;
                                        str199 = str223;
                                        obj4 = str241;
                                        httpURLConnection38 = O000000o2;
                                        str37 = str118;
                                        str36 = str107;
                                        z26 = z8;
                                        str222 = str199;
                                        str34 = str242;
                                        z25 = z26;
                                        str221 = str222;
                                        cdnConfigModel8 = cdnConfigModel17;
                                        f20 = z25;
                                        str35 = str221;
                                        if (imo.O0000Oo <= 0.0f) {
                                        }
                                        imo.O0000O0o = "dns_fail";
                                        imo.O00000oo = imq.O000000o(unknownHostException);
                                        imo.O00000oO = "0.0";
                                        imo.O0000o0O = str21;
                                        imo.O0000o0o = str21;
                                        imo.O0000o = str247;
                                        if (!z) {
                                        }
                                        long j1922222 = j;
                                        if (httpURLConnection != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        str20 = XMediaplayerJNI.O0000o0;
                                        sb2 = new StringBuilder(str4);
                                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                        imc.O000000o(str20, (Object) sb2.toString());
                                        j2 = j202222;
                                        f20 = f20;
                                        if (imo != null) {
                                        }
                                        CdnConfigModel cdnConfigModel182222222222222222222222222222222 = cdnConfigModel2;
                                        cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222;
                                        str245 = str6;
                                        str246 = str5;
                                        str244 = str4;
                                        z33 = z;
                                        i12 = i;
                                        uuid = str7;
                                        str242 = str2;
                                        str239 = obj2;
                                        str241 = obj;
                                        j14 = j2;
                                        ily = this;
                                        str243 = str8;
                                        str240 = str3;
                                        z34 = true;
                                    } catch (IllegalArgumentException e34) {
                                        e = e34;
                                        z8 = f4;
                                        illegalArgumentException4 = e;
                                        str211 = str240;
                                        f16 = z8;
                                        str226 = str117;
                                        str21 = str;
                                        str202 = str116;
                                        f9 = f16;
                                        str227 = str211;
                                        byteArrayOutputStream23 = null;
                                        inputStream12 = null;
                                        obj2 = str226;
                                        z8 = f9;
                                        str201 = str227;
                                        obj4 = str241;
                                        httpURLConnection40 = O000000o2;
                                        str51 = str118;
                                        str50 = str107;
                                        z28 = z8;
                                        str225 = str201;
                                        str48 = str242;
                                        obj2 = obj2;
                                        z27 = z28;
                                        str224 = str225;
                                        cdnConfigModel10 = cdnConfigModel17;
                                        f20 = z27;
                                        str238 = str224;
                                        if (imo.O0000Oo <= 0.0f) {
                                        }
                                        imo.O0000O0o = "dns_fail";
                                        imo.O00000oo = imq.O000000o(illegalArgumentException);
                                        imo.O00000oO = "0.0";
                                        imo.O0000o0O = str21;
                                        imo.O0000o0o = str21;
                                        imo.O0000o = str247;
                                        if (!z) {
                                        }
                                        long j2022222 = j;
                                        if (httpURLConnection != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        str20 = XMediaplayerJNI.O0000o0;
                                        sb2 = new StringBuilder(str4);
                                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                        imc.O000000o(str20, (Object) sb2.toString());
                                        j2 = j2022222;
                                        f20 = f20;
                                        if (imo != null) {
                                        }
                                        CdnConfigModel cdnConfigModel1822222222222222222222222222222222 = cdnConfigModel2;
                                        cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222;
                                        str245 = str6;
                                        str246 = str5;
                                        str244 = str4;
                                        z33 = z;
                                        i12 = i;
                                        uuid = str7;
                                        str242 = str2;
                                        str239 = obj2;
                                        str241 = obj;
                                        j14 = j2;
                                        ily = this;
                                        str243 = str8;
                                        str240 = str3;
                                        z34 = true;
                                    } catch (FileNotFoundException e35) {
                                        e = e35;
                                        z8 = f4;
                                        fileNotFoundException4 = e;
                                        str122 = str240;
                                        f17 = z8;
                                        str230 = str117;
                                        str8 = str;
                                        str204 = str116;
                                        f10 = f17;
                                        str231 = str122;
                                        byteArrayOutputStream24 = null;
                                        inputStream13 = null;
                                        obj2 = str230;
                                        z8 = f10;
                                        str203 = str231;
                                        obj32 = str241;
                                        httpURLConnection11 = O000000o2;
                                        str62 = str118;
                                        str61 = str107;
                                        z30 = z8;
                                        str229 = str203;
                                        str59 = str242;
                                        str161 = obj32;
                                        z29 = z30;
                                        str228 = str229;
                                        cdnConfigModel2 = cdnConfigModel17;
                                        obj = str161;
                                        f20 = z29;
                                        obj34 = str228;
                                        if (imo.O0000Oo <= 0.0f) {
                                        }
                                        imo.O0000O0o = "system_exception";
                                        imo.O00000oo = imq.O000000o(fileNotFoundException);
                                        imo.O00000oO = "0.0";
                                        imo.O0000o0O = str8;
                                        imo.O0000o0o = str8;
                                        imo.O0000o = str247;
                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                        if (!z) {
                                        }
                                        long j2122222 = j;
                                        if (httpURLConnection != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        str9 = XMediaplayerJNI.O0000o0;
                                        sb = new StringBuilder(str4);
                                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                                        imc.O000000o(str9, (Object) sb.toString());
                                        f20 = f20;
                                        if (imo != null) {
                                        }
                                        CdnConfigModel cdnConfigModel18222222222222222222222222222222222 = cdnConfigModel2;
                                        cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222;
                                        str245 = str6;
                                        str246 = str5;
                                        str244 = str4;
                                        z33 = z;
                                        i12 = i;
                                        uuid = str7;
                                        str242 = str2;
                                        str239 = obj2;
                                        str241 = obj;
                                        j14 = j2;
                                        ily = this;
                                        str243 = str8;
                                        str240 = str3;
                                        z34 = true;
                                    } catch (IOException e36) {
                                        e = e36;
                                        z8 = f4;
                                        iOException4 = e;
                                        str212 = str240;
                                        f18 = z8;
                                        str232 = str117;
                                        i2 = i13;
                                        str206 = str116;
                                        f11 = f18;
                                        byteArrayOutputStream25 = null;
                                        inputStream14 = null;
                                        obj2 = str232;
                                        z8 = f11;
                                        str205 = str212;
                                        obj4 = str241;
                                        httpURLConnection31 = O000000o2;
                                        str73 = str118;
                                        str72 = str107;
                                        obj2 = obj2;
                                        z8 = z8;
                                        str139 = str205;
                                        str70 = str242;
                                        f20 = z8;
                                        str3 = str139;
                                        if (!z) {
                                        }
                                        cdnConfigModel2 = cdnConfigModel17;
                                        String str25422222 = str;
                                        j = j;
                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                        if (!z) {
                                        }
                                        long j2222222 = j;
                                        if (httpURLConnection != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                        i13 = i2;
                                        if (imo != null) {
                                        }
                                        CdnConfigModel cdnConfigModel182222222222222222222222222222222222 = cdnConfigModel2;
                                        cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222;
                                        str245 = str6;
                                        str246 = str5;
                                        str244 = str4;
                                        z33 = z;
                                        i12 = i;
                                        uuid = str7;
                                        str242 = str2;
                                        str239 = obj2;
                                        str241 = obj;
                                        j14 = j2;
                                        ily = this;
                                        str243 = str8;
                                        str240 = str3;
                                        z34 = true;
                                    } catch (Throwable th13) {
                                        th = th13;
                                        z8 = f4;
                                        cdnConfigModel = cdnConfigModel17;
                                        String str2772 = str117;
                                        f = z8;
                                        str247 = str116;
                                        String str2782 = str2772;
                                        byteArrayOutputStream = null;
                                        inputStream = null;
                                        obj2 = str2782;
                                        str193 = str241;
                                        httpURLConnection34 = O000000o2;
                                        str168 = str118;
                                        str4 = str107;
                                        obj2 = obj2;
                                        str2 = str242;
                                        z2 = z34;
                                        str167 = str193;
                                        obj2 = obj2;
                                        str3 = str240;
                                        obj = str167;
                                        th = th;
                                        if (!z) {
                                        }
                                        Throwable th622222 = th;
                                        httpURLConnection2 = httpURLConnection;
                                        if (httpURLConnection2 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                        throw th622222;
                                    }
                                } else {
                                    str7 = str119;
                                    z8 = f4;
                                    obj2 = str117;
                                }
                                if (responseCode != 200) {
                                    if (responseCode != 206) {
                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "HlsDownloadThread fail responseCode:".concat(String.valueOf(responseCode)));
                                        throw new IOException("HlsDownloadThread fail responseCode:".concat(String.valueOf(responseCode)));
                                    }
                                }
                                try {
                                    int contentLength = O000000o2.getContentLength();
                                    if (imo != null) {
                                        imo.O00000Oo = (long) contentLength;
                                    }
                                    if (contentLength <= 0 || contentLength > 262144) {
                                        str173 = str240;
                                        str86 = str241;
                                        httpURLConnection23 = O000000o2;
                                        str87 = str118;
                                        str72 = str107;
                                        str84 = obj2;
                                        str247 = str116;
                                        try {
                                            String str279 = str72;
                                            try {
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "HlsDownloadThread fail contentLength:".concat(String.valueOf(contentLength)));
                                                if (z || imo == null) {
                                                    str174 = str6;
                                                    str175 = str173;
                                                } else {
                                                    if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                                        imo.O0000Oo0 = null;
                                                    }
                                                    if (TextUtils.isEmpty(imo.O0000OOo)) {
                                                        imo.O0000OOo = str87;
                                                    }
                                                    String str280 = str173;
                                                    imo.O0000OoO = System.currentTimeMillis();
                                                    if (imo.O0000o == null || !imo.O0000o.contains(str6)) {
                                                        imo.O0000o = str247;
                                                    }
                                                    if (!z34) {
                                                        int i15 = cdnConfigModel17.O00000oO;
                                                        if (i15 == -1) {
                                                            str174 = str6;
                                                            f5 = z8;
                                                            str175 = str280;
                                                            z12 = true;
                                                            if (httpURLConnection23 != 0) {
                                                                httpURLConnection23.disconnect();
                                                            }
                                                            String str281 = XMediaplayerJNI.O0000o0;
                                                            f20 = f5;
                                                            String str282 = str279;
                                                            StringBuilder sb7 = new StringBuilder(str282);
                                                            long j24 = j;
                                                            sb7.append(System.currentTimeMillis() - currentTimeMillis);
                                                            imc.O000000o(str281, (Object) sb7.toString());
                                                            str244 = str282;
                                                            str239 = str84;
                                                            str245 = str174;
                                                            i12 = i;
                                                            uuid = str7;
                                                            str243 = str;
                                                            j14 = j24;
                                                            String str283 = str87;
                                                            str241 = str86;
                                                            str240 = str175;
                                                            str246 = str283;
                                                        } else if (i15 == 0) {
                                                            ily.f1456O000000o = (long) cdnConfigModel17.O00000Oo;
                                                            ily.O00000Oo = (long) cdnConfigModel17.O00000o;
                                                            if (j > ily.f1456O000000o * 1000) {
                                                                imo.O0000O0o = str242;
                                                                StringBuilder sb8 = new StringBuilder(str86);
                                                                sb8.append(imq.O000000o((float) j, false));
                                                                str175 = str280;
                                                                sb8.append(str175);
                                                                sb8.append(ily.f1456O000000o);
                                                                sb8.append(str84);
                                                                imo.O00000oo = sb8.toString();
                                                            } else {
                                                                str175 = str280;
                                                                if (((float) ily.O00000Oo) > z8) {
                                                                    imo.O0000O0o = "cdn_download_too_slow";
                                                                    StringBuilder sb9 = new StringBuilder("download_speed=");
                                                                    str174 = str6;
                                                                    sb9.append(imq.O000000o((float) z8, true));
                                                                    sb9.append("KB/s, download_speed_threshold=");
                                                                    sb9.append(ily.O00000Oo);
                                                                    sb9.append("KB/s");
                                                                    imo.O00000oo = sb9.toString();
                                                                }
                                                            }
                                                            str174 = str6;
                                                        } else {
                                                            str174 = str6;
                                                            str175 = str280;
                                                            if (i15 == 1) {
                                                                ily.f1456O000000o = (long) cdnConfigModel17.f12180O000000o;
                                                                ily.O00000Oo = (long) cdnConfigModel17.O00000o0;
                                                                ily.f1456O000000o = 0;
                                                                if (j > ily.f1456O000000o * 1000) {
                                                                    imo.O0000O0o = str242;
                                                                    imo.O00000oo = str86 + imq.O000000o((float) j, false) + str175 + ily.f1456O000000o + str84;
                                                                } else if (((float) ily.O00000Oo) > z8) {
                                                                    imo.O0000O0o = "cdn_download_too_slow";
                                                                    StringBuilder sb10 = new StringBuilder("download_speed=");
                                                                    f5 = z8;
                                                                    sb10.append(imq.O000000o(f5, true));
                                                                    sb10.append("KB/s, download_speed_threshold=");
                                                                    sb10.append(ily.O00000Oo);
                                                                    sb10.append("KB/s");
                                                                    imo.O00000oo = sb10.toString();
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        str174 = str6;
                                                        f5 = z8;
                                                        str175 = str280;
                                                    }
                                                    z12 = z;
                                                    if (httpURLConnection23 != 0) {
                                                    }
                                                    String str2812 = XMediaplayerJNI.O0000o0;
                                                    f20 = f5;
                                                    String str2822 = str279;
                                                    StringBuilder sb72 = new StringBuilder(str2822);
                                                    long j242 = j;
                                                    sb72.append(System.currentTimeMillis() - currentTimeMillis);
                                                    imc.O000000o(str2812, (Object) sb72.toString());
                                                    str244 = str2822;
                                                    str239 = str84;
                                                    str245 = str174;
                                                    i12 = i;
                                                    uuid = str7;
                                                    str243 = str;
                                                    j14 = j242;
                                                    String str2832 = str87;
                                                    str241 = str86;
                                                    str240 = str175;
                                                    str246 = str2832;
                                                }
                                                f5 = z8;
                                                z12 = z;
                                                if (httpURLConnection23 != 0) {
                                                }
                                                String str28122 = XMediaplayerJNI.O0000o0;
                                                f20 = f5;
                                                String str28222 = str279;
                                                StringBuilder sb722 = new StringBuilder(str28222);
                                                long j2422 = j;
                                                sb722.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str28122, (Object) sb722.toString());
                                                str244 = str28222;
                                                str239 = str84;
                                                str245 = str174;
                                                i12 = i;
                                                uuid = str7;
                                                str243 = str;
                                                j14 = j2422;
                                                String str28322 = str87;
                                                str241 = str86;
                                                str240 = str175;
                                                str246 = str28322;
                                            } catch (MalformedURLException e37) {
                                                e = e37;
                                                str72 = str279;
                                                malformedURLException5 = e;
                                                obj17 = str86;
                                                cdnConfigModel4 = cdnConfigModel17;
                                                obj18 = str173;
                                                obj2 = str84;
                                                str127 = str;
                                                obj15 = obj17;
                                                str7 = str7;
                                                z8 = z8;
                                                obj16 = obj18;
                                                httpURLConnection26 = httpURLConnection23;
                                                byteArrayOutputStream11 = null;
                                                inputStream3 = null;
                                                obj13 = obj15;
                                                z8 = z8;
                                                obj14 = obj16;
                                                str10 = str242;
                                                obj4 = obj13;
                                                f20 = z8;
                                                obj33 = obj14;
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                imo.O0000O0o = "cdn_connect_fail ";
                                                imo.O00000oo = imq.O000000o(malformedURLException);
                                                imo.O00000oO = "0.0";
                                                imo.O0000o0O = str8;
                                                imo.O0000o0o = str8;
                                                imo.O0000o = str247;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                if (!z) {
                                                }
                                                long j2322222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str9 = XMediaplayerJNI.O0000o0;
                                                sb = new StringBuilder(str4);
                                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str9, (Object) sb.toString());
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel1822222222222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (SocketTimeoutException e38) {
                                                e = e38;
                                                str72 = str279;
                                                socketTimeoutException5 = e;
                                                obj21 = str86;
                                                cdnConfigModel6 = cdnConfigModel17;
                                                obj23 = str173;
                                                obj2 = str84;
                                                str128 = str;
                                                obj2 = obj2;
                                                str7 = str7;
                                                z8 = z8;
                                                obj22 = obj23;
                                                httpURLConnection27 = httpURLConnection23;
                                                byteArrayOutputStream12 = null;
                                                inputStream4 = null;
                                                obj19 = obj21;
                                                obj2 = obj2;
                                                str7 = str7;
                                                z8 = z8;
                                                obj20 = obj22;
                                                str23 = str242;
                                                obj4 = obj19;
                                                obj2 = obj2;
                                                str7 = str7;
                                                f20 = z8;
                                                obj5 = obj20;
                                                imo.O00000oO = "0.0";
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                }
                                                imo.O0000o0O = str21;
                                                imo.O0000o0o = str21;
                                                imo.O0000o = str247;
                                                imo.O00000o = true;
                                                if (!z) {
                                                }
                                                long j18222222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str20 = XMediaplayerJNI.O0000o0;
                                                sb2 = new StringBuilder(str4);
                                                str7 = str7;
                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str20, (Object) sb2.toString());
                                                j2 = j2022222;
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel18222222222222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (UnknownHostException e39) {
                                                e = e39;
                                                str72 = str279;
                                                unknownHostException5 = e;
                                                str129 = str86;
                                                cdnConfigModel8 = cdnConfigModel17;
                                                str35 = str173;
                                                obj2 = str84;
                                                str130 = str;
                                                httpURLConnection28 = httpURLConnection23;
                                                byteArrayOutputStream13 = null;
                                                inputStream5 = null;
                                                str34 = str242;
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                imo.O0000O0o = "dns_fail";
                                                imo.O00000oo = imq.O000000o(unknownHostException);
                                                imo.O00000oO = "0.0";
                                                imo.O0000o0O = str21;
                                                imo.O0000o0o = str21;
                                                imo.O0000o = str247;
                                                if (!z) {
                                                }
                                                long j19222222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str20 = XMediaplayerJNI.O0000o0;
                                                sb2 = new StringBuilder(str4);
                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str20, (Object) sb2.toString());
                                                j2 = j2022222;
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel182222222222222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (IllegalArgumentException e40) {
                                                e = e40;
                                                str72 = str279;
                                                illegalArgumentException5 = e;
                                                str132 = str86;
                                                cdnConfigModel10 = cdnConfigModel17;
                                                str135 = str173;
                                                obj2 = str84;
                                                str134 = str;
                                                obj2 = obj2;
                                                str133 = str135;
                                                httpURLConnection29 = httpURLConnection23;
                                                byteArrayOutputStream14 = null;
                                                inputStream6 = null;
                                                str131 = str133;
                                                str48 = str242;
                                                str238 = str131;
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                imo.O0000O0o = "dns_fail";
                                                imo.O00000oo = imq.O000000o(illegalArgumentException);
                                                imo.O00000oO = "0.0";
                                                imo.O0000o0O = str21;
                                                imo.O0000o0o = str21;
                                                imo.O0000o = str247;
                                                if (!z) {
                                                }
                                                long j20222222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str20 = XMediaplayerJNI.O0000o0;
                                                sb2 = new StringBuilder(str4);
                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str20, (Object) sb2.toString());
                                                j2 = j20222222;
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (FileNotFoundException e41) {
                                                e = e41;
                                                str72 = str279;
                                                fileNotFoundException5 = e;
                                                str136 = str86;
                                                cdnConfigModel2 = cdnConfigModel17;
                                                obj26 = str173;
                                                obj2 = str84;
                                                str137 = str;
                                                str7 = str7;
                                                z8 = z8;
                                                obj25 = obj26;
                                                httpURLConnection30 = httpURLConnection23;
                                                byteArrayOutputStream15 = null;
                                                inputStream7 = null;
                                                z8 = z8;
                                                obj24 = obj25;
                                                str59 = str242;
                                                obj = str136;
                                                f20 = z8;
                                                obj34 = obj24;
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                imo.O0000O0o = "system_exception";
                                                imo.O00000oo = imq.O000000o(fileNotFoundException);
                                                imo.O00000oO = "0.0";
                                                imo.O0000o0O = str8;
                                                imo.O0000o0o = str8;
                                                imo.O0000o = str247;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                                if (!z) {
                                                }
                                                long j21222222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str9 = XMediaplayerJNI.O0000o0;
                                                sb = new StringBuilder(str4);
                                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str9, (Object) sb.toString());
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (IOException e42) {
                                                e = e42;
                                                str72 = str279;
                                                iOException5 = e;
                                                str140 = str86;
                                                str141 = str173;
                                                obj2 = str84;
                                                i7 = i13;
                                                str138 = str140;
                                                str7 = str7;
                                                z8 = z8;
                                                str139 = str141;
                                                httpURLConnection31 = httpURLConnection23;
                                                byteArrayOutputStream = null;
                                                inputStream = null;
                                                obj4 = str138;
                                                obj2 = obj2;
                                                str7 = str7;
                                                z8 = z8;
                                                str70 = str242;
                                                f20 = z8;
                                                str3 = str139;
                                                if (!z) {
                                                }
                                                cdnConfigModel2 = cdnConfigModel17;
                                                String str254222222 = str;
                                                j = j;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                                if (!z) {
                                                }
                                                long j22222222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                i13 = i2;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (Throwable th14) {
                                                th = th14;
                                                str72 = str279;
                                                str172 = str86;
                                                cdnConfigModel16 = cdnConfigModel17;
                                                obj2 = str84;
                                                z11 = z8;
                                                byteArrayOutputStream = null;
                                                inputStream8 = null;
                                                str170 = str172;
                                                obj2 = obj2;
                                                th = th;
                                                obj4 = str170;
                                                obj2 = obj2;
                                                str2 = str242;
                                                z2 = z34;
                                                str3 = str169;
                                                httpURLConnection = httpURLConnection35;
                                                if (!z) {
                                                }
                                                Throwable th6222222 = th;
                                                httpURLConnection2 = httpURLConnection;
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                throw th6222222;
                                            }
                                        } catch (MalformedURLException e43) {
                                            e = e43;
                                            malformedURLException5 = e;
                                            obj17 = str86;
                                            cdnConfigModel4 = cdnConfigModel17;
                                            obj18 = str173;
                                            obj2 = str84;
                                            str127 = str;
                                            obj15 = obj17;
                                            str7 = str7;
                                            z8 = z8;
                                            obj16 = obj18;
                                            httpURLConnection26 = httpURLConnection23;
                                            byteArrayOutputStream11 = null;
                                            inputStream3 = null;
                                            obj13 = obj15;
                                            z8 = z8;
                                            obj14 = obj16;
                                            str10 = str242;
                                            obj4 = obj13;
                                            f20 = z8;
                                            obj33 = obj14;
                                            if (imo.O0000Oo <= 0.0f) {
                                            }
                                            imo.O0000O0o = "cdn_connect_fail ";
                                            imo.O00000oo = imq.O000000o(malformedURLException);
                                            imo.O00000oO = "0.0";
                                            imo.O0000o0O = str8;
                                            imo.O0000o0o = str8;
                                            imo.O0000o = str247;
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                            if (!z) {
                                            }
                                            long j23222222 = j;
                                            if (httpURLConnection != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            str9 = XMediaplayerJNI.O0000o0;
                                            sb = new StringBuilder(str4);
                                            sb.append(System.currentTimeMillis() - currentTimeMillis);
                                            imc.O000000o(str9, (Object) sb.toString());
                                            f20 = f20;
                                            if (imo != null) {
                                            }
                                            CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222 = cdnConfigModel2;
                                            cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222;
                                            str245 = str6;
                                            str246 = str5;
                                            str244 = str4;
                                            z33 = z;
                                            i12 = i;
                                            uuid = str7;
                                            str242 = str2;
                                            str239 = obj2;
                                            str241 = obj;
                                            j14 = j2;
                                            ily = this;
                                            str243 = str8;
                                            str240 = str3;
                                            z34 = true;
                                        } catch (SocketTimeoutException e44) {
                                            e = e44;
                                            socketTimeoutException5 = e;
                                            obj21 = str86;
                                            cdnConfigModel6 = cdnConfigModel17;
                                            obj23 = str173;
                                            obj2 = str84;
                                            str128 = str;
                                            obj2 = obj2;
                                            str7 = str7;
                                            z8 = z8;
                                            obj22 = obj23;
                                            httpURLConnection27 = httpURLConnection23;
                                            byteArrayOutputStream12 = null;
                                            inputStream4 = null;
                                            obj19 = obj21;
                                            obj2 = obj2;
                                            str7 = str7;
                                            z8 = z8;
                                            obj20 = obj22;
                                            str23 = str242;
                                            obj4 = obj19;
                                            obj2 = obj2;
                                            str7 = str7;
                                            f20 = z8;
                                            obj5 = obj20;
                                            imo.O00000oO = "0.0";
                                            if (imo.O0000Oo <= 0.0f) {
                                            }
                                            if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                            }
                                            imo.O0000o0O = str21;
                                            imo.O0000o0o = str21;
                                            imo.O0000o = str247;
                                            imo.O00000o = true;
                                            if (!z) {
                                            }
                                            long j182222222 = j;
                                            if (httpURLConnection != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            str20 = XMediaplayerJNI.O0000o0;
                                            sb2 = new StringBuilder(str4);
                                            str7 = str7;
                                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                            imc.O000000o(str20, (Object) sb2.toString());
                                            j2 = j20222222;
                                            f20 = f20;
                                            if (imo != null) {
                                            }
                                            CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222 = cdnConfigModel2;
                                            cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222;
                                            str245 = str6;
                                            str246 = str5;
                                            str244 = str4;
                                            z33 = z;
                                            i12 = i;
                                            uuid = str7;
                                            str242 = str2;
                                            str239 = obj2;
                                            str241 = obj;
                                            j14 = j2;
                                            ily = this;
                                            str243 = str8;
                                            str240 = str3;
                                            z34 = true;
                                        } catch (UnknownHostException e45) {
                                            e = e45;
                                            unknownHostException5 = e;
                                            str129 = str86;
                                            cdnConfigModel8 = cdnConfigModel17;
                                            str35 = str173;
                                            obj2 = str84;
                                            str130 = str;
                                            httpURLConnection28 = httpURLConnection23;
                                            byteArrayOutputStream13 = null;
                                            inputStream5 = null;
                                            str34 = str242;
                                            if (imo.O0000Oo <= 0.0f) {
                                            }
                                            imo.O0000O0o = "dns_fail";
                                            imo.O00000oo = imq.O000000o(unknownHostException);
                                            imo.O00000oO = "0.0";
                                            imo.O0000o0O = str21;
                                            imo.O0000o0o = str21;
                                            imo.O0000o = str247;
                                            if (!z) {
                                            }
                                            long j192222222 = j;
                                            if (httpURLConnection != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            str20 = XMediaplayerJNI.O0000o0;
                                            sb2 = new StringBuilder(str4);
                                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                            imc.O000000o(str20, (Object) sb2.toString());
                                            j2 = j20222222;
                                            f20 = f20;
                                            if (imo != null) {
                                            }
                                            CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222 = cdnConfigModel2;
                                            cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222;
                                            str245 = str6;
                                            str246 = str5;
                                            str244 = str4;
                                            z33 = z;
                                            i12 = i;
                                            uuid = str7;
                                            str242 = str2;
                                            str239 = obj2;
                                            str241 = obj;
                                            j14 = j2;
                                            ily = this;
                                            str243 = str8;
                                            str240 = str3;
                                            z34 = true;
                                        } catch (IllegalArgumentException e46) {
                                            e = e46;
                                            illegalArgumentException5 = e;
                                            str132 = str86;
                                            cdnConfigModel10 = cdnConfigModel17;
                                            str135 = str173;
                                            obj2 = str84;
                                            str134 = str;
                                            obj2 = obj2;
                                            str133 = str135;
                                            httpURLConnection29 = httpURLConnection23;
                                            byteArrayOutputStream14 = null;
                                            inputStream6 = null;
                                            str131 = str133;
                                            str48 = str242;
                                            str238 = str131;
                                            if (imo.O0000Oo <= 0.0f) {
                                            }
                                            imo.O0000O0o = "dns_fail";
                                            imo.O00000oo = imq.O000000o(illegalArgumentException);
                                            imo.O00000oO = "0.0";
                                            imo.O0000o0O = str21;
                                            imo.O0000o0o = str21;
                                            imo.O0000o = str247;
                                            if (!z) {
                                            }
                                            long j202222222 = j;
                                            if (httpURLConnection != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            str20 = XMediaplayerJNI.O0000o0;
                                            sb2 = new StringBuilder(str4);
                                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                            imc.O000000o(str20, (Object) sb2.toString());
                                            j2 = j202222222;
                                            f20 = f20;
                                            if (imo != null) {
                                            }
                                            CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222 = cdnConfigModel2;
                                            cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222;
                                            str245 = str6;
                                            str246 = str5;
                                            str244 = str4;
                                            z33 = z;
                                            i12 = i;
                                            uuid = str7;
                                            str242 = str2;
                                            str239 = obj2;
                                            str241 = obj;
                                            j14 = j2;
                                            ily = this;
                                            str243 = str8;
                                            str240 = str3;
                                            z34 = true;
                                        } catch (FileNotFoundException e47) {
                                            e = e47;
                                            fileNotFoundException5 = e;
                                            str136 = str86;
                                            cdnConfigModel2 = cdnConfigModel17;
                                            obj26 = str173;
                                            obj2 = str84;
                                            str137 = str;
                                            str7 = str7;
                                            z8 = z8;
                                            obj25 = obj26;
                                            httpURLConnection30 = httpURLConnection23;
                                            byteArrayOutputStream15 = null;
                                            inputStream7 = null;
                                            z8 = z8;
                                            obj24 = obj25;
                                            str59 = str242;
                                            obj = str136;
                                            f20 = z8;
                                            obj34 = obj24;
                                            if (imo.O0000Oo <= 0.0f) {
                                            }
                                            imo.O0000O0o = "system_exception";
                                            imo.O00000oo = imq.O000000o(fileNotFoundException);
                                            imo.O00000oO = "0.0";
                                            imo.O0000o0O = str8;
                                            imo.O0000o0o = str8;
                                            imo.O0000o = str247;
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                            if (!z) {
                                            }
                                            long j212222222 = j;
                                            if (httpURLConnection != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            str9 = XMediaplayerJNI.O0000o0;
                                            sb = new StringBuilder(str4);
                                            sb.append(System.currentTimeMillis() - currentTimeMillis);
                                            imc.O000000o(str9, (Object) sb.toString());
                                            f20 = f20;
                                            if (imo != null) {
                                            }
                                            CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                            cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222;
                                            str245 = str6;
                                            str246 = str5;
                                            str244 = str4;
                                            z33 = z;
                                            i12 = i;
                                            uuid = str7;
                                            str242 = str2;
                                            str239 = obj2;
                                            str241 = obj;
                                            j14 = j2;
                                            ily = this;
                                            str243 = str8;
                                            str240 = str3;
                                            z34 = true;
                                        } catch (IOException e48) {
                                            e = e48;
                                            iOException5 = e;
                                            str140 = str86;
                                            str141 = str173;
                                            obj2 = str84;
                                            i7 = i13;
                                            str138 = str140;
                                            str7 = str7;
                                            z8 = z8;
                                            str139 = str141;
                                            httpURLConnection31 = httpURLConnection23;
                                            byteArrayOutputStream = null;
                                            inputStream = null;
                                            obj4 = str138;
                                            obj2 = obj2;
                                            str7 = str7;
                                            z8 = z8;
                                            str70 = str242;
                                            f20 = z8;
                                            str3 = str139;
                                            if (!z) {
                                            }
                                            cdnConfigModel2 = cdnConfigModel17;
                                            String str2542222222 = str;
                                            j = j;
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                            if (!z) {
                                            }
                                            long j222222222 = j;
                                            if (httpURLConnection != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                            i13 = i2;
                                            if (imo != null) {
                                            }
                                            CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                            cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222;
                                            str245 = str6;
                                            str246 = str5;
                                            str244 = str4;
                                            z33 = z;
                                            i12 = i;
                                            uuid = str7;
                                            str242 = str2;
                                            str239 = obj2;
                                            str241 = obj;
                                            j14 = j2;
                                            ily = this;
                                            str243 = str8;
                                            str240 = str3;
                                            z34 = true;
                                        } catch (Throwable th15) {
                                            th = th15;
                                            str172 = str86;
                                            cdnConfigModel16 = cdnConfigModel17;
                                            obj2 = str84;
                                            z11 = z8;
                                            byteArrayOutputStream = null;
                                            inputStream8 = null;
                                            str170 = str172;
                                            obj2 = obj2;
                                            th = th;
                                            obj4 = str170;
                                            obj2 = obj2;
                                            str2 = str242;
                                            z2 = z34;
                                            str3 = str169;
                                            httpURLConnection = httpURLConnection35;
                                            if (!z) {
                                            }
                                            Throwable th62222222 = th;
                                            httpURLConnection2 = httpURLConnection;
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                            throw th62222222;
                                        }
                                    } else {
                                        try {
                                            j15 = System.currentTimeMillis();
                                            InputStream inputStream16 = O000000o2.getInputStream();
                                            try {
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "HlsDownloadThread 0");
                                                if (ily.O00000o != null) {
                                                    try {
                                                        byteArrayOutputStream19 = new ByteArrayOutputStream();
                                                    } catch (MalformedURLException e49) {
                                                        malformedURLException = e49;
                                                        str195 = str240;
                                                        inputStream9 = inputStream16;
                                                        str13 = str;
                                                        str196 = str116;
                                                        byteArrayOutputStream20 = null;
                                                    } catch (SocketTimeoutException e50) {
                                                        socketTimeoutException = e50;
                                                        str197 = str240;
                                                        inputStream10 = inputStream16;
                                                        str26 = str;
                                                        str198 = str116;
                                                        byteArrayOutputStream21 = null;
                                                        obj4 = str241;
                                                        httpURLConnection37 = O000000o2;
                                                        str25 = str118;
                                                        str24 = str107;
                                                        obj2 = obj2;
                                                        z24 = z8;
                                                        str219 = str197;
                                                        str23 = str242;
                                                        z23 = z24;
                                                        str218 = str219;
                                                        cdnConfigModel6 = cdnConfigModel17;
                                                        f20 = z23;
                                                        obj5 = str218;
                                                        imo.O00000oO = "0.0";
                                                        if (imo.O0000Oo <= 0.0f) {
                                                        }
                                                        if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                        }
                                                        imo.O0000o0O = str21;
                                                        imo.O0000o0o = str21;
                                                        imo.O0000o = str247;
                                                        imo.O00000o = true;
                                                        if (!z) {
                                                        }
                                                        long j1822222222 = j;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream != null) {
                                                        }
                                                        str20 = XMediaplayerJNI.O0000o0;
                                                        sb2 = new StringBuilder(str4);
                                                        str7 = str7;
                                                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                        imc.O000000o(str20, (Object) sb2.toString());
                                                        j2 = j202222222;
                                                        f20 = f20;
                                                        if (imo != null) {
                                                        }
                                                        CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                        cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222;
                                                        str245 = str6;
                                                        str246 = str5;
                                                        str244 = str4;
                                                        z33 = z;
                                                        i12 = i;
                                                        uuid = str7;
                                                        str242 = str2;
                                                        str239 = obj2;
                                                        str241 = obj;
                                                        j14 = j2;
                                                        ily = this;
                                                        str243 = str8;
                                                        str240 = str3;
                                                        z34 = true;
                                                    } catch (UnknownHostException e51) {
                                                        unknownHostException = e51;
                                                        str199 = str240;
                                                        inputStream11 = inputStream16;
                                                        str38 = str;
                                                        str200 = str116;
                                                        byteArrayOutputStream22 = null;
                                                        obj4 = str241;
                                                        httpURLConnection38 = O000000o2;
                                                        str37 = str118;
                                                        str36 = str107;
                                                        z26 = z8;
                                                        str222 = str199;
                                                        str34 = str242;
                                                        z25 = z26;
                                                        str221 = str222;
                                                        cdnConfigModel8 = cdnConfigModel17;
                                                        f20 = z25;
                                                        str35 = str221;
                                                        if (imo.O0000Oo <= 0.0f) {
                                                        }
                                                        imo.O0000O0o = "dns_fail";
                                                        imo.O00000oo = imq.O000000o(unknownHostException);
                                                        imo.O00000oO = "0.0";
                                                        imo.O0000o0O = str21;
                                                        imo.O0000o0o = str21;
                                                        imo.O0000o = str247;
                                                        if (!z) {
                                                        }
                                                        long j1922222222 = j;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream != null) {
                                                        }
                                                        str20 = XMediaplayerJNI.O0000o0;
                                                        sb2 = new StringBuilder(str4);
                                                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                        imc.O000000o(str20, (Object) sb2.toString());
                                                        j2 = j202222222;
                                                        f20 = f20;
                                                        if (imo != null) {
                                                        }
                                                        CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                        cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222;
                                                        str245 = str6;
                                                        str246 = str5;
                                                        str244 = str4;
                                                        z33 = z;
                                                        i12 = i;
                                                        uuid = str7;
                                                        str242 = str2;
                                                        str239 = obj2;
                                                        str241 = obj;
                                                        j14 = j2;
                                                        ily = this;
                                                        str243 = str8;
                                                        str240 = str3;
                                                        z34 = true;
                                                    } catch (IllegalArgumentException e52) {
                                                        illegalArgumentException = e52;
                                                        str201 = str240;
                                                        inputStream12 = inputStream16;
                                                        str21 = str;
                                                        str202 = str116;
                                                        byteArrayOutputStream23 = null;
                                                        obj4 = str241;
                                                        httpURLConnection40 = O000000o2;
                                                        str51 = str118;
                                                        str50 = str107;
                                                        z28 = z8;
                                                        str225 = str201;
                                                        str48 = str242;
                                                        obj2 = obj2;
                                                        z27 = z28;
                                                        str224 = str225;
                                                        cdnConfigModel10 = cdnConfigModel17;
                                                        f20 = z27;
                                                        str238 = str224;
                                                        if (imo.O0000Oo <= 0.0f) {
                                                        }
                                                        imo.O0000O0o = "dns_fail";
                                                        imo.O00000oo = imq.O000000o(illegalArgumentException);
                                                        imo.O00000oO = "0.0";
                                                        imo.O0000o0O = str21;
                                                        imo.O0000o0o = str21;
                                                        imo.O0000o = str247;
                                                        if (!z) {
                                                        }
                                                        long j2022222222 = j;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream != null) {
                                                        }
                                                        str20 = XMediaplayerJNI.O0000o0;
                                                        sb2 = new StringBuilder(str4);
                                                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                        imc.O000000o(str20, (Object) sb2.toString());
                                                        j2 = j2022222222;
                                                        f20 = f20;
                                                        if (imo != null) {
                                                        }
                                                        CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                        cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222;
                                                        str245 = str6;
                                                        str246 = str5;
                                                        str244 = str4;
                                                        z33 = z;
                                                        i12 = i;
                                                        uuid = str7;
                                                        str242 = str2;
                                                        str239 = obj2;
                                                        str241 = obj;
                                                        j14 = j2;
                                                        ily = this;
                                                        str243 = str8;
                                                        str240 = str3;
                                                        z34 = true;
                                                    } catch (FileNotFoundException e53) {
                                                        fileNotFoundException = e53;
                                                        str203 = str240;
                                                        inputStream13 = inputStream16;
                                                        str8 = str;
                                                        str204 = str116;
                                                        byteArrayOutputStream24 = null;
                                                        obj32 = str241;
                                                        httpURLConnection11 = O000000o2;
                                                        str62 = str118;
                                                        str61 = str107;
                                                        z30 = z8;
                                                        str229 = str203;
                                                        str59 = str242;
                                                        str161 = obj32;
                                                        z29 = z30;
                                                        str228 = str229;
                                                        cdnConfigModel2 = cdnConfigModel17;
                                                        obj = str161;
                                                        f20 = z29;
                                                        obj34 = str228;
                                                        if (imo.O0000Oo <= 0.0f) {
                                                        }
                                                        imo.O0000O0o = "system_exception";
                                                        imo.O00000oo = imq.O000000o(fileNotFoundException);
                                                        imo.O00000oO = "0.0";
                                                        imo.O0000o0O = str8;
                                                        imo.O0000o0o = str8;
                                                        imo.O0000o = str247;
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                                        if (!z) {
                                                        }
                                                        long j2122222222 = j;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream != null) {
                                                        }
                                                        str9 = XMediaplayerJNI.O0000o0;
                                                        sb = new StringBuilder(str4);
                                                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                        imc.O000000o(str9, (Object) sb.toString());
                                                        f20 = f20;
                                                        if (imo != null) {
                                                        }
                                                        CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                        cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222;
                                                        str245 = str6;
                                                        str246 = str5;
                                                        str244 = str4;
                                                        z33 = z;
                                                        i12 = i;
                                                        uuid = str7;
                                                        str242 = str2;
                                                        str239 = obj2;
                                                        str241 = obj;
                                                        j14 = j2;
                                                        ily = this;
                                                        str243 = str8;
                                                        str240 = str3;
                                                        z34 = true;
                                                    } catch (IOException e54) {
                                                        iOException = e54;
                                                        str205 = str240;
                                                        inputStream14 = inputStream16;
                                                        i2 = i13;
                                                        str206 = str116;
                                                        byteArrayOutputStream25 = null;
                                                        obj4 = str241;
                                                        httpURLConnection31 = O000000o2;
                                                        str73 = str118;
                                                        str72 = str107;
                                                        obj2 = obj2;
                                                        z8 = z8;
                                                        str139 = str205;
                                                        str70 = str242;
                                                        f20 = z8;
                                                        str3 = str139;
                                                        if (!z) {
                                                        }
                                                        cdnConfigModel2 = cdnConfigModel17;
                                                        String str25422222222 = str;
                                                        j = j;
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                                        if (!z) {
                                                        }
                                                        long j2222222222 = j;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream != null) {
                                                        }
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                        i13 = i2;
                                                        if (imo != null) {
                                                        }
                                                        CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                        cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222;
                                                        str245 = str6;
                                                        str246 = str5;
                                                        str244 = str4;
                                                        z33 = z;
                                                        i12 = i;
                                                        uuid = str7;
                                                        str242 = str2;
                                                        str239 = obj2;
                                                        str241 = obj;
                                                        j14 = j2;
                                                        ily = this;
                                                        str243 = str8;
                                                        str240 = str3;
                                                        z34 = true;
                                                    } catch (Throwable th16) {
                                                        th = th16;
                                                        cdnConfigModel = cdnConfigModel17;
                                                        inputStream = inputStream16;
                                                        f = z8;
                                                        str247 = str116;
                                                        byteArrayOutputStream = null;
                                                        str193 = str241;
                                                        httpURLConnection34 = O000000o2;
                                                        str168 = str118;
                                                        str4 = str107;
                                                        obj2 = obj2;
                                                        str2 = str242;
                                                        z2 = z34;
                                                        str167 = str193;
                                                        obj2 = obj2;
                                                        str3 = str240;
                                                        obj = str167;
                                                        th = th;
                                                        if (!z) {
                                                        }
                                                        Throwable th622222222 = th;
                                                        httpURLConnection2 = httpURLConnection;
                                                        if (httpURLConnection2 != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream != null) {
                                                        }
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                        throw th622222222;
                                                    }
                                                } else {
                                                    byteArrayOutputStream19 = null;
                                                }
                                                try {
                                                    byte[] bArr = new byte[1024];
                                                    i6 = 0;
                                                    while (true) {
                                                        read = inputStream16.read(bArr);
                                                        inputStream = inputStream16;
                                                        if (read == -1) {
                                                            break;
                                                        }
                                                        int i16 = i6 + read;
                                                        if (byteArrayOutputStream != null) {
                                                            try {
                                                                byteArrayOutputStream.write(bArr, 0, read);
                                                            } catch (MalformedURLException e55) {
                                                                malformedURLException6 = e55;
                                                                str194 = str240;
                                                                httpURLConnection3 = O000000o2;
                                                                i13 = i6;
                                                            } catch (SocketTimeoutException e56) {
                                                                socketTimeoutException6 = e56;
                                                                String str284 = str240;
                                                                httpURLConnection5 = O000000o2;
                                                                i13 = i6;
                                                                str148 = str;
                                                                str149 = str107;
                                                                str150 = str116;
                                                                str147 = str284;
                                                                obj4 = str241;
                                                                str23 = str242;
                                                                str25 = str118;
                                                                z23 = z8;
                                                                str218 = str147;
                                                                cdnConfigModel6 = cdnConfigModel17;
                                                                f20 = z23;
                                                                obj5 = str218;
                                                                imo.O00000oO = "0.0";
                                                                if (imo.O0000Oo <= 0.0f) {
                                                                }
                                                                if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                                }
                                                                imo.O0000o0O = str21;
                                                                imo.O0000o0o = str21;
                                                                imo.O0000o = str247;
                                                                imo.O00000o = true;
                                                                if (!z) {
                                                                }
                                                                long j18222222222 = j;
                                                                if (httpURLConnection != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                                if (byteArrayOutputStream != null) {
                                                                }
                                                                str20 = XMediaplayerJNI.O0000o0;
                                                                sb2 = new StringBuilder(str4);
                                                                str7 = str7;
                                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                                imc.O000000o(str20, (Object) sb2.toString());
                                                                j2 = j2022222222;
                                                                f20 = f20;
                                                                if (imo != null) {
                                                                }
                                                                CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                                cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222;
                                                                str245 = str6;
                                                                str246 = str5;
                                                                str244 = str4;
                                                                z33 = z;
                                                                i12 = i;
                                                                uuid = str7;
                                                                str242 = str2;
                                                                str239 = obj2;
                                                                str241 = obj;
                                                                j14 = j2;
                                                                ily = this;
                                                                str243 = str8;
                                                                str240 = str3;
                                                                z34 = true;
                                                            } catch (UnknownHostException e57) {
                                                                unknownHostException6 = e57;
                                                                String str285 = str240;
                                                                httpURLConnection7 = O000000o2;
                                                                i13 = i6;
                                                                str152 = str;
                                                                str153 = str107;
                                                                str154 = str116;
                                                                str151 = str285;
                                                                obj4 = str241;
                                                                str34 = str242;
                                                                str37 = str118;
                                                                z25 = z8;
                                                                str221 = str151;
                                                                cdnConfigModel8 = cdnConfigModel17;
                                                                f20 = z25;
                                                                str35 = str221;
                                                                if (imo.O0000Oo <= 0.0f) {
                                                                }
                                                                imo.O0000O0o = "dns_fail";
                                                                imo.O00000oo = imq.O000000o(unknownHostException);
                                                                imo.O00000oO = "0.0";
                                                                imo.O0000o0O = str21;
                                                                imo.O0000o0o = str21;
                                                                imo.O0000o = str247;
                                                                if (!z) {
                                                                }
                                                                long j19222222222 = j;
                                                                if (httpURLConnection != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                                if (byteArrayOutputStream != null) {
                                                                }
                                                                str20 = XMediaplayerJNI.O0000o0;
                                                                sb2 = new StringBuilder(str4);
                                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                                imc.O000000o(str20, (Object) sb2.toString());
                                                                j2 = j2022222222;
                                                                f20 = f20;
                                                                if (imo != null) {
                                                                }
                                                                CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                                cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222;
                                                                str245 = str6;
                                                                str246 = str5;
                                                                str244 = str4;
                                                                z33 = z;
                                                                i12 = i;
                                                                uuid = str7;
                                                                str242 = str2;
                                                                str239 = obj2;
                                                                str241 = obj;
                                                                j14 = j2;
                                                                ily = this;
                                                                str243 = str8;
                                                                str240 = str3;
                                                                z34 = true;
                                                            } catch (IllegalArgumentException e58) {
                                                                illegalArgumentException6 = e58;
                                                                String str286 = str240;
                                                                httpURLConnection9 = O000000o2;
                                                                i13 = i6;
                                                                str156 = str;
                                                                str157 = str107;
                                                                str158 = str116;
                                                                str155 = str286;
                                                                obj4 = str241;
                                                                str48 = str242;
                                                                str51 = str118;
                                                                z27 = z8;
                                                                str224 = str155;
                                                                cdnConfigModel10 = cdnConfigModel17;
                                                                f20 = z27;
                                                                str238 = str224;
                                                                if (imo.O0000Oo <= 0.0f) {
                                                                }
                                                                imo.O0000O0o = "dns_fail";
                                                                imo.O00000oo = imq.O000000o(illegalArgumentException);
                                                                imo.O00000oO = "0.0";
                                                                imo.O0000o0O = str21;
                                                                imo.O0000o0o = str21;
                                                                imo.O0000o = str247;
                                                                if (!z) {
                                                                }
                                                                long j20222222222 = j;
                                                                if (httpURLConnection != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                                if (byteArrayOutputStream != null) {
                                                                }
                                                                str20 = XMediaplayerJNI.O0000o0;
                                                                sb2 = new StringBuilder(str4);
                                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                                imc.O000000o(str20, (Object) sb2.toString());
                                                                j2 = j20222222222;
                                                                f20 = f20;
                                                                if (imo != null) {
                                                                }
                                                                CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                                cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222;
                                                                str245 = str6;
                                                                str246 = str5;
                                                                str244 = str4;
                                                                z33 = z;
                                                                i12 = i;
                                                                uuid = str7;
                                                                str242 = str2;
                                                                str239 = obj2;
                                                                str241 = obj;
                                                                j14 = j2;
                                                                ily = this;
                                                                str243 = str8;
                                                                str240 = str3;
                                                                z34 = true;
                                                            } catch (FileNotFoundException e59) {
                                                                fileNotFoundException6 = e59;
                                                                String str287 = str240;
                                                                HttpURLConnection httpURLConnection44 = O000000o2;
                                                                i13 = i6;
                                                                str162 = str;
                                                                str163 = str107;
                                                                str160 = str116;
                                                                str159 = str287;
                                                                httpURLConnection33 = httpURLConnection44;
                                                                str161 = str241;
                                                                str59 = str242;
                                                                str62 = str118;
                                                                z29 = z8;
                                                                str228 = str159;
                                                                httpURLConnection11 = httpURLConnection33;
                                                                str247 = str160;
                                                                cdnConfigModel2 = cdnConfigModel17;
                                                                obj = str161;
                                                                f20 = z29;
                                                                obj34 = str228;
                                                                if (imo.O0000Oo <= 0.0f) {
                                                                }
                                                                imo.O0000O0o = "system_exception";
                                                                imo.O00000oo = imq.O000000o(fileNotFoundException);
                                                                imo.O00000oO = "0.0";
                                                                imo.O0000o0O = str8;
                                                                imo.O0000o0o = str8;
                                                                imo.O0000o = str247;
                                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                                                if (!z) {
                                                                }
                                                                long j21222222222 = j;
                                                                if (httpURLConnection != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                                if (byteArrayOutputStream != null) {
                                                                }
                                                                str9 = XMediaplayerJNI.O0000o0;
                                                                sb = new StringBuilder(str4);
                                                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                                imc.O000000o(str9, (Object) sb.toString());
                                                                f20 = f20;
                                                                if (imo != null) {
                                                                }
                                                                CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                                cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222;
                                                                str245 = str6;
                                                                str246 = str5;
                                                                str244 = str4;
                                                                z33 = z;
                                                                i12 = i;
                                                                uuid = str7;
                                                                str242 = str2;
                                                                str239 = obj2;
                                                                str241 = obj;
                                                                j14 = j2;
                                                                ily = this;
                                                                str243 = str8;
                                                                str240 = str3;
                                                                z34 = true;
                                                            } catch (IOException e60) {
                                                                iOException6 = e60;
                                                                String str288 = str240;
                                                                httpURLConnection = O000000o2;
                                                                str165 = str107;
                                                                str166 = str116;
                                                                str164 = str288;
                                                                obj4 = str241;
                                                                str70 = str242;
                                                                str73 = str118;
                                                                f20 = z8;
                                                                str3 = str164;
                                                                if (!z) {
                                                                }
                                                                cdnConfigModel2 = cdnConfigModel17;
                                                                String str254222222222 = str;
                                                                j = j;
                                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                                                if (!z) {
                                                                }
                                                                long j22222222222 = j;
                                                                if (httpURLConnection != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                                if (byteArrayOutputStream != null) {
                                                                }
                                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                                i13 = i2;
                                                                if (imo != null) {
                                                                }
                                                                CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                                cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222;
                                                                str245 = str6;
                                                                str246 = str5;
                                                                str244 = str4;
                                                                z33 = z;
                                                                i12 = i;
                                                                uuid = str7;
                                                                str242 = str2;
                                                                str239 = obj2;
                                                                str241 = obj;
                                                                j14 = j2;
                                                                ily = this;
                                                                str243 = str8;
                                                                str240 = str3;
                                                                z34 = true;
                                                            } catch (Throwable th17) {
                                                            }
                                                        }
                                                        i6 = i16;
                                                        i13 = i6;
                                                        inputStream16 = inputStream;
                                                    }
                                                    if (imo != null) {
                                                        if (i6 <= 0 || read != -1) {
                                                            str247 = str116;
                                                            try {
                                                                imo.O0000o = str247;
                                                            } catch (MalformedURLException e61) {
                                                                httpURLConnection35 = O000000o2;
                                                                malformedURLException7 = e61;
                                                                str187 = str240;
                                                                obj4 = str241;
                                                                i13 = i6;
                                                                str177 = str118;
                                                                z13 = z8;
                                                                str176 = str187;
                                                                str13 = str;
                                                                str12 = str107;
                                                                httpURLConnection36 = httpURLConnection35;
                                                                z22 = z13;
                                                                str5 = str177;
                                                                str10 = str242;
                                                                z21 = z22;
                                                                str216 = str176;
                                                                cdnConfigModel4 = cdnConfigModel17;
                                                                f20 = z21;
                                                                obj33 = str216;
                                                                if (imo.O0000Oo <= 0.0f) {
                                                                }
                                                                imo.O0000O0o = "cdn_connect_fail ";
                                                                imo.O00000oo = imq.O000000o(malformedURLException);
                                                                imo.O00000oO = "0.0";
                                                                imo.O0000o0O = str8;
                                                                imo.O0000o0o = str8;
                                                                imo.O0000o = str247;
                                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                                if (!z) {
                                                                }
                                                                long j232222222 = j;
                                                                if (httpURLConnection != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                                if (byteArrayOutputStream != null) {
                                                                }
                                                                str9 = XMediaplayerJNI.O0000o0;
                                                                sb = new StringBuilder(str4);
                                                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                                imc.O000000o(str9, (Object) sb.toString());
                                                                f20 = f20;
                                                                if (imo != null) {
                                                                }
                                                                CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                                cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222;
                                                                str245 = str6;
                                                                str246 = str5;
                                                                str244 = str4;
                                                                z33 = z;
                                                                i12 = i;
                                                                uuid = str7;
                                                                str242 = str2;
                                                                str239 = obj2;
                                                                str241 = obj;
                                                                j14 = j2;
                                                                ily = this;
                                                                str243 = str8;
                                                                str240 = str3;
                                                                z34 = true;
                                                            } catch (SocketTimeoutException e62) {
                                                                httpURLConnection35 = O000000o2;
                                                                socketTimeoutException7 = e62;
                                                                str188 = str240;
                                                                obj4 = str241;
                                                                i13 = i6;
                                                                str25 = str118;
                                                                httpURLConnection35 = httpURLConnection35;
                                                                z14 = z8;
                                                                str178 = str188;
                                                                str26 = str;
                                                                str24 = str107;
                                                                httpURLConnection37 = httpURLConnection35;
                                                                z24 = z14;
                                                                str219 = str178;
                                                                str23 = str242;
                                                                z23 = z24;
                                                                str218 = str219;
                                                                cdnConfigModel6 = cdnConfigModel17;
                                                                f20 = z23;
                                                                obj5 = str218;
                                                                imo.O00000oO = "0.0";
                                                                if (imo.O0000Oo <= 0.0f) {
                                                                }
                                                                if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                                }
                                                                imo.O0000o0O = str21;
                                                                imo.O0000o0o = str21;
                                                                imo.O0000o = str247;
                                                                imo.O00000o = true;
                                                                if (!z) {
                                                                }
                                                                long j182222222222 = j;
                                                                if (httpURLConnection != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                                if (byteArrayOutputStream != null) {
                                                                }
                                                                str20 = XMediaplayerJNI.O0000o0;
                                                                sb2 = new StringBuilder(str4);
                                                                str7 = str7;
                                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                                imc.O000000o(str20, (Object) sb2.toString());
                                                                j2 = j20222222222;
                                                                f20 = f20;
                                                                if (imo != null) {
                                                                }
                                                                CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                                cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222;
                                                                str245 = str6;
                                                                str246 = str5;
                                                                str244 = str4;
                                                                z33 = z;
                                                                i12 = i;
                                                                uuid = str7;
                                                                str242 = str2;
                                                                str239 = obj2;
                                                                str241 = obj;
                                                                j14 = j2;
                                                                ily = this;
                                                                str243 = str8;
                                                                str240 = str3;
                                                                z34 = true;
                                                            } catch (UnknownHostException e63) {
                                                                httpURLConnection35 = O000000o2;
                                                                unknownHostException7 = e63;
                                                                str189 = str240;
                                                                obj4 = str241;
                                                                i13 = i6;
                                                                str37 = str118;
                                                                httpURLConnection35 = httpURLConnection35;
                                                                z15 = z8;
                                                                str179 = str189;
                                                                str38 = str;
                                                                str36 = str107;
                                                                httpURLConnection38 = httpURLConnection35;
                                                                z26 = z15;
                                                                str222 = str179;
                                                                str34 = str242;
                                                                z25 = z26;
                                                                str221 = str222;
                                                                cdnConfigModel8 = cdnConfigModel17;
                                                                f20 = z25;
                                                                str35 = str221;
                                                                if (imo.O0000Oo <= 0.0f) {
                                                                }
                                                                imo.O0000O0o = "dns_fail";
                                                                imo.O00000oo = imq.O000000o(unknownHostException);
                                                                imo.O00000oO = "0.0";
                                                                imo.O0000o0O = str21;
                                                                imo.O0000o0o = str21;
                                                                imo.O0000o = str247;
                                                                if (!z) {
                                                                }
                                                                long j192222222222 = j;
                                                                if (httpURLConnection != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                                if (byteArrayOutputStream != null) {
                                                                }
                                                                str20 = XMediaplayerJNI.O0000o0;
                                                                sb2 = new StringBuilder(str4);
                                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                                imc.O000000o(str20, (Object) sb2.toString());
                                                                j2 = j20222222222;
                                                                f20 = f20;
                                                                if (imo != null) {
                                                                }
                                                                CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                                cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222;
                                                                str245 = str6;
                                                                str246 = str5;
                                                                str244 = str4;
                                                                z33 = z;
                                                                i12 = i;
                                                                uuid = str7;
                                                                str242 = str2;
                                                                str239 = obj2;
                                                                str241 = obj;
                                                                j14 = j2;
                                                                ily = this;
                                                                str243 = str8;
                                                                str240 = str3;
                                                                z34 = true;
                                                            } catch (IllegalArgumentException e64) {
                                                                httpURLConnection35 = O000000o2;
                                                                illegalArgumentException7 = e64;
                                                                str190 = str240;
                                                                obj4 = str241;
                                                                i13 = i6;
                                                                str51 = str118;
                                                                httpURLConnection39 = httpURLConnection35;
                                                                obj4 = obj4;
                                                                z16 = z8;
                                                                str180 = str190;
                                                                str21 = str;
                                                                str50 = str107;
                                                                httpURLConnection40 = httpURLConnection39;
                                                                z28 = z16;
                                                                str225 = str180;
                                                                str48 = str242;
                                                                obj2 = obj2;
                                                                z27 = z28;
                                                                str224 = str225;
                                                                cdnConfigModel10 = cdnConfigModel17;
                                                                f20 = z27;
                                                                str238 = str224;
                                                                if (imo.O0000Oo <= 0.0f) {
                                                                }
                                                                imo.O0000O0o = "dns_fail";
                                                                imo.O00000oo = imq.O000000o(illegalArgumentException);
                                                                imo.O00000oO = "0.0";
                                                                imo.O0000o0O = str21;
                                                                imo.O0000o0o = str21;
                                                                imo.O0000o = str247;
                                                                if (!z) {
                                                                }
                                                                long j202222222222 = j;
                                                                if (httpURLConnection != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                                if (byteArrayOutputStream != null) {
                                                                }
                                                                str20 = XMediaplayerJNI.O0000o0;
                                                                sb2 = new StringBuilder(str4);
                                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                                imc.O000000o(str20, (Object) sb2.toString());
                                                                j2 = j202222222222;
                                                                f20 = f20;
                                                                if (imo != null) {
                                                                }
                                                                CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                                cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222;
                                                                str245 = str6;
                                                                str246 = str5;
                                                                str244 = str4;
                                                                z33 = z;
                                                                i12 = i;
                                                                uuid = str7;
                                                                str242 = str2;
                                                                str239 = obj2;
                                                                str241 = obj;
                                                                j14 = j2;
                                                                ily = this;
                                                                str243 = str8;
                                                                str240 = str3;
                                                                z34 = true;
                                                            } catch (FileNotFoundException e65) {
                                                                httpURLConnection35 = O000000o2;
                                                                fileNotFoundException7 = e65;
                                                                str191 = str240;
                                                                obj4 = str241;
                                                                i13 = i6;
                                                                str62 = str118;
                                                                httpURLConnection41 = httpURLConnection35;
                                                                obj28 = obj4;
                                                                z17 = z8;
                                                                str181 = str191;
                                                                str8 = str;
                                                                str61 = str107;
                                                                httpURLConnection11 = httpURLConnection41;
                                                                obj32 = obj28;
                                                                z30 = z17;
                                                                str229 = str181;
                                                                str59 = str242;
                                                                str161 = obj32;
                                                                z29 = z30;
                                                                str228 = str229;
                                                                cdnConfigModel2 = cdnConfigModel17;
                                                                obj = str161;
                                                                f20 = z29;
                                                                obj34 = str228;
                                                                if (imo.O0000Oo <= 0.0f) {
                                                                }
                                                                imo.O0000O0o = "system_exception";
                                                                imo.O00000oo = imq.O000000o(fileNotFoundException);
                                                                imo.O00000oO = "0.0";
                                                                imo.O0000o0O = str8;
                                                                imo.O0000o0o = str8;
                                                                imo.O0000o = str247;
                                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                                                if (!z) {
                                                                }
                                                                long j212222222222 = j;
                                                                if (httpURLConnection != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                                if (byteArrayOutputStream != null) {
                                                                }
                                                                str9 = XMediaplayerJNI.O0000o0;
                                                                sb = new StringBuilder(str4);
                                                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                                imc.O000000o(str9, (Object) sb.toString());
                                                                f20 = f20;
                                                                if (imo != null) {
                                                                }
                                                                CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                                cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222;
                                                                str245 = str6;
                                                                str246 = str5;
                                                                str244 = str4;
                                                                z33 = z;
                                                                i12 = i;
                                                                uuid = str7;
                                                                str242 = str2;
                                                                str239 = obj2;
                                                                str241 = obj;
                                                                j14 = j2;
                                                                ily = this;
                                                                str243 = str8;
                                                                str240 = str3;
                                                                z34 = true;
                                                            } catch (IOException e66) {
                                                                httpURLConnection35 = O000000o2;
                                                                iOException7 = e66;
                                                                str182 = str240;
                                                                obj4 = str241;
                                                                str73 = str118;
                                                                httpURLConnection35 = httpURLConnection35;
                                                                z18 = z8;
                                                                str72 = str107;
                                                                httpURLConnection31 = httpURLConnection35;
                                                                z8 = z18;
                                                                str139 = str182;
                                                                str70 = str242;
                                                                f20 = z8;
                                                                str3 = str139;
                                                                if (!z) {
                                                                }
                                                                cdnConfigModel2 = cdnConfigModel17;
                                                                String str2542222222222 = str;
                                                                j = j;
                                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                                                if (!z) {
                                                                }
                                                                long j222222222222 = j;
                                                                if (httpURLConnection != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                                if (byteArrayOutputStream != null) {
                                                                }
                                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                                i13 = i2;
                                                                if (imo != null) {
                                                                }
                                                                CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                                cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222;
                                                                str245 = str6;
                                                                str246 = str5;
                                                                str244 = str4;
                                                                z33 = z;
                                                                i12 = i;
                                                                uuid = str7;
                                                                str242 = str2;
                                                                str239 = obj2;
                                                                str241 = obj;
                                                                j14 = j2;
                                                                ily = this;
                                                                str243 = str8;
                                                                str240 = str3;
                                                                z34 = true;
                                                            } catch (Throwable th18) {
                                                                th = th18;
                                                                HttpURLConnection httpURLConnection45 = O000000o2;
                                                                str193 = str241;
                                                                cdnConfigModel = cdnConfigModel17;
                                                                str168 = str118;
                                                                f = z8;
                                                                str4 = str107;
                                                                httpURLConnection34 = httpURLConnection45;
                                                                str2 = str242;
                                                                z2 = z34;
                                                                str167 = str193;
                                                                obj2 = obj2;
                                                                str3 = str240;
                                                                obj = str167;
                                                                th = th;
                                                                if (!z) {
                                                                }
                                                                Throwable th6222222222 = th;
                                                                httpURLConnection2 = httpURLConnection;
                                                                if (httpURLConnection2 != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                                if (byteArrayOutputStream != null) {
                                                                }
                                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                                throw th6222222222;
                                                            }
                                                        } else {
                                                            imo.O0000o = str6;
                                                            str247 = str116;
                                                        }
                                                        str169 = str240;
                                                        String str289 = str241;
                                                        long currentTimeMillis3 = System.currentTimeMillis() - j15;
                                                        if (currentTimeMillis3 != 0) {
                                                            obj4 = str289;
                                                            httpURLConnection35 = O000000o2;
                                                            z8 = ((((float) i6) + 0.0f) / 1024.0f) / ((((float) currentTimeMillis3) + 0.0f) / 1000.0f);
                                                        } else {
                                                            httpURLConnection35 = O000000o2;
                                                            obj4 = str289;
                                                        }
                                                        z20 = z8;
                                                        try {
                                                            imo.O0000o0O = String.valueOf(i6);
                                                            imo.O0000o0o = String.valueOf(currentTimeMillis3);
                                                            StringBuilder sb11 = new StringBuilder();
                                                            sb11.append(imq.O000000o((float) z20, true));
                                                            imo.O00000oO = sb11.toString();
                                                            i13 = i6;
                                                        } catch (MalformedURLException e67) {
                                                            malformedURLException7 = e67;
                                                            z8 = z20;
                                                            str187 = str169;
                                                            i13 = i6;
                                                            str177 = str118;
                                                            z13 = z8;
                                                            str176 = str187;
                                                            str13 = str;
                                                            str12 = str107;
                                                            httpURLConnection36 = httpURLConnection35;
                                                            z22 = z13;
                                                            str5 = str177;
                                                            str10 = str242;
                                                            z21 = z22;
                                                            str216 = str176;
                                                            cdnConfigModel4 = cdnConfigModel17;
                                                            f20 = z21;
                                                            obj33 = str216;
                                                            if (imo.O0000Oo <= 0.0f) {
                                                            }
                                                            imo.O0000O0o = "cdn_connect_fail ";
                                                            imo.O00000oo = imq.O000000o(malformedURLException);
                                                            imo.O00000oO = "0.0";
                                                            imo.O0000o0O = str8;
                                                            imo.O0000o0o = str8;
                                                            imo.O0000o = str247;
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                            if (!z) {
                                                            }
                                                            long j2322222222 = j;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            str9 = XMediaplayerJNI.O0000o0;
                                                            sb = new StringBuilder(str4);
                                                            sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                            imc.O000000o(str9, (Object) sb.toString());
                                                            f20 = f20;
                                                            if (imo != null) {
                                                            }
                                                            CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                            cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222;
                                                            str245 = str6;
                                                            str246 = str5;
                                                            str244 = str4;
                                                            z33 = z;
                                                            i12 = i;
                                                            uuid = str7;
                                                            str242 = str2;
                                                            str239 = obj2;
                                                            str241 = obj;
                                                            j14 = j2;
                                                            ily = this;
                                                            str243 = str8;
                                                            str240 = str3;
                                                            z34 = true;
                                                        } catch (SocketTimeoutException e68) {
                                                            socketTimeoutException7 = e68;
                                                            z8 = z20;
                                                            str188 = str169;
                                                            i13 = i6;
                                                            str25 = str118;
                                                            httpURLConnection35 = httpURLConnection35;
                                                            z14 = z8;
                                                            str178 = str188;
                                                            str26 = str;
                                                            str24 = str107;
                                                            httpURLConnection37 = httpURLConnection35;
                                                            z24 = z14;
                                                            str219 = str178;
                                                            str23 = str242;
                                                            z23 = z24;
                                                            str218 = str219;
                                                            cdnConfigModel6 = cdnConfigModel17;
                                                            f20 = z23;
                                                            obj5 = str218;
                                                            imo.O00000oO = "0.0";
                                                            if (imo.O0000Oo <= 0.0f) {
                                                            }
                                                            if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                            }
                                                            imo.O0000o0O = str21;
                                                            imo.O0000o0o = str21;
                                                            imo.O0000o = str247;
                                                            imo.O00000o = true;
                                                            if (!z) {
                                                            }
                                                            long j1822222222222 = j;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            str20 = XMediaplayerJNI.O0000o0;
                                                            sb2 = new StringBuilder(str4);
                                                            str7 = str7;
                                                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                            imc.O000000o(str20, (Object) sb2.toString());
                                                            j2 = j202222222222;
                                                            f20 = f20;
                                                            if (imo != null) {
                                                            }
                                                            CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                            cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222;
                                                            str245 = str6;
                                                            str246 = str5;
                                                            str244 = str4;
                                                            z33 = z;
                                                            i12 = i;
                                                            uuid = str7;
                                                            str242 = str2;
                                                            str239 = obj2;
                                                            str241 = obj;
                                                            j14 = j2;
                                                            ily = this;
                                                            str243 = str8;
                                                            str240 = str3;
                                                            z34 = true;
                                                        } catch (UnknownHostException e69) {
                                                            unknownHostException7 = e69;
                                                            z8 = z20;
                                                            str189 = str169;
                                                            i13 = i6;
                                                            str37 = str118;
                                                            httpURLConnection35 = httpURLConnection35;
                                                            z15 = z8;
                                                            str179 = str189;
                                                            str38 = str;
                                                            str36 = str107;
                                                            httpURLConnection38 = httpURLConnection35;
                                                            z26 = z15;
                                                            str222 = str179;
                                                            str34 = str242;
                                                            z25 = z26;
                                                            str221 = str222;
                                                            cdnConfigModel8 = cdnConfigModel17;
                                                            f20 = z25;
                                                            str35 = str221;
                                                            if (imo.O0000Oo <= 0.0f) {
                                                            }
                                                            imo.O0000O0o = "dns_fail";
                                                            imo.O00000oo = imq.O000000o(unknownHostException);
                                                            imo.O00000oO = "0.0";
                                                            imo.O0000o0O = str21;
                                                            imo.O0000o0o = str21;
                                                            imo.O0000o = str247;
                                                            if (!z) {
                                                            }
                                                            long j1922222222222 = j;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            str20 = XMediaplayerJNI.O0000o0;
                                                            sb2 = new StringBuilder(str4);
                                                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                            imc.O000000o(str20, (Object) sb2.toString());
                                                            j2 = j202222222222;
                                                            f20 = f20;
                                                            if (imo != null) {
                                                            }
                                                            CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                            cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222;
                                                            str245 = str6;
                                                            str246 = str5;
                                                            str244 = str4;
                                                            z33 = z;
                                                            i12 = i;
                                                            uuid = str7;
                                                            str242 = str2;
                                                            str239 = obj2;
                                                            str241 = obj;
                                                            j14 = j2;
                                                            ily = this;
                                                            str243 = str8;
                                                            str240 = str3;
                                                            z34 = true;
                                                        } catch (IllegalArgumentException e70) {
                                                            illegalArgumentException7 = e70;
                                                            z8 = z20;
                                                            str190 = str169;
                                                            i13 = i6;
                                                            str51 = str118;
                                                            httpURLConnection39 = httpURLConnection35;
                                                            obj4 = obj4;
                                                            z16 = z8;
                                                            str180 = str190;
                                                            str21 = str;
                                                            str50 = str107;
                                                            httpURLConnection40 = httpURLConnection39;
                                                            z28 = z16;
                                                            str225 = str180;
                                                            str48 = str242;
                                                            obj2 = obj2;
                                                            z27 = z28;
                                                            str224 = str225;
                                                            cdnConfigModel10 = cdnConfigModel17;
                                                            f20 = z27;
                                                            str238 = str224;
                                                            if (imo.O0000Oo <= 0.0f) {
                                                            }
                                                            imo.O0000O0o = "dns_fail";
                                                            imo.O00000oo = imq.O000000o(illegalArgumentException);
                                                            imo.O00000oO = "0.0";
                                                            imo.O0000o0O = str21;
                                                            imo.O0000o0o = str21;
                                                            imo.O0000o = str247;
                                                            if (!z) {
                                                            }
                                                            long j2022222222222 = j;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            str20 = XMediaplayerJNI.O0000o0;
                                                            sb2 = new StringBuilder(str4);
                                                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                            imc.O000000o(str20, (Object) sb2.toString());
                                                            j2 = j2022222222222;
                                                            f20 = f20;
                                                            if (imo != null) {
                                                            }
                                                            CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                            cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222;
                                                            str245 = str6;
                                                            str246 = str5;
                                                            str244 = str4;
                                                            z33 = z;
                                                            i12 = i;
                                                            uuid = str7;
                                                            str242 = str2;
                                                            str239 = obj2;
                                                            str241 = obj;
                                                            j14 = j2;
                                                            ily = this;
                                                            str243 = str8;
                                                            str240 = str3;
                                                            z34 = true;
                                                        } catch (FileNotFoundException e71) {
                                                            fileNotFoundException7 = e71;
                                                            z8 = z20;
                                                            str191 = str169;
                                                            i13 = i6;
                                                            str62 = str118;
                                                            httpURLConnection41 = httpURLConnection35;
                                                            obj28 = obj4;
                                                            z17 = z8;
                                                            str181 = str191;
                                                            str8 = str;
                                                            str61 = str107;
                                                            httpURLConnection11 = httpURLConnection41;
                                                            obj32 = obj28;
                                                            z30 = z17;
                                                            str229 = str181;
                                                            str59 = str242;
                                                            str161 = obj32;
                                                            z29 = z30;
                                                            str228 = str229;
                                                            cdnConfigModel2 = cdnConfigModel17;
                                                            obj = str161;
                                                            f20 = z29;
                                                            obj34 = str228;
                                                            if (imo.O0000Oo <= 0.0f) {
                                                            }
                                                            imo.O0000O0o = "system_exception";
                                                            imo.O00000oo = imq.O000000o(fileNotFoundException);
                                                            imo.O00000oO = "0.0";
                                                            imo.O0000o0O = str8;
                                                            imo.O0000o0o = str8;
                                                            imo.O0000o = str247;
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                                            if (!z) {
                                                            }
                                                            long j2122222222222 = j;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            str9 = XMediaplayerJNI.O0000o0;
                                                            sb = new StringBuilder(str4);
                                                            sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                            imc.O000000o(str9, (Object) sb.toString());
                                                            f20 = f20;
                                                            if (imo != null) {
                                                            }
                                                            CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                            cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222;
                                                            str245 = str6;
                                                            str246 = str5;
                                                            str244 = str4;
                                                            z33 = z;
                                                            i12 = i;
                                                            uuid = str7;
                                                            str242 = str2;
                                                            str239 = obj2;
                                                            str241 = obj;
                                                            j14 = j2;
                                                            ily = this;
                                                            str243 = str8;
                                                            str240 = str3;
                                                            z34 = true;
                                                        } catch (IOException e72) {
                                                            iOException7 = e72;
                                                            z8 = z20;
                                                            str182 = str169;
                                                            str73 = str118;
                                                            httpURLConnection35 = httpURLConnection35;
                                                            z18 = z8;
                                                            str72 = str107;
                                                            httpURLConnection31 = httpURLConnection35;
                                                            z8 = z18;
                                                            str139 = str182;
                                                            str70 = str242;
                                                            f20 = z8;
                                                            str3 = str139;
                                                            if (!z) {
                                                            }
                                                            cdnConfigModel2 = cdnConfigModel17;
                                                            String str25422222222222 = str;
                                                            j = j;
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                                            if (!z) {
                                                            }
                                                            long j2222222222222 = j;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                            i13 = i2;
                                                            if (imo != null) {
                                                            }
                                                            CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                            cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222;
                                                            str245 = str6;
                                                            str246 = str5;
                                                            str244 = str4;
                                                            z33 = z;
                                                            i12 = i;
                                                            uuid = str7;
                                                            str242 = str2;
                                                            str239 = obj2;
                                                            str241 = obj;
                                                            j14 = j2;
                                                            ily = this;
                                                            str243 = str8;
                                                            str240 = str3;
                                                            z34 = true;
                                                        } catch (Throwable th19) {
                                                            th = th19;
                                                            z10 = z20;
                                                            cdnConfigModel15 = cdnConfigModel17;
                                                            str171 = str118;
                                                            str72 = str107;
                                                            str2 = str242;
                                                            z2 = z34;
                                                            str3 = str169;
                                                            httpURLConnection = httpURLConnection35;
                                                            if (!z) {
                                                            }
                                                            Throwable th62222222222 = th;
                                                            httpURLConnection2 = httpURLConnection;
                                                            if (httpURLConnection2 != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                            throw th62222222222;
                                                        }
                                                    } else {
                                                        str169 = str240;
                                                        httpURLConnection35 = O000000o2;
                                                        str247 = str116;
                                                        obj4 = str241;
                                                        z20 = z8;
                                                    }
                                                    if (byteArrayOutputStream == null) {
                                                        break;
                                                    }
                                                    try {
                                                        if (ily.O00000o != null) {
                                                            ily.O00000o.O000000o(byteArrayOutputStream.toByteArray());
                                                            int i17 = ily.O00000o.O00000o;
                                                            if (z || imo == null) {
                                                                i10 = i17;
                                                            } else {
                                                                if (TextUtils.isEmpty(imo.O0000Oo0)) {
                                                                    imo.O0000Oo0 = null;
                                                                }
                                                                if (TextUtils.isEmpty(imo.O0000OOo)) {
                                                                    imo.O0000OOo = str118;
                                                                }
                                                                i10 = i17;
                                                                imo.O0000OoO = System.currentTimeMillis();
                                                                if (imo.O0000o == null || !imo.O0000o.contains(str6)) {
                                                                    imo.O0000o = str247;
                                                                }
                                                                if (!z34 && (i11 = cdnConfigModel17.O00000oO) != -1) {
                                                                    if (i11 == 0) {
                                                                        ily.f1456O000000o = (long) cdnConfigModel17.O00000Oo;
                                                                        ily.O00000Oo = (long) cdnConfigModel17.O00000o;
                                                                        if (j > ily.f1456O000000o * 1000) {
                                                                            imo.O0000O0o = str242;
                                                                            imo.O00000oo = obj4 + imq.O000000o((float) j, false) + str169 + ily.f1456O000000o + obj2;
                                                                        } else if (((float) ily.O00000Oo) > z20) {
                                                                            imo.O0000O0o = "cdn_download_too_slow";
                                                                            imo.O00000oo = "download_speed=" + imq.O000000o((float) z20, true) + "KB/s, download_speed_threshold=" + ily.O00000Oo + "KB/s";
                                                                        }
                                                                    } else {
                                                                        String str290 = obj2;
                                                                        String str291 = obj4;
                                                                        if (i11 == 1) {
                                                                            byteArrayOutputStream18 = byteArrayOutputStream;
                                                                            ily.f1456O000000o = (long) cdnConfigModel17.f12180O000000o;
                                                                            ily.O00000Oo = (long) cdnConfigModel17.O00000o0;
                                                                            ily.f1456O000000o = 0;
                                                                            if (j > ily.f1456O000000o * 1000) {
                                                                                imo.O0000O0o = str242;
                                                                                imo.O00000oo = str291 + imq.O000000o((float) j, false) + str169 + ily.f1456O000000o + str290;
                                                                            } else if (((float) ily.O00000Oo) > z20) {
                                                                                imo.O0000O0o = "cdn_download_too_slow";
                                                                                imo.O00000oo = "download_speed=" + imq.O000000o((float) z20, true) + "KB/s, download_speed_threshold=" + ily.O00000Oo + "KB/s";
                                                                            }
                                                                            if (httpURLConnection35 != 0) {
                                                                                httpURLConnection35.disconnect();
                                                                            }
                                                                            if (inputStream != null) {
                                                                                try {
                                                                                    inputStream.close();
                                                                                } catch (IOException unused) {
                                                                                }
                                                                            }
                                                                            if (byteArrayOutputStream18 != null) {
                                                                                try {
                                                                                    byteArrayOutputStream18.close();
                                                                                } catch (IOException unused2) {
                                                                                }
                                                                            }
                                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str107 + (System.currentTimeMillis() - currentTimeMillis)));
                                                                            return i10;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            byteArrayOutputStream18 = byteArrayOutputStream;
                                                            if (httpURLConnection35 != 0) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (byteArrayOutputStream18 != null) {
                                                            }
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str107 + (System.currentTimeMillis() - currentTimeMillis)));
                                                            return i10;
                                                        }
                                                    } catch (MalformedURLException e73) {
                                                        str177 = str118;
                                                        malformedURLException8 = e73;
                                                        z8 = z20;
                                                        str176 = str169;
                                                        httpURLConnection35 = httpURLConnection35;
                                                        obj4 = obj4;
                                                        z13 = z8;
                                                        str13 = str;
                                                        str12 = str107;
                                                        httpURLConnection36 = httpURLConnection35;
                                                        z22 = z13;
                                                        str5 = str177;
                                                        str10 = str242;
                                                        z21 = z22;
                                                        str216 = str176;
                                                        cdnConfigModel4 = cdnConfigModel17;
                                                        f20 = z21;
                                                        obj33 = str216;
                                                        if (imo.O0000Oo <= 0.0f) {
                                                        }
                                                        imo.O0000O0o = "cdn_connect_fail ";
                                                        imo.O00000oo = imq.O000000o(malformedURLException);
                                                        imo.O00000oO = "0.0";
                                                        imo.O0000o0O = str8;
                                                        imo.O0000o0o = str8;
                                                        imo.O0000o = str247;
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                        if (!z) {
                                                        }
                                                        long j23222222222 = j;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream != null) {
                                                        }
                                                        str9 = XMediaplayerJNI.O0000o0;
                                                        sb = new StringBuilder(str4);
                                                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                        imc.O000000o(str9, (Object) sb.toString());
                                                        f20 = f20;
                                                        if (imo != null) {
                                                        }
                                                        CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                        cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222;
                                                        str245 = str6;
                                                        str246 = str5;
                                                        str244 = str4;
                                                        z33 = z;
                                                        i12 = i;
                                                        uuid = str7;
                                                        str242 = str2;
                                                        str239 = obj2;
                                                        str241 = obj;
                                                        j14 = j2;
                                                        ily = this;
                                                        str243 = str8;
                                                        str240 = str3;
                                                        z34 = true;
                                                    } catch (SocketTimeoutException e74) {
                                                        str25 = str118;
                                                        socketTimeoutException8 = e74;
                                                        z8 = z20;
                                                        str178 = str169;
                                                        z14 = z8;
                                                        str26 = str;
                                                        str24 = str107;
                                                        httpURLConnection37 = httpURLConnection35;
                                                        z24 = z14;
                                                        str219 = str178;
                                                        str23 = str242;
                                                        z23 = z24;
                                                        str218 = str219;
                                                        cdnConfigModel6 = cdnConfigModel17;
                                                        f20 = z23;
                                                        obj5 = str218;
                                                        imo.O00000oO = "0.0";
                                                        if (imo.O0000Oo <= 0.0f) {
                                                        }
                                                        if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                        }
                                                        imo.O0000o0O = str21;
                                                        imo.O0000o0o = str21;
                                                        imo.O0000o = str247;
                                                        imo.O00000o = true;
                                                        if (!z) {
                                                        }
                                                        long j18222222222222 = j;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream != null) {
                                                        }
                                                        str20 = XMediaplayerJNI.O0000o0;
                                                        sb2 = new StringBuilder(str4);
                                                        str7 = str7;
                                                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                        imc.O000000o(str20, (Object) sb2.toString());
                                                        j2 = j2022222222222;
                                                        f20 = f20;
                                                        if (imo != null) {
                                                        }
                                                        CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                        cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222;
                                                        str245 = str6;
                                                        str246 = str5;
                                                        str244 = str4;
                                                        z33 = z;
                                                        i12 = i;
                                                        uuid = str7;
                                                        str242 = str2;
                                                        str239 = obj2;
                                                        str241 = obj;
                                                        j14 = j2;
                                                        ily = this;
                                                        str243 = str8;
                                                        str240 = str3;
                                                        z34 = true;
                                                    } catch (UnknownHostException e75) {
                                                        str37 = str118;
                                                        unknownHostException8 = e75;
                                                        z8 = z20;
                                                        str179 = str169;
                                                        z15 = z8;
                                                        str38 = str;
                                                        str36 = str107;
                                                        httpURLConnection38 = httpURLConnection35;
                                                        z26 = z15;
                                                        str222 = str179;
                                                        str34 = str242;
                                                        z25 = z26;
                                                        str221 = str222;
                                                        cdnConfigModel8 = cdnConfigModel17;
                                                        f20 = z25;
                                                        str35 = str221;
                                                        if (imo.O0000Oo <= 0.0f) {
                                                        }
                                                        imo.O0000O0o = "dns_fail";
                                                        imo.O00000oo = imq.O000000o(unknownHostException);
                                                        imo.O00000oO = "0.0";
                                                        imo.O0000o0O = str21;
                                                        imo.O0000o0o = str21;
                                                        imo.O0000o = str247;
                                                        if (!z) {
                                                        }
                                                        long j19222222222222 = j;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream != null) {
                                                        }
                                                        str20 = XMediaplayerJNI.O0000o0;
                                                        sb2 = new StringBuilder(str4);
                                                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                        imc.O000000o(str20, (Object) sb2.toString());
                                                        j2 = j2022222222222;
                                                        f20 = f20;
                                                        if (imo != null) {
                                                        }
                                                        CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                        cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222;
                                                        str245 = str6;
                                                        str246 = str5;
                                                        str244 = str4;
                                                        z33 = z;
                                                        i12 = i;
                                                        uuid = str7;
                                                        str242 = str2;
                                                        str239 = obj2;
                                                        str241 = obj;
                                                        j14 = j2;
                                                        ily = this;
                                                        str243 = str8;
                                                        str240 = str3;
                                                        z34 = true;
                                                    } catch (IllegalArgumentException e76) {
                                                        str51 = str118;
                                                        illegalArgumentException8 = e76;
                                                        z8 = z20;
                                                        str180 = str169;
                                                        httpURLConnection39 = httpURLConnection35;
                                                        z16 = z8;
                                                        str247 = str247;
                                                        str21 = str;
                                                        str50 = str107;
                                                        httpURLConnection40 = httpURLConnection39;
                                                        z28 = z16;
                                                        str225 = str180;
                                                        str48 = str242;
                                                        obj2 = obj2;
                                                        z27 = z28;
                                                        str224 = str225;
                                                        cdnConfigModel10 = cdnConfigModel17;
                                                        f20 = z27;
                                                        str238 = str224;
                                                        if (imo.O0000Oo <= 0.0f) {
                                                        }
                                                        imo.O0000O0o = "dns_fail";
                                                        imo.O00000oo = imq.O000000o(illegalArgumentException);
                                                        imo.O00000oO = "0.0";
                                                        imo.O0000o0O = str21;
                                                        imo.O0000o0o = str21;
                                                        imo.O0000o = str247;
                                                        if (!z) {
                                                        }
                                                        long j20222222222222 = j;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream != null) {
                                                        }
                                                        str20 = XMediaplayerJNI.O0000o0;
                                                        sb2 = new StringBuilder(str4);
                                                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                        imc.O000000o(str20, (Object) sb2.toString());
                                                        j2 = j20222222222222;
                                                        f20 = f20;
                                                        if (imo != null) {
                                                        }
                                                        CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                        cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222;
                                                        str245 = str6;
                                                        str246 = str5;
                                                        str244 = str4;
                                                        z33 = z;
                                                        i12 = i;
                                                        uuid = str7;
                                                        str242 = str2;
                                                        str239 = obj2;
                                                        str241 = obj;
                                                        j14 = j2;
                                                        ily = this;
                                                        str243 = str8;
                                                        str240 = str3;
                                                        z34 = true;
                                                    } catch (FileNotFoundException e77) {
                                                        str62 = str118;
                                                        fileNotFoundException8 = e77;
                                                        z8 = z20;
                                                        str181 = str169;
                                                        httpURLConnection41 = httpURLConnection35;
                                                        obj28 = obj4;
                                                        z17 = z8;
                                                        str8 = str;
                                                        str61 = str107;
                                                        httpURLConnection11 = httpURLConnection41;
                                                        obj32 = obj28;
                                                        z30 = z17;
                                                        str229 = str181;
                                                        str59 = str242;
                                                        str161 = obj32;
                                                        z29 = z30;
                                                        str228 = str229;
                                                        cdnConfigModel2 = cdnConfigModel17;
                                                        obj = str161;
                                                        f20 = z29;
                                                        obj34 = str228;
                                                        if (imo.O0000Oo <= 0.0f) {
                                                        }
                                                        imo.O0000O0o = "system_exception";
                                                        imo.O00000oo = imq.O000000o(fileNotFoundException);
                                                        imo.O00000oO = "0.0";
                                                        imo.O0000o0O = str8;
                                                        imo.O0000o0o = str8;
                                                        imo.O0000o = str247;
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                                        if (!z) {
                                                        }
                                                        long j21222222222222 = j;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream != null) {
                                                        }
                                                        str9 = XMediaplayerJNI.O0000o0;
                                                        sb = new StringBuilder(str4);
                                                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                        imc.O000000o(str9, (Object) sb.toString());
                                                        f20 = f20;
                                                        if (imo != null) {
                                                        }
                                                        CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                        cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222;
                                                        str245 = str6;
                                                        str246 = str5;
                                                        str244 = str4;
                                                        z33 = z;
                                                        i12 = i;
                                                        uuid = str7;
                                                        str242 = str2;
                                                        str239 = obj2;
                                                        str241 = obj;
                                                        j14 = j2;
                                                        ily = this;
                                                        str243 = str8;
                                                        str240 = str3;
                                                        z34 = true;
                                                    } catch (IOException e78) {
                                                        str73 = str118;
                                                        iOException8 = e78;
                                                        z8 = z20;
                                                        str182 = str169;
                                                        i6 = i13;
                                                        obj4 = obj4;
                                                        z18 = z8;
                                                        str72 = str107;
                                                        httpURLConnection31 = httpURLConnection35;
                                                        z8 = z18;
                                                        str139 = str182;
                                                        str70 = str242;
                                                        f20 = z8;
                                                        str3 = str139;
                                                        if (!z) {
                                                        }
                                                        cdnConfigModel2 = cdnConfigModel17;
                                                        String str254222222222222 = str;
                                                        j = j;
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                                        if (!z) {
                                                        }
                                                        long j22222222222222 = j;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream != null) {
                                                        }
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                        i13 = i2;
                                                        if (imo != null) {
                                                        }
                                                        CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                        cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222;
                                                        str245 = str6;
                                                        str246 = str5;
                                                        str244 = str4;
                                                        z33 = z;
                                                        i12 = i;
                                                        uuid = str7;
                                                        str242 = str2;
                                                        str239 = obj2;
                                                        str241 = obj;
                                                        j14 = j2;
                                                        ily = this;
                                                        str243 = str8;
                                                        str240 = str3;
                                                        z34 = true;
                                                    } catch (Throwable th20) {
                                                        str171 = str118;
                                                        th = th20;
                                                        z10 = z20;
                                                        cdnConfigModel15 = cdnConfigModel17;
                                                        str72 = str107;
                                                        str2 = str242;
                                                        z2 = z34;
                                                        str3 = str169;
                                                        httpURLConnection = httpURLConnection35;
                                                        if (!z) {
                                                        }
                                                        Throwable th622222222222 = th;
                                                        httpURLConnection2 = httpURLConnection;
                                                        if (httpURLConnection2 != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream != null) {
                                                        }
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                        throw th622222222222;
                                                    }
                                                } catch (MalformedURLException e79) {
                                                    httpURLConnection35 = O000000o2;
                                                    inputStream = inputStream16;
                                                    str247 = str116;
                                                    str169 = str240;
                                                    String str292 = str241;
                                                    str177 = str118;
                                                    malformedURLException8 = e79;
                                                    obj4 = str292;
                                                    str176 = str169;
                                                    httpURLConnection35 = httpURLConnection35;
                                                    obj4 = obj4;
                                                    z13 = z8;
                                                    str13 = str;
                                                    str12 = str107;
                                                    httpURLConnection36 = httpURLConnection35;
                                                    z22 = z13;
                                                    str5 = str177;
                                                    str10 = str242;
                                                    z21 = z22;
                                                    str216 = str176;
                                                    cdnConfigModel4 = cdnConfigModel17;
                                                    f20 = z21;
                                                    obj33 = str216;
                                                    if (imo.O0000Oo <= 0.0f) {
                                                    }
                                                    imo.O0000O0o = "cdn_connect_fail ";
                                                    imo.O00000oo = imq.O000000o(malformedURLException);
                                                    imo.O00000oO = "0.0";
                                                    imo.O0000o0O = str8;
                                                    imo.O0000o0o = str8;
                                                    imo.O0000o = str247;
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                    if (!z) {
                                                    }
                                                    long j232222222222 = j;
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                    }
                                                    str9 = XMediaplayerJNI.O0000o0;
                                                    sb = new StringBuilder(str4);
                                                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                    imc.O000000o(str9, (Object) sb.toString());
                                                    f20 = f20;
                                                    if (imo != null) {
                                                    }
                                                    CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                    cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222;
                                                    str245 = str6;
                                                    str246 = str5;
                                                    str244 = str4;
                                                    z33 = z;
                                                    i12 = i;
                                                    uuid = str7;
                                                    str242 = str2;
                                                    str239 = obj2;
                                                    str241 = obj;
                                                    j14 = j2;
                                                    ily = this;
                                                    str243 = str8;
                                                    str240 = str3;
                                                    z34 = true;
                                                } catch (SocketTimeoutException e80) {
                                                    httpURLConnection35 = O000000o2;
                                                    inputStream = inputStream16;
                                                    str247 = str116;
                                                    str169 = str240;
                                                    String str293 = str241;
                                                    str25 = str118;
                                                    socketTimeoutException8 = e80;
                                                    obj4 = str293;
                                                    str178 = str169;
                                                    z14 = z8;
                                                    str26 = str;
                                                    str24 = str107;
                                                    httpURLConnection37 = httpURLConnection35;
                                                    z24 = z14;
                                                    str219 = str178;
                                                    str23 = str242;
                                                    z23 = z24;
                                                    str218 = str219;
                                                    cdnConfigModel6 = cdnConfigModel17;
                                                    f20 = z23;
                                                    obj5 = str218;
                                                    imo.O00000oO = "0.0";
                                                    if (imo.O0000Oo <= 0.0f) {
                                                    }
                                                    if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                    }
                                                    imo.O0000o0O = str21;
                                                    imo.O0000o0o = str21;
                                                    imo.O0000o = str247;
                                                    imo.O00000o = true;
                                                    if (!z) {
                                                    }
                                                    long j182222222222222 = j;
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                    }
                                                    str20 = XMediaplayerJNI.O0000o0;
                                                    sb2 = new StringBuilder(str4);
                                                    str7 = str7;
                                                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                    imc.O000000o(str20, (Object) sb2.toString());
                                                    j2 = j20222222222222;
                                                    f20 = f20;
                                                    if (imo != null) {
                                                    }
                                                    CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                    cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222;
                                                    str245 = str6;
                                                    str246 = str5;
                                                    str244 = str4;
                                                    z33 = z;
                                                    i12 = i;
                                                    uuid = str7;
                                                    str242 = str2;
                                                    str239 = obj2;
                                                    str241 = obj;
                                                    j14 = j2;
                                                    ily = this;
                                                    str243 = str8;
                                                    str240 = str3;
                                                    z34 = true;
                                                } catch (UnknownHostException e81) {
                                                    httpURLConnection35 = O000000o2;
                                                    inputStream = inputStream16;
                                                    str247 = str116;
                                                    str169 = str240;
                                                    String str294 = str241;
                                                    str37 = str118;
                                                    unknownHostException8 = e81;
                                                    obj4 = str294;
                                                    str179 = str169;
                                                    z15 = z8;
                                                    str38 = str;
                                                    str36 = str107;
                                                    httpURLConnection38 = httpURLConnection35;
                                                    z26 = z15;
                                                    str222 = str179;
                                                    str34 = str242;
                                                    z25 = z26;
                                                    str221 = str222;
                                                    cdnConfigModel8 = cdnConfigModel17;
                                                    f20 = z25;
                                                    str35 = str221;
                                                    if (imo.O0000Oo <= 0.0f) {
                                                    }
                                                    imo.O0000O0o = "dns_fail";
                                                    imo.O00000oo = imq.O000000o(unknownHostException);
                                                    imo.O00000oO = "0.0";
                                                    imo.O0000o0O = str21;
                                                    imo.O0000o0o = str21;
                                                    imo.O0000o = str247;
                                                    if (!z) {
                                                    }
                                                    long j192222222222222 = j;
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                    }
                                                    str20 = XMediaplayerJNI.O0000o0;
                                                    sb2 = new StringBuilder(str4);
                                                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                    imc.O000000o(str20, (Object) sb2.toString());
                                                    j2 = j20222222222222;
                                                    f20 = f20;
                                                    if (imo != null) {
                                                    }
                                                    CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                    cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222;
                                                    str245 = str6;
                                                    str246 = str5;
                                                    str244 = str4;
                                                    z33 = z;
                                                    i12 = i;
                                                    uuid = str7;
                                                    str242 = str2;
                                                    str239 = obj2;
                                                    str241 = obj;
                                                    j14 = j2;
                                                    ily = this;
                                                    str243 = str8;
                                                    str240 = str3;
                                                    z34 = true;
                                                } catch (IllegalArgumentException e82) {
                                                    httpURLConnection35 = O000000o2;
                                                    inputStream = inputStream16;
                                                    str247 = str116;
                                                    str169 = str240;
                                                    String str295 = str241;
                                                    str51 = str118;
                                                    illegalArgumentException8 = e82;
                                                    obj4 = str295;
                                                    str180 = str169;
                                                    httpURLConnection39 = httpURLConnection35;
                                                    z16 = z8;
                                                    str247 = str247;
                                                    str21 = str;
                                                    str50 = str107;
                                                    httpURLConnection40 = httpURLConnection39;
                                                    z28 = z16;
                                                    str225 = str180;
                                                    str48 = str242;
                                                    obj2 = obj2;
                                                    z27 = z28;
                                                    str224 = str225;
                                                    cdnConfigModel10 = cdnConfigModel17;
                                                    f20 = z27;
                                                    str238 = str224;
                                                    if (imo.O0000Oo <= 0.0f) {
                                                    }
                                                    imo.O0000O0o = "dns_fail";
                                                    imo.O00000oo = imq.O000000o(illegalArgumentException);
                                                    imo.O00000oO = "0.0";
                                                    imo.O0000o0O = str21;
                                                    imo.O0000o0o = str21;
                                                    imo.O0000o = str247;
                                                    if (!z) {
                                                    }
                                                    long j202222222222222 = j;
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                    }
                                                    str20 = XMediaplayerJNI.O0000o0;
                                                    sb2 = new StringBuilder(str4);
                                                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                    imc.O000000o(str20, (Object) sb2.toString());
                                                    j2 = j202222222222222;
                                                    f20 = f20;
                                                    if (imo != null) {
                                                    }
                                                    CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                    cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                                    str245 = str6;
                                                    str246 = str5;
                                                    str244 = str4;
                                                    z33 = z;
                                                    i12 = i;
                                                    uuid = str7;
                                                    str242 = str2;
                                                    str239 = obj2;
                                                    str241 = obj;
                                                    j14 = j2;
                                                    ily = this;
                                                    str243 = str8;
                                                    str240 = str3;
                                                    z34 = true;
                                                } catch (FileNotFoundException e83) {
                                                    httpURLConnection35 = O000000o2;
                                                    inputStream = inputStream16;
                                                    str247 = str116;
                                                    str169 = str240;
                                                    String str296 = str241;
                                                    str62 = str118;
                                                    fileNotFoundException8 = e83;
                                                    obj4 = str296;
                                                    str181 = str169;
                                                    httpURLConnection41 = httpURLConnection35;
                                                    obj28 = obj4;
                                                    z17 = z8;
                                                    str8 = str;
                                                    str61 = str107;
                                                    httpURLConnection11 = httpURLConnection41;
                                                    obj32 = obj28;
                                                    z30 = z17;
                                                    str229 = str181;
                                                    str59 = str242;
                                                    str161 = obj32;
                                                    z29 = z30;
                                                    str228 = str229;
                                                    cdnConfigModel2 = cdnConfigModel17;
                                                    obj = str161;
                                                    f20 = z29;
                                                    obj34 = str228;
                                                    if (imo.O0000Oo <= 0.0f) {
                                                    }
                                                    imo.O0000O0o = "system_exception";
                                                    imo.O00000oo = imq.O000000o(fileNotFoundException);
                                                    imo.O00000oO = "0.0";
                                                    imo.O0000o0O = str8;
                                                    imo.O0000o0o = str8;
                                                    imo.O0000o = str247;
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                                    if (!z) {
                                                    }
                                                    long j212222222222222 = j;
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                    }
                                                    str9 = XMediaplayerJNI.O0000o0;
                                                    sb = new StringBuilder(str4);
                                                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                    imc.O000000o(str9, (Object) sb.toString());
                                                    f20 = f20;
                                                    if (imo != null) {
                                                    }
                                                    CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                    cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                                    str245 = str6;
                                                    str246 = str5;
                                                    str244 = str4;
                                                    z33 = z;
                                                    i12 = i;
                                                    uuid = str7;
                                                    str242 = str2;
                                                    str239 = obj2;
                                                    str241 = obj;
                                                    j14 = j2;
                                                    ily = this;
                                                    str243 = str8;
                                                    str240 = str3;
                                                    z34 = true;
                                                } catch (IOException e84) {
                                                    httpURLConnection35 = O000000o2;
                                                    inputStream = inputStream16;
                                                    str247 = str116;
                                                    str169 = str240;
                                                    String str297 = str241;
                                                    str73 = str118;
                                                    iOException8 = e84;
                                                    obj4 = str297;
                                                    str182 = str169;
                                                    i6 = i13;
                                                    obj4 = obj4;
                                                    z18 = z8;
                                                    str72 = str107;
                                                    httpURLConnection31 = httpURLConnection35;
                                                    z8 = z18;
                                                    str139 = str182;
                                                    str70 = str242;
                                                    f20 = z8;
                                                    str3 = str139;
                                                    if (!z) {
                                                    }
                                                    cdnConfigModel2 = cdnConfigModel17;
                                                    String str2542222222222222 = str;
                                                    j = j;
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                                    if (!z) {
                                                    }
                                                    long j222222222222222 = j;
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                    }
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                    i13 = i2;
                                                    if (imo != null) {
                                                    }
                                                    CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                    cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                                    str245 = str6;
                                                    str246 = str5;
                                                    str244 = str4;
                                                    z33 = z;
                                                    i12 = i;
                                                    uuid = str7;
                                                    str242 = str2;
                                                    str239 = obj2;
                                                    str241 = obj;
                                                    j14 = j2;
                                                    ily = this;
                                                    str243 = str8;
                                                    str240 = str3;
                                                    z34 = true;
                                                } catch (Throwable th21) {
                                                    th = th21;
                                                    httpURLConnection23 = O000000o2;
                                                    inputStream8 = inputStream16;
                                                    str247 = str116;
                                                    str173 = str240;
                                                    String str298 = str241;
                                                    str87 = str118;
                                                    str170 = str298;
                                                    cdnConfigModel16 = cdnConfigModel17;
                                                    z11 = z8;
                                                    str72 = str107;
                                                    th = th;
                                                    obj4 = str170;
                                                    obj2 = obj2;
                                                    str2 = str242;
                                                    z2 = z34;
                                                    str3 = str169;
                                                    httpURLConnection = httpURLConnection35;
                                                    if (!z) {
                                                    }
                                                    Throwable th6222222222222 = th;
                                                    httpURLConnection2 = httpURLConnection;
                                                    if (httpURLConnection2 != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                    }
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                    throw th6222222222222;
                                                }
                                            } catch (MalformedURLException e85) {
                                                HttpURLConnection httpURLConnection46 = O000000o2;
                                                inputStream3 = inputStream16;
                                                str247 = str116;
                                                String str299 = str240;
                                                String str300 = str241;
                                                str87 = str118;
                                                malformedURLException5 = e85;
                                                obj13 = str300;
                                                cdnConfigModel4 = cdnConfigModel17;
                                                obj14 = str299;
                                                str127 = str;
                                                str72 = str107;
                                                httpURLConnection26 = httpURLConnection46;
                                                byteArrayOutputStream11 = null;
                                                str10 = str242;
                                                obj4 = obj13;
                                                f20 = z8;
                                                obj33 = obj14;
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                imo.O0000O0o = "cdn_connect_fail ";
                                                imo.O00000oo = imq.O000000o(malformedURLException);
                                                imo.O00000oO = "0.0";
                                                imo.O0000o0O = str8;
                                                imo.O0000o0o = str8;
                                                imo.O0000o = str247;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                if (!z) {
                                                }
                                                long j2322222222222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str9 = XMediaplayerJNI.O0000o0;
                                                sb = new StringBuilder(str4);
                                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str9, (Object) sb.toString());
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (SocketTimeoutException e86) {
                                                HttpURLConnection httpURLConnection47 = O000000o2;
                                                inputStream4 = inputStream16;
                                                str247 = str116;
                                                String str301 = str240;
                                                String str302 = str241;
                                                str87 = str118;
                                                socketTimeoutException5 = e86;
                                                obj19 = str302;
                                                cdnConfigModel6 = cdnConfigModel17;
                                                obj20 = str301;
                                                str128 = str;
                                                str72 = str107;
                                                httpURLConnection27 = httpURLConnection47;
                                                byteArrayOutputStream12 = null;
                                                str23 = str242;
                                                obj4 = obj19;
                                                obj2 = obj2;
                                                str7 = str7;
                                                f20 = z8;
                                                obj5 = obj20;
                                                imo.O00000oO = "0.0";
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                }
                                                imo.O0000o0O = str21;
                                                imo.O0000o0o = str21;
                                                imo.O0000o = str247;
                                                imo.O00000o = true;
                                                if (!z) {
                                                }
                                                long j1822222222222222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str20 = XMediaplayerJNI.O0000o0;
                                                sb2 = new StringBuilder(str4);
                                                str7 = str7;
                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str20, (Object) sb2.toString());
                                                j2 = j202222222222222;
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (UnknownHostException e87) {
                                                HttpURLConnection httpURLConnection48 = O000000o2;
                                                inputStream5 = inputStream16;
                                                str247 = str116;
                                                String str303 = str240;
                                                String str304 = str241;
                                                str87 = str118;
                                                unknownHostException5 = e87;
                                                str129 = str304;
                                                cdnConfigModel8 = cdnConfigModel17;
                                                str35 = str303;
                                                str130 = str;
                                                str72 = str107;
                                                httpURLConnection28 = httpURLConnection48;
                                                byteArrayOutputStream13 = null;
                                                str34 = str242;
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                imo.O0000O0o = "dns_fail";
                                                imo.O00000oo = imq.O000000o(unknownHostException);
                                                imo.O00000oO = "0.0";
                                                imo.O0000o0O = str21;
                                                imo.O0000o0o = str21;
                                                imo.O0000o = str247;
                                                if (!z) {
                                                }
                                                long j1922222222222222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str20 = XMediaplayerJNI.O0000o0;
                                                sb2 = new StringBuilder(str4);
                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str20, (Object) sb2.toString());
                                                j2 = j202222222222222;
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (IllegalArgumentException e88) {
                                                HttpURLConnection httpURLConnection49 = O000000o2;
                                                inputStream6 = inputStream16;
                                                str247 = str116;
                                                String str305 = str240;
                                                String str306 = str241;
                                                str87 = str118;
                                                illegalArgumentException5 = e88;
                                                str132 = str306;
                                                cdnConfigModel10 = cdnConfigModel17;
                                                str131 = str305;
                                                str134 = str;
                                                str72 = str107;
                                                httpURLConnection29 = httpURLConnection49;
                                                byteArrayOutputStream14 = null;
                                                str48 = str242;
                                                str238 = str131;
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                imo.O0000O0o = "dns_fail";
                                                imo.O00000oo = imq.O000000o(illegalArgumentException);
                                                imo.O00000oO = "0.0";
                                                imo.O0000o0O = str21;
                                                imo.O0000o0o = str21;
                                                imo.O0000o = str247;
                                                if (!z) {
                                                }
                                                long j2022222222222222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str20 = XMediaplayerJNI.O0000o0;
                                                sb2 = new StringBuilder(str4);
                                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str20, (Object) sb2.toString());
                                                j2 = j2022222222222222;
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (FileNotFoundException e89) {
                                                HttpURLConnection httpURLConnection50 = O000000o2;
                                                inputStream7 = inputStream16;
                                                str247 = str116;
                                                String str307 = str240;
                                                String str308 = str241;
                                                str87 = str118;
                                                fileNotFoundException5 = e89;
                                                str136 = str308;
                                                cdnConfigModel2 = cdnConfigModel17;
                                                obj24 = str307;
                                                str137 = str;
                                                str72 = str107;
                                                httpURLConnection30 = httpURLConnection50;
                                                byteArrayOutputStream15 = null;
                                                str59 = str242;
                                                obj = str136;
                                                f20 = z8;
                                                obj34 = obj24;
                                                if (imo.O0000Oo <= 0.0f) {
                                                }
                                                imo.O0000O0o = "system_exception";
                                                imo.O00000oo = imq.O000000o(fileNotFoundException);
                                                imo.O00000oO = "0.0";
                                                imo.O0000o0O = str8;
                                                imo.O0000o0o = str8;
                                                imo.O0000o = str247;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                                if (!z) {
                                                }
                                                long j2122222222222222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                str9 = XMediaplayerJNI.O0000o0;
                                                sb = new StringBuilder(str4);
                                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                                imc.O000000o(str9, (Object) sb.toString());
                                                f20 = f20;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (IOException e90) {
                                                HttpURLConnection httpURLConnection51 = O000000o2;
                                                inputStream = inputStream16;
                                                str247 = str116;
                                                String str309 = str240;
                                                String str310 = str241;
                                                str73 = str118;
                                                iOException = e90;
                                                obj4 = str310;
                                                str139 = str309;
                                                i2 = i13;
                                                str72 = str107;
                                                httpURLConnection31 = httpURLConnection51;
                                                byteArrayOutputStream = null;
                                                str70 = str242;
                                                f20 = z8;
                                                str3 = str139;
                                                if (!z) {
                                                }
                                                cdnConfigModel2 = cdnConfigModel17;
                                                String str25422222222222222 = str;
                                                j = j;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                                if (!z) {
                                                }
                                                long j2222222222222222 = j;
                                                if (httpURLConnection != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                i13 = i2;
                                                if (imo != null) {
                                                }
                                                CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                                cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                                str245 = str6;
                                                str246 = str5;
                                                str244 = str4;
                                                z33 = z;
                                                i12 = i;
                                                uuid = str7;
                                                str242 = str2;
                                                str239 = obj2;
                                                str241 = obj;
                                                j14 = j2;
                                                ily = this;
                                                str243 = str8;
                                                str240 = str3;
                                                z34 = true;
                                            } catch (Throwable th22) {
                                                th = th22;
                                                httpURLConnection23 = O000000o2;
                                                inputStream8 = inputStream16;
                                                str247 = str116;
                                                str173 = str240;
                                                String str311 = str241;
                                                str87 = str118;
                                                str170 = str311;
                                                cdnConfigModel16 = cdnConfigModel17;
                                                z11 = z8;
                                                str72 = str107;
                                                byteArrayOutputStream = null;
                                                th = th;
                                                obj4 = str170;
                                                obj2 = obj2;
                                                str2 = str242;
                                                z2 = z34;
                                                str3 = str169;
                                                httpURLConnection = httpURLConnection35;
                                                if (!z) {
                                                }
                                                Throwable th62222222222222 = th;
                                                httpURLConnection2 = httpURLConnection;
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                                throw th62222222222222;
                                            }
                                        } catch (MalformedURLException e91) {
                                            String str312 = str240;
                                            String str313 = str241;
                                            httpURLConnection23 = O000000o2;
                                            str87 = str118;
                                            str247 = str116;
                                            malformedURLException5 = e91;
                                            obj15 = str313;
                                            cdnConfigModel4 = cdnConfigModel17;
                                            obj16 = str312;
                                            str127 = str;
                                            str72 = str107;
                                            httpURLConnection26 = httpURLConnection23;
                                            byteArrayOutputStream11 = null;
                                            inputStream3 = null;
                                            obj13 = obj15;
                                            z8 = z8;
                                            obj14 = obj16;
                                            str10 = str242;
                                            obj4 = obj13;
                                            f20 = z8;
                                            obj33 = obj14;
                                            if (imo.O0000Oo <= 0.0f) {
                                            }
                                            imo.O0000O0o = "cdn_connect_fail ";
                                            imo.O00000oo = imq.O000000o(malformedURLException);
                                            imo.O00000oO = "0.0";
                                            imo.O0000o0O = str8;
                                            imo.O0000o0o = str8;
                                            imo.O0000o = str247;
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                            if (!z) {
                                            }
                                            long j23222222222222 = j;
                                            if (httpURLConnection != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            str9 = XMediaplayerJNI.O0000o0;
                                            sb = new StringBuilder(str4);
                                            sb.append(System.currentTimeMillis() - currentTimeMillis);
                                            imc.O000000o(str9, (Object) sb.toString());
                                            f20 = f20;
                                            if (imo != null) {
                                            }
                                            CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                            cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                            str245 = str6;
                                            str246 = str5;
                                            str244 = str4;
                                            z33 = z;
                                            i12 = i;
                                            uuid = str7;
                                            str242 = str2;
                                            str239 = obj2;
                                            str241 = obj;
                                            j14 = j2;
                                            ily = this;
                                            str243 = str8;
                                            str240 = str3;
                                            z34 = true;
                                        } catch (SocketTimeoutException e92) {
                                            String str314 = str240;
                                            String str315 = str241;
                                            httpURLConnection23 = O000000o2;
                                            str87 = str118;
                                            str247 = str116;
                                            socketTimeoutException5 = e92;
                                            obj21 = str315;
                                            cdnConfigModel6 = cdnConfigModel17;
                                            obj22 = str314;
                                            str128 = str;
                                            str72 = str107;
                                            httpURLConnection27 = httpURLConnection23;
                                            byteArrayOutputStream12 = null;
                                            inputStream4 = null;
                                            obj19 = obj21;
                                            obj2 = obj2;
                                            str7 = str7;
                                            z8 = z8;
                                            obj20 = obj22;
                                            str23 = str242;
                                            obj4 = obj19;
                                            obj2 = obj2;
                                            str7 = str7;
                                            f20 = z8;
                                            obj5 = obj20;
                                            imo.O00000oO = "0.0";
                                            if (imo.O0000Oo <= 0.0f) {
                                            }
                                            if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                            }
                                            imo.O0000o0O = str21;
                                            imo.O0000o0o = str21;
                                            imo.O0000o = str247;
                                            imo.O00000o = true;
                                            if (!z) {
                                            }
                                            long j18222222222222222 = j;
                                            if (httpURLConnection != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            str20 = XMediaplayerJNI.O0000o0;
                                            sb2 = new StringBuilder(str4);
                                            str7 = str7;
                                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                            imc.O000000o(str20, (Object) sb2.toString());
                                            j2 = j2022222222222222;
                                            f20 = f20;
                                            if (imo != null) {
                                            }
                                            CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                            cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                            str245 = str6;
                                            str246 = str5;
                                            str244 = str4;
                                            z33 = z;
                                            i12 = i;
                                            uuid = str7;
                                            str242 = str2;
                                            str239 = obj2;
                                            str241 = obj;
                                            j14 = j2;
                                            ily = this;
                                            str243 = str8;
                                            str240 = str3;
                                            z34 = true;
                                        } catch (UnknownHostException e93) {
                                            String str316 = str240;
                                            String str317 = str241;
                                            httpURLConnection23 = O000000o2;
                                            str87 = str118;
                                            str247 = str116;
                                            unknownHostException5 = e93;
                                            str129 = str317;
                                            cdnConfigModel8 = cdnConfigModel17;
                                            str35 = str316;
                                            str130 = str;
                                            str72 = str107;
                                            httpURLConnection28 = httpURLConnection23;
                                            byteArrayOutputStream13 = null;
                                            inputStream5 = null;
                                            str34 = str242;
                                            if (imo.O0000Oo <= 0.0f) {
                                            }
                                            imo.O0000O0o = "dns_fail";
                                            imo.O00000oo = imq.O000000o(unknownHostException);
                                            imo.O00000oO = "0.0";
                                            imo.O0000o0O = str21;
                                            imo.O0000o0o = str21;
                                            imo.O0000o = str247;
                                            if (!z) {
                                            }
                                            long j19222222222222222 = j;
                                            if (httpURLConnection != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            str20 = XMediaplayerJNI.O0000o0;
                                            sb2 = new StringBuilder(str4);
                                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                            imc.O000000o(str20, (Object) sb2.toString());
                                            j2 = j2022222222222222;
                                            f20 = f20;
                                            if (imo != null) {
                                            }
                                            CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                            cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                            str245 = str6;
                                            str246 = str5;
                                            str244 = str4;
                                            z33 = z;
                                            i12 = i;
                                            uuid = str7;
                                            str242 = str2;
                                            str239 = obj2;
                                            str241 = obj;
                                            j14 = j2;
                                            ily = this;
                                            str243 = str8;
                                            str240 = str3;
                                            z34 = true;
                                        } catch (IllegalArgumentException e94) {
                                            String str318 = str240;
                                            String str319 = str241;
                                            httpURLConnection23 = O000000o2;
                                            str87 = str118;
                                            str247 = str116;
                                            illegalArgumentException5 = e94;
                                            str132 = str319;
                                            cdnConfigModel10 = cdnConfigModel17;
                                            str133 = str318;
                                            str134 = str;
                                            str72 = str107;
                                            httpURLConnection29 = httpURLConnection23;
                                            byteArrayOutputStream14 = null;
                                            inputStream6 = null;
                                            str131 = str133;
                                            str48 = str242;
                                            str238 = str131;
                                            if (imo.O0000Oo <= 0.0f) {
                                            }
                                            imo.O0000O0o = "dns_fail";
                                            imo.O00000oo = imq.O000000o(illegalArgumentException);
                                            imo.O00000oO = "0.0";
                                            imo.O0000o0O = str21;
                                            imo.O0000o0o = str21;
                                            imo.O0000o = str247;
                                            if (!z) {
                                            }
                                            long j20222222222222222 = j;
                                            if (httpURLConnection != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            str20 = XMediaplayerJNI.O0000o0;
                                            sb2 = new StringBuilder(str4);
                                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                            imc.O000000o(str20, (Object) sb2.toString());
                                            j2 = j20222222222222222;
                                            f20 = f20;
                                            if (imo != null) {
                                            }
                                            CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                            cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                            str245 = str6;
                                            str246 = str5;
                                            str244 = str4;
                                            z33 = z;
                                            i12 = i;
                                            uuid = str7;
                                            str242 = str2;
                                            str239 = obj2;
                                            str241 = obj;
                                            j14 = j2;
                                            ily = this;
                                            str243 = str8;
                                            str240 = str3;
                                            z34 = true;
                                        } catch (FileNotFoundException e95) {
                                            String str320 = str240;
                                            String str321 = str241;
                                            httpURLConnection23 = O000000o2;
                                            str87 = str118;
                                            str247 = str116;
                                            fileNotFoundException5 = e95;
                                            str136 = str321;
                                            cdnConfigModel2 = cdnConfigModel17;
                                            obj25 = str320;
                                            str137 = str;
                                            str72 = str107;
                                            httpURLConnection30 = httpURLConnection23;
                                            byteArrayOutputStream15 = null;
                                            inputStream7 = null;
                                            z8 = z8;
                                            obj24 = obj25;
                                            str59 = str242;
                                            obj = str136;
                                            f20 = z8;
                                            obj34 = obj24;
                                            if (imo.O0000Oo <= 0.0f) {
                                            }
                                            imo.O0000O0o = "system_exception";
                                            imo.O00000oo = imq.O000000o(fileNotFoundException);
                                            imo.O00000oO = "0.0";
                                            imo.O0000o0O = str8;
                                            imo.O0000o0o = str8;
                                            imo.O0000o = str247;
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                            if (!z) {
                                            }
                                            long j21222222222222222 = j;
                                            if (httpURLConnection != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            str9 = XMediaplayerJNI.O0000o0;
                                            sb = new StringBuilder(str4);
                                            sb.append(System.currentTimeMillis() - currentTimeMillis);
                                            imc.O000000o(str9, (Object) sb.toString());
                                            f20 = f20;
                                            if (imo != null) {
                                            }
                                            CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                            cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                            str245 = str6;
                                            str246 = str5;
                                            str244 = str4;
                                            z33 = z;
                                            i12 = i;
                                            uuid = str7;
                                            str242 = str2;
                                            str239 = obj2;
                                            str241 = obj;
                                            j14 = j2;
                                            ily = this;
                                            str243 = str8;
                                            str240 = str3;
                                            z34 = true;
                                        } catch (IOException e96) {
                                            String str322 = str240;
                                            String str323 = str241;
                                            httpURLConnection23 = O000000o2;
                                            str87 = str118;
                                            str247 = str116;
                                            iOException5 = e96;
                                            str138 = str323;
                                            str139 = str322;
                                            i7 = i13;
                                            str72 = str107;
                                            httpURLConnection31 = httpURLConnection23;
                                            byteArrayOutputStream = null;
                                            inputStream = null;
                                            obj4 = str138;
                                            obj2 = obj2;
                                            str7 = str7;
                                            z8 = z8;
                                            str70 = str242;
                                            f20 = z8;
                                            str3 = str139;
                                            if (!z) {
                                            }
                                            cdnConfigModel2 = cdnConfigModel17;
                                            String str254222222222222222 = str;
                                            j = j;
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                            if (!z) {
                                            }
                                            long j22222222222222222 = j;
                                            if (httpURLConnection != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                            i13 = i2;
                                            if (imo != null) {
                                            }
                                            CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                            cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                            str245 = str6;
                                            str246 = str5;
                                            str244 = str4;
                                            z33 = z;
                                            i12 = i;
                                            uuid = str7;
                                            str242 = str2;
                                            str239 = obj2;
                                            str241 = obj;
                                            j14 = j2;
                                            ily = this;
                                            str243 = str8;
                                            str240 = str3;
                                            z34 = true;
                                        } catch (Throwable th23) {
                                            th = th23;
                                            str173 = str240;
                                            String str324 = str241;
                                            httpURLConnection23 = O000000o2;
                                            str87 = str118;
                                            str247 = str116;
                                            str172 = str324;
                                            cdnConfigModel16 = cdnConfigModel17;
                                            z11 = z8;
                                            str72 = str107;
                                            byteArrayOutputStream = null;
                                            inputStream8 = null;
                                            str170 = str172;
                                            obj2 = obj2;
                                            th = th;
                                            obj4 = str170;
                                            obj2 = obj2;
                                            str2 = str242;
                                            z2 = z34;
                                            str3 = str169;
                                            httpURLConnection = httpURLConnection35;
                                            if (!z) {
                                            }
                                            Throwable th622222222222222 = th;
                                            httpURLConnection2 = httpURLConnection;
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                            throw th622222222222222;
                                        }
                                    }
                                } catch (MalformedURLException e97) {
                                    String str325 = str240;
                                    String str326 = str241;
                                    httpURLConnection23 = O000000o2;
                                    str87 = str118;
                                    str72 = str107;
                                    str247 = str116;
                                    malformedURLException5 = e97;
                                    obj17 = str326;
                                    obj18 = str325;
                                    cdnConfigModel4 = cdnConfigModel17;
                                    str127 = str;
                                    obj15 = obj17;
                                    str7 = str7;
                                    z8 = z8;
                                    obj16 = obj18;
                                    httpURLConnection26 = httpURLConnection23;
                                    byteArrayOutputStream11 = null;
                                    inputStream3 = null;
                                    obj13 = obj15;
                                    z8 = z8;
                                    obj14 = obj16;
                                    str10 = str242;
                                    obj4 = obj13;
                                    f20 = z8;
                                    obj33 = obj14;
                                    if (imo.O0000Oo <= 0.0f) {
                                    }
                                    imo.O0000O0o = "cdn_connect_fail ";
                                    imo.O00000oo = imq.O000000o(malformedURLException);
                                    imo.O00000oO = "0.0";
                                    imo.O0000o0O = str8;
                                    imo.O0000o0o = str8;
                                    imo.O0000o = str247;
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                    if (!z) {
                                    }
                                    long j232222222222222 = j;
                                    if (httpURLConnection != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    str9 = XMediaplayerJNI.O0000o0;
                                    sb = new StringBuilder(str4);
                                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                                    imc.O000000o(str9, (Object) sb.toString());
                                    f20 = f20;
                                    if (imo != null) {
                                    }
                                    CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                    cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                    str245 = str6;
                                    str246 = str5;
                                    str244 = str4;
                                    z33 = z;
                                    i12 = i;
                                    uuid = str7;
                                    str242 = str2;
                                    str239 = obj2;
                                    str241 = obj;
                                    j14 = j2;
                                    ily = this;
                                    str243 = str8;
                                    str240 = str3;
                                    z34 = true;
                                } catch (SocketTimeoutException e98) {
                                    String str327 = str240;
                                    String str328 = str241;
                                    httpURLConnection23 = O000000o2;
                                    str87 = str118;
                                    str72 = str107;
                                    str247 = str116;
                                    socketTimeoutException5 = e98;
                                    obj21 = str328;
                                    obj23 = str327;
                                    cdnConfigModel6 = cdnConfigModel17;
                                    str128 = str;
                                    obj2 = obj2;
                                    str7 = str7;
                                    z8 = z8;
                                    obj22 = obj23;
                                    httpURLConnection27 = httpURLConnection23;
                                    byteArrayOutputStream12 = null;
                                    inputStream4 = null;
                                    obj19 = obj21;
                                    obj2 = obj2;
                                    str7 = str7;
                                    z8 = z8;
                                    obj20 = obj22;
                                    str23 = str242;
                                    obj4 = obj19;
                                    obj2 = obj2;
                                    str7 = str7;
                                    f20 = z8;
                                    obj5 = obj20;
                                    imo.O00000oO = "0.0";
                                    if (imo.O0000Oo <= 0.0f) {
                                    }
                                    if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                    }
                                    imo.O0000o0O = str21;
                                    imo.O0000o0o = str21;
                                    imo.O0000o = str247;
                                    imo.O00000o = true;
                                    if (!z) {
                                    }
                                    long j182222222222222222 = j;
                                    if (httpURLConnection != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    str20 = XMediaplayerJNI.O0000o0;
                                    sb2 = new StringBuilder(str4);
                                    str7 = str7;
                                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                    imc.O000000o(str20, (Object) sb2.toString());
                                    j2 = j20222222222222222;
                                    f20 = f20;
                                    if (imo != null) {
                                    }
                                    CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                    cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                    str245 = str6;
                                    str246 = str5;
                                    str244 = str4;
                                    z33 = z;
                                    i12 = i;
                                    uuid = str7;
                                    str242 = str2;
                                    str239 = obj2;
                                    str241 = obj;
                                    j14 = j2;
                                    ily = this;
                                    str243 = str8;
                                    str240 = str3;
                                    z34 = true;
                                } catch (UnknownHostException e99) {
                                    String str329 = str240;
                                    String str330 = str241;
                                    httpURLConnection23 = O000000o2;
                                    str87 = str118;
                                    str72 = str107;
                                    str247 = str116;
                                    unknownHostException5 = e99;
                                    str129 = str330;
                                    str35 = str329;
                                    cdnConfigModel8 = cdnConfigModel17;
                                    str130 = str;
                                    httpURLConnection28 = httpURLConnection23;
                                    byteArrayOutputStream13 = null;
                                    inputStream5 = null;
                                    str34 = str242;
                                    if (imo.O0000Oo <= 0.0f) {
                                    }
                                    imo.O0000O0o = "dns_fail";
                                    imo.O00000oo = imq.O000000o(unknownHostException);
                                    imo.O00000oO = "0.0";
                                    imo.O0000o0O = str21;
                                    imo.O0000o0o = str21;
                                    imo.O0000o = str247;
                                    if (!z) {
                                    }
                                    long j192222222222222222 = j;
                                    if (httpURLConnection != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    str20 = XMediaplayerJNI.O0000o0;
                                    sb2 = new StringBuilder(str4);
                                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                    imc.O000000o(str20, (Object) sb2.toString());
                                    j2 = j20222222222222222;
                                    f20 = f20;
                                    if (imo != null) {
                                    }
                                    CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                    cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                    str245 = str6;
                                    str246 = str5;
                                    str244 = str4;
                                    z33 = z;
                                    i12 = i;
                                    uuid = str7;
                                    str242 = str2;
                                    str239 = obj2;
                                    str241 = obj;
                                    j14 = j2;
                                    ily = this;
                                    str243 = str8;
                                    str240 = str3;
                                    z34 = true;
                                } catch (IllegalArgumentException e100) {
                                    String str331 = str240;
                                    String str332 = str241;
                                    httpURLConnection23 = O000000o2;
                                    str87 = str118;
                                    str72 = str107;
                                    str247 = str116;
                                    illegalArgumentException5 = e100;
                                    str132 = str332;
                                    str135 = str331;
                                    cdnConfigModel10 = cdnConfigModel17;
                                    str134 = str;
                                    obj2 = obj2;
                                    str133 = str135;
                                    httpURLConnection29 = httpURLConnection23;
                                    byteArrayOutputStream14 = null;
                                    inputStream6 = null;
                                    str131 = str133;
                                    str48 = str242;
                                    str238 = str131;
                                    if (imo.O0000Oo <= 0.0f) {
                                    }
                                    imo.O0000O0o = "dns_fail";
                                    imo.O00000oo = imq.O000000o(illegalArgumentException);
                                    imo.O00000oO = "0.0";
                                    imo.O0000o0O = str21;
                                    imo.O0000o0o = str21;
                                    imo.O0000o = str247;
                                    if (!z) {
                                    }
                                    long j202222222222222222 = j;
                                    if (httpURLConnection != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    str20 = XMediaplayerJNI.O0000o0;
                                    sb2 = new StringBuilder(str4);
                                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                    imc.O000000o(str20, (Object) sb2.toString());
                                    j2 = j202222222222222222;
                                    f20 = f20;
                                    if (imo != null) {
                                    }
                                    CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                    cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                    str245 = str6;
                                    str246 = str5;
                                    str244 = str4;
                                    z33 = z;
                                    i12 = i;
                                    uuid = str7;
                                    str242 = str2;
                                    str239 = obj2;
                                    str241 = obj;
                                    j14 = j2;
                                    ily = this;
                                    str243 = str8;
                                    str240 = str3;
                                    z34 = true;
                                } catch (FileNotFoundException e101) {
                                    String str333 = str240;
                                    String str334 = str241;
                                    httpURLConnection23 = O000000o2;
                                    str87 = str118;
                                    str72 = str107;
                                    str247 = str116;
                                    fileNotFoundException5 = e101;
                                    str136 = str334;
                                    obj26 = str333;
                                    cdnConfigModel2 = cdnConfigModel17;
                                    str137 = str;
                                    str7 = str7;
                                    z8 = z8;
                                    obj25 = obj26;
                                    httpURLConnection30 = httpURLConnection23;
                                    byteArrayOutputStream15 = null;
                                    inputStream7 = null;
                                    z8 = z8;
                                    obj24 = obj25;
                                    str59 = str242;
                                    obj = str136;
                                    f20 = z8;
                                    obj34 = obj24;
                                    if (imo.O0000Oo <= 0.0f) {
                                    }
                                    imo.O0000O0o = "system_exception";
                                    imo.O00000oo = imq.O000000o(fileNotFoundException);
                                    imo.O00000oO = "0.0";
                                    imo.O0000o0O = str8;
                                    imo.O0000o0o = str8;
                                    imo.O0000o = str247;
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                    if (!z) {
                                    }
                                    long j212222222222222222 = j;
                                    if (httpURLConnection != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    str9 = XMediaplayerJNI.O0000o0;
                                    sb = new StringBuilder(str4);
                                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                                    imc.O000000o(str9, (Object) sb.toString());
                                    f20 = f20;
                                    if (imo != null) {
                                    }
                                    CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                    cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                    str245 = str6;
                                    str246 = str5;
                                    str244 = str4;
                                    z33 = z;
                                    i12 = i;
                                    uuid = str7;
                                    str242 = str2;
                                    str239 = obj2;
                                    str241 = obj;
                                    j14 = j2;
                                    ily = this;
                                    str243 = str8;
                                    str240 = str3;
                                    z34 = true;
                                } catch (IOException e102) {
                                    String str335 = str240;
                                    String str336 = str241;
                                    httpURLConnection23 = O000000o2;
                                    str87 = str118;
                                    str72 = str107;
                                    str247 = str116;
                                    iOException5 = e102;
                                    str140 = str336;
                                    str141 = str335;
                                    i7 = i13;
                                    str138 = str140;
                                    str7 = str7;
                                    z8 = z8;
                                    str139 = str141;
                                    httpURLConnection31 = httpURLConnection23;
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                    obj4 = str138;
                                    obj2 = obj2;
                                    str7 = str7;
                                    z8 = z8;
                                    str70 = str242;
                                    f20 = z8;
                                    str3 = str139;
                                    if (!z) {
                                    }
                                    cdnConfigModel2 = cdnConfigModel17;
                                    String str2542222222222222222 = str;
                                    j = j;
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                    if (!z) {
                                    }
                                    long j222222222222222222 = j;
                                    if (httpURLConnection != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                    i13 = i2;
                                    if (imo != null) {
                                    }
                                    CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                    cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                    str245 = str6;
                                    str246 = str5;
                                    str244 = str4;
                                    z33 = z;
                                    i12 = i;
                                    uuid = str7;
                                    str242 = str2;
                                    str239 = obj2;
                                    str241 = obj;
                                    j14 = j2;
                                    ily = this;
                                    str243 = str8;
                                    str240 = str3;
                                    z34 = true;
                                } catch (Throwable th24) {
                                    th = th24;
                                    str88 = str240;
                                    String str337 = str241;
                                    httpURLConnection32 = O000000o2;
                                    str91 = str118;
                                    str90 = str107;
                                    str142 = str116;
                                    obj27 = str337;
                                    cdnConfigModel13 = cdnConfigModel17;
                                    f2 = z8;
                                    httpURLConnection16 = httpURLConnection32;
                                    inputStream2 = null;
                                    th4 = th;
                                    str89 = str242;
                                    z9 = z34;
                                    obj7 = obj27;
                                    str3 = str88;
                                    byteArrayOutputStream = null;
                                    obj = obj7;
                                    if (!z) {
                                    }
                                    Throwable th6222222222222222 = th;
                                    httpURLConnection2 = httpURLConnection;
                                    if (httpURLConnection2 != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                    throw th6222222222222222;
                                }
                            } catch (MalformedURLException e103) {
                                httpURLConnection23 = O000000o2;
                                str7 = str119;
                                z8 = f4;
                                str72 = str107;
                                str247 = str116;
                                String str338 = str240;
                                String str339 = str241;
                                str87 = str118;
                                malformedURLException5 = e103;
                                obj17 = str339;
                                obj18 = str338;
                                cdnConfigModel4 = cdnConfigModel17;
                                obj2 = str117;
                                str127 = str;
                                obj15 = obj17;
                                str7 = str7;
                                z8 = z8;
                                obj16 = obj18;
                                httpURLConnection26 = httpURLConnection23;
                                byteArrayOutputStream11 = null;
                                inputStream3 = null;
                                obj13 = obj15;
                                z8 = z8;
                                obj14 = obj16;
                                str10 = str242;
                                obj4 = obj13;
                                f20 = z8;
                                obj33 = obj14;
                                if (imo.O0000Oo <= 0.0f) {
                                }
                                imo.O0000O0o = "cdn_connect_fail ";
                                imo.O00000oo = imq.O000000o(malformedURLException);
                                imo.O00000oO = "0.0";
                                imo.O0000o0O = str8;
                                imo.O0000o0o = str8;
                                imo.O0000o = str247;
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                                if (!z) {
                                }
                                long j2322222222222222 = j;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                str9 = XMediaplayerJNI.O0000o0;
                                sb = new StringBuilder(str4);
                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                imc.O000000o(str9, (Object) sb.toString());
                                f20 = f20;
                                if (imo != null) {
                                }
                                CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                str245 = str6;
                                str246 = str5;
                                str244 = str4;
                                z33 = z;
                                i12 = i;
                                uuid = str7;
                                str242 = str2;
                                str239 = obj2;
                                str241 = obj;
                                j14 = j2;
                                ily = this;
                                str243 = str8;
                                str240 = str3;
                                z34 = true;
                            } catch (SocketTimeoutException e104) {
                                httpURLConnection23 = O000000o2;
                                str7 = str119;
                                z8 = f4;
                                str72 = str107;
                                str247 = str116;
                                String str340 = str240;
                                String str341 = str241;
                                str87 = str118;
                                socketTimeoutException5 = e104;
                                obj21 = str341;
                                obj23 = str340;
                                cdnConfigModel6 = cdnConfigModel17;
                                obj2 = str117;
                                str128 = str;
                                obj2 = obj2;
                                str7 = str7;
                                z8 = z8;
                                obj22 = obj23;
                                httpURLConnection27 = httpURLConnection23;
                                byteArrayOutputStream12 = null;
                                inputStream4 = null;
                                obj19 = obj21;
                                obj2 = obj2;
                                str7 = str7;
                                z8 = z8;
                                obj20 = obj22;
                                str23 = str242;
                                obj4 = obj19;
                                obj2 = obj2;
                                str7 = str7;
                                f20 = z8;
                                obj5 = obj20;
                                imo.O00000oO = "0.0";
                                if (imo.O0000Oo <= 0.0f) {
                                }
                                if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                }
                                imo.O0000o0O = str21;
                                imo.O0000o0o = str21;
                                imo.O0000o = str247;
                                imo.O00000o = true;
                                if (!z) {
                                }
                                long j1822222222222222222 = j;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                str20 = XMediaplayerJNI.O0000o0;
                                sb2 = new StringBuilder(str4);
                                str7 = str7;
                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                imc.O000000o(str20, (Object) sb2.toString());
                                j2 = j202222222222222222;
                                f20 = f20;
                                if (imo != null) {
                                }
                                CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                str245 = str6;
                                str246 = str5;
                                str244 = str4;
                                z33 = z;
                                i12 = i;
                                uuid = str7;
                                str242 = str2;
                                str239 = obj2;
                                str241 = obj;
                                j14 = j2;
                                ily = this;
                                str243 = str8;
                                str240 = str3;
                                z34 = true;
                            } catch (UnknownHostException e105) {
                                httpURLConnection23 = O000000o2;
                                str7 = str119;
                                z8 = f4;
                                str72 = str107;
                                str247 = str116;
                                String str342 = str240;
                                String str343 = str241;
                                str87 = str118;
                                unknownHostException5 = e105;
                                str129 = str343;
                                str35 = str342;
                                cdnConfigModel8 = cdnConfigModel17;
                                obj2 = str117;
                                str130 = str;
                                httpURLConnection28 = httpURLConnection23;
                                byteArrayOutputStream13 = null;
                                inputStream5 = null;
                                str34 = str242;
                                if (imo.O0000Oo <= 0.0f) {
                                }
                                imo.O0000O0o = "dns_fail";
                                imo.O00000oo = imq.O000000o(unknownHostException);
                                imo.O00000oO = "0.0";
                                imo.O0000o0O = str21;
                                imo.O0000o0o = str21;
                                imo.O0000o = str247;
                                if (!z) {
                                }
                                long j1922222222222222222 = j;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                str20 = XMediaplayerJNI.O0000o0;
                                sb2 = new StringBuilder(str4);
                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                imc.O000000o(str20, (Object) sb2.toString());
                                j2 = j202222222222222222;
                                f20 = f20;
                                if (imo != null) {
                                }
                                CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                str245 = str6;
                                str246 = str5;
                                str244 = str4;
                                z33 = z;
                                i12 = i;
                                uuid = str7;
                                str242 = str2;
                                str239 = obj2;
                                str241 = obj;
                                j14 = j2;
                                ily = this;
                                str243 = str8;
                                str240 = str3;
                                z34 = true;
                            } catch (IllegalArgumentException e106) {
                                httpURLConnection23 = O000000o2;
                                str7 = str119;
                                z8 = f4;
                                str72 = str107;
                                str247 = str116;
                                String str344 = str240;
                                String str345 = str241;
                                str87 = str118;
                                illegalArgumentException5 = e106;
                                str132 = str345;
                                str135 = str344;
                                cdnConfigModel10 = cdnConfigModel17;
                                obj2 = str117;
                                str134 = str;
                                obj2 = obj2;
                                str133 = str135;
                                httpURLConnection29 = httpURLConnection23;
                                byteArrayOutputStream14 = null;
                                inputStream6 = null;
                                str131 = str133;
                                str48 = str242;
                                str238 = str131;
                                if (imo.O0000Oo <= 0.0f) {
                                }
                                imo.O0000O0o = "dns_fail";
                                imo.O00000oo = imq.O000000o(illegalArgumentException);
                                imo.O00000oO = "0.0";
                                imo.O0000o0O = str21;
                                imo.O0000o0o = str21;
                                imo.O0000o = str247;
                                if (!z) {
                                }
                                long j2022222222222222222 = j;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                str20 = XMediaplayerJNI.O0000o0;
                                sb2 = new StringBuilder(str4);
                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                imc.O000000o(str20, (Object) sb2.toString());
                                j2 = j2022222222222222222;
                                f20 = f20;
                                if (imo != null) {
                                }
                                CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                str245 = str6;
                                str246 = str5;
                                str244 = str4;
                                z33 = z;
                                i12 = i;
                                uuid = str7;
                                str242 = str2;
                                str239 = obj2;
                                str241 = obj;
                                j14 = j2;
                                ily = this;
                                str243 = str8;
                                str240 = str3;
                                z34 = true;
                            } catch (FileNotFoundException e107) {
                                httpURLConnection23 = O000000o2;
                                str7 = str119;
                                z8 = f4;
                                str72 = str107;
                                str247 = str116;
                                String str346 = str240;
                                String str347 = str241;
                                str87 = str118;
                                fileNotFoundException5 = e107;
                                str136 = str347;
                                obj26 = str346;
                                cdnConfigModel2 = cdnConfigModel17;
                                obj2 = str117;
                                str137 = str;
                                str7 = str7;
                                z8 = z8;
                                obj25 = obj26;
                                httpURLConnection30 = httpURLConnection23;
                                byteArrayOutputStream15 = null;
                                inputStream7 = null;
                                z8 = z8;
                                obj24 = obj25;
                                str59 = str242;
                                obj = str136;
                                f20 = z8;
                                obj34 = obj24;
                                if (imo.O0000Oo <= 0.0f) {
                                }
                                imo.O0000O0o = "system_exception";
                                imo.O00000oo = imq.O000000o(fileNotFoundException);
                                imo.O00000oO = "0.0";
                                imo.O0000o0O = str8;
                                imo.O0000o0o = str8;
                                imo.O0000o = str247;
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                                if (!z) {
                                }
                                long j2122222222222222222 = j;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                str9 = XMediaplayerJNI.O0000o0;
                                sb = new StringBuilder(str4);
                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                imc.O000000o(str9, (Object) sb.toString());
                                f20 = f20;
                                if (imo != null) {
                                }
                                CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                str245 = str6;
                                str246 = str5;
                                str244 = str4;
                                z33 = z;
                                i12 = i;
                                uuid = str7;
                                str242 = str2;
                                str239 = obj2;
                                str241 = obj;
                                j14 = j2;
                                ily = this;
                                str243 = str8;
                                str240 = str3;
                                z34 = true;
                            } catch (IOException e108) {
                                httpURLConnection23 = O000000o2;
                                str7 = str119;
                                z8 = f4;
                                str72 = str107;
                                str247 = str116;
                                String str348 = str240;
                                String str349 = str241;
                                str87 = str118;
                                iOException5 = e108;
                                str140 = str349;
                                str141 = str348;
                                obj2 = str117;
                                i7 = i13;
                                str138 = str140;
                                str7 = str7;
                                z8 = z8;
                                str139 = str141;
                                httpURLConnection31 = httpURLConnection23;
                                byteArrayOutputStream = null;
                                inputStream = null;
                                obj4 = str138;
                                obj2 = obj2;
                                str7 = str7;
                                z8 = z8;
                                str70 = str242;
                                f20 = z8;
                                str3 = str139;
                                if (!z) {
                                }
                                cdnConfigModel2 = cdnConfigModel17;
                                String str25422222222222222222 = str;
                                j = j;
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                                if (!z) {
                                }
                                long j2222222222222222222 = j;
                                if (httpURLConnection != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                i13 = i2;
                                if (imo != null) {
                                }
                                CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                                cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                str245 = str6;
                                str246 = str5;
                                str244 = str4;
                                z33 = z;
                                i12 = i;
                                uuid = str7;
                                str242 = str2;
                                str239 = obj2;
                                str241 = obj;
                                j14 = j2;
                                ily = this;
                                str243 = str8;
                                str240 = str3;
                                z34 = true;
                            } catch (Throwable th25) {
                                th = th25;
                                str88 = str240;
                                String str350 = str241;
                                httpURLConnection32 = O000000o2;
                                z8 = f4;
                                str91 = str118;
                                str90 = str107;
                                str142 = str116;
                                obj27 = str350;
                                cdnConfigModel13 = cdnConfigModel17;
                                obj2 = str117;
                                f2 = z8;
                                httpURLConnection16 = httpURLConnection32;
                                inputStream2 = null;
                                th4 = th;
                                str89 = str242;
                                z9 = z34;
                                obj7 = obj27;
                                str3 = str88;
                                byteArrayOutputStream = null;
                                obj = obj7;
                                if (!z) {
                                }
                                Throwable th62222222222222222 = th;
                                httpURLConnection2 = httpURLConnection;
                                if (httpURLConnection2 != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                                throw th62222222222222222;
                            }
                        }
                    } catch (MalformedURLException e109) {
                        httpURLConnection17 = O000000o2;
                        long j25 = j14;
                        str15 = str107;
                        z = z33;
                        String str351 = str246;
                        String str352 = str240;
                        String str353 = str241;
                        str16 = str351;
                        malformedURLException2 = e109;
                        obj9 = str353;
                        str14 = str242;
                        str6 = str245;
                        r21 = str352;
                        cdnConfigModel5 = cdnConfigModel17;
                        str17 = str;
                        j = j25;
                        httpURLConnection4 = httpURLConnection17;
                        byteArrayOutputStream2 = null;
                        obj3 = obj9;
                        str11 = r21;
                        inputStream = null;
                        obj4 = obj3;
                        obj2 = obj2;
                        obj33 = str11;
                        if (imo.O0000Oo <= 0.0f) {
                        }
                        imo.O0000O0o = "cdn_connect_fail ";
                        imo.O00000oo = imq.O000000o(malformedURLException);
                        imo.O00000oO = "0.0";
                        imo.O0000o0O = str8;
                        imo.O0000o0o = str8;
                        imo.O0000o = str247;
                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                        if (!z) {
                        }
                        long j23222222222222222 = j;
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        str9 = XMediaplayerJNI.O0000o0;
                        sb = new StringBuilder(str4);
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        imc.O000000o(str9, (Object) sb.toString());
                        f20 = f20;
                        if (imo != null) {
                        }
                        CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                        cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        str245 = str6;
                        str246 = str5;
                        str244 = str4;
                        z33 = z;
                        i12 = i;
                        uuid = str7;
                        str242 = str2;
                        str239 = obj2;
                        str241 = obj;
                        j14 = j2;
                        ily = this;
                        str243 = str8;
                        str240 = str3;
                        z34 = true;
                    } catch (SocketTimeoutException e110) {
                        httpURLConnection18 = O000000o2;
                        long j26 = j14;
                        str28 = str107;
                        z = z33;
                        String str354 = str246;
                        String str355 = str240;
                        String str356 = str241;
                        str29 = str354;
                        socketTimeoutException2 = e110;
                        r38 = str356;
                        str27 = str242;
                        str6 = str245;
                        obj10 = str355;
                        cdnConfigModel7 = cdnConfigModel17;
                        str30 = str;
                        j = j26;
                        httpURLConnection6 = httpURLConnection18;
                        byteArrayOutputStream3 = null;
                        str22 = obj2;
                        obj5 = obj10;
                        inputStream = null;
                        obj2 = str22;
                        str7 = str7;
                        f20 = f20;
                        imo.O00000oO = "0.0";
                        if (imo.O0000Oo <= 0.0f) {
                        }
                        if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                        }
                        imo.O0000o0O = str21;
                        imo.O0000o0o = str21;
                        imo.O0000o = str247;
                        imo.O00000o = true;
                        if (!z) {
                        }
                        long j18222222222222222222 = j;
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        str20 = XMediaplayerJNI.O0000o0;
                        sb2 = new StringBuilder(str4);
                        str7 = str7;
                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                        imc.O000000o(str20, (Object) sb2.toString());
                        j2 = j2022222222222222222;
                        f20 = f20;
                        if (imo != null) {
                        }
                        CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                        cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        str245 = str6;
                        str246 = str5;
                        str244 = str4;
                        z33 = z;
                        i12 = i;
                        uuid = str7;
                        str242 = str2;
                        str239 = obj2;
                        str241 = obj;
                        j14 = j2;
                        ily = this;
                        str243 = str8;
                        str240 = str3;
                        z34 = true;
                    } catch (UnknownHostException e111) {
                        httpURLConnection19 = O000000o2;
                        long j27 = j14;
                        str42 = str107;
                        z = z33;
                        String str357 = str246;
                        String str358 = str240;
                        String str359 = str241;
                        str43 = str357;
                        unknownHostException2 = e111;
                        str39 = str359;
                        str40 = str242;
                        str6 = str245;
                        str41 = str358;
                        cdnConfigModel9 = cdnConfigModel17;
                        str44 = str;
                        j = j27;
                        httpURLConnection8 = httpURLConnection19;
                        byteArrayOutputStream4 = null;
                        str33 = obj2;
                        inputStream = null;
                        obj2 = str33;
                        if (imo.O0000Oo <= 0.0f) {
                        }
                        imo.O0000O0o = "dns_fail";
                        imo.O00000oo = imq.O000000o(unknownHostException);
                        imo.O00000oO = "0.0";
                        imo.O0000o0O = str21;
                        imo.O0000o0o = str21;
                        imo.O0000o = str247;
                        if (!z) {
                        }
                        long j19222222222222222222 = j;
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        str20 = XMediaplayerJNI.O0000o0;
                        sb2 = new StringBuilder(str4);
                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                        imc.O000000o(str20, (Object) sb2.toString());
                        j2 = j2022222222222222222;
                        f20 = f20;
                        if (imo != null) {
                        }
                        CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                        cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        str245 = str6;
                        str246 = str5;
                        str244 = str4;
                        z33 = z;
                        i12 = i;
                        uuid = str7;
                        str242 = str2;
                        str239 = obj2;
                        str241 = obj;
                        j14 = j2;
                        ily = this;
                        str243 = str8;
                        str240 = str3;
                        z34 = true;
                    } catch (IllegalArgumentException e112) {
                        httpURLConnection20 = O000000o2;
                        long j28 = j14;
                        str53 = str107;
                        z = z33;
                        String str360 = str246;
                        String str361 = str240;
                        String str362 = str241;
                        str54 = str360;
                        illegalArgumentException2 = e112;
                        r382 = str362;
                        str52 = str242;
                        str6 = str245;
                        str108 = str361;
                        cdnConfigModel11 = cdnConfigModel17;
                        str55 = str;
                        j = j28;
                        httpURLConnection10 = httpURLConnection20;
                        byteArrayOutputStream5 = null;
                        str47 = obj2;
                        str49 = str108;
                        inputStream = null;
                        obj2 = str47;
                        str238 = str49;
                        if (imo.O0000Oo <= 0.0f) {
                        }
                        imo.O0000O0o = "dns_fail";
                        imo.O00000oo = imq.O000000o(illegalArgumentException);
                        imo.O00000oO = "0.0";
                        imo.O0000o0O = str21;
                        imo.O0000o0o = str21;
                        imo.O0000o = str247;
                        if (!z) {
                        }
                        long j20222222222222222222 = j;
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        str20 = XMediaplayerJNI.O0000o0;
                        sb2 = new StringBuilder(str4);
                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                        imc.O000000o(str20, (Object) sb2.toString());
                        j2 = j20222222222222222222;
                        f20 = f20;
                        if (imo != null) {
                        }
                        CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                        cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        str245 = str6;
                        str246 = str5;
                        str244 = str4;
                        z33 = z;
                        i12 = i;
                        uuid = str7;
                        str242 = str2;
                        str239 = obj2;
                        str241 = obj;
                        j14 = j2;
                        ily = this;
                        str243 = str8;
                        str240 = str3;
                        z34 = true;
                    } catch (FileNotFoundException e113) {
                        httpURLConnection21 = O000000o2;
                        long j29 = j14;
                        str64 = str107;
                        z = z33;
                        String str363 = str246;
                        String str364 = str240;
                        String str365 = str241;
                        str65 = str363;
                        fileNotFoundException2 = e113;
                        str109 = str365;
                        str63 = str242;
                        str6 = str245;
                        r212 = str364;
                        cdnConfigModel12 = cdnConfigModel17;
                        str66 = str;
                        j = j29;
                        httpURLConnection12 = httpURLConnection21;
                        byteArrayOutputStream6 = null;
                        str58 = str109;
                        str60 = r212;
                        inputStream = null;
                        obj = str58;
                        obj2 = obj2;
                        obj34 = str60;
                        if (imo.O0000Oo <= 0.0f) {
                        }
                        imo.O0000O0o = "system_exception";
                        imo.O00000oo = imq.O000000o(fileNotFoundException);
                        imo.O00000oO = "0.0";
                        imo.O0000o0O = str8;
                        imo.O0000o0o = str8;
                        imo.O0000o = str247;
                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                        if (!z) {
                        }
                        long j21222222222222222222 = j;
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        str9 = XMediaplayerJNI.O0000o0;
                        sb = new StringBuilder(str4);
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        imc.O000000o(str9, (Object) sb.toString());
                        f20 = f20;
                        if (imo != null) {
                        }
                        CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                        cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        str245 = str6;
                        str246 = str5;
                        str244 = str4;
                        z33 = z;
                        i12 = i;
                        uuid = str7;
                        str242 = str2;
                        str239 = obj2;
                        str241 = obj;
                        j14 = j2;
                        ily = this;
                        str243 = str8;
                        str240 = str3;
                        z34 = true;
                    } catch (IOException e114) {
                        httpURLConnection22 = O000000o2;
                        str74 = str107;
                        z = z33;
                        String str366 = str246;
                        String str367 = str240;
                        String str368 = str241;
                        str75 = str366;
                        iOException2 = e114;
                        obj11 = str368;
                        str70 = str242;
                        str6 = str245;
                        r213 = str367;
                        i3 = i13;
                        j = j14;
                        httpURLConnection13 = httpURLConnection22;
                        byteArrayOutputStream7 = null;
                        obj6 = obj11;
                        str69 = obj2;
                        str71 = r213;
                        inputStream = null;
                        obj4 = obj6;
                        obj2 = str69;
                        str3 = str71;
                        if (!z) {
                        }
                        cdnConfigModel2 = cdnConfigModel17;
                        String str254222222222222222222 = str;
                        j = j;
                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                        if (!z) {
                        }
                        long j22222222222222222222 = j;
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                        i13 = i2;
                        if (imo != null) {
                        }
                        CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                        cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        str245 = str6;
                        str246 = str5;
                        str244 = str4;
                        z33 = z;
                        i12 = i;
                        uuid = str7;
                        str242 = str2;
                        str239 = obj2;
                        str241 = obj;
                        j14 = j2;
                        ily = this;
                        str243 = str8;
                        str240 = str3;
                        z34 = true;
                    } catch (Throwable th26) {
                        th = th26;
                        httpURLConnection25 = O000000o2;
                        str93 = str107;
                        z = z33;
                        String str369 = str246;
                        str92 = str240;
                        String str370 = str241;
                        str94 = str369;
                        obj12 = str370;
                        str89 = str242;
                        str6 = str245;
                        cdnConfigModel14 = cdnConfigModel17;
                        z9 = z34;
                        f2 = f20;
                        j = j14;
                        httpURLConnection16 = httpURLConnection25;
                        obj8 = obj12;
                        inputStream2 = null;
                        th4 = th;
                        obj7 = obj8;
                        str3 = str88;
                        byteArrayOutputStream = null;
                        obj = obj7;
                        if (!z) {
                        }
                        Throwable th622222222222222222 = th;
                        httpURLConnection2 = httpURLConnection;
                        if (httpURLConnection2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                        throw th622222222222222222;
                    }
                } catch (MalformedURLException e115) {
                    j3 = j14;
                    str18 = str107;
                    z3 = z33;
                    String str371 = str246;
                    str95 = str240;
                    str96 = str241;
                    str19 = str371;
                    malformedURLException3 = e115;
                    String str372 = str96;
                    String str373 = str242;
                    String str374 = str245;
                    String str375 = str95;
                    CdnConfigModel cdnConfigModel20 = cdnConfigModel17;
                    String str376 = str;
                    j = j3;
                    byteArrayOutputStream2 = null;
                    httpURLConnection4 = null;
                    obj3 = str372;
                    obj2 = obj2;
                    str11 = str375;
                    inputStream = null;
                    obj4 = obj3;
                    obj2 = obj2;
                    obj33 = str11;
                    if (imo.O0000Oo <= 0.0f) {
                    }
                    imo.O0000O0o = "cdn_connect_fail ";
                    imo.O00000oo = imq.O000000o(malformedURLException);
                    imo.O00000oO = "0.0";
                    imo.O0000o0O = str8;
                    imo.O0000o0o = str8;
                    imo.O0000o = str247;
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                    if (!z) {
                    }
                    long j232222222222222222 = j;
                    if (httpURLConnection != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    str9 = XMediaplayerJNI.O0000o0;
                    sb = new StringBuilder(str4);
                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                    imc.O000000o(str9, (Object) sb.toString());
                    f20 = f20;
                    if (imo != null) {
                    }
                    CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                    cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                    str245 = str6;
                    str246 = str5;
                    str244 = str4;
                    z33 = z;
                    i12 = i;
                    uuid = str7;
                    str242 = str2;
                    str239 = obj2;
                    str241 = obj;
                    j14 = j2;
                    ily = this;
                    str243 = str8;
                    str240 = str3;
                    z34 = true;
                } catch (SocketTimeoutException e116) {
                    j4 = j14;
                    str31 = str107;
                    z4 = z33;
                    String str377 = str246;
                    str97 = str240;
                    str98 = str241;
                    str32 = str377;
                    socketTimeoutException3 = e116;
                    String str378 = str98;
                    String str379 = str242;
                    String str380 = str245;
                    String str381 = str97;
                    CdnConfigModel cdnConfigModel21 = cdnConfigModel17;
                    String str382 = str;
                    String str383 = obj2;
                    String str384 = str7;
                    j = j4;
                    byteArrayOutputStream3 = null;
                    httpURLConnection6 = null;
                    str22 = str383;
                    str7 = str384;
                    obj5 = str381;
                    inputStream = null;
                    obj2 = str22;
                    str7 = str7;
                    f20 = f20;
                    imo.O00000oO = "0.0";
                    if (imo.O0000Oo <= 0.0f) {
                    }
                    if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                    }
                    imo.O0000o0O = str21;
                    imo.O0000o0o = str21;
                    imo.O0000o = str247;
                    imo.O00000o = true;
                    if (!z) {
                    }
                    long j182222222222222222222 = j;
                    if (httpURLConnection != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    str20 = XMediaplayerJNI.O0000o0;
                    sb2 = new StringBuilder(str4);
                    str7 = str7;
                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                    imc.O000000o(str20, (Object) sb2.toString());
                    j2 = j20222222222222222222;
                    f20 = f20;
                    if (imo != null) {
                    }
                    CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                    cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                    str245 = str6;
                    str246 = str5;
                    str244 = str4;
                    z33 = z;
                    i12 = i;
                    uuid = str7;
                    str242 = str2;
                    str239 = obj2;
                    str241 = obj;
                    j14 = j2;
                    ily = this;
                    str243 = str8;
                    str240 = str3;
                    z34 = true;
                } catch (UnknownHostException e117) {
                    j5 = j14;
                    str45 = str107;
                    z5 = z33;
                    String str385 = str246;
                    str99 = str240;
                    str100 = str241;
                    str46 = str385;
                    unknownHostException3 = e117;
                    String str386 = str100;
                    String str387 = str242;
                    String str388 = str245;
                    String str389 = str99;
                    CdnConfigModel cdnConfigModel22 = cdnConfigModel17;
                    String str390 = str;
                    String str391 = obj2;
                    j = j5;
                    byteArrayOutputStream4 = null;
                    httpURLConnection8 = null;
                    str33 = str391;
                    inputStream = null;
                    obj2 = str33;
                    if (imo.O0000Oo <= 0.0f) {
                    }
                    imo.O0000O0o = "dns_fail";
                    imo.O00000oo = imq.O000000o(unknownHostException);
                    imo.O00000oO = "0.0";
                    imo.O0000o0O = str21;
                    imo.O0000o0o = str21;
                    imo.O0000o = str247;
                    if (!z) {
                    }
                    long j192222222222222222222 = j;
                    if (httpURLConnection != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    str20 = XMediaplayerJNI.O0000o0;
                    sb2 = new StringBuilder(str4);
                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                    imc.O000000o(str20, (Object) sb2.toString());
                    j2 = j20222222222222222222;
                    f20 = f20;
                    if (imo != null) {
                    }
                    CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                    cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                    str245 = str6;
                    str246 = str5;
                    str244 = str4;
                    z33 = z;
                    i12 = i;
                    uuid = str7;
                    str242 = str2;
                    str239 = obj2;
                    str241 = obj;
                    j14 = j2;
                    ily = this;
                    str243 = str8;
                    str240 = str3;
                    z34 = true;
                } catch (IllegalArgumentException e118) {
                    j6 = j14;
                    str56 = str107;
                    z6 = z33;
                    String str392 = str246;
                    str101 = str240;
                    str102 = str241;
                    str57 = str392;
                    illegalArgumentException3 = e118;
                    String str393 = str102;
                    String str394 = str242;
                    String str395 = str245;
                    String str396 = str101;
                    CdnConfigModel cdnConfigModel23 = cdnConfigModel17;
                    String str397 = str;
                    String str398 = obj2;
                    String str399 = str7;
                    j = j6;
                    byteArrayOutputStream5 = null;
                    httpURLConnection10 = null;
                    str47 = str398;
                    str7 = str399;
                    str49 = str396;
                    inputStream = null;
                    obj2 = str47;
                    str238 = str49;
                    if (imo.O0000Oo <= 0.0f) {
                    }
                    imo.O0000O0o = "dns_fail";
                    imo.O00000oo = imq.O000000o(illegalArgumentException);
                    imo.O00000oO = "0.0";
                    imo.O0000o0O = str21;
                    imo.O0000o0o = str21;
                    imo.O0000o = str247;
                    if (!z) {
                    }
                    long j202222222222222222222 = j;
                    if (httpURLConnection != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    str20 = XMediaplayerJNI.O0000o0;
                    sb2 = new StringBuilder(str4);
                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                    imc.O000000o(str20, (Object) sb2.toString());
                    j2 = j202222222222222222222;
                    f20 = f20;
                    if (imo != null) {
                    }
                    CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                    cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                    str245 = str6;
                    str246 = str5;
                    str244 = str4;
                    z33 = z;
                    i12 = i;
                    uuid = str7;
                    str242 = str2;
                    str239 = obj2;
                    str241 = obj;
                    j14 = j2;
                    ily = this;
                    str243 = str8;
                    str240 = str3;
                    z34 = true;
                } catch (FileNotFoundException e119) {
                    j7 = j14;
                    str67 = str107;
                    z7 = z33;
                    String str400 = str246;
                    str103 = str240;
                    str104 = str241;
                    str68 = str400;
                    fileNotFoundException3 = e119;
                    String str401 = str104;
                    String str402 = str242;
                    String str403 = str245;
                    String str404 = str103;
                    CdnConfigModel cdnConfigModel24 = cdnConfigModel17;
                    String str405 = str;
                    String str406 = obj2;
                    String str407 = str7;
                    j = j7;
                    byteArrayOutputStream6 = null;
                    httpURLConnection12 = null;
                    str58 = str401;
                    obj2 = str406;
                    str7 = str407;
                    str60 = str404;
                    inputStream = null;
                    obj = str58;
                    obj2 = obj2;
                    obj34 = str60;
                    if (imo.O0000Oo <= 0.0f) {
                    }
                    imo.O0000O0o = "system_exception";
                    imo.O00000oo = imq.O000000o(fileNotFoundException);
                    imo.O00000oO = "0.0";
                    imo.O0000o0O = str8;
                    imo.O0000o0o = str8;
                    imo.O0000o = str247;
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                    if (!z) {
                    }
                    long j212222222222222222222 = j;
                    if (httpURLConnection != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    str9 = XMediaplayerJNI.O0000o0;
                    sb = new StringBuilder(str4);
                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                    imc.O000000o(str9, (Object) sb.toString());
                    f20 = f20;
                    if (imo != null) {
                    }
                    CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                    cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                    str245 = str6;
                    str246 = str5;
                    str244 = str4;
                    z33 = z;
                    i12 = i;
                    uuid = str7;
                    str242 = str2;
                    str239 = obj2;
                    str241 = obj;
                    j14 = j2;
                    ily = this;
                    str243 = str8;
                    str240 = str3;
                    z34 = true;
                } catch (IOException e120) {
                    j8 = j14;
                    str76 = str107;
                    z = z33;
                    String str408 = str246;
                    str105 = str240;
                    str106 = str241;
                    str77 = str408;
                    iOException3 = e120;
                    String str409 = str106;
                    String str410 = str242;
                    String str411 = str245;
                    String str412 = str105;
                    String str413 = obj2;
                    String str414 = str7;
                    i3 = i13;
                    j = j8;
                    byteArrayOutputStream7 = null;
                    httpURLConnection13 = null;
                    obj6 = str409;
                    str69 = str413;
                    str7 = str414;
                    str71 = str412;
                    inputStream = null;
                    obj4 = obj6;
                    obj2 = str69;
                    str3 = str71;
                    if (!z) {
                    }
                    cdnConfigModel2 = cdnConfigModel17;
                    String str2542222222222222222222 = str;
                    j = j;
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                    if (!z) {
                    }
                    long j222222222222222222222 = j;
                    if (httpURLConnection != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                    i13 = i2;
                    if (imo != null) {
                    }
                    CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                    cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                    str245 = str6;
                    str246 = str5;
                    str244 = str4;
                    z33 = z;
                    i12 = i;
                    uuid = str7;
                    str242 = str2;
                    str239 = obj2;
                    str241 = obj;
                    j14 = j2;
                    ily = this;
                    str243 = str8;
                    str240 = str3;
                    z34 = true;
                } catch (Throwable th27) {
                    th = th27;
                    long j30 = j14;
                    String str415 = str107;
                    boolean z36 = z33;
                    String str416 = str246;
                    String str417 = str240;
                    String str418 = str241;
                    String str419 = str416;
                    obj8 = str418;
                    str89 = str242;
                    str6 = str245;
                    cdnConfigModel14 = cdnConfigModel17;
                    z9 = z34;
                    f2 = f20;
                    j = j30;
                    httpURLConnection16 = null;
                    obj2 = obj2;
                    inputStream2 = null;
                    th4 = th;
                    obj7 = obj8;
                    str3 = str88;
                    byteArrayOutputStream = null;
                    obj = obj7;
                    if (!z) {
                    }
                    Throwable th6222222222222222222 = th;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                    throw th6222222222222222222;
                }
            } catch (MalformedURLException e121) {
                e = e121;
                str18 = str244;
                str7 = uuid;
                j3 = j14;
                z3 = z33;
                String str420 = str246;
                str95 = str240;
                str96 = str241;
                str19 = str420;
                malformedURLException3 = e;
                obj2 = str239;
                String str3722 = str96;
                String str3732 = str242;
                String str3742 = str245;
                String str3752 = str95;
                CdnConfigModel cdnConfigModel202 = cdnConfigModel17;
                String str3762 = str;
                j = j3;
                byteArrayOutputStream2 = null;
                httpURLConnection4 = null;
                obj3 = str3722;
                obj2 = obj2;
                str11 = str3752;
                inputStream = null;
                obj4 = obj3;
                obj2 = obj2;
                obj33 = str11;
                if (imo.O0000Oo <= 0.0f) {
                }
                imo.O0000O0o = "cdn_connect_fail ";
                imo.O00000oo = imq.O000000o(malformedURLException);
                imo.O00000oO = "0.0";
                imo.O0000o0O = str8;
                imo.O0000o0o = str8;
                imo.O0000o = str247;
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
                if (!z) {
                }
                long j2322222222222222222 = j;
                if (httpURLConnection != null) {
                }
                if (inputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                str9 = XMediaplayerJNI.O0000o0;
                sb = new StringBuilder(str4);
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                imc.O000000o(str9, (Object) sb.toString());
                f20 = f20;
                if (imo != null) {
                }
                CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                str245 = str6;
                str246 = str5;
                str244 = str4;
                z33 = z;
                i12 = i;
                uuid = str7;
                str242 = str2;
                str239 = obj2;
                str241 = obj;
                j14 = j2;
                ily = this;
                str243 = str8;
                str240 = str3;
                z34 = true;
            } catch (SocketTimeoutException e122) {
                e = e122;
                str31 = str244;
                str7 = uuid;
                j4 = j14;
                z4 = z33;
                String str421 = str246;
                str97 = str240;
                str98 = str241;
                str32 = str421;
                socketTimeoutException3 = e;
                obj2 = str239;
                str7 = str7;
                String str3782 = str98;
                String str3792 = str242;
                String str3802 = str245;
                String str3812 = str97;
                CdnConfigModel cdnConfigModel212 = cdnConfigModel17;
                String str3822 = str;
                String str3832 = obj2;
                String str3842 = str7;
                j = j4;
                byteArrayOutputStream3 = null;
                httpURLConnection6 = null;
                str22 = str3832;
                str7 = str3842;
                obj5 = str3812;
                inputStream = null;
                obj2 = str22;
                str7 = str7;
                f20 = f20;
                imo.O00000oO = "0.0";
                if (imo.O0000Oo <= 0.0f) {
                }
                if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                }
                imo.O0000o0O = str21;
                imo.O0000o0o = str21;
                imo.O0000o = str247;
                imo.O00000o = true;
                if (!z) {
                }
                long j1822222222222222222222 = j;
                if (httpURLConnection != null) {
                }
                if (inputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                str20 = XMediaplayerJNI.O0000o0;
                sb2 = new StringBuilder(str4);
                str7 = str7;
                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                imc.O000000o(str20, (Object) sb2.toString());
                j2 = j202222222222222222222;
                f20 = f20;
                if (imo != null) {
                }
                CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                str245 = str6;
                str246 = str5;
                str244 = str4;
                z33 = z;
                i12 = i;
                uuid = str7;
                str242 = str2;
                str239 = obj2;
                str241 = obj;
                j14 = j2;
                ily = this;
                str243 = str8;
                str240 = str3;
                z34 = true;
            } catch (UnknownHostException e123) {
                e = e123;
                str45 = str244;
                str7 = uuid;
                j5 = j14;
                z5 = z33;
                String str422 = str246;
                str99 = str240;
                str100 = str241;
                str46 = str422;
                unknownHostException3 = e;
                obj2 = str239;
                String str3862 = str100;
                String str3872 = str242;
                String str3882 = str245;
                String str3892 = str99;
                CdnConfigModel cdnConfigModel222 = cdnConfigModel17;
                String str3902 = str;
                String str3912 = obj2;
                j = j5;
                byteArrayOutputStream4 = null;
                httpURLConnection8 = null;
                str33 = str3912;
                inputStream = null;
                obj2 = str33;
                if (imo.O0000Oo <= 0.0f) {
                }
                imo.O0000O0o = "dns_fail";
                imo.O00000oo = imq.O000000o(unknownHostException);
                imo.O00000oO = "0.0";
                imo.O0000o0O = str21;
                imo.O0000o0o = str21;
                imo.O0000o = str247;
                if (!z) {
                }
                long j1922222222222222222222 = j;
                if (httpURLConnection != null) {
                }
                if (inputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                str20 = XMediaplayerJNI.O0000o0;
                sb2 = new StringBuilder(str4);
                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                imc.O000000o(str20, (Object) sb2.toString());
                j2 = j202222222222222222222;
                f20 = f20;
                if (imo != null) {
                }
                CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                str245 = str6;
                str246 = str5;
                str244 = str4;
                z33 = z;
                i12 = i;
                uuid = str7;
                str242 = str2;
                str239 = obj2;
                str241 = obj;
                j14 = j2;
                ily = this;
                str243 = str8;
                str240 = str3;
                z34 = true;
            } catch (IllegalArgumentException e124) {
                e = e124;
                str56 = str244;
                str7 = uuid;
                j6 = j14;
                z6 = z33;
                String str423 = str246;
                str101 = str240;
                str102 = str241;
                str57 = str423;
                illegalArgumentException3 = e;
                obj2 = str239;
                str7 = str7;
                String str3932 = str102;
                String str3942 = str242;
                String str3952 = str245;
                String str3962 = str101;
                CdnConfigModel cdnConfigModel232 = cdnConfigModel17;
                String str3972 = str;
                String str3982 = obj2;
                String str3992 = str7;
                j = j6;
                byteArrayOutputStream5 = null;
                httpURLConnection10 = null;
                str47 = str3982;
                str7 = str3992;
                str49 = str3962;
                inputStream = null;
                obj2 = str47;
                str238 = str49;
                if (imo.O0000Oo <= 0.0f) {
                }
                imo.O0000O0o = "dns_fail";
                imo.O00000oo = imq.O000000o(illegalArgumentException);
                imo.O00000oO = "0.0";
                imo.O0000o0O = str21;
                imo.O0000o0o = str21;
                imo.O0000o = str247;
                if (!z) {
                }
                long j2022222222222222222222 = j;
                if (httpURLConnection != null) {
                }
                if (inputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                str20 = XMediaplayerJNI.O0000o0;
                sb2 = new StringBuilder(str4);
                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                imc.O000000o(str20, (Object) sb2.toString());
                j2 = j2022222222222222222222;
                f20 = f20;
                if (imo != null) {
                }
                CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                str245 = str6;
                str246 = str5;
                str244 = str4;
                z33 = z;
                i12 = i;
                uuid = str7;
                str242 = str2;
                str239 = obj2;
                str241 = obj;
                j14 = j2;
                ily = this;
                str243 = str8;
                str240 = str3;
                z34 = true;
            } catch (FileNotFoundException e125) {
                e = e125;
                str67 = str244;
                str7 = uuid;
                j7 = j14;
                z7 = z33;
                String str424 = str246;
                str103 = str240;
                str104 = str241;
                str68 = str424;
                fileNotFoundException3 = e;
                obj2 = str239;
                str7 = str7;
                String str4012 = str104;
                String str4022 = str242;
                String str4032 = str245;
                String str4042 = str103;
                CdnConfigModel cdnConfigModel242 = cdnConfigModel17;
                String str4052 = str;
                String str4062 = obj2;
                String str4072 = str7;
                j = j7;
                byteArrayOutputStream6 = null;
                httpURLConnection12 = null;
                str58 = str4012;
                obj2 = str4062;
                str7 = str4072;
                str60 = str4042;
                inputStream = null;
                obj = str58;
                obj2 = obj2;
                obj34 = str60;
                if (imo.O0000Oo <= 0.0f) {
                }
                imo.O0000O0o = "system_exception";
                imo.O00000oo = imq.O000000o(fileNotFoundException);
                imo.O00000oO = "0.0";
                imo.O0000o0O = str8;
                imo.O0000o0o = str8;
                imo.O0000o = str247;
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread IOException:" + fileNotFoundException.toString()));
                if (!z) {
                }
                long j2122222222222222222222 = j;
                if (httpURLConnection != null) {
                }
                if (inputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                str9 = XMediaplayerJNI.O0000o0;
                sb = new StringBuilder(str4);
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                imc.O000000o(str9, (Object) sb.toString());
                f20 = f20;
                if (imo != null) {
                }
                CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                str245 = str6;
                str246 = str5;
                str244 = str4;
                z33 = z;
                i12 = i;
                uuid = str7;
                str242 = str2;
                str239 = obj2;
                str241 = obj;
                j14 = j2;
                ily = this;
                str243 = str8;
                str240 = str3;
                z34 = true;
            } catch (IOException e126) {
                e = e126;
                str76 = str244;
                str7 = uuid;
                j8 = j14;
                z = z33;
                String str425 = str246;
                str105 = str240;
                str106 = str241;
                str77 = str425;
                iOException3 = e;
                obj2 = str239;
                str7 = str7;
                String str4092 = str106;
                String str4102 = str242;
                String str4112 = str245;
                String str4122 = str105;
                String str4132 = obj2;
                String str4142 = str7;
                i3 = i13;
                j = j8;
                byteArrayOutputStream7 = null;
                httpURLConnection13 = null;
                obj6 = str4092;
                str69 = str4132;
                str7 = str4142;
                str71 = str4122;
                inputStream = null;
                obj4 = obj6;
                obj2 = str69;
                str3 = str71;
                if (!z) {
                }
                cdnConfigModel2 = cdnConfigModel17;
                String str25422222222222222222222 = str;
                j = j;
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread IOException:" + iOException.toString()));
                if (!z) {
                }
                long j2222222222222222222222 = j;
                if (httpURLConnection != null) {
                }
                if (inputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + (System.currentTimeMillis() - currentTimeMillis)));
                i13 = i2;
                if (imo != null) {
                }
                CdnConfigModel cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
                cdnConfigModel17 = cdnConfigModel1822222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                str245 = str6;
                str246 = str5;
                str244 = str4;
                z33 = z;
                i12 = i;
                uuid = str7;
                str242 = str2;
                str239 = obj2;
                str241 = obj;
                j14 = j2;
                ily = this;
                str243 = str8;
                str240 = str3;
                z34 = true;
            } catch (Throwable th28) {
            }
        }
        String str426 = str118;
        String str427 = obj2;
        String str428 = obj4;
        ByteArrayOutputStream byteArrayOutputStream26 = byteArrayOutputStream;
        String str429 = str107;
        if (z || imo == null) {
            i8 = i6;
        } else {
            i8 = i6;
            if (TextUtils.isEmpty(imo.O0000Oo0)) {
                imo.O0000Oo0 = null;
            }
            if (TextUtils.isEmpty(imo.O0000OOo)) {
                imo.O0000OOo = str426;
            }
            String str430 = str169;
            imo.O0000OoO = System.currentTimeMillis();
            if (imo.O0000o == null || !imo.O0000o.contains(str6)) {
                imo.O0000o = str247;
            }
            if (!z34 && (i9 = cdnConfigModel17.O00000oO) != -1) {
                if (i9 == 0) {
                    ily.f1456O000000o = (long) cdnConfigModel17.O00000Oo;
                    ily.O00000Oo = (long) cdnConfigModel17.O00000o;
                    if (j > ily.f1456O000000o * 1000) {
                        imo.O0000O0o = str242;
                        imo.O00000oo = str428 + imq.O000000o((float) j, false) + str430 + ily.f1456O000000o + str427;
                    } else if (((float) ily.O00000Oo) > z20) {
                        imo.O0000O0o = "cdn_download_too_slow";
                        imo.O00000oo = "download_speed=" + imq.O000000o((float) z20, true) + "KB/s, download_speed_threshold=" + ily.O00000Oo + "KB/s";
                    }
                } else {
                    String str431 = str430;
                    if (i9 == 1) {
                        str186 = str429;
                        ily.f1456O000000o = (long) cdnConfigModel17.f12180O000000o;
                        ily.O00000Oo = (long) cdnConfigModel17.O00000o0;
                        ily.f1456O000000o = 0;
                        if (j > ily.f1456O000000o * 1000) {
                            imo.O0000O0o = str242;
                            imo.O00000oo = str428 + imq.O000000o((float) j, false) + str431 + ily.f1456O000000o + str427;
                        } else if (((float) ily.O00000Oo) > z20) {
                            imo.O0000O0o = "cdn_download_too_slow";
                            imo.O00000oo = "download_speed=" + imq.O000000o((float) z20, true) + "KB/s, download_speed_threshold=" + ily.O00000Oo + "KB/s";
                        }
                        if (httpURLConnection35 != null) {
                            httpURLConnection35.disconnect();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (byteArrayOutputStream26 != null) {
                            try {
                                byteArrayOutputStream26.close();
                            } catch (IOException unused4) {
                            }
                        }
                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str186 + (System.currentTimeMillis() - currentTimeMillis)));
                        return i8;
                    }
                }
            }
        }
        str186 = str429;
        if (httpURLConnection35 != null) {
        }
        if (inputStream != null) {
        }
        if (byteArrayOutputStream26 != null) {
        }
        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str186 + (System.currentTimeMillis() - currentTimeMillis)));
        return i8;
        str144 = str;
        str145 = str107;
        str146 = str116;
        str143 = str194;
        obj4 = str241;
        str10 = str242;
        str5 = str118;
        z21 = z8;
        str216 = str143;
        cdnConfigModel4 = cdnConfigModel17;
        f20 = z21;
        obj33 = str216;
        if (imo.O0000Oo <= 0.0f) {
        }
        imo.O0000O0o = "cdn_connect_fail ";
        imo.O00000oo = imq.O000000o(malformedURLException);
        imo.O00000oO = "0.0";
        imo.O0000o0O = str8;
        imo.O0000o0o = str8;
        imo.O0000o = str247;
        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
        if (!z) {
        }
        long j23222222222222222222 = j;
        if (httpURLConnection != null) {
        }
        if (inputStream != null) {
        }
        if (byteArrayOutputStream != null) {
        }
        str9 = XMediaplayerJNI.O0000o0;
        sb = new StringBuilder(str4);
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        imc.O000000o(str9, (Object) sb.toString());
        f20 = f20;
        if (imo != null) {
        }
        CdnConfigModel cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
        cdnConfigModel17 = cdnConfigModel18222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
        str245 = str6;
        str246 = str5;
        str244 = str4;
        z33 = z;
        i12 = i;
        uuid = str7;
        str242 = str2;
        str239 = obj2;
        str241 = obj;
        j14 = j2;
        ily = this;
        str243 = str8;
        str240 = str3;
        z34 = true;
        f13 = f4;
        str209 = str120;
        obj29 = str117;
        str13 = str;
        str196 = str116;
        f6 = f13;
        str217 = str209;
        byteArrayOutputStream20 = null;
        inputStream9 = null;
        obj2 = obj29;
        z8 = f6;
        str195 = str217;
        obj4 = str241;
        httpURLConnection36 = O000000o2;
        str5 = str118;
        str12 = str107;
        obj2 = obj2;
        z22 = z8;
        str176 = str195;
        str10 = str242;
        z21 = z22;
        str216 = str176;
        cdnConfigModel4 = cdnConfigModel17;
        f20 = z21;
        obj33 = str216;
        if (imo.O0000Oo <= 0.0f) {
        }
        imo.O0000O0o = "cdn_connect_fail ";
        imo.O00000oo = imq.O000000o(malformedURLException);
        imo.O00000oO = "0.0";
        imo.O0000o0O = str8;
        imo.O0000o0o = str8;
        imo.O0000o = str247;
        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("HlsDownloadThread MalformedURLException:" + malformedURLException.toString()));
        if (!z) {
        }
        long j232222222222222222222 = j;
        if (httpURLConnection != null) {
        }
        if (inputStream != null) {
        }
        if (byteArrayOutputStream != null) {
        }
        str9 = XMediaplayerJNI.O0000o0;
        sb = new StringBuilder(str4);
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        imc.O000000o(str9, (Object) sb.toString());
        f20 = f20;
        if (imo != null) {
        }
        CdnConfigModel cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = cdnConfigModel2;
        cdnConfigModel17 = cdnConfigModel182222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
        str245 = str6;
        str246 = str5;
        str244 = str4;
        z33 = z;
        i12 = i;
        uuid = str7;
        str242 = str2;
        str239 = obj2;
        str241 = obj;
        j14 = j2;
        ily = this;
        str243 = str8;
        str240 = str3;
        z34 = true;
    }
}
