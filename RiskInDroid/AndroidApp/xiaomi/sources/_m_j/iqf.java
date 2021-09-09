package _m_j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class iqf {
    public static NinePatchDrawable O000000o(Resources resources, Bitmap bitmap, int i, int i2, int i3, int i4) {
        return new NinePatchDrawable(resources, bitmap, O000000o(i, i2, i3, i4).array(), new Rect(), null);
    }

    private static ByteBuffer O000000o(int i, int i2, int i3, int i4) {
        ByteBuffer order = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) 2);
        order.put((byte) 2);
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(i2);
        order.putInt(i4);
        order.putInt(i);
        order.putInt(i3);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        return order;
    }
}
