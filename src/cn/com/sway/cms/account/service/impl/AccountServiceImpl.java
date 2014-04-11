package cn.com.sway.cms.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.com.sway.cms.account.dao.AccountDao;
import cn.com.sway.cms.account.model.Account;
import cn.com.sway.cms.account.service.AccountService;
import cn.com.sway.generic.dao.AbstractGenericDao;
import cn.com.sway.generic.service.impl.AbstractGenericServiceImpl;


@Service("accountService")
public class AccountServiceImpl extends AbstractGenericServiceImpl<Account, String> implements AccountService{
	
	private AccountDao accountDao;
	
	@Autowired
    @Qualifier("accountDao")
    @Override
    public void setAbstractGenericDao(AbstractGenericDao<Account, String> accountDao) {
        this.abstractGenericDao = accountDao;
        this.accountDao = (AccountDao) accountDao;
    }

}
