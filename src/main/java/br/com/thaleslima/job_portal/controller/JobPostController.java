package br.com.thaleslima.job_portal.controller;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import br.com.thaleslima.job_portal.domain.entity.JobPost;
import br.com.thaleslima.job_portal.service.JobPostService;

@RestController
@RequiredArgsConstructor
public class JobPostController {

	private final JobPostService jobPostService;

	@PostMapping("/jobs")
	public JobPost createJob(@RequestBody JobPost jobPost) {
		return jobPostService.createJob(jobPost);
	}

	@GetMapping("/jobs")
	public List<JobPost> listAllJobs() {
		return jobPostService.listAllJobs();
	}

	@GetMapping("/jobs/{uuid}")
	public JobPost getJobPostById(@PathVariable("uuid") UUID uuid) {
		return jobPostService.getJobPostById(uuid);
	}

	@DeleteMapping("/jobs/{uuid}")
	public String deleteJobPostById(@PathVariable("uuid") UUID uuid) {
		jobPostService.deleteJobPostById(uuid);

		return "Job ${uuid} has been deleted";
	}
}
