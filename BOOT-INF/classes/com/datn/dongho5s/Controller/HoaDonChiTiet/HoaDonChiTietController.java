/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.HoaDonChiTiet;
/*    */ 
/*    */ import com.datn.dongho5s.Cache.DiaChiCache;
/*    */ import com.datn.dongho5s.Entity.DonHang;
/*    */ import com.datn.dongho5s.Entity.HoaDonChiTiet;
/*    */ import com.datn.dongho5s.Export.HoaDonPdf;
/*    */ import com.datn.dongho5s.GiaoHangNhanhService.DiaChiAPI;
/*    */ import com.datn.dongho5s.Service.DonHangService;
/*    */ import com.datn.dongho5s.Service.HoaDonChiTietService;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RequestMapping({"/admin/hoa-don-chi-tiet"})
/*    */ @Controller
/*    */ public class HoaDonChiTietController
/*    */ {
/*    */   @Autowired
/*    */   private HoaDonChiTietService hoaDonChiTietService;
/*    */   @Autowired
/*    */   private DonHangService donHangService;
/*    */   @Autowired
/*    */   HttpServletRequest request;
/*    */   
/*    */   @GetMapping({"/search/{id}"})
/*    */   public String getByIdDonHang(@PathVariable("id") int id, Model model, HttpSession session) {
/* 42 */     session = this.request.getSession();
/* 43 */     if (session.getAttribute("admin") == null) {
/* 44 */       return "redirect:/login-admin";
/*    */     }
/* 46 */     List<HoaDonChiTiet> lst = this.hoaDonChiTietService.getByIdDonHang(id);
/* 47 */     Double tongTien = this.donHangService.tongTien(id);
/*    */     
/* 49 */     DonHang donHang = this.donHangService.findById(id);
/*    */     
/* 51 */     model.addAttribute("donHang", donHang);
/* 52 */     model.addAttribute("diaChiCache", new DiaChiCache());
/* 53 */     model.addAttribute("diaChiAPI", new DiaChiAPI());
/*    */     
/* 55 */     model.addAttribute("lstHDCT", lst);
/* 56 */     model.addAttribute("tongTien", donHang.getTongTien());
/*    */     
/* 58 */     session.setAttribute("donHang", donHang);
/*    */     
/* 60 */     return "admin/hoadonchitiet/hoadonchitiet";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/export"})
/*    */   public void exportHoaDon(HttpServletResponse response, Model model, HttpSession session) throws Exception {
/* 70 */     DonHang donHang = (DonHang)session.getAttribute("donHang");
/*    */     
/* 72 */     List<HoaDonChiTiet> lst = this.hoaDonChiTietService.getByIdDonHang(donHang.getIdDonHang().intValue());
/*    */     
/* 74 */     HoaDonPdf hoaDonPdf = new HoaDonPdf();
/* 75 */     hoaDonPdf.exportToPDF(response, lst, donHang);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\HoaDonChiTiet\HoaDonChiTietController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */