package stackjava.com.springmvchibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import stackjava.com.springmvchibernate.dao.CategoryDao;
import stackjava.com.springmvchibernate.entities.Category;
import stackjava.com.springmvchibernate.entities.Donvihanhchinh;

@Service
@Transactional
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	public List<Category> findAll(Integer offset, Integer maxResults,String name) {
		return categoryDao.findAll(offset, maxResults, name);
	}

	public Long count(String name){
		return categoryDao.count(name);
	}

	public void save(final Category c) {
		categoryDao.save(c);
	}
	
	public Category findById(final int id) {
		return categoryDao.findById(id);
	}

	public void update(final Category c) {
		categoryDao.update(c);
	}

	public void delete(final Category c) {
		categoryDao.delete(c);
	}

	public List<Category> findAll_Product(Integer offset, Integer maxResults,String name) {
		return categoryDao.findAll_Product(offset, maxResults,name);
	}

	public Long count_Product(String name){
		return categoryDao.count_Product(name);
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public void save_Product(final Category c, CommonsMultipartFile fileUpload) {
		categoryDao.save_Product(c,fileUpload);
	}

	public void update(final Category c, CommonsMultipartFile fileUpload) {
		categoryDao.update(c,fileUpload);
	}

	public List<Category> findAll_Ajax(String categoryId) {
		return categoryDao.findAll_Ajax(categoryId);
	}

	public List<Donvihanhchinh> findAll_DVHC() {
		return categoryDao.findAll_DVHC();
	}

	public List<Donvihanhchinh> findAll_DVHC(String categoryId) {
		return categoryDao.findAll_DVHC(categoryId);
	}

	public List<Category> findAll_Product_id(int id) {
		return categoryDao.findAll_Product_id(id);
	}

	
}
