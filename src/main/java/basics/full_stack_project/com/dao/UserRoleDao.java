package basics.full_stack_project.com.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import basics.full_stack_project.com.entity.UserRoleEntity;

@Repository
public interface UserRoleDao extends JpaRepository<UserRoleEntity,Integer> {

}
