package Bean;

public class PagingBean {
	private int totalCount;  //�ܵļ�¼��
	private int pageCount;   //��ǰҳ
	private int currentPage;//һҳ����������
	private int countPerPage;
	private String prefixUrl;
	//true��ʱ����&�����ǣ�
	private boolean isAnd;
	
	public PagingBean(int currentPage,int totalCount,int countPerpage)
	{
		this.countPerPage = countPerpage;
		pageCount = (totalCount - 1) / countPerpage + 1;
		if(currentPage >= pageCount)
		{
			currentPage = pageCount - 1;
		}
		if (currentPage< 0) 
		{
			currentPage = 0;
		}
		this.totalCount = totalCount;
		this.currentPage = currentPage; 
	}
	public PagingBean() { }
	
	public int getCurrentPage() 
	{
		return currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCountPerPage() {
		return countPerPage;
	}
	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
	public String getPrefixUrl() {
		return prefixUrl;
	}
	public void setPrefixUrl(String prefixUrl) {
		this.prefixUrl = prefixUrl;
	}
	public boolean isAnd() {
		return isAnd;
	}
	public void setAnd(boolean isAnd) {
		this.isAnd = isAnd;
	}
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "PagingBean [totalCount=" + totalCount + ", pageCount=" + pageCount + ", currentPage=" + currentPage
				+ ", countPerPage=" + countPerPage + ", prefixUrl=" + prefixUrl + ", isAnd=" + isAnd + "]";
	}

}
