package priv.shen.learn.handler;

import priv.shen.learn.dto.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, Exception e){
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(request.getRequestURI());
        errorInfo.setData("data when error");
        return errorInfo;
    }

}
