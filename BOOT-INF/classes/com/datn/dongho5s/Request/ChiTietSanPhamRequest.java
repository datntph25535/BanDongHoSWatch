/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.DayDeo;
/*    */ import com.datn.dongho5s.Entity.KhuyenMai;
/*    */ import com.datn.dongho5s.Entity.KichCo;
/*    */ import com.datn.dongho5s.Entity.MauSac;
/*    */ import com.datn.dongho5s.Entity.SanPham;
/*    */ import com.datn.dongho5s.Entity.VatLieu;
/*    */ 
/*    */ public class ChiTietSanPhamRequest {
/*    */   private Integer idChiTietSanPham;
/*    */   private SanPham sanPham;
/*    */   private DayDeo dayDeo;
/*    */   private KhuyenMai khuyenMai;
/*    */   private MauSac mauSac;
/*    */   private VatLieu vatLieu;
/*    */   private KichCo kichCo;
/*    */   
/*    */   public void setIdChiTietSanPham(Integer idChiTietSanPham) {
/* 20 */     this.idChiTietSanPham = idChiTietSanPham; } private Double chieuDaiDayDeo; private Double duongKinhMatDongHo; private Double doDayMatDongHo; private Integer doChiuNuoc; private Integer trangThai; private Double giaSanPham; private Integer soLuong; public void setSanPham(SanPham sanPham) { this.sanPham = sanPham; } public void setDayDeo(DayDeo dayDeo) { this.dayDeo = dayDeo; } public void setKhuyenMai(KhuyenMai khuyenMai) { this.khuyenMai = khuyenMai; } public void setMauSac(MauSac mauSac) { this.mauSac = mauSac; } public void setVatLieu(VatLieu vatLieu) { this.vatLieu = vatLieu; } public void setKichCo(KichCo kichCo) { this.kichCo = kichCo; } public void setChieuDaiDayDeo(Double chieuDaiDayDeo) { this.chieuDaiDayDeo = chieuDaiDayDeo; } public void setDuongKinhMatDongHo(Double duongKinhMatDongHo) { this.duongKinhMatDongHo = duongKinhMatDongHo; } public void setDoDayMatDongHo(Double doDayMatDongHo) { this.doDayMatDongHo = doDayMatDongHo; } public void setDoChiuNuoc(Integer doChiuNuoc) { this.doChiuNuoc = doChiuNuoc; } public void setTrangThai(Integer trangThai) { this.trangThai = trangThai; } public void setGiaSanPham(Double giaSanPham) { this.giaSanPham = giaSanPham; } public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.ChiTietSanPhamRequest)) return false;  com.datn.dongho5s.Request.ChiTietSanPhamRequest other = (com.datn.dongho5s.Request.ChiTietSanPhamRequest)o; if (!other.canEqual(this)) return false;  Object this$idChiTietSanPham = getIdChiTietSanPham(), other$idChiTietSanPham = other.getIdChiTietSanPham(); if ((this$idChiTietSanPham == null) ? (other$idChiTietSanPham != null) : !this$idChiTietSanPham.equals(other$idChiTietSanPham)) return false;  Object this$chieuDaiDayDeo = getChieuDaiDayDeo(), other$chieuDaiDayDeo = other.getChieuDaiDayDeo(); if ((this$chieuDaiDayDeo == null) ? (other$chieuDaiDayDeo != null) : !this$chieuDaiDayDeo.equals(other$chieuDaiDayDeo)) return false;  Object this$duongKinhMatDongHo = getDuongKinhMatDongHo(), other$duongKinhMatDongHo = other.getDuongKinhMatDongHo(); if ((this$duongKinhMatDongHo == null) ? (other$duongKinhMatDongHo != null) : !this$duongKinhMatDongHo.equals(other$duongKinhMatDongHo)) return false;  Object this$doDayMatDongHo = getDoDayMatDongHo(), other$doDayMatDongHo = other.getDoDayMatDongHo(); if ((this$doDayMatDongHo == null) ? (other$doDayMatDongHo != null) : !this$doDayMatDongHo.equals(other$doDayMatDongHo)) return false;  Object this$doChiuNuoc = getDoChiuNuoc(), other$doChiuNuoc = other.getDoChiuNuoc(); if ((this$doChiuNuoc == null) ? (other$doChiuNuoc != null) : !this$doChiuNuoc.equals(other$doChiuNuoc)) return false;  Object this$trangThai = getTrangThai(), other$trangThai = other.getTrangThai(); if ((this$trangThai == null) ? (other$trangThai != null) : !this$trangThai.equals(other$trangThai)) return false;  Object this$giaSanPham = getGiaSanPham(), other$giaSanPham = other.getGiaSanPham(); if ((this$giaSanPham == null) ? (other$giaSanPham != null) : !this$giaSanPham.equals(other$giaSanPham)) return false;  Object this$soLuong = getSoLuong(), other$soLuong = other.getSoLuong(); if ((this$soLuong == null) ? (other$soLuong != null) : !this$soLuong.equals(other$soLuong)) return false;  Object this$sanPham = getSanPham(), other$sanPham = other.getSanPham(); if ((this$sanPham == null) ? (other$sanPham != null) : !this$sanPham.equals(other$sanPham)) return false;  Object this$dayDeo = getDayDeo(), other$dayDeo = other.getDayDeo(); if ((this$dayDeo == null) ? (other$dayDeo != null) : !this$dayDeo.equals(other$dayDeo)) return false;  Object this$khuyenMai = getKhuyenMai(), other$khuyenMai = other.getKhuyenMai(); if ((this$khuyenMai == null) ? (other$khuyenMai != null) : !this$khuyenMai.equals(other$khuyenMai)) return false;  Object this$mauSac = getMauSac(), other$mauSac = other.getMauSac(); if ((this$mauSac == null) ? (other$mauSac != null) : !this$mauSac.equals(other$mauSac)) return false;  Object this$vatLieu = getVatLieu(), other$vatLieu = other.getVatLieu(); if ((this$vatLieu == null) ? (other$vatLieu != null) : !this$vatLieu.equals(other$vatLieu)) return false;  Object this$kichCo = getKichCo(), other$kichCo = other.getKichCo(); return !((this$kichCo == null) ? (other$kichCo != null) : !this$kichCo.equals(other$kichCo)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.ChiTietSanPhamRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $idChiTietSanPham = getIdChiTietSanPham(); result = result * 59 + (($idChiTietSanPham == null) ? 43 : $idChiTietSanPham.hashCode()); Object $chieuDaiDayDeo = getChieuDaiDayDeo(); result = result * 59 + (($chieuDaiDayDeo == null) ? 43 : $chieuDaiDayDeo.hashCode()); Object $duongKinhMatDongHo = getDuongKinhMatDongHo(); result = result * 59 + (($duongKinhMatDongHo == null) ? 43 : $duongKinhMatDongHo.hashCode()); Object $doDayMatDongHo = getDoDayMatDongHo(); result = result * 59 + (($doDayMatDongHo == null) ? 43 : $doDayMatDongHo.hashCode()); Object $doChiuNuoc = getDoChiuNuoc(); result = result * 59 + (($doChiuNuoc == null) ? 43 : $doChiuNuoc.hashCode()); Object $trangThai = getTrangThai(); result = result * 59 + (($trangThai == null) ? 43 : $trangThai.hashCode()); Object $giaSanPham = getGiaSanPham(); result = result * 59 + (($giaSanPham == null) ? 43 : $giaSanPham.hashCode()); Object $soLuong = getSoLuong(); result = result * 59 + (($soLuong == null) ? 43 : $soLuong.hashCode()); Object $sanPham = getSanPham(); result = result * 59 + (($sanPham == null) ? 43 : $sanPham.hashCode()); Object $dayDeo = getDayDeo(); result = result * 59 + (($dayDeo == null) ? 43 : $dayDeo.hashCode()); Object $khuyenMai = getKhuyenMai(); result = result * 59 + (($khuyenMai == null) ? 43 : $khuyenMai.hashCode()); Object $mauSac = getMauSac(); result = result * 59 + (($mauSac == null) ? 43 : $mauSac.hashCode()); Object $vatLieu = getVatLieu(); result = result * 59 + (($vatLieu == null) ? 43 : $vatLieu.hashCode()); Object $kichCo = getKichCo(); return result * 59 + (($kichCo == null) ? 43 : $kichCo.hashCode()); } public String toString() { return "ChiTietSanPhamRequest(idChiTietSanPham=" + getIdChiTietSanPham() + ", sanPham=" + getSanPham() + ", dayDeo=" + getDayDeo() + ", khuyenMai=" + getKhuyenMai() + ", mauSac=" + getMauSac() + ", vatLieu=" + getVatLieu() + ", kichCo=" + getKichCo() + ", chieuDaiDayDeo=" + getChieuDaiDayDeo() + ", duongKinhMatDongHo=" + getDuongKinhMatDongHo() + ", doDayMatDongHo=" + getDoDayMatDongHo() + ", doChiuNuoc=" + getDoChiuNuoc() + ", trangThai=" + getTrangThai() + ", giaSanPham=" + getGiaSanPham() + ", soLuong=" + getSoLuong() + ")"; } public ChiTietSanPhamRequest(Integer idChiTietSanPham, SanPham sanPham, DayDeo dayDeo, KhuyenMai khuyenMai, MauSac mauSac, VatLieu vatLieu, KichCo kichCo, Double chieuDaiDayDeo, Double duongKinhMatDongHo, Double doDayMatDongHo, Integer doChiuNuoc, Integer trangThai, Double giaSanPham, Integer soLuong) {
/* 21 */     this.idChiTietSanPham = idChiTietSanPham; this.sanPham = sanPham; this.dayDeo = dayDeo; this.khuyenMai = khuyenMai; this.mauSac = mauSac; this.vatLieu = vatLieu; this.kichCo = kichCo; this.chieuDaiDayDeo = chieuDaiDayDeo; this.duongKinhMatDongHo = duongKinhMatDongHo; this.doDayMatDongHo = doDayMatDongHo; this.doChiuNuoc = doChiuNuoc; this.trangThai = trangThai; this.giaSanPham = giaSanPham; this.soLuong = soLuong;
/*    */   } public ChiTietSanPhamRequest() {} public static ChiTietSanPhamRequestBuilder builder() {
/* 23 */     return new ChiTietSanPhamRequestBuilder();
/*    */   } public Integer getIdChiTietSanPham() {
/* 25 */     return this.idChiTietSanPham;
/*    */   } public SanPham getSanPham() {
/* 27 */     return this.sanPham;
/*    */   } public DayDeo getDayDeo() {
/* 29 */     return this.dayDeo;
/*    */   } public KhuyenMai getKhuyenMai() {
/* 31 */     return this.khuyenMai;
/*    */   } public MauSac getMauSac() {
/* 33 */     return this.mauSac;
/*    */   } public VatLieu getVatLieu() {
/* 35 */     return this.vatLieu;
/*    */   } public KichCo getKichCo() {
/* 37 */     return this.kichCo;
/*    */   } public Double getChieuDaiDayDeo() {
/* 39 */     return this.chieuDaiDayDeo;
/*    */   } public Double getDuongKinhMatDongHo() {
/* 41 */     return this.duongKinhMatDongHo;
/*    */   } public Double getDoDayMatDongHo() {
/* 43 */     return this.doDayMatDongHo;
/*    */   } public Integer getDoChiuNuoc() {
/* 45 */     return this.doChiuNuoc;
/*    */   } public Integer getTrangThai() {
/* 47 */     return this.trangThai;
/*    */   } public Double getGiaSanPham() {
/* 49 */     return this.giaSanPham;
/*    */   } public Integer getSoLuong() {
/* 51 */     return this.soLuong;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\ChiTietSanPhamRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */