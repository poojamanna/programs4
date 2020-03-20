package net;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	//without stream
 public void withoutStream(List<Product> productList)
 {
	 List<Float> productPriceList = new ArrayList<Float>();
	 List<String> productName = new ArrayList<String>();
	 for(Product product : productList)
	 {
		 if(product.price<30000)
		 {
			 productName.add(product.name);
			 productPriceList.add(product.price);
		 }
	 }
	 System.out.println(productName);
	 System.out.println(productPriceList);
 }
 //with stream
 public void withStream(List<Product> productList)
 {
	 List<Float> productPriceList2 = productList.stream().filter(p->p.price>30000)
			 .map(p->p.price).collect(Collectors.toList());
	 System.out.println(productPriceList2);
	 
 }
 public void streamIterating(List<Product> productList)
 {
	 Stream
	 .iterate(1,element -> element +1)
	 .filter(element-> element%5==0).limit(5)
	 .forEach(System.out::println);
 }
 public void streamFilteringIterating(List<Product> productList)
 {
	 productList.stream()
	 .filter(product->product.price==30000)
	 .forEach(product->System.out.println(product.name));
 }
 public void maxAndMin(List<Product> productList)
 {
	 Product productA = productList.stream()
			 .max((product1,product2)-> product1.price > product2.price?1:-1)
			 .get();
	 System.out.println(productA.price);
	 Product productB = productList.stream()
			 .min((product1,product2)->product1.price < product2.price?1:-1)
			 .get();
	 System.out.println(productB.price);
 }
 public void countIteams(List<Product> productList)
 {
	 long count = productList.stream()
			 .filter(product->product.price<30000)
			 .count();
	 System.out.println(count);
 }
 public void toSet(List<Product> productList)
 {
	 Set<Float> productPriceList = productList.stream()
			 .filter(product->product.price<30000)
			 .map(product->product.price)
			 .collect(Collectors.toSet());
	 System.out.println(productPriceList);
 }
 public void toMap(List<Product> productList)
 {
	 Map<Integer,String> productPriceMap = productList.stream()
			 .collect(Collectors.toMap(p->p.id, p->p.name));
	 System.out.println(productPriceMap);
 }
 public void methodRef(List<Product> productList)
 {
	 List<Float> productPriceList =
			 productList.stream()
			 .filter(p->p.price>30000)
			 .map(Product::getPrice)
			 .collect(Collectors.toList());
	 System.out.println(productPriceList);
 }
 
 public static void main(String[] args) {
	 List<Product> productList = new ArrayList<Product>();
	 productList.add(new Product(1,"hp laptop",25000f));
	 productList.add(new Product(2,"dell laptop",28000f));
	 productList.add(new Product(3,"lenovo laptop",30000f));
	 productList.add(new Product(4,"sony laptop",28000f));
	 productList.add(new Product(5,"apple laptop",90000f));
	 StreamTest st = new StreamTest();
	 st.withoutStream(productList);
	 st.withStream(productList);
	 st.streamIterating(productList);
	 st.streamFilteringIterating(productList);
	 st.countIteams(productList);
	 st.maxAndMin(productList);
	 st.toSet(productList);
	 st.toMap(productList);
	 st.methodRef(productList);	
}
}

