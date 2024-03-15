/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ 
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import org.springframework.format.annotation.DateTimeFormat;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "kichco")
/*    */ public class KichCo {
/*    */   @Id
/*    */   @Column(name = "id_kich_co")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer idKichCo;
/*    */   @Column(name = "ten_kich_co")
/*    */   private String tenKichCo;
/*    */   
/* 18 */   public void setIdKichCo(Integer idKichCo) { this.idKichCo = idKichCo; } @Column(name = "mo_ta_kich_co") private String moTaKichCo; @Column(name = "ngay_tao_kich_co") @DateTimeFormat(pattern = "yyyy-MM-dd") private Date ngayTaoKichCo; @Column(name = "enabled", nullable = false) private boolean enabled; public void setTenKichCo(String tenKichCo) { this.tenKichCo = tenKichCo; } public void setMoTaKichCo(String moTaKichCo) { this.moTaKichCo = moTaKichCo; } public void setNgayTaoKichCo(Date ngayTaoKichCo) { this.ngayTaoKichCo = ngayTaoKichCo; } public void setEnabled(boolean enabled) { this.enabled = enabled; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.KichCo)) return false;  com.datn.dongho5s.Entity.KichCo other = (com.datn.dongho5s.Entity.KichCo)o; if (!other.canEqual(this)) return false;  if (isEnabled() != other.isEnabled()) return false;  Object this$idKichCo = getIdKichCo(), other$idKichCo = other.getIdKichCo(); if ((this$idKichCo == null) ? (other$idKichCo != null) : !this$idKichCo.equals(other$idKichCo)) return false;  Object this$tenKichCo = getTenKichCo(), other$tenKichCo = other.getTenKichCo(); if ((this$tenKichCo == null) ? (other$tenKichCo != null) : !this$tenKichCo.equals(other$tenKichCo)) return false;  Object this$moTaKichCo = getMoTaKichCo(), other$moTaKichCo = other.getMoTaKichCo(); if ((this$moTaKichCo == null) ? (other$moTaKichCo != null) : !this$moTaKichCo.equals(other$moTaKichCo)) return false;  Object this$ngayTaoKichCo = getNgayTaoKichCo(), other$ngayTaoKichCo = other.getNgayTaoKichCo(); return !((this$ngayTaoKichCo == null) ? (other$ngayTaoKichCo != null) : !this$ngayTaoKichCo.equals(other$ngayTaoKichCo)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.KichCo; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + (isEnabled() ? 79 : 97); Object $idKichCo = getIdKichCo(); result = result * 59 + (($idKichCo == null) ? 43 : $idKichCo.hashCode()); Object $tenKichCo = getTenKichCo(); result = result * 59 + (($tenKichCo == null) ? 43 : $tenKichCo.hashCode()); Object $moTaKichCo = getMoTaKichCo(); result = result * 59 + (($moTaKichCo == null) ? 43 : $moTaKichCo.hashCode()); Object $ngayTaoKichCo = getNgayTaoKichCo(); return result * 59 + (($ngayTaoKichCo == null) ? 43 : $ngayTaoKichCo.hashCode()); } public String toString() { return "KichCo(idKichCo=" + getIdKichCo() + ", tenKichCo=" + getTenKichCo() + ", moTaKichCo=" + getMoTaKichCo() + ", ngayTaoKichCo=" + getNgayTaoKichCo() + ", enabled=" + isEnabled() + ")"; } public KichCo(Integer idKichCo, String tenKichCo, String moTaKichCo, Date ngayTaoKichCo, boolean enabled) {
/* 19 */     this.idKichCo = idKichCo; this.tenKichCo = tenKichCo; this.moTaKichCo = moTaKichCo; this.ngayTaoKichCo = ngayTaoKichCo; this.enabled = enabled;
/*    */   } public KichCo() {} public static KichCoBuilder builder() {
/* 21 */     return new KichCoBuilder();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getIdKichCo() {
/* 27 */     return this.idKichCo;
/*    */   }
/*    */   public String getTenKichCo() {
/* 30 */     return this.tenKichCo;
/*    */   }
/*    */   public String getMoTaKichCo() {
/* 33 */     return this.moTaKichCo;
/*    */   }
/*    */   
/*    */   public Date getNgayTaoKichCo() {
/* 37 */     return this.ngayTaoKichCo;
/*    */   }
/*    */   public boolean isEnabled() {
/* 40 */     return this.enabled;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\KichCo.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */