import java.time.LocalDateTime;

public class Article{

    private int id;
    private String title;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    public Article(){

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
        return modDate.format(AppContext.formatter);
    }

    public void setId(int id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title= title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setRegDate(LocalDateTime regDate){
        this.regDate = regDate;
    }
    public void setModDate(LocalDateTime modDate){
        this.modDate = modDate;
    }
}


