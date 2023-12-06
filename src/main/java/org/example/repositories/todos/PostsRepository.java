package org.example.repositories.todos;


import org.example.services.posts.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface PostsRepository extends CrudRepository<Post,Long> {

    Optional<Post> findByUtilisateur(String utilisateur);

   /* List<Post> getAllPosts();

    Optional<Post> getPostDetail(String id);

    DeleteAction deletePost(String id);

    UpdateAction updatePost(String id, Post post);

    PostAction savePost(Post post);*/
}
