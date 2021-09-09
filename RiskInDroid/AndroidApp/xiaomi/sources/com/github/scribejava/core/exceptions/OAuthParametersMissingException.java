package com.github.scribejava.core.exceptions;

import _m_j.avd;

public class OAuthParametersMissingException extends OAuthException {
    private static final long serialVersionUID = 1745308760111976671L;

    public OAuthParametersMissingException(avd avd) {
        super(String.format("Could not find oauth parameters in request: %s. OAuth parameters must be specified with the addOAuthParameter() method", avd));
    }
}
