package io.github.aenesgur.landroutecalculator.exception;

import io.github.aenesgur.landroutecalculator.model.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(RouteNotFoundException.class)
    public ResponseEntity<Object> routeNotFoundException(Exception ex, WebRequest request){
        BaseResponse baseResponse = new BaseResponse(LocalDateTime.now(),false,ex.getMessage());
        return handleExceptionInternal(ex,baseResponse,null, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> runtimeException(Exception ex, WebRequest request){
        BaseResponse baseResponse = new BaseResponse(LocalDateTime.now(),false,"Bizimle iletişime geçin, TRACE ID");
        Logger logger = LoggerFactory.getLogger(Slf4j.class);
        logger.error(ex.getMessage(),ex);
        return handleExceptionInternal(ex, baseResponse, null, HttpStatus.NOT_FOUND, request);
    }
}
