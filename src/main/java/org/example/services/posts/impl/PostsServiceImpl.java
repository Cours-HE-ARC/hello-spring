package org.example.services.posts.impl;

import org.example.repositories.posts.PostEntity;
import org.example.repositories.posts.PostsRepository;
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
        postsRepository.findAll().iterator().forEachRemaining(postEntity -> {
            posts.add(Post.fromEntity(postEntity));
        });
        return posts;
    }

    @Override
    public Optional<Post> getPostDetail(Long id) {

        if(postsRepository.existsById(id)){
            return Optional.of(
                    Post.fromEntity(postsRepository.findById(id).get())
            );
        }else{
            return Optional.empty();
        }


    }

    @Override
    public Optional<Post> getPostDetailByUsername(String username) {
        Optional<PostEntity> postEntity = postsRepository.findByUtilisateur(username);

        return postEntity.map(Post::fromEntity);

    }

    @Override
    public DeleteResult deletePost(String id) {

        Optional<PostEntity> postEntity = postsRepository.findById(Long.valueOf(id));
        DeleteResult result;

        if(postEntity.isPresent()){
            postsRepository.delete(postEntity.get());
            result = new DeleteResult("Post with id " + postEntity.get().getId() + " successfully deleted");
        }else{
            result = new DeleteResult("Post with id " + id + " doesn't exist");
        }

        return result;
    }

    @Override
    public UpdateResult updatePost(Long id, Post post) {
        Optional<PostEntity> toUpdate = postsRepository.findById(id);
        UpdateResult result;

        if(toUpdate.isPresent()){

            PostEntity entity = toUpdate.get();
            entity.setDate(post.getDate());
            entity.setContent(post.getContent());
            entity.setUtilisateur(entity.getUtilisateur());
            postsRepository.save(entity);
            result = new UpdateResult("Post with id " + id + " successfully updated");
        }else{
            result =  new UpdateResult("Post with id " + id + " doesn't exist");
        }

        return result;
    }

    @Override
    public SaveAction savePost(Post post) {
        PostEntity postEntity = Post.toEntity(post);
        postEntity = postsRepository.save(postEntity);
        return new SaveAction(
                "Post successfully saved, id: " + postEntity.getId(),
                Post.fromEntity(postEntity),
                postEntity.getId());
    }
}
