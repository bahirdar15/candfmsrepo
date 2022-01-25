package com.candfms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.candfms.models.Post;
import com.candfms.models.Role;
import com.candfms.models.User;

public interface PostRepository extends JpaRepository<Post, Integer> {
	@Query("select u from Post u ORDER BY id DESC")
	public List<Post> findAllPost1();

}
