package br.com.thaleslima.job_portal.domain.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import br.com.thaleslima.job_portal.domain.enumeration.JobCategoryEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostRequestDTO {

	@NotNull
	private String title;

	private String description;

	@NotNull
	@Positive
	private BigDecimal monthlySalary;

	private JobCategoryEnum jobCategory;
}
