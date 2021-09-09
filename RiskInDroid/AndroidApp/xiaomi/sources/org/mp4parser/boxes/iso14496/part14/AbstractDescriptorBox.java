package org.mp4parser.boxes.iso14496.part14;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.ObjectDescriptorFactory;

public class AbstractDescriptorBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static Logger log = Logger.getLogger(AbstractDescriptorBox.class.getName());
    protected ByteBuffer data;
    protected BaseDescriptor descriptor;

    private static void ajc$preClinit() {
        jho jho = new jho("AbstractDescriptorBox.java", AbstractDescriptorBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getData", "org.mp4parser.boxes.iso14496.part14.AbstractDescriptorBox", "", "", "", "java.nio.ByteBuffer"), 42);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setData", "org.mp4parser.boxes.iso14496.part14.AbstractDescriptorBox", "java.nio.ByteBuffer", "data", "", "void"), 46);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getDescriptor", "org.mp4parser.boxes.iso14496.part14.AbstractDescriptorBox", "", "", "", "org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor"), 62);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setDescriptor", "org.mp4parser.boxes.iso14496.part14.AbstractDescriptorBox", "org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor", "descriptor", "", "void"), 66);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getDescriptorAsString", "org.mp4parser.boxes.iso14496.part14.AbstractDescriptorBox", "", "", "", "java.lang.String"), 70);
    }

    static {
        ajc$preClinit();
    }

    public AbstractDescriptorBox(String str) {
        super(str);
    }

    public ByteBuffer getData() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.data;
    }

    public void setData(ByteBuffer byteBuffer) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, byteBuffer);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.data = byteBuffer;
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        this.data.rewind();
        byteBuffer.put(this.data);
    }

    public long getContentSize() {
        return (long) (this.data.limit() + 4);
    }

    public BaseDescriptor getDescriptor() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.descriptor;
    }

    public void setDescriptor(BaseDescriptor baseDescriptor) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, baseDescriptor);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.descriptor = baseDescriptor;
    }

    public String getDescriptorAsString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.descriptor.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.IndexOutOfBoundsException]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.io.IOException]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.data = byteBuffer.slice();
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        try {
            this.data.rewind();
            this.descriptor = ObjectDescriptorFactory.createFrom(-1, this.data.duplicate());
        } catch (IOException e) {
            log.log(Level.WARNING, "Error parsing ObjectDescriptor", (Throwable) e);
        } catch (IndexOutOfBoundsException e2) {
            log.log(Level.WARNING, "Error parsing ObjectDescriptor", (Throwable) e2);
        }
    }
}
