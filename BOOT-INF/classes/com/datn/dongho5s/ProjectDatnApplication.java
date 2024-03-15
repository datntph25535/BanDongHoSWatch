/*    */ package BOOT-INF.classes.com.datn.dongho5s;
/*    */ 
/*    */ import com.datn.dongho5s.GiaoHangNhanhService.DiaChiAPI;
/*    */ import org.springframework.boot.SpringApplication;
/*    */ import org.springframework.boot.autoconfigure.SpringBootApplication;
/*    */ import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/*    */ import org.springframework.scheduling.annotation.EnableScheduling;
/*    */ 
/*    */ @SpringBootApplication
/*    */ @EnableJpaRepositories
/*    */ @EnableScheduling
/*    */ public class ProjectDatnApplication
/*    */ {
/*    */   public static void main(String[] args) throws Exception {
/* 15 */     DiaChiAPI.callGetTinhThanhAPI();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 23 */     SpringApplication.run(com.datn.dongho5s.ProjectDatnApplication.class, args);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\ProjectDatnApplication.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */