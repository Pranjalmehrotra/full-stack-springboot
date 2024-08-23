package basics.full_stack_project.com.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_role_tbl")
public class UserRoleEntity {

	@Override
	public int hashCode() {
		return Objects.hash(userDescription, userName, userid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoleEntity other = (UserRoleEntity) obj;
		return Objects.equals(userDescription, other.userDescription) && Objects.equals(userName, other.userName)
				&& Objects.equals(userid, other.userid);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer userid;

	@Column(name = "role_name", nullable = false, length = 40, unique = true)
	private String userName;

	@Column(name = "role_description", length = 150, nullable = false)
	private String userDescription;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDescription() {
		return userDescription;
	}



	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	public UserRoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRoleEntity(Integer userid) {
		super();
		this.userid = userid;
	}

	public UserRoleEntity(String userName, String userDescription) {
		super();
		// this.userid = userid;
		this.userName = userName;
		this.userDescription = userDescription;
	}

	@Override
	public String toString() {
		return "UserRoleEntity [userid=" + userid + ", userName=" + userName + ", userDescription=" + userDescription
				+ "]";
	}

}
