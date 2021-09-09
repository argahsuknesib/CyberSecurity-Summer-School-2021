package com.xiaomi.smarthome.svg;

import _m_j.gsy;
import android.graphics.Matrix;
import android.support.v4.app.NotificationCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.smarthome.svg.CSSParser;
import com.xiaomi.smarthome.svg.PreserveAspectRatio;
import com.xiaomi.smarthome.svg.SVG;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;

public final class SVGParser extends DefaultHandler2 {

    /* renamed from: O000000o  reason: collision with root package name */
    public static HashSet<String> f11898O000000o = new HashSet<>();
    private static final HashMap<String, Integer> O0000Ooo = new HashMap<>();
    private static final HashMap<String, Integer> O0000o0 = new HashMap<>(13);
    private static final HashMap<String, SVG.O000OO00> O0000o00 = new HashMap<>(9);
    private static final HashMap<String, SVG.Style.FontStyle> O0000o0O = new HashMap<>(3);
    private static final HashMap<String, PreserveAspectRatio.Alignment> O0000o0o = new HashMap<>();
    private SVG O00000Oo = null;
    private boolean O00000o = false;
    private SVG.O00O0Oo0 O00000o0 = null;
    private int O00000oO;
    private boolean O00000oo = false;
    private String O0000O0o = null;
    private StringBuilder O0000OOo = null;
    private StringBuilder O0000Oo = null;
    private boolean O0000Oo0 = false;
    private HashSet<String> O0000OoO = null;

    enum SVGAttr {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        id,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        in,
        values,
        filter,
        UNSUPPORTED;

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
         arg types: [int, int]
         candidates:
          ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
          ClspMth{java.lang.String.replace(char, char):java.lang.String} */
        public static SVGAttr fromString(String str) {
            if (str.equals("class")) {
                return CLASS;
            }
            if (str.indexOf(95) != -1) {
                return UNSUPPORTED;
            }
            try {
                return valueOf(str.replace('-', '_'));
            } catch (IllegalArgumentException unused) {
                return UNSUPPORTED;
            }
        }
    }

    static {
        O0000Ooo.put("aliceblue", 15792383);
        O0000Ooo.put("antiquewhite", 16444375);
        O0000Ooo.put("aqua", 65535);
        O0000Ooo.put("aquamarine", 8388564);
        O0000Ooo.put("azure", 15794175);
        O0000Ooo.put("beige", 16119260);
        O0000Ooo.put("bisque", 16770244);
        O0000Ooo.put("black", 0);
        O0000Ooo.put("blanchedalmond", 16772045);
        O0000Ooo.put("blue", 255);
        O0000Ooo.put("blueviolet", 9055202);
        O0000Ooo.put("brown", 10824234);
        O0000Ooo.put("burlywood", 14596231);
        O0000Ooo.put("cadetblue", 6266528);
        O0000Ooo.put("chartreuse", 8388352);
        O0000Ooo.put("chocolate", 13789470);
        O0000Ooo.put("coral", 16744272);
        O0000Ooo.put("cornflowerblue", 6591981);
        O0000Ooo.put("cornsilk", 16775388);
        O0000Ooo.put("crimson", 14423100);
        O0000Ooo.put("cyan", 65535);
        O0000Ooo.put("darkblue", 139);
        O0000Ooo.put("darkcyan", 35723);
        O0000Ooo.put("darkgoldenrod", 12092939);
        O0000Ooo.put("darkgray", 11119017);
        O0000Ooo.put("darkgreen", 25600);
        O0000Ooo.put("darkgrey", 11119017);
        O0000Ooo.put("darkkhaki", 12433259);
        O0000Ooo.put("darkmagenta", 9109643);
        O0000Ooo.put("darkolivegreen", 5597999);
        O0000Ooo.put("darkorange", 16747520);
        O0000Ooo.put("darkorchid", 10040012);
        O0000Ooo.put("darkred", 9109504);
        O0000Ooo.put("darksalmon", 15308410);
        O0000Ooo.put("darkseagreen", 9419919);
        O0000Ooo.put("darkslateblue", 4734347);
        O0000Ooo.put("darkslategray", 3100495);
        O0000Ooo.put("darkslategrey", 3100495);
        O0000Ooo.put("darkturquoise", 52945);
        O0000Ooo.put("darkviolet", 9699539);
        O0000Ooo.put("deeppink", 16716947);
        O0000Ooo.put("deepskyblue", 49151);
        O0000Ooo.put("dimgray", 6908265);
        O0000Ooo.put("dimgrey", 6908265);
        O0000Ooo.put("dodgerblue", 2003199);
        O0000Ooo.put("firebrick", 11674146);
        O0000Ooo.put("floralwhite", 16775920);
        O0000Ooo.put("forestgreen", 2263842);
        O0000Ooo.put("fuchsia", 16711935);
        O0000Ooo.put("gainsboro", 14474460);
        O0000Ooo.put("ghostwhite", 16316671);
        O0000Ooo.put("gold", 16766720);
        O0000Ooo.put("goldenrod", 14329120);
        O0000Ooo.put("gray", 8421504);
        O0000Ooo.put("green", 32768);
        O0000Ooo.put("greenyellow", 11403055);
        O0000Ooo.put("grey", 8421504);
        O0000Ooo.put("honeydew", 15794160);
        O0000Ooo.put("hotpink", 16738740);
        O0000Ooo.put("indianred", 13458524);
        O0000Ooo.put("indigo", 4915330);
        O0000Ooo.put("ivory", 16777200);
        O0000Ooo.put("khaki", 15787660);
        O0000Ooo.put("lavender", 15132410);
        O0000Ooo.put("lavenderblush", 16773365);
        O0000Ooo.put("lawngreen", 8190976);
        O0000Ooo.put("lemonchiffon", 16775885);
        O0000Ooo.put("lightblue", 11393254);
        O0000Ooo.put("lightcoral", 15761536);
        O0000Ooo.put("lightcyan", 14745599);
        O0000Ooo.put("lightgoldenrodyellow", 16448210);
        O0000Ooo.put("lightgray", 13882323);
        O0000Ooo.put("lightgreen", 9498256);
        O0000Ooo.put("lightgrey", 13882323);
        O0000Ooo.put("lightpink", 16758465);
        O0000Ooo.put("lightsalmon", 16752762);
        O0000Ooo.put("lightseagreen", 2142890);
        O0000Ooo.put("lightskyblue", 8900346);
        O0000Ooo.put("lightslategray", 7833753);
        O0000Ooo.put("lightslategrey", 7833753);
        O0000Ooo.put("lightsteelblue", 11584734);
        O0000Ooo.put("lightyellow", 16777184);
        O0000Ooo.put("lime", 65280);
        O0000Ooo.put("limegreen", 3329330);
        O0000Ooo.put("linen", 16445670);
        O0000Ooo.put("magenta", 16711935);
        O0000Ooo.put("maroon", 8388608);
        O0000Ooo.put("mediumaquamarine", 6737322);
        O0000Ooo.put("mediumblue", 205);
        O0000Ooo.put("mediumorchid", 12211667);
        O0000Ooo.put("mediumpurple", 9662683);
        O0000Ooo.put("mediumseagreen", 3978097);
        O0000Ooo.put("mediumslateblue", 8087790);
        O0000Ooo.put("mediumspringgreen", 64154);
        O0000Ooo.put("mediumturquoise", 4772300);
        O0000Ooo.put("mediumvioletred", 13047173);
        O0000Ooo.put("midnightblue", 1644912);
        O0000Ooo.put("mintcream", 16121850);
        O0000Ooo.put("mistyrose", 16770273);
        O0000Ooo.put("moccasin", 16770229);
        O0000Ooo.put("navajowhite", 16768685);
        O0000Ooo.put("navy", Integer.valueOf((int) NotificationCompat.FLAG_HIGH_PRIORITY));
        O0000Ooo.put("oldlace", 16643558);
        O0000Ooo.put("olive", 8421376);
        O0000Ooo.put("olivedrab", 7048739);
        O0000Ooo.put("orange", 16753920);
        O0000Ooo.put("orangered", 16729344);
        O0000Ooo.put("orchid", 14315734);
        O0000Ooo.put("palegoldenrod", 15657130);
        O0000Ooo.put("palegreen", 10025880);
        O0000Ooo.put("paleturquoise", 11529966);
        O0000Ooo.put("palevioletred", 14381203);
        O0000Ooo.put("papayawhip", 16773077);
        O0000Ooo.put("peachpuff", 16767673);
        O0000Ooo.put("peru", 13468991);
        O0000Ooo.put("pink", 16761035);
        O0000Ooo.put("plum", 14524637);
        O0000Ooo.put("powderblue", 11591910);
        O0000Ooo.put("purple", 8388736);
        O0000Ooo.put("red", 16711680);
        O0000Ooo.put("rosybrown", 12357519);
        O0000Ooo.put("royalblue", 4286945);
        O0000Ooo.put("saddlebrown", 9127187);
        O0000Ooo.put("salmon", 16416882);
        O0000Ooo.put("sandybrown", 16032864);
        O0000Ooo.put("seagreen", 3050327);
        O0000Ooo.put("seashell", 16774638);
        O0000Ooo.put("sienna", 10506797);
        O0000Ooo.put("silver", 12632256);
        O0000Ooo.put("skyblue", 8900331);
        O0000Ooo.put("slateblue", 6970061);
        O0000Ooo.put("slategray", 7372944);
        O0000Ooo.put("slategrey", 7372944);
        O0000Ooo.put("snow", 16775930);
        O0000Ooo.put("springgreen", 65407);
        O0000Ooo.put("steelblue", 4620980);
        O0000Ooo.put("tan", 13808780);
        O0000Ooo.put("teal", 32896);
        O0000Ooo.put("thistle", 14204888);
        O0000Ooo.put("tomato", 16737095);
        O0000Ooo.put("turquoise", 4251856);
        O0000Ooo.put("violet", 15631086);
        O0000Ooo.put("wheat", 16113331);
        O0000Ooo.put("white", 16777215);
        O0000Ooo.put("whitesmoke", 16119285);
        O0000Ooo.put("yellow", 16776960);
        O0000Ooo.put("yellowgreen", 10145074);
        O0000o00.put("xx-small", new SVG.O000OO00(0.694f, SVG.Unit.pt));
        O0000o00.put("x-small", new SVG.O000OO00(0.833f, SVG.Unit.pt));
        O0000o00.put("small", new SVG.O000OO00(10.0f, SVG.Unit.pt));
        O0000o00.put("medium", new SVG.O000OO00(12.0f, SVG.Unit.pt));
        O0000o00.put("large", new SVG.O000OO00(14.4f, SVG.Unit.pt));
        O0000o00.put("x-large", new SVG.O000OO00(17.3f, SVG.Unit.pt));
        O0000o00.put("xx-large", new SVG.O000OO00(20.7f, SVG.Unit.pt));
        O0000o00.put("smaller", new SVG.O000OO00(83.33f, SVG.Unit.percent));
        O0000o00.put("larger", new SVG.O000OO00(120.0f, SVG.Unit.percent));
        O0000o0.put("normal", 400);
        O0000o0.put("bold", 700);
        O0000o0.put("bolder", 1);
        O0000o0.put("lighter", -1);
        O0000o0.put("100", 100);
        O0000o0.put("200", 200);
        O0000o0.put("300", 300);
        O0000o0.put("400", 400);
        O0000o0.put("500", 500);
        O0000o0.put("600", 600);
        O0000o0.put("700", 700);
        O0000o0.put("800", 800);
        O0000o0.put("900", 900);
        O0000o0O.put("normal", SVG.Style.FontStyle.Normal);
        O0000o0O.put("italic", SVG.Style.FontStyle.Italic);
        O0000o0O.put("oblique", SVG.Style.FontStyle.Oblique);
        O0000o0o.put("none", PreserveAspectRatio.Alignment.None);
        O0000o0o.put("xMinYMin", PreserveAspectRatio.Alignment.XMinYMin);
        O0000o0o.put("xMidYMin", PreserveAspectRatio.Alignment.XMidYMin);
        O0000o0o.put("xMaxYMin", PreserveAspectRatio.Alignment.XMaxYMin);
        O0000o0o.put("xMinYMid", PreserveAspectRatio.Alignment.XMinYMid);
        O0000o0o.put("xMidYMid", PreserveAspectRatio.Alignment.XMidYMid);
        O0000o0o.put("xMaxYMid", PreserveAspectRatio.Alignment.XMaxYMid);
        O0000o0o.put("xMinYMax", PreserveAspectRatio.Alignment.XMinYMax);
        O0000o0o.put("xMidYMax", PreserveAspectRatio.Alignment.XMidYMax);
        O0000o0o.put("xMaxYMax", PreserveAspectRatio.Alignment.XMaxYMax);
        f11898O000000o.add("Structure");
        f11898O000000o.add("BasicStructure");
        f11898O000000o.add("ConditionalProcessing");
        f11898O000000o.add("Image");
        f11898O000000o.add("Style");
        f11898O000000o.add("ViewportAttribute");
        f11898O000000o.add("Shape");
        f11898O000000o.add("BasicText");
        f11898O000000o.add("PaintAttribute");
        f11898O000000o.add("BasicPaintAttribute");
        f11898O000000o.add("OpacityAttribute");
        f11898O000000o.add("BasicGraphicsAttribute");
        f11898O000000o.add("Marker");
        f11898O000000o.add("Gradient");
        f11898O000000o.add("Pattern");
        f11898O000000o.add("Clip");
        f11898O000000o.add("BasicClip");
        f11898O000000o.add("Mask");
        f11898O000000o.add("View");
    }

    /* access modifiers changed from: protected */
    public final SVG O000000o(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        xMLReader.setContentHandler(this);
        xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", this);
        xMLReader.parse(new InputSource(inputStream));
        return this.O00000Oo;
    }

    public final void startDocument() throws SAXException {
        super.startDocument();
        this.O00000Oo = new SVG();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00O00o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00O00o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00O00o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O0000Oo0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O0000Oo0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo0o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo0o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo0o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo00o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo00o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo00o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00oo000, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00oo000, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00oo000, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O0000o0, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    public final void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        super.startElement(str, str2, str3, attributes);
        if (this.O00000o) {
            this.O00000oO++;
        } else if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.equals("svg")) {
                O000000o("<svg>", new Object[0]);
                SVG.O00O00o0 o00O00o0 = new SVG.O00O00o0();
                o00O00o0.O0000oOo = this.O00000Oo;
                o00O00o0.O0000oo0 = this.O00000o0;
                O000000o((SVG.O00O0o0) o00O00o0, attributes);
                O00000Oo(o00O00o0, attributes);
                O000000o((SVG.O00O00o) o00O00o0, attributes);
                O000000o((SVG.O00Oo00) o00O00o0, attributes);
                for (int i = 0; i < attributes.getLength(); i++) {
                    String trim = attributes.getValue(i).trim();
                    int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                    if (i2 == 1) {
                        o00O00o0.f11886O000000o = O00000o0(trim);
                    } else if (i2 == 2) {
                        o00O00o0.O00000Oo = O00000o0(trim);
                    } else if (i2 == 3) {
                        o00O00o0.O00000o0 = O00000o0(trim);
                        if (o00O00o0.O00000o0.O00000Oo()) {
                            throw new SAXException("Invalid <svg> element. width cannot be negative");
                        }
                    } else if (i2 == 4) {
                        o00O00o0.O00000o = O00000o0(trim);
                        if (o00O00o0.O00000o.O00000Oo()) {
                            throw new SAXException("Invalid <svg> element. height cannot be negative");
                        }
                    } else if (i2 == 5) {
                        o00O00o0.O00000oO = trim;
                    }
                }
                SVG.O00O0Oo0 o00O0Oo0 = this.O00000o0;
                if (o00O0Oo0 == null) {
                    this.O00000Oo.O00000Oo = o00O00o0;
                } else {
                    o00O0Oo0.O000000o(o00O00o0);
                }
                this.O00000o0 = o00O00o0;
            } else if (str2.equals("g")) {
                O000000o(attributes);
            } else if (str2.equals("defs")) {
                O000000o("<defs>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O0000Oo0 o0000Oo0 = new SVG.O0000Oo0();
                    o0000Oo0.O0000oOo = this.O00000Oo;
                    o0000Oo0.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o0000Oo0, attributes);
                    O00000Oo(o0000Oo0, attributes);
                    O000000o((SVG.O000O0o0) o0000Oo0, attributes);
                    this.O00000o0.O000000o(o0000Oo0);
                    this.O00000o0 = o0000Oo0;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("use")) {
                O000000o("<use>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O00o0 o00o0 = new SVG.O00o0();
                    o00o0.O0000oOo = this.O00000Oo;
                    o00o0.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o00o0, attributes);
                    O00000Oo(o00o0, attributes);
                    O000000o((SVG.O000O0o0) o00o0, attributes);
                    O000000o((SVG.O00O00o) o00o0, attributes);
                    O000000o(o00o0, attributes);
                    this.O00000o0.O000000o(o00o0);
                    this.O00000o0 = o00o0;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("path")) {
                O000000o("<path>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O000Oo0 o000Oo0 = new SVG.O000Oo0();
                    o000Oo0.O0000oOo = this.O00000Oo;
                    o000Oo0.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o000Oo0, attributes);
                    O00000Oo(o000Oo0, attributes);
                    O000000o((SVG.O000O0o0) o000Oo0, attributes);
                    O000000o((SVG.O00O00o) o000Oo0, attributes);
                    O000000o(o000Oo0, attributes);
                    this.O00000o0.O000000o(o000Oo0);
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("rect")) {
                O000000o("<rect>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.oooOoO oooooo = new SVG.oooOoO();
                    oooooo.O0000oOo = this.O00000Oo;
                    oooooo.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) oooooo, attributes);
                    O00000Oo(oooooo, attributes);
                    O000000o((SVG.O000O0o0) oooooo, attributes);
                    O000000o((SVG.O00O00o) oooooo, attributes);
                    O000000o(oooooo, attributes);
                    this.O00000o0.O000000o(oooooo);
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("circle")) {
                O000000o("<circle>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O00000o0 o00000o0 = new SVG.O00000o0();
                    o00000o0.O0000oOo = this.O00000Oo;
                    o00000o0.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o00000o0, attributes);
                    O00000Oo(o00000o0, attributes);
                    O000000o((SVG.O000O0o0) o00000o0, attributes);
                    O000000o((SVG.O00O00o) o00000o0, attributes);
                    O000000o(o00000o0, attributes);
                    this.O00000o0.O000000o(o00000o0);
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("ellipse")) {
                O000000o("<ellipse>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O0000Oo o0000Oo = new SVG.O0000Oo();
                    o0000Oo.O0000oOo = this.O00000Oo;
                    o0000Oo.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o0000Oo, attributes);
                    O00000Oo(o0000Oo, attributes);
                    O000000o((SVG.O000O0o0) o0000Oo, attributes);
                    O000000o((SVG.O00O00o) o0000Oo, attributes);
                    O000000o(o0000Oo, attributes);
                    this.O00000o0.O000000o(o0000Oo);
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("line")) {
                O000000o("<line>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O000OO0o o000OO0o = new SVG.O000OO0o();
                    o000OO0o.O0000oOo = this.O00000Oo;
                    o000OO0o.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o000OO0o, attributes);
                    O00000Oo(o000OO0o, attributes);
                    O000000o((SVG.O000O0o0) o000OO0o, attributes);
                    O000000o((SVG.O00O00o) o000OO0o, attributes);
                    O000000o(o000OO0o, attributes);
                    this.O00000o0.O000000o(o000OO0o);
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("polyline")) {
                O000000o("<polyline>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O000o0 o000o0 = new SVG.O000o0();
                    o000o0.O0000oOo = this.O00000Oo;
                    o000o0.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o000o0, attributes);
                    O00000Oo(o000o0, attributes);
                    O000000o((SVG.O000O0o0) o000o0, attributes);
                    O000000o((SVG.O00O00o) o000o0, attributes);
                    O000000o(o000o0, attributes, "polyline");
                    this.O00000o0.O000000o(o000o0);
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("polygon")) {
                O000000o("<polygon>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O000o o000o = new SVG.O000o();
                    o000o.O0000oOo = this.O00000Oo;
                    o000o.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o000o, attributes);
                    O00000Oo(o000o, attributes);
                    O000000o((SVG.O000O0o0) o000o, attributes);
                    O000000o((SVG.O00O00o) o000o, attributes);
                    O000000o(o000o, attributes, "polygon");
                    this.O00000o0.O000000o(o000o);
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("text")) {
                O000000o("<text>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O00Oo o00Oo = new SVG.O00Oo();
                    o00Oo.O0000oOo = this.O00000Oo;
                    o00Oo.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o00Oo, attributes);
                    O00000Oo(o00Oo, attributes);
                    O000000o((SVG.O000O0o0) o00Oo, attributes);
                    O000000o((SVG.O00O00o) o00Oo, attributes);
                    O000000o((SVG.O00o0000) o00Oo, attributes);
                    this.O00000o0.O000000o(o00Oo);
                    this.O00000o0 = o00Oo;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("tspan")) {
                O000000o("<tspan>", new Object[0]);
                SVG.O00O0Oo0 o00O0Oo02 = this.O00000o0;
                if (o00O0Oo02 == null) {
                    throw new SAXException("Invalid document. Root element must be <svg>");
                } else if (o00O0Oo02 instanceof SVG.O00OoOO0) {
                    SVG.O00Oo0o0 o00Oo0o0 = new SVG.O00Oo0o0();
                    o00Oo0o0.O0000oOo = this.O00000Oo;
                    o00Oo0o0.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o00Oo0o0, attributes);
                    O00000Oo(o00Oo0o0, attributes);
                    O000000o((SVG.O00O00o) o00Oo0o0, attributes);
                    O000000o((SVG.O00o0000) o00Oo0o0, attributes);
                    this.O00000o0.O000000o(o00Oo0o0);
                    this.O00000o0 = o00Oo0o0;
                    if (o00Oo0o0.O0000oo0 instanceof SVG.O00o000) {
                        o00Oo0o0.f11890O000000o = (SVG.O00o000) o00Oo0o0.O0000oo0;
                    } else {
                        o00Oo0o0.f11890O000000o = ((SVG.O00OoO0o) o00Oo0o0.O0000oo0).O0000O0o();
                    }
                } else {
                    throw new SAXException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
                }
            } else if (str2.equals("tref")) {
                O000000o("<tref>", new Object[0]);
                SVG.O00O0Oo0 o00O0Oo03 = this.O00000o0;
                if (o00O0Oo03 == null) {
                    throw new SAXException("Invalid document. Root element must be <svg>");
                } else if (o00O0Oo03 instanceof SVG.O00OoOO0) {
                    SVG.O00Oo0OO o00Oo0OO = new SVG.O00Oo0OO();
                    o00Oo0OO.O0000oOo = this.O00000Oo;
                    o00Oo0OO.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o00Oo0OO, attributes);
                    O00000Oo(o00Oo0OO, attributes);
                    O000000o((SVG.O00O00o) o00Oo0OO, attributes);
                    O000000o(o00Oo0OO, attributes);
                    this.O00000o0.O000000o(o00Oo0OO);
                    if (o00Oo0OO.O0000oo0 instanceof SVG.O00o000) {
                        o00Oo0OO.O00000Oo = (SVG.O00o000) o00Oo0OO.O0000oo0;
                    } else {
                        o00Oo0OO.O00000Oo = ((SVG.O00OoO0o) o00Oo0OO.O0000oo0).O0000O0o();
                    }
                } else {
                    throw new SAXException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
                }
            } else if (str2.equals("switch")) {
                O000000o("<switch>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O00Oo00o o00Oo00o = new SVG.O00Oo00o();
                    o00Oo00o.O0000oOo = this.O00000Oo;
                    o00Oo00o.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o00Oo00o, attributes);
                    O00000Oo(o00Oo00o, attributes);
                    O000000o((SVG.O000O0o0) o00Oo00o, attributes);
                    O000000o((SVG.O00O00o) o00Oo00o, attributes);
                    this.O00000o0.O000000o(o00Oo00o);
                    this.O00000o0 = o00Oo00o;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("symbol")) {
                O000000o("<symbol>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O00Oo0 o00Oo0 = new SVG.O00Oo0();
                    o00Oo0.O0000oOo = this.O00000Oo;
                    o00Oo0.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o00Oo0, attributes);
                    O00000Oo(o00Oo0, attributes);
                    O000000o((SVG.O00O00o) o00Oo0, attributes);
                    O000000o((SVG.O00Oo00) o00Oo0, attributes);
                    this.O00000o0.O000000o(o00Oo0);
                    this.O00000o0 = o00Oo0;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("marker")) {
                O000000o("<marker>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O000OO o000oo = new SVG.O000OO();
                    o000oo.O0000oOo = this.O00000Oo;
                    o000oo.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o000oo, attributes);
                    O00000Oo(o000oo, attributes);
                    O000000o((SVG.O00O00o) o000oo, attributes);
                    O000000o((SVG.O00Oo00) o000oo, attributes);
                    O000000o(o000oo, attributes);
                    this.O00000o0.O000000o(o000oo);
                    this.O00000o0 = o000oo;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("linearGradient")) {
                O000000o("<linearGradiant>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O00O0o o00O0o = new SVG.O00O0o();
                    o00O0o.O0000oOo = this.O00000Oo;
                    o00O0o.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o00O0o, attributes);
                    O00000Oo(o00O0o, attributes);
                    O000000o((SVG.O00oOooO) o00O0o, attributes);
                    O000000o(o00O0o, attributes);
                    this.O00000o0.O000000o(o00O0o);
                    this.O00000o0 = o00O0o;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("radialGradient")) {
                O000000o("<radialGradient>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O00OOo o00OOo = new SVG.O00OOo();
                    o00OOo.O0000oOo = this.O00000Oo;
                    o00OOo.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o00OOo, attributes);
                    O00000Oo(o00OOo, attributes);
                    O000000o((SVG.O00oOooO) o00OOo, attributes);
                    O000000o(o00OOo, attributes);
                    this.O00000o0.O000000o(o00OOo);
                    this.O00000o0 = o00OOo;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("stop")) {
                O000000o("<stop>", new Object[0]);
                SVG.O00O0Oo0 o00O0Oo04 = this.O00000o0;
                if (o00O0Oo04 == null) {
                    throw new SAXException("Invalid document. Root element must be <svg>");
                } else if (o00O0Oo04 instanceof SVG.O00oOooO) {
                    SVG.O00O00Oo o00O00Oo = new SVG.O00O00Oo();
                    o00O00Oo.O0000oOo = this.O00000Oo;
                    o00O00Oo.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o00O00Oo, attributes);
                    O00000Oo(o00O00Oo, attributes);
                    O000000o(o00O00Oo, attributes);
                    this.O00000o0.O000000o(o00O00Oo);
                    this.O00000o0 = o00O00Oo;
                } else {
                    throw new SAXException("Invalid document. <stop> elements are only valid inside <linearGradiant> or <radialGradient> elements.");
                }
            } else if (str2.equals("a")) {
                O000000o(attributes);
            } else if (str2.equals("title") || str2.equals("desc")) {
                this.O00000oo = true;
                this.O0000O0o = str2;
            } else if (str2.equals("clipPath")) {
                O000000o("<clipPath>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O00000o o00000o = new SVG.O00000o();
                    o00000o.O0000oOo = this.O00000Oo;
                    o00000o.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o00000o, attributes);
                    O00000Oo(o00000o, attributes);
                    O000000o((SVG.O000O0o0) o00000o, attributes);
                    O000000o((SVG.O00O00o) o00000o, attributes);
                    O000000o(o00000o, attributes);
                    this.O00000o0.O000000o(o00000o);
                    this.O00000o0 = o00000o;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("textPath")) {
                O000000o("<textPath>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O00Ooo00 o00Ooo00 = new SVG.O00Ooo00();
                    o00Ooo00.O0000oOo = this.O00000Oo;
                    o00Ooo00.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o00Ooo00, attributes);
                    O00000Oo(o00Ooo00, attributes);
                    O000000o((SVG.O00O00o) o00Ooo00, attributes);
                    O000000o(o00Ooo00, attributes);
                    this.O00000o0.O000000o(o00Ooo00);
                    this.O00000o0 = o00Ooo00;
                    if (o00Ooo00.O0000oo0 instanceof SVG.O00o000) {
                        o00Ooo00.O00000o0 = (SVG.O00o000) o00Ooo00.O0000oo0;
                    } else {
                        o00Ooo00.O00000o0 = ((SVG.O00OoO0o) o00Ooo00.O0000oo0).O0000O0o();
                    }
                } else {
                    throw new SAXException("Invalid document. Root element must be <svg>");
                }
            } else if (str2.equals("pattern")) {
                O000000o("<pattern>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O000o00 o000o00 = new SVG.O000o00();
                    o000o00.O0000oOo = this.O00000Oo;
                    o000o00.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o000o00, attributes);
                    O00000Oo(o000o00, attributes);
                    O000000o((SVG.O00O00o) o000o00, attributes);
                    O000000o((SVG.O00Oo00) o000o00, attributes);
                    O000000o(o000o00, attributes);
                    this.O00000o0.O000000o(o000o00);
                    this.O00000o0 = o000o00;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("image")) {
                O000000o("<image>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O000O0o o000O0o = new SVG.O000O0o();
                    o000O0o.O0000oOo = this.O00000Oo;
                    o000O0o.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o000O0o, attributes);
                    O00000Oo(o000O0o, attributes);
                    O000000o((SVG.O000O0o0) o000O0o, attributes);
                    O000000o((SVG.O00O00o) o000O0o, attributes);
                    O000000o(o000O0o, attributes);
                    this.O00000o0.O000000o(o000O0o);
                    this.O00000o0 = o000O0o;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("view")) {
                O000000o("<view>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O00oo000 o00oo000 = new SVG.O00oo000();
                    o00oo000.O0000oOo = this.O00000Oo;
                    o00oo000.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o00oo000, attributes);
                    O000000o((SVG.O00O00o) o00oo000, attributes);
                    O000000o((SVG.O00Oo00) o00oo000, attributes);
                    this.O00000o0.O000000o(o00oo000);
                    this.O00000o0 = o00oo000;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("mask")) {
                O000000o("<mask>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O000OOOo o000OOOo = new SVG.O000OOOo();
                    o000OOOo.O0000oOo = this.O00000Oo;
                    o000OOOo.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o000OOOo, attributes);
                    O00000Oo(o000OOOo, attributes);
                    O000000o((SVG.O00O00o) o000OOOo, attributes);
                    O000000o(o000OOOo, attributes);
                    this.O00000o0.O000000o(o000OOOo);
                    this.O00000o0 = o000OOOo;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("style")) {
                O00000Oo(attributes);
            } else if (str2.equals("solidColor")) {
                O000000o("<solidColor>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O00O000o o00O000o = new SVG.O00O000o();
                    o00O000o.O0000oOo = this.O00000Oo;
                    o00O000o.O0000oo0 = this.O00000o0;
                    O000000o(o00O000o, attributes);
                    O00000Oo(o00O000o, attributes);
                    this.O00000o0.O000000o(o00O000o);
                    this.O00000o0 = o00O000o;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("filter")) {
                O000000o("<filter>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O0000o0 o0000o0 = new SVG.O0000o0();
                    o0000o0.O0000oOo = this.O00000Oo;
                    o0000o0.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o0000o0, attributes);
                    O00000Oo(o0000o0, attributes);
                    this.O00000o0.O000000o(o0000o0);
                    this.O00000o0 = o0000o0;
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else if (str2.equals("feColorMatrix")) {
                O000000o("<feColorMatrix>", new Object[0]);
                if (this.O00000o0 != null) {
                    SVG.O0000o00 o0000o00 = new SVG.O0000o00();
                    o0000o00.O0000oOo = this.O00000Oo;
                    o0000o00.O0000oo0 = this.O00000o0;
                    O000000o((SVG.O00O0o0) o0000o00, attributes);
                    O00000Oo(o0000o00, attributes);
                    O000000o(o0000o00, attributes);
                    this.O00000o0.O000000o(o0000o00);
                    return;
                }
                throw new SAXException("Invalid document. Root element must be <svg>");
            } else {
                this.O00000o = true;
                this.O00000oO = 1;
            }
        }
    }

    public final void characters(char[] cArr, int i, int i2) throws SAXException {
        SVG.O00OO0O o00oo0o;
        if (!this.O00000o) {
            if (this.O00000oo) {
                if (this.O0000OOo == null) {
                    this.O0000OOo = new StringBuilder(i2);
                }
                this.O0000OOo.append(cArr, i, i2);
            } else if (this.O0000Oo0) {
                if (this.O0000Oo == null) {
                    this.O0000Oo = new StringBuilder(i2);
                }
                this.O0000Oo.append(cArr, i, i2);
            } else {
                SVG.O00O0Oo0 o00O0Oo0 = this.O00000o0;
                if (o00O0Oo0 instanceof SVG.O00OoOO0) {
                    SVG.O00O0O0o o00O0O0o = (SVG.O00O0O0o) o00O0Oo0;
                    int size = o00O0O0o.O0000Oo0.size();
                    if (size == 0) {
                        o00oo0o = null;
                    } else {
                        o00oo0o = o00O0O0o.O0000Oo0.get(size - 1);
                    }
                    if (o00oo0o instanceof SVG.O00o00) {
                        StringBuilder sb = new StringBuilder();
                        SVG.O00o00 o00o00 = (SVG.O00o00) o00oo0o;
                        sb.append(o00o00.f11893O000000o);
                        sb.append(new String(cArr, i, i2));
                        o00o00.f11893O000000o = sb.toString();
                        return;
                    }
                    ((SVG.O00O0O0o) this.O00000o0).O000000o(new SVG.O00o00(new String(cArr, i, i2)));
                }
            }
        }
    }

    public final void comment(char[] cArr, int i, int i2) throws SAXException {
        if (!this.O00000o && this.O0000Oo0) {
            if (this.O0000Oo == null) {
                this.O0000Oo = new StringBuilder(i2);
            }
            this.O0000Oo.append(cArr, i, i2);
        }
    }

    public final void endElement(String str, String str2, String str3) throws SAXException {
        StringBuilder sb;
        super.endElement(str, str2, str3);
        if (this.O00000o) {
            int i = this.O00000oO - 1;
            this.O00000oO = i;
            if (i == 0) {
                this.O00000o = false;
                return;
            }
        }
        if (!"http://www.w3.org/2000/svg".equals(str) && !"".equals(str)) {
            return;
        }
        if (str2.equals("title") || str2.equals("desc")) {
            this.O00000oo = false;
            if (this.O0000O0o.equals("title")) {
                this.O00000Oo.O00000o = this.O0000OOo.toString();
            } else if (this.O0000O0o.equals("desc")) {
                this.O00000Oo.O00000oO = this.O0000OOo.toString();
            }
            this.O0000OOo.setLength(0);
        } else if (str2.equals("style") && (sb = this.O0000Oo) != null) {
            this.O0000Oo0 = false;
            String sb2 = sb.toString();
            CSSParser cSSParser = new CSSParser(CSSParser.MediaType.screen);
            SVG svg = this.O00000Oo;
            CSSParser.O00000Oo o00000Oo = new CSSParser.O00000Oo(sb2);
            o00000Oo.O00000o();
            svg.O00000oo.O000000o(cSSParser.O00000Oo(o00000Oo));
            this.O0000Oo.setLength(0);
        } else if (str2.equals("svg") || str2.equals("defs") || str2.equals("g") || str2.equals("filter") || str2.equals("use") || str2.equals("image") || str2.equals("text") || str2.equals("tspan") || str2.equals("switch") || str2.equals("symbol") || str2.equals("marker") || str2.equals("linearGradient") || str2.equals("radialGradient") || str2.equals("stop") || str2.equals("clipPath") || str2.equals("textPath") || str2.equals("pattern") || str2.equals("view") || str2.equals("mask") || str2.equals("solidColor")) {
            this.O00000o0 = ((SVG.O00OO0O) this.O00000o0).O0000oo0;
        }
    }

    public final void endDocument() throws SAXException {
        super.endDocument();
    }

    private static void O000000o(String str, Object... objArr) {
        gsy.O000000o(3, "SVGParser", String.format(str, objArr));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void */
    private void O000000o(Attributes attributes) throws SAXException {
        O000000o("<g>", new Object[0]);
        if (this.O00000o0 != null) {
            SVG.O000O0OO o000o0oo = new SVG.O000O0OO();
            o000o0oo.O0000oOo = this.O00000Oo;
            o000o0oo.O0000oo0 = this.O00000o0;
            O000000o((SVG.O00O0o0) o000o0oo, attributes);
            O00000Oo(o000o0oo, attributes);
            O000000o((SVG.O000O0o0) o000o0oo, attributes);
            O000000o(o000o0oo, attributes);
            O000000o((SVG.O00O00o) o000o0oo, attributes);
            this.O00000o0.O000000o(o000o0oo);
            this.O00000o0 = o000o0oo;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private static void O000000o(SVG.O000O0OO o000o0oo, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String localName = attributes.getLocalName(i);
            if (SVGAttr.fromString(localName) == SVGAttr.filter) {
                o000o0oo.O00000o0 = O00000Oo(attributes.getValue(i), localName);
            }
        }
    }

    private static void O000000o(SVG.O0000o00 o0000o00, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 6) {
                o0000o00.O00000o0 = trim;
            } else if (i2 == 7) {
                o0000o00.O00000Oo = trim;
            } else if (i2 == 8) {
                try {
                    String[] split = trim.split(" ");
                    float[] fArr = new float[split.length];
                    for (int i3 = 0; i3 < split.length; i3++) {
                        fArr[i3] = Float.parseFloat(split[i3]);
                    }
                    o0000o00.f11875O000000o = fArr;
                } catch (NumberFormatException e) {
                    gsy.O000000o(4, "SVGParser", Log.getStackTraceString(e));
                    return;
                }
            }
        }
    }

    private static void O000000o(SVG.O00o0 o00o0, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                o00o0.O00000o = O00000o0(trim);
            } else if (i2 == 2) {
                o00o0.O00000oO = O00000o0(trim);
            } else if (i2 == 3) {
                o00o0.O00000oo = O00000o0(trim);
                if (o00o0.O00000oo.O00000Oo()) {
                    throw new SAXException("Invalid <use> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                o00o0.O0000O0o = O00000o0(trim);
                if (o00o0.O0000O0o.O00000Oo()) {
                    throw new SAXException("Invalid <use> element. height cannot be negative");
                }
            } else if (i2 == 9 && "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                o00o0.f11892O000000o = trim;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O000O0o, java.lang.String]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void */
    private static void O000000o(SVG.O000O0o o000O0o, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                o000O0o.O00000Oo = O00000o0(trim);
            } else if (i2 == 2) {
                o000O0o.O00000o0 = O00000o0(trim);
            } else if (i2 == 3) {
                o000O0o.O00000o = O00000o0(trim);
                if (o000O0o.O00000o.O00000Oo()) {
                    throw new SAXException("Invalid <use> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                o000O0o.O00000oO = O00000o0(trim);
                if (o000O0o.O00000oO.O00000Oo()) {
                    throw new SAXException("Invalid <use> element. height cannot be negative");
                }
            } else if (i2 != 9) {
                if (i2 == 10) {
                    O000000o((SVG.O00OOo0) o000O0o, trim);
                }
            } else if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                o000O0o.f11876O000000o = trim;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x048f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x046c  */
    private static void O000000o(SVG.O000Oo0 o000Oo0, Attributes attributes) throws SAXException {
        int intValue;
        float floatValue;
        float f;
        float f2;
        float f3;
        float floatValue2;
        SVG.O000Oo0 o000Oo02 = o000Oo0;
        Attributes attributes2 = attributes;
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes2.getValue(i).trim();
            int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes2.getLocalName(i)).ordinal()];
            if (i2 == 11) {
                O000000o o000000o = new O000000o(trim);
                SVG.O00O0Oo o00O0Oo = new SVG.O00O0Oo();
                if (!o000000o.O00000o0() && ((intValue = o000000o.O0000Oo0().intValue()) == 77 || intValue == 109)) {
                    float f4 = 0.0f;
                    float f5 = 0.0f;
                    float f6 = 0.0f;
                    float f7 = 0.0f;
                    float f8 = 0.0f;
                    float f9 = 0.0f;
                    while (true) {
                        o000000o.O00000o();
                        switch (intValue) {
                            case 65:
                            case 97:
                                Float O00000oo2 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo3 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo4 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Boolean O0000OoO2 = o000000o.O0000OoO();
                                o000000o.O00000oO();
                                Boolean O0000OoO3 = o000000o.O0000OoO();
                                o000000o.O00000oO();
                                Float O00000oo5 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo6 = o000000o.O00000oo();
                                if (O00000oo6 != null && O00000oo2.floatValue() >= 0.0f && O00000oo3.floatValue() >= 0.0f) {
                                    if (intValue == 97) {
                                        O00000oo5 = Float.valueOf(O00000oo5.floatValue() + f4);
                                        O00000oo6 = Float.valueOf(O00000oo6.floatValue() + f6);
                                    }
                                    o00O0Oo.O000000o(O00000oo2.floatValue(), O00000oo3.floatValue(), O00000oo4.floatValue(), O0000OoO2.booleanValue(), O0000OoO3.booleanValue(), O00000oo5.floatValue(), O00000oo6.floatValue());
                                    f5 = O00000oo5.floatValue();
                                    floatValue = O00000oo6.floatValue();
                                    f7 = floatValue;
                                    f4 = f5;
                                    o000000o.O00000o();
                                    if (!o000000o.O00000o0()) {
                                        break;
                                    } else if (o000000o.O0000o()) {
                                        intValue = o000000o.O0000Oo0().intValue();
                                    }
                                } else {
                                    gsy.O000000o(6, "SVGParser", "Bad path coords for " + intValue + " path segment");
                                    break;
                                }
                                break;
                            case 67:
                            case 99:
                                Float O00000oo7 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo8 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo9 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo10 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo11 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo12 = o000000o.O00000oo();
                                if (O00000oo12 == null) {
                                    gsy.O000000o(6, "SVGParser", "Bad path coords for " + intValue + " path segment");
                                    break;
                                } else {
                                    if (intValue == 99) {
                                        O00000oo11 = Float.valueOf(O00000oo11.floatValue() + f4);
                                        O00000oo12 = Float.valueOf(O00000oo12.floatValue() + f6);
                                        O00000oo7 = Float.valueOf(O00000oo7.floatValue() + f4);
                                        O00000oo8 = Float.valueOf(O00000oo8.floatValue() + f6);
                                        O00000oo9 = Float.valueOf(O00000oo9.floatValue() + f4);
                                        O00000oo10 = Float.valueOf(O00000oo10.floatValue() + f6);
                                    }
                                    Float f10 = O00000oo9;
                                    o00O0Oo.O000000o(O00000oo7.floatValue(), O00000oo8.floatValue(), f10.floatValue(), O00000oo10.floatValue(), O00000oo11.floatValue(), O00000oo12.floatValue());
                                    f3 = f10.floatValue();
                                    f2 = O00000oo10.floatValue();
                                    f = O00000oo11.floatValue();
                                    floatValue2 = O00000oo12.floatValue();
                                    f7 = f2;
                                    f4 = f;
                                    f5 = f3;
                                    o000000o.O00000o();
                                    if (!o000000o.O00000o0()) {
                                    }
                                }
                                break;
                            case 72:
                            case 104:
                                Float O00000oo13 = o000000o.O00000oo();
                                if (O00000oo13 == null) {
                                    gsy.O000000o(6, "SVGParser", "Bad path coords for " + intValue + " path segment");
                                    break;
                                } else {
                                    if (intValue == 104) {
                                        O00000oo13 = Float.valueOf(O00000oo13.floatValue() + f4);
                                    }
                                    o00O0Oo.O00000Oo(O00000oo13.floatValue(), f6);
                                    f4 = O00000oo13.floatValue();
                                    f5 = f4;
                                    o000000o.O00000o();
                                    if (!o000000o.O00000o0()) {
                                    }
                                }
                                break;
                            case 76:
                            case 108:
                                Float O00000oo14 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo15 = o000000o.O00000oo();
                                if (O00000oo15 == null) {
                                    gsy.O000000o(6, "SVGParser", "Bad path coords for " + intValue + " path segment");
                                    break;
                                } else {
                                    if (intValue == 108) {
                                        O00000oo14 = Float.valueOf(O00000oo14.floatValue() + f4);
                                        O00000oo15 = Float.valueOf(O00000oo15.floatValue() + f6);
                                    }
                                    o00O0Oo.O00000Oo(O00000oo14.floatValue(), O00000oo15.floatValue());
                                    f5 = O00000oo14.floatValue();
                                    floatValue = O00000oo15.floatValue();
                                    f7 = floatValue;
                                    f4 = f5;
                                    o000000o.O00000o();
                                    if (!o000000o.O00000o0()) {
                                    }
                                }
                                break;
                            case 77:
                            case 109:
                                Float O00000oo16 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo17 = o000000o.O00000oo();
                                if (O00000oo17 == null) {
                                    gsy.O000000o(6, "SVGParser", "Bad path coords for " + intValue + " path segment");
                                    break;
                                } else {
                                    if (intValue == 109 && !o00O0Oo.f11887O000000o.isEmpty()) {
                                        O00000oo16 = Float.valueOf(O00000oo16.floatValue() + f4);
                                        O00000oo17 = Float.valueOf(O00000oo17.floatValue() + f6);
                                    }
                                    o00O0Oo.O000000o(O00000oo16.floatValue(), O00000oo17.floatValue());
                                    float floatValue3 = O00000oo16.floatValue();
                                    f5 = floatValue3;
                                    f8 = f5;
                                    f6 = O00000oo17.floatValue();
                                    f7 = f6;
                                    f9 = f7;
                                    intValue = intValue == 109 ? 108 : 76;
                                    f4 = f8;
                                    o000000o.O00000o();
                                    if (!o000000o.O00000o0()) {
                                    }
                                }
                                break;
                            case 81:
                            case 113:
                                Float O00000oo18 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo19 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo20 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo21 = o000000o.O00000oo();
                                if (O00000oo21 == null) {
                                    gsy.O000000o(6, "SVGParser", "Bad path coords for " + intValue + " path segment");
                                    break;
                                } else {
                                    if (intValue == 113) {
                                        O00000oo20 = Float.valueOf(O00000oo20.floatValue() + f4);
                                        O00000oo21 = Float.valueOf(O00000oo21.floatValue() + f6);
                                        O00000oo18 = Float.valueOf(O00000oo18.floatValue() + f4);
                                        O00000oo19 = Float.valueOf(O00000oo19.floatValue() + f6);
                                    }
                                    o00O0Oo.O000000o(O00000oo18.floatValue(), O00000oo19.floatValue(), O00000oo20.floatValue(), O00000oo21.floatValue());
                                    f3 = O00000oo18.floatValue();
                                    f2 = O00000oo19.floatValue();
                                    f = O00000oo20.floatValue();
                                    floatValue2 = O00000oo21.floatValue();
                                    f7 = f2;
                                    f4 = f;
                                    f5 = f3;
                                    o000000o.O00000o();
                                    if (!o000000o.O00000o0()) {
                                    }
                                }
                                break;
                            case 83:
                            case 115:
                                Float valueOf = Float.valueOf((f4 * 2.0f) - f5);
                                Float valueOf2 = Float.valueOf((2.0f * f6) - f7);
                                Float O00000oo22 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo23 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo24 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo25 = o000000o.O00000oo();
                                if (O00000oo25 == null) {
                                    gsy.O000000o(6, "SVGParser", "Bad path coords for " + intValue + " path segment");
                                    break;
                                } else {
                                    if (intValue == 115) {
                                        O00000oo24 = Float.valueOf(O00000oo24.floatValue() + f4);
                                        O00000oo25 = Float.valueOf(O00000oo25.floatValue() + f6);
                                        O00000oo22 = Float.valueOf(O00000oo22.floatValue() + f4);
                                        O00000oo23 = Float.valueOf(O00000oo23.floatValue() + f6);
                                    }
                                    Float f11 = O00000oo22;
                                    o00O0Oo.O000000o(valueOf.floatValue(), valueOf2.floatValue(), f11.floatValue(), O00000oo23.floatValue(), O00000oo24.floatValue(), O00000oo25.floatValue());
                                    f3 = f11.floatValue();
                                    f2 = O00000oo23.floatValue();
                                    f = O00000oo24.floatValue();
                                    floatValue2 = O00000oo25.floatValue();
                                    f7 = f2;
                                    f4 = f;
                                    f5 = f3;
                                    o000000o.O00000o();
                                    if (!o000000o.O00000o0()) {
                                    }
                                }
                                break;
                            case 84:
                            case 116:
                                Float valueOf3 = Float.valueOf((f4 * 2.0f) - f5);
                                Float valueOf4 = Float.valueOf((2.0f * f6) - f7);
                                Float O00000oo26 = o000000o.O00000oo();
                                o000000o.O00000oO();
                                Float O00000oo27 = o000000o.O00000oo();
                                if (O00000oo27 == null) {
                                    gsy.O000000o(6, "SVGParser", "Bad path coords for " + intValue + " path segment");
                                    break;
                                } else {
                                    if (intValue == 116) {
                                        O00000oo26 = Float.valueOf(O00000oo26.floatValue() + f4);
                                        O00000oo27 = Float.valueOf(O00000oo27.floatValue() + f6);
                                    }
                                    o00O0Oo.O000000o(valueOf3.floatValue(), valueOf4.floatValue(), O00000oo26.floatValue(), O00000oo27.floatValue());
                                    f3 = valueOf3.floatValue();
                                    f2 = valueOf4.floatValue();
                                    f = O00000oo26.floatValue();
                                    floatValue2 = O00000oo27.floatValue();
                                    f7 = f2;
                                    f4 = f;
                                    f5 = f3;
                                    o000000o.O00000o();
                                    if (!o000000o.O00000o0()) {
                                    }
                                }
                                break;
                            case 86:
                            case 118:
                                Float O00000oo28 = o000000o.O00000oo();
                                if (O00000oo28 == null) {
                                    gsy.O000000o(6, "SVGParser", "Bad path coords for " + intValue + " path segment");
                                    break;
                                } else {
                                    if (intValue == 118) {
                                        O00000oo28 = Float.valueOf(O00000oo28.floatValue() + f6);
                                    }
                                    o00O0Oo.O00000Oo(f4, O00000oo28.floatValue());
                                    f6 = O00000oo28.floatValue();
                                    f7 = f6;
                                    o000000o.O00000o();
                                    if (!o000000o.O00000o0()) {
                                    }
                                }
                                break;
                            case 90:
                            case 122:
                                o00O0Oo.O000000o();
                                f4 = f8;
                                f5 = f4;
                                f6 = f9;
                                f7 = f6;
                                o000000o.O00000o();
                                if (!o000000o.O00000o0()) {
                                }
                                break;
                        }
                    }
                }
                o000Oo02.f11882O000000o = o00O0Oo;
            } else if (i2 != 12) {
                continue;
            } else {
                o000Oo02.O00000Oo = Float.valueOf(O00000oO(trim));
                if (o000Oo02.O00000Oo.floatValue() < 0.0f) {
                    throw new SAXException("Invalid <path> element. pathLength cannot be negative");
                }
            }
        }
    }

    private static void O000000o(SVG.oooOoO oooooo, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                oooooo.f11897O000000o = O00000o0(trim);
            } else if (i2 == 2) {
                oooooo.O00000Oo = O00000o0(trim);
            } else if (i2 == 3) {
                oooooo.O00000o0 = O00000o0(trim);
                if (oooooo.O00000o0.O00000Oo()) {
                    throw new SAXException("Invalid <rect> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                oooooo.O00000o = O00000o0(trim);
                if (oooooo.O00000o.O00000Oo()) {
                    throw new SAXException("Invalid <rect> element. height cannot be negative");
                }
            } else if (i2 == 13) {
                oooooo.O00000oo = O00000o0(trim);
                if (oooooo.O00000oo.O00000Oo()) {
                    throw new SAXException("Invalid <rect> element. rx cannot be negative");
                }
            } else if (i2 != 14) {
                continue;
            } else {
                oooooo.O0000O0o = O00000o0(trim);
                if (oooooo.O0000O0o.O00000Oo()) {
                    throw new SAXException("Invalid <rect> element. ry cannot be negative");
                }
            }
        }
    }

    private static void O000000o(SVG.O00000o0 o00000o0, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    o00000o0.f11871O000000o = O00000o0(trim);
                    break;
                case 16:
                    o00000o0.O00000Oo = O00000o0(trim);
                    break;
                case 17:
                    o00000o0.O00000o0 = O00000o0(trim);
                    if (!o00000o0.O00000o0.O00000Oo()) {
                        break;
                    } else {
                        throw new SAXException("Invalid <circle> element. r cannot be negative");
                    }
            }
        }
    }

    private static void O000000o(SVG.O0000Oo o0000Oo, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 13:
                    o0000Oo.O00000o0 = O00000o0(trim);
                    if (!o0000Oo.O00000o0.O00000Oo()) {
                        break;
                    } else {
                        throw new SAXException("Invalid <ellipse> element. rx cannot be negative");
                    }
                case 14:
                    o0000Oo.O00000o = O00000o0(trim);
                    if (!o0000Oo.O00000o.O00000Oo()) {
                        break;
                    } else {
                        throw new SAXException("Invalid <ellipse> element. ry cannot be negative");
                    }
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    o0000Oo.f11874O000000o = O00000o0(trim);
                    break;
                case 16:
                    o0000Oo.O00000Oo = O00000o0(trim);
                    break;
            }
        }
    }

    private static void O000000o(SVG.O000OO0o o000OO0o, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    o000OO0o.f11879O000000o = O00000o0(trim);
                    break;
                case y1:
                    o000OO0o.O00000Oo = O00000o0(trim);
                    break;
                case x2:
                    o000OO0o.O00000o0 = O00000o0(trim);
                    break;
                case y2:
                    o000OO0o.O00000o = O00000o0(trim);
                    break;
            }
        }
    }

    private static void O000000o(SVG.O000o0 o000o0, Attributes attributes, String str) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                O000000o o000000o = new O000000o(attributes.getValue(i));
                ArrayList<Float> arrayList = new ArrayList<>();
                o000000o.O00000o();
                while (!o000000o.O00000o0()) {
                    Float O00000oo2 = o000000o.O00000oo();
                    if (O00000oo2 != null) {
                        o000000o.O00000oO();
                        Float O00000oo3 = o000000o.O00000oo();
                        if (O00000oo3 != null) {
                            o000000o.O00000oO();
                            arrayList.add(O00000oo2);
                            arrayList.add(O00000oo3);
                        } else {
                            throw new SAXException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                        }
                    } else {
                        throw new SAXException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                }
                o000o0.f11883O000000o = new float[arrayList.size()];
                int i2 = 0;
                for (Float floatValue : arrayList) {
                    o000o0.f11883O000000o[i2] = floatValue.floatValue();
                    i2++;
                }
            }
        }
    }

    private static void O000000o(SVG.O00o0000 o00o0000, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                o00o0000.O00000Oo = O00000o(trim);
            } else if (i2 == 2) {
                o00o0000.O00000o0 = O00000o(trim);
            } else if (i2 == 22) {
                o00o0000.O00000o = O00000o(trim);
            } else if (i2 == 23) {
                o00o0000.O00000oO = O00000o(trim);
            }
        }
    }

    private static void O000000o(SVG.O00Oo0OO o00Oo0OO, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 9 && "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                o00Oo0OO.f11889O000000o = trim;
            }
        }
    }

    private static void O000000o(SVG.O00O00o o00O00o, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case requiredFeatures:
                    o00O00o.O000000o(O0000ooO(trim));
                    break;
                case requiredExtensions:
                    o00O00o.O000000o(trim);
                    break;
                case systemLanguage:
                    o00O00o.O00000Oo(O0000ooo(trim));
                    break;
                case requiredFormats:
                    o00O00o.O00000o0(O00oOooO(trim));
                    break;
                case requiredFonts:
                    List<String> O0000Oo2 = O0000Oo(trim);
                    o00O00o.O00000o(O0000Oo2 != null ? new HashSet(O0000Oo2) : new HashSet(0));
                    break;
            }
        }
    }

    private static void O000000o(SVG.O000OO o000oo, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case refX:
                    o000oo.O00000Oo = O00000o0(trim);
                    break;
                case refY:
                    o000oo.O00000o0 = O00000o0(trim);
                    break;
                case markerWidth:
                    o000oo.O00000o = O00000o0(trim);
                    if (!o000oo.O00000o.O00000Oo()) {
                        break;
                    } else {
                        throw new SAXException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                case markerHeight:
                    o000oo.O00000oO = O00000o0(trim);
                    if (!o000oo.O00000oO.O00000Oo()) {
                        break;
                    } else {
                        throw new SAXException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                case markerUnits:
                    if ("strokeWidth".equals(trim)) {
                        o000oo.f11877O000000o = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        o000oo.f11877O000000o = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute markerUnits");
                    }
                case orient:
                    if (!"auto".equals(trim)) {
                        o000oo.O00000oo = Float.valueOf(O00000oO(trim));
                        break;
                    } else {
                        o000oo.O00000oo = Float.valueOf(Float.NaN);
                        break;
                    }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007e, code lost:
        continue;
     */
    private static void O000000o(SVG.O00oOooO o00oOooO, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 != 9) {
                switch (i2) {
                    case 35:
                        if ("objectBoundingBox".equals(trim)) {
                            o00oOooO.O00000Oo = Boolean.FALSE;
                            continue;
                        } else if ("userSpaceOnUse".equals(trim)) {
                            o00oOooO.O00000Oo = Boolean.TRUE;
                            break;
                        } else {
                            throw new SAXException("Invalid value for attribute gradientUnits");
                        }
                    case 36:
                        o00oOooO.O00000o0 = O00000Oo(trim);
                        continue;
                    case 37:
                        try {
                            o00oOooO.O00000o = SVG.GradientSpread.valueOf(trim);
                            continue;
                        } catch (IllegalArgumentException unused) {
                            throw new SAXException("Invalid spreadMethod attribute. \"" + trim + "\" is not a valid value.");
                        }
                }
            } else if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                o00oOooO.O00000oO = trim;
            }
        }
    }

    private static void O000000o(SVG.O00O0o o00O0o, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    o00O0o.O00000oo = O00000o0(trim);
                    break;
                case y1:
                    o00O0o.O0000O0o = O00000o0(trim);
                    break;
                case x2:
                    o00O0o.O0000OOo = O00000o0(trim);
                    break;
                case y2:
                    o00O0o.O0000Oo0 = O00000o0(trim);
                    break;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        continue;
     */
    private static void O000000o(SVG.O00OOo o00OOo, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 38) {
                o00OOo.O0000Oo0 = O00000o0(trim);
            } else if (i2 != 39) {
                switch (i2) {
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        o00OOo.O00000oo = O00000o0(trim);
                        continue;
                    case 16:
                        o00OOo.O0000O0o = O00000o0(trim);
                        continue;
                    case 17:
                        o00OOo.O0000OOo = O00000o0(trim);
                        if (!o00OOo.O0000OOo.O00000Oo()) {
                            continue;
                        } else {
                            throw new SAXException("Invalid <radialGradient> element. r cannot be negative");
                        }
                }
            } else {
                o00OOo.O0000Oo = O00000o0(trim);
            }
        }
    }

    private static void O000000o(SVG.O00O00Oo o00O00Oo, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 40) {
                o00O00Oo.f11885O000000o = O000000o(trim);
            }
        }
    }

    private static Float O000000o(String str) throws SAXException {
        if (str.length() != 0) {
            int length = str.length();
            boolean z = true;
            if (str.charAt(str.length() - 1) == '%') {
                length--;
            } else {
                z = false;
            }
            try {
                float parseFloat = Float.parseFloat(str.substring(0, length));
                if (z) {
                    parseFloat /= 100.0f;
                }
                if (parseFloat < 0.0f) {
                    parseFloat = 0.0f;
                } else if (parseFloat > 100.0f) {
                    parseFloat = 100.0f;
                }
                return Float.valueOf(parseFloat);
            } catch (NumberFormatException e) {
                throw new SAXException("Invalid offset value in <stop>: ".concat(String.valueOf(str)), e);
            }
        } else {
            throw new SAXException("Invalid offset value in <stop> (empty string)");
        }
    }

    private static void O000000o(SVG.O00000o o00000o, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 41) {
                if ("objectBoundingBox".equals(trim)) {
                    o00000o.f11870O000000o = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    o00000o.f11870O000000o = Boolean.TRUE;
                } else {
                    throw new SAXException("Invalid value for attribute clipPathUnits");
                }
            }
        }
    }

    private static void O000000o(SVG.O00Ooo00 o00Ooo00, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 != 9) {
                if (i2 == 42) {
                    o00Ooo00.O00000Oo = O00000o0(trim);
                }
            } else if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                o00Ooo00.f11891O000000o = trim;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c8, code lost:
        continue;
     */
    private static void O000000o(SVG.O000o00 o000o00, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                o000o00.O00000o = O00000o0(trim);
            } else if (i2 == 2) {
                o000o00.O00000oO = O00000o0(trim);
            } else if (i2 == 3) {
                o000o00.O00000oo = O00000o0(trim);
                if (o000o00.O00000oo.O00000Oo()) {
                    throw new SAXException("Invalid <pattern> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                o000o00.O0000O0o = O00000o0(trim);
                if (o000o00.O0000O0o.O00000Oo()) {
                    throw new SAXException("Invalid <pattern> element. height cannot be negative");
                }
            } else if (i2 != 9) {
                switch (i2) {
                    case 43:
                        if ("objectBoundingBox".equals(trim)) {
                            o000o00.f11884O000000o = Boolean.FALSE;
                            continue;
                        } else if ("userSpaceOnUse".equals(trim)) {
                            o000o00.f11884O000000o = Boolean.TRUE;
                            break;
                        } else {
                            throw new SAXException("Invalid value for attribute patternUnits");
                        }
                    case 44:
                        if ("objectBoundingBox".equals(trim)) {
                            o000o00.O00000Oo = Boolean.FALSE;
                            continue;
                        } else if ("userSpaceOnUse".equals(trim)) {
                            o000o00.O00000Oo = Boolean.TRUE;
                            break;
                        } else {
                            throw new SAXException("Invalid value for attribute patternContentUnits");
                        }
                    case 45:
                        o000o00.O00000o0 = O00000Oo(trim);
                        continue;
                }
            } else if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                o000o00.O0000OOo = trim;
            }
        }
    }

    private static void O000000o(SVG.O000OOOo o000OOOo, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                o000OOOo.O00000o0 = O00000o0(trim);
            } else if (i2 == 2) {
                o000OOOo.O00000o = O00000o0(trim);
            } else if (i2 == 3) {
                o000OOOo.O00000oO = O00000o0(trim);
                if (o000OOOo.O00000oO.O00000Oo()) {
                    throw new SAXException("Invalid <mask> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                o000OOOo.O00000oo = O00000o0(trim);
                if (o000OOOo.O00000oo.O00000Oo()) {
                    throw new SAXException("Invalid <mask> element. height cannot be negative");
                }
            } else if (i2 != 46) {
                if (i2 != 47) {
                    continue;
                } else if ("objectBoundingBox".equals(trim)) {
                    o000OOOo.O00000Oo = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    o000OOOo.O00000Oo = Boolean.TRUE;
                } else {
                    throw new SAXException("Invalid value for attribute maskContentUnits");
                }
            } else if ("objectBoundingBox".equals(trim)) {
                o000OOOo.f11880O000000o = Boolean.FALSE;
            } else if ("userSpaceOnUse".equals(trim)) {
                o000OOOo.f11880O000000o = Boolean.TRUE;
            } else {
                throw new SAXException("Invalid value for attribute maskUnits");
            }
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        protected String f11900O000000o;
        protected int O00000Oo = 0;

        protected static boolean O000000o(int i) {
            return i == 32 || i == 10 || i == 13 || i == 9;
        }

        public O000000o(String str) {
            this.f11900O000000o = str.trim();
        }

        public final boolean O00000o0() {
            return this.O00000Oo == this.f11900O000000o.length();
        }

        public final void O00000o() {
            while (this.O00000Oo < this.f11900O000000o.length() && O000000o((int) this.f11900O000000o.charAt(this.O00000Oo))) {
                this.O00000Oo++;
            }
        }

        public final boolean O00000oO() {
            O00000o();
            if (this.O00000Oo == this.f11900O000000o.length() || this.f11900O000000o.charAt(this.O00000Oo) != ',') {
                return false;
            }
            this.O00000Oo++;
            O00000o();
            return true;
        }

        public final Float O0000O0o() {
            int i = this.O00000Oo;
            O00000oO();
            Float O00000oo = O00000oo();
            if (O00000oo != null) {
                return O00000oo;
            }
            this.O00000Oo = i;
            return null;
        }

        public final Integer O0000Oo0() {
            if (this.O00000Oo == this.f11900O000000o.length()) {
                return null;
            }
            String str = this.f11900O000000o;
            int i = this.O00000Oo;
            this.O00000Oo = i + 1;
            return Integer.valueOf(str.charAt(i));
        }

        public final SVG.O000OO00 O0000Oo() {
            Float O00000oo = O00000oo();
            if (O00000oo == null) {
                return null;
            }
            SVG.Unit O0000o0o = O0000o0o();
            if (O0000o0o == null) {
                return new SVG.O000OO00(O00000oo.floatValue(), SVG.Unit.px);
            }
            return new SVG.O000OO00(O00000oo.floatValue(), O0000o0o);
        }

        public final Boolean O0000OoO() {
            if (this.O00000Oo == this.f11900O000000o.length()) {
                return null;
            }
            char charAt = this.f11900O000000o.charAt(this.O00000Oo);
            if (charAt != '0' && charAt != '1') {
                return null;
            }
            boolean z = true;
            this.O00000Oo++;
            if (charAt != '1') {
                z = false;
            }
            return Boolean.valueOf(z);
        }

        public final boolean O000000o(char c) {
            boolean z = this.O00000Oo < this.f11900O000000o.length() && this.f11900O000000o.charAt(this.O00000Oo) == c;
            if (z) {
                this.O00000Oo++;
            }
            return z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
        public final boolean O000000o(String str) {
            boolean z;
            int length = str.length();
            if (this.O00000Oo <= this.f11900O000000o.length() - length) {
                String str2 = this.f11900O000000o;
                int i = this.O00000Oo;
                if (str2.substring(i, i + length).equals(str)) {
                    z = true;
                    if (z) {
                        this.O00000Oo += length;
                    }
                    return z;
                }
            }
            z = false;
            if (z) {
            }
            return z;
        }

        /* access modifiers changed from: protected */
        public final int O0000Ooo() {
            if (this.O00000Oo == this.f11900O000000o.length()) {
                return -1;
            }
            this.O00000Oo++;
            if (this.O00000Oo < this.f11900O000000o.length()) {
                return this.f11900O000000o.charAt(this.O00000Oo);
            }
            return -1;
        }

        public final String O0000o00() {
            return O00000Oo(' ');
        }

        public final String O00000Oo(char c) {
            if (O00000o0()) {
                return null;
            }
            char charAt = this.f11900O000000o.charAt(this.O00000Oo);
            if (O000000o((int) charAt) || charAt == c) {
                return null;
            }
            int i = this.O00000Oo;
            int O0000Ooo = O0000Ooo();
            while (O0000Ooo != -1 && O0000Ooo != c && !O000000o(O0000Ooo)) {
                O0000Ooo = O0000Ooo();
            }
            return this.f11900O000000o.substring(i, this.O00000Oo);
        }

        public final String O0000o0() {
            if (O00000o0()) {
                return null;
            }
            int i = this.O00000Oo;
            int charAt = this.f11900O000000o.charAt(i);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    int i2 = this.O00000Oo;
                } else {
                    charAt = O0000Ooo();
                }
            }
            int i22 = this.O00000Oo;
            while (O000000o(charAt)) {
                charAt = O0000Ooo();
            }
            if (charAt == 40) {
                this.O00000Oo++;
                return this.f11900O000000o.substring(i, i22);
            }
            this.O00000Oo = i;
            return null;
        }

        public final String O0000o0O() {
            int i = this.O00000Oo;
            while (!O00000o0() && !O000000o((int) this.f11900O000000o.charAt(this.O00000Oo))) {
                this.O00000Oo++;
            }
            String substring = this.f11900O000000o.substring(i, this.O00000Oo);
            this.O00000Oo = i;
            return substring;
        }

        public final SVG.Unit O0000o0o() {
            if (O00000o0()) {
                return null;
            }
            if (this.f11900O000000o.charAt(this.O00000Oo) == '%') {
                this.O00000Oo++;
                return SVG.Unit.percent;
            } else if (this.O00000Oo > this.f11900O000000o.length() - 2) {
                return null;
            } else {
                try {
                    SVG.Unit valueOf = SVG.Unit.valueOf(this.f11900O000000o.substring(this.O00000Oo, this.O00000Oo + 2).toLowerCase(Locale.US));
                    this.O00000Oo += 2;
                    return valueOf;
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }
        }

        public final boolean O0000o() {
            if (this.O00000Oo == this.f11900O000000o.length()) {
                return false;
            }
            char charAt = this.f11900O000000o.charAt(this.O00000Oo);
            if (charAt >= 'a' && charAt <= 'z') {
                return true;
            }
            if (charAt < 'A' || charAt > 'Z') {
                return false;
            }
            return true;
        }

        public final String O0000oO0() {
            int O0000Ooo;
            if (O00000o0()) {
                return null;
            }
            int i = this.O00000Oo;
            char charAt = this.f11900O000000o.charAt(i);
            if (charAt != '\'' && charAt != '\"') {
                return null;
            }
            do {
                O0000Ooo = O0000Ooo();
                if (O0000Ooo == -1) {
                    break;
                }
            } while (O0000Ooo != charAt);
            if (O0000Ooo == -1) {
                this.O00000Oo = i;
                return null;
            }
            this.O00000Oo++;
            return this.f11900O000000o.substring(i + 1, this.O00000Oo - 1);
        }

        public final String O0000oO() {
            if (O00000o0()) {
                return null;
            }
            int i = this.O00000Oo;
            this.O00000Oo = this.f11900O000000o.length();
            return this.f11900O000000o.substring(i);
        }

        public final Float O00000oo() {
            int i;
            int i2;
            int i3;
            int i4;
            if (O00000o0()) {
                i = this.O00000Oo;
            } else {
                int i5 = this.O00000Oo;
                int charAt = this.f11900O000000o.charAt(i5);
                if (charAt == 45 || charAt == 43) {
                    charAt = O0000Ooo();
                }
                if (Character.isDigit(i2)) {
                    int O0000Ooo = O0000Ooo();
                    i3 = this.O00000Oo + 1;
                    i2 = O0000Ooo;
                    while (Character.isDigit(i2)) {
                        i3 = this.O00000Oo + 1;
                        i2 = O0000Ooo();
                    }
                } else {
                    i3 = i5;
                }
                if (i2 == 46) {
                    int O0000Ooo2 = O0000Ooo();
                    int i6 = this.O00000Oo + 1;
                    int i7 = O0000Ooo2;
                    while (Character.isDigit(i2)) {
                        i6 = this.O00000Oo + 1;
                        i7 = O0000Ooo();
                    }
                }
                if (i2 == 101 || i2 == 69) {
                    int O0000Ooo3 = O0000Ooo();
                    if (O0000Ooo3 == 45 || O0000Ooo3 == 43) {
                        O0000Ooo3 = O0000Ooo();
                    }
                    if (Character.isDigit(O0000Ooo3)) {
                        i4 = this.O00000Oo + 1;
                        int O0000Ooo4 = O0000Ooo();
                        while (Character.isDigit(O0000Ooo4)) {
                            i4 = this.O00000Oo + 1;
                            O0000Ooo4 = O0000Ooo();
                        }
                        this.O00000Oo = i5;
                        i = i4;
                    }
                }
                i4 = i3;
                this.O00000Oo = i5;
                i = i4;
            }
            int i8 = this.O00000Oo;
            if (i == i8) {
                return null;
            }
            Float valueOf = Float.valueOf(Float.parseFloat(this.f11900O000000o.substring(i8, i)));
            this.O00000Oo = i;
            return valueOf;
        }

        public final Integer O0000OOo() {
            int i;
            int i2;
            if (O00000o0()) {
                i = this.O00000Oo;
            } else {
                int i3 = this.O00000Oo;
                int charAt = this.f11900O000000o.charAt(i3);
                if (charAt == 45 || charAt == 43) {
                    charAt = O0000Ooo();
                }
                if (Character.isDigit(charAt)) {
                    i2 = this.O00000Oo + 1;
                    int O0000Ooo = O0000Ooo();
                    while (Character.isDigit(O0000Ooo)) {
                        i2 = this.O00000Oo + 1;
                        O0000Ooo = O0000Ooo();
                    }
                } else {
                    i2 = i3;
                }
                this.O00000Oo = i3;
                i = i2;
            }
            int i4 = this.O00000Oo;
            if (i == i4) {
                return null;
            }
            Integer valueOf = Integer.valueOf(Integer.parseInt(this.f11900O000000o.substring(i4, i)));
            this.O00000Oo = i;
            return valueOf;
        }
    }

    private static void O000000o(SVG.O00O0o0 o00O0o0, Attributes attributes) throws SAXException {
        int i = 0;
        while (i < attributes.getLength()) {
            String qName = attributes.getQName(i);
            if (qName.equals("id") || qName.equals("xml:id")) {
                o00O0o0.O0000o0o = attributes.getValue(i).trim();
                return;
            } else if (qName.equals("xml:space")) {
                String trim = attributes.getValue(i).trim();
                if ("default".equals(trim)) {
                    o00O0o0.O0000o = Boolean.FALSE;
                    return;
                } else if ("preserve".equals(trim)) {
                    o00O0o0.O0000o = Boolean.TRUE;
                    return;
                } else {
                    throw new SAXException("Invalid value for \"xml:space\" attribute: ".concat(String.valueOf(trim)));
                }
            } else {
                i++;
            }
        }
    }

    private static void O00000Oo(SVG.O00O0o0 o00O0o0, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (trim.length() != 0) {
                int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 == 48) {
                    O000000o(o00O0o0, trim);
                } else if (i2 != 49) {
                    if (o00O0o0.O0000oO0 == null) {
                        o00O0o0.O0000oO0 = new SVG.Style();
                    }
                    O000000o(o00O0o0.O0000oO0, attributes.getLocalName(i), attributes.getValue(i).trim());
                } else {
                    o00O0o0.O0000oOO = CSSParser.O000000o(trim);
                }
            }
        }
    }

    private static void O000000o(SVG.O00O0o0 o00O0o0, String str) throws SAXException {
        O000000o o000000o = new O000000o(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String O00000Oo2 = o000000o.O00000Oo(':');
            o000000o.O00000o();
            if (o000000o.O000000o(':')) {
                o000000o.O00000o();
                String O00000Oo3 = o000000o.O00000Oo(';');
                if (O00000Oo3 != null) {
                    o000000o.O00000o();
                    if (o000000o.O00000o0() || o000000o.O000000o(';')) {
                        if (o00O0o0.O0000oO == null) {
                            o00O0o0.O0000oO = new SVG.Style();
                        }
                        O000000o(o00O0o0.O0000oO, O00000Oo2, O00000Oo3);
                        o000000o.O00000o();
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    protected static void O000000o(SVG.Style style, String str, String str2) throws SAXException {
        if (str2.length() != 0 && !str2.equals("inherit")) {
            switch (AnonymousClass1.f11899O000000o[SVGAttr.fromString(str).ordinal()]) {
                case 50:
                    style.O00000Oo = O000000o(str2, "fill");
                    style.f11895O000000o |= 1;
                    return;
                case 51:
                    style.O00000o0 = O0000o0o(str2);
                    style.f11895O000000o |= 2;
                    return;
                case 52:
                    style.O00000o = Float.valueOf(O00000oo(str2));
                    style.f11895O000000o |= 4;
                    return;
                case 53:
                    style.O00000oO = O000000o(str2, "stroke");
                    style.f11895O000000o |= 8;
                    return;
                case 54:
                    style.O00000oo = Float.valueOf(O00000oo(str2));
                    style.f11895O000000o |= 16;
                    return;
                case 55:
                    style.O0000O0o = O00000o0(str2);
                    style.f11895O000000o |= 32;
                    return;
                case 56:
                    style.O0000OOo = O0000o(str2);
                    style.f11895O000000o |= 64;
                    return;
                case 57:
                    style.O0000Oo0 = O0000oO0(str2);
                    style.f11895O000000o |= 128;
                    return;
                case 58:
                    style.O0000Oo = Float.valueOf(O00000oO(str2));
                    style.f11895O000000o |= 256;
                    return;
                case 59:
                    if ("none".equals(str2)) {
                        style.O0000OoO = null;
                    } else {
                        style.O0000OoO = O0000oO(str2);
                    }
                    style.f11895O000000o |= 512;
                    return;
                case 60:
                    style.O0000Ooo = O00000o0(str2);
                    style.f11895O000000o |= 1024;
                    return;
                case 61:
                    style.O0000o00 = Float.valueOf(O00000oo(str2));
                    style.f11895O000000o |= 2048;
                    return;
                case 62:
                    style.O0000o0 = O0000Oo0(str2);
                    style.f11895O000000o |= 4096;
                    return;
                case 63:
                    O000000o(style, str2);
                    return;
                case 64:
                    style.O0000o0O = O0000Oo(str2);
                    style.f11895O000000o |= 8192;
                    return;
                case 65:
                    style.O0000o0o = O0000OoO(str2);
                    style.f11895O000000o |= 16384;
                    return;
                case 66:
                    style.O0000o = O0000Ooo(str2);
                    style.f11895O000000o |= 32768;
                    return;
                case 67:
                    style.O0000oO0 = O0000o00(str2);
                    style.f11895O000000o |= 65536;
                    return;
                case 68:
                    style.O0000oO = O0000o0(str2);
                    style.f11895O000000o |= 131072;
                    return;
                case 69:
                    style.O0000oOO = O0000o0O(str2);
                    style.f11895O000000o |= 68719476736L;
                    return;
                case 70:
                    style.O0000oOo = O0000oOO(str2);
                    style.f11895O000000o |= 262144;
                    return;
                case 71:
                    style.O0000oo0 = O0000oOo(str2);
                    style.f11895O000000o |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    return;
                case 72:
                    style.O0000ooO = O00000Oo(str2, str);
                    style.O0000ooo = style.O0000ooO;
                    style.O00oOooO = style.O0000ooO;
                    style.f11895O000000o |= 14680064;
                    return;
                case 73:
                    style.O0000ooO = O00000Oo(str2, str);
                    style.f11895O000000o |= 2097152;
                    return;
                case 74:
                    style.O0000ooo = O00000Oo(str2, str);
                    style.f11895O000000o |= 4194304;
                    return;
                case 75:
                    style.O00oOooO = O00000Oo(str2, str);
                    style.f11895O000000o |= 8388608;
                    return;
                case 76:
                    if (str2.indexOf(124) < 0) {
                        if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".indexOf("|" + str2 + '|') != -1) {
                            style.O00oOooo = Boolean.valueOf(!str2.equals("none"));
                            style.f11895O000000o |= 16777216;
                            return;
                        }
                    }
                    throw new SAXException("Invalid value for \"display\" attribute: ".concat(String.valueOf(str2)));
                case 77:
                    if (str2.indexOf(124) < 0) {
                        if ("|visible|hidden|collapse|".indexOf("|" + str2 + '|') != -1) {
                            style.O000O00o = Boolean.valueOf(str2.equals("visible"));
                            style.f11895O000000o |= 33554432;
                            return;
                        }
                    }
                    throw new SAXException("Invalid value for \"visibility\" attribute: ".concat(String.valueOf(str2)));
                case 78:
                    if (str2.equals("currentColor")) {
                        style.O000O0OO = SVG.O0000OOo.O000000o();
                    } else {
                        style.O000O0OO = O0000Oo0(str2);
                    }
                    style.f11895O000000o |= 67108864;
                    return;
                case 79:
                    style.O000O0Oo = Float.valueOf(O00000oo(str2));
                    style.f11895O000000o |= 134217728;
                    return;
                case 80:
                    style.O0000oo = O0000oo0(str2);
                    style.f11895O000000o |= 1048576;
                    return;
                case 81:
                    style.O00oOoOo = O00000Oo(str2, str);
                    style.f11895O000000o |= 268435456;
                    return;
                case XiaomiOAuthConstants.VERSION_MINOR:
                    style.O000O0o0 = O0000o0o(str2);
                    style.f11895O000000o |= 536870912;
                    return;
                case 83:
                    style.O000O0o = O00000Oo(str2, str);
                    style.f11895O000000o |= 1073741824;
                    return;
                case 84:
                    if (str2.equals("currentColor")) {
                        style.O000O0oO = SVG.O0000OOo.O000000o();
                    } else {
                        style.O000O0oO = O0000Oo0(str2);
                    }
                    style.f11895O000000o |= 2147483648L;
                    return;
                case 85:
                    style.O000O0oo = Float.valueOf(O00000oo(str2));
                    style.f11895O000000o |= 4294967296L;
                    return;
                case 86:
                    if (str2.equals("currentColor")) {
                        style.O000OO00 = SVG.O0000OOo.O000000o();
                    } else {
                        style.O000OO00 = O0000Oo0(str2);
                    }
                    style.f11895O000000o |= 8589934592L;
                    return;
                case 87:
                    style.O000OO0o = Float.valueOf(O00000oo(str2));
                    style.f11895O000000o |= 17179869184L;
                    return;
                case 88:
                    style.O000OO = O0000oo(str2);
                    style.f11895O000000o |= 34359738368L;
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void
     arg types: [com.xiaomi.smarthome.svg.SVG$O00Oo00, java.lang.String]
     candidates:
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.String):com.xiaomi.smarthome.svg.SVG$O00OOOo
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00000o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O0000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000OOOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000Oo0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O000o00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00Oo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O00o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00O0o, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Oo0OO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00Ooo00, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0000, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00o0, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00oOooO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$Style, java.lang.String):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$oooOoO, org.xml.sax.Attributes):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.svg.SVGParser.O000000o(com.xiaomi.smarthome.svg.SVG$O00OOo0, java.lang.String):void */
    private static void O000000o(SVG.O00Oo00 o00Oo00, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 10) {
                O000000o((SVG.O00OOo0) o00Oo00, trim);
            } else if (i2 == 89) {
                o00Oo00.O0000ooO = O0000O0o(trim);
            }
        }
    }

    private static void O000000o(SVG.O000O0o0 o000O0o0, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.transform) {
                o000O0o0.O000000o(O00000Oo(attributes.getValue(i)));
            }
        }
    }

    private static Matrix O00000Oo(String str) throws SAXException {
        Matrix matrix = new Matrix();
        O000000o o000000o = new O000000o(str);
        o000000o.O00000o();
        while (!o000000o.O00000o0()) {
            String O0000o02 = o000000o.O0000o0();
            if (O0000o02 != null) {
                if (O0000o02.equals("matrix")) {
                    o000000o.O00000o();
                    Float O00000oo2 = o000000o.O00000oo();
                    o000000o.O00000oO();
                    Float O00000oo3 = o000000o.O00000oo();
                    o000000o.O00000oO();
                    Float O00000oo4 = o000000o.O00000oo();
                    o000000o.O00000oO();
                    Float O00000oo5 = o000000o.O00000oo();
                    o000000o.O00000oO();
                    Float O00000oo6 = o000000o.O00000oo();
                    o000000o.O00000oO();
                    Float O00000oo7 = o000000o.O00000oo();
                    o000000o.O00000o();
                    if (O00000oo7 == null || !o000000o.O000000o(')')) {
                        throw new SAXException("Invalid transform list: ".concat(String.valueOf(str)));
                    }
                    Matrix matrix2 = new Matrix();
                    matrix2.setValues(new float[]{O00000oo2.floatValue(), O00000oo4.floatValue(), O00000oo6.floatValue(), O00000oo3.floatValue(), O00000oo5.floatValue(), O00000oo7.floatValue(), 0.0f, 0.0f, 1.0f});
                    matrix.preConcat(matrix2);
                } else if (O0000o02.equals("translate")) {
                    o000000o.O00000o();
                    Float O00000oo8 = o000000o.O00000oo();
                    Float O0000O0o2 = o000000o.O0000O0o();
                    o000000o.O00000o();
                    if (O00000oo8 == null || !o000000o.O000000o(')')) {
                        throw new SAXException("Invalid transform list: ".concat(String.valueOf(str)));
                    } else if (O0000O0o2 == null) {
                        matrix.preTranslate(O00000oo8.floatValue(), 0.0f);
                    } else {
                        matrix.preTranslate(O00000oo8.floatValue(), O0000O0o2.floatValue());
                    }
                } else if (O0000o02.equals("scale")) {
                    o000000o.O00000o();
                    Float O00000oo9 = o000000o.O00000oo();
                    Float O0000O0o3 = o000000o.O0000O0o();
                    o000000o.O00000o();
                    if (O00000oo9 == null || !o000000o.O000000o(')')) {
                        throw new SAXException("Invalid transform list: ".concat(String.valueOf(str)));
                    } else if (O0000O0o3 == null) {
                        matrix.preScale(O00000oo9.floatValue(), O00000oo9.floatValue());
                    } else {
                        matrix.preScale(O00000oo9.floatValue(), O0000O0o3.floatValue());
                    }
                } else if (O0000o02.equals("rotate")) {
                    o000000o.O00000o();
                    Float O00000oo10 = o000000o.O00000oo();
                    Float O0000O0o4 = o000000o.O0000O0o();
                    Float O0000O0o5 = o000000o.O0000O0o();
                    o000000o.O00000o();
                    if (O00000oo10 == null || !o000000o.O000000o(')')) {
                        throw new SAXException("Invalid transform list: ".concat(String.valueOf(str)));
                    } else if (O0000O0o4 == null) {
                        matrix.preRotate(O00000oo10.floatValue());
                    } else if (O0000O0o5 != null) {
                        matrix.preRotate(O00000oo10.floatValue(), O0000O0o4.floatValue(), O0000O0o5.floatValue());
                    } else {
                        throw new SAXException("Invalid transform list: ".concat(String.valueOf(str)));
                    }
                } else if (O0000o02.equals("skewX")) {
                    o000000o.O00000o();
                    Float O00000oo11 = o000000o.O00000oo();
                    o000000o.O00000o();
                    if (O00000oo11 == null || !o000000o.O000000o(')')) {
                        throw new SAXException("Invalid transform list: ".concat(String.valueOf(str)));
                    }
                    matrix.preSkew((float) Math.tan(Math.toRadians((double) O00000oo11.floatValue())), 0.0f);
                } else if (O0000o02.equals("skewY")) {
                    o000000o.O00000o();
                    Float O00000oo12 = o000000o.O00000oo();
                    o000000o.O00000o();
                    if (O00000oo12 == null || !o000000o.O000000o(')')) {
                        throw new SAXException("Invalid transform list: ".concat(String.valueOf(str)));
                    }
                    matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians((double) O00000oo12.floatValue())));
                } else if (O0000o02 != null) {
                    throw new SAXException("Invalid transform list fn: " + O0000o02 + ")");
                }
                if (o000000o.O00000o0()) {
                    break;
                }
                o000000o.O00000oO();
            } else {
                throw new SAXException("Bad transform function encountered in transform list: ".concat(String.valueOf(str)));
            }
        }
        return matrix;
    }

    private static SVG.O000OO00 O00000o0(String str) throws SAXException {
        if (str.length() != 0) {
            int length = str.length();
            SVG.Unit unit = SVG.Unit.px;
            char charAt = str.charAt(length - 1);
            if (charAt == '%') {
                length--;
                unit = SVG.Unit.percent;
            } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
                length -= 2;
                try {
                    unit = SVG.Unit.valueOf(str.substring(length).toLowerCase(Locale.US));
                } catch (IllegalArgumentException unused) {
                    throw new SAXException("Invalid length unit specifier: ".concat(String.valueOf(str)));
                }
            }
            try {
                return new SVG.O000OO00(Float.parseFloat(str.substring(0, length)), unit);
            } catch (NumberFormatException e) {
                throw new SAXException("Invalid length value: ".concat(String.valueOf(str)), e);
            }
        } else {
            throw new SAXException("Invalid length value (empty string)");
        }
    }

    private static List<SVG.O000OO00> O00000o(String str) throws SAXException {
        if (str.length() != 0) {
            ArrayList arrayList = new ArrayList(1);
            O000000o o000000o = new O000000o(str);
            o000000o.O00000o();
            while (!o000000o.O00000o0()) {
                Float O00000oo2 = o000000o.O00000oo();
                if (O00000oo2 != null) {
                    SVG.Unit O0000o0o2 = o000000o.O0000o0o();
                    if (O0000o0o2 == null) {
                        O0000o0o2 = SVG.Unit.px;
                    }
                    arrayList.add(new SVG.O000OO00(O00000oo2.floatValue(), O0000o0o2));
                    o000000o.O00000oO();
                } else {
                    throw new SAXException("Invalid length list value: " + o000000o.O0000o0O());
                }
            }
            return arrayList;
        }
        throw new SAXException("Invalid length list (empty string)");
    }

    private static float O00000oO(String str) throws SAXException {
        if (str.length() != 0) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException e) {
                throw new SAXException("Invalid float value: ".concat(String.valueOf(str)), e);
            }
        } else {
            throw new SAXException("Invalid float value (empty string)");
        }
    }

    private static float O00000oo(String str) throws SAXException {
        float O00000oO2 = O00000oO(str);
        if (O00000oO2 < 0.0f) {
            return 0.0f;
        }
        if (O00000oO2 > 1.0f) {
            return 1.0f;
        }
        return O00000oO2;
    }

    private static SVG.O000000o O0000O0o(String str) throws SAXException {
        O000000o o000000o = new O000000o(str);
        o000000o.O00000o();
        Float O00000oo2 = o000000o.O00000oo();
        o000000o.O00000oO();
        Float O00000oo3 = o000000o.O00000oo();
        o000000o.O00000oO();
        Float O00000oo4 = o000000o.O00000oo();
        o000000o.O00000oO();
        Float O00000oo5 = o000000o.O00000oo();
        if (O00000oo2 == null || O00000oo3 == null || O00000oo4 == null || O00000oo5 == null) {
            throw new SAXException("Invalid viewBox definition - should have four numbers");
        } else if (O00000oo4.floatValue() < 0.0f) {
            throw new SAXException("Invalid viewBox. width cannot be negative");
        } else if (O00000oo5.floatValue() >= 0.0f) {
            return new SVG.O000000o(O00000oo2.floatValue(), O00000oo3.floatValue(), O00000oo4.floatValue(), O00000oo5.floatValue());
        } else {
            throw new SAXException("Invalid viewBox. height cannot be negative");
        }
    }

    private static void O000000o(SVG.O00OOo0 o00OOo0, String str) throws SAXException {
        PreserveAspectRatio.Scale scale;
        O000000o o000000o = new O000000o(str);
        o000000o.O00000o();
        String O0000o002 = o000000o.O0000o00();
        if ("defer".equals(O0000o002)) {
            o000000o.O00000o();
            O0000o002 = o000000o.O0000o00();
        }
        PreserveAspectRatio.Alignment alignment = O0000o0o.get(O0000o002);
        o000000o.O00000o();
        if (!o000000o.O00000o0()) {
            String O0000o003 = o000000o.O0000o00();
            if (O0000o003.equals("meet")) {
                scale = PreserveAspectRatio.Scale.Meet;
            } else if (O0000o003.equals("slice")) {
                scale = PreserveAspectRatio.Scale.Slice;
            } else {
                throw new SAXException("Invalid preserveAspectRatio definition: ".concat(String.valueOf(str)));
            }
        } else {
            scale = null;
        }
        o00OOo0.O0000oo = new PreserveAspectRatio(alignment, scale);
    }

    private static SVG.O00OOOo O000000o(String str, String str2) throws SAXException {
        if (!str.startsWith("url(")) {
            return O0000OOo(str);
        }
        int indexOf = str.indexOf(")");
        if (indexOf != -1) {
            String trim = str.substring(4, indexOf).trim();
            SVG.O00OOOo o00OOOo = null;
            String trim2 = str.substring(indexOf + 1).trim();
            if (trim2.length() > 0) {
                o00OOOo = O0000OOo(trim2);
            }
            return new SVG.O000OOo(trim, o00OOOo);
        }
        throw new SAXException("Bad " + str2 + " attribute. Unterminated url() reference");
    }

    private static SVG.O00OOOo O0000OOo(String str) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (str.equals("currentColor")) {
            return SVG.O0000OOo.O000000o();
        }
        return O0000Oo0(str);
    }

    private static SVG.O0000O0o O0000Oo0(String str) throws SAXException {
        if (str.charAt(0) == '#') {
            try {
                if (str.length() == 7) {
                    return new SVG.O0000O0o(Integer.parseInt(str.substring(1), 16));
                }
                if (str.length() == 4) {
                    int parseInt = Integer.parseInt(str.substring(1), 16);
                    int i = parseInt & 3840;
                    int i2 = parseInt & 240;
                    int i3 = parseInt & 15;
                    return new SVG.O0000O0o(i3 | (i << 12) | (i << 16) | (i2 << 8) | (i2 << 4) | (i3 << 4));
                }
                throw new SAXException("Bad hex colour value: ".concat(String.valueOf(str)));
            } catch (NumberFormatException unused) {
                throw new SAXException("Bad colour value: ".concat(String.valueOf(str)));
            }
        } else if (str.toLowerCase(Locale.US).startsWith("rgb(")) {
            O000000o o000000o = new O000000o(str.substring(4));
            o000000o.O00000o();
            int O000000o2 = O000000o(o000000o);
            o000000o.O00000oO();
            int O000000o3 = O000000o(o000000o);
            o000000o.O00000oO();
            int O000000o4 = O000000o(o000000o);
            o000000o.O00000o();
            if (o000000o.O000000o(')')) {
                return new SVG.O0000O0o((O000000o2 << 16) | (O000000o3 << 8) | O000000o4);
            }
            throw new SAXException("Bad rgb() colour value: ".concat(String.valueOf(str)));
        } else {
            Integer num = O0000Ooo.get(str.toLowerCase(Locale.US));
            if (num != null) {
                return new SVG.O0000O0o(num.intValue());
            }
            throw new SAXException("Invalid colour keyword: ".concat(String.valueOf(str)));
        }
    }

    private static int O000000o(O000000o o000000o) throws SAXException {
        int intValue = o000000o.O0000OOo().intValue();
        if (o000000o.O000000o('%')) {
            if (intValue < 0) {
                intValue = 0;
            } else if (intValue > 100) {
                intValue = 100;
            }
            return (intValue * 255) / 100;
        } else if (intValue < 0) {
            return 0;
        } else {
            if (intValue > 255) {
                return 255;
            }
            return intValue;
        }
    }

    private static void O000000o(SVG.Style style, String str) throws SAXException {
        String O00000Oo2;
        int i;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".indexOf("|" + str + '|') == -1) {
            O000000o o000000o = new O000000o(str);
            Integer num = null;
            SVG.Style.FontStyle fontStyle = null;
            String str2 = null;
            while (true) {
                O00000Oo2 = o000000o.O00000Oo('/');
                o000000o.O00000o();
                if (O00000Oo2 != null) {
                    if (num == null || fontStyle == null) {
                        if (!O00000Oo2.equals("normal") && ((num != null || (num = O0000o0.get(O00000Oo2)) == null) && (fontStyle != null || (fontStyle = O0000o0O.get(O00000Oo2)) == null))) {
                            if (str2 != null || !O00000Oo2.equals("small-caps")) {
                                break;
                            }
                            str2 = O00000Oo2;
                        }
                    } else {
                        break;
                    }
                } else {
                    throw new SAXException("Invalid font style attribute: missing font size and family");
                }
            }
            SVG.O000OO00 O0000OoO2 = O0000OoO(O00000Oo2);
            if (o000000o.O000000o('/')) {
                o000000o.O00000o();
                String O0000o002 = o000000o.O0000o00();
                if (O0000o002 != null) {
                    O00000o0(O0000o002);
                    o000000o.O00000o();
                } else {
                    throw new SAXException("Invalid font style attribute: missing line-height");
                }
            }
            style.O0000o0O = O0000Oo(o000000o.O0000oO());
            style.O0000o0o = O0000OoO2;
            if (num == null) {
                i = 400;
            } else {
                i = num.intValue();
            }
            style.O0000o = Integer.valueOf(i);
            if (fontStyle == null) {
                fontStyle = SVG.Style.FontStyle.Normal;
            }
            style.O0000oO0 = fontStyle;
            style.f11895O000000o |= 122880;
        }
    }

    private static List<String> O0000Oo(String str) throws SAXException {
        O000000o o000000o = new O000000o(str);
        ArrayList arrayList = null;
        do {
            String O0000oO0 = o000000o.O0000oO0();
            if (O0000oO0 == null) {
                O0000oO0 = o000000o.O00000Oo(',');
            }
            if (O0000oO0 == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(O0000oO0);
            o000000o.O00000oO();
        } while (!o000000o.O00000o0());
        return arrayList;
    }

    private static SVG.O000OO00 O0000OoO(String str) throws SAXException {
        SVG.O000OO00 o000oo00 = O0000o00.get(str);
        return o000oo00 == null ? O00000o0(str) : o000oo00;
    }

    private static Integer O0000Ooo(String str) throws SAXException {
        Integer num = O0000o0.get(str);
        if (num != null) {
            return num;
        }
        throw new SAXException("Invalid font-weight property: ".concat(String.valueOf(str)));
    }

    private static SVG.Style.FontStyle O0000o00(String str) throws SAXException {
        SVG.Style.FontStyle fontStyle = O0000o0O.get(str);
        if (fontStyle != null) {
            return fontStyle;
        }
        throw new SAXException("Invalid font-style property: ".concat(String.valueOf(str)));
    }

    private static SVG.Style.TextDecoration O0000o0(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.TextDecoration.None;
        }
        if ("underline".equals(str)) {
            return SVG.Style.TextDecoration.Underline;
        }
        if ("overline".equals(str)) {
            return SVG.Style.TextDecoration.Overline;
        }
        if ("line-through".equals(str)) {
            return SVG.Style.TextDecoration.LineThrough;
        }
        if ("blink".equals(str)) {
            return SVG.Style.TextDecoration.Blink;
        }
        throw new SAXException("Invalid text-decoration property: ".concat(String.valueOf(str)));
    }

    private static SVG.Style.TextDirection O0000o0O(String str) throws SAXException {
        if ("ltr".equals(str)) {
            return SVG.Style.TextDirection.LTR;
        }
        if ("rtl".equals(str)) {
            return SVG.Style.TextDirection.RTL;
        }
        throw new SAXException("Invalid direction property: ".concat(String.valueOf(str)));
    }

    private static SVG.Style.FillRule O0000o0o(String str) throws SAXException {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        throw new SAXException("Invalid fill-rule property: ".concat(String.valueOf(str)));
    }

    private static SVG.Style.LineCaps O0000o(String str) throws SAXException {
        if ("butt".equals(str)) {
            return SVG.Style.LineCaps.Butt;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineCaps.Round;
        }
        if ("square".equals(str)) {
            return SVG.Style.LineCaps.Square;
        }
        throw new SAXException("Invalid stroke-linecap property: ".concat(String.valueOf(str)));
    }

    private static SVG.Style.LineJoin O0000oO0(String str) throws SAXException {
        if ("miter".equals(str)) {
            return SVG.Style.LineJoin.Miter;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineJoin.Round;
        }
        if ("bevel".equals(str)) {
            return SVG.Style.LineJoin.Bevel;
        }
        throw new SAXException("Invalid stroke-linejoin property: ".concat(String.valueOf(str)));
    }

    private static SVG.O000OO00[] O0000oO(String str) throws SAXException {
        SVG.O000OO00 O0000Oo2;
        O000000o o000000o = new O000000o(str);
        o000000o.O00000o();
        if (o000000o.O00000o0() || (O0000Oo2 = o000000o.O0000Oo()) == null) {
            return null;
        }
        if (!O0000Oo2.O00000Oo()) {
            float f = O0000Oo2.f11878O000000o;
            ArrayList arrayList = new ArrayList();
            arrayList.add(O0000Oo2);
            while (!o000000o.O00000o0()) {
                o000000o.O00000oO();
                SVG.O000OO00 O0000Oo3 = o000000o.O0000Oo();
                if (O0000Oo3 == null) {
                    throw new SAXException("Invalid stroke-dasharray. Non-Length content found: ".concat(String.valueOf(str)));
                } else if (!O0000Oo3.O00000Oo()) {
                    arrayList.add(O0000Oo3);
                    f += O0000Oo3.f11878O000000o;
                } else {
                    throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: ".concat(String.valueOf(str)));
                }
            }
            if (f == 0.0f) {
                return null;
            }
            return (SVG.O000OO00[]) arrayList.toArray(new SVG.O000OO00[arrayList.size()]);
        }
        throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: ".concat(String.valueOf(str)));
    }

    private static SVG.Style.TextAnchor O0000oOO(String str) throws SAXException {
        if ("start".equals(str)) {
            return SVG.Style.TextAnchor.Start;
        }
        if ("middle".equals(str)) {
            return SVG.Style.TextAnchor.Middle;
        }
        if ("end".equals(str)) {
            return SVG.Style.TextAnchor.End;
        }
        throw new SAXException("Invalid text-anchor property: ".concat(String.valueOf(str)));
    }

    private static Boolean O0000oOo(String str) throws SAXException {
        if ("visible".equals(str) || "auto".equals(str)) {
            return Boolean.TRUE;
        }
        if ("hidden".equals(str) || "scroll".equals(str)) {
            return Boolean.FALSE;
        }
        throw new SAXException("Invalid toverflow property: ".concat(String.valueOf(str)));
    }

    private static SVG.O00000Oo O0000oo0(String str) throws SAXException {
        if ("auto".equals(str)) {
            return null;
        }
        if (str.toLowerCase(Locale.US).startsWith("rect(")) {
            O000000o o000000o = new O000000o(str.substring(5));
            o000000o.O00000o();
            SVG.O000OO00 O00000Oo2 = O00000Oo(o000000o);
            o000000o.O00000oO();
            SVG.O000OO00 O00000Oo3 = O00000Oo(o000000o);
            o000000o.O00000oO();
            SVG.O000OO00 O00000Oo4 = O00000Oo(o000000o);
            o000000o.O00000oO();
            SVG.O000OO00 O00000Oo5 = O00000Oo(o000000o);
            o000000o.O00000o();
            if (o000000o.O000000o(')')) {
                return new SVG.O00000Oo(O00000Oo2, O00000Oo3, O00000Oo4, O00000Oo5);
            }
            throw new SAXException("Bad rect() clip definition: ".concat(String.valueOf(str)));
        }
        throw new SAXException("Invalid clip attribute shape. Only rect() is supported.");
    }

    private static SVG.O000OO00 O00000Oo(O000000o o000000o) {
        if (o000000o.O000000o("auto")) {
            return new SVG.O000OO00(0.0f);
        }
        return o000000o.O0000Oo();
    }

    private static SVG.Style.VectorEffect O0000oo(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.VectorEffect.None;
        }
        if ("non-scaling-stroke".equals(str)) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        throw new SAXException("Invalid vector-effect property: ".concat(String.valueOf(str)));
    }

    private static Set<String> O0000ooO(String str) throws SAXException {
        O000000o o000000o = new O000000o(str);
        HashSet hashSet = new HashSet();
        while (!o000000o.O00000o0()) {
            String O0000o002 = o000000o.O0000o00();
            if (O0000o002.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(O0000o002.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            o000000o.O00000o();
        }
        return hashSet;
    }

    private static Set<String> O0000ooo(String str) throws SAXException {
        O000000o o000000o = new O000000o(str);
        HashSet hashSet = new HashSet();
        while (!o000000o.O00000o0()) {
            String O0000o002 = o000000o.O0000o00();
            int indexOf = O0000o002.indexOf(45);
            if (indexOf != -1) {
                O0000o002 = O0000o002.substring(0, indexOf);
            }
            hashSet.add(new Locale(O0000o002, "", "").getLanguage());
            o000000o.O00000o();
        }
        return hashSet;
    }

    private static Set<String> O00oOooO(String str) throws SAXException {
        O000000o o000000o = new O000000o(str);
        HashSet hashSet = new HashSet();
        while (!o000000o.O00000o0()) {
            hashSet.add(o000000o.O0000o00());
            o000000o.O00000o();
        }
        return hashSet;
    }

    private static String O00000Oo(String str, String str2) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (str.startsWith("url(") && str.endsWith(")")) {
            return str.substring(4, str.length() - 1).trim();
        }
        throw new SAXException("Bad " + str2 + " attribute. Expected \"none\" or \"url()\" format");
    }

    private void O00000Oo(Attributes attributes) throws SAXException {
        O000000o("<style>", new Object[0]);
        if (this.O00000o0 != null) {
            String str = "all";
            boolean z = true;
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = AnonymousClass1.f11899O000000o[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 == 7) {
                    z = trim.equals("text/css");
                } else if (i2 == 90) {
                    str = trim;
                }
            }
            if (z) {
                CSSParser.MediaType mediaType = CSSParser.MediaType.screen;
                CSSParser.O00000Oo o00000Oo = new CSSParser.O00000Oo(str);
                o00000Oo.O00000o();
                List<CSSParser.MediaType> O000000o2 = CSSParser.O000000o(o00000Oo);
                if (!o00000Oo.O00000o0()) {
                    throw new SAXException("Invalid @media type list");
                } else if (CSSParser.O000000o(O000000o2, mediaType)) {
                    this.O0000Oo0 = true;
                    return;
                }
            }
            this.O00000o = true;
            this.O00000oO = 1;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }
}
