package springmvctest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("springmvctest")
@EnableWebMvc // 开启web mvc基础设施支持
public class AppConfig extends WebMvcConfigurerAdapter {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// book-list -> /WEB-INF/jsp/book-list.jsp
		// 对于控制器方法返回的字符串，会用以下规则解析成jsp路径，然后forward
		// 前缀 + 返回字符串 + 后缀 = jsp路径
		//            前缀                                      后缀
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
}
