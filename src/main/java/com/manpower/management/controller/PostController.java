package com.manpower.management.controller;

import com.manpower.management.entity.PostEntity;
import com.manpower.management.repository.PostRepository;
import com.manpower.management.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
//@CrossOrigin("*")
public class PostController {
    @Autowired
    PostRepository postRepository;

    // Aggregate root
    // tag::get-aggregate-root[]
//    @GetMapping("/posts")
//    List<PostEntity> all() {
//        return postRepository.findAll();
//    }
//    // end::get-aggregate-root[]

    @PostMapping("/admission/posts")
    PostEntity newPost(@RequestBody PostEntity newTrainee) {
      System.out.println("test Hit");

      return postRepository.save(newTrainee);
    }


  @GetMapping("/admission/posts")
  List<PostEntity> getAll() {
    System.out.println("test Hit");

    return postRepository.findAll();
  }
    // Single item

    @GetMapping("/admission/posts/{id}")
    PostEntity one(@PathVariable Long id) {
        Optional<PostEntity> postEntity =  postRepository.findById(id);
        return postEntity.get();
    }

    @PutMapping("/admission/posts/{id}")
    PostEntity replaceEmployee(@RequestBody PostEntity postEntity, @PathVariable Long id) {

        return postRepository.findById(id)
                .map(post -> {
                    post.setName(postEntity.getName());
                    post.setFathername(postEntity.getFathername());
                    post.setMothername(postEntity.getMothername());
                    post.setDob(postEntity.getDob());
                    post.setPassport(postEntity.getPassport());
                    post.setNid(postEntity.getNid());
                    post.setEmail(postEntity.getEmail());
                    return postRepository.save(post);
                })
                .orElseGet(() -> {
                    postEntity.setId(id);
                    return postRepository.save(postEntity);
                });
    }

    @DeleteMapping("/admission/posts/{id}")
    void deleteTrainee(@PathVariable Long id) {
        postRepository.deleteById(id);
    }
}
