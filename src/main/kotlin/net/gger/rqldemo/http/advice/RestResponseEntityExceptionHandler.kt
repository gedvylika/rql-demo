package net.gger.rqldemo.http.advice

import net.gger.rqldemo.exception.BadSyntaxException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.RuntimeException

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [BadSyntaxException::class, UnsupportedOperationException::class])
    protected fun handleConflict(
        ex: RuntimeException, request: WebRequest
    ): ResponseEntity<Any> {
        val bodyOfResponse = "Bad request: ${ex.message}"
        return handleExceptionInternal(ex, bodyOfResponse, HttpHeaders(), HttpStatus.BAD_REQUEST, request)
    }
}