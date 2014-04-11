package cn.com.sway.cms.page.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.com.sway.cms.page.dao.PageDao;
import cn.com.sway.cms.page.model.Page;
import cn.com.sway.cms.page.service.PageService;
import cn.com.sway.generic.dao.AbstractGenericDao;
import cn.com.sway.generic.service.impl.AbstractGenericServiceImpl;


@Service("pageService")
public class PageServiceImpl extends AbstractGenericServiceImpl<Page, String> implements PageService{
	
	private PageDao pageDao;
	
	@Autowired
    @Qualifier("pageDao")
    @Override
    public void setAbstractGenericDao(AbstractGenericDao<Page, String> pageDao) {
        this.abstractGenericDao = pageDao;
        this.pageDao = (PageDao) pageDao;
    }

}
