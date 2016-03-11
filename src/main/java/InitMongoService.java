import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.bay.bo.ZipCodeBO;
import com.bay.db.template.ZipJDBCTemplate;
import com.bay.domain.Zip;


public class InitMongoService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ZipCodeBO zipCodeBO = (ZipCodeBO) ctx.getBean("zipCodeBO");
		
		zipCodeBO.getAllZipCodes(37.3382, 121.8863, 10.0,"94085");
		
		//http://localhost:8080/house-0.0.1-SNAPSHOT/zipcodes?lat=37.3382&lon=121.8863&radius=10.0
		//http://localhost:8080/house-0.0.1-SNAPSHOT/rest/zip-service/api/v1/zipcodes?lat=37.3382&lon=121.8863&radius=10.0
		//http://localhost:8080/house-0.0.1-SNAPSHOT/nbiDocs/index.html
		//http://localhost:8080/house-0.0.1-SNAPSHOT/rest/sw/api-docs
		//http://localhost:8080/house-0.0.1-SNAPSHOT/rest/sw/api-docs//zip-service/api
		
		
		ZipJDBCTemplate zipJDBCTemplate = 
			      (ZipJDBCTemplate)ctx.getBean("zipJDBCTemplate");
		
        List<Zip> zips = zipJDBCTemplate.findZips("94085", 3.0);
		
		zipCodeBO.getAllZipCodes(37.3382, 121.8863, 1.0,"94085");
		
		
		System.out.print(zips.size());
	}
	

}
