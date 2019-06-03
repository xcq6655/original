package com.xcq.original.config;

import com.xcq.original.entity.Menu;
import com.xcq.original.entity.Role;
import com.xcq.original.entity.User;
import com.xcq.original.mapper.MenuMapper;
import com.xcq.original.mapper.RoleMapper;
import com.xcq.original.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义Realm
 * @author zjt
 *
 */
public class MyRealm extends AuthorizingRealm{

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private MenuMapper menuMapper;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName=(String) SecurityUtils.getSubject().getPrincipal();

        //User user=userRepository.findByUserName(userName);
        //根据用户名查询出用户记录
        User user=userMapper.selectUserByUsername(userName).get(0);


        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        //List<Role> roleList=roleRepository.findByUserId(user.getId());
        List<Role> roleList = roleMapper.selectRolesByUserId(user.getId());

        Set<String> roles=new HashSet<String>();
        if(roleList.size()>0){
            for(Role role:roleList){
                roles.add(role.getName());
                //List<Tmenu> menuList=menuRepository.findByRoleId(role.getId());
                //根据角色id查询所有资源
                List<Menu> menuList=menuMapper.selectMenusByRoleId(role.getId());
                for(Menu menu:menuList){
                    info.addStringPermission(menu.getName()); // 添加权限
                }
            }
        }
        info.setRoles(roles);
        return info;
    }

    /**
     * 权限认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username=(String)token.getPrincipal();
        User user=userMapper.selectUserByUsername(username).get(0);
        if(user!=null){
            AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),"xxx");
            return authcInfo;
        }else{
            return null;
        }
    }

}
