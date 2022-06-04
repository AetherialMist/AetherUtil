package com.github.aetherialmist.util;

import com.github.aetherialmist.util.exception.AetherSerializationException;

import java.io.*;

public final class SerializableUtil {

    private SerializableUtil() {
    }

    /**
     * @param serializable The serializable Object to be converted into a byte array.
     * @return The byte array resulting from the serialization of the given object. May return an empty byte array if there was no data to serialize.
     * @throws AetherSerializationException If there was an error while converting the object into a byte array.
     */
    public static byte[] serialize(Serializable serializable) throws AetherSerializationException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos;

        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(serializable);
            oos.flush();
        } catch (IOException e) {
            throw new AetherSerializationException("Failed to serialize object into byte array (IO).", e);
        } catch (Exception e) {
            throw new AetherSerializationException("Failed to serialize object into byte array (non-IO).", e);
        }

        return bos.size() == 0 ? new byte[0] : bos.toByteArray();
    }

    /**
     * @param bytes Data to reconstruct the represented Object.
     * @param clazz The type to cast the reconstructed Object to.
     * @return The reconstructed object represented by the given bytes as the given type.
     * @throws AetherSerializationException If there was an error while converting the bytes into an Object.
     */
    public static <T> T deserialize(byte[] bytes, Class<T> clazz) throws AetherSerializationException {
        try {
            return clazz.cast(deserialize(bytes));
        } catch (AetherSerializationException e) {
            throw e;
        } catch (ClassCastException e) {
            throw new AetherSerializationException("Failed to cast the converted bytes to the desired type.", e);
        } catch (Exception e) {
            throw new AetherSerializationException("Failed to deserialize bytes.", e);
        }
    }

    /**
     * @param bytes Data to reconstruct the represented Object.
     * @return The reconstructed object represented by the given bytes.
     * @throws AetherSerializationException If there was an error while converting the bytes into an Object.
     */
    public static Object deserialize(byte[] bytes) throws AetherSerializationException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

        try (ObjectInputStream ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        } catch (IOException e) {
            throw new AetherSerializationException("Failed to deserialize bytes. (IO)", e);
        } catch (ClassNotFoundException e) {
            throw new AetherSerializationException("Class does not exist to deserialize bytes.", e);
        } catch (Exception e) {
            throw new AetherSerializationException("Failed to deserialize bytes (non-IO).", e);
        }
    }

}
