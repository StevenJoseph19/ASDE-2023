package com.acme.books.repository;

import com.acme.books.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, CrudRepository<Review, Long> {
    List<Review> findByBookIdAndUserId(Long bookId, Long userId);

    Page<Review> findAllByBookId(Long id, Pageable pageable);

    @Query("SELECT AVG(rating) FROM Review WHERE book.id=?1")
    Double getRatingBookId(Long id);
}
