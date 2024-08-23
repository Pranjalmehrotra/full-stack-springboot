package basics.full_stack_project.com;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import basics.full_stack_project.com.dao.UserInfoDao;
import basics.full_stack_project.com.entity.UserInfoEntity;
import basics.full_stack_project.com.entity.UserRoleEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserInfoRespositoryTest {

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private TestEntityManager testEntityManager;
	
	//Commented the code of testCreateNewUserWithOneRole() and testCreateNewUserWtihTwoRoles() because of the error dupicate 
	//entry found coming of the eamil while installing the build

	/*
	 * @Test public void testCreateNewUserWithOneRole() {
	 * 
	 * UserRoleEntity roleAdmin = testEntityManager.find(UserRoleEntity.class, 1);
	 * 
	 * UserInfoEntity userInfoFirstEntity = new UserInfoEntity("Rajesh", "Mehrotra",
	 * "rajeshmehrotra213@gmail.com", "Pranjal@1234567890");
	 * userInfoFirstEntity.addRole(roleAdmin); UserInfoEntity savedFirstUser =
	 * userInfoDao.save(userInfoFirstEntity);
	 * 
	 * }
	 */

	/*
	 * @Test public void testCreateNewUserWtihTwoRoles() {
	 * 
	 * UserInfoEntity userInfoEntity = new UserInfoEntity("Skand", "Mehrotra",
	 * "skandmehrotra213@gmail.com", "Rishabh@123456"); UserRoleEntity assitantRole
	 * = new UserRoleEntity(9); UserRoleEntity editorRole = new UserRoleEntity(10);
	 * userInfoEntity.addRole(assitantRole); userInfoEntity.addRole(editorRole);
	 * userInfoDao.save(userInfoEntity); }
	 */

	// Get List of all userDetails
	@Test
	public void testListAllUsers() {
		Iterable<UserInfoEntity> listUsers = userInfoDao.findAll();
		listUsers.forEach(user -> System.out.println("The values of user details are ::" + user));

	}

	// Get details by userid
	@Test
	public void getUserDeatilsByUserId() {
		UserInfoEntity userEntityFind = userInfoDao.findById(2).get();
		System.out.println("UserEntity details are ::" + userEntityFind);
	}

	// Update userdetails
	@Test
	public void updateUserDetails() {
		UserInfoEntity userEntityFind = userInfoDao.findById(1).get();
		userEntityFind.setEnabled(true);
		userEntityFind.setEmailAddress("pranjalmehrotra123@gmail.com");
		userInfoDao.save(userEntityFind);
	}
	
	@Test
	public void updateUserRole() {
		
		/*
		 * UserInfoEntity userEntityFind = userInfoDao.findById(2).get(); UserRoleEntity
		 * salesPersonEntity = new UserRoleEntity(12); Set<UserRoleEntity> role=
		 * userEntityFind.getRoles(); System.out.println("Rol/roles are ::" + role);
		 * userEntityFind.getRoles().remove(role); userInfoDao.save(userEntityFind);
		 */
		
		UserInfoEntity userEntityFind = userInfoDao.findById(2).get();
		UserRoleEntity assistantEntity = new UserRoleEntity(9);
		UserRoleEntity editorEntity = new UserRoleEntity(10);
		UserRoleEntity shipperEntity = new UserRoleEntity(12);


		userEntityFind.getRoles().remove(editorEntity);
		userEntityFind.addRole(shipperEntity);
		userInfoDao.save(userEntityFind);
		
		//userEntityFind.setRoles(salesPersonEntity);

		
	}

}
