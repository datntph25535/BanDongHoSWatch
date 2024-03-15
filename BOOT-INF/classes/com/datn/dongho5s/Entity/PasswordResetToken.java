/*     */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.KhachHang;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.OneToOne;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "password_reset_token")
/*     */ public class PasswordResetToken
/*     */ {
/*     */   private static final int EXPIRATION = 30;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.AUTO)
/*     */   private Long id;
/*     */   private String token;
/*     */   @OneToOne(targetEntity = KhachHang.class, fetch = FetchType.EAGER)
/*     */   @JoinColumn(nullable = false, name = "id_khach_hang")
/*     */   private KhachHang khachHang;
/*     */   private Date expiryDate;
/*     */   
/*     */   public PasswordResetToken() {}
/*     */   
/*     */   public PasswordResetToken(String token) {
/*  35 */     this.token = token;
/*  36 */     this.expiryDate = calculateExpiryDate(30);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PasswordResetToken(String token, KhachHang khachHang) {
/*  42 */     this.token = token;
/*  43 */     this.khachHang = khachHang;
/*  44 */     this.expiryDate = calculateExpiryDate(30);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  49 */     return this.id;
/*     */   }
/*     */   
/*     */   public String getToken() {
/*  53 */     return this.token;
/*     */   }
/*     */   
/*     */   public void setToken(String token) {
/*  57 */     this.token = token;
/*     */   }
/*     */   
/*     */   public KhachHang getKhachHang() {
/*  61 */     return this.khachHang;
/*     */   }
/*     */   
/*     */   public void setUser(KhachHang khachHang) {
/*  65 */     this.khachHang = khachHang;
/*     */   }
/*     */   
/*     */   public Date getExpiryDate() {
/*  69 */     return this.expiryDate;
/*     */   }
/*     */   
/*     */   public void setExpiryDate(Date expiryDate) {
/*  73 */     this.expiryDate = expiryDate;
/*     */   }
/*     */   
/*     */   private Date calculateExpiryDate(int expiryTimeInMinutes) {
/*  77 */     Calendar cal = Calendar.getInstance();
/*  78 */     cal.setTimeInMillis((new Date()).getTime());
/*  79 */     cal.add(12, expiryTimeInMinutes);
/*  80 */     return new Date(cal.getTime().getTime());
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateToken(String token) {
/*  85 */     this.token = token;
/*  86 */     this.expiryDate = calculateExpiryDate(30);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  93 */     int prime = 31;
/*  94 */     int result = 1;
/*  95 */     result = 31 * result + ((getExpiryDate() == null) ? 0 : getExpiryDate().hashCode());
/*  96 */     result = 31 * result + ((getToken() == null) ? 0 : getToken().hashCode());
/*  97 */     result = 31 * result + ((getKhachHang() == null) ? 0 : getKhachHang().hashCode());
/*  98 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 103 */     if (this == obj) {
/* 104 */       return true;
/*     */     }
/* 106 */     if (obj == null) {
/* 107 */       return false;
/*     */     }
/* 109 */     if (getClass() != obj.getClass()) {
/* 110 */       return false;
/*     */     }
/* 112 */     com.datn.dongho5s.Entity.PasswordResetToken other = (com.datn.dongho5s.Entity.PasswordResetToken)obj;
/* 113 */     if (getExpiryDate() == null) {
/* 114 */       if (other.getExpiryDate() != null) {
/* 115 */         return false;
/*     */       }
/* 117 */     } else if (!getExpiryDate().equals(other.getExpiryDate())) {
/* 118 */       return false;
/*     */     } 
/* 120 */     if (getToken() == null) {
/* 121 */       if (other.getToken() != null) {
/* 122 */         return false;
/*     */       }
/* 124 */     } else if (!getToken().equals(other.getToken())) {
/* 125 */       return false;
/*     */     } 
/* 127 */     if (getKhachHang() == null) {
/* 128 */       if (other.getKhachHang() != null) {
/* 129 */         return false;
/*     */       }
/* 131 */     } else if (!getKhachHang().equals(other.getKhachHang())) {
/* 132 */       return false;
/*     */     } 
/* 134 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 139 */     StringBuilder builder = new StringBuilder();
/* 140 */     builder.append("Token [String=").append(this.token).append("]").append("[Expires").append(this.expiryDate).append("]");
/* 141 */     return builder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\PasswordResetToken.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */