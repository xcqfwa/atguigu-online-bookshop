package com.bear.book.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/2 8:41
 */
public class BeanUtils {
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
}
