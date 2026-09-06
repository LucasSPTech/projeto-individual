package sptech.school.individual_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.individual_api.dto.TravelRequest;
import sptech.school.individual_api.model.Travels;
import sptech.school.individual_api.service.TravelService;

import java.util.List;

@RestController
@RequestMapping("/travels")
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @PostMapping()
    public ResponseEntity<Integer> login(@RequestBody TravelRequest request) {
        Integer id = travelService.register(request);
        return ResponseEntity.status(201).body(id);
    }

    @GetMapping()
    public ResponseEntity<List<Travels>> travels() {
        List<Travels> response = travelService.get();
        return ResponseEntity.status(200).body(response);
    }

}