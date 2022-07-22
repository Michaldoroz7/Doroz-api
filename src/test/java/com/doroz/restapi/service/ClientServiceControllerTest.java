package com.doroz.restapi.service;

import com.doroz.restapi.AbstractTest;
import com.doroz.restapi.entity.Client;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClientServiceControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getClient() throws Exception {
        String uri = "/clients";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Client[] clients = super.mapFromJson(content, Client[].class);
        assertTrue(clients.length > 0);
    }

    @Test
    public void CreateClient() throws Exception {
        String uri = "/clients";
        Client client = new Client();
        client.setId(3L);
        client.setLogin("Test-Client");
        String inputJson = super.mapToJson(client);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Client created!");
    }

    @Test
    public void DeleteClient() throws Exception {
        String uri = "/clients/3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Client deleted");
    }
}
