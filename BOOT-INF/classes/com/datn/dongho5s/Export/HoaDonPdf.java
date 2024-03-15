/*     */ package BOOT-INF.classes.com.datn.dongho5s.Export;
/*     */ 
/*     */ import com.datn.dongho5s.Cache.DiaChiCache;
/*     */ import com.datn.dongho5s.Entity.DonHang;
/*     */ import com.datn.dongho5s.Entity.HoaDonChiTiet;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.DiaChiAPI;
/*     */ import com.itextpdf.text.Document;
/*     */ import com.itextpdf.text.Element;
/*     */ import com.itextpdf.text.FontFactory;
/*     */ import com.itextpdf.text.Paragraph;
/*     */ import com.itextpdf.text.Phrase;
/*     */ import com.itextpdf.text.pdf.PdfPCell;
/*     */ import com.itextpdf.text.pdf.PdfPTable;
/*     */ import com.itextpdf.text.pdf.PdfWriter;
/*     */ import java.io.OutputStream;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HoaDonPdf
/*     */ {
/*     */   public void exportToPDF(HttpServletResponse response, List<HoaDonChiTiet> lst, DonHang donHang) throws Exception {
/*  25 */     DiaChiAPI diaChiAPI = new DiaChiAPI();
/*  26 */     DiaChiCache diaChiCache = new DiaChiCache();
/*     */ 
/*     */     
/*  29 */     Document document = new Document();
/*     */ 
/*     */     
/*  32 */     response.setContentType("application/pdf");
/*  33 */     response.setHeader("Content-Disposition", "attachment; filename=\"HD" + donHang.getIdDonHang() + ".pdf\"");
/*     */ 
/*     */     
/*  36 */     PdfWriter.getInstance(document, (OutputStream)response.getOutputStream());
/*     */ 
/*     */     
/*  39 */     document.open();
/*     */ 
/*     */     
/*  42 */     Paragraph header1 = new Paragraph("Dong ho 5S");
/*  43 */     header1.setAlignment(1);
/*  44 */     header1.setFont(FontFactory.getFont("Times-Bold", 16.0F, 1));
/*  45 */     String diaChi = "";
/*  46 */     if (donHang.getDiaChi() != null)
/*     */     {
/*     */ 
/*     */       
/*  50 */       diaChi = donHang.getDiaChi() + ", " + donHang.getDiaChi() + ", " + (String)DiaChiAPI.callGetPhuongXaAPI(donHang.getIdQuanHuyen()).get(donHang.getIdPhuongXa()) + ", " + (String)DiaChiAPI.callGetQuanHuyenAPI(donHang.getIdTinhThanh()).get(donHang.getIdQuanHuyen());
/*     */     }
/*     */     
/*  53 */     Paragraph header2 = new Paragraph(diaChi);
/*  54 */     header2.setAlignment(1);
/*  55 */     header2.setFont(FontFactory.getFont("Times-Italic", 12.0F));
/*     */     
/*  57 */     Paragraph header3 = new Paragraph("Hoa don thanh toan");
/*  58 */     header3.setAlignment(1);
/*  59 */     header3.setFont(FontFactory.getFont("Times-Bold", 14.0F, 1));
/*     */     
/*  61 */     PdfPTable table = new PdfPTable(4);
/*  62 */     table.setWidthPercentage(100.0F);
/*  63 */     table.setSpacingBefore(10.0F);
/*  64 */     table.setSpacingAfter(10.0F);
/*     */     
/*  66 */     PdfPCell cell1 = new PdfPCell(new Phrase("Ten san pham"));
/*  67 */     cell1.setHorizontalAlignment(1);
/*     */     
/*  69 */     PdfPCell cell2 = new PdfPCell(new Phrase("So Luong"));
/*  70 */     cell2.setHorizontalAlignment(1);
/*     */     
/*  72 */     PdfPCell cell3 = new PdfPCell(new Phrase("Don gia"));
/*  73 */     cell3.setHorizontalAlignment(1);
/*     */     
/*  75 */     PdfPCell cell4 = new PdfPCell(new Phrase("Thanh tien"));
/*  76 */     cell4.setHorizontalAlignment(1);
/*     */     
/*  78 */     table.addCell(cell1);
/*  79 */     table.addCell(cell2);
/*  80 */     table.addCell(cell3);
/*  81 */     table.addCell(cell4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     for (HoaDonChiTiet item : lst) {
/*  88 */       PdfPCell cell5 = new PdfPCell(new Phrase(item.getChiTietSanPham().getSanPham().getTenSanPham()));
/*  89 */       PdfPCell cell6 = new PdfPCell(new Phrase("x" + item.getSoLuong()));
/*  90 */       PdfPCell cell7 = new PdfPCell(new Phrase("" + item.getGiaBan() + "d"));
/*  91 */       PdfPCell cell8 = new PdfPCell(new Phrase("" + item.getGiaBan().doubleValue() * item.getSoLuong().intValue() + "d"));
/*     */       
/*  93 */       table.addCell(cell5);
/*  94 */       table.addCell(cell6);
/*  95 */       table.addCell(cell7);
/*  96 */       table.addCell(cell8);
/*     */     } 
/*     */ 
/*     */     
/* 100 */     Paragraph footer = new Paragraph("Chuc quy khach vui ve! Hen gap lai!");
/* 101 */     footer.setAlignment(1);
/* 102 */     footer.setFont(FontFactory.getFont("Times-Italic", 12.0F));
/*     */ 
/*     */ 
/*     */     
/* 106 */     Paragraph donGia = new Paragraph("Don gia cac san pham " + donHang.getTongTien() + "d");
/* 107 */     donGia.setAlignment(2);
/* 108 */     donGia.setFont(FontFactory.getFont("Times-Bold", 12.0F, 1));
/*     */ 
/*     */     
/* 111 */     Paragraph pvc = new Paragraph("Phi van chuyem " + ((donHang.getPhiVanChuyen() == null) ? 0.0D : donHang.getPhiVanChuyen().doubleValue()) + "d");
/* 112 */     pvc.setAlignment(2);
/* 113 */     pvc.setFont(FontFactory.getFont("Times-Bold", 12.0F, 1));
/*     */ 
/*     */     
/* 116 */     Paragraph tongCong = new Paragraph("Tong tien: " + donHang.getTongTien().doubleValue() + ((donHang.getPhiVanChuyen() == null) ? 0.0D : donHang.getPhiVanChuyen().doubleValue()) + "d");
/* 117 */     tongCong.setAlignment(2);
/* 118 */     tongCong.setFont(FontFactory.getFont("Times-Bold", 12.0F, 1));
/*     */ 
/*     */     
/* 121 */     document.add((Element)header1);
/* 122 */     document.add((Element)header2);
/* 123 */     document.add((Element)header3);
/* 124 */     document.add((Element)table);
/* 125 */     document.add((Element)donGia);
/* 126 */     document.add((Element)pvc);
/* 127 */     document.add((Element)tongCong);
/* 128 */     document.add((Element)footer);
/*     */ 
/*     */     
/* 131 */     document.close();
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Export\HoaDonPdf.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */