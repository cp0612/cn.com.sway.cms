package cn.com.sway.cms.archiveAddonShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.com.sway.cms.archiveAddonShop.dao.ArchiveAddonShopDao;
import cn.com.sway.cms.archiveAddonShop.model.ArchiveAddonShop;
import cn.com.sway.cms.archiveAddonShop.service.ArchiveAddonShopService;
import cn.com.sway.generic.dao.AbstractGenericDao;
import cn.com.sway.generic.service.impl.AbstractGenericServiceImpl;


@Service("archiveAddonShopService")
public class ArchiveAddonShopServiceImpl extends AbstractGenericServiceImpl<ArchiveAddonShop, String> implements ArchiveAddonShopService{
	
	private ArchiveAddonShopDao archiveAddonShopDao;
	
	@Autowired
    @Qualifier("archiveAddonShopDao")
    @Override
    public void setAbstractGenericDao(AbstractGenericDao<ArchiveAddonShop, String> archiveAddonShopDao) {
        this.abstractGenericDao = archiveAddonShopDao;
        this.archiveAddonShopDao = (ArchiveAddonShopDao) archiveAddonShopDao;
    }

}
