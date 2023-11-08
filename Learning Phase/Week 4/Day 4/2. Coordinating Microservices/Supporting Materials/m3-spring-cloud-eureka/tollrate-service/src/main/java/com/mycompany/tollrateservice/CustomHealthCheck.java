package com.mycompany.tollrateservice;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {

    int errorCode = 0;

    @Override
    public Health health() {
        System.out.println("health check performed, error code is " + errorCode);

        if (errorCode > 2 && errorCode < 4) {
            errorCode++;
            return Health.down().withDetail("Custom Error Code", errorCode).build();
        } else {
            errorCode++;
            return Health.up().build();
        }

    }
}
