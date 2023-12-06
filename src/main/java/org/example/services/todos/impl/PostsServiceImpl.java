package org.example.services.todos.impl;

import org.example.repositories.todos.PostsRepository;
import org.example.services.todos.PostsService;
import org.example.services.posts.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    PostsRepository todosRepository;

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<Post>();
        todosRepository.findAll().iterator().forEachRemaining(posts::add);
        return posts;
    }

    @Override
    public Optional<Post> getPostDetail(Long id) {

        return todosRepository.findById(id);
    }

    @Override
    public Optional<Post> getPostDetailByUsername(String username) {
        return todosRepository.findByUtilisateur(username);
    }

    @Override
    public DeleteAction deletePost(Post post) {

        todosRepository.delete(post);

        return new DeleteAction("Post with id " + post.getId() + " successfully deleted");
    }

    @Override
    public UpdateAction updatePost(Post post) {
        Post updated =  todosRepository.save(post);
        return new UpdateAction("Post with id " + post.getId() + " successfully deleted");
    }

    @Override
    public SaveAction savePost(Post post) {

        Post savedPost = todosRepository.save(post);
        return new SaveAction("Post successfully saved, id: " + post.getId(), post.getId());
    }
}
