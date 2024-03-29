package com.studynippon.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studynippon.api.dto.request.PostCreate;
import com.studynippon.api.dto.request.PostEdit;
import com.studynippon.api.dto.request.PostSearch;
import com.studynippon.api.dto.response.PageResponse;
import com.studynippon.api.dto.response.PostDetail;
import com.studynippon.api.service.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	/**
	 * 게시글 작성
	 */
	@PostMapping("/api/v1/posts")
	public ResponseEntity<Void> writePost(@RequestBody @Valid PostCreate postCreate) {
		return postService.writePost(postCreate);
	}

	/**
	 * 게시글 단일 조회
	 */
	@GetMapping("/api/v1/posts/{postId}")
	public ResponseEntity<PostDetail> getPost(@PathVariable Long postId) {
		return postService.getPost(postId);
	}

	/**
	 * 게시글 리스트 조회
	 */
	@GetMapping("/api/v1/posts")
	public ResponseEntity<PageResponse> getPostList(@RequestBody @Valid PostSearch postSearch) {
		return postService.getPostList(postSearch);
	}

	/**
	 * 게시글 삭제
	 */
	@DeleteMapping("/api/v1/posts/{postId}")
	public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
		return postService.deletePost(postId);
	}

	/**
	 * 게시글 수정
	 */
	@PutMapping("/api/v1/posts/{postId}")
	public ResponseEntity<Void> editPost(@PathVariable Long postId, @RequestBody @Valid PostEdit postEdit) {
		return postService.editPost(postId, postEdit);
	}
}
