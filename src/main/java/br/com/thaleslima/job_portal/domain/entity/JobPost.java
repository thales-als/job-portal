package br.com.thaleslima.job_portal.domain.entity;

import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import br.com.thaleslima.job_portal.domain.enumeration.JobCategoryEnum;

@Entity
@Table(name = "TB_JOB_POSTS")
@Getter
@Setter
public class JobPost {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@NotNull
	private String title;

	private String description;

	@NotNull
	private Double monthlySalary;

	private JobCategoryEnum jobCategory;
}