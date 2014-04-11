package cn.com.sway.cms.navi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.com.sway.cms.navi.dao.NaviDao;
import cn.com.sway.cms.navi.model.Navi;
import cn.com.sway.cms.navi.service.NaviService;
import cn.com.sway.generic.dao.AbstractGenericDao;
import cn.com.sway.generic.service.impl.AbstractGenericServiceImpl;


@Service("naviService")
public class NaviServiceImpl extends AbstractGenericServiceImpl<Navi, String> implements NaviService{
	
	private NaviDao naviDao;
	
	@Autowired
    @Qualifier("naviDao")
    @Override
    public void setAbstractGenericDao(AbstractGenericDao<Navi, String> naviDao) {
        this.abstractGenericDao = naviDao;
        this.naviDao = (NaviDao) naviDao;
    }

}
