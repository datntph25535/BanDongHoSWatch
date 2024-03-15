/*     */ package BOOT-INF.classes.com.datn.dongho5s.Configure;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import javax.crypto.Mac;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ 
/*     */ public class VNPayConfig {
/*     */   public static final String version = "2.1.0";
/*     */   public static final String command = "pay";
/*     */   public static final String bank_code = "NCB";
/*     */   public static final String curr_code = "VND";
/*     */   public static final String location = "vn";
/*     */   public static final String order_type = "other";
/*  24 */   public static String vnp_PayUrl = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html";
/*  25 */   public static String vnp_Returnurl = "http://localhost:8080/don-hang/thong-tin-thanh-toan";
/*  26 */   public static String vnp_TmnCode = "Q0M81PPD";
/*  27 */   public static String vnp_HashSecret = "NRYJBFMTSNTGMVQLVKMUMUZHNONBRGKZ";
/*  28 */   public static String vnp_apiUrl = "https://sandbox.vnpayment.vn/merchant_webapi/api/transaction";
/*     */   
/*     */   public static String md5(String message) {
/*  31 */     String digest = null;
/*     */     try {
/*  33 */       MessageDigest md = MessageDigest.getInstance("MD5");
/*  34 */       byte[] hash = md.digest(message.getBytes("UTF-8"));
/*  35 */       StringBuilder sb = new StringBuilder(2 * hash.length);
/*  36 */       for (byte b : hash) {
/*  37 */         sb.append(String.format("%02x", new Object[] { Integer.valueOf(b & 0xFF) }));
/*     */       } 
/*  39 */       digest = sb.toString();
/*  40 */     } catch (UnsupportedEncodingException ex) {
/*  41 */       digest = "";
/*  42 */     } catch (NoSuchAlgorithmException ex) {
/*  43 */       digest = "";
/*     */     } 
/*  45 */     return digest;
/*     */   }
/*     */   
/*     */   public static String Sha256(String message) {
/*  49 */     String digest = null;
/*     */     try {
/*  51 */       MessageDigest md = MessageDigest.getInstance("SHA-256");
/*  52 */       byte[] hash = md.digest(message.getBytes("UTF-8"));
/*  53 */       StringBuilder sb = new StringBuilder(2 * hash.length);
/*  54 */       for (byte b : hash) {
/*  55 */         sb.append(String.format("%02x", new Object[] { Integer.valueOf(b & 0xFF) }));
/*     */       } 
/*  57 */       digest = sb.toString();
/*  58 */     } catch (UnsupportedEncodingException ex) {
/*  59 */       digest = "";
/*  60 */     } catch (NoSuchAlgorithmException ex) {
/*  61 */       digest = "";
/*     */     } 
/*  63 */     return digest;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String hashAllFields(Map fields) {
/*  68 */     List<Comparable> fieldNames = new ArrayList(fields.keySet());
/*  69 */     Collections.sort(fieldNames);
/*  70 */     StringBuilder sb = new StringBuilder();
/*  71 */     Iterator<Comparable> itr = fieldNames.iterator();
/*  72 */     while (itr.hasNext()) {
/*  73 */       String fieldName = (String)itr.next();
/*  74 */       String fieldValue = (String)fields.get(fieldName);
/*  75 */       if (fieldValue != null && fieldValue.length() > 0) {
/*  76 */         sb.append(fieldName);
/*  77 */         sb.append("=");
/*  78 */         sb.append(fieldValue);
/*     */       } 
/*  80 */       if (itr.hasNext()) {
/*  81 */         sb.append("&");
/*     */       }
/*     */     } 
/*  84 */     return hmacSHA512(vnp_HashSecret, sb.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   public static String hmacSHA512(String key, String data) {
/*     */     try {
/*  90 */       if (key == null || data == null) {
/*  91 */         throw new NullPointerException();
/*     */       }
/*  93 */       Mac hmac512 = Mac.getInstance("HmacSHA512");
/*  94 */       byte[] hmacKeyBytes = key.getBytes();
/*  95 */       SecretKeySpec secretKey = new SecretKeySpec(hmacKeyBytes, "HmacSHA512");
/*  96 */       hmac512.init(secretKey);
/*  97 */       byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
/*  98 */       byte[] result = hmac512.doFinal(dataBytes);
/*  99 */       StringBuilder sb = new StringBuilder(2 * result.length);
/* 100 */       for (byte b : result) {
/* 101 */         sb.append(String.format("%02x", new Object[] { Integer.valueOf(b & 0xFF) }));
/*     */       } 
/* 103 */       return sb.toString();
/*     */     }
/* 105 */     catch (Exception ex) {
/* 106 */       return "";
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String getIpAddress(HttpServletRequest request) {
/*     */     String ipAdress;
/*     */     try {
/* 113 */       ipAdress = request.getHeader("X-FORWARDED-FOR");
/* 114 */       if (ipAdress == null) {
/* 115 */         ipAdress = request.getLocalAddr();
/*     */       }
/* 117 */     } catch (Exception e) {
/* 118 */       ipAdress = "Invalid IP:" + e.getMessage();
/*     */     } 
/* 120 */     return ipAdress;
/*     */   }
/*     */   
/*     */   public static String getRandomNumber(int len) {
/* 124 */     Random rnd = new Random();
/* 125 */     String chars = "0123456789";
/* 126 */     StringBuilder sb = new StringBuilder(len);
/* 127 */     for (int i = 0; i < len; i++) {
/* 128 */       sb.append(chars.charAt(rnd.nextInt(chars.length())));
/*     */     }
/* 130 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Configure\VNPayConfig.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */