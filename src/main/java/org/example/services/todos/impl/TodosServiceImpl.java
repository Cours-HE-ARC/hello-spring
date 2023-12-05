package org.example.services.todos.impl;

import org.example.repositories.todos.TodosRepository;
import org.example.repositories.todos.impl.DeleteAction;
import org.example.repositories.todos.impl.PostAction;
import org.example.repositories.todos.impl.UpdateAction;
import org.example.services.todos.TodosService;
import org.example.services.posts.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodosServiceImpl implements TodosService {

    @Autowired
    TodosRepository todosRepository;

    @Override
    public List<Post> getAllPosts() {
        return todosRepository.getAllPosts();
    }

    @Override
    public Optional<Post> getPostDetail(String id) {
        return todosRepository.getPostDetail(id);
    }

    @Override
    public DeleteAction deletePost(String id) {
        return todosRepository.deletePost(id);
    }

    @Override
    public UpdateAction updatePost(String id, Post post) {
        return todosRepository.updatePost(id,post);
    }

    @Override
    public PostAction savePost(Post post) {
        return todosRepository.savePost(post);
    }
}
