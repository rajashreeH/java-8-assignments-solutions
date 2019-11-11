package lamda_functional_interface;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIO2Exercise {
	
	private static final int String = 0;
	static DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	static Tablet getTabletDetail(String fileData) {
		
		String[] rows=fileData.split(" ");
		
		
		LocalDate data=LocalDate.parse(rows[3], format);
		Tablet tablet=new Tablet(rows[0], rows[1], rows[2], data);
		
		return tablet;
	}
	
	static Map<String,LocalDate> getExpiredTablets(String filename, String manufacturer) {
		
		try(Stream<String> fileData= Files.lines(Paths.get("src/main/resources","tablet.csv"))) {
			
			LocalDate today=LocalDate.now();

			Map<String, LocalDate> expireData=fileData.map(NIO2Exercise::getTabletDetail)
					.filter(p->p.getManufacturer().equals(manufacturer))
					.filter(p-> p.expiry_date.isAfter(today))
					.collect(Collectors.toMap(Tablet::getTablet_name, Tablet::getExpiry_date));
			
		
			
			return expireData;
			
					//return null;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	static void findjavaFiles(String directoryPath) {
		System.out.println("****************.java files in src folder*******************");
		try(Stream<Path> path=Files.walk(Paths.get(directoryPath))){
			path.filter(p->p.toString().endsWith(".java"))
			.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println("folder not present");
			e.printStackTrace();
		}
	}
	
	static void findFile(String fileName,String abspath) {
		try(Stream<Path> path=Files.walk(Paths.get(abspath))){
			path.filter(p->p.getFileName().toString().equals(fileName))
			.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		Map<String, LocalDate> expireDate=getExpiredTablets("tablet.csv", "bengaluru");
		System.out.println("**********getExpiredTablets********************");
		System.out.println(expireDate);
		
		findjavaFiles("src");
		
		
		
		
		System.out.println("**************search file*********************");
		findFile("tablet.csv", "src/main/resources");
		
	}

}
