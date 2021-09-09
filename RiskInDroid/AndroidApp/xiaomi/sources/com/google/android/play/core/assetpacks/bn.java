package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import com.google.android.play.core.internal.ce;
import com.google.android.play.core.tasks.Tasks;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

final class bn {

    /* renamed from: a  reason: collision with root package name */
    private final ce<x> f3658a;

    bn(ce<x> ceVar) {
        this.f3658a = ceVar;
    }

    /* access modifiers changed from: package-private */
    public final InputStream a(int i, String str, String str2, int i2) {
        try {
            return new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor) Tasks.await(this.f3658a.a().b(i, str, str2, i2)));
        } catch (ExecutionException e) {
            throw new by(String.format("Error opening chunk file, session %s packName %s sliceId %s, chunkNumber %s", Integer.valueOf(i), str, str2, Integer.valueOf(i2)), e, i);
        } catch (InterruptedException e2) {
            throw new by("Extractor was interrupted while waiting for chunk file.", e2, i);
        }
    }
}
