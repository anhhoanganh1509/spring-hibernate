package stackjava.com.springmvchibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import stackjava.com.springmvchibernate.entities.Bill;
import stackjava.com.springmvchibernate.entities.Category;
import stackjava.com.springmvchibernate.entities.Donvihanhchinh;
import stackjava.com.springmvchibernate.entities.Info_customer;
import stackjava.com.springmvchibernate.entities.Product;
import stackjava.com.springmvchibernate.model.Cart;
import stackjava.com.springmvchibernate.model.ProductInfo;
import stackjava.com.springmvchibernate.model.Utils;
import stackjava.com.springmvchibernate.service.CategoryService;
import stackjava.com.springmvchibernate.service.ProductService;



@Controller
public class CustomerController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
    public String Main(Model model, HttpServletRequest request){
		List<Category> cateList = categoryService.findAll();
		model.addAttribute("cateList", cateList);
		List<Category> cateList_Product = categoryService.findAll_Product_id(1);
		model.addAttribute("cateList_Product", cateList_Product);
		Cart myCart = Utils.getCartInSession(request);
	    model.addAttribute("cartForm", myCart);
        return "index";
    }

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "login";
	}
	
	@RequestMapping(value="/admin/index")
	public String adminPages() {
		return "admin/index";
	}

	@RequestMapping(value="/admin/listCategory", method = RequestMethod.GET)
	public String listCategory(Model model, Integer offset, Integer maxResults,@RequestParam(value = "name", defaultValue = "") String name) {		
		String action="addNewCategory";
		model.addAttribute("action",action);
		model.addAttribute("categoryList", categoryService.findAll(offset, maxResults,name));
		model.addAttribute("count", categoryService.count(name));
        model.addAttribute("offset", offset);
        model.addAttribute("name", name);
		return "admin/index";
	}

	@RequestMapping(value="/admin/listCategory/{name}", method = RequestMethod.GET)
	public String searchlistCategory(Model model, Integer offset, Integer maxResults,@PathVariable String name) {
		String split_string_array[]=name.split("\\?");
		String action="addNewCategory";
		model.addAttribute("action",action);
		model.addAttribute("categoryList", categoryService.findAll(offset, maxResults,split_string_array[0]));
		model.addAttribute("count", categoryService.count(split_string_array[0]));
        model.addAttribute("offset", offset);
        model.addAttribute("name", split_string_array[0]);
		return "admin/index";
	}

	@RequestMapping(value="/admin/addNewCategory", method = RequestMethod.GET)
	public String addCategory(Model model) {
		String action="addNewCategory";
		model.addAttribute("action",action);
		model.addAttribute("categoryForm",new Category());
		return "admin/index";
	}
	
	@RequestMapping(value="/admin/addNewCategory", method = RequestMethod.POST)
	public String saveCategory(Category c, Model model) {
		categoryService.save(c);
		return "redirect:/admin/listCategory";
	}
	
	@RequestMapping(value="/admin/editCategory/{id}", method = RequestMethod.GET)
	public String editCategory(@PathVariable int id, Model model) {
		String action="updateCategory";
		model.addAttribute("action",action);
		Category c = categoryService.findById(id);
		model.addAttribute("categoryForm", c);
		return "admin/index";
	}
	
	@RequestMapping(value="/admin/updateCategory", method = RequestMethod.POST)
	public String updateCategory(Category c, Model model) {
		categoryService.update(c);
		return "redirect:/admin/listCategory";
	}

	@RequestMapping(value="/admin/deleteCategory/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable int id, Model model) {
		Category c = categoryService.findById(id);
		categoryService.delete(c);
		return "redirect:/admin/listCategory";
	}

	@RequestMapping(value="/admin/listProduct", method = RequestMethod.GET)
	public String listProduct(Model model, Integer offset, Integer maxResults,@RequestParam(value = "name", defaultValue = "") String name) {
        String action = "addNewProduct";
        model.addAttribute("actionProduct",action);
		model.addAttribute("productList", categoryService.findAll_Product(offset, maxResults, name));
		model.addAttribute("count", categoryService.count_Product(name));
        model.addAttribute("offset", offset);
        model.addAttribute("name", name);
		return "admin/index";
	}

	@RequestMapping(value="/admin/listProduct/{name}", method = RequestMethod.GET)
	public String searchlistProduct(Model model, Integer offset, Integer maxResults,@PathVariable String name) {
		String split_string_array[]=name.split("\\?");
        String action = "addNewProduct";
        model.addAttribute("actionProduct",action);
		model.addAttribute("productList", categoryService.findAll_Product(offset, maxResults,split_string_array[0]));
		model.addAttribute("count", categoryService.count_Product(split_string_array[0]));
        model.addAttribute("offset", offset);
        model.addAttribute("name", split_string_array[0]);
		return "admin/index";
	}
	
	@RequestMapping(value="/admin/addNewProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {
		String action="addNewProduct";
		model.addAttribute("action",action);
		model.addAttribute("productForm",new Category());
		List<Category> cateList = categoryService.findAll();
		model.addAttribute("cateList", cateList);
		return "admin/index";
	}
	
	@RequestMapping(value="/admin/addNewProduct", method = RequestMethod.POST)
	public String saveProduct(Category c, Model model, @RequestParam CommonsMultipartFile fileUpload) {
		categoryService.save_Product(c,fileUpload);
		return "redirect:/admin/listProduct";
	}

	@RequestMapping(value="/admin/editProduct/{id}", method = RequestMethod.GET)
	public String editProduct(@PathVariable int id, Model model) {
		String action="updateProduct";
		model.addAttribute("action",action);
		Category c = categoryService.findById(id);
		List<Category> cateList = categoryService.findAll();
		model.addAttribute("cateList", cateList);
		model.addAttribute("productForm", c);		
		return "admin/index";
	}

	@RequestMapping(value="/admin/updateProduct", method = RequestMethod.POST)
	public String updateProduct(Category c, Model model, @RequestParam CommonsMultipartFile fileUpload) {
		categoryService.update(c,fileUpload);
		return "redirect:/admin/listProduct";
	}

	@RequestMapping(value="/admin/deleteProduct/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable int id, Model model) {
		Category c = categoryService.findById(id);
		categoryService.delete(c);
		return "redirect:/admin/listProduct";
	}

	@RequestMapping(value="/admin/listDetailProduct", method = RequestMethod.GET)
	public String listDetailProduct(Model model, Integer offset, Integer maxResults) {
		String action = "addNewDetailProduct";
        model.addAttribute("actionDetail",action);
		model.addAttribute("productListDetail", productService.findAll(offset, maxResults));
		model.addAttribute("count", productService.count());
        model.addAttribute("offset", offset);
		return "admin/index";
	}

	@RequestMapping(value="/admin/addNewDetailProduct", method = RequestMethod.GET)
	public String addDetailProduct(Model model) {
		String action="addNewDetailProduct";
		model.addAttribute("action",action);
		model.addAttribute("productFormDetail",new Product());
		List<Category> cateList = categoryService.findAll();
		model.addAttribute("cateList", cateList);
		return "admin/index";
	}

	@RequestMapping(value="/admin/addNewDetailProduct", method = RequestMethod.POST)
	public String saveDetailProduct(Product p, Model model, @RequestParam CommonsMultipartFile fileUpload) {
		productService.save(p, fileUpload);
		return "redirect:/admin/listDetailProduct";
	}

	@RequestMapping(value="/admin/deleteDetailProduct/{id}", method = RequestMethod.GET)
	public String deleteDetailProduct(@PathVariable int id, Model model) {
		Product c = productService.findById(id);
		productService.delete(c);
		return "redirect:/admin/listDetailProduct";
	}

	@RequestMapping(value = "admin/fetchDonViHanhChinh")
	public void ajax(Model model,@RequestParam("isAction") String isAction,
			@RequestParam("categoryId") String categoryId, HttpServletResponse response) throws IOException{
		JSONObject json = null;  
        JSONArray jsonResult = new JSONArray();
        try {
        	if(isAction.equals("getCategory")) {
    			List<Category> cateList = categoryService.findAll_Ajax(categoryId);
    			for (Category c : cateList) {
    				json = new JSONObject();
    				json.put("id", c.getCategoryid());
    				json.put("name", c.getCategoryname());
    				jsonResult.put(json);
    			}
    			response.getWriter().write(jsonResult.toString());
    		}
        }catch(Exception ex) {
        	ex.printStackTrace();
        }		
	}

	@RequestMapping(value = "/fetchDonViHanhChinh")
	public void fetchDonViHanhChinh(Model model,@RequestParam("isAction") String isAction, HttpServletResponse response,
			@RequestParam("tinhTPId") String tinhTPId) throws IOException{
		String country = null;
		if(isAction.equals("getHuyenTP")) {
			country = tinhTPId;
		}
		if(isAction.equals("getXaTP")) {
			country = tinhTPId;
		}
		JSONObject json = null;  
        JSONArray jsonResult = new JSONArray();
        try {        	
			List<Donvihanhchinh> cateList = categoryService.findAll_DVHC(country);
			for (Donvihanhchinh c : cateList) {
				json = new JSONObject();
				json.put("id", c.getId());
				json.put("name", c.getTen());
				jsonResult.put(json);
			}
			response.getWriter().write(jsonResult.toString());    		
        }catch(Exception ex) {
        	ex.printStackTrace();
        }		
	}
	
	@RequestMapping(value="/customerProduct/{id}", method = RequestMethod.GET)
	public String customerProduct(@PathVariable int id, Model model, Integer offset, Integer maxResults) {
		model.addAttribute("listCustomerProduct",productService.customerProduct(offset,maxResults,id));
		model.addAttribute("count", productService.count_customerProduct(id));
        model.addAttribute("offset", offset);
		List<Category> cateList = categoryService.findAll();
		model.addAttribute("cateList", cateList);
		model.addAttribute("id", id);
		List<Category> cateList_Product = categoryService.findAll_Product_id(id);
		model.addAttribute("cateList_Product", cateList_Product);
		return "index";
	}

	@RequestMapping(value="/customerProductSingle/{id}", method = RequestMethod.GET)
	public String customerProductSingle(@PathVariable int id, Model model) {
		model.addAttribute("customerProductSingle", productService.findById(id));
		List<Category> cateList = categoryService.findAll();
		model.addAttribute("cateList", cateList);
		return "index";
	}
	
	@RequestMapping(value="/customerProductCart/{id}", method = RequestMethod.GET)
	public String customerProductCart(@PathVariable Integer id, Model model,
			HttpServletRequest request, Integer offset, Integer maxResults) {		
		Product p = null;
		if (id != null) {
			p = productService.findProduct(id);
		}
		if(p != null) {
	       Cart cartInfo = Utils.getCartInSession(request);
	       ProductInfo productInfo = new ProductInfo(p);	           
	       cartInfo.addProduct(productInfo, 1);
		}
		Cart myCart = Utils.getCartInSession(request);
	    model.addAttribute("cartForm", myCart);
		List<Category> cateList = categoryService.findAll();
		model.addAttribute("cateList", cateList);
		List<Category> cateList_Product = categoryService.findAll_Product_id(1);
		model.addAttribute("cateList_Product", cateList_Product);
		return "index";
	}

	@RequestMapping(value="/checkoutProductCart", method = RequestMethod.GET)
	public String addCheckoutProduct(Model model, HttpServletRequest request) {
		String action="checkoutProductCart";
		model.addAttribute("action",action);
		model.addAttribute("info_customer",new Info_customer());
		List<Category> cateList = categoryService.findAll();
		model.addAttribute("cateList", cateList);
		List<Donvihanhchinh> cateListDVHC = categoryService.findAll_DVHC();
		model.addAttribute("cateListDVHC", cateListDVHC);
		Cart myCart = Utils.getCartInSession(request);
	    model.addAttribute("cartForm", myCart);
		return "checkout";
	}

	@RequestMapping(value="/checkoutProductCart", method = RequestMethod.POST)
	public String checkoutProductCart(Model model, HttpServletRequest request, Info_customer cus, Bill b) {
		Cart myCart = Utils.getCartInSession(request);
		productService.saveCheckout(cus, b, myCart);
		Utils.removeCartInSession(request);
		return "index";
	}
	
	@RequestMapping(value = { "/productImage" }, method = RequestMethod.GET)
	   public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
	           @RequestParam("id") String id) throws IOException {
		Product p = null;
		if(id != null) {
			p = productService.findById(Integer.parseInt(id));
		}
		if(p != null && p.getProductimage() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	           response.getOutputStream().write(p.getProductimage());
		}
		response.getOutputStream().close();
	}
	
	@RequestMapping(value = { "/productImageLogo" }, method = RequestMethod.GET)
	   public void productImage_Logo(HttpServletRequest request, HttpServletResponse response, Model model,
	           @RequestParam("id") String id) throws IOException {
		Category c = null;
		if(id != null) {
			c = categoryService.findById(Integer.parseInt(id));
		}
		if(c != null && c.getCategoryimage() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	           response.getOutputStream().write(c.getCategoryimage());
		}
		response.getOutputStream().close();
	}
}
