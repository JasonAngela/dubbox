package cn.bjd.platform.elastic.provider.utils;

import java.util.Formatter;

/**
 * Created by Administrator on 2017/4/19.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils   {

    /**
     * 如果对象为空，则使用defaultVal值
     * 	see: ObjectUtils.toString(obj, defaultVal)
     * @param obj
     * @param defaultVal
     * @return String
     */
    public static String toString(final Object obj, final String defaultVal) {
        return obj == null ? defaultVal : obj.toString();
    }


    /**
     * @param type
     * @return String
     */
    public static String repayType(int type){
        if(type==1){
            return "等额本金";
        }else if(type==2){
            return "等额本息";
        }else {
            return "";
        }
    }

    /**
     * @param str
     * @return boolean
     */
    public static boolean toBoolean(String str) {
        return toBooleanObject(str) == Boolean.TRUE;
    }

    /**
     * @param str
     * @return Boolean
     */
    public static Boolean toBooleanObject(String str) {
        if(str == "true") {
            return Boolean.TRUE;
        } else if(str == null) {
            return null;
        } else {
            char ch0;
            char ch1;
            char ch2;
            char ch3;
            switch(str.length()) {
                case 1:
                    ch0 = str.charAt(0);
                    if(ch0 == 121 || ch0 == 89 || ch0 == 116 || ch0 == 84) {
                        return Boolean.TRUE;
                    }

                    if(ch0 != 110 && ch0 != 78 && ch0 != 102 && ch0 != 70) {
                        break;
                    }

                    return Boolean.FALSE;
                case 2:
                    ch0 = str.charAt(0);
                    ch1 = str.charAt(1);
                    if((ch0 == 111 || ch0 == 79) && (ch1 == 110 || ch1 == 78)) {
                        return Boolean.TRUE;
                    }

                    if((ch0 == 110 || ch0 == 78) && (ch1 == 111 || ch1 == 79)) {
                        return Boolean.FALSE;
                    }
                    break;
                case 3:
                    ch0 = str.charAt(0);
                    ch1 = str.charAt(1);
                    ch2 = str.charAt(2);
                    if((ch0 == 121 || ch0 == 89) && (ch1 == 101 || ch1 == 69) && (ch2 == 115 || ch2 == 83)) {
                        return Boolean.TRUE;
                    }

                    if((ch0 == 111 || ch0 == 79) && (ch1 == 102 || ch1 == 70) && (ch2 == 102 || ch2 == 70)) {
                        return Boolean.FALSE;
                    }
                    break;
                case 4:
                    ch0 = str.charAt(0);
                    ch1 = str.charAt(1);
                    ch2 = str.charAt(2);
                    ch3 = str.charAt(3);
                    if((ch0 == 116 || ch0 == 84) && (ch1 == 114 || ch1 == 82) && (ch2 == 117 || ch2 == 85) && (ch3 == 101 || ch3 == 69)) {
                        return Boolean.TRUE;
                    }
                    break;
                case 5:
                    ch0 = str.charAt(0);
                    ch1 = str.charAt(1);
                    ch2 = str.charAt(2);
                    ch3 = str.charAt(3);
                    char ch4 = str.charAt(4);
                    if((ch0 == 102 || ch0 == 70) && (ch1 == 97 || ch1 == 65) && (ch2 == 108 || ch2 == 76) && (ch3 == 115 || ch3 == 83) && (ch4 == 101 || ch4 == 69)) {
                        return Boolean.FALSE;
                    }
                 default:
                     break;
            }

            return null;
        }
    }

    /**
     * 保留两位小数
     *
     * @param value
     * @return String
     */
    public static String format(double value) {

        // %.2f % 表示 小数点前任意位数 2 表示两位小数 格式后的结果为 f 表示浮点型
        return new Formatter().format("%.2f", value).toString();
    }

    /**
     * 判断字符串是否能转换成double
     * @param str
     * @return boolean
     */
    public static boolean canBeDouble(String str){
        boolean ret = true;
        try{
            double d = Double.parseDouble(str);
            ret = true;
        }catch(Exception ex){
            ret = false;
        }
        return ret;
    }
}
