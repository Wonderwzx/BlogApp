package com.wonder.blog.service;

import com.wonder.blog.po.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> listCommentByBLogId(Long blogId);

    Comment saveComment(Comment comment);
}
