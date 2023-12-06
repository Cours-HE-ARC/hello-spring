package org.example.services.todos;


import org.example.services.posts.Post;
import org.example.services.todos.impl.DeleteAction;
import org.example.services.todos.impl.SaveAction;
import org.example.services.todos.impl.UpdateAction;

import java.util.List;
import java.util.Optional;

public interface PostsService {

    List<Post> getAllPosts();

    Optional<Post> getPostDetail(Long id);

    Optional<Post> getPostDetailByUsername(String username);

    DeleteAction deletePost(Post post);

    UpdateAction updatePost(Post post);

    SaveAction savePost(Post post);
}
