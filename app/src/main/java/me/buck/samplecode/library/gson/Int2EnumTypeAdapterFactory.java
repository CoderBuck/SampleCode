package me.buck.samplecode.library.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

public class Int2EnumTypeAdapterFactory implements TypeAdapterFactory {
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class clazz = typeToken.getRawType();
            if (Enum.class.isAssignableFrom(clazz) && clazz != Enum.class) {
                if (!clazz.isEnum()) {
                    clazz = clazz.getSuperclass(); // handle anonymous subclasses
                }
                return new Int2EnumTypeAdapter<>(clazz);
            } else {
                return null;
            }
        }
    }