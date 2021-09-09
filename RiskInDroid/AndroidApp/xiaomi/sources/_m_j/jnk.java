package _m_j;

import java.lang.Character;

final class jnk {
    static char O00000Oo(char c) {
        int i;
        if (c == 12288) {
            return ' ';
        }
        if (c > 65280 && c < 65375) {
            i = c - 65248;
        } else if (c < 'A' || c > 'Z') {
            return c;
        } else {
            i = c + ' ';
        }
        return (char) i;
    }

    static int O000000o(char c) {
        if (c >= '0' && c <= '9') {
            return 1;
        }
        if (c >= 'a' && c <= 'z') {
            return 2;
        }
        if (c >= 'A' && c <= 'Z') {
            return 2;
        }
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
        if (of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) {
            return 4;
        }
        return (of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || of == Character.UnicodeBlock.HANGUL_SYLLABLES || of == Character.UnicodeBlock.HANGUL_JAMO || of == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO || of == Character.UnicodeBlock.HIRAGANA || of == Character.UnicodeBlock.KATAKANA || of == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS) ? 8 : 0;
    }
}
