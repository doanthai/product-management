package com.product.management.productmanagement.repository;


import com.product.management.productmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    int countByEmail(String email);
    int countByUsername(String username);
}
