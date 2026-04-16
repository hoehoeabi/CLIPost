package com.gg;

import com.gg.domain.article.ArticleController;
import com.gg.domain.article.ArticleRepository;
import com.gg.domain.article.ArticleService;
import com.gg.domain.system.SystemController;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AppContext {
    public static final Scanner sc;
    public static final ArticleRepository articleRepository;
    public static final ArticleService articleService;
    public static final ArticleController articleController;
    public static final SystemController systemController;
    public static final DateTimeFormatter forPrintDateTimeFormatter ;


    static {
        sc = new Scanner(System.in);
        articleRepository = new ArticleRepository();
        articleService = new ArticleService();
        articleController = new ArticleController();
        systemController = new SystemController();
        forPrintDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }







}

