/*    */ package BOOT-INF.classes.com.datn.dongho5s.Worker;
/*    */ import com.datn.dongho5s.Entity.KhuyenMai;
/*    */ import com.datn.dongho5s.Service.KhuyenMaiService;
/*    */ import java.util.List;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.scheduling.annotation.Scheduled;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class CheckExpiredKhuyenMai {
/* 13 */   private static final Logger log = LoggerFactory.getLogger(com.datn.dongho5s.Worker.CheckExpiredKhuyenMai.class);
/*    */ 
/*    */   
/*    */   @Autowired
/*    */   KhuyenMaiService khuyenMaiService;
/*    */ 
/*    */   
/*    */   @Scheduled(cron = "0 0 0 * * ?")
/*    */   public void deactiveExpiredKhuyenMai() {
/* 22 */     List<KhuyenMai> listKhuyenMai = this.khuyenMaiService.getExpiredKhuyenMai();
/* 23 */     log.info("Số khuyến mại hết hạn : {}", Integer.valueOf(listKhuyenMai.size()));
/* 24 */     listKhuyenMai.forEach(item -> {
/*    */           item.setEnabled(false);
/*    */           this.khuyenMaiService.save(item);
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Worker\CheckExpiredKhuyenMai.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */