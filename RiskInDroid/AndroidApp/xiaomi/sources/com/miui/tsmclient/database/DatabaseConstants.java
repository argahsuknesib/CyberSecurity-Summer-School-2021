package com.miui.tsmclient.database;

import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseConstants {
    public static final String AUTHORITY = ProviderAuthorities.AUTHORITY;
    public static final Uri CONTENT_URI = ProviderAuthorities.CONTENT_URI;
    public static final Uri CONTENT_URI_BANK_BIN = Uri.parse(CONTENT_URI + "/bank_bin");
    public static final Uri CONTENT_URI_BANK_INFO = Uri.parse(CONTENT_URI + "/bank_info");
    public static final Uri CONTENT_URI_CACHE = Uri.parse(CONTENT_URI + "/cache");
    public static final Uri CONTENT_URI_DATA_STAT = Uri.parse(CONTENT_URI + "/data_stat");
    public static final Uri CONTENT_URI_NO_PROMPT_BULLETIN = Uri.parse(CONTENT_URI + "/no_prompt_bulletin");
    public static final Uri CONTENT_URI_TRANS_CARD_INFO = Uri.parse(CONTENT_URI + "/trans_card_info");
    public static final Uri CONTENT_URI_TRAVEL_INFO = Uri.parse(CONTENT_URI + "/travel_info");
    public static final String[] PROJECTION_BANK_NAME_AND_LOGO = {"bank_info.bank_name", "bank_logo"};
    public static final String[] PROJECTION_CACHE = {"key", "value"};
    public static final String[] PROJECTION_DATA_STAT_INFO = {"data_id", "data_value", "data_time"};
    public static final String[] PROJECTION_TRANS_CARD_INFO = {"card_name", "card_logo", "issuable", "card_code"};
    public static final String[] PROJECTION_TRAVEL_INFO = {"key", "card_name", "value"};
    public static final Uri PUBLIC_CONTENT_URI = ProviderAuthorities.PUBLIC_CONTENT_URI;

    public static final class BankBinTable implements BaseColumns {
    }

    public static final class BankInfoTable implements BaseColumns {
    }

    public static final class CacheTable implements BaseColumns {
    }

    public static final class DataStatTable implements BaseColumns {
    }

    public static final class NoPromptBulletinTable implements BaseColumns {
    }

    public static final class TransCardInfoTable implements BaseColumns {
    }

    public static final class TravelInfoTable implements BaseColumns {
    }
}
