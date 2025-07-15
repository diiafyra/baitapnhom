package com.example.baitapnhom.repository;

import com.example.baitapnhom.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    // API: /api/borrow/user/{userId}
    List<Borrow> findByUser_Username(String userId); // nếu User có id là username
}
