package cn.com.sway.cms.archive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.com.sway.cms.archive.dao.ArchiveDao;
import cn.com.sway.cms.archive.model.Archive;
import cn.com.sway.cms.archive.service.ArchiveService;
import cn.com.sway.generic.dao.AbstractGenericDao;
import cn.com.sway.generic.service.impl.AbstractGenericServiceImpl;


@Service("archiveService")
public class ArchiveServiceImpl extends AbstractGenericServiceImpl<Archive, String> implements ArchiveService{
	
	private ArchiveDao archiveDao;
	
	@Autowired
    @Qualifier("archiveDao")
    @Override
    public void setAbstractGenericDao(AbstractGenericDao<Archive, String> archiveDao) {
        this.abstractGenericDao = archiveDao;
        this.archiveDao = (ArchiveDao) archiveDao;
    }

}
