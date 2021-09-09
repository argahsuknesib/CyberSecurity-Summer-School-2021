package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedPreparedStmt<T, ID> extends BaseMappedQuery<T, ID> implements PreparedDelete<T>, PreparedQuery<T>, PreparedUpdate<T> {
    private final ArgumentHolder[] argHolders;
    private final boolean cacheStore;
    private final Long limit;
    private final StatementBuilder.StatementType type;

    public MappedPreparedStmt(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2, ArgumentHolder[] argumentHolderArr, Long l, StatementBuilder.StatementType statementType, boolean z) {
        super(tableInfo, str, fieldTypeArr, fieldTypeArr2);
        this.argHolders = argumentHolderArr;
        this.limit = l;
        this.type = statementType;
        this.cacheStore = z;
    }

    public CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType) throws SQLException {
        return compile(databaseConnection, statementType, -1);
    }

    public CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType, int i) throws SQLException {
        if (this.type == statementType) {
            return assignStatementArguments(databaseConnection.compileStatement(this.statement, statementType, this.argFieldTypes, i, this.cacheStore));
        }
        throw new SQLException("Could not compile this " + this.type + " statement since the caller is expecting a " + statementType + " statement.  Check your QueryBuilder methods.");
    }

    public String getStatement() {
        return this.statement;
    }

    public StatementBuilder.StatementType getType() {
        return this.type;
    }

    public void setArgumentHolderValue(int i, Object obj) throws SQLException {
        if (i >= 0) {
            ArgumentHolder[] argumentHolderArr = this.argHolders;
            if (argumentHolderArr.length > i) {
                argumentHolderArr[i].setValue(obj);
                return;
            }
            throw new SQLException("argument holder index " + i + " is not valid, only " + this.argHolders.length + " in statement (index starts at 0)");
        }
        throw new SQLException("argument holder index " + i + " must be >= 0");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.Object[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    private CompiledStatement assignStatementArguments(CompiledStatement compiledStatement) throws SQLException {
        SqlType sqlType;
        try {
            if (this.limit != null) {
                compiledStatement.setMaxRows(this.limit.intValue());
            }
            Object[] objArr = null;
            if (logger.isLevelEnabled(Log.Level.TRACE) && this.argHolders.length > 0) {
                objArr = new Object[this.argHolders.length];
            }
            for (int i = 0; i < this.argHolders.length; i++) {
                Object sqlArgValue = this.argHolders[i].getSqlArgValue();
                FieldType fieldType = this.argFieldTypes[i];
                if (fieldType == null) {
                    sqlType = this.argHolders[i].getSqlType();
                } else {
                    sqlType = fieldType.getSqlType();
                }
                compiledStatement.setObject(i, sqlArgValue, sqlType);
                if (objArr != null) {
                    objArr[i] = sqlArgValue;
                }
            }
            logger.debug("prepared statement '{}' with {} args", this.statement, Integer.valueOf(this.argHolders.length));
            if (objArr != null) {
                logger.trace("prepared statement arguments: {}", (Object) objArr);
            }
            return compiledStatement;
        } catch (Throwable th) {
            IOUtils.closeThrowSqlException(compiledStatement, "statement");
            throw th;
        }
    }
}
