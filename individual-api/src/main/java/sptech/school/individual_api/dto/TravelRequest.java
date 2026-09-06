package sptech.school.individual_api.dto;

import java.time.LocalDate;

public class TravelRequest {

    private String destination;
    private LocalDate departure;
    private String companions;
    private String memories;

    public TravelRequest() {
    }

    public TravelRequest(String destination, LocalDate departure, String companions, String memories) {
        this.destination = destination;
        this.departure = departure;
        this.companions = companions;
        this.memories = memories;
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

    public String getMemories() {
        return memories;
    }

    public void setMemories(String memories) {
        this.memories = memories;
    }
}