package com.example.tacocloud;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

//@WebMvcTest(HomController.class)
//public class HomControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void testHomePage() throws  Exception{
//     mockMvc.perform(get("/"))
//             .andExpect(status().isOk())
//             .andExpect(view().name("home"))
//             .andExpect(content().string(
//                     containsString("Welcome to...")));
//
//    }
//}
