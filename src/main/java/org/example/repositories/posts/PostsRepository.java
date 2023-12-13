package org.example.repositories.posts;


import org.example.services.posts.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface PostsRepository extends CrudRepository<PostEntity,Long> {

   // Optional<PostEntity> findByUtilisateurUsername(String utilisateur);

   /* List<Post> getAllPosts();

    Optional<Post> getPostDetail(String id);

    DeleteAction deletePost(String id);

    UpdateAction updatePost(String id, Post post);

    PostAction savePost(Post post);*/
}
