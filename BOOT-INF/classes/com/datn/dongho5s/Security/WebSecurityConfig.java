/*    */ package BOOT-INF.classes.com.datn.dongho5s.Security;
/*    */ 
/*    */ import com.datn.dongho5s.Security.AccountFilter;
/*    */ import com.datn.dongho5s.Security.SecurityConfiguration;
/*    */ import javax.servlet.Filter;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.security.authentication.AuthenticationProvider;
/*    */ import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/*    */ import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
/*    */ import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
/*    */ import org.springframework.security.config.http.SessionCreationPolicy;
/*    */ import org.springframework.security.web.SecurityFilterChain;
/*    */ import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ @EnableWebSecurity
/*    */ public class WebSecurityConfig
/*    */ {
/*    */   private final AuthenticationProvider authenticationProvider;
/*    */   private final AccountFilter accountFilter;
/*    */   @Autowired
/*    */   SecurityConfiguration securityConfiguration;
/*    */   
/*    */   public WebSecurityConfig(AuthenticationProvider authenticationProvider, AccountFilter accountFilter) {
/* 29 */     this.authenticationProvider = authenticationProvider;
/* 30 */     this.accountFilter = accountFilter;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Bean
/*    */   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
/* 37 */     return (SecurityFilterChain)((HttpSecurity)((HttpSecurity)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((HttpSecurity)((HttpSecurity)http
/*    */       
/* 39 */       .cors()
/* 40 */       .and())
/* 41 */       .csrf()
/* 42 */       .disable())
/* 43 */       .authorizeRequests()
/* 44 */       .antMatchers(new String[] { "/refresh-token" })).permitAll()
/* 45 */       .antMatchers(new String[] { "/src/**", "/images/**", "/js/**", "/webjars/**" })).permitAll()
/* 46 */       .antMatchers(new String[] { "/api/giohang/**", "/api/phan-hoi/**", "/api/dia-chi", "/api/don-hang/**" })).hasAuthority("ROLE_CUSTOMER")
/*    */       
/* 48 */       .and())
/* 49 */       .sessionManagement()
/* 50 */       .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
/* 51 */       .and())
/* 52 */       .authenticationProvider(this.authenticationProvider)
/* 53 */       .addFilterBefore((Filter)this.accountFilter, UsernamePasswordAuthenticationFilter.class)
/* 54 */       .build();
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Security\WebSecurityConfig.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */