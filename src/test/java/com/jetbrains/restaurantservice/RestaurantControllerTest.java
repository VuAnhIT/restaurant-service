package com.jetbrains.restaurantservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RestaurantControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetAStubRestaurantFromTheRestaurantService() throws Exception {
        this.mockMvc.perform(get("/restaurant"))
                    .andExpect(status().isOk())
                    .andExpect(content().json("""
                                                      {"id":null,
                                                      "name":"Dalia's",
                                                      "address":"",
                                                      "indoorCapacity":0,
                                                      "outdoorCapacity":0,
                                                      "openingHours":[]}
                                                      """));
    }

    @Test
    @DisplayName("Should return a list of all restaurants in the database")
    void shouldReturnAListOfAllRestaurantsInTheDatabase() throws Exception {
        this.mockMvc.perform(get("/restaurants"))
                    .andExpect(status().isOk())
                    .andExpect(content().json("""
                                                      []
                                                      """));
    }

    // TODO: get all restaurants
    // TODO: get a restaurant by ID
    // TODO: update a restaurant's details
    // TODO: delete a restaurant
    // TODO: create a restaurant

    // Restaurant Admins:
    // {id: admin_id,
    //  name: bob
    //  password:
    //  email: ,
    //  restaurant_id: int}
}