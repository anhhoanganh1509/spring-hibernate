package stackjava.com.springmvchibernate.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "info_customer")
public class Info_customer {
	@Id
	@Column(name = "customerid")
	private int customerid;
	
	@Column(name = "customername")
	private String customername;

	@Column(name = "customerphone")
	private String customerphone;

	@Column(name = "customeraddress")
	private String customeraddress;
	
	@Column(name = "diaChiTinhId")
	private int diaChiTinhId;

	@Column(name = "diaChiHuyenId")
	private int diaChiHuyenId;

	@Column(name = "diaChiXaId")
	private int diaChiXaId;	

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "orderdate")
	private Date orderdate;

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

	public Info_customer() {
		
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	
	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomerphone() {
		return customerphone;
	}

	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
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

	public int getDiaChiTinhId() {
		return diaChiTinhId;
	}

	public void setDiaChiTinhId(int diaChiTinhId) {
		this.diaChiTinhId = diaChiTinhId;
	}

	public int getDiaChiHuyenId() {
		return diaChiHuyenId;
	}

	public void setDiaChiHuyenId(int diaChiHuyenId) {
		this.diaChiHuyenId = diaChiHuyenId;
	}

	public int getDiaChiXaId() {
		return diaChiXaId;
	}

	public void setDiaChiXaId(int diaChiXaId) {
		this.diaChiXaId = diaChiXaId;
	}
    
}
