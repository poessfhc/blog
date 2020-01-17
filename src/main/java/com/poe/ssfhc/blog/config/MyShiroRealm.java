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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: MyShiroRealm
 * @Description: 权限授权认证
 * @Author: Vince
 * @Date: 2020/1/17 14:30
 * @Version: v1.0
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 授权
     *
     * @param principalCollection 身份集合
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        List<Role> roles = roleMapper.selectByPrimaryKey(user.getUserId());
        List<Menu> menus = menuMapper.selectByPrimaryKey(user.getUserId());
        simpleAuthorizationInfo.addRoles(roles.stream().map(Role::getRoleName).collect(Collectors.toSet()));
        simpleAuthorizationInfo.addStringPermissions(menus.stream().map(Menu::getPerms).collect(Collectors.toSet()));
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param authenticationToken token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = userMapper.getUserByUsername(username);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName()
        );
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", user);
        return simpleAuthenticationInfo;
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
