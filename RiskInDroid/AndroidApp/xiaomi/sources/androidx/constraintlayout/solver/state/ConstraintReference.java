package androidx.constraintlayout.solver.state;

import java.util.ArrayList;

public final class ConstraintReference {

    class IncorrectConstraintException extends Exception {
        private final ArrayList<String> mErrors;

        public IncorrectConstraintException(ArrayList<String> arrayList) {
            this.mErrors = arrayList;
        }

        public ArrayList<String> getErrors() {
            return this.mErrors;
        }

        public String toString() {
            return "IncorrectConstraintException: " + this.mErrors.toString();
        }
    }
}
