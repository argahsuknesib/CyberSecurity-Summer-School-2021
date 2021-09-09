package bsh;

class BSHVariableDeclarator extends SimpleNode {
    public String name;

    BSHVariableDeclarator() {
        super(5);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("BSHVariableDeclarator ");
        stringBuffer.append(this.name);
        return stringBuffer.toString();
    }
}
