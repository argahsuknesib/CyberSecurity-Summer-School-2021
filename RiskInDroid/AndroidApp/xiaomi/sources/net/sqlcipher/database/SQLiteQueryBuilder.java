package net.sqlcipher.database;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import net.sqlcipher.Cursor;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.database.SQLiteDatabase;

public class SQLiteQueryBuilder {
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private boolean mDistinct = false;
    private SQLiteDatabase.CursorFactory mFactory = null;
    private Map<String, String> mProjectionMap = null;
    private boolean mStrictProjectionMap;
    private String mTables = "";
    private StringBuilder mWhereClause = null;

    public void setDistinct(boolean z) {
        this.mDistinct = z;
    }

    public String getTables() {
        return this.mTables;
    }

    public void setTables(String str) {
        this.mTables = str;
    }

    public void appendWhere(CharSequence charSequence) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(charSequence.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        this.mWhereClause.append(charSequence);
    }

    public void appendWhereEscapeString(String str) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(str.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        DatabaseUtils.appendEscapedSQLString(this.mWhereClause, str);
    }

    public void setProjectionMap(Map<String, String> map) {
        this.mProjectionMap = map;
    }

    public void setCursorFactory(SQLiteDatabase.CursorFactory cursorFactory) {
        this.mFactory = cursorFactory;
    }

    public void setStrictProjectionMap(boolean z) {
        this.mStrictProjectionMap = z;
    }

    public static String buildQueryString(boolean z, String str, String[] strArr, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        } else if (TextUtils.isEmpty(str6) || sLimitPattern.matcher(str6).matches()) {
            StringBuilder sb = new StringBuilder(120);
            sb.append("SELECT ");
            if (z) {
                sb.append("DISTINCT ");
            }
            if (strArr == null || strArr.length == 0) {
                sb.append("* ");
            } else {
                appendColumns(sb, strArr);
            }
            sb.append("FROM ");
            sb.append(str);
            appendClause(sb, " WHERE ", str2);
            appendClause(sb, " GROUP BY ", str3);
            appendClause(sb, " HAVING ", str4);
            appendClause(sb, " ORDER BY ", str5);
            appendClause(sb, " LIMIT ", str6);
            return sb.toString();
        } else {
            throw new IllegalArgumentException("invalid LIMIT clauses:".concat(String.valueOf(str6)));
        }
    }

    private static void appendClause(StringBuilder sb, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str);
            sb.append(str2);
        }
    }

    private static void appendClauseEscapeClause(StringBuilder sb, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str);
            DatabaseUtils.appendEscapedSQLString(sb, str2);
        }
    }

    public static void appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (str != null) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(str);
            }
        }
        sb.append(' ');
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return query(sQLiteDatabase, strArr, str, strArr2, str2, str3, str4, null);
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        if (this.mTables == null) {
            return null;
        }
        String buildQuery = buildQuery(strArr, str, strArr2, str2, str3, str4, str5);
        if (Log.isLoggable("SQLiteQueryBuilder", 3)) {
            Log.d("SQLiteQueryBuilder", "Performing query: ".concat(String.valueOf(buildQuery)));
        }
        return sQLiteDatabase.rawQueryWithFactory(this.mFactory, buildQuery, strArr2, SQLiteDatabase.findEditTable(this.mTables));
    }

    public String buildQuery(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        String[] computeProjection = computeProjection(strArr);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = this.mWhereClause;
        boolean z = sb2 != null && sb2.length() > 0;
        if (z) {
            sb.append(this.mWhereClause.toString());
            sb.append(')');
        }
        if (str != null && str.length() > 0) {
            if (z) {
                sb.append(" AND ");
            }
            sb.append('(');
            sb.append(str);
            sb.append(')');
        }
        return buildQueryString(this.mDistinct, this.mTables, computeProjection, sb.toString(), str2, str3, str4, str5);
    }

    public String buildUnionSubQuery(String str, String[] strArr, Set<String> set, int i, String str2, String str3, String[] strArr2, String str4, String str5) {
        String[] strArr3 = strArr;
        int length = strArr3.length;
        String[] strArr4 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str6 = strArr3[i2];
            if (str6.equals(str)) {
                strArr4[i2] = "'" + str2 + "' AS " + str;
            } else {
                if (i2 > i) {
                    if (!set.contains(str6)) {
                        strArr4[i2] = "NULL AS ".concat(String.valueOf(str6));
                    }
                }
                strArr4[i2] = str6;
            }
        }
        return buildQuery(strArr4, str3, strArr2, str4, str5, null, null);
    }

    public String buildUnionQuery(String[] strArr, String str, String str2) {
        StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        int length = strArr.length;
        String str3 = this.mDistinct ? " UNION " : " UNION ALL ";
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(str3);
            }
            sb.append(strArr[i]);
        }
        appendClause(sb, " ORDER BY ", str);
        appendClause(sb, " LIMIT ", str2);
        return sb.toString();
    }

    private String[] computeProjection(String[] strArr) {
        int i = 0;
        if (strArr == null || strArr.length <= 0) {
            Map<String, String> map = this.mProjectionMap;
            if (map == null) {
                return null;
            }
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            String[] strArr2 = new String[entrySet.size()];
            for (Map.Entry next : entrySet) {
                if (!((String) next.getKey()).equals("_count")) {
                    strArr2[i] = (String) next.getValue();
                    i++;
                }
            }
            return strArr2;
        } else if (this.mProjectionMap == null) {
            return strArr;
        } else {
            String[] strArr3 = new String[strArr.length];
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                String str2 = this.mProjectionMap.get(str);
                if (str2 != null) {
                    strArr3[i] = str2;
                } else if (this.mStrictProjectionMap || (!str.contains(" AS ") && !str.contains(" as "))) {
                    throw new IllegalArgumentException("Invalid column " + strArr[i]);
                } else {
                    strArr3[i] = str;
                }
                i++;
            }
            return strArr3;
        }
    }
}
