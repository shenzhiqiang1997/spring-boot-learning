package com.shen.learn;

import com.shen.learn.web.HelloController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearningApplicationTests {

    private MockMvc mvc;

    @Autowired
    private Properties properties;

    @Before
    public void setUp(){
        mvc=MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void test() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World")));
    }

    @Test
    public void testProperties(){
        Assert.assertEquals(properties.getName(),"no one");
        Assert.assertEquals(properties.getTitle(),"spring boot");
        Assert.assertEquals(properties.getDesc(),"no one 写了第一个 spring boot demo");
        System.out.println(properties.getValue());
        System.out.println(properties.getNum());
    }



}
