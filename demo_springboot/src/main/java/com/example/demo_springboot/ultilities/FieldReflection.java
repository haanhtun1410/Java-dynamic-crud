package com.example.demo_springboot.ultilities;




import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FieldReflection {

    private Class<?> className;
    public FieldReflection(Class<?> className) {
        this.className = className;
    }
    public FieldReflection() {
    }

    ///lay tat ca ca truong co trong className;
    public List<Field> getAllFields() {
        List<Field> fields = new ArrayList<>();
        Class<?> clazz = className;
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                fields.add(field);
            }
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
    //////Tao va lay du lieu 1 list cua class duoc dua vao /// optional : co the cai tien hon;
    public static <T> List<T> createListOf(Class<T> clazz) {
        Crud sv = new CrudImpl(clazz);
        List<T> listOfClazz = sv.readAll();
        System.out.println("list of class sau khi get from read aLL: "+listOfClazz.toString());
        return listOfClazz;
    }
    ////lay 1 list chua cac list cua cac class co ben trong className;
    ////note : dung de lay thong tin cho <select>
    ///tra ve list<list>
    public List<List<?>> getAllRelationClasses(){
        Set<Class<?>> classes = new HashSet<>();
        List<List<?>> listOfLists = new ArrayList<List<?>>();
        List<Field> fields = getAllFields();
        for (Field field : fields) {
            Class<?> fieldType = field.getType();
            if (!fieldType.isPrimitive() && !fieldType.getPackage().getName().startsWith("java")) {
                classes.add(fieldType);
                System.out.println(fieldType.toString() + " +  " + classes.size());
            }
        }
        for (Class<?> clazz : classes) {
            List<?> listOfClazz = createListOf(clazz);
            listOfLists.add(listOfClazz);
        }
        return listOfLists;
    }


}
