package stackjava.com.springmvchibernate.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import stackjava.com.springmvchibernate.entities.Bill;
import stackjava.com.springmvchibernate.entities.Info_customer;
import stackjava.com.springmvchibernate.entities.Product;
import stackjava.com.springmvchibernate.model.Cart;
import stackjava.com.springmvchibernate.model.Item;

@Repository(value = "productDao")
@Transactional(rollbackFor = Exception.class)
public class ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Product> findAll(Integer offset, Integer maxResults) {
		Session session = this.sessionFactory.getCurrentSession();							
		return session.createQuery("FROM "+Product.class.getName()
				+" where daxoa = 0 order by productid desc", Product.class)
				.setFirstResult(offset!=null?offset:0)
				.setMaxResults(maxResults!=null?maxResults:12)
				.getResultList();		
	}

	public Long count() {
		Session session = this.sessionFactory.getCurrentSession();	
		String sql = "Select count(o.productid) from " 
		+ Product.class.getName() + " o where o.daxoa = 0";
		Long value = (Long)session.createQuery(sql).uniqueResult();    
        if (value == null) {
            return 0L;
        }
        return value;
	}

	public void save(final Product c, CommonsMultipartFile fileUpload) {
		Session session = this.sessionFactory.getCurrentSession();		
		if (fileUpload.getOriginalFilename().length() > 0) {				
			c.setProductid(this.max()+1);			
			c.setNgaytao(new Date());
			c.setProductimage(fileUpload.getBytes());		
			session.save(c);
		}
	}

	public Product findById(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Product.class, id);
	}
	
	public void delete(final Product c) {
		Session session = this.sessionFactory.getCurrentSession();
		c.setDaxoa(1);
		session.update(c);
	}
	
    public int max() {
		Session session = this.sessionFactory.getCurrentSession();
    	String sql = "Select max(o.productid) from " + Product.class.getName() + " o ";
    	Integer value = (Integer)session.createQuery(sql).uniqueResult();
        if (value == null) {
            return 0;
        }
        return value;
    }
    

	public List<Product> customerProduct(Integer offset, Integer maxResults, int chaid) {
		Session session = this.sessionFactory.getCurrentSession();							
		return session.createQuery("FROM "+Product.class.getName()
				+" where daxoa = 0 and chaid = "+chaid+" order by productid desc", Product.class)
				.setFirstResult(offset!=null?offset:0)
				.setMaxResults(maxResults!=null?maxResults:12)
				.getResultList();		
	}

	public Long count_customerProduct(int chaid) {
		Session session = this.sessionFactory.getCurrentSession();	
		String sql = "Select count(o.productid) from " 
		+ Product.class.getName() + " o where o.daxoa = 0 and o.chaid = "+chaid+" ";
		Long value = (Long)session.createQuery(sql).uniqueResult();    
        if (value == null) {
            return 0L;
        }
        return value;
	}

	public Product findProduct(Integer code) {
	        Session session = this.sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Product.class);
	        crit.add(Restrictions.eq("productid", code));
	        return (Product) crit.uniqueResult();
	}
	
	public void saveCheckout(Info_customer cus, Bill b, Cart c) {
        Session session = this.sessionFactory.getCurrentSession();
		List<Item> lines = c.getCartLines();
		if(lines != null) {
        int maxCustomerId = this.max_customer()+1;
        cus.setCustomerid(maxCustomerId);
        cus.setOrderdate(new Date());
        cus.setNgaytao(new Date());
		session.save(cus);
		}
		for(Item i : lines) {
			Bill b1 = new Bill();
			b1.setBillid(this.max_bill()+1);
			b1.setCustomerid(this.max_customer());
			b1.setOrderdate(new Date());
			b1.setQuantity(i.getQuantity());
			b1.setProductid(i.getProduct().getProductId());
			b1.setNgaytao(new Date());
			session.save(b1);
		}		
	}

    public int max_customer() {
		Session session = this.sessionFactory.getCurrentSession();
    	String sql = "Select max(o.customerid) from " + Info_customer.class.getName() + " o ";
    	Integer value = (Integer)session.createQuery(sql).uniqueResult();
        if (value == null) {
            return 0;
        }
        return value;
    }
    
    public int max_bill() {
		Session session = this.sessionFactory.getCurrentSession();
    	String sql = "Select max(o.billid) from " + Bill.class.getName() + " o ";
    	Integer value = (Integer)session.createQuery(sql).uniqueResult();
        if (value == null) {
            return 0;
        }
        return value;
    }
}
