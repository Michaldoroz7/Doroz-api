package com.doroz.restapi.service;

import com.doroz.restapi.model.Resource;
import com.doroz.restapi.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ResourceService implements ResourceServiceInterface {

    @Autowired
    ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Iterable<Resource> getResources() {
        return resourceRepository.findAll();
    }

    @Override
    public Resource getResourceById(Long id) {
        return resourceRepository.findById(id).get();
    }

    @Override
    public Resource addResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public void updateResource(Long id, Resource resource) {
        Resource resourceFromDb = resourceRepository.findById(id).get();
        System.out.println("Updating resource: " + resourceFromDb);
        resourceFromDb.setRole(resource.getRole());
        resourceFromDb.setSubscriptions(resource.getSubscriptions());
    }

    @Override
    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
        System.out.println("Resource " + id + " deleted");
    }
}
