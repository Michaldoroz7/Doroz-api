package com.doroz.restapi.dto;


import com.doroz.restapi.entity.Resource;
import com.doroz.restapi.entity.Subscription;
import com.doroz.restapi.service.SubscriptionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class SubscriptionDto extends Subscription {

    private Long id;

    @Enumerated(EnumType.STRING)
    private SubscriptionType subtype;

    private String startDate;
    private String endDate;
    private Resource resource;
}
