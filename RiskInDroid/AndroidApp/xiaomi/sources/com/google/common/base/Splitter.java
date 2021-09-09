package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@GwtCompatible(emulated = true)
public final class Splitter {
    public final int limit;
    public final boolean omitEmptyStrings;
    private final Strategy strategy;
    public final CharMatcher trimmer;

    interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(Strategy strategy2) {
        this(strategy2, false, CharMatcher.none(), Integer.MAX_VALUE);
    }

    private Splitter(Strategy strategy2, boolean z, CharMatcher charMatcher, int i) {
        this.strategy = strategy2;
        this.omitEmptyStrings = z;
        this.trimmer = charMatcher;
        this.limit = i;
    }

    public static Splitter on(char c) {
        return on(CharMatcher.is(c));
    }

    public static Splitter on(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new Strategy() {
            /* class com.google.common.base.Splitter.AnonymousClass1 */

            public final SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    /* class com.google.common.base.Splitter.AnonymousClass1.AnonymousClass1 */

                    /* access modifiers changed from: package-private */
                    public int separatorEnd(int i) {
                        return i + 1;
                    }

                    /* access modifiers changed from: package-private */
                    public int separatorStart(int i) {
                        return charMatcher.indexIn(this.toSplit, i);
                    }
                };
            }
        });
    }

    public static Splitter on(final String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        if (str.length() == 1) {
            return on(str.charAt(0));
        }
        return new Splitter(new Strategy() {
            /* class com.google.common.base.Splitter.AnonymousClass2 */

            public final SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    /* class com.google.common.base.Splitter.AnonymousClass2.AnonymousClass1 */

                    public int separatorStart(int i) {
                        int length = str.length();
                        int length2 = this.toSplit.length() - length;
                        while (i <= length2) {
                            int i2 = 0;
                            while (i2 < length) {
                                if (this.toSplit.charAt(i2 + i) == str.charAt(i2)) {
                                    i2++;
                                } else {
                                    i++;
                                }
                            }
                            return i;
                        }
                        return -1;
                    }

                    public int separatorEnd(int i) {
                        return i + str.length();
                    }
                };
            }
        });
    }

    @GwtIncompatible
    public static Splitter on(Pattern pattern) {
        return on(new JdkPattern(pattern));
    }

    private static Splitter on(final CommonPattern commonPattern) {
        Preconditions.checkArgument(!commonPattern.matcher("").matches(), "The pattern may not match the empty string: %s", commonPattern);
        return new Splitter(new Strategy() {
            /* class com.google.common.base.Splitter.AnonymousClass3 */

            public final SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                final CommonMatcher matcher = commonPattern.matcher(charSequence);
                return new SplittingIterator(splitter, charSequence) {
                    /* class com.google.common.base.Splitter.AnonymousClass3.AnonymousClass1 */

                    public int separatorStart(int i) {
                        if (matcher.find(i)) {
                            return matcher.start();
                        }
                        return -1;
                    }

                    public int separatorEnd(int i) {
                        return matcher.end();
                    }
                };
            }
        });
    }

    @GwtIncompatible
    public static Splitter onPattern(String str) {
        return on(Platform.compilePattern(str));
    }

    public static Splitter fixedLength(final int i) {
        Preconditions.checkArgument(i > 0, "The length may not be less than 1");
        return new Splitter(new Strategy() {
            /* class com.google.common.base.Splitter.AnonymousClass4 */

            public final SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    /* class com.google.common.base.Splitter.AnonymousClass4.AnonymousClass1 */

                    public int separatorEnd(int i) {
                        return i;
                    }

                    public int separatorStart(int i) {
                        int i2 = i + i;
                        if (i2 < this.toSplit.length()) {
                            return i2;
                        }
                        return -1;
                    }
                };
            }
        });
    }

    public final Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public final Splitter limit(int i) {
        Preconditions.checkArgument(i > 0, "must be greater than zero: %s", i);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, i);
    }

    public final Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    public final Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }

    public final Iterable<String> split(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new Iterable<String>() {
            /* class com.google.common.base.Splitter.AnonymousClass5 */

            public Iterator<String> iterator() {
                return Splitter.this.splittingIterator(charSequence);
            }

            public String toString() {
                StringBuilder appendTo = Joiner.on(", ").appendTo(new StringBuilder("["), (Iterable<?>) this);
                appendTo.append(']');
                return appendTo.toString();
            }
        };
    }

    public final Iterator<String> splittingIterator(CharSequence charSequence) {
        return this.strategy.iterator(this, charSequence);
    }

    @Beta
    public final List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> splittingIterator = splittingIterator(charSequence);
        ArrayList arrayList = new ArrayList();
        while (splittingIterator.hasNext()) {
            arrayList.add(splittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Beta
    public final MapSplitter withKeyValueSeparator(String str) {
        return withKeyValueSeparator(on(str));
    }

    @Beta
    public final MapSplitter withKeyValueSeparator(char c) {
        return withKeyValueSeparator(on(c));
    }

    @Beta
    public final MapSplitter withKeyValueSeparator(Splitter splitter) {
        return new MapSplitter(splitter);
    }

    @Beta
    public static final class MapSplitter {
        private final Splitter entrySplitter;
        private final Splitter outerSplitter;

        private MapSplitter(Splitter splitter, Splitter splitter2) {
            this.outerSplitter = splitter;
            this.entrySplitter = (Splitter) Preconditions.checkNotNull(splitter2);
        }

        public final Map<String, String> split(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String next : this.outerSplitter.split(charSequence)) {
                Iterator<String> splittingIterator = this.entrySplitter.splittingIterator(next);
                Preconditions.checkArgument(splittingIterator.hasNext(), "Chunk [%s] is not a valid entry", next);
                String next2 = splittingIterator.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(next2), "Duplicate key [%s] found.", next2);
                Preconditions.checkArgument(splittingIterator.hasNext(), "Chunk [%s] is not a valid entry", next);
                linkedHashMap.put(next2, splittingIterator.next());
                Preconditions.checkArgument(!splittingIterator.hasNext(), "Chunk [%s] is not a valid entry", next);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }
    }

    static abstract class SplittingIterator extends AbstractIterator<String> {
        int limit;
        int offset = 0;
        final boolean omitEmptyStrings;
        final CharSequence toSplit;
        final CharMatcher trimmer;

        /* access modifiers changed from: package-private */
        public abstract int separatorEnd(int i);

        /* access modifiers changed from: package-private */
        public abstract int separatorStart(int i);

        protected SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.toSplit = charSequence;
        }

        /* access modifiers changed from: protected */
        public String computeNext() {
            int i;
            int i2 = this.offset;
            while (true) {
                int i3 = this.offset;
                if (i3 == -1) {
                    return (String) endOfData();
                }
                int separatorStart = separatorStart(i3);
                if (separatorStart == -1) {
                    separatorStart = this.toSplit.length();
                    this.offset = -1;
                } else {
                    this.offset = separatorEnd(separatorStart);
                }
                int i4 = this.offset;
                if (i4 == i2) {
                    this.offset = i4 + 1;
                    if (this.offset > this.toSplit.length()) {
                        this.offset = -1;
                    }
                } else {
                    while (i2 < separatorStart && this.trimmer.matches(this.toSplit.charAt(i2))) {
                        i2++;
                    }
                    while (i > i2 && this.trimmer.matches(this.toSplit.charAt(i - 1))) {
                        separatorStart = i - 1;
                    }
                    if (!this.omitEmptyStrings || i2 != i) {
                        int i5 = this.limit;
                    } else {
                        i2 = this.offset;
                    }
                }
            }
            int i52 = this.limit;
            if (i52 == 1) {
                i = this.toSplit.length();
                this.offset = -1;
                while (i > i2 && this.trimmer.matches(this.toSplit.charAt(i - 1))) {
                    i--;
                }
            } else {
                this.limit = i52 - 1;
            }
            return this.toSplit.subSequence(i2, i).toString();
        }
    }
}
