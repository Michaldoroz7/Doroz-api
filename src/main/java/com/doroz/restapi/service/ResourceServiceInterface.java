package com.doroz.restapi.service;

import com.doroz.restapi.model.Resource;

import java.util.List;

public interface ResourceServiceInterface {

    List<Resource> getResources();
    Resource getResourceById(Long id);
    Resource addResource(Resource resource);
    void updateResource(Long id, Resource resource);
    void deleteResource(Long id);
}
