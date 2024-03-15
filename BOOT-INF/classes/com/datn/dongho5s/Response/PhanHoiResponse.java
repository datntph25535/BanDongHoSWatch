/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class PhanHoiResponse {
/*    */   private Integer idPhanHoi;
/*    */   private KhachHang khachHang;
/*    */   private ChiTietSanPham chiTietSanPham;
/*    */   private String noiDungPhanHoi;
/*    */   private Timestamp thoiGianPhanHoi;
/*    */   
/* 13 */   public void setIdPhanHoi(Integer idPhanHoi) { this.idPhanHoi = idPhanHoi; } private Integer trangThaiPhanHoi; private Integer danhGia; private String ghiChu; private Date ngayTao; private Date ngaySua; public void setKhachHang(KhachHang khachHang) { this.khachHang = khachHang; } public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) { this.chiTietSanPham = chiTietSanPham; } public void setNoiDungPhanHoi(String noiDungPhanHoi) { this.noiDungPhanHoi = noiDungPhanHoi; } public void setThoiGianPhanHoi(Timestamp thoiGianPhanHoi) { this.thoiGianPhanHoi = thoiGianPhanHoi; } public void setTrangThaiPhanHoi(Integer trangThaiPhanHoi) { this.trangThaiPhanHoi = trangThaiPhanHoi; } public void setDanhGia(Integer danhGia) { this.danhGia = danhGia; } public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; } public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; } public void setNgaySua(Date ngaySua) { this.ngaySua = ngaySua; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.PhanHoiResponse)) return false;  com.datn.dongho5s.Response.PhanHoiResponse other = (com.datn.dongho5s.Response.PhanHoiResponse)o; if (!other.canEqual(this)) return false;  Object this$idPhanHoi = getIdPhanHoi(), other$idPhanHoi = other.getIdPhanHoi(); if ((this$idPhanHoi == null) ? (other$idPhanHoi != null) : !this$idPhanHoi.equals(other$idPhanHoi)) return false;  Object this$trangThaiPhanHoi = getTrangThaiPhanHoi(), other$trangThaiPhanHoi = other.getTrangThaiPhanHoi(); if ((this$trangThaiPhanHoi == null) ? (other$trangThaiPhanHoi != null) : !this$trangThaiPhanHoi.equals(other$trangThaiPhanHoi)) return false;  Object this$danhGia = getDanhGia(), other$danhGia = other.getDanhGia(); if ((this$danhGia == null) ? (other$danhGia != null) : !this$danhGia.equals(other$danhGia)) return false;  Object this$khachHang = getKhachHang(), other$khachHang = other.getKhachHang(); if ((this$khachHang == null) ? (other$khachHang != null) : !this$khachHang.equals(other$khachHang)) return false;  Object this$chiTietSanPham = getChiTietSanPham(), other$chiTietSanPham = other.getChiTietSanPham(); if ((this$chiTietSanPham == null) ? (other$chiTietSanPham != null) : !this$chiTietSanPham.equals(other$chiTietSanPham)) return false;  Object this$noiDungPhanHoi = getNoiDungPhanHoi(), other$noiDungPhanHoi = other.getNoiDungPhanHoi(); if ((this$noiDungPhanHoi == null) ? (other$noiDungPhanHoi != null) : !this$noiDungPhanHoi.equals(other$noiDungPhanHoi)) return false;  Object this$thoiGianPhanHoi = getThoiGianPhanHoi(), other$thoiGianPhanHoi = other.getThoiGianPhanHoi(); if ((this$thoiGianPhanHoi == null) ? (other$thoiGianPhanHoi != null) : !this$thoiGianPhanHoi.equals(other$thoiGianPhanHoi)) return false;  Object this$ghiChu = getGhiChu(), other$ghiChu = other.getGhiChu(); if ((this$ghiChu == null) ? (other$ghiChu != null) : !this$ghiChu.equals(other$ghiChu)) return false;  Object this$ngayTao = getNgayTao(), other$ngayTao = other.getNgayTao(); if ((this$ngayTao == null) ? (other$ngayTao != null) : !this$ngayTao.equals(other$ngayTao)) return false;  Object this$ngaySua = getNgaySua(), other$ngaySua = other.getNgaySua(); return !((this$ngaySua == null) ? (other$ngaySua != null) : !this$ngaySua.equals(other$ngaySua)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.PhanHoiResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $idPhanHoi = getIdPhanHoi(); result = result * 59 + (($idPhanHoi == null) ? 43 : $idPhanHoi.hashCode()); Object $trangThaiPhanHoi = getTrangThaiPhanHoi(); result = result * 59 + (($trangThaiPhanHoi == null) ? 43 : $trangThaiPhanHoi.hashCode()); Object $danhGia = getDanhGia(); result = result * 59 + (($danhGia == null) ? 43 : $danhGia.hashCode()); Object $khachHang = getKhachHang(); result = result * 59 + (($khachHang == null) ? 43 : $khachHang.hashCode()); Object $chiTietSanPham = getChiTietSanPham(); result = result * 59 + (($chiTietSanPham == null) ? 43 : $chiTietSanPham.hashCode()); Object $noiDungPhanHoi = getNoiDungPhanHoi(); result = result * 59 + (($noiDungPhanHoi == null) ? 43 : $noiDungPhanHoi.hashCode()); Object $thoiGianPhanHoi = getThoiGianPhanHoi(); result = result * 59 + (($thoiGianPhanHoi == null) ? 43 : $thoiGianPhanHoi.hashCode()); Object $ghiChu = getGhiChu(); result = result * 59 + (($ghiChu == null) ? 43 : $ghiChu.hashCode()); Object $ngayTao = getNgayTao(); result = result * 59 + (($ngayTao == null) ? 43 : $ngayTao.hashCode()); Object $ngaySua = getNgaySua(); return result * 59 + (($ngaySua == null) ? 43 : $ngaySua.hashCode()); } public String toString() { return "PhanHoiResponse(idPhanHoi=" + getIdPhanHoi() + ", khachHang=" + getKhachHang() + ", chiTietSanPham=" + getChiTietSanPham() + ", noiDungPhanHoi=" + getNoiDungPhanHoi() + ", thoiGianPhanHoi=" + getThoiGianPhanHoi() + ", trangThaiPhanHoi=" + getTrangThaiPhanHoi() + ", danhGia=" + getDanhGia() + ", ghiChu=" + getGhiChu() + ", ngayTao=" + getNgayTao() + ", ngaySua=" + getNgaySua() + ")"; } public PhanHoiResponse(Integer idPhanHoi, KhachHang khachHang, ChiTietSanPham chiTietSanPham, String noiDungPhanHoi, Timestamp thoiGianPhanHoi, Integer trangThaiPhanHoi, Integer danhGia, String ghiChu, Date ngayTao, Date ngaySua) {
/* 14 */     this.idPhanHoi = idPhanHoi; this.khachHang = khachHang; this.chiTietSanPham = chiTietSanPham; this.noiDungPhanHoi = noiDungPhanHoi; this.thoiGianPhanHoi = thoiGianPhanHoi; this.trangThaiPhanHoi = trangThaiPhanHoi; this.danhGia = danhGia; this.ghiChu = ghiChu; this.ngayTao = ngayTao; this.ngaySua = ngaySua;
/*    */   } public PhanHoiResponse() {} public static PhanHoiResponseBuilder builder() {
/* 16 */     return new PhanHoiResponseBuilder();
/*    */   } public Integer getIdPhanHoi() {
/* 18 */     return this.idPhanHoi;
/*    */   } public KhachHang getKhachHang() {
/* 20 */     return this.khachHang;
/*    */   } public ChiTietSanPham getChiTietSanPham() {
/* 22 */     return this.chiTietSanPham;
/*    */   } public String getNoiDungPhanHoi() {
/* 24 */     return this.noiDungPhanHoi;
/*    */   } public Timestamp getThoiGianPhanHoi() {
/* 26 */     return this.thoiGianPhanHoi;
/*    */   } public Integer getTrangThaiPhanHoi() {
/* 28 */     return this.trangThaiPhanHoi;
/*    */   } public Integer getDanhGia() {
/* 30 */     return this.danhGia;
/*    */   } public String getGhiChu() {
/* 32 */     return this.ghiChu;
/*    */   } public Date getNgayTao() {
/* 34 */     return this.ngayTao;
/*    */   } public Date getNgaySua() {
/* 36 */     return this.ngaySua;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\PhanHoiResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */