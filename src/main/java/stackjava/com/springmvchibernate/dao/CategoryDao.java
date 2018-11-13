package stackjava.com.springmvchibernate.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import stackjava.com.springmvchibernate.entities.Category;
import stackjava.com.springmvchibernate.entities.Donvihanhchinh;

@Repository(value = "categoryDao")
@Transactional(rollbackFor = Exception.class)
public class CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Category> findAll(Integer offset, Integer maxResults, String name) {
		Session session = this.sessionFactory.getCurrentSession();					
		return session.createQuery("FROM "+Category.class.getName()
				+" where chaid is null and daxoa = 0 and categoryname like '%"+name+"%' order by categoryid desc", Category.class)
				.setFirstResult(offset!=null?offset:0)
				.setMaxResults(maxResults!=null?maxResults:12)
				.getResultList();		
	}

	public Long count(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "Select count(o.categoryid) from " 
		+ Category.class.getName() + " o where o.daxoa = 0 and o.chaid is null and o.categoryname like '%"+name+"%'";
		Long value = (Long)session.createQuery(sql).uniqueResult();
        if (value == null) {
            return 0L;
        }
        return value;
	}

	public void save(final Category c) {
		Session session = this.sessionFactory.getCurrentSession();
		c.setCategoryid(this.max()+1);
		c.setNgaytao(new Date());
		session.save(c);
	}

	public Category findById(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Category.class, id);
	}

	public void update(final Category c) {
		Session session = this.sessionFactory.getCurrentSession();
		c.setNgaysua(new Date());
		session.update(c);
	}

	public void delete(final Category c) {
		Session session = this.sessionFactory.getCurrentSession();
		c.setDaxoa(1);
		session.update(c);
	}	

	public List<Category> findAll_Product(Integer offset, Integer maxResults, String name) {
		Session session = this.sessionFactory.getCurrentSession();					
		return session.createQuery("FROM "+Category.class.getName()
				+" where chaid is not null and daxoa = 0 and categoryname like '%"+name+"%' order by categoryid desc", Category.class)
				.setFirstResult(offset!=null?offset:0)
				.setMaxResults(maxResults!=null?maxResults:12)
				.getResultList();		
	}

	public Long count_Product(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "Select count(o.categoryid) from " 
		+ Category.class.getName() + " o where o.daxoa = 0 and o.chaid is not null and o.categoryname like '%"+name+"%'";				
    	Long value = (Long) session.createQuery(sql).uniqueResult();
        if (value == null) {
            return 0L;
        }
        return value;
	}

	public List<Category> findAll() {		
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM "+Category.class.getName()
				+" where chaid is null and daxoa = 0 order by categoryid desc", Category.class).getResultList();		
	}

	public void save_Product(final Category c, CommonsMultipartFile fileUpload) {
		Session session = this.sessionFactory.getCurrentSession();
		c.setCategoryid(this.max()+1);
		c.setNgaytao(new Date());
		if(fileUpload.getOriginalFilename().length() > 0) {
			c.setCategoryimage(fileUpload.getBytes());
		}
		session.save(c);
	}

	public void update(final Category c, CommonsMultipartFile fileUpload) {
		Session session = this.sessionFactory.getCurrentSession();
		c.setNgaysua(new Date());
		if(fileUpload.getOriginalFilename().length() > 0) {
			c.setCategoryimage(fileUpload.getBytes());
		}
		session.update(c);
	}

    public int max() {
		Session session = this.sessionFactory.getCurrentSession();		
    	String sql = "Select max(o.categoryid) from " + Category.class.getName() + " o ";
    	Integer value = (Integer)session.createQuery(sql).uniqueResult();    	
        if (value == null) {
            return 0;
        }
        return value;
    }
    
	public List<Category> findAll_Ajax(String categoryId) {		
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM "+Category.class.getName()
				+" where chaid ="+categoryId+" and daxoa = 0 order by categoryid desc", Category.class).getResultList();
	}

	public List<Donvihanhchinh> findAll_DVHC() {		
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM "+Donvihanhchinh.class.getName()
				+" where chaid is null and daxoa = 0 ", Donvihanhchinh.class).getResultList();		
	}

	public List<Donvihanhchinh> findAll_DVHC(String id) {		
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM "+Donvihanhchinh.class.getName()
				+" where chaid ="+id+" AND daxoa = 0", Donvihanhchinh.class).getResultList();		
	}

	public List<Category> findAll_Product_id(int id) {		
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM "+Category.class.getName()
				+" where chaid ="+id+" and daxoa = 0 and categoryimage is not null ", Category.class).getResultList();		
	}

}
