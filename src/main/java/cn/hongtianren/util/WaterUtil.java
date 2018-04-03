package cn.hongtianren.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class WaterUtil {
	
	public static Set<String> orderWater = new HashSet<>();
	
	public static Set<String> paymentWater = new HashSet<>();
	
	public static synchronized String getOrderWater(){
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			builder.append(random.nextInt(10));
		}
		if(orderWater.add(builder.toString())){
			return builder.toString();
		}else{
			return getOrderWater();
		}
	}
	
	public static synchronized String getPaymentWater(){
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			builder.append(random.nextInt(10));
		}
		if(paymentWater.add(builder.toString())){
			return builder.toString();
		}else{
			return getPaymentWater();
		}
	}
}
