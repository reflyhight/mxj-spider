package com.mxj.spider.impl;
import java.util.List;

import javax.management.JMException;

import com.mxj.spider.EnDistriSpider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * 
 * @author Rob Jiang
 * @dat 2018年1月17日
 * @email jh624haima@126.com
 * @blog blog.mxjhaima.com
 */
public class JdSpiderTest implements PageProcessor {

	public void process(Page page) {
		// TODO Auto-generated method stub
		Html html = page.getHtml();
		List<String> all = html.links().regex(".*?item\\.jd\\.com.+").all();
		page.addTargetRequests(all);
		List<String> all2 = html.links().regex(".*?//list\\.jd\\.com/list\\.html\\?cat=.+html$").all();
		page.addTargetRequests(all2);

		System.out.println(page.getUrl());
	}

	public Site getSite() {
		// TODO Auto-generated method stub
		Site site = Site.me();
		site.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
		site.setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);
		return site;
	}

	public static void main(String[] args) {
		
		EnDistriSpider spider= new EnDistriSpider(new JdSpiderTest());
		spider.thread(5);
		spider.addUrl("https://list.jd.com/list.html?cat=9987,653,655");
		
		spider.run();

		try {
			SpiderMonitor.instance().register(spider);
			spider.start();
		} catch (JMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
