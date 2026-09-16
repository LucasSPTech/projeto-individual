package sptech.school.individual_api.model;

import java.time.LocalDate;

public class Travels {
    private Integer id;
    private String destination;
    private LocalDate departure;
    private String companions;
    private Integer review;
    private String memories;

    public Travels() {
    }

    public Travels(String destination, LocalDate departure, String companions, Integer review, String memories) {
        this.destination = destination;
        this.departure = departure;
        this.companions = companions;
        this.review = review;
        this.memories = memories;
    }

    public Travels(Integer id, String destination, LocalDate departure, String companions, Integer review, String memories) {
        this.id = id;
        this.destination = destination;
        this.departure = departure;
        this.companions = companions;
        this.review = review;
        this.memories = memories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public String getCompanions() {
        return companions;
    }

    public void setCompanions(String companions) {
        this.companions = companions;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public String getMemories() {
        return memories;
    }

    public void setMemories(String memories) {
        this.memories = memories;
    }
}