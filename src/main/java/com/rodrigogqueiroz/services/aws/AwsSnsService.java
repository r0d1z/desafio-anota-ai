package com.rodrigogqueiroz.services.aws;

import com.rodrigogqueiroz.config.aws.AwsSnsConfig;
import jakarta.enterprise.context.ApplicationScoped;
import software.amazon.awssdk.services.sns.SnsClient;

@ApplicationScoped
public class AwsSnsService {

    private final SnsClient snsClient;
    private final AwsSnsConfig awsSnsConfig;

    public AwsSnsService(SnsClient snsClient, AwsSnsConfig awsSnsConfig) {
        this.snsClient = snsClient;
        this.awsSnsConfig = awsSnsConfig;
    }

    public void publishMessage(MessageDTO message) {
        this.snsClient.publish(publishRequest -> publishRequest
                .message(message.message())
                .topicArn(awsSnsConfig.getCatalogTopicArn()));
    }
}