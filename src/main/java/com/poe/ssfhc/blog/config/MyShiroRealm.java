package com.poe.ssfhc.blog.config;


import com.poe.ssfhc.blog.authority.dao.MenuMapper;
import com.poe.ssfhc.blog.authority.dao.RoleMapper;
import com.poe.ssfhc.blog.authority.dao.UserMapper;
import com.poe.ssfhc.blog.authority.domain.Menu;
import com.poe.ssfhc.blog.authority.domain.Role;
import com.poe.ssfhc.blog.authority.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName: MyShiroRealm
 * @Description: 权限授权认证
 * @Author: Vince
 * @Date: 2020/1/17 14:30
 * @Version: v1.0
 */
public class MyShiroRealm extends AuthorizingRealm {
    private final static Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);
    @Autowired
    private UserMapper userMapper;

    /**
     * 权限获取
     *
     * @param principalCollection 身份集合
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) getAvailablePrincipal(principalCollection);
        List<String> roleList = userMapper.getRolesByName(username);
        Set<String> roles = new HashSet<>(roleList);
        List<String> permissionList = userMapper.getPermissionsByRoleName(roleList);
        Set<String> permissions = new HashSet<>(permissionList);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        logger.debug("== >角色:" + String.join(",", roles));
        logger.debug("== >权限:" + String.join(",", permissions));
        return simpleAuthorizationInfo;
    }

    /**
     * 身份验证
     *
     * @param token token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        User user = userMapper.login(username);
        if (user == null) {
            throw new UnknownAccountException();
        } else if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException();
        }
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        return authenticationInfo;
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
