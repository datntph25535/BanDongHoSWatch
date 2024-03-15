/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ 
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.GeneratedValue;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "thuonghieu")
/*    */ public class ThuongHieu {
/*    */   @Id
/*    */   @Column(name = "id_thuong_hieu")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer idThuongHieu;
/*    */   @Column(name = "ten_thuong_hieu", length = 128, nullable = false, unique = true)
/*    */   private String tenThuongHieu;
/*    */   
/* 16 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.ThuongHieu)) return false;  com.datn.dongho5s.Entity.ThuongHieu other = (com.datn.dongho5s.Entity.ThuongHieu)o; if (!other.canEqual(this)) return false;  if (isEnabled() != other.isEnabled()) return false;  Object this$idThuongHieu = getIdThuongHieu(), other$idThuongHieu = other.getIdThuongHieu(); if ((this$idThuongHieu == null) ? (other$idThuongHieu != null) : !this$idThuongHieu.equals(other$idThuongHieu)) return false;  Object this$tenThuongHieu = getTenThuongHieu(), other$tenThuongHieu = other.getTenThuongHieu(); if ((this$tenThuongHieu == null) ? (other$tenThuongHieu != null) : !this$tenThuongHieu.equals(other$tenThuongHieu)) return false;  Object this$moTaThuongHieu = getMoTaThuongHieu(), other$moTaThuongHieu = other.getMoTaThuongHieu(); return !((this$moTaThuongHieu == null) ? (other$moTaThuongHieu != null) : !this$moTaThuongHieu.equals(other$moTaThuongHieu)); } @Column(name = "mo_ta_thuong_hieu", length = 128, nullable = false, unique = true) private String moTaThuongHieu; @Column(name = "enabled", nullable = false) private boolean enabled; protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.ThuongHieu; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + (isEnabled() ? 79 : 97); Object $idThuongHieu = getIdThuongHieu(); result = result * 59 + (($idThuongHieu == null) ? 43 : $idThuongHieu.hashCode()); Object $tenThuongHieu = getTenThuongHieu(); result = result * 59 + (($tenThuongHieu == null) ? 43 : $tenThuongHieu.hashCode()); Object $moTaThuongHieu = getMoTaThuongHieu(); return result * 59 + (($moTaThuongHieu == null) ? 43 : $moTaThuongHieu.hashCode()); } public String toString() { return "ThuongHieu(idThuongHieu=" + getIdThuongHieu() + ", tenThuongHieu=" + getTenThuongHieu() + ", moTaThuongHieu=" + getMoTaThuongHieu() + ", enabled=" + isEnabled() + ")"; } public static ThuongHieuBuilder builder() {
/* 17 */     return new ThuongHieuBuilder();
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
/*    */   public ThuongHieu() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ThuongHieu(Integer idThuongHieu, String tenThuongHieu) {
/* 38 */     this.idThuongHieu = idThuongHieu;
/* 39 */     this.tenThuongHieu = tenThuongHieu;
/*    */   }
/*    */   
/*    */   public ThuongHieu(Integer idThuongHieu, String tenThuongHieu, String moTaThuongHieu, boolean enabled) {
/* 43 */     this.idThuongHieu = idThuongHieu;
/* 44 */     this.tenThuongHieu = tenThuongHieu;
/* 45 */     this.moTaThuongHieu = moTaThuongHieu;
/* 46 */     this.enabled = enabled;
/*    */   }
/*    */   
/*    */   public Integer getIdThuongHieu() {
/* 50 */     return this.idThuongHieu;
/*    */   }
/*    */   
/*    */   public void setIdThuongHieu(Integer idThuongHieu) {
/* 54 */     this.idThuongHieu = idThuongHieu;
/*    */   }
/*    */   
/*    */   public String getTenThuongHieu() {
/* 58 */     return this.tenThuongHieu;
/*    */   }
/*    */   
/*    */   public void setTenThuongHieu(String tenThuongHieu) {
/* 62 */     this.tenThuongHieu = tenThuongHieu;
/*    */   }
/*    */   
/*    */   public String getMoTaThuongHieu() {
/* 66 */     return this.moTaThuongHieu;
/*    */   }
/*    */   
/*    */   public void setMoTaThuongHieu(String moTaThuongHieu) {
/* 70 */     this.moTaThuongHieu = moTaThuongHieu;
/*    */   }
/*    */   
/*    */   public boolean isEnabled() {
/* 74 */     return this.enabled;
/*    */   }
/*    */   
/*    */   public void setEnabled(boolean enabled) {
/* 78 */     this.enabled = enabled;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\ThuongHieu.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */