package Bean;

public class UserBean {
	private int id;
	private String username;
	private String password;
	private String phnumber;
	private String depart;
	private String truename;
	private String city;
	private String director;
	private String hangye;
	private String education;
	private String zhicheng;
	private String address;
	private String e_code;
	private String dianhua;
	private String email;
	private String cardid;
	private String jigoushuxing;
	private String jigoujianjie;
	
	private String departname;
	private String wangzhi;
	private String faren;
	private String chuanzhen;
	private String juese;//用户角色
	
	
 	public String getJuese() {
		return juese;
	}
	public void setJuese(String juese) {
		this.juese = juese;
	}
	public String getDepartname() {
		return departname;
	}
	public void setDepartname(String departname) {
		this.departname = departname;
	}
	public String getWangzhi() {
		return wangzhi;
	}
	public void setWangzhi(String wangzhi) {
		this.wangzhi = wangzhi;
	}
	public String getFaren() {
		return faren;
	}
	public void setFaren(String faren) {
		this.faren = faren;
	}
	public String getChuanzhen() {
		return chuanzhen;
	}
	public void setChuanzhen(String chuanzhen) {
		this.chuanzhen = chuanzhen;
	}
	public String getJigoushuxing() {
		return jigoushuxing;
	}
	public void setJigoushuxing(String jigoushuxing) {
		this.jigoushuxing = jigoushuxing;
	}
	public String getJigoujianjie() {
		return jigoujianjie;
	}
	public void setJigoujianjie(String jigoujianjie) {
		this.jigoujianjie = jigoujianjie;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getHangye() {
		return hangye;
	}
	public void setHangye(String hangye) {
		this.hangye = hangye;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getZhicheng() {
		return zhicheng;
	}
	public void setZhicheng(String zhicheng) {
		this.zhicheng = zhicheng;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getE_code() {
		return e_code;
	}
	public void setE_code(String e_code) {
		this.e_code = e_code;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhnumber() {
		return phnumber;
	}
	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	//除了ID全都插入表格(注册)
		
	public UserBean(){}
	public UserBean(String username, String password, String phnumber, String depart, String truename, String city,
			String director, String hangye, String education, String zhicheng, String address, String e_code,
			String dianhua, String email, String cardid) {
		super();
		this.username = username;
		this.password = password;
		this.phnumber = phnumber;
		this.depart = depart;
		this.truename = truename;
		this.city = city;
		this.director = director;
		this.hangye = hangye;
		this.education = education;
		this.zhicheng = zhicheng;
		this.address = address;
		this.e_code = e_code;
		this.dianhua = dianhua;
		this.email = email;
		this.cardid = cardid;
	}
	//征集页面修改
	public UserBean(String username, String password, String phnumber, String depart, String truename, String city,
			String director, String hangye, String education, String zhicheng, String address, String e_code,
			String dianhua, String email, String cardid, String jigoushuxing, String jigoujianjie, String departname,
			String wangzhi, String faren, String chuanzhen) {
		super();
		this.username = username;
		this.password = password;
		this.phnumber = phnumber;
		this.depart = depart;
		this.truename = truename;
		this.city = city;
		this.director = director;
		this.hangye = hangye;
		this.education = education;
		this.zhicheng = zhicheng;
		this.address = address;
		this.e_code = e_code;
		this.dianhua = dianhua;
		this.email = email;
		this.cardid = cardid;
		this.jigoushuxing = jigoushuxing;
		this.jigoujianjie = jigoujianjie;
		this.departname = departname;
		this.wangzhi = wangzhi;
		this.faren = faren;
		this.chuanzhen = chuanzhen;
	}
	//获取所有属性
	public UserBean(int id, String username, String password, String phnumber, String depart, String truename,
			String city, String director, String hangye, String education, String zhicheng, String address,
			String e_code, String dianhua, String email, String cardid, String jigoushuxing, String jigoujianjie,
			String departname, String wangzhi, String faren, String chuanzhen) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phnumber = phnumber;
		this.depart = depart;
		this.truename = truename;
		this.city = city;
		this.director = director;
		this.hangye = hangye;
		this.education = education;
		this.zhicheng = zhicheng;
		this.address = address;
		this.e_code = e_code;
		this.dianhua = dianhua;
		this.email = email;
		this.cardid = cardid;
		this.jigoushuxing = jigoushuxing;
		this.jigoujianjie = jigoujianjie;
		this.departname = departname;
		this.wangzhi = wangzhi;
		this.faren = faren;
		this.chuanzhen = chuanzhen;
	}
	
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", password=" + password + ", phnumber=" + phnumber
				+ ", depart=" + depart + ", truename=" + truename + ", city=" + city + ", director=" + director
				+ ", hangye=" + hangye + ", education=" + education + ", zhicheng=" + zhicheng + ", address=" + address
				+ ", e_code=" + e_code + ", dianhua=" + dianhua + ", email=" + email + ", cardid=" + cardid
				+ ", jigoushuxing=" + jigoushuxing + ", jigoujianjie=" + jigoujianjie + ", departname=" + departname
				+ ", wangzhi=" + wangzhi + ", faren=" + faren + ", chuanzhen=" + chuanzhen + "]";
	}
	//第二个页面修改
	public UserBean(String depart,String departname,String address,String city,String wangzhi,String email,String faren,String e_code,
			String truename,String dianhua,String phnumber,String chuanzhen,String jigoushuxing,String jigoujianjie){
		this.depart = depart;
		this.departname = departname;
		this.address = address;
		this.city = city;
		this.wangzhi = wangzhi;
		this.email = email;
		this.faren = faren;
		this.e_code = e_code;
		this.truename = truename;
		this.dianhua = dianhua;
		this.phnumber = phnumber;
		this.chuanzhen = chuanzhen;
		this.jigoushuxing = jigoushuxing;
		this.jigoujianjie = jigoujianjie;
	}
	public UserBean(String phnumber, String depart, String truename, String dianhua, String jigoushuxing,
			String departname, String chuanzhen) {
		super();
		this.phnumber = phnumber;
		this.depart = depart;
		this.truename = truename;
		this.dianhua = dianhua;
		this.jigoushuxing = jigoushuxing;
		this.departname = departname;
		this.chuanzhen = chuanzhen;
	}
	
	public UserBean(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	
	
}
