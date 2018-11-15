package stackjava.com.springmvchibernate.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@Column(name = "billid")
	private int billid;
	
	@Column(name = "customerid")
	private int customerid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "orderdate")
	private Date orderdate;

	@Column(name = "productid")
	private int productid;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "chaid")
	private int chaid;

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

	public Bill() {
		
	}

	public int getBillid() {
		return billid;
	}

	public void setBillid(int billid) {
		this.billid = billid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getChaid() {
		return chaid;
	}

	public void setChaid(int chaid) {
		this.chaid = chaid;
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
