package com.jamel.pi.repositories;

import com.jamel.pi.entities.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Override
    Comment getById(Long aLong);

    @Override
            @Transactional
    <S extends Comment> S save(S entity);

    @Override
    Optional<Comment> findById(Long aLong);

    @Override
    long count();

    List<Comment> findByPost_Id(Long id);
}
