package com.charan.recruitmentportal.controller;

import com.charan.recruitmentportal.entity.Candidate;
import com.charan.recruitmentportal.repository.CandidateRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import com.charan.recruitmentportal.exception.ResourceNotFoundException;




@RestController
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateRepository candidateRepository;

    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @PostMapping
    public Candidate createCandidate(@Valid @RequestBody Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @PutMapping("/{id}")
    public Candidate updateCandidate(
            @PathVariable Long id,
            @RequestBody @Valid Candidate updatedCandidate) {

        Candidate existingCandidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Candidate not found with id " + id
                ));


        existingCandidate.setName(updatedCandidate.getName());
        existingCandidate.setEmail(updatedCandidate.getEmail());

        return candidateRepository.save(existingCandidate);
    }



    @GetMapping
    public Page<Candidate> getAllCandidates(
            @PageableDefault(size = 5, sort = "id") Pageable pageable
    ) {
        return candidateRepository.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        candidateRepository.deleteById(id);
    }



}
