package org.example.services.posts;


import org.example.services.posts.impl.DeleteAction;
import org.example.services.posts.impl.SaveAction;
import org.example.services.posts.impl.UpdateAction;

import java.util.List;
import java.util.Optional;

public interface PostsService {

    List<Post> getAllPosts();

    Optional<Post> getPostDetail(Long id);

    Optional<Post> getPostDetailByUsername(String username);

    DeleteAction deletePost(Post post);

    UpdateAction updatePost(Long id,Post post);

    SaveAction savePost(Post post);
}
