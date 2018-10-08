package Bean;

public class TwoHangyeBean {
	private int id;
	private String twohangye;
	private int code;
	private int fuid;
	public TwoHangyeBean() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTwohangye() {
		return twohangye;
	}
	public void setTwohangye(String twohangye) {
		this.twohangye = twohangye;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getFuid() {
		return fuid;
	}
	public void setFuid(int fuid) {
		this.fuid = fuid;
	}

	@Override
	public String toString() {
		return "TwoHangyeBean [id=" + id + ", twohangye=" + twohangye + ", code=" + code + ", fuid=" + fuid + "]";
	}
	
}
