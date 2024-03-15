/*    */ package BOOT-INF.classes.com.datn.dongho5s.mapper;
/*    */ 
/*    */ import com.datn.dongho5s.Cache.DiaChiCache;
/*    */ import com.datn.dongho5s.Entity.DonHang;
/*    */ import com.datn.dongho5s.GiaoHangNhanhService.DiaChiAPI;
/*    */ import com.datn.dongho5s.Response.DonHangResponse;
/*    */ import java.text.DateFormat;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.HashMap;
/*    */ import java.util.TimeZone;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DonHangMapping
/*    */ {
/*    */   public boolean equals(Object o) {
/* 17 */     if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.mapper.DonHangMapping)) return false;  com.datn.dongho5s.mapper.DonHangMapping other = (com.datn.dongho5s.mapper.DonHangMapping)o; return !!other.canEqual(this); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.mapper.DonHangMapping; } public int hashCode() { int result = 1; return 1; } public String toString() { return "DonHangMapping()"; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static DonHangResponse mapEntitytoResponseBT(DonHang donHang) throws Exception {
/* 37 */     DonHangResponse donHangResponse = DonHangResponse.builder().idDonHang(donHang.getIdDonHang()).maDonHang(donHang.getMaDonHang()).diaChi(donHang.getDiaChi()).ghiChu(donHang.getGhiChu()).PhuongXa(getXa(donHang.getIdQuanHuyen(), donHang.getIdPhuongXa())).QuanHuyen(getQuan(donHang.getIdTinhThanh(), donHang.getIdQuanHuyen())).TinhThanh(getTinh(donHang.getIdTinhThanh())).ngayTao(donHang.getNgayTao()).ngayGiaoHang(donHang.getNgayGiaoHang()).khachHang(donHang.getKhachHang()).phiVanChuyen(donHang.getPhiVanChuyen()).trangThaiDonHang(donHang.getTrangThaiDonHang()).tongTien(donHang.getTongTien()).hoaDonChiTiets(donHang.getListHoaDonChiTiet()).lyDo(donHang.getLyDo()).build();
/* 38 */     return donHangResponse;
/*    */   }
/*    */   
/*    */   public static DonHangResponse mapEntitytoResponse(DonHang donHang) throws Exception {
/* 42 */     TimeZone tz = TimeZone.getTimeZone("UTC");
/* 43 */     DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
/* 44 */     df.setTimeZone(tz);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 63 */     DonHangResponse donHangResponse = DonHangResponse.builder().idDonHang(donHang.getIdDonHang()).maDonHang(donHang.getMaDonHang()).diaChi(donHang.getDiaChi()).ghiChu(donHang.getGhiChu()).PhuongXa(getXa(donHang.getIdQuanHuyen(), donHang.getIdPhuongXa())).QuanHuyen(getQuan(donHang.getIdTinhThanh(), donHang.getIdQuanHuyen())).TinhThanh(getTinh(donHang.getIdTinhThanh())).ngayTao(donHang.getNgayTao()).ngayGiaoHang(donHang.getNgayGiaoHang()).khachHang(donHang.getKhachHang()).phiVanChuyen(donHang.getPhiVanChuyen()).trangThaiDonHang(donHang.getTrangThaiDonHang()).tongTien(donHang.getTongTien()).hoaDonChiTiets(donHang.getListHoaDonChiTiet()).lyDo(donHang.getLyDo()).ngayCapNhap(df.format(donHang.getNgayCapNhap())).build();
/* 64 */     return donHangResponse;
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getTinh(Integer idTP) throws Exception {
/* 69 */     HashMap<Integer, String> listTP = DiaChiCache.hashMapTinhThanh;
/* 70 */     String tinh = listTP.get(idTP);
/* 71 */     return tinh;
/*    */   }
/*    */   public static String getQuan(Integer idTP, Integer idQH) throws Exception {
/* 74 */     HashMap<Integer, String> listQH = DiaChiAPI.callGetQuanHuyenAPI(idTP);
/* 75 */     String quan = listQH.get(idQH);
/* 76 */     return quan;
/*    */   }
/*    */   public static String getXa(Integer idQH, String idPX) throws Exception {
/* 79 */     HashMap<String, String> listPX = DiaChiAPI.callGetPhuongXaAPI(idQH);
/* 80 */     String xa = listPX.get(idPX);
/* 81 */     return xa;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\mapper\DonHangMapping.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */