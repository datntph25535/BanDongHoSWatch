/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "daydeo")
/*    */ public class DayDeo {
/*    */   @Id
/*    */   @Column(name = "id_day_deo")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer idDayDeo;
/*    */   @Column(name = "ten_day_deo", length = 128, nullable = false, unique = true)
/*    */   private String tenDayDeo;
/*    */   @Column(name = "mo_ta_day_deo")
/*    */   private String moTaDayDeo;
/*    */   
/* 16 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.DayDeo)) return false;  com.datn.dongho5s.Entity.DayDeo other = (com.datn.dongho5s.Entity.DayDeo)o; if (!other.canEqual(this)) return false;  if (isEnabled() != other.isEnabled()) return false;  Object this$idDayDeo = getIdDayDeo(), other$idDayDeo = other.getIdDayDeo(); if ((this$idDayDeo == null) ? (other$idDayDeo != null) : !this$idDayDeo.equals(other$idDayDeo)) return false;  Object this$chieuDai = getChieuDai(), other$chieuDai = other.getChieuDai(); if ((this$chieuDai == null) ? (other$chieuDai != null) : !this$chieuDai.equals(other$chieuDai)) return false;  Object this$tenDayDeo = getTenDayDeo(), other$tenDayDeo = other.getTenDayDeo(); if ((this$tenDayDeo == null) ? (other$tenDayDeo != null) : !this$tenDayDeo.equals(other$tenDayDeo)) return false;  Object this$moTaDayDeo = getMoTaDayDeo(), other$moTaDayDeo = other.getMoTaDayDeo(); if ((this$moTaDayDeo == null) ? (other$moTaDayDeo != null) : !this$moTaDayDeo.equals(other$moTaDayDeo)) return false;  Object this$chatLieu = getChatLieu(), other$chatLieu = other.getChatLieu(); return !((this$chatLieu == null) ? (other$chatLieu != null) : !this$chatLieu.equals(other$chatLieu)); } @Column(name = "chieu_dai") private Float chieuDai; @Column(name = "chat_lieu") private String chatLieu; @Column(name = "enabled", nullable = false) private boolean enabled; protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.DayDeo; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + (isEnabled() ? 79 : 97); Object $idDayDeo = getIdDayDeo(); result = result * 59 + (($idDayDeo == null) ? 43 : $idDayDeo.hashCode()); Object $chieuDai = getChieuDai(); result = result * 59 + (($chieuDai == null) ? 43 : $chieuDai.hashCode()); Object $tenDayDeo = getTenDayDeo(); result = result * 59 + (($tenDayDeo == null) ? 43 : $tenDayDeo.hashCode()); Object $moTaDayDeo = getMoTaDayDeo(); result = result * 59 + (($moTaDayDeo == null) ? 43 : $moTaDayDeo.hashCode()); Object $chatLieu = getChatLieu(); return result * 59 + (($chatLieu == null) ? 43 : $chatLieu.hashCode()); } public String toString() { return "DayDeo(idDayDeo=" + getIdDayDeo() + ", tenDayDeo=" + getTenDayDeo() + ", moTaDayDeo=" + getMoTaDayDeo() + ", chieuDai=" + getChieuDai() + ", chatLieu=" + getChatLieu() + ", enabled=" + isEnabled() + ")"; } public static DayDeoBuilder builder() {
/* 17 */     return new DayDeoBuilder();
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
/*    */   public DayDeo() {}
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
/*    */   public DayDeo(Integer idDayDeo, String tenDayDeo, String moTaDayDeo, Float chieuDai, String chatLieu, boolean enabled) {
/* 44 */     this.idDayDeo = idDayDeo;
/* 45 */     this.tenDayDeo = tenDayDeo;
/* 46 */     this.moTaDayDeo = moTaDayDeo;
/* 47 */     this.chieuDai = chieuDai;
/* 48 */     this.chatLieu = chatLieu;
/* 49 */     this.enabled = enabled;
/*    */   }
/*    */   
/*    */   public Integer getIdDayDeo() {
/* 53 */     return this.idDayDeo;
/*    */   }
/*    */   
/*    */   public void setIdDayDeo(Integer idDayDeo) {
/* 57 */     this.idDayDeo = idDayDeo;
/*    */   }
/*    */   
/*    */   public String getTenDayDeo() {
/* 61 */     return this.tenDayDeo;
/*    */   }
/*    */   
/*    */   public void setTenDayDeo(String tenDayDeo) {
/* 65 */     this.tenDayDeo = tenDayDeo;
/*    */   }
/*    */   
/*    */   public String getMoTaDayDeo() {
/* 69 */     return this.moTaDayDeo;
/*    */   }
/*    */   
/*    */   public void setMoTaDayDeo(String moTaDayDeo) {
/* 73 */     this.moTaDayDeo = moTaDayDeo;
/*    */   }
/*    */   
/*    */   public Float getChieuDai() {
/* 77 */     return this.chieuDai;
/*    */   }
/*    */   
/*    */   public void setChieuDai(Float chieuDai) {
/* 81 */     this.chieuDai = chieuDai;
/*    */   }
/*    */   
/*    */   public String getChatLieu() {
/* 85 */     return this.chatLieu;
/*    */   }
/*    */   
/*    */   public void setChatLieu(String chatLieu) {
/* 89 */     this.chatLieu = chatLieu;
/*    */   }
/*    */   
/*    */   public boolean isEnabled() {
/* 93 */     return this.enabled;
/*    */   }
/*    */   
/*    */   public void setEnabled(boolean enabled) {
/* 97 */     this.enabled = enabled;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\DayDeo.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */