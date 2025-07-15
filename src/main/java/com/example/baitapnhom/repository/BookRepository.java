package com.example.baitapnhom.repository;

import com.example.baitapnhom.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Có thể bỏ dòng này nếu muốn gọn, vì Spring sẽ tự hiểu
public interface BookRepository extends JpaRepository<Book, Long> {
    // List<Book>createByBooks(String category); //tri nhu moi them. 
    // Tìm theo danh mục
    List<Book> findByCategory(String category);

    // Tìm theo danh mục và sách còn sẵn sàng (available = true)
    List<Book> findByCategoryAndAvailableTrue(String category);
}
