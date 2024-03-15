/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "cuahang")
/*    */ public class CuaHang {
/*    */   @Id
/*    */   @Column(name = "id_cua_hang")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer idCuaHang;
/*    */   @Column(name = "ma_cua_hang")
/*    */   private String maCuaHang;
/*    */   @Column(name = "ten_cua_hang")
/*    */   private String tenCuaHang;
/*    */   
/* 16 */   public void setIdCuaHang(Integer idCuaHang) { this.idCuaHang = idCuaHang; } @Column(name = "dia_chi") private String diaChi; @Column(name = "thanh_pho") private String thanhPho; @Column(name = "quoc_gia") private String quocGia; @Column(name = "enabled", nullable = false) private boolean enabled; public void setMaCuaHang(String maCuaHang) { this.maCuaHang = maCuaHang; } public void setTenCuaHang(String tenCuaHang) { this.tenCuaHang = tenCuaHang; } public void setDiaChi(String diaChi) { this.diaChi = diaChi; } public void setThanhPho(String thanhPho) { this.thanhPho = thanhPho; } public void setQuocGia(String quocGia) { this.quocGia = quocGia; } public void setEnabled(boolean enabled) { this.enabled = enabled; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.CuaHang)) return false;  com.datn.dongho5s.Entity.CuaHang other = (com.datn.dongho5s.Entity.CuaHang)o; if (!other.canEqual(this)) return false;  if (isEnabled() != other.isEnabled()) return false;  Object this$idCuaHang = getIdCuaHang(), other$idCuaHang = other.getIdCuaHang(); if ((this$idCuaHang == null) ? (other$idCuaHang != null) : !this$idCuaHang.equals(other$idCuaHang)) return false;  Object this$maCuaHang = getMaCuaHang(), other$maCuaHang = other.getMaCuaHang(); if ((this$maCuaHang == null) ? (other$maCuaHang != null) : !this$maCuaHang.equals(other$maCuaHang)) return false;  Object this$tenCuaHang = getTenCuaHang(), other$tenCuaHang = other.getTenCuaHang(); if ((this$tenCuaHang == null) ? (other$tenCuaHang != null) : !this$tenCuaHang.equals(other$tenCuaHang)) return false;  Object this$diaChi = getDiaChi(), other$diaChi = other.getDiaChi(); if ((this$diaChi == null) ? (other$diaChi != null) : !this$diaChi.equals(other$diaChi)) return false;  Object this$thanhPho = getThanhPho(), other$thanhPho = other.getThanhPho(); if ((this$thanhPho == null) ? (other$thanhPho != null) : !this$thanhPho.equals(other$thanhPho)) return false;  Object this$quocGia = getQuocGia(), other$quocGia = other.getQuocGia(); return !((this$quocGia == null) ? (other$quocGia != null) : !this$quocGia.equals(other$quocGia)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.CuaHang; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + (isEnabled() ? 79 : 97); Object $idCuaHang = getIdCuaHang(); result = result * 59 + (($idCuaHang == null) ? 43 : $idCuaHang.hashCode()); Object $maCuaHang = getMaCuaHang(); result = result * 59 + (($maCuaHang == null) ? 43 : $maCuaHang.hashCode()); Object $tenCuaHang = getTenCuaHang(); result = result * 59 + (($tenCuaHang == null) ? 43 : $tenCuaHang.hashCode()); Object $diaChi = getDiaChi(); result = result * 59 + (($diaChi == null) ? 43 : $diaChi.hashCode()); Object $thanhPho = getThanhPho(); result = result * 59 + (($thanhPho == null) ? 43 : $thanhPho.hashCode()); Object $quocGia = getQuocGia(); return result * 59 + (($quocGia == null) ? 43 : $quocGia.hashCode()); } public String toString() { return "CuaHang(idCuaHang=" + getIdCuaHang() + ", maCuaHang=" + getMaCuaHang() + ", tenCuaHang=" + getTenCuaHang() + ", diaChi=" + getDiaChi() + ", thanhPho=" + getThanhPho() + ", quocGia=" + getQuocGia() + ", enabled=" + isEnabled() + ")"; } public CuaHang(Integer idCuaHang, String maCuaHang, String tenCuaHang, String diaChi, String thanhPho, String quocGia, boolean enabled) {
/* 17 */     this.idCuaHang = idCuaHang; this.maCuaHang = maCuaHang; this.tenCuaHang = tenCuaHang; this.diaChi = diaChi; this.thanhPho = thanhPho; this.quocGia = quocGia; this.enabled = enabled;
/*    */   } public CuaHang() {} public static CuaHangBuilder builder() {
/* 19 */     return new CuaHangBuilder();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getIdCuaHang() {
/* 25 */     return this.idCuaHang;
/*    */   }
/*    */   public String getMaCuaHang() {
/* 28 */     return this.maCuaHang;
/*    */   }
/*    */   public String getTenCuaHang() {
/* 31 */     return this.tenCuaHang;
/*    */   }
/*    */   public String getDiaChi() {
/* 34 */     return this.diaChi;
/*    */   }
/*    */   public String getThanhPho() {
/* 37 */     return this.thanhPho;
/*    */   }
/*    */   public String getQuocGia() {
/* 40 */     return this.quocGia;
/*    */   }
/*    */   public boolean isEnabled() {
/* 43 */     return this.enabled;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\CuaHang.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */