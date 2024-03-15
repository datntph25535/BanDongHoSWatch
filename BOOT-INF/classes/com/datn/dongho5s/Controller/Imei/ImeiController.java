/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.Imei;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.Seri;
/*     */ import com.datn.dongho5s.Service.ChiTietSanPhamService;
/*     */ import com.datn.dongho5s.Service.SeriService;
/*     */ import com.datn.dongho5s.Utils.TrangThaiImei;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.DateUtil;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.repository.query.Param;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/admin/seri"})
/*     */ public class ImeiController
/*     */ {
/*  47 */   private final String UPLOAD_DIR = "./uploads/";
/*  48 */   private final Integer ITEM_PER_PAGE = Integer.valueOf(10);
/*     */   
/*     */   @Autowired
/*     */   SeriService seriService;
/*     */   @Autowired
/*     */   ChiTietSanPhamService ctspService;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping({""})
/*     */   public String init() {
/*  59 */     HttpSession session = this.request.getSession();
/*  60 */     if (session.getAttribute("admin") == null) {
/*  61 */       return "redirect:/login-admin";
/*     */     }
/*  63 */     return "admin/imei/imei";
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/page/{pageNum}"})
/*     */   public String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model, @Param("keyword") String keyword) {
/*  69 */     HttpSession session = this.request.getSession();
/*  70 */     if (session.getAttribute("admin") == null) {
/*  71 */       return "redirect:/login-admin";
/*     */     }
/*  73 */     Page<Seri> page = this.seriService.searchSeri(pageNum, this.ITEM_PER_PAGE.intValue(), keyword);
/*  74 */     List<Seri> listSeri = page.getContent();
/*  75 */     long startCount = (pageNum * this.ITEM_PER_PAGE.intValue() + 1);
/*  76 */     long endCount = startCount + this.ITEM_PER_PAGE.intValue() - 1L;
/*  77 */     if (endCount > page.getTotalElements()) {
/*  78 */       endCount = page.getTotalElements();
/*     */     }
/*  80 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/*  81 */     model.addAttribute("totalPages", Integer.valueOf(page.getTotalPages()));
/*  82 */     model.addAttribute("startCount", Long.valueOf(startCount));
/*  83 */     model.addAttribute("endCount", Long.valueOf(endCount));
/*  84 */     model.addAttribute("totalItem", Long.valueOf(page.getTotalElements()));
/*  85 */     model.addAttribute("listSeri", listSeri);
/*  86 */     model.addAttribute("keyword", keyword);
/*  87 */     System.out.println(listSeri.size());
/*  88 */     return "admin/imei/imei";
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/new"})
/*     */   public String newSeri(Model model) {
/*  94 */     HttpSession session = this.request.getSession();
/*  95 */     if (session.getAttribute("admin") == null) {
/*  96 */       return "redirect:/login-admin";
/*     */     }
/*  98 */     model.addAttribute("seri", new Seri());
/*  99 */     model.addAttribute("pageTitle", "Tạo Mới Seri");
/* 100 */     return "admin/imei/imei_form";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/edit/{id}"})
/*     */   public String editSeri(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
/*     */     try {
/* 108 */       HttpSession session = this.request.getSession();
/* 109 */       if (session.getAttribute("admin") == null) {
/* 110 */         return "redirect:/login-admin";
/*     */       }
/* 112 */       model.addAttribute("edit", Boolean.valueOf(true));
/* 113 */       Seri seri = this.seriService.get(id);
/* 114 */       if (seri == null) {
/* 115 */         redirectAttributes.addFlashAttribute("message", "Không tìm thấy Imei");
/* 116 */         return "redirect:/admin/seri";
/*     */       } 
/* 118 */       model.addAttribute("seri", seri);
/* 119 */       model.addAttribute("pageTitle", "Update Imei (ID : " + id + ")");
/* 120 */       return "admin/imei/imei_form";
/* 121 */     } catch (Exception ex) {
/* 122 */       redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi trong quá trình xử lý. Vui lòng thử lại sau.");
/* 123 */       return "redirect:/error";
/*     */     } 
/*     */   }
/*     */   
/*     */   @PostMapping({"/save"})
/*     */   public String upTrangThaiImei(Seri seri, RedirectAttributes redirectAttributes) {
/* 129 */     HttpSession session = this.request.getSession();
/* 130 */     if (session.getAttribute("admin") == null) {
/* 131 */       return "redirect:/login-admin";
/*     */     }
/* 133 */     Seri updateSeri = this.seriService.get(seri.getIdSeri());
/* 134 */     updateSeri.setTrangThai(seri.getTrangThai());
/* 135 */     updateSeri.setIdImei(seri.getIdImei());
/* 136 */     this.seriService.save(updateSeri);
/* 137 */     redirectAttributes.addFlashAttribute("message", "Thay Đổi Thành Công");
/* 138 */     return "redirect:/admin/seri";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/importExcept"})
/*     */   public String uploadFile(@RequestParam("file") MultipartFile file, Seri seri, RedirectAttributes redirectAttributes) {
/* 145 */     HttpSession session = this.request.getSession();
/* 146 */     if (session.getAttribute("admin") == null) {
/* 147 */       return "redirect:/login-admin";
/*     */     }
/* 149 */     if (seri.getChiTietSanPham() == null || this.ctspService.getChiTietSanPhamByMa(seri.getChiTietSanPham().getMaChiTietSanPham()) == null) {
/* 150 */       redirectAttributes.addFlashAttribute("message", "Vui lòng chọn đúng chi tiết cần thêm Imei");
/* 151 */       return "redirect:/admin/seri";
/*     */     } 
/* 153 */     if (file.isEmpty() && seri.getIdImei().isBlank()) {
/* 154 */       redirectAttributes.addFlashAttribute("message", "Vui lòng chọn 1 trong 2 cách thức nhập seri");
/* 155 */       return "redirect:/admin/seri";
/* 156 */     }  if (!file.isEmpty()) {
/*     */       try {
/* 158 */         List<Seri> listSave = new ArrayList<>();
/*     */         
/* 160 */         File tempFile = File.createTempFile("temp", ".xlsx");
/* 161 */         file.transferTo(tempFile);
/*     */ 
/*     */         
/* 164 */         XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(tempFile);
/* 165 */         Sheet sheet = xSSFWorkbook.getSheetAt(0);
/* 166 */         for (Row row : sheet) {
/* 167 */           for (Cell cell : row) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 173 */             Seri result = Seri.builder().chiTietSanPham(this.ctspService.getChiTietSanPhamByMa(seri.getChiTietSanPham().getMaChiTietSanPham())).ngayNhap(new Timestamp(System.currentTimeMillis())).ngayBan(null).trangThai(TrangThaiImei.CHUA_BAN).build();
/* 174 */             if (cell.getCellType() == CellType.STRING) {
/* 175 */               String value = cell.getStringCellValue();
/* 176 */               result.setIdImei(value);
/* 177 */             } else if (cell.getCellType() == CellType.NUMERIC) {
/* 178 */               if (DateUtil.isCellDateFormatted(cell)) {
/* 179 */                 Date dateValue = cell.getDateCellValue();
/* 180 */                 result.setIdImei(dateValue.toString());
/*     */               } else {
/* 182 */                 double numericValue = cell.getNumericCellValue();
/* 183 */                 result.setIdImei(String.valueOf(numericValue));
/*     */               } 
/*     */             } 
/* 186 */             if (result.getIdImei() != null) {
/* 187 */               listSave.add(result);
/*     */             }
/*     */           } 
/*     */         } 
/* 191 */         this.seriService.saveMany(listSave);
/* 192 */         xSSFWorkbook.close();
/* 193 */         redirectAttributes.addFlashAttribute("message", "Thêm list Imei thành công");
/*     */       }
/* 195 */       catch (IOException e) {
/* 196 */         e.printStackTrace();
/* 197 */       } catch (InvalidFormatException e) {
/* 198 */         throw new RuntimeException(e);
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 207 */       Seri result = Seri.builder().idImei(seri.getIdImei()).chiTietSanPham(this.ctspService.getChiTietSanPhamByMa(seri.getChiTietSanPham().getMaChiTietSanPham())).ngayNhap(new Timestamp(System.currentTimeMillis())).ngayBan(null).trangThai(TrangThaiImei.CHUA_BAN).build();
/* 208 */       this.seriService.save(result);
/* 209 */       redirectAttributes.addFlashAttribute("message", "Thêm Imei thành công");
/*     */     } 
/*     */     
/* 212 */     return "redirect:/admin/seri";
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\Imei\ImeiController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */