package com.technix.bbplus.repository;
import com.technix.bbplus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

List<User> findBycustomerId(int CustomerId);






}
