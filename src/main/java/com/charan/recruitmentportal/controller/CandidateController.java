package com.charan.recruitmentportal.controller;

import com.charan.recruitmentportal.entity.Candidate;
import com.charan.recruitmentportal.repository.CandidateRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateRepository candidateRepository;

    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @PostMapping
    public Candidate create(@RequestBody Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        candidateRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Candidate updateCandidate(
            @PathVariable Long id,
            @RequestBody Candidate updatedCandidate) {

        return candidateRepository.findById(id)
                .map(candidate -> {
                    candidate.setName(updatedCandidate.getName());
                    candidate.setEmail(updatedCandidate.getEmail());
                    return candidateRepository.save(candidate);
                })
                .orElseThrow(() -> new RuntimeException("Candidate not found with id " + id));
    }



}
