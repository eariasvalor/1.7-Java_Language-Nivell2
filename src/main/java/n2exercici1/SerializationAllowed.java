package n2exercici1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SerializationAllowed {

    String dir() default "src/main/resources/data";
    String fileName() default "serializedFile.json";
}
