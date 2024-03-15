package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.DonHang;
import com.datn.dongho5s.Request.DonHangRequest;
import com.datn.dongho5s.Response.DonHangResponse;
import com.datn.dongho5s.Response.HoaDonChiTietResponse;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;

public interface DonHangService {
  public static final int DONHANG_PAGE = 10;
  
  DonHang save(DonHang paramDonHang);
  
  DonHang getById(Integer paramInteger);
  
  Page<DonHang> getAll(int paramInt);
  
  List<DonHang> findByNgayTao(Date paramDate1, Date paramDate2, Integer paramInteger);
  
  Double tongTien(int paramInt);
  
  DonHang findById(int paramInt);
  
  void updateTrangThaiDonHang(DonHang paramDonHang);
  
  List<HoaDonChiTietResponse> findHDCTbyDH(Integer paramInteger);
  
  List<DonHangResponse> findAllHD(Integer paramInteger) throws Exception;
  
  List<DonHangResponse> findHDByStatus(Integer paramInteger1, Integer paramInteger2) throws Exception;
  
  DonHangResponse updateDH(DonHangRequest paramDonHangRequest);
  
  List<DonHang> findByTrangThaiDonHang(int paramInt);
  
  Page<DonHang> getAllForBanHang(int paramInt);
  
  DonHang findByMaDonHang(String paramString);
  
  String thanhToanAdmin(DonHang paramDonHang);
  
  String xoaDonHangAdmin(DonHang paramDonHang);
  
  void xoaDonHang(DonHang paramDonHang);
  
  List<DonHang> getAllDonHang();
  
  List<DonHang> getAllPaginationDonHang();
  
  Page<DonHang> listByPage(int paramInt, String paramString1, String paramString2, String paramString3);
  
  Page<DonHang> listByPageStatus(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2);
  
  Integer countDHbyStatus(Integer paramInteger);
  
  Integer countDHAll();
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\DonHangService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */