package interfaces;


import java.util.List;

import entitys.Chapter;
import entitys.ChapterContent;

public interface IChapterSpider {
	public List<Chapter> getChapter(String url);
	public String getPicUrl(String url);
}