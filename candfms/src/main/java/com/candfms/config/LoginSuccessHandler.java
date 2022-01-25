package com.candfms.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication) {
		String url = "/login?error=true";
		// fetch the role from authontication object

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		List<String> roles = new ArrayList<String>();

		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}

		// check user role and decide the redirect url
		if (roles.contains("ADMIN")) {
			url = "/faculty/index";
		} else if (roles.contains("INSTRUCTOR")) {
			url = "/faculty/index";

		} else if (roles.contains("CHAIR_HOLDER")) {
			url = "/faculty/index";

		} else if (roles.contains("COURSE_CHAIR")) {
			url = "/faculty/index";

		} else if (roles.contains("STUDENT")) {
			url = "/faculty/index";
		} else if (roles.contains("APO")) {
			url = "/faculty/index";
		} else if (roles.contains("QUALITY")) {
			url = "/faculty/index";
		} else if (roles.contains("DEAN")) {
			url = "/faculty/index";
		}

		
		
		
		else if (roles.contains("ASSISTANT")) {
			url = "/faculty/index";
		}

		else if (roles.contains("ADVISOR")) {
			url = "/faculty/index";
		}

		return url;

	}

}

//@Component
//public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
// 
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//            Authentication authentication) throws ServletException, IOException {
// 
//        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
//         
//        String redirectURL = request.getContextPath();
//         
//		/*
//		 * if (userDetails.hasRole("Salesperson")) { redirectURL = "sales_home"; } else
//		 * if (userDetails.hasRole("Editor")) { redirectURL = "editor_home"; } else if
//		 * (userDetails.hasRole("Shipper")) { redirectURL = "shipper_home"; }
//		 */
//        response.sendRedirect(redirectURL);
//         
//    }
// 
//}