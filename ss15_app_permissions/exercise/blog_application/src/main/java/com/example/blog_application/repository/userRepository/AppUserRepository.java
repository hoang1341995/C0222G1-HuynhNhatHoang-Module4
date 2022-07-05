package com.example.blog_application.repository.userRepository;

import com.example.blog_application.model.userModel.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}
