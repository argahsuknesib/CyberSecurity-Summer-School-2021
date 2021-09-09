package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.Immutable;
import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.List;

@GwtCompatible
@Immutable
@Beta
public final class InternetDomainName {
    private static final CharMatcher DASH_MATCHER = CharMatcher.anyOf("-_");
    private static final CharMatcher DOTS_MATCHER = CharMatcher.anyOf(".。．｡");
    private static final Joiner DOT_JOINER = Joiner.on('.');
    private static final Splitter DOT_SPLITTER = Splitter.on('.');
    private static final CharMatcher PART_CHAR_MATCHER = CharMatcher.javaLetterOrDigit().or(DASH_MATCHER);
    private final String name;
    private final ImmutableList<String> parts;
    private final int publicSuffixIndex;
    private final int registrySuffixIndex;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.base.CharMatcher.replaceFrom(java.lang.CharSequence, char):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      com.google.common.base.CharMatcher.replaceFrom(java.lang.CharSequence, java.lang.CharSequence):java.lang.String
      com.google.common.base.CharMatcher.replaceFrom(java.lang.CharSequence, char):java.lang.String */
    InternetDomainName(String str) {
        String lowerCase = Ascii.toLowerCase(DOTS_MATCHER.replaceFrom((CharSequence) str, '.'));
        boolean z = true;
        lowerCase = lowerCase.endsWith(".") ? lowerCase.substring(0, lowerCase.length() - 1) : lowerCase;
        Preconditions.checkArgument(lowerCase.length() <= 253, "Domain name too long: '%s':", lowerCase);
        this.name = lowerCase;
        this.parts = ImmutableList.copyOf(DOT_SPLITTER.split(lowerCase));
        Preconditions.checkArgument(this.parts.size() > 127 ? false : z, "Domain has too many parts: '%s'", lowerCase);
        Preconditions.checkArgument(validateSyntax(this.parts), "Not a valid domain name: '%s'", lowerCase);
        this.publicSuffixIndex = findSuffixOfType(Optional.absent());
        this.registrySuffixIndex = findSuffixOfType(Optional.of(PublicSuffixType.REGISTRY));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E>
     arg types: [int, int]
     candidates:
      com.google.common.collect.ImmutableList.subList(int, int):java.util.List
      ClspMth{java.util.List.subList(int, int):java.util.List<E>}
      com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E> */
    private int findSuffixOfType(Optional<PublicSuffixType> optional) {
        int size = this.parts.size();
        for (int i = 0; i < size; i++) {
            String join = DOT_JOINER.join(this.parts.subList(i, size));
            if (matchesType(optional, Optional.fromNullable(PublicSuffixPatterns.EXACT.get(join)))) {
                return i;
            }
            if (PublicSuffixPatterns.EXCLUDED.containsKey(join)) {
                return i + 1;
            }
            if (matchesWildcardSuffixType(optional, join)) {
                return i;
            }
        }
        return -1;
    }

    public static InternetDomainName from(String str) {
        return new InternetDomainName((String) Preconditions.checkNotNull(str));
    }

    private static boolean validateSyntax(List<String> list) {
        int size = list.size() - 1;
        if (!validatePart(list.get(size), true)) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!validatePart(list.get(i), false)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validatePart(String str, boolean z) {
        if (str.length() > 0 && str.length() <= 63) {
            if (PART_CHAR_MATCHER.matchesAllOf(CharMatcher.ascii().retainFrom(str)) && !DASH_MATCHER.matches(str.charAt(0)) && !DASH_MATCHER.matches(str.charAt(str.length() - 1))) {
                if (!z || !CharMatcher.digit().matches(str.charAt(0))) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final ImmutableList<String> parts() {
        return this.parts;
    }

    public final boolean isPublicSuffix() {
        return this.publicSuffixIndex == 0;
    }

    public final boolean hasPublicSuffix() {
        return this.publicSuffixIndex != -1;
    }

    public final InternetDomainName publicSuffix() {
        if (hasPublicSuffix()) {
            return ancestor(this.publicSuffixIndex);
        }
        return null;
    }

    public final boolean isUnderPublicSuffix() {
        return this.publicSuffixIndex > 0;
    }

    public final boolean isTopPrivateDomain() {
        return this.publicSuffixIndex == 1;
    }

    public final InternetDomainName topPrivateDomain() {
        if (isTopPrivateDomain()) {
            return this;
        }
        Preconditions.checkState(isUnderPublicSuffix(), "Not under a public suffix: %s", this.name);
        return ancestor(this.publicSuffixIndex - 1);
    }

    public final boolean isRegistrySuffix() {
        return this.registrySuffixIndex == 0;
    }

    public final boolean hasRegistrySuffix() {
        return this.registrySuffixIndex != -1;
    }

    public final InternetDomainName registrySuffix() {
        if (hasRegistrySuffix()) {
            return ancestor(this.registrySuffixIndex);
        }
        return null;
    }

    public final boolean isUnderRegistrySuffix() {
        return this.registrySuffixIndex > 0;
    }

    public final boolean isTopDomainUnderRegistrySuffix() {
        return this.registrySuffixIndex == 1;
    }

    public final InternetDomainName topDomainUnderRegistrySuffix() {
        if (isTopDomainUnderRegistrySuffix()) {
            return this;
        }
        Preconditions.checkState(isUnderRegistrySuffix(), "Not under a registry suffix: %s", this.name);
        return ancestor(this.registrySuffixIndex - 1);
    }

    public final boolean hasParent() {
        return this.parts.size() > 1;
    }

    public final InternetDomainName parent() {
        Preconditions.checkState(hasParent(), "Domain '%s' has no parent", this.name);
        return ancestor(1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E>
     arg types: [int, int]
     candidates:
      com.google.common.collect.ImmutableList.subList(int, int):java.util.List
      ClspMth{java.util.List.subList(int, int):java.util.List<E>}
      com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E> */
    private InternetDomainName ancestor(int i) {
        Joiner joiner = DOT_JOINER;
        ImmutableList<String> immutableList = this.parts;
        return from(joiner.join(immutableList.subList(i, immutableList.size())));
    }

    public final InternetDomainName child(String str) {
        return from(((String) Preconditions.checkNotNull(str)) + "." + this.name);
    }

    public static boolean isValid(String str) {
        try {
            from(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    private static boolean matchesWildcardSuffixType(Optional<PublicSuffixType> optional, String str) {
        List<String> splitToList = DOT_SPLITTER.limit(2).splitToList(str);
        if (splitToList.size() != 2 || !matchesType(optional, Optional.fromNullable(PublicSuffixPatterns.UNDER.get(splitToList.get(1))))) {
            return false;
        }
        return true;
    }

    private static boolean matchesType(Optional<PublicSuffixType> optional, Optional<PublicSuffixType> optional2) {
        return optional.isPresent() ? optional.equals(optional2) : optional2.isPresent();
    }

    public final String toString() {
        return this.name;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternetDomainName) {
            return this.name.equals(((InternetDomainName) obj).name);
        }
        return false;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }
}
