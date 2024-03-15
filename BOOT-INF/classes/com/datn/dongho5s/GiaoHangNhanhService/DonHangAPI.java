/*     */ package BOOT-INF.classes.com.datn.dongho5s.GiaoHangNhanhService;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.BaseResponse;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.PhiVanChuyenResponse;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.Constant;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.Request.ChiTietItemRequestGHN;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.Request.PhiVanChuyenRequest;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.Request.TaoDonHangRequestGHN;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.client.methods.HttpPost;
/*     */ import org.apache.http.entity.StringEntity;
/*     */ import org.apache.http.impl.client.CloseableHttpClient;
/*     */ import org.apache.http.impl.client.HttpClientBuilder;
/*     */ 
/*     */ public class DonHangAPI {
/*  21 */   private static final Logger log = LoggerFactory.getLogger(com.datn.dongho5s.GiaoHangNhanhService.DonHangAPI.class);
/*     */   
/*     */   private static final String FeeAPI = "https://dev-online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/fee";
/*     */   
/*     */   private static final String CreateOrderAPI = "https://dev-online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/create";
/*     */   
/*     */   public static Integer getFee(PhiVanChuyenRequest request) throws Exception {
/*  28 */     CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
/*  29 */     HttpPost httpPost = new HttpPost("https://dev-online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/fee");
/*  30 */     httpPost.setHeader("Token", "14c14a31-1dbd-11ee-8bfa-8a2dda8ec551");
/*  31 */     httpPost.setHeader("shopid", String.valueOf("125042"));
/*  32 */     httpPost.setHeader("Content-Type", "application/json");
/*  33 */     request.getTrungBinhCacCanh();
/*     */     try {
/*  35 */       StringBuilder body = new StringBuilder("{ \"to_district_id\":" + request.getIdQuanHuyen() + " ,");
/*  36 */       body.append(" \"to_ward_code\": \"" + request.getStringPhuongXa() + "\" ,");
/*  37 */       body.append(" \"service_type_id\":2 ,");
/*  38 */       body.append(" \"height\":" + request.getTrungBinhCacCanh() + " ,");
/*  39 */       body.append(" \"length\":" + request.getTrungBinhCacCanh() + " ,");
/*  40 */       body.append(" \"width\":" + request.getTrungBinhCacCanh() + " ,");
/*  41 */       body.append(" \"weight\":" + request.getSoLuongSanPham().intValue() * Constant.TRONG_LUONG_SAN_PHAM.intValue() + " }");
/*  42 */       System.out.println(body);
/*  43 */       StringEntity requestEntity = new StringEntity(body.toString());
/*  44 */       httpPost.setEntity((HttpEntity)requestEntity);
/*  45 */       HttpResponse response = closeableHttpClient.execute((HttpUriRequest)httpPost);
/*  46 */       HttpEntity entity = response.getEntity();
/*  47 */       String responseBody = EntityUtils.toString(entity);
/*     */       
/*  49 */       ObjectMapper objectMapper = new ObjectMapper();
/*  50 */       BaseResponse<PhiVanChuyenResponse> responseObject = (BaseResponse<PhiVanChuyenResponse>)objectMapper.readValue(responseBody, (TypeReference)new Object());
/*     */       
/*  52 */       PhiVanChuyenResponse thongTinPhi = (PhiVanChuyenResponse)responseObject.getData();
/*  53 */       System.out.println(thongTinPhi.toString());
/*  54 */       return thongTinPhi.getTotal();
/*  55 */     } catch (Exception e) {
/*  56 */       System.out.println(e);
/*  57 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Integer createOrder(TaoDonHangRequestGHN request) throws Exception {
/*  62 */     CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
/*  63 */     HttpPost httpPost = new HttpPost("https://dev-online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/create");
/*  64 */     httpPost.setHeader("Token", "14c14a31-1dbd-11ee-8bfa-8a2dda8ec551");
/*  65 */     httpPost.setHeader("shopid", String.valueOf("125042"));
/*  66 */     httpPost.setHeader("Content-Type", "application/json");
/*  67 */     request.getTrungBinhCacCanh();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  83 */       JsonObject body = new JsonObject();
/*  84 */       body.addProperty("to_district_id", request.getIdQuanHuyen());
/*  85 */       body.addProperty("to_ward_code", request.getStringPhuongXa());
/*  86 */       body.addProperty("to_address", request.getToAddress());
/*  87 */       body.addProperty("note", request.getNote());
/*  88 */       body.addProperty("required_note", "CHOXEMHANGKHONGTHU");
/*  89 */       body.addProperty("to_name", request.getToName());
/*  90 */       body.addProperty("to_phone", request.getToPhone());
/*  91 */       body.addProperty("service_type_id", Integer.valueOf(2));
/*  92 */       body.addProperty("height", request.getTrungBinhCacCanh());
/*  93 */       body.addProperty("length", request.getTrungBinhCacCanh());
/*  94 */       body.addProperty("width", request.getTrungBinhCacCanh());
/*  95 */       body.addProperty("weight", Integer.valueOf(request.getSoLuongSanPham().intValue() * Constant.TRONG_LUONG_SAN_PHAM.intValue()));
/*     */       
/*  97 */       if (request.getPhuongThuc() == PhuongThucThanhToan.TRA_SAU) {
/*  98 */         body.addProperty("cod_amount", Integer.valueOf(request.getThanhTien().intValue()));
/*  99 */         body.addProperty("payment_type_id", Integer.valueOf(2));
/* 100 */       } else if (request.getPhuongThuc() == PhuongThucThanhToan.VNPAY) {
/* 101 */         body.addProperty("payment_type_id", Integer.valueOf(1));
/*     */       } else {
/* 103 */         body.addProperty("payment_type_id", Integer.valueOf(1));
/*     */       } 
/* 105 */       JsonArray items = new JsonArray();
/* 106 */       request.getListItems().forEach(item -> {
/*     */             JsonObject covertJO = new JsonObject();
/*     */             covertJO.addProperty("name", item.getName());
/*     */             covertJO.addProperty("quantity", item.getSoLuong());
/*     */             covertJO.addProperty("price", Integer.valueOf(item.getGiaBan().intValue()));
/*     */             covertJO.addProperty("id", item.getCtsp().getIdChiTietSanPham());
/*     */             items.add((JsonElement)covertJO);
/*     */           });
/* 114 */       body.add("items", (JsonElement)items);
/* 115 */       Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
/* 116 */       String jsonString = gson.toJson((JsonElement)body);
/* 117 */       log.info("Thông tin đơn hàng gửi lên Giao hàng nhanh {}", jsonString);
/* 118 */       StringEntity requestEntity = new StringEntity(body.toString());
/* 119 */       httpPost.setEntity((HttpEntity)requestEntity);
/* 120 */       HttpResponse response = closeableHttpClient.execute((HttpUriRequest)httpPost);
/* 121 */       HttpEntity entity = response.getEntity();
/* 122 */       String responseBody = EntityUtils.toString(entity);
/* 123 */       JsonParser parser = new JsonParser();
/* 124 */       JsonObject jsonObject = parser.parse(responseBody).getAsJsonObject();
/*     */ 
/*     */       
/* 127 */       Integer code = Integer.valueOf(jsonObject.get("code").getAsInt());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       log.info("Thông tin đơn hàng trả về của Giao hàng nhanh {}", responseBody);
/* 135 */       return code;
/* 136 */     } catch (Exception e) {
/* 137 */       System.out.println(e);
/* 138 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\GiaoHangNhanhService\DonHangAPI.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */