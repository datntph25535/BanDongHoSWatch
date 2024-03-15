/*     */ package org.springframework.boot.loader.jar;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.net.URLStreamHandler;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import java.util.regex.Pattern;
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
/*     */ 
/*     */ 
/*     */ public class Handler
/*     */   extends URLStreamHandler
/*     */ {
/*     */   private static final String JAR_PROTOCOL = "jar:";
/*     */   private static final String FILE_PROTOCOL = "file:";
/*     */   private static final String SEPARATOR = "!/";
/*  52 */   private static final Pattern SEPARATOR_PATTERN = Pattern.compile("!/", 16);
/*     */   
/*     */   private static final String CURRENT_DIR = "/./";
/*     */   
/*  56 */   private static final Pattern CURRENT_DIR_PATTERN = Pattern.compile("/./", 16);
/*     */   
/*     */   private static final String PARENT_DIR = "/../";
/*     */   
/*     */   private static final String PROTOCOL_HANDLER = "java.protocol.handler.pkgs";
/*     */   
/*  62 */   private static final String[] FALLBACK_HANDLERS = new String[] { "sun.net.www.protocol.jar.Handler" };
/*     */ 
/*     */ 
/*     */   
/*     */   private static URL jarContextUrl;
/*     */ 
/*     */   
/*  69 */   private static SoftReference<Map<File, JarFile>> rootFileCache = new SoftReference<>(null);
/*     */   
/*     */   private final JarFile jarFile;
/*     */   
/*     */   private URLStreamHandler fallbackHandler;
/*     */ 
/*     */   
/*     */   public Handler() {
/*  77 */     this(null);
/*     */   }
/*     */   
/*     */   public Handler(JarFile jarFile) {
/*  81 */     this.jarFile = jarFile;
/*     */   }
/*     */ 
/*     */   
/*     */   protected URLConnection openConnection(URL url) throws IOException {
/*  86 */     if (this.jarFile != null && isUrlInJarFile(url, this.jarFile)) {
/*  87 */       return JarURLConnection.get(url, this.jarFile);
/*     */     }
/*     */     try {
/*  90 */       return JarURLConnection.get(url, getRootJarFileFromUrl(url));
/*     */     }
/*  92 */     catch (Exception ex) {
/*  93 */       return openFallbackConnection(url, ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isUrlInJarFile(URL url, JarFile jarFile) throws MalformedURLException {
/*  99 */     return (url.getPath().startsWith(jarFile.getUrl().getPath()) && url
/* 100 */       .toString().startsWith(jarFile.getUrlString()));
/*     */   }
/*     */   
/*     */   private URLConnection openFallbackConnection(URL url, Exception reason) throws IOException {
/*     */     try {
/* 105 */       URLConnection connection = openFallbackContextConnection(url);
/* 106 */       return (connection != null) ? connection : openFallbackHandlerConnection(url);
/*     */     }
/* 108 */     catch (Exception ex) {
/* 109 */       if (reason instanceof IOException) {
/* 110 */         log(false, "Unable to open fallback handler", ex);
/* 111 */         throw (IOException)reason;
/*     */       } 
/* 113 */       log(true, "Unable to open fallback handler", ex);
/* 114 */       if (reason instanceof RuntimeException) {
/* 115 */         throw (RuntimeException)reason;
/*     */       }
/* 117 */       throw new IllegalStateException(reason);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private URLConnection openFallbackContextConnection(URL url) {
/*     */     try {
/* 131 */       if (jarContextUrl != null) {
/* 132 */         return (new URL(jarContextUrl, url.toExternalForm())).openConnection();
/*     */       }
/*     */     }
/* 135 */     catch (Exception exception) {}
/*     */     
/* 137 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private URLConnection openFallbackHandlerConnection(URL url) throws Exception {
/* 148 */     URLStreamHandler fallbackHandler = getFallbackHandler();
/* 149 */     return (new URL(null, url.toExternalForm(), fallbackHandler)).openConnection();
/*     */   }
/*     */   
/*     */   private URLStreamHandler getFallbackHandler() {
/* 153 */     if (this.fallbackHandler != null) {
/* 154 */       return this.fallbackHandler;
/*     */     }
/* 156 */     for (String handlerClassName : FALLBACK_HANDLERS) {
/*     */       try {
/* 158 */         Class<?> handlerClass = Class.forName(handlerClassName);
/* 159 */         this.fallbackHandler = handlerClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
/* 160 */         return this.fallbackHandler;
/*     */       }
/* 162 */       catch (Exception exception) {}
/*     */     } 
/*     */ 
/*     */     
/* 166 */     throw new IllegalStateException("Unable to find fallback handler");
/*     */   }
/*     */   
/*     */   private void log(boolean warning, String message, Exception cause) {
/*     */     try {
/* 171 */       Level level = warning ? Level.WARNING : Level.FINEST;
/* 172 */       Logger.getLogger(getClass().getName()).log(level, message, cause);
/*     */     }
/* 174 */     catch (Exception ex) {
/* 175 */       if (warning) {
/* 176 */         System.err.println("WARNING: " + message);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void parseURL(URL context, String spec, int start, int limit) {
/* 183 */     if (spec.regionMatches(true, 0, "jar:", 0, "jar:".length())) {
/* 184 */       setFile(context, getFileFromSpec(spec.substring(start, limit)));
/*     */     } else {
/*     */       
/* 187 */       setFile(context, getFileFromContext(context, spec.substring(start, limit)));
/*     */     } 
/*     */   }
/*     */   
/*     */   private String getFileFromSpec(String spec) {
/* 192 */     int separatorIndex = spec.lastIndexOf("!/");
/* 193 */     if (separatorIndex == -1) {
/* 194 */       throw new IllegalArgumentException("No !/ in spec '" + spec + "'");
/*     */     }
/*     */     try {
/* 197 */       new URL(spec.substring(0, separatorIndex));
/* 198 */       return spec;
/*     */     }
/* 200 */     catch (MalformedURLException ex) {
/* 201 */       throw new IllegalArgumentException("Invalid spec URL '" + spec + "'", ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String getFileFromContext(URL context, String spec) {
/* 206 */     String file = context.getFile();
/* 207 */     if (spec.startsWith("/")) {
/* 208 */       return trimToJarRoot(file) + "!/" + spec.substring(1);
/*     */     }
/* 210 */     if (file.endsWith("/")) {
/* 211 */       return file + spec;
/*     */     }
/* 213 */     int lastSlashIndex = file.lastIndexOf('/');
/* 214 */     if (lastSlashIndex == -1) {
/* 215 */       throw new IllegalArgumentException("No / found in context URL's file '" + file + "'");
/*     */     }
/* 217 */     return file.substring(0, lastSlashIndex + 1) + spec;
/*     */   }
/*     */   
/*     */   private String trimToJarRoot(String file) {
/* 221 */     int lastSeparatorIndex = file.lastIndexOf("!/");
/* 222 */     if (lastSeparatorIndex == -1) {
/* 223 */       throw new IllegalArgumentException("No !/ found in context URL's file '" + file + "'");
/*     */     }
/* 225 */     return file.substring(0, lastSeparatorIndex);
/*     */   }
/*     */   
/*     */   private void setFile(URL context, String file) {
/* 229 */     String path = normalize(file);
/* 230 */     String query = null;
/* 231 */     int queryIndex = path.lastIndexOf('?');
/* 232 */     if (queryIndex != -1) {
/* 233 */       query = path.substring(queryIndex + 1);
/* 234 */       path = path.substring(0, queryIndex);
/*     */     } 
/* 236 */     setURL(context, "jar:", null, -1, null, null, path, query, context.getRef());
/*     */   }
/*     */   
/*     */   private String normalize(String file) {
/* 240 */     if (!file.contains("/./") && !file.contains("/../")) {
/* 241 */       return file;
/*     */     }
/* 243 */     int afterLastSeparatorIndex = file.lastIndexOf("!/") + "!/".length();
/* 244 */     String afterSeparator = file.substring(afterLastSeparatorIndex);
/* 245 */     afterSeparator = replaceParentDir(afterSeparator);
/* 246 */     afterSeparator = replaceCurrentDir(afterSeparator);
/* 247 */     return file.substring(0, afterLastSeparatorIndex) + afterSeparator;
/*     */   }
/*     */   
/*     */   private String replaceParentDir(String file) {
/*     */     int parentDirIndex;
/* 252 */     while ((parentDirIndex = file.indexOf("/../")) >= 0) {
/* 253 */       int precedingSlashIndex = file.lastIndexOf('/', parentDirIndex - 1);
/* 254 */       if (precedingSlashIndex >= 0) {
/* 255 */         file = file.substring(0, precedingSlashIndex) + file.substring(parentDirIndex + 3);
/*     */         continue;
/*     */       } 
/* 258 */       file = file.substring(parentDirIndex + 4);
/*     */     } 
/*     */     
/* 261 */     return file;
/*     */   }
/*     */   
/*     */   private String replaceCurrentDir(String file) {
/* 265 */     return CURRENT_DIR_PATTERN.matcher(file).replaceAll("/");
/*     */   }
/*     */ 
/*     */   
/*     */   protected int hashCode(URL u) {
/* 270 */     return hashCode(u.getProtocol(), u.getFile());
/*     */   }
/*     */   
/*     */   private int hashCode(String protocol, String file) {
/* 274 */     int result = (protocol != null) ? protocol.hashCode() : 0;
/* 275 */     int separatorIndex = file.indexOf("!/");
/* 276 */     if (separatorIndex == -1) {
/* 277 */       return result + file.hashCode();
/*     */     }
/* 279 */     String source = file.substring(0, separatorIndex);
/* 280 */     String entry = canonicalize(file.substring(separatorIndex + 2));
/*     */     try {
/* 282 */       result += (new URL(source)).hashCode();
/*     */     }
/* 284 */     catch (MalformedURLException ex) {
/* 285 */       result += source.hashCode();
/*     */     } 
/* 287 */     result += entry.hashCode();
/* 288 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean sameFile(URL u1, URL u2) {
/* 293 */     if (!u1.getProtocol().equals("jar") || !u2.getProtocol().equals("jar")) {
/* 294 */       return false;
/*     */     }
/* 296 */     int separator1 = u1.getFile().indexOf("!/");
/* 297 */     int separator2 = u2.getFile().indexOf("!/");
/* 298 */     if (separator1 == -1 || separator2 == -1) {
/* 299 */       return super.sameFile(u1, u2);
/*     */     }
/* 301 */     String nested1 = u1.getFile().substring(separator1 + "!/".length());
/* 302 */     String nested2 = u2.getFile().substring(separator2 + "!/".length());
/* 303 */     if (!nested1.equals(nested2)) {
/* 304 */       String canonical1 = canonicalize(nested1);
/* 305 */       String canonical2 = canonicalize(nested2);
/* 306 */       if (!canonical1.equals(canonical2)) {
/* 307 */         return false;
/*     */       }
/*     */     } 
/* 310 */     String root1 = u1.getFile().substring(0, separator1);
/* 311 */     String root2 = u2.getFile().substring(0, separator2);
/*     */     try {
/* 313 */       return super.sameFile(new URL(root1), new URL(root2));
/*     */     }
/* 315 */     catch (MalformedURLException malformedURLException) {
/*     */ 
/*     */       
/* 318 */       return super.sameFile(u1, u2);
/*     */     } 
/*     */   }
/*     */   private String canonicalize(String path) {
/* 322 */     return SEPARATOR_PATTERN.matcher(path).replaceAll("/");
/*     */   }
/*     */   
/*     */   public JarFile getRootJarFileFromUrl(URL url) throws IOException {
/* 326 */     String spec = url.getFile();
/* 327 */     int separatorIndex = spec.indexOf("!/");
/* 328 */     if (separatorIndex == -1) {
/* 329 */       throw new MalformedURLException("Jar URL does not contain !/ separator");
/*     */     }
/* 331 */     String name = spec.substring(0, separatorIndex);
/* 332 */     return getRootJarFile(name);
/*     */   }
/*     */   
/*     */   private JarFile getRootJarFile(String name) throws IOException {
/*     */     try {
/* 337 */       if (!name.startsWith("file:")) {
/* 338 */         throw new IllegalStateException("Not a file URL");
/*     */       }
/* 340 */       File file = new File(URI.create(name));
/* 341 */       Map<File, JarFile> cache = rootFileCache.get();
/* 342 */       JarFile result = (cache != null) ? cache.get(file) : null;
/* 343 */       if (result == null) {
/* 344 */         result = new JarFile(file);
/* 345 */         addToRootFileCache(file, result);
/*     */       } 
/* 347 */       return result;
/*     */     }
/* 349 */     catch (Exception ex) {
/* 350 */       throw new IOException("Unable to open root Jar file '" + name + "'", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void addToRootFileCache(File sourceFile, JarFile jarFile) {
/* 360 */     Map<File, JarFile> cache = rootFileCache.get();
/* 361 */     if (cache == null) {
/* 362 */       cache = new ConcurrentHashMap<>();
/* 363 */       rootFileCache = new SoftReference<>(cache);
/*     */     } 
/* 365 */     cache.put(sourceFile, jarFile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void captureJarContextUrl() {
/* 374 */     if (canResetCachedUrlHandlers()) {
/* 375 */       String handlers = System.getProperty("java.protocol.handler.pkgs", "");
/*     */       try {
/* 377 */         System.clearProperty("java.protocol.handler.pkgs");
/*     */         try {
/* 379 */           resetCachedUrlHandlers();
/* 380 */           jarContextUrl = new URL("jar:file:context.jar!/");
/* 381 */           URLConnection connection = jarContextUrl.openConnection();
/* 382 */           if (connection instanceof JarURLConnection) {
/* 383 */             jarContextUrl = null;
/*     */           }
/*     */         }
/* 386 */         catch (Exception exception) {}
/*     */       }
/*     */       finally {
/*     */         
/* 390 */         if (handlers == null) {
/* 391 */           System.clearProperty("java.protocol.handler.pkgs");
/*     */         } else {
/*     */           
/* 394 */           System.setProperty("java.protocol.handler.pkgs", handlers);
/*     */         } 
/*     */       } 
/* 397 */       resetCachedUrlHandlers();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean canResetCachedUrlHandlers() {
/*     */     try {
/* 403 */       resetCachedUrlHandlers();
/* 404 */       return true;
/*     */     }
/* 406 */     catch (Error ex) {
/* 407 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void resetCachedUrlHandlers() {
/* 412 */     URL.setURLStreamHandlerFactory(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setUseFastConnectionExceptions(boolean useFastConnectionExceptions) {
/* 422 */     JarURLConnection.setUseFastExceptions(useFastConnectionExceptions);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\org\springframework\boot\loader\jar\Handler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */