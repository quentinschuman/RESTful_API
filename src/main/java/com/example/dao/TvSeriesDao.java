package com.example.dao;

import com.example.pojo.TvSeries;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: RESTful API
 * User: quent
 * Date: 2018/11/24
 * Time: 10:10
 */
public interface TvSeriesDao {

    @Select("SELECT * FROM tv_series")
    public List<TvSeries> getAll();
}
