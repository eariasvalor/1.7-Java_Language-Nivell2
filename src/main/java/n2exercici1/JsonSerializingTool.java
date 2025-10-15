package n2exercici1;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class JsonSerializingTool {
    private static final ObjectMapper MAPPER = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    private JsonSerializingTool() {
    }

    public static Path serialize(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("The object cannot be null.");
        }

        Class<?> c = object.getClass();
        SerializationAnnotation annotation = c.getAnnotation(SerializationAnnotation.class);
        if (annotation == null) {
            throw new IllegalStateException("The class " + c.getName() + " is not annotated with @SerializationAnnotation");
        }


        String dir = annotation.dir();
        String fileName = annotation.fileName().isBlank() ? c.getSimpleName() + ".json" : annotation.fileName();

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
