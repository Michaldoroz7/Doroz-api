package com.doroz.restapi.service;

import com.doroz.restapi.AbstractTest;
import com.doroz.restapi.entity.Resource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResourceServiceControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getResource() throws Exception {
        String uri = "/resources";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Resource[] resources = super.mapFromJson(content, Resource[].class);
        assertTrue(resources.length > 0);
    }

    @Test
    public void createResource() throws Exception {
        String uri = "/resources";
        Resource resource = new Resource();
        resource.setId(3L);
        resource.setMaterial("Test role");
        String inputJson = super.mapToJson(resource);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Resource created!");
    }

    @Test
    public void deleteResource() throws Exception {
        String uri = "/resources/3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Resource deleted");
    }
}
