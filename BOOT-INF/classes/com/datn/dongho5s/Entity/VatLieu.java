/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ 
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.GeneratedValue;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "vatlieu")
/*    */ public class VatLieu {
/*    */   @Id
/*    */   @Column(name = "id_vat_lieu")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer idVatLieu;
/*    */   @Column(name = "ten_vat_lieu")
/*    */   private String tenVatLieu;
/*    */   
/* 16 */   public void setIdVatLieu(Integer idVatLieu) { this.idVatLieu = idVatLieu; } @Column(name = "mo_ta_vat_lieu") private String moTaVatLieu; @Column(name = "enabled", nullable = false) private boolean enabled; public void setTenVatLieu(String tenVatLieu) { this.tenVatLieu = tenVatLieu; } public void setMoTaVatLieu(String moTaVatLieu) { this.moTaVatLieu = moTaVatLieu; } public void setEnabled(boolean enabled) { this.enabled = enabled; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.VatLieu)) return false;  com.datn.dongho5s.Entity.VatLieu other = (com.datn.dongho5s.Entity.VatLieu)o; if (!other.canEqual(this)) return false;  if (isEnabled() != other.isEnabled()) return false;  Object this$idVatLieu = getIdVatLieu(), other$idVatLieu = other.getIdVatLieu(); if ((this$idVatLieu == null) ? (other$idVatLieu != null) : !this$idVatLieu.equals(other$idVatLieu)) return false;  Object this$tenVatLieu = getTenVatLieu(), other$tenVatLieu = other.getTenVatLieu(); if ((this$tenVatLieu == null) ? (other$tenVatLieu != null) : !this$tenVatLieu.equals(other$tenVatLieu)) return false;  Object this$moTaVatLieu = getMoTaVatLieu(), other$moTaVatLieu = other.getMoTaVatLieu(); return !((this$moTaVatLieu == null) ? (other$moTaVatLieu != null) : !this$moTaVatLieu.equals(other$moTaVatLieu)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.VatLieu; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + (isEnabled() ? 79 : 97); Object $idVatLieu = getIdVatLieu(); result = result * 59 + (($idVatLieu == null) ? 43 : $idVatLieu.hashCode()); Object $tenVatLieu = getTenVatLieu(); result = result * 59 + (($tenVatLieu == null) ? 43 : $tenVatLieu.hashCode()); Object $moTaVatLieu = getMoTaVatLieu(); return result * 59 + (($moTaVatLieu == null) ? 43 : $moTaVatLieu.hashCode()); } public String toString() { return "VatLieu(idVatLieu=" + getIdVatLieu() + ", tenVatLieu=" + getTenVatLieu() + ", moTaVatLieu=" + getMoTaVatLieu() + ", enabled=" + isEnabled() + ")"; } public VatLieu(Integer idVatLieu, String tenVatLieu, String moTaVatLieu, boolean enabled) {
/* 17 */     this.idVatLieu = idVatLieu; this.tenVatLieu = tenVatLieu; this.moTaVatLieu = moTaVatLieu; this.enabled = enabled;
/*    */   } public VatLieu() {} public static VatLieuBuilder builder() {
/* 19 */     return new VatLieuBuilder();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getIdVatLieu() {
/* 25 */     return this.idVatLieu;
/*    */   }
/*    */   public String getTenVatLieu() {
/* 28 */     return this.tenVatLieu;
/*    */   }
/*    */   public String getMoTaVatLieu() {
/* 31 */     return this.moTaVatLieu;
/*    */   }
/*    */   public boolean isEnabled() {
/* 34 */     return this.enabled;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\VatLieu.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */