package basics.full_stack_project.com.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import basics.full_stack_project.com.dao.UserInfoDao;
import basics.full_stack_project.com.entity.UserInfoEntity;

@Service
public class UserServiceImp implements UserService{
	
	UserInfoDao userInfoDao;

	@Autowired
	public UserServiceImp(UserInfoDao userInfoDao) {
		super();
		this.userInfoDao = userInfoDao;
	}
	
	public List<UserInfoEntity>listAllUsers(){
		
		return userInfoDao.findAll();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
