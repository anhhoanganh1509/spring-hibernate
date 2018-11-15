package stackjava.com.springmvchibernate.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "productid")
	private int productid;

	@ManyToOne
	@JoinColumn(name = "productma")
	private Category category;
	
	@Column(name = "productname")
	private String productname;
	
    @Lob
    @Column(name = "productimage")
    private byte[] productimage;

    @Column(name = "sanid")
	private String sanid;

    @Column(name = "productprice")
	private int productprice;

	@Column(name = "productdescription")
	private String productdescription;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngaytao")
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
    
    @Column(name = "chaid")
	private int chaid;
	
	public Product() {
		
	}

	public int getChaid() {
		return chaid;
	}

	public void setChaid(int chaid) {
		this.chaid = chaid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public byte[] getProductimage() {
		return productimage;
	}

	public void setProductimage(byte[] productimage) {
		this.productimage = productimage;
	}
	
	public String getSanid() {
		return sanid;
	}

	public void setSanid(String sanid) {
		this.sanid = sanid;
	}

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
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
    
}
