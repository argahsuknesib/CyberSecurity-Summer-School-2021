package com.xiaomi.accountsdk.account.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.account.exception.NeedVerificationException;
import com.xiaomi.accountsdk.request.SimpleRequest;

public class Step1LoginContext implements Parcelable {
    public static final Parcelable.Creator<Step1LoginContext> CREATOR = new Parcelable.Creator<Step1LoginContext>() {
        /* class com.xiaomi.accountsdk.account.data.Step1LoginContext.AnonymousClass1 */

        public final Step1LoginContext createFromParcel(Parcel parcel) {
            return new Step1LoginContext(parcel);
        }

        public final Step1LoginContext[] newArray(int i) {
            return new Step1LoginContext[i];
        }
    };
    private LoginContext mLoginContext;
    private NextStep mNextStep;

    public interface LoginContext {
        String getUserId();
    }

    public enum NextStep {
        NONE,
        NOTIFICATION,
        VERIFICATION
    }

    public int describeContents() {
        return 0;
    }

    public static class NextNotificationLoginContext implements LoginContext {
        public SimpleRequest.StringContent loginContent;
        public String notificationUrl;
        public String userId;

        public String getUserId() {
            return this.userId;
        }
    }

    public static class NextVerificationLoginContext implements LoginContext {
        public MetaLoginData metaLoginData;
        public String step1Token;
        public String userId;

        public String getUserId() {
            return this.userId;
        }
    }

    public static class NextNoneLoginContext implements LoginContext {
        public AccountInfo accountInfo;

        public String getUserId() {
            return this.accountInfo.getUserId();
        }
    }

    public Step1LoginContext(AccountInfo accountInfo) {
        this.mNextStep = NextStep.NONE;
        NextNoneLoginContext nextNoneLoginContext = new NextNoneLoginContext();
        nextNoneLoginContext.accountInfo = accountInfo;
        this.mLoginContext = nextNoneLoginContext;
    }

    public Step1LoginContext(Exception exc) {
        if (exc instanceof NeedNotificationException) {
            NeedNotificationException needNotificationException = (NeedNotificationException) exc;
            this.mNextStep = NextStep.NOTIFICATION;
            NextNotificationLoginContext nextNotificationLoginContext = new NextNotificationLoginContext();
            nextNotificationLoginContext.userId = needNotificationException.getUserId();
            nextNotificationLoginContext.notificationUrl = needNotificationException.getNotificationUrl();
            nextNotificationLoginContext.loginContent = needNotificationException.getLoginContent();
            this.mLoginContext = nextNotificationLoginContext;
        } else if (exc instanceof NeedVerificationException) {
            NeedVerificationException needVerificationException = (NeedVerificationException) exc;
            this.mNextStep = NextStep.VERIFICATION;
            NextVerificationLoginContext nextVerificationLoginContext = new NextVerificationLoginContext();
            nextVerificationLoginContext.userId = needVerificationException.getUserId();
            nextVerificationLoginContext.metaLoginData = needVerificationException.getMetaLoginData();
            nextVerificationLoginContext.step1Token = needVerificationException.getStep1Token();
            this.mLoginContext = nextVerificationLoginContext;
        } else {
            throw new IllegalArgumentException("Exception type " + exc.getClass().getName() + " not supported. ");
        }
    }

    public NextStep getNextStep() {
        return this.mNextStep;
    }

    public LoginContext getLoginContext() {
        return this.mLoginContext;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mNextStep.name());
        if (this.mNextStep == NextStep.NOTIFICATION) {
            NextNotificationLoginContext nextNotificationLoginContext = (NextNotificationLoginContext) this.mLoginContext;
            parcel.writeString(nextNotificationLoginContext.userId);
            parcel.writeString(nextNotificationLoginContext.notificationUrl);
            parcel.writeString(nextNotificationLoginContext.loginContent.getBody());
        } else if (this.mNextStep == NextStep.VERIFICATION) {
            NextVerificationLoginContext nextVerificationLoginContext = (NextVerificationLoginContext) this.mLoginContext;
            parcel.writeString(nextVerificationLoginContext.userId);
            parcel.writeString(nextVerificationLoginContext.metaLoginData.sign);
            parcel.writeString(nextVerificationLoginContext.metaLoginData.qs);
            parcel.writeString(nextVerificationLoginContext.metaLoginData.callback);
            parcel.writeString(nextVerificationLoginContext.step1Token);
        } else if (this.mNextStep == NextStep.NONE) {
            parcel.writeParcelable(((NextNoneLoginContext) this.mLoginContext).accountInfo, i);
        }
    }

    private Step1LoginContext(Parcel parcel) {
        this.mNextStep = NextStep.valueOf(parcel.readString());
        if (this.mNextStep == NextStep.NOTIFICATION) {
            NextNotificationLoginContext nextNotificationLoginContext = new NextNotificationLoginContext();
            nextNotificationLoginContext.userId = parcel.readString();
            nextNotificationLoginContext.notificationUrl = parcel.readString();
            nextNotificationLoginContext.loginContent = new SimpleRequest.StringContent(parcel.readString());
            this.mLoginContext = nextNotificationLoginContext;
        } else if (this.mNextStep == NextStep.VERIFICATION) {
            NextVerificationLoginContext nextVerificationLoginContext = new NextVerificationLoginContext();
            nextVerificationLoginContext.userId = parcel.readString();
            nextVerificationLoginContext.metaLoginData = new MetaLoginData(parcel.readString(), parcel.readString(), parcel.readString());
            nextVerificationLoginContext.step1Token = parcel.readString();
            this.mLoginContext = nextVerificationLoginContext;
        } else if (this.mNextStep == NextStep.NONE) {
            NextNoneLoginContext nextNoneLoginContext = new NextNoneLoginContext();
            nextNoneLoginContext.accountInfo = (AccountInfo) parcel.readParcelable(getClass().getClassLoader());
            this.mLoginContext = nextNoneLoginContext;
        }
    }
}
