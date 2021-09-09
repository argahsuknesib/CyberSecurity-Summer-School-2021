package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

public final class TextProperties {

    public enum FontStyle {
        normal,
        italic,
        oblique
    }

    public enum FontVariantLigatures {
        normal,
        none
    }

    public enum TextAnchor {
        start,
        middle,
        end
    }

    enum TextLengthAdjust {
        spacing,
        spacingAndGlyphs
    }

    enum TextPathMethod {
        align,
        stretch
    }

    enum TextPathMidLine {
        sharp,
        smooth
    }

    enum TextPathSide {
        left,
        right
    }

    enum TextPathSpacing {
        auto,
        exact
    }

    enum AlignmentBaseline {
        baseline("baseline"),
        textBottom("text-bottom"),
        alphabetic("alphabetic"),
        ideographic("ideographic"),
        middle("middle"),
        central("central"),
        mathematical("mathematical"),
        textTop("text-top"),
        bottom("bottom"),
        center("center"),
        top("top"),
        textBeforeEdge("text-before-edge"),
        textAfterEdge("text-after-edge"),
        beforeEdge("before-edge"),
        afterEdge("after-edge"),
        hanging("hanging");
        
        private static final Map<String, AlignmentBaseline> alignmentToEnum = new HashMap();
        private final String alignment;

        static {
            for (AlignmentBaseline alignmentBaseline : values()) {
                alignmentToEnum.put(alignmentBaseline.alignment, alignmentBaseline);
            }
        }

        private AlignmentBaseline(String str) {
            this.alignment = str;
        }

        static AlignmentBaseline getEnum(String str) {
            if (alignmentToEnum.containsKey(str)) {
                return alignmentToEnum.get(str);
            }
            throw new IllegalArgumentException("Unknown String Value: ".concat(String.valueOf(str)));
        }

        public final String toString() {
            return this.alignment;
        }
    }

    public enum FontWeight {
        Normal("normal"),
        Bold("bold"),
        Bolder("bolder"),
        Lighter("lighter"),
        w100("100"),
        w200("200"),
        w300("300"),
        w400("400"),
        w500("500"),
        w600("600"),
        w700("700"),
        w800("800"),
        w900("900");
        
        private static final Map<String, FontWeight> weightToEnum = new HashMap();
        private final String weight;

        static {
            for (FontWeight fontWeight : values()) {
                weightToEnum.put(fontWeight.weight, fontWeight);
            }
        }

        private FontWeight(String str) {
            this.weight = str;
        }

        public static FontWeight getEnum(String str) {
            if (weightToEnum.containsKey(str)) {
                return weightToEnum.get(str);
            }
            throw new IllegalArgumentException("Unknown String Value: ".concat(String.valueOf(str)));
        }

        public final String toString() {
            return this.weight;
        }
    }

    public enum TextDecoration {
        None("none"),
        Underline("underline"),
        Overline("overline"),
        LineThrough("line-through"),
        Blink("blink");
        
        private static final Map<String, TextDecoration> decorationToEnum = new HashMap();
        private final String decoration;

        static {
            for (TextDecoration textDecoration : values()) {
                decorationToEnum.put(textDecoration.decoration, textDecoration);
            }
        }

        private TextDecoration(String str) {
            this.decoration = str;
        }

        public static TextDecoration getEnum(String str) {
            if (decorationToEnum.containsKey(str)) {
                return decorationToEnum.get(str);
            }
            throw new IllegalArgumentException("Unknown String Value: ".concat(String.valueOf(str)));
        }

        public final String toString() {
            return this.decoration;
        }
    }
}
