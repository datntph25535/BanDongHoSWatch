/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.DayDeo;
/*    */ import com.datn.dongho5s.Entity.KichCo;
/*    */ import com.datn.dongho5s.Entity.PhanHoi;
/*    */ import com.datn.dongho5s.Entity.SanPham;
/*    */ 
/*    */ public class ChiTietSanPhamResponse {
/*    */   private Integer idChiTietSanPham;
/*    */   private SanPham sanPham;
/*    */   private DayDeo dayDeo;
/*    */   private KhuyenMai khuyenMai;
/*    */   private MauSac mauSac;
/*    */   private VatLieu vatLieu;
/*    */   private KichCo kichCo;
/*    */   
/* 17 */   public void setIdChiTietSanPham(Integer idChiTietSanPham) { this.idChiTietSanPham = idChiTietSanPham; } private Double chieuDaiDayDeo; private Double duongKinhMatDongHo; private Double doDayMatDongHo; private Integer doChiuNuoc; private Integer trangThai; private Double giaSanPham; private Integer soLuong; List<PhanHoi> listPhanHoi; public void setSanPham(SanPham sanPham) { this.sanPham = sanPham; } public void setDayDeo(DayDeo dayDeo) { this.dayDeo = dayDeo; } public void setKhuyenMai(KhuyenMai khuyenMai) { this.khuyenMai = khuyenMai; } public void setMauSac(MauSac mauSac) { this.mauSac = mauSac; } public void setVatLieu(VatLieu vatLieu) { this.vatLieu = vatLieu; } public void setKichCo(KichCo kichCo) { this.kichCo = kichCo; } public void setChieuDaiDayDeo(Double chieuDaiDayDeo) { this.chieuDaiDayDeo = chieuDaiDayDeo; } public void setDuongKinhMatDongHo(Double duongKinhMatDongHo) { this.duongKinhMatDongHo = duongKinhMatDongHo; } public void setDoDayMatDongHo(Double doDayMatDongHo) { this.doDayMatDongHo = doDayMatDongHo; } public void setDoChiuNuoc(Integer doChiuNuoc) { this.doChiuNuoc = doChiuNuoc; } public void setTrangThai(Integer trangThai) { this.trangThai = trangThai; } public void setGiaSanPham(Double giaSanPham) { this.giaSanPham = giaSanPham; } public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; } public void setListPhanHoi(List<PhanHoi> listPhanHoi) { this.listPhanHoi = listPhanHoi; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.ChiTietSanPhamResponse)) return false;  com.datn.dongho5s.Response.ChiTietSanPhamResponse other = (com.datn.dongho5s.Response.ChiTietSanPhamResponse)o; if (!other.canEqual(this)) return false;  Object this$idChiTietSanPham = getIdChiTietSanPham(), other$idChiTietSanPham = other.getIdChiTietSanPham(); if ((this$idChiTietSanPham == null) ? (other$idChiTietSanPham != null) : !this$idChiTietSanPham.equals(other$idChiTietSanPham)) return false;  Object this$chieuDaiDayDeo = getChieuDaiDayDeo(), other$chieuDaiDayDeo = other.getChieuDaiDayDeo(); if ((this$chieuDaiDayDeo == null) ? (other$chieuDaiDayDeo != null) : !this$chieuDaiDayDeo.equals(other$chieuDaiDayDeo)) return false;  Object this$duongKinhMatDongHo = getDuongKinhMatDongHo(), other$duongKinhMatDongHo = other.getDuongKinhMatDongHo(); if ((this$duongKinhMatDongHo == null) ? (other$duongKinhMatDongHo != null) : !this$duongKinhMatDongHo.equals(other$duongKinhMatDongHo)) return false;  Object this$doDayMatDongHo = getDoDayMatDongHo(), other$doDayMatDongHo = other.getDoDayMatDongHo(); if ((this$doDayMatDongHo == null) ? (other$doDayMatDongHo != null) : !this$doDayMatDongHo.equals(other$doDayMatDongHo)) return false;  Object this$doChiuNuoc = getDoChiuNuoc(), other$doChiuNuoc = other.getDoChiuNuoc(); if ((this$doChiuNuoc == null) ? (other$doChiuNuoc != null) : !this$doChiuNuoc.equals(other$doChiuNuoc)) return false;  Object this$trangThai = getTrangThai(), other$trangThai = other.getTrangThai(); if ((this$trangThai == null) ? (other$trangThai != null) : !this$trangThai.equals(other$trangThai)) return false;  Object this$giaSanPham = getGiaSanPham(), other$giaSanPham = other.getGiaSanPham(); if ((this$giaSanPham == null) ? (other$giaSanPham != null) : !this$giaSanPham.equals(other$giaSanPham)) return false;  Object this$soLuong = getSoLuong(), other$soLuong = other.getSoLuong(); if ((this$soLuong == null) ? (other$soLuong != null) : !this$soLuong.equals(other$soLuong)) return false;  Object this$sanPham = getSanPham(), other$sanPham = other.getSanPham(); if ((this$sanPham == null) ? (other$sanPham != null) : !this$sanPham.equals(other$sanPham)) return false;  Object this$dayDeo = getDayDeo(), other$dayDeo = other.getDayDeo(); if ((this$dayDeo == null) ? (other$dayDeo != null) : !this$dayDeo.equals(other$dayDeo)) return false;  Object this$khuyenMai = getKhuyenMai(), other$khuyenMai = other.getKhuyenMai(); if ((this$khuyenMai == null) ? (other$khuyenMai != null) : !this$khuyenMai.equals(other$khuyenMai)) return false;  Object this$mauSac = getMauSac(), other$mauSac = other.getMauSac(); if ((this$mauSac == null) ? (other$mauSac != null) : !this$mauSac.equals(other$mauSac)) return false;  Object this$vatLieu = getVatLieu(), other$vatLieu = other.getVatLieu(); if ((this$vatLieu == null) ? (other$vatLieu != null) : !this$vatLieu.equals(other$vatLieu)) return false;  Object this$kichCo = getKichCo(), other$kichCo = other.getKichCo(); if ((this$kichCo == null) ? (other$kichCo != null) : !this$kichCo.equals(other$kichCo)) return false;  Object<PhanHoi> this$listPhanHoi = (Object<PhanHoi>)getListPhanHoi(), other$listPhanHoi = (Object<PhanHoi>)other.getListPhanHoi(); return !((this$listPhanHoi == null) ? (other$listPhanHoi != null) : !this$listPhanHoi.equals(other$listPhanHoi)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.ChiTietSanPhamResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $idChiTietSanPham = getIdChiTietSanPham(); result = result * 59 + (($idChiTietSanPham == null) ? 43 : $idChiTietSanPham.hashCode()); Object $chieuDaiDayDeo = getChieuDaiDayDeo(); result = result * 59 + (($chieuDaiDayDeo == null) ? 43 : $chieuDaiDayDeo.hashCode()); Object $duongKinhMatDongHo = getDuongKinhMatDongHo(); result = result * 59 + (($duongKinhMatDongHo == null) ? 43 : $duongKinhMatDongHo.hashCode()); Object $doDayMatDongHo = getDoDayMatDongHo(); result = result * 59 + (($doDayMatDongHo == null) ? 43 : $doDayMatDongHo.hashCode()); Object $doChiuNuoc = getDoChiuNuoc(); result = result * 59 + (($doChiuNuoc == null) ? 43 : $doChiuNuoc.hashCode()); Object $trangThai = getTrangThai(); result = result * 59 + (($trangThai == null) ? 43 : $trangThai.hashCode()); Object $giaSanPham = getGiaSanPham(); result = result * 59 + (($giaSanPham == null) ? 43 : $giaSanPham.hashCode()); Object $soLuong = getSoLuong(); result = result * 59 + (($soLuong == null) ? 43 : $soLuong.hashCode()); Object $sanPham = getSanPham(); result = result * 59 + (($sanPham == null) ? 43 : $sanPham.hashCode()); Object $dayDeo = getDayDeo(); result = result * 59 + (($dayDeo == null) ? 43 : $dayDeo.hashCode()); Object $khuyenMai = getKhuyenMai(); result = result * 59 + (($khuyenMai == null) ? 43 : $khuyenMai.hashCode()); Object $mauSac = getMauSac(); result = result * 59 + (($mauSac == null) ? 43 : $mauSac.hashCode()); Object $vatLieu = getVatLieu(); result = result * 59 + (($vatLieu == null) ? 43 : $vatLieu.hashCode()); Object $kichCo = getKichCo(); result = result * 59 + (($kichCo == null) ? 43 : $kichCo.hashCode()); Object<PhanHoi> $listPhanHoi = (Object<PhanHoi>)getListPhanHoi(); return result * 59 + (($listPhanHoi == null) ? 43 : $listPhanHoi.hashCode()); } public String toString() { return "ChiTietSanPhamResponse(idChiTietSanPham=" + getIdChiTietSanPham() + ", sanPham=" + getSanPham() + ", dayDeo=" + getDayDeo() + ", khuyenMai=" + getKhuyenMai() + ", mauSac=" + getMauSac() + ", vatLieu=" + getVatLieu() + ", kichCo=" + getKichCo() + ", chieuDaiDayDeo=" + getChieuDaiDayDeo() + ", duongKinhMatDongHo=" + getDuongKinhMatDongHo() + ", doDayMatDongHo=" + getDoDayMatDongHo() + ", doChiuNuoc=" + getDoChiuNuoc() + ", trangThai=" + getTrangThai() + ", giaSanPham=" + getGiaSanPham() + ", soLuong=" + getSoLuong() + ", listPhanHoi=" + getListPhanHoi() + ")"; } public ChiTietSanPhamResponse(Integer idChiTietSanPham, SanPham sanPham, DayDeo dayDeo, KhuyenMai khuyenMai, MauSac mauSac, VatLieu vatLieu, KichCo kichCo, Double chieuDaiDayDeo, Double duongKinhMatDongHo, Double doDayMatDongHo, Integer doChiuNuoc, Integer trangThai, Double giaSanPham, Integer soLuong, List<PhanHoi> listPhanHoi) {
/* 18 */     this.idChiTietSanPham = idChiTietSanPham; this.sanPham = sanPham; this.dayDeo = dayDeo; this.khuyenMai = khuyenMai; this.mauSac = mauSac; this.vatLieu = vatLieu; this.kichCo = kichCo; this.chieuDaiDayDeo = chieuDaiDayDeo; this.duongKinhMatDongHo = duongKinhMatDongHo; this.doDayMatDongHo = doDayMatDongHo; this.doChiuNuoc = doChiuNuoc; this.trangThai = trangThai; this.giaSanPham = giaSanPham; this.soLuong = soLuong; this.listPhanHoi = listPhanHoi;
/*    */   } public ChiTietSanPhamResponse() {} public static ChiTietSanPhamResponseBuilder builder() {
/* 20 */     return new ChiTietSanPhamResponseBuilder();
/*    */   } public Integer getIdChiTietSanPham() {
/* 22 */     return this.idChiTietSanPham;
/*    */   } public SanPham getSanPham() {
/* 24 */     return this.sanPham;
/*    */   } public DayDeo getDayDeo() {
/* 26 */     return this.dayDeo;
/*    */   } public KhuyenMai getKhuyenMai() {
/* 28 */     return this.khuyenMai;
/*    */   } public MauSac getMauSac() {
/* 30 */     return this.mauSac;
/*    */   } public VatLieu getVatLieu() {
/* 32 */     return this.vatLieu;
/*    */   } public KichCo getKichCo() {
/* 34 */     return this.kichCo;
/*    */   } public Double getChieuDaiDayDeo() {
/* 36 */     return this.chieuDaiDayDeo;
/*    */   } public Double getDuongKinhMatDongHo() {
/* 38 */     return this.duongKinhMatDongHo;
/*    */   } public Double getDoDayMatDongHo() {
/* 40 */     return this.doDayMatDongHo;
/*    */   } public Integer getDoChiuNuoc() {
/* 42 */     return this.doChiuNuoc;
/*    */   } public Integer getTrangThai() {
/* 44 */     return this.trangThai;
/*    */   } public Double getGiaSanPham() {
/* 46 */     return this.giaSanPham;
/*    */   }
/* 48 */   public Integer getSoLuong() { return this.soLuong; } public List<PhanHoi> getListPhanHoi() {
/* 49 */     return this.listPhanHoi;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\ChiTietSanPhamResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */