package cn.itsource.mySecurity.interceptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.itsource.mySecurity.annotation.SMPermission;

public class SMPermissionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object)
			throws Exception {
		// 如果不是映射到方法直接通过
		if (!(object instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) object;
		Method method = handlerMethod.getMethod();
		// 检查是否有SMPermission注释，没有则跳过认证
		if (method.isAnnotationPresent(SMPermission.class)) {
			SMPermission SMPermission = method.getAnnotation(SMPermission.class);
			if (SMPermission.required()) {//是否需要权限
				//需要权限的时候，判断用户是否包含该权限
				//①拿到方法上的权限
				String value = SMPermission.value();//"allMenu"
				//从token中拿到用户所有的权限
				String token = request.getHeader("token");
				List<String> permissions =  getAllPermissions(token);
				if (permissions.contains(value)){
					return true;
				}else {
					return false;
				}
			}
		}
		return true;
	}

	private List<String> getAllPermissions(String token) {
		List<String> permissions = new ArrayList<String>();
		permissions.add("allMenu");
		return permissions;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
