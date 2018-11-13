package stackjava.com.springmvchibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import stackjava.com.springmvchibernate.dao.ProductDao;
import stackjava.com.springmvchibernate.entities.Bill;
import stackjava.com.springmvchibernate.entities.Info_customer;
import stackjava.com.springmvchibernate.entities.Product;
import stackjava.com.springmvchibernate.model.Cart;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public List<Product> findAll(Integer offset, Integer maxResults) {
		return productDao.findAll(offset, maxResults);
	}

	public Long count(){
		return productDao.count();
	}
	 
	public void save(final Product c, CommonsMultipartFile fileUpload) {
		productDao.save(c, fileUpload);
	}

	public Product findById(final int id) {
		return productDao.findById(id);
	}
	
	public void delete(final Product c) {
		productDao.delete(c);
	}

	public List<Product> customerProduct(Integer offset, Integer maxResults, final int id) {
		return productDao.customerProduct(offset,maxResults,id);
	}

	public Long count_customerProduct(int chaid){
		return productDao.count_customerProduct(chaid);
	}
	 
	public Product findProduct(final Integer code) {
		return productDao.findProduct(code);
	}
	
	public void saveCheckout(final Info_customer cus,final Bill b,final Cart c) {
		productDao.saveCheckout(cus, b, c);
	}
}
