package seven;
import java.util.Date;

class Post {
    private static int idCounter = 1;
    private final int id;
    private final User author;
    private final String content;
    private int likes;
    private int reposts;
    private final Date creationDate;

    public Post(User author, String content) {
        this.id = idCounter++;
        this.author = author;
        this.content = content;
        this.likes = 0;
        this.reposts = 0;
        this.creationDate = new Date();
    }

    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }

    public int getReposts() {
        return reposts;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void like() {
        likes++;
    }

    public void repost() {
        reposts++;
    }

    @Override
    public String toString() {
        return String.format("Post{id=%d, author=%s, content='%s', likes=%d, reposts=%d, date=%s}",
                id, author.getName(), content, likes, reposts, creationDate);
    }
}