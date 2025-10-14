package n2exercici1;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class JsonSerializing {
    private static final ObjectMapper MAPPER = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    private JsonSerializing() {
    }

    public static Path serialize(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("The object cannot be null.");
        }

        Class<?> c = object.getClass();
        SerializationAllowed ann = c.getAnnotation(SerializationAllowed.class);
        if (ann == null) {
            throw new IllegalStateException("The class " + c.getName() + " is not annotated with @JsonSerializable");
        }


        String dir = ann.dir();
        String fileName = ann.fileName().isBlank() ? c.getSimpleName() + ".json" : ann.fileName();

        Path outDir = Paths.get(dir);
        try {
            Files.createDirectories(outDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path out = outDir.resolve(fileName);

        try {
            MAPPER.writeValue(out.toFile(), object);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out;
    }
}
