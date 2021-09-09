package com.google.android.gms.stats.internal;

import com.google.android.gms.common.config.GservicesValue;
import com.google.android.gms.stats.netstats.NetstatsParserPatterns;
import java.util.concurrent.TimeUnit;

public final class G {

    public static final class netStats {
        public static final GservicesValue<Long> dataSourcePollIntervalMillis = GservicesValue.value("gms:stats:netstats:data_source_poll_millis", Long.valueOf(TimeUnit.MINUTES.toMillis(30)));
        public static final GservicesValue<Boolean> enabled = GservicesValue.value("gms:stats:netstats:enabled", true);
        public static final GservicesValue<Long> recordIntervalSecs = GservicesValue.value("gms:stats:netstats:record_interval_secs", Long.valueOf(TimeUnit.DAYS.toSeconds(1)));

        public static final class patterns {
            public static final GservicesValue<String> BUCKET = GservicesValue.value("gms:stats:netstats:pattern:bucket", NetstatsParserPatterns.BUCKET_PATTERN);
            public static final GservicesValue<String> HISTORY = GservicesValue.value("gms:stats:netstats:pattern:history", ".*bucketDuration=(?<duration>[0-9]+).*");
            public static final GservicesValue<String> IDENT = GservicesValue.value("gms:stats:netstats:pattern:ident", NetstatsParserPatterns.IDENT_PATTERN);
            public static final GservicesValue<String> IDENTS = GservicesValue.value("gms:stats:netstats:pattern:idents", " *ident=\\[(?<idents>.*)\\](?: uid=(?<uid>-?[0-9]+))?(?: set=(?<set>\\w+))?(?: tag=0x(?<tag>[0-9a-f]+))?.*");
            public static final GservicesValue<Integer> TAG_RADIX = GservicesValue.value("gms:stats:netstats:pattern:tag_radix", (Integer) 16);
            public static final GservicesValue<Integer> TS_TO_MILLIS = GservicesValue.value("gms:stats:netstats:pattern:ts_to_millis", Integer.valueOf(NetstatsParserPatterns.TS_TO_MILLIS));
            public static final GservicesValue<String> TYPE_BACKGROUND = GservicesValue.value("gms:stats:netstats:pattern:type_background", "DEFAULT");
            public static final GservicesValue<String> TYPE_BOTH = GservicesValue.value("gms:stats:netstats:pattern:type_both", "ALL");
            public static final GservicesValue<String> TYPE_DEBUG_VPN_IN_PATTERN = GservicesValue.value("gms:stats:netstats:pattern:type_debug_vpn_in_pattern", "DBG_VPN_IN");
            public static final GservicesValue<String> TYPE_DEBUG_VPN_OUT_PATTERN = GservicesValue.value("gms:stats:netstats:pattern:type_debug_vpn_out_pattern", "DBG_VPN_OUT");
            public static final GservicesValue<String> TYPE_FOREGROUND = GservicesValue.value("gms:stats:netstats:pattern:type_foreground", "FOREGROUND");
            public static final GservicesValue<String> UID_STATS_START = GservicesValue.value("gms:stats:netstats:pattern:uid_start", "UID stats:|Detailed UID stats:");
            public static final GservicesValue<String> UID_TAG_STATS_START = GservicesValue.value("gms:stats:netstats:pattern:uid_tag_start", "UID tag stats:");

            private patterns() {
            }
        }

        private netStats() {
        }
    }
}
