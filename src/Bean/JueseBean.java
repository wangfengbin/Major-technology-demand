package Bean;

public class JueseBean {
	
	private String id;
	private String juese;
	private String quanxian;//Ȩ�޹���
	private String wangluo;//�������
	private String xuqiu;//�������
	private String upmima;//�޸�����
	private String sel;//��ѯͳ��Ȩ��
	private String addneed;//��������Ȩ��
	private String dealneed;//�������
	private String userinfo;//�û���Ϣ
	private String weishenhe;
	private String tongguo;
	private String tuihui;
	public JueseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getWangluo() {
		return wangluo;
	}

	public void setWangluo(String wangluo) {
		this.wangluo = wangluo;
	}

	public String getXuqiu() {
		return xuqiu;
	}

	public void setXuqiu(String xuqiu) {
		this.xuqiu = xuqiu;
	}

	public String getUpmima() {
		return upmima;
	}

	public void setUpmima(String upmima) {
		this.upmima = upmima;
	}

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}

	public String getAddneed() {
		return addneed;
	}

	public void setAddneed(String addneed) {
		this.addneed = addneed;
	}

	public String getDealneed() {
		return dealneed;
	}

	public void setDealneed(String dealneed) {
		this.dealneed = dealneed;
	}

	public String getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJuese() {
		return juese;
	}
	public void setJuese(String juese) {
		this.juese = juese;
	}
	public String getQuanxian() {
		return quanxian;
	}
	public void setQuanxian(String quanxianid) {
		this.quanxian = quanxianid;
	}
	public String getWeishenhe() {
		return weishenhe;
	}

	public void setWeitongguo(String weishenhe) {
		this.weishenhe = weishenhe;
	}

	public String getTongguo() {
		return tongguo;
	}

	public void setTongguo(String tongguo) {
		this.tongguo = tongguo;
	}

	public String getTuihui() {
		return tuihui;
	}

	public void setTuihui(String tuihui) {
		this.tuihui = tuihui;
	}

	
	@Override
	public String toString() {
		return "JueseBean [id=" + id + ", juese=" + juese + ", quanxian=" + quanxian + ", wangluo=" + wangluo
				+ ", xuqiu=" + xuqiu + ", upmima=" + upmima + ", sel=" + sel + ", addneed=" + addneed + ", dealneed="
				+ dealneed + ", userinfo=" + userinfo + ", weitongguo=" + weishenhe + ", tongguo=" + tongguo
				+ ", tuihui=" + tuihui + "]";
	}
	//�������ݿ�
	public JueseBean(String juese, String wangluo, String xuqiu, String upmima, String addneed,
			String dealneed, String userinfo, String weishenhe, String tongguo, String tuihui) {
		super();
		this.juese = juese;
		this.wangluo = wangluo;
		this.xuqiu = xuqiu;
		this.upmima = upmima;
		//this.sel = sel;
		this.addneed = addneed;
		this.dealneed = dealneed;
		this.userinfo = userinfo;
		this.weishenhe = weishenhe;
		this.tongguo = tongguo;
		this.tuihui = tuihui;
	}
	//�����ݿ��л�ȡ
	public JueseBean(String id, String juese, String wangluo, String xuqiu, String upmima, String addneed,
			String dealneed, String userinfo, String weishenhe, String tongguo, String tuihui) {
		super();
		this.id = id;
		this.juese = juese;
		this.wangluo = wangluo;
		this.xuqiu = xuqiu;
		this.upmima = upmima;
		//this.sel = sel;
		this.addneed = addneed;
		this.dealneed = dealneed;
		this.userinfo = userinfo;
		this.weishenhe = weishenhe;
		this.tongguo = tongguo;
		this.tuihui = tuihui;
	}
	
	
	
	

}
