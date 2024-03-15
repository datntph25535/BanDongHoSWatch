/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ 
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "mausac")
/*    */ public class MauSac {
/*    */   @Id
/*    */   @Column(name = "id_mau_sac")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer idMauSac;
/*    */   
/* 16 */   public void setIdMauSac(Integer idMauSac) { this.idMauSac = idMauSac; } @Column(name = "ten_mau_sac") private String tenMauSac; @Column(name = "enabled", nullable = false) private boolean enabled; public void setTenMauSac(String tenMauSac) { this.tenMauSac = tenMauSac; } public void setEnabled(boolean enabled) { this.enabled = enabled; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.MauSac)) return false;  com.datn.dongho5s.Entity.MauSac other = (com.datn.dongho5s.Entity.MauSac)o; if (!other.canEqual(this)) return false;  if (isEnabled() != other.isEnabled()) return false;  Object this$idMauSac = getIdMauSac(), other$idMauSac = other.getIdMauSac(); if ((this$idMauSac == null) ? (other$idMauSac != null) : !this$idMauSac.equals(other$idMauSac)) return false;  Object this$tenMauSac = getTenMauSac(), other$tenMauSac = other.getTenMauSac(); return !((this$tenMauSac == null) ? (other$tenMauSac != null) : !this$tenMauSac.equals(other$tenMauSac)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.MauSac; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + (isEnabled() ? 79 : 97); Object $idMauSac = getIdMauSac(); result = result * 59 + (($idMauSac == null) ? 43 : $idMauSac.hashCode()); Object $tenMauSac = getTenMauSac(); return result * 59 + (($tenMauSac == null) ? 43 : $tenMauSac.hashCode()); } public String toString() { return "MauSac(idMauSac=" + getIdMauSac() + ", tenMauSac=" + getTenMauSac() + ", enabled=" + isEnabled() + ")"; } public MauSac(Integer idMauSac, String tenMauSac, boolean enabled) {
/* 17 */     this.idMauSac = idMauSac; this.tenMauSac = tenMauSac; this.enabled = enabled;
/*    */   } public MauSac() {} public static MauSacBuilder builder() {
/* 19 */     return new MauSacBuilder();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getIdMauSac() {
/* 25 */     return this.idMauSac;
/*    */   }
/*    */   public String getTenMauSac() {
/* 28 */     return this.tenMauSac;
/*    */   }
/*    */   public boolean isEnabled() {
/* 31 */     return this.enabled;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\MauSac.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */