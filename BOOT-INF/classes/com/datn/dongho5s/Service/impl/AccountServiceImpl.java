/*     */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*     */ 
/*     */ import com.datn.dongho5s.Cache.DiaChiCache;
/*     */ import com.datn.dongho5s.Entity.DiaChi;
/*     */ import com.datn.dongho5s.Entity.KhachHang;
/*     */ import com.datn.dongho5s.Entity.PasswordResetToken;
/*     */ import com.datn.dongho5s.Exception.CustomException.BadRequestException;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.DiaChiAPI;
/*     */ import com.datn.dongho5s.Repository.DiaChiRepository;
/*     */ import com.datn.dongho5s.Repository.KhachHangRepository;
/*     */ import com.datn.dongho5s.Repository.NhanVienRepository;
/*     */ import com.datn.dongho5s.Repository.PasswordResetTokenRepository;
/*     */ import com.datn.dongho5s.Request.ChangePassRequest;
/*     */ import com.datn.dongho5s.Request.RegisterRequest;
/*     */ import com.datn.dongho5s.Service.AccountService;
/*     */ import java.security.Principal;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Optional;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.security.crypto.password.PasswordEncoder;
/*     */ import org.springframework.stereotype.Service;
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
/*     */ @Service
/*     */ public class AccountServiceImpl
/*     */   implements AccountService
/*     */ {
/*     */   @Autowired
/*     */   KhachHangRepository khachHangRepository;
/*     */   @Autowired
/*     */   PasswordEncoder passwordEncoder;
/*     */   @Autowired
/*     */   NhanVienRepository nhanVienRepository;
/*     */   @Autowired
/*     */   PasswordResetTokenRepository passwordResetTokenRepository;
/*     */   @Autowired
/*     */   DiaChiRepository diaChiRepository;
/*     */   
/*     */   public ResponseEntity<?> register(RegisterRequest registerRequest) throws Exception {
/*  54 */     KhachHang findKHbyEmail = this.khachHangRepository.getKhachHangByEmail(registerRequest.getEmail());
/*  55 */     KhachHang khachHangBySdt = this.khachHangRepository.getKhachHangBySdt(registerRequest.getSoDienThoai());
/*  56 */     if (registerRequest.getIdTinhThanh() == null || registerRequest.getIdQuanHuyen() == null || registerRequest.getIdPhuongXa() == null) {
/*  57 */       throw new BadRequestException("Mời bạn nhập địa chỉ ");
/*     */     }
/*  59 */     if (registerRequest.getNgaySinh().after(new Date())) {
/*  60 */       throw new BadRequestException("Ngày sinh sai rùi ");
/*     */     }
/*  62 */     if (registerRequest.getPassword().isEmpty()) {
/*  63 */       throw new BadRequestException("Password không được trống ");
/*     */     }
/*  65 */     if (findKHbyEmail != null) {
/*  66 */       throw new BadRequestException("Email đã tồn tại ");
/*     */     }
/*  68 */     if (khachHangBySdt != null && khachHangBySdt.getPassword() == null) {
/*  69 */       khachHangBySdt.setEmail(registerRequest.getEmail());
/*  70 */       khachHangBySdt.setEnabled(true);
/*  71 */       khachHangBySdt.setGioiTinh(registerRequest.getGioiTinh());
/*  72 */       khachHangBySdt.setPassword(this.passwordEncoder.encode(registerRequest.getPassword()));
/*  73 */       khachHangBySdt.setTenKhachHang(registerRequest.getTenKhachHang());
/*  74 */       khachHangBySdt.setNgaySinh(registerRequest.getNgaySinh());
/*  75 */       khachHangBySdt.setNgaySua(new Date());
/*  76 */       khachHangBySdt.setThoiGianTaoTaiKhoan(new Timestamp((new Date()).getTime()));
/*  77 */       KhachHang khachHang0 = (KhachHang)this.khachHangRepository.save(khachHangBySdt);
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
/*  88 */       DiaChi diaChi2 = DiaChi.builder().diaChi(registerRequest.getDiaChi()).idTinhThanh(registerRequest.getIdTinhThanh()).idQuanHuyen(registerRequest.getIdQuanHuyen()).idPhuongXa(registerRequest.getIdPhuongXa()).ghiChu("").maBuuChinh(Integer.valueOf(123)).khachHang(khachHang0).trangThaiMacDinh(Integer.valueOf(1)).soDienThoai(registerRequest.getSoDienThoai()).build();
/*  89 */       DiaChi diaChi3 = (DiaChi)this.diaChiRepository.save(diaChi2);
/*  90 */       return new ResponseEntity(khachHang0, HttpStatus.OK);
/*  91 */     }  if (khachHangBySdt != null) {
/*  92 */       throw new BadRequestException("Số điện thoại đã được đăng ký");
/*     */     }
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
/* 105 */     KhachHang khachHang = KhachHang.builder().idKhachHang(null).email(registerRequest.getEmail()).enabled(true).gioiTinh(registerRequest.getGioiTinh()).password(this.passwordEncoder.encode(registerRequest.getPassword())).tenKhachHang(registerRequest.getTenKhachHang()).ngaySinh(registerRequest.getNgaySinh()).ngaySua(new Date()).soDienThoai(registerRequest.getSoDienThoai()).thoiGianTaoTaiKhoan(new Timestamp((new Date()).getTime())).build();
/* 106 */     KhachHang khachHang1 = (KhachHang)this.khachHangRepository.save(khachHang);
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
/* 118 */     DiaChi diaChi = DiaChi.builder().diaChi(registerRequest.getDiaChi()).idTinhThanh(registerRequest.getIdTinhThanh()).idQuanHuyen(registerRequest.getIdQuanHuyen()).idPhuongXa(registerRequest.getIdPhuongXa()).ghiChu("").maBuuChinh(Integer.valueOf(123)).khachHang(khachHang1).trangThaiMacDinh(Integer.valueOf(1)).soDienThoai(registerRequest.getSoDienThoai()).build();
/* 119 */     DiaChi diaChi1 = (DiaChi)this.diaChiRepository.save(diaChi);
/* 120 */     return new ResponseEntity(khachHang1, HttpStatus.OK);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HashMap<Integer, String> getListTP() {
/* 126 */     return DiaChiCache.hashMapTinhThanh;
/*     */   }
/*     */ 
/*     */   
/*     */   public HashMap<Integer, String> getListQuan(Integer idTP) throws Exception {
/* 131 */     DiaChiAPI.callGetQuanHuyenAPI(idTP);
/* 132 */     return (HashMap<Integer, String>)DiaChiCache.hashMapQuanHuyen.get(idTP);
/*     */   }
/*     */ 
/*     */   
/*     */   public HashMap<String, String> getListPhuong(Integer idQH) throws Exception {
/* 137 */     DiaChiAPI.callGetPhuongXaAPI(idQH);
/* 138 */     return (HashMap<String, String>)DiaChiCache.hashMapPhuongXa.get(idQH);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResponseEntity<?> changePass(Principal p, ChangePassRequest changePassRequest) throws Exception {
/* 145 */     if (changePassRequest.getNewPass() == null) {
/* 146 */       throw new BadRequestException("Mật khẩu không được để trống");
/*     */     }
/* 148 */     if (changePassRequest.getConfirmPass() == null) {
/* 149 */       throw new BadRequestException("Mật khẩu không được để trống");
/*     */     }
/* 151 */     String email = p.getName();
/* 152 */     KhachHang user = this.khachHangRepository.getKhachHangByEmail(email);
/* 153 */     boolean f = this.passwordEncoder.matches(changePassRequest.getOldPass(), user.getPassword());
/* 154 */     if (f) {
/* 155 */       if (!changePassRequest.getNewPass().equals(changePassRequest.getConfirmPass())) {
/* 156 */         throw new BadRequestException("Xác nhận mật khẩu không khớp");
/*     */       }
/* 158 */       user.setPassword(this.passwordEncoder.encode(changePassRequest.getNewPass()));
/* 159 */       this.khachHangRepository.save(user);
/* 160 */       return ResponseEntity.status(HttpStatus.OK).body(this.khachHangRepository.save(user));
/*     */     } 
/*     */     
/* 163 */     throw new BadRequestException("Mật khẩu không đúng");
/*     */   }
/*     */ 
/*     */   
/*     */   public Optional<KhachHang> getUserByPasswordResetToken(String token) {
/* 168 */     return Optional.ofNullable(this.passwordResetTokenRepository.findByToken(token).getKhachHang());
/*     */   }
/*     */ 
/*     */   
/*     */   public void changeforgotPass(KhachHang khachHang, String pass) {
/* 173 */     khachHang.setPassword(this.passwordEncoder.encode(pass));
/* 174 */     this.khachHangRepository.save(khachHang);
/*     */   }
/*     */   
/*     */   public void createPasswordResetTokenForUser(KhachHang user, String token) {
/* 178 */     PasswordResetToken myToken = new PasswordResetToken(token, user);
/* 179 */     this.passwordResetTokenRepository.save(myToken);
/*     */   }
/*     */ 
/*     */   
/*     */   public String validatePasswordResetToken(String token) {
/* 184 */     PasswordResetToken passToken = this.passwordResetTokenRepository.findByToken(token);
/* 185 */     return !isTokenFound(passToken) ? "invalidToken" : (
/* 186 */       isTokenExpired(passToken) ? "expired" : 
/* 187 */       null);
/*     */   }
/*     */   
/*     */   private boolean isTokenFound(PasswordResetToken passToken) {
/* 191 */     return (passToken != null);
/*     */   }
/*     */   
/*     */   private boolean isTokenExpired(PasswordResetToken passToken) {
/* 195 */     Calendar cal = Calendar.getInstance();
/* 196 */     return passToken.getExpiryDate().before(cal.getTime());
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\AccountServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */