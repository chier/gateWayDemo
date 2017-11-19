package com.jhz.demo.common.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lishi on 2017/11/5.
 */
public class BeanUtils {
    public static void copyProperties(Object source, Object target) {
        copyProperties(source, target, null);
    }

    public static void copyProperties(Object source, Object target,
                                      String[] ignoreProperties) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class<?> targetClass = target.getClass();
        Field[] targetFields = targetClass.getDeclaredFields();
        List<String> ignoreList = ignoreProperties == null ? null : Arrays.asList(ignoreProperties);
        for (Field targetField : targetFields) {
            String targetFieldName = targetField.getName();
            Method writeMethod = getWriteMethod(targetField);
            if (writeMethod == null
                    || (ignoreList != null && ignoreList.contains(targetFieldName))) {
                continue;
            }
            Field sourceField = null;
            try {
                sourceField = source.getClass().getDeclaredField(targetFieldName);
            } catch (NoSuchFieldException | SecurityException e1) {
                continue;
            }
            ParameterizedType sourceGenericType = (ParameterizedType) sourceField
                    .getGenericType();
            ParameterizedType targetGenericType = (ParameterizedType) targetField
                    .getGenericType();
            if (!genericTypeEquals(sourceGenericType, targetGenericType)) {
                continue;
            }
            Method readMethod = getReadMethod(sourceField);
            if (sourceField == null || readMethod == null) {
                continue;
            }
            Object value = null;
            try {
                value = readMethod.invoke(source);
                writeMethod.invoke(target, value);
            } catch (IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {}
        }
    }

    // 判断字段泛型是否相同
    private static boolean genericTypeEquals(ParameterizedType sourceGenericType,
                                             ParameterizedType targetGenericType) {
        Type[] sourceTypes = sourceGenericType.getActualTypeArguments();
        Type[] targetTypes = targetGenericType.getActualTypeArguments();
        if (sourceTypes == null) {
            if (targetTypes == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (targetTypes == null) {
                return false;
            } else {
                int lengthS = sourceTypes.length;
                int lengthT = targetTypes.length;
                if (lengthS != lengthT) {
                    return false;
                } else {
                    for (int i = 0; i < lengthS; i++) {
                        if (!sourceTypes[i].equals(targetTypes[i])) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
    }

    // 获取get方法或者is方法(boolean)
    private static Method getReadMethod(Field sourceField) {
        Method method = null;
        Class<?> declaringClass = sourceField.getDeclaringClass();
        String fieldName = StringUtils.capitalize(sourceField.getName());
        try {
            method = declaringClass.getMethod("get" + fieldName);
        } catch (NoSuchMethodException | SecurityException e) {}
        try {
            method = declaringClass.getMethod("is" + fieldName);
        } catch (NoSuchMethodException | SecurityException e) {}
        return method;
    }

    // 获取set方法
    private static Method getWriteMethod(Field targetField) {
        Method method = null;
        Class<?> declaringClass = targetField.getDeclaringClass();
        String fieldName = StringUtils.capitalize(targetField.getName());
        try {
            method = declaringClass.getMethod("set" + fieldName, targetField.getType());
        } catch (NoSuchMethodException | SecurityException e) {}
        return method;
    }

}
