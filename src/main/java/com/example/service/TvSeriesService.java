package com.example.service;

import com.example.dao.TvSeriesDao;
import com.example.pojo.TvSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: RESTful API
 * User: quent
 * Date: 2018/11/24
 * Time: 10:56
 */
@Service
public class TvSeriesService {

    @Autowired TvSeriesDao tvSeriesDao;

    public List<TvSeries> getAllTvSeries(){
        return tvSeriesDao.getAll();
    }
}
