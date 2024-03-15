/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.NhanVien;
/*     */ import com.datn.dongho5s.Repository.NhanVienRepository;
/*     */ import com.datn.dongho5s.Request.LoginAdminRequest;
/*     */ import com.datn.dongho5s.Security.AccountFilterService;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import javax.validation.Valid;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.security.authentication.AuthenticationManager;
/*     */ import org.springframework.security.authentication.BadCredentialsException;
/*     */ import org.springframework.security.authentication.DisabledException;
/*     */ import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/*     */ import org.springframework.security.core.Authentication;
/*     */ import org.springframework.security.crypto.password.PasswordEncoder;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ public class MainController
/*     */ {
/*     */   @Autowired
/*     */   AuthenticationManager authenticationManager;
/*     */   @Autowired
/*     */   private AccountFilterService tokenProvider;
/*     */   @Autowired
/*     */   NhanVienRepository nhanVienRepository;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   @Autowired
/*     */   PasswordEncoder passwordEncoder;
/*     */   
/*     */   @GetMapping({"/admin"})
/*     */   public String viewHome() {
/*  46 */     HttpSession session = this.request.getSession();
/*  47 */     if (session.getAttribute("admin") == null) {
/*  48 */       return "redirect:/login-admin";
/*     */     }
/*  50 */     return "admin/index";
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/login-admin"})
/*     */   public String viewLogin() {
/*  56 */     return "admin/login";
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/logout"})
/*     */   public String logout() {
/*  61 */     HttpSession session = this.request.getSession();
/*  62 */     session.removeAttribute("admin");
/*  63 */     return "redirect:/login-admin";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/post/login"})
/*     */   public ModelAndView authenticateUser(@Valid LoginAdminRequest loginAdminRequest, BindingResult bindingResult, Model model) throws Exception {
/*  72 */     HttpSession session = this.request.getSession();
/*     */ 
/*     */     
/*     */     try {
/*  76 */       NhanVien userEntity = this.nhanVienRepository.getNhanVienByEmail(loginAdminRequest.getEmail());
/*  77 */       if (this.passwordEncoder.matches(loginAdminRequest.getPassword(), userEntity.getMatKhau())) {
/*  78 */         session.setAttribute("admin", userEntity);
/*  79 */         ModelAndView mv = new ModelAndView("redirect:/admin");
/*  80 */         return mv;
/*     */       } 
/*     */       
/*  83 */       model.addAttribute("error", "Đăng nhập không thành công. Vui lòng kiểm tra lại email và mật khẩu.");
/*  84 */       return new ModelAndView("admin/login");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  97 */     catch (Exception ex) {
/*  98 */       System.out.println(ex);
/*  99 */       model.addAttribute("error", "Đăng nhập không thành công. Vui lòng kiểm tra lại email và mật khẩu.");
/*     */       
/* 101 */       return new ModelAndView("admin/login");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Authentication authenticate(String username, String password) throws Exception {
/*     */     try {
/* 108 */       return this.authenticationManager.authenticate((Authentication)new UsernamePasswordAuthenticationToken(username, password));
/* 109 */     } catch (DisabledException e) {
/* 110 */       throw new Exception("USER_DISABLED", e);
/* 111 */     } catch (BadCredentialsException e) {
/* 112 */       System.out.println(e);
/* 113 */       throw new Exception("INVALID_CREDENTIALS", e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\MainController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */