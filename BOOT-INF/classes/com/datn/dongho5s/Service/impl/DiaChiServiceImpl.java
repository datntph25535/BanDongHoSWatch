/*     */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*     */ 
/*     */ import com.datn.dongho5s.Cache.DiaChiCache;
/*     */ import com.datn.dongho5s.Entity.DiaChi;
/*     */ import com.datn.dongho5s.Entity.KhachHang;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.DiaChiAPI;
/*     */ import com.datn.dongho5s.Repository.DiaChiRepository;
/*     */ import com.datn.dongho5s.Repository.KhachHangRepository;
/*     */ import com.datn.dongho5s.Request.DiaChiRequest;
/*     */ import com.datn.dongho5s.Response.DiaChiResponse;
/*     */ import com.datn.dongho5s.Service.DiaChiService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service
/*     */ public class DiaChiServiceImpl
/*     */   implements DiaChiService {
/*     */   public DiaChiServiceImpl(DiaChiRepository diaChiRepository, KhachHangRepository khachHangRepository) {
/*  21 */     this.diaChiRepository = diaChiRepository; this.khachHangRepository = khachHangRepository;
/*     */   }
/*     */ 
/*     */   
/*     */   private final DiaChiRepository diaChiRepository;
/*     */   
/*     */   private final KhachHangRepository khachHangRepository;
/*     */   
/*     */   public DiaChiResponse createDiaChi(Integer idKhachHang, DiaChiRequest diaChiRequest) throws Exception {
/*  30 */     KhachHang khachHang = this.khachHangRepository.findById(idKhachHang).get();
/*  31 */     if (khachHang == null) return null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  42 */     DiaChi d = DiaChi.builder().idTinhThanh(diaChiRequest.getIdTinhThanh()).idQuanHuyen(diaChiRequest.getIdQuanHuyen()).idPhuongXa(diaChiRequest.getIdPhuongXa()).diaChi(diaChiRequest.getDiaChi()).ghiChu(diaChiRequest.getGhiChu()).soDienThoai(diaChiRequest.getSoDienThoai()).maBuuChinh(Integer.valueOf(123)).trangThaiMacDinh(Integer.valueOf(0)).khachHang(khachHang).build();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  56 */     DiaChiResponse diaChiResponse = DiaChiResponse.builder().idDiaChi(d.getIdDiaChi()).idTinhThanh(d.getIdTinhThanh()).idQuanHuyen(d.getIdQuanHuyen()).idPhuongXa(d.getIdPhuongXa()).thanhPho(getTinh(d.getIdTinhThanh())).quanHuyen(getQuan(d.getIdTinhThanh(), d.getIdQuanHuyen())).phuongXa(getXa(d.getIdQuanHuyen(), d.getIdPhuongXa())).diaChi(d.getDiaChi()).ghiChu(d.getGhiChu()).soDienThoai(d.getSoDienThoai()).trangThaiMacDinh(d.getTrangThaiMacDinh()).khachHang(d.getKhachHang()).build();
/*  57 */     this.diaChiRepository.save(d);
/*  58 */     return diaChiResponse;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<DiaChi> getAllDiaChi() {
/*  63 */     return this.diaChiRepository.findAll();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<DiaChi> getAllDiaChiByKhachHang(KhachHang khachHang) {
/*  68 */     return this.diaChiRepository.findByKhachHang(khachHang);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<DiaChiResponse> getDiaChiByKhachHang(Integer idKhachHang) throws Exception {
/*  73 */     List<DiaChi> listDiaChi = this.diaChiRepository.findByIdKH(idKhachHang);
/*  74 */     List<DiaChiResponse> listDiaChiResponse = new ArrayList<>();
/*  75 */     for (DiaChi d : listDiaChi) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  89 */       DiaChiResponse diaChiResponse = DiaChiResponse.builder().idDiaChi(d.getIdDiaChi()).idTinhThanh(d.getIdTinhThanh()).idQuanHuyen(d.getIdQuanHuyen()).idPhuongXa(d.getIdPhuongXa()).thanhPho(getTinh(d.getIdTinhThanh())).quanHuyen(getQuan(d.getIdTinhThanh(), d.getIdQuanHuyen())).phuongXa(getXa(d.getIdQuanHuyen(), d.getIdPhuongXa())).diaChi(d.getDiaChi()).ghiChu(d.getGhiChu()).soDienThoai(d.getSoDienThoai()).trangThaiMacDinh(d.getTrangThaiMacDinh()).khachHang(d.getKhachHang()).build();
/*  90 */       listDiaChiResponse.add(diaChiResponse);
/*     */     } 
/*  92 */     return listDiaChiResponse;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DiaChiResponse updateDC(Integer idDiachi, DiaChiRequest diaChiRequest) throws Exception {
/*  98 */     DiaChi d = this.diaChiRepository.findById(idDiachi).get();
/*  99 */     d.setGhiChu(diaChiRequest.getGhiChu());
/* 100 */     d.setIdTinhThanh(diaChiRequest.getIdTinhThanh());
/* 101 */     d.setIdQuanHuyen(diaChiRequest.getIdQuanHuyen());
/* 102 */     d.setIdPhuongXa(diaChiRequest.getIdPhuongXa());
/* 103 */     d.setDiaChi(diaChiRequest.getDiaChi());
/* 104 */     d.setSoDienThoai(diaChiRequest.getSoDienThoai());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     DiaChiResponse diaChiResponse = DiaChiResponse.builder().idDiaChi(d.getIdDiaChi()).idTinhThanh(d.getIdTinhThanh()).idQuanHuyen(d.getIdQuanHuyen()).idPhuongXa(d.getIdPhuongXa()).thanhPho(getTinh(d.getIdTinhThanh())).quanHuyen(getQuan(d.getIdTinhThanh(), d.getIdQuanHuyen())).phuongXa(getXa(d.getIdQuanHuyen(), d.getIdPhuongXa())).diaChi(d.getDiaChi()).ghiChu(d.getGhiChu()).soDienThoai(d.getSoDienThoai()).trangThaiMacDinh(d.getTrangThaiMacDinh()).khachHang(d.getKhachHang()).build();
/* 119 */     this.diaChiRepository.save(d);
/* 120 */     return diaChiResponse;
/*     */   }
/*     */ 
/*     */   
/*     */   public DiaChiResponse updateDCDefault(Integer idKhachHang, Integer idDiachi) throws Exception {
/* 125 */     List<DiaChi> listDiaChi = this.diaChiRepository.findByIdKH(idKhachHang);
/* 126 */     for (DiaChi diaChi : listDiaChi) {
/*     */       
/* 128 */       diaChi.setTrangThaiMacDinh(Integer.valueOf(0));
/* 129 */       this.diaChiRepository.save(diaChi);
/*     */     } 
/* 131 */     DiaChi d = this.diaChiRepository.findById(idDiachi).get();
/* 132 */     if (d == null) return null; 
/* 133 */     d.setTrangThaiMacDinh(Integer.valueOf(1));
/* 134 */     this.diaChiRepository.save(d);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 148 */     DiaChiResponse diaChiResponse = DiaChiResponse.builder().idDiaChi(d.getIdDiaChi()).idTinhThanh(d.getIdTinhThanh()).idQuanHuyen(d.getIdQuanHuyen()).idPhuongXa(d.getIdPhuongXa()).thanhPho(getTinh(d.getIdTinhThanh())).quanHuyen(getQuan(d.getIdTinhThanh(), d.getIdQuanHuyen())).phuongXa(getXa(d.getIdQuanHuyen(), d.getIdPhuongXa())).diaChi(d.getDiaChi()).ghiChu(d.getGhiChu()).soDienThoai(d.getSoDienThoai()).trangThaiMacDinh(d.getTrangThaiMacDinh()).khachHang(d.getKhachHang()).build();
/* 149 */     return diaChiResponse;
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete(Integer idDiachi) {
/* 154 */     this.diaChiRepository.deleteDC(idDiachi);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDiaChiCuThe(DiaChiRequest diaChiRequest) throws Exception {
/* 160 */     String diaChiCuThe = getXa(diaChiRequest.getIdQuanHuyen(), diaChiRequest.getIdPhuongXa()) + " " + getXa(diaChiRequest.getIdQuanHuyen(), diaChiRequest.getIdPhuongXa()) + " " + getQuan(diaChiRequest.getIdTinhThanh(), diaChiRequest.getIdQuanHuyen());
/* 161 */     return diaChiCuThe;
/*     */   }
/*     */   
/*     */   public String getTinh(Integer idTP) throws Exception {
/* 165 */     HashMap<Integer, String> listTP = DiaChiCache.hashMapTinhThanh;
/* 166 */     String tinh = listTP.get(idTP);
/* 167 */     return tinh;
/*     */   }
/*     */   public String getQuan(Integer idTP, Integer idQH) throws Exception {
/* 170 */     HashMap<Integer, String> listQH = DiaChiAPI.callGetQuanHuyenAPI(idTP);
/* 171 */     String quan = listQH.get(idQH);
/* 172 */     return quan;
/*     */   }
/*     */   public String getXa(Integer idQH, String idPX) throws Exception {
/* 175 */     HashMap<String, String> listPX = DiaChiAPI.callGetPhuongXaAPI(idQH);
/* 176 */     String xa = listPX.get(idPX);
/* 177 */     return xa;
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\DiaChiServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */