package cn.com.sway.cms.archiveType.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.com.sway.cms.archiveType.dao.ArchiveTypeDao;
import cn.com.sway.cms.archiveType.model.ArchiveType;
import cn.com.sway.cms.archiveType.service.ArchiveTypeService;
import cn.com.sway.generic.dao.AbstractGenericDao;
import cn.com.sway.generic.service.impl.AbstractGenericServiceImpl;


@Service("archiveTypeService")
public class ArchiveTypeServiceImpl extends AbstractGenericServiceImpl<ArchiveType, String> implements ArchiveTypeService{
	
	private ArchiveTypeDao archiveTypeDao;
	
	@Autowired
    @Qualifier("archiveTypeDao")
    @Override
    public void setAbstractGenericDao(AbstractGenericDao<ArchiveType, String> archiveTypeDao) {
        this.abstractGenericDao = archiveTypeDao;
        this.archiveTypeDao = (ArchiveTypeDao) archiveTypeDao;
    }

}
