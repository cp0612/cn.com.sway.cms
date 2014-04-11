package cn.com.sway.cms.account.dao.impl;

import org.springframework.stereotype.Repository;


import cn.com.sway.cms.account.dao.AccountDao;
import cn.com.sway.cms.account.model.Account;
import cn.com.sway.generic.dao.impl.AbstractGenericDaoImpl;

@Repository("accountDao")
public class AccountDaoImpl extends AbstractGenericDaoImpl<Account, String> implements AccountDao {

}
