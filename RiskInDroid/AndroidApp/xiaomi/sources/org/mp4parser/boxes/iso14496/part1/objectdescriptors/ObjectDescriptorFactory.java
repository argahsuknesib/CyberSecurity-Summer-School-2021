package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import _m_j.jky;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectDescriptorFactory {
    protected static Map<Integer, Map<Integer, Class<? extends BaseDescriptor>>> descriptorRegistry = new HashMap();
    protected static Logger log = Logger.getLogger(ObjectDescriptorFactory.class.getName());

    static {
        HashSet<Class> hashSet = new HashSet<>();
        hashSet.add(DecoderSpecificInfo.class);
        hashSet.add(SLConfigDescriptor.class);
        hashSet.add(BaseDescriptor.class);
        hashSet.add(ExtensionDescriptor.class);
        hashSet.add(ObjectDescriptorBase.class);
        hashSet.add(ProfileLevelIndicationDescriptor.class);
        hashSet.add(AudioSpecificConfig.class);
        hashSet.add(ExtensionProfileLevelDescriptor.class);
        hashSet.add(ESDescriptor.class);
        hashSet.add(DecoderConfigDescriptor.class);
        for (Class cls : hashSet) {
            Descriptor descriptor = (Descriptor) cls.getAnnotation(Descriptor.class);
            int[] tags = descriptor.tags();
            int objectTypeIndication = descriptor.objectTypeIndication();
            Map map = descriptorRegistry.get(Integer.valueOf(objectTypeIndication));
            if (map == null) {
                map = new HashMap();
            }
            for (int valueOf : tags) {
                map.put(Integer.valueOf(valueOf), cls);
            }
            descriptorRegistry.put(Integer.valueOf(objectTypeIndication), map);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.Exception]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    public static BaseDescriptor createFrom(int i, ByteBuffer byteBuffer) throws IOException {
        BaseDescriptor baseDescriptor;
        int O000000o2 = jky.O000000o(byteBuffer.get());
        Map map = descriptorRegistry.get(Integer.valueOf(i));
        if (map == null) {
            map = descriptorRegistry.get(-1);
        }
        Class cls = (Class) map.get(Integer.valueOf(O000000o2));
        if (cls == null || cls.isInterface() || Modifier.isAbstract(cls.getModifiers())) {
            Logger logger = log;
            logger.warning("No ObjectDescriptor found for objectTypeIndication " + Integer.toHexString(i) + " and tag " + Integer.toHexString(O000000o2) + " found: " + cls);
            baseDescriptor = new UnknownDescriptor();
        } else {
            try {
                baseDescriptor = (BaseDescriptor) cls.newInstance();
            } catch (Exception e) {
                Logger logger2 = log;
                Level level = Level.SEVERE;
                logger2.log(level, "Couldn't instantiate BaseDescriptor class " + cls + " for objectTypeIndication " + i + " and tag " + O000000o2, (Throwable) e);
                throw new RuntimeException(e);
            }
        }
        baseDescriptor.parse(O000000o2, byteBuffer);
        return baseDescriptor;
    }
}
