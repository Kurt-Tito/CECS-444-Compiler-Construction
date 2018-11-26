
public class Grammar {


    private int id;
    private String keyword;

    public Grammar(int id, String keyword)
    {
        this.id = id;
        this.keyword = keyword;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
