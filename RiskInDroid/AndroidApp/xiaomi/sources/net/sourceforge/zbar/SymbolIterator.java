package net.sourceforge.zbar;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SymbolIterator implements Iterator<Symbol> {
    private Symbol current;

    SymbolIterator(Symbol symbol) {
        this.current = symbol;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public Symbol next() {
        Symbol symbol = this.current;
        if (symbol != null) {
            long next = symbol.next();
            if (next != 0) {
                this.current = new Symbol(next);
            } else {
                this.current = null;
            }
            return symbol;
        }
        throw new NoSuchElementException("access past end of SymbolIterator");
    }

    public void remove() {
        throw new UnsupportedOperationException("SymbolIterator is immutable");
    }
}
