package javaTest;

class Money {

         private String country = "Canada";

         public String getC() { return country; }

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}
         
         

 }

 class Yen extends Money {

         public String getC() { return getCountry(); }
 }

 public class Euro extends Money {

     public String getC(int x) { return super.getC(); }

     public static void main(String[] args) {

         System.out.print(new Yen().getC() 

                        + " " + new Euro().getC());

     }

 }
 
// class Money에서 선언한 멤버변수의 수식어가 private이기 때문에 값을 상속받을수 없다.
//
// 값을 가지고 오고 싶다면 getter를 만들어 가져올수 있다.

