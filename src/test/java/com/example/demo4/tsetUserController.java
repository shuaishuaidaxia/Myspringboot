package com.example.demo4;

import com.example.Demo4Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo4Application.class)
@AutoConfigureMockMvc
public class tsetUserController {

    @Resource
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        //构建请求
        MockHttpServletRequestBuilder builder= MockMvcRequestBuilders.get("/user/list")
                .contentType("text/html")//设置请求头
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8");

        //发送请求 获取结果
        ResultActions prtfrom=mockMvc.perform(builder);
        //请求检验判断
        prtfrom.andExpect(MockMvcResultMatchers.status().isOk());
        //获取返回结果
        MvcResult result=prtfrom.andReturn();
        //得到相应对象
        MockHttpServletResponse response=result.getResponse();

        //得到响应状态吗和消息
        System.out.println("响应码:"+response.getStatus());
        System.out.println("响应消息:"+response.getContentAsString());
    }
}
