/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.NhanVien;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.ChucVu;
/*     */ import com.datn.dongho5s.Entity.NhanVien;
/*     */ import com.datn.dongho5s.Exception.NhanVienNotFoundException;
/*     */ import com.datn.dongho5s.Export.NhanVienCsvExporter;
/*     */ import com.datn.dongho5s.Export.NhanVienExcelExporter;
/*     */ import com.datn.dongho5s.Export.NhanVienPdfExporter;
/*     */ import com.datn.dongho5s.Service.NhanVienService;
/*     */ import com.datn.dongho5s.UploadFile.FileUploadUtil;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.repository.query.Param;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.util.StringUtils;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ public class NhanVienController
/*     */ {
/*     */   @Autowired
/*     */   private NhanVienService service;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping({"/admin/users"})
/*     */   public String listFirstPage(Model model) {
/*  42 */     HttpSession session = this.request.getSession();
/*  43 */     if (session.getAttribute("admin") == null) {
/*  44 */       return "redirect:/login-admin";
/*     */     }
/*  46 */     return listByPage(1, model, "email", "asc", null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/users/page/{pageNum}"})
/*     */   public String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
/*  54 */     HttpSession session = this.request.getSession();
/*  55 */     if (session.getAttribute("admin") == null) {
/*  56 */       return "redirect:/login-admin";
/*     */     }
/*  58 */     System.out.println("SortField: " + sortField);
/*  59 */     System.out.println("sortOrder: " + sortDir);
/*  60 */     Page<NhanVien> page = this.service.listByPage(pageNum, sortField, sortDir, keyword);
/*  61 */     List<NhanVien> listNhanVien = page.getContent();
/*     */     
/*  63 */     long startCount = ((pageNum - 1) * 4 + 1);
/*  64 */     long endCount = startCount + 4L - 1L;
/*     */     
/*  66 */     if (endCount > page.getTotalElements()) {
/*  67 */       endCount = page.getTotalElements();
/*     */     }
/*     */     
/*  70 */     String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
/*     */     
/*  72 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/*  73 */     model.addAttribute("totalPages", Integer.valueOf(page.getTotalPages()));
/*  74 */     model.addAttribute("startCount", Long.valueOf(startCount));
/*  75 */     model.addAttribute("endCount", Long.valueOf(endCount));
/*  76 */     model.addAttribute("totalItem", Long.valueOf(page.getTotalElements()));
/*  77 */     model.addAttribute("listNhanVien", listNhanVien);
/*  78 */     model.addAttribute("sortField", sortField);
/*  79 */     model.addAttribute("sortDir", sortDir);
/*  80 */     model.addAttribute("reverseSortDir", reverseSortDir);
/*  81 */     model.addAttribute("keyword", keyword);
/*  82 */     return "admin/nhanvien/users";
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/users/new"})
/*     */   public String newUser(Model model) {
/*  88 */     HttpSession session = this.request.getSession();
/*  89 */     if (session.getAttribute("admin") == null) {
/*  90 */       return "redirect:/login-admin";
/*     */     }
/*  92 */     List<ChucVu> listChucVu = this.service.listChucVu();
/*  93 */     NhanVien nhanVien = new NhanVien();
/*  94 */     nhanVien.setEnabled(true);
/*  95 */     model.addAttribute("nhanVien", nhanVien);
/*  96 */     model.addAttribute("listChucVu", listChucVu);
/*  97 */     model.addAttribute("pageTitle", "Thêm Mới Nhân Viên");
/*  98 */     return "admin/nhanvien/user_form";
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/admin/users/save"})
/*     */   public String saveUser(NhanVien nhanVien, RedirectAttributes redirectAttributes, @RequestParam("image") MultipartFile multipartFile) throws IOException {
/* 104 */     HttpSession session = this.request.getSession();
/* 105 */     if (session.getAttribute("admin") == null) {
/* 106 */       return "redirect:/login-admin";
/*     */     }
/* 108 */     if (!multipartFile.isEmpty()) {
/* 109 */       String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
/* 110 */       nhanVien.setAnh(fileName);
/* 111 */       NhanVien savedNhanVien = this.service.save(nhanVien);
/* 112 */       String uploadDir = "user-photos/" + savedNhanVien.getId();
/*     */       
/* 114 */       FileUploadUtil.cleanDir(uploadDir);
/* 115 */       FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
/*     */     } else {
/* 117 */       if (nhanVien.getAnh().isEmpty()) nhanVien.setAnh(null); 
/* 118 */       this.service.save(nhanVien);
/*     */     } 
/* 120 */     redirectAttributes.addFlashAttribute("message", "Thay Đổi Thành Công");
/* 121 */     return "redirect:/admin/users";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/users/edit/{id}"})
/*     */   public String editUser(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
/*     */     try {
/* 129 */       HttpSession session = this.request.getSession();
/* 130 */       if (session.getAttribute("admin") == null) {
/* 131 */         return "redirect:/login-admin";
/*     */       }
/* 133 */       NhanVien nhanVien = this.service.get(id);
/* 134 */       List<ChucVu> listChucVu = this.service.listChucVu();
/* 135 */       model.addAttribute("nhanVien", nhanVien);
/* 136 */       model.addAttribute("pageTitle", "Update Nhân Viên (ID : " + id + ")");
/* 137 */       model.addAttribute("listChucVu", listChucVu);
/* 138 */       return "admin/nhanvien/user_form";
/* 139 */     } catch (NhanVienNotFoundException ex) {
/* 140 */       redirectAttributes.addFlashAttribute("message", ex.getMessage());
/* 141 */       return "redirect:/admin/users";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/users/delete/{id}"})
/*     */   public String deleteUser(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
/*     */     try {
/* 152 */       HttpSession session = this.request.getSession();
/* 153 */       if (session.getAttribute("admin") == null) {
/* 154 */         return "redirect:/login-admin";
/*     */       }
/* 156 */       this.service.delete(id);
/* 157 */       redirectAttributes.addFlashAttribute("message", "Người dùng ID" + id + "đã xóa thành công");
/* 158 */     } catch (NhanVienNotFoundException ex) {
/* 159 */       redirectAttributes.addFlashAttribute("message", ex.getMessage());
/*     */     } 
/* 161 */     return "redirect:/admin/users";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/users/{id}/enabled/{status}"})
/*     */   public String updateNhanVienEnabledStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean enabled, RedirectAttributes redirectAttributes) {
/* 168 */     HttpSession session = this.request.getSession();
/* 169 */     if (session.getAttribute("admin") == null) {
/* 170 */       return "redirect:/login-admin";
/*     */     }
/* 172 */     this.service.updateNhanVienEnabledStatus(id, enabled);
/* 173 */     String status = enabled ? "online" : "offline";
/* 174 */     String message = "Nhân viên có id " + id + " thay đổi trạng thái thành " + status;
/* 175 */     redirectAttributes.addFlashAttribute("message", message);
/* 176 */     return "redirect:/admin/users";
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/users/export/csv"})
/*     */   public void exportToCSV(HttpServletResponse response) throws IOException {
/* 181 */     List<NhanVien> listNhanVien = this.service.listAll();
/* 182 */     NhanVienCsvExporter exporter = new NhanVienCsvExporter();
/* 183 */     exporter.export(listNhanVien, response);
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/users/export/excel"})
/*     */   public void exportToExcel(HttpServletResponse response) throws IOException {
/* 188 */     List<NhanVien> listNhanVien = this.service.listAll();
/* 189 */     NhanVienExcelExporter exporter = new NhanVienExcelExporter();
/* 190 */     exporter.export(listNhanVien, response);
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/users/export/pdf"})
/*     */   public void exportToPDF(HttpServletResponse response) throws IOException {
/* 196 */     List<NhanVien> listNhanVien = this.service.listAll();
/* 197 */     NhanVienPdfExporter exporter = new NhanVienPdfExporter();
/* 198 */     exporter.export(listNhanVien, response);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\NhanVien\NhanVienController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */