package lamda_functional_interface;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIO2Exercise {
	
	static Tablet getTabletDetail(String fileData) {
		
		String[] rows=fileData.split(" ");
		Tablet tablet=new Tablet(rows[0], rows[1], rows[2], rows[3]);
		
		return tablet;
	}
	
	static Map<String,String> getExpiredTablets(String filename, String manufacturer) {
		
		try(Stream<String> fileData= Files.lines(Paths.get("src/main/resources","tablet.csv"))) {
			
			Map<String, String> expireData=fileData.map(NIO2Exercise::getTabletDetail)
					.filter(p->p.getManufacturer().equals(manufacturer))
					.collect(Collectors.toMap(Tablet::getTablet_name, Tablet::getExpiry_date));
			
			/*List<Tablet> tabletDetail=fileData.map(NIO2Exercise::getTabletDetail)
					.collect(Collectors.toCollection(ArrayList::new));
			System.out.println(tabletDetail);
			Map<String,String> expireData=tabletDetail.stream()
					.filter(p->p.getManufacturer().equals(manufacturer))
					.collect(Collectors.toMap(Tablet::getTablet_name, Tablet::getExpiry_date));
			System.out.println(expireData);*/
			
			return expireData;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static void main(String[] args) {
		
		Map<String, String> expireDate=getExpiredTablets("tablet.csv", "bengaluru");
		System.out.println("**********getExpiredTablets********************");
		System.out.println(expireDate);
		
		
		System.out.println("****************.java files in src folder*******************");
		try(Stream<Path> path=Files.walk(Paths.get("src"))){
			path.filter(f->Files.isRegularFile(f))
			.filter(f->f.toString().endsWith(".java"))
			.forEach(System.out::println);
			
		} catch (IOException e) {
			System.out.println("folder not present");
			e.printStackTrace();
		}
		
		System.out.println("**************search file*********************");
		/*
		try(Stream<Path> path=Files.find("src", 0, "tablet.csv")){
			
		}*/
	}

}
