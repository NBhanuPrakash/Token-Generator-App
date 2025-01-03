package com.NNTeachie.repository;

import com.NNTeachie.model.UsersTokens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersTokens,Long> {
    UsersTokens findByUsername(String username);
}
