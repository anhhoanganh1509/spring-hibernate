package stackjava.com.springmvchibernate.model;
 
import javax.servlet.http.HttpServletRequest;
 
 
public class Utils {
  
   // Thông tin các mặt hàng đã mua, được lưu trữ trong Session.
   public static Cart getCartInSession(HttpServletRequest request) {
 
  
       // Thông tin giỏ hàng có thể đã lưu vào trong Session trước đó.
       Cart cartInfo = (Cart) request.getSession().getAttribute("myCart");
      
  
       // Nếu chưa tạo giỏ hàng, tạo nó.
       if (cartInfo == null) {
           cartInfo = new Cart();
          
  
           // Và lưu vào trong session.
           request.getSession().setAttribute("myCart", cartInfo);
       }
 
       return cartInfo;
   }
 
   public static void removeCartInSession(HttpServletRequest request) {
       request.getSession().removeAttribute("myCart");
   }
 
   public static void storeLastOrderedCartInSession(HttpServletRequest request, Cart cartInfo) {
       request.getSession().setAttribute("lastOrderedCart", cartInfo);
   }
  
   public static Cart getLastOrderedCartInSession(HttpServletRequest request) {
       return (Cart) request.getSession().getAttribute("lastOrderedCart");
   }
 
}