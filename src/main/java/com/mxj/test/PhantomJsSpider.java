package com.mxj.test;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.PhantomJSDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

public class PhantomJsSpider  implements PageProcessor{
	
	public static void main(String[] args) {
		
		// PhantomJSDownloader
		Spider spider = Spider.create(new PhantomJsSpider());
		spider.addUrl("https://movie.douban.com/subject_search?search_text=%E8%8B%B1%E9%9B%84%E6%9C%AC%E8%89%B2&cat=1002");
		spider.downloader(new PhantomJSDownloader("D:\\Program Files\\python2.7\\Scripts\\phantomjs.exe","D:\\Program Files\\python2.7\\Scripts\\phjs.js")).thread(4).run();
		
	}

	@Override
	public void process(Page page) {
		// TODO Auto-generated method stub
		Html html = page.getHtml();
		List<String> all = html.$(".rating_nums").all();
		for (String score : all) {
			System.out.println("score"+score);
		}
		
	}

	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return Site.me();
	}

}
