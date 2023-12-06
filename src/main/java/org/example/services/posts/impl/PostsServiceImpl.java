package org.example.services.posts.impl;

import org.example.repositories.todos.PostsRepository;
import org.example.services.posts.PostsService;
import org.example.services.posts.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    PostsRepository postsRepository;

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<Post>();
        postsRepository.findAll().iterator().forEachRemaining(posts::add);
        return posts;
    }

    @Override
    public Optional<Post> getPostDetail(Long id) {

        return postsRepository.findById(id);
    }

    @Override
    public Optional<Post> getPostDetailByUsername(String username) {
        return postsRepository.findByUtilisateur(username);
    }

    @Override
    public DeleteAction deletePost(Post post) {

        postsRepository.delete(post);

        return new DeleteAction("Post with id " + post.getId() + " successfully deleted");
    }

    @Override
    public UpdateAction updatePost(Long id,Post post) {
        Post toUpdate = postsRepository.findById(id).get();
        post.setId(toUpdate.getId());
        Post updated =  postsRepository.save(post);
        return new UpdateAction("Post with id " + updated.getId() + " successfully deleted");
    }

    @Override
    public SaveAction savePost(Post post) {

        Post savedPost = postsRepository.save(post);
        return new SaveAction("Post successfully saved, id: " + post.getId(), post.getId());
    }
}
