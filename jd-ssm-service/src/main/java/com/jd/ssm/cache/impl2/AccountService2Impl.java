package com.jd.ssm.cache.impl2;

import com.google.common.base.Optional;
import com.jd.ssm.cache.Account;
import com.jd.ssm.cache.AccountService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by wangyingjie1 on 2016/12/22.
 */
@Service("accountService2Impl")
public class AccountService2Impl implements AccountService2 {

    private final Logger logger = LoggerFactory.getLogger(AccountService2Impl.class);

    // 使用了一个缓存名叫 accountCache
    @Cacheable(value = "accountCache")
    public Account getAccountByName(String accountName) {

        // 方法内部实现不考虑缓存逻辑，直接实现业务
        logger.info("real querying account... {}", accountName);

        Optional<Account> accountOptional = getFromDB(accountName);

        if (!accountOptional.isPresent()) {
            throw new IllegalStateException(String.format("can not find account by account name : [%s]", accountName));
        }

        return accountOptional.get();
    }

    private Optional<Account> getFromDB(String accountName) {

        logger.info("real querying db... {}", accountName);

        //Todo query data from database
        return Optional.fromNullable(new Account(accountName));
    }

}
