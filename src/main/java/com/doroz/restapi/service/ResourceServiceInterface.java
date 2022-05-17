package com.doroz.restapi.service;

import com.doroz.restapi.model.Resource;

public interface ResourceServiceInterface {

    Iterable<Resource> getResources();

    Resource getResourceById(Long id);

    Resource addResource(Resource resource);

    void updateResource(Long id, Resource resource);

    void deleteResource(Long id);
}
