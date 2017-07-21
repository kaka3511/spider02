package task;

public class YuJia {
	private String addr;
	private String address_norm;
	private String name;
	private String tel;
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddress_norm() {
		return address_norm;
	}
	public void setAddress_norm(String address_norm) {
		this.address_norm = address_norm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "YuJia [addr=" + addr + ", address_norm=" + address_norm + ", name=" + name + ", tel=" + tel + "]";
	}
	public YuJia(String addr, String address_norm, String name, String tel) {
		super();
		this.addr = addr;
		this.address_norm = address_norm;
		this.name = name;
		this.tel = tel;
	}
	public YuJia() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
}
