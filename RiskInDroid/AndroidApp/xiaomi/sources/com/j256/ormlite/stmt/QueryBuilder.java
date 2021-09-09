package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.query.ColumnNameOrRawSql;
import com.j256.ormlite.stmt.query.OrderBy;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryBuilder<T, ID> extends StatementBuilder<T, ID> {
    private String alias;
    private String countOfQuery;
    private boolean distinct;
    private List<ColumnNameOrRawSql> groupByList;
    private String having;
    private final FieldType idField;
    private boolean isInnerQuery;
    private List<JoinInfo> joinList;
    private Long limit;
    private Long offset;
    private List<OrderBy> orderByList;
    private FieldType[] resultFieldTypes;
    private boolean selectIdColumn;
    private List<ColumnNameOrRawSql> selectList;

    public QueryBuilder(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao) {
        super(databaseType, tableInfo, dao, StatementBuilder.StatementType.SELECT);
        this.idField = tableInfo.getIdField();
        this.selectIdColumn = this.idField != null;
    }

    /* access modifiers changed from: package-private */
    public void enableInnerQuery() {
        this.isInnerQuery = true;
    }

    /* access modifiers changed from: package-private */
    public int getSelectColumnCount() {
        if (this.countOfQuery != null) {
            return 1;
        }
        List<ColumnNameOrRawSql> list = this.selectList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* access modifiers changed from: package-private */
    public String getSelectColumnsAsString() {
        if (this.countOfQuery != null) {
            return "COUNT(" + this.countOfQuery + ")";
        }
        List<ColumnNameOrRawSql> list = this.selectList;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public PreparedQuery<T> prepare() throws SQLException {
        return super.prepareStatement(this.limit, this.selectList == null);
    }

    public QueryBuilder<T, ID> selectColumns(String... strArr) {
        for (String addSelectColumnToList : strArr) {
            addSelectColumnToList(addSelectColumnToList);
        }
        return this;
    }

    public QueryBuilder<T, ID> selectColumns(Iterable<String> iterable) {
        for (String addSelectColumnToList : iterable) {
            addSelectColumnToList(addSelectColumnToList);
        }
        return this;
    }

    public QueryBuilder<T, ID> selectRaw(String... strArr) {
        for (String withRawSql : strArr) {
            addSelectToList(ColumnNameOrRawSql.withRawSql(withRawSql));
        }
        return this;
    }

    public QueryBuilder<T, ID> groupBy(String str) {
        if (!verifyColumnName(str).isForeignCollection()) {
            addGroupBy(ColumnNameOrRawSql.withColumnName(str));
            return this;
        }
        throw new IllegalArgumentException("Can't groupBy foreign collection field: ".concat(String.valueOf(str)));
    }

    public QueryBuilder<T, ID> groupByRaw(String str) {
        addGroupBy(ColumnNameOrRawSql.withRawSql(str));
        return this;
    }

    public QueryBuilder<T, ID> orderBy(String str, boolean z) {
        if (!verifyColumnName(str).isForeignCollection()) {
            addOrderBy(new OrderBy(str, z));
            return this;
        }
        throw new IllegalArgumentException("Can't orderBy foreign collection field: ".concat(String.valueOf(str)));
    }

    public QueryBuilder<T, ID> orderByRaw(String str) {
        addOrderBy(new OrderBy(str, (ArgumentHolder[]) null));
        return this;
    }

    public QueryBuilder<T, ID> orderByRaw(String str, ArgumentHolder... argumentHolderArr) {
        addOrderBy(new OrderBy(str, argumentHolderArr));
        return this;
    }

    public QueryBuilder<T, ID> distinct() {
        this.distinct = true;
        this.selectIdColumn = false;
        return this;
    }

    public QueryBuilder<T, ID> limit(Long l) {
        this.limit = l;
        return this;
    }

    public QueryBuilder<T, ID> offset(Long l) throws SQLException {
        if (this.databaseType.isOffsetSqlSupported()) {
            this.offset = l;
            return this;
        }
        throw new SQLException("Offset is not supported by this database");
    }

    public QueryBuilder<T, ID> setCountOf(boolean z) {
        return setCountOf("*");
    }

    public QueryBuilder<T, ID> setCountOf(String str) {
        this.countOfQuery = str;
        return this;
    }

    public QueryBuilder<T, ID> having(String str) {
        this.having = str;
        return this;
    }

    public QueryBuilder<T, ID> join(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.INNER, null, null, queryBuilder, JoinWhereOperation.AND);
        return this;
    }

    public QueryBuilder<T, ID> join(QueryBuilder<?, ?> queryBuilder, JoinType joinType, JoinWhereOperation joinWhereOperation) throws SQLException {
        addJoinInfo(joinType, null, null, queryBuilder, joinWhereOperation);
        return this;
    }

    public QueryBuilder<T, ID> joinOr(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.INNER, null, null, queryBuilder, JoinWhereOperation.OR);
        return this;
    }

    public QueryBuilder<T, ID> leftJoin(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.LEFT, null, null, queryBuilder, JoinWhereOperation.AND);
        return this;
    }

    public QueryBuilder<T, ID> leftJoinOr(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.LEFT, null, null, queryBuilder, JoinWhereOperation.OR);
        return this;
    }

    public QueryBuilder<T, ID> join(String str, String str2, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.INNER, str, str2, queryBuilder, JoinWhereOperation.AND);
        return this;
    }

    public QueryBuilder<T, ID> join(String str, String str2, QueryBuilder<?, ?> queryBuilder, JoinType joinType, JoinWhereOperation joinWhereOperation) throws SQLException {
        addJoinInfo(joinType, str, str2, queryBuilder, joinWhereOperation);
        return this;
    }

    public List<T> query() throws SQLException {
        return this.dao.query(prepare());
    }

    public GenericRawResults<String[]> queryRaw() throws SQLException {
        return this.dao.queryRaw(prepareStatementString(), new String[0]);
    }

    public T queryForFirst() throws SQLException {
        return this.dao.queryForFirst(prepare());
    }

    public String[] queryRawFirst() throws SQLException {
        return this.dao.queryRaw(prepareStatementString(), new String[0]).getFirstResult();
    }

    public CloseableIterator<T> iterator() throws SQLException {
        return this.dao.iterator(prepare());
    }

    public long countOf() throws SQLException {
        String str = this.countOfQuery;
        try {
            setCountOf(true);
            return this.dao.countOf(prepare());
        } finally {
            setCountOf(str);
        }
    }

    /* JADX INFO: finally extract failed */
    public long countOf(String str) throws SQLException {
        String str2 = this.countOfQuery;
        try {
            setCountOf(str);
            long countOf = this.dao.countOf(prepare());
            setCountOf(str2);
            return countOf;
        } catch (Throwable th) {
            setCountOf(str2);
            throw th;
        }
    }

    public QueryBuilder<T, ID> setAlias(String str) {
        this.alias = str;
        return this;
    }

    public void reset() {
        super.reset();
        this.distinct = false;
        this.selectIdColumn = this.idField != null;
        List<ColumnNameOrRawSql> list = this.selectList;
        if (list != null) {
            list.clear();
            this.selectList = null;
        }
        List<OrderBy> list2 = this.orderByList;
        if (list2 != null) {
            list2.clear();
            this.orderByList = null;
        }
        List<ColumnNameOrRawSql> list3 = this.groupByList;
        if (list3 != null) {
            list3.clear();
            this.groupByList = null;
        }
        this.isInnerQuery = false;
        this.countOfQuery = null;
        this.having = null;
        this.limit = null;
        this.offset = null;
        List<JoinInfo> list4 = this.joinList;
        if (list4 != null) {
            list4.clear();
            this.joinList = null;
        }
        this.addTableName = false;
        this.alias = null;
    }

    /* access modifiers changed from: protected */
    public void appendStatementStart(StringBuilder sb, List<ArgumentHolder> list) {
        if (this.joinList == null) {
            setAddTableName(false);
        } else {
            setAddTableName(true);
        }
        sb.append("SELECT ");
        if (this.databaseType.isLimitAfterSelect()) {
            appendLimit(sb);
        }
        if (this.distinct) {
            sb.append("DISTINCT ");
        }
        if (this.countOfQuery == null) {
            appendSelects(sb);
        } else {
            this.type = StatementBuilder.StatementType.SELECT_LONG;
            sb.append("COUNT(");
            sb.append(this.countOfQuery);
            sb.append(") ");
        }
        sb.append("FROM ");
        this.databaseType.appendEscapedEntityName(sb, this.tableName);
        if (this.alias != null) {
            appendAlias(sb);
        }
        sb.append(' ');
        if (this.joinList != null) {
            appendJoinSql(sb);
        }
    }

    /* access modifiers changed from: protected */
    public FieldType[] getResultFieldTypes() {
        return this.resultFieldTypes;
    }

    /* access modifiers changed from: protected */
    public boolean appendWhereStatement(StringBuilder sb, List<ArgumentHolder> list, StatementBuilder.WhereOperation whereOperation) throws SQLException {
        StatementBuilder.WhereOperation whereOperation2;
        boolean z = whereOperation == StatementBuilder.WhereOperation.FIRST;
        if (this.where != null) {
            z = super.appendWhereStatement(sb, list, whereOperation);
        }
        List<JoinInfo> list2 = this.joinList;
        if (list2 != null) {
            for (JoinInfo next : list2) {
                if (z) {
                    whereOperation2 = StatementBuilder.WhereOperation.FIRST;
                } else {
                    whereOperation2 = next.operation.whereOperation;
                }
                z = next.queryBuilder.appendWhereStatement(sb, list, whereOperation2);
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void appendStatementEnd(StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        maybeAppendGroupBys(sb, true);
        maybeAppendHaving(sb);
        maybeAppendOrderBys(sb, list, true);
        if (!this.databaseType.isLimitAfterSelect()) {
            appendLimit(sb);
        }
        appendOffset(sb);
        setAddTableName(false);
    }

    /* access modifiers changed from: protected */
    public boolean shouldPrependTableNameToColumns() {
        return this.joinList != null;
    }

    /* access modifiers changed from: protected */
    public void appendTableQualifier(StringBuilder sb) {
        this.databaseType.appendEscapedEntityName(sb, getTableName());
    }

    /* access modifiers changed from: protected */
    public String getTableName() {
        String str = this.alias;
        return str == null ? this.tableName : str;
    }

    private void addOrderBy(OrderBy orderBy) {
        if (this.orderByList == null) {
            this.orderByList = new ArrayList();
        }
        this.orderByList.add(orderBy);
    }

    private void addGroupBy(ColumnNameOrRawSql columnNameOrRawSql) {
        if (this.groupByList == null) {
            this.groupByList = new ArrayList();
        }
        this.groupByList.add(columnNameOrRawSql);
        this.selectIdColumn = false;
    }

    private void setAddTableName(boolean z) {
        this.addTableName = z;
        List<JoinInfo> list = this.joinList;
        if (list != null) {
            for (JoinInfo joinInfo : list) {
                joinInfo.queryBuilder.setAddTableName(z);
            }
        }
    }

    private void addJoinInfo(JoinType joinType, String str, String str2, QueryBuilder<?, ?> queryBuilder, JoinWhereOperation joinWhereOperation) throws SQLException {
        JoinInfo joinInfo = new JoinInfo(joinType, queryBuilder, joinWhereOperation);
        if (str == null) {
            matchJoinedFields(joinInfo, queryBuilder);
        } else {
            matchJoinedFieldsByName(joinInfo, str, str2, queryBuilder);
        }
        if (this.joinList == null) {
            this.joinList = new ArrayList();
        }
        this.joinList.add(joinInfo);
    }

    private void matchJoinedFieldsByName(JoinInfo joinInfo, String str, String str2, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        joinInfo.localField = this.tableInfo.getFieldTypeByColumnName(str);
        if (joinInfo.localField != null) {
            joinInfo.remoteField = queryBuilder.tableInfo.getFieldTypeByColumnName(str2);
            if (joinInfo.remoteField == null) {
                throw new SQLException("Could not find field in " + queryBuilder.tableInfo.getDataClass() + " that has column-name '" + str2 + "'");
            }
            return;
        }
        throw new SQLException("Could not find field in " + this.tableInfo.getDataClass() + " that has column-name '" + str + "'");
    }

    private void matchJoinedFields(JoinInfo joinInfo, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        FieldType[] fieldTypes = this.tableInfo.getFieldTypes();
        int length = fieldTypes.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            FieldType fieldType = fieldTypes[i2];
            FieldType foreignRefField = fieldType.getForeignRefField();
            if (!fieldType.isForeign() || !foreignRefField.equals(queryBuilder.tableInfo.getIdField())) {
                i2++;
            } else {
                joinInfo.localField = fieldType;
                joinInfo.remoteField = foreignRefField;
                return;
            }
        }
        FieldType[] fieldTypes2 = queryBuilder.tableInfo.getFieldTypes();
        int length2 = fieldTypes2.length;
        while (i < length2) {
            FieldType fieldType2 = fieldTypes2[i];
            if (!fieldType2.isForeign() || !fieldType2.getForeignIdField().equals(this.idField)) {
                i++;
            } else {
                joinInfo.localField = this.idField;
                joinInfo.remoteField = fieldType2;
                return;
            }
        }
        throw new SQLException("Could not find a foreign " + this.tableInfo.getDataClass() + " field in " + queryBuilder.tableInfo.getDataClass() + " or vice versa");
    }

    private void addSelectColumnToList(String str) {
        verifyColumnName(str);
        addSelectToList(ColumnNameOrRawSql.withColumnName(str));
    }

    private void addSelectToList(ColumnNameOrRawSql columnNameOrRawSql) {
        if (this.selectList == null) {
            this.selectList = new ArrayList();
        }
        this.selectList.add(columnNameOrRawSql);
    }

    private void appendJoinSql(StringBuilder sb) {
        for (JoinInfo next : this.joinList) {
            sb.append(next.type.sql);
            sb.append(" JOIN ");
            this.databaseType.appendEscapedEntityName(sb, next.queryBuilder.tableName);
            if (next.queryBuilder.alias != null) {
                next.queryBuilder.appendAlias(sb);
            }
            sb.append(" ON ");
            appendTableQualifier(sb);
            sb.append('.');
            this.databaseType.appendEscapedEntityName(sb, next.localField.getColumnName());
            sb.append(" = ");
            next.queryBuilder.appendTableQualifier(sb);
            sb.append('.');
            this.databaseType.appendEscapedEntityName(sb, next.remoteField.getColumnName());
            sb.append(' ');
            if (next.queryBuilder.joinList != null) {
                next.queryBuilder.appendJoinSql(sb);
            }
        }
    }

    private void appendSelects(StringBuilder sb) {
        this.type = StatementBuilder.StatementType.SELECT;
        List<ColumnNameOrRawSql> list = this.selectList;
        if (list == null) {
            if (this.addTableName) {
                appendTableQualifier(sb);
                sb.append('.');
            }
            sb.append("* ");
            this.resultFieldTypes = this.tableInfo.getFieldTypes();
            return;
        }
        boolean z = this.isInnerQuery;
        ArrayList arrayList = new ArrayList(list.size() + 1);
        boolean z2 = true;
        for (ColumnNameOrRawSql next : this.selectList) {
            if (next.getRawSql() != null) {
                this.type = StatementBuilder.StatementType.SELECT_RAW;
                if (z2) {
                    z2 = false;
                } else {
                    sb.append(", ");
                }
                sb.append(next.getRawSql());
            } else {
                FieldType fieldTypeByColumnName = this.tableInfo.getFieldTypeByColumnName(next.getColumnName());
                if (fieldTypeByColumnName.isForeignCollection()) {
                    arrayList.add(fieldTypeByColumnName);
                } else {
                    if (z2) {
                        z2 = false;
                    } else {
                        sb.append(", ");
                    }
                    appendFieldColumnName(sb, fieldTypeByColumnName, arrayList);
                    if (fieldTypeByColumnName == this.idField) {
                        z = true;
                    }
                }
            }
        }
        if (this.type != StatementBuilder.StatementType.SELECT_RAW) {
            if (!z && this.selectIdColumn) {
                if (!z2) {
                    sb.append(',');
                }
                appendFieldColumnName(sb, this.idField, arrayList);
            }
            this.resultFieldTypes = (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
        }
        sb.append(' ');
    }

    private void appendFieldColumnName(StringBuilder sb, FieldType fieldType, List<FieldType> list) {
        appendColumnName(sb, fieldType.getColumnName());
        if (list != null) {
            list.add(fieldType);
        }
    }

    private void appendLimit(StringBuilder sb) {
        if (this.limit != null && this.databaseType.isLimitSqlSupported()) {
            this.databaseType.appendLimitValue(sb, this.limit.longValue(), this.offset);
        }
    }

    private void appendOffset(StringBuilder sb) throws SQLException {
        if (this.offset != null) {
            if (!this.databaseType.isOffsetLimitArgument()) {
                this.databaseType.appendOffsetValue(sb, this.offset.longValue());
            } else if (this.limit == null) {
                throw new SQLException("If the offset is specified, limit must also be specified with this database");
            }
        }
    }

    private boolean maybeAppendGroupBys(StringBuilder sb, boolean z) {
        List<ColumnNameOrRawSql> list = this.groupByList;
        if (list != null && !list.isEmpty()) {
            appendGroupBys(sb, z);
            z = false;
        }
        List<JoinInfo> list2 = this.joinList;
        if (list2 != null) {
            for (JoinInfo joinInfo : list2) {
                z = joinInfo.queryBuilder.maybeAppendGroupBys(sb, z);
            }
        }
        return z;
    }

    private void appendGroupBys(StringBuilder sb, boolean z) {
        if (z) {
            sb.append("GROUP BY ");
        }
        for (ColumnNameOrRawSql next : this.groupByList) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            if (next.getRawSql() == null) {
                appendColumnName(sb, next.getColumnName());
            } else {
                sb.append(next.getRawSql());
            }
        }
        sb.append(' ');
    }

    private boolean maybeAppendOrderBys(StringBuilder sb, List<ArgumentHolder> list, boolean z) {
        List<OrderBy> list2 = this.orderByList;
        if (list2 != null && !list2.isEmpty()) {
            appendOrderBys(sb, z, list);
            z = false;
        }
        List<JoinInfo> list3 = this.joinList;
        if (list3 != null) {
            for (JoinInfo joinInfo : list3) {
                z = joinInfo.queryBuilder.maybeAppendOrderBys(sb, list, z);
            }
        }
        return z;
    }

    private void appendOrderBys(StringBuilder sb, boolean z, List<ArgumentHolder> list) {
        if (z) {
            sb.append("ORDER BY ");
        }
        for (OrderBy next : this.orderByList) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            if (next.getRawSql() == null) {
                appendColumnName(sb, next.getColumnName());
                if (!next.isAscending()) {
                    sb.append(" DESC");
                }
            } else {
                sb.append(next.getRawSql());
                if (next.getOrderByArgs() != null) {
                    for (ArgumentHolder add : next.getOrderByArgs()) {
                        list.add(add);
                    }
                }
            }
        }
        sb.append(' ');
    }

    private void appendColumnName(StringBuilder sb, String str) {
        if (this.addTableName) {
            appendTableQualifier(sb);
            sb.append('.');
        }
        this.databaseType.appendEscapedEntityName(sb, str);
    }

    private void maybeAppendHaving(StringBuilder sb) {
        if (this.having != null) {
            sb.append("HAVING ");
            sb.append(this.having);
            sb.append(' ');
        }
    }

    private void appendAlias(StringBuilder sb) {
        sb.append(" AS ");
        this.databaseType.appendEscapedEntityName(sb, this.alias);
    }

    static class JoinInfo {
        FieldType localField;
        JoinWhereOperation operation;
        final QueryBuilder<?, ?> queryBuilder;
        FieldType remoteField;
        final JoinType type;

        public JoinInfo(JoinType joinType, QueryBuilder<?, ?> queryBuilder2, JoinWhereOperation joinWhereOperation) {
            this.type = joinType;
            this.queryBuilder = queryBuilder2;
            this.operation = joinWhereOperation;
        }
    }

    public static class InternalQueryBuilderWrapper {
        private final QueryBuilder<?, ?> queryBuilder;

        InternalQueryBuilderWrapper(QueryBuilder<?, ?> queryBuilder2) {
            this.queryBuilder = queryBuilder2;
        }

        public void appendStatementString(StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
            this.queryBuilder.appendStatementString(sb, list);
        }

        public FieldType[] getResultFieldTypes() {
            return this.queryBuilder.getResultFieldTypes();
        }
    }

    public enum JoinType {
        INNER("INNER"),
        LEFT("LEFT");
        
        final String sql;

        private JoinType(String str) {
            this.sql = str;
        }
    }

    public enum JoinWhereOperation {
        AND(StatementBuilder.WhereOperation.AND),
        OR(StatementBuilder.WhereOperation.OR);
        
        final StatementBuilder.WhereOperation whereOperation;

        private JoinWhereOperation(StatementBuilder.WhereOperation whereOperation2) {
            this.whereOperation = whereOperation2;
        }
    }
}
