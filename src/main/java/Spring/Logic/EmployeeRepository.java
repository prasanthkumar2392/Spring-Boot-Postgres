package Spring.Logic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    public List<Employee> findAllByName(String name);
    @Transactional
    public void deleteByName(String name);


    @Transactional
    @Modifying
    @Query("update Employee set name=:name where id=:id" )
    void  updateByName(@Param("name") String name,@Param("id") int id);
}
