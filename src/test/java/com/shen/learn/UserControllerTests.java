package com.shen.learn;

import com.shen.learn.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTests {
    private MockMvc mvc;

    @Before
    public void setUp(){
        mvc=MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void test() throws Exception{
        RequestBuilder request = null;

        request=MockMvcRequestBuilders.get("/users/");

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        request=MockMvcRequestBuilders.post("/users/")
                .param("id","1")
                .param("name","测试")
                .param("age","20");

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

        request=MockMvcRequestBuilders.get("/users/");

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试\",\"age\":20}]")));

        request=MockMvcRequestBuilders.put("/users/1")
                .param("id","1")
                .param("name","测试")
                .param("age","10");

        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));


        request=MockMvcRequestBuilders.get("/users/1");

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试\",\"age\":10}")));

        request=MockMvcRequestBuilders.delete("/users/1");

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

        request=MockMvcRequestBuilders.get("/users/");

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }
}
