import Classes.*;

public class Driver {

	public static void main(String[] args) {
		YouTubeDownload download = null;
		try {
			download = new YouTubeDownload();
			String filepath = System.getProperty("user.dir");
			filepath = filepath + "\\MusicList.txt";
			download.readTextDocument(filepath);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			download.driver.quit();
		}
		
	}	
}
