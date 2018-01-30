package cn.bjd.platform.common.utils.Enum;

import cn.bjd.platform.common.utils.ArrayUtils;
import cn.bjd.platform.common.utils.ClassUtil;
import cn.bjd.platform.common.utils.MapBuilder;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.*;

public class EnumUtils {
    private static final String[] ENUM_PACKAGE_PATH_ARR = new String[] {"cn.bjd.platform.system.api.Enum" };


    /**
     * 系统中所有枚举存放在该Map中
     */
    private static Map<String, Map<String, String>> ALL_ENUM_MAP = initialEnumMap(true);

    /**
     * 根据枚举类型名称返回一个枚举的Map对象
     * @description:
     * @param enumTypeName 枚举类型名称
     * @return
     * @author:OA项目组  连石生
     * @createTime:2016年7月19日 下午3:09:48
     */
    public static Map<String, String> getEnumMap(String enumTypeName)
    {
        return ALL_ENUM_MAP.get(enumTypeName);
    }

    /**
     * 通过key获取value值
     * @description:
     * @param enumTypeName
     * @param key
     * @return
     * @author:OA项目 樊宇杰
     * @createTime:2016年10月14日 下午3:00:44
     */
    public static String getKeyByValue(String enumTypeName, String value)
    {
        Map<String, String> map = ALL_ENUM_MAP.get(enumTypeName);
        if (map == null)
        {
            return null;
        }
        if (value == null)
        {
            return null;
        }
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            if (value.equals(entry.getValue()))
            {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * 根据多个枚举类型名称查找出多个枚举对象的集合
     * @description:
     * @param enumTypeNames 枚举类型名称数组
     * @return
     * @author:OA项目组  连石生
     * @createTime:2016年7月19日 下午3:10:28
     */
    public static Map<String, Map<String, String>> getEnumMaps(String... enumTypeNames)
    {
        if (ArrayUtils.isEmpty(enumTypeNames))
        {
            return null;
        }

        Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String, String>>(enumTypeNames.length);

        for (int i = 0; i < enumTypeNames.length; i++)
        {
            String enumTypeName = enumTypeNames[i];

            resultMap.put(enumTypeName, getEnumMap(enumTypeName));
        }

        return resultMap;
    }

    /**
     * 根据枚举类型名称返回多个枚举的List对象
     * @description:
     * @param enumTypeName 枚举类型名称
     * @return
     * @author:OA项目组  连石生
     * @createTime:2016年7月19日 下午3:11:22
     */
    public static List<Map<String, String>> getEnumList(String enumTypeName)
    {
        Map<String, String> enumMap = getEnumMap(enumTypeName);
        Set<Map.Entry<String, String>> enumEntrySet = enumMap.entrySet();

        List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
        for (Map.Entry<String, String> enumEntry : enumEntrySet)
        {
            resultList.add(MapBuilder.newMap().put(enumEntry.getKey(), enumEntry.getValue()).build());
        }

        return resultList;
    }

    /**
     * 根据枚举类型名称及值返回值对应的描述信息
     * @description:
     * @param enumTypeName 枚举类型名称
     * @param value 枚举值
     * @return
     * @author:OA项目组  连石生
     * @createTime:2016年7月19日 下午3:11:56
     */
    public static String getEnumDesc(String enumTypeName, String value)
    {
        Map<String, String> enumMap = getEnumMap(enumTypeName);

        return enumMap.get(value);
    }

    /**
     * 判断是否包含在对应的枚举类型里
     * @description:
     * @param enumTypeName
     * @param value
     * @return
     * @author:OA项目 樊宇杰
     * @createTime:2016年9月13日 下午1:18:39
     */
    public static boolean contain(String enumTypeName, String value)
    {
        Map<String, String> enumMap = getEnumMap(enumTypeName);
        boolean contain = false;
        for (String key : enumMap.keySet())
        {
            if (key.equals(value))
            {
                contain = true;

                break;
            }
        }
        return contain;
    }

    /**
     * 根据枚举类型名称及多个值返回值对应的描述信息，描述信息使用半角逗号分隔
     * @description:
     * @param enumTypeName 枚举类型名称
     * @param values 多个枚举值
     * @return
     * @author:OA项目组  连石生
     * @createTime:2016年7月19日 下午3:12:26
     */
    public static String getEnumDescs(String enumTypeName, String... values)
    {
        if (ArrayUtils.isEmpty(values))
        {
            return null;
        }

        Map<String, String> enumMap = getEnumMap(enumTypeName);
        String[] resultDescs = new String[values.length];
        for (int i = 0; i < values.length; i++)
        {
            String value = values[i];
            if (StringUtils.isNotEmpty(value))
            {
                resultDescs[i] = enumMap.get(value);
            }
        }

        return ArrayUtils.toString(resultDescs);
    }

    /**
     * 加载所有枚举对象数据
     * @description:
     * @param isFouceCheck 是否强制校验枚举是否实现了BaseEnum接口
     * @return
     * @author:OA项目组  连石生
     * @createTime:2016年7月19日 下午3:13:30
     */
    private static Map<String, Map<String, String>> initialEnumMap(boolean isFouceCheck)
    {
        Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String, String>>();
        try
        {
            List<String> packageClasses = ClassUtil.getClasses(ENUM_PACKAGE_PATH_ARR);

            for (String classname : packageClasses)
            {
                Class<?> cls = null;
                cls = Class.forName(classname);
                Class<?>[] iter = cls.getInterfaces();

                boolean flag = false;
                if (isFouceCheck)
                {
                    for (Class<?> cz : iter)
                    {
                        if (cz.getName().equals(BaseEnum.class.getName()))
                        {
                            flag = true;

                            break;
                        }
                    }
                }

                if (flag == isFouceCheck)
                {
                    Method method = cls.getMethod("values");
                    BaseEnum inter[] = (BaseEnum[]) method.invoke(null, null);

                    Map<String, String> singleEnumMap = new LinkedHashMap<String, String>(inter.length);
                    String enumTypeName = null;
                    for (BaseEnum enumEle : inter)
                    {
                        singleEnumMap.put(enumEle.getValue(), enumEle.getDesc());

                        if (null == enumTypeName)
                        {
                            enumTypeName = enumEle.enumTypeName();
                        }
                    }

                    resultMap.put(enumTypeName, singleEnumMap);
                }
            }
        }
        catch (Exception e)
        {
        }

        return resultMap;
    }
}
