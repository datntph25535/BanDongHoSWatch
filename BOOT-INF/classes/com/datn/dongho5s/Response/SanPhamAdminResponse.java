/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.SanPham;
/*    */ 
/*    */ public class SanPhamAdminResponse {
/*    */   private Integer idChiTietSanPham;
/*    */   private String maChiTietSanPham;
/*    */   private SanPham sanPham;
/*    */   private KhuyenMai khuyenMai;
/*    */   
/* 11 */   public static SanPhamAdminResponseBuilder builder() { return new SanPhamAdminResponseBuilder(); } private MauSac mauSac; private Double giaSanPham; private Integer soLuong; private VatLieu vatLieu; public void setIdChiTietSanPham(Integer idChiTietSanPham) {
/* 12 */     this.idChiTietSanPham = idChiTietSanPham; } public void setMaChiTietSanPham(String maChiTietSanPham) { this.maChiTietSanPham = maChiTietSanPham; } public void setSanPham(SanPham sanPham) { this.sanPham = sanPham; } public void setKhuyenMai(KhuyenMai khuyenMai) { this.khuyenMai = khuyenMai; } public void setMauSac(MauSac mauSac) { this.mauSac = mauSac; } public void setGiaSanPham(Double giaSanPham) { this.giaSanPham = giaSanPham; } public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; } public void setVatLieu(VatLieu vatLieu) { this.vatLieu = vatLieu; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.SanPhamAdminResponse)) return false;  com.datn.dongho5s.Response.SanPhamAdminResponse other = (com.datn.dongho5s.Response.SanPhamAdminResponse)o; if (!other.canEqual(this)) return false;  Object this$idChiTietSanPham = getIdChiTietSanPham(), other$idChiTietSanPham = other.getIdChiTietSanPham(); if ((this$idChiTietSanPham == null) ? (other$idChiTietSanPham != null) : !this$idChiTietSanPham.equals(other$idChiTietSanPham)) return false;  Object this$giaSanPham = getGiaSanPham(), other$giaSanPham = other.getGiaSanPham(); if ((this$giaSanPham == null) ? (other$giaSanPham != null) : !this$giaSanPham.equals(other$giaSanPham)) return false;  Object this$soLuong = getSoLuong(), other$soLuong = other.getSoLuong(); if ((this$soLuong == null) ? (other$soLuong != null) : !this$soLuong.equals(other$soLuong)) return false;  Object this$maChiTietSanPham = getMaChiTietSanPham(), other$maChiTietSanPham = other.getMaChiTietSanPham(); if ((this$maChiTietSanPham == null) ? (other$maChiTietSanPham != null) : !this$maChiTietSanPham.equals(other$maChiTietSanPham)) return false;  Object this$sanPham = getSanPham(), other$sanPham = other.getSanPham(); if ((this$sanPham == null) ? (other$sanPham != null) : !this$sanPham.equals(other$sanPham)) return false;  Object this$khuyenMai = getKhuyenMai(), other$khuyenMai = other.getKhuyenMai(); if ((this$khuyenMai == null) ? (other$khuyenMai != null) : !this$khuyenMai.equals(other$khuyenMai)) return false;  Object this$mauSac = getMauSac(), other$mauSac = other.getMauSac(); if ((this$mauSac == null) ? (other$mauSac != null) : !this$mauSac.equals(other$mauSac)) return false;  Object this$vatLieu = getVatLieu(), other$vatLieu = other.getVatLieu(); return !((this$vatLieu == null) ? (other$vatLieu != null) : !this$vatLieu.equals(other$vatLieu)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.SanPhamAdminResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $idChiTietSanPham = getIdChiTietSanPham(); result = result * 59 + (($idChiTietSanPham == null) ? 43 : $idChiTietSanPham.hashCode()); Object $giaSanPham = getGiaSanPham(); result = result * 59 + (($giaSanPham == null) ? 43 : $giaSanPham.hashCode()); Object $soLuong = getSoLuong(); result = result * 59 + (($soLuong == null) ? 43 : $soLuong.hashCode()); Object $maChiTietSanPham = getMaChiTietSanPham(); result = result * 59 + (($maChiTietSanPham == null) ? 43 : $maChiTietSanPham.hashCode()); Object $sanPham = getSanPham(); result = result * 59 + (($sanPham == null) ? 43 : $sanPham.hashCode()); Object $khuyenMai = getKhuyenMai(); result = result * 59 + (($khuyenMai == null) ? 43 : $khuyenMai.hashCode()); Object $mauSac = getMauSac(); result = result * 59 + (($mauSac == null) ? 43 : $mauSac.hashCode()); Object $vatLieu = getVatLieu(); return result * 59 + (($vatLieu == null) ? 43 : $vatLieu.hashCode()); } public String toString() { return "SanPhamAdminResponse(idChiTietSanPham=" + getIdChiTietSanPham() + ", maChiTietSanPham=" + getMaChiTietSanPham() + ", sanPham=" + getSanPham() + ", khuyenMai=" + getKhuyenMai() + ", mauSac=" + getMauSac() + ", giaSanPham=" + getGiaSanPham() + ", soLuong=" + getSoLuong() + ", vatLieu=" + getVatLieu() + ")"; } public SanPhamAdminResponse(Integer idChiTietSanPham, String maChiTietSanPham, SanPham sanPham, KhuyenMai khuyenMai, MauSac mauSac, Double giaSanPham, Integer soLuong, VatLieu vatLieu) {
/* 13 */     this.idChiTietSanPham = idChiTietSanPham; this.maChiTietSanPham = maChiTietSanPham; this.sanPham = sanPham; this.khuyenMai = khuyenMai; this.mauSac = mauSac; this.giaSanPham = giaSanPham; this.soLuong = soLuong; this.vatLieu = vatLieu;
/*    */   }
/*    */   public SanPhamAdminResponse() {}
/* 16 */   public Integer getIdChiTietSanPham() { return this.idChiTietSanPham; }
/* 17 */   public String getMaChiTietSanPham() { return this.maChiTietSanPham; }
/* 18 */   public SanPham getSanPham() { return this.sanPham; }
/* 19 */   public KhuyenMai getKhuyenMai() { return this.khuyenMai; }
/* 20 */   public MauSac getMauSac() { return this.mauSac; }
/* 21 */   public Double getGiaSanPham() { return this.giaSanPham; }
/* 22 */   public Integer getSoLuong() { return this.soLuong; } public VatLieu getVatLieu() {
/* 23 */     return this.vatLieu;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\SanPhamAdminResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */