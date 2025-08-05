package br.com.thaleslima.job_portal.service;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.thaleslima.job_portal.domain.entity.JobPost;
import br.com.thaleslima.job_portal.repository.JobPostRepository;

@Service
@RequiredArgsConstructor
public class JobPostService {

	private final JobPostRepository jobPostRepository;

	public JobPost createJob(JobPost jobPost) {
		return jobPostRepository.save(jobPost);
	}

	public List<JobPost> listAllJobs() {
		return jobPostRepository.findAll();
	}

	public JobPost getJobPostById(UUID uuid) {
		return jobPostRepository.findById(uuid).orElse(null);
	}

	public JobPost updateJobPost(UUID uuid, @RequestBody JobPost jobPost) {
		return jobPostRepository.save(jobPost);
	}

	public void deleteJobPostById(UUID uuid) {
		jobPostRepository.deleteById(uuid);
	}
}
