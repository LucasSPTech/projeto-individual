package sptech.school.individual_api.service;

import org.springframework.stereotype.Service;
import sptech.school.individual_api.dto.TravelRequest;
import sptech.school.individual_api.exception.InvalidRequestException;
import sptech.school.individual_api.exception.TravelsNotFoundException;
import sptech.school.individual_api.model.Travels;
import sptech.school.individual_api.repository.TravelRepository;

import java.util.List;

@Service
public class TravelService {

    private final TravelRepository travelRepository;

    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public Integer register(TravelRequest request) {
        if (request.getDestination() == null || request.getDestination().isBlank() || request.getDeparture() == null ||
                (request.getReview() != null && (request.getReview() < 0 || request.getReview() > 5))) {

            throw new InvalidRequestException("Destination and Departure Date cannot be empty or null, and Review must be between 0 and 5");
        }

        Travels travel = new Travels(request.getDestination(), request.getDeparture(), request.getCompanions(), request.getReview(), request.getMemories());
        return travelRepository.save(travel);
    }

    public List<Travels> get() {
        List<Travels> travels = travelRepository.getAllTravels();

        if (travels == null || travels.isEmpty()) { throw new TravelsNotFoundException(); }

        return travels;
    }
}
