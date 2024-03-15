/*    */ package BOOT-INF.classes.com.datn.dongho5s.GiaoHangNhanhService.Request;
/*    */ 
/*    */ 
/*    */ public class ChiTietItemRequestGHN {
/*    */   private ChiTietSanPham ctsp;
/*    */   private String name;
/*    */   private Integer soLuong;
/*    */   private Double giaBan;
/*    */   
/* 10 */   public void setCtsp(ChiTietSanPham ctsp) { this.ctsp = ctsp; } public void setName(String name) { this.name = name; } public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; } public void setGiaBan(Double giaBan) { this.giaBan = giaBan; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.GiaoHangNhanhService.Request.ChiTietItemRequestGHN)) return false;  com.datn.dongho5s.GiaoHangNhanhService.Request.ChiTietItemRequestGHN other = (com.datn.dongho5s.GiaoHangNhanhService.Request.ChiTietItemRequestGHN)o; if (!other.canEqual(this)) return false;  Object this$soLuong = getSoLuong(), other$soLuong = other.getSoLuong(); if ((this$soLuong == null) ? (other$soLuong != null) : !this$soLuong.equals(other$soLuong)) return false;  Object this$giaBan = getGiaBan(), other$giaBan = other.getGiaBan(); if ((this$giaBan == null) ? (other$giaBan != null) : !this$giaBan.equals(other$giaBan)) return false;  Object this$ctsp = getCtsp(), other$ctsp = other.getCtsp(); if ((this$ctsp == null) ? (other$ctsp != null) : !this$ctsp.equals(other$ctsp)) return false;  Object this$name = getName(), other$name = other.getName(); return !((this$name == null) ? (other$name != null) : !this$name.equals(other$name)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.GiaoHangNhanhService.Request.ChiTietItemRequestGHN; } public int hashCode() { int PRIME = 59; result = 1; Object $soLuong = getSoLuong(); result = result * 59 + (($soLuong == null) ? 43 : $soLuong.hashCode()); Object $giaBan = getGiaBan(); result = result * 59 + (($giaBan == null) ? 43 : $giaBan.hashCode()); Object $ctsp = getCtsp(); result = result * 59 + (($ctsp == null) ? 43 : $ctsp.hashCode()); Object $name = getName(); return result * 59 + (($name == null) ? 43 : $name.hashCode()); } public String toString() { return "ChiTietItemRequestGHN(ctsp=" + getCtsp() + ", name=" + getName() + ", soLuong=" + getSoLuong() + ", giaBan=" + getGiaBan() + ")"; }
/*    */   
/* 12 */   public ChiTietItemRequestGHN() {} public ChiTietItemRequestGHN(ChiTietSanPham ctsp, String name, Integer soLuong, Double giaBan) { this.ctsp = ctsp; this.name = name; this.soLuong = soLuong; this.giaBan = giaBan; } public static ChiTietItemRequestGHNBuilder builder() {
/* 13 */     return new ChiTietItemRequestGHNBuilder();
/*    */   }
/* 15 */   public ChiTietSanPham getCtsp() { return this.ctsp; }
/* 16 */   public String getName() { return this.name; }
/* 17 */   public Integer getSoLuong() { return this.soLuong; } public Double getGiaBan() {
/* 18 */     return this.giaBan;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\GiaoHangNhanhService\Request\ChiTietItemRequestGHN.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */