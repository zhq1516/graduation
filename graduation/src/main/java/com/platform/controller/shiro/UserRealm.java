package com.platform.controller.shiro;

import com.platform.dao.UserDao;
import com.platform.model.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserDao userDao;

	/**
	 * 设定Password校验.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		//该句作用是重写shiro的密码验证，让shiro用我自己的验证
		setCredentialsMatcher(new CustomCredentialsMatcher());
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User doc = (User) principals.getPrimaryPrincipal();
		// 角色
		Set<String> r = new HashSet<String>();
		r.add(doc.getRole() + "");
		authorizationInfo.setRoles(r);
		return authorizationInfo;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String loginAccount = token.getUsername();
		char[] password = token.getPassword();
		User user = new User() ;
		// 判断是否填写用户名／密码
		if(StringUtils.isNotBlank(loginAccount) && password != null){
			 user = userDao.login(loginAccount);
		}
		if (user == null) {
			 throw new UnknownAccountException("账号密码错误");//没找到帐号
		}

		// 设置数据权限
		return new SimpleAuthenticationInfo(user, user.getPassword(), user.getLoginAccount());
	}
	private static final String OR_OPERATOR = " or ";
	private static final String AND_OPERATOR = " and ";
	private static final String NOT_OPERATOR = "not ";
	/**
	 * 支持or and not 关键词  不支持and or混用
	 * @param principals
	 * @param permission
	 * @return
	 */
	public boolean isPermitted(PrincipalCollection principals, String permission) {
		if(permission.contains(OR_OPERATOR)) {
			String[] permissions = permission.split(OR_OPERATOR);
			for(String orPermission : permissions) {
				if(isPermittedWithNotOperator(principals, orPermission)) {
					return true;
				}
			}
			return false;
		} else if(permission.contains(AND_OPERATOR)) {
			String[] permissions = permission.split(AND_OPERATOR);
			for(String orPermission : permissions) {
				if(!isPermittedWithNotOperator(principals, orPermission)) {
					return false;
				}
			}
			return true;
		} else {
			return isPermittedWithNotOperator(principals, permission);
		}
	}
	private boolean isPermittedWithNotOperator(PrincipalCollection principals, String permission) {
		if(permission.startsWith(NOT_OPERATOR)) {
			return !super.isPermitted(principals, permission.substring(NOT_OPERATOR.length()));
		} else {
			return super.isPermitted(principals, permission);
		}
	}
}