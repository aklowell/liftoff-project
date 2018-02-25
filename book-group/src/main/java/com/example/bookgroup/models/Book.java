package com.example.bookgroup.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;



@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;
    // private static int nextId = 1;

    @NotNull
    @Size(min = 1, message = "Title cannot be empty.")
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private int pages;
    private Date meetingDate;
    private String recommended;

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }



    //TODO here is the new many to many stuff
    @ManyToMany
    private List<Rating> ratings;
    public List<Rating> getRatings() { return ratings; }
    public void setRatings(List<Rating> ratings) { this.ratings=ratings;}
    public void addItem(Rating item) { ratings.add(item); }

    //public static void findAll() { Book.findAll();}

    //TODO moved to Rating class
    //private double rate;

    private double averageRating;

    public int sum (List<Integer> list) {

        int sum = 0;
        for (int i: list) {
            sum += i;
        }
        return sum;
    }
/*
    public void calcAverage(Book book) {
        List<Rating> rates = new ArrayList<>();
        Book avgBook = new Book();
        rates = avgBook.getRatings();
        //sum (rates);
        int total = 0;
        for(int i = 0; i<rates.size(); i++) {
            total = total + rates.get(i);
        }
        double avg = int total / rates.size();
    }

   //TODO moved to Rating class
    //@ManyToMany
   // @ElementCollection


    public List<Double> getRatings() {
        return ratings;
    }

    public void setRatings(List<Double> ratings) {
        this.ratings = ratings;
    }

    @ManyToMany(mappedBy="ratings")
    private ArrayList<Book> books = new ArrayList<>();

    //private List<Double> ratings = new ArrayList<>();
public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
*/

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }





    private static Book instance;



    @ManyToOne
    private Member members;



    //TODO take out if not working
    public static Book getInstance() {
        if (instance == null) {
            instance = new Book();
        }
        return instance;
    }
        //TODO end




    private BookGenre genre;

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public Book() {
    }

    public Book(String title, String authorFirstName, String authorLastName, int pages, Date meetingDate, List ratings) {
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.pages = pages;
        this.meetingDate = meetingDate;

        this.ratings = ratings;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public int getId() {
        return id;
    }






    public Member getMembers() {
        return members;
    }

    public void setMembers(Member members) {
        this.members = members;
    }






    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating() {
        this.averageRating = averageRating;
    }


    public void add(Book book) {
    }
}