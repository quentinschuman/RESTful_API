package com.example.demo;

import com.example.dao.TvSeriesDao;
import com.example.pojo.TvSeries;
import com.example.service.TvSeriesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: RESTful API
 * User: quent
 * Date: 2018/11/24
 * Time: 16:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TvSeriesServiceTest {

    @MockBean TvSeriesDao tvSeriesDao;
    @Autowired TvSeriesService tvSeriesService;

    @Test
    public void testGetAllWithoutMockit(){
        List<TvSeries> list = tvSeriesService.getAllTvSeries();
        Assert.assertTrue(list.size() >= 0);
    }

    @Test
    public void getAll(){
        List<TvSeries> list = new ArrayList<>();
        TvSeries ts = new TvSeries();
        ts.setName("test");
        list.add(ts);
        Mockito.when(tvSeriesDao.getAll()).thenReturn(list);
        List<TvSeries> result = tvSeriesService.getAllTvSeries();
        Assert.assertTrue(result.size() == list.size());
        Assert.assertTrue("test".equals(result.get(0).getName()));
    }
}
