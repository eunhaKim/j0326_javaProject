package mall;

public class ProductVo {
	private int pIdx, pCnt, pPrice;
	private String pPic, pName, pInfo;
	
	public int getpIdx() {
		return pIdx;
	}
	public void setpIdx(int pIdx) {
		this.pIdx = pIdx;
	}
	public int getpCnt() {
		return pCnt;
	}
	public void setpCnt(int pCnt) {
		this.pCnt = pCnt;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public String getpPic() {
		return pPic;
	}
	public void setpPic(String pPic) {
		this.pPic = pPic;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpInfo() {
		return pInfo;
	}
	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	}
	@Override
	public String toString() {
		return "ProductVo [pIdx=" + pIdx + ", pCnt=" + pCnt + ", pPrice=" + pPrice + ", pPic=" + pPic + ", pName=" + pName
				+ ", pInfo=" + pInfo + "]";
	}
	
}
