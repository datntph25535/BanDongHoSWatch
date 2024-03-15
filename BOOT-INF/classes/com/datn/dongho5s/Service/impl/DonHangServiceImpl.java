/*     */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.DonHang;
/*     */ import com.datn.dongho5s.Entity.HoaDonChiTiet;
/*     */ import com.datn.dongho5s.Repository.ChiTietSanPhamRepository;
/*     */ import com.datn.dongho5s.Repository.DonHangRepository;
/*     */ import com.datn.dongho5s.Repository.HoaDonChiTietRepository;
/*     */ import com.datn.dongho5s.Repository.SeriRepository;
/*     */ import com.datn.dongho5s.Request.DonHangRequest;
/*     */ import com.datn.dongho5s.Response.DonHangResponse;
/*     */ import com.datn.dongho5s.Response.HoaDonChiTietResponse;
/*     */ import com.datn.dongho5s.Service.DonHangService;
/*     */ import com.datn.dongho5s.mapper.DonHangMapping;
/*     */ import com.datn.dongho5s.mapper.HoaDonChiTietMapping;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.stream.Collectors;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class DonHangServiceImpl
/*     */   implements DonHangService
/*     */ {
/*     */   public static final int DONHANG_PAGE = 10;
/*     */   @Autowired
/*     */   DonHangRepository donHangRepository;
/*     */   @Autowired
/*     */   HoaDonChiTietRepository hoaDonChiTietRepository;
/*     */   @Autowired
/*     */   ChiTietSanPhamRepository chiTietSanPhamRepository;
/*     */   @Autowired
/*     */   SeriRepository seriRepository;
/*     */   
/*     */   public DonHang save(DonHang donHang) {
/*  49 */     return (DonHang)this.donHangRepository.save(donHang);
/*     */   }
/*     */ 
/*     */   
/*     */   public DonHang getById(Integer idDonHang) {
/*  54 */     Optional<DonHang> optionalDonHang = this.donHangRepository.findById(idDonHang);
/*  55 */     if (optionalDonHang.isPresent()) {
/*  56 */       return optionalDonHang.get();
/*     */     }
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Page<DonHang> getAll(int pageNumber) {
/*  64 */     Page<DonHang> allDonHang = this.donHangRepository.findAll((Pageable)PageRequest.of(pageNumber - 1, 10));
/*  65 */     return allDonHang;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DonHang> findByNgayTao(Date dateStart, Date dateEnd, Integer status) {
/*  75 */     List<DonHang> allDonHang = this.donHangRepository.findByNgayTao(dateStart, dateEnd, status);
/*  76 */     return allDonHang;
/*     */   }
/*     */ 
/*     */   
/*     */   public Double tongTien(int id) {
/*  81 */     return this.donHangRepository.findTongTienByIdDonHang(id);
/*     */   }
/*     */ 
/*     */   
/*     */   public DonHang findById(int id) {
/*  86 */     return this.donHangRepository.findByIdDonHang(id);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateTrangThaiDonHang(DonHang donHang) {
/*  91 */     this.donHangRepository.updateTrangThaiDonHang(donHang);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HoaDonChiTietResponse> findHDCTbyDH(Integer idDonhang) {
/*  96 */     List<HoaDonChiTiet> listHDCT = this.donHangRepository.findHDCTbyDH(idDonhang);
/*  97 */     List<HoaDonChiTietResponse> responseList = (List<HoaDonChiTietResponse>)listHDCT.stream().map(HoaDonChiTietMapping::mapEntitytoResponse).collect(Collectors.toList());
/*  98 */     return responseList;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<DonHangResponse> findAllHD(Integer idKhachHang) throws Exception {
/* 103 */     List<DonHang> listHD = this.donHangRepository.findAllHD(idKhachHang);
/* 104 */     List<DonHangResponse> responseList = new ArrayList<>();
/* 105 */     for (DonHang don : listHD) {
/* 106 */       DonHangResponse donHangResponse = new DonHangResponse();
/* 107 */       donHangResponse = DonHangMapping.mapEntitytoResponseBT(don);
/* 108 */       responseList.add(donHangResponse);
/*     */     } 
/* 110 */     responseList.sort((o1, o2) -> o2.getNgayTao().compareTo(o1.getNgayTao()));
/* 111 */     return responseList;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<DonHangResponse> findHDByStatus(Integer idKhachHang, Integer trangThaiDonHang) throws Exception {
/* 116 */     List<DonHang> listHD = this.donHangRepository.findHDByStatus(idKhachHang, trangThaiDonHang);
/* 117 */     List<DonHangResponse> responseList = new ArrayList<>();
/* 118 */     for (DonHang don : listHD) {
/* 119 */       DonHangResponse donHangResponse = new DonHangResponse();
/* 120 */       donHangResponse = DonHangMapping.mapEntitytoResponse(don);
/* 121 */       responseList.add(donHangResponse);
/*     */     } 
/* 123 */     responseList.sort((o1, o2) -> o2.getNgayTao().compareTo(o1.getNgayTao()));
/* 124 */     return responseList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DonHangResponse updateDH(DonHangRequest donHangRequest) {
/*     */     try {
/* 132 */       DonHang donHang = this.donHangRepository.findByIdDonHang(donHangRequest.getIdDonHang().intValue());
/* 133 */       if (donHang != null) {
/* 134 */         if (donHangRequest.getLyDo() == null) {
/* 135 */           return null;
/*     */         }
/* 137 */         donHang.setLyDo(donHangRequest.getLyDo());
/* 138 */         donHang.setTrangThaiDonHang(donHangRequest.getTrangThaiDonHang());
/* 139 */         donHang.setNgayCapNhap(new Date());
/* 140 */         donHang = (DonHang)this.donHangRepository.save(donHang);
/*     */       } 
/*     */ 
/*     */       
/* 144 */       DonHangResponse donHangResponse = DonHangMapping.mapEntitytoResponse(donHang);
/* 145 */       return donHangResponse;
/* 146 */     } catch (Exception e) {
/* 147 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<DonHang> findByTrangThaiDonHang(int trangThai) {
/* 153 */     return this.donHangRepository.findByTrangThaiDonHang(trangThai);
/*     */   }
/*     */ 
/*     */   
/*     */   public Page<DonHang> getAllForBanHang(int pageNum) {
/* 158 */     Page<DonHang> allDonHang = this.donHangRepository.findAllSort((Pageable)PageRequest.of(pageNum - 1, 5));
/* 159 */     return allDonHang;
/*     */   }
/*     */ 
/*     */   
/*     */   public DonHang findByMaDonHang(String maDonHang) {
/* 164 */     return this.donHangRepository.findByMaDonHang(maDonHang);
/*     */   }
/*     */ 
/*     */   
/*     */   public String thanhToanAdmin(DonHang donHang) {
/* 169 */     this.donHangRepository.updateTrangThaiDonHang(donHang);
/* 170 */     return "Thanh toan thanh cong don hang " + donHang.getMaDonHang();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String xoaDonHangAdmin(DonHang donHang) {
/* 176 */     for (HoaDonChiTiet h : donHang.getListHoaDonChiTiet()) {
/* 177 */       this.seriRepository.xoaSoLuongSanPham(h.getIdHoaDonChiTiet().intValue());
/*     */     }
/*     */ 
/*     */     
/* 181 */     this.hoaDonChiTietRepository.deleteByDonHang(donHang);
/*     */     
/* 183 */     this.donHangRepository.deleteByMaDonHang(donHang.getMaDonHang());
/* 184 */     return "Delete succcessful! Code is" + donHang.getMaDonHang();
/*     */   }
/*     */ 
/*     */   
/*     */   public void xoaDonHang(DonHang donhang) {
/* 189 */     this.donHangRepository.delete(donhang);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<DonHang> getAllDonHang() {
/* 194 */     return this.donHangRepository.findAll();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<DonHang> getAllPaginationDonHang() {
/* 199 */     return (List<DonHang>)this.donHangRepository.findAllSort((Pageable)Sort.by(new String[] { "maDonHang" }).ascending());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Page<DonHang> listByPage(int pageNumber, String sortField, String sortDir, String keyword) {
/* 207 */     PageRequest pageRequest = PageRequest.of(pageNumber - 1, 10, Sort.by(SortOrder(sortField, sortDir)));
/* 208 */     if (keyword != null) {
/* 209 */       return this.donHangRepository.findAllPagination(keyword, (Pageable)pageRequest);
/*     */     }
/* 211 */     return this.donHangRepository.findAll((Pageable)pageRequest);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Page<DonHang> listByPageStatus(int pageNumber, String sortField, String sortDir, String keyword, int status) {
/* 218 */     PageRequest pageRequest = PageRequest.of(pageNumber - 1, 10, Sort.by(SortOrder(sortField, sortDir)));
/* 219 */     if (keyword != null) {
/* 220 */       return this.donHangRepository.findAllPaginationStatus(keyword, (Pageable)pageRequest, Integer.valueOf(status));
/*     */     }
/* 222 */     return this.donHangRepository.findAll((Pageable)pageRequest);
/*     */   }
/*     */   
/*     */   public Integer countDHbyStatus(Integer trangThaiDonhang) {
/* 226 */     return this.donHangRepository.countDHbyStatus(trangThaiDonhang);
/*     */   }
/*     */   
/*     */   public Integer countDHAll() {
/* 230 */     return this.donHangRepository.countDHAll();
/*     */   } public List<Sort.Order> SortOrder(String sort, String sortDirection) {
/*     */     Sort.Direction direction;
/* 233 */     List<Sort.Order> sorts = new ArrayList<>();
/*     */     
/* 235 */     if (sortDirection != null) {
/* 236 */       direction = Sort.Direction.fromString(sortDirection);
/*     */     } else {
/* 238 */       direction = Sort.Direction.DESC;
/*     */     } 
/* 240 */     sorts.add(new Sort.Order(direction, sort));
/* 241 */     return sorts;
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\DonHangServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */