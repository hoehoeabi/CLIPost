import java.time.LocalDateTime;

public class Article{

    private int id;
    private String title;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    public Article(int id, String title, String content, LocalDateTime regDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.modDate = null;
    }

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public String getRegDate(){
        return regDate.format(AppContext.formatter);
    };
    public String getModDate(){
        return modDate == null ? "" : modDate.format(AppContext.formatter);
    }

    public void setTitle(String title){
        this.title= title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setModDate(LocalDateTime modDate){
        this.modDate = modDate;
    }
}


