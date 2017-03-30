package com.aotu.interceptor.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.aotu.entity.system.User;
import com.aotu.service.IUserService;

/**
 * 登录控制
 */
@SuppressWarnings("all")
public class ShiroRealm extends AuthorizingRealm {
	
	@Resource(name="userService")
	private IUserService userService;
	
	/**
	 * 登录信息和用户验证信息验证
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		try {
			UsernamePasswordToken upToken = (UsernamePasswordToken) token; //将参数token转换成它的子类, 再获取用户名
			String userName = upToken.getUsername(); //获取用户在表单上输入的用户名
			User userTemp = new User();
			userTemp.setUserName(userName);
			List<User> userList = this.userService.queryList(userTemp);
			 
			if(null != userList && userList.size() > 0) {
				User user = (User)userList.get(0);
				SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
				return info;
			}
			return null;
		} catch(Exception e) {
			throw new AuthenticationException(e);
		}
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		return null;
	}

}
