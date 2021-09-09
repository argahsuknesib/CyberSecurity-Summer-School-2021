package com.hzy.tvmao.model.legacy.api;

import _m_j.jdn;

public class p {
    public static String a(String str) {
        return str.replace("<p>", "&nbsp;&nbsp;&nbsp;&nbsp;").replace("</p>", "\n").replaceAll("<br[ /]*>", "\n");
    }

    public static String b(String str) {
        return str.replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", jdn.f1779O000000o).replace("&amp;", "&").replace("&nbsp;", " ").replace("&mdash;", "—").replace("&ldquo;", "“").replace("&rdquo;", "”").replace("&#151;", "—");
    }

    public static String a(CharSequence charSequence) {
        return b(c(a(charSequence.toString())).replaceAll("\n{2,}", "\n"));
    }

    public static String c(String str) {
        return str.replaceAll("</?[^>]+/?>", "");
    }
}
