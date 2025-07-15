package com.example.baitapnhom.repository;

import com.example.baitapnhom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

   // API: /api/users/login - tìm user theo username (thường dùng trong xác thực)
    User findByUsername(String username);

    // Có thể thêm nếu bạn muốn kiểm tra username đã tồn tại
    boolean existsByUsername(String username);
}
