/*    */ package org.springframework.boot.loader;
/*    */ 
/*    */ import org.springframework.boot.loader.archive.Archive;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WarLauncher
/*    */   extends ExecutableArchiveLauncher
/*    */ {
/*    */   public WarLauncher() {}
/*    */   
/*    */   protected WarLauncher(Archive archive) {
/* 37 */     super(archive);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isPostProcessingClassPathArchives() {
/* 42 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isSearchCandidate(Archive.Entry entry) {
/* 47 */     return entry.getName().startsWith("WEB-INF/");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isNestedArchive(Archive.Entry entry) {
/* 52 */     if (entry.isDirectory()) {
/* 53 */       return entry.getName().equals("WEB-INF/classes/");
/*    */     }
/* 55 */     return (entry.getName().startsWith("WEB-INF/lib/") || entry.getName().startsWith("WEB-INF/lib-provided/"));
/*    */   }
/*    */   
/*    */   public static void main(String[] args) throws Exception {
/* 59 */     (new WarLauncher()).launch(args);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\org\springframework\boot\loader\WarLauncher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */