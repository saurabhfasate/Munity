package com.sprint1.CapGPlus.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.CapGPlus.dto.outer.CommentDTO;
import com.sprint1.CapGPlus.entity.Comment;
import com.sprint1.CapGPlus.exception.UserNotFoundException;
import com.sprint1.CapGPlus.repository.CommentRepository;
import com.sprint1.CapGPlus.repository.PostRepository;
import com.sprint1.CapGPlus.repository.UserRepository;
import com.sprint1.CapGPlus.service.dto.CommentDTOService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private CommentDTOService commentDTOService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<CommentDTO> getAllCommentsByUser(int userId) throws UserNotFoundException {
		if(!userRepository.existsById(userId))
			throw new UserNotFoundException();
		List<Comment> list = commentRepository.getAllCommentsByUser(userId);
		if(list.isEmpty())
			throw new UserNotFoundException();
		return commentRepository.getAllCommentsByUser(userId).stream().map(commentDTOService::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<CommentDTO> getAllCommentsOnAPost(int postId) {
		if(!postRepository.existsById(postId))
			throw new UserNotFoundException();
		List<Comment> list = commentRepository.getAllCommentsByUser(userId);
		if(list.isEmpty())
			throw new UserNotFoundException();
		return commentRepository.getAllCommentsOnAPost(postId).stream().map(commentDTOService::convertToDTO)
				.collect(Collectors.toList());
	}
}
