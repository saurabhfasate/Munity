package com.sprint1.CapGPlus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint1.CapGPlus.dto.outer.UserDTO;
import com.sprint1.CapGPlus.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT e FROM User e WHERE e.userName = :name")
	public User findByUserName(@Param("name") String userName);

	@Query(value = "SELECT * FROM users WHERE id IN (SELECT user_id FROM user_following WHERE following_id = :userId)", nativeQuery = true)
	public List<User> getFollowers(@Param("userId") int userId);
}