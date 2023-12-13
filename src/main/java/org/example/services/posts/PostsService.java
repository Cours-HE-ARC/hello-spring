package org.example.services.posts;


import org.example.services.posts.impl.DeleteResult;
import org.example.services.posts.impl.SavePostAction;
import org.example.services.posts.impl.UpdateResult;

import java.util.List;
import java.util.Optional;

public interface PostsService {

    List<Post> getAllPosts();

    Optional<Post> getPostDetail(Long id);


    DeleteResult deletePost(String id);

    UpdateResult updatePost(Long id, Post post);

    SavePostAction savePost(Post post, String userId);
}
