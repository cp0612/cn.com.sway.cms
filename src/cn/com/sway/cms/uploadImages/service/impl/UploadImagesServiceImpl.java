package cn.com.sway.cms.uploadImages.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.com.sway.cms.uploadImages.dao.UploadImagesDao;
import cn.com.sway.cms.uploadImages.model.UploadImages;
import cn.com.sway.cms.uploadImages.service.UploadImagesService;
import cn.com.sway.generic.dao.AbstractGenericDao;
import cn.com.sway.generic.service.impl.AbstractGenericServiceImpl;


@Service("uploadImagesService")
public class UploadImagesServiceImpl extends AbstractGenericServiceImpl<UploadImages, String> implements UploadImagesService{
	
	private UploadImagesDao uploadImagesDao;
	
	@Autowired
    @Qualifier("uploadImagesDao")
    @Override
    public void setAbstractGenericDao(AbstractGenericDao<UploadImages, String> uploadImagesDao) {
        this.abstractGenericDao = uploadImagesDao;
        this.uploadImagesDao = (UploadImagesDao) uploadImagesDao;
    }

}
