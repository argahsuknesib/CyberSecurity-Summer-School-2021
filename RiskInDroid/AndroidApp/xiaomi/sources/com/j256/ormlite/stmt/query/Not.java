package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class Not implements Clause, NeedsFutureClause {
    private Comparison comparison = null;
    private Exists exists = null;

    public Not() {
    }

    public Not(Clause clause) {
        setMissingClause(clause);
    }

    public void setMissingClause(Clause clause) {
        if (this.comparison != null) {
            throw new IllegalArgumentException("NOT operation already has a comparison set");
        } else if (clause instanceof Comparison) {
            this.comparison = (Comparison) clause;
        } else if (clause instanceof Exists) {
            this.exists = (Exists) clause;
        } else {
            throw new IllegalArgumentException("NOT operation can only work with comparison SQL clauses, not ".concat(String.valueOf(clause)));
        }
    }

    public void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        if (this.comparison == null && this.exists == null) {
            throw new IllegalStateException("Clause has not been set in NOT operation");
        }
        if (this.comparison == null) {
            sb.append("(NOT ");
            this.exists.appendSql(databaseType, str, sb, list);
        } else {
            sb.append("(NOT ");
            if (str != null) {
                databaseType.appendEscapedEntityName(sb, str);
                sb.append('.');
            }
            databaseType.appendEscapedEntityName(sb, this.comparison.getColumnName());
            sb.append(' ');
            this.comparison.appendOperation(sb);
            this.comparison.appendValue(databaseType, sb, list);
        }
        sb.append(") ");
    }

    public String toString() {
        if (this.comparison == null) {
            return "NOT without comparison";
        }
        return "NOT comparison " + this.comparison;
    }
}
