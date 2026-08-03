package dev.danvega.ot;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Observed(name = "greeting.service",contextualName = "Generate Greeting")
    public String greet(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return "Hello " + name;
    }
}