package Bean;

public class QuanxianBean {
	
	private String id;	//Ȩ��ID
	private String quanxian;//Ȩ������
	private String juese;//Ȩ�޽�ɫ
	
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
