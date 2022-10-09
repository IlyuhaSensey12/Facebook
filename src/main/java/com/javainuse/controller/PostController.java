package com.javainuse.controller;

import com.javainuse.dto.PostDto;
import com.javainuse.service.IPostService;
import com.javainuse.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private IPostService iPostService;

    @PostMapping("/addPost")
    public void add(@RequestBody PostDto postDto){
        iPostService.save(postDto);
    }

    @GetMapping("/find/{id}")
    public List<PostDto> findPostsByUserId(@PathVariable long id){
        return iPostService.findPostsByUserId(id);
    }

    @PutMapping("/updatePost")
     public void updatePostByUserId(@RequestBody PostDto postDto){
        iPostService.updatePost(postDto);
    }

    @DeleteMapping("/deletePost/{id}")
    public void deletePost(@PathVariable long id){
        iPostService.deletePost(id);
    }

}
