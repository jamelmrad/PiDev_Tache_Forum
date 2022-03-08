package com.jamel.pi.repositories;

import com.jamel.pi.dto.PostDto;
import com.jamel.pi.entities.Post;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Override
    Post getById(Long aLong);

    @Override
    void deleteAll(Iterable<? extends Post> entities);

    List<Post> findByEmployee_Id(Long id);

    //List<Post> findAllByEmployee_Id(Sort sort);

    @Override
    Optional<Post> findById(Long aLong);

    @Override
    List<Post> findAll();

    @Override
    long count();

    @Override
    <S extends Post> S save(S entity);

}
