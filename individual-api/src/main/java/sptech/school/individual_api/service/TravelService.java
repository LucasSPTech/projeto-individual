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
        if (request.getDestination() == null || request.getDestination().isBlank() || request.getDeparture() == null) {
            throw new InvalidRequestException("The fields Destination and Departure Data cannot be empty or null");
        }

        Travels travel = new Travels(request.getDestination(), request.getDeparture(), request.getCompanions(), request.getMemories());
        return travelRepository.save(travel);
    }

    public List<Travels> get() {
        List<Travels> travels = travelRepository.getAllTravels();

        if (travels == null || travels.isEmpty()) { throw new TravelsNotFoundException(); }

        return travels;
    }
}
