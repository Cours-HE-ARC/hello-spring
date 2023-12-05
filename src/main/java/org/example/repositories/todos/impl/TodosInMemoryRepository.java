package org.example.repositories.todos.impl;

import org.example.repositories.todos.TodosRepository;
import org.example.services.posts.Post;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TodosInMemoryRepository implements TodosRepository {

    Map<Integer, Post> postDB = new HashMap<>();

    @Override
    public List<Post> getAllPosts(){

        return new ArrayList<>(postDB.values());
    }

    @Override
    public Optional<Post> getPostDetail(String id){

        if(postDB.containsKey(id)){
            return Optional.of(postDB.get(Integer.parseInt(id)));
        }else {
            return Optional.empty();
        }
    }

    @Override
    public DeleteAction deletePost(String id){

        DeleteAction deleteAction;

        //Si la cle existe
        if(postDB.containsKey(Integer.valueOf(id))){
            postDB.remove(Integer.valueOf(id));
            deleteAction = new DeleteAction(Boolean.TRUE, "Post successfully deleted");
        }else{
            deleteAction = new DeleteAction(Boolean.FALSE, "Post not deleted, id not present");
        }

        return deleteAction;
    }

    @Override
    public UpdateAction updatePost(String id, Post post){

        UpdateAction updateAction;

        //Si la cle existe
        if(postDB.containsKey(Integer.valueOf(id))){
            postDB.put(Integer.valueOf(id),post);
            updateAction = new UpdateAction(Boolean.TRUE,"Post updated");

        }else{
            updateAction = new UpdateAction(Boolean.FALSE,"Post not updated, id doesn't exist");

        }

        return updateAction;
    }

    @Override
    public PostAction savePost(Post post){
        post.setDate(new Date());
        Integer id = getNextId();
        postDB.put(getNextId(),post);

        return new PostAction(post, String.valueOf(id));
    }

    private Integer getNextId(){

        return postDB.values().size();
    }
}
