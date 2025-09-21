package com.rodrigogqueiroz.config.aws;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
@Getter
public class AwsSnsConfig {
    
    @ConfigProperty(name = "aws.sns.topic.catalog.arn")
    private String catalogTopicArn;
}
