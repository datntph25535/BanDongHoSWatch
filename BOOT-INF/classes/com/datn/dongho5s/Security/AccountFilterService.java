/*     */ package BOOT-INF.classes.com.datn.dongho5s.Security;
/*     */ 
/*     */ import io.jsonwebtoken.Claims;
/*     */ import io.jsonwebtoken.Jwts;
/*     */ import io.jsonwebtoken.security.Keys;
/*     */ import java.util.Base64;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.function.Function;
/*     */ import javax.crypto.SecretKey;
/*     */ import org.springframework.security.core.Authentication;
/*     */ import org.springframework.security.core.userdetails.UserDetails;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class AccountFilterService
/*     */ {
/*  27 */   private final String signInKey = "7A25432A462D4A614E645266556A586E3272357538782F413F4428472B4B6250";
/*     */   
/*     */   private SecretKey getSignInKey() {
/*  30 */     byte[] key = Base64.getDecoder().decode("7A25432A462D4A614E645266556A586E3272357538782F413F4428472B4B6250");
/*  31 */     return Keys.hmacShaKeyFor(key);
/*     */   }
/*     */   private Claims getClaims(String token) {
/*  34 */     return 
/*     */       
/*  36 */       (Claims)Jwts.parser()
/*  37 */       .setSigningKey(getSignInKey())
/*     */       
/*  39 */       .parseClaimsJws(token)
/*  40 */       .getBody();
/*     */   }
/*     */   private <T> T extractClaim(String token, Function<Claims, T> getClaimValue) {
/*  43 */     Claims claims = getClaims(token);
/*  44 */     return getClaimValue.apply(claims);
/*     */   }
/*     */   
/*     */   public String getUsername(String token) {
/*  48 */     return extractClaim(token, Claims::getSubject);
/*     */   }
/*     */   
/*     */   private String generateToken(HashMap<String, Objects> claims, Authentication account) {
/*  52 */     UserDetails userDetails = (UserDetails)account.getPrincipal();
/*  53 */     return 
/*  54 */       Jwts.builder()
/*  55 */       .setClaims(new HashMap<>())
/*  56 */       .setSubject(userDetails.getUsername())
/*  57 */       .setIssuedAt(new Date())
/*  58 */       .setExpiration(new Date(System.currentTimeMillis() + 7200000L))
/*  59 */       .signWith(getSignInKey())
/*  60 */       .compact();
/*     */   }
/*     */   
/*     */   public String generateToken(Authentication account) {
/*  64 */     return generateToken(new HashMap<>(), account);
/*     */   }
/*     */   
/*     */   public boolean isTokenValid(String token, UserDetails userDetails) {
/*  68 */     return (!isTokenExpired(token) && 
/*  69 */       isTheSameUser(token, userDetails) && 
/*  70 */       isAccountEnable(userDetails));
/*     */   }
/*     */   
/*     */   public boolean isTokenExpired(String token) {
/*  74 */     Date expiredDate = extractClaim(token, Claims::getExpiration);
/*  75 */     return (new Date()).after(expiredDate);
/*     */   }
/*     */   
/*     */   public boolean isTheSameUser(String token, UserDetails userDetails) {
/*  79 */     return userDetails.getUsername().equals(getUsername(token));
/*     */   }
/*     */   
/*     */   public boolean isAccountEnable(UserDetails userDetails) {
/*  83 */     return userDetails.isEnabled();
/*     */   }
/*     */ 
/*     */   
/*     */   public String refreshToken(String token) {
/*  88 */     if (isTokenValid(token, null)) {
/*     */       
/*  90 */       Claims claims = getClaims(token);
/*  91 */       HashMap<String, Object> newClaims = new HashMap<>((Map<? extends String, ?>)claims);
/*     */ 
/*     */       
/*  94 */       long expirationTime = System.currentTimeMillis() + 86400000L;
/*  95 */       newClaims.put("exp", new Date(expirationTime));
/*     */ 
/*     */       
/*  98 */       return Jwts.builder().setClaims(newClaims).setIssuedAt(new Date()).setExpiration(new Date(expirationTime))
/*  99 */         .signWith(getSignInKey()).compact();
/*     */     } 
/*     */     
/* 102 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Security\AccountFilterService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */