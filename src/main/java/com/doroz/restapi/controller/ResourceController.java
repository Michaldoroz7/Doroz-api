package com.doroz.restapi.controller;


import com.doroz.restapi.dto.ResourceDto;
import com.doroz.restapi.entity.Resource;
import com.doroz.restapi.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/resources")
    public List<ResourceDto> showResources() {
        return resourceService.getResources().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/resources/{id}")
    public ResourceDto getResourceById(@PathVariable("id") long id) {
        return mapToDto(resourceService.getResourceById(id));
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

    private ResourceDto mapToDto(Resource resource) {
        ResourceDto rDto = new ResourceDto();
        rDto.setId(resource.getId());
        rDto.setRole(resource.getRole());

        return rDto;
    }
}
