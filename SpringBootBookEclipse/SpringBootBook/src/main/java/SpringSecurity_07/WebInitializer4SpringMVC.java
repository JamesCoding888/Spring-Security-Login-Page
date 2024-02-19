//package SpringSecurity_07;
//
//import java.util.Date;
//
//import javax.servlet.Filter;
//import javax.servlet.ServletContext;
//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//import com.example.CustomFilter1;
//import com.example.CustomFilter2;
//
//public class WebInitializer4SpringMVC extends AbstractSecurityWebApplicationInitializer {
//	
//	@Override
//	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
//		System.out.println(new Date() + " - " + "beforeSpringSecurityFilterChain");
//	    // Create your filters
//	    Filter filter1 = (Filter) new CustomFilter1();
//	    Filter filter2 = (Filter) new CustomFilter2();
//
//	    // Insert filters before existing filters
//	    insertFilters(servletContext, filter1, filter2);
//
//	    // Alternatively, you can append filters after existing filters
//	    // appendFilters(servletContext, filter1, filter2);
//	}
//
///*
//	@Override
//	protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
//	    // Create your filters
//		Filter filter1 = (Filter) new CustomFilter1();
//	    Filter filter2 = (Filter) new CustomFilter2();
//
//	    // Insert filters before existing filters
//	    insertFilters(servletContext, filter1, filter2);
//
//	    // Alternatively, you can append filters after existing filters
//	    // appendFilters(servletContext, filter1, filter2);
//	}
//*/
//	
//}
