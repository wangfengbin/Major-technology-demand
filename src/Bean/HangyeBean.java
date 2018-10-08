package Bean;

public class HangyeBean {
	private int id;
	private String hangye;
	private int code;
	public HangyeBean() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHangye() {
		return hangye;
	}
	public void setHangye(String hangye) {
		this.hangye = hangye;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "HangyeBean [id=" + id + ", hangye=" + hangye + ", code=" + code + "]";
	}
	
}
