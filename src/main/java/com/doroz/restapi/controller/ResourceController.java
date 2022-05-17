package com.doroz.restapi.controller;


import com.doroz.restapi.model.Resource;
import com.doroz.restapi.service.ResourceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/resources")
    public Iterable<Resource> showResources() {
        return resourceService.getResources();
    }

    @GetMapping("/resources/{id}")
    public Resource getResourceById(@PathVariable("id") long id) {
        return resourceService.getResourceById(id);
    }

    @PostMapping("/resources")
    public Resource newResource(@RequestBody Resource resource) {
        return resourceService.addResource(resource);
    }

    @DeleteMapping("/resources/delete/{id}")
    public void deleteResource(@PathVariable("id") long id) {
        resourceService.deleteResource(id);
        System.out.println("Deleted resource: " + id);
    }
}
