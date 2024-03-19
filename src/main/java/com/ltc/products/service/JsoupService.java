package com.ltc.products.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsoupService {
    @Scheduled(fixedRate = 100000)
    public void getData() throws IOException {

        Document doc_1 = Jsoup.connect("https://aniwatchtv.to/home").get();
        Document document = Jsoup.connect("https://aniwatchtv.to/movie").get();
        Elements allElements = document.getAllElements();
        Elements names = document.getElementsByClass("film-name");

        for (Element name : names) {
            System.out.println("~~~~~~~~~~~~~~~");
            System.out.println(name.text());
            System.out.println("~~~~~~~~~~~~~~~");
        }
//       System.out.println(names);

    }
}
