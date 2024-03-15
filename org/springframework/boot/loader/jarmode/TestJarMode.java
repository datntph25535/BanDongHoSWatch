/*    */ package org.springframework.boot.loader.jarmode;
/*    */ 
/*    */ import java.util.Arrays;
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
/*    */ class TestJarMode
/*    */   implements JarMode
/*    */ {
/*    */   public boolean accepts(String mode) {
/* 30 */     return "test".equals(mode);
/*    */   }
/*    */ 
/*    */   
/*    */   public void run(String mode, String[] args) {
/* 35 */     System.out.println("running in " + mode + " jar mode " + Arrays.<String>asList(args));
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\org\springframework\boot\loader\jarmode\TestJarMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */