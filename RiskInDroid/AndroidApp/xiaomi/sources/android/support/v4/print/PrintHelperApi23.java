package android.support.v4.print;

import android.annotation.TargetApi;
import android.content.Context;
import android.print.PrintAttributes;
import android.support.annotation.RequiresApi;

@TargetApi(23)
@RequiresApi(23)
class PrintHelperApi23 extends PrintHelperApi20 {
    /* access modifiers changed from: protected */
    public PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
        PrintAttributes.Builder copyAttributes = super.copyAttributes(printAttributes);
        if (printAttributes.getDuplexMode() != 0) {
            copyAttributes.setDuplexMode(printAttributes.getDuplexMode());
        }
        return copyAttributes;
    }

    PrintHelperApi23(Context context) {
        super(context);
        this.mIsMinMarginsHandlingCorrect = false;
    }
}
