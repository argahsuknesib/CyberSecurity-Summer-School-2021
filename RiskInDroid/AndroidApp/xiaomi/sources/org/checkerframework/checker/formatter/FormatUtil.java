package org.checkerframework.checker.formatter;

import java.util.IllegalFormatConversionException;
import java.util.MissingFormatArgumentException;
import java.util.regex.Pattern;
import org.checkerframework.checker.formatter.qual.ConversionCategory;

public final class FormatUtil {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Pattern f15439O000000o = Pattern.compile("%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])");

    public static class ExcessiveOrMissingFormatArgumentException extends MissingFormatArgumentException {
        private static final long serialVersionUID = 17000126;
        private final int expected;
        private final int found;

        public ExcessiveOrMissingFormatArgumentException(int i, int i2) {
            super("-");
            this.expected = i;
            this.found = i2;
        }

        public int getExpected() {
            return this.expected;
        }

        public int getFound() {
            return this.found;
        }

        public String getMessage() {
            return String.format("Expected %d arguments but found %d.", Integer.valueOf(this.expected), Integer.valueOf(this.found));
        }
    }

    public static class IllegalFormatConversionCategoryException extends IllegalFormatConversionException {
        private static final long serialVersionUID = 17000126;
        private final ConversionCategory expected;
        private final ConversionCategory found;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IllegalFormatConversionCategoryException(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
            super(conversionCategory.chars.length() == 0 ? '-' : conversionCategory.chars.charAt(0), conversionCategory2.types == null ? Object.class : conversionCategory2.types[0]);
            this.expected = conversionCategory;
            this.found = conversionCategory2;
        }

        public ConversionCategory getExpected() {
            return this.expected;
        }

        public ConversionCategory getFound() {
            return this.found;
        }

        public String getMessage() {
            return String.format("Expected category %s but found %s.", this.expected, this.found);
        }
    }
}
