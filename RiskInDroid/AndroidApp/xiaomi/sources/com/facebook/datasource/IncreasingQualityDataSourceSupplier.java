package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IncreasingQualityDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

    private IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> list) {
        Preconditions.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mDataSourceSuppliers = list;
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list) {
        return new IncreasingQualityDataSourceSupplier<>(list);
    }

    public DataSource<T> get() {
        return new IncreasingQualityDataSource();
    }

    public int hashCode() {
        return this.mDataSourceSuppliers.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IncreasingQualityDataSourceSupplier)) {
            return false;
        }
        return Objects.equal(this.mDataSourceSuppliers, ((IncreasingQualityDataSourceSupplier) obj).mDataSourceSuppliers);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("list", this.mDataSourceSuppliers).toString();
    }

    class IncreasingQualityDataSource extends AbstractDataSource<T> {
        private ArrayList<DataSource<T>> mDataSources;
        private Throwable mDelayedError;
        private final AtomicInteger mFinishedDataSources = new AtomicInteger(0);
        private int mIndexOfDataSourceWithResult;
        private final int mNumberOfDataSources;

        public IncreasingQualityDataSource() {
            int i = 0;
            int size = IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.size();
            this.mNumberOfDataSources = size;
            this.mIndexOfDataSourceWithResult = size;
            this.mDataSources = new ArrayList<>(size);
            while (i < size) {
                DataSource dataSource = (DataSource) IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.get(i).get();
                this.mDataSources.add(dataSource);
                dataSource.subscribe(new InternalDataSubscriber(i), CallerThreadExecutor.getInstance());
                if (!dataSource.hasResult()) {
                    i++;
                } else {
                    return;
                }
            }
        }

        private synchronized DataSource<T> getDataSource(int i) {
            if (this.mDataSources == null || i >= this.mDataSources.size()) {
                return null;
            }
            return this.mDataSources.get(i);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            return null;
         */
        private synchronized DataSource<T> getAndClearDataSource(int i) {
            if (this.mDataSources != null && i < this.mDataSources.size()) {
                return this.mDataSources.set(i, null);
            }
        }

        private synchronized DataSource<T> getDataSourceWithResult() {
            return getDataSource(this.mIndexOfDataSourceWithResult);
        }

        public synchronized T getResult() {
            DataSource dataSourceWithResult = getDataSourceWithResult();
            if (dataSourceWithResult == null) {
                return null;
            }
            return dataSourceWithResult.getResult();
        }

        public synchronized boolean hasResult() {
            DataSource dataSourceWithResult;
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null && dataSourceWithResult.hasResult();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
            if (r1 >= r0.size()) goto L_0x0024;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
            closeSafely(r0.get(r1));
            r1 = r1 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
            if (r0 == null) goto L_?;
         */
        public boolean close() {
            synchronized (this) {
                int i = 0;
                if (!super.close()) {
                    return false;
                }
                ArrayList<DataSource<T>> arrayList = this.mDataSources;
                this.mDataSources = null;
            }
        }

        public void onDataSourceNewResult(int i, DataSource<T> dataSource) {
            maybeSetIndexOfDataSourceWithResult(i, dataSource, dataSource.isFinished());
            if (dataSource == getDataSourceWithResult()) {
                setResult(null, i == 0 && dataSource.isFinished());
            }
            maybeSetFailure();
        }

        public void onDataSourceFailed(int i, DataSource<T> dataSource) {
            closeSafely(tryGetAndClearDataSource(i, dataSource));
            if (i == 0) {
                this.mDelayedError = dataSource.getFailureCause();
            }
            maybeSetFailure();
        }

        private void maybeSetFailure() {
            Throwable th;
            if (this.mFinishedDataSources.incrementAndGet() == this.mNumberOfDataSources && (th = this.mDelayedError) != null) {
                setFailure(th);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
            if (r0 <= r4) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
            closeSafely(getAndClearDataSource(r0));
            r0 = r0 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
            return;
         */
        private void maybeSetIndexOfDataSourceWithResult(int i, DataSource<T> dataSource, boolean z) {
            synchronized (this) {
                int i2 = this.mIndexOfDataSourceWithResult;
                int i3 = this.mIndexOfDataSourceWithResult;
                if (dataSource == getDataSource(i)) {
                    if (i != this.mIndexOfDataSourceWithResult) {
                        if (getDataSourceWithResult() != null) {
                            if (!z || i >= this.mIndexOfDataSourceWithResult) {
                                i = i3;
                            }
                        }
                        this.mIndexOfDataSourceWithResult = i;
                    }
                }
            }
        }

        private synchronized DataSource<T> tryGetAndClearDataSource(int i, DataSource<T> dataSource) {
            if (dataSource == getDataSourceWithResult()) {
                return null;
            }
            if (dataSource != getDataSource(i)) {
                return dataSource;
            }
            return getAndClearDataSource(i);
        }

        private void closeSafely(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }

        class InternalDataSubscriber implements DataSubscriber<T> {
            private int mIndex;

            public void onCancellation(DataSource<T> dataSource) {
            }

            public InternalDataSubscriber(int i) {
                this.mIndex = i;
            }

            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    IncreasingQualityDataSource.this.onDataSourceNewResult(this.mIndex, dataSource);
                } else if (dataSource.isFinished()) {
                    IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, dataSource);
                }
            }

            public void onFailure(DataSource<T> dataSource) {
                IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, dataSource);
            }

            public void onProgressUpdate(DataSource<T> dataSource) {
                if (this.mIndex == 0) {
                    IncreasingQualityDataSource.this.setProgress(dataSource.getProgress());
                }
            }
        }
    }
}
