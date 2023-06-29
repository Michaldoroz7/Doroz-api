package com.doroz.restapi.service;

import com.doroz.restapi.entity.Resource;
import com.doroz.restapi.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class ResourceService {

    @Autowired
    ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<Resource> getResources() {
        return (List<Resource>) resourceRepository.findAll();
    }
    public List<Resource> getSpecificClientResources(Long clientId) {
        List<Resource> resources = (List<Resource>) resourceRepository.findAll();
        List<Resource> specificClientResources = new ArrayList<>();

        for (Resource resource : resources) {
            if (Objects.equals(resource.getClientId(), clientId)) {
                specificClientResources.add(resource);
            }
        }
        return specificClientResources;
    }

    public Resource getResourceById(Long id) {
        return resourceRepository.findById(id).get();
    }

    public Resource addResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public void updateResource(Long id, Resource resource) {
        Resource resourceFromDb = resourceRepository.findById(id).get();
        System.out.println("Updating resource: " + resourceFromDb);
        resourceFromDb.setMaterialLink(resource.getMaterialLink());
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
        System.out.println("Resource " + id + " deleted");
    }
}
