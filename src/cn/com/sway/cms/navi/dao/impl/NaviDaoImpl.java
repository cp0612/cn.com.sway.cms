package cn.com.sway.cms.navi.dao.impl;

import org.springframework.stereotype.Repository;


import cn.com.sway.cms.navi.dao.NaviDao;
import cn.com.sway.cms.navi.model.Navi;
import cn.com.sway.generic.dao.impl.AbstractGenericDaoImpl;

@Repository("naviDao")
public class NaviDaoImpl extends AbstractGenericDaoImpl<Navi, String> implements NaviDao {

}
