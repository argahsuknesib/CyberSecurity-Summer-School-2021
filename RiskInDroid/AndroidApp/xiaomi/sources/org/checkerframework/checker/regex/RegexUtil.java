package org.checkerframework.checker.regex;

import java.util.regex.PatternSyntaxException;

public final class RegexUtil {

    public static class CheckedPatternSyntaxException extends Exception {
        private static final long serialVersionUID = 6266881831979001480L;
        private final PatternSyntaxException pse;

        public CheckedPatternSyntaxException(PatternSyntaxException patternSyntaxException) {
            this.pse = patternSyntaxException;
        }

        public CheckedPatternSyntaxException(String str, String str2, int i) {
            this(new PatternSyntaxException(str, str2, i));
        }

        public String getDescription() {
            return this.pse.getDescription();
        }

        public int getIndex() {
            return this.pse.getIndex();
        }

        public String getMessage() {
            return this.pse.getMessage();
        }

        public String getPattern() {
            return this.pse.getPattern();
        }
    }
}
