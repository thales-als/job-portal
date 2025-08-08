package br.com.thaleslima.job_portal.controller;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.thaleslima.job_portal.domain.dto.JobPostRequestDTO;
import br.com.thaleslima.job_portal.domain.dto.JobPostResponseDTO;
import br.com.thaleslima.job_portal.service.JobPostService;

@RestController
@RequiredArgsConstructor
public class JobPostController {

	private final JobPostService service;

	@PostMapping
	public ResponseEntity<JobPostResponseDTO> createJob(@RequestBody @Valid JobPostRequestDTO dto) {
		JobPostResponseDTO criado = service.createJob(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(criado);
	}

	@GetMapping
	public List<JobPostResponseDTO> listAllJobs() {
		return service.listAllJobs();
	}

	@GetMapping("/{id}")
	public JobPostResponseDTO getJobPostById(@PathVariable UUID id) {
		return service.getJobPostById(id);
	}

	@PutMapping("/{id}")
	public JobPostResponseDTO updateJobPost(@PathVariable UUID id, @RequestBody @Valid JobPostRequestDTO dto) {
		return service.updateJobPost(id, dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteJobPostById(@PathVariable UUID id) {
		service.deleteJobPostById(id);
		return ResponseEntity.noContent().build();
	}
}
