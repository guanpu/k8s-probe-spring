package guanpu.me.controllers;

import guanpu.me.entities.HealthStatus;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Endpoint(id="customized")
@Component
public class CustomizedHealthEndpoint {
    @ReadOperation
    public HealthStatus ready() {
        return new HealthStatus("ready");
    }
}
