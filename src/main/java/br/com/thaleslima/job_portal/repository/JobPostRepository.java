package br.com.thaleslima.job_portal.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.thaleslima.job_portal.domain.entity.JobPost;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, UUID> {}
