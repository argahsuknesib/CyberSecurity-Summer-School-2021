package com.typesafe.config.impl;

public enum TokenType {
    START,
    END,
    COMMA,
    EQUALS,
    COLON,
    OPEN_CURLY,
    CLOSE_CURLY,
    OPEN_SQUARE,
    CLOSE_SQUARE,
    VALUE,
    NEWLINE,
    UNQUOTED_TEXT,
    SUBSTITUTION,
    PROBLEM,
    COMMENT,
    PLUS_EQUALS
}
