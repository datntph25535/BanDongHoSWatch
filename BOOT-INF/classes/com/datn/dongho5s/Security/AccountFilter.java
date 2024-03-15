/*    */ package BOOT-INF.classes.com.datn.dongho5s.Security;
/*    */ import com.datn.dongho5s.Security.AccountFilterService;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ import org.springframework.security.core.userdetails.UserDetails;
/*    */ import org.springframework.security.core.userdetails.UserDetailsService;
/*    */ 
/*    */ @Component
/*    */ public class AccountFilter extends OncePerRequestFilter {
/*    */   public AccountFilter(AccountFilterService accountFilterService, UserDetailsService userDetailsService) {
/* 19 */     this.accountFilterService = accountFilterService; this.userDetailsService = userDetailsService;
/*    */   }
/*    */ 
/*    */   
/*    */   private final AccountFilterService accountFilterService;
/*    */   
/*    */   private final UserDetailsService userDetailsService;
/*    */   
/*    */   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, IOException {
/* 28 */     String header = request.getHeader("Authorization");
/* 29 */     if (header == null || !header.startsWith("Bearer ")) {
/* 30 */       filterChain.doFilter((ServletRequest)request, (ServletResponse)response);
/*    */       return;
/*    */     } 
/* 33 */     String token = header.substring(7);
/* 34 */     String username = null;
/*    */     try {
/* 36 */       username = this.accountFilterService.getUsername(token);
/* 37 */     } catch (IllegalArgumentException e) {
/* 38 */       filterChain.doFilter((ServletRequest)request, (ServletResponse)response);
/*    */       return;
/* 40 */     } catch (ExpiredJwtException e) {
/* 41 */       filterChain.doFilter((ServletRequest)request, (ServletResponse)response);
/*    */       
/*    */       return;
/*    */     } 
/* 45 */     if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
/* 46 */       UserDetails account = this.userDetailsService.loadUserByUsername(username);
/* 47 */       if (this.accountFilterService.isTokenValid(token, account)) {
/*    */         
/* 49 */         UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(account, null, account.getAuthorities());
/* 50 */         authToken.setDetails(new WebAuthenticationDetails(request));
/* 51 */         SecurityContextHolder.getContext().setAuthentication((Authentication)authToken);
/*    */       } 
/*    */     } 
/* 54 */     filterChain.doFilter((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Security\AccountFilter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */