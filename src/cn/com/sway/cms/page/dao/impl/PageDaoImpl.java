package cn.com.sway.cms.page.dao.impl;

import org.springframework.stereotype.Repository;


import cn.com.sway.cms.page.dao.PageDao;
import cn.com.sway.cms.page.model.Page;
import cn.com.sway.generic.dao.impl.AbstractGenericDaoImpl;

@Repository("pageDao")
public class PageDaoImpl extends AbstractGenericDaoImpl<Page, String> implements PageDao {

}
