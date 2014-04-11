package cn.com.sway.cms.archive.dao.impl;

import org.springframework.stereotype.Repository;


import cn.com.sway.cms.archive.dao.ArchiveDao;
import cn.com.sway.cms.archive.model.Archive;
import cn.com.sway.generic.dao.impl.AbstractGenericDaoImpl;

@Repository("archiveDao")
public class ArchiveDaoImpl extends AbstractGenericDaoImpl<Archive, String> implements ArchiveDao {

}
