package yang.muyun.service.impl;

        import yang.muyun.dao.IAccountDao;
        import yang.muyun.dao.impl.AccountDaoImpl;
        import yang.muyun.factory.BeanFactory;
        import yang.muyun.service.IAccountService;

// 账户业务层实现类
public class AccountServiceImpl implements IAccountService {

    // IAccountDao accountDao = new AccountDaoImpl();
    IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
