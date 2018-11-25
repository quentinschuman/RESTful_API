package com.example.controller;

import com.example.pojo.TvSeries;
import com.example.service.TvSeriesService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: RESTful API
 * User: quent
 * Date: 2018/11/21
 * Time: 15:42
 */
@RestController
@RequestMapping("/tvseries")
public class TvSeriesController {

    public static final Log log = LogFactory.getLog(TvSeriesController.class);

    @Autowired TvSeriesService tvSeriesService;

    @GetMapping
    public List<TvSeries> getAll(){
        if (log.isTraceEnabled()){
            log.trace("getAll() is done");
        }
//        List<TvSeries> list = new ArrayList<>();
//        Calendar calendar = Calendar.getInstance();
//        list.add(new TvSeries(1,"aaa",5,calendar.getTime()));
//        list.add(new TvSeries(2,"bbb",20,calendar.getTime()));
//        list.add(new TvSeries(3,"Naruto",720,calendar.getTime()));
//        list.add(new TvSeries(4,"Conan",980,calendar.getTime()));
        List<TvSeries> list = tvSeriesService.getAllTvSeries();
        return list;
    }

    @GetMapping("/{id}")
    public TvSeries getOne(@PathVariable int id){
        if (log.isTraceEnabled()){
            log.trace("getOne() is done" + id);
        }
        if (id == 101){
            return createNaruto();
        }else if (id == 102){
            return createConan();
        }else{
            return null;
        }
    }

    @PostMapping
    public TvSeries insertOne(@RequestBody TvSeries tvSeries){
        if (log.isTraceEnabled()){
            log.trace("insertOne");
        }
        tvSeries.setId(9999);
        System.out.println(tvSeries.toString());
        return tvSeries;
    }

    @PutMapping("{id}")
    public TvSeries updateOne(@PathVariable int id, @RequestBody TvSeries tvSeries){
        if (log.isTraceEnabled()){
            log.trace("updateOne" + id);
        }
        if (id == 101 || id == 102){
            return createNaruto();
        }else{
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public Map<String,String> deleteOne(@PathVariable int id, HttpServletRequest request,@RequestParam (value = "delete_reason",required = false) String deleteReason)throws Exception{
        if (log.isTraceEnabled()){
            log.trace("deleteOne" + id);
        }
        Map<String,String> result = new HashMap<>();
        if (id == 101){
            result.put("message","#101 is deleted by " + request.getRemoteAddr() + request.getRemoteHost() + request.getRemotePort() + " the reason is that " + deleteReason);
        }else if (id == 102){
            throw new RuntimeException("#102 can not be deleted!");
        }else {
            return null;
        }
        return result;
    }

    @PostMapping(value = "/{id}/photos",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addPhoto(@PathVariable int id, @RequestParam("photo") MultipartFile imgFile) throws Exception{
        if (log.isTraceEnabled()){
            log.trace("Receive file " + id + imgFile.getOriginalFilename());
        }
        //save file
        FileOutputStream fos = new FileOutputStream("target/" + imgFile.getOriginalFilename());
        IOUtils.copy(imgFile.getInputStream(),fos);
        fos.close();
    }

    @GetMapping(value = "/{id}/getpdf",produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPdf(@PathVariable int id) throws Exception{
        if (log.isTraceEnabled()){
            log.trace("getPdf" + id);
        }
        String pdfFile = "C:\\Users\\quent\\IdeaProjects\\Javaweb_bookstore-master\\RESTful API\\src\\main\\resources\\static\\testpdf.pdf";
        InputStream is = new FileInputStream(pdfFile);
        return IOUtils.toByteArray(is);
    }

    @GetMapping(value = "/{id}/geticon",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getIcon(@PathVariable int id) throws Exception{
        if (log.isTraceEnabled()){
            log.trace("getIcon" + id);
        }
        String pdfFile = "C:\\Users\\quent\\IdeaProjects\\Javaweb_bookstore-master\\RESTful API\\src\\main\\resources\\static\\qq.png";
        InputStream is = new FileInputStream(pdfFile);
        return IOUtils.toByteArray(is);
    }

    private TvSeries createNaruto(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,calendar.SEPTEMBER,12,0,0,0);
        return new TvSeries(101,"Naruto",720,calendar.getTime());
    }

    private TvSeries createConan(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018,calendar.DECEMBER,20,0,0,0);
        return new TvSeries(102,"Conan",900,calendar.getTime());
    }
}
