package com.sanyuan.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanyuan.mapper.SanyuanUserMapper;
import com.sanyuan.pojo.SanyuanUser;
import com.sanyuan.pojo.YiyuanUser;
import com.sanyuan.utils.CookieUtils;
import com.sanyuan.utils.GlobalConst;
import com.sanyuan.utils.JsonUtils;
import com.sanyuan.utils.RedisUtils;
@Component
public class UserInfoFilter implements Filter{

	@Autowired
	private SanyuanUserMapper userMapper;
	@Autowired
	private RedisUtils redisUtils;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
		
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		String ticket=redisUtils.get(CookieUtils.getCookieValue(request, GlobalConst.YY_COOKIE_NAME));
		if(ticket==null||"".equals(ticket)||" ".equals(ticket)||"null".equals(ticket)) {
			chain.doFilter(request, response);
			return;
		}
		YiyuanUser user = JsonUtils.jsonToPojo(ticket,YiyuanUser.class);
		
		SanyuanUser suser= userMapper.selectByPrimaryKey(user.getUserId());
		
		if(suser.getUserName()==null||suser.getIdentity()==null) {
			response.sendRedirect("userInfo");
		}else {
			chain.doFilter(request, response);
		}
		
	}

}
