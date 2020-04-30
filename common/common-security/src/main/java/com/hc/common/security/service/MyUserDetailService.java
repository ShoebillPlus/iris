package com.hc.common.security.service;

import com.hc.common.core.entity.po.SysUser;
import com.hc.feign.RemoteUpmsService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

/**
 * description:auth鉴权service
 *
 * @author yanwei
 * @date 2020/4/2
 */
@Service("userDetailsService")
@AllArgsConstructor
public class MyUserDetailService implements  UserDetailsService {
    private final RemoteUpmsService remoteUpmsService;

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = remoteUpmsService.queryUserInfo(username);
        if (sysUser == null) {
            logger.error("找不到该账号，账号：" + username);
            throw new UsernameNotFoundException("账号：" + username + "不存在！");
        }
        String password = passwordEncoder.encode(sysUser.getLoginPass());
        //String password = sysUser.getLoginPass();
        logger.debug(username);
        logger.debug(sysUser.getLoginPass());
        logger.debug(password);

        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        /* Iterator<String> iterator =  roleDao.getRolesByUserId(userEntity.getId()).iterator();
        while (iterator.hasNext()){
            collection.add(new SimpleGrantedAuthority(iterator.next()));
        }*/

        /*return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));*/
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(sysUser.getLoginAccount(),
                sysUser.getLoginPass(), isEnabled(sysUser.getIsValid()?1:0), true, true, true, collection);

        return new BaseUserDetail(sysUser, user);
    }

    private boolean isEnabled(int isValid) {
        return isValid == 1 ? true : false;
    }

}
