package com.doroz.restapi.service;

import com.doroz.restapi.entity.Resource;
import com.doroz.restapi.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public Resource getResourceById(Long id) {
        return resourceRepository.findById(id).get();
    }

    public Resource addResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public void updateResource(Long id, Resource resource) {
        Resource resourceFromDb = resourceRepository.findById(id).get();
        System.out.println("Updating resource: " + resourceFromDb);
        resourceFromDb.setRole(resource.getRole());
        resourceFromDb.setSubscriptions(resource.getSubscriptions());
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
        System.out.println("Resource " + id + " deleted");
    }
}
