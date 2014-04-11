package cn.com.sway.cms.archiveType.dao.impl;

import org.springframework.stereotype.Repository;


import cn.com.sway.cms.archiveType.dao.ArchiveTypeDao;
import cn.com.sway.cms.archiveType.model.ArchiveType;
import cn.com.sway.generic.dao.impl.AbstractGenericDaoImpl;

@Repository("archiveTypeDao")
public class ArchiveTypeDaoImpl extends AbstractGenericDaoImpl<ArchiveType, String> implements ArchiveTypeDao {

}
