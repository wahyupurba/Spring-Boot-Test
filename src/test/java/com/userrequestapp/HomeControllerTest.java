/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userrequestapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userrequestapp.entity.other.ModuleResponses;
import com.userrequestapp.entity.other.Responses;
import com.userrequestapp.entity.other.ResponsesValue;
import com.userrequestapp.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import org.junit.Before;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * @author yuu
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("tesofuserrequestapp")
public class HomeControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    
//    @Autowired
//    private MockMvc mockMvc;
//
    @MockBean
    private UserService userService;

    @Before
    public void init() {

        Responses responses = new Responses();
        ModuleResponses moduleResponses = new ModuleResponses();

        List<ResponsesValue> responsesValues = new ArrayList<ResponsesValue>();
        responsesValues.add(new ResponsesValue("CategoryCard", 2));
        responsesValues.add(new ResponsesValue("NewsCard", 5));
        responsesValues.add(new ResponsesValue("HistoryCard", 4));
        responsesValues.add(new ResponsesValue("FlashSaleCard", 3));
        responsesValues.add(new ResponsesValue("PromoCard", 1));

        moduleResponses.setModules(responsesValues);
        responses.setUserId(2);
        responses.setResponses(moduleResponses);

//        when(userService.dashboard(Long.valueOf(1))).thenReturn(Optional.of(rv));
    }

//    @Test
//    public void userId_NotFound_404() throws Exception {
//        mockMvc.perform(get("/api/dashboard/5")).andExpect(status().isNotFound());
//    }
//    @Test
//    public void userId_home_OK() throws Exception {
//
//        mockMvc.perform(get("/api/dashboard/2"))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.userId", is(2)));
//
//        verify(userService, times(1)).dashboard(2L);
//
//    }
    @Test
    public void dashboard_OK() throws Exception {

        String uri = "/api/dashboard/2";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Responses responses = super.mapFromJson(content, Responses.class);
        assertTrue(responses != null);
    }


}
