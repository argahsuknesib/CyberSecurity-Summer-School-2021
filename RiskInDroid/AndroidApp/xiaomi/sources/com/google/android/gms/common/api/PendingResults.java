package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public final class PendingResults {

    static final class zza<R extends Result> extends BasePendingResult<R> {
        private final R zzdl;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.zzdl = r;
        }

        public final R createFailedResult(Status status) {
            if (status.getStatusCode() == this.zzdl.getStatus().getStatusCode()) {
                return this.zzdl;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    static final class zzb<R extends Result> extends BasePendingResult<R> {
        private final R zzdm;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.zzdm = r;
        }

        public final R createFailedResult(Status status) {
            return this.zzdm;
        }
    }

    static final class zzc<R extends Result> extends BasePendingResult<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public final R createFailedResult(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    @KeepForSdk
    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.cancel();
        return statusPendingResult;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        Preconditions.checkNotNull(r, "Result must not be null");
        Preconditions.checkArgument(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zza zza2 = new zza(r);
        zza2.cancel();
        return zza2;
    }

    @KeepForSdk
    public static <R extends Result> PendingResult<R> immediateFailedResult(R r, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(r, "Result must not be null");
        Preconditions.checkArgument(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        zzb zzb2 = new zzb(googleApiClient, r);
        zzb2.setResult(r);
        return zzb2;
    }

    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        Preconditions.checkNotNull(r, "Result must not be null");
        zzc zzc2 = new zzc(null);
        zzc2.setResult(r);
        return new OptionalPendingResultImpl(zzc2);
    }

    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(Result result, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(result, "Result must not be null");
        zzc zzc2 = new zzc(googleApiClient);
        zzc2.setResult(result);
        return new OptionalPendingResultImpl(zzc2);
    }

    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(Status status) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }

    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(Status status, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }
}
