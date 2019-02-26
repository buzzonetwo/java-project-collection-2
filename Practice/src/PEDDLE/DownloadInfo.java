package PEDDLE;

public class DownloadInfo {
	
	private String title;
	private int times;

	public DownloadInfo(String titlex) {
		// TODO Auto-generated constructor stub
		title = titlex;
		times = 1;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void incrementTimesDownloaded() {
		times++;
	}

}
