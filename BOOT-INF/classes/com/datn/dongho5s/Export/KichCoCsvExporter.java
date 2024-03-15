/*    */ package BOOT-INF.classes.com.datn.dongho5s.Export;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.KichCo;
/*    */ import com.datn.dongho5s.Export.AbstractExporter;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.supercsv.io.CsvBeanWriter;
/*    */ import org.supercsv.prefs.CsvPreference;
/*    */ 
/*    */ public class KichCoCsvExporter
/*    */   extends AbstractExporter {
/*    */   public void export(List<KichCo> listKichCo, HttpServletResponse response) throws IOException {
/* 14 */     setResponseHeader(response, "text/csv", ".csv", "material_");
/*    */     
/* 16 */     CsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
/*    */     
/* 18 */     String[] csvHeader = { "ID", "Name", "Description", "DateUpdated", "Enabled" };
/* 19 */     String[] filedMapping = { "idKichCo", "tenKichCo", "moTaKichCo", "ngayTaoKichCo", "enabled" };
/*    */     
/* 21 */     csvBeanWriter.writeHeader(csvHeader);
/* 22 */     for (KichCo KichCo : listKichCo) {
/* 23 */       csvBeanWriter.write(KichCo, filedMapping);
/*    */     }
/* 25 */     csvBeanWriter.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Export\KichCoCsvExporter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */