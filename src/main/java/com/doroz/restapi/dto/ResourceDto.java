package com.doroz.restapi.dto;


import com.doroz.restapi.entity.Resource;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResourceDto extends Resource {
    private Long id;
    private String role;
}
