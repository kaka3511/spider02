package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.SimpleFormatter;

import org.junit.Test;

import entitys.Chapter;
import impl.AbstractChapterSpider;
import impl.DefaultChapterSpider;

public class TestCase {
	
	public void fun1(){
		AbstractChapterSpider spider = new DefaultChapterSpider();
		List<Chapter> list = spider.getChapter("http://book.zongheng.com/showchapter/626779.html");
		List<String> listString = new ArrayList<String>();
		
//		测试获取章节标题和href
		for(Chapter item:list){
			System.out.println(item);
		}
		
	}
	

	
	public void fun2(String url,int baseI){
		AbstractChapterSpider spider = new DefaultChapterSpider();
		String baseUrl = url;
		Set<String> picUrls = spider.getPicUrls(baseUrl);
		int i = 1;
		for(String item:picUrls){
			//每个美女图片的页面地址
			List<String> listSpecificPicUrls = spider.getSpecificPicUrls(item);
			DefaultChapterSpider dSpider = new DefaultChapterSpider();		
			for(String o:listSpecificPicUrls){
				System.out.println("正在保存该图片     ->  "+o);
				//每张图片的真实地址
				String picRealUrl = spider.getPicUrl(o);
				try {
					dSpider.saveFile(picRealUrl,i,baseI);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			i++;
		}
	}
	
//	测试15yc.com
	
	public void fun3(){
		String startUrl = "http://www.15yc.com/type/20";
		for(int i=8;i<=9;i++){
			String url = startUrl + "/" + i + ".html";
			fun2(url,i);
		}
	}
//	测试看书中
	
	public void fun4() throws Exception{
		//雪鹰领主
		String url = "http://www.kanshuzhong.com/book/92701/";
		AbstractChapterSpider spider = new DefaultChapterSpider();
		List<String> chapterUrls = spider.getChapterForKSZ(url);
		DefaultChapterSpider dSpider = new DefaultChapterSpider();	
		int i =1;
		for(String o:chapterUrls){
			i++;
			String content = spider.getContentForKSZ(o);
//			dSpider.saveTxtFile(content);
			if(i == 1230)
				System.out.println(content);
		}
		System.out.println(chapterUrls.size());
//		String content = spider.getContentForKSZ("http://www.kanshuzhong.com/book/92701/16044208.html");
//		System.out.println(spider.getContentForKSZ("http://www.kanshuzhong.com/book/92701/16044208.html"));
	}
	
//	测试多线程
	
	public void fun5(){
		ExecutorService service = Executors.newFixedThreadPool(30);
		List<Future<String>> tasks = new ArrayList<>();
		String basePath = "D:/1/";
		for (int i=0;i<30;i++) {
			tasks.add(service.submit(new DownloadCallable(basePath+i+ ".txt")));
		}
		service.shutdown();
		
		
	}
	
	class DownloadCallable implements Callable<String>{
		String path;		
		public DownloadCallable(String path) {
			this.path = path;
		}
		@Override
		public String call() throws Exception {
			try {
				File f = new File(path);
				if (!f.exists()) {
					f.createNewFile();
				}
				FileWriter fw = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fw);
				Random random = new Random();
				pw.append(path);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public void fun6() throws Exception{
		String s = "12-11-23";
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		Date date = format.parse(s);
		System.out.println(date.toLocaleString());
		
	}
	
	@Test
	public void fun7(){
		for(int j=0;j<3;j++){
			try{
				int k = 10/0;
			}catch (Exception e){				
				System.out.println("exception");
			}
		}
		System.out.println("3 times over!");
	}
	
	
}
