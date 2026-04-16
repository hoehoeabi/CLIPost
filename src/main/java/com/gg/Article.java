package com.gg;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Article {
    int id;
    String title;
    String content;
    LocalDateTime regDate;

    public Article(int id, String title, String content, LocalDateTime regDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
    }

    public String getRegDateFormatted(){
        return regDate.format(AppContext.forPrintDateTimeFormatter);
    }
}