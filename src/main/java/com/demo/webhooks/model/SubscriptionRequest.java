package com.demo.webhooks.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SubscriptionRequest {

    @NotNull
    private String name;
    @NotNull
    private String level;
    @NotNull
    private String url;

}
