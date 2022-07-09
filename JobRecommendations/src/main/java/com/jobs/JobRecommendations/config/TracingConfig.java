package com.jobs.JobRecommendations.config;

import io.opentracing.Tracer;
import io.opentracing.contrib.grpc.TracingServerInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfig {
    @GrpcGlobalServerInterceptor
    TracingServerInterceptor tracingInterceptor(Tracer tracer) {
        return TracingServerInterceptor
                .newBuilder()
                .withTracer(tracer)
                .build();
    }
}
