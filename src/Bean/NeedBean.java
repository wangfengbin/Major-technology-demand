package Bean;

public class NeedBean {
	private String id;
	private int userid;			//���������û���id;
	private String name;		//��������
	private String descrpt;		//�����������
	private String type;		//�Ƽ������
	private String moshi;		//�����ʽ
	private double money;		//Ͷ�ʽ��
	private int status;			//�Ƿ����
	private int status1;		//��ʽ���
	private String date;		//��д����
	private String ping;		//����
	
	private String qiannian;	//��ݿ�ʼ
	private String hounian;		//��ݵ�
	private String guanjian1;	//�ؼ���1
	private String guanjian2;
	private String guanjian3;
	private String guanjian4;
	private String guanjian5; //�ؼ���5
	private String hezuo;	 //������λ
	private String xueke;    //ѧ�Ʒ���
	private String twoxueke;
	private String lingyu;   //��������
	private String yingyong;   //Ӧ����ҵ
	private String twohangye;	//�ڶ���ҵ
	
	
	
	public String getTwoxueke() {
		return twoxueke;
	}
	public void setTwoxueke(String twoxueke) {
		this.twoxueke = twoxueke;
	}
	public String getTwohangye() {
		return twohangye;
	}
	public void setTwohangye(String twohangye) {
		this.twohangye = twohangye;
	}
	public String getPing() {
		return ping;
	}
	public void setPing(String ping) {
		this.ping = ping;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrpt() {
		return descrpt;
	}
	public void setDescrpt(String descrpt) {
		this.descrpt = descrpt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMoshi() {
		return moshi;
	}
	public void setMoshi(String moshi) {
		this.moshi = moshi;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getStatus1() {
		return status1;
	}
	public void setStatus1(int status1) {
		this.status1 = status1;
	}
	public String getQiannian() {
		return qiannian;
	}
	public void setQiannian(String qiannian) {
		this.qiannian = qiannian;
	}
	public String getHounian() {
		return hounian;
	}
	public void setHounian(String hounian) {
		this.hounian = hounian;
	}
	public String getGuanjian1() {
		return guanjian1;
	}
	public void setGuanjian1(String guanjian1) {
		this.guanjian1 = guanjian1;
	}
	public String getGuanjian2() {
		return guanjian2;
	}
	public void setGuanjian2(String guanjian2) {
		this.guanjian2 = guanjian2;
	}
	public String getGuanjian3() {
		return guanjian3;
	}
	public void setGuanjian3(String guanjian3) {
		this.guanjian3 = guanjian3;
	}
	public String getGuanjian4() {
		return guanjian4;
	}
	public void setGuanjian4(String guanjian4) {
		this.guanjian4 = guanjian4;
	}
	public String getGuanjian5() {
		return guanjian5;
	}
	public void setGuanjian5(String guanjian5) {
		this.guanjian5 = guanjian5;
	}
	public String getHezuo() {
		return hezuo;
	}
	public void setHezuo(String hezuo) {
		this.hezuo = hezuo;
	}
	public String getXueke() {
		return xueke;
	}
	public void setXueke(String xueke) {
		this.xueke = xueke;
	}
	public String getLingyu() {
		return lingyu;
	}
	public void setLingyu(String lingyu) {
		this.lingyu = lingyu;
	}
	public String getYingyong() {
		return yingyong;
	}
	public void setYingyong(String yingyong) {
		this.yingyong = yingyong;
	}
	
	
	
	
	@Override
	public String toString() {
		return "NeedBean [id=" + id + ", userid=" + userid + ", name=" + name + ", descrpt=" + descrpt + ", type="
				+ type + ", moshi=" + moshi + ", money=" + money + ", status=" + status + ", status1=" + status1
				+ ", date=" + date + ", ping=" + ping + ", qiannian=" + qiannian + ", hounian=" + hounian
				+ ", guanjian1=" + guanjian1 + ", guanjian2=" + guanjian2 + ", guanjian3=" + guanjian3 + ", guanjian4="
				+ guanjian4 + ", guanjian5=" + guanjian5 + ", hezuo=" + hezuo + ", xueke=" + xueke + ", twoxueke="
				+ twoxueke + ", lingyu=" + lingyu + ", yingyong=" + yingyong + ", twohangye=" + twohangye + "]";
	}
	public NeedBean() {
		
	}
	//��������
	public NeedBean(String id,int userid, String name, String descrpt, String type, String moshi, double money, String ping,
			String qiannian, String hounian, String guanjian1, String guanjian2, String guanjian3, String guanjian4,
			String guanjian5, String hezuo, String xueke,String twoxueke, String lingyu, String yingyong,String twohangye) {
		super();
		this.id = id;
		this.userid = userid;
		this.name = name;
		this.descrpt = descrpt;
		this.type = type;
		this.moshi = moshi;
		this.money = money;
		this.ping = ping;
		this.qiannian = qiannian;
		this.hounian = hounian;
		this.guanjian1 = guanjian1;
		this.guanjian2 = guanjian2;
		this.guanjian3 = guanjian3;
		this.guanjian4 = guanjian4;
		this.guanjian5 = guanjian5;
		this.hezuo = hezuo;
		this.xueke = xueke;
		this.twoxueke = twoxueke;
		this.lingyu = lingyu;
		this.yingyong = yingyong;
		this.twohangye = twohangye;
	}
	
	//���ȫ������
	public NeedBean(String id, int userid, String name, String descrpt, String type, String moshi, double money,
			int status, int status1, String date, String ping, String qiannian, String hounian, String guanjian1,
			String guanjian2, String guanjian3, String guanjian4, String guanjian5, String hezuo, String xueke,
			String twoxueke,String lingyu, String yingyong,String twohangye) {
		super();
		this.id = id;
		this.userid = userid;
		this.name = name;
		this.descrpt = descrpt;
		this.type = type;
		this.moshi = moshi;
		this.money = money;
		this.status = status;
		this.status1 = status1;
		this.date = date;
		this.ping = ping;
		this.qiannian = qiannian;
		this.hounian = hounian;
		this.guanjian1 = guanjian1;
		this.guanjian2 = guanjian2;
		this.guanjian3 = guanjian3;
		this.guanjian4 = guanjian4;
		this.guanjian5 = guanjian5;
		this.hezuo = hezuo;
		this.xueke = xueke;
		this.twoxueke = twoxueke;
		this.lingyu = lingyu;
		this.yingyong = yingyong;
		this.twohangye = twohangye;
	}
	public NeedBean(int userid, String name, String descrpt, String type, String moshi, double money, String ping,
			String qiannian, String hounian, String guanjian1, String guanjian2, String guanjian3, String guanjian4,
			String guanjian5, String hezuo, String xueke,String twoxueke, String lingyu, String yingyong,String twohangye) {
		super();
	
		this.userid = userid;
		this.name = name;
		this.descrpt = descrpt;
		this.type = type;
		this.moshi = moshi;
		this.money = money;
		this.ping = ping;
		this.qiannian = qiannian;
		this.hounian = hounian;
		this.guanjian1 = guanjian1;
		this.guanjian2 = guanjian2;
		this.guanjian3 = guanjian3;
		this.guanjian4 = guanjian4;
		this.guanjian5 = guanjian5;
		this.hezuo = hezuo;
		this.xueke = xueke;
		this.twoxueke = twoxueke;
		this.lingyu = lingyu;
		this.yingyong = yingyong;
		this.twohangye = twohangye;
	}
	
}
