package br.com.thaleslima.job_portal.domain.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.thaleslima.job_portal.domain.dto.JobPostRequestDTO;
import br.com.thaleslima.job_portal.domain.dto.JobPostResponseDTO;
import br.com.thaleslima.job_portal.domain.entity.JobPost;

@Mapper(componentModel = "spring")
public interface JobPostMapper {

	JobPost toEntity(JobPostRequestDTO dto);

	JobPostResponseDTO toDTO(JobPost entity);

	List<JobPostResponseDTO> toDTOList(List<JobPost> entities);
}
