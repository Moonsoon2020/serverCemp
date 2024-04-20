package org.serv.servercemp

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class ServerCempApplicationTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `test get all persons endpoint`() {
        mockMvc.perform(get("/allpersons"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].login").value("expectedLogin"))
            .andExpect(jsonPath("$[0].password").value("expectedPassword"))
            .andExpect(jsonPath("$[0].status").value(true))
    }

    @Test
    fun `test add person endpoint`() {
        mockMvc.perform(post("/addperson")
            .param("login", "testLogin")
            .param("password", "testPassword")
            .param("status", "true"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.status").value(true))
    }

}
