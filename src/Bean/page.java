package Bean;

public class page {
	private int sum = 0;		  //数据总条数
	private int pagenum = 0;      //页数
	private int everypage = 10;	  //每页的数量
	private int currentPage = 1;  //当前页
	
	public void initpage() {      //初始化分页
		if(sum%everypage==0)
			pagenum=sum/everypage;
		else 
			pagenum=sum/everypage+1;
		if(sum==0)
			pagenum=1;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getEverypage() {
		return everypage;
	}

	public void setEverypage(int everypage) {
		this.everypage = everypage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "page [sum=" + sum + ", pagenum=" + pagenum + ", everypage=" + everypage + ", currentPage=" + currentPage
				+ "]";
	}
	
	
}
