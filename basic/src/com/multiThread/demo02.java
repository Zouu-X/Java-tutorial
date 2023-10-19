package com.multiThread;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class demo02 extends Thread {
    private String url;
    private String name;
    public demo02(String url, String name) {
        this.url = url;
        this.name = name;
    }
    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了" + name);
    }

    public static void main(String[] args) {
        demo02 t1 = new demo02("https://img2023.cnblogs.com/blog/80824/202310/80824-20231013101331018-1835119512.png", "pic1.jpg");
        demo02 t2 = new demo02("https://img2023.cnblogs.com/blog/80824/202310/80824-20231019131453499-1730128068.png", "pic2.jpg");
        demo02 t3 = new demo02("https://cdn02.nintendo-europe.com/media/images/08_content_images/games_6/nintendo_switch_7/nswitch_splatoon2/nswitch_splatoon2_news_vers2/NSwitch_Splatoon2_newhair_4.jpg", "pic3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class WebDownloader {
    //下载方法
    public void downloader(String url, String name) {
        try {
            //引入的工具类
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        }

    }
}