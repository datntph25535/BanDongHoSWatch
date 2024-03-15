/*     */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*     */ import com.datn.dongho5s.Entity.SanPham;
/*     */ import com.datn.dongho5s.Entity.ThuongHieu;
/*     */ import com.datn.dongho5s.Exception.SanPhamNotFountException;
/*     */ import com.datn.dongho5s.Repository.ChiTietSanPhamRepository;
/*     */ import com.datn.dongho5s.Repository.DanhMucRepository;
/*     */ import com.datn.dongho5s.Repository.SanPhamRepository;
/*     */ import com.datn.dongho5s.Repository.ThuongHieuRepository;
/*     */ import com.datn.dongho5s.Request.TimKiemRequest;
/*     */ import com.datn.dongho5s.Response.ChiTietSanPhamResponse;
/*     */ import com.datn.dongho5s.Response.SanPhamDetailResponse;
/*     */ import com.datn.dongho5s.Response.TimKiemResponse;
/*     */ import com.datn.dongho5s.Service.SanPhamService;
/*     */ import com.datn.dongho5s.mapper.ChiTietSanPhamMapping;
/*     */ import com.datn.dongho5s.mapper.SanPhamMapping;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.persistence.EntityManager;
/*     */ import javax.persistence.PersistenceContext;
/*     */ import javax.persistence.Query;
/*     */ import javax.persistence.TypedQuery;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service
/*     */ public class SanPhamServiceImpl
/*     */   implements SanPhamService {
/*     */   @Autowired
/*     */   SanPhamRepository sanPhamRepository;
/*     */   @Autowired
/*     */   DanhMucRepository danhMucRepository;
/*     */   @Autowired
/*     */   ThuongHieuRepository thuongHieuRepository;
/*     */   @Autowired
/*     */   ChiTietSanPhamRepository chiTietSanPhamRepository;
/*     */   @PersistenceContext
/*     */   private EntityManager entityManager;
/*     */   
/*     */   public Set<TimKiemResponse> getSanPhamByCondition(TimKiemRequest timKiemRequest) {
/*  52 */     HashMap<String, Object> values = new HashMap<>();
/*  53 */     StringBuilder query = new StringBuilder("SELECT sp FROM SanPham sp ");
/*  54 */     query.append("INNER JOIN ThuongHieu th ON sp.thuongHieu.idThuongHieu = th.idThuongHieu ");
/*  55 */     query.append("INNER JOIN DanhMuc dm ON sp.danhMuc.id = dm.id ");
/*  56 */     query.append("INNER JOIN ChiTietSanPham ctsp ON sp.idSanPham = ctsp.sanPham.idSanPham ");
/*  57 */     query.append("INNER JOIN DayDeo dd ON ctsp.dayDeo.idDayDeo = dd.idDayDeo ");
/*  58 */     query.append("INNER JOIN KichCo kc ON ctsp.kichCo.idKichCo = kc.idKichCo ");
/*  59 */     query.append("INNER JOIN VatLieu vl ON ctsp.vatLieu.idVatLieu = vl.idVatLieu ");
/*  60 */     query.append("INNER JOIN MauSac ms ON ctsp.mauSac.idMauSac = ms.idMauSac ");
/*  61 */     query.append("WHERE true = true ");
/*  62 */     if (timKiemRequest.getThuongHieuId() != null && timKiemRequest.getThuongHieuId().size() != 0) {
/*  63 */       query.append("AND sp.thuongHieu.idThuongHieu IN :ths ");
/*  64 */       values.put("ths", timKiemRequest.getThuongHieuId());
/*     */     } 
/*  66 */     if (timKiemRequest.getDanhMucId() != null && timKiemRequest.getDanhMucId().size() != 0) {
/*  67 */       query.append("AND sp.danhMuc.id IN :dms ");
/*  68 */       values.put("dms", timKiemRequest.getDanhMucId());
/*     */     } 
/*  70 */     if (timKiemRequest.getDayDeoId() != null && timKiemRequest.getDayDeoId().size() != 0) {
/*  71 */       query.append("AND ctsp.dayDeo.idDayDeo IN :dds ");
/*  72 */       values.put("dds", timKiemRequest.getDayDeoId());
/*     */     } 
/*  74 */     if (timKiemRequest.getVatLieuId() != null && timKiemRequest.getVatLieuId().size() != 0) {
/*  75 */       query.append("AND ctsp.vatLieu.idVatLieu IN :vls ");
/*  76 */       values.put("vls", timKiemRequest.getVatLieuId());
/*     */     } 
/*  78 */     if (timKiemRequest.getSizeId() != null && timKiemRequest.getSizeId().size() != 0) {
/*  79 */       query.append("AND ctsp.kichCo.idKichCo IN :kcs ");
/*  80 */       values.put("kcs", timKiemRequest.getSizeId());
/*     */     } 
/*  82 */     if (timKiemRequest.getMauSacId() != null && timKiemRequest.getMauSacId().size() != 0) {
/*  83 */       query.append("AND ctsp.mauSac.idMauSac IN :mss ");
/*  84 */       values.put("mss", timKiemRequest.getMauSacId());
/*     */     } 
/*  86 */     if (timKiemRequest.getTenSanPham() != null && !timKiemRequest.getTenSanPham().trim().isBlank()) {
/*  87 */       query.append("AND sp.tenSanPham like :ten ");
/*  88 */       values.put("ten", "%" + timKiemRequest.getTenSanPham() + "%");
/*     */     } 
/*  90 */     TypedQuery typedQuery = this.entityManager.createQuery(query.toString(), SanPham.class);
/*  91 */     values.forEach((key, value) -> queryCreated.setParameter(key, value));
/*     */ 
/*     */     
/*  94 */     System.out.println(typedQuery.toString());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     List<SanPham> listSanPham = typedQuery.getResultList();
/* 103 */     Set<TimKiemResponse> result = new HashSet<>();
/* 104 */     listSanPham.forEach(sanPham -> result.add(toTimKiemResponse(sanPham)));
/* 105 */     return result;
/*     */   }
/*     */   
/*     */   private TimKiemResponse toTimKiemResponse(SanPham sp) {
/* 109 */     TimKiemResponse result = new TimKiemResponse();
/* 110 */     result.setSanPhamID(sp.getIdSanPham());
/* 111 */     result.setTenSanPham(sp.getTenSanPham());
/*     */     
/* 113 */     result.setListAnhSanPham(sp.getListAnhSanPham());
/* 114 */     result.setListChiTietSanPham(sp.getListChiTietSanPham());
/* 115 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<SanPhamDetailResponse> getSPnew() {
/* 120 */     List<SanPham> listSanPham = this.sanPhamRepository.getSPnew();
/* 121 */     List<SanPhamDetailResponse> responseList = (List<SanPhamDetailResponse>)listSanPham.stream().map(SanPhamMapping::mapEntitytoResponse).collect(Collectors.toList());
/* 122 */     return responseList;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<SanPhamDetailResponse> getSPFeature() {
/* 127 */     List<SanPham> listSanPham = this.sanPhamRepository.findAll();
/* 128 */     List<SanPhamDetailResponse> responseList = (List<SanPhamDetailResponse>)listSanPham.stream().map(SanPhamMapping::mapEntitytoResponse).collect(Collectors.toList());
/* 129 */     return responseList;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<SanPhamDetailResponse> getSPchay() {
/* 134 */     List<SanPham> listSanPham = this.sanPhamRepository.getSPchay();
/* 135 */     List<SanPhamDetailResponse> responseList = (List<SanPhamDetailResponse>)listSanPham.stream().map(SanPhamMapping::mapEntitytoResponse).collect(Collectors.toList());
/* 136 */     return responseList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SanPhamDetailResponse getDetailSanPhamById(Integer sanPhamId) {
/* 142 */     SanPham sanPham = this.sanPhamRepository.findById(sanPhamId).get();
/* 143 */     return toSanPhamRepository(sanPham);
/*     */   }
/*     */   
/*     */   private SanPhamDetailResponse toSanPhamRepository(SanPham sp) {
/* 147 */     return SanPhamDetailResponse.builder()
/* 148 */       .idSanPham(sp.getIdSanPham())
/* 149 */       .listAnhSanPham(sp.getListAnhSanPham())
/* 150 */       .moTaSanPham(sp.getMoTaSanPham())
/* 151 */       .tenSanPham(sp.getTenSanPham())
/* 152 */       .maSanPham(sp.getMaSanPham())
/* 153 */       .danhMuc(sp.getDanhMuc())
/* 154 */       .listChiTietSanPham(sp.getListChiTietSanPham())
/* 155 */       .thuongHieu(sp.getThuongHieu())
/* 156 */       .trangThai(sp.getTrangThai())
/* 157 */       .build();
/*     */   }
/*     */   
/*     */   public List<ChiTietSanPhamResponse> getSPchayKM(Integer idChiTietSanPham) {
/* 161 */     List<ChiTietSanPham> chiTietSanPhamList = new ArrayList<>();
/* 162 */     List<ChiTietSanPham> chiTietSanPhams = this.sanPhamRepository.getCTSP(idChiTietSanPham);
/* 163 */     Date currentDate = new Date();
/* 164 */     for (ChiTietSanPham chiTietSanPham : chiTietSanPhams) {
/* 165 */       if (chiTietSanPham.getKhuyenMai() == null || !chiTietSanPham.getKhuyenMai().isEnabled() || chiTietSanPham
/* 166 */         .getKhuyenMai().getNgayKetThuc().before(currentDate) || chiTietSanPham
/* 167 */         .getKhuyenMai().getNgayBatDau().after(currentDate)) {
/* 168 */         chiTietSanPhamList.add(chiTietSanPham); continue;
/*     */       } 
/* 170 */       chiTietSanPham.setGiaSanPham(Double.valueOf(chiTietSanPham.getGiaSanPham().doubleValue() - chiTietSanPham.getGiaSanPham().doubleValue() * chiTietSanPham.getKhuyenMai().getChietKhau().intValue() / 100.0D));
/* 171 */       chiTietSanPhamList.add(chiTietSanPham);
/*     */     } 
/*     */     
/* 174 */     return (List<ChiTietSanPhamResponse>)chiTietSanPhamList.stream().map(ChiTietSanPhamMapping::mapEntitytoResponse).collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<SanPham> listAll() {
/* 186 */     return this.sanPhamRepository.findAll(Sort.by(new String[] { "tenSanPham" }).ascending());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Page<SanPham> listByPage(int pageNumber, String sortField, String sortDir, String keyword) {
/* 194 */     Sort sort = Sort.by(new String[] { sortField });
/* 195 */     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
/* 196 */     PageRequest pageRequest = PageRequest.of(pageNumber - 1, 5, sort);
/* 197 */     if (keyword != null) {
/* 198 */       return this.sanPhamRepository.findAll(keyword, (Pageable)pageRequest);
/*     */     }
/* 200 */     return this.sanPhamRepository.findAll((Pageable)pageRequest);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<SanPham> getSPCungTH(ThuongHieu thuongHieu) {
/* 206 */     return this.sanPhamRepository.findByThuongHieu(thuongHieu);
/*     */   }
/*     */ 
/*     */   
/*     */   public SanPham save(SanPham sanPham) {
/* 211 */     return (SanPham)this.sanPhamRepository.save(sanPham);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkUniqueTenAndMa(String ten, String ma) {
/* 216 */     SanPham sanPhamTheoTen = this.sanPhamRepository.findByTenSanPham(ten);
/* 217 */     SanPham sanPhamTheoMa = this.sanPhamRepository.findByMaSanPham(ma);
/*     */     
/* 219 */     if (sanPhamTheoTen == null && sanPhamTheoMa == null) {
/* 220 */       return true;
/*     */     }
/*     */     
/* 223 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkUniqueTenMaId(String ten, String ma, Integer id) {
/* 228 */     SanPham sanPhamTheoTen = this.sanPhamRepository.findByTenSanPham(ten);
/* 229 */     SanPham sanPhamTheoMa = this.sanPhamRepository.findByMaSanPham(ma);
/*     */     
/* 231 */     if (sanPhamTheoTen == null && sanPhamTheoMa == null) {
/* 232 */       return true;
/*     */     }
/*     */     
/* 235 */     if (id != null) {
/* 236 */       SanPham existingSanPham = this.sanPhamRepository.findById(id).orElse(null);
/* 237 */       if (existingSanPham != null) {
/* 238 */         if (sanPhamTheoTen != null && !sanPhamTheoTen.getIdSanPham().equals(id)) {
/* 239 */           return false;
/*     */         }
/* 241 */         if (sanPhamTheoMa != null && !sanPhamTheoMa.getIdSanPham().equals(id)) {
/* 242 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 247 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SanPham get(Integer id) throws SanPhamNotFountException {
/*     */     try {
/* 255 */       return this.sanPhamRepository.findById(id).get();
/* 256 */     } catch (NoSuchElementException ex) {
/* 257 */       throw new SanPhamNotFountException("không tìm thấy sản phẩm có id" + id);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\SanPhamServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */