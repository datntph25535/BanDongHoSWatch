/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.RestController.KhachHang;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.KhachHang;
/*     */ import com.datn.dongho5s.Exception.ErrorResponse;
/*     */ import com.datn.dongho5s.Exception.GenericResponse;
/*     */ import com.datn.dongho5s.Repository.KhachHangRepository;
/*     */ import com.datn.dongho5s.Request.ChangePassForgetRequest;
/*     */ import com.datn.dongho5s.Request.ChangePassRequest;
/*     */ import com.datn.dongho5s.Request.LoginRequest;
/*     */ import com.datn.dongho5s.Request.RegisterRequest;
/*     */ import com.datn.dongho5s.Response.LoginResponse;
/*     */ import com.datn.dongho5s.Security.AccountFilterService;
/*     */ import com.datn.dongho5s.Service.AccountService;
/*     */ import java.security.Principal;
/*     */ import java.util.Optional;
/*     */ import java.util.UUID;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import javax.validation.Valid;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.context.MessageSource;
/*     */ import org.springframework.core.env.Environment;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.mail.SimpleMailMessage;
/*     */ import org.springframework.mail.javamail.JavaMailSender;
/*     */ import org.springframework.security.authentication.AuthenticationManager;
/*     */ import org.springframework.security.authentication.BadCredentialsException;
/*     */ import org.springframework.security.authentication.DisabledException;
/*     */ import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/*     */ import org.springframework.security.core.Authentication;
/*     */ import org.springframework.security.core.context.SecurityContextHolder;
/*     */ import org.springframework.security.crypto.password.PasswordEncoder;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
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
/*     */ @RestController
/*     */ @CrossOrigin({"*"})
/*     */ @RequestMapping({"/api/"})
/*     */ public class AccountRestController
/*     */ {
/*     */   @Autowired
/*     */   AuthenticationManager authenticationManager;
/*     */   @Autowired
/*     */   private AccountFilterService tokenProvider;
/*     */   @Autowired
/*     */   KhachHangRepository khachHangRepository;
/*     */   @Autowired
/*     */   AccountService accountService;
/*     */   @Autowired
/*     */   PasswordEncoder passwordEncoder;
/*     */   @Autowired
/*     */   private HttpSession session;
/*     */   @Autowired
/*     */   private Environment env;
/*     */   @Autowired
/*     */   private MessageSource messages;
/*     */   @Autowired
/*     */   private JavaMailSender javaMailSender;
/*     */   
/*     */   public Authentication authenticate(String username, String password) throws Exception {
/*     */     try {
/*  78 */       return this.authenticationManager.authenticate((Authentication)new UsernamePasswordAuthenticationToken(username, password));
/*  79 */     } catch (DisabledException e) {
/*  80 */       throw new Exception("USER_DISABLED", e);
/*  81 */     } catch (BadCredentialsException e) {
/*  82 */       System.out.println(e);
/*  83 */       throw new Exception("INVALID_CREDENTIALS", e);
/*     */     } 
/*     */   }
/*     */   @PostMapping({"/login"})
/*     */   public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
/*     */     try {
/*  89 */       Authentication authentication = authenticate(loginRequest
/*  90 */           .getUsername(), loginRequest.getPassword());
/*     */       
/*  92 */       SecurityContextHolder.getContext().setAuthentication(authentication);
/*  93 */       KhachHang userEntity = this.khachHangRepository.getKhachHangByEmail(authentication.getName());
/*  94 */       String jwt = this.tokenProvider.generateToken(authentication);
/*  95 */       LoginResponse loginResponse = new LoginResponse();
/*  96 */       loginResponse.setToken(jwt);
/*  97 */       loginResponse.setStatus(200);
/*  98 */       loginResponse.setIdKhachHang(userEntity.getIdKhachHang());
/*  99 */       loginResponse.setMessage("Đăng nhập thành công");
/* 100 */       loginResponse.setUsername(userEntity.getEmail());
/* 101 */       this.session.setAttribute("userName", userEntity.getUsername());
/* 102 */       return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
/* 103 */     } catch (Exception e) {
/* 104 */       System.out.println(e);
/* 105 */       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST, "Sai mật khẩu hoặc email "));
/*     */     } 
/*     */   }
/*     */   
/*     */   @PostMapping({"/register"})
/*     */   public ResponseEntity<?> singup(@Valid @RequestBody RegisterRequest registerRequest) throws Exception {
/* 111 */     return this.accountService.register(registerRequest);
/*     */   }
/*     */   
/*     */   @GetMapping({"/getTP"})
/*     */   public ResponseEntity<?> getTP() {
/* 116 */     return ResponseEntity.status(HttpStatus.OK).body(this.accountService.getListTP());
/*     */   }
/*     */   
/*     */   @GetMapping({"/getQH/{idTinh}"})
/*     */   public ResponseEntity<?> getQH(@PathVariable("idTinh") Integer idTinh) throws Exception {
/* 121 */     return ResponseEntity.status(HttpStatus.OK).body(this.accountService.getListQuan(idTinh));
/*     */   }
/*     */   @GetMapping({"/getPX/{idQuan}"})
/*     */   public ResponseEntity<?> getPX(@PathVariable("idQuan") Integer idQuan) throws Exception {
/* 125 */     return ResponseEntity.status(HttpStatus.OK).body(this.accountService.getListPhuong(idQuan));
/*     */   }
/*     */   
/*     */   @PostMapping({"/changePass"})
/*     */   public ResponseEntity<?> changePass(@Valid @RequestBody ChangePassRequest changePassRequest, Principal p) throws Exception {
/* 130 */     return this.accountService.changePass(p, changePassRequest);
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/resetPassword"})
/*     */   public ResponseEntity<?> resetPassword(HttpServletRequest request, @RequestParam("email") String userEmail) {
/* 136 */     KhachHang user = this.khachHangRepository.getKhachHangByEmail(userEmail);
/* 137 */     if (user == null) {
/* 138 */       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST, "Email không tồn tại"));
/*     */     }
/* 140 */     String token = UUID.randomUUID().toString();
/* 141 */     this.accountService.createPasswordResetTokenForUser(user, token);
/* 142 */     this.javaMailSender.send(constructResetTokenEmail(getAppUrl(request), token, user));
/* 143 */     GenericResponse genericResponse = new GenericResponse();
/* 144 */     genericResponse.setToken(token);
/* 145 */     return ResponseEntity.status(HttpStatus.OK).body(genericResponse);
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/user/changePassword/{token}"})
/*     */   public ResponseEntity<?> showChangePasswordPage(@PathVariable("token") String token) {
/* 151 */     String result = this.accountService.validatePasswordResetToken(token);
/* 152 */     if (result != null) {
/* 153 */       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST, "het han"));
/*     */     }
/* 155 */     return ResponseEntity.status(200).body(new ErrorResponse(HttpStatus.OK, "oke"));
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/updatePass/{token}"})
/*     */   public ResponseEntity<?> changePassForgot(@RequestBody ChangePassForgetRequest changePassForgetRequest, @PathVariable("token") String token) throws Exception {
/* 161 */     String result = this.accountService.validatePasswordResetToken(token);
/* 162 */     if (result != null) {
/* 163 */       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST, "Mã đã hết hạn"));
/*     */     }
/*     */     
/* 166 */     Optional<KhachHang> user = this.accountService.getUserByPasswordResetToken(token);
/* 167 */     if (user.isPresent()) {
/* 168 */       if (!changePassForgetRequest.getNewPass().equals(changePassForgetRequest.getConfirmPass())) {
/* 169 */         return ResponseEntity.status(400).body(new ErrorResponse(HttpStatus.BAD_REQUEST, "Xác nhận mật khẩu không khớp"));
/*     */       }
/* 171 */       this.accountService.changeforgotPass(user.get(), changePassForgetRequest.getNewPass());
/* 172 */       return ResponseEntity.status(200).body(new ErrorResponse(HttpStatus.OK, "Cập nhập thành công"));
/*     */     } 
/* 174 */     return ResponseEntity.status(400).body(new ErrorResponse(HttpStatus.BAD_REQUEST, "K thấy người dùng"));
/*     */   }
/*     */ 
/*     */   
/*     */   private SimpleMailMessage constructResetTokenEmail(String contextPath, String token, KhachHang user) {
/* 179 */     String url = contextPath + "/index#/changePassword/" + contextPath;
/* 180 */     String message = "Hi " + user.getTenKhachHang();
/* 181 */     return constructEmail("Reset Password", message + " \r\n" + message, user);
/*     */   }
/*     */ 
/*     */   
/*     */   private SimpleMailMessage constructEmail(String subject, String body, KhachHang user) {
/* 186 */     SimpleMailMessage email = new SimpleMailMessage();
/* 187 */     email.setSubject(subject);
/* 188 */     email.setText(body);
/* 189 */     email.setTo(user.getEmail());
/* 190 */     email.setFrom(this.env.getProperty("support.email"));
/* 191 */     return email;
/*     */   }
/*     */   private String getAppUrl(HttpServletRequest request) {
/* 194 */     return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\RestController\KhachHang\AccountRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */