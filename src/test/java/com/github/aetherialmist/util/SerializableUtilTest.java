package com.github.aetherialmist.util;

import com.github.aetherialmist.util.exception.AetherSerializationException;
import lombok.*;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.assertj.core.api.Assertions.assertThat;

class SerializableUtilTest {

    @Test
    void serialize() throws AetherSerializationException {
        byte[] serializedData = SerializableUtil.serialize(createTestObject());

        assertThat(serializedData).isNotEmpty();
    }

    @Test
    void deserializeWithType() throws AetherSerializationException {
        Data originalData = createTestObject();
        byte[] serialized = SerializableUtil.serialize(originalData);

        Data deserialized = SerializableUtil.deserialize(serialized, Data.class);

        assertThat(deserialized).isEqualTo(originalData);
    }

    @Test
    void deserializeManualCast() throws AetherSerializationException {
        Data originalData = createTestObject();
        byte[] serialized = SerializableUtil.serialize(originalData);

        Data deserialized = (Data) SerializableUtil.deserialize(serialized);

        assertThat(deserialized).isEqualTo(originalData);
    }

    private Data createTestObject() {
        NestedData nestedData = new NestedData("Pine", 1_000L);
        return new Data("Tree", 1234, nestedData);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    private static class Data implements Serializable {

        private String message;
        private int value;
        private NestedData nestedData;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    private static class NestedData implements Serializable {

        private String message;
        private long value;

    }
}