package mk.ukim.finki.emt.biblioteka.models.dto;

public class BookDto {
    public String name;
    public Long author;
    public String category;
    public Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Long author, String category, Integer availableCopies) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.availableCopies = availableCopies;
    }
}
