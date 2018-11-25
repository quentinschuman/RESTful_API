package com.example.demo;

import com.example.controller.TvSeriesController;
import com.example.dao.TvSeriesDao;
import com.example.pojo.TvSeries;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: RESTful API
 * User: quent
 * Date: 2018/11/24
 * Time: 19:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppTest {

    @Autowired
    private TvSeriesDao tvSeriesDao;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TvSeriesController tvSeriesController;
    @Test
    public void contextLoads()throws Exception{

    }
    @Test
    public void getAll()throws Exception{
        List<TvSeries> list = new ArrayList<>();
        TvSeries ts = new TvSeries();
        ts.setName("test");
        list.add(ts);
        Mockito.when(tvSeriesDao.getAll()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/tvseries")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.contains("test")));
    }
}
