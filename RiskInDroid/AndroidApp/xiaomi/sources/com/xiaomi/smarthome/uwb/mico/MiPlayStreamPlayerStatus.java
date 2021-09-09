package com.xiaomi.smarthome.uwb.mico;

import android.graphics.Bitmap;
import com.xiaomi.mico.api.model.Remote;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/MiPlayStreamPlayerStatus;", "Lcom/xiaomi/mico/api/model/Remote$Response$PlayerStatus;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MiPlayStreamPlayerStatus extends Remote.Response.PlayerStatus {
    private Bitmap bitmap;

    public MiPlayStreamPlayerStatus(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }
}
