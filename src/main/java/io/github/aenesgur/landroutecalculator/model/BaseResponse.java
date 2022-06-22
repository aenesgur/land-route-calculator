package io.github.aenesgur.landroutecalculator.model;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BaseResponse {
    private LocalDateTime timeStamp;
    private Boolean success = true;
    private String message;
}
