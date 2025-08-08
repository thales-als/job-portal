package br.com.thaleslima.job_portal.service;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import br.com.thaleslima.job_portal.domain.dto.JobPostRequestDTO;
import br.com.thaleslima.job_portal.domain.dto.JobPostResponseDTO;
import br.com.thaleslima.job_portal.domain.entity.JobPost;
import br.com.thaleslima.job_portal.domain.mapper.JobPostMapper;
import br.com.thaleslima.job_portal.repository.JobPostRepository;

@Service
@RequiredArgsConstructor
public class JobPostService {

	private final JobPostRepository repository;

	private final JobPostMapper mapper;

	public JobPostResponseDTO createJob(JobPostRequestDTO dto) {
		JobPost jobPost = mapper.toEntity(dto);
		JobPost savedJobPost = repository.save(jobPost);
		return mapper.toDTO(savedJobPost);
	}

	public List<JobPostResponseDTO> listAllJobs() {
		return mapper.toDTOList(repository.findAll());
	}

	public JobPostResponseDTO getJobPostById(UUID uuid) {
		JobPost jobPost = repository.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return mapper.toDTO(jobPost);
	}

	public JobPostResponseDTO updateJobPost(UUID uuid, @RequestBody JobPostRequestDTO dto) {
		JobPost currentJobPost = repository.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		currentJobPost.setTitle(dto.getTitle());
		currentJobPost.setDescription(dto.getDescription());
		currentJobPost.setMonthlySalary(dto.getMonthlySalary());
		currentJobPost.setJobCategory(dto.getJobCategory());

		JobPost updatedJobPost = repository.save(currentJobPost);
		return mapper.toDTO(updatedJobPost);
	}

	public void deleteJobPostById(UUID uuid) {
		repository.deleteById(uuid);
	}
}
