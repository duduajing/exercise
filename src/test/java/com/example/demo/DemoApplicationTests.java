package com.example.demo;

import com.example.demo.SingletonStudy.SerSingleton;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void test() throws Exception{
		SerSingleton s1 = null;
		SerSingleton s = SerSingleton.getInstance();
		//先将实例串行化到文件
		FileOutputStream fos = new FileOutputStream("SerSingleton.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.flush();
		oos.close();
		//从文件读入原有的单例类
		FileInputStream fis = new FileInputStream("SerSingleton.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		s1 = (SerSingleton) ois.readObject();
		Assert.assertEquals(s, s1);

	}
}
