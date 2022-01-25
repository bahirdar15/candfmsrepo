package com.candfms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Coursout;
import com.candfms.models.User;

public interface UserRepositories extends JpaRepository<User,Integer>{
	
	
	@Query("select u from User u where u.uname=:uname and u.enabled = true")
	public User getUserByUserName(@Param("uname") String uname);
	
	@Query("select u from User u where u.imageUrl=:imageUrl and u.enabled = true")
	public List<User> getUserByImageUrl(@Param("imageUrl") String imageUrl);
	
	//@Query("select u from User u where u.role=:role and u.enabled = true")
	//public List<User> getUserByRole(@Param("role") String role);
	
	@Query("select u from User u where u.id=:id and u.enabled = true")
	public List<User> getUserByApproveId(@Param("id") int id);
	
	
	@Query("select  coalesce(max(id), 0) from User")
	 public Integer getMaxId();
	
	@Query("select u from User u where u.id=:id and u.enabled = true")
	public User getUserByapproIdSingle(@Param("id") int id);
	
	@Query("SELECT u FROM User as u JOIN u.roles as r WHERE r.id = ?1 and u.enabled = true")
	public List<User> findByRole(int roleID);
	
	@Query("SELECT u FROM User as u JOIN u.roles as r WHERE r.id = ?1 and u.enabled = true")
	public  User findByRoleId(int roleID);
	
	@Query("select u from User u where u.id != 1  and u.enabled = true ORDER BY id DESC")
	public List<User> findAllExeptAdmin();
	
	@Query("SELECT u FROM User as u JOIN u.roles as r WHERE u.depar IN :hhh and r.id IN :rids and u.enabled = true") // and u.depar:depar ,@Param("depar")int depar
	 	public List<User> findByRoleBothInsAndAssi(@Param("hhh") List<Integer> hhh,@Param("rids") List<Integer> rids);
	
	
	@Query("SELECT u FROM User as u JOIN u.roles as r WHERE r.id IN :rids and u.enabled = true") 
 	public List<User> findByRoleBothInsAndAssiNotDepart(@Param("rids") List<Integer> rids);


	@Query("SELECT u FROM User as u JOIN u.roles as r WHERE u.id NOT IN :idd and r.id IN :rids and u.depar IN :hhh and u.enabled = true") // and u.depar:depar ,@Param("depar")int depar
 	public List<User> findByRoleBothInsAndAssiAndDeperWithOutItself(@Param("idd") List<Integer> idd,@Param("rids") List<Integer> rids,@Param("hhh") List<Integer> hhh);

	@Query("SELECT u FROM User as u JOIN u.roles as r WHERE u.depar =:depar and r.id = :rids and u.enabled = true") // and u.depar:depar ,@Param("depar")int depar
 	public User findByRoleAndFmie(@Param("depar")int depar,@Param("rids") int rids);

}
