/*    */ package BOOT-INF.classes.com.datn.dongho5s.Security;
/*    */ 
/*    */ import com.datn.dongho5s.Repository.KhachHangRepository;
/*    */ import com.datn.dongho5s.Repository.NhanVienRepository;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.security.authentication.AuthenticationManager;
/*    */ import org.springframework.security.authentication.AuthenticationProvider;
/*    */ import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
/*    */ import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
/*    */ import org.springframework.security.core.userdetails.UserDetailsService;
/*    */ import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*    */ import org.springframework.security.crypto.password.PasswordEncoder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class SecurityConfiguration
/*    */ {
/*    */   private final NhanVienRepository nhanVienRepository;
/*    */   private final KhachHangRepository khachHangRepository;
/*    */   
/*    */   public SecurityConfiguration(NhanVienRepository nhanVienRepository, KhachHangRepository khachHangRepository) {
/* 28 */     this.nhanVienRepository = nhanVienRepository; this.khachHangRepository = khachHangRepository;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Bean
/*    */   public PasswordEncoder passwordEncoder() {
/* 36 */     return (PasswordEncoder)new BCryptPasswordEncoder();
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public UserDetailsService userDetailsService() {
/* 41 */     return (UserDetailsService)new Object(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Bean
/*    */   public AuthenticationProvider getProvider() {
/* 62 */     DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
/* 63 */     provider.setPasswordEncoder(passwordEncoder());
/* 64 */     provider.setUserDetailsService(userDetailsService());
/* 65 */     return (AuthenticationProvider)provider;
/*    */   }
/*    */   @Bean
/*    */   public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
/* 69 */     return config.getAuthenticationManager();
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Security\SecurityConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */