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

    @CrossOrigin(origins = "*")
    @GetMapping("/resources")
    public List<ResourceDto> showResources() {
        return resourceService.getResources().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/resources/client/{clientId}")
    public List<ResourceDto> getSpecificUserResources(@PathVariable("clientId") long clientId) {
        return resourceService.getSpecificClientResources(clientId).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/resources/{id}")
    public ResourceDto getResourceById(@PathVariable("id") long id) {
        return mapToDto(resourceService.getResourceById(id));
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/resources", consumes = {"*/*"})
    public Resource newResource(@ModelAttribute Resource resource) {
        return resourceService.addResource(resource);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/resources/delete/{id}")
    public void deleteResource(@PathVariable("id") long id) {
        resourceService.deleteResource(id);
        System.out.println("Deleted resource: " + id);
    }

    private ResourceDto mapToDto(Resource resource) {
        ResourceDto rDto = new ResourceDto();
        rDto.setId(resource.getId());
        rDto.setMaterialLink(resource.getMaterialLink());
        rDto.setClientId(resource.getClientId());
        rDto.setMaterialName(resource.getMaterialName());

        return rDto;
    }
}
