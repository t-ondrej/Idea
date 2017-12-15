package sk.upjs.ics.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {
    
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                            "Parameter has to be of a type " + e.getRequiredType().getSimpleName());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    ErrorMessage getErrorMessage(HttpMediaTypeNotSupportedException ex) {
        String supported = "Supported content types: " + MediaType.toString(ex.getSupportedMediaTypes());
        return new ErrorMessage(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(),
                            "Supported media type is: " + supported);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorMessage handleException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<String> errors = new ArrayList<>(fieldErrors.size() + globalErrors.size());
        String error;
        for (FieldError fieldError : fieldErrors) {
            error = fieldError.getField() + ", " + fieldError.getDefaultMessage();
            errors.add(error);
        }
        for (ObjectError objectError : globalErrors) {
            error = objectError.getObjectName() + ", " + objectError.getDefaultMessage();
            errors.add(error);
        }
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), String.join(", ", errors));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorMessage getErrorMessage(HttpMessageNotReadableException ex) {
        Throwable mostSpecificCause = ex.getMostSpecificCause();
        if (mostSpecificCause != null) {
            String message = mostSpecificCause.getMessage();
            return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), message);
        }
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}