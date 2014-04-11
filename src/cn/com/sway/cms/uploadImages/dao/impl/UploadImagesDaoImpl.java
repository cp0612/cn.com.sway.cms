package cn.com.sway.cms.uploadImages.dao.impl;

import org.springframework.stereotype.Repository;


import cn.com.sway.cms.uploadImages.dao.UploadImagesDao;
import cn.com.sway.cms.uploadImages.model.UploadImages;
import cn.com.sway.generic.dao.impl.AbstractGenericDaoImpl;

@Repository("uploadImagesDao")
public class UploadImagesDaoImpl extends AbstractGenericDaoImpl<UploadImages, String> implements UploadImagesDao {

}
