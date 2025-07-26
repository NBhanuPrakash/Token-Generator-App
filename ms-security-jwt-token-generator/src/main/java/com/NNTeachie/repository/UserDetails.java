package com.NNTeachie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetails extends JpaRepository<com.NNTeachie.model.UserDetails,Integer> {
    com.NNTeachie.model.UserDetails findByUserName(String username);
}
