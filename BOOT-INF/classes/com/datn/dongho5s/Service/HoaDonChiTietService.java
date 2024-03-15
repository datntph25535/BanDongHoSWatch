package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.ChiTietSanPham;
import com.datn.dongho5s.Entity.DonHang;
import com.datn.dongho5s.Entity.HoaDonChiTiet;
import com.datn.dongho5s.Request.HoaDonChiTietRequest;
import java.util.List;

public interface HoaDonChiTietService {
  HoaDonChiTiet save(HoaDonChiTiet paramHoaDonChiTiet);
  
  List<HoaDonChiTiet> convertToListHoaDonChiTiet(List<HoaDonChiTietRequest> paramList, Integer paramInteger);
  
  List<HoaDonChiTiet> saveAll(List<HoaDonChiTiet> paramList);
  
  Double getTongGia(List<HoaDonChiTietRequest> paramList);
  
  List<HoaDonChiTiet> getByIdDonHang(int paramInt);
  
  List<HoaDonChiTiet> getByHoaDonId(DonHang paramDonHang);
  
  List<HoaDonChiTiet> getHDCTByMaDonHang(String paramString);
  
  void themSoLuongSanPham(int paramInt, ChiTietSanPham paramChiTietSanPham, DonHang paramDonHang);
  
  void xoaHDCT(HoaDonChiTiet paramHoaDonChiTiet);
  
  HoaDonChiTiet findHoaDonChiTietById(int paramInt);
  
  void updateSoLuongImeiThem(HoaDonChiTiet paramHoaDonChiTiet, int paramInt);
  
  void xoaHDCTByIdDonHang(DonHang paramDonHang);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\HoaDonChiTietService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */