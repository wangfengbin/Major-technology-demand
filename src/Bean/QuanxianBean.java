package Bean;

public class QuanxianBean {
	
	private String id;	//权限ID
	private String quanxian;//权限名字
	private String juese;//权限角色
	
	public QuanxianBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuanxian() {
		return quanxian;
	}
	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}
	public String getJuese() {
		return juese;
	}
	public void setJuese(String juese) {
		this.juese = juese;
	}
	
	@Override
	public String toString() {
		return "QuanxianBean [id=" + id + ", quanxian=" + quanxian + ", juese=" + juese + "]";
	}
	
	
	

}
