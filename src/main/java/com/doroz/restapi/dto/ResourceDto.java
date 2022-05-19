package com.doroz.restapi.dto;


import com.doroz.restapi.entity.Resource;
import com.doroz.restapi.entity.Subscription;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class ResourceDto extends Resource {
    private Long id;
    private String role;
    private Set<Subscription> subscriptions = new HashSet<>();

}
