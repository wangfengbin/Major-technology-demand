package Bean;

public class TwoxuekeBean {
	private int id;
	private String name;
	private String code;
	private int fuid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
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
		return "TwoxuekeBean [id=" + id + ", name=" + name + ", code=" + code + ", fuid=" + fuid + "]";
	}
	public TwoxuekeBean() {}
	
}
