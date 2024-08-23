package basics.full_stack_project.com.entity;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_information_tbl")
public class UserInfoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userid;
	
	@Column(name = "first_name",length = 45,nullable = false)
	private String firstName;
	
	@Column(name = "last_name",length = 45,nullable = false)
   private String lastName;
	
	
	@Column(name = "email_address",length = 125,nullable = false,unique = true)
	private String emailAddress;
	
	@Column(name = "hashed_password",length = 64,nullable = false)
	private String password;
	
	
	@Column(name = "user_photos",length = 64)
	private String userPhotos;
	
	@Column(name = "user_enabled")
    private boolean enabled;
	
	@ManyToMany
	@JoinTable(
			name = "user_roles_tbl",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<UserRoleEntity> roles = new HashSet<>();
	
	public Integer getUserid() {
		return userid;
	}

	/*
	 * public UserInfoEntity() { super(); // TODO Auto-generated constructor stub }
	 */

	public UserInfoEntity(String firstName, String lastName, String emailAddress, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public UserInfoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserPhotos() {
		return userPhotos;
	}

	public void setUserPhotos(String userPhotos) {
		this.userPhotos = userPhotos;
	}

	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRoleEntity> roles) {
		this.roles = roles;
	}
	
	public void addRole(UserRoleEntity userRoleEntity) {
		
		this.roles.add(userRoleEntity);
	}

	@Override
	public String toString() {
		return "UserInfoEntity [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailAddress=" + emailAddress + ", password=" + password + ", roles=" + roles + "]";
	}
	
	

	
}
