/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller;
/*    */ 
/*    */ import com.datn.dongho5s.Security.AccountFilterService;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.userdetails.UserDetails;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class TokenController
/*    */ {
/*    */   private final AccountFilterService accountFilterService;
/*    */   
/*    */   public TokenController(AccountFilterService accountFilterService) {
/* 18 */     this.accountFilterService = accountFilterService;
/*    */   }
/*    */ 
/*    */   
/*    */   @PostMapping({"/refresh-token"})
/*    */   public ResponseEntity<String> refreshToken(HttpServletRequest request, Authentication authentication) {
/* 24 */     String token = extractTokenFromRequest(request);
/*    */ 
/*    */     
/* 27 */     if (token != null && authentication != null) {
/*    */       
/* 29 */       boolean isUserValid = this.accountFilterService.isTokenValid(token, (UserDetails)authentication.getPrincipal());
/* 30 */       if (isUserValid) {
/*    */         
/* 32 */         String newToken = this.accountFilterService.refreshToken(token);
/* 33 */         if (newToken != null) {
/* 34 */           return ResponseEntity.ok(newToken);
/*    */         }
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 40 */     return ResponseEntity.badRequest().body("Không thể làm mới token hoặc token không hợp lệ.");
/*    */   }
/*    */ 
/*    */   
/*    */   private String extractTokenFromRequest(HttpServletRequest request) {
/* 45 */     String bearerToken = request.getHeader("Authorization");
/* 46 */     if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
/* 47 */       return bearerToken.substring(7);
/*    */     }
/* 49 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\TokenController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */