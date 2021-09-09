package com.polidea.rxandroidble.exceptions;

import java.util.UUID;

public class BleCharacteristicNotFoundException extends BleException {
    private final UUID charactersisticUUID;

    public BleCharacteristicNotFoundException(UUID uuid) {
        this.charactersisticUUID = uuid;
    }

    public UUID getCharactersisticUUID() {
        return this.charactersisticUUID;
    }

    public String toString() {
        return "BleCharacteristicNotFoundException{charactersisticUUID=" + this.charactersisticUUID + '}';
    }
}
