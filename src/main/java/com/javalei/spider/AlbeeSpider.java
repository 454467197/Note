package com.javalei.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;
import us.codecraft.webmagic.scheduler.RedisScheduler;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AlbeeSpider  implements  PageProcessor {

    private Site site = Site.me().setDomain("www.e-cology.com.cn");
    @Override
    public void process(Page page) {
        System.out.println();
        String script=page.getHtml().$("script").all().get(21);
        script=script.substring(script.indexOf("ecologylogin:"));
        System.out.println(script.substring(0,script.indexOf("\"")));

        //http://www.e-cology.com.cn/mobile/plugin/login/QCLoginStatus.jsp?isie=false&langid=7&loginkey=24354ce5-2645-4748-850d-c7e56bee339d


        //System.out.println(page.getHtml().xpath("//div[@id='lg']").toString());
       // System.out.println(page.getJson().$("#qrcodeImg"));

  //JSESSIONID=cabvSAZDc1oHCcke7Vtaw
    }

    @Override
    public Site getSite() {
        return site;
    }


    public static void main(String[] args) {


        System.out.println(  UUID.randomUUID().toString());
        Spider.create(new AlbeeSpider())
                //从https://github.com/code4craft开始抓
                .addUrl("http://www.e-cology.com.cn")
                //.addUrl("http://www.baidu.com/")
                //设置Scheduler，使用Redis来管理URL队列
                //.setScheduler(new RedisScheduler("localhost"))
                //设置Pipeline，将结果以json方式保存到文件
                .addPipeline(new JsonFilePipeline("c:\\data\\wget"))
                //开启5个线程同时执行
                .thread(1);
                //启动爬虫


    }
}
