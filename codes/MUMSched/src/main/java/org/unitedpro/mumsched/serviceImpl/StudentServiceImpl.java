package org.unitedpro.mumsched.serviceImpl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.domain.*;
import org.unitedpro.mumsched.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{

	//private Student student;
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
	    this.entityManager = entityManager;
	}
	public EntityManager getEntityManager() {
	    return entityManager;
	}
	
	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.flush();
		entityManager.getTransaction().commit();
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public boolean delete(Student student) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
	        entityManager.remove(student);
	        entityManager.getTransaction().commit();
	    } catch (Exception ex) {
	        return false;
	    }
	    return true;
	}

	@Override
	public boolean update(Student student) {
		// TODO Auto-generated method stub
	    try{
	    	entityManager.getTransaction().begin();
	        entityManager.merge(student);
	        entityManager.getTransaction().commit();
	        return true;
	     } catch(Exception ex) {
	         return false;
	     }
	}
/*	@Autowired
	StudentDAO studentDAO;
	
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    
	public void save(Student student){
		studentDAO.save(student);
		return ;
	}

	public Student getStudentById(Long studentId) {
		return studentDAO.findStudentById(studentId);
	}

	@Override
	public void delete(Student student) {
		studentDAO.delete(student);
		
	}

	@Override
	public void update(Long id, Student student) {
		Student s = studentDAO.findStudentById(id);
		s = student;
		studentDAO.
	}*/
	
}
