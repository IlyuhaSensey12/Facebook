package com.javainuse.service;

import com.javainuse.dto.PostDto;
import com.javainuse.dto.UserDto;
import com.javainuse.model.PostEntity;
import com.javainuse.model.UserEntity;
import com.javainuse.repository.PostRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
   @Autowired
   private PostRepository postRepository;

   public PostDto mapToPostDto(PostEntity postEntity){
      PostDto postDto = new PostDto();
      postDto.setId(postEntity.getId());
      postDto.setTitle(postEntity.getTitle());
      postDto.setDescription(postEntity.getDescription());
      postDto.setUserId(postEntity.getUserEntity().getId());
      return postDto;
   }
   public void save(PostDto postDto){
      PostEntity postEntity = new PostEntity();
      postEntity.setTitle(postDto.getTitle());
      postEntity.setDescription(postDto.getDescription());

      UserEntity user = new UserEntity();
      user.setId(postDto.getUserId());
      postEntity.setUserEntity(user);
      postRepository.save(postEntity);
   }

   @Override
   public List<PostDto> findPostsByUserId(long id) {
      List<PostEntity> postEntities = postRepository.findPostEntitiesByUserEntityId(id);
      return postEntities.stream()
              .map(this::mapToPostDto)
              .collect(Collectors.toList());
   }

   @Override
   public PostDto findPostById(long id) {
      PostEntity postEntity = postRepository.findPostEntityById(id);
      return mapToPostDto(postEntity);
   }

   public void updatePost(PostDto postDto){
      PostEntity postEntity = postRepository.findPostEntityById(postDto.getId());
      postEntity.setTitle(postDto.getTitle());
      postEntity.setDescription(postDto.getDescription());
      postRepository.save(postEntity);
   }

   public void deletePost(long id){
      PostEntity postEntity = postRepository.findPostEntityById(id);
      postRepository.delete(postEntity);
   }


}
