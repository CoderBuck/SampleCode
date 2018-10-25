package me.buck.samplecode.library.gson;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * gson 实例是线程安全的
 * <p>
 * Created by gwf on 2018/10/25
 */
public class GsonUtils {

    private static final Gson gson = new Gson();

    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return gson.fromJson(json, classOfT);
    }

    // Type type = new TypeToken<List<String>>() {}.getType();
    public static <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {
        return gson.fromJson(json, typeOfT);
    }

}
