package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;

@TargetApi(11)
@RequiresApi(11)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface NotificationBuilderWithBuilderAccessor {
    Notification build();

    Notification.Builder getBuilder();
}
