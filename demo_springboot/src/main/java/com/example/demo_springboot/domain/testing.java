package com.example.demo_springboot.domain;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class testing {
    public static void main(String[] args) throws Exception {



        Class<?> clazz = Class.forName("com.example.demo_springboot.domain."+"ChucVu");
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getType());
            if(field.getType().isInterface()){
            Type t = field.getGenericType();
                ParameterizedType t2 = (ParameterizedType) t;
                System.out.println(t2.getActualTypeArguments()[0].getTypeName());
            }
            if (field.isAnnotationPresent(FormField.class)) {
;
                FormField formFieldAnnotation = field.getAnnotation(FormField.class);
                String fieldName = formFieldAnnotation.label();
                String fieldType = formFieldAnnotation.type().getInputType();
                System.out.println("Field: " + field.getAnnotation(FormField.class).label()+ ", Type: " + fieldType);
            }
        }
    }
}
