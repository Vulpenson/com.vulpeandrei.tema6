package Controller;

import Model.Specialty;
import Model.Visit;
import Service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("visits")
public class VisitController {

    private final VisitService visitService;

    // Method to get all visits
    @GetMapping("all")
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    // Method to get all visits by cnp
    @GetMapping("cnp/{cnp}")
    public List<Visit> getAllVisitByCnp(@PathVariable String cnp) {
        return visitService.getVisitsByCnp(cnp);
    }

    // Method to get all visits by specialty
    @GetMapping("specialty/{specialty}")
    public List<Visit> getAllVisitsBySpecialty(@PathVariable Specialty specialty) {
        return visitService.getVisitBySpeciality(specialty);
    }

    // Method to add a new visit
    @PostMapping("add")
    public void addVisit(@RequestBody Visit visit) {
        visitService.addVisit(visit);
    }

    // Method to delete a visit by id
    @DeleteMapping("delete/{id}")
    public void deleteVisit(@PathVariable Integer id) {
        visitService.deleteVisit(id);
    }
}
