package com.javainuse.repository;

import com.javainuse.dto.PostDto;
import com.javainuse.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findPostEntitiesByUserEntityId(long id);

    PostEntity findPostEntityById(long id);
}
