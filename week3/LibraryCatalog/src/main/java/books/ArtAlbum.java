package main.java.books;

public class ArtAlbum extends Book {
    private String paperQuality;

    public ArtAlbum(String name, int numberOfPages, String paperQuality) {
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }

    public String getPaperQuality() {
        return this.paperQuality;
    }

    public void setPaperQuality(String paperQuality) {
        this.paperQuality = paperQuality;
    }

    public String toString() {
        return "{name: " + this.getName() + ", type: art album}";
    }
}
