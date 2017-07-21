package impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entitys.Chapter;
import entitys.ChapterContent;
import interfaces.IChapterSpider;

public abstract class AbstractChapterSpider implements IChapterSpider {

	public static String crawl(String url) throws Exception {
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build();
				CloseableHttpResponse httpResponse = httpClient.execute(new HttpGet(url));) {
			String result = EntityUtils.toString(httpResponse.getEntity(),"gbk");
			return result;
		}
	}

	@Override
	public List<Chapter> getChapter(String url) {
		String result = null;
		List<Chapter> list = new ArrayList<Chapter>();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		try {
			result = crawl(url);
			Document doc = Jsoup.parse(result);
			Elements as1 = doc.select(".chapterBean");
			Elements as2 = doc.select("div table tr td a");
			for (Element item : as1) {
				list1.add(item.attr("chaptername"));
			}
			for (Element item : as2) {
				list2.add(item.attr("href"));
			}
			int length = list1.size();
			for (int i = 0; i < length; i++) {
				Chapter chapter = new Chapter();
				chapter.setTitle(list1.get(i));
				chapter.setUrl(list2.get(i));
				list.add(chapter);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 获取图片地址
	@Override
	public String getPicUrl(String url) {
		String result = null;
		try {
			result = crawl(url);
			Document doc = Jsoup.parse(result);
			Elements as = doc.select(".playpic img");
			Element as0 = as.get(0);
			String str = as0.attr("src");
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 得到当前页下所有美女图片的根地址
	public Set<String> getPicUrls(String url) {
		Set<String> resultUrls = new LinkedHashSet<String>();
		String result = null;
		try {
			result = crawl(url);
			Document doc = Jsoup.parse(result);
			Elements as = doc.select("div div div div div a");
			for (Element e : as) {
				resultUrls.add("http://www.15yc.com" + e.attr("href"));
			}
			return resultUrls;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 得到特定美女所有图片的地址集合
	public List<String> getSpecificPicUrls(String url) {
		int i = 0;
		List<String> resultUrls = new ArrayList<String>();
		String result = null;
		try {
			result = crawl(url);
			Document doc = Jsoup.parse(result);
			Elements as = doc.select("div div div div ul li a");
			for (Element e : as) {
				i++;
				if (i >= 3)
					resultUrls.add("http://www.15yc.com" + e.attr("href"));
			}
			return resultUrls;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	获取看书中雪鹰领主的每个章节url
	public List<String> getChapterForKSZ(String url) {
		String result = null;
		List<String> list = new ArrayList<String>();
		try {
			result = crawl(url);
			Document doc = Jsoup.parse(result);
			Elements as = doc.select(".bookcontent dl dd a");
			for(Element o:as)
				list.add(url+ o.attr("href"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
//	获取看书中雪鹰领主的每个章节内容
	public String getContentForKSZ(String url) {
		String result = null;
		try {
			result = crawl(url);
			Document doc = Jsoup.parse(result);
			Elements as = doc.select(".textcontent");
			Elements noAs = doc.select(".textcontent div");
			String content = "";
			content = as.get(0).html();
			String ad1 = noAs.toString().substring(0, noAs.toString().indexOf("</div>")+6);
			String ad2 = noAs.toString().substring(noAs.toString().indexOf("</div>")+6);
			int ad1Index = content.indexOf(ad1);
			int ad2Index = content.indexOf(ad2);
			//去除首尾div标签
			content = content.substring(ad1Index+52, ad2Index);
			//&nbsp;  <br>去除
			content = content.replaceAll("&nbsp;", "");
			content = content.replaceAll("<br>", "\r\n");
			return content;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
