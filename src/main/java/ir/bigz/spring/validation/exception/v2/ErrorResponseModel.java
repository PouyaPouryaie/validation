package ir.bigz.spring.validation.exception.v2;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
public class ErrorResponseModel {

    private final Map<String, String> errors;
    private final LocalDateTime localDateTime;
    private final String path;
}
