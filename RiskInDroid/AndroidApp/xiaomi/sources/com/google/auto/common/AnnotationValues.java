package com.google.auto.common;

import com.google.common.base.Equivalence;
import java.util.List;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor6;

public final class AnnotationValues {
    private static final Equivalence<AnnotationValue> ANNOTATION_VALUE_EQUIVALENCE = new Equivalence<AnnotationValue>() {
        /* class com.google.auto.common.AnnotationValues.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final boolean doEquivalent(AnnotationValue annotationValue, AnnotationValue annotationValue2) {
            return ((Boolean) annotationValue.accept(new SimpleAnnotationValueVisitor6<Boolean, AnnotationValue>() {
                /* class com.google.auto.common.AnnotationValues.AnonymousClass1.AnonymousClass1 */

                public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
                    return visitArray((List<? extends AnnotationValue>) list, (AnnotationValue) obj);
                }

                /* access modifiers changed from: protected */
                public Boolean defaultAction(Object obj, AnnotationValue annotationValue) {
                    return Boolean.valueOf(obj.equals(annotationValue.accept(new SimpleAnnotationValueVisitor6<Object, Void>() {
                        /* class com.google.auto.common.AnnotationValues.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                        /* access modifiers changed from: protected */
                        public Object defaultAction(Object obj, Void voidR) {
                            return obj;
                        }
                    }, (Object) null)));
                }

                public Boolean visitAnnotation(AnnotationMirror annotationMirror, AnnotationValue annotationValue) {
                    return (Boolean) annotationValue.accept(new SimpleAnnotationValueVisitor6<Boolean, AnnotationMirror>() {
                        /* class com.google.auto.common.AnnotationValues.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                        /* access modifiers changed from: protected */
                        public Boolean defaultAction(Object obj, AnnotationMirror annotationMirror) {
                            return Boolean.FALSE;
                        }

                        public Boolean visitAnnotation(AnnotationMirror annotationMirror, AnnotationMirror annotationMirror2) {
                            return Boolean.valueOf(AnnotationMirrors.equivalence().equivalent(annotationMirror2, annotationMirror));
                        }
                    }, annotationMirror);
                }

                public Boolean visitArray(List<? extends AnnotationValue> list, AnnotationValue annotationValue) {
                    return (Boolean) annotationValue.accept(new SimpleAnnotationValueVisitor6<Boolean, List<? extends AnnotationValue>>() {
                        /* class com.google.auto.common.AnnotationValues.AnonymousClass1.AnonymousClass1.AnonymousClass3 */

                        /* access modifiers changed from: protected */
                        public /* bridge */ /* synthetic */ Object defaultAction(Object obj, Object obj2) {
                            return defaultAction(obj, (List<? extends AnnotationValue>) ((List) obj2));
                        }

                        public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
                            return visitArray((List<? extends AnnotationValue>) list, (List<? extends AnnotationValue>) ((List) obj));
                        }

                        /* access modifiers changed from: protected */
                        public Boolean defaultAction(Object obj, List<? extends AnnotationValue> list) {
                            return Boolean.FALSE;
                        }

                        public Boolean visitArray(List<? extends AnnotationValue> list, List<? extends AnnotationValue> list2) {
                            return Boolean.valueOf(AnnotationValues.equivalence().pairwise().equivalent(list2, list));
                        }
                    }, list);
                }

                public Boolean visitType(TypeMirror typeMirror, AnnotationValue annotationValue) {
                    return (Boolean) annotationValue.accept(new SimpleAnnotationValueVisitor6<Boolean, TypeMirror>() {
                        /* class com.google.auto.common.AnnotationValues.AnonymousClass1.AnonymousClass1.AnonymousClass4 */

                        /* access modifiers changed from: protected */
                        public Boolean defaultAction(Object obj, TypeMirror typeMirror) {
                            return Boolean.FALSE;
                        }

                        public Boolean visitType(TypeMirror typeMirror, TypeMirror typeMirror2) {
                            return Boolean.valueOf(MoreTypes.equivalence().equivalent(typeMirror2, typeMirror));
                        }
                    }, typeMirror);
                }
            }, annotationValue2)).booleanValue();
        }

        /* access modifiers changed from: protected */
        public final int doHash(AnnotationValue annotationValue) {
            return ((Integer) annotationValue.accept(new SimpleAnnotationValueVisitor6<Integer, Void>() {
                /* class com.google.auto.common.AnnotationValues.AnonymousClass1.AnonymousClass2 */

                public /* bridge */ /* synthetic */ Object visitArray(List list, Object obj) {
                    return visitArray((List<? extends AnnotationValue>) list, (Void) obj);
                }

                public Integer visitAnnotation(AnnotationMirror annotationMirror, Void voidR) {
                    return Integer.valueOf(AnnotationMirrors.equivalence().hash(annotationMirror));
                }

                public Integer visitArray(List<? extends AnnotationValue> list, Void voidR) {
                    return Integer.valueOf(AnnotationValues.equivalence().pairwise().hash(list));
                }

                public Integer visitType(TypeMirror typeMirror, Void voidR) {
                    return Integer.valueOf(MoreTypes.equivalence().hash(typeMirror));
                }

                /* access modifiers changed from: protected */
                public Integer defaultAction(Object obj, Void voidR) {
                    return Integer.valueOf(obj.hashCode());
                }
            }, (Object) null)).intValue();
        }
    };

    public static Equivalence<AnnotationValue> equivalence() {
        return ANNOTATION_VALUE_EQUIVALENCE;
    }

    private AnnotationValues() {
    }
}
