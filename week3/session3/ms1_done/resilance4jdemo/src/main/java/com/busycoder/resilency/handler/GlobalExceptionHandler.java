package com.busycoder.resilency.handler;

import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequestNotPermitted.class)
    public ProblemDetail handleRateLimit(RequestNotPermitted ex) {

        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.TOO_MANY_REQUESTS);

        problem.setTitle("Rate Limit Exceeded");
        problem.setDetail("Too many requests. Please try again later.");

        return problem;
    }

    @ExceptionHandler(BulkheadFullException.class)
    public ProblemDetail handle(BulkheadFullException ex) {
        ProblemDetail problem =ProblemDetail.forStatus(HttpStatus.TOO_MANY_REQUESTS);
        problem.setTitle("Bulkhead Full");
        problem.setDetail("Maximum concurrent calls reached.");
        return problem;
    }
}