package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;

@GwtCompatible
final class TrieParser {
    private static final Joiner PREFIX_JOINER = Joiner.on("");

    TrieParser() {
    }

    static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence charSequence) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            i += doParseTrieToBuilder(Lists.newLinkedList(), charSequence, i, builder);
        }
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065 A[EDGE_INSN: B:35:0x0065->B:27:0x0065 ?: BREAK  , SYNTHETIC] */
    private static int doParseTrieToBuilder(List<CharSequence> list, CharSequence charSequence, int i, ImmutableMap.Builder<String, PublicSuffixType> builder) {
        int length = charSequence.length();
        int i2 = i;
        char c = 0;
        while (i2 < length && (c = charSequence.charAt(i2)) != '&' && c != '?' && c != '!' && c != ':' && c != ',') {
            i2++;
        }
        list.add(0, reverse(charSequence.subSequence(i, i2)));
        if (c == '!' || c == '?' || c == ':' || c == ',') {
            String join = PREFIX_JOINER.join(list);
            if (join.length() > 0) {
                builder.put(join, PublicSuffixType.fromCode(c));
            }
        }
        int i3 = i2 + 1;
        if (c != '?' && c != ',') {
            while (true) {
                if (i3 >= length) {
                    i3 += doParseTrieToBuilder(list, charSequence, i3, builder);
                    if (charSequence.charAt(i3) == '?' || charSequence.charAt(i3) == ',') {
                        i3++;
                    }
                    if (i3 >= length) {
                        break;
                    }
                }
            }
            i3++;
        }
        list.remove(0);
        return i3 - i;
    }

    private static CharSequence reverse(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }
}
