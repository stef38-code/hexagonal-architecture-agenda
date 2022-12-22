package org.hexagonal.architecture.agenda.infrastructure.tools;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;

public class JsonFile {
    static Logger logger = LoggerFactory.getLogger(JsonFile.class);

    private JsonFile() {
        throw new UnsupportedOperationException("JsonFile is a utility class and cannot be instantiated");
    }

    public static Optional<File> getFile(String name) {
        ClassLoader classLoader = JsonFile.class.getClassLoader();
        URL resource = classLoader.getResource(name);
        if (Objects.isNull(resource)) {
            return Optional.empty();
        }
        return Optional.of(new File(resource.getFile()));
    }

    public static <T> Optional<T> parseJsonToObject(Optional<File> json, TypeReference<T> ref) {
        Optional<T> result = Optional.empty();
        if (json.isPresent()) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                result = Optional.of(objectMapper.readValue(json.get(), ref));
            } catch (IOException e) {
                logger.error("Erreur parsing", e);
            }
        }

        if (result.isEmpty()) {
            result = Optional.empty();
        }
        return result;
    }
}
