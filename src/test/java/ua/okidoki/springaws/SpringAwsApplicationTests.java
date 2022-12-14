package ua.okidoki.springaws;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringAwsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getSingleUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void returnsNotFoundForInvalidUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/9999")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void addNewUser() throws Exception {
        String newUser = "{\"email\":\"pitt@gmail.com\",\"firstName\":\"Steve\",\"lastName\":\"Johns\",\"mobileNumber\":\"+3806787654321\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newUser)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}
