package com.example.demo_springboot.domain;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FormField {

    String label() default "chưa cài đặt label" ;
    FieldType type();

    enum FieldType {
        ID("hidden"),
        TEXT("text"),
        PASSWORD("password"),
        NUMBER("number"),
        SELECT("select"),
        BOOLEAN("checkbox"),
        DATE("date");
        private final String inputType;
        FieldType(String inputType) {
            this.inputType = inputType;
        }
        public String getInputType() {
            return inputType;
        }
    }
}
