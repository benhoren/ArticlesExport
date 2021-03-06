import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * http://www.bbc.com/news
 * @author benho
 *
 */
public class BBC extends Site{

	public BBC(String tts, String ttc, int noa, SearchState stat, String sd, String ed) {
		super(tts, ttc, noa, stat, sd,ed);
		this.url="http://www.bbc.com/news";
		this.window = WindowState.Invisible;
		this.DateRange = false;
		this.page = new BBCPage(window, this);
	}


	@Override
	public boolean search() {

		driver = startWebDriver(url);
//		sleep(2000);
//		driver.get(url);
		sleep(10000);

		try {
			WebElement field = driver.findElement(By.xpath("//*[@id='orb-search-q']"));
			field.click();
			field.clear();
			field.sendKeys(this.textToSearch);

			WebElement button = driver.findElement(By.xpath("//*[@id='orb-search-button']"));

			button.click();

		}catch(Exception e) {e.printStackTrace(); sleep(5000); return false;}



		try {
			WebElement news = driver.findElement(By.xpath("//*[@class='filters-content']"))
					.findElement(By.xpath(".//*[@class='filter-news']"));

			news.click();

		}catch(Exception e) {e.printStackTrace(); sleep(5000); return false;}

		return true;
	}



	/* 
	 * (non-Javadoc)
	 * @see Site#resultsPage(java.util.List)
	 * long result page.
	 */
	
	@Override
	public void resultsPage(List<String> urls) {


		WebElement searchcontent = driver.findElement(By.className("search-content"));

	
		ArrayList<WebElement> results  = (ArrayList<WebElement>) 
				searchcontent.findElements(By.xpath(".//*[@class='search-results results']/li"));


		String link="", title="" , date="";
		int i=0;
		int checks = 0;
		int res =0;
		boolean addLink=false;
		try{
			while(urls.size() < numOfArticles){
				link=""; title=""; date="";
				addLink=false;

				checks++;
				if(checks == maxSearch)
					return;

				if(i<results.size()){
					String type ="";
					try{
						WebElement head = results.get(i)
								.findElement(By.xpath(".//*[@itemprop='headline']/a"));

						title = head.getText();
						link = head.getAttribute("href");

						WebElement dt = results.get(i)
								.findElement(By.xpath(".//*[@class='display-date']"));
 
						date = dt.getText();
						String[] arr = date.split(" ");
						String month = ""+monthToInt(arr[1]);
						date = arr[0]+"."+month+"."+arr[2];

						System.out.println(link);
						System.out.println(title);


						WebElement tp  = results.get(i).findElement(By.tagName("article"));
						type = tp.getAttribute("class");
					}catch(Exception e){e.printStackTrace();}

					if((!type.contains("video"))&&(!url.contains("live"))) {
						try{
							String s = this.toDate;
							addLink = stateHandle(link, title, date);
							if(!s.equals(this.toDate))
								i=0;
						}catch(Exception e){e.printStackTrace();addLink=false;}
					}
					else addLink=false;

					if(addLink){
						urls.add(link);
						removeDuplicate(urls);
						mainScreen.addToLog(urls.size()+"/"+this.numOfArticles);
					}
					i++;
				}

				if(i>=results.size()){
					int size= results.size();
					clickLoadMore();
					results  = (ArrayList<WebElement>) 
							searchcontent.findElements(By.xpath(".//*[@class='search-results results']/li"));		

					if(size == results.size()) {
						sleep(2000);
						res++;
					}
					else res = 0;
					if(res >= 10){
						System.out.println(driver.getCurrentUrl());
//						sleep(1000000);
						System.out.println("NOMORE?");
						String s = this.toDate;
						updateToDate(true);
						if(s.equals(this.toDate))
							break;
						res = 0;
						i=0;
					}
				}
			}
		}catch(Exception e){ e.printStackTrace();return;}
	}


	private void clickLoadMore() {
		try {
			WebElement more = driver.findElement(By.xpath("//*[@class='pagination']/a"));

			moveTo2(driver, more);

			sleep(1000);
			more.click();
//			clickInvisible(driver, more);
			sleep(1000);

		}catch(Exception e) {e.printStackTrace();clickInvisible(driver, driver.findElement(By.xpath("//*[@class='pagination']/a")));}

	}

}
