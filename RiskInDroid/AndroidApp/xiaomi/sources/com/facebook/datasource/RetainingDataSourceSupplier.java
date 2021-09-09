package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class RetainingDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    private Supplier<DataSource<T>> mCurrentDataSourceSupplier = null;
    private final Set<RetainingDataSource> mDataSources = Collections.newSetFromMap(new WeakHashMap());

    public DataSource<T> get() {
        RetainingDataSource retainingDataSource = new RetainingDataSource();
        retainingDataSource.setSupplier(this.mCurrentDataSourceSupplier);
        this.mDataSources.add(retainingDataSource);
        return retainingDataSource;
    }

    public void replaceSupplier(Supplier<DataSource<T>> supplier) {
        this.mCurrentDataSourceSupplier = supplier;
        for (RetainingDataSource next : this.mDataSources) {
            if (!next.isClosed()) {
                next.setSupplier(supplier);
            }
        }
    }

    static class RetainingDataSource<T> extends AbstractDataSource<T> {
        private DataSource<T> mDataSource;

        public void onDataSourceFailed(DataSource<T> dataSource) {
        }

        private RetainingDataSource() {
            this.mDataSource = null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
            if (r4 == null) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
            r4.subscribe(new com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource.InternalDataSubscriber(r3, null), com.facebook.common.executors.CallerThreadExecutor.getInstance());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
            closeSafely(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
            return;
         */
        public void setSupplier(Supplier<DataSource<T>> supplier) {
            if (!isClosed()) {
                DataSource<T> dataSource = supplier != null ? supplier.get() : null;
                synchronized (this) {
                    if (isClosed()) {
                        closeSafely(dataSource);
                    } else {
                        DataSource<T> dataSource2 = this.mDataSource;
                        this.mDataSource = dataSource;
                    }
                }
            }
        }

        public synchronized T getResult() {
            if (this.mDataSource == null) {
                return null;
            }
            return this.mDataSource.getResult();
        }

        public synchronized boolean hasResult() {
            return this.mDataSource != null && this.mDataSource.hasResult();
        }

        public boolean close() {
            synchronized (this) {
                if (!super.close()) {
                    return false;
                }
                DataSource<T> dataSource = this.mDataSource;
                this.mDataSource = null;
                closeSafely(dataSource);
                return true;
            }
        }

        public void onDataSourceNewResult(DataSource<T> dataSource) {
            if (dataSource == this.mDataSource) {
                setResult(null, false);
            }
        }

        public void onDatasourceProgress(DataSource<T> dataSource) {
            if (dataSource == this.mDataSource) {
                setProgress(dataSource.getProgress());
            }
        }

        private static <T> void closeSafely(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }

        class InternalDataSubscriber implements DataSubscriber<T> {
            public void onCancellation(DataSource<T> dataSource) {
            }

            private InternalDataSubscriber() {
            }

            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    RetainingDataSource.this.onDataSourceNewResult(dataSource);
                } else if (dataSource.isFinished()) {
                    RetainingDataSource.this.onDataSourceFailed(dataSource);
                }
            }

            public void onFailure(DataSource<T> dataSource) {
                RetainingDataSource.this.onDataSourceFailed(dataSource);
            }

            public void onProgressUpdate(DataSource<T> dataSource) {
                RetainingDataSource.this.onDatasourceProgress(dataSource);
            }
        }
    }
}
