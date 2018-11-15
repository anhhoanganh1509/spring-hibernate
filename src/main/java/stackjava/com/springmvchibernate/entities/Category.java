package stackjava.com.springmvchibernate.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@Column(name = "categoryid")
	private int categoryid;
	
	@Column(name = "categoryname")
	private String categoryname;
	
    @Lob
    @Column(name = "categoryimage")
    private byte[] categoryimage;
    
    @Column(name = "chaid")
	private String chaid;

    @Column(name = "ngaytao")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date ngaytao;

	@Column(name = "nguoitao")
	private String nguoitao;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngaysua")
	private Date ngaysua;

	@Column(name = "nguoisua")
	private String nguoisua;

    @Column(name = "daxoa")
	private int daxoa;
	
    @OneToMany(mappedBy = "category")
    private List<Product> productList;
    
	public Category() {
		
	}

	public Category(int categoryid, String categoryname, byte[] categoryimage, String chaid, Date ngaytao,
			String nguoitao, Date ngaysua, String nguoisua, int daxoa) {
		this.categoryid = categoryid;
		this.categoryname = categoryname;
		this.categoryimage = categoryimage;
		this.chaid = chaid;
		this.ngaytao = ngaytao;
		this.nguoitao = nguoitao;
		this.ngaysua = ngaysua;
		this.nguoisua = nguoisua;
		this.daxoa = daxoa;
	}

	public String getChaid() {
		return chaid;
	}

	public void setChaid(String chaid) {
		this.chaid = chaid;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public byte[] getCategoryimage() {
		return categoryimage;
	}

	public void setCategoryimage(byte[] categoryimage) {
		this.categoryimage = categoryimage;
	}
	
	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public String getNguoitao() {
		return nguoitao;
	}

	public void setNguoitao(String nguoitao) {
		this.nguoitao = nguoitao;
	}

	public Date getNgaysua() {
		return ngaysua;
	}

	public void setNgaysua(Date ngaysua) {
		this.ngaysua = ngaysua;
	}

	public String getNguoisua() {
		return nguoisua;
	}

	public void setNguoisua(String nguoisua) {
		this.nguoisua = nguoisua;
	}

	public int getDaxoa() {
		return daxoa;
	}

	public void setDaxoa(int daxoa) {
		this.daxoa = daxoa;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}	
    
}
