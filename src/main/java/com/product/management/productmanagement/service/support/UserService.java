package com.product.management.productmanagement.service.support;

import com.product.management.productmanagement.entity.Product;
import com.product.management.productmanagement.entity.User;
import com.product.management.productmanagement.entity.support.ActionLog;
import com.product.management.productmanagement.exception.ExceptionCode;
import com.product.management.productmanagement.exception.support.DuplicateObjectPmException;
import com.product.management.productmanagement.exception.support.NotFoundObjectPmExcpetion;
import com.product.management.productmanagement.repository.IUserRepository;
import com.product.management.productmanagement.service.AbstractUserService;
import com.product.management.productmanagement.service.ILogService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class UserService extends AbstractUserService<User, String> {

    public UserService(JpaRepository<User, String> jpaRepository, ILogService<ActionLog, String> logRepository) {
        super(jpaRepository, logRepository);
    }

    @Override
    public Collection<User> loadAll() {
        return getUserRepository().findAll();
    }

    @Override
    public User getOneByKey(String key) throws NotFoundObjectPmExcpetion {
        Optional<User> userOptional = getUserRepository().findById(key);
        if(!userOptional.isPresent())
            throw new NotFoundObjectPmExcpetion(ExceptionCode.NOT_FOUND_USER_BY_ID.getCode(),ExceptionCode.NOT_FOUND_USER_BY_ID.getCode());
        return userOptional.get();
    }

    @Override
    public User add(User object) throws DuplicateObjectPmException {
        checkDuplicateDataInsert(object);
        return save(object);
    }

    private void checkDuplicateDataInsert(User object) throws DuplicateObjectPmException {
        if(getUserRepository().countByUsername(object.getUsername()) > 0)
            throw new DuplicateObjectPmException(ExceptionCode.USER_NAME_EXISTS.getCode(), ExceptionCode.USER_NAME_EXISTS.getMessage());
        if(getUserRepository().countByEmail(object.getEmail()) > 0)
            throw new DuplicateObjectPmException(ExceptionCode.EMAIL_EXISTS.getCode(), ExceptionCode.EMAIL_EXISTS.getMessage());
    }

    @Override
    public User edit(User object) throws NotFoundObjectPmExcpetion, DuplicateObjectPmException {
        User userDb = getOneByKey(object.getUsername());
        checkNameDuplicate(userDb,object);
        return save(object);
    }

    private void checkNameDuplicate(User userDb, User object) throws DuplicateObjectPmException {
        if(!object.getEmail().equals(userDb.getEmail()) && getUserRepository().countByEmail(object.getEmail()) > 0)
            throw new DuplicateObjectPmException(ExceptionCode.EMAIL_EXISTS.getCode(), ExceptionCode.EMAIL_EXISTS.getMessage());
    }

    @Override
    public User delete(String key) throws NotFoundObjectPmExcpetion {
        User userDb = getOneByKey(key);
        getUserRepository().delete(userDb);
        return userDb;
    }

    private User save(User user) {
        return getUserRepository().save(user);
    }

    private IUserRepository getUserRepository() {
        return (IUserRepository) jpaRepository;
    }
}
