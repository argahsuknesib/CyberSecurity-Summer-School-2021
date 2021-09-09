package net.sqlcipher.database;

public class SQLiteQueryStats {
    long largestIndividualRowSize = 0;
    long totalQueryResultSize = 0;

    public SQLiteQueryStats(long j, long j2) {
        this.totalQueryResultSize = j;
        this.largestIndividualRowSize = j2;
    }

    public long getTotalQueryResultSize() {
        return this.totalQueryResultSize;
    }

    public long getLargestIndividualRowSize() {
        return this.largestIndividualRowSize;
    }
}
