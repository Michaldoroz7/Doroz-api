package com.doroz.restapi.service;


import com.doroz.restapi.AbstractTest;
import com.doroz.restapi.entity.Subscription;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SubscriptionServiceControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getSubscription() throws Exception {
        String uri = "/subscriptions";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Subscription[] subscriptions = super.mapFromJson(content, Subscription[].class);
        assertTrue(subscriptions.length > 0);
    }

    @Test
    public void createSubscription() throws Exception {
        String uri = "/subscriptions";
        Subscription subscription = new Subscription();
        subscription.setId(3L);
        String inputJson = super.mapToJson(subscription);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Subscription created");
    }

    @Test
    public void DeleteSubscription() throws Exception {
        String uri = "/subscriptions/3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Subscription Deleted!");
    }
}
