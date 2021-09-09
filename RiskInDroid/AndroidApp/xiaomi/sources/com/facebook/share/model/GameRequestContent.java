package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

public final class GameRequestContent implements ShareModel {
    public static final Parcelable.Creator<GameRequestContent> CREATOR = new Parcelable.Creator<GameRequestContent>() {
        /* class com.facebook.share.model.GameRequestContent.AnonymousClass1 */

        public final GameRequestContent createFromParcel(Parcel parcel) {
            return new GameRequestContent(parcel);
        }

        public final GameRequestContent[] newArray(int i) {
            return new GameRequestContent[i];
        }
    };
    private final ActionType actionType;
    private final String data;
    private final Filters filters;
    private final String message;
    private final String objectId;
    private final List<String> recipients;
    private final List<String> suggestions;
    private final String title;

    public enum ActionType {
        SEND,
        ASKFOR,
        TURN
    }

    public enum Filters {
        APP_USERS,
        APP_NON_USERS
    }

    public final int describeContents() {
        return 0;
    }

    private GameRequestContent(Builder builder) {
        this.message = builder.message;
        this.recipients = builder.recipients;
        this.title = builder.title;
        this.data = builder.data;
        this.actionType = builder.actionType;
        this.objectId = builder.objectId;
        this.filters = builder.filters;
        this.suggestions = builder.suggestions;
    }

    GameRequestContent(Parcel parcel) {
        this.message = parcel.readString();
        this.recipients = parcel.createStringArrayList();
        this.title = parcel.readString();
        this.data = parcel.readString();
        this.actionType = (ActionType) parcel.readSerializable();
        this.objectId = parcel.readString();
        this.filters = (Filters) parcel.readSerializable();
        this.suggestions = parcel.createStringArrayList();
        parcel.readStringList(this.suggestions);
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTo() {
        if (getRecipients() != null) {
            return TextUtils.join(",", getRecipients());
        }
        return null;
    }

    public final List<String> getRecipients() {
        return this.recipients;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getData() {
        return this.data;
    }

    public final ActionType getActionType() {
        return this.actionType;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final Filters getFilters() {
        return this.filters;
    }

    public final List<String> getSuggestions() {
        return this.suggestions;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.message);
        parcel.writeStringList(this.recipients);
        parcel.writeString(this.title);
        parcel.writeString(this.data);
        parcel.writeSerializable(this.actionType);
        parcel.writeString(this.objectId);
        parcel.writeSerializable(this.filters);
        parcel.writeStringList(this.suggestions);
    }

    public static class Builder implements ShareModelBuilder<GameRequestContent, Builder> {
        public ActionType actionType;
        public String data;
        public Filters filters;
        public String message;
        public String objectId;
        public List<String> recipients;
        public List<String> suggestions;
        public String title;

        public Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        public Builder setTo(String str) {
            if (str != null) {
                this.recipients = Arrays.asList(str.split(","));
            }
            return this;
        }

        public Builder setRecipients(List<String> list) {
            this.recipients = list;
            return this;
        }

        public Builder setData(String str) {
            this.data = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setActionType(ActionType actionType2) {
            this.actionType = actionType2;
            return this;
        }

        public Builder setObjectId(String str) {
            this.objectId = str;
            return this;
        }

        public Builder setFilters(Filters filters2) {
            this.filters = filters2;
            return this;
        }

        public Builder setSuggestions(List<String> list) {
            this.suggestions = list;
            return this;
        }

        public GameRequestContent build() {
            return new GameRequestContent(this);
        }

        public Builder readFrom(GameRequestContent gameRequestContent) {
            if (gameRequestContent == null) {
                return this;
            }
            return setMessage(gameRequestContent.getMessage()).setRecipients(gameRequestContent.getRecipients()).setTitle(gameRequestContent.getTitle()).setData(gameRequestContent.getData()).setActionType(gameRequestContent.getActionType()).setObjectId(gameRequestContent.getObjectId()).setFilters(gameRequestContent.getFilters()).setSuggestions(gameRequestContent.getSuggestions());
        }

        /* access modifiers changed from: package-private */
        public Builder readFrom(Parcel parcel) {
            return readFrom((GameRequestContent) parcel.readParcelable(GameRequestContent.class.getClassLoader()));
        }
    }
}
