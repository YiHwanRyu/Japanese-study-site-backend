package com.studynippon.api.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostCreate {

	@NotEmpty(message = "글 작성시 제목은 필수입력입니다.")
	private String title;

	@NotEmpty(message = "글 작성시 내용은 필수입력입니다.")
	private String content;

}
