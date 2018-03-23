package com.zyf.springboot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class MockTestUtil {

    private static final Logger log = LoggerFactory.getLogger(MockTestUtil.class);

    private static double curD = 100.1;

    private static float curF = 10000.2f;

    private static int curInt = 1;

    private static long curL = 1000;

    private static int curS = 1;

    private static String[] rs = new String[]{"A", "C", "D", "E", "F", "J", "H", "I", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "c", "d", "e", "f", "j", "h", "i", "k", "l", "m", "n", "o", "p", "q",
            "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "f"};

    private static String getFieldName(String methodName) {
        String s = "set";
        String ups = methodName.toLowerCase();
        String key = null;
        if (ups.contains(s)) {
            key = ups.substring(s.length());
        }
        return (key == null) ? null : key;
    }

    public static <T> T getJavaBean(Class<T> c) {

        T object = null;
        List<Method> allMethods = new ArrayList<>();
        List<Field> allFields = new ArrayList<>();
        try {
            object = c.newInstance();
            Method[] methods = c.getDeclaredMethods();
            Field[] fields = c.getDeclaredFields();
            allMethods.addAll(Arrays.asList(methods));
            allFields.addAll(Arrays.asList(fields));
            Class superClass = c.getSuperclass();
            while (superClass != null) {
                allMethods.addAll(Arrays.asList(superClass.getDeclaredMethods()));
                allFields.addAll(Arrays.asList(superClass.getDeclaredFields()));
                superClass = superClass.getSuperclass();
            }
            for (Method m : allMethods) {
                if (m.getName().contains("set")) {
                    String field = getFieldName(m.getName());
                    String type = "string";
                    for (Field f : allFields) {
                        if (f.getName().toLowerCase().equals(field)) {
                            type = f.getType().getSimpleName().toLowerCase();
                            break;
                        }
                    }
                    try {
                        m.invoke(object, getValue(type));
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        log.error("{} {} {}", field, e.getMessage(), e);
                    }
                }
            }

        } catch (Exception e) {
            //log.error(e.getMessage(), e);
        }
        return object;
    }

    public static String getRand(int size) {
        Random random = new Random();
        String rvs = "";
        for (int i = 0; i < size; i++) {
            int status = random.nextInt(size);
            if (status < rs.length && status > 0) {
                rvs += rs[status];
            } else {
                rvs += "A";
            }

        }
        return rvs;
    }

    private static Object getValue(String s) {
        Object temp = null;
        String st = s.toLowerCase();
        Random random = new Random(10010);
        if (st.equals("int") || st.equals("integer")) {
            temp = curInt;
            curInt++;
        } else if (st.equals("long")) {
            temp = curL;
            curL++;
        } else if (st.equals("string")) {
            temp = curS + getRand(6);
            curS++;
        } else if (st.equals("double")) {
            temp = curD;
            curD++;
        } else if (st.equals("float")) {
            temp = curF;
            curF++;
        } else if (st.equals("boolean")) {
            temp = random.nextBoolean();
        } else if (st.equals("date")) {
            temp = new Date();
        } else if (st.equals("bigdecimal")) {
            temp = new BigDecimal(curInt);
            curInt++;
        } else if (st.equals("biginteger")) {
            temp = new BigInteger(String.valueOf(curInt));
            curInt++;
        } else if (st.equals("byte")) {
            temp = (byte) curInt;
            curInt++;
        }
        return (temp == null) ? null : (temp);
    }
}