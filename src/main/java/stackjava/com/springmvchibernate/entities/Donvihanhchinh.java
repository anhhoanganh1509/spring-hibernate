package stackjava.com.springmvchibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donvihanhchinh")
public class Donvihanhchinh {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "ma")
	private String ma;

	@Column(name = "ten")
	private String ten;

    @Column(name = "daxoa")
	private int daxoa;

	@Column(name = "chaid")
	private String chaid;

	public Donvihanhchinh() {
		super();
	}

	public Donvihanhchinh(int id, String ma, String ten, int daxoa, String chaid) {
		super();
		this.id = id;
		this.ma = ma;
		this.ten = ten;
		this.daxoa = daxoa;
		this.chaid = chaid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getDaxoa() {
		return daxoa;
	}

	public void setDaxoa(int daxoa) {
		this.daxoa = daxoa;
	}

	public String getChaid() {
		return chaid;
	}

	public void setChaid(String chaid) {
		this.chaid = chaid;
	}

    
}
