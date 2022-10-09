package com.javainuse.service;

import com.javainuse.dto.PostDto;

import java.util.List;

public interface IPostService {
   void save(PostDto postDto);

   List<PostDto> findPostsByUserId(long id);

   PostDto findPostById(long id);
   void updatePost(PostDto postDto);

   void deletePost(long id);
}
