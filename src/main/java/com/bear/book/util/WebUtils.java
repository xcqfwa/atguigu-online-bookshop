package com.bear.book.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/2 8:41
 */
public class WebUtils {
    /**
     * Let the form request parameters into a java bean project
     *
     * @param bean  java bean
     * @param value map
     * @return java bean
     */
    public static <T> T copyParamsToBean(T bean, Map<String, String[]> value) {
        try {
            org.apache.commons.beanutils.BeanUtils.populate(bean, value);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将 Object 类型转换为 Integer
     *
     * @param obj          Object
     * @param defaultValue 转换失败时返回的默认值
     * @return Integer
     */
    public static int objectToString(Object obj, int defaultValue) {
        try {
            return Integer.parseInt(String.valueOf(obj));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
