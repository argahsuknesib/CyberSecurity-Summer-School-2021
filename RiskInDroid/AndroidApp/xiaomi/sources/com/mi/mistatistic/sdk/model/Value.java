package com.mi.mistatistic.sdk.model;

import com.google.android.exoplayer2.C;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class Value extends Message<Value, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ProtoAdapter<Value> f5068O000000o = new O00000Oo();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "appstat.Value_Event#ADAPTER", tag = 1)
    public final Value_Event val_event;
    @WireField(adapter = "appstat.Value_Page#ADAPTER", tag = 2)
    public final Value_Page val_page;
    @WireField(adapter = "appstat.Value_RN_Download#ADAPTER", tag = 7)
    public final Value_RN_Download val_rn_download;
    @WireField(adapter = "appstat.Value_Session#ADAPTER", tag = 6)
    public final Value_Session val_session;
    @WireField(adapter = "appstat.Value_Startup#ADAPTER", tag = 3)
    public final Value_Startup val_startup;
    @WireField(adapter = "appstat.Value_View_Click#ADAPTER", tag = 5)
    public final Value_View_Click val_view_click;
    @WireField(adapter = "appstat.Value_View_Show#ADAPTER", tag = 4)
    public final Value_View_Show val_view_show;
    @WireField(adapter = "appstat.Value_RN_Activity#ADAPTER", tag = 9)
    public final Value_RN_Activity value_rn_activity;
    @WireField(adapter = "appstat.Value_RN_LoadBundle#ADAPTER", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final Value_RN_LoadBundle value_rn_loadBundle;

    public Value(Value_Event value_Event, Value_Page value_Page, Value_Startup value_Startup, Value_View_Show value_View_Show, Value_View_Click value_View_Click, Value_Session value_Session, Value_RN_Download value_RN_Download, Value_RN_LoadBundle value_RN_LoadBundle, Value_RN_Activity value_RN_Activity, ByteString byteString) {
        super(f5068O000000o, byteString);
        if (Internal.countNonNull(value_Event, value_Page, value_Startup, value_View_Show, value_View_Click, value_Session, value_RN_Download, value_RN_LoadBundle, value_RN_Activity) <= 1) {
            this.val_event = value_Event;
            this.val_page = value_Page;
            this.val_startup = value_Startup;
            this.val_view_show = value_View_Show;
            this.val_view_click = value_View_Click;
            this.val_session = value_Session;
            this.val_rn_download = value_RN_Download;
            this.value_rn_loadBundle = value_RN_LoadBundle;
            this.value_rn_activity = value_RN_Activity;
            return;
        }
        throw new IllegalArgumentException("at most one of val_event, val_page, val_startup, val_view_show, val_view_click, val_session, val_rn_download, value_rn_loadBundle, value_rn_activity may be non-null");
    }

    /* renamed from: O000000o */
    public final O000000o newBuilder() {
        O000000o o000000o = new O000000o();
        o000000o.f5069O000000o = this.val_event;
        o000000o.O00000Oo = this.val_page;
        o000000o.O00000o0 = this.val_startup;
        o000000o.O00000o = this.val_view_show;
        o000000o.O00000oO = this.val_view_click;
        o000000o.O00000oo = this.val_session;
        o000000o.O0000O0o = this.val_rn_download;
        o000000o.O0000OOo = this.value_rn_loadBundle;
        o000000o.O0000Oo0 = this.value_rn_activity;
        o000000o.addUnknownFields(unknownFields());
        return o000000o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value)) {
            return false;
        }
        Value value = (Value) obj;
        return Internal.equals(unknownFields(), value.unknownFields()) && Internal.equals(this.val_event, value.val_event) && Internal.equals(this.val_page, value.val_page) && Internal.equals(this.val_startup, value.val_startup) && Internal.equals(this.val_view_show, value.val_view_show) && Internal.equals(this.val_view_click, value.val_view_click) && Internal.equals(this.val_session, value.val_session) && Internal.equals(this.val_rn_download, value.val_rn_download) && Internal.equals(this.value_rn_loadBundle, value.value_rn_loadBundle) && Internal.equals(this.value_rn_activity, value.value_rn_activity);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Value_Event value_Event = this.val_event;
        int i2 = 0;
        int hashCode2 = (hashCode + (value_Event != null ? value_Event.hashCode() : 0)) * 37;
        Value_Page value_Page = this.val_page;
        int hashCode3 = (hashCode2 + (value_Page != null ? value_Page.hashCode() : 0)) * 37;
        Value_Startup value_Startup = this.val_startup;
        int hashCode4 = (hashCode3 + (value_Startup != null ? value_Startup.hashCode() : 0)) * 37;
        Value_View_Show value_View_Show = this.val_view_show;
        int hashCode5 = (hashCode4 + (value_View_Show != null ? value_View_Show.hashCode() : 0)) * 37;
        Value_View_Click value_View_Click = this.val_view_click;
        int hashCode6 = (hashCode5 + (value_View_Click != null ? value_View_Click.hashCode() : 0)) * 37;
        Value_Session value_Session = this.val_session;
        int hashCode7 = (hashCode6 + (value_Session != null ? value_Session.hashCode() : 0)) * 37;
        Value_RN_Download value_RN_Download = this.val_rn_download;
        int hashCode8 = (hashCode7 + (value_RN_Download != null ? value_RN_Download.hashCode() : 0)) * 37;
        Value_RN_LoadBundle value_RN_LoadBundle = this.value_rn_loadBundle;
        int hashCode9 = (hashCode8 + (value_RN_LoadBundle != null ? value_RN_LoadBundle.hashCode() : 0)) * 37;
        Value_RN_Activity value_RN_Activity = this.value_rn_activity;
        if (value_RN_Activity != null) {
            i2 = value_RN_Activity.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.val_event != null) {
            sb.append(", val_event=");
            sb.append(this.val_event);
        }
        if (this.val_page != null) {
            sb.append(", val_page=");
            sb.append(this.val_page);
        }
        if (this.val_startup != null) {
            sb.append(", val_startup=");
            sb.append(this.val_startup);
        }
        if (this.val_view_show != null) {
            sb.append(", val_view_show=");
            sb.append(this.val_view_show);
        }
        if (this.val_view_click != null) {
            sb.append(", val_view_click=");
            sb.append(this.val_view_click);
        }
        if (this.val_session != null) {
            sb.append(", val_session=");
            sb.append(this.val_session);
        }
        if (this.val_rn_download != null) {
            sb.append(", val_rn_download=");
            sb.append(this.val_rn_download);
        }
        if (this.value_rn_loadBundle != null) {
            sb.append(", value_rn_loadBundle=");
            sb.append(this.value_rn_loadBundle);
        }
        if (this.value_rn_activity != null) {
            sb.append(", value_rn_activity=");
            sb.append(this.value_rn_activity);
        }
        StringBuilder replace = sb.replace(0, 2, "Value{");
        replace.append('}');
        return replace.toString();
    }

    public static final class O000000o extends Message.Builder<Value, O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public Value_Event f5069O000000o;
        public Value_Page O00000Oo;
        public Value_View_Show O00000o;
        public Value_Startup O00000o0;
        public Value_View_Click O00000oO;
        public Value_Session O00000oo;
        public Value_RN_Download O0000O0o;
        public Value_RN_LoadBundle O0000OOo;
        public Value_RN_Activity O0000Oo0;

        public final O000000o O000000o(Value_Event value_Event) {
            this.f5069O000000o = value_Event;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000o = null;
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000O0o = null;
            this.O0000OOo = null;
            this.O0000Oo0 = null;
            return this;
        }

        public final O000000o O000000o(Value_Page value_Page) {
            this.O00000Oo = value_Page;
            this.f5069O000000o = null;
            this.O00000o0 = null;
            this.O00000o = null;
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000O0o = null;
            this.O0000OOo = null;
            this.O0000Oo0 = null;
            return this;
        }

        public final O000000o O000000o(Value_Startup value_Startup) {
            this.O00000o0 = value_Startup;
            this.f5069O000000o = null;
            this.O00000Oo = null;
            this.O00000o = null;
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000O0o = null;
            this.O0000OOo = null;
            this.O0000Oo0 = null;
            return this;
        }

        public final O000000o O000000o(Value_View_Show value_View_Show) {
            this.O00000o = value_View_Show;
            this.f5069O000000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000O0o = null;
            this.O0000OOo = null;
            this.O0000Oo0 = null;
            return this;
        }

        public final O000000o O000000o(Value_View_Click value_View_Click) {
            this.O00000oO = value_View_Click;
            this.f5069O000000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000o = null;
            this.O00000oo = null;
            this.O0000O0o = null;
            this.O0000OOo = null;
            this.O0000Oo0 = null;
            return this;
        }

        public final O000000o O000000o(Value_Session value_Session) {
            this.O00000oo = value_Session;
            this.f5069O000000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000o = null;
            this.O00000oO = null;
            this.O0000O0o = null;
            this.O0000OOo = null;
            this.O0000Oo0 = null;
            return this;
        }

        public final O000000o O000000o(Value_RN_Download value_RN_Download) {
            this.O0000O0o = value_RN_Download;
            this.f5069O000000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000o = null;
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000OOo = null;
            this.O0000Oo0 = null;
            return this;
        }

        public final O000000o O000000o(Value_RN_LoadBundle value_RN_LoadBundle) {
            this.O0000OOo = value_RN_LoadBundle;
            this.f5069O000000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000o = null;
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000O0o = null;
            this.O0000Oo0 = null;
            return this;
        }

        public final O000000o O000000o(Value_RN_Activity value_RN_Activity) {
            this.O0000Oo0 = value_RN_Activity;
            this.f5069O000000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000o = null;
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000O0o = null;
            this.O0000OOo = null;
            return this;
        }

        /* renamed from: O000000o */
        public final Value build() {
            return new Value(this.f5069O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o, this.O0000OOo, this.O0000Oo0, buildUnknownFields());
        }
    }

    static final class O00000Oo extends ProtoAdapter<Value> {
        public final /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
            Value value = (Value) obj;
            if (value.val_event != null) {
                Value_Event.f5070O000000o.encodeWithTag(protoWriter, 1, value.val_event);
            }
            if (value.val_page != null) {
                Value_Page.f5072O000000o.encodeWithTag(protoWriter, 2, value.val_page);
            }
            if (value.val_startup != null) {
                Value_Startup.f5082O000000o.encodeWithTag(protoWriter, 3, value.val_startup);
            }
            if (value.val_view_show != null) {
                Value_View_Show.f5086O000000o.encodeWithTag(protoWriter, 4, value.val_view_show);
            }
            if (value.val_view_click != null) {
                Value_View_Click.f5084O000000o.encodeWithTag(protoWriter, 5, value.val_view_click);
            }
            if (value.val_session != null) {
                Value_Session.f5080O000000o.encodeWithTag(protoWriter, 6, value.val_session);
            }
            if (value.val_rn_download != null) {
                Value_RN_Download.f5076O000000o.encodeWithTag(protoWriter, 7, value.val_rn_download);
            }
            if (value.value_rn_loadBundle != null) {
                Value_RN_LoadBundle.f5078O000000o.encodeWithTag(protoWriter, 8, value.value_rn_loadBundle);
            }
            if (value.value_rn_activity != null) {
                Value_RN_Activity.f5074O000000o.encodeWithTag(protoWriter, 9, value.value_rn_activity);
            }
            protoWriter.writeBytes(value.unknownFields());
        }

        public final /* synthetic */ int encodedSize(Object obj) {
            Value value = (Value) obj;
            int i = 0;
            int encodedSizeWithTag = (value.val_event != null ? Value_Event.f5070O000000o.encodedSizeWithTag(1, value.val_event) : 0) + (value.val_page != null ? Value_Page.f5072O000000o.encodedSizeWithTag(2, value.val_page) : 0) + (value.val_startup != null ? Value_Startup.f5082O000000o.encodedSizeWithTag(3, value.val_startup) : 0) + (value.val_view_show != null ? Value_View_Show.f5086O000000o.encodedSizeWithTag(4, value.val_view_show) : 0) + (value.val_view_click != null ? Value_View_Click.f5084O000000o.encodedSizeWithTag(5, value.val_view_click) : 0) + (value.val_session != null ? Value_Session.f5080O000000o.encodedSizeWithTag(6, value.val_session) : 0) + (value.val_rn_download != null ? Value_RN_Download.f5076O000000o.encodedSizeWithTag(7, value.val_rn_download) : 0) + (value.value_rn_loadBundle != null ? Value_RN_LoadBundle.f5078O000000o.encodedSizeWithTag(8, value.value_rn_loadBundle) : 0);
            if (value.value_rn_activity != null) {
                i = Value_RN_Activity.f5074O000000o.encodedSizeWithTag(9, value.value_rn_activity);
            }
            return encodedSizeWithTag + i + value.unknownFields().O0000OOo();
        }

        public final /* synthetic */ Object redact(Object obj) {
            O000000o O000000o2 = ((Value) obj).newBuilder();
            if (O000000o2.f5069O000000o != null) {
                O000000o2.f5069O000000o = Value_Event.f5070O000000o.redact(O000000o2.f5069O000000o);
            }
            if (O000000o2.O00000Oo != null) {
                O000000o2.O00000Oo = Value_Page.f5072O000000o.redact(O000000o2.O00000Oo);
            }
            if (O000000o2.O00000o0 != null) {
                O000000o2.O00000o0 = Value_Startup.f5082O000000o.redact(O000000o2.O00000o0);
            }
            if (O000000o2.O00000o != null) {
                O000000o2.O00000o = Value_View_Show.f5086O000000o.redact(O000000o2.O00000o);
            }
            if (O000000o2.O00000oO != null) {
                O000000o2.O00000oO = Value_View_Click.f5084O000000o.redact(O000000o2.O00000oO);
            }
            if (O000000o2.O00000oo != null) {
                O000000o2.O00000oo = Value_Session.f5080O000000o.redact(O000000o2.O00000oo);
            }
            if (O000000o2.O0000O0o != null) {
                O000000o2.O0000O0o = Value_RN_Download.f5076O000000o.redact(O000000o2.O0000O0o);
            }
            if (O000000o2.O0000OOo != null) {
                O000000o2.O0000OOo = Value_RN_LoadBundle.f5078O000000o.redact(O000000o2.O0000OOo);
            }
            if (O000000o2.O0000Oo0 != null) {
                O000000o2.O0000Oo0 = Value_RN_Activity.f5074O000000o.redact(O000000o2.O0000Oo0);
            }
            O000000o2.clearUnknownFields();
            return O000000o2.build();
        }

        O00000Oo() {
            super(FieldEncoding.LENGTH_DELIMITED, Value.class);
        }

        public final /* synthetic */ Object decode(ProtoReader protoReader) throws IOException {
            O000000o o000000o = new O000000o();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            o000000o.O000000o(Value_Event.f5070O000000o.decode(protoReader));
                            break;
                        case 2:
                            o000000o.O000000o(Value_Page.f5072O000000o.decode(protoReader));
                            break;
                        case 3:
                            o000000o.O000000o(Value_Startup.f5082O000000o.decode(protoReader));
                            break;
                        case 4:
                            o000000o.O000000o(Value_View_Show.f5086O000000o.decode(protoReader));
                            break;
                        case 5:
                            o000000o.O000000o(Value_View_Click.f5084O000000o.decode(protoReader));
                            break;
                        case 6:
                            o000000o.O000000o(Value_Session.f5080O000000o.decode(protoReader));
                            break;
                        case 7:
                            o000000o.O000000o(Value_RN_Download.f5076O000000o.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            o000000o.O000000o(Value_RN_LoadBundle.f5078O000000o.decode(protoReader));
                            break;
                        case 9:
                            o000000o.O000000o(Value_RN_Activity.f5074O000000o.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            o000000o.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return o000000o.build();
                }
            }
        }
    }
}
