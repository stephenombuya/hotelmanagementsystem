package librarymanagementsystem;

import java.util.*;
import java.util.stream.Collectors;

public class Book {
    private String title;
    private String author;
    private static String genre;
    private int publicationYear;
    

    public Book(String title, String author,String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear ;

    }

	public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

     public String toString() {
	return "\nTitle: " + title +
			"\nAuthor: " + author +
			"\nGenre: " + genre +
			"\nPublication Year: " + publicationYear;
     }
		
	}

    


 
