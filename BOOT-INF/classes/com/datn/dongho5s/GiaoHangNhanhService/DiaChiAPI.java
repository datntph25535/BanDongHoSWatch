/*     */ package BOOT-INF.classes.com.datn.dongho5s.GiaoHangNhanhService;
/*     */ import com.datn.dongho5s.Cache.DiaChiCache;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.BaseListResponse;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.PhuongXaResponse;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.QuanHuyenResponse;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.TinhThanhResponse;
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.client.methods.HttpGet;
/*     */ import org.apache.http.client.methods.HttpPost;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.entity.StringEntity;
/*     */ import org.apache.http.impl.client.CloseableHttpClient;
/*     */ import org.apache.http.impl.client.HttpClientBuilder;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ @Service
/*     */ public class DiaChiAPI {
/*  25 */   private static final Logger log = LoggerFactory.getLogger(com.datn.dongho5s.GiaoHangNhanhService.DiaChiAPI.class);
/*     */   
/*     */   private static final String apiTinhThanh = "https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/province";
/*     */   
/*     */   private static final String apiQuanHuyen = "https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/district";
/*     */   
/*     */   private static final String apiPhuongXa = "https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id";
/*     */ 
/*     */   
/*     */   public static void callGetTinhThanhAPI() throws Exception {
/*     */     try {
/*  36 */       CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
/*  37 */       HttpGet httpGet = new HttpGet("https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/province");
/*  38 */       httpGet.setHeader("Token", "14c14a31-1dbd-11ee-8bfa-8a2dda8ec551");
/*  39 */       httpGet.setHeader("Content-Type", "application/json");
/*  40 */       HttpResponse response = closeableHttpClient.execute((HttpUriRequest)httpGet);
/*  41 */       HttpEntity entity = response.getEntity();
/*  42 */       String responseBody = EntityUtils.toString(entity);
/*     */       
/*  44 */       ObjectMapper objectMapper = new ObjectMapper();
/*  45 */       BaseListResponse<TinhThanhResponse> responseObject = (BaseListResponse<TinhThanhResponse>)objectMapper.readValue(responseBody, (TypeReference)new Object());
/*     */       
/*  47 */       List<TinhThanhResponse> listTinhThanh = responseObject.getData();
/*  48 */       for (TinhThanhResponse data : listTinhThanh) {
/*  49 */         DiaChiCache.hashMapTinhThanh.put(data.getProvinceID(), data.getProvinceName());
/*     */       }
/*  51 */     } catch (Exception e) {
/*  52 */       System.out.println(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static HashMap<Integer, String> callGetQuanHuyenAPI(Integer idTinhThanh) throws Exception {
/*  57 */     if (DiaChiCache.hashMapQuanHuyen.containsKey(idTinhThanh)) {
/*  58 */       return (HashMap<Integer, String>)DiaChiCache.hashMapQuanHuyen.get(idTinhThanh);
/*     */     }
/*     */     
/*  61 */     CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
/*  62 */     HttpPost httpPost = new HttpPost("https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/district");
/*  63 */     httpPost.setHeader("Token", "14c14a31-1dbd-11ee-8bfa-8a2dda8ec551");
/*  64 */     httpPost.setHeader("Content-Type", "application/json");
/*     */     try {
/*  66 */       String body = "{ \"province_id\":" + idTinhThanh + " }";
/*  67 */       StringEntity requestEntity = new StringEntity(body);
/*  68 */       httpPost.setEntity((HttpEntity)requestEntity);
/*  69 */       HttpResponse response = closeableHttpClient.execute((HttpUriRequest)httpPost);
/*  70 */       HttpEntity entity = response.getEntity();
/*  71 */       String responseBody = EntityUtils.toString(entity);
/*  72 */       ObjectMapper objectMapper = new ObjectMapper();
/*  73 */       BaseListResponse<QuanHuyenResponse> responseObject = (BaseListResponse<QuanHuyenResponse>)objectMapper.readValue(responseBody, (TypeReference)new Object());
/*     */       
/*  75 */       List<QuanHuyenResponse> listQuanHuyen = responseObject.getData();
/*  76 */       HashMap<Integer, String> hashMapQuanHuyenByTP = new HashMap<>();
/*  77 */       for (QuanHuyenResponse data : listQuanHuyen) {
/*  78 */         hashMapQuanHuyenByTP.put(data.getDistrictID(), data.getDistrictName());
/*     */       }
/*  80 */       DiaChiCache.hashMapQuanHuyen.put(idTinhThanh, hashMapQuanHuyenByTP);
/*  81 */     } catch (Exception e) {
/*  82 */       System.out.println(e);
/*     */     } 
/*  84 */     return (HashMap<Integer, String>)DiaChiCache.hashMapQuanHuyen.get(idTinhThanh);
/*     */   }
/*     */   
/*     */   public static HashMap<String, String> callGetPhuongXaAPI(Integer idQuanHuyen) throws Exception {
/*  88 */     if (DiaChiCache.hashMapPhuongXa.containsKey(idQuanHuyen)) {
/*  89 */       return (HashMap<String, String>)DiaChiCache.hashMapPhuongXa.get(idQuanHuyen);
/*     */     }
/*     */     
/*  92 */     CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
/*  93 */     HttpPost httpPost = new HttpPost("https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id");
/*  94 */     httpPost.setHeader("Token", "14c14a31-1dbd-11ee-8bfa-8a2dda8ec551");
/*  95 */     httpPost.setHeader("Content-Type", "application/json");
/*     */     
/*     */     try {
/*  98 */       String body = "{\"district_id\":" + idQuanHuyen + "}";
/*  99 */       StringEntity requestEntity = new StringEntity(body);
/* 100 */       httpPost.setEntity((HttpEntity)requestEntity);
/* 101 */       HttpResponse response = closeableHttpClient.execute((HttpUriRequest)httpPost);
/* 102 */       HttpEntity entity = response.getEntity();
/* 103 */       String responseBody = EntityUtils.toString(entity);
/*     */       
/* 105 */       ObjectMapper objectMapper = new ObjectMapper();
/* 106 */       BaseListResponse<PhuongXaResponse> responseObject = (BaseListResponse<PhuongXaResponse>)objectMapper.readValue(responseBody, (TypeReference)new Object());
/*     */       
/* 108 */       List<PhuongXaResponse> listPhuongXa = responseObject.getData();
/* 109 */       HashMap<String, String> hashMapPhuongXaByQH = new HashMap<>();
/* 110 */       for (PhuongXaResponse data : listPhuongXa) {
/* 111 */         hashMapPhuongXaByQH.put(data.getWardCode(), data.getWardName());
/*     */       }
/* 113 */       DiaChiCache.hashMapPhuongXa.put(idQuanHuyen, hashMapPhuongXaByQH);
/* 114 */     } catch (Exception e) {
/* 115 */       System.out.println(e);
/*     */     } 
/* 117 */     return (HashMap<String, String>)DiaChiCache.hashMapPhuongXa.get(idQuanHuyen);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\GiaoHangNhanhService\DiaChiAPI.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */