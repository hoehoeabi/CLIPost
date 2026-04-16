package com.Article;

import com.AppContext;

import java.util.List;
import java.util.Scanner;

public class ArticleController {
    Scanner scanner = AppContext.scanner;
    List<Article> articleList = AppContext.articleList;
    ArticleService articleService = AppContext.articleService;

    public void writeArticle(){
        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();
        articleService.write(title, content);
        System.out.println("게시글이 등록되었습니다.\n");
    }

    public void listArticles(){
        System.out.printf(" %s | %s | %s | %s\n", "번호", "제목", "등록일", "수정일");
        System.out.println("--------------------------------");
        for(Article article : articleList.reversed()){
            System.out.printf(" %d | %s | %s | %s\n", article.getId(), article.getTitle(), article.getRegDate(), article.getModDate());
        }
        System.out.println();
    }

    public void showDetail(int id){
        Article article = checkId(id);
        if(article == null)
            return;
        System.out.println("번호: " + article.getId());
        System.out.println("제목: " + article.getTitle());
        System.out.println("내용: " + article.getContent());
        System.out.println("등록일: " + article.getRegDate());
        if(!article.getModDate().isEmpty()){
            System.out.println("수정일: " + article.getModDate());
        }
        System.out.println();
    }

    public void updateArticle(int id){
        Article article = checkId(id);
        if(article == null)
            return;
        System.out.println("제목(기존): " + article.getTitle());
        System.out.print("제목: ");
        String newTitle = scanner.nextLine();
        System.out.println("내용(기존): " + article.getContent());
        System.out.print("내용: ");
        String newContent = scanner.nextLine();
        articleService.update(article, newTitle, newContent);
        System.out.println(id + "번 게시글이 수정되었습니다.\n");
    }

    public void deleteArticle(int id){
        Article article = checkId(id);
        if(article == null)
            return;
        articleService.delete(article);
        System.out.println(id + "번 게시글이 삭제되었습니다.\n");
    }

    public Article checkId(int id){
        return articleService.checkId(id);
    }

    public void showCommands(){
        System.out.println("등록: write");
        System.out.println("목록: list");
        System.out.println("상세보기: detail [id]");
        System.out.println("수정: update [id]");
        System.out.println("삭제: delete [id]");
        System.out.println("도움: help");
        System.out.println("종료: exit\n");
    }
}
