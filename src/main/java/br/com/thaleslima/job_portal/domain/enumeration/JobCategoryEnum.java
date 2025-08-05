package br.com.thaleslima.job_portal.domain.enumeration;

import lombok.Getter;

@Getter
public enum JobCategoryEnum {

	TECHNOLOGY((short) 1, "Technology Jobs"),
	DESIGN((short) 2, "Design Jobs"),
	HUMAN_RESOURCES((short) 3, "HR Jobs");

	private Short index;

	private String description;

	JobCategoryEnum(Short index, String description) {
		this.index = index;
		this.description = description;
	}
}
