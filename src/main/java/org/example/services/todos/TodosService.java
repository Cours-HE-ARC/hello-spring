package org.example.services.todos;

import org.example.repositories.todos.impl.DeleteAction;
import org.example.repositories.todos.impl.PostAction;
import org.example.repositories.todos.impl.UpdateAction;
import org.example.services.posts.Post;

import java.util.List;
import java.util.Optional;

public interface TodosService {

    List<Post> getAllPosts();

    Optional<Post> getPostDetail(String id);

    DeleteAction deletePost(String id);

    UpdateAction updatePost(String id, Post post);

    PostAction savePost(Post post);
}
