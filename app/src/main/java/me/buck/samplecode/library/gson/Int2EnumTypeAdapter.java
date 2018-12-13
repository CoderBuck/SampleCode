package me.buck.samplecode.library.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Int2EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {

    private final Map<String, T>  nameToConstant  = new HashMap();
    private final Map<T, String>  constantToName  = new HashMap();
    private final Map<Integer, T> valueToConstant = new HashMap();
    private final Map<T, Integer> constantToValue = new HashMap();
    private       boolean         bCustomVal      = false;

    public Int2EnumTypeAdapter(Class<T> enumClass) {
//        System.out.println("enumClass = " + enumClass.getSimpleName());
        try {
            Enum[] enums = (Enum[]) enumClass.getEnumConstants();
            int size = enums.length;

            for (int i = 0; i < size; ++i) {
                Enum em = enums[i];
                String emName = em.name();
                SerializedName serializedName = (SerializedName) enumClass.getField(emName).getAnnotation(SerializedName.class);
                if (serializedName != null) {
                    emName = serializedName.value();
                }

//                System.out.println("emName = " + emName);

                this.nameToConstant.put(emName, (T) em);
                this.constantToName.put((T) em, emName);

                String emString = em.toString();
                this.bCustomVal = false;
                Pattern pattern = Pattern.compile("[0-9]*");
                Matcher matcher = pattern.matcher(emString);
                if (matcher.matches()) {
                    this.bCustomVal = true;
                }
//                System.out.println("bCustomVal = " + bCustomVal);

                if (this.bCustomVal) {
                    int val = Integer.parseInt(em.toString());
                    this.valueToConstant.put(val, (T) em);
                    this.constantToValue.put((T) em, val);
                }
            }

        } catch (NoSuchFieldException var12) {
            throw new AssertionError();
        }
    }

    public T read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        } else {
            if (bCustomVal) {
                return this.valueToConstant.get(reader.nextInt());
            } else {
                return this.nameToConstant.get(reader.nextString());
            }


        }
    }

    public void write(JsonWriter writer, T em) throws IOException {
        if (this.bCustomVal) {
            writer.value(em == null ? null : constantToValue.get(em));
        } else {
            writer.value(em == null ? null : constantToName.get(em));
        }

    }
}
