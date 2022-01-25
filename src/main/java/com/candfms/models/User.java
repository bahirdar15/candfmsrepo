package com.candfms.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.candfms.models.Role;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="USER")

  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
 
public class User {
	@Id	
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	/* @GeneratedValue(strategy=GenerationType.AUTO) */
	public int id;
	

	@NotBlank(message="Name field is required !!")
	  
	  @Size(min=2,max=100,message="min 2 and max 100 characters are allowed !!")
	 
	private String name;
	
	  @NotBlank(message="UserName field is required !!")
	  
	  @Size(min=2,max=20,message="min 2 and max 20 characters are allowed !!")
	  @Column(unique=true) 
	private String uname;
	
	private String email;
	private String password;
	/* private String role; */
	private String phone;
	private boolean enabled;
	private String imageUrl;
	private String signature;
	@Column(length=500)
	private String about;
	private String address;
	private int depar;
	
	/*start role*/
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();
	/* end role */
	
	
	//now, 'one user can have many contacts', we can use list, set etc.
	/*
	 * @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	 * //cascade, auto save, delete etc. i.e If user is save, then contact will auto
	 * saved. private List<Student> students = new ArrayList<>();
	 * 
	 * @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	 * private List<Feedback> feedbacks = new ArrayList<>();
	 */
	
	
	/*
	 * @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true)
	 * public List<UserCoursout> userCoursouts;
	 */
	  
	  @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<UserCoursoutAssign> userCoursoutAssigns;
	  
	  @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<UserCoursoutCart> userCoursoutCarts;
	  
	  @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<UserCoursoutDetile> userCoursoutDetiles;
	  
	  @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<InstaCart> instaCarts;
	  
	  @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<StuCart> stuCarts;
	  
	  @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<LabCart> labCarts;
	  
	  
	  @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<InstaOrder> InstaOrders;
	  
	  @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<StuOrder> StuOrders;
	  
	  @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<StuOrderDetile> StuOrderDetiles;
	  
	  @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<LabOrder> LabOrders;
	  
	  
	  
	  
	  @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<ProformRequ> proformRequs;
	  
	  @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<EvaluationCo> evaluationCos;
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  public List<StuOrderDetile> getStuOrderDetiles() {
		return StuOrderDetiles;
	}




	public void setStuOrderDetiles(List<StuOrderDetile> stuOrderDetiles) {
		StuOrderDetiles = stuOrderDetiles;
	}




	public int getDepar() {
		return depar;
	}




	public void setDepar(int depar) {
		this.depar = depar;
	}




	public Set<Role> getRoles() {
		return roles;
	}




	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}




	public List<UserCoursoutAssign> getUserCoursoutAssigns() {
		return userCoursoutAssigns;
	}




	public void setUserCoursoutAssigns(List<UserCoursoutAssign> userCoursoutAssigns) {
		this.userCoursoutAssigns = userCoursoutAssigns;
	}




	public List<UserCoursoutCart> getUserCoursoutCarts() {
		return userCoursoutCarts;
	}




	public void setUserCoursoutCarts(List<UserCoursoutCart> userCoursoutCarts) {
		this.userCoursoutCarts = userCoursoutCarts;
	}




	public List<UserCoursoutDetile> getUserCoursoutDetiles() {
		return userCoursoutDetiles;
	}




	public void setUserCoursoutDetiles(List<UserCoursoutDetile> userCoursoutDetiles) {
		this.userCoursoutDetiles = userCoursoutDetiles;
	}




	public List<StuCart> getStuCarts() {
		return stuCarts;
	}




	public void setStuCarts(List<StuCart> stuCarts) {
		this.stuCarts = stuCarts;
	}




	public List<LabCart> getLabCarts() {
		return labCarts;
	}




	public void setLabCarts(List<LabCart> labCarts) {
		this.labCarts = labCarts;
	}




	public List<StuOrder> getStuOrders() {
		return StuOrders;
	}




	public void setStuOrders(List<StuOrder> stuOrders) {
		StuOrders = stuOrders;
	}




	public List<LabOrder> getLabOrders() {
		return LabOrders;
	}




	public void setLabOrders(List<LabOrder> labOrders) {
		LabOrders = labOrders;
	}




	public List<EvaluationCo> getEvaluationCos() {
		return evaluationCos;
	}




	public void setEvaluationCos(List<EvaluationCo> evaluationCos) {
		this.evaluationCos = evaluationCos;
	}




	public List<InstaOrder> getInstaOrders() {
		return InstaOrders;
	}




	public void setInstaOrders(List<InstaOrder> instaOrders) {
		InstaOrders = instaOrders;
	}




	public List<ProformRequ> getProformRequs() {
		return proformRequs;
	}




	public void setProformRequs(List<ProformRequ> proformRequs) {
		this.proformRequs = proformRequs;
	}




	public List<InstaCart> getInstaCarts() {
		return instaCarts;
	}




	public void setInstaCarts(List<InstaCart> instaCarts) {
		this.instaCarts = instaCarts;
	}



	    




		public int getId() {
			return id;
		}




		public void setId(int id) {
			this.id = id;
		}




	public String getName() {
		return name;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	




	public void setName(String name) {
		this.name = name;
	}




	public String getUname() {
		return uname;
	}




	public void setUname(String uname) {
		this.uname = uname;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	



	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public boolean isEnabled() {
		return enabled;
	}




	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}




	public String getImageUrl() {
		return imageUrl;
	}




	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}




	public String getSignature() {
		return signature;
	}




	public void setSignature(String signature) {
		this.signature = signature;
	}




	public String getAbout() {
		return about;
	}




	public void setAbout(String about) {
		this.about = about;
	}




	
	public void addRole(Role role) {
		this.roles.add(role);
	}

	

	

    
	
	
	
	

}
