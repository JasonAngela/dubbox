package cn.bjd.platform.elastic.provider.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2016/11/22.
 */
public final class JacksonUtils {

    /**
     * 工具类应隐藏public构造器
     */
    private JacksonUtils() {

    }

    /**
     * objectMapper
     */
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
    }

    /**
     * 使用泛型方法，把json字符串转换为相应的JavaBean对象。
     * (1)转换为普通JavaBean：readValue(json,Student.class)
     * (2)转换为List,如List<Student>,将第二个参数传递为Student
     * [].class.然后使用Arrays.asList();方法把得到的数组转换为特定类型的List
     *
     * @param jsonStr
     * @param valueType
     * @return T
     */
    public static <T> T readValue(String jsonStr, Class<T> valueType) {
        try {
            return objectMapper.readValue(jsonStr, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * json数组转List
     *
     * @param jsonStr
     * @param valueTypeRef
     * @return T
     */
    public static <T> T readValue(String jsonStr, TypeReference<T> valueTypeRef) {
        try {
            return objectMapper.readValue(jsonStr, valueTypeRef);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param module
     * @return
     */
    public static ObjectMapper registerModule(Module module) {
        return objectMapper.registerModule(module);
    }

    /**
     * 把JavaBean转换为json字符串
     *
     * @param object
     * @return T
     */
    public static String toJSon(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getString(JsonNode jsonNode, String key){
        JsonNode valueNode = jsonNode.get(key);
        if(valueNode != null){
            String text = valueNode.asText();
            if(StringUtils.isEmpty(text)){
                return null;
            }
            else{
                return clearNull(text, Charset.forName("UTF-8"));
            }
        }
        return null;
    }

    public static Double getDouble(JsonNode jsonNode,String key){
        JsonNode valueNode = jsonNode.get(key);
        if(valueNode != null){
            return valueNode.asDouble();
        }
        return null;
    }

    public static Date getDate(JsonNode jsonNode, String key,final String... parsePatterns){
        JsonNode valueNode = jsonNode.get(key);
        if(valueNode != null){
            String dateStr = valueNode.asText();
            if(dateStr == null){
                return null;
            }
            else{
                dateStr = clearNull(dateStr, Charset.forName("UTF-8"));;
                if(!StringUtils.isEmpty(dateStr)){
                    return DateUtils.parseDateByPattern(dateStr.trim(),parsePatterns);
                }
            }
        }
        return null;
    }

    public static Date getDateByLocal(JsonNode jsonNode, String key, final Locale locale, final String... parsePatterns){
        JsonNode valueNode = jsonNode.get(key);
        if(valueNode != null){
            String dateStr = valueNode.asText();
            if(dateStr == null){
                return null;
            }
            else{
                dateStr = clearNull(dateStr, Charset.forName("UTF-8"));
                if(!StringUtils.isEmpty(dateStr)) {
                    return DateUtils.parseDateByPatternAndLocale(dateStr, locale, parsePatterns);
                }
            }
        }
        return null;
    }

    private static String clearNull(String toBeClear,Charset charset){
        byte[] bytes = toBeClear.getBytes(charset);
        for (int i=0; i<bytes.length; i++) {
            Byte b = bytes[i];
            if (b == 0x00) bytes[i] = 0x30;
        }
        return new String(bytes, charset).trim();
    }
}
