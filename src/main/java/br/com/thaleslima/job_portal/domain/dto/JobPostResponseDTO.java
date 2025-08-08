package br.com.thaleslima.job_portal.domain.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import br.com.thaleslima.job_portal.domain.enumeration.JobCategoryEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostResponseDTO {

	private UUID id;

	private String title;

	private String description;

	private BigDecimal monthlySalary;

	private JobCategoryEnum jobCategory;
}
