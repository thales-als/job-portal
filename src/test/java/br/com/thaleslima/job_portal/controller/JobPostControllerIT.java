package br.com.thaleslima.job_portal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import br.com.thaleslima.job_portal.domain.dto.JobPostRequestDTO;
import br.com.thaleslima.job_portal.domain.dto.JobPostResponseDTO;
import br.com.thaleslima.job_portal.domain.enumeration.JobCategoryEnum;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JobPostControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;

	private String jwtToken;

	@BeforeAll
	void setup() {
		Map<String, String> signupRequest = Map.of("username", "testuser", "password", "testpassword");

		restTemplate.postForEntity("/api/auth/signup", signupRequest, String.class);

		ResponseEntity<String> signinResponse = restTemplate.postForEntity("/api/auth/signin", signupRequest, String.class);

		assertEquals(HttpStatus.OK, signinResponse.getStatusCode());
		jwtToken = "Bearer " + signinResponse.getBody();
	}

	@Test
	void deveCriarJobPostComTokenJwtValido() {
		JobPostRequestDTO jobRequest = new JobPostRequestDTO();
		jobRequest.setTitle("Desenvolvedor Backend");
		jobRequest.setDescription("Spring Boot, JWT, REST APIs");
		jobRequest.setMonthlySalary(new BigDecimal("9000"));
		jobRequest.setJobCategory(JobCategoryEnum.DESIGN);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", jwtToken);

		HttpEntity<JobPostRequestDTO> entity = new HttpEntity<>(jobRequest, headers);

		ResponseEntity<JobPostResponseDTO> response = restTemplate.postForEntity("/", entity, JobPostResponseDTO.class);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());

		JobPostResponseDTO body = response.getBody();
		assertNotNull(body);
		assertEquals("Desenvolvedor Backend", body.getTitle());
	}
}
