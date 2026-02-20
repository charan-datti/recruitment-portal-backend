package com.charan.recruitmentportal.repository;

import com.charan.recruitmentportal.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
